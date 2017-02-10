package org.spring.normal.ioc.before;

/**
 * Created by LeoAshin on 16/9/4.
 * in 上午1:32
 */
public interface UserService {

    void addNewUser(String username, String password);

    void loginUser(String username, String password);
}
