package com.hq.crud.test;

import java.util.UUID;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.hq.crud.bean.Department;
import com.hq.crud.bean.Employee;
import com.hq.crud.dao.DepartmentMapper;
import com.hq.crud.dao.EmployeeMapper;
/**
 * 测试dao层工作
 * @author Hammer and Sickle
 *推荐：spring的项目可以使用spring的单元测试，可以自动注入我们的组件
 *推荐方式
 *1，导入spring testjar包，在pom.xml中导入
 *2.@ContextConfiguration指定spring配置文件的位置
 *3.@RunWith指定用哪个junit进行测试
 *4.直接@Autowired要使用的组件即可,如下
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class MapperTest 
{
	@Autowired
	DepartmentMapper departmentMapper;
	@Autowired
	EmployeeMapper employeeMapper;
	@Autowired
	SqlSession sqlSession;
	@Test
	public void testCrud() 
	{
		/*原生方式，建议使用上面推荐方式
		 * //创建springIoc容器 ApplicationContext ioc=new
		 * ClassPathXmlApplicationContext("applicationContext.xml"); //从容器中获取mapper
		 * DepartmentMapper bean = ioc.getBean(DepartmentMapper.class);
		 */
		//插入部门
//		departmentMapper.insertSelective(new Department(null,"开发部"));
//		departmentMapper.insertSelective(new Department(null,"测试部"));
//		System.out.println("插入成功");
		
		//插入员工
		//employeeMapper.insertSelective(new Employee(null,"jerry","M","jerry@qq.com",1));
		//批量插入
		EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
		for (int i = 0; i < 50; i++) 
		{
			String uid=UUID.randomUUID().toString().substring(0,5)+i;
			mapper.insertSelective(new Employee(null,uid,"M",uid+"@qq.com",1));
		}
		
	}
}
