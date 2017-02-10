package org.spring.normal.ioc.before;

/**
 * Created by LeoAshin on 16/9/4.
 * in 上午1:33
 */
public class UserServiceImp implements UserService {

    private UserDao dao = new UserDaoOracleImp();

    @Override
    public void addNewUser(String username, String password) {
        dao.addNewUser(username, password);
    }

    @Override
    public void loginUser(String username, String password) {
        //!username == password
        // username!! uid select passwordl from user;

    }
}
