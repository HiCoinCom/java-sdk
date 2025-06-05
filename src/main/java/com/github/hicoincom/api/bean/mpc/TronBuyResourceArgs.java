package com.github.hicoincom.api.bean.mpc;

import com.alibaba.fastjson.annotation.JSONField;
import com.github.hicoincom.api.bean.BaseArgs;

import java.io.Serializable;

/**
 * @author ChainUp Custody
 * TronBuyResourceArgs args, https://custodydocs-zh.chainup.com/api-references/mpc-apis/apis/tron/delegate-create
 */
public class TronBuyResourceArgs extends BaseArgs implements Serializable {

    private static final long serialVersionUID = 482740789867073520L;

    /**
     * The unique identifier for buy resource
     * required : true
     */
    @JSONField(name = "request_id")
    private String requestId;

    /**
     * buyType
     * required : false
     */
    @JSONField(name = "buy_type")
    private Integer buyType;

    /**
     * resourceType
     * required : false
     */
    @JSONField(name = "resource_type")
    private Integer resourceType;

    /**
     * serviceChargeType
     * required : true
     */
    @JSONField(name = "service_charge_type")
    private String serviceChargeType;

    /**
     * energyNum
     * required : false
     */
    @JSONField(name = "energy_num")
    private Integer energyNum;

    /**
     * netNum
     * required : false
     */
    @JSONField(name = "net_num")
    private Integer netNum;

    /**
     * addressFrom
     * required : true
     */
    @JSONField(name = "address_from")
    private String addressFrom;

    /**
     * addressTo
     * required : false
     */
    @JSONField(name = "address_to")
    private String addressTo;

    /**
     * contractAddress
     * required : false
     */
    @JSONField(name = "contract_address")
    private String contractAddress;

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public Integer getBuyType() {
        return buyType;
    }

    public void setBuyType(Integer buyType) {
        this.buyType = buyType;
    }

    public Integer getResourceType() {
        return resourceType;
    }

    public void setResourceType(Integer resourceType) {
        this.resourceType = resourceType;
    }



    public Integer getEnergyNum() {
        return energyNum;
    }

    public void setEnergyNum(Integer energyNum) {
        this.energyNum = energyNum;
    }

    public Integer getNetNum() {
        return netNum;
    }

    public void setNetNum(Integer netNum) {
        this.netNum = netNum;
    }

    public String getServiceChargeType() {
        return serviceChargeType;
    }

    public void setServiceChargeType(String serviceChargeType) {
        this.serviceChargeType = serviceChargeType;
    }

    public String getAddressFrom() {
        return addressFrom;
    }

    public void setAddressFrom(String addressFrom) {
        this.addressFrom = addressFrom;
    }

    public String getAddressTo() {
        return addressTo;
    }

    public void setAddressTo(String addressTo) {
        this.addressTo = addressTo;
    }

    public String getContractAddress() {
        return contractAddress;
    }

    public void setContractAddress(String contractAddress) {
        this.contractAddress = contractAddress;
    }
}
