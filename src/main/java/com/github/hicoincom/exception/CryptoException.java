package com.github.hicoincom.exception;

/**
 * @author ChainUp Cusotdy
 */
public class CryptoException extends RuntimeException {

    private static final long serialVersionUID = -5547909633748960256L;

    public CryptoException() {
        super();
    }

    public CryptoException(String msg) {
        super(msg);
    }
}
