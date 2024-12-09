package com.github.hicoincom.api.mpc;

import com.github.hicoincom.api.bean.mpc.NotifyArgs;

public interface INotifyApi {

    /**
     * Decrypt deposit and withdrawal notification parameters
     *
     * @param cipher
     * @return
     */
    NotifyArgs notifyRequest(String cipher);
}
