package com.github.hicoincom.api.waas;

import com.github.hicoincom.api.bean.waas.TransferArgs;
import com.github.hicoincom.api.bean.waas.TransferListResult;
import com.github.hicoincom.api.bean.waas.TransferResult;

/**
 * @author ChainUp Custody
 * Transfer operation related api
 */
public interface ITransferApi {

    String REQUEST_ID = "request_id";
    String RECEIPT = "receipt";

    /**
     * WaaS internal merchants transfer money to each other
     * @param  args TransferArgs
     * @return TransferResult
     */
    TransferResult accountTransfer(TransferArgs args);

    /**
     * Query transfer records
     * @param idsType String
     * @param ids String
     * @return  TransferListResult
     */
    TransferListResult getAccountTransferList(String ids, String idsType);

    /**
     * Sync transfer records
     * @param maxId Integer
     * @return TransferListResult
     */
    TransferListResult syncAccountTransferList(Integer maxId);

}
