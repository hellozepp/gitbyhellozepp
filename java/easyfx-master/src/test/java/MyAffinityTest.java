import net.openhft.affinity.Affinity;
import net.openhft.affinity.AffinityLock;
import net.openhft.affinity.AffinityStrategies;
import net.openhft.affinity.CpuLayout;

import static net.openhft.affinity.AffinityStrategies.DIFFERENT_CORE;
import static net.openhft.affinity.AffinityStrategies.DIFFERENT_SOCKET;

// -Djava.library.path=/disk/test/iotest/lib
public class MyAffinityTest {
    public static void main(String... args) throws InterruptedException {
        CpuLayout cpu = AffinityLock.cpuLayout();
        System.out.println("cpus: " + cpu.cpus());
        System.out.println("sockets: " + cpu.sockets());
        System.out.println("coresPerSocket: " + cpu.coresPerSocket());
        System.out.println("threadsPerCore: " + cpu.threadsPerCore());
        System.out.println("---------------------------------------------------");
        AffinityLock al = AffinityLock.acquireLock();
        System.out.println("Affinity.getCpu():"+Affinity.getCpu());// -1
        try {
            AffinityLock readerLock = al.acquireLock(DIFFERENT_SOCKET, DIFFERENT_CORE);//不同线 不同核
            new Thread(new SleepRunnable(readerLock, false), "reader").start();

            AffinityLock writerLock = readerLock.acquireLock(AffinityStrategies.SAME_CORE);//同一个核
            new Thread(new SleepRunnable(writerLock, false), "writer").start();
            //mac好像不支持
            Thread.sleep(200);
        } finally {
            al.release();
        }
        System.out.println("---------------------------------------------------");
        //申请启用超线程，使用一个CPU
        al = AffinityLock.acquireCore(false);    /*发动机，引擎*/
        new Thread(new SleepRunnable(al, true), "engine").start();
        Thread.sleep(200);
        System.out.println("---------------------------------------------------");
        new Thread(new SleepRunnable1(), "xxx").start();
        Thread.sleep(500);

        System.out.println("\nThe assignment of CPUs is\n" + AffinityLock.dumpLocks());
            //分配的cpu为
//        dumpLocks 列举锁和cpu情况
//        The assignment of CPUs is
//        0: General use CPU  CPU 0为操作系统保留，它必须在某处运行。
//        1: Thread[writer,5,main] alive=true
//        2: Thread[engine,5,main] alive=true
//        3: Reserved for this application
//        4: Reserved for this application
//        5: Thread[reader,5,main] alive=true
//        6: Thread[engine,5,main] alive=true
//        7: General use CPU
    }

    /*是否在一个核上运行，打印结果*/
    static class SleepRunnable implements Runnable {
        private final AffinityLock affinityLock;
        private final boolean wholeCore;

        SleepRunnable(AffinityLock affinityLock, boolean wholeCore) {
            this.affinityLock = affinityLock;
            this.wholeCore = wholeCore;
        }

        public void run() {
            affinityLock.bind(wholeCore);//True绑定在整个核上
            System.out.println("查看当前cpu："+Thread.currentThread().getName() + ":" + Affinity.getCpu());
            while(true);//查看是否该核轮转
//            try {
//                Thread.sleep(1000);
//            } catch (Exception e) {
//                e.printStackTrace();
//            } finally {
//                affinityLock.release();
//            }
        }
    }

    /*绑定在一个cpu上*/
    static class SleepRunnable1 implements Runnable {
        public void run() {
            Affinity.setAffinity(1);//第1个cpu
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + ":" + Affinity.getCpu());
        }
    }
}
