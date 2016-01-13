package com.fafukeji.dao;

import com.fafukeji.common.persistence.annotation.MyBatisDao;
import com.fafukeji.model.DeviceToken;

@MyBatisDao
public interface DeviceTokenMapper {

    int insertSelective(DeviceToken record);

    DeviceToken getByUserId(DeviceToken deviceToken);

	DeviceToken getByDeviceToken(DeviceToken deviceToken);
}