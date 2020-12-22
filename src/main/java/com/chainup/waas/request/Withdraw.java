package com.chainup.waas.request;

/**
 * @author chainup waas
 */
public class Withdraw extends CommonParam {

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

    /**
     * 提现币种
     */
    private String symbol;

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

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }


    public static Builder builder() {
        return new Builder();
    }
    public static final class Builder {
        private Withdraw withdraw;

        private Builder() {
            withdraw = new Withdraw();
        }

        public Builder time(Long time) {
            withdraw.setTime(time);
            return this;
        }

        public Builder request_id(String request_id) {
            withdraw.setRequest_id(request_id);
            return this;
        }

        public Builder charset(String charset) {
            withdraw.setCharset(charset);
            return this;
        }

        public Builder from_uid(String from_uid) {
            withdraw.setFrom_uid(from_uid);
            return this;
        }

        public Builder version(String version) {
            withdraw.setVersion(version);
            return this;
        }

        public Builder to_address(String to_address) {
            withdraw.setTo_address(to_address);
            return this;
        }

        public Builder amount(String amount) {
            withdraw.setAmount(amount);
            return this;
        }

        public Builder symbol(String symbol) {
            withdraw.setSymbol(symbol);
            return this;
        }

        public Withdraw build() {
            return withdraw;
        }
    }
}
