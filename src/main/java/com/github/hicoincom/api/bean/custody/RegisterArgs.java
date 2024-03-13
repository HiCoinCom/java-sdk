package com.github.hicoincom.api.bean.custody;


import com.github.hicoincom.api.bean.BaseWaasArgs;

import java.io.Serializable;

/**
 *  SMS mailbox registration parameters
 *  http://docs.hicoin.vip/zh/latest/API-WaaS-V2/api/user_createUser.html
 *  http://docs.hicoin.vip/zh/latest/API-WaaS-V2/api/user_registerEmail.html
 */
public class RegisterArgs extends BaseWaasArgs implements Serializable {

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
