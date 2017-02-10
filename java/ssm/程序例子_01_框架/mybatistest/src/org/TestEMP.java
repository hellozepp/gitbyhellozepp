package org;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.entity.Emp;

import java.io.IOException;
import java.io.Reader;
import java.sql.Date;
import java.util.List;

/**
 * Created by andilyliao on 17-1-4.
 */
public class TestEMP {
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
        session.delete("deleteById",15);
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
        //调用findAll方法
        List<Emp> list =
                session.selectList("findAll");
        for(Emp e : list){
            System.out.println(e.getEmpno() +" "+e.getEname()+" "+e.getJob()+" "+e.getMgr()
                    +" "+e.getHiredate()+" "+e.getSal()+" "+e.getComm()+" "+e.getDeptno());
        }
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
        Emp e = (Emp)
                session.selectOne("findById",1);
        System.out.println(e.getEmpno() +" "+e.getEname()+" "+e.getJob()+" "+e.getMgr()
                +" "+e.getHiredate()+" "+e.getSal()+" "+e.getComm()+" "+e.getDeptno());
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
        //调用addEmp操作
        Emp emp = new Emp();
        emp.setEmpno(15);
        emp.setEname("jim");
        emp.setJob("sales");
        emp.setMgr(2);
        emp.setHiredate(new Date(System.currentTimeMillis()));
        emp.setSal(1000.00);
        emp.setComm(200.00);
        emp.setDeptno(30);
        session.insert("addEmp",emp);
        session.commit();
        //关闭
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
        Emp emp =(Emp)session.selectOne("findById",15);
        emp.setEname("tom");
        emp.setJob("sales");
        emp.setMgr(2);
        emp.setHiredate(new Date(System.currentTimeMillis()));
        emp.setSal(1000.00);
        emp.setComm(200.00);
        emp.setDeptno(30);
        //调用updateDept操作
        session.update("updateEmp",emp);
        session.commit();
        //关闭
        session.close();
    }
    public static void main(String[] args) throws IOException {
        TestEMP testEMP =new TestEMP();
        testEMP.testDelete();
        testEMP.testInsert();
        testEMP.testFindAll();
        testEMP.testFindById();
        testEMP.testUpdate();
        testEMP.testDelete();

    }
}
