package com.osmium.schoolconnect.backend.utils;

import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

@Data
@ToString
public class Result<T> implements Serializable {

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

   public Result(T data)
   {
       this.code = ResultCode.SUCCESS.getCode();
       this.msg = ResultCode.SUCCESS.getMessage();
       this.data = data;
   }
    protected Result(StatusCode status,T data) {
        this.code = status.getCode();
        this.msg =status.getMessage();
        this.data = data;
    }

    protected Result(StatusCode status)
    {
        this.code = status.getCode();
        this.msg = status.getMessage();
        this.data = null;
    }
    @JsonIgnore
    public boolean isSuccess() {
        return StringUtils.equals(this.code, ResultCode.SUCCESS.getCode());
    }

    public String success() {
        return ResultCode.SUCCESS.getCode();
    }


}
