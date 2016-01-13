package com.fafukeji.common.persistence;

import java.util.List;

import com.fafukeji.common.utils.DateUtils;
import org.apache.log4j.Logger;

/**
 * 数据Entity类
 */
public abstract class DataEntity<T> extends BaseEntity<T> {

	private static final long serialVersionUID = 1L;
	protected long createdAt; // 创建日期
	protected long updatedAt;
	protected List<?> listData;
	private String searchKey;
    private byte delFlag =-1;
	
	public List<?> getListData() {
		return listData;
	}

	public void setListData(List<?> listData) {
		this.listData = listData;
	}

	public long getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(long updatedAt) {
		this.updatedAt = updatedAt;
	}

	public static Logger log = Logger.getLogger(DataEntity.class);
	
	public static final Byte DEL_FLAG_NORMAL = 0;
	public static final Byte DEL_FLAG_DELETE = 1;
	public static final Byte DEL_FLAG_AUDIT = 2;
	

	public long getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(long createdAt) {
		this.createdAt = createdAt;
	}

	/**
	 * 插入之前执行方法，需要手动调用
	 */
	@Override
	public void preInsert() {
		this.createdAt = DateUtils.getCurrentTimeStamp();
	}


	/**
	 * 插入之前执行方法，需要手动调用
	 */
	@Override
	public void preUpdatedAt() {
		this.updatedAt = DateUtils.getCurrentTimeStamp();
	}

	public String getSearchKey() {
		return searchKey;
	}

	public void setSearchKey(String searchKey) {
		this.searchKey = searchKey;
	}

	public byte getDelFlag() {
		return delFlag;
	}

	public void setDelFlag(byte delFlag) {
		this.delFlag = delFlag;
	}
}
