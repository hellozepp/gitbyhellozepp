package com.lakefarm.service.Impl;

import com.lakefarm.mapper.TasksMapper;
import com.lakefarm.pojo.Task;
import com.lakefarm.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by cxd on 2017/2/14.
 */
@Service
public class TaskServiceImp implements TaskService {
    @Autowired
    private TasksMapper tasksMapper;
    @Override
    /*
    *增加任务
     */
    public int addTask(Task t) {
        return tasksMapper.addTask(t);
    }

    @Override
    /*
    *删除任务
     */
    public int deleteTask(String task_id) {
        return tasksMapper.deleteTask(task_id);
    }

    @Override
    /*
    *更新任务
     */
    public int updateTask(Task t) {
        return tasksMapper.updateTask(t);
    }

    @Override
    /*
    *通过类型获取该类型全部任务
     */
    public List<Task> getTaskByType(String task_type) {
        return tasksMapper.getTaskByType(task_type);
    }

    @Override
    /*
    *通过id获取指定任务
     */
    public Task getTaskById(String task_id) {
        return tasksMapper.getTaskById(task_id);
    }
}
