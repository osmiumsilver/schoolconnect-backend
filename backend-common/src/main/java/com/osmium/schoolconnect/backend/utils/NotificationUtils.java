package com.osmium.schoolconnect.backend.utils;

import cn.hutool.json.JSONUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.osmium.schoolconnect.backend.entity.NotificationData;
import com.osmium.schoolconnect.backend.entity.WechatResult;
import com.osmium.schoolconnect.backend.entity.WeixinTokenResult;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author
 * @Date 2023/4/18
 * @Description
 */
@Component
public class NotificationUtils {
    public Object sendNotification(String templateId, ObjectNode objectNode) {

        ObjectMapper objectMapper = new ObjectMapper();
        List<String> userOpenIDs = objectMapper.convertValue(objectNode.get("userOpenIDs"), ArrayList.class);
        NotificationData data = objectMapper.convertValue(objectNode.get("data"), NotificationData.class);

        return buildNotification(templateId, userOpenIDs, data);
    }

    public Object sendNotification(String templateId, List<String> userOpenIDs, NotificationData data) {
        return buildNotification(templateId, userOpenIDs, data);
    }

    private Object buildNotification(String templateId, List<String> userOpenIDs, NotificationData data) {
        WeixinTokenResult result = JSONUtil.toBean(WeChatBackendUtils.getAccessToken(), WeixinTokenResult.class);
        var statusMap = new HashMap<String, Integer>();
        for (String openID : userOpenIDs) {
            WechatResult status = WeChatBackendUtils.sendNotification(result.getAccess_token(), templateId, openID, data, "developer");
            if (!status.getErrcode().equals("0")) {
                statusMap.put(openID, 1);
            } else statusMap.put(openID, 0);
        }
        List<String> usersWhoFailedSending = new ArrayList<String>();

        for (Map.Entry<String, Integer> next : statusMap.entrySet()) {
            if (next.getValue() == 1)
                usersWhoFailedSending.add(next.getKey());
        }
        if ((!userOpenIDs.isEmpty()) && usersWhoFailedSending.isEmpty())
            return true;
        else return usersWhoFailedSending;
    }
}
