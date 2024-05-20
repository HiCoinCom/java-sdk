package com.github.hicoincom.enums;

public enum MinerFeeStatus {
    PENDING(0),
    DONE(1),
    FAILURE(2),
    ;
    private Integer value;

    private MinerFeeStatus(Integer value){
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }
}
