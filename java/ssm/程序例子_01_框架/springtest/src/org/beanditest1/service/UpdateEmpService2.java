package org.beanditest1.service;

import org.beanditest1.dao.EmpDAO2;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import javax.inject.Named;

@Service
public class UpdateEmpService2 {

	private EmpDAO2 dao;
	@Inject
	public void setDao(@Named("mybatisEmpDAO")EmpDAO2 dao) {
		this.dao = dao;
	}

	public void updateEmp(){
		System.out.println("更新员工操作处理");
		dao.update();
	}
}
