package com.github.hicoincom.api.mpc.impl;

import com.github.hicoincom.MpcConfig;
import com.github.hicoincom.api.WaasApi;
import com.github.hicoincom.api.bean.mpc.GetDepositRecordArgs;
import com.github.hicoincom.api.bean.mpc.DepositRecordResult;
import com.github.hicoincom.api.bean.mpc.SyncDepositRecordArgs;
import com.github.hicoincom.api.mpc.IDepositApi;
import com.github.hicoincom.crypto.IDataCrypto;
import com.github.hicoincom.enums.MpcApiUri;
import com.github.hicoincom.exception.ArgsNullException;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.List;

/**
 * @author ChainUp Custody
 */
public class DepositApi extends WaasApi implements IDepositApi {

    public DepositApi(MpcConfig cfg, IDataCrypto dataCrypto) {
        super(cfg, dataCrypto);
    }

    @Override
    public DepositRecordResult getDepositRecords(List<Integer> ids) {
        if (ObjectUtils.isEmpty(ids) || ids.isEmpty()) {
            throw new ArgsNullException("the request parameter 'ids' empty");
        }

        GetDepositRecordArgs args = new GetDepositRecordArgs();
        args.setIds(StringUtils.join(ids, ","));

        return this.invoke(MpcApiUri.DEPOSIT_RECORDS, args, DepositRecordResult.class);
    }

    @Override
    public DepositRecordResult syncDepositRecords(Integer maxId) {
        SyncDepositRecordArgs args = new SyncDepositRecordArgs();
        args.setMaxId(ObjectUtils.isEmpty(maxId) ? 0 : maxId);

        return this.invoke(MpcApiUri.SYNC_DEPOSIT_RECORDS, args, DepositRecordResult.class);
    }
}
