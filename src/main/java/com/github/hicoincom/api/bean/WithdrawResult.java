package com.github.hicoincom.api.bean;


import java.io.Serializable;

/**
 *  Note that the interface only returns the status field
 *  http://docs.hicoin.vip/zh/latest/API-WaaS-V2/api/billing_syncWithdrawList.html
 */
public class WithdrawResult extends Result<Withdraw> implements Serializable {
    private static final long serialVersionUID = 1L;
}
