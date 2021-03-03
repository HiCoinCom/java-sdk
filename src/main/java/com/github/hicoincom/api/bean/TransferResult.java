package com.github.hicoincom.api.bean;

import java.io.Serializable;

/**
 * 接口只返回了receipt字段
 */
public class TransferResult extends Result<Transfer> implements Serializable {
    private static final long serialVersionUID = 1L;
}
