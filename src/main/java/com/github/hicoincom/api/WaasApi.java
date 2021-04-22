package com.github.hicoincom.api;

import com.alibaba.fastjson.JSONObject;
import com.github.hicoincom.WaasConfig;
import com.github.hicoincom.api.bean.ApiUri;
import com.github.hicoincom.api.bean.Args;
import com.github.hicoincom.api.bean.BaseWaasArgs;
import com.github.hicoincom.crypto.IDataCrypto;
import com.github.hicoincom.exception.CryptoException;
import com.github.hicoincom.util.HttpClientUtil;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WaasApi {
    protected static final Logger logger = LoggerFactory.getLogger(WaasApi.class);

    protected IDataCrypto dataCrypto;
    protected WaasConfig cfg;

    public WaasApi(){}

    public WaasApi(WaasConfig cfg, IDataCrypto crypto){
        this.cfg = cfg;
        this.dataCrypto = crypto;
    }

    public IDataCrypto getDataCrypto() {
        return dataCrypto;
    }

    public void setDataCrypto(IDataCrypto dataCrypto) {
        this.dataCrypto = dataCrypto;
    }

    public WaasConfig getCfg() {
        return cfg;
    }

    public void setCfg(WaasConfig cfg) {
        this.cfg = cfg;
    }

    /**
     *  请求waas 接口
     * @param uri
     * @param args
     * @param clazz
     * @param <T>
     * @return
     */
    protected <T> T invoke(ApiUri uri, BaseWaasArgs args, Class<T> clazz)  {
        //默认参数
        args.setCharset(this.cfg.getCharset());
        args.setTime(System.currentTimeMillis());
        args.setVersion(cfg.getVersion());

        //加密参数
        String raw = args.toJson();
        this.info("{}  raw args:{}", uri.getValue(), raw);
        String data = this.dataCrypto.encode(raw);
        this.info("{}  encode args:{}", uri.getValue(), data);

        if(StringUtils.isBlank(data)){
            logger.error("{} encode args return null", uri.getValue());
            throw new CryptoException("data crypto return null");
        }

        //请求接口
        String url = String.format("%s/%s", this.cfg.getDomain(), uri.getValue());
        Args params = new Args(this.cfg.getAppId(), data);
        String resp = null;
        if("GET".equalsIgnoreCase(uri.getMethod())){
            url += "?" + params.toString();
            resp = HttpClientUtil.getInstance().doGetWithJsonResult(url);
        }else{
            resp = HttpClientUtil.getInstance().doPostWithJsonResult(url, params.toMap());
        }

        this.info("{} raw result:{}", uri.getValue(), resp);
        //接口返回数据为空
        if(StringUtils.isBlank(resp)){
            logger.error("{} api return null", uri.getValue());
            return null;
        }

        JSONObject jsonObject = JSONObject.parseObject(resp);
        if(jsonObject == null || !jsonObject.containsKey("data") || StringUtils.isBlank(jsonObject.getString("data"))){
            //接口返回数据未包含data字段
            logger.error("{} result do not found data field or data field is empty", uri.getValue());
            return null;
        }

        //解密响应数据
        String respRaw = this.dataCrypto.decode(jsonObject.getString("data"));
        this.info("{} decode result :{}", uri.getValue(), respRaw);
        if(StringUtils.isBlank(respRaw)){
            logger.error("{} decode result return null", uri.getValue());
            return null;
        }

        T result = JSONObject.parseObject(respRaw, clazz);
        if(result == null){
            logger.error("{} result parse json to object error", uri.getValue());
            return null;
        }
        return result;
    }

    protected void info(String format, Object...  object){
        if(this.getCfg().getEnableLog()) {
            logger.info(format, object);
        }
    }
}
