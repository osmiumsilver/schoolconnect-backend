package com.osmium.schoolconnect.backend.utils;

public interface IFailResult {

    Result result();

    <T> Result<T> resultData(T data);

    default <T> Result<T> result(String code, String msg, T data) {
        return new Result(code, msg, data);
    }
}
