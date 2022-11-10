package com.github.hicoincom.api.bean;


import java.io.Serializable;
import java.util.List;

/**
 *  Batch query withdrawal and recharge records
 *  http://docs.hicoin.vip/zh/latest/API-WaaS-V2/api/billing_depositList.html
 */
public class DepositListResult extends Result<List<Deposit>> implements Serializable {
    private static final long serialVersionUID = 1L;
}
