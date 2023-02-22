package com.osmium.schoolconnect.backend.misc;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author Abel www.osmium.com
 * @Date 2023/2/26
 * @Description 角色代码变换
 */
@AllArgsConstructor
@Getter
public enum AuthorityCode implements GrantedAuthority {
    ROLE_SUPER(0),
    ROLE_ADMINISTRATIVE(1),
    ROLE_TEACHER(2),
    ROLE_STUDENT(3),
    ROLE_OTHER_STAFF(4);
    //ROLE_GUEST("5","来宾"); 没用

    private final int code;


    // 超级新的写法 超有趣的哈哈
    private static final Map<Integer,AuthorityCode> lookup = new HashMap<>();

    static {
        for(AuthorityCode s : EnumSet.allOf(AuthorityCode.class))
            lookup.put(s.getCode(), s);
    }

    public static AuthorityCode get(int code) {
        return lookup.get(code);
    }

    @Override //别的类如果要用GrantedAuthority 这个方法是给他们用的
    public String getAuthority() {
        return String.valueOf(lookup.get(AuthorityCode.get(code)));
    }

}
