package org.yjg.bean;

import org.springframework.stereotype.Component;

/**
 * Created by LeoAshin on 16/9/7.
 * in 下午10:04
 */
@Component
public class Result {
    //请求返回状态
    private short status;
    //错误码
    private String code;
    //请求返回内容
    private String body;

    public short getStatus() {
        return status;
    }

    public void setStatus(short status) {
        this.status = status;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
