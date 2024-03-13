package com.github.hicoincom.api.bean.custody;


import com.alibaba.fastjson.annotation.JSONField;
import com.github.hicoincom.api.bean.BaseWaasArgs;

import java.io.Serializable;

/**
 * Transfer Record List Parameters
 */
public class TransferListArgs extends BaseWaasArgs implements Serializable {

    private static final long serialVersionUID = 1L;

    private String ids;
    /**
     * id type（request_id：request ID（default）；receipt：） ids_type
     */
    @JSONField(name = "ids_type")
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
