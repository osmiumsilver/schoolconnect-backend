package com.osmium.schoolconnect.backend.misc;

import lombok.Getter;

@Getter
public enum ResultCode implements StatusCode {

    //GLOBAL
    SUCCESS("200", "请求成功"),
    UNKNOWN("500", "未知错误"),
    RETURN("999", "返回信息"),


    //SYS ERROR
    SYS_FAIL_NULL_POINTER("5001", "系统出错：空指针异常"),
    SYS_NOT_UNIMPLEMENTED("5002", "暂未实现"),
    SYS_TIME_CONVERSION_ERROR("5003", "时间转换错误"),


    //USER REQUEST ERROR
    REQ_TOO_FAST("1002", "请求太快"),
    REQ_TOO_MANY_FAIL("1003", "失败次数太多"),
    REQ_TOO_MANY_REQ("1005", "请求过多"),
    SYS_OPT_LIMIT("1007", "操作频次受限"),

    //REQUEST ERROR
    PARAM_ERR("1101", "参数错误"),
    PARAM_REQUIRED("1102", "参数不能为空"),
    PARAM_TYPE_ERR("1103", "参数类型错误"),
    PARAM_FORMAT_ERR("1104", "参数格式错误"),
    PARAM_BODY_ERR("1105", "请求Body错误"),
    PARAM_BODY_REQUIRED("1106", "请求Body不能为空"),
    PARAM_BODY_FORMAT_ERR("1107", "请求Body格式错误"),
    PARAM_PARSE_ERR("1108", "参数解析错误"),
    PARAM_HEADER_REQUIRED("1109", "请求Header不能为空"),


    // AUTH RESPONSE
    AUTH_UNAUTHORIZED("401", "未授权"),
    AUTH_INVALID("1202", "授权请求不合法"),
    AUTH_NO_PERMISSION("1204", "权限不足"),
    AUTH_LOGIN_FAIL("1205", "授权失败"),
    AUTH_LOGIN_USER_PWD_ERR("1206", "用户名或密码错误"),
    AUTH_PWD_ERR("1215", "密码错误"),
    AUTH_USER_DISABLED("1207", "用户被禁用"),
    AUTH_USER_EXPIRE("1208", "用户过期"),
    AUTH_USER_RESET_PWD("1209", "用户密码需要重置"),
    AUTH_LOGOUT_ERR("1210", "登出失败"),
    AUTH_TOKEN_INVALID("1211", "登录过期或无效"),
    AUTH_USER_LOCKED("1212", "用户被锁定"),
    AUTH_UNKNOWN_ERROR("1213", "授权后台异常"),
    AUTH_NO_SUCH_USER("1214", "没有此用户"),


    //DATA ERROR
    DATA_ERR("1301", "数据错误"),
    DATA_CHECK("1302", "数据校验失败"),
    DATA_NOT_EXISTS("1303", "数据不存在"),
    DATA_EXISTS("1304", "数据已经存在"),
    DATA_NOT_ALLOWED("1305", "数据不允许操作"),
    DATA_NOT_UNIQUE("1307", "数据不唯一"),
    DATA_CHECK_SIGN_ERR("1308", "签名错误"),
    DATA_STATUS_CHECK("1309", "数据状态校验错误"),
    DATA_ALREADY_SUCCESS("1310", "数据已经处理成功"),
    DATA_RES_EXHAUST("1311", "数据资源已用尽"),
    DATA_REQ_REPEAT("1312", "重复请求~"),

    DATA_MANIPULATION_ERROR("1313", "数据操纵错误"),


    // REMOTE ERROR
    REMOTE_ERR("1401", "远程接口失败"),
    REMOTE_CONN_TIMEOUT("1402", "远程接口连接超时"),
    REMOTE_SOCKET_TIMEOUT("1403", "远程接口通讯超时"),
    REMOTE_RES_ERR("1404", "远程接口返回错误"),
    REMOTE_RES_BLANK("1405", "远程接口返回为空"),
    REMOTE_RES_PARSE_ERR("1406", "远程接口返回解析错误"),
    REMOTE_RES_NOT_SUCCESS("1407", "远程接口返回非成功"),
    REMOTE_RES_NO_DATA("1408", "远程接口返回无数据"),
    REMOTE_HTTP_ERR("1409", "远程接口HTTP异常"),


    //DATABASE ERROR

    DB_SQL_SYNTAX_ERR("1501", "数据库SQL执行错误"),
    DB_OPT_LOCK("1502", "乐观锁失败"),
    DB_INTEGRITY_CONSTRAINT("1503", "违反数据库约束(唯一,非空等)"),
    DB_LOST_CONNECTION("1505", "数据库连接失败"),

    GRADE_ADD_ERROR("1601", "成绩添加失败"),
    GRADE_MODIFY_ERROR("1602", "成绩修改失败"),
    GRADE_DELETE_ERROR("1602", "成绩删除失败"),

    MYBATIS_ERROR("1701", "MyBatis 出错");

    private final String code;
    private final String msg;

    ResultCode(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

}
