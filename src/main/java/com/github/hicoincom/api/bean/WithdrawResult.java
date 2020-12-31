package com.github.hicoincom.api.bean;


import java.io.Serializable;

/**
 *  用户提现结果 注意接口只返回了status字段
 *  http://docs.hicoin.vip/zh/latest/API-WaaS-V2/api/billing_syncWithdrawList.html
 */
public class WithdrawResult extends Result<Withdraw> implements Serializable {
    private static final long serialVersionUID = 1L;
}
