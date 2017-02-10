package org;

/**
     * TODO 取得当前项目的根目录  
     * @author <a href="mailto:pheh.lin@gmail.com">PHeH</a><br>  
     * Created On 2006-12-30 17:15:41  
     */  
    public class Application {
    public static void main(String[] args) {
        Application.getRootPath();
    }
        /**  
         * TODO 获取根目录  
         * @return  
         * @author <a href="mailto:pheh.lin@gmail.com">PHeH</a><br>  
         * Created On 2007-5-10 15:16:21  
         */  
        public static String getRootPath(){   
            //因为类名为"Application"，因此" Application.class"一定能找到   
            String result = Application.class.getResource("Application.class").toString();
            System.out.println(result);
            int index = result.indexOf("WEB-INF");   
            if(index == -1){   
                index = result.indexOf("bin");   
            }   
            result = result.substring(0,index);   
            if(result.startsWith("jar")){   
                // 当class文件在jar文件中时，返回"jar:file:/F:/ ..."样的路径    
                result = result.substring(10);   
            }else if(result.startsWith("file")){   
                // 当class文件在class文件中时，返回"file:/F:/ ..."样的路径    
                result = result.substring(6);   
            }   
            if(result.endsWith("/"))result = result.substring(0,result.length()-1);//不包含最后的"/"   
            return result;   
        }   
    }  

