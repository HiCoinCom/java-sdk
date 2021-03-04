package com.github.hicoincom.api.bean;


import java.io.Serializable;

/**
 * 转账记录列表参数
 */
public class TransferListArgs extends BaseWaasArgs implements Serializable {

    private static final long serialVersionUID = 1L;

    private String ids;
    /**
     * id 类型（request_id：请求ID（默认）；receipt：转账凭证）
     */
    private String idsType;

    public String getIds() {
        return ids;
    }

    public void setIds(String ids) {
        this.ids = ids;
    }

    public String getIdsType() {
        return idsType;
    }

    public void setIdsType(String idsType) {
        this.idsType = idsType;
    }
}
