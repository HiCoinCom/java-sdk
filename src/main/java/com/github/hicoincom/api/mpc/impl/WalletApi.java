package com.github.hicoincom.api.mpc.impl;

import com.github.hicoincom.CustodyMpcConfig;
import com.github.hicoincom.api.MpcApi;
import com.github.hicoincom.api.bean.Result;
import com.github.hicoincom.api.bean.mpc.*;
import com.github.hicoincom.api.mpc.IWalletApi;
import com.github.hicoincom.crypto.IDataCrypto;
import com.github.hicoincom.enums.AppShowStatus;
import com.github.hicoincom.enums.MpcApiUri;
import com.github.hicoincom.exception.ArgsNullException;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.List;

/**
 * @author ChainUp Custody
 */
public class WalletApi extends MpcApi implements IWalletApi {

    public WalletApi(IDataCrypto dataCrypto, CustodyMpcConfig cfg) {
        super(dataCrypto, cfg);
    }

    @Override
    public MpcWalletResult createWallet(String walletName, AppShowStatus showStatus) {
        if(StringUtils.isBlank(walletName)){
            throw new ArgsNullException("the request parameter 'sub_wallet_name' is required");
        }

        if (walletName.length() > 50) {
            throw new ArgsNullException("the length of parameter 'sub_wallet_name' cannot be greater than 50");
        }

        if (ObjectUtils.isEmpty(showStatus)) {
            showStatus = AppShowStatus.HIDDEN;
        }


        MpcCreateWalletArgs args = MpcCreateWalletArgs.MpcCreateWalletArgsBuilder.aMpcCreateWalletArgs()
                .subWalletName(walletName)
                .appShowStatus(showStatus.getShowStatus())
                .build();


        return this.invoke(MpcApiUri.CREATE_WALLET, args, MpcWalletResult.class);
    }

    @Override
    public MpcWalletAddressResult createWalletAddress(Integer walletId, String symbol) {
        if (ObjectUtils.isEmpty(walletId)) {
            throw new ArgsNullException("the request parameter 'sub_wallet_id' is required");
        }

        if (StringUtils.isBlank(symbol)) {
            throw new ArgsNullException("the request parameter 'symbol' is required");
        }

        MpcCreateWalletAddressArgs args = MpcCreateWalletAddressArgs.MpcCreateWalletAddressArgsBuilder
                .aMpcCreateWalletAddressArgs()
                .subWalletId(walletId)
                .symbol(symbol)
                .build();

        return this.invoke(MpcApiUri.CREATE_WALLET_ADDRESS, args, MpcWalletAddressResult.class);
    }

    @Override
    public MpcWalletAddressListResult queryWalletAddress(Integer walletId, String symbol, Integer maxId) {
        if (ObjectUtils.isEmpty(walletId)) {
            throw new ArgsNullException("the request parameter 'sub_wallet_id' is required");
        }

        if (StringUtils.isBlank(symbol)) {
            throw new ArgsNullException("the request parameter 'symbol' is required");
        }

        if (ObjectUtils.isEmpty(maxId)) {
            maxId = 0;
        }

        MpcQueryAddressArgs args = MpcQueryAddressArgs.QueryMpcAddressArgsBuilder.aQueryMpcAddressArgs()
                .subWalletId(walletId)
                .symbol(symbol)
                .maxId(maxId)
                .build();

        return this.invoke(MpcApiUri.GET_ADDRESS_LIST, args, MpcWalletAddressListResult.class);
    }

    @Override
    public MpcWalletAssetsResult getWalletAssets(Integer walletId, String symbol) {
        if (ObjectUtils.isEmpty(walletId)) {
            throw new ArgsNullException("the request parameter 'sub_wallet_id' is required");
        }

        if (StringUtils.isBlank(symbol)) {
            throw new ArgsNullException("the request parameter 'symbol' is required");
        }

        GetMpcWalletAssetsArgs args = GetMpcWalletAssetsArgs.GetWalletAssetsArgsBuilder.aGetWalletAssetsArgs()
                .subWalletId(walletId)
                .symbol(symbol)
                .build();

        return this.invoke(MpcApiUri.GET_WALLET_ASSETS, args, MpcWalletAssetsResult.class);
    }

    @Override
    public boolean changeWalletShowStatus(List<Integer> walletIds, AppShowStatus showStatus) {
        if (ObjectUtils.isEmpty(walletIds) || walletIds.isEmpty()) {
            throw new ArgsNullException("the request parameter 'sub_wallet_ids' empty");
        }

        if (ObjectUtils.isEmpty(showStatus)) {
            showStatus = AppShowStatus.HIDDEN;
        }


        MpcChangeShowStatusArgs args = MpcChangeShowStatusArgs.MpcChangeShowStatusArgsBuilder.aMpcChangeShowStatusArgs()
                .subWalletIds(StringUtils.join(walletIds, ","))
                .appShowStatus(showStatus.getShowStatus())
                .build();
        Result result = this.invoke(MpcApiUri.CHANGE_SHOW_STATUS, args, Result.class);
        if (result.getCode().equalsIgnoreCase("0")) {
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    @Override
    public MpcWalletAddressInfoResult walletAddressInfo(String address, String memo) {
        if (StringUtils.isBlank(address)) {
            throw new ArgsNullException("the request parameter 'address' is required");
        }

        GetMpcAddressInfoArgs args = GetMpcAddressInfoArgs.GetMpcAddressInfoArgsBuilder.aGetMpcAddressInfoArgs()
                .address(address)
                .memo(memo)
                .build();
        return this.invoke(MpcApiUri.ADDRESS_INFO, args, MpcWalletAddressInfoResult.class);
    }


}
