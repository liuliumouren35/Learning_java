package com.itheima.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import com.itheima.pojo.Result;

@RestControllerAdvice
public class GlobalExceptionHandler {
  @ExceptionHandler(Exception.class)//捕获所有异常
  public Result handleException(Exception e){
    return Result.error("系统繁忙，请稍后再试");
  }
}
