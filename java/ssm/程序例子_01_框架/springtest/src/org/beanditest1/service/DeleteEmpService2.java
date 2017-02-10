package org.beanditest1.service;

import org.beanditest1.dao.EmpDAO2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class DeleteEmpService2 {

	private EmpDAO2 dao;

	@Autowired
	public DeleteEmpService2(@Qualifier("mybatisEmpDAO")EmpDAO2 dao) {
		this.dao = dao;
	}

	public void deleteEmp(){
		System.out.println("添加员工操作处理");
		dao.delete();
	}
}
