package org.spring.AOP;

/**
 * Created by hadoop on 16-9-13.
 */
public class UserDaoImpl implements UserDao {
    public void add() {
        System.out.println("添加用户");
    }

    public void update() {
        System.out.println("修改用户");
    }
}
