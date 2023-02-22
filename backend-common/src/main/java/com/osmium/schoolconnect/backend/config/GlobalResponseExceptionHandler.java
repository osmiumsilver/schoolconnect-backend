package com.osmium.schoolconnect.backend.config;

import cn.hutool.json.JSONObject;
import com.mysql.cj.exceptions.CJCommunicationsException;
import com.osmium.schoolconnect.backend.misc.Result;
import com.osmium.schoolconnect.backend.misc.ResultCode;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.MyBatisSystemException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.oauth2.server.resource.InvalidBearerTokenException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
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

    @ExceptionHandler(CJCommunicationsException.class)
    public Result<String> cJCommunicationsException(CJCommunicationsException exception) {
        log.error(exception.getMessage());
        return Result.error(ResultCode.DB_LOST_CONNECTION,exception.getLocalizedMessage());
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public Result<String> dataIntegrityViolationException (DataIntegrityViolationException exception) {
        log.error(exception.getMessage());
        return Result.error(ResultCode.DB_INTEGRITY_CONSTRAINT,exception.getLocalizedMessage());
    }
    @ExceptionHandler(NullPointerException.class)
    public Result<String> nullPointerExceptionHandler(NullPointerException exception) {
        log.error(exception.getMessage());
        return Result.error(ResultCode.SYS_FAIL_NULL_POINTER,exception.getLocalizedMessage());
    }

    @ExceptionHandler(InternalAuthenticationServiceException.class)
    public Result<String> internalAuthenticationServiceException(InternalAuthenticationServiceException exception) {
        log.error(exception.getMessage());
        return Result.error(ResultCode.AUTH_UNKNOWN_ERROR,exception.getLocalizedMessage());
    }

    @ExceptionHandler(SQLSyntaxErrorException.class)
    public Result<String> sqlSyntaxErrorException(SQLSyntaxErrorException exception) {
        log.error(exception.getMessage());
        return Result.error(ResultCode.DB_SQL_SYNTAX_ERR,exception.getLocalizedMessage());
    }


    @ExceptionHandler(DuplicateKeyException.class)
    public Result<String> duplicateKeyException(DuplicateKeyException exception) {
        log.error(exception.getMessage());
        return Result.error(ResultCode.DATA_EXISTS,exception.getLocalizedMessage());
    }


    @ExceptionHandler(UsernameNotFoundException.class)
    public Result<String> usernameNotFoundException(UsernameNotFoundException exception) {
        log.error(exception.getMessage());
        return Result.error(ResultCode.AUTH_NO_SUCH_USER,exception.getLocalizedMessage());
    }

    @ExceptionHandler(MyBatisSystemException.class)
    public Result<String> myBatisSystemException(MyBatisSystemException exception) {
        log.error(exception.getMessage());
        return Result.error(ResultCode.DB_SQL_SYNTAX_ERR,exception.getLocalizedMessage());
    }

    @ExceptionHandler(SocketTimeoutException.class)
    public Result<String> socketTimeoutException(SocketTimeoutException exception) {
        log.error(exception.getMessage());
        return Result.error(ResultCode.REMOTE_CONN_TIMEOUT,exception.getLocalizedMessage());
    }

    @ExceptionHandler(BadCredentialsException.class)
    public Result<String> badCredentialsException(BadCredentialsException exception) {
        log.error(exception.getMessage());
        return Result.error(ResultCode.AUTH_LOGIN_USER_PWD_ERR,exception.getLocalizedMessage());
    }

    @ExceptionHandler(InvalidBearerTokenException.class)
    public Result<String> invalidBearerTokenException(InvalidBearerTokenException exception) {
        log.error(exception.getMessage());
        return Result.error(ResultCode.AUTH_INVALID,exception.getLocalizedMessage());
    }

    //@ExceptionHandler(Exception.class)
    //@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    //public Result<JSONObject> exception(Exception e) {
    //    log.error("全局异常信息 ex={}", e.getMessage(), e);
    //    return Result.error(ResultCode.UNKNOWN);
    //}
    @ExceptionHandler(Exception.class)
    public Result<String> defaultErrorHandler(HttpServletRequest request, Exception exception) {
        return Result.error(ResultCode.RETURN, request.toString()+"\n" + exception.getLocalizedMessage());
    }
}