package com.coinbase.wallet.consumer.repositories;

import com.coinbase.Coinbase;
import com.coinbase.wallet.consumer.apis.ConsumerAPI;
import com.coinbase.wallet.consumer.daos.ConsumerAccountsDAO;
import com.coinbase.wallet.core.interfaces.Tracing;
import com.coinbase.wallet.store.interfaces.StoreInterface;
import com.coinbase.wallet.user.interfaces.UserDaoInterface;
import com.coinbase.wallet.user.repositories.UserRepository;
import com.coinbase.wallet.wallets.interfaces.IWalletRepository;
import javax.inject.Provider;

/* loaded from: classes.dex */
public final class ConsumerAccountsRepository_Factory implements f.c.d<ConsumerAccountsRepository> {
    private final Provider<Coinbase> coinbaseApiProvider;
    private final Provider<ConsumerAPI> consumerAPIProvider;
    private final Provider<ConsumerAccountsDAO> consumerAccountsDAOProvider;
    private final Provider<StoreInterface> storeProvider;
    private final Provider<Tracing> tracerProvider;
    private final Provider<UserDaoInterface> userDaoProvider;
    private final Provider<UserRepository> userRepositoryProvider;
    private final Provider<IWalletRepository> walletsRepositoryProvider;

    public ConsumerAccountsRepository_Factory(Provider<StoreInterface> provider, Provider<ConsumerAccountsDAO> provider2, Provider<ConsumerAPI> provider3, Provider<Coinbase> provider4, Provider<UserRepository> provider5, Provider<IWalletRepository> provider6, Provider<UserDaoInterface> provider7, Provider<Tracing> provider8) {
        this.storeProvider = provider;
        this.consumerAccountsDAOProvider = provider2;
        this.consumerAPIProvider = provider3;
        this.coinbaseApiProvider = provider4;
        this.userRepositoryProvider = provider5;
        this.walletsRepositoryProvider = provider6;
        this.userDaoProvider = provider7;
        this.tracerProvider = provider8;
    }

    public static ConsumerAccountsRepository_Factory create(Provider<StoreInterface> provider, Provider<ConsumerAccountsDAO> provider2, Provider<ConsumerAPI> provider3, Provider<Coinbase> provider4, Provider<UserRepository> provider5, Provider<IWalletRepository> provider6, Provider<UserDaoInterface> provider7, Provider<Tracing> provider8) {
        return new ConsumerAccountsRepository_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8);
    }

    public static ConsumerAccountsRepository newInstance(StoreInterface storeInterface, ConsumerAccountsDAO consumerAccountsDAO, ConsumerAPI consumerAPI, Coinbase coinbase, UserRepository userRepository, IWalletRepository iWalletRepository, UserDaoInterface userDaoInterface, Tracing tracing) {
        return new ConsumerAccountsRepository(storeInterface, consumerAccountsDAO, consumerAPI, coinbase, userRepository, iWalletRepository, userDaoInterface, tracing);
    }

    @Override // javax.inject.Provider
    public ConsumerAccountsRepository get() {
        return newInstance(this.storeProvider.get(), this.consumerAccountsDAOProvider.get(), this.consumerAPIProvider.get(), this.coinbaseApiProvider.get(), this.userRepositoryProvider.get(), this.walletsRepositoryProvider.get(), this.userDaoProvider.get(), this.tracerProvider.get());
    }
}