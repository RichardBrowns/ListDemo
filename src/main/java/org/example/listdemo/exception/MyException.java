package org.example.listdemo.exception;

import lombok.Getter;
import lombok.Setter;

import java.util.Map;

/**
 * @description: 自定义异常类
 * @projectName: ListDemo
 * @packageName: org.example.listdemo.exception
 * @author: LiDa
 * @createTime: 2024/5/17 14:53
 * @version: 1.0
 */
@Getter
@Setter
public class MyException extends RuntimeException{
    private int errorCode;
    private Map<String,Object> additionalData;

    public MyException(int errorCode, String message) {
        super(message);
        this.errorCode = errorCode;
    }

    public MyException(int errorCode, String message, Map<String, Object> additionalData) {
        super(message);
        this.errorCode = errorCode;
        this.additionalData = additionalData;
    }
}
