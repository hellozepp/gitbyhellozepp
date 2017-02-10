package org1.aa.Rpc;

public class
MyCity implements City {
      int result=1;
public int  ResWeather1(int city){
      if((city-1)!=0) {
            result =result*city;
      ResWeather1(city-1);
}
return result;
        }

      @Override
      public String ResWeather(int city) {
            return "OK";
      }
}