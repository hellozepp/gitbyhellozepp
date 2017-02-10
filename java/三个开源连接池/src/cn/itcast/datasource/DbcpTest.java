package cn.itcast.datasource;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.commons.dbcp.BasicDataSourceFactory;
import org.junit.Test;

public class DbcpTest {

	// 1.手动配置
	@Test
	public void test1() throws SQLException {

		BasicDataSource bds = new BasicDataSource();

		// 需要设置连接数据库最基本四个条件
		bds.setDriverClassName("com.mysql.jdbc.Driver");
		bds.setUrl("jdbc:mysql:///day18");
		bds.setUsername("root");
		bds.setPassword("abc");

		// 得到一个Connection
		Connection con = bds.getConnection();

		ResultSet rs = con.createStatement().executeQuery(
				"select * from account");

		while (rs.next()) {

			System.out.println(rs.getInt("id") + "  " + rs.getString("name"));
		}

		rs.close();
		con.close(); // 将Connection对象重新装入到连接池.

	}

	// 2.自动配置
	@Test
	public void test2() throws Exception {

		Properties props = new Properties();

		// props.setProperty("driverClassName", "com.mysql.jdbc.Driver");
		// props.setProperty("url", "jdbc:mysql:///day18");
		// props.setProperty("username", "root");
		// props.setProperty("password", "abc");
		FileInputStream fis = new FileInputStream(
				"D:\\java1110\\workspace\\day18_2\\src\\dbcp.properties");
		props.load(fis);

		DataSource ds = BasicDataSourceFactory.createDataSource(props);

		// 得到一个Connection
		Connection con = ds.getConnection();

		ResultSet rs = con.createStatement().executeQuery(
				"select * from account");

		while (rs.next()) {

			System.out.println(rs.getInt("id") + "  " + rs.getString("name"));
		}

		rs.close();
		con.close(); // 将Connection对象重新装入到连接池.
	}
}
