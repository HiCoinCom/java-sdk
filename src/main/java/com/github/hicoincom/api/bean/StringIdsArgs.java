package com.github.hicoincom.api.bean;


import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;

/**
 *  批量查询提现记录
 *  http://docs.hicoin.vip/zh/latest/API-WaaS-V2/api/billing_withdrawList.html
 */
public class StringIdsArgs extends BaseWaasArgs implements Serializable {

    private static final long serialVersionUID = 1L;

    @JSONField(name ="ids")
    private String idList;

    public String getIdList() {
        return idList;
    }

    public void setIdList(String idList) {
        this.idList = idList;
    }
}
