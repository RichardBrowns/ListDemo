package org.example.listdemo.exception;

import lombok.extern.slf4j.Slf4j;
import org.example.listdemo.common.ResultData;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @description: 全局异常处理类
 * @projectName: ListDemo
 * @packageName: org.example.listdemo.exception
 * @author: LiDa
 * @createTime: 2024/5/17 15:01
 * @version: 1.0
 */
@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(value = {MyException.class})
    public ResultData<Map<String,Object>> handleMyException(MyException ex, HttpServletRequest request) {
        Map<String, Object> data = new HashMap<>();
        data.put("message", ex.getMessage());
        data.put("errorCode", ex.getErrorCode());
        data.put("additionalData", ex.getAdditionalData());

        log.error("An MyException occurred: {}", ex.getMessage());

        return ResultData.failure(ex.getErrorCode(), data);
    }

    @ExceptionHandler(value = {Exception.class})
    public ResultData handleGeneralException(Exception ex, HttpServletRequest request) {
        Map<String, Object> data = new HashMap<>();
        data.put("message", "An unexpected error occurred");
        data.put("stackTrace", ex.getStackTrace().toString());

        log.error("An Exception occurred: {}", ex.getMessage());

        return ResultData.failure(ResultData.ERROR, data);
    }
}
