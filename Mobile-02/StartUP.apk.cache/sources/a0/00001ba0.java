package com.coinbase.wallet.dogecoin.repositories;

import com.coinbase.ciphercore.CipherCoreInterface;
import com.coinbase.wallet.bip44wallets.apis.BatchBalanceAPI;
import com.coinbase.wallet.bip44wallets.daos.BIP44SignedTxDao;
import com.coinbase.wallet.blockchains.daos.AddressDao;
import com.coinbase.wallet.blockchains.daos.WalletDao;
import com.coinbase.wallet.core.interfaces.Tracing;
import com.coinbase.wallet.dogecoin.services.DOGEService;
import com.coinbase.wallet.store.interfaces.StoreInterface;
import f.c.d;
import javax.inject.Provider;

/* loaded from: classes.dex */
public final class DOGETxRepository_Factory implements d<DOGETxRepository> {
    private final Provider<AddressDao> addressDaoProvider;
    private final Provider<BatchBalanceAPI> batchBalanceAPIProvider;
    private final Provider<CipherCoreInterface> cipherCoreProvider;
    private final Provider<StoreInterface> storeProvider;
    private final Provider<Tracing> tracerProvider;
    private final Provider<BIP44SignedTxDao> txDaoProvider;
    private final Provider<WalletDao> walletDaoProvider;
    private final Provider<DOGEService> walletServiceProvider;

    public DOGETxRepository_Factory(Provider<DOGEService> provider, Provider<AddressDao> provider2, Provider<WalletDao> provider3, Provider<BIP44SignedTxDao> provider4, Provider<CipherCoreInterface> provider5, Provider<StoreInterface> provider6, Provider<Tracing> provider7, Provider<BatchBalanceAPI> provider8) {
        this.walletServiceProvider = provider;
        this.addressDaoProvider = provider2;
        this.walletDaoProvider = provider3;
        this.txDaoProvider = provider4;
        this.cipherCoreProvider = provider5;
        this.storeProvider = provider6;
        this.tracerProvider = provider7;
        this.batchBalanceAPIProvider = provider8;
    }

    public static DOGETxRepository_Factory create(Provider<DOGEService> provider, Provider<AddressDao> provider2, Provider<WalletDao> provider3, Provider<BIP44SignedTxDao> provider4, Provider<CipherCoreInterface> provider5, Provider<StoreInterface> provider6, Provider<Tracing> provider7, Provider<BatchBalanceAPI> provider8) {
        return new DOGETxRepository_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8);
    }

    public static DOGETxRepository newInstance(DOGEService dOGEService, AddressDao addressDao, WalletDao walletDao, BIP44SignedTxDao bIP44SignedTxDao, CipherCoreInterface cipherCoreInterface, StoreInterface storeInterface, Tracing tracing, BatchBalanceAPI batchBalanceAPI) {
        return new DOGETxRepository(dOGEService, addressDao, walletDao, bIP44SignedTxDao, cipherCoreInterface, storeInterface, tracing, batchBalanceAPI);
    }

    @Override // javax.inject.Provider
    public DOGETxRepository get() {
        return newInstance(this.walletServiceProvider.get(), this.addressDaoProvider.get(), this.walletDaoProvider.get(), this.txDaoProvider.get(), this.cipherCoreProvider.get(), this.storeProvider.get(), this.tracerProvider.get(), this.batchBalanceAPIProvider.get());
    }
}