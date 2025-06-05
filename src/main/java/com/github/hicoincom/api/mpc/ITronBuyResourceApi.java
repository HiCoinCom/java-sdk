package com.github.hicoincom.api.mpc;

import com.github.hicoincom.api.bean.mpc.TronBuyResourceArgs;
import com.github.hicoincom.api.bean.mpc.TronBuyResourceRecordResult;
import com.github.hicoincom.api.bean.mpc.TronBuyResourceResult;
import com.github.hicoincom.api.bean.mpc.WithdrawRecordResult;

import java.util.List;

/**
 * @author jiamin.bai
 * @since 2025-04-28
 */
public interface ITronBuyResourceApi {

    /**
     * https://custodydocs-zh.chainup.com/api-references/mpc-apis/apis/tron/delegate-create
     * @param buyResourceArgs
     * @return
     */
    TronBuyResourceResult createTronDelegate(TronBuyResourceArgs buyResourceArgs);

    /**
     * https://custodydocs-zh.chainup.com/api-references/mpc-apis/apis/tron/delegate-record-list
     * @param requestIds
     * @return
     */
    TronBuyResourceRecordResult getBuyResourceRecords(List<String> requestIds);

    /**
     * https://custodydocs-zh.chainup.com/api-references/mpc-apis/apis/tron/delegate-record-sync-list
     * @param maxId
     * @return
     */
    TronBuyResourceRecordResult syncBuyResourceRecords(Integer maxId);

}
