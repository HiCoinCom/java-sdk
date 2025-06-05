package com.github.hicoincom.api.bean.mpc;

import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;

/**
 * @author jiamin.bai
 * @since 2025-04-29
 */
public class TronBuyResourceRecord implements Serializable {

    private static final long serialVersionUID = -9095946267485228021L;

    /**
     * buy resource id
     */
    private Integer id;

    /**
     * The unique identifier for buy resource
     */
    @JSONField(name = "request_id")
    private String requestId;

    @JSONField(name = "address_from")
    private String addressFrom;

    @JSONField(name = "service_charge_rate")
    private String serviceChargeRate;

    @JSONField(name = "service_charge")
    private String serviceCharge;

    @JSONField(name = "contract_address")
    private String contractAddress;

    @JSONField(name = "address_to")
    private String addressTo;

    @JSONField(name = "resource_type")
    private Integer resourceType;

    @JSONField(name = "buy_type")
    private Integer buyType;

    @JSONField(name = "net_num")
    private Integer netNum;

    @JSONField(name = "energy_num")
    private Integer energyNum;

    @JSONField(name = "net_txid")
    private String netTxid;

    @JSONField(name = "energy_txid")
    private String energyTxid;

    @JSONField(name = "net_price")
    private String netPrice;

    @JSONField(name = "energy_price")
    private String energyPrice;

    @JSONField(name = "status")
    private Integer status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public String getAddressFrom() {
        return addressFrom;
    }

    public void setAddressFrom(String addressFrom) {
        this.addressFrom = addressFrom;
    }

    public String getServiceChargeRate() {
        return serviceChargeRate;
    }

    public void setServiceChargeRate(String serviceChargeRate) {
        this.serviceChargeRate = serviceChargeRate;
    }

    public String getServiceCharge() {
        return serviceCharge;
    }

    public void setServiceCharge(String serviceCharge) {
        this.serviceCharge = serviceCharge;
    }

    public String getContractAddress() {
        return contractAddress;
    }

    public void setContractAddress(String contractAddress) {
        this.contractAddress = contractAddress;
    }

    public String getAddressTo() {
        return addressTo;
    }

    public void setAddressTo(String addressTo) {
        this.addressTo = addressTo;
    }

    public Integer getResourceType() {
        return resourceType;
    }

    public void setResourceType(Integer resourceType) {
        this.resourceType = resourceType;
    }

    public Integer getBuyType() {
        return buyType;
    }

    public void setBuyType(Integer buyType) {
        this.buyType = buyType;
    }

    public Integer getNetNum() {
        return netNum;
    }

    public void setNetNum(Integer netNum) {
        this.netNum = netNum;
    }

    public Integer getEnergyNum() {
        return energyNum;
    }

    public void setEnergyNum(Integer energyNum) {
        this.energyNum = energyNum;
    }

    public String getNetTxid() {
        return netTxid;
    }

    public void setNetTxid(String netTxid) {
        this.netTxid = netTxid;
    }

    public String getEnergyTxid() {
        return energyTxid;
    }

    public void setEnergyTxid(String energyTxid) {
        this.energyTxid = energyTxid;
    }

    public String getNetPrice() {
        return netPrice;
    }

    public void setNetPrice(String netPrice) {
        this.netPrice = netPrice;
    }

    public String getEnergyPrice() {
        return energyPrice;
    }

    public void setEnergyPrice(String energyPrice) {
        this.energyPrice = energyPrice;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
