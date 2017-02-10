package org.ditest2.service;

import org.ditest1.dao.EmpDAO;

public class DeleteEmpService {
	
	private EmpDAO dao;
	
	public DeleteEmpService(EmpDAO dao) {
		this.dao = dao;
	}

	public void deleteEmp(){
		System.out.println("删除员工操作处理");
		dao.delete();
	}
}
