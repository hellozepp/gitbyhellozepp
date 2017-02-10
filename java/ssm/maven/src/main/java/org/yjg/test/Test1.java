package org.yjg.test;

import org.springframework.stereotype.Component;
import org.yjg.bean.Userbean;
import org.yjg.service.IUserService;

import javax.annotation.Resource;

/**
 * Created by hadoop on 16-9-24.
 */
@Component
public class Test1 {
    @Resource
    private IUserService testService;//通过标记的@service找到定义@Resource的接口名
    public void testService(){
        testService.test();
    }
}
