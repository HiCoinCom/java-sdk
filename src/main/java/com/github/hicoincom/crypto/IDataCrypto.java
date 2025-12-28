package com.github.hicoincom.crypto;

/**
 * Interface for data encryption and decryption operations
 * 
 * This interface defines the contract for encrypting and decrypting
 * data when communicating with the ChainUp Custody API.
 */
public interface IDataCrypto {
    /**
     * Decrypt ciphertext to plaintext
     * 
     * @param cipher the encrypted data to decrypt
     * @return String the decrypted plaintext
     */
    String decode(String cipher);
    
    /**
     * Encrypt plaintext to ciphertext
     * 
     * @param raw the plaintext data to encrypt
     * @return String the encrypted ciphertext
     */
    String encode(String raw);
    
    /**
     * Sign data using private key (RSA SHA256withRSA)
     * Uses signPrivateKey if set, otherwise uses privateKey
     * 
     * @param data the data to sign
     * @return String the signature (Base64 encoded)
     */
    String sign(String data);
    
    /**
     * Check if sign private key is configured
     * 
     * @return true if signPrivateKey or privateKey is available for signing
     */
    boolean hasSignKey();
}
