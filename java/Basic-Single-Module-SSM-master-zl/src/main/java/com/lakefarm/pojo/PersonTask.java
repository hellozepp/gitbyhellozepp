package com.lakefarm.pojo;

/**
 * Created by cxd on 2017/2/14.
 */
public class PersonTask {
    private String u_id;
    private String task_id;
    private String task_releaseTime;
    private String task_status;

    public String getTask_status() {
        return task_status;
    }

    public void setTask_status(String task_status) {
        this.task_status = task_status;
    }

    public String getU_id() {
        return u_id;
    }

    public void setU_id(String u_id) {
        this.u_id = u_id;
    }

    public String getTask_id() {
        return task_id;
    }

    public void setTask_id(String task_id) {
        this.task_id = task_id;
    }

    public String getTask_releaseTime() {
        return task_releaseTime;
    }

    public void setTask_releaseTime(String task_releaseTime) {
        this.task_releaseTime = task_releaseTime;
    }
}
