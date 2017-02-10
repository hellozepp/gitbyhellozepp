package cn.itcast.spring3.demo1;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class SpringTest1 {
	
	@Autowired
	@Qualifier("jdbcTemplate")
	private JdbcTemplate jdbcTemplate;
	
	@Test
	public void demo2(){
		jdbcTemplate.execute("create table user (id int primary key auto_increment,name varchar(20))");
	}
	
	@Test
	public void demo1(){
		// 创建连接池:
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		// 设置参数:
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql:///spring3_day02");
		dataSource.setUsername("root");
		dataSource.setPassword("123");
		
		// 使用JDBC的模板:
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		jdbcTemplate.execute("create table user (id int primary key auto_increment,name varchar(20))");
	}
}
