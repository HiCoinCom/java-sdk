# java-sdk

chain waas client sdk

Project compile jar package

```
mvn clean install -DskipTests=true
```

maven project direct reference
```
<!-- https://mvnrepository.com/artifact/com.github.hicoincom/waas-sdk -->
<dependency>
    <groupId>com.github.hicoincom</groupId>
    <artifactId>waas-sdk</artifactId>
    <version>2.0.2</version>
</dependency>
```

How to use:

```

WaasConfig cfg = new WaasConfig();
//cfg.setDomain("interface domain name");
cfg.setAppId("app id");

cfg.setUserPrivateKey("Merchant private key");

cfg.setWaasPublickKey("waas public key");

WaasClient client = WaasClientFactory.CreateClient(cfg);

//Register Email User
System.out.print(client.getUserApi().RegisterEmailUser("test@admin.com").toJson());
//Query user information
UserInfoResult userInfo = client.getUserApi().GetEmailUser("test@admin.com");
System.out.print(userInfo.toJson());

//Querying Merchant Collection Account Balance
System.out.print(client.getAccountApi().GetCompanyAccount("ETH").toJson());
//Query user balance
System.out.print(client.getAccountApi().GetUserAccount(userInfo.getData().getUid(),"ETH").toJson());
//Query user recharge address
System.out.print(client.getAccountApi().GetUserAddress(userInfo.getData().getUid(), "ETH").toJson());
//Query currency list
System.out.print(client.getCoinApi().getCoinList().toJson());

//Withdraw
WithdrawArgs args = new WithdrawArgs();
args.setAmount(BigDecimal.ONE);
args.setSymbol("USDT");
args.setFromUid(userInfo.getData().getUid());
args.setRequestId("9876567812sdf");
args.setToAddress("16ASftbAGPCSMpb1tU9GCxmWi59BPncttK");

WithdrawResult withdraw = client.getBillingApi().Withdraw(args);
System.out.print(withdraw.toJson());

//Synchronized withdrawal record
System.out.print(client.getBillingApi().SyncWithdrawList(0).toJson());

//Batch query withdrawal records
List<String> requestIdList = new ArrayList<>();
requestIdList.add(args.getRequestId());
requestIdList.add("123");
System.out.print(client.getBillingApi().WithdrawList(requestIdList).toJson());

//Synchronized recharge record
System.out.print(client.getBillingApi().SyncDepositList(0).toJson());

//Batch query recharge records
List<Integer> waasDepositIdList = new ArrayList<>();
waasDepositIdList.add(1);
waasDepositIdList.add(1000);
System.out.print(client.getBillingApi().DepositList(waasDepositIdList).toJson());

//Decryption deposit and withdrawal notification parameters
System.out.print(client.getAsyncNotifyApi().NotifyRequest("ciphertext"));

//Decrypt secondary verification parameters
System.out.print(client.getAsyncNotifyApi().VerifyRequest("ciphertext"));

//Encrypt secondary verification response data
System.out.print(client.getAsyncNotifyApi().VerifyResponse(args))

//Transfer and query transfer records and other related operations
TransferArgs args = new TransferArgs();
args.setAmount(new BigDecimal("0.001"));
args.setRemark("this is a transfer operation");
args.setRequestId("234343411");
args.setSymbol("usdt");
args.setTo("10c533a212a795f692db6684d70c95e9");
System.out.println("Transfer result：---"+client.getTransferApi().accountTransfer(args).toJson());

System.out.println("Get transfer records：---"+client.getTransferApi().getAccountTransferList("123", ITransferApi.REQUEST_ID).toJson());

System.out.println("Sync transfer records：---"+client.getTransferApi().syncAccountTransferList(0).toJson());

```

