package com.coinbase.wallet.di;

import com.squareup.moshi.Moshi;

/* loaded from: classes.dex */
public final class NetworkCoreModule_ProvidesMoshiFactory implements f.c.d<Moshi> {

    /* loaded from: classes.dex */
    private static final class InstanceHolder {
        private static final NetworkCoreModule_ProvidesMoshiFactory INSTANCE = new NetworkCoreModule_ProvidesMoshiFactory();

        private InstanceHolder() {
        }
    }

    public static NetworkCoreModule_ProvidesMoshiFactory create() {
        return InstanceHolder.INSTANCE;
    }

    public static Moshi providesMoshi() {
        return (Moshi) f.c.h.f(NetworkCoreModule.providesMoshi());
    }

    @Override // javax.inject.Provider
    public Moshi get() {
        return providesMoshi();
    }
}