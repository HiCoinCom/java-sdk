package com.chainup.waas.api;

import com.chainup.waas.WaasConfig;
import com.chainup.waas.api.bean.*;
import com.chainup.waas.crypto.IDataCrypto;
import com.chainup.waas.exception.CryptoException;
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
    public WithdrawResult Withdraw(WithdrawArgs args)  throws Exception {
        if(args == null){
            throw new Exception("args can not be null");
        }
        return this.invoke(ApiUri.BILLING_WITHDRAW, args, WithdrawResult.class);
    }

    @Override
    public WithdrawListResult WithdrawList(List<String> idList)  throws Exception{
        StringIdsArgs args = new StringIdsArgs();
        args.setIdList(StringUtils.join(idList, ","));
        return this.invoke(ApiUri.WITHDRAW_LIST, args, WithdrawListResult.class);
    }

    @Override
    public WithdrawListResult SyncWithdrawList(int maxId)  throws Exception{
        SyncWithdrawArgs args = new SyncWithdrawArgs();
        args.setMaxId(maxId);
        return this.invoke(ApiUri.SYNC_WITHDRAW, args, WithdrawListResult.class);
    }

    @Override
    public DepositListResult DepositList(List<Integer> idList)  throws Exception{
        StringIdsArgs args = new StringIdsArgs();
        args.setIdList(StringUtils.join(idList, ","));
        return this.invoke(ApiUri.DEPOSIT_LIST, args, DepositListResult.class);
    }

    @Override
    public DepositListResult SyncDepositList(int maxId)  throws Exception{
        SyncDepositArgs args = new SyncDepositArgs();
        args.setMaxId(maxId);
        return this.invoke(ApiUri.SYNC_DEPOSIT, args, DepositListResult.class);
    }
}
