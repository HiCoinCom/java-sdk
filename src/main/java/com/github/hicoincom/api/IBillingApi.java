package com.github.hicoincom.api;

import com.github.hicoincom.api.bean.*;

import java.util.List;

/**
 *  Funding related APIs
 */
public interface IBillingApi {
    WithdrawResult Withdraw(WithdrawArgs args) ;

    WithdrawListResult WithdrawList(List<String> requestIdList) ;

    WithdrawListResult SyncWithdrawList(int maxId) ;

    DepositListResult DepositList(List<Integer> waasIdList) ;

    DepositListResult SyncDepositList(int maxId) ;

    MinerFeeListResult MinerFeeList(List<Integer> waasIdList) ;

    MinerFeeListResult SyncMinerFeeList(int maxId) ;
}
