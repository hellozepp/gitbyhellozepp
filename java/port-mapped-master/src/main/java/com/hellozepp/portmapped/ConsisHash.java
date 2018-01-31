package com.hellozepp.portmapped;

import sun.misc.BASE64Encoder;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;
import java.util.SortedMap;
import java.util.concurrent.ConcurrentNavigableMap;
import java.util.concurrent.ConcurrentSkipListMap;

/**
 * Created by hadoop on 16/11/20.
 *  hash算法的意义在于提供了一种快速存取数据的方法,它用一种算法建立键值与真实值之间的对应关系
 *  ,(每一个真实值只能有一个键值,但是一个键值可以对应多个真实值),这样可以快速在数组等条件中里面存取数据.　
 */
public class ConsisHash {
    static volatile ConcurrentNavigableMap<Long,String> virtual =new ConcurrentSkipListMap<Long,String>();

    public   static long FNV1_32(String str)
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

//        System.out.println(hash);
        return hash& 0xffffL; /* Truncate to 32-bits */
    }

    /**
     * 利用MD5进行加密
     * 　　* @param str  待加密的字符串
     * 　　* @return  加密后的字符串
     * 　　* @throws NoSuchAlgorithmException  没有这种产生消息摘要的算法
     * 　　 * @throws UnsupportedEncodingException
     *
     */
    public static String EncoderByMd5(String str) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        //确定计算方法
        MessageDigest md5 = MessageDigest.getInstance("MD5");
        BASE64Encoder base64en = new BASE64Encoder();
        //加密后的字符串
        String newstr = base64en.encode(md5.digest(str.getBytes("utf-8")));
        return newstr;
    }
    //生成虚拟节点
    public static void setPort(String[] realPort, int node) {
        for (int i=0;i<realPort.length;i++){
            long l = FNV1_32(realPort[i]);
            int length = ((1<<16)-1)/ node;//计算平均步长
            for(int j = 0; j< node; j++){
                l +=  new Random().nextInt(length);//随机步长

                virtual.put(l,realPort[i]+"虚拟节点"+j);
            }
        }
    }

    //获取真实节点
    public static String getPort(String data) {
        long hash = ConsisHash.FNV1_32(data);
        //SortMap tailMap（Object fromkey ,boolean inclusive）:返回该Map的子Map
        // ，其key范围大于fromkey（是否包括取决于第二个参数）的所有key。
        SortedMap<Long,String> sortedMap = virtual.tailMap(hash); //找大于hash的子树
        //sortmap api :Object firstKey():返回最小key，如果为空，则返回null。
        long k =sortedMap.firstKey();//选取最小值
        String nodeName =sortedMap.get(k);//取value,存到该节点
        return nodeName.substring(0,4);//切割
    }

    public static void main(String[] args) throws UnsupportedEncodingException, NoSuchAlgorithmException {

        setPort(new String[]{"8080","8081","8082","8083"}, 10000);
//        System.out.println(ConsisHash.getPort(EncoderByMd5(1 + "")));;
       /* for (Map.Entry<Long,String> m : virtual.entrySet()){
        System.out.println("虚拟节点创建情况：\n"+m.getKey()+" "+m.getValue());}*/
        int zero,one,two,three;
        zero=one=two=three=0;
        for (int i =1;i<100000;i++){//i相当于数据
            switch (ConsisHash.getPort(EncoderByMd5(i+""))){
                case "8080":zero++;break;
                case "8081":one++;break;
                case "8082":two++;break;
                case "8083":three++;
            }
        }
        System.out.println(zero+" "+one+" "+two+" "+three+" ");
    }
}
