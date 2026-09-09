package com.github.hicoincom.api.bean.mpc;

import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;

/**
 * TRON resource flash/swap details nested in a buy resource record.
 */
public class TronBuyResourceSwapInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * Service charge type. Flash recharge records use 10000.
     */
    @JSONField(name = "service_charge_type")
    private String serviceChargeType;

    /**
     * Address receiving the flash recharge energy.
     */
    private String address;

    /**
     * Energy used by the address before flash recharge.
     */
    @JSONField(name = "energy_used")
    private Integer energyUsed;

    /**
     * Energy available to the address before flash recharge.
     */
    @JSONField(name = "energy_num")
    private Integer energyNum;

    /**
     * Energy requested by the user and used as the final billing quantity.
     */
    @JSONField(name = "buy_energy_num")
    private Integer buyEnergyNum;

    /**
     * Energy actually delegated by Center after applying the flash recharge rule.
     */
    @JSONField(name = "send_energy_num")
    private Integer sendEnergyNum;

    /**
     * Energy used by the address after reclaim is complete.
     */
    @JSONField(name = "end_energy_used")
    private Integer endEnergyUsed;

    /**
     * Energy available to the address after reclaim is complete.
     */
    @JSONField(name = "end_energy_num")
    private Integer endEnergyNum;

    /**
     * Reclaim snapshot status: 0 means pending and 1 means completed.
     */
    @JSONField(name = "snapshot_status")
    private Integer snapshotStatus;

    public String getServiceChargeType() {
        return serviceChargeType;
    }

    public void setServiceChargeType(String serviceChargeType) {
        this.serviceChargeType = serviceChargeType;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getEnergyUsed() {
        return energyUsed;
    }

    public void setEnergyUsed(Integer energyUsed) {
        this.energyUsed = energyUsed;
    }

    public Integer getEnergyNum() {
        return energyNum;
    }

    public void setEnergyNum(Integer energyNum) {
        this.energyNum = energyNum;
    }

    public Integer getBuyEnergyNum() {
        return buyEnergyNum;
    }

    public void setBuyEnergyNum(Integer buyEnergyNum) {
        this.buyEnergyNum = buyEnergyNum;
    }

    public Integer getSendEnergyNum() {
        return sendEnergyNum;
    }

    public void setSendEnergyNum(Integer sendEnergyNum) {
        this.sendEnergyNum = sendEnergyNum;
    }

    public Integer getEndEnergyUsed() {
        return endEnergyUsed;
    }

    public void setEndEnergyUsed(Integer endEnergyUsed) {
        this.endEnergyUsed = endEnergyUsed;
    }

    public Integer getEndEnergyNum() {
        return endEnergyNum;
    }

    public void setEndEnergyNum(Integer endEnergyNum) {
        this.endEnergyNum = endEnergyNum;
    }

    public Integer getSnapshotStatus() {
        return snapshotStatus;
    }

    public void setSnapshotStatus(Integer snapshotStatus) {
        this.snapshotStatus = snapshotStatus;
    }
}
