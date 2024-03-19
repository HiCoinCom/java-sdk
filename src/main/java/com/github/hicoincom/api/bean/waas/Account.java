package com.github.hicoincom.api.bean.waas;


import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author ChainUp Custody
 */
public class Account implements Serializable {

    private static final long serialVersionUID = 6146964330571988112L;

    private BigDecimal balance;

    private String symbol;

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }
}
