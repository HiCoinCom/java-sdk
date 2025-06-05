package com.github.hicoincom.api.mpc.impl;

import com.github.hicoincom.MpcConfig;
import com.github.hicoincom.api.WaasApi;
import com.github.hicoincom.api.bean.mpc.GetTransactionRecordArgs;
import com.github.hicoincom.api.bean.mpc.SyncTransactionRecordArgs;
import com.github.hicoincom.api.bean.mpc.TronBuyResourceArgs;
import com.github.hicoincom.api.bean.mpc.TronBuyResourceRecordResult;
import com.github.hicoincom.api.bean.mpc.TronBuyResourceResult;
import com.github.hicoincom.api.mpc.ITronBuyResourceApi;
import com.github.hicoincom.crypto.IDataCrypto;
import com.github.hicoincom.enums.MpcApiUri;
import com.github.hicoincom.exception.ArgsNullException;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.List;

/**
 * @author jiamin.bai
 * @since 2025-04-29
 */
public class TronBuyResourceApi extends WaasApi implements ITronBuyResourceApi {

    public TronBuyResourceApi(MpcConfig cfg, IDataCrypto dataCrypto) {
        super(cfg, dataCrypto);
    }

    @Override
    public TronBuyResourceResult createTronDelegate(TronBuyResourceArgs buyResourceArgs) {
        if (ObjectUtils.isEmpty(buyResourceArgs)) {
            throw new ArgsNullException("mpc buyResourceArgs args empty");
        }

        return this.invoke(MpcApiUri.TRON_CREATE_DELEGATE, buyResourceArgs, TronBuyResourceResult.class);
    }

    @Override
    public TronBuyResourceRecordResult getBuyResourceRecords(List<String> requestIds) {
        if (ObjectUtils.isEmpty(requestIds) || requestIds.isEmpty()) {
            throw new ArgsNullException("the request parameter 'ids' empty");
        }
        GetTransactionRecordArgs args = new GetTransactionRecordArgs();
        args.setIds(StringUtils.join(requestIds, ","));

        return this.invoke(MpcApiUri.TRON_DELEGATE_RECORDS, args, TronBuyResourceRecordResult.class);
    }

    @Override
    public TronBuyResourceRecordResult syncBuyResourceRecords(Integer maxId) {

        SyncTransactionRecordArgs args = new SyncTransactionRecordArgs();
        args.setMaxId(ObjectUtils.isEmpty(maxId) ? 0 : maxId);

        return this.invoke(MpcApiUri.SYNC_TRON_DELEGATE_RECORDS, args, TronBuyResourceRecordResult.class);
    }
}
