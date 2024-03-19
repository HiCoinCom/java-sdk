package com.github.hicoincom.api;

import com.github.hicoincom.WaasConfig;
import com.github.hicoincom.api.bean.Args;
import com.github.hicoincom.api.bean.BaseArgs;
import com.github.hicoincom.crypto.IDataCrypto;
import com.github.hicoincom.enums.ApiUri;
import com.github.hicoincom.enums.MpcApiUri;
import com.github.hicoincom.exception.CryptoException;
import com.github.hicoincom.util.HttpClientUtil;
import com.google.gson.*;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.client.methods.HttpGet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author ChainUp Custody
 */
public class WaasApi {
    protected static final Logger logger = LoggerFactory.getLogger(WaasApi.class);

    protected WaasConfig cfg;

    protected IDataCrypto dataCrypto;

    public WaasApi(WaasConfig cfg, IDataCrypto dataCrypto) {
        this.cfg = cfg;
        this.dataCrypto = dataCrypto;
    }

    public WaasConfig getCfg() {
        return cfg;
    }

    public void setCfg(WaasConfig cfg) {
        this.cfg = cfg;
    }

    public IDataCrypto getDataCrypto() {
        return dataCrypto;
    }

    public void setDataCrypto(IDataCrypto dataCrypto) {
        this.dataCrypto = dataCrypto;
    }

    /**
     * call Custody api
     */
    protected <T> T invoke(MpcApiUri uri, BaseArgs args, Class<T> clazz) {
        return this.invoke(uri.getValue(), uri.getMethod(), args, clazz);
    }

    /**
     * call Custody mpc api
     */
    protected <T> T invoke(ApiUri uri, BaseArgs args, Class<T> clazz) {
        return this.invoke(uri.getValue(), uri.getMethod(), args, clazz);
    }

    /**
     * call Custody api
     */
    protected <T> T invoke(String uri, String requestMethod, BaseArgs args, Class<T> clazz) {
        // default parameters
        args.setCharset(this.cfg.getCharset());
        args.setTime(System.currentTimeMillis());

        // encryption parameters
        String raw = args.toJson();
        this.info("request api:{}, request args:{}", uri, raw);
        String data = this.dataCrypto.encode(raw);
        this.info("request api: {}, encode args:{}", uri, data);

        if (StringUtils.isBlank(data)) {
            logger.error("request api:{}, encode args return null", uri);
            throw new CryptoException("data crypto return null");
        }

        // request interface
        String url = String.format("%s%s", this.cfg.getDomain(), uri);
        Args params = new Args(this.cfg.getAppId(), data);
        String resp;
        if (HttpGet.METHOD_NAME.equalsIgnoreCase(requestMethod)) {
            url += "?" + params.toString();
            resp = HttpClientUtil.getInstance().doGetWithJsonResult(url);
        } else {
            resp = HttpClientUtil.getInstance().doPostWithJsonResult(url, params.toMap());
        }

        this.info("request api: {} raw result:{}", uri, resp);
        // The interface return data is empty
        if (StringUtils.isBlank(resp)) {
            logger.error("request api: {} api return null", uri);
            return null;
        }

        JsonObject jsonObject = JsonParser.parseString(resp).getAsJsonObject();
        if (ObjectUtils.isEmpty(jsonObject)
                || !jsonObject.has("data")
                || StringUtils.isBlank(jsonObject.get("data").getAsString())) {
            // The data returned by the interface does not contain the data field
            logger.error("request api: {}, result do not found data field or data field is empty", uri);
            return null;
        }

        // Decrypt response data
        String respRaw = this.dataCrypto.decode(jsonObject.get("data").getAsString());
        this.info("request api:{} decode result :{}", uri, respRaw);
        if (StringUtils.isBlank(respRaw)) {
            logger.error("request api:{}, decode result return null", uri);
            return null;
        }

        jsonObject = JsonParser.parseString(respRaw).getAsJsonObject();
        if (!ObjectUtils.isEmpty(jsonObject.get("code")) && !"0".equals(jsonObject.get("code").getAsString())) {
            jsonObject.remove("data");
        }

        T result = new GsonBuilder()
                .setFieldNamingStrategy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                .create()
                .fromJson(jsonObject.toString(), clazz);
        if (ObjectUtils.isEmpty(result)) {
            logger.error("request api:{}, result parse json to object error, json:{}", uri, respRaw);
            return null;
        }
        return result;
    }

    protected void info(String format, Object... object) {
        if (this.getCfg().getEnableLog()) {
            logger.info(format, object);
        }
    }
}
