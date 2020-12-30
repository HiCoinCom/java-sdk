package com.chainup.waas.api;

import com.chainup.waas.api.bean.*;
import com.chainup.waas.exception.CryptoException;

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
