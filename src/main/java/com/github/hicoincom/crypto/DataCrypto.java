package com.github.hicoincom.crypto;

import com.github.hicoincom.crypto.rsa.RSAHelper;
import org.apache.commons.lang3.StringUtils;

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
     * Optional private key specifically used for transaction signing.
     * If not set, privateKey will be used for signing.
     */
    String signPrivateKey;

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
     * Constructor with key initialization including sign private key
     * 
     * @param priv RSA private key for encryption
     * @param pub RSA public key for decryption
     * @param signPriv RSA private key for transaction signing (optional)
     */
    public DataCrypto(String priv, String pub, String signPriv){
        this.privateKey = priv;
        this.publicKey = pub;
        this.signPrivateKey = signPriv;
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
    
    /**
     * Sign data using private key (RSA SHA256withRSA)
     * Uses signPrivateKey if set, otherwise uses privateKey
     * 
     * @param data the data to sign
     * @return String the signature (Base64 encoded)
     */
    @Override
    public String sign(String data){
        if (StringUtils.isBlank(data)) {
            return "";
        }
        String keyToUse = StringUtils.isNotBlank(this.signPrivateKey) ? this.signPrivateKey : this.privateKey;
        return RSAHelper.getSign(data, keyToUse);
    }
    
    /**
     * Check if sign private key is configured
     * 
     * @return true if signPrivateKey or privateKey is available for signing
     */
    @Override
    public boolean hasSignKey(){
        return StringUtils.isNotBlank(this.signPrivateKey) || StringUtils.isNotBlank(this.privateKey);
    }
    
    /**
     * Get sign private key
     * 
     * @return signPrivateKey if set, otherwise privateKey
     */
    public String getSignPrivateKey(){
        return StringUtils.isNotBlank(this.signPrivateKey) ? this.signPrivateKey : this.privateKey;
    }
    
    /**
     * Set sign private key for transaction signing
     * 
     * @param signPrivateKey RSA private key for signing
     */
    public void setSignPrivateKey(String signPrivateKey){
        this.signPrivateKey = signPrivateKey;
    }
}
