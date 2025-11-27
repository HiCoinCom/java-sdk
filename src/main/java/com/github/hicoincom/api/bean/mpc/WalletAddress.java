package com.github.hicoincom.api.bean.mpc;

import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;

/**
 * @author ChainUp Custody
 */
public class WalletAddress implements Serializable {

    private static final long serialVersionUID = 3962401229470065720L;

    /**
     * custody address id
     */
    private Integer id;

    /**
     * Created address
     */
    private String address;

    /**
     * Address type, 1: User address, 2: System address (including sweeping address, change address).
     * System addresses cannot be assigned to users for use; change in UTXO transactions will be directed to the change address
     */
    @JSONField(name = "addr_type")
    private Integer addrType;


    /**
     * Memo assigned for Memo types under the main chain
     */
    private String memo;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getAddrType() {
        return addrType;
    }

    public void setAddrType(Integer addrType) {
        this.addrType = addrType;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }
}
