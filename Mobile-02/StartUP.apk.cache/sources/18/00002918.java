package com.coinbase.wallet.wallets.di;

import com.coinbase.ciphercore.CipherCoreInterface;
import com.coinbase.wallet.blockchains.daos.AddressDao;
import com.coinbase.wallet.blockchains.daos.WalletDao;
import com.coinbase.wallet.blockchains.interfaces.TxManaging;
import com.coinbase.wallet.ripple.daos.XRPSignedTxDAO;
import com.coinbase.wallet.store.interfaces.StoreInterface;
import com.coinbase.walletengine.services.xrp.XRPService;
import f.c.d;
import f.c.h;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class TxManagingModule_Companion_ProvidesXRPTxManaging$wallets_releaseFactory implements d<TxManaging> {
    private final Provider<AddressDao> addressDaoProvider;
    private final Provider<CipherCoreInterface> cipherCoreProvider;
    private final Provider<StoreInterface> storeProvider;
    private final Provider<WalletDao> walletDaoProvider;
    private final Provider<XRPService> walletServiceProvider;
    private final Provider<XRPSignedTxDAO> xrpSignedTxDAOProvider;

    public TxManagingModule_Companion_ProvidesXRPTxManaging$wallets_releaseFactory(Provider<CipherCoreInterface> provider, Provider<XRPSignedTxDAO> provider2, Provider<XRPService> provider3, Provider<AddressDao> provider4, Provider<WalletDao> provider5, Provider<StoreInterface> provider6) {
        this.cipherCoreProvider = provider;
        this.xrpSignedTxDAOProvider = provider2;
        this.walletServiceProvider = provider3;
        this.addressDaoProvider = provider4;
        this.walletDaoProvider = provider5;
        this.storeProvider = provider6;
    }

    public static TxManagingModule_Companion_ProvidesXRPTxManaging$wallets_releaseFactory create(Provider<CipherCoreInterface> provider, Provider<XRPSignedTxDAO> provider2, Provider<XRPService> provider3, Provider<AddressDao> provider4, Provider<WalletDao> provider5, Provider<StoreInterface> provider6) {
        return new TxManagingModule_Companion_ProvidesXRPTxManaging$wallets_releaseFactory(provider, provider2, provider3, provider4, provider5, provider6);
    }

    public static TxManaging providesXRPTxManaging$wallets_release(CipherCoreInterface cipherCoreInterface, XRPSignedTxDAO xRPSignedTxDAO, XRPService xRPService, AddressDao addressDao, WalletDao walletDao, StoreInterface storeInterface) {
        return (TxManaging) h.f(TxManagingModule.Companion.providesXRPTxManaging$wallets_release(cipherCoreInterface, xRPSignedTxDAO, xRPService, addressDao, walletDao, storeInterface));
    }

    @Override // javax.inject.Provider
    public TxManaging get() {
        return providesXRPTxManaging$wallets_release(this.cipherCoreProvider.get(), this.xrpSignedTxDAOProvider.get(), this.walletServiceProvider.get(), this.addressDaoProvider.get(), this.walletDaoProvider.get(), this.storeProvider.get());
    }
}