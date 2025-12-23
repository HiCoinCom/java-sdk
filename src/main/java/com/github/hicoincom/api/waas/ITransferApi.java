package com.github.hicoincom.api.waas;

import com.github.hicoincom.api.bean.waas.TransferArgs;
import com.github.hicoincom.api.bean.waas.TransferListResult;
import com.github.hicoincom.api.bean.waas.TransferResult;

/**
 * Transfer operation related API interface
 * 
 * This interface provides methods for internal transfers between
 * merchant users within the WaaS platform.
 * 
 * @author ChainUp Custody
 */
public interface ITransferApi {

    /**
     * Query type constant: by request ID
     */
    String REQUEST_ID = "request_id";
    
    /**
     * Query type constant: by receipt
     */
    String RECEIPT = "receipt";

    /**
     * Execute internal transfer between WaaS merchant users
     * 
     * Transfers funds from one user account to another within the same merchant.
     * 
     * @param args TransferArgs containing transfer details (amount, from/to users, etc.)
     * @return TransferResult containing transfer operation result
     */
    TransferResult accountTransfer(TransferArgs args);

    /**
     * Query transfer records by IDs
     * 
     * Retrieve transfer records using either request IDs or receipts.
     * 
     * @param ids comma-separated list of IDs to query
     * @param idsType type of IDs: REQUEST_ID or RECEIPT
     * @return TransferListResult containing list of transfer records
     */
    TransferListResult getAccountTransferList(String ids, String idsType);

    /**
     * Synchronize transfer records
     * 
     * Retrieves transfer records with ID greater than the specified maxId,
     * useful for incremental synchronization.
     * 
     * @param maxId maximum ID from previous sync (0 for first sync)
     * @return TransferListResult containing list of new transfer records
     */
    TransferListResult syncAccountTransferList(Integer maxId);

}
