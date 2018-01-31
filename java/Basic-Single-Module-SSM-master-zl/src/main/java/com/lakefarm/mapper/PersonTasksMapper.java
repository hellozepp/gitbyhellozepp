package com.lakefarm.mapper;

import com.lakefarm.pojo.PersonTask;

import java.util.List;

/**
 * Created by cxd on 2017/2/14.
 */
public interface PersonTasksMapper {
    /*
   *增加用户任务
    */
    public int addPersonTask(PersonTask pt);

    /*
    *删除用户任务
     */
    public int deletePersonTask(String u_id, String task_id);

    /*
    *更新用户任务
     */
    public int updatePersonTask(PersonTask pt);

    /*
    *通过uid获取用户全部任务
     */
    public List<PersonTask> getPersonTaskByUId(String u_id);

    /*
    *通过uid taskid 获取指定用户任务
     */
    public PersonTask getPersonTaskById(String u_id, String task_id);
}
