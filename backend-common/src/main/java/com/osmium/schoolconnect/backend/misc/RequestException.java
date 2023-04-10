package com.osmium.schoolconnect.backend.misc;

import lombok.Getter;

/**
 * @Author
 * @Date 2023/3/1
 * @Description
 */
@Getter
public class RequestException extends RuntimeException {
    private final String code;
    private final String msg;

    // 手动设置异常
    public RequestException(StatusCode statusCode, String message) {
        // message用于用户设置抛出错误详情，例如：当前价格-5，小于0
        super(message);
        // 状态码
        this.code = statusCode.getCode();
        // 状态码配套的msg
        this.msg = statusCode.getMsg();
    }

    // 默认异常使用APP_ERROR状态码
    public RequestException(String message) {
        super(message);
        this.code = ResultCode.RETURN.getCode();
        this.msg = ResultCode.RETURN.getMsg();
    }

    public RequestException(StatusCode statusCode) {
        super(statusCode.getMsg());
        this.code = statusCode.getCode();
        this.msg = statusCode.getMsg();
    }

}
