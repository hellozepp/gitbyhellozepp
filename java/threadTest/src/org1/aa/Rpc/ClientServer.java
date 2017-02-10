package org1.aa.Rpc;
 import java.io.BufferedReader;;
 import java.io.IOException;
 import java.io.InputStreamReader;;
 import java.io.PrintStream;;
 import java.net.Socket;
 public class ClientServer implements City {
      private Socket socket;
      private String ip;
      ClientServer( String ip) throws IOException {
           this.ip=ip;
      }
 public  String  Born(int  city) throws IOException {
     socket=new Socket(ip,30000);
      PrintStream  ps=new PrintStream(socket.getOutputStream());
      ps.println(city);
      ps.flush();
      BufferedReader br=new BufferedReader(new InputStreamReader(socket.getInputStream()));
      String result=br.readLine();
      return result;
    }
   public  String  ResWeather(int city){
      String  result=null;
      ClientServer clientServer = null;
         try {
             clientServer = new ClientServer(ip);
         } catch (IOException e) {
             e.printStackTrace();
         }
       try {
      result= clientServer.Born(city);
         } catch (Exception e) {
             e.printStackTrace();
         }
         return result;

     }
 }