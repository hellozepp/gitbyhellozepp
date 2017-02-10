package org.spring.normal.ioc.now;

/**
 * Created by LeoAshin on 16/9/4.
 * in 上午1:31
 */
public class UserDaoMysqlImp implements UserDao {

    @Override
    public void addNewUser(String username, String password) {
        System.out.println("各种连接数据库");
        System.out.println("addNewUser" + username + ":" + password);
    }
}
