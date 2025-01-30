package com.coinbase.wallet.txhistory.apis;

import f.c.d;

/* loaded from: classes2.dex */
public final class TxHistoryApi_Factory implements d<TxHistoryApi> {

    /* loaded from: classes2.dex */
    private static final class InstanceHolder {
        private static final TxHistoryApi_Factory INSTANCE = new TxHistoryApi_Factory();

        private InstanceHolder() {
        }
    }

    public static TxHistoryApi_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static TxHistoryApi newInstance() {
        return new TxHistoryApi();
    }

    @Override // javax.inject.Provider
    public TxHistoryApi get() {
        return newInstance();
    }
}