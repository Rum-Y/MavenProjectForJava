package com.hq.crud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hq.crud.bean.Department;
import com.hq.crud.dao.DepartmentMapper;
@Service
public class DepartmentService 
{
	@Autowired
	DepartmentMapper departmentMapper;
	
	public List<Department> getDepts() 
	{
		List<Department> list = departmentMapper.selectByExample(null);
		return list;
	}

}
