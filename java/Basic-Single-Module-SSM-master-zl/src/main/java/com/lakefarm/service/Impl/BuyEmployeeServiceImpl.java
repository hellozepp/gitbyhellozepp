package com.lakefarm.service.Impl;

import com.lakefarm.pojo.Employee;
import com.lakefarm.pojo.User;
import com.lakefarm.pojo.User_employee;
import com.lakefarm.mapper.EmployeeMapper;
import com.lakefarm.service.BuyEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.DateFormat;
import java.util.Date;
import java.util.logging.Logger;

/**
 * Created by hadoop on 17-2-5.
 */
@Service
public class BuyEmployeeServiceImpl implements BuyEmployeeService {
    static Logger log = Logger.getLogger(BuyEmployeeServiceImpl.class.getName());
    @Resource
    private ApplicationContext applicationContext;

    @Override
    public String BuyEmployee(String u_id, int e_id) {
        log.info("前端控制器响应获取信息为->u_id："+u_id+",e_id:"+String.valueOf(e_id));
        //查询用户金钱
        EmployeeMapper employeeMapper = (EmployeeMapper) applicationContext.getBean("employeeMapper");
        int u_money=employeeMapper.findUserMoneyById(u_id);
        Logger.getLogger("==================employeeMapper:"+u_money+"===============");
        //查询 雇农表 雇农基础信息
//        log.info("查询雇农基础信息");
//        Object checkedEmployeeInfo1 =employeeMapper.findEmployeeById(e_id);
//        log.info(String.valueOf(checkedEmployeeInfo1));
//        log.info(String.valueOf(checkedEmployeeInfo1));
//        Employee checkedEmployeeInfo = (Employee) checkedEmployeeInfo1;
        //TODO 此方法一直是空指针

        //查询雇农所需金钱
        int e_price =employeeMapper.findEmpolyeeMoneyById(e_id);
        log.info("查询雇农所需金钱");
        System.out.println("===================e_price:"+e_price+"===============");

        //计算余额是否能够购买
        log.info("计算余额是否能够购买");
        int balance=0;
        if((balance=(u_money-e_price))>=0){
            log.info("this user can pay for the thing...\nthe user balance is:"+balance);
            //获取session用户信息
            log.info("获取session用户信息");
            User user1 =new User();
            user1.setU_id(u_id);
            user1.setU_money(balance);

            //查询 用户雇农表 是否存在雇农
            log.info("查询 用户雇农表 是否存在该用户");

            try {
                Integer  findUser_employeeIsExists=employeeMapper.findUser_employeeIsExists(u_id);
                if(!(findUser_employeeIsExists>0)){
                   return ("该用户已经拥有雇农！");//return
                }else {
                    log.info("不存在该用户购买记录");
                    log.info("将 雇农基础信息 添加 用户-雇农表 ");
                    User_employee ue =new User_employee();
                    ue.setU_id(user1.getU_id());
                    ue.setE_id(e_id);
                    ue.sete_typeid(employeeMapper.findE_type(e_id).toString());
                    if(employeeMapper.findE_duration(e_id)==30){
                        ue.setE_duration(30);
                    }else ue.setE_duration(-1);//永久
                    String currentDate = DateFormat.getDateInstance().format(new Date());
                    log.info("获取当前时间："+currentDate);
                    ue.setE_starteddate(currentDate);
                    ue.setE_enddate(null);
                    ue.setE_egrade(1);
                    //插入 用户-雇农表 信息
                    employeeMapper.insertUser_employee(ue);
                    //修该用户金钱
                    employeeMapper.updateUserMoney(user1);
                    return ("恭喜您，购买成功！");//return
                }
            }catch (Exception e){
                log.info("不存在该用户购买记录");

//                try {
//                    if(!(checkedEmployeeInfo.equals(null) || (null == checkedEmployeeInfo ))){
//                        //添加 用户-雇农表 记录   VALUES (2,2,'农医师',30,'2017-02-05','2017-03-04',1);
//                        log.info("将 雇农基础信息 添加 用户-雇农表 ");
//                        ue =new User_employee();
//                        ue.setU_id(user1.getU_id());
//                        ue.setE_id(checkedEmployeeInfo.getE_id());
//                        ue.sete_typeid(checkedEmployeeInfo.getE_typeid().toString());
//                        log.info(checkedEmployeeInfo.getE_typeid()+"++++++++++"+
//                                checkedEmployeeInfo.getE_typeid().toString());
//                        if(checkedEmployeeInfo.getE_duration()==30){
                //添加 用户-雇农表 记录   VALUES (2,2,'农医师',30,'2017-02-05','2017-03-04',1);
                log.info("将 雇农基础信息 添加 用户-雇农表 ");
                User_employee ue =new User_employee();
                ue.setU_id(user1.getU_id());
                ue.setE_id(e_id);
                ue.sete_typeid(employeeMapper.findE_type(e_id).toString());
                if(employeeMapper.findE_duration(e_id)==30){
                    ue.setE_duration(30);
                }else ue.setE_duration(-1);//永久
                String currentDate = DateFormat.getDateInstance().format(new Date());
                log.info("获取当前时间："+currentDate);
                ue.setE_starteddate(currentDate);
                ue.setE_enddate(null);
                ue.setE_egrade(1);
                //插入 用户-雇农表 信息
                try {
                    employeeMapper.insertUser_employee(ue);// TODO 因为查询后存不存在都会进catch 所以此处有错误，无法解决
                    //修该用户金钱
                    employeeMapper.updateUserMoney(user1);
                    return ("恭喜您，购买成功！");//return
                }catch (Exception e1){
                    return "该用户已经拥有雇农，请勿重复购买！";
                }

//                    }
//                    else{
//                        log.info("查询雇农不存在1");
//                        return ("查询雇农不存在！");//return
//                    }

//                }catch (Exception e){
//                    // TODO java.lang.NullPointerException 根据e_id找不到雇农信息
//                    log.info("查询雇农不存在2");
//                    return ("查询雇农信息不存在！");//return
//                }
            }
        }
        else  return "对不起，您的余额不足...\n剩余金额:"+u_money;// TODO 您的余额不足
    }
}
