package com.sy.base;

import java.io.Serializable;

/**
 * 返回客户端对像
 * @param <T>
 */
public class BaseResp<T> implements Serializable {

    public static final int RET_SUCCESS = 0 ;
    public static final int RET_FAILED = 1 ;

    public static final String RET_SUCCESS_MSG = "成功" ;
    public static final String RET_FAILED_MSG = "失败" ;



    private int code ; //1是失败，0是成功
    private String msg ;//信息
    private T data ;//业务数据


    public BaseResp() {
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "BaseResp{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }
}
