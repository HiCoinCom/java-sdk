package com.github.hicoincom.api.bean.custody;


import com.github.hicoincom.api.bean.Result;

import java.io.Serializable;
import java.util.List;

/**
 *  user withdrawal records
 *  http://docs.hicoin.vip/zh/latest/API-WaaS-V2/api/billing_syncWithdrawList.html
 */
public class WithdrawListResult extends Result<List<Withdraw>> implements Serializable {
    private static final long serialVersionUID = 1L;

}
