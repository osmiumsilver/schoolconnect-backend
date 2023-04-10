package com.osmium.schoolconnect.backend.entity;

import cn.hutool.json.JSONObject;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.handlers.FastjsonTypeHandler;
import com.baomidou.mybatisplus.extension.handlers.GsonTypeHandler;
import com.baomidou.mybatisplus.extension.handlers.JacksonTypeHandler;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import lombok.Data;
import org.apache.ibatis.type.ArrayTypeHandler;
import org.apache.ibatis.type.BlobByteObjectArrayTypeHandler;
import org.apache.ibatis.type.BlobTypeHandler;
import org.json.JSONArray;

import java.io.Serial;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.sql.Blob;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Author
 * @Date 2023/2/19
 * @Description
 */
@Data
@TableName(autoResultMap = true,value = "t_class_schedule")
public class ClazzSchedule implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    @TableId
    private String id;
    private String classNo;
private String courseName;
    private String courseNo;
private String coursePlace;
private String courseTeacher;
private byte courseCredits;
    private Integer dayOfWeek;
@TableField(typeHandler = ArrayTypeHandler.class)
    private Object weeks;
    private byte startingPeriod;
private byte lastingPeriods;
    private int year;
    private byte semester;
}
