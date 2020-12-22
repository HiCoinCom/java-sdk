package com.chainup.waas.request;

public class RequestParams {

    /**
     * 请求当前时间戳
     */
    private Long time;

    /**
     * 编码格式，无特殊情况，传参数utf-8
     */
    private String charset;

    /**
     * 接口版本号，无特殊情况，传参数v2
     */
    private String version;

    /**
     * 国家编号，mobile不为空时，该字段必填
     */
    private String country;

    /**
     * 手机号，手机和邮箱需要保证其中之一不能为空
     */
    private String mobile;

    /**
     * 邮箱，手机和邮箱需要保证其中之一不能为空
     */
    private String email;

    /**
     * 用户ID
     */
    private String uid;

    /**
     * 币种
     */
    private String symbol;

    /**
     * 返回大于id的100条充值记录数据
     */
    private String max_id;

    /**
     * 多个request_id使用逗号隔开，最多100个request_id
     */
    private String ids;

    /**
     * 请求唯一标识，最多支持64位
     */
    private String request_id;

    /**
     * 转出用户ID
     */
    private String from_uid;

    /**
     * 转入用户地址，memo类型，使用"_"进行拼接，如: waaswaaseos_24545
     */
    private String to_address;

    /**
     * 提现金额，包含提现手续费；手续费需要在商户后台配置
     */
    private String amount;

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }

    public String getCharset() {
        return charset;
    }

    public void setCharset(String charset) {
        this.charset = charset;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

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

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getMax_id() {
        return max_id;
    }

    public void setMax_id(String max_id) {
        this.max_id = max_id;
    }

    public String getIds() {
        return ids;
    }

    public void setIds(String ids) {
        this.ids = ids;
    }

    public String getRequest_id() {
        return request_id;
    }

    public void setRequest_id(String request_id) {
        this.request_id = request_id;
    }

    public String getFrom_uid() {
        return from_uid;
    }

    public void setFrom_uid(String from_uid) {
        this.from_uid = from_uid;
    }

    public String getTo_address() {
        return to_address;
    }

    public void setTo_address(String to_address) {
        this.to_address = to_address;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }


    public static Builder builder() {
        return new Builder();
    }
    public static final class Builder {
        private RequestParams requestParams;

        private Builder() {
            requestParams = new RequestParams();
        }

        public Builder time(Long time) {
            requestParams.setTime(time);
            return this;
        }

        public Builder charset(String charset) {
            requestParams.setCharset(charset);
            return this;
        }

        public Builder version(String version) {
            requestParams.setVersion(version);
            return this;
        }

        public Builder country(String country) {
            requestParams.setCountry(country);
            return this;
        }

        public Builder mobile(String mobile) {
            requestParams.setMobile(mobile);
            return this;
        }

        public Builder email(String email) {
            requestParams.setEmail(email);
            return this;
        }

        public Builder uid(String uid) {
            requestParams.setUid(uid);
            return this;
        }

        public Builder symbol(String symbol) {
            requestParams.setSymbol(symbol);
            return this;
        }

        public Builder max_id(String max_id) {
            requestParams.setMax_id(max_id);
            return this;
        }

        public Builder ids(String ids) {
            requestParams.setIds(ids);
            return this;
        }

        public Builder request_id(String request_id) {
            requestParams.setRequest_id(request_id);
            return this;
        }

        public Builder from_uid(String from_uid) {
            requestParams.setFrom_uid(from_uid);
            return this;
        }

        public Builder to_address(String to_address) {
            requestParams.setTo_address(to_address);
            return this;
        }

        public Builder amount(String amount) {
            requestParams.setAmount(amount);
            return this;
        }

        public RequestParams build() {
            return requestParams;
        }
    }
}
