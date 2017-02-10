package org;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.dao.DeptMapper;
import org.entity.Dept;
import org.entity.Dept1;

import java.io.IOException;
import java.io.Reader;
import java.util.List;
import java.util.Map;

/**
 * Created by andilyliao on 17-1-4.
 */
public class TestDEPT {
    public void testDelete() throws IOException {
        String conf = "SqlMapConfig.xml";
        Reader reader =
                Resources.getResourceAsReader(conf);
        //创建SessionFactory对象
        SqlSessionFactoryBuilder sfb =
                new SqlSessionFactoryBuilder();
        SqlSessionFactory sf = sfb.build(reader);
        //创建Session
        SqlSession session = sf.openSession();
        //调用deleteById操作
        session.delete("org.dao.DeptMapper.deleteById",60);
        session.commit();
        //关闭
        session.close();
    }
    public void testFindAll() throws IOException{
        String conf = "SqlMapConfig.xml";
        Reader reader =
                Resources.getResourceAsReader(conf);
        //创建SessionFactory对象
        SqlSessionFactoryBuilder sfb =
                new SqlSessionFactoryBuilder();
        SqlSessionFactory sf = sfb.build(reader);
        //创建Session
        SqlSession session = sf.openSession();
        DeptMapper mapper =
                session.getMapper(DeptMapper.class);
        //调用findAll方法
        List<Dept> list = mapper.findAll();
        for(Dept dept : list){
            System.out.println(dept.getDeptno()+" "
                    +dept.getDname()+" "
                    +dept.getLoc());
        }
        session.close();
    }

    public void testInsert1() throws IOException{
        String conf = "SqlMapConfig.xml";
        Reader reader =
                Resources.getResourceAsReader(conf);
        //创建SessionFactory对象
        SqlSessionFactoryBuilder sfb =
                new SqlSessionFactoryBuilder();
        SqlSessionFactory sf = sfb.build(reader);
        //创建Session
        SqlSession session = sf.openSession();
        DeptMapper mapper =
                session.getMapper(DeptMapper.class);
        //调用findById方法
        Dept dept = new Dept();
        dept.setDeptno(60);
        dept.setDname("testing");
        dept.setLoc("beijing");
        mapper.addDept(dept);
        session.commit();
        //关闭
        session.close();
    }

    public void testDelete1() throws IOException{
        String conf = "SqlMapConfig.xml";
        Reader reader =
                Resources.getResourceAsReader(conf);
        //创建SessionFactory对象
        SqlSessionFactoryBuilder sfb =
                new SqlSessionFactoryBuilder();
        SqlSessionFactory sf = sfb.build(reader);
        //创建Session
        SqlSession session = sf.openSession();
        DeptMapper mapper =
                session.getMapper(DeptMapper.class);
        //调用deleteById方法
        mapper.deleteById(60);
        session.commit();
        //关闭
        session.close();
    }
    public void testFindAll1() throws IOException{
        String conf = "SqlMapConfig.xml";
        Reader reader =
                Resources.getResourceAsReader(conf);
        //创建SessionFactory对象
        SqlSessionFactoryBuilder sfb =
                new SqlSessionFactoryBuilder();
        SqlSessionFactory sf = sfb.build(reader);
        //创建Session
        SqlSession session = sf.openSession();
        //调用findAll方法
        List<Dept> list =
                session.selectList("org.dao.DeptMapper.findAll");
        System.out.println("==============================================");
        for(Dept dept : list){
            System.out.println(dept.getDeptno()+" "
                    +dept.getDname()+" "
                    +dept.getLoc());
        }
        System.out.println("================================================");
        session.close();
    }

    public void testFindById() throws IOException{
        String conf = "SqlMapConfig.xml";
        Reader reader =
                Resources.getResourceAsReader(conf);
        //创建SessionFactory对象
        SqlSessionFactoryBuilder sfb =
                new SqlSessionFactoryBuilder();
        SqlSessionFactory sf = sfb.build(reader);
        //创建Session
        SqlSession session = sf.openSession();
        //调用findById方法
        Dept dept = (Dept)
                session.selectOne("org.dao.DeptMapper.findById",10);
        System.out.println(dept.getDeptno()+" "
                +dept.getDname()+" "
                +dept.getLoc());
        //关闭
        session.close();
    }
    public void testInsert() throws IOException{
        String conf = "SqlMapConfig.xml";
        Reader reader =
                Resources.getResourceAsReader(conf);
        //创建SessionFactory对象
        SqlSessionFactoryBuilder sfb =
                new SqlSessionFactoryBuilder();
        SqlSessionFactory sf = sfb.build(reader);
        //创建Session
        SqlSession session = sf.openSession();
        //调用addDept操作
        Dept dept = new Dept();
        dept.setDeptno(60);
        dept.setDname("testing");
        dept.setLoc("beijing");
        session.insert("addDept",dept);
        session.commit();
        //关闭
        session.close();
    }
    public void test1() throws IOException{
        String conf = "SqlMapConfig.xml";
        Reader reader =
                Resources.getResourceAsReader(conf);
        //创建SessionFactory对象
        SqlSessionFactoryBuilder sfb =
                new SqlSessionFactoryBuilder();
        SqlSessionFactory sf = sfb.build(reader);
        //创建Session
        SqlSession session = sf.openSession();
        List<Map> list = session.selectList("findDepts");
        for(Map map : list){
            System.out.println(map.get("DEPTNO")
                    +" "+map.get("DNAME"));
        }
        session.close();
    }

    public void test2() throws IOException{
        String conf = "SqlMapConfig.xml";
        Reader reader =
                Resources.getResourceAsReader(conf);
        //创建SessionFactory对象
        SqlSessionFactoryBuilder sfb =
                new SqlSessionFactoryBuilder();
        SqlSessionFactory sf = sfb.build(reader);
        //创建Session
        SqlSession session = sf.openSession();
        Map map = (Map)session.selectOne("findDept",10);
        System.out.println(map.get("DEPTNO")
                +" "+map.get("DNAME"));
        session.close();
    }
    public void testFindPage() throws IOException{
        String conf = "SqlMapConfig.xml";
        Reader reader =
                Resources.getResourceAsReader(conf);
        //创建SessionFactory对象
        SqlSessionFactoryBuilder sfb =
                new SqlSessionFactoryBuilder();
        SqlSessionFactory sf = sfb.build(reader);
        //创建Session
        SqlSession session = sf.openSession();

        int offset = 0;//起点,从0开始
        int limit = 1;//查几条
        RowBounds rowBounds = new RowBounds(offset, limit);
        List<Dept> list =
                session.selectList("org.dao.DeptMapper.findAll",null,rowBounds);
        System.out.println("----------------------------------------------------");
        for(Dept dept : list){
            System.out.println(dept.getDeptno()+" "
                    +dept.getDname()+" "
                    +dept.getLoc());
        }
        System.out.println("----------------------------------------------------");
        session.close();
    }
    public void testFindAll2() throws IOException{
        String conf = "SqlMapConfig.xml";
        Reader reader =
                Resources.getResourceAsReader(conf);
        //创建SessionFactory对象
        SqlSessionFactoryBuilder sfb =
                new SqlSessionFactoryBuilder();
        SqlSessionFactory sf = sfb.build(reader);
        //创建Session
        SqlSession session = sf.openSession();
        DeptMapper mapper =
                session.getMapper(DeptMapper.class);
        //调用findAll方法
        List<Dept1> list = mapper.findAll1();
        for(Dept1 dept : list){
            System.out.println(dept.getNo()+" "
                    +dept.getName()+" "
                    +dept.getLoc());
        }
        session.close();
    }
    public void testUpdate() throws IOException{
        String conf = "SqlMapConfig.xml";
        Reader reader =
                Resources.getResourceAsReader(conf);
        //创建SessionFactory对象
        SqlSessionFactoryBuilder sfb =
                new SqlSessionFactoryBuilder();
        SqlSessionFactory sf = sfb.build(reader);
        //创建Session
        SqlSession session = sf.openSession();
        //调用findById操作
        Dept dept = (Dept)
                session.selectOne("org.dao.DeptMapper.findById",60);
        dept.setDname("开发部");
        dept.setLoc("北京");
        //调用updateDept操作
        session.update("updateDept",dept);
        session.commit();
        //关闭
        session.close();
    }
    public void testSqlSesseion() throws IOException{
        String conf = "SqlMapConfig.xml";
        Reader reader =
                Resources.getResourceAsReader(conf);
        //创建SessionFactory对象
        SqlSessionFactoryBuilder sfb =
                new SqlSessionFactoryBuilder();
        SqlSessionFactory sf = sfb.build(reader);
        //创建Session
        SqlSession session = sf.openSession();

        System.out.println(session);

        //关闭Session
        session.close();
    }
    public static void main(String[] args) throws IOException {
        TestDEPT testDEPT=new TestDEPT();
        testDEPT.testInsert();
        testDEPT.testDelete();//
        testDEPT.testInsert1();
        testDEPT.testUpdate();//
        testDEPT.testDelete1();
        testDEPT.testFindAll();
        testDEPT.testFindAll1();
        testDEPT.testFindAll2();
        testDEPT.testFindById();
        testDEPT.testFindPage();
        testDEPT.test1();
        testDEPT.test2();
        testDEPT.testSqlSesseion();

    }
}
