package com.github.hicoincom.api;

import com.github.hicoincom.api.bean.DepositListResult;
import com.github.hicoincom.api.bean.WithdrawArgs;
import com.github.hicoincom.api.bean.WithdrawResult;
import com.github.hicoincom.api.bean.WithdrawListResult;

import java.util.List;

/**
 *  资金相关api
 */
public interface IBillingApi {
    WithdrawResult Withdraw(WithdrawArgs args)  throws Exception;

    WithdrawListResult WithdrawList(List<String> requestIdList)  throws Exception;

    WithdrawListResult SyncWithdrawList(int maxId)  throws Exception;

    DepositListResult DepositList(List<Integer> waasIdList)  throws Exception;

    DepositListResult SyncDepositList(int maxId)  throws Exception;
}
