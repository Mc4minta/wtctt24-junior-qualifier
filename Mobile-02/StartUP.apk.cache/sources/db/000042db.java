package com.toshi.view.fragment.coin;

import com.coinbase.wallet.consumer.repositories.ConsumerUserRepository;
import com.coinbase.wallet.featureflags.repositories.FeatureFlagsRepository;
import com.coinbase.wallet.features.swap.prompts.UnsupportedSwapAssetPrompt;
import com.coinbase.wallet.swap.interfaces.ISwapRepository;
import com.coinbase.wallet.txhistory.repositories.TxHistoryRepository;
import com.coinbase.wallet.wallets.formatters.CurrencyFormatter;
import com.coinbase.wallet.wallets.interfaces.IExchangeRateRepository;
import com.coinbase.wallet.wallets.interfaces.IFiatCurrencyRepository;
import com.coinbase.wallet.wallets.interfaces.IWalletRepository;
import javax.inject.Provider;

/* compiled from: WalletDetailViewModel_Factory.java */
/* loaded from: classes2.dex */
public final class o implements f.c.d<m> {
    private final Provider<TxHistoryRepository> a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<CurrencyFormatter> f11326b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<IWalletRepository> f11327c;

    /* renamed from: d  reason: collision with root package name */
    private final Provider<FeatureFlagsRepository> f11328d;

    /* renamed from: e  reason: collision with root package name */
    private final Provider<ISwapRepository> f11329e;

    /* renamed from: f  reason: collision with root package name */
    private final Provider<UnsupportedSwapAssetPrompt> f11330f;

    /* renamed from: g  reason: collision with root package name */
    private final Provider<ConsumerUserRepository> f11331g;

    /* renamed from: h  reason: collision with root package name */
    private final Provider<IFiatCurrencyRepository> f11332h;

    /* renamed from: i  reason: collision with root package name */
    private final Provider<IExchangeRateRepository> f11333i;

    public o(Provider<TxHistoryRepository> provider, Provider<CurrencyFormatter> provider2, Provider<IWalletRepository> provider3, Provider<FeatureFlagsRepository> provider4, Provider<ISwapRepository> provider5, Provider<UnsupportedSwapAssetPrompt> provider6, Provider<ConsumerUserRepository> provider7, Provider<IFiatCurrencyRepository> provider8, Provider<IExchangeRateRepository> provider9) {
        this.a = provider;
        this.f11326b = provider2;
        this.f11327c = provider3;
        this.f11328d = provider4;
        this.f11329e = provider5;
        this.f11330f = provider6;
        this.f11331g = provider7;
        this.f11332h = provider8;
        this.f11333i = provider9;
    }

    public static o a(Provider<TxHistoryRepository> provider, Provider<CurrencyFormatter> provider2, Provider<IWalletRepository> provider3, Provider<FeatureFlagsRepository> provider4, Provider<ISwapRepository> provider5, Provider<UnsupportedSwapAssetPrompt> provider6, Provider<ConsumerUserRepository> provider7, Provider<IFiatCurrencyRepository> provider8, Provider<IExchangeRateRepository> provider9) {
        return new o(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9);
    }

    public static m c(TxHistoryRepository txHistoryRepository, CurrencyFormatter currencyFormatter, IWalletRepository iWalletRepository, FeatureFlagsRepository featureFlagsRepository, ISwapRepository iSwapRepository, UnsupportedSwapAssetPrompt unsupportedSwapAssetPrompt, ConsumerUserRepository consumerUserRepository, IFiatCurrencyRepository iFiatCurrencyRepository, IExchangeRateRepository iExchangeRateRepository) {
        return new m(txHistoryRepository, currencyFormatter, iWalletRepository, featureFlagsRepository, iSwapRepository, unsupportedSwapAssetPrompt, consumerUserRepository, iFiatCurrencyRepository, iExchangeRateRepository);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public m get() {
        return c(this.a.get(), this.f11326b.get(), this.f11327c.get(), this.f11328d.get(), this.f11329e.get(), this.f11330f.get(), this.f11331g.get(), this.f11332h.get(), this.f11333i.get());
    }
}