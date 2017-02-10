package org.Collection.mapandset;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 * Created by hadoop on 16-9-23.
 * 1.乱序
 * 2.没有Iterator 迭代器
 * 3.独有 ketSet entrySet   (set 集合保证唯一性)
 */
public class TreeMapSimale {
    public static void main(String[] args) {
        Map<String,String> map =new TreeMap<>();
        map.put("1","Mon");
        map.put("2","Mon");
        map.put("3","Mon");
        map.put("3","Mon");
        map.put("4","Mon");
        map.put("5","Mon");
        map.put("6","Mon");
        map.put("0","Mon");
        String s =map.remove("星期一");//返回v
        String s1 =map.remove("星期一");
        System.out.println("删了一个——"+s);
        System.out.println("又删了一个——"+s1);
        System.out.println("又删了一个——"+map.remove("星期五"));
        System.out.println(map.size());
        System.out.println("=++++++++++++++++++++++++++=");
        System.out.println("获取map所有的单列 ：");
        Set<String> set =map.keySet();
        for(Iterator it =set.iterator();it.hasNext();){
            System.out.println(it.next());
        }
        System.out.println("=++++++++++++++++++++++++++=");
        System.out.println("直接打印map.keySet()为："+set);
        System.out.println("直接打印map为："+map);
        System.out.println("直接打印map.entrySet()为："+map.entrySet());
        System.out.println("=++++++++++++++++++++++++++=");
        System.out.println("如果不对元素进行操作，可以foreach,否则.ConcurrentModificationException");
        for (String key :set){
           String value= map.get(key);
            System.out.println(key+" "+value);
        }
        System.out.println("=++++++++++++++++++++++++++=");
        System.out.println("获取映射关系的集合");//Map.Entry结婚证 me.getKey()获得丈夫 me.getValue();获得妻子//太麻烦，不好用
//        Set<Map.Entry<String,String>> me1=map.entrySet();//将映射的内部类对象存储到set方便迭代
        for(Iterator<Map.Entry<String,String>> it =map.entrySet().iterator();it.hasNext();){//迭代器存放me类型数据//entry为内部接口
            Map.Entry<String, String> me=it.next();
            String key =me.getKey();
            String value =me.getValue();
            System.out.println(key+"   "+value);
        }
        System.out.println("=+++++++++++简化+++++++++++=");//不能进行增删操作
        for (Map.Entry<String,String> me :map.entrySet()){
            System.out.println(me.getKey()+"  "+me.getValue());
        }
    }
}
