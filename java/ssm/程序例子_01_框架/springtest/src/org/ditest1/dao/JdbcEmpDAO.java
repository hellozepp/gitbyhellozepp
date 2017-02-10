package org.ditest1.dao;

public class JdbcEmpDAO implements EmpDAO{

	public void add() {
		System.out.println("利用JDBC技术保存Emp信息");
	}

	public void delete() {
		System.out.println("利用JDBC技术删除Emp信息");
	}

	public void update() {
		System.out.println("利用JDBC技术更新Emp信息");
	}

}
