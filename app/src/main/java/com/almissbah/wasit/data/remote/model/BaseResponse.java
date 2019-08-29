package com.almissbah.wasit.data.remote.model;

public abstract class BaseResponse {
    boolean isSuccess = false;
    String msg = "";


    public boolean isSuccess() {
        return isSuccess;
    }

    public void setSuccess(boolean success) {
        isSuccess = success;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
