package com.coinbase.wallet.wallets.di;

import com.coinbase.ciphercore.CipherCoreInterface;
import com.coinbase.wallet.bip44wallets.apis.BatchBalanceAPI;
import com.coinbase.wallet.bitcoincash.services.BCHService;
import com.coinbase.wallet.blockchains.daos.AddressDao;
import com.coinbase.wallet.blockchains.daos.WalletDao;
import com.coinbase.wallet.blockchains.interfaces.WalletManaging;
import com.coinbase.wallet.core.interfaces.Tracing;
import com.coinbase.wallet.store.interfaces.StoreInterface;
import f.c.d;
import f.c.h;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class WalletsRepositoriesModule_ProvidesBCHWalletRepositoryFactory implements d<WalletManaging> {
    private final Provider<AddressDao> addressDaoProvider;
    private final Provider<BatchBalanceAPI> batchBalanceAPIProvider;
    private final Provider<BCHService> bchServiceProvider;
    private final Provider<CipherCoreInterface> cipherCoreProvider;
    private final Provider<StoreInterface> storeProvider;
    private final Provider<Tracing> tracerProvider;
    private final Provider<WalletDao> walletDaoProvider;

    public WalletsRepositoriesModule_ProvidesBCHWalletRepositoryFactory(Provider<AddressDao> provider, Provider<WalletDao> provider2, Provider<StoreInterface> provider3, Provider<CipherCoreInterface> provider4, Provider<BCHService> provider5, Provider<Tracing> provider6, Provider<BatchBalanceAPI> provider7) {
        this.addressDaoProvider = provider;
        this.walletDaoProvider = provider2;
        this.storeProvider = provider3;
        this.cipherCoreProvider = provider4;
        this.bchServiceProvider = provider5;
        this.tracerProvider = provider6;
        this.batchBalanceAPIProvider = provider7;
    }

    public static WalletsRepositoriesModule_ProvidesBCHWalletRepositoryFactory create(Provider<AddressDao> provider, Provider<WalletDao> provider2, Provider<StoreInterface> provider3, Provider<CipherCoreInterface> provider4, Provider<BCHService> provider5, Provider<Tracing> provider6, Provider<BatchBalanceAPI> provider7) {
        return new WalletsRepositoriesModule_ProvidesBCHWalletRepositoryFactory(provider, provider2, provider3, provider4, provider5, provider6, provider7);
    }

    public static WalletManaging providesBCHWalletRepository(AddressDao addressDao, WalletDao walletDao, StoreInterface storeInterface, CipherCoreInterface cipherCoreInterface, BCHService bCHService, Tracing tracing, BatchBalanceAPI batchBalanceAPI) {
        return (WalletManaging) h.f(WalletsRepositoriesModule.providesBCHWalletRepository(addressDao, walletDao, storeInterface, cipherCoreInterface, bCHService, tracing, batchBalanceAPI));
    }

    @Override // javax.inject.Provider
    public WalletManaging get() {
        return providesBCHWalletRepository(this.addressDaoProvider.get(), this.walletDaoProvider.get(), this.storeProvider.get(), this.cipherCoreProvider.get(), this.bchServiceProvider.get(), this.tracerProvider.get(), this.batchBalanceAPIProvider.get());
    }
}