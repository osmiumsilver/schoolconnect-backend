package com.osmium.schoolconnect.backend.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.osmium.schoolconnect.backend.entity.CampaignAttendee;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * @Author
 * @Date 2023/2/28
 * @Description
 */
public interface CampaignAttendeeMapper extends BaseMapper<CampaignAttendee> {
    @Select("select t_campaign_info.*,t_campaign_info_pics.picture_url from t_campaign_info JOIN t_campaign_attendee ON t_campaign_attendee.campaign_id=t_campaign_info.id LEFT OUTER JOIN t_campaign_info_pics ON t_campaign_info_pics.campaign_id= t_campaign_info.id WHERE t_campaign_attendee.attendee_id = #{userId} AND t_campaign_info.campaign_status=#{status}")
    List<String> listCampaignsById(String userId,String status);

@Update("UPDATE schoolconnect.t_campaign_attendee t SET t.check_in_status = #{i} WHERE t.id LIKE #{attendantsId} ESCAPE '#'")
    Boolean updateCheckInStatus(String attendantsId, int i);
}
