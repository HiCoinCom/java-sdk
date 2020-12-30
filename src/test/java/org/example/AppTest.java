package org.example;

import static org.junit.Assert.assertTrue;

import com.chainup.waas.WaasClient;
import com.chainup.waas.WaasClientFactory;
import com.chainup.waas.WaasConfig;
import com.chainup.waas.api.bean.*;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()throws Exception
    {
        WaasConfig cfg = new WaasConfig();
        cfg.setDomain("http://awstestopenapi.hiwallet.pro/api/v2");
        cfg.setAppId("baaceb1e506e1b5d7d1f0a3b1622583b");

        cfg.setUserPrivateKey("MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQD6YNILWOJZjS6FQQ9ZL9CEKcWZTTldrDLsxP2dQME7hSUTDQ5AosBUZk18Uq212SC2+L0UA9G6WPoCNzHCB8TP25jC+EwIkHMN4EEPRs+bEHUgX3Bq3oR2SCHjEiqleTFW2kO/oS6Vg9bhTST5MFaEnA0fc2Bh3+4iRus+5mVc6ux0lG55f1qmvUNM4hhP7qVpzc3X0xFA0Slu8dyel1dbOUQlJbUkrt5NzXXqmRoP5UVHUCXPZzH1kbxdbGA58TonXceh6DHQRa6pIBNaQ6BfnqhMvGVvuIqKPrdWq8yigvTw2zqBfwCwY3/3FZoI5ICQ8oS3GRHYP/rXzncqkKTzAgMBAAECggEAdag77EMnkueKXeo12TZj6Udr6N9mPsOl5qenelcsttiZlHtFIFCays6MSQjdQqA3BGSdDaPB0azwR0xCoKhf70GFZtGhgUDIIFQqnpArDPZN5BmVTVMlsiOxcPBfhAUQj3zf61RF/NLIjnVfE46IiaZ/cDEasMO3NvpWn+dK6L86zklgwHfC5IXTFnFRVA3bWkAQ3gswhLzjs50HNoNV96fsnbt1n7NSWhyz9B8hGMV+qYz1NGmb+VsaAune+oIv28krcaqf+Doah37rCmzEgVeZZ1/flPFOXpaq1eGJDgbLu6FbbgqfabCBlhmuzuwNbDl/2T/U9U6JoQWGR7t++QKBgQD8XSzBqpWwz8ebfsPipvnhIugbHgBnwLaRc3/xieuNuiDMsYPY1isBWSeYqjwV5uTad9s9dRxb6OOMH+KChkUxkYhEvoujUulGSuO4MxJlWl99WWEsbLzefubBD0zyHo5daHbPPXO8UPMu/SfiYxT2D5wsW2/swUqHWS3AmDS9RQKBgQD9/FJC/++DLyhU60Q9vrVY50zQTyPLtPnuIxbsPXB1Exo1wKe+LC02k9Cub9f5EFViTEniWRasB7ecnDxJT/ISU+hJjMUKFuaHueb7dO6wiIqyfpJeQM/4fKalBQI+nCEh3aceNKP44mk/lv2x22+P47EAKh7yqBdEVUv5GlHw1wKBgQCbAqReJOijXU0vLtMlYgj0h9tn5Kq9D/tUJky9UUkVmfFRqevhgdOSlW+j71TO4y9JHfvVqRyNO+ShCmi4Yb8Yrlq0VxIwdNoCqjdryjsPdE5ZEVCF2Bi+1dXpWfuacLhjman4q7duQY7OGwOno9KZPYdhG50JIMUlk9pthVBHvQKBgCXUC+iAuAqg3m/vboWHvvjT0mQANYOkm8j1HvfmmrZFNxUkcZdoev9y+pTQgalN3nm6hRKaVD8hEx7XQj9lEdfa+XDi74H2MTWr4ZQ4MUjHvWiiY2h4XMFUx3kyisgKdwDVQ4vDKVzrU+OtuHFiDnau4fD1VRCtKnH6Bku+uM+XAoGAB7V/OFlk7gaX7gne7p+DypXICn1oGE46aFLsDciOyePNovYg6bfdiUB9evwFSijiHq7eldZIQSRIdUalL1qfv2zDwFmEGpSd/RZYOOv21c3eISjln6W7ZGtumtLHx2nGpC072i5vNee0aAPEdvO0h3y4gvzad5L4KwIwyHifKic=");

        cfg.setWaasPublickKey("MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAua4XMw/W9BxyZhirTlNau5Y/tdAHkPsbZo58Cdz1ByeRX8RwOibpREDZLTwhMTZGroqWEAZ+efQhx0gez++03Sw6IsPWPDpzpM90ezn2gBqPog7jxQA+M0E32gMHWB5ygplPwQkGz/qGYeJ5qhp2OZ8O+jFqOJNi7ob1hE2QsPT118HIhUzTL77urD61BovI+jg9Rx6PGAqlFLLmfXToqDulLkYVKhhQlL7ii6iuzIXgl46mbmvH2RXJRq083sa9b9J1z/WzXxNaHNpq5USl3ifTTyD/IiOKnblA7f4KJmr9rcMFbAP1mNxz95at6hPBvqGypPqqixxPBrdkOIPUVwIDAQAB");

        WaasClient client = WaasClientFactory.CreateClient(cfg);

        //注册邮箱用户
        System.out.print(client.getUserApi().GetEmailUser("test@admin.com").toJson());
        //查询用户信息
        UserInfoResult userInfo = client.getUserApi().GetEmailUser("test@admin.com");
        System.out.print(userInfo.toJson());

        //查询商户归集账户余额
        System.out.print(client.getAccountApi().GetCompanyAccount("ETH").toJson());
        //查询用户余额
        System.out.print(client.getAccountApi().GetUserAccount(userInfo.getData().getUid(),"ETH").toJson());
        //查询用户充值地址
        System.out.print(client.getAccountApi().GetUserAddress(userInfo.getData().getUid(), "ETH").toJson());
        //查询币种列表
        System.out.print(client.getCoinApi().getCoinList().toJson());

        //提现
        WithdrawArgs args = new WithdrawArgs();
        args.setAmount(BigDecimal.ONE);
        args.setSymbol("USDT");
        args.setFromUid(userInfo.getData().getUid());
        args.setRequestId("9876567812sdf");
        args.setToAddress("16ASftbAGPCSMpb1tU9GCxmWi59BPncttK");

        WithdrawResult withdraw = client.getBillingApi().Withdraw(args);
        System.out.print(withdraw.toJson());

        //同步提现记录
        System.out.print(client.getBillingApi().SyncWithdrawList(0).toJson());

        //批量查询提现记录
        List<String> requestIdList = new ArrayList<>();
        requestIdList.add(args.getRequestId());
        requestIdList.add("123");
        System.out.print(client.getBillingApi().WithdrawList(requestIdList).toJson());

        //同步充值记录
        System.out.print(client.getBillingApi().SyncDepositList(0).toJson());

        //批量查询充值记录
        List<Integer> waasDepositIdList = new ArrayList<>();
        waasDepositIdList.add(1);
        waasDepositIdList.add(1000);
        System.out.print(client.getBillingApi().DepositList(waasDepositIdList).toJson());

        //解密充提通知参数
        System.out.print(client.getAsyncNotifyApi().NotifyRequest("密文"));

        //解密二次验证参数
        System.out.print(client.getAsyncNotifyApi().VerifyRequest("密文"));

        //加密二次验证响应数据
        System.out.print(client.getAsyncNotifyApi().VerifyResponse(withdraw.getData()));

        assertTrue( true );
    }
}
