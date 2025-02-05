package com.example.springbootacg.dto;

import com.example.springbootacg.common.constant.MsgCodeEnum;

import java.io.Serializable;

public class Result<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    private Boolean success;
    private String code;
    private String msg;
    private T data;

    public Result() {

    }
    public Result(T data, MsgCodeEnum msgCodeEnum) {
        this(data, msgCodeEnum, true);
    }
    public Result(T data, MsgCodeEnum msgCodeEnum, Boolean success) {
        this.data = data;
        this.code = msgCodeEnum.getCode();
        this.msg = msgCodeEnum.getMsg();
        this.success = success;
    }
    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
