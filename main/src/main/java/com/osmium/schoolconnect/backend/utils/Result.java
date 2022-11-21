package com.osmium.schoolconnect.backend.utils;


import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.Map;


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


    private Result() {//外接只可以调用统一返回类的方法，不可以直接创建，影刺构造器私有
    }

    private Result(String code, String msg, T data){
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

   public Result(T data) //通用返回成功
   {
       this.code = ResultCode.SUCCESS.getCode();
       this.msg = ResultCode.SUCCESS.getMsg();
       this.data = data;
   }
    // 自定义返回数据
    public Result data(T map) {
        this.setData(map);
        return this;
    }






}
