package com.example.springbootacg.common.constant;

public enum MsgCodeEnum {

    SUCCESS("0", "success", "成功"),
    EXCEPTION("00001", "exception", "异常");

    private String code;
    private String msg;
    private String type;


    MsgCodeEnum(String code, String type, String msg) {
        this.code = code;
        this.msg = msg;
        this.type = type;
    }

    public String getMsg() {
        return msg;
    }

    public String getType() {
        return type;
    }

    public String getCode() {
        return code;
    }
}
