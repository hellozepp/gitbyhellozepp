package org.spring.normal.ioc.before;

/**
 * Created by LeoAshin on 16/9/4.
 * in 上午1:30
 */
public interface UserDao {
    void addNewUser(String username, String password);

    boolean findPwdByUserName(String username);
}
