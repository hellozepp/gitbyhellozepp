package com.lakefarm.mapper;

import com.lakefarm.pojo.Task;

import java.util.List;

/**
 * Created by cxd on 2017/2/14.
 */
public interface TasksMapper {
    /*
     *增加任务
     */
    public int addTask(Task t);


    /*
    *删除任务
    */
    public int deleteTask(String task_id);

    /*
    *更新任务
    */
    public int updateTask(Task t);

    /*
    *通过类型获取该类型全部任务
    */
    public List<Task> getTaskByType(String task_type);

    /*
    *通过id获取指定任务
    */
    public Task getTaskById(String task_id);
}
