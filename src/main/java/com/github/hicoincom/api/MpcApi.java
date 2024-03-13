package com.github.hicoincom.api;


import com.github.hicoincom.CustodyMpcConfig;
import com.github.hicoincom.api.bean.Args;
import com.github.hicoincom.api.bean.BaseCustodyArgs;
import com.github.hicoincom.crypto.IDataCrypto;
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
public class MpcApi {
    protected static final Logger logger = LoggerFactory.getLogger(MpcApi.class);

    protected IDataCrypto dataCrypto;
    protected CustodyMpcConfig cfg;

    public MpcApi(IDataCrypto dataCrypto, CustodyMpcConfig cfg) {
        this.dataCrypto = dataCrypto;
        this.cfg = cfg;
    }

    public IDataCrypto getDataCrypto() {
        return dataCrypto;
    }

    public void setDataCrypto(IDataCrypto dataCrypto) {
        this.dataCrypto = dataCrypto;
    }

    public CustodyMpcConfig getCfg() {
        return cfg;
    }

    public void setCfg(CustodyMpcConfig cfg) {
        this.cfg = cfg;
    }


    /**
     * call Custody mpc api
     */
    protected <T> T invoke(MpcApiUri uri, BaseCustodyArgs args, Class<T> clazz) {
        // default parameters
        args.setCharset(this.cfg.getCharset());
        args.setTime(System.currentTimeMillis());

        // encryption parameters
        String raw = args.toJson();
        this.info("mpc api:{}, request args:{}", uri.getValue(), raw);
        String data = this.dataCrypto.encode(raw);
        this.info("mpc api: {}, encode args:{}", uri.getValue(), data);

        if (StringUtils.isBlank(data)) {
            logger.error("mpc api:{}, encode args return null", uri.getValue());
            throw new CryptoException("data crypto return null");
        }

        // request interface
        String url = String.format("%s/%s", this.cfg.getDomain(), uri.getValue());
        Args params = new Args(this.cfg.getAppId(), data);
        String resp;
        if (HttpGet.METHOD_NAME.equalsIgnoreCase(uri.getMethod())) {
            url += "?" + params.toString();
            resp = HttpClientUtil.getInstance().doGetWithJsonResult(url);
        } else {
            resp = HttpClientUtil.getInstance().doPostWithJsonResult(url, params.toMap());
        }

        this.info("mpc api: {} raw result:{}", uri.getValue(), resp);
        // The interface return data is empty
        if (StringUtils.isBlank(resp)) {
            logger.error("mpc api: {} api return null", uri.getValue());
            return null;
        }

        JsonObject jsonObject = JsonParser.parseString(resp).getAsJsonObject();
        if (ObjectUtils.isEmpty(jsonObject)
                || !jsonObject.has("data")
                || StringUtils.isBlank(jsonObject.get("data").getAsString())) {
            // The data returned by the interface does not contain the data field
            logger.error("mpc aip: {}, result do not found data field or data field is empty", uri.getValue());
            return null;
        }

        // Decrypt response data
        String respRaw = this.dataCrypto.decode(jsonObject.get("data").getAsString());
        this.info("mpc api:{} decode result :{}", uri.getValue(), respRaw);
        if (StringUtils.isBlank(respRaw)) {
            logger.error("mpc api:{}, decode result return null", uri.getValue());
            return null;
        }
        T result = new GsonBuilder()
                .setFieldNamingStrategy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                .create()
                .fromJson(respRaw, clazz);
        if (ObjectUtils.isEmpty(result)) {
            logger.error("mpc api:{}, result parse json to object error, json:{}", uri.getValue(), respRaw);
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
