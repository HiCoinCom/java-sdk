package com.github.hicoincom;

/**
 * @author ChainUp Custody
 */
public class MpcConfig extends WaasConfig {

    /**
     * The rsa used for encryption parameters when withdrawing or creating web3 transactions
     */
    private String signPrivateKey;

    /**
     * Custody domain name
     */
    private String domain = "https://openapi.chainup.com";

    private String charset = "utf-8";

    private Boolean enableLog = Boolean.TRUE;

    public String getSignPrivateKey() {
        return signPrivateKey;
    }

    public void setSignPrivateKey(String signPrivateKey) {
        this.signPrivateKey = signPrivateKey;
    }

    @Override
    public String getDomain() {
        return domain;
    }

    @Override
    public void setDomain(String domain) {
        this.domain = domain;
    }

    @Override
    public String getCharset() {
        return charset;
    }

    @Override
    public void setCharset(String charset) {
        this.charset = charset;
    }

    @Override
    public Boolean getEnableLog() {
        return enableLog;
    }

    @Override
    public void setEnableLog(Boolean enableLog) {
        this.enableLog = enableLog;
    }
}
