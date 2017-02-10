package org.zl.jdbcTemplate;

import org.apache.log4j.BasicConfigurator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by hadoop on 16-9-14.
 */
//重要：：：：：：：：；mysql的驱动
    //连不上需要重启
    @RunWith(SpringJUnit4ClassRunner.class)
    @ContextConfiguration("classpath:application.xml")
public class JDBCTemplateTest {
    @Test
    public void test1(){
//        自动快速地使用缺省Log4j环境。
        BasicConfigurator.configure();
        //配置连接池
        DriverManagerDataSource ds =new DriverManagerDataSource();
        ds.setDriverClassName("com.mysql.jdbc.Driver");
        ds.setUrl("jdbc:mysql://localhost:3306/mytestdb");
        ds.setUsername("mytestdb");
        ds.setPassword("mytestdb");
        //使用JDBC模板
        JdbcTemplate jt =new JdbcTemplate(ds);
//        jt.execute("INSERT  INTO userinfo(id,name,pass)VALUES(13,'newUser1','1234')");
        jt.execute("SELECT * FROM userinfo");
        //打印log4j 内容：

        new JDBCTemplateTest().test2();
    }
    @Autowired
    @Qualifier("jdbcTemplate")
    private JdbcTemplate jdbcTemplate;
    @Test
    public void test2(){
//        jdbcTemplate.execute("CREATE TABLE userinfo2 (id int PRIMARY KEY auto_increment,name VARCHAR(20) not null )");
        jdbcTemplate.execute("SELECT * FROM userinfo");
    }
}
