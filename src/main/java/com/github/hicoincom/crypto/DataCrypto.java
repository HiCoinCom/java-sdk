package com.github.hicoincom.crypto;

import com.github.hicoincom.crypto.rsa.RSAHelper;

public class DataCrypto implements IDataCrypto{
    //private key to encrypt data
    String privateKey;
    //public key to decrypt data
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
