package com.github.hicoincom.api.waas;

import com.github.hicoincom.api.bean.waas.*;

import java.util.List;

/**
 * @author ChainUp Custody
 * Funding related APIs
 */
public interface IBillingApi {

    WithdrawResult withdraw(WithdrawArgs args);

    WithdrawListResult withdrawList(List<String> requestIdList);

    WithdrawListResult syncWithdrawList(int maxId);

    DepositListResult depositList(List<Integer> waasIdList);

    DepositListResult syncDepositList(int maxId);

    MinerFeeListResult minerFeeList(List<Integer> waasIdList);

    MinerFeeListResult syncMinerFeeList(int maxId);
}
