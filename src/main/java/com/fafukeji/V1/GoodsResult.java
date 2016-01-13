package com.fafukeji.V1;

import com.fafukeji.common.persistence.BaseEntity;
import com.fafukeji.common.persistence.DataEntity;
import com.fafukeji.model.Categories;
import com.fafukeji.model.Goods;
import com.fafukeji.model.User;

import java.util.List;

/**
 * 物品信息
 */
public class GoodsResult implements GoodsDao{
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


    public GoodsResult GoodsInfo(Goods goods){
        return this;
    }

}
