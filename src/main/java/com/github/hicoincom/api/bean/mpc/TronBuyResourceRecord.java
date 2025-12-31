package com.github.hicoincom.api.bean.mpc;

import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;

/**
 * TRON buy resource (delegate) record bean.
 * Represents a single buy resource (delegate) operation record returned by the MPC APIs.
 * Contains request identifiers, addresses, resource quantities, txids, times and prices.
 *
 * @author jiamin.bai
 * @since 2025-04-29
 */
public class TronBuyResourceRecord implements Serializable {

    private static final long serialVersionUID = -9095946267485228021L;

    /**
     * internal numeric ID for the buy resource record
     */
    private Integer id;

    /**
     * The unique request identifier for this buy resource operation
     */
    @JSONField(name = "request_id")
    private String requestId;

    /**
     * sender / owner address (address from which the request was made)
     */
    @JSONField(name = "address_from")
    private String addressFrom;

    /**
     * service charge rate (percentage or rate string)
     */
    @JSONField(name = "service_charge_rate")
    private String serviceChargeRate;

    /**
     * service charge amount (string to preserve precision)
     */
    @JSONField(name = "service_charge")
    private String serviceCharge;

    /**
     * related contract address (if any)
     */
    @JSONField(name = "contract_address")
    private String contractAddress;

    /**
     * recipient address for the resource (address to)
     */
    @JSONField(name = "address_to")
    private String addressTo;

    /**
     * resource type (e.g. net=1, energy=2) as defined by API
     */
    @JSONField(name = "resource_type")
    private Integer resourceType;

    /**
     * buy type (purchase subtype defined by API)
     */
    @JSONField(name = "buy_type")
    private Integer buyType;

    /**
     * number of NET units bought
     */
    @JSONField(name = "net_num")
    private Integer netNum;

    /**
     * number of ENERGY units bought
     */
    @JSONField(name = "energy_num")
    private Integer energyNum;

    /**
     * transaction id for NET buy operation
     */
    @JSONField(name = "net_txid")
    private String netTxid;

    /**
     * transaction id for ENERGY buy operation
     */
    @JSONField(name = "energy_txid")
    private String energyTxid;

    /**
     * transaction id for reclaiming NET (if reclaimed)
     */
    @JSONField(name = "reclaim_net_txid")
    private String reclaimNetTxid;

    /**
     * transaction id for reclaiming ENERGY (if reclaimed)
     */
    @JSONField(name = "reclaim_energy_txid")
    private String reclaimEnergyTxid;

    /**
     * timestamp (ms) when NET transaction occurred
     */
    @JSONField(name = "net_time")
    private Long netTime;

    /**
     * timestamp (ms) when ENERGY transaction occurred
     */
    @JSONField(name = "energy_time")
    private Long energyTime;

    /**
     * timestamp (ms) when NET reclaim occurred
     */
    @JSONField(name = "reclaim_net_time")
    private Long reclaimNetTime;

    /**
     * timestamp (ms) when ENERGY reclaim occurred
     */
    @JSONField(name = "reclaim_energy_time")
    private Long reclaimEnergyTime;

    /**
     * NET unit price (string to preserve precision)
     */
    @JSONField(name = "net_price")
    private String netPrice;

    /**
     * ENERGY unit price (string to preserve precision)
     */
    @JSONField(name = "energy_price")
    private String energyPrice;

    /**
     * current status of the buy resource record (status codes as defined by API)
     */
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

    public String getReclaimNetTxid() {
        return reclaimNetTxid;
    }

    public void setReclaimNetTxid(String reclaimNetTxid) {
        this.reclaimNetTxid = reclaimNetTxid;
    }

    public String getReclaimEnergyTxid() {
        return reclaimEnergyTxid;
    }

    public void setReclaimEnergyTxid(String reclaimEnergyTxid) {
        this.reclaimEnergyTxid = reclaimEnergyTxid;
    }

    public Long getNetTime() {
        return netTime;
    }

    public void setNetTime(Long netTime) {
        this.netTime = netTime;
    }

    public Long getEnergyTime() {
        return energyTime;
    }

    public void setEnergyTime(Long energyTime) {
        this.energyTime = energyTime;
    }

    public Long getReclaimNetTime() {
        return reclaimNetTime;
    }

    public void setReclaimNetTime(Long reclaimNetTime) {
        this.reclaimNetTime = reclaimNetTime;
    }

    public Long getReclaimEnergyTime() {
        return reclaimEnergyTime;
    }

    public void setReclaimEnergyTime(Long reclaimEnergyTime) {
        this.reclaimEnergyTime = reclaimEnergyTime;
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
