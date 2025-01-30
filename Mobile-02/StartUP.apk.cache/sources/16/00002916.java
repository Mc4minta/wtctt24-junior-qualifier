package com.coinbase.wallet.wallets.di;

import com.coinbase.ciphercore.CipherCoreInterface;
import com.coinbase.wallet.blockchains.daos.AddressDao;
import com.coinbase.wallet.blockchains.daos.WalletDao;
import com.coinbase.wallet.blockchains.interfaces.TxManaging;
import com.coinbase.wallet.stellar.api.TimeAPI;
import com.coinbase.wallet.stellar.daos.StellarSignedTxDao;
import com.coinbase.walletengine.services.stellar.StellarService;
import f.c.d;
import f.c.h;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class TxManagingModule_Companion_ProvidesStellarTxManaging$wallets_releaseFactory implements d<TxManaging> {
    private final Provider<AddressDao> addressDaoProvider;
    private final Provider<CipherCoreInterface> cipherCoreProvider;
    private final Provider<TimeAPI> timeAPIProvider;
    private final Provider<StellarSignedTxDao> txDaoProvider;
    private final Provider<WalletDao> walletDaoProvider;
    private final Provider<StellarService> walletServiceProvider;

    public TxManagingModule_Companion_ProvidesStellarTxManaging$wallets_releaseFactory(Provider<StellarSignedTxDao> provider, Provider<CipherCoreInterface> provider2, Provider<TimeAPI> provider3, Provider<StellarService> provider4, Provider<AddressDao> provider5, Provider<WalletDao> provider6) {
        this.txDaoProvider = provider;
        this.cipherCoreProvider = provider2;
        this.timeAPIProvider = provider3;
        this.walletServiceProvider = provider4;
        this.addressDaoProvider = provider5;
        this.walletDaoProvider = provider6;
    }

    public static TxManagingModule_Companion_ProvidesStellarTxManaging$wallets_releaseFactory create(Provider<StellarSignedTxDao> provider, Provider<CipherCoreInterface> provider2, Provider<TimeAPI> provider3, Provider<StellarService> provider4, Provider<AddressDao> provider5, Provider<WalletDao> provider6) {
        return new TxManagingModule_Companion_ProvidesStellarTxManaging$wallets_releaseFactory(provider, provider2, provider3, provider4, provider5, provider6);
    }

    public static TxManaging providesStellarTxManaging$wallets_release(StellarSignedTxDao stellarSignedTxDao, CipherCoreInterface cipherCoreInterface, TimeAPI timeAPI, StellarService stellarService, AddressDao addressDao, WalletDao walletDao) {
        return (TxManaging) h.f(TxManagingModule.Companion.providesStellarTxManaging$wallets_release(stellarSignedTxDao, cipherCoreInterface, timeAPI, stellarService, addressDao, walletDao));
    }

    @Override // javax.inject.Provider
    public TxManaging get() {
        return providesStellarTxManaging$wallets_release(this.txDaoProvider.get(), this.cipherCoreProvider.get(), this.timeAPIProvider.get(), this.walletServiceProvider.get(), this.addressDaoProvider.get(), this.walletDaoProvider.get());
    }
}