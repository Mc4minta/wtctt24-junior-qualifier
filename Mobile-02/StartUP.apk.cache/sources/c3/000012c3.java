package com.coinbase.wallet.bip44wallets.apis;

import f.c.d;

/* loaded from: classes.dex */
public final class BatchBalanceAPI_Factory implements d<BatchBalanceAPI> {

    /* loaded from: classes.dex */
    private static final class InstanceHolder {
        private static final BatchBalanceAPI_Factory INSTANCE = new BatchBalanceAPI_Factory();

        private InstanceHolder() {
        }
    }

    public static BatchBalanceAPI_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static BatchBalanceAPI newInstance() {
        return new BatchBalanceAPI();
    }

    @Override // javax.inject.Provider
    public BatchBalanceAPI get() {
        return newInstance();
    }
}