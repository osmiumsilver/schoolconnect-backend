package com.osmium.schoolconnect.backend.utils;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;

/**
 * @Author
 * @Date 2023/2/14
 * @Description
 */
public class UserUtils {
    public static User getLoginUserName() {
        return (User) SecurityContextHolder.getContext().getAuthentication().getDetails();
    }
}
