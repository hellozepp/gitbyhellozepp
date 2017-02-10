package cn.itcast.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

public class JdbcUtils {

	private static final String DRIVERCLASS;
	private static final String URL;
	private static final String USERNAME;
	private static final String PASSWORD;

	static {
		DRIVERCLASS = ResourceBundle.getBundle("jdbc").getString("driverClass");
		URL = ResourceBundle.getBundle("jdbc").getString("url");
		USERNAME = ResourceBundle.getBundle("jdbc").getString("username");
		PASSWORD = ResourceBundle.getBundle("jdbc").getString("password");
	}

	static {
		try {
			// 将加载驱动操作，放置在静态代码块中.这样就保证了只加载一次.
			Class.forName(DRIVERCLASS);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static Connection getConnection() throws SQLException {
		Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD);

		// 对Connection进行增强

		// return new MyConnection(con);

		// 使用动态代理来完成

		return con;
	}

	// 关闭操作
	public static void closeConnection(Connection con) throws SQLException {
		if (con != null) {
			con.close();
		}
	}

	public static void closeStatement(Statement st) throws SQLException {
		if (st != null) {
			st.close();
		}
	}

	public static void closeResultSet(ResultSet rs) throws SQLException {
		if (rs != null) {
			rs.close();
		}
	}
}
// class MyConnection implements Connection {
// private Connection con;
//
// public MyConnection(Connection con) {
// this.con = con;
// }
//
// public <T> T unwrap(Class<T> iface) throws SQLException {
//
// return con.unwrap(iface);
// }
//
// public boolean isWrapperFor(Class<?> iface) throws SQLException {
//
// return con.isWrapperFor(iface);
// }
//
// public Statement createStatement() throws SQLException {
// // TODO Auto-generated method stub
// return null;
// }
//
// public PreparedStatement prepareStatement(String sql)
// throws SQLException {
// // TODO Auto-generated method stub
// return null;
// }
//
// public CallableStatement prepareCall(String sql) throws SQLException {
// // TODO Auto-generated method stub
// return null;
// }
//
// public String nativeSQL(String sql) throws SQLException {
// // TODO Auto-generated method stub
// return null;
// }
//
// public void setAutoCommit(boolean autoCommit) throws SQLException {
// // TODO Auto-generated method stub
//
// }
//
// public boolean getAutoCommit() throws SQLException {
// // TODO Auto-generated method stub
// return false;
// }
//
// public void commit() throws SQLException {
// // TODO Auto-generated method stub
//
// }
//
// public void rollback() throws SQLException {
// // TODO Auto-generated method stub
//
// }
//
// public void close() throws SQLException {
// //将Connection对象重新装入到集合中.
//
// ll.add(this);
//
// }
//
// public boolean isClosed() throws SQLException {
// // TODO Auto-generated method stub
// return false;
// }
//
// public DatabaseMetaData getMetaData() throws SQLException {
// // TODO Auto-generated method stub
// return null;
// }
//
// public void setReadOnly(boolean readOnly) throws SQLException {
// // TODO Auto-generated method stub
//
// }
//
// public boolean isReadOnly() throws SQLException {
// // TODO Auto-generated method stub
// return false;
// }
//
// public void setCatalog(String catalog) throws SQLException {
// // TODO Auto-generated method stub
//
// }
//
// public String getCatalog() throws SQLException {
// // TODO Auto-generated method stub
// return null;
// }
//
// public void setTransactionIsolation(int level) throws SQLException {
// // TODO Auto-generated method stub
//
// }
//
// public int getTransactionIsolation() throws SQLException {
// // TODO Auto-generated method stub
// return 0;
// }
//
// public SQLWarning getWarnings() throws SQLException {
// // TODO Auto-generated method stub
// return null;
// }
//
// public void clearWarnings() throws SQLException {
// // TODO Auto-generated method stub
//
// }
//
// public Statement createStatement(int resultSetType,
// int resultSetConcurrency) throws SQLException {
// // TODO Auto-generated method stub
// return null;
// }
//
// public PreparedStatement prepareStatement(String sql,
// int resultSetType, int resultSetConcurrency)
// throws SQLException {
// // TODO Auto-generated method stub
// return null;
// }
//
// public CallableStatement prepareCall(String sql, int resultSetType,
// int resultSetConcurrency) throws SQLException {
// // TODO Auto-generated method stub
// return null;
// }
//
// public Map<String, Class<?>> getTypeMap() throws SQLException {
// // TODO Auto-generated method stub
// return null;
// }
//
// public void setTypeMap(Map<String, Class<?>> map) throws SQLException {
// // TODO Auto-generated method stub
//
// }
//
// public void setHoldability(int holdability) throws SQLException {
// // TODO Auto-generated method stub
//
// }
//
// public int getHoldability() throws SQLException {
// // TODO Auto-generated method stub
// return 0;
// }
//
// public Savepoint setSavepoint() throws SQLException {
// // TODO Auto-generated method stub
// return null;
// }
//
// public Savepoint setSavepoint(String name) throws SQLException {
// // TODO Auto-generated method stub
// return null;
// }
//
// public void rollback(Savepoint savepoint) throws SQLException {
// // TODO Auto-generated method stub
//
// }
//
// public void releaseSavepoint(Savepoint savepoint) throws SQLException {
// // TODO Auto-generated method stub
//
// }
//
// public Statement createStatement(int resultSetType,
// int resultSetConcurrency, int resultSetHoldability)
// throws SQLException {
// // TODO Auto-generated method stub
// return null;
// }
//
// public PreparedStatement prepareStatement(String sql,
// int resultSetType, int resultSetConcurrency,
// int resultSetHoldability) throws SQLException {
// // TODO Auto-generated method stub
// return null;
// }
//
// public CallableStatement prepareCall(String sql, int resultSetType,
// int resultSetConcurrency, int resultSetHoldability)
// throws SQLException {
// // TODO Auto-generated method stub
// return null;
// }
//
// public PreparedStatement prepareStatement(String sql,
// int autoGeneratedKeys) throws SQLException {
// // TODO Auto-generated method stub
// return null;
// }
//
// public PreparedStatement prepareStatement(String sql,
// int[] columnIndexes) throws SQLException {
// // TODO Auto-generated method stub
// return null;
// }
//
// public PreparedStatement prepareStatement(String sql,
// String[] columnNames) throws SQLException {
// // TODO Auto-generated method stub
// return null;
// }
//
// public Clob createClob() throws SQLException {
// // TODO Auto-generated method stub
// return null;
// }
//
// public Blob createBlob() throws SQLException {
// // TODO Auto-generated method stub
// return null;
// }
//
// public NClob createNClob() throws SQLException {
// // TODO Auto-generated method stub
// return null;
// }
//
// public SQLXML createSQLXML() throws SQLException {
// // TODO Auto-generated method stub
// return null;
// }
//
// public boolean isValid(int timeout) throws SQLException {
// // TODO Auto-generated method stub
// return false;
// }
//
// public void setClientInfo(String name, String value)
// throws SQLClientInfoException {
// // TODO Auto-generated method stub
//
// }
//
// public void setClientInfo(Properties properties)
// throws SQLClientInfoException {
// // TODO Auto-generated method stub
//
// }
//
// public String getClientInfo(String name) throws SQLException {
// // TODO Auto-generated method stub
// return null;
// }
//
// public Properties getClientInfo() throws SQLException {
// // TODO Auto-generated method stub
// return null;
// }
//
// public Array createArrayOf(String typeName, Object[] elements)
// throws SQLException {
// // TODO Auto-generated method stub
// return null;
// }
//
// public Struct createStruct(String typeName, Object[] attributes)
// throws SQLException {
// // TODO Auto-generated method stub
// return null;
// }
// };
// }
