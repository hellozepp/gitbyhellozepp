package org.service;

import org.dao.IUserDao;
import org.pojo.User;

/**
 * Created by andilyliao on 17-1-4.
 */
public class Login implements ILogin {

    private IUserDao userDao;

    public void setUserDao(IUserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public int login(String username, String password) throws Exception {
        int flag=0;
        User user=new User();
        user.setUsername(username);
        user.setPassword(password);
        if(userDao.isUserExists(user)){
            flag=1;
        }
        return flag;
    }
}
