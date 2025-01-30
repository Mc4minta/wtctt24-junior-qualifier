package com.coinbase.wallet.appreview.repositories;

import com.coinbase.wallet.store.interfaces.StoreInterface;
import f.c.d;
import javax.inject.Provider;

/* loaded from: classes.dex */
public final class AppReviewRepository_Factory implements d<AppReviewRepository> {
    private final Provider<StoreInterface> storeProvider;

    public AppReviewRepository_Factory(Provider<StoreInterface> provider) {
        this.storeProvider = provider;
    }

    public static AppReviewRepository_Factory create(Provider<StoreInterface> provider) {
        return new AppReviewRepository_Factory(provider);
    }

    public static AppReviewRepository newInstance(StoreInterface storeInterface) {
        return new AppReviewRepository(storeInterface);
    }

    @Override // javax.inject.Provider
    public AppReviewRepository get() {
        return newInstance(this.storeProvider.get());
    }
}