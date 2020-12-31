package com.github.hicoincom.api.bean;

public enum DepositStatus {
    PENDING(0),
    DONE(1),
    FAILURE(2),
    ;
    private Integer value;

    private DepositStatus(Integer value){
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }
}
