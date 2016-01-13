package com.fafukeji.service.impl;

import com.fafukeji.dao.DeviceTokenMapper;
import com.fafukeji.model.DeviceToken;
import com.fafukeji.service.IDeviceTokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service("deviceTokenService")
public class DeviceTokenServiceImpl implements IDeviceTokenService {
	
	@Autowired
	private DeviceTokenMapper deviceTokenMapper;
	@Override
	public int insertSelective(DeviceToken deviceToken) {
		return deviceTokenMapper.insertSelective(deviceToken);
	}

	@Override
	public DeviceToken getByUserId(DeviceToken deviceToken) {
		return deviceTokenMapper.getByUserId(deviceToken);
	}

	@Override
	public DeviceToken getByDeviceToken(DeviceToken deviceToken) {
		return deviceTokenMapper.getByDeviceToken(deviceToken);
	}
   
}
