package com.osmium.schoolconnect.backend.controller;

import com.osmium.schoolconnect.backend.misc.GlobalResponseExceptionHandler;
import com.osmium.schoolconnect.backend.misc.Result;
import com.osmium.schoolconnect.backend.misc.ResultCode;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author
 * @Date 2023/2/8
 * @Description
 */
@RestController
public class CustomErrorController implements ErrorController {

    //管理Spring默认Error的处理
    private final GlobalResponseExceptionHandler globalExceptionHandler;

    public CustomErrorController(GlobalResponseExceptionHandler globalExceptionHandler) {
        this.globalExceptionHandler = globalExceptionHandler;
    }

    //宣告一個 @RequestMapping，並直接將 Exception 導向 GlobalExceptionHandler
    @RequestMapping("/error")
    public Result<String> handleError(HttpServletRequest request) {

        Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
        Object exception = request.getAttribute(RequestDispatcher.ERROR_EXCEPTION);
        if (status != null) {
            Integer statusCode = Integer.valueOf(status.toString());

            if (statusCode == HttpStatus.NOT_FOUND.value()) {
                return Result.error(ResultCode.NOT_FOUND);
            } else if (statusCode == HttpStatus.INTERNAL_SERVER_ERROR.value()) {
                return Result.error(ResultCode.UNKNOWN);
            } else if (statusCode == HttpStatus.UNAUTHORIZED.value()) {
                return Result.error(ResultCode.AUTH_UNAUTHORIZED);
            }
        }
        return globalExceptionHandler.defaultErrorHandler(request, exception).getBody();
    }
}
