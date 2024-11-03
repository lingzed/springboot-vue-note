package com.ling.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Result<T> {
    private String status;
    private Integer code;
    private String msg;
    private T data;

    public Result(String status, ResponseCodeEnum codeEnum, T data) {
        this.status = status;
        this.code = codeEnum.getCode();
        this.msg = codeEnum.getMsg();
        this.data = data;
    }

    public static <T> Result<T> success(T data) {
        return new Result<>("success", ResponseCodeEnum.CODE_200, data);
    }

    public static Result success() {
        return new Result<>("success", ResponseCodeEnum.CODE_200, null);
    }

    public static Result error(ResponseCodeEnum codeEnum) {
        return new Result("fail", codeEnum, null);
    }
}
