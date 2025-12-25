package com.github.hicoincom.api.bean.waas;


import java.io.Serializable;

/**
 * @author ChainUp Custody
 */
public class UserAddress implements Serializable {

    private static final long serialVersionUID = -8412092540025155623L;

    /**
     * Just for api: address/syncList, dot not use for other api
     */
    private Integer id;

    private Integer uid;

    private String address;

    private String symbol;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }
}
