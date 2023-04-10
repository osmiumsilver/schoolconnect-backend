package com.osmium.schoolconnect.backend.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.osmium.schoolconnect.backend.entity.CampaignInfo;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Author
 * @Date 2023/2/28
 * @Description
 */
public interface CampaignInfoMapper extends BaseMapper<CampaignInfo> {
    @Select("select * from t_campaign_info JOIN t_campaign_attendee ON t_campaign_attendee.campaign_id = t_campaign_info.id  WHERE t_campaign_attendee.attendee_id = #{user} AND t_campaign_info.campaign_status = #{status}")
    List<CampaignInfo> listCampaignsUserSignedUpFor(String user,Integer status);
}
