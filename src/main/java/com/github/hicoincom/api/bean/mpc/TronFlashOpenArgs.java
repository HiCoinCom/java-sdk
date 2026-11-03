package com.github.hicoincom.api.bean.mpc;

import com.alibaba.fastjson.annotation.JSONField;
import com.github.hicoincom.api.bean.BaseArgs;

import java.io.Serializable;

/**
 * Arguments for TRON energy or bandwidth flash open.
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
     * Required for energy flash recharge; otherwise omit or pass zero.
     */
    @JSONField(name = "energy_num")
    private Integer energyNum;

    /**
     * Resource type: 1 means energy, 2 means bandwidth. Omit to default to energy.
     */
    @JSONField(name = "resource_type")
    private Integer resourceType;

    /**
     * Bandwidth amount requested by the user. Required for bandwidth flash recharge;
     * otherwise omit or pass zero.
     */
    @JSONField(name = "net_num")
    private Integer netNum;

    /**
     * Address receiving the requested resource.
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

    /** Get the requested resource type; null uses the server's energy default. */
    public Integer getResourceType() {
        return resourceType;
    }

    /** Set the resource type: 1 for energy, 2 for bandwidth. */
    public void setResourceType(Integer resourceType) {
        this.resourceType = resourceType;
    }

    /** Get the requested bandwidth amount. */
    public Integer getNetNum() {
        return netNum;
    }

    /** Set the requested bandwidth amount. */
    public void setNetNum(Integer netNum) {
        this.netNum = netNum;
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
