package com.osmium.schoolconnect.backend.utils.annotations;

import org.springframework.security.core.annotation.AuthenticationPrincipal;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

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
