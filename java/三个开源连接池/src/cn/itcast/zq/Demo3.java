package cn.itcast.zq;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import cn.itcast.utils.JdbcUtils;

public class Demo3 {

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		
		Class.forName("com.mysql.jdbc.Driver"); //注册驱动
				
		final Connection con = DriverManager.getConnection("jdbc:mysql:///day18","root","abc");
		
		Connection proxy = (Connection) Proxy.newProxyInstance(con.getClass()
				.getClassLoader(), con.getClass().getInterfaces(),
				new InvocationHandler() {

					public Object invoke(Object proxy, Method method,
							Object[] args) throws Throwable {

						return method.invoke(con, args);
					}
				});

		System.out.println(proxy);

	}
}
