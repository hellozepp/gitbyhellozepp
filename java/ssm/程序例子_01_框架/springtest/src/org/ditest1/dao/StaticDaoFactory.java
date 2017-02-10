package org.ditest1.dao;

public class StaticDaoFactory {
	
	
	public static EmpDAO getEmpDAO(){
		return new JdbcEmpDAO();
	}
}
