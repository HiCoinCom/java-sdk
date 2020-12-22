package com.chainup.waas.request;

/**
 * @author chainup waas
 */
public class RegisterUserByMobile extends CommonParam {

    /**
     * 国家编号，如：86表示中国，是否必填：是
     */
    private String country;

    /**
     * 手机号,，是否必填：是
     */
    private String  mobile;

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


    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder {
        private RegisterUserByMobile createUser;

        public Builder() {
            createUser = new RegisterUserByMobile();
        }

        public Builder time(Long time) {
            createUser.setTime(time);
            return this;
        }

        public Builder country(String country) {
            createUser.setCountry(country);
            return this;
        }

        public Builder charset(String charset) {
            createUser.setCharset(charset);
            return this;
        }

        public Builder mobile(String mobile) {
            createUser.setMobile(mobile);
            return this;
        }

        public Builder version(String version) {
            createUser.setVersion(version);
            return this;
        }

        public RegisterUserByMobile build() {
            return createUser;
        }
    }
}
