package com.github.hicoincom.api.bean;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;

public class BaseWaasArgs {
    @JSONField(name ="app_id")
    protected String appId;

    @JSONField(name ="version")
    protected String version;

    @JSONField(name ="charset")
    protected String charset;

    @JSONField(name ="time")
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

    public String toJson(){
        return JSONObject.toJSONString(this);
    }
}
