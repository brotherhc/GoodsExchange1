package com.fafukeji.service.impl;


import com.fafukeji.common.config.Global;
import com.fafukeji.common.utils.DateUtils;
import com.fafukeji.dao.MobileCaptchaMapper;
import com.fafukeji.model.MobileCaptcha;
import com.fafukeji.service.IMobileCaptchaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service("mobileCaptchaService")
public class MobileCaptchaServiceImpl implements IMobileCaptchaService {
    private MobileCaptchaMapper mobileCaptchaMapper;

    public MobileCaptchaMapper getMobileCaptchaMapper() {
        return mobileCaptchaMapper;
    }

    @Autowired
    public void setMobileCaptchaMapper(MobileCaptchaMapper mobileCaptchaMapper) {
        this.mobileCaptchaMapper = mobileCaptchaMapper;
    }

    @Override
    public MobileCaptcha getByProps(MobileCaptcha mobileCaptcha) {
        return mobileCaptchaMapper.getByProps(mobileCaptcha);
    }

    @Override
    public int insertSelective(MobileCaptcha mobileCaptcha) {
        Long validTime = DateUtils.getCurrentTimeStamp() + 30 * Integer.parseInt(Global.getConfig("validTime"));
        mobileCaptcha.setValidTime(validTime);
        return mobileCaptchaMapper.insertSelective(mobileCaptcha);
    }

}
