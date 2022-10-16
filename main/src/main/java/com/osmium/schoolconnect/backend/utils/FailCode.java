package com.osmium.schoolconnect.backend.utils;


public enum FailCode implements IFailResult {

    UNKNOWN("9999", "未知错误"),

    SYS_UNKNOWN("1001", "未知错误"),
    SYS_REQ_TOO_FAST("1002", "请求太快"),
    SYS_FAIL_TOO_MANY("1003", "失败次数太多"),
    SYS_CONCURRENT_REJECT("1005", "请求过多"),
    SYS_NOT_UNIMPLEMENTED("1006", "暂未实现"),
    SYS_OPT_LIMIT("1007", "操作频次受限"),

    // http status code
    HSC_400_INVALID_ARG("4001", "INVALID_ARGUMENT"),
    HSC_400_FAILED_PRECONDITION("4002", "FAILED_PRECONDITION"),
    HSC_400_OUT_OF_RANGE("4003", "OUT_OF_RANGE"),
    HSC_401("4010", "UNAUTHENTICATED"),
    HSC_403("4030", "PERMISSION_DENIED"),
    HSC_403_BASE("4031", "请求拒绝: 基本信息未完善"),
    HSC_403_PHONE("4032", "请求拒绝: 未绑定手机号"),
    HSC_403_REAL("4033", "请求拒绝: 未实名认证"),
    HSC_403_OPERATOR("4034", "请求拒绝: 非操作员"),
    HSC_403_ADMIN("4035", "请求拒绝: 非管理员"),
    HSC_404("4040", "NOT_FOUND"),
    HSC_405("4050", "Not Support Method"),
    HSC_409_ABORTED("4091", "ABORTED"),
    HSC_409_ALREADY_EXISTS("4092", "ALREADY_EXISTS"),
    HSC_429("4290", "RESOURCE_EXHAUSTED"),
    HSC_499("4990", "CANCELLED"),
    HSC_500_DATA_LOSS("5001", "DATA_LOSS"),
    HSC_500_UNKNOWN("5002", "UNKNOWN"),
    HSC_500_INTERNAL("5003", "INTERNAL"),
    HSC_501("5010", "NOT_IMPLEMENTED"),
    HSC_503("5030", "UNAVAILABLE"),
    HSC_504("5040", "DEADLINE_EXCEEDED"),

    PARAM_ERR("1101", "参数错误"),
    PARAM_REQUIRED("1102", "参数不能为空"),
    PARAM_TYPE_ERR("1103", "参数类型错误"),
    PARAM_FORMAT_ERR("1104", "参数格式错误"),
    PARAM_BODY_ERR("1105", "请求Body错误"),
    PARAM_BODY_REQUIRED("1106", "请求Body不能为空"),
    PARAM_BODY_FORMAT_ERR("1107", "请求Body格式错误"),
    PARAM_PARSE_ERR("1108", "参数解析错误"),
    PARAM_HEADER_REQUIRED("1109", "请求Header不能为空"),

    AUTH_NOLOGIN("1201", "未登录"),
    AUTH_INVALID("1202", "请求不合法"),
    //    AUTH_401("1203", "未授权"),
//    AUTH_403("1204", "权限不足"),
    AUTH_LOGIN_FAIL("1205", "登录失败"),
    AUTH_LOGIN_USER_PWD_ERR("1206", "用户名或密码错误"),
    AUTH_USER_DISABLED("1207", "用户被禁用"),
    AUTH_USER_EXPIRE("1208", "用户过期"),
    AUTH_USER_RESET_PWD("1209", "用户密码需要重置"),
    AUTH_LOGOUT_ERR("1210", "登出失败"),
    AUTH_TOKEN_INVALID("1211", "登录过期或无效"),
    AUTH_USER_LOCKED("1212", "用户被锁定"),

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

    REMOTE_ERR("1401", "远程接口失败"),
    REMOTE_CONN_TIMEOUT("1402", "远程接口连接超时"),
    REMOTE_SOCKET_TIMEOUT("1403", "远程接口通讯超时"),
    REMOTE_RES_ERR("1404", "远程接口返回错误"),
    REMOTE_RES_BLANK("1405", "远程接口返回为空"),
    REMOTE_RES_PARSE_ERR("1406", "远程接口返回解析错误"),
    REMOTE_RES_NOT_SUCCESS("1407", "远程接口返回非成功"),
    REMOTE_RES_NO_DATA("1408", "远程接口返回无数据"),
    REMOTE_HTTP_ERR("1409", "远程接口HTTP异常"),

    DB_SQL_ERR("1501", "数据库SQL执行错误"),
    DB_OPT_LOCK("1502", "乐观锁失败"),
    DB_INTEGRITY_CONSTRAINT("1503", "违反数据库约束(唯一,非空等)"),

    CODE_EXCEPTION("1601", "服务异常"),
    CODE_NPE("1603", "服务异常-NPE"),

    TICKET_SHOW_EXPIRED("2101", "场次信息过期，请重新获取场次信息~"),
    TICKET_SHOW_SEAT_EXPIRED("2102", "请更新实时座位图~"),
    TICKET_HALL_SEAT_EXPIRED("2103", "请更新影厅物理座位图~"),

    DISCOUNT_EXHAUSTED("2201", "优惠已用尽~");

    private String code;
    private String msg;
    private Result rs;

    FailCode(String code, String msg) {
        this.code = code;
        this.msg = msg;
        rs = new Result(code, msg, null);
    }

    public String getMsg() {
        return msg;
    }

    public Result result(String msg) {
        this.msg = msg;
        return this.result(this.code, this.msg, null);
    }

    public Result result(Exception e) {
        this.msg = e.getClass() + ":" + e.getMessage();
        return this.result(this.code, this.msg, null);
    }

    @Override
    public Result result() {
        return this.rs;
    }

    @Override
    public <T> Result<T> resultData(T data) {
        return this.result(this.code, this.msg, data);
    }

    public static <T> Result<T> result(Result rs) {
        return rs;
    }
}
