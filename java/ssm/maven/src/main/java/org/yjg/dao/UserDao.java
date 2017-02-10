package org.yjg.dao;

import org.yjg.annotation.MyBatisRepository;
import org.yjg.bean.Userbean;

/**
 * Created by hadoop on 16-9-10.
 */
@MyBatisRepository
public interface UserDao {
    int add(Userbean var1);
}
