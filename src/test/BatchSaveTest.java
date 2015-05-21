package test;

import static org.junit.Assert.*;

import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.cpp.core.common.entity.Student;
import com.cpp.core.scfRecharge.mybatis.dao.StudentMapper;

public class BatchSaveTest {

	@Test
	public void BatchSave() throws IOException{
		org.apache.ibatis.logging.LogFactory.useStdOutLogging();
		Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder()
				.build(reader);
		reader.close();
		SqlSession session = null;
		//1、打开批处理
		session = sqlSessionFactory.openSession(ExecutorType.BATCH, true);
		StudentMapper studentMapper = (StudentMapper) session.getMapper(StudentMapper.class);
		Map<String, Object> params = new HashMap<String,Object>();
		List<Student> students = studentMapper.queryStudentAndTeacher(params);
		
		//2、初始化数据
		List<Student> preSaveStudent = initStudent();
		Date first = new Date();  
		
		//3、执行批量插入
		for (int i = 0; i < preSaveStudent.size(); i++) {
			studentMapper.insert(preSaveStudent.get(i));
		}
		//4、事务提交
		session.commit();
		System.out.println("first quest costs:"+ (new Date().getTime()-first.getTime()) +" ms");  
	}
	@Test
	public void batchSave2() throws IOException{
		org.apache.ibatis.logging.LogFactory.useStdOutLogging();
		Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder()
				.build(reader);
		reader.close();
		SqlSession session = null;
		//1、打开批处理
		session = sqlSessionFactory.openSession(ExecutorType.BATCH, true);
		StudentMapper studentMapper = (StudentMapper) session.getMapper(StudentMapper.class);
		Map<String, Object> params = new HashMap<String,Object>();
	//	List<Student> students = studentMapper.queryStudentAndTeacher(params);
		
		//2、初始化数据
		List<Student> preSaveStudent = initStudent();
		Date first = new Date();  
		
		//3、执行批量插入
		studentMapper.batchInsert(preSaveStudent);
		//4、事务提交
		session.commit();
		System.out.println("耗费时间:"+ (new Date().getTime()-first.getTime()) +" ms");  
	}
	/**
	 * 打印学生信息
	 * @author thero
	 * @param students
	 */
	public void printStudent(List<Student> students){
		for (Student student : students) {
			System.out.println(student.getId() + student.getTeacher().getName());
		}
	}
	
	/**
	 * 初始化参数；用于测试保存内容；
	 * @author thero
	 * @return List<Student>
	 * 	student集合内容
	 */
	public List<Student> initStudent(){
		List<Student> students = new ArrayList<Student>();
		for(int i = 0 ;i < 2;i++){
			Student student = new Student();
			student.setId(i);
			student.setGender("男"+i+"-"+i);
			student.setGrade("100"+i+i+"-"+i);
			student.setMajor("软件技术"+i+i+"-"+i);
			student.setName(null);
			student.setSupervisorId(2);
			students.add(student);
		}
		return students;
	}
}







