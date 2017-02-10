package org.beanditest1.service;

import org.beanditest1.dao.EmpDAO2;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class AddEmpService2 {

	private EmpDAO2 dao;

	@Resource(name="mybatisEmpDAO")
	public void setDao(EmpDAO2 dao) {
		this.dao = dao;
	}

	public void addEmp(){
		System.out.println("添加员工操作处理");
		dao.add();
	}
}
