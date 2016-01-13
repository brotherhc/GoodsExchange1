package com.fafukeji.V1;
import com.fafukeji.common.persistence.DataEntity;
import com.fafukeji.model.User;

/**
 * Created by java on 2015/8/25 0025.
 *
 * 用户信息查询
 */
public class UserResult  implements UserTe{
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
    private String username;
    private String mobile;
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserResult generateMobilePageInfo(User user){
        this.setUsername(user.getUsername());
        this.setPassword(user.getPassword());
        this.setMobile(user.getMobile());
        return this;
    }


}
