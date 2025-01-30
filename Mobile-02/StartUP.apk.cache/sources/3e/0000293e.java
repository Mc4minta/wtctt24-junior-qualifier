package com.coinbase.wallet.wallets.di;

import com.coinbase.wallet.blockchains.interfaces.TxManaging;
import com.coinbase.wallet.blockchains.models.NetworkSetting;
import com.coinbase.wallet.core.interfaces.Tracing;
import com.coinbase.wallet.store.interfaces.StoreInterface;
import com.coinbase.wallet.wallets.interfaces.ITxRepository;
import f.c.d;
import f.c.h;
import java.util.List;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class WalletsModule_ProvidesTxRepository$wallets_releaseFactory implements d<ITxRepository> {
    private final Provider<List<NetworkSetting>> networkSettingsProvider;
    private final Provider<List<TxManaging>> repositoriesProvider;
    private final Provider<StoreInterface> storeProvider;
    private final Provider<Tracing> tracerProvider;

    public WalletsModule_ProvidesTxRepository$wallets_releaseFactory(Provider<List<TxManaging>> provider, Provider<StoreInterface> provider2, Provider<List<NetworkSetting>> provider3, Provider<Tracing> provider4) {
        this.repositoriesProvider = provider;
        this.storeProvider = provider2;
        this.networkSettingsProvider = provider3;
        this.tracerProvider = provider4;
    }

    public static WalletsModule_ProvidesTxRepository$wallets_releaseFactory create(Provider<List<TxManaging>> provider, Provider<StoreInterface> provider2, Provider<List<NetworkSetting>> provider3, Provider<Tracing> provider4) {
        return new WalletsModule_ProvidesTxRepository$wallets_releaseFactory(provider, provider2, provider3, provider4);
    }

    public static ITxRepository providesTxRepository$wallets_release(List<TxManaging> list, StoreInterface storeInterface, List<NetworkSetting> list2, Tracing tracing) {
        ITxRepository providesTxRepository$wallets_release;
        providesTxRepository$wallets_release = WalletsModule.Companion.providesTxRepository$wallets_release(list, storeInterface, list2, tracing);
        return (ITxRepository) h.f(providesTxRepository$wallets_release);
    }

    @Override // javax.inject.Provider
    public ITxRepository get() {
        return providesTxRepository$wallets_release(this.repositoriesProvider.get(), this.storeProvider.get(), this.networkSettingsProvider.get(), this.tracerProvider.get());
    }
}