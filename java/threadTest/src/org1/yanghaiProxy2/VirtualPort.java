package org1.yanghaiProxy2;

import java.util.*;

public class VirtualPort {
    /** 随机对象*/
    static Random random = new Random();

    /**真实的节点*/
 //   public static String[] realServer = new String[]{"8080", "8081", "8082"};
    public static String[] realServer = new String[]{"8080", "8081", "8082","8083"};
    /** 用TreeMap来存虚拟节点*/
    public static SortedMap<Long,String> virtualServer=
            new TreeMap<>();

    public static void addPost(String[] realServer) {
        for(int i=0;i<realServer.length;i++) {
            // virtualServer.put(VirtualPort.getHash(realServer[i]), realServer[i]);
            //随机产生虚拟节点的个数
            int virtualNumber = random.nextInt(  64);
            while (true) {
                if (virtualNumber < 20) {
                    virtualNumber =random.nextInt(64);
                } else {
                    break;
                }
            }
            //添加虚拟节点
            long length = (long) (Math.pow(2, 32) / virtualNumber);
            for (int j = 0; j < virtualNumber; j++) {
                //步长
                virtualServer.put(VirtualPort.getHash(realServer[i]) + length * j, realServer[i] +j + "虚拟节点");
            }
            System.out.println("第"+i+"realserver配置成功！！");

        }
    }
/**
 * <<      :     左移运算符，num << 1,相当于num乘以2
 >>        :     右移运算符，num >> 1,相当于num除以2
 >>>       :     无符号右移，忽略符号位，空位都以0补齐
 使用FNV1_32_HASH算法计算服务器的Hash值,这里不使用重写hashCode的方法，最终效果没区别*/
    public   static long getHash(String str)
    {
        final int p = 16777619;
        int hash = (int)2166136261L;
        for (int i = 0; i < str.length(); i++)
            hash = (hash ^ str.charAt(i)) * p;//按位异或
        hash += hash << 13;
        hash ^= hash >> 7;
        hash += hash << 3;
        hash ^= hash >> 17;
        hash += hash << 5;

        // 如果算出来的值为负数则取其绝对值
        if (hash < 0)
            hash = Math.abs(hash);
        return hash;
    }
    public static String getrealServer(String client){
        //得到访问节点的hash值
        long hash = VirtualPort.getHash(client);
        //得到大于该hash值的虚拟节点的结合
        SortedMap<Long,String> hashMap = virtualServer.tailMap(hash);
        //得到第一个元素的值
        Long nodevalue = hashMap.firstKey();
        //得到虚拟节点的名字
        String virtualName = hashMap.get(nodevalue);
        //得到真实节点
        String realServerName = virtualName.substring(0,4);
        return realServerName;

    }

//    public static void main(String[] args) {
//        VirtualPort.addPost(realServer);
//        System.out.println(virtualServer);
//        for(int i =1;i<1000;i++){
////            System.out.println(i+"客户端！！！");
//            String server= VirtualPort.getrealServer(i+" ");
////            System.out.println("=====>"+server);
////            System.out.println(server.substring(0,server.length()-1)+"正在为"+i+"提供服务！！！");//不能减，用的是length个
//            System.out.println(server+"正在为"+i+"提供服务！！！");
//
//
//        }
//    }

}
