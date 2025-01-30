package com.coinbase.wallet.features.send.repositories;

import com.coinbase.wallet.consumer.repositories.ConsumerAccountsRepository;
import com.coinbase.wallet.featureflags.repositories.FeatureFlagsRepository;
import com.coinbase.wallet.features.send.apis.RecipientAPI;
import com.coinbase.wallet.features.send.daos.RecipientDao;
import com.coinbase.wallet.store.interfaces.StoreInterface;
import com.coinbase.wallet.txhistory.daos.TxAddressDAO;
import com.coinbase.wallet.wallets.interfaces.ITxRepository;
import com.coinbase.walletengine.services.resolver.ResolverService;
import javax.inject.Provider;

/* loaded from: classes.dex */
public final class RecipientRepository_Factory implements f.c.d<RecipientRepository> {
    private final Provider<ConsumerAccountsRepository> consumerAccountsRepositoryProvider;
    private final Provider<FeatureFlagsRepository> featureFlagRepositoryProvider;
    private final Provider<RecipientAPI> recipientAPIProvider;
    private final Provider<RecipientDao> recipientDAOProvider;
    private final Provider<ResolverService> resolverServiceProvider;
    private final Provider<StoreInterface> storeProvider;
    private final Provider<TxAddressDAO> txAddressDAOProvider;
    private final Provider<ITxRepository> txRepositoryProvider;

    public RecipientRepository_Factory(Provider<TxAddressDAO> provider, Provider<RecipientDao> provider2, Provider<RecipientAPI> provider3, Provider<ResolverService> provider4, Provider<StoreInterface> provider5, Provider<ConsumerAccountsRepository> provider6, Provider<FeatureFlagsRepository> provider7, Provider<ITxRepository> provider8) {
        this.txAddressDAOProvider = provider;
        this.recipientDAOProvider = provider2;
        this.recipientAPIProvider = provider3;
        this.resolverServiceProvider = provider4;
        this.storeProvider = provider5;
        this.consumerAccountsRepositoryProvider = provider6;
        this.featureFlagRepositoryProvider = provider7;
        this.txRepositoryProvider = provider8;
    }

    public static RecipientRepository_Factory create(Provider<TxAddressDAO> provider, Provider<RecipientDao> provider2, Provider<RecipientAPI> provider3, Provider<ResolverService> provider4, Provider<StoreInterface> provider5, Provider<ConsumerAccountsRepository> provider6, Provider<FeatureFlagsRepository> provider7, Provider<ITxRepository> provider8) {
        return new RecipientRepository_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8);
    }

    public static RecipientRepository newInstance(TxAddressDAO txAddressDAO, RecipientDao recipientDao, RecipientAPI recipientAPI, ResolverService resolverService, StoreInterface storeInterface, ConsumerAccountsRepository consumerAccountsRepository, FeatureFlagsRepository featureFlagsRepository, ITxRepository iTxRepository) {
        return new RecipientRepository(txAddressDAO, recipientDao, recipientAPI, resolverService, storeInterface, consumerAccountsRepository, featureFlagsRepository, iTxRepository);
    }

    @Override // javax.inject.Provider
    public RecipientRepository get() {
        return newInstance(this.txAddressDAOProvider.get(), this.recipientDAOProvider.get(), this.recipientAPIProvider.get(), this.resolverServiceProvider.get(), this.storeProvider.get(), this.consumerAccountsRepositoryProvider.get(), this.featureFlagRepositoryProvider.get(), this.txRepositoryProvider.get());
    }
}