package com.chainup.waas.request;

/**
 * @author chainup waas
 */
public class UserSymbolAccount extends CommonParam {

    /**
     * 用户ID，是否必填：是
     */
    private String uid;

    /**
     * 币种，是否必填：是
     */
    private String symbol;

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



    public static Builder builder() {
        return new Builder();
    }
    public static final class Builder {
        private UserSymbolAccount userSymbolAccount;

        private Builder() {
            userSymbolAccount = new UserSymbolAccount();
        }


        public Builder time(Long time) {
            userSymbolAccount.setTime(time);
            return this;
        }

        public Builder uid(String uid) {
            userSymbolAccount.setUid(uid);
            return this;
        }

        public Builder charset(String charset) {
            userSymbolAccount.setCharset(charset);
            return this;
        }

        public Builder symbol(String symbol) {
            userSymbolAccount.setSymbol(symbol);
            return this;
        }

        public Builder version(String version) {
            userSymbolAccount.setVersion(version);
            return this;
        }

        public UserSymbolAccount build() {
            return userSymbolAccount;
        }
    }
}
