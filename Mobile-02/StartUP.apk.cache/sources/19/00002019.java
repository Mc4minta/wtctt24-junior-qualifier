package com.coinbase.wallet.features.send.viewmodels;

import com.coinbase.wallet.wallets.formatters.CurrencyFormatter;
import javax.inject.Provider;

/* loaded from: classes.dex */
public final class SendCompleteViewModel_Factory implements f.c.d<SendCompleteViewModel> {
    private final Provider<CurrencyFormatter> currencyFormatterProvider;

    public SendCompleteViewModel_Factory(Provider<CurrencyFormatter> provider) {
        this.currencyFormatterProvider = provider;
    }

    public static SendCompleteViewModel_Factory create(Provider<CurrencyFormatter> provider) {
        return new SendCompleteViewModel_Factory(provider);
    }

    public static SendCompleteViewModel newInstance(CurrencyFormatter currencyFormatter) {
        return new SendCompleteViewModel(currencyFormatter);
    }

    @Override // javax.inject.Provider
    public SendCompleteViewModel get() {
        return newInstance(this.currencyFormatterProvider.get());
    }
}