package com.chainup.waas.api.bean;

public enum WithdrawStatus {
    AUDIT(0),
    AUDIT_PASS(1),
    AUDIT_REJECT(2),
    PENDING(3),
    FAILURE(4),
    DONE(5),
    ;
    private Integer value;

    private WithdrawStatus(Integer value){
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }
}
