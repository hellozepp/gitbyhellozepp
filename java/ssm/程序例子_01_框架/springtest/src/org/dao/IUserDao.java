package org.dao;

import org.pojo.User;

/**
 * Created by andilyliao on 17-1-4.
 */
public interface IUserDao {
    boolean isUserExists(User user) throws Exception;
}
