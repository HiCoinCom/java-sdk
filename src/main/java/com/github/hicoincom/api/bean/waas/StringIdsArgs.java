package com.github.hicoincom.api.bean.waas;

import com.alibaba.fastjson.annotation.JSONField;
import com.github.hicoincom.api.bean.BaseArgs;

import java.io.Serializable;

/**
 * @author ChainUp Custody
 * Batch query withdrawal records
 * http://docs.hicoin.vip/zh/latest/API-WaaS-V2/api/billing_withdrawList.html
 */
public class StringIdsArgs extends BaseArgs implements Serializable {

    private static final long serialVersionUID = 7418332321561807830L;

    @JSONField(name ="ids")
    private String idList;

    public String getIdList() {
        return idList;
    }

    public void setIdList(String idList) {
        this.idList = idList;
    }
}
