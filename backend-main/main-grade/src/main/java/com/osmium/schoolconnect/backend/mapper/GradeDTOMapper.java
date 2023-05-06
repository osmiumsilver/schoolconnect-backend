package com.osmium.schoolconnect.backend.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.osmium.schoolconnect.backend.entity.pojo.GradeDTO;
import org.apache.ibatis.annotations.Update;

/**
 * @Author
 * @Date 2023/5/6
 * @Description
 */
public interface GradeDTOMapper extends BaseMapper<GradeDTO> {
    @Update("UPDATE schoolconnect.t_grade t SET t.grade = #{grade},t.awaiting_revision=#{revision} WHERE t.id LIKE #{id} ESCAPE '#'")
    Integer updateGradeAndRevision(String id,Double grade, Byte revision);
}
