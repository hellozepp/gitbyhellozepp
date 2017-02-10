package org.beanditest1.dao;

import org.springframework.stereotype.Repository;

@Repository
public class MybatisEmpDAO implements EmpDAO2 {

	public void add() {
		System.out.println("利用Mybatis技术保存Emp信息");
	}

	public void delete() {
		System.out.println("利用Mybatis技术删除Emp信息");
	}

	public void update() {
		System.out.println("利用Mybatis技术更新Emp信息");
	}

}
