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
 * ����dao�㹤��
 * @author Hammer and Sickle
 *�Ƽ���spring����Ŀ����ʹ��spring�ĵ�Ԫ���ԣ������Զ�ע�����ǵ����
 *�Ƽ���ʽ
 *1������spring testjar������pom.xml�е���
 *2.@ContextConfigurationָ��spring�����ļ���λ��
 *3.@RunWithָ�����ĸ�junit���в���
 *4.ֱ��@AutowiredҪʹ�õ��������,����
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
		/*ԭ����ʽ������ʹ�������Ƽ���ʽ
		 * //����springIoc���� ApplicationContext ioc=new
		 * ClassPathXmlApplicationContext("applicationContext.xml"); //�������л�ȡmapper
		 * DepartmentMapper bean = ioc.getBean(DepartmentMapper.class);
		 */
		//���벿��
//		departmentMapper.insertSelective(new Department(null,"������"));
//		departmentMapper.insertSelective(new Department(null,"���Բ�"));
//		System.out.println("����ɹ�");
		
		//����Ա��
		//employeeMapper.insertSelective(new Employee(null,"jerry","M","jerry@qq.com",1));
		//��������
		EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
		for (int i = 0; i < 50; i++) 
		{
			String uid=UUID.randomUUID().toString().substring(0,5)+i;
			mapper.insertSelective(new Employee(null,uid,"M",uid+"@qq.com",1));
		}
		
	}
}
