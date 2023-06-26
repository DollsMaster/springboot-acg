package com.example.springacg.config;

import com.example.springacg.utils.ResponseStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler
    @ResponseBody
    public ResponseStatus handleMyException(MyException e) {
        return ResponseStatus.error(e.getMessage(), null);
    }
}
