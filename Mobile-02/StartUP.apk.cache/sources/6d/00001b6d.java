package com.coinbase.wallet.di;

import android.content.Context;
import com.coinbase.wallet.store.interfaces.StoreInterface;
import javax.inject.Provider;

/* loaded from: classes.dex */
public final class StoreModule_Companion_ProvidesStoreFactory implements f.c.d<StoreInterface> {
    private final Provider<Context> contextProvider;

    public StoreModule_Companion_ProvidesStoreFactory(Provider<Context> provider) {
        this.contextProvider = provider;
    }

    public static StoreModule_Companion_ProvidesStoreFactory create(Provider<Context> provider) {
        return new StoreModule_Companion_ProvidesStoreFactory(provider);
    }

    public static StoreInterface providesStore(Context context) {
        return (StoreInterface) f.c.h.f(StoreModule.Companion.providesStore(context));
    }

    @Override // javax.inject.Provider
    public StoreInterface get() {
        return providesStore(this.contextProvider.get());
    }
}