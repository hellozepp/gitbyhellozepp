package com.lakefarm.controller;

import com.lakefarm.pojo.PersonTask;
import com.lakefarm.pojo.Task;
import com.lakefarm.pojo.User;
import com.lakefarm.service.PersonTaskService;
import com.lakefarm.service.TaskService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by cxd on 2017/2/14.
 */
@Controller
@RequestMapping("/lakeFarm")
public class GetPersonDailyTaskController {
    private static Logger log = Logger.getLogger(GetPersonDailyTaskController.class);
    @Autowired
    private TaskService taskService;
    @Autowired
    private PersonTaskService personTaskService;
    @RequestMapping(value = "/getPersonDailyTask.from", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
    public
    @ResponseBody
    String getPersonDailyTask(HttpServletRequest request, HttpServletResponse response) {
            log.info("获取日常任务---"+"\n");
        try {
            Cookie[] cookies = request.getCookies();
            User user=new User();
            if (cookies != null) {
                for (Cookie c : cookies) {
                    if (c.getName().trim().equals("u_id")) {
                        user.setU_id(c.getValue().trim());//对u_id进行赋值
                    }
                }
                if("".equals(user.getU_id())){
                    return new String("102");//TODO COOKIES失效
                }
                else {
                    //建立映射
                    List<PersonTask> personTasks=personTaskService.getPersonTaskByUId(user.getU_id().trim());//获取用户的全部任务
                    int personTasksSize=personTasks.size();//获取用户全部任务的数量
                    //获取日常任务并返回
                    String result="";
                    for (int i=0;i<personTasksSize;i++){
                        Task task=taskService.getTaskById(personTasks.get(i).getTask_id());
                        if ("daily".equals(task.getTask_type())) {
                            result+="task_type:daily#$@task_name:"+task.getTask_name().trim()+"#$@task_description:"+task.getTask_description().trim()+"#$@task_status:"+personTasks.get(i).getTask_status()+"@@@";
                        }
                    }
                    log.info("\n"+result);
                    return result;
                }
            }
            else {
                return new String("101");//TODO 不存在cookie重新登陆
            }
        } catch (Exception e) {
            log.error("异常错误位置----",e);
            return new String("100"); //TODO 获取用户信息失败
        }
    }
}

