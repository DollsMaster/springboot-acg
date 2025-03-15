package springboot.acg.common.enums;

public enum MsgCodeEnum {
    SUCCESS("0","success","成功"),
    FAILL("00001", "fail", "错误"),
    EXCEPTION("00002","exception","异常");

    private String code;
    private String type;
    private String msg;

    MsgCodeEnum(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    MsgCodeEnum(String code, String type, String msg) {
        this.code = code;
        this.type = type;
        this.msg = msg;
    }

    public String getCode() {
        return this.code;
    }
    public String getType() {
        return this.type;
    }
    public String getMsg() {
        return this.msg;
    }
}
