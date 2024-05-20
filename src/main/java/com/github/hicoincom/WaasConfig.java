package com.github.hicoincom;

public class WaasConfig {

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
    private String waasPublickKey;

    /**
     * Custody domain name
     */
    private String domain = "https://openapi.hicoin.vip/api/v2";

    private String version = "v2";

    private String charset = "utf-8";

    private Boolean enableLog = true;

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

    public String getWaasPublickKey() {
        return waasPublickKey;
    }

    public void setWaasPublickKey(String waasPublickKey) {
        this.waasPublickKey = waasPublickKey;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
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
}
