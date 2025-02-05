package com.example.springbootacg.utils;

import com.example.springbootacg.common.constant.MsgCodeEnum;
import com.example.springbootacg.dto.Result;
import lombok.val;

public abstract class ResultHelper {


    public static <R> Result<R> success() {
        return result(null, MsgCodeEnum.SUCCESS, true);
    }

    public static <R> Result<R> success(R data) {
        return result(data, MsgCodeEnum.SUCCESS, true);
    }

    public static <R> Result<R> success(R data, MsgCodeEnum msgCodeEnum) {
        return result(data, msgCodeEnum, true);
    }

    private static <R> Result<R> result(R data, MsgCodeEnum msgCode, boolean success) {
        Result<R> rResult = new Result<R>(data, msgCode, success);
        return rResult;
    }

    public static <R> Result<R> exception(String errorMsg) {
        return result(null, MsgCodeEnum.EXCEPTION, false);
    }
}