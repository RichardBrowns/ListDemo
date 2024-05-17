package org.example.listdemo.common;

/**
 * @description:
 * @projectName: ListDemo
 * @see: org.example.listdemo.common
 * @author: LiDa
 * @createTime: 2024/5/13 10:04
 * @version:
 */
import lombok.*;

import java.util.Map;
@Data
public class ResultData<T> {

    private int code; // 状态码，例如200表示成功，400表示错误
    private String message; // 消息，描述操作结果或错误信息
    private T data; // 数据部分，可以是任意类型的对象

    public static final int SUCCESS = 200; // 成功
    public static final int ERROR = 500; // 服务器内部错误
    public static final int PARAMS_ERROR = 400; // 参数错误
    public static final int NOT_FOUND = 404; // 资源未找到

    public ResultData() {
    }

    public ResultData(int code, T data) {
        this.code = code;
        this.data = data;
    }

    public ResultData(int code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public static <T> ResultData<T> success(int code, String message, T data) {
        return new ResultData<>(code, message, data);
    }

    public static <T> ResultData<T> failure(int code, String message) {
        return new ResultData<>(code, message, null);
    }

    public static <T> ResultData<T> failure(int code,T data) {
        return new ResultData<>(code, data);
    }
}
