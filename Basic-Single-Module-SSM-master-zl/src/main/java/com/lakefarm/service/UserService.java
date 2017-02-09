package com.lakefarm.service;

import com.lakefarm.pojo.User;

import java.util.List;
import java.util.Map;

/**
 * Created by cxd on 2017/2/6.
 */
public interface UserService {
    /**
     * 功能说明 ：用户登录
     * @param user
     * @return
     * @author hpf
     */
    public User login(User UserInfo);

    /**
     * 功能说明 :用户信息分页显示
     * @param map
     * @return
     */
    public List<User> find(Map<String, Object> map);

    /**
     * 功能说明 :获取总记录数
     * @param map
     * @return
     */
    public Long getTotal(Map<String, Object> map);

    /**
     * 功能说明 :添加用户
     * @param user
     * @return
     */
    public int addUser(User userInfo);

    /**
     * 功能说明 :更新用户
     * @param user
     * @return
     */
    public int update(User userInfo);

    /**
     * 功能说明 :删除用户
     * @param user
     * @return
     */
    public int deletebyId(String u_id);
    /**
     * 功能说明 :根据用户名删除
     * @param u_id
     * @return
     */
    public List<User> findByMap(Map<String, Object> map);

    public User getUserById(String u_id);
    /**
     * 功能说明 :根据id查找
     * @param u_id
     * @return
     */
}
