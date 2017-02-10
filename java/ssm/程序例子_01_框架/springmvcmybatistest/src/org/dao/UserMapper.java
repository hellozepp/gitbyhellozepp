package org.dao;

import org.model.User;

public interface UserMapper {
	public User selectUserById(int userId);

}