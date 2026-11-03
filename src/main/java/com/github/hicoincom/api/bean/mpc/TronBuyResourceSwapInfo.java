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
     * Address receiving the flash recharge resource.
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
     * Energy originally requested by the user; final billing may be adjusted after reclaim.
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

    /** Staked bandwidth used before flash recharge, excluding free bandwidth. */
    @JSONField(name = "net_used")
    private Integer netUsed;

    /** Staked bandwidth available before flash recharge, excluding free bandwidth. */
    @JSONField(name = "net_num")
    private Integer netNum;

    /** Bandwidth originally requested by the user; final billing may be adjusted after reclaim. */
    @JSONField(name = "buy_net_num")
    private Integer buyNetNum;

    /** Bandwidth actually delegated by Center after applying the recharge caps. */
    @JSONField(name = "send_net_num")
    private Integer sendNetNum;

    /** Staked bandwidth used after reclaim is complete, excluding free bandwidth. */
    @JSONField(name = "end_net_used")
    private Integer endNetUsed;

    /** Staked bandwidth available after reclaim is complete, excluding free bandwidth. */
    @JSONField(name = "end_net_num")
    private Integer endNetNum;

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
    /** Get staked bandwidth used before flash recharge, excluding free bandwidth. */
    public Integer getNetUsed() {
        return netUsed;
    }

    /** Set staked bandwidth used before flash recharge, excluding free bandwidth. */
    public void setNetUsed(Integer netUsed) {
        this.netUsed = netUsed;
    }

    /** Get staked bandwidth available before flash recharge, excluding free bandwidth. */
    public Integer getNetNum() {
        return netNum;
    }

    /** Set staked bandwidth available before flash recharge, excluding free bandwidth. */
    public void setNetNum(Integer netNum) {
        this.netNum = netNum;
    }

    /** Get bandwidth originally requested by the user; final billing may be adjusted after reclaim. */
    public Integer getBuyNetNum() {
        return buyNetNum;
    }

    /** Set bandwidth originally requested by the user; final billing may be adjusted after reclaim. */
    public void setBuyNetNum(Integer buyNetNum) {
        this.buyNetNum = buyNetNum;
    }

    /** Get bandwidth actually delegated by Center after applying the recharge caps. */
    public Integer getSendNetNum() {
        return sendNetNum;
    }

    /** Set bandwidth actually delegated by Center after applying the recharge caps. */
    public void setSendNetNum(Integer sendNetNum) {
        this.sendNetNum = sendNetNum;
    }

    /** Get staked bandwidth used after reclaim is complete, excluding free bandwidth. */
    public Integer getEndNetUsed() {
        return endNetUsed;
    }

    /** Set staked bandwidth used after reclaim is complete, excluding free bandwidth. */
    public void setEndNetUsed(Integer endNetUsed) {
        this.endNetUsed = endNetUsed;
    }

    /** Get staked bandwidth available after reclaim is complete, excluding free bandwidth. */
    public Integer getEndNetNum() {
        return endNetNum;
    }

    /** Set staked bandwidth available after reclaim is complete, excluding free bandwidth. */
    public void setEndNetNum(Integer endNetNum) {
        this.endNetNum = endNetNum;
    }

}
