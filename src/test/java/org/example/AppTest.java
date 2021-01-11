package org.example;

import static org.junit.Assert.assertTrue;

import com.github.hicoincom.WaasClient;
import com.github.hicoincom.WaasClientFactory;
import com.github.hicoincom.WaasConfig;
import com.github.hicoincom.api.bean.UserInfoResult;
import com.github.hicoincom.api.bean.WithdrawArgs;
import com.github.hicoincom.api.bean.WithdrawResult;
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
        //cfg.setDomain("接口域名");
        cfg.setAppId("商户app id");

        cfg.setUserPrivateKey("商户私钥");

        cfg.setWaasPublickKey("waas 公钥");

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
        System.out.print(client.getAsyncNotifyApi().VerifyResponse(args));

        assertTrue( true );
    }
}
