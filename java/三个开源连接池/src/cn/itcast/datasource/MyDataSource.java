package cn.itcast.datasource;

import java.io.PrintWriter;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.LinkedList;
import java.util.logging.Logger;

import javax.sql.DataSource;

import cn.itcast.utils.JdbcUtils;

public class MyDataSource implements DataSource {

	private LinkedList<Connection> ll; // 用于装Connection对象的容器。

	public MyDataSource() throws SQLException {

		ll = new LinkedList<Connection>();
		// 当创建MyDateSource对象时，会向ll中装入5个Connection对象。

		for (int i = 0; i < 5; i++) {

			Connection con = JdbcUtils.getConnection();

			ll.add(con);

		}

	}

	// 获取连接方法
	public Connection getConnection() throws SQLException {

		if (ll.isEmpty()) {
			for (int i = 0; i < 3; i++) {

				Connection con = JdbcUtils.getConnection();

				ll.add(con);

			}
		}

		final Connection con = ll.removeFirst();

		Connection proxyCon = (Connection) Proxy.newProxyInstance(con
				.getClass().getClassLoader(), con.getClass().getInterfaces(),
				new InvocationHandler() {

					public Object invoke(Object proxy, Method method,
							Object[] args) throws Throwable {
						if ("close".equals(method.getName())) {

							// 这代表是close方法，它要做的事情是将con对象重新装入到集合中.

							ll.add(con);
							System.out.println("重新将连接对象装入到集合中");

							return null;

						} else {
							return method.invoke(con, args);// 其它方法执行原来操作
						}
					}
				});

		return proxyCon;
	}

	// 将Connection对象重新装入.
	// public void readd(Connection con) {
	//
	// ll.addLast(con);
	//
	// }

	// public int getSize() {
	// return ll.size();
	// }

	public Connection getConnection(String username, String password)
			throws SQLException {
		return null;
	}

	public PrintWriter getLogWriter() throws SQLException {
		return null;
	}

	public void setLogWriter(PrintWriter out) throws SQLException {

	}

	public void setLoginTimeout(int seconds) throws SQLException {

	}

	public int getLoginTimeout() throws SQLException {
		return 0;
	}

	public <T> T unwrap(Class<T> iface) throws SQLException {
		return null;
	}

	public boolean isWrapperFor(Class<?> iface) throws SQLException {
		return false;
	}

	public Logger getParentLogger() throws SQLFeatureNotSupportedException {
		// TODO Auto-generated method stub
		return null;
	}

}
