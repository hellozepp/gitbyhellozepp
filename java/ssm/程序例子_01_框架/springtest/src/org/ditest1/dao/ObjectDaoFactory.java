package org.ditest1.dao;

public class ObjectDaoFactory {
	
	
	public EmpDAO getEmpDAO(){
		return new JdbcEmpDAO();
	}
}
