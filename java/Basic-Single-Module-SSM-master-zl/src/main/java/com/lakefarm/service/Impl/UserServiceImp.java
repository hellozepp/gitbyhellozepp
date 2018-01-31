package com.lakefarm.service.Impl;


import com.lakefarm.mapper.UserMapper;
import com.lakefarm.pojo.User;
import com.lakefarm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by cxd on 2017/2/6.
 */
@Service
public class UserServiceImp implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public User login(User UserInfo) {
        return userMapper.login(UserInfo);
    }

    @Override
    public List<User> find(Map<String, Object> map) {
        return null;
    }

    @Override
    public Long getTotal(Map<String, Object> map) {
        return null;
    }

    @Override
    public int addUser(User userInfo) {
        return userMapper.addUser(userInfo);
    }

    @Override
    public int update(User userInfo) {
        return userMapper.update(userInfo);
    }

    @Override
    public int deletebyId(String u_id) {
        return 0;
    }

    @Override
    public List<User> findByMap(Map<String, Object> map) {
        return null;
    }

    @Override
    public User getUserById(String u_id) {
        return userMapper.getUserById(u_id);
    }
}
