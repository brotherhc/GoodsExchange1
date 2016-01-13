package com.fafukeji.service;

import com.fafukeji.model.MobileCaptcha;

public interface IMobileCaptchaService {
    MobileCaptcha getByProps(MobileCaptcha mobileCaptcha);

    int insertSelective(MobileCaptcha mobileCaptcha);

}
