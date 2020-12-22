package com.chainup.waas.request;

/**
 * @author chainup waas
 */
public class QueryUserInfo extends CommonParam {

    /**
     * 国家编号，mobile不为空时，该字段必填，是否必填：否
     */
    private String country;

    /**
     * 手机号，手机和邮箱需要保证其中之一不能为空，是否必填：否
     */
    private String mobile;

    /**
     * 邮箱，手机和邮箱需要保证其中之一不能为空，是否必填：否
     */
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


    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder {
        private QueryUserInfo getUserInfo;

        private Builder() {
            getUserInfo = new QueryUserInfo();
        }

        public Builder time(Long time) {
            getUserInfo.setTime(time);
            return this;
        }

        public Builder charset(String charset) {
            getUserInfo.setCharset(charset);
            return this;
        }

        public Builder country(String country) {
            getUserInfo.setCountry(country);
            return this;
        }

        public Builder version(String version) {
            getUserInfo.setVersion(version);
            return this;
        }

        public Builder mobile(String mobile) {
            getUserInfo.setMobile(mobile);
            return this;
        }

        public Builder email(String email) {
            getUserInfo.setEmail(email);
            return this;
        }

        public QueryUserInfo build() {
            return getUserInfo;
        }
    }
}
