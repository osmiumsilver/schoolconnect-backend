package com.osmium.schoolconnect.backend.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

/**
 * @Author
 * @Date 2023/5/5
 * @Description
 */
@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class RevisionNotification {
    Thing1 thing1;
    Thing2 thing2;

    public RevisionNotification(String name, String msg) {
        this.thing1 = new RevisionNotification.Thing1(name);
        this.thing2 = new RevisionNotification.Thing2(msg);
    }

    @Data
    @AllArgsConstructor
    class Thing1 {
        private String value;

    }

    @Data
    @AllArgsConstructor
    class Thing2 {
        private String value;

    }
}
