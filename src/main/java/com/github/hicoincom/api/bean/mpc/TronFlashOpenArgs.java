package com.github.hicoincom.api.bean.mpc;

import com.alibaba.fastjson.annotation.JSONField;
import com.github.hicoincom.api.bean.BaseArgs;

import java.io.Serializable;

/**
 * Arguments for TRON energy flash open.
 *
 * @author ChainUp Custody
 * @since 2026-08-25
 */
public class TronFlashOpenArgs extends BaseArgs implements Serializable {

    private static final long serialVersionUID = 6768010728645184908L;

    /**
     * The unique identifier for the flash open request.
     * required: true
     */
    @JSONField(name = "request_id")
    private String requestId;

    /**
     * Energy amount requested by the user.
     * required: true
     */
    @JSONField(name = "energy_num")
    private Integer energyNum;

    /**
     * Address receiving the energy.
     * required: true
     */
    @JSONField(name = "address_from")
    private String addressFrom;

    /**
     * Fee snapshot supplied by Gas Station for Center fee calculation.
     */
    @JSONField(name = "extend")
    private String extend;

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public Integer getEnergyNum() {
        return energyNum;
    }

    public void setEnergyNum(Integer energyNum) {
        this.energyNum = energyNum;
    }

    public String getAddressFrom() {
        return addressFrom;
    }

    public void setAddressFrom(String addressFrom) {
        this.addressFrom = addressFrom;
    }

    public String getExtend() {
        return extend;
    }

    public void setExtend(String extend) {
        this.extend = extend;
    }

}
