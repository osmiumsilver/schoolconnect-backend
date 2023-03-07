package com.osmium.schoolconnect.backend.utils.annotations;

import org.springframework.security.access.prepost.PreAuthorize;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Author Abel
 * @Date 2023/3/5
 * @Description 超管权限 SUPER ACCESS 上帝模式哈哈
 */
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@PreAuthorize(value = "hasAnyAuthority('[SUPER]')")
public @interface SuperAccess {
}
