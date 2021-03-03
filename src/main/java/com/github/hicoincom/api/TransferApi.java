package com.github.hicoincom.api;

import com.github.hicoincom.WaasConfig;
import com.github.hicoincom.api.bean.*;
import com.github.hicoincom.crypto.IDataCrypto;
import com.github.hicoincom.exception.ArgsNullException;

/**
 * 转账操作相关api
 */
public class TransferApi extends WaasApi implements ITransferApi {
    public TransferApi(WaasConfig cfg, IDataCrypto crypto) {
        super(cfg, crypto);
    }

    /**
     * WaaS内部商户互相转账
     */
    @Override
    public TransferResult accountTransfer(TransferArgs args) {
        if (args == null) {
            throw new ArgsNullException("args can not be null");
        }
        return this.invoke(ApiUri.ACCOUNT_TRANSFER, args, TransferResult.class);
    }

    /**
     * 查询转账记录
     */
    @Override
    public TransferListResult getAccountTransferList(String ids, String ids_type) {
        TransferListArgs args = new TransferListArgs();
        args.setIds(ids);
        args.setIds_type(ids_type);
        return this.invoke(ApiUri.ACCOUNT_TRANSFER_LIST, args, TransferListResult.class);
    }

    /**
     * 同步转账记录
     */
    @Override
    public TransferListResult syncAccountTransferList(Integer max_id) {
        SyncTransferListArgs args = new SyncTransferListArgs();
        args.setMax_id(max_id);
        return this.invoke(ApiUri.SYNC_ACCOUNT_TRANSFER_LIST, args, TransferListResult.class);
    }


}
