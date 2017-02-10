package com.lakefarm.mapper;

import com.lakefarm.pojo.Employee;
import com.lakefarm.pojo.User;
import com.lakefarm.pojo.User_employee;

/**
 * Created by hadoop on 17-2-4.
 */
public interface EmployeeMapper {
    /**asm-3.3.1.jar aspectjtools.jar cglib-2.2.2.jar ehcache-core-2.6.5.jar fastjson-1.2.5.jar
     * mybatis-ehcache-1.0.2.jar
     javassist-3.17.1-GA.jar
     log4j-core-2.0.2.jar
     javax.inject-1.jar
     junit-4.9.jar
     mysql-connector-java-5.1.7-bin.jar
     org.aspectj.matcher.jar
     spring-framework-bom-3.2.9.RELEASE.jar
     spring-instrument-3.2.9.RELEASE.jar
     spring-instrument-tomcat-3.2.9.RELEASE.jar
     spring-jms-3.2.9.RELEASE.jar
     spring-struts-3.2.9.RELEASE.jar
     spring-webmvc-portlet-3.2.9.RELEASE.jar
     * 功能说明 ：查询用户金钱
     * @param user
     * @param u_id
     * @return
     * @author hellozepp
     */
    public int findUserMoneyById(String u_id);
    /**
     * 功能说明 ：查询雇农所需金钱
     * @param user
     * @param u_id
     * @return
     * @author hellozepp
     */
    public int findEmpolyeeMoneyById(int e_id);
    /**
     * 功能说明 ：修该用户金钱
     * @param user
     * @param user1
     * @return
     * @author hellozepp
     */
    public void updateUserMoney(User user1);
    /**
     * 功能说明 ：查询用户雇农表是否存在雇农
     * @param user
     * @param user1
     * @return
     * @author hellozepp
     */
    public int findUser_employeeIsExists(String u_id);
    /**
     * 功能说明 ：查询雇农基础信息
     * @param user
     * @param user1
     * @return
     * @author hellozepp
     */
    public Employee findEmployeeById(int e_id);
    /**
     * 功能说明 ：添加用户-雇农表记录
     * @param user
     * @param user1
     * @return
     * @author hellozepp
     */
    public void insertUser_employee(User_employee ue);

    public String findE_type(int e_id);

    public  int findE_duration(int e_id);
}
