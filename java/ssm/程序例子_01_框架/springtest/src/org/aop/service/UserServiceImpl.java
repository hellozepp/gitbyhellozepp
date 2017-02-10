package org.aop.service;

/**
 * Created by andilyliao on 17-1-4.
 */
public class UserServiceImpl implements UserService {
    public int delete() {
        System.out.println("删除用户信息");
        return 1;
    }

    public void save() {

        System.out.println("保存用户信息");
        //模拟NullPointException
        String s = null;
        s.length();
    }

    public int update() {
        System.out.println("更新用户信息");
        return 1;
    }
}
