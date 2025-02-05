package com.example.springbootacg.config;

import com.example.springbootacg.dto.Result;
import com.example.springbootacg.utils.ResultHelper;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.net.BindException;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public void methodArgumentNotValidException(MethodArgumentNotValidException e) {
        System.out.println("methodArgumentNotValidException");
    }


    @ExceptionHandler(BindException.class)
    public void handleBindException(BindException exception){
        //FieldError fieldError = exception.getBindingResult().getFieldError();
        System.out.println("handleBindException");
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public void handleHttpMessageNotReadableException(HttpMessageNotReadableException exception){
        System.out.println("handleHttpMessageNotReadableException");
    }


    @ExceptionHandler(Exception.class)
    public Result<Object> handleException(Exception exception) {
        System.out.println(exception.toString());
        return ResultHelper.exception("网络异常请稍后再试");
    }
}
