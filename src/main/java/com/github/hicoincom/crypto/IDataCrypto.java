package com.github.hicoincom.crypto;

public interface IDataCrypto {
    String decode(String cipher);
    String encode(String raw);
}
