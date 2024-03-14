package com.github.hicoincom.api.mpc.impl;

import com.github.hicoincom.CustodyMpcConfig;
import com.github.hicoincom.api.MpcApi;
import com.github.hicoincom.api.bean.mpc.*;
import com.github.hicoincom.api.mpc.IAutoSweepApi;
import com.github.hicoincom.crypto.IDataCrypto;
import com.github.hicoincom.enums.MpcApiUri;
import com.github.hicoincom.exception.ArgsNullException;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;

/**
 * @author ChainUp Custody
 */
public class AutoSweepApi extends MpcApi implements IAutoSweepApi {

    public AutoSweepApi(IDataCrypto dataCrypto, CustodyMpcConfig cfg) {
        super(dataCrypto, cfg);
    }

    @Override
    public MpcAutoCollectWalletsResult autoCollectSubWallets(String symbol) {
        if (StringUtils.isBlank(symbol)) {
            throw new ArgsNullException("the request parameter 'symbol' empty");
        }

        GetMpcAutoCollectWalletArgs args = GetMpcAutoCollectWalletArgs.GetMpcAutoCollectWalletArgsBuilder
                .aGetMpcAutoCollectWalletArgs()
                .symbol(symbol)
                .build();
        return this.invoke(MpcApiUri.AUTO_COLLECT_WALLETS, args, MpcAutoCollectWalletsResult.class);
    }

    @Override
    public MpcSetAutoCollectSymbolResult setAutoCollectSymbol(String symbol, String collectMin, String fuelingLimit) {
        if (StringUtils.isBlank(symbol)) {
            throw new ArgsNullException("the request parameter 'symbol' empty");
        }

        if (StringUtils.isBlank(collectMin)) {
            throw new ArgsNullException("the request parameter 'collect_min' empty");
        }

        if (StringUtils.isBlank(fuelingLimit)) {
            throw new ArgsNullException("the request parameter 'fueling_limit' empty");
        }

        MpcSetAutoCollectSymbolArgs args = MpcSetAutoCollectSymbolArgs.MpcSetAutoCollectSymbolArgsBuilder
                .aMpcSetAutoCollectSymbolArgs()
                .symbol(symbol)
                .collectMin(collectMin)
                .fuelingLimit(fuelingLimit)
                .build();

        return this.invoke(MpcApiUri.SET_AUTO_COLLECT_SYMBOL, args, MpcSetAutoCollectSymbolResult.class);
    }

    @Override
    public MpcAutoCollectRecordResult syncAutoCollectRecords(Integer maxId) {
        MpcSyncTransactionRecordArgs args = MpcSyncTransactionRecordArgs.MpcSyncTransactionRecordArgsBuilder
                .aMpcSyncTransactionRecordArgs()
                .maxId(ObjectUtils.isEmpty(maxId) ? 0 : maxId)
                .build();
        return this.invoke(MpcApiUri.SYNC_AUTO_SWEEP_RECORDS, args, MpcAutoCollectRecordResult.class);
    }
}
