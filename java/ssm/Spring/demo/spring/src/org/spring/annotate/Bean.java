package org.spring.annotate;

import org.springframework.stereotype.Component;

/**
 * Created by LeoAshin on 16/9/4.
 * in 上午3:31
 */
@Component
public class Bean {

    public Bean(){
        System.out.println("Bean 实例化");
    }

    public void execute(){
        System.out.println("Bean 执行");
    }


}
