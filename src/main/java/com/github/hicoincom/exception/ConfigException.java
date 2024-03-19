package com.github.hicoincom.exception;

/**
 * @author ChainUp Cusotdy
 */
public class ConfigException extends RuntimeException {

    private static final long serialVersionUID = -2109848660378898280L;

    public ConfigException() {
        super();
    }

    public ConfigException(String msg) {
        super(msg);
    }
}
