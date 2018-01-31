package com.hello.zepp.entity;

import net.openhft.affinity.Affinity;
import net.openhft.affinity.AffinityLock;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;
import java.util.concurrent.CountDownLatch;

/**
 * Created by docker on 2017/10/22.
 */
public abstract class Operator implements Serializable, Runnable {
    private static final Logger log =  LoggerFactory.getLogger(Operator.class);
    static final long serialVersionUID = 42121L;
    public volatile double val;
    public static CountDownLatch cdl;
    private AffinityLock al;

    public void run() {
        System.out.println("start run server!");
        al.bind(true);//绑在整个核上
        System.out.println("current cpu is："+Thread.currentThread().getName() + ":" + Affinity.getCpu());
        this.val = this.call();
        cdl.countDown();
        log.info("the thread "+Thread.currentThread().getName()+" is finish!");
    }

    /**
     * 回调函数，用来设置并行计算表达式。
     *
     * @return value
     */
    public abstract double call();

    public void setCdl(CountDownLatch cdl) {
        Operator.cdl = cdl;
    }

    public  double getVal() {
        return val;
    }

    public  void setVal(double val) {
        this.val = val;
    }

    public void setAffinityLock(AffinityLock affinityLock) {
        this.al = affinityLock;
    }
}
