package com.hello.zepp;

import com.hello.zepp.entity.Operator;
import com.hello.zepp.utils.TaylorSeries;
import net.openhft.affinity.AffinityLock;
import net.openhft.affinity.CpuLayout;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.HashSet;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static net.openhft.affinity.AffinityStrategies.DIFFERENT_CORE;
import static net.openhft.affinity.AffinityStrategies.DIFFERENT_SOCKET;

/**
 * Created by docker on 2017/10/22.
 */
public class EasyFX {
    private static final Logger log = LoggerFactory.getLogger(EasyFX.class);
    private static HashSet<Operator> operators = new HashSet<Operator>();//存放op记录
    private static int CORE;
    private static int PARALLEL_NUM;

    static {
        CORE = 7;
        PARALLEL_NUM = 7;
    }

    public EasyFX setOps(Operator... ops) {
        operators.addAll(Arrays.asList(ops));
        return this;
    }

    public void execute() {
        ExecutorService executorService = null;
        AffinityLock al = null;
        try {
            al = AffinityLock.acquireCore(false);
            executorService = Executors.newFixedThreadPool(PARALLEL_NUM);
            CountDownLatch cdl = new CountDownLatch(operators.size());
            for (Operator op : operators) {
                op.setCdl(cdl);
                AffinityLock al1 = al.acquireLock(DIFFERENT_SOCKET, DIFFERENT_CORE);
                op.setAffinityLock(al1);
                executorService.execute(op);
            }
            try {
                cdl.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } finally {
            if (executorService != null) {
                executorService.shutdown();
            }
            if (al != null) {
                al.release();
            }
        }

    }

    public EasyFX bindCore(int i) {
        CpuLayout cpu = AffinityLock.cpuLayout();
        int cpus = cpu.cpus();
        CORE = (cpus < i ? cpus : i) - 1;//core 0 不能使用
        log.info("[EasyFX->bindCore] cpus is :" + cpus + ",bind the core is :" + CORE);
        return this;
    }

    public EasyFX setParallelNu(int parallelNu) {
        PARALLEL_NUM = parallelNu;
        return this;
    }
}
