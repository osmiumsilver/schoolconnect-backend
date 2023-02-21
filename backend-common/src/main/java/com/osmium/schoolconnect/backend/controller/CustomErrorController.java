package com.osmium.schoolconnect.backend.controller;

import com.osmium.schoolconnect.backend.config.GlobalResponseExceptionHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author
 * @Date 2023/2/8
 * @Description
 */
@RestController
    public class CustomErrorController implements ErrorController {

        private final GlobalResponseExceptionHandler globalExceptionHandler;
    @Autowired
    public CustomErrorController(GlobalResponseExceptionHandler globalExceptionHandler) {
        this.globalExceptionHandler = globalExceptionHandler;
    }

    // 宣告一個 @RequestMapping，並直接將 Exception 導向 GlobalExceptionHandler
    //    @RequestMapping("/error")
    //    public Result<Object> handleError(HttpServletRequest request) {
    //        Exception exception = (Exception) request.getAttribute(RequestDispatcher.ERROR_EXCEPTION);
    //        return globalExceptionHandler.defaultErrorHandler(request, exception);
    //    }

}
