package com.github.hicoincom.api.custody;

import com.github.hicoincom.api.bean.custody.*;

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
