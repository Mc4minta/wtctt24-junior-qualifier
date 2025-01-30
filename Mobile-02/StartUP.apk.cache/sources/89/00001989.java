package com.coinbase.wallet.di;

import com.coinbase.wallet.http.connectivity.ConnectionStatus;
import h.c.s;

/* loaded from: classes.dex */
public final class AppModule_ProvidesConnectivitySubjectFactory implements f.c.d<s<ConnectionStatus>> {

    /* loaded from: classes.dex */
    private static final class InstanceHolder {
        private static final AppModule_ProvidesConnectivitySubjectFactory INSTANCE = new AppModule_ProvidesConnectivitySubjectFactory();

        private InstanceHolder() {
        }
    }

    public static AppModule_ProvidesConnectivitySubjectFactory create() {
        return InstanceHolder.INSTANCE;
    }

    public static s<ConnectionStatus> providesConnectivitySubject() {
        return (s) f.c.h.f(AppModule.providesConnectivitySubject());
    }

    @Override // javax.inject.Provider
    public s<ConnectionStatus> get() {
        return providesConnectivitySubject();
    }
}