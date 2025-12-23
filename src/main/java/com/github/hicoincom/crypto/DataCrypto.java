package com.github.hicoincom.crypto;

import com.github.hicoincom.crypto.rsa.RSAHelper;

/**
 * Default implementation of data encryption and decryption
 * 
 * This class uses RSA encryption for secure data transmission.
 * Private key is used for encryption, public key for decryption.
 */
public class DataCrypto implements IDataCrypto{
    /**
     * Private key used to encrypt data before sending
     */
    String privateKey;
    
    /**
     * Public key used to decrypt data received from server
     */
    String publicKey;

    /**
     * Default constructor
     */
    public DataCrypto(){
    }

    /**
     * Constructor with key initialization
     * 
     * @param priv RSA private key for encryption
     * @param pub RSA public key for decryption
     */
    public DataCrypto(String priv, String pub){
        this.privateKey = priv;
        this.publicKey = pub;
    }

    /**
     * Decrypt ciphertext using public key
     * 
     * @param cipher encrypted data to decrypt
     * @return String decrypted plaintext
     */
    @Override
    public String decode(String cipher){
       return RSAHelper.decryptByPublicKey(cipher, this.publicKey);
    }

    /**
     * Encrypt plaintext using private key
     * 
     * @param raw plaintext data to encrypt
     * @return String encrypted ciphertext
     */
   @Override
    public String encode(String raw){
        return RSAHelper.encryptByPrivateKey(raw, this.privateKey);
    }
}
