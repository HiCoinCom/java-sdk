package org.example;

import com.github.hicoincom.WaasClient;
import com.github.hicoincom.WaasClientFactory;
import com.github.hicoincom.WaasConfig;
import com.github.hicoincom.api.waas.ITransferApi;
import com.github.hicoincom.api.bean.waas.TransferArgs;
import com.github.hicoincom.api.bean.waas.UserInfoResult;
import com.github.hicoincom.api.bean.waas.WithdrawArgs;
import com.github.hicoincom.api.bean.waas.WithdrawResult;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;


/**
 * Unit test for simple App.
 */
public class AppTest {
    /**
     * Rigorous Test :-)
     */
    //@Test
    public void shouldAnswerWithTrue() throws Exception {
        WaasConfig cfg = new WaasConfig();
        cfg.setAppId("Merchant app id");

        cfg.setUserPrivateKey("Merchant Private key");

        cfg.setWaasPublickKey("waas public key");

        WaasClient client = WaasClientFactory.CreateClient(cfg);

        //register email user
        System.out.print(client.getUserApi().getEmailUser("test@admin.com").toJson());
        //Query user information
        UserInfoResult userInfo = client.getUserApi().getEmailUser("test@admin.com");
        System.out.print(userInfo.toJson());

        //Querying Merchant Account Balance
        System.out.print(client.getAccountApi().getCompanyAccount("ETH").toJson());
        //Query user balance
        System.out.print(client.getAccountApi().getUserAccount(userInfo.getData().getUid(), "ETH").toJson());
        //Query user recharge address
        System.out.print(client.getAccountApi().getUserAddress(userInfo.getData().getUid(), "ETH").toJson());
        //Query currency list
        System.out.print(client.getCoinApi().getCoinList().toJson());

        //Withdraw
        WithdrawArgs args = new WithdrawArgs();
        args.setAmount(BigDecimal.ONE);
        args.setSymbol("USDT");
        args.setFromUid(userInfo.getData().getUid());
        args.setRequestId("9876567812sdf");
        args.setToAddress("16ASftbAGPCSMpb1tU9GCxmWi59BPncttK");

        WithdrawResult withdraw = client.getBillingApi().withdraw(args);
        System.out.print(withdraw.toJson());

        //sync withdrawal record
        System.out.print(client.getBillingApi().syncWithdrawList(0).toJson());

        //batch query withdrawal record
        List<String> requestIdList = new ArrayList<>();
        requestIdList.add(args.getRequestId());
        requestIdList.add("123");
        System.out.print(client.getBillingApi().withdrawList(requestIdList).toJson());

        //sync deposit record
        System.out.print(client.getBillingApi().syncDepositList(0).toJson());

        //batch query deposit record
        List<Integer> waasDepositIdList = new ArrayList<>();
        waasDepositIdList.add(1);
        waasDepositIdList.add(1000);
        System.out.print(client.getBillingApi().depositList(waasDepositIdList).toJson());

        //Decryption deposit and withdrawal notification parameters
        System.out.print(client.getAsyncNotifyApi().notifyRequest("cipherText"));

        //decrypt secondary verification parameters
        System.out.print(client.getAsyncNotifyApi().verifyRequest("cipherText"));

        //Encrypt secondary verification response data
        System.out.print(client.getAsyncNotifyApi().verifyResponse(args));


        assertTrue(true);
    }

    @Test
    public void acountTransferOperations() {
        WaasConfig cfg = new WaasConfig();
        cfg.setAppId("Merchant app id");

        cfg.setUserPrivateKey("Merchant private key");

        cfg.setWaasPublickKey("waas public key");

        WaasClient client = WaasClientFactory.CreateClient(cfg);

        TransferArgs args = new TransferArgs();
        args.setAmount(new BigDecimal("0.001"));
        args.setRemark("this is a transfer operation");
        args.setRequestId("234343411");
        args.setSymbol("usdt");
        args.setTo("10c533a212a795f692db6684d70c95e9");
        System.out.println("transfer result：---" + client.getTransferApi().accountTransfer(args).toJson());

        System.out.println("gain transfer record ：---" + client.getTransferApi().getAccountTransferList("123", ITransferApi.REQUEST_ID).toJson());

        System.out.println("Sync transfer records：---" + client.getTransferApi().syncAccountTransferList(0).toJson());

    }
}
