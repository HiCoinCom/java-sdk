package com.chainup.waas.api.bean;


import java.io.Serializable;

/**
 *  用户信息查询
 *  http://docs.hicoin.vip/zh/latest/API-WaaS-V2/api/user_info.html
 */
public class UserInfoArgs extends BaseWaasArgs implements Serializable {

    private static final long serialVersionUID = 1L;

    private String country;
    private String mobile;
    private String email;

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
