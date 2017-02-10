package jsonTest.JSONObject;

import com.alibaba.fastjson.JSONObject;

/**
 * Created by hadoop on 16-8-31.
 */
public class FastJsonTest {
    public static void main(String[] args){
        String jsonStr = "{\"JACKIE_ZHANG\":\"张学友\",\"ANDY_LAU\":\"刘德华\",\"LIMING\"" +
                ":\"黎明\",\"Aaron_Kwok\":\"郭富城\"}" ;
        //做100次测试
        for(int i=0,j=100;i<j;i++)
        {
            JSONObject jsonObject = JSONObject.parseObject(jsonStr) ;
            for(java.util.Map.Entry<String,Object> entry:jsonObject.entrySet()){
                System.out.print(entry.getKey()+"-"+entry.getValue()+"\t");
            }
            System.out.println();//用来换行
        }
    }
}