package com.github.hicoincom.api.bean.waas;


import com.github.hicoincom.api.bean.Result;

import java.io.Serializable;
import java.util.List;

/**
 * obtain coins list
 * http://docs.hicoin.vip/zh/latest/API-WaaS-V2/api/user_getCoinList.html
 * @author ChainUp Custody
 */
public class CoinInfoListResult extends Result<List<CoinInfo>> implements Serializable {

    private static final long serialVersionUID = 2781667383263512987L;

}
