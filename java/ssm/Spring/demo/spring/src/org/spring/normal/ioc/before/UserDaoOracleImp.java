package org.spring.normal.ioc.before;

/**
 * Created by LeoAshin on 16/9/4.
 * in 上午1:41
 */
public class UserDaoOracleImp implements UserDao {
    @Override
    public void addNewUser(String username, String password) {

        System.out.println("各种连接数据库");
        addNewUser(username, password);
    }

    @Override
    public boolean findPwdByUserName(String username) {
        System.out.println("Oracle连接, 各种查找");
        return true;
    }
}
