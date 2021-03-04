package com.github.hicoincom.api;

import com.github.hicoincom.api.bean.TransferArgs;
import com.github.hicoincom.api.bean.TransferListResult;
import com.github.hicoincom.api.bean.TransferResult;

/**
 * 转账操作相关api
 */
public interface ITransferApi {

    String REQUEST_ID = "request_id";
    String RECEIPT = "receipt";

    /**
     * WaaS内部商户互相转账
     */
    TransferResult accountTransfer(TransferArgs args);

    /**
     * 查询转账记录
     */
    TransferListResult getAccountTransferList(String ids, String idsType);

    /**
     * 同步转账记录
     */
    TransferListResult syncAccountTransferList(Integer maxId);

}
