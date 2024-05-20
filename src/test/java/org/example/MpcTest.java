package org.example;


import com.github.hicoincom.MpcConfig;
import com.github.hicoincom.MpcClient;
import com.github.hicoincom.WaasClientFactory;
import com.github.hicoincom.api.bean.mpc.*;
import com.github.hicoincom.enums.AppShowStatus;
import com.github.hicoincom.util.Md5Util;
import com.github.hicoincom.util.MpcSignUtil;
import org.apache.commons.lang3.StringUtils;
import org.junit.Before;
import org.junit.Test;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class MpcTest {

    MpcClient mpcClient;

    @Before
    public void initMpcClient() {
        String appId = "";
        String userPriKey = "";
        String waasPub = "";
        String custodyDomain = "";
        String signPri = "";


        MpcConfig cfg = new MpcConfig();
        cfg.setAppId(appId);
        cfg.setUserPrivateKey(userPriKey);
        cfg.setWaasPublickKey(waasPub);
        cfg.setDomain(custodyDomain);
        cfg.setSignPrivateKey(signPri);
        cfg.setEnableLog(Boolean.FALSE);
        mpcClient = WaasClientFactory.CreateMpcClient(cfg);
    }

    @org.junit.jupiter.api.Test
    public void signParams() {
        HashMap<String, String> dataMap = new HashMap<>();
        dataMap.put("q", "8");
        dataMap.put("amount", "8.00088800");
        dataMap.put("t", "test");

        String signData = MpcSignUtil.paramsSort(dataMap);
        System.out.println("sign params: " + signData + ", MD5: " + Md5Util.getMd5(signData));
        if (StringUtils.isBlank(signData)) {
            return;
        }

        String pri = "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQDSxEURQHg5zk/6g7laQhXjAhUkPj59kwwtFm3Lv+aBplMYs+miFMK32xhL+XWXq0jTM3DX63YX+J9yQLuKo6fbzlQIil+4wXD8v1liVOM9RAA3dkeJIiOGZQZ2GKJyBsQIdJY3+n5A71MrCE5imVy/LA4iX3SKLtY7HkgruWWRHytQTK22jCxSa0hpltaqeONMUBfjRxFftXUrapVyFUFynzq/iuW3Q49pPgT4rXqSGUg+IO2IStVJnJSkHWlC94PQklNidRvafTslpSVQUCn0e6fLcOZEYM6BK82Id6sxeqOWRcNpoYwsBfJ4em5QPF4XhBuFtD7mGwwEmhqLlf25AgMBAAECggEBAId7wyoj1yTRinfu1OdAM/GJFS4HFQSD0f/puwqOgQ42bJQkkrqtvb2SCTxNT1n/sQCSwKcLpQ4js9st4WBtcynIqBwVVxLcxlSybDLZfnmTjNAaKEHuwAdUSaMAkuvZjYoh5650R1RWg4/V9w1KqGP7Xdqaob9x/CRkguAYfUGbK8Hurv4uRJnTYDHwDTeOLyXp21Ow4mbukQUMDiqLEqx5sF805f2jW5V2AICRn/k/lgObLkrvCsYEOHaM+vsdrZL40gMjCux0i6ECNAaZaaj54pWUFqik23H0Rzt2cdxstQiDQFEdG3o8vGNWtsQ+qqagArCWpi9z2YQIe4KfcEECgYEA/tG/2Azg3+AblyfyULip5sNYrTxGRq2kkrNqyYk7FmsHdqzTH4TzfrlRgGkXGJb1zeRkL6/6PowTvIeAVkZVv0IVl2jel6lROAyuPGNKDmlDaS0bpdI4CUL13D5AbBAp267kOWBrbREn0cBj4KQO2qrAcoYcihWa6C0oVV/CbzsCgYEA075ElsaP9fZMOoJlCe7rbvJnUWNbFD/RWMXMicE5d8sjsggvbf7redVxrumCi4c+/2+CS9txOPt5fdG3HzA1A8AhsvUVs6RjxYTNjr4UG1W5GReI/+gfmzMH/s5csgkdVrMFs+odQIGvOVEz2s363VQA9D+0vHVWX/o9Xgrln5sCgYB+VKiiyQe3lhi3oLNOd66r3E8bW5WPtsivfknD7sgffiJuIJJuvvAk9GVGn1M2+qiUUdWlmr4awkGKpzbmDuq17mJb9T7du7CrdAXxpFvztxYXj6h0Vjs3xD212hsAOCc4ZYV6OKYppWazY4lgtpUyrZLJdFmzz7BDyReE8/umPwKBgGRy1LL6S30RdKQlC62krAeb8yuHCMQYakXEv/1xrsOHmM1yWJ3D2w2XFjE2EXoDlP00dwlpdtLjaYUoocin4959nP76iWsJR1OCZsmanotBJWgj5BgSlDvZ/6b/WrYS4NoqX0A0hd/+JZP5U7IvGR06JqG4PxNQTsOFQOuGG9yVAoGBANH0knupfdxgvnPOSapnyhq99C8rsLGEkoh7KoqWCCsFPoMcWjyHwpOxukkPKPDEY5j8JnX3vzPofpUVv4REEUuTnZjezPMwDbrWAQ/0kQztTZOSMtpjpGDvHHgc3I02okI0mrGNQPvQwRVwe0IcJ/X4ddjF1OQLD6tK1sekku5n";
        String sign = MpcSignUtil.sign(signData, pri);

        System.out.println("sign: " + sign);
    }


    @Test
    public void getMpcSupportCoin() {
        SupportMainChainResult supportChain = mpcClient.getWorkSpaceApi().getSupportMainChain();
        System.out.println("support chain: " + supportChain.toJson());
    }


    @Test
    public void getCoinDetails() {
        CoinDetailsResult coinDetails = mpcClient.getWorkSpaceApi().getCoinDetails("", "HECO", Boolean.TRUE);
        System.out.println("coin info: " + coinDetails.toJson());
    }

    @Test
    public void getBlockHeight() {
        GetLastBlockHeightResult lastBlockHeight = mpcClient.getWorkSpaceApi().getLastBlockHeight("HECO");
        System.out.println("last block height: " + lastBlockHeight.toJson());
    }

    @Test
    public void createWallet() {
        WalletResult walletResult = mpcClient.getWalletApi().createWallet("api-1", AppShowStatus.HIDDEN);
        System.out.println("create wallet: " + walletResult.toJson());
    }

    @Test
    public void showWallet() {
        List<Integer> walletIds = Collections.singletonList(1001673);
        boolean ok = mpcClient.getWalletApi().changeWalletShowStatus(walletIds, AppShowStatus.HIDDEN);
        System.out.println("change wallet show status: " + ok);
    }


    @Test
    public void createWalletAddress() {
        WalletAddressResult addressInfo = mpcClient.getWalletApi().createWalletAddress(1001673, "HECO");
        System.out.println("create wallet address: " + addressInfo.toJson());

        // result :  {"code":"0","msg":"success","data":{"address":"0x73edc7ebA08c659Af47C48b58AAC8a2AAf6B48d3","addr_type":2,"memo":""}}
    }


    @Test
    public void getWalletAddress() {
        WalletAddressListResult addressList = mpcClient.getWalletApi()
                .queryWalletAddress(1001673, "HECO", 0);
        System.out.println("wallet address list: " + addressList.toJson());

        // result :  {"code":"0","msg":"success","data":[{"address":"0x73edc7ebA08c659Af47C48b58AAC8a2AAf6B48d3","addr_type":2,"memo":""},
        // {"address":"0x277534a92b3dB66bda5483e184BD30E4CE9430E4","addr_type":1,"memo":""},{"address":"0x72576548EA1deB88F0D2e4C3b504B123c7A7E2A5","addr_type":1,"memo":""},
        // {"address":"0xC32d3F97cA778719046E0D9E1C6A10Ba70aF232C","addr_type":1,"memo":""}]}
    }


    @Test
    public void getWalletAsset() {
        WalletAssetsResult hecoAssets = mpcClient.getWalletApi().getWalletAssets(1000786, "HECO");
        System.out.println("wallet assets: " + hecoAssets.toJson());
    }

    @Test
    public void addressInfo() {
        WalletAddressInfoResult addressInfo = mpcClient.getWalletApi().walletAddressInfo("0x72576548EA1deB88F0D2e4C3b504B123c7A7E2A5", "");
        System.out.println("address info: " + addressInfo.toJson());
    }


    @Test
    public void withdraw() {
        WithdrawArgs withdrawArgs = new WithdrawArgs();
        withdrawArgs.setRequestId("test-1");
        withdrawArgs.setSymbol("HECO");
        withdrawArgs.setSubWalletId(1000721);
        withdrawArgs.setAddressTo("0xcF88c8a960d5e155A9F3236a9f4e7CacE29E5050");
        withdrawArgs.setAmount("0.00000100000");

        // Method 1
        WithdrawResult withdraw = mpcClient.getWithdrawApi().withdraw(withdrawArgs, Boolean.TRUE);

        // Method 2
        /*String signPriKey = "";
        String sign = MpcSignUtil.getWithdrawSign(withdrawArgs, signPriKey);
        withdrawArgs.setSign(sign);
        WithdrawResult withdraw = mpcClient.getWithdrawApi().withdraw(withdrawArgs);*/

        System.out.println("withdraw result: " + withdraw.toJson()); // {"code":"0","msg":"success","data":{"withdraw_id":4229}}
    }

    @Test
    public void withdrawList() {
        WithdrawRecordResult withdrawRecords = mpcClient.getWithdrawApi()
                .getWithdrawRecords(Collections.singletonList("test-1"));

        System.out.println("withdraw records: " + withdrawRecords.toJson());
    }

    @Test
    public void syncList() {
        WithdrawRecordResult withdrawRecords = mpcClient.getWithdrawApi().syncWithdrawRecords(4229);
        System.out.println("sync withdraw records: " + withdrawRecords.toJson());
    }

    @Test
    public void depositList() {
        DepositRecordResult depositRecords = mpcClient.getDepositApi().syncDepositRecords(0);
        System.out.println("deposit records: " + depositRecords.toJson());
    }








}
