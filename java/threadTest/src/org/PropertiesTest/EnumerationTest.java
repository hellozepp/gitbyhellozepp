package org.PropertiesTest;
        import java.io.File;
        import java.io.FileFilter;
        import java.io.FileInputStream;
        import java.io.FileNotFoundException;
        import java.io.FileOutputStream;
        import java.io.IOException;
        import java.io.SequenceInputStream;
        import java.util.ArrayList;
        import java.util.Collections;
        import java.util.Enumeration;
        import java.util.List;
        import java.util.Properties;

/**
 * Created by hadoop on 16-8-13.
 */
public class EnumerationTest {
    /**
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {

        File partsDir = new File("E:\\PartFiles");

        mergerFile(partsDir);
    }

    public static void mergerFile(File partsDir) throws IOException {

		/*
		 * 虽然合并成功，问题如下：
		 * 1，如何明确碎片的个数，来确定循环的次数，以明确要有多少个输入流对象。
		 * 2，如何知道合并的文件的类型。
		 * 解决方案：应该先读取配置文件。
		 */
        //1,获取配置文件。
        File configFile = getConfigFile(partsDir);

        //2,获取配置文件信息容器。获取配置信息的属性集。
        Properties prop = getProperties(configFile);

        //3,将属性集对象传递合并方法中。
        merge(partsDir,prop);
    }


    //根据配置文件获取配置信息属性集。
    private static Properties getProperties(File configFile) throws IOException {
        FileInputStream fis = null;
        Properties prop = new Properties();
        try{
            //读取流和配置文件相关联。
            fis = new FileInputStream(configFile);
            //将流中的数据加载的集合中。
            prop.load(fis);
        }finally{
            if(fis!=null){
                try{
                    fis.close();
                }catch(IOException e){
                    //写日志，记录异常信息。便于维护。
                }
            }
        }
        return prop;
    }


    //根据碎片目录获取配置文件对象。
    private static File getConfigFile(File partsDir) {

        if(!(partsDir.exists() &&partsDir.isDirectory())){
            throw new RuntimeException(partsDir.toString()+",不是有效目录");
        }

        //1,判断碎片文件目录中是否存在properties文件。使用过滤器完成。
        File[] files = partsDir.listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {

                return pathname.getName().endsWith(".properties");
            }
        });

        if(files.length!=1){
            throw new RuntimeException("properties扩展名的文件不存在，或不唯一");
        }


        File configFile = files[0];
        return configFile;
    }



    private static void merge(File partsDir,Properties prop) throws FileNotFoundException,
            IOException {

        //获取属性集中的信息。
        String filename = prop.getProperty("filename");
        int partCount = Integer.parseInt(prop.getProperty("partcount"));



        //使用io包中的SequenceInputStream，对碎片文件进行合并，将多个读取流合并成一个读取流。
        List<FileInputStream> list = new ArrayList<FileInputStream>();

        for (int i = 1; i < partCount; i++) {
            list.add(new FileInputStream(new File(partsDir, i + ".part")));
        }

        //怎么获取枚举对象呢？List自身是无法获取枚举Enumeration对象的，考虑到Collections中去找。
        Enumeration<FileInputStream> en = Collections.enumeration(list);

        //源。
        SequenceInputStream sis = new SequenceInputStream(en);

        //目的。
        FileOutputStream fos = new FileOutputStream(new File(partsDir,filename));

        //不断的读写。
        byte[] buf = new byte[4096];
        int len = 0;
        while((len=sis.read(buf))!=-1){
            fos.write(buf,0,len);
        }

        fos.close();
        sis.close();
    }

}
