package com.github.hicoincom.api.bean.waas;


import com.github.hicoincom.api.bean.Result;

import java.io.Serializable;

/**
 * @author ChainUp Custody
 * User withdrawal result. Note that the interface only returns the status string
 * http://docs.hicoin.vip/zh/latest/API-WaaS-V2/api/billing_syncWithdrawList.html
 */
public class WithdrawResult extends Result<Withdraw> implements Serializable {

    private static final long serialVersionUID = 4145976711610357553L;

}
