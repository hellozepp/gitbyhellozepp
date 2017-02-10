package org.dao;

import org.pojo.User;

/**
 * Created by andilyliao on 17-1-4.
 */
public class UserDao implements IUserDao {
    @Override
    public boolean isUserExists(User user) throws Exception {
        return true;
    }
}
