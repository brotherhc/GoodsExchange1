package com.fafukeji.common.persistence;
import java.io.Serializable;
import java.util.Map;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import com.fafukeji.common.config.Global;
import com.fafukeji.model.User;
import com.fafukeji.utils.UserUtils;
import com.google.common.collect.Maps;

/**
 * Entity支持类
 */
public abstract class BaseEntity<T> implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * 当前用户
	 */
	protected User currentUser;
	
	/**
	 * 当前实体分页对象
	 */
	protected Page<T> page;
	
	/**
	 * 自定义SQL（SQL标识，SQL内容）
	 */
	protected Map<String, String> sqlMap;
	
	/**
	 * 是否是新记录（默认：false），调用setIsNewRecord()设置新记录，使用自定义ID。
	 * 设置为true后强制执行插入语句，ID不会自动生成，需从手动传入。
	 */
	protected boolean isNewRecord = false;

	public BaseEntity() {
		
	}
	

	public User getCurrentUser() {
		if(currentUser == null){
			currentUser = UserUtils.getUser();
		}
		return currentUser;
	}
	
	public void setCurrentUser(User currentUser) {
		this.currentUser = currentUser;
	}

	public Page<T> getPage() {
		if (page == null){
			page = new Page<T>();
		}
		return page;
	}
	
	public Page<T> setPage(Page<T> page) {
		this.page = page;
		return page;
	}

	public Map<String, String> getSqlMap() {
		if (sqlMap == null){
			sqlMap = Maps.newHashMap();
		}
		return sqlMap;
	}

	public void setSqlMap(Map<String, String> sqlMap) {
		this.sqlMap = sqlMap;
	}
	
	/**----
	 * 插入之前执行方法，子类实现
	 */
	public abstract void preInsert();


	/**
	 * 插入之前执行方法，子类实现
	 */
	public abstract void preUpdatedAt();


//    /**
//	 * 是否是新记录（默认：false），调用setIsNewRecord()设置新记录，使用自定义ID。
//	 * 设置为true后强制执行插入语句，ID不会自动生成，需从手动传入。
//     * @return
//     */
//	public boolean getIsNewRecord() {
//        return isNewRecord || StringUtils.isBlank(getId());
//    }

	/**
	 * 是否是新记录（默认：false），调用setIsNewRecord()设置新记录，使用自定义ID。
	 * 设置为true后强制执行插入语句，ID不会自动生成，需从手动传入。
	 */
	public void setIsNewRecord(boolean isNewRecord) {
		this.isNewRecord = isNewRecord;
	}

	/**
	 * 全局变量对象
	 */

	public Global getGlobal() {
		return Global.getInstance();
	}
	
	/**
	 * 获取数据库名称
	 */
	public String getDbName(){
		return Global.getConfig("jdbc.type");
	}
	
//    @Override
//    public boolean equals(Object obj) {
//        if (null == obj) {
//            return false;
//        }
//        if (this == obj) {
//            return true;
//        }
//        if (!getClass().equals(obj.getClass())) {
//            return false;
//        }
//        BaseEntity<?> that = (BaseEntity<?>) obj;
//        return null == this.getId() ? false : this.getId().equals(that.getId());
//    }
    
    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }


}
