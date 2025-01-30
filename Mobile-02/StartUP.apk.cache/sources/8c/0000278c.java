package com.coinbase.wallet.txhistory.repositories;

import com.coinbase.wallet.blockchains.models.Blockchain;
import com.coinbase.wallet.blockchains.models.Network;
import com.coinbase.wallet.blockchains.models.TxState;
import com.coinbase.wallet.blockchains.models.TxUpdate;
import com.coinbase.wallet.blockchains.models.Wallet;
import com.coinbase.wallet.consumer.apis.ConsumerAPI;
import com.coinbase.wallet.core.interfaces.Tracing;
import com.coinbase.wallet.store.interfaces.StoreInterface;
import com.coinbase.wallet.txhistory.apis.TxHistoryApi;
import com.coinbase.wallet.txhistory.daos.TxAddressDAO;
import com.coinbase.wallet.txhistory.daos.TxHistoryDAO;
import com.coinbase.wallet.wallets.interfaces.IWalletRepository;
import com.coinbase.walletengine.services.xrp.XRPService;
import h.c.b0;
import java.util.List;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class TxHistoryRepository_Factory implements f.c.d<TxHistoryRepository> {
    private final Provider<ConsumerAPI> consumerAPIProvider;
    private final Provider<kotlin.e0.c.q<Blockchain, Network, String, b0<TxState>>> getTxStateProvider;
    private final Provider<StoreInterface> storeProvider;
    private final Provider<Tracing> tracerProvider;
    private final Provider<TxAddressDAO> txAddressDAOProvider;
    private final Provider<TxHistoryApi> txHistoryAPIProvider;
    private final Provider<TxHistoryDAO> txHistoryDAOProvider;
    private final Provider<h.c.s<TxUpdate>> txUpdateObservableProvider;
    private final Provider<IWalletRepository> walletRepositoryProvider;
    private final Provider<h.c.s<List<Wallet>>> walletsObservableProvider;
    private final Provider<XRPService> xrpServiceProvider;

    public TxHistoryRepository_Factory(Provider<TxHistoryDAO> provider, Provider<TxAddressDAO> provider2, Provider<TxHistoryApi> provider3, Provider<IWalletRepository> provider4, Provider<ConsumerAPI> provider5, Provider<StoreInterface> provider6, Provider<XRPService> provider7, Provider<h.c.s<TxUpdate>> provider8, Provider<h.c.s<List<Wallet>>> provider9, Provider<kotlin.e0.c.q<Blockchain, Network, String, b0<TxState>>> provider10, Provider<Tracing> provider11) {
        this.txHistoryDAOProvider = provider;
        this.txAddressDAOProvider = provider2;
        this.txHistoryAPIProvider = provider3;
        this.walletRepositoryProvider = provider4;
        this.consumerAPIProvider = provider5;
        this.storeProvider = provider6;
        this.xrpServiceProvider = provider7;
        this.txUpdateObservableProvider = provider8;
        this.walletsObservableProvider = provider9;
        this.getTxStateProvider = provider10;
        this.tracerProvider = provider11;
    }

    public static TxHistoryRepository_Factory create(Provider<TxHistoryDAO> provider, Provider<TxAddressDAO> provider2, Provider<TxHistoryApi> provider3, Provider<IWalletRepository> provider4, Provider<ConsumerAPI> provider5, Provider<StoreInterface> provider6, Provider<XRPService> provider7, Provider<h.c.s<TxUpdate>> provider8, Provider<h.c.s<List<Wallet>>> provider9, Provider<kotlin.e0.c.q<Blockchain, Network, String, b0<TxState>>> provider10, Provider<Tracing> provider11) {
        return new TxHistoryRepository_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9, provider10, provider11);
    }

    public static TxHistoryRepository newInstance(TxHistoryDAO txHistoryDAO, TxAddressDAO txAddressDAO, TxHistoryApi txHistoryApi, IWalletRepository iWalletRepository, ConsumerAPI consumerAPI, StoreInterface storeInterface, XRPService xRPService, h.c.s<TxUpdate> sVar, h.c.s<List<Wallet>> sVar2, kotlin.e0.c.q<Blockchain, Network, String, b0<TxState>> qVar, Tracing tracing) {
        return new TxHistoryRepository(txHistoryDAO, txAddressDAO, txHistoryApi, iWalletRepository, consumerAPI, storeInterface, xRPService, sVar, sVar2, qVar, tracing);
    }

    @Override // javax.inject.Provider
    public TxHistoryRepository get() {
        return newInstance(this.txHistoryDAOProvider.get(), this.txAddressDAOProvider.get(), this.txHistoryAPIProvider.get(), this.walletRepositoryProvider.get(), this.consumerAPIProvider.get(), this.storeProvider.get(), this.xrpServiceProvider.get(), this.txUpdateObservableProvider.get(), this.walletsObservableProvider.get(), this.getTxStateProvider.get(), this.tracerProvider.get());
    }
}