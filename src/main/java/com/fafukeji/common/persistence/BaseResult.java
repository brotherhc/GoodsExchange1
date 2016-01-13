package com.fafukeji.common.persistence;

import com.fafukeji.common.persistence.Page;

import java.io.Serializable;

/**
 * @author wjx
 * @version 15-8-14
 */
public class BaseResult implements Serializable {
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


    // 当前页数
    private int pageNo;
    // 总条数
    private long count;
    // 是否含有更多内容
    private int haveMore;

    private int pageSize;

    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }

    public int getHaveMore() {
        return haveMore;
    }

    public void setHaveMore(Boolean isHave) {
        if (isHave){
            this.haveMore = 0;
        }else{
            this.haveMore = 1;
        }
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public BaseResult generateMobilePageInfo(Page page){
        this.setPageNo(page.getPageNo());
        this.setHaveMore(page.isLastPage());
        this.setCount(page.getCount());
        this.setPageSize(page.getPageSize());
        return this;
    }
}
