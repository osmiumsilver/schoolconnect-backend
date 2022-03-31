package com.osmium.java.schoolconnect.backend.utils;

/**
 * @author
 * @date 2022/3/30
 * @apinote
 */

import lombok.Data;

import java.util.HashMap;
import java.util.Map;
@Data
public class Action {
    private int status; // 200为 成功,其他 为失败
    private String message;
    private Map<String, Object> map = new HashMap<>();


    public static Action success() {
        Action result = new Action();
        result.setStatus(200);
        result.setMessage("成功");
        return result;
    }

    public static Action failed() {
        Action result = new Action();
        result.setStatus(202);
        result.setMessage("失败");
        return result;
    }

    public Action add(String key, Object value) {
        this.map.put(key, value);
        return this;
    }
}
