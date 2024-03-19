package com.github.hicoincom.api.bean.waas;


import com.github.hicoincom.api.bean.BaseArgs;

import java.io.Serializable;

/**
 * @author ChainUp Custody
 * SMS mailbox registration parameters
 * http://docs.hicoin.vip/zh/latest/API-WaaS-V2/api/user_createUser.html
 * http://docs.hicoin.vip/zh/latest/API-WaaS-V2/api/user_registerEmail.html
 */
public class RegisterArgs extends BaseArgs implements Serializable {

    private static final long serialVersionUID = 3438195413825582164L;

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
