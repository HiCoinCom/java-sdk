package com.github.hicoincom.api.bean;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.GsonBuilder;

/**
 * @author ChainUp
 */
public class BaseArgs {

    protected String appId;

    protected String version;

    protected String charset;

    protected Long time;

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
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

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }

    public String toJson() {
        return new GsonBuilder()
                .setFieldNamingStrategy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                .create()
                .toJson(this);
    }
}
