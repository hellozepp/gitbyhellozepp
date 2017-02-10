package org.spring.normal.ioc.before;

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

    @Override
    public boolean findPwdByUserName(String username) {
        System.out.println("Mysql连接 各种查找");

        return true;
    }
}
