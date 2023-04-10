package com.osmium.schoolconnect.backend.misc;

import com.osmium.schoolconnect.backend.utils.annotations.NotControllerResponseAdvice;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.MyBatisSystemException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.data.redis.RedisConnectionFailureException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.jdbc.BadSqlGrammarException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.oauth2.server.resource.InvalidBearerTokenException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.net.SocketTimeoutException;
import java.sql.SQLSyntaxErrorException;
import java.time.format.DateTimeParseException;

/**
 * @Author Abel
 * @Date 2023/2/5
 * @Description
 */

@RestControllerAdvice
@Slf4j
public class GlobalResponseExceptionHandler extends ResponseEntityExceptionHandler {
    @Override
    @NotControllerResponseAdvice
    protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        log.error(ex.getMessage());
        return new ResponseEntity<>(Result.error(ResultCode.PARAM_TYPE_ERR, ex.getLocalizedMessage()), HttpStatusCode.valueOf(405));
    }

    @Override
    @NotControllerResponseAdvice
    protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        log.error(ex.getMessage());
        return new ResponseEntity<>(Result.error(ResultCode.PARAM_BODY_ERR, ex.getLocalizedMessage()), HttpStatusCode.valueOf(400));
    }


    @ExceptionHandler(RedisConnectionFailureException.class)
    public ResponseEntity<Result<String>> redisConnectionFailureException(RedisConnectionFailureException e)
    {
        log.error(e.getMessage());
        return new ResponseEntity<>(Result.error(ResultCode.DB_LOST_CONNECTION),HttpStatusCode.valueOf(521));
    }
    @ExceptionHandler(AccessDeniedException.class)
    public ResponseEntity<Result<String>> accessDeniedException(AccessDeniedException e) {
        log.error(e.getMessage());
        return new ResponseEntity<>(Result.error(ResultCode.AUTH_NO_PERMISSION), HttpStatusCode.valueOf(403));
    }

    @ExceptionHandler(DateTimeParseException.class)
    public ResponseEntity<Result<String>> dateTimeParseException(DateTimeParseException e) {
        log.error(e.getMessage());
        return new ResponseEntity<>(Result.error(ResultCode.SYS_TIME_CONVERSION_ERROR, e.getLocalizedMessage()), HttpStatusCode.valueOf(500));
    }

    //@ExceptionHandler(CJCommunicationsException.class)
    //public Result<String> cJCommunicationsException(CJCommunicationsException exception) {
    //    log.error(exception.getMessage());
    //    return Result.error(ResultCode.DB_LOST_CONNECTION, exception.getLocalizedMessage());
    //}
    @ExceptionHandler(CannotGetJdbcConnectionException.class)
    public ResponseEntity<Result<String>> cannotGetJdbcConnectionException(CannotGetJdbcConnectionException exception) {
        log.error(exception.getMessage());
        return new ResponseEntity<>(Result.error(ResultCode.DB_LOST_CONNECTION, "\n" + exception.getLocalizedMessage()), HttpStatusCode.valueOf(521));
    }
    //弃用
    //@ExceptionHandler(CommunicationsException.class)
    //public Result<String> communicationsException(CommunicationsException exception) {
    //    log.error(exception.getMessage());
    //    return Result.error(ResultCode.REMOTE_SOCKET_TIMEOUT, "\n" + exception.getLocalizedMessage());
    //}

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<Result<String>> dataIntegrityViolationException(DataIntegrityViolationException exception) {
        log.error(exception.getMessage());
        return new ResponseEntity<>(Result.error(ResultCode.DB_INTEGRITY_CONSTRAINT, exception.getLocalizedMessage()), HttpStatusCode.valueOf(409));
    }

    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<Result<String>> nullPointerExceptionHandler(NullPointerException exception) {
        log.error(exception.getMessage());
        return new ResponseEntity<>(Result.error(ResultCode.SYS_FAIL_NULL_POINTER, exception.getLocalizedMessage()), HttpStatusCode.valueOf(500));
    }

    @ExceptionHandler(InternalAuthenticationServiceException.class)
    public ResponseEntity<Result<String>> internalAuthenticationServiceException(InternalAuthenticationServiceException exception) {
        log.error(exception.getMessage());
        return new ResponseEntity<>(Result.error(ResultCode.AUTH_UNKNOWN_ERROR, exception.getLocalizedMessage()), HttpStatusCode.valueOf(500));
    }

    @ExceptionHandler(SQLSyntaxErrorException.class)
    public ResponseEntity<Result<String>> sqlSyntaxErrorException(SQLSyntaxErrorException exception) {
        log.error(exception.getMessage());
        return new ResponseEntity<>(Result.error(ResultCode.DB_SQL_SYNTAX_ERR, exception.getLocalizedMessage()), HttpStatusCode.valueOf(500));
    }

    @ExceptionHandler(BadSqlGrammarException.class)
    public ResponseEntity<Result<String>> badSqlGrammarException(BadSqlGrammarException exception) {
        log.error(exception.getMessage());
        return new ResponseEntity<>(Result.error(ResultCode.DB_SQL_SYNTAX_ERR, exception.getLocalizedMessage()), HttpStatusCode.valueOf(500));
    }


    @ExceptionHandler(DuplicateKeyException.class)
    public ResponseEntity<Result<String>> duplicateKeyException(DuplicateKeyException exception) {
        log.error(exception.getMessage());
        return new ResponseEntity<>(Result.error(ResultCode.DATA_EXISTS, exception.getLocalizedMessage()), HttpStatusCode.valueOf(409));
    }


    @ExceptionHandler(UsernameNotFoundException.class)
    public ResponseEntity<Result<String>> usernameNotFoundException(UsernameNotFoundException exception) {
        log.error(exception.getMessage());
        return new ResponseEntity<>(Result.error(ResultCode.AUTH_NO_SUCH_USER, exception.getLocalizedMessage()), HttpStatusCode.valueOf(401));
    }

    @ExceptionHandler(MyBatisSystemException.class)
    public ResponseEntity<Result<String>> myBatisSystemException(MyBatisSystemException exception) {
        log.error(exception.getMessage());
        return new ResponseEntity<>(Result.error(ResultCode.MYBATIS_ERROR, exception.getLocalizedMessage()),HttpStatusCode.valueOf(521));
    }

    @ExceptionHandler(SocketTimeoutException.class)
    public ResponseEntity<Result<String>> socketTimeoutException(SocketTimeoutException exception) {
        log.error(exception.getMessage());
        return new ResponseEntity<>(Result.error(ResultCode.REMOTE_CONN_TIMEOUT, exception.getLocalizedMessage()),HttpStatusCode.valueOf(521));

    }

    @ExceptionHandler(BadCredentialsException.class)
    public ResponseEntity<Result<String>> badCredentialsException(BadCredentialsException exception) {
        log.error(exception.getMessage());
        return new ResponseEntity<>(Result.error(ResultCode.AUTH_LOGIN_USER_PWD_ERR, exception.getLocalizedMessage()), HttpStatusCode.valueOf(406));
    }

    @ExceptionHandler(InvalidBearerTokenException.class)
    public ResponseEntity<Result<String>> invalidBearerTokenException(InvalidBearerTokenException exception) {
        log.error(exception.getMessage());
        return new ResponseEntity<>(Result.error(ResultCode.AUTH_INVALID, exception.getLocalizedMessage()), HttpStatusCode.valueOf(406));
    }
//弃用
    //@ExceptionHandler(Exception.class)
    //@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    //public Result<JSONObject> exception(Exception e) {
    //    log.error("全局异常信息 ex={}", e.getMessage(), e);
    //    return Result.error(ResultCode.UNKNOWN);
    //}
    @ExceptionHandler(RequestException.class)
    public ResponseEntity<Result<String>> serverExceptionHandler(RequestException e) {
        log.error(e.getMessage(), e);
        return new ResponseEntity<>(Result.error(e.getCode(), e.getMsg(), e.getMessage()), HttpStatusCode.valueOf(406));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Result<String>> defaultErrorHandler(HttpServletRequest request, Object exception) {
        log.error(exception.toString());
        return new ResponseEntity<>(Result.error(ResultCode.RETURN, exception.toString()), HttpStatusCode.valueOf(406));
    }
}