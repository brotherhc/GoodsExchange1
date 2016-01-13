package com.fafukeji.service;


import com.fafukeji.model.DeviceToken;

public interface IDeviceTokenService {
	
    int insertSelective(DeviceToken deviceToken);
    
    DeviceToken getByUserId(DeviceToken deviceToken);
    
    DeviceToken getByDeviceToken(DeviceToken deviceToken);
}
