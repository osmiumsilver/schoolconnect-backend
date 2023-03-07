package com.osmium.schoolconnect.backend.utils.annotations;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;

import java.lang.annotation.*;

/**
 * @Author
 * @Date 2023/3/6
 * @Description
 */
@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
@AuthenticationPrincipal(expression = "SecurityContextHolder.getContext().getAuthentication().getName()")
public @interface CurrentUser {

}
