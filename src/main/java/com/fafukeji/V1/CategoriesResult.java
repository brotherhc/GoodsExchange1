package com.fafukeji.V1;

import com.fafukeji.V1.dao.CategoriesDao;
import com.fafukeji.model.Categories;

/**
 * Created by java on 2015/8/31 0031.
 */
public class CategoriesResult  implements CategoriesDao{
    private int result=1;//状态

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

    private String msg;//返回信息
    private Object data;//数据


    public  CategoriesResult cateInfo(CategoriesResult categoriesResult){
        return this;
    }
}
