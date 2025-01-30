package com.coinbase.wallet.features.send.repositories;

import com.coinbase.ciphercore.CipherCoreInterface;
import com.coinbase.wallet.ethereum.apis.MinerFeeAPI;
import com.coinbase.wallet.ethereum.daos.EthereumSignedTxDao;
import com.coinbase.wallet.store.interfaces.StoreInterface;
import com.coinbase.wallet.wallets.formatters.CurrencyFormatter;
import com.coinbase.wallet.wallets.interfaces.IExchangeRateRepository;
import javax.inject.Provider;

/* loaded from: classes.dex */
public final class AdjustableMinerFeeRepository_Factory implements f.c.d<AdjustableMinerFeeRepository> {
    private final Provider<CipherCoreInterface> cipherCoreProvider;
    private final Provider<CurrencyFormatter> currencyFormatterProvider;
    private final Provider<EthereumSignedTxDao> ethereumSignedTxDaoProvider;
    private final Provider<IExchangeRateRepository> exchangeRateRepositoryProvider;
    private final Provider<MinerFeeAPI> minerFeesAPIProvider;
    private final Provider<StoreInterface> storeProvider;

    public AdjustableMinerFeeRepository_Factory(Provider<IExchangeRateRepository> provider, Provider<CurrencyFormatter> provider2, Provider<CipherCoreInterface> provider3, Provider<MinerFeeAPI> provider4, Provider<EthereumSignedTxDao> provider5, Provider<StoreInterface> provider6) {
        this.exchangeRateRepositoryProvider = provider;
        this.currencyFormatterProvider = provider2;
        this.cipherCoreProvider = provider3;
        this.minerFeesAPIProvider = provider4;
        this.ethereumSignedTxDaoProvider = provider5;
        this.storeProvider = provider6;
    }

    public static AdjustableMinerFeeRepository_Factory create(Provider<IExchangeRateRepository> provider, Provider<CurrencyFormatter> provider2, Provider<CipherCoreInterface> provider3, Provider<MinerFeeAPI> provider4, Provider<EthereumSignedTxDao> provider5, Provider<StoreInterface> provider6) {
        return new AdjustableMinerFeeRepository_Factory(provider, provider2, provider3, provider4, provider5, provider6);
    }

    public static AdjustableMinerFeeRepository newInstance(IExchangeRateRepository iExchangeRateRepository, CurrencyFormatter currencyFormatter, CipherCoreInterface cipherCoreInterface, MinerFeeAPI minerFeeAPI, EthereumSignedTxDao ethereumSignedTxDao, StoreInterface storeInterface) {
        return new AdjustableMinerFeeRepository(iExchangeRateRepository, currencyFormatter, cipherCoreInterface, minerFeeAPI, ethereumSignedTxDao, storeInterface);
    }

    @Override // javax.inject.Provider
    public AdjustableMinerFeeRepository get() {
        return newInstance(this.exchangeRateRepositoryProvider.get(), this.currencyFormatterProvider.get(), this.cipherCoreProvider.get(), this.minerFeesAPIProvider.get(), this.ethereumSignedTxDaoProvider.get(), this.storeProvider.get());
    }
}