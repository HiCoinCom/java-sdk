package com.chainup.waas.request;

/**
 * @author chainup waas
 */
public class CommonParam {

    /**
     * 请求当前时间戳，是否必填：是
     */
    private Long time;

    /**
     * 编码格式，无特殊情况，传参数utf-8，是否必填：是
     */
    private String charset;

    /**
     * 接口版本号，无特殊情况，传参数v2，是否必填：是
     */
    private String version;

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
}
