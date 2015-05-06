package com.thero.mapper.common.test;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.cpp.core.common.entity.Student;
import com.thero.mapper.common.CommonExample;
import com.thero.mapper.common.Criteria;

public class TestCommonMapper {
	@Test
	public void testCommonMapper(){
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
			CommonExample commonExample = new CommonExample();
			Criteria criteria = commonExample.createCriteria();
			/*//拼接name
			criteria.andEqualTo("name", "李林","name");
			Criteria criteria2 = commonExample.createCriteria();
			//拼接name
			criteria2.andEqualTo("name","陈明","name");
			//拼接or的查询
			commonExample.or(criteria2);
			//添加排序字段
			commonExample.setOrderByClause("name,gender");
			commonExample.setDistinct(true);*/
			//criteria.andGreaterThan("id", 3, "id");
			//criteria.andLessThanOrEqualTo("id", 2, "id");
			criteria.andIsNotNull("supervisor_id");
			List<Student> student = studentMapper.selectByExample(commonExample);
			for (Student student2 : student) {
				System.out.println(student2.getName());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
