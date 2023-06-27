package com.example.springacg.config;

import cn.dev33.satoken.exception.NotLoginException;
import com.example.springacg.utils.ResponseStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class SaTokenExceptionHandler {
    @ExceptionHandler(NotLoginException.class)
    public ResponseStatus handlerNotLoginException(NotLoginException notLoginException) {
        String type = notLoginException.getType();
        String result = notLoginException.getMessage();

        if (type.equals(NotLoginException.INVALID_TOKEN)) {
            return ResponseStatus.error(401, NotLoginException.INVALID_TOKEN_MESSAGE, result);
        } else if (type.equals(NotLoginException.NOT_TOKEN)) {
            return ResponseStatus.error(401, NotLoginException.NOT_TOKEN_MESSAGE, result);
        } else if (type.equals(NotLoginException.TOKEN_TIMEOUT)) {
            return ResponseStatus.error(401, NotLoginException.TOKEN_TIMEOUT_MESSAGE, result);
        } else if (type.equals(NotLoginException.KICK_OUT_MESSAGE)) {
            return ResponseStatus.error(401, NotLoginException.KICK_OUT_MESSAGE, result);
        }
        return ResponseStatus.error(401, "权限错误", notLoginException.getMessage());
    }
}
