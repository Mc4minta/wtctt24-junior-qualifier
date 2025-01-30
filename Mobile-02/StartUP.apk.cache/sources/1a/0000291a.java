package com.coinbase.wallet.wallets.di;

import com.coinbase.ciphercore.CipherCoreInterface;
import com.coinbase.wallet.bip44wallets.apis.BatchBalanceAPI;
import com.coinbase.wallet.bip44wallets.daos.BIP44SignedTxDao;
import com.coinbase.wallet.bitcoin.services.BTCService;
import com.coinbase.wallet.blockchains.daos.AddressDao;
import com.coinbase.wallet.blockchains.daos.WalletDao;
import com.coinbase.wallet.blockchains.interfaces.TxManaging;
import com.coinbase.wallet.core.interfaces.Tracing;
import com.coinbase.wallet.store.interfaces.StoreInterface;
import f.c.d;
import f.c.h;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class TxManagingModule_ProvidesBTCTxManaging$wallets_releaseFactory implements d<TxManaging> {
    private final Provider<AddressDao> addressDaoProvider;
    private final Provider<BatchBalanceAPI> batchBalanceAPIProvider;
    private final Provider<CipherCoreInterface> cipherCoreProvider;
    private final Provider<StoreInterface> storeProvider;
    private final Provider<Tracing> tracerProvider;
    private final Provider<BIP44SignedTxDao> txDaoProvider;
    private final Provider<WalletDao> walletDaoProvider;
    private final Provider<BTCService> walletServiceProvider;

    public TxManagingModule_ProvidesBTCTxManaging$wallets_releaseFactory(Provider<BTCService> provider, Provider<AddressDao> provider2, Provider<WalletDao> provider3, Provider<BIP44SignedTxDao> provider4, Provider<CipherCoreInterface> provider5, Provider<StoreInterface> provider6, Provider<Tracing> provider7, Provider<BatchBalanceAPI> provider8) {
        this.walletServiceProvider = provider;
        this.addressDaoProvider = provider2;
        this.walletDaoProvider = provider3;
        this.txDaoProvider = provider4;
        this.cipherCoreProvider = provider5;
        this.storeProvider = provider6;
        this.tracerProvider = provider7;
        this.batchBalanceAPIProvider = provider8;
    }

    public static TxManagingModule_ProvidesBTCTxManaging$wallets_releaseFactory create(Provider<BTCService> provider, Provider<AddressDao> provider2, Provider<WalletDao> provider3, Provider<BIP44SignedTxDao> provider4, Provider<CipherCoreInterface> provider5, Provider<StoreInterface> provider6, Provider<Tracing> provider7, Provider<BatchBalanceAPI> provider8) {
        return new TxManagingModule_ProvidesBTCTxManaging$wallets_releaseFactory(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8);
    }

    public static TxManaging providesBTCTxManaging$wallets_release(BTCService bTCService, AddressDao addressDao, WalletDao walletDao, BIP44SignedTxDao bIP44SignedTxDao, CipherCoreInterface cipherCoreInterface, StoreInterface storeInterface, Tracing tracing, BatchBalanceAPI batchBalanceAPI) {
        TxManaging providesBTCTxManaging$wallets_release;
        providesBTCTxManaging$wallets_release = TxManagingModule.Companion.providesBTCTxManaging$wallets_release(bTCService, addressDao, walletDao, bIP44SignedTxDao, cipherCoreInterface, storeInterface, tracing, batchBalanceAPI);
        return (TxManaging) h.f(providesBTCTxManaging$wallets_release);
    }

    @Override // javax.inject.Provider
    public TxManaging get() {
        return providesBTCTxManaging$wallets_release(this.walletServiceProvider.get(), this.addressDaoProvider.get(), this.walletDaoProvider.get(), this.txDaoProvider.get(), this.cipherCoreProvider.get(), this.storeProvider.get(), this.tracerProvider.get(), this.batchBalanceAPIProvider.get());
    }
}