package com.github.hicoincom.api.mpc;


import com.github.hicoincom.api.bean.mpc.WithdrawArgs;
import com.github.hicoincom.api.bean.mpc.WithdrawRecordResult;
import com.github.hicoincom.api.bean.mpc.WithdrawResult;

import java.util.List;

/**
 * @author ChainUp Custody
 */
public interface IWithdrawApi {

    /**
     * Transfer (Withdrawal)
     * Initiate a Transfer
     * https://custodydocs-en.chainup.com/api-references/mpc-apis/apis/withdraw/withdraw
     *
     * @param withdrawArgs        required true
     *                            withdraw info args
     * @param needTransactionSign transactions require signature fields
     *
     * @return WithdrawResult
     */
    WithdrawResult withdraw(WithdrawArgs withdrawArgs, boolean needTransactionSign);

    /**
     * Transfer (Withdrawal)
     * Initiate a Transfer
     * https://custodydocs-en.chainup.com/api-references/mpc-apis/apis/withdraw/withdraw
     *
     * @param withdrawArgs required true
     *                     withdraw info args
     * @return WithdrawResult
     */
    WithdrawResult withdraw(WithdrawArgs withdrawArgs);

    /**
     * Get Transfer Records
     * Get all wallet transfer records under the workspace, and return up to 100 records
     * https://custodydocs-en.chainup.com/api-references/mpc-apis/apis/withdraw/withdraw-list
     *
     * @param requestIds required: true
     *                   many request_id string
     * @return WithdrawRecordResult
     */
    WithdrawRecordResult getWithdrawRecords(List<String> requestIds);

    /**
     * Synchronize Transfer(withdraw) Records
     * https://custodydocs-en.chainup.com/api-references/mpc-apis/apis/withdraw/withdraw-sync-list
     *
     * @param maxId required: true
     *              transfer record initial id, default: 0
     * @return WithdrawRecordResult
     */
    WithdrawRecordResult syncWithdrawRecords(Integer maxId);
}
