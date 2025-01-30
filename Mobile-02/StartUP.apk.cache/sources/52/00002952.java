package com.coinbase.wallet.wallets.di;

import com.coinbase.ciphercore.CipherCoreInterface;
import com.coinbase.wallet.blockchains.daos.AddressDao;
import com.coinbase.wallet.blockchains.daos.WalletDao;
import com.coinbase.wallet.blockchains.interfaces.WalletManaging;
import com.coinbase.walletengine.services.stellar.StellarService;
import f.c.d;
import f.c.h;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class WalletsRepositoriesModule_ProvidesStellarWalletRepositoryFactory implements d<WalletManaging> {
    private final Provider<AddressDao> addressDaoProvider;
    private final Provider<CipherCoreInterface> cipherCoreProvider;
    private final Provider<StellarService> stellarServiceProvider;
    private final Provider<WalletDao> walletDaoProvider;

    public WalletsRepositoriesModule_ProvidesStellarWalletRepositoryFactory(Provider<AddressDao> provider, Provider<WalletDao> provider2, Provider<CipherCoreInterface> provider3, Provider<StellarService> provider4) {
        this.addressDaoProvider = provider;
        this.walletDaoProvider = provider2;
        this.cipherCoreProvider = provider3;
        this.stellarServiceProvider = provider4;
    }

    public static WalletsRepositoriesModule_ProvidesStellarWalletRepositoryFactory create(Provider<AddressDao> provider, Provider<WalletDao> provider2, Provider<CipherCoreInterface> provider3, Provider<StellarService> provider4) {
        return new WalletsRepositoriesModule_ProvidesStellarWalletRepositoryFactory(provider, provider2, provider3, provider4);
    }

    public static WalletManaging providesStellarWalletRepository(AddressDao addressDao, WalletDao walletDao, CipherCoreInterface cipherCoreInterface, StellarService stellarService) {
        return (WalletManaging) h.f(WalletsRepositoriesModule.providesStellarWalletRepository(addressDao, walletDao, cipherCoreInterface, stellarService));
    }

    @Override // javax.inject.Provider
    public WalletManaging get() {
        return providesStellarWalletRepository(this.addressDaoProvider.get(), this.walletDaoProvider.get(), this.cipherCoreProvider.get(), this.stellarServiceProvider.get());
    }
}