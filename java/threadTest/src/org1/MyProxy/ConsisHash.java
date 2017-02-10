package org1.MyProxy;

import java.util.Map;
import java.util.Random;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.*;

/**
 * Created by hadoop on 16/11/20.
 *  hash算法的意义在于提供了一种快速存取数据的方法,它用一种算法建立键值与真实值之间的对应关系
 *  ,(每一个真实值只能有一个键值,但是一个键值可以对应多个真实值),这样可以快速在数组等条件中里面存取数据.　
 *
 *  怎么应该是(0,20)呢？应该是(0,19)。
 Java API里说明了这个函数是[0,20)的关系，包含0，不包含20.
 */
public class ConsisHash {
    static SortedMap<Long,String> virtualServer =new TreeMap<>();

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

        // 如果算出来的值为负数则取其绝对值
        if (hash < 0)
            hash = Math.abs(hash);
        return hash;
    }
    //生成虚拟节点
    public static void setPort(String[] realPort) {
        for (int i=0;i<realPort.length;i++){
            //随机生成虚拟节点数
            // %用rem（取余）时，不管“除数”是正是负，“余数”的符号与“被除数”的符号相同
            //    mod和除数相等
            int max =64; int min =20;
            Random random =new Random();
            int quantityNode =random.nextInt(max)%(max-min+1) + min;//随机生成节点数
            System.out.println("步长为="+quantityNode);
            Long length = (long)( Math.pow(2,32)/quantityNode);//计算步长
            for(int j=0;j<quantityNode;j++){
                virtualServer.put(FNV1_32(realPort[i])+length,realPort[i]+"虚拟节点");
            }
        }
    }

    //获取真实节点
    public static String getPort(String data) {
        long hashPort =ConsisHash.FNV1_32(data);
        //SortMap tailMap（Object fromkey ,boolean inclusive）:返回该Map的子Map，其key范围大于fromkey（是否包括取决于第二个参数）的所有key。
        SortedMap<Long,String> hashMap = virtualServer.tailMap(hashPort); //找大于hashPort的子树
        //、Object firstKey():返回最小key，如果为空，则返回null。
        long nodeValue =hashMap.firstKey();//选取最小值
        String nodeName =hashMap.get(nodeValue);//取值
        return nodeName.substring(0,4);//切割
    }

//    public static void main(String[] args) {
//
//        setPort(new String[]{"8080","8081","8082","8083"});
//        System.out.println("虚拟节点创建情况：\n"+virtualServer);
//        for (int i =1;i<10000000;i++){
//            System.out.println(i+"当前服务的节点为："+ConsisHash.getPort(i+""));
//        }
//    }
}
