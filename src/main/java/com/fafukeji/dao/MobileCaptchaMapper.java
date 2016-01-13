package com.fafukeji.dao;


import com.fafukeji.common.persistence.annotation.MyBatisDao;
import com.fafukeji.model.MobileCaptcha;

@MyBatisDao
public interface MobileCaptchaMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(MobileCaptcha record);

    int insertSelective(MobileCaptcha record);

    MobileCaptcha getByProps(MobileCaptcha record);

    int updateByPrimaryKeySelective(MobileCaptcha record);

    int updateByPrimaryKey(MobileCaptcha record);
}