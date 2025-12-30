package com.github.hicoincom.api.bean.mpc;

import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;

/**
 * Example JSON item:
 * {"resource_type":"energy","single_price_trx":"3.000396","type":"10010","price_sun":"46.59"}
 *
 * @author jiamin.bai
 * @since 2025-12-30
 */
public class TronFeeRule implements Serializable {
    private static final long serialVersionUID = -872345672345672345L;

    @JSONField(name = "resource_type")
    private String resourceType;

    @JSONField(name = "single_price_trx")
    private String singlePriceTrx;

    @JSONField(name = "type")
    private String type;

    @JSONField(name = "price_sun")
    private String priceSun;

    public String getResourceType() {
        return resourceType;
    }

    public void setResourceType(String resourceType) {
        this.resourceType = resourceType;
    }

    public String getSinglePriceTrx() {
        return singlePriceTrx;
    }

    public void setSinglePriceTrx(String singlePriceTrx) {
        this.singlePriceTrx = singlePriceTrx;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPriceSun() {
        return priceSun;
    }

    public void setPriceSun(String priceSun) {
        this.priceSun = priceSun;
    }

}
