package com.coinbase.wallet.wallets.di;

import com.coinbase.ciphercore.CipherCoreInterface;
import com.coinbase.wallet.bip44wallets.apis.BatchBalanceAPI;
import com.coinbase.wallet.bitcoin.services.BTCService;
import com.coinbase.wallet.blockchains.daos.AddressDao;
import com.coinbase.wallet.blockchains.daos.WalletDao;
import com.coinbase.wallet.blockchains.interfaces.WalletManaging;
import com.coinbase.wallet.core.interfaces.Tracing;
import com.coinbase.wallet.store.interfaces.StoreInterface;
import f.c.d;
import f.c.h;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class WalletsRepositoriesModule_ProvidesBTCWalletRepositoryFactory implements d<WalletManaging> {
    private final Provider<AddressDao> addressDaoProvider;
    private final Provider<BatchBalanceAPI> batchBalanceAPIProvider;
    private final Provider<BTCService> btcServiceProvider;
    private final Provider<CipherCoreInterface> cipherCoreProvider;
    private final Provider<StoreInterface> storeProvider;
    private final Provider<Tracing> tracerProvider;
    private final Provider<WalletDao> walletDaoProvider;

    public WalletsRepositoriesModule_ProvidesBTCWalletRepositoryFactory(Provider<AddressDao> provider, Provider<WalletDao> provider2, Provider<StoreInterface> provider3, Provider<CipherCoreInterface> provider4, Provider<BTCService> provider5, Provider<Tracing> provider6, Provider<BatchBalanceAPI> provider7) {
        this.addressDaoProvider = provider;
        this.walletDaoProvider = provider2;
        this.storeProvider = provider3;
        this.cipherCoreProvider = provider4;
        this.btcServiceProvider = provider5;
        this.tracerProvider = provider6;
        this.batchBalanceAPIProvider = provider7;
    }

    public static WalletsRepositoriesModule_ProvidesBTCWalletRepositoryFactory create(Provider<AddressDao> provider, Provider<WalletDao> provider2, Provider<StoreInterface> provider3, Provider<CipherCoreInterface> provider4, Provider<BTCService> provider5, Provider<Tracing> provider6, Provider<BatchBalanceAPI> provider7) {
        return new WalletsRepositoriesModule_ProvidesBTCWalletRepositoryFactory(provider, provider2, provider3, provider4, provider5, provider6, provider7);
    }

    public static WalletManaging providesBTCWalletRepository(AddressDao addressDao, WalletDao walletDao, StoreInterface storeInterface, CipherCoreInterface cipherCoreInterface, BTCService bTCService, Tracing tracing, BatchBalanceAPI batchBalanceAPI) {
        return (WalletManaging) h.f(WalletsRepositoriesModule.providesBTCWalletRepository(addressDao, walletDao, storeInterface, cipherCoreInterface, bTCService, tracing, batchBalanceAPI));
    }

    @Override // javax.inject.Provider
    public WalletManaging get() {
        return providesBTCWalletRepository(this.addressDaoProvider.get(), this.walletDaoProvider.get(), this.storeProvider.get(), this.cipherCoreProvider.get(), this.btcServiceProvider.get(), this.tracerProvider.get(), this.batchBalanceAPIProvider.get());
    }
}