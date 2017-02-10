package com.lakefarm.mapper;

import com.lakefarm.entity.Employee;
import com.lakefarm.entity.User;
import com.lakefarm.entity.User_employee;

/**
 * Created by hadoop on 17-2-4.
 */
public interface EmployeeMapper {
    /**
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
    public User_employee findUser_employeeIsExists(String u_id);
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

}
