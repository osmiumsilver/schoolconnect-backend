package com.osmium.schoolconnect.backend.utils.annotations;

import org.springframework.security.access.prepost.PreAuthorize;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Author
 * @Date 2023/3/6
 * @Description
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@PreAuthorize(value = "hasRole('ADMINISTRATIVE')")
public @interface AdministrativeAccessOnly {
}
