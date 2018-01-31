package test.java;

import java.sql.*;

/**
 * Created by docker on 2017/7/23.
 */
public class JDBCtest1 {
    private static Connection conn = null;
    private static String oracle_url = null;
    private static String oracle_user = null;
    private static String oracle_password = null;
    private static String driver = null;

    static{
        try {
//            URL url = JDBCUtil.class.getClassLoader().getResource("jdbc.properties");
//            FileInputStream fis = new FileInputStream(new File(url.getPath()));
//            Properties prop = new Properties();
//            prop.load(fis);
            oracle_url = "jdbc:mysql://192.168.100.64:3306/lhjh_activities";
            oracle_user ="lhjh";
            oracle_password ="lhjh";
            driver = "com.mysql.jdbc.Driver";
            Class.forName(driver);
        } catch(Exception e) {
            System.out.println("链接数据库失败！");
            e.printStackTrace();
        }
    }

    public static Connection getConnection(){
        try {
            if(conn==null){
                return DriverManager.getConnection(oracle_url, oracle_user, oracle_password);
            }
        } catch (SQLException e) {
            System.out.println("获取数据库链接失败！");
            e.printStackTrace();
        }
        return conn;
    }

    public static void closeConn(Connection conn, Statement statem, ResultSet set){
        if(set!=null){
            try {
                set.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }finally{
                set = null;
            }
        }
        if(statem!=null){
            try {
                statem.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }finally{
                statem = null;
            }
        }
        if(conn!=null){
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }finally{
                conn = null;
            }
        }
    }

    public static void main(String[] args) {
        Connection connection = getConnection();
    }

}
