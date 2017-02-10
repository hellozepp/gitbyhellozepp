package demo.service;

import demo.dao.IUserDao;
import demo.dao.UserDao;
import demo.pojo.User;
import tools.InitServlet;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by andilyliao on 16-9-5.
 */
public class DemoService implements IDemo {
    private IUserDao userDao=new UserDao();
    @Override
    public void xxx(User user) {
        Connection conn=null;
        try {
            conn= InitServlet.getConn();
            userDao.adduser(conn,user);
            conn.commit();

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            try {
                InitServlet.returnConn(conn);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
