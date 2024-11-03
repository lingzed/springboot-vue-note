package com.ling.entity;

public class BusinessException extends RuntimeException {
    private Integer code;
    private String msg;
    private ResponseCodeEnum codeEnum;

    public BusinessException(ResponseCodeEnum codeEnum) {
        super(codeEnum.getMsg());
        this.code = codeEnum.getCode();
        this.codeEnum = codeEnum;
    }

    public BusinessException(ResponseCodeEnum codeEnum, Throwable e) {
        super(codeEnum.getMsg(), e);
        this.code = codeEnum.getCode();
        this.codeEnum = codeEnum;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return getMessage();
    }

    public ResponseCodeEnum getCodeEnum() {
        return codeEnum;
    }

    /**
     * 业务异常不需要打印堆栈信息，提高效率
     *
     * @return
     */
    @Override
    public Throwable fillInStackTrace() {
        return this;
    }
}
