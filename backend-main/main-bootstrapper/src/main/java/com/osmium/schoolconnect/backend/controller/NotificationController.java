package com.osmium.schoolconnect.backend.controller;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.osmium.schoolconnect.backend.utils.NotificationUtils;
import com.osmium.schoolconnect.backend.utils.annotations.AccessIsolation;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.*;

/**
 * @Author
 * @Date 2023/4/16
 * @Description
 */
@RestController
@RequestMapping("/notification")
public class NotificationController {
    private final NotificationUtils notificationUtils;

    public NotificationController(NotificationUtils notificationUtils) {
        this.notificationUtils = notificationUtils;
    }

    @Operation(summary = "根据Id发送通知")
    @AccessIsolation
    @PostMapping("/send/{templateId}")
    public Object sendNotification(@PathVariable(value = "templateId") String templateId, @RequestParam String userId, @RequestBody ObjectNode objectNode) {

        return notificationUtils.sendNotification(templateId, objectNode);
    }

}
