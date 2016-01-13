package com.fafukeji.V1;

/**
 * Created by java on 2015/8/28 0028.
 */
public class LoginResult {
    private int result=1;//状态
    private String msg;//返回信息
    private Object data;//数据

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
