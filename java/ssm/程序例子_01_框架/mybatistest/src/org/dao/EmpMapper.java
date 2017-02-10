package org.dao;

import org.entity.Emp;

import java.util.List;

public interface EmpMapper {
	public List<Emp> findAll();
	public Emp findById(int id);
	public void addEmp(Emp emp);
	public void updateEmp(Emp emp);
	public void deleteById(int id);
}

