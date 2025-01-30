package com.coinbase.wallet.txhistory.views;

import com.coinbase.wallet.txhistory.daos.TxHistoryDAO;
import com.coinbase.wallet.wallets.formatters.CurrencyFormatter;
import f.c.d;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class TxHistoryDetailViewModel_Factory implements d<TxHistoryDetailViewModel> {
    private final Provider<CurrencyFormatter> currencyFormatterProvider;
    private final Provider<TxHistoryDAO> txHistoryDAOProvider;

    public TxHistoryDetailViewModel_Factory(Provider<CurrencyFormatter> provider, Provider<TxHistoryDAO> provider2) {
        this.currencyFormatterProvider = provider;
        this.txHistoryDAOProvider = provider2;
    }

    public static TxHistoryDetailViewModel_Factory create(Provider<CurrencyFormatter> provider, Provider<TxHistoryDAO> provider2) {
        return new TxHistoryDetailViewModel_Factory(provider, provider2);
    }

    public static TxHistoryDetailViewModel newInstance(CurrencyFormatter currencyFormatter, TxHistoryDAO txHistoryDAO) {
        return new TxHistoryDetailViewModel(currencyFormatter, txHistoryDAO);
    }

    @Override // javax.inject.Provider
    public TxHistoryDetailViewModel get() {
        return newInstance(this.currencyFormatterProvider.get(), this.txHistoryDAOProvider.get());
    }
}