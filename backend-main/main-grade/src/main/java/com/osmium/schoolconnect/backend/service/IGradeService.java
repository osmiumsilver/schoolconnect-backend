package com.osmium.schoolconnect.backend.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.osmium.schoolconnect.backend.entity.Grade;
import com.osmium.schoolconnect.backend.entity.vo.GradeVO;

import java.util.List;

/**
 * <p>
 * 成绩表 服务类
 * </p>
 *
 * @author abel
 * @since 2023-01-12
 */
public interface IGradeService extends IService<Grade> {
List<GradeVO> listGradeByUserId(String userId, String year, String semester);
//List<GradeVO> findGradeByClazz(String clazzId,String year,String semester);

}