package com.github.hicoincom.api;

import com.github.hicoincom.WaasConfig;
import com.github.hicoincom.api.bean.*;
import com.github.hicoincom.crypto.IDataCrypto;
import com.github.hicoincom.exception.ArgsNullException;

/**
 * Transfer operation related api
 */
public class TransferApi extends WaasApi implements ITransferApi {
    public TransferApi(WaasConfig cfg, IDataCrypto crypto) {
        super(cfg, crypto);
    }

    /**
     * WaaS internal merchants transfer money to each other
     */
    @Override
    public TransferResult accountTransfer(TransferArgs args) {
        if (args == null) {
            throw new ArgsNullException("args can not be null");
        }
        return this.invoke(ApiUri.ACCOUNT_TRANSFER, args, TransferResult.class);
    }

    /**
     * Query transfer records
     */
    @Override
    public TransferListResult getAccountTransferList(String ids, String idsType) {
        TransferListArgs args = new TransferListArgs();
        args.setIds(ids);
        args.setIdsType(idsType);
        return this.invoke(ApiUri.ACCOUNT_TRANSFER_LIST, args, TransferListResult.class);
    }

    /**
     * Sync transfer records
     */
    @Override
    public TransferListResult syncAccountTransferList(Integer maxId) {
        SyncTransferListArgs args = new SyncTransferListArgs();
        args.setMaxId(maxId);
        return this.invoke(ApiUri.SYNC_ACCOUNT_TRANSFER_LIST, args, TransferListResult.class);
    }


}
