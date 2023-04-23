package com.osmium.schoolconnect.backend.utils.annotations;

import org.springframework.security.access.prepost.PreAuthorize;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Author Abel
 * @Date 2023/3/5
 * @Description 限制访问注解（传入参数必须为自己工号，传入他人工号则为空）
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@PreAuthorize(value = "authentication.name.equals(#userId)")
public @interface AccessIsolation {

}
