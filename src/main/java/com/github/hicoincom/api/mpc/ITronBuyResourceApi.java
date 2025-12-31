package com.github.hicoincom.api.mpc;

import com.github.hicoincom.api.bean.mpc.TronBuyResourceArgs;
import com.github.hicoincom.api.bean.mpc.TronBuyResourceRecordResult;
import com.github.hicoincom.api.bean.mpc.TronBuyResourceResult;
import com.github.hicoincom.api.bean.mpc.TronFeeRuleResult;

import java.util.List;

/**
 * @author jiamin.bai
 * @since 2025-04-28
 */
public interface ITronBuyResourceApi {

    /**
     * Create a TRON delegate (buy resource) request
     * https://custodydocs-zh.chainup.com/api-references/mpc-apis/apis/tron/delegate-create
     *
     * @param buyResourceArgs required: true
     *                        arguments for creating a TRON delegate (e.g. owner address, resource type, amount, etc.)
     * @return TronBuyResourceResult the creation result, contains request id and status
     */
    TronBuyResourceResult createTronDelegate(TronBuyResourceArgs buyResourceArgs);

    /**
     * Get TRON buy resource (delegate) records by request IDs
     * https://custodydocs-zh.chainup.com/api-references/mpc-apis/apis/tron/delegate-record-list
     *
     * @param requestIds required: true
     *                   list of request_id strings to query (up to API limits)
     * @return TronBuyResourceRecordResult list of matching delegate records
     */
    TronBuyResourceRecordResult getBuyResourceRecords(List<String> requestIds);

    /**
     * Synchronize TRON buy resource (delegate) records
     * https://custodydocs-zh.chainup.com/api-references/mpc-apis/apis/tron/delegate-record-sync-list
     *
     * @param maxId required: true
     *              start id for synchronization; pass 0 to start from the beginning
     * @return TronBuyResourceRecordResult synchronized delegate records and next max id
     */
    TronBuyResourceRecordResult syncBuyResourceRecords(Integer maxId);

    /**
     * Obtain TRON fee rules
     * This returns the current fee rules for TRON resources (energy/net) used by the buy resource API.
     *
     * @return TronFeeRuleResult contains a list of TronFeeRule objects with fields like resource_type,
     * single_price_trx, type and price_sun
     */
    TronFeeRuleResult getTronFeeRule();

}
