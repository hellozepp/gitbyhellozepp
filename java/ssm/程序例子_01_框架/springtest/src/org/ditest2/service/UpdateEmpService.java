package org.ditest2.service;

import org.ditest1.dao.EmpDAO1;

public class UpdateEmpService {
	private EmpDAO1 dao;
	
	public void setDao(EmpDAO1 dao) {
		this.dao = dao;
	}

	public void updateEmp(){
		System.out.println("更新员工操作处理");
		dao.update();
	}
}
