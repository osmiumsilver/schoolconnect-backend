package com.osmium.schoolconnect.backend.misc;

import cn.hutool.json.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.MyBatisSystemException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.net.SocketTimeoutException;
import java.sql.SQLSyntaxErrorException;

/**
 * @Author Abel
 * @Date 2023/2/5
 * @Description
 */

@RestControllerAdvice
@Slf4j
public class GlobalResponseExceptionHandler extends ResponseEntityExceptionHandler {


    @ExceptionHandler(NullPointerException.class)
    public Result<JSONObject> nullPointerExceptionHandler(NullPointerException exception) {
        log.error(exception.getMessage());
        return Result.error(ResultCode.NULL_POINT);
    }


    @ExceptionHandler(InternalAuthenticationServiceException.class)
    public Result<JSONObject> internalAuthenticationServiceException(InternalAuthenticationServiceException exception) {
        log.error(exception.getMessage());
        return Result.error(ResultCode.AUTH_UNKNOWN_ERROR);
    }

    @ExceptionHandler(SQLSyntaxErrorException.class)
    public Result<JSONObject> sqlSyntaxErrorException(SQLSyntaxErrorException exception) {
        log.error(exception.getMessage());
        return Result.error(ResultCode.DB_SQL_SYNTAX_ERR);
    }


    @ExceptionHandler(DuplicateKeyException.class)
    public Result<JSONObject> duplicateKeyException(DuplicateKeyException exception) {
        log.error(exception.getMessage());
        return Result.error(ResultCode.DATA_EXISTS);
    }


    @ExceptionHandler(UsernameNotFoundException.class)
    public Result<JSONObject> usernameNotFoundException(UsernameNotFoundException exception) {
        log.error(exception.getMessage());
        return Result.error(ResultCode.AUTH_NO_SUCH_USER);
    }

    @ExceptionHandler(MyBatisSystemException.class)

    public Result<JSONObject> myBatisSystemException(UsernameNotFoundException exception) {
        log.error(exception.getMessage());
        return Result.error(ResultCode.DB_SQL_ERR);
    }

    @ExceptionHandler(SocketTimeoutException.class)
    public Result<JSONObject> socketTimeoutException(SocketTimeoutException exception) {
        log.error(exception.getMessage());
        return Result.error(ResultCode.REMOTE_CONN_TIMEOUT);
    }

    @ExceptionHandler(BadCredentialsException.class)
    public Result<JSONObject> badCredentialsException(BadCredentialsException exception) {
        log.error(exception.getMessage());
        return Result.error(ResultCode.AUTH_LOGIN_USER_PWD_ERR);
    }
}