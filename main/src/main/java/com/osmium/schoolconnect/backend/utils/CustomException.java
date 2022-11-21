package com.osmium.schoolconnect.backend.utils;

/**
 * @Author
 * @Date 2022/11/20
 * @Description
 */
public class CustomException extends RuntimeException {
    private String code;


    public CustomException(String code,String message) {
        super(message);
        this.code = code;
    }
    public CustomException(ResultCode resultCode)
    {
        super(resultCode.getMsg());
        this.code = resultCode.getCode();
    }

    @Override
    public String toString() {
        return "CustomException{" + "code=" + code + ", message=" + this.getMessage() + '}';
    }
}
