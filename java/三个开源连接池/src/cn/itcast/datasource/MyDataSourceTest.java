package cn.itcast.datasource;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

//测试自己定义的连接池
public class MyDataSourceTest {

	public static void main(String[] args) throws SQLException {
		DataSource mds = new MyDataSource(); // 创建一个连接池

		// 获取一个连接对象
		Connection con = mds.getConnection();

		// 操作
		ResultSet rs = con.createStatement().executeQuery(
				"select * from account");

		while (rs.next()) {

			System.out.println(rs.getInt("id") + "  " + rs.getString("name"));
		}

		rs.close();

		// 将连接对象重新装入到连接池
		// mds.readd(con);

		con.close(); // 原来作用是将Connection对象销毁，我们在使用连接池，获取Connection对象后，在调用close方法，就不在是销毁，而是将其重新放回到连接池。
		// System.out.println(mds.getSize());
	}
}
