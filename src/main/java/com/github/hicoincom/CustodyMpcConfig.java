package com.github.hicoincom;

/**
 * @author ChainUp Custody
 */
public class CustodyMpcConfig {

    /**
     * Custody appId
     */
    private String appId;

    /**
     * Customer Rsa private key
     */
    private String userPrivateKey;

    /**
     * The Rsa public key provided by Custody
     */
    private String custodyPublicKey;

    /**
     * The rsa used for encryption parameters when withdrawing or creating web3 transactions
     */
    private String signPrivateKey;

    /**
     * Custody domain name
     */
    private String domain = "https://openapi.hicoin.vip";

    private String charset = "utf-8";

    private Boolean enableLog = Boolean.TRUE;

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getUserPrivateKey() {
        return userPrivateKey;
    }

    public void setUserPrivateKey(String userPrivateKey) {
        this.userPrivateKey = userPrivateKey;
    }

    public String getCustodyPublicKey() {
        return custodyPublicKey;
    }

    public void setCustodyPublicKey(String custodyPublicKey) {
        this.custodyPublicKey = custodyPublicKey;
    }

    public String getSignPrivateKey() {
        return signPrivateKey;
    }

    public void setSignPrivateKey(String signPrivateKey) {
        this.signPrivateKey = signPrivateKey;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public String getCharset() {
        return charset;
    }

    public void setCharset(String charset) {
        this.charset = charset;
    }

    public Boolean getEnableLog() {
        return enableLog;
    }

    public void setEnableLog(Boolean enableLog) {
        this.enableLog = enableLog;
    }


    public static final class CustodyMpcConfigBuilder {
        private String appId;
        private String userPrivateKey;
        private String custodyPublicKey;
        private String signPrivateKey;
        private String domain = "https://openapi.hicoin.vip";
        private String charset = "utf-8";
        private Boolean enableLog = Boolean.TRUE;

        private CustodyMpcConfigBuilder() {
        }

        public static CustodyMpcConfigBuilder aCustodyMpcConfig() {
            return new CustodyMpcConfigBuilder();
        }

        public CustodyMpcConfigBuilder appId(String appId) {
            this.appId = appId;
            return this;
        }

        public CustodyMpcConfigBuilder userPrivateKey(String userPrivateKey) {
            this.userPrivateKey = userPrivateKey;
            return this;
        }

        public CustodyMpcConfigBuilder custodyPublicKey(String custodyPublicKey) {
            this.custodyPublicKey = custodyPublicKey;
            return this;
        }

        public CustodyMpcConfigBuilder signPrivateKey(String signPrivateKey) {
            this.signPrivateKey = signPrivateKey;
            return this;
        }

        public CustodyMpcConfigBuilder domain(String domain) {
            this.domain = domain;
            return this;
        }

        public CustodyMpcConfigBuilder charset(String charset) {
            this.charset = charset;
            return this;
        }

        public CustodyMpcConfigBuilder enableLog(Boolean enableLog) {
            this.enableLog = enableLog;
            return this;
        }

        public CustodyMpcConfig build() {
            CustodyMpcConfig custodyMpcConfig = new CustodyMpcConfig();
            custodyMpcConfig.setAppId(appId);
            custodyMpcConfig.setUserPrivateKey(userPrivateKey);
            custodyMpcConfig.setCustodyPublicKey(custodyPublicKey);
            custodyMpcConfig.setSignPrivateKey(signPrivateKey);
            custodyMpcConfig.setDomain(domain);
            custodyMpcConfig.setCharset(charset);
            custodyMpcConfig.setEnableLog(enableLog);
            return custodyMpcConfig;
        }
    }
}
