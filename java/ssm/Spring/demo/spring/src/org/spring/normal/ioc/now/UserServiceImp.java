package org.spring.normal.ioc.now;

/**
 * Created by LeoAshin on 16/9/4.
 * in 上午1:33
 */
public class UserServiceImp implements UserService {

    private UserDao dao;

    public void setUserDao(UserDao userDao){
        this.dao = userDao;
    }

    @Override
    public void addNewUser(String username, String password) {
        dao.addNewUser(username, password);
    }
}
