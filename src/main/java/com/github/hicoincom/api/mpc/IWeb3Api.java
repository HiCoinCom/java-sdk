package com.github.hicoincom.api.mpc;


import com.github.hicoincom.api.bean.mpc.MpcCreateWeb3Result;
import com.github.hicoincom.api.bean.mpc.MpcWeb3AccelerationArgs;
import com.github.hicoincom.api.bean.mpc.MpcWeb3RecordResult;
import com.github.hicoincom.api.bean.mpc.MpcWeb3TransArgs;

import java.util.List;

/**
 * @author Chainup Custody
 */
public interface IWeb3Api {

    /**
     * Create Web3 Transaction
     * https://custodydocs-en.chainup.com/api-references/mpc-apis/apis/web3/web3-create
     *
     * @param web3TransArgs       required true
     *                            create web3 transaction args
     * @param needTransactionSign transactions require signature fields
     */
    MpcCreateWeb3Result createWeb3Trans(MpcWeb3TransArgs web3TransArgs, boolean needTransactionSign);

    /**
     * Web3 Transaction Acceleration
     * https://custodydocs-en.chainup.com/api-references/mpc-apis/apis/web3/web3-pending
     *
     * @param accelerationArgs required true
     *                         acceleration web3 transaction args
     */
    boolean accelerationWeb3Trans(MpcWeb3AccelerationArgs accelerationArgs);


    /**
     * Get Web3 Transaction Records
     * Get all Web3 transaction records under a wallet, maximum of 100 records.
     * https://custodydocs-en.chainup.com/api-references/mpc-apis/apis/web3/web3-record-list
     *
     * @param requestIds required: true
     *                   many request_id string
     */
    MpcWeb3RecordResult getWeb3Records(List<String> requestIds);

    /**
     * Sync Web3 Transaction Records
     * Get all Web3 transaction records under a wallet, maximum of 100 records.
     * https://custodydocs-en.chainup.com/api-references/mpc-apis/apis/web3/web3-record-sync-list
     *
     * @param maxId required: true
     *              Starting ID of Web3 transactions, default:0
     */
    MpcWeb3RecordResult syncWeb3Records(Integer maxId);


}
