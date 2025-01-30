package com.coinbase.wallet.di;

import com.coinbase.wallet.core.interfaces.Refreshable;

/* loaded from: classes.dex */
public final class RefreshablesModule_Companion_ProvidesInternetRefreshableFactory implements f.c.d<Refreshable> {

    /* loaded from: classes.dex */
    private static final class InstanceHolder {
        private static final RefreshablesModule_Companion_ProvidesInternetRefreshableFactory INSTANCE = new RefreshablesModule_Companion_ProvidesInternetRefreshableFactory();

        private InstanceHolder() {
        }
    }

    public static RefreshablesModule_Companion_ProvidesInternetRefreshableFactory create() {
        return InstanceHolder.INSTANCE;
    }

    public static Refreshable providesInternetRefreshable() {
        return (Refreshable) f.c.h.f(RefreshablesModule.Companion.providesInternetRefreshable());
    }

    @Override // javax.inject.Provider
    public Refreshable get() {
        return providesInternetRefreshable();
    }
}