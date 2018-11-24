package com.cqupt.weigs.shirodemo.exception;

import com.cqupt.weigs.shirodemo.common.Result;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author weigs
 * @date 2018/11/24 0024
 */
@ControllerAdvice
public class MyExceptionHandler {
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result<String> defaultErrorHandler(Exception e) {
        return Result.error(e.getMessage());
    }
}
