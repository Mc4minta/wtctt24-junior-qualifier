package com.coinbase.wallet.wallets.di;

import com.coinbase.ciphercore.CipherCoreInterface;
import com.coinbase.wallet.blockchains.daos.AddressDao;
import com.coinbase.wallet.blockchains.daos.WalletDao;
import com.coinbase.wallet.blockchains.interfaces.WalletManaging;
import com.coinbase.wallet.ripple.daos.XRPSignedTxDAO;
import com.coinbase.wallet.store.interfaces.StoreInterface;
import com.coinbase.walletengine.services.xrp.XRPService;
import f.c.d;
import f.c.h;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class WalletsRepositoriesModule_ProvidesXRPWalletRepositoryFactory implements d<WalletManaging> {
    private final Provider<AddressDao> addressDaoProvider;
    private final Provider<CipherCoreInterface> cipherCoreProvider;
    private final Provider<StoreInterface> storeProvider;
    private final Provider<WalletDao> walletDaoProvider;
    private final Provider<XRPService> xrpServiceProvider;
    private final Provider<XRPSignedTxDAO> xrpSignedTxDAOProvider;

    public WalletsRepositoriesModule_ProvidesXRPWalletRepositoryFactory(Provider<AddressDao> provider, Provider<WalletDao> provider2, Provider<StoreInterface> provider3, Provider<CipherCoreInterface> provider4, Provider<XRPService> provider5, Provider<XRPSignedTxDAO> provider6) {
        this.addressDaoProvider = provider;
        this.walletDaoProvider = provider2;
        this.storeProvider = provider3;
        this.cipherCoreProvider = provider4;
        this.xrpServiceProvider = provider5;
        this.xrpSignedTxDAOProvider = provider6;
    }

    public static WalletsRepositoriesModule_ProvidesXRPWalletRepositoryFactory create(Provider<AddressDao> provider, Provider<WalletDao> provider2, Provider<StoreInterface> provider3, Provider<CipherCoreInterface> provider4, Provider<XRPService> provider5, Provider<XRPSignedTxDAO> provider6) {
        return new WalletsRepositoriesModule_ProvidesXRPWalletRepositoryFactory(provider, provider2, provider3, provider4, provider5, provider6);
    }

    public static WalletManaging providesXRPWalletRepository(AddressDao addressDao, WalletDao walletDao, StoreInterface storeInterface, CipherCoreInterface cipherCoreInterface, XRPService xRPService, XRPSignedTxDAO xRPSignedTxDAO) {
        return (WalletManaging) h.f(WalletsRepositoriesModule.providesXRPWalletRepository(addressDao, walletDao, storeInterface, cipherCoreInterface, xRPService, xRPSignedTxDAO));
    }

    @Override // javax.inject.Provider
    public WalletManaging get() {
        return providesXRPWalletRepository(this.addressDaoProvider.get(), this.walletDaoProvider.get(), this.storeProvider.get(), this.cipherCoreProvider.get(), this.xrpServiceProvider.get(), this.xrpSignedTxDAOProvider.get());
    }
}