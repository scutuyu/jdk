package com.tuyu.enums;

/**
 * @author tuyu
 * @date 8/7/18
 * Talk is cheap, show me the code.
 */
public enum ErrorCodeEnum {
    SUCCESS("0000", "success"),
    PARAM_EMPTY("1001", "必选参数为空"),
    PARAM_ERROR("1002", "参数格式错误"),
    UNKNOWN_ERROR("9999", "系统繁忙，请稍后再试....");

    private String code;
    private String msg;

    ErrorCodeEnum(String code, String msg) {
        this.code = code;
        this.msg = msg;
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
}
