package com.github.hicoincom.api;

import com.github.hicoincom.WaasConfig;
import com.github.hicoincom.api.bean.*;
import com.github.hicoincom.crypto.IDataCrypto;
import com.github.hicoincom.exception.ArgsNullException;
import org.apache.commons.lang3.StringUtils;

import java.util.List;

/**
 *  资金相关api
 */
public class BillingApi extends  WaasApi implements IBillingApi{
    public BillingApi(WaasConfig cfg, IDataCrypto crypto){
        super(cfg, crypto);
    }

    @Override
    public WithdrawResult Withdraw(WithdrawArgs args)   {
        if(args == null){
            throw new ArgsNullException("args can not be null");
        }
        return this.invoke(ApiUri.BILLING_WITHDRAW, args, WithdrawResult.class);
    }

    @Override
    public WithdrawListResult WithdrawList(List<String> idList)  {
        StringIdsArgs args = new StringIdsArgs();
        args.setIdList(StringUtils.join(idList, ","));
        return this.invoke(ApiUri.WITHDRAW_LIST, args, WithdrawListResult.class);
    }

    @Override
    public WithdrawListResult SyncWithdrawList(int maxId)  {
        SyncWithdrawArgs args = new SyncWithdrawArgs();
        args.setMaxId(maxId);
        return this.invoke(ApiUri.SYNC_WITHDRAW, args, WithdrawListResult.class);
    }

    @Override
    public DepositListResult DepositList(List<Integer> idList)  {
        StringIdsArgs args = new StringIdsArgs();
        args.setIdList(StringUtils.join(idList, ","));
        return this.invoke(ApiUri.DEPOSIT_LIST, args, DepositListResult.class);
    }

    @Override
    public DepositListResult SyncDepositList(int maxId)  {
        SyncDepositArgs args = new SyncDepositArgs();
        args.setMaxId(maxId);
        return this.invoke(ApiUri.SYNC_DEPOSIT, args, DepositListResult.class);
    }

    @Override
    public MinerFeeListResult MinerFeeList(List<Integer> idList)  {
        StringIdsArgs args = new StringIdsArgs();
        args.setIdList(StringUtils.join(idList, ","));
        return this.invoke(ApiUri.MINER_FEE_LIST, args, MinerFeeListResult.class);
    }

    @Override
    public MinerFeeListResult SyncMinerFeeList(int maxId)  {
        SyncDepositArgs args = new SyncDepositArgs();
        args.setMaxId(maxId);
        return this.invoke(ApiUri.SYNC_MINER_FEE, args, MinerFeeListResult.class);
    }
}
