package com.fafukeji.model;

import com.fafukeji.common.persistence.DataEntity;
//手机验证码
public class MobileCaptcha extends DataEntity<MobileCaptcha> {
    private Integer id;

    private String mobile;

    private String captcha;

    private Long validTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    public String getCaptcha() {
        return captcha;
    }

    public void setCaptcha(String captcha) {
        this.captcha = captcha == null ? null : captcha.trim();
    }

    public Long getValidTime() {
        return validTime;
    }

    public void setValidTime(Long validTime) {
        this.validTime = validTime;
    }

}