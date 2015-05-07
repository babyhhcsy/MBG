package test;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.cpp.core.common.entity.Student;
import com.cpp.core.common.entity.StudentExample;
import com.cpp.core.common.entity.StudentExample.Criteria;
import com.cpp.core.scfRecharge.mybatis.dao.StudentMapper;

public class StudentExampleTest {
	@Test
	public void test1() {
		try {
			Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder()
					.build(reader);
			reader.close();
			SqlSession session = null;
			session = sqlSessionFactory.openSession();
			StudentMapper studentMapper = (StudentMapper) session.getMapper(StudentMapper.class);
			Student student = studentMapper.selectByPrimaryKey(1);
			System.out.println(student.getGender());
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
}





