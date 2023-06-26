package com.example.springacg.utils;

import com.github.pagehelper.PageInfo;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class ResponseStatus {
    private Integer status;
    private Integer code;
    private String msg;
    private Object result;
    private Long timer;

    public static ResponseStatus start() {
        return new ResponseStatus();
    }
    public static ResponseStatus ok() {
        String msg = "操作成功";
        return new ResponseStatus(200, msg, null, null);
    }
    public static ResponseStatus ok(String msg) {
        return new ResponseStatus(200, msg, null, null);
    }
    public static ResponseStatus ok (String msg, Object result) {
        return new ResponseStatus(200, msg, result, null);
    }
    public static ResponseStatus ok(Object result, PageInfo pageInfo) {
        String msg = "操作成功";
        return new ResponseStatus(200, msg, result, pageInfo);
    }
    public static ResponseStatus ok(String msg, Object result, PageInfo pageInfo) {
        return new ResponseStatus(200, msg, result, pageInfo);
    }
    public static ResponseStatus error(String msg) {
        return new ResponseStatus(500, msg, null, null);
    }
    public static ResponseStatus error(String msg, Object result) {
        return new ResponseStatus(500, msg, result, null);
    }
    public static ResponseStatus error(Integer status, String msg, Object result) {
        return new ResponseStatus(status, msg, result, null);
    }
    private ResponseStatus() {

    }
    private ResponseStatus(Integer status, String message, Object result, PageInfo pageInfo) {
        Object data = null;
        if (pageInfo == null) {
            data = result;
        } else {
            Map map = new HashMap();
            map.put("data", pageInfo.getList());
            map.put("index", pageInfo.getPageNum());
            map.put("size", pageInfo.getSize());
            map.put("total", pageInfo.getTotal());
            data = map;
        }


        this.code = status == 200?0:1;
        this.status = status;
        this.msg = message;
        this.result = data;
        this.timer = new Date().getTime();
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }

    public Long getTimer() {
        return timer;
    }

    public void setTimer(Long timer) {
        this.timer = timer;
    }
}
