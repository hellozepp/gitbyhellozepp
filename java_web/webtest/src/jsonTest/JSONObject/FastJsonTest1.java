package jsonTest.JSONObject;
import com.alibaba.fastjson.JSONObject;

import java.util.Map;

/**
 * Created by hadoop on 16-8-31.
 * 和前面的一样
 */
public class FastJsonTest1 {
    public static void main(String[] args){
      String jsonFormat ="{\"xingming\":25,\"xiangwang\":13,\"xiaoli\":11}";
        JSONObject jsonObject = JSONObject.parseObject(jsonFormat);
        for(Map.Entry<String,Object> entry:jsonObject.entrySet()){
            System.out.print(entry.getKey()+" : "+entry.getValue()+"\t");
        }

    }
}