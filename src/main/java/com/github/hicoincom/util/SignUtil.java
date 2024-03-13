package com.github.hicoincom.util;

import com.github.hicoincom.crypto.rsa.RSAHelper;
import org.apache.commons.lang3.StringUtils;

import java.math.BigDecimal;
import java.util.Map;
import java.util.TreeMap;


public class SignUtil {

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
        return RSAHelper.getSign(MD5Util.getMD5(signData), signPrivateKey);
    }

}
