package com.coinbase.wallet.application.repository;

import com.coinbase.wallet.application.repository.interfaces.MnemonicRepositoryInterface;
import com.coinbase.wallet.store.interfaces.StoreInterface;
import e.j.d.g.w;
import javax.inject.Provider;

/* loaded from: classes.dex */
public final class AppLockRepository_Factory implements f.c.d<AppLockRepository> {
    private final Provider<e.j.g.a> keyguardManagerProvider;
    private final Provider<e.j.j.e> lockPrefsProvider;
    private final Provider<w> masterSeedHandlerProvider;
    private final Provider<MnemonicRepositoryInterface> mnemonicRepositoryProvider;
    private final Provider<StoreInterface> storeProvider;

    public AppLockRepository_Factory(Provider<MnemonicRepositoryInterface> provider, Provider<e.j.j.e> provider2, Provider<StoreInterface> provider3, Provider<w> provider4, Provider<e.j.g.a> provider5) {
        this.mnemonicRepositoryProvider = provider;
        this.lockPrefsProvider = provider2;
        this.storeProvider = provider3;
        this.masterSeedHandlerProvider = provider4;
        this.keyguardManagerProvider = provider5;
    }

    public static AppLockRepository_Factory create(Provider<MnemonicRepositoryInterface> provider, Provider<e.j.j.e> provider2, Provider<StoreInterface> provider3, Provider<w> provider4, Provider<e.j.g.a> provider5) {
        return new AppLockRepository_Factory(provider, provider2, provider3, provider4, provider5);
    }

    public static AppLockRepository newInstance(MnemonicRepositoryInterface mnemonicRepositoryInterface, e.j.j.e eVar, StoreInterface storeInterface, w wVar, e.j.g.a aVar) {
        return new AppLockRepository(mnemonicRepositoryInterface, eVar, storeInterface, wVar, aVar);
    }

    @Override // javax.inject.Provider
    public AppLockRepository get() {
        return newInstance(this.mnemonicRepositoryProvider.get(), this.lockPrefsProvider.get(), this.storeProvider.get(), this.masterSeedHandlerProvider.get(), this.keyguardManagerProvider.get());
    }
}