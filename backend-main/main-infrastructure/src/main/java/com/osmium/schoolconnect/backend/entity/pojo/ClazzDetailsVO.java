package com.osmium.schoolconnect.backend.entity.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import com.osmium.schoolconnect.backend.entity.Clazz;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * @Author
 * @Date 2023/2/25
 * @Description
 */
@EqualsAndHashCode(callSuper = true)
@Data
@TableName("v_class_detail")
public class ClazzDetailsVO extends Clazz implements Serializable {
    private String employeeId; //管理人员编号
    private byte role; //0 班主任 1 辅导员
}







