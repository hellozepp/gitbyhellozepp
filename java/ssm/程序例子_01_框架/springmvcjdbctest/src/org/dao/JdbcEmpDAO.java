package org.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.entity.Emp;
import org.entity.EmpMapper;

import java.util.List;

@Repository
public class JdbcEmpDAO implements EmpDAO{
	
	private JdbcTemplate template;
	@Autowired
	public void setTemplate(JdbcTemplate template){
		this.template = template;
	}

	public List<Emp> findAll() {
		String sql = "select * from t_emp";
		RowMapper<Emp> mapper = new EmpMapper();
		List<Emp> list = template.query(sql, mapper);
		return list;
	}

}
