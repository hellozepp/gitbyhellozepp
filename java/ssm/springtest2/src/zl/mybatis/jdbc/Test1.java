package zl.mybatis.jdbc;

import java.sql.*;

/**
 * Created by hadoop on 2017/1/1.
 */
public class Test1{
    public static java.sql.Connection getConnection() throws ClassNotFoundException {
       final String DRIVER="com.mysql.jdbc.Driver";
        final String URL="jdbc:mysql://127.0.0.1:3306/userinfo";
        final String USERNAME="mytestdb";
        final String PASSWORD="123123";
        Class.forName(DRIVER);
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(URL,USERNAME,PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }
    public static void main(String[] args) throws ClassNotFoundException {
        Connection connection =Test1.getConnection();
        PreparedStatement prest = null;
        try {
            prest = connection.prepareStatement
                    ("SELECT * FROM user WHERE id = ? and name = ?");

        prest.setInt(1,10);
        prest.setString(2,"张三");
        ResultSet resultSet =prest.executeQuery();
        while (resultSet.next())
        {
            int id=resultSet.getInt("id");
            String username=resultSet.getString("name");
            String password=resultSet.getString("pass");
            System.out.println(id+"  "+username+"  "+password+"  ");
        }  } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
/**多结果集或ddl语句、 单结果集、 ddl
 * JDBCTM中Statement接口提供的execute、executeQuery和executeUpdate之间的区别
 Statement 接口提供了三种执行 SQL 语句的方法：executeQuery、executeUpdate和 execute。使用哪一个方法由
 SQL 语句所产生的内容决定。
 方法executeQuery
 用于产生单个结果集的语句，例如 SELECT 语句。 被使用最多的执行 SQL 语句的方法是 executeQuery。这个方法被用来执行 SELECT
 语句，它几乎是使用最多的 SQL 语句。
 方法executeUpdate
 用于执行 INSERT、UPDATE 或 DELETE 语句以及 SQL DDL（数据定义语言）语句，例如 CREATE TABLE 和 DROP
 TABLE。INSERT、UPDATE 或 DELETE 语句的效果是修改表中零行或多行中的一列或多列。executeUpdate
 的返回值是一个整数，指示受影响的行数（即更新计数）。对于 CREATE TABLE 或 DROP TABLE 等不操作行的语句，executeUpdate
 的返回值总为零。
 使用executeUpdate方法是因为在 createTableCoffees 中的 SQL 语句是 DDL
 （数据定义语言）语句。创建表，改变表，删除表都是 DDL 语句的例子，要用 executeUpdate 方法来执行。你也可以从它的名字里看出，方法
 executeUpdate 也被用于执行更新表 SQL 语句。实际上，相对于创建表来说，executeUpdate
 更多时间是用于更新表，因为表只需要创建一次，但经常被更新。
 方法execute：
 用于执行返回多个结果集、多个更新计数或二者组合的语句。因为多数程序员不会需要该高级功能
 execute方法应该仅在语句能返回多个ResultSet对象、多个更新计数或ResultSet对象与更新计数的组合时使用。当执行某个已存储过程
 或动态执行未知 SQL 字符串（即应用程序程序员在编译时未知）时，有可能出现多个结果的情况，尽管这种情况很少见。
 因为方法 execute 处理非常规情况，所以获取其结果需要一些特殊处理并不足为怪。例如，假定已知某个过程返回两个结果集，则在使用方法 execute
 执行该过程后，必须调用方法 getResultSet 获得第一个结果集，然后调用适当的 getXXX 方法获取其中的值。要获得第二个结果集，需要先调用
 getMoreResults 方法，然后再调用 getResultSet 方法。如果已知某个过程返回两个更新计数，则首先调用方法
 getUpdateCount，然后调用 getMoreResults，并再次调用 getUpdateCount。
 对于不知道返回内容，则情况更为复杂。如果结果是 ResultSet 对象，则方法 execute 返回 true；如果结果是 Java int，则返回
 false。如果返回 int，则意味着结果是更新计数或执行的语句是 DDL 命令。在调用方法 execute 之后要做的第一件事情是调用
 getResultSet 或 getUpdateCount。调用方法 getResultSet 可以获得两个或多个 ResultSet
 对象中第一个对象；或调用方法 getUpdateCount 可以获得两个或多个更新计数中第一个更新计数的内容。*/