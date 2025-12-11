package com.github.hicoincom.api.bean.mpc;

import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;

/**
 * @author jiamin.bai
 * @since 2025-12-11
 */
public class TronFeeRule implements Serializable {

    private static final long serialVersionUID = -4924070205674458119L;

    @JSONField(name = "energy_service_charge_rate")
    private String energyServiceChargeRate;

    @JSONField(name = "net_service_charge_rate")
    private String netServiceChargeRate;

    @JSONField(name = "api_service_charge_rate")
    private String apiServiceChargeRate;

    public String getEnergyServiceChargeRate() {
        return energyServiceChargeRate;
    }

    public void setEnergyServiceChargeRate(String energyServiceChargeRate) {
        this.energyServiceChargeRate = energyServiceChargeRate;
    }

    public String getApiServiceChargeRate() {
        return apiServiceChargeRate;
    }

    public void setApiServiceChargeRate(String apiServiceChargeRate) {
        this.apiServiceChargeRate = apiServiceChargeRate;
    }

    public String getNetServiceChargeRate() {
        return netServiceChargeRate;
    }

    public void setNetServiceChargeRate(String netServiceChargeRate) {
        this.netServiceChargeRate = netServiceChargeRate;
    }
}
