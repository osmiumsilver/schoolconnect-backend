package com.osmium.schoolconnect.backend.utils.annotations;

import org.springframework.security.access.prepost.PreAuthorize;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Author Abel
 * @Date 2023/3/5
 * @Description 教师限制访问注解
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@PreAuthorize(value = "hasAnyAuthority('[TEACHER]')" + "and authentication.principal.equals(#userId) ")
public @interface TeacherOnlyAccess {
}
