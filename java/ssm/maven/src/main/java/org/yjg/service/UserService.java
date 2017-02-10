package org.yjg.service;

import org.apache.log4j.Logger;
import org.apache.log4j.spi.LoggerFactory;
import org.springframework.stereotype.Service;
import org.yjg.bean.Userbean;
import org.yjg.dao.UserDao;
import org.yjg.util.CommonConst;

import javax.annotation.Resource;
import javax.xml.registry.infomodel.User;
import java.util.UUID;

/**
 * Created by hadoop on 16-9-10.
 */
@Service
public class UserService implements IUserService {
    @Resource
    private UserDao userDao;
    private Logger logger = Logger.getLogger(UserService.class);

    public UserService() {
    }

    public String add(Userbean user) {
        this.logger.info("UserService.add User[{}]");

        try {
            user.setUid(UUID.randomUUID().toString());
            if(this.userDao.add(user) > 0) {
                return "0";
            }
        } catch (Exception var3) {
            var3.printStackTrace();
        }

        return "1";
    }

    public void test() {
        System.out.println("UserService.....");
    }
}
