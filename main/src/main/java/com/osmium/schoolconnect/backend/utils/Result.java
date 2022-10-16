package com.osmium.schoolconnect.backend.utils;

import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;
import lombok.ToString;

import java.io.Serializable;
import java.util.Objects;

@ToString
public class Result<T> implements Serializable {
    public static final String CODE_SUCCESS = "0000";
    public static final String SUCCESS_MESSAGE = "success";

    private static final long serialVersionUID = 4418416282894231647L;
    @ApiModelProperty(value = "提示代码")
    private String code;
    @ApiModelProperty(value = "提示信息")
    private String msg;
    @ApiModelProperty(value = "返回数据")
    private T data;

    protected Result() {/*for util method*/}

    protected Result(String code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    private static final Result SUCCESS = new ConstantResult(CODE_SUCCESS, SUCCESS_MESSAGE);

    @Override
    public boolean equals(Object another) {
        if (another == null || !(another instanceof Result)) return false;
        return Objects.equals(this.code, ((Result<?>) another).code);
    }

    @JsonIgnore
    public boolean isSuccess() {
        return StringUtils.equals(this.code, CODE_SUCCESS);
    }

    public static <T> Result success() {
        return SUCCESS;
    }

    public static <T> Result success(T data) {
        return new Result(CODE_SUCCESS, SUCCESS_MESSAGE, data);
    }

    public T getData() {
        return data;
    }

    public String getMsg() {
        return msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public void setData(T data) {
        this.data = data;
    }

    /**
     * 作为常量，不允许改变值
     */
    private static class ConstantResult extends Result {
        private static final long serialVersionUID = 1L;

        public ConstantResult(String errcode, String msg) {
            super(errcode, msg, null);
        }

        @Override
        public void setCode(String code) {
            throw new IllegalArgumentException();
        }

        @Override
        public void setMsg(String msg) {
            throw new IllegalArgumentException();
        }

        @Override
        public void setData(Object data) {
            throw new IllegalArgumentException();
        }
    }
}
