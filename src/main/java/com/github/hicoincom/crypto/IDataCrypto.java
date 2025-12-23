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
}
