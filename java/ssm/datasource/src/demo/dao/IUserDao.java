package demo.dao;

import demo.pojo.User;

import java.sql.Connection;

/**
 * Created by andilyliao on 16-9-5.
 */
public interface IUserDao {
    boolean adduser(Connection conn,User user);
}
