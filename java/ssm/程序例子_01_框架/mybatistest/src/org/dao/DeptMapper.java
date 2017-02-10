package org.dao;

import org.entity.Dept;
import org.entity.Dept1;

import java.util.List;

public interface DeptMapper {
	public List<Dept> findAll();
	public Dept findById(int id);
	public void addDept(Dept dept);
	public void updateDept(Dept dept);
	public void deleteById(int id);
	
	//TestResultMap
	public List<Dept1> findAll1();
}
