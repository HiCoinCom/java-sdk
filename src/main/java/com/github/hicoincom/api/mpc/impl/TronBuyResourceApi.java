package com.github.hicoincom.api.mpc.impl;

import com.github.hicoincom.MpcConfig;
import com.github.hicoincom.api.WaasApi;
import com.github.hicoincom.api.bean.BaseArgs;
import com.github.hicoincom.api.bean.mpc.GetTransactionRecordArgs;
import com.github.hicoincom.api.bean.mpc.SyncTransactionRecordArgs;
import com.github.hicoincom.api.bean.mpc.TronBuyResourceArgs;
import com.github.hicoincom.api.bean.mpc.TronBuyResourceRecordResult;
import com.github.hicoincom.api.bean.mpc.TronBuyResourceResult;
import com.github.hicoincom.api.bean.mpc.TronFeeRuleResult;
import com.github.hicoincom.api.bean.mpc.TronFlashOpenArgs;
import com.github.hicoincom.api.bean.mpc.TronReclaimArgs;
import com.github.hicoincom.api.bean.mpc.TronReclaimResult;
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
    public TronBuyResourceResult createTronFlashOpen(TronFlashOpenArgs flashOpenArgs) {
        // Flash recharge accepts only the business request ID, requested energy and receiving address.
        if (ObjectUtils.isEmpty(flashOpenArgs)
                || StringUtils.isBlank(flashOpenArgs.getRequestId())
                || StringUtils.isBlank(flashOpenArgs.getAddressFrom())
                || ObjectUtils.isEmpty(flashOpenArgs.getEnergyNum())
                || flashOpenArgs.getEnergyNum() <= 0) {
            throw new ArgsNullException("mpc flashOpenArgs required args empty or invalid");
        }

        return this.invoke(MpcApiUri.TRON_FLASH_OPEN, flashOpenArgs, TronBuyResourceResult.class);
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

    @Override
    public TronFeeRuleResult getTronFeeRule() {
        BaseArgs args = new BaseArgs();
        return this.invoke(MpcApiUri.GET_TRON_FEE_RULE, args, TronFeeRuleResult.class);
    }

    @Override
    public TronReclaimResult reclaimTronResource(TronReclaimArgs reclaimArgs) {
        if (ObjectUtils.isEmpty(reclaimArgs) || StringUtils.isEmpty(reclaimArgs.getRequestId())) {
            throw new ArgsNullException("mpc reclaimArgs or request_id args empty");
        }

        return this.invoke(MpcApiUri.TRON_RECLAIM, reclaimArgs, TronReclaimResult.class);
    }
}
