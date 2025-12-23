package com.github.hicoincom.api.mpc.impl;

import com.github.hicoincom.MpcConfig;
import com.github.hicoincom.api.WaasApi;
import com.github.hicoincom.api.bean.BaseArgs;
import com.github.hicoincom.api.bean.mpc.*;
import com.github.hicoincom.api.mpc.IWorkSpaceApi;
import com.github.hicoincom.crypto.IDataCrypto;
import com.github.hicoincom.enums.MpcApiUri;
import com.github.hicoincom.exception.ArgsNullException;
import org.apache.commons.lang3.StringUtils;

/**
 * @author Chainup Custody
 */
public class WorkSpaceApi extends WaasApi implements IWorkSpaceApi {

    public WorkSpaceApi(MpcConfig cfg, IDataCrypto dataCrypto) {
        super(cfg, dataCrypto);
    }

    @Override
    public SupportMainChainResult getSupportMainChain() {
        return this.invoke(MpcApiUri.SUPPORT_MAIN_CHAIN, new BaseArgs(), SupportMainChainResult.class);
    }

    @Override
    public CoinDetailsResult getCoinDetails(String symbol, String baseSymbol, Boolean openChain, Integer maxId, Integer limit) {
        GetCoinDetailsArgs args = new GetCoinDetailsArgs();
        args.setSymbol(symbol);
        args.setBaseSymbol(baseSymbol);
        args.setOpenChain(openChain);
        args.setMaxId(maxId);
        args.setLimit(limit);
        return this.getCoinDetails(args);
    }

    /**
     * Overloaded method that accepts GetCoinDetailsArgs structure
     */
    @Override
    public CoinDetailsResult getCoinDetails(GetCoinDetailsArgs args) {
        if (args == null) {
            args = new GetCoinDetailsArgs();
        }
        return this.invoke(MpcApiUri.COIN_DETAILS, args, CoinDetailsResult.class);
    }

    @Override
    public GetLastBlockHeightResult getLastBlockHeight(String baseSymbol) {
        if (StringUtils.isBlank(baseSymbol)) {
            throw new ArgsNullException("get last block height, the request parameter 'bas_sSymbol' empty");
        }

        GetLastBlockHeightArgs args = new GetLastBlockHeightArgs();
        args.setBaseSymbol(baseSymbol);
        return this.invoke(MpcApiUri.CHAIN_HEIGHT, args, GetLastBlockHeightResult.class);
    }
}
