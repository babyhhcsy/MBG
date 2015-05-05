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
				System.out.println(student2.getGender());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}





