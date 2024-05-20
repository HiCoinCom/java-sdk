package com.github.hicoincom.enums;

import org.apache.commons.lang3.StringUtils;

/**
 * @author Chainup Custody
 */
public enum AppShowStatus {

    /**
     *  wallet show status
     */
    SHOW("1", "show wallet"),
    HIDDEN("2", "don’t show wallet");

    private String showStatus;
    private String des;

    private AppShowStatus(String showStatus, String des) {
        this.showStatus = showStatus;
        this.des = des;
    }

    public String getShowStatus() {
        return showStatus;
    }

    public void setShowStatus(String showStatus) {
        this.showStatus = showStatus;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public static AppShowStatus showStatus(String showStatus) {
        if (StringUtils.isBlank(showStatus)) {
            return null;
        }
        for (AppShowStatus t : AppShowStatus.values()) {
            if (t.showStatus.equals(showStatus.trim())) {
                return t;
            }
        }
        return null;
    }
}
