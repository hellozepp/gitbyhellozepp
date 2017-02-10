import com.lakefarm.entity.Employee;
import com.lakefarm.entity.User;
import com.lakefarm.entity.User_employee;
import com.lakefarm.mapper.EmployeeMapper;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.text.DateFormat;
import java.util.Date;
import java.util.logging.Logger;

/**
 * Created by hadoop on 2017/1/8.
 */
public class EmployeeMapperTest {
    static Logger log = Logger.getLogger(EmployeeMapperTest.class.getName());
    private ApplicationContext applicationContext;
    @Before
    public void setUp() throws Exception {
        applicationContext = new ClassPathXmlApplicationContext("classpath:spring/applicationContext-dao.xml");
    }

    @Test
    public void findUserMoneyById() throws Exception {
        //查询用户金钱
        String u_id="2";
        EmployeeMapper employeeMapper = (EmployeeMapper) applicationContext.getBean("employeeMapper");
        int u_money=employeeMapper.findUserMoneyById(u_id);
        System.out.println();
        Logger.getLogger("==================employeeMapper:"+u_money+"===============");

        //查询雇农所需金钱
        int e_id=2;
        int e_price=employeeMapper.findEmpolyeeMoneyById(e_id);
        System.out.println("===================e_price:"+e_price+"===============");

        //计算余额是否能够购买
        int balance=0;
        if((balance=(u_money-e_price))>=0){
           log.info("this user can pay for the thing...\nthe user balance is:"+balance);

            //获取session用户信息
            User user1 =new User();
            user1.setU_id(u_id);
            user1.setU_money(balance);

            //查询 用户雇农表 是否存在雇农
            User_employee ue;
            ue=employeeMapper.findUser_employeeIsExists(u_id);
            if(null==ue||ue.equals(null)){
            //查询 雇农表 雇农基础信息
            Employee checkedEmployeeInfo =employeeMapper.findEmployeeById(2);
            if(!(checkedEmployeeInfo.equals(null))){
                log.info("查询雇农基础信息");
                //添加 用户-雇农表 记录   VALUES (2,2,'农医师',30,'2017-02-05','2017-03-04',1);
                ue =new User_employee();
                ue.setU_id(user1.getU_id());
                ue.setE_id(2);
                ue.sete_typeid(checkedEmployeeInfo.gete_typeid().toString());
                log.info(checkedEmployeeInfo.gete_typeid()+"++++++++++"+checkedEmployeeInfo.gete_typeid().toString());
                //编码不对
                if(checkedEmployeeInfo.getE_duration()==30){
                ue.setE_duration(30);
                }else ue.setE_duration(-1);//永久
                String currentDate =DateFormat.getDateInstance().format(new Date());
                log.info("获取当前时间："+currentDate);
                ue.setE_starteddate(currentDate);
                ue.setE_enddate(null);
                ue.setE_egrade(1);
                //插入 用户-雇农表 信息
                employeeMapper.insertUser_employee(ue);
                //修该用户金钱
                employeeMapper.updateUserMoney(user1);
                System.out.println("购买成功！");
                //return
                }
                else System.out.println("查询雇农不存在！");//return
            }
            else System.out.println("该用户已经拥有雇农！");//return

        }
        else  log.info("warning:this user can not pay for the thing...");//return
    }
    @Test
    public  void aaa(){
        Date now = new Date();
        DateFormat d1 = DateFormat.getDateInstance();
        System.out.println("获取当前时间："+d1.format(now));

        //下面就可使用log4j
        log.info("info");
//        log.debug("debug");
//        log.error("error");
//        log.warn("warn");

    }
}
