package com.coinbase.wallet.swap.di;

import com.coinbase.wallet.libraries.databases.db.Database;
import com.coinbase.wallet.swap.daos.SwapAssetStatsDAO;
import com.coinbase.wallet.swap.db.SwapDatabase;
import f.c.d;
import f.c.h;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class SwapModule_ProvidesSwapAssetStatsDAO$swap_releaseFactory implements d<SwapAssetStatsDAO> {
    private final Provider<Database<SwapDatabase>> dbProvider;

    public SwapModule_ProvidesSwapAssetStatsDAO$swap_releaseFactory(Provider<Database<SwapDatabase>> provider) {
        this.dbProvider = provider;
    }

    public static SwapModule_ProvidesSwapAssetStatsDAO$swap_releaseFactory create(Provider<Database<SwapDatabase>> provider) {
        return new SwapModule_ProvidesSwapAssetStatsDAO$swap_releaseFactory(provider);
    }

    public static SwapAssetStatsDAO providesSwapAssetStatsDAO$swap_release(Database<SwapDatabase> database) {
        SwapAssetStatsDAO providesSwapAssetStatsDAO$swap_release;
        providesSwapAssetStatsDAO$swap_release = SwapModule.Companion.providesSwapAssetStatsDAO$swap_release(database);
        return (SwapAssetStatsDAO) h.f(providesSwapAssetStatsDAO$swap_release);
    }

    @Override // javax.inject.Provider
    public SwapAssetStatsDAO get() {
        return providesSwapAssetStatsDAO$swap_release(this.dbProvider.get());
    }
}