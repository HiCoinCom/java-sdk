package com.github.hicoincom.api.mpc.impl;

import com.github.hicoincom.CustodyMpcConfig;
import com.github.hicoincom.api.MpcApi;
import com.github.hicoincom.api.bean.BaseCustodyArgs;
import com.github.hicoincom.api.bean.mpc.*;
import com.github.hicoincom.api.mpc.IWorkSpaceApi;
import com.github.hicoincom.crypto.IDataCrypto;
import com.github.hicoincom.enums.MpcApiUri;
import com.github.hicoincom.exception.ArgsNullException;
import org.apache.commons.lang3.StringUtils;

/**
 * @author Chainup Custody
 */
public class WorkSpaceApi extends MpcApi implements IWorkSpaceApi {

    public WorkSpaceApi(IDataCrypto dataCrypto, CustodyMpcConfig cfg) {
        super(dataCrypto, cfg);
    }

    @Override
    public MpcSupportMainChainResult getSupportMainChain() {
        return this.invoke(MpcApiUri.SUPPORT_MAIN_CHAIN, new BaseCustodyArgs(), MpcSupportMainChainResult.class);
    }

    @Override
    public MpcCoinDetailsResult getCoinDetails(String symbol, String baseSymbol, Boolean openChain) {
        GetMpcCoinDetailsArgs args = GetMpcCoinDetailsArgs.GetMpcCoinDetailsArgsBuilder.aGetMpcCoinDetailsArgs()
                .symbol(symbol)
                .baseSymbol(baseSymbol)
                .openChain(openChain)
                .build();
        return this.invoke(MpcApiUri.COIN_DETAILS, args, MpcCoinDetailsResult.class);
    }

    @Override
    public GetLastBlockHeightResult getLastBlockHeight(String baseSymbol) {
        if (StringUtils.isBlank(baseSymbol)) {
            throw new ArgsNullException("get last block height, the request parameter 'bas_sSymbol' empty");
        }
        GetLastBlockHeightArgs args = GetLastBlockHeightArgs.GetLastBlockHeightArgsBuilder.aGetLastBlockHeightArgs()
                .baseSymbol(baseSymbol)
                .build();
        return this.invoke(MpcApiUri.CHAIN_HEIGHT, args, GetLastBlockHeightResult.class);
    }
}
