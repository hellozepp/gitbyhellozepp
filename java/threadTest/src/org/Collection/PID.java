package org.Collection;

import java.io.IOException;
import java.lang.management.ManagementFactory;

/**
 * Created by hadoop on 16-8-2.
 */
public class PID {
    public static void main(String[] args) {


        String name = ManagementFactory.getRuntimeMXBean().getName();//拿到 PID
        System.out.println(name);
        // get pid
        String pid = name.split("@")[0];
        System.out.println("Pid is:" + pid);
        Process process;
        try {
            process=Runtime.getRuntime().exec("kill -9 "+pid);//init 0 关机
//            process=Runtime.getRuntime().exec("mkdir abc /home/hadoop/桌面/IO流/test");//没效果
            process.waitFor();

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("fa");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        while (true);
    }
}
