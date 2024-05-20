package com.github.hicoincom.util;

import com.github.hicoincom.api.bean.mpc.CreateWeb3Args;
import com.github.hicoincom.api.bean.mpc.WithdrawArgs;
import com.github.hicoincom.crypto.rsa.RSAHelper;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author ChainUp Custody
 */
public class MpcSignUtil {


    public static String getMpcSign(Map<String, String> signParams, String signPrivateKey) {
        String signData = paramsSort(signParams);
        if (StringUtils.isBlank(signData)) {
            return "";
        }
        return sign(signData, signPrivateKey);
    }

    /**
     * Obtain withdrawal signature
     *
     * @param withdrawArgs   withdraw info
     * @param signPrivateKey rsa private key
     * @return signature data
     */
    public static String getWithdrawSign(WithdrawArgs withdrawArgs, String signPrivateKey) {
        if (ObjectUtils.isEmpty(withdrawArgs) || StringUtils.isBlank(signPrivateKey)) {
            return "";
        }
        Map<String, String> signParamsMap = getWithdrawSignParams(withdrawArgs);
        String signData = paramsSort(signParamsMap);
        return sign(signData, signPrivateKey);
    }

    /**
     * Obtain create web3 transaction signature
     *
     * @param createWeb3Args crete web3 trans args
     * @param signPrivateKey rsa private key
     * @return signature data
     */
    public static String getWeb3Sign(CreateWeb3Args createWeb3Args, String signPrivateKey) {
        if (ObjectUtils.isEmpty(createWeb3Args) || StringUtils.isBlank(signPrivateKey)) {
            return "";
        }
        Map<String, String> signParamsMap = getWeb3SignParams(createWeb3Args);
        String signData = paramsSort(signParamsMap);
        return sign(signData, signPrivateKey);
    }

    /**
     * Obtain withdrawal signature parameters
     *
     * @param withdrawArgs withdraw info
     * @return map
     */
    public static Map<String, String> getWithdrawSignParams(WithdrawArgs withdrawArgs) {
        Map<String, String> signParamsMap = new HashMap<>(6, 1);
        signParamsMap.put("request_id", withdrawArgs.getRequestId());
        signParamsMap.put("sub_wallet_id", withdrawArgs.getSubWalletId().toString());
        signParamsMap.put("symbol", withdrawArgs.getSymbol());
        signParamsMap.put("address_to", withdrawArgs.getAddressTo());
        signParamsMap.put("amount", withdrawArgs.getAmount());
        signParamsMap.put("memo", withdrawArgs.getMemo());
        return signParamsMap;
    }

    /**
     * Obtain web3 signature parameters
     *
     * @param createWeb3Args crete web3 transaction info
     * @return map
     */
    public static Map<String, String> getWeb3SignParams(CreateWeb3Args createWeb3Args) {
        Map<String, String> signParamsMap = new HashMap<>(6, 1);
        signParamsMap.put("request_id", createWeb3Args.getRequestId());
        signParamsMap.put("sub_wallet_id", createWeb3Args.getSubWalletId().toString());
        signParamsMap.put("main_chain_symbol", createWeb3Args.getMainChainSymbol());
        signParamsMap.put("interactive_contract", createWeb3Args.getInteractiveContract());
        signParamsMap.put("amount", createWeb3Args.getAmount());
        signParamsMap.put("input_data", createWeb3Args.getInputData());
        return signParamsMap;
    }


    /**
     * 1. Sign the parameters in the format k1=v1&k2=v2, and sort k in ASCII ascending order; parameters with empty values are not included in the signature.
     * 2. The digits involved in the signature must not end with the digit 0, for example, 1.0001000, please use 1.0001 for the signature.
     */
    public static String paramsSort(Map<String, String> params) {
        TreeMap<String, String> sortedParams = new TreeMap<>();
        for (String p : params.keySet()) {
            String pv = params.get(p);
            if (StringUtils.isBlank(pv)) {
                continue;
            }

            if (StringUtils.isNotBlank(pv) && "amount".equals(p)) {
                pv = new BigDecimal(pv).stripTrailingZeros().toPlainString();
            }
            sortedParams.put(p, pv);
        }

        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, String> param : sortedParams.entrySet()) {
            if (StringUtils.isNotBlank(param.getValue())) {
                sb.append("&").append(param.getKey()).append("=").append(param.getValue());
            }
        }
        return sb.toString().replaceFirst("&", "").toLowerCase();
    }


    public static String sign(String signData, String signPrivateKey) {
        if (StringUtils.isBlank(signData)) {
            return "";
        }
        return RSAHelper.getSign(Md5Util.getMd5(signData), signPrivateKey);
    }

}
