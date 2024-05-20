package com.github.hicoincom.exception;

/**
 * @author ChainUp Cusotdy
 */
public class ArgsNullException extends RuntimeException {

    private static final long serialVersionUID = -1859928557432340788L;

    public ArgsNullException() {
        super();
    }

    public ArgsNullException(String msg) {
        super(msg);
    }
}
