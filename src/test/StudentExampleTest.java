package test;

import java.io.IOException;
import java.io.Reader;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.ejb.FinderException;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.spi.LoggerFactory;
import org.junit.Test;
import org.slf4j.Logger;

import com.cpp.core.common.entity.Student;
import com.cpp.core.common.entity.StudentExample;
import com.cpp.core.common.entity.StudentExample.Criteria;
import com.cpp.core.common.entity.Teacher;
import com.cpp.core.common.entity.TeacherExample;
import com.cpp.core.scfRecharge.mybatis.dao.StudentMapper;
import com.cpp.core.scfRecharge.mybatis.dao.TeacherMapper;
import com.thero.framework.common.CommonExample;
import com.thero.framework.common.CommonMapper;

public class StudentExampleTest {
	
	/**
	 * 测试Example的用法，以及以及缓存
	 */
	@Test
	public void test1() {
		try {
			Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder()
					.build(reader);
			reader.close();
			SqlSession session = null;
			session = sqlSessionFactory.openSession();
			
			//使用查询公共对象
			StudentExample studentExample = new StudentExample();
			Criteria criteria = studentExample.createCriteria();
			StudentMapper studentMapper = (StudentMapper) session.getMapper(StudentMapper.class);
			//发起第一次查询
			Date first = new Date();  
			criteria.andNameEqualTo("陈明");
			studentMapper.selectByExample(studentExample);
			System.out.println("first quest costs:"+ (new Date().getTime()-first.getTime()) +" ms");  
			
			 //第二次查询；
			 criteria.andNameEqualTo("陈明");
			 Date second = new Date();
			 studentMapper.selectByExample(studentExample);
			 System.out.println(("second quest costs:"+ (new Date().getTime()-second.getTime()) +" ms"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 测试StudentExample中Criteria用法
	 */
	@Test
	public void TestExample(){
		try {
			Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder()
					.build(reader);
			reader.close();
			SqlSession session = null;
			session = sqlSessionFactory.openSession();
			StudentMapper studentMapper = (StudentMapper) session.getMapper(StudentMapper.class);
			StudentExample studentExample = new StudentExample();
			Criteria criteria = studentExample.createCriteria();
			criteria.andGradeNotLike("2011");
			List<Student> student = studentMapper.selectByExample(studentExample);
			for (Student student2 : student) {
				System.out.println(student2.getName());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	@Test
	public void testCondition(){
		try {
			//如果想在控制台中输出日志的内容，那么必须添加上这句话
			org.apache.ibatis.logging.LogFactory.useStdOutLogging();
			Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder()
					.build(reader);
			reader.close();
			SqlSession session = null;
			session = sqlSessionFactory.openSession();
			StudentMapper studentMapper = (StudentMapper) session.getMapper(StudentMapper.class);
			StudentExample studentExample = new StudentExample();
			Criteria criteria = studentExample.createCriteria();
			//拼接name
			criteria.andNameEqualTo("李林");
			Criteria criteria2 = studentExample.createCriteria();
			//拼接name
			criteria2.andNameEqualTo("陈明");
			//拼接or的查询
			studentExample.or(criteria2);
			//添加排序字段
			studentExample.setOrderByClause("name,gender");
			studentExample.setDistinct(true);
			List<Student> student = studentMapper.selectByExample(studentExample);
			for (Student student2 : student) {
				System.out.println(student2.getName());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/**
	 * 测试二级缓存以及关联查询内容
	 * @throws IOException 
	 */
	@Test
	public void TestSecondCache() throws IOException{
		org.apache.ibatis.logging.LogFactory.useStdOutLogging();
		Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder()
				.build(reader);
		reader.close();
		SqlSession session = null;
		session = sqlSessionFactory.openSession();
		StudentMapper studentMapper = (StudentMapper) session.getMapper(StudentMapper.class);
		Map<String, Object> params = new HashMap<String,Object>();
		/**
		 * 模拟下面的情况
		 * 1. 执行StudentMapper中的"queryStudentAndTeacher" 操作，此时会将查询到的结果放置到StudentMapper对应的二级缓存StudentCache中；
		 * 2. 执行teacherMapper中对teacher的更新操作(update、delete、insert)后，teacher的数据更新；
		 * 3. 再执行1完全相同的查询，这时候会直接从StudentMapper二级缓存StudentCache中取值，将StudentMapper中的值直接返回；
		 * */
		List<Student> students = studentMapper.queryStudentAndTeacher(params);
		for (Student student : students) {
			System.out.println(student.getId() + student.getTeacher().getName());
		}
		System.out.println(students.size());
		
		//更新老师
		SqlSession session2 = sqlSessionFactory.openSession();
		TeacherMapper teacherMapper = session2.getMapper(TeacherMapper.class);
		Teacher teacher = new Teacher();
		teacher.setName("刘老师");
		teacher.setId(1);
		TeacherExample teacherExample = new TeacherExample();
		teacherExample.createCriteria().andIdEqualTo(1);
		teacherMapper.updateByExample(teacher, teacherExample);
		session2.commit();
		
		//第二次查询，查看是否从缓存中读取
		List<Student> students2 = studentMapper.queryStudentAndTeacher(params);
		for (Student student : students2) {
			System.out.println(student.getId() + student.getTeacher().getName());
		}
		System.out.println(students2.size());
		checkCacheStatus(session);  
	}
	
	public static void checkCacheStatus(SqlSession sqlSession)	{
		System.out.println("------------Cache Status------------");
		Iterator<String> iter = sqlSession.getConfiguration().getCacheNames().iterator();
		while(iter.hasNext()){
			String it = iter.next();
			System.out.println(it+":"+sqlSession.getConfiguration().getCache(it).getSize());
		}
		System.out.println("------------------------------------");
	}
}





