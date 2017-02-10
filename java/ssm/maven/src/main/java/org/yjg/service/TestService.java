package org.yjg.service;

import org.springframework.stereotype.Service;
import org.yjg.bean.Userbean;
import org.yjg.dao.UserDao;

/**
 * Created by hadoop on 16-9-10.
 */
@Service
public class TestService implements IUserService {
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public UserDao getUserDao() {
        return userDao;
    }

    private UserDao userDao;
    public int addNewUser(Userbean userbean) {
        return  userDao.add(userbean);
    }

    public String add(Userbean var1) {
        return null;
    }

    public void test() {
        System.out.println("TestService");
    }
}
