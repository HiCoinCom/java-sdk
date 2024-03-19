package com.github.hicoincom.api.waas.impl;

import com.github.hicoincom.WaasConfig;
import com.github.hicoincom.api.WaasApi;
import com.github.hicoincom.api.bean.waas.*;
import com.github.hicoincom.api.waas.IBillingApi;
import com.github.hicoincom.crypto.IDataCrypto;
import com.github.hicoincom.enums.ApiUri;
import com.github.hicoincom.exception.ArgsNullException;
import org.apache.commons.lang3.StringUtils;

import java.util.List;

/**
 * @author ChainUp Custody
 * Fund related api
 */
public class BillingApi extends WaasApi implements IBillingApi {

    public BillingApi(WaasConfig cfg, IDataCrypto crypto) {
        super(cfg, crypto);
    }

    @Override
    public WithdrawResult withdraw(WithdrawArgs args) {
        if (args == null) {
            throw new ArgsNullException("args can not be null");
        }
        return this.invoke(ApiUri.BILLING_WITHDRAW, args, WithdrawResult.class);
    }

    @Override
    public WithdrawListResult withdrawList(List<String> idList) {
        StringIdsArgs args = new StringIdsArgs();
        args.setIdList(StringUtils.join(idList, ","));
        return this.invoke(ApiUri.WITHDRAW_LIST, args, WithdrawListResult.class);
    }

    @Override
    public WithdrawListResult syncWithdrawList(int maxId) {
        SyncWithdrawArgs args = new SyncWithdrawArgs();
        args.setMaxId(maxId);
        return this.invoke(ApiUri.SYNC_WITHDRAW, args, WithdrawListResult.class);
    }

    @Override
    public DepositListResult depositList(List<Integer> idList) {
        StringIdsArgs args = new StringIdsArgs();
        args.setIdList(StringUtils.join(idList, ","));
        return this.invoke(ApiUri.DEPOSIT_LIST, args, DepositListResult.class);
    }

    @Override
    public DepositListResult syncDepositList(int maxId) {
        SyncDepositArgs args = new SyncDepositArgs();
        args.setMaxId(maxId);
        return this.invoke(ApiUri.SYNC_DEPOSIT, args, DepositListResult.class);
    }

    @Override
    public MinerFeeListResult minerFeeList(List<Integer> idList) {
        StringIdsArgs args = new StringIdsArgs();
        args.setIdList(StringUtils.join(idList, ","));
        return this.invoke(ApiUri.MINER_FEE_LIST, args, MinerFeeListResult.class);
    }

    @Override
    public MinerFeeListResult syncMinerFeeList(int maxId) {
        SyncDepositArgs args = new SyncDepositArgs();
        args.setMaxId(maxId);
        return this.invoke(ApiUri.SYNC_MINER_FEE, args, MinerFeeListResult.class);
    }
}
