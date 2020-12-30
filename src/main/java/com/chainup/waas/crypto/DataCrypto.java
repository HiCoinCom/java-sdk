package com.chainup.waas.crypto;

import com.chainup.waas.crypto.rsa.RSAHelper;

public class DataCrypto implements IDataCrypto{
    //加密数据的私钥
    String privateKey;
    //解密数据的公钥
    String publicKey;

    public DataCrypto(){
    }

    public DataCrypto(String priv, String pub){
        this.privateKey = priv;
        this.publicKey = pub;
    }

    @Override
    public String decode(String cipher){
       return RSAHelper.decryptByPublicKey(cipher, this.publicKey);
    }

   @Override
    public String encode(String raw){
        return RSAHelper.encryptByPrivateKey(raw, this.privateKey);
    }
}
