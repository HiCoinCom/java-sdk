package com.github.hicoincom.api.bean.custody;


import com.github.hicoincom.api.bean.Result;
import com.github.hicoincom.api.bean.custody.CoinInfo;

import java.io.Serializable;
import java.util.List;

/**
 *  obtain coins list
 *  http://docs.hicoin.vip/zh/latest/API-WaaS-V2/api/user_getCoinList.html
 */
public class CoinInfoListResult extends Result<List<CoinInfo>> implements Serializable {
    private static final long serialVersionUID = 1L;
}
