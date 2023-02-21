package com.osmium.schoolconnect.backend.config;

import cn.hutool.json.JSON;
import cn.hutool.json.JSONObject;
import com.mysql.cj.exceptions.CJCommunicationsException;
import com.osmium.schoolconnect.backend.misc.Result;
import com.osmium.schoolconnect.backend.misc.ResultCode;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.MyBatisSystemException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.oauth2.server.resource.InvalidBearerTokenException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
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
public class GlobalResponseExceptionHandler extends ResponseEntityExceptionHandler{


    @Override
    protected ResponseEntity<Object> handleExceptionInternal(Exception ex, Object body, HttpHeaders headers, HttpStatusCode statusCode, WebRequest request) {
        return super.handleExceptionInternal(ex, body, headers, statusCode, request);
    }

    @ExceptionHandler(CJCommunicationsException.class)
    public Result<JSONObject> cJCommunicationsException(CJCommunicationsException exception)
    {
        log.error(exception.getMessage());
        return Result.error(ResultCode.DB_LOST_CONNECTION);
    }


    @ExceptionHandler(NullPointerException.class)
    public Result<JSONObject> nullPointerExceptionHandler(NullPointerException exception) {
        log.error(exception.getMessage());
        return Result.error(ResultCode.SYS_FAIL_NULL_POINTER);
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
    public Result<JSONObject> myBatisSystemException(MyBatisSystemException exception) {
        log.error(exception.getMessage());
        return Result.error(ResultCode.DB_SQL_SYNTAX_ERR);
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

    @ExceptionHandler(InvalidBearerTokenException.class)
    public Result<JSONObject> invalidBearerTokenException(InvalidBearerTokenException exception) {
        log.error(exception.getMessage());
        return Result.error(ResultCode.AUTH_INVALID);
    }
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Result<JSONObject> exception(Exception e) {
        log.error("全局异常信息 ex={}", e.getMessage(), e);
        return Result.error(ResultCode.UNKNOWN);
    }
    //@ExceptionHandler(Exception.class)
    //public Result<JSONObject> defaultErrorHandler(HttpServletRequest request, Exception exception) {
    //    return Result.error();
    //}

}