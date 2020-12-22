package com.chainup.waas.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.chainup.waas.constant.WaasUrlConstant;
import com.chainup.waas.request.*;
import com.chainup.waas.response.CommonResult;
import com.chainup.waas.service.RequestWaasService;
import com.chainup.waas.util.HttpClientUtil;
import com.chainup.waas.util.RSAHelper;
import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * @author chainup waas
 */
public class RequestWaasServiceImpl implements RequestWaasService {

    private String paramErrorMsg = "请求参数%s不合法";

    @Override
    public String registerUserByMobile(RegisterUserByMobile param, String encryptPriKey, String decodePubKey, String appId, String waasDomain) {
        String errorParam = this.checkCommonParam(param);
        if (StringUtils.isNotBlank(errorParam)) {
            return JSONObject.toJSONString(CommonResult.PARAM_FAIL(String.format(paramErrorMsg, errorParam)));
        }
        if (StringUtils.isBlank(param.getCountry())) {
            return JSONObject.toJSONString(CommonResult.PARAM_FAIL(String.format(paramErrorMsg, "country")));
        }
        if (StringUtils.isBlank(param.getMobile())) {
            return JSONObject.toJSONString(CommonResult.PARAM_FAIL(String.format(paramErrorMsg, "mobile")));
        }
        String encryptParams = RSAHelper.encryptByPrivateKey(JSONObject.toJSONString(param), encryptPriKey);
        return this.doPost(appId, encryptParams, waasDomain + WaasUrlConstant.CREATE_USER_MOBILE, decodePubKey);
    }

    @Override
    public String registerUserByEmail(RegisterUserByEmail param, String encryptPriKey, String decodePubKey, String appId, String waasDomain) {
        String errorParam = this.checkCommonParam(param);
        if (StringUtils.isNotBlank(errorParam)) {
            return JSONObject.toJSONString(CommonResult.PARAM_FAIL(String.format(paramErrorMsg, errorParam)));
        }
        if (StringUtils.isBlank(param.getEmail())) {
            return JSONObject.toJSONString(CommonResult.PARAM_FAIL(String.format(paramErrorMsg, "email")));
        }
        String encryptParams = RSAHelper.encryptByPrivateKey(JSONObject.toJSONString(param), encryptPriKey);
        System.out.println("加密数据：" + encryptParams);
        return this.doPost(appId, encryptParams, waasDomain + WaasUrlConstant.CREATE_USER_EMAIL, decodePubKey);
    }

    @Override
    public String userInfo(QueryUserInfo param, String encryptPriKey, String decodePubKey, String appId, String waasDomain) {
        String errorParam = this.checkCommonParam(param);
        if (StringUtils.isNotBlank(errorParam)) {
            return JSONObject.toJSONString(CommonResult.PARAM_FAIL(String.format(paramErrorMsg, errorParam)));
        }
        if (StringUtils.isBlank(param.getEmail()) && StringUtils.isBlank(param.getMobile())) {
            return JSONObject.toJSONString(CommonResult.PARAM_FAIL(String.format(paramErrorMsg, "email或者mobile")));
        }
        if (StringUtils.isBlank(param.getMobile()) && StringUtils.isBlank(param.getCountry())) {
            return JSONObject.toJSONString(CommonResult.PARAM_FAIL(String.format(paramErrorMsg, "country")));
        }
        String encryptParams = RSAHelper.encryptByPrivateKey(JSONObject.toJSONString(param), encryptPriKey);
        return this.doGet(appId, encryptParams, waasDomain + WaasUrlConstant.GET_USER_INFO, decodePubKey);
    }

    @Override
    public String coinList(CommonParam param, String encryptPriKey, String decodePubKey, String appId, String waasDomain) {
        String errorParam = this.checkCommonParam(param);
        if (StringUtils.isNotBlank(errorParam)) {
            return JSONObject.toJSONString(CommonResult.PARAM_FAIL(String.format(paramErrorMsg, errorParam)));
        }
        String encryptParams = RSAHelper.encryptByPrivateKey(JSONObject.toJSONString(param), encryptPriKey);
        return this.doGet(appId, encryptParams, waasDomain + WaasUrlConstant.COIN_LIST, decodePubKey);
    }

    @Override
    public String userSymbolAccount(UserSymbolAccount param, String encryptPriKey, String decodePubKey, String appId, String waasDomain) {
        String errorParam = this.checkCommonParam(param);
        if (StringUtils.isNotBlank(errorParam)) {
            return JSONObject.toJSONString(CommonResult.PARAM_FAIL(String.format(paramErrorMsg, errorParam)));
        }
        if (StringUtils.isBlank(param.getSymbol())) {
            return JSONObject.toJSONString(CommonResult.PARAM_FAIL(String.format(paramErrorMsg, "symbol")));
        }
        if (StringUtils.isBlank(param.getUid())) {
            return JSONObject.toJSONString(CommonResult.PARAM_FAIL(String.format(paramErrorMsg, "uid")));
        }
        String encryptParams = RSAHelper.encryptByPrivateKey(JSONObject.toJSONString(param), encryptPriKey);
        return this.doGet(appId, encryptParams, waasDomain + WaasUrlConstant.USER_SYMBOL_ACCOUNT, decodePubKey);
    }

    @Override
    public String collectionAccountBalance(CollectionAccountBalance param, String encryptPriKey, String decodePubKey, String appId, String waasDomain) {
        String errorParam = this.checkCommonParam(param);
        if (StringUtils.isNotBlank(errorParam)) {
            return JSONObject.toJSONString(CommonResult.PARAM_FAIL(String.format(paramErrorMsg, errorParam)));
        }
        if (StringUtils.isBlank(param.getSymbol())) {
            return JSONObject.toJSONString(CommonResult.PARAM_FAIL(String.format(paramErrorMsg, "symbol")));
        }
        String encryptParams = RSAHelper.encryptByPrivateKey(JSONObject.toJSONString(param), encryptPriKey);
        return this.doGet(appId, encryptParams, waasDomain + WaasUrlConstant.COMPANY_SYMBOL_ACCOUNT, decodePubKey);
    }

    @Override
    public String userDepositAddress(UserSymbolAccount param, String encryptPriKey, String decodePubKey, String appId, String waasDomain) {
        String errorParam = this.checkCommonParam(param);
        if (StringUtils.isNotBlank(errorParam)) {
            return JSONObject.toJSONString(CommonResult.PARAM_FAIL(String.format(paramErrorMsg, errorParam)));
        }
        if (StringUtils.isBlank(param.getSymbol())) {
            return JSONObject.toJSONString(CommonResult.PARAM_FAIL(String.format(paramErrorMsg, "symbol")));
        }
        if (StringUtils.isBlank(param.getUid())) {
            return JSONObject.toJSONString(CommonResult.PARAM_FAIL(String.format(paramErrorMsg, "uid")));
        }
        String encryptParams = RSAHelper.encryptByPrivateKey(JSONObject.toJSONString(param), encryptPriKey);
        return this.doPost(appId, encryptParams, waasDomain + WaasUrlConstant.USER_DEPOSIT_ADDRESS, decodePubKey);
    }

    @Override
    public String withdraw(Withdraw param, String encryptPriKey, String decodePubKey, String appId, String waasDomain) {
        String errorParam = this.checkCommonParam(param);
        if (StringUtils.isNotBlank(errorParam)) {
            return JSONObject.toJSONString(CommonResult.PARAM_FAIL(String.format(paramErrorMsg, errorParam)));
        }
        if (StringUtils.isBlank(param.getRequest_id())) {
            return JSONObject.toJSONString(CommonResult.PARAM_FAIL(String.format(paramErrorMsg, "request_id")));
        }
        if (StringUtils.isBlank(param.getFrom_uid())) {
            return JSONObject.toJSONString(CommonResult.PARAM_FAIL(String.format(paramErrorMsg, "from_uid")));
        }
        if (StringUtils.isBlank(param.getTo_address())) {
            return JSONObject.toJSONString(CommonResult.PARAM_FAIL(String.format(paramErrorMsg, "to_address")));
        }
        if (StringUtils.isBlank(param.getAmount())) {
            return JSONObject.toJSONString(CommonResult.PARAM_FAIL(String.format(paramErrorMsg, "amount")));
        }
        if (StringUtils.isBlank(param.getSymbol())) {
            return JSONObject.toJSONString(CommonResult.PARAM_FAIL(String.format(paramErrorMsg, "symbol")));
        }
        String encryptParams = RSAHelper.encryptByPrivateKey(JSONObject.toJSONString(param), encryptPriKey);
        return this.doPost(appId, encryptParams, waasDomain + WaasUrlConstant.BILLING_WITHDRAW, decodePubKey);

    }

    @Override
    public String syncWithdraw(SyncWithdraw param, String encryptPriKey, String decodePubKey, String appId, String waasDomain) {
        String errorParam = this.checkCommonParam(param);
        if (StringUtils.isNotBlank(errorParam)) {
            return JSONObject.toJSONString(CommonResult.PARAM_FAIL(String.format(paramErrorMsg, errorParam)));
        }
        if (StringUtils.isBlank(param.getMax_id())) {
            return JSONObject.toJSONString(CommonResult.PARAM_FAIL(String.format(paramErrorMsg, "max_id")));
        }
        String encryptParams = RSAHelper.encryptByPrivateKey(JSONObject.toJSONString(param), encryptPriKey);
        return this.doGet(appId, encryptParams, waasDomain + WaasUrlConstant.SYNC_WITHDRAW, decodePubKey);
    }

    @Override
    public String withdrawList(SyncWithdraw param, String encryptPriKey, String decodePubKey, String appId, String waasDomain) {
        String errorParam = this.checkCommonParam(param);
        if (StringUtils.isNotBlank(errorParam)) {
            return JSONObject.toJSONString(CommonResult.PARAM_FAIL( String.format(paramErrorMsg, errorParam)));
        }
        if (StringUtils.isBlank(param.getIds())) {
            return JSONObject.toJSONString(CommonResult.PARAM_FAIL(String.format(paramErrorMsg, "ids")));
        }
        String encryptParams = RSAHelper.encryptByPrivateKey(JSONObject.toJSONString(param), encryptPriKey);
        return this.doGet(appId, encryptParams, waasDomain + WaasUrlConstant.WITHDRAW_LIST, decodePubKey);
    }

    @Override
    public String syncDeposit(SyncDeposit param, String encryptPriKey, String decodePubKey, String appId, String waasDomain) {
        String errorParam = this.checkCommonParam(param);
        if (StringUtils.isNotBlank(errorParam)) {
            return JSONObject.toJSONString(CommonResult.PARAM_FAIL(String.format(paramErrorMsg, errorParam)));
        }
        if (StringUtils.isBlank(param.getMax_id())) {
            return JSONObject.toJSONString(CommonResult.PARAM_FAIL(String.format(paramErrorMsg, "max_id")));
        }
        String encryptParams = RSAHelper.encryptByPrivateKey(JSONObject.toJSONString(param), encryptPriKey);
        return this.doGet(appId, encryptParams, waasDomain + WaasUrlConstant.SYNC_DEPOSIT, decodePubKey);
    }

    @Override
    public String depositList(SyncDeposit param, String encryptPriKey, String decodePubKey, String appId, String waasDomain) {
        String errorParam = this.checkCommonParam(param);
        if (StringUtils.isNotBlank(errorParam)) {
            return JSONObject.toJSONString(CommonResult.PARAM_FAIL(String.format(paramErrorMsg, errorParam)));
        }
        if (StringUtils.isBlank(param.getIds())) {
            return JSONObject.toJSONString(CommonResult.PARAM_FAIL(String.format(paramErrorMsg, "ids")));
        }
        String encryptParams = RSAHelper.encryptByPrivateKey(JSONObject.toJSONString(param), encryptPriKey);
        return this.doGet(appId, encryptParams, waasDomain + WaasUrlConstant.DEPOSIT_LIST, decodePubKey);
    }

    @Override
    public String doPost(RequestParams param, String encryptPriKey, String decodePubKey, String appId, String url) {
        String encryptParams = RSAHelper.encryptByPrivateKey(JSONObject.toJSONString(param), encryptPriKey);
        return this.doPost(appId, encryptParams, url, decodePubKey);
    }

    @Override
    public String doGet(RequestParams param, String encryptPriKey, String decodePubKey, String appId, String url) {
        String encryptParams = RSAHelper.encryptByPrivateKey(JSONObject.toJSONString(param), encryptPriKey);
        return this.doGet(appId, encryptParams, url, decodePubKey);
    }

    @Override
    public String doGet(String paramJson, String encryptPriKey, String decodePubKey, String appId, String url) {
        String encryptParams = RSAHelper.encryptByPrivateKey(paramJson, encryptPriKey);
        return this.doGet(appId, encryptParams, url, decodePubKey);
    }

    @Override
    public String doPost(String paramJson, String encryptPriKey, String decodePubKey, String appId, String url) {
        String encryptParams = RSAHelper.encryptByPrivateKey(paramJson, encryptPriKey);
        return this.doPost(appId, encryptParams, url, decodePubKey);
    }

    /**
     * 公共参数校验
     *
     * @return 返回错误参数名称，没有错误返回空串
     */
    private String checkCommonParam(CommonParam param) {
        if (StringUtils.isBlank(param.getCharset())) {
            return "charset";
        }
        if (StringUtils.isBlank(param.getVersion())) {
            return "version";
        }
        if (param.getTime() == null) {
            return "time";
        }
        return "";
    }

    private String doPost(String appId, String encryptParams, String url, String decodePubKey) {
        Map<String, String> reqParam = new HashMap<>(2, 1);
        reqParam.put("app_id", appId);
        reqParam.put("data", encryptParams);
        String resp = HttpClientUtil.getInstance().doPostWithJsonResult(url, reqParam);
        return this.dealRequestResult(resp, decodePubKey, encryptParams);
    }

    private String doGet(String appId, String encryptParams, String url, String decodePubKey) {
        url = String.format("%s?app_id=%s&data=%s", url, appId, encryptParams);
        String resp = HttpClientUtil.getInstance().doGetWithJsonResult(url);
        return  this.dealRequestResult(resp, decodePubKey, encryptParams);
    }

    private String dealRequestResult(String response, String decodePubKey, String encryptParams) {
        String data = "";
        if (StringUtils.isNotBlank(response)) {
            JSONObject jsonObject = JSONObject.parseObject(response);
            if(jsonObject != null && jsonObject.containsKey("data")){
                data = RSAHelper.decryptByPublicKey(jsonObject.getString("data"), decodePubKey);
            } else {
                data = this.requestError(encryptParams);
            }
        } else {
            data = this.requestError(encryptParams);
        }
        return data;
    }

    private String requestError(String encryptParams) {
        Map<String, String> data = new HashMap<>(1, 1);
        data.put("encryptParams", encryptParams);
        return JSONObject.toJSONString(CommonResult.FAIL("100001", "请求waas失败", data));
    }

}
