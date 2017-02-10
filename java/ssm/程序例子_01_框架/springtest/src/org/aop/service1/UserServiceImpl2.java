package org.aop.service1;

import org.springframework.stereotype.Service;

/**
 * Created by andilyliao on 17-1-4.
 */
@Service
public class UserServiceImpl2 implements UserService2 {

    public int update() {
        System.out.println("更新用户信息");
        return 1;
    }
}
