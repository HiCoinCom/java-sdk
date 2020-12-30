package com.chainup.waas.crypto;

public interface IDataCrypto {
    String decode(String cipher);
    String encode(String raw);
}
