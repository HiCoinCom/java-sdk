package com.chainup.waas.service;

import com.chainup.waas.request.*;


/**
 * @author chainup waas
 */
public interface RequestWaasService {

    /**
     * 用户手机注册
     *
     * @param param         手机注册用户请求参数数据
     * @param encryptPriKey 请求waas数据加密私钥
     * @param decodePubKey  解密waas返回数据公钥
     * @param appId         appId
     * @param waasDomain    waas域名
     */
    String registerUserByMobile(RegisterUserByMobile param, String encryptPriKey, String decodePubKey, String appId, String waasDomain);

    /**
     * 用户邮箱（虚拟账号）注册
     *
     * @param param         邮箱注册用户请求参数数据
     * @param encryptPriKey 请求waas数据加密私钥
     * @param decodePubKey  解密waas返回数据公钥
     * @param appId         appId
     * @param waasDomain    waas域名
     */
    String registerUserByEmail(RegisterUserByEmail param, String encryptPriKey, String decodePubKey, String appId, String waasDomain);


    /**
     * 查询用户信息
     *
     * @param param         查询用户信息请求参数
     * @param encryptPriKey 请求waas数据加密私钥
     * @param decodePubKey  解密waas返回数据公钥
     * @param appId         appId
     * @param waasDomain    waas域名
     */
    String userInfo(QueryUserInfo param, String encryptPriKey, String decodePubKey, String appId, String waasDomain);


    /**
     * 获取商户的币种列表
     *
     * @param param         获取币种列表请求参数
     * @param encryptPriKey 请求waas数据加密私钥
     * @param decodePubKey  解密waas返回数据公钥
     * @param appId         appId
     * @param waasDomain    waas域名
     */
    String coinList(CommonParam param, String encryptPriKey, String decodePubKey, String appId, String waasDomain);


    /**
     * 获取用户指定币账户
     *
     * @param param         获取用户指定币账户请求参数
     * @param encryptPriKey 请求waas数据加密私钥
     * @param decodePubKey  解密waas返回数据公钥
     * @param appId         appId
     * @param waasDomain    waas域名
     */
    String userSymbolAccount(UserSymbolAccount param, String encryptPriKey, String decodePubKey, String appId, String waasDomain);


    /**
     * 获取商户归集账户余额
     *
     * @param param         获取商户归集账户余额请求参数
     * @param encryptPriKey 请求waas数据加密私钥
     * @param decodePubKey  解密waas返回数据公钥
     * @param appId         appId
     * @param waasDomain    waas域名
     */
    String collectionAccountBalance(CollectionAccountBalance param, String encryptPriKey, String decodePubKey, String appId, String waasDomain);

    /**
     * 获取用户指定币账户地址
     *
     * @param param         获取用户指定币账户地址请求参数
     * @param encryptPriKey 请求waas数据加密私钥
     * @param decodePubKey  解密waas返回数据公钥
     * @param appId         appId
     * @param waasDomain    waas域名
     */
    String userDepositAddress(UserSymbolAccount param, String encryptPriKey, String decodePubKey, String appId, String waasDomain);

    /**
     * 提现操作
     *
     * @param param         提现操作请求参数
     * @param encryptPriKey 请求waas数据加密私钥
     * @param decodePubKey  解密waas返回数据公钥
     * @param appId         appId
     * @param waasDomain    waas域名
     */
    String withdraw(Withdraw param, String encryptPriKey, String decodePubKey, String appId, String waasDomain);


    /**
     * 同步提现记录
     *
     * @param param         同步提现记录请求参数
     * @param encryptPriKey 请求waas数据加密私钥
     * @param decodePubKey  解密waas返回数据公钥
     * @param appId         appId
     * @param waasDomain    waas域名
     */
    String syncWithdraw(SyncWithdraw param, String encryptPriKey, String decodePubKey, String appId, String waasDomain);


    /**
     * 批量获取提现记录
     *
     * @param param         批量获取提现记录请求参数
     * @param encryptPriKey 请求waas数据加密私钥
     * @param decodePubKey  解密waas返回数据公钥
     * @param appId         appId
     * @param waasDomain    waas域名
     */
    String withdrawList(SyncWithdraw param, String encryptPriKey, String decodePubKey, String appId, String waasDomain);

    /**
     * 同步充值记录
     *
     * @param param         同步充值记录请求参数
     * @param encryptPriKey 请求waas数据加密私钥
     * @param decodePubKey  解密waas返回数据公钥
     * @param appId         appId
     * @param waasDomain    waas域名
     */
    String syncDeposit(SyncDeposit param, String encryptPriKey, String decodePubKey, String appId, String waasDomain);

    /**
     * 批量获取充值记录
     *
     * @param param         批量获取充值记录请求参数
     * @param encryptPriKey 请求waas数据加密私钥
     * @param decodePubKey  解密waas返回数据公钥
     * @param appId         appId
     * @param waasDomain    waas域名
     */
    String depositList(SyncDeposit param, String encryptPriKey, String decodePubKey, String appId, String waasDomain);

    /**
     * 请求waas post方式接口
     *
     * @param param
     * @param encryptPriKey
     * @param decodePubKey
     * @param appId
     * @param url
     * @return
     */
    String doPost(RequestParams param, String encryptPriKey, String decodePubKey, String appId, String url);

    /**
     * 请求waas get方式接口
     *
     * @param param         请求参数
     * @param encryptPriKey 请求waas数据加密私钥
     * @param decodePubKey  解密waas返回数据公钥
     * @param appId         appId
     * @param url           请求地址
     * @return
     */
    String doGet(RequestParams param, String encryptPriKey, String decodePubKey, String appId, String url);


    /**
     * 请求waas get方式接口
     *
     * @param paramJson     请求参数json串
     * @param encryptPriKey 请求waas数据加密私钥
     * @param decodePubKey  解密waas返回数据公钥
     * @param appId         appId
     * @param url           请求地址
     * @return
     */
    String doGet(String paramJson, String encryptPriKey, String decodePubKey, String appId, String url);

    /**
     * 请求waas post方式接口
     *
     * @param paramJson     请求参数json串
     * @param encryptPriKey 请求waas数据加密私钥
     * @param decodePubKey  解密waas返回数据公钥
     * @param appId         appId
     * @param url           请求地址
     * @return
     */
    String doPost(String paramJson, String encryptPriKey, String decodePubKey, String appId, String url);


}
