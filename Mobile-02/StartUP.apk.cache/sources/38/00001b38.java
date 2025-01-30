package com.coinbase.wallet.di;

import com.squareup.moshi.Moshi;

/* loaded from: classes.dex */
public final class NetworkCoreModule_Companion_ProvidesMoshiFactory implements f.c.d<Moshi> {

    /* loaded from: classes.dex */
    private static final class InstanceHolder {
        private static final NetworkCoreModule_Companion_ProvidesMoshiFactory INSTANCE = new NetworkCoreModule_Companion_ProvidesMoshiFactory();

        private InstanceHolder() {
        }
    }

    public static NetworkCoreModule_Companion_ProvidesMoshiFactory create() {
        return InstanceHolder.INSTANCE;
    }

    public static Moshi providesMoshi() {
        return (Moshi) f.c.h.f(NetworkCoreModule.Companion.providesMoshi());
    }

    @Override // javax.inject.Provider
    public Moshi get() {
        return providesMoshi();
    }
}