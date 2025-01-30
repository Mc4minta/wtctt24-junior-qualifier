package com.coinbase.wallet.di;

import android.content.Context;
import com.coinbase.wallet.store.Store;
import javax.inject.Provider;

/* loaded from: classes.dex */
public final class AppCoreModule_Companion_ProvidesStoreFactory implements f.c.d<Store> {
    private final Provider<Context> contextProvider;

    public AppCoreModule_Companion_ProvidesStoreFactory(Provider<Context> provider) {
        this.contextProvider = provider;
    }

    public static AppCoreModule_Companion_ProvidesStoreFactory create(Provider<Context> provider) {
        return new AppCoreModule_Companion_ProvidesStoreFactory(provider);
    }

    public static Store providesStore(Context context) {
        return (Store) f.c.h.f(AppCoreModule.Companion.providesStore(context));
    }

    @Override // javax.inject.Provider
    public Store get() {
        return providesStore(this.contextProvider.get());
    }
}