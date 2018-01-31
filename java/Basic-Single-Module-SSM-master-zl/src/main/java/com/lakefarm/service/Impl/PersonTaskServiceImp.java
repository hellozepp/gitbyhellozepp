package com.lakefarm.service.Impl;

import com.lakefarm.mapper.PersonTasksMapper;
import com.lakefarm.pojo.PersonTask;
import com.lakefarm.service.PersonTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by cxd on 2017/2/14.
 */
@Service
public class PersonTaskServiceImp implements PersonTaskService {
    @Autowired
    private PersonTasksMapper personTasksMapper;
    @Override
    /*
    *增加用户任务
     */
    public int addPersonTask(PersonTask pt) {
        return personTasksMapper.addPersonTask(pt);
    }

    @Override
    /*
    *删除用户任务
     */
    public int deletePersonTask(String u_id, String task_id) {
        return personTasksMapper.deletePersonTask(u_id,task_id);
    }

    @Override
    /*
    *更新用户任务
     */
    public int updatePersonTask(PersonTask pt) {
        return personTasksMapper.updatePersonTask(pt);
    }

    @Override
    /*
    *通过u_ID获取用户全部任务
     */
    public List<PersonTask> getPersonTaskByUId(String u_id) {
        return personTasksMapper.getPersonTaskByUId(u_id);
    }

    @Override
    /*
    *通过u_ID task_id获取指定的用户任务
     */
    public PersonTask getPersonTaskById(String u_id, String task_id) {
        return personTasksMapper.getPersonTaskById(u_id, task_id);
    }
}
