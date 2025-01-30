package com.coinbase.wallet.consumer.viewmodels;

import com.coinbase.ApiConstants;
import com.coinbase.ciphercore.ethereum.EthereumChain;
import com.coinbase.wallet.analytics.Analytics;
import com.coinbase.wallet.analytics.models.AnalyticsEvent;
import com.coinbase.wallet.blockchains.models.CurrencyCode;
import com.coinbase.wallet.common.extensions.List_WalletsKt;
import com.coinbase.wallet.common.models.UserProperties;
import com.coinbase.wallet.common.utilities.LocalizedStrings;
import com.coinbase.wallet.commonui.models.ForwardArgs;
import com.coinbase.wallet.commonui.models.ViewModelNavRoute;
import com.coinbase.wallet.consumer.R;
import com.coinbase.wallet.consumer.extensions.AnalyticsEvent_ConsumerKt;
import com.coinbase.wallet.consumer.models.ConsumerAccount;
import com.coinbase.wallet.consumer.models.ConsumerAccountViewEvent;
import com.coinbase.wallet.consumer.models.ConsumerAccountViewState;
import com.coinbase.wallet.consumer.models.ConsumerAccountsArgs;
import com.coinbase.wallet.consumer.models.ConsumerAmountPickerArgs;
import com.coinbase.wallet.consumer.models.ConsumerCardCDVArgs;
import com.coinbase.wallet.consumer.models.ConsumerCardCDVResult;
import com.coinbase.wallet.consumer.models.ConsumerCoinCellViewState;
import com.coinbase.wallet.consumer.models.ConsumerPaymentMethod;
import com.coinbase.wallet.consumer.models.ConsumerPaymentMethodType;
import com.coinbase.wallet.consumer.models.ConsumerSplashScreenState;
import com.coinbase.wallet.consumer.models.SectionHeader;
import com.coinbase.wallet.consumer.repositories.ConsumerAccountsRepository;
import com.coinbase.wallet.consumer.repositories.ConsumerTransferRepository;
import com.coinbase.wallet.consumer.repositories.ConsumerUserRepository;
import com.coinbase.wallet.core.extensions.Observable_CoreKt;
import com.coinbase.wallet.core.extensions.Single_CoreKt;
import com.coinbase.wallet.core.interfaces.Refreshable;
import com.coinbase.wallet.wallets.formatters.CurrencyFormatter;
import com.coinbase.wallet.wallets.interfaces.IExchangeRateRepository;
import com.coinbase.wallet.wallets.interfaces.IWalletRepository;
import com.coinbase.wallet.wallets.models.CryptoCurrency;
import com.coinbase.wallet.wallets.models.ExchangeRate;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Metadata;

/* compiled from: ConsumerAccountsViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Ä\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001pBC\b\u0007\u0012\u0006\u0010]\u001a\u00020\\\u0012\u0006\u0010b\u001a\u00020a\u0012\u0006\u0010N\u001a\u00020M\u0012\u0006\u0010h\u001a\u00020g\u0012\b\b\u0001\u0010W\u001a\u00020\"\u0012\u0006\u0010k\u001a\u00020j\u0012\u0006\u0010m\u001a\u00020l¢\u0006\u0004\bn\u0010oJ\u0019\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\b\u0010\u0006J'\u0010\u000f\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J?\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00120\u00112\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u00112\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u00112\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\u0011H\u0002¢\u0006\u0004\b\u0018\u0010\u0019JG\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001b0\u00112\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u00112\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\u00112\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00140\u00112\u0006\u0010\u0007\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ1\u0010 \u001a\b\u0012\u0004\u0012\u00020\u001b0\u00112\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u00112\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u001e0\u0011H\u0002¢\u0006\u0004\b \u0010!J\u0017\u0010$\u001a\u00020\u00042\b\u0010#\u001a\u0004\u0018\u00010\"¢\u0006\u0004\b$\u0010%J\u0013\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00040&¢\u0006\u0004\b'\u0010(J\u0015\u0010*\u001a\u00020\u00042\u0006\u0010)\u001a\u00020\u0012¢\u0006\u0004\b*\u0010+J\r\u0010,\u001a\u00020\u0004¢\u0006\u0004\b,\u0010-J\u000f\u0010.\u001a\u00020\u0004H\u0014¢\u0006\u0004\b.\u0010-R$\u00101\u001a\u00020/2\u0006\u00100\u001a\u00020/8\u0002@BX\u0082\u000e¢\u0006\f\n\u0004\b1\u00102\"\u0004\b3\u00104R\u001d\u0010\u0007\u001a\u00020\u00028F@\u0006X\u0086\u0084\u0002¢\u0006\f\n\u0004\b5\u00106\u001a\u0004\b7\u00108R\u001f\u0010;\u001a\b\u0012\u0004\u0012\u00020:098\u0006@\u0006¢\u0006\f\n\u0004\b;\u0010<\u001a\u0004\b=\u0010>R\"\u0010?\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\u00110&8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b?\u0010@R$\u0010C\u001a\u0010\u0012\f\u0012\n B*\u0004\u0018\u00010/0/0A8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bC\u0010DR\u001d\u0010I\u001a\u00020E8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\bF\u00106\u001a\u0004\bG\u0010HR\u001f\u0010K\u001a\b\u0012\u0004\u0012\u00020J098\u0006@\u0006¢\u0006\f\n\u0004\bK\u0010<\u001a\u0004\bL\u0010>R\u0016\u0010N\u001a\u00020M8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bN\u0010OR\u0016\u0010P\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bP\u0010QR$\u0010R\u001a\u0010\u0012\f\u0012\n B*\u0004\u0018\u00010J0J0A8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bR\u0010DR\u0016\u0010S\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bS\u0010QR\u001f\u0010T\u001a\b\u0012\u0004\u0012\u00020/098\u0006@\u0006¢\u0006\f\n\u0004\bT\u0010<\u001a\u0004\bU\u0010>R$\u0010V\u001a\u0010\u0012\f\u0012\n B*\u0004\u0018\u00010:0:0A8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bV\u0010DR\u0016\u0010W\u001a\u00020\"8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bW\u0010XR\u001e\u0010Z\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020Y8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bZ\u0010[R\u0016\u0010]\u001a\u00020\\8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b]\u0010^R$\u0010_\u001a\u0010\u0012\f\u0012\n B*\u0004\u0018\u00010\u00040\u00040A8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b_\u0010DR\"\u0010`\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160\u0011098\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b`\u0010<R\u0016\u0010b\u001a\u00020a8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bb\u0010cR\u001e\u0010d\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00120Y8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bd\u0010[R\u001f\u0010e\u001a\b\u0012\u0004\u0012\u00020\u0004098\u0006@\u0006¢\u0006\f\n\u0004\be\u0010<\u001a\u0004\bf\u0010>R\u0016\u0010h\u001a\u00020g8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bh\u0010i¨\u0006q"}, d2 = {"Lcom/coinbase/wallet/consumer/viewmodels/ConsumerAccountsViewModel;", "Landroidx/lifecycle/b0;", "", "addedPaymentMethod", "Lkotlin/x;", "loadAccounts", "(Z)V", "onrampEnabled", "setupState", "Ljava/math/BigInteger;", "balance", "", "decimals", "Ljava/math/BigDecimal;", "exchangeRate", "calculateBalance", "(Ljava/math/BigInteger;ILjava/math/BigDecimal;)Ljava/math/BigDecimal;", "", "Lcom/coinbase/wallet/consumer/models/ConsumerAccount;", ApiConstants.ACCOUNTS, "Lcom/coinbase/wallet/wallets/models/CryptoCurrency;", "cryptoCurrencies", "Lcom/coinbase/wallet/wallets/models/ExchangeRate;", "exchangeRates", "sortAccounts", "(Ljava/util/List;Ljava/util/List;Ljava/util/List;)Ljava/util/List;", "supportedCurrencies", "Lcom/coinbase/wallet/consumer/models/ConsumerCoinCellViewState;", "buildSupportedCoins", "(Ljava/util/List;Ljava/util/List;Ljava/util/List;Z)Ljava/util/List;", "Lcom/coinbase/wallet/blockchains/models/CurrencyCode;", "supportedCurrencyCodes", "buildUnsupportedCoins", "(Ljava/util/List;Ljava/util/List;)Ljava/util/List;", "Landroidx/lifecycle/z;", "fragmentSavedStateHandle", "setup", "(Landroidx/lifecycle/z;)V", "Lh/c/b0;", "revokeToken", "()Lh/c/b0;", "account", "accountClicked", "(Lcom/coinbase/wallet/consumer/models/ConsumerAccount;)V", "onStartTransferClicked", "()V", "onCleared", "Lcom/coinbase/wallet/consumer/models/ConsumerAccountViewState;", "value", ApiConstants.STATE, "Lcom/coinbase/wallet/consumer/models/ConsumerAccountViewState;", "setState", "(Lcom/coinbase/wallet/consumer/models/ConsumerAccountViewState;)V", "onrampEnabled$delegate", "Lkotlin/h;", "getOnrampEnabled", "()Z", "Lh/c/s;", "Lcom/coinbase/wallet/consumer/models/ConsumerAccountViewEvent;", "eventsObservable", "Lh/c/s;", "getEventsObservable", "()Lh/c/s;", "supportedCurrenciesSingle", "Lh/c/b0;", "Lh/c/v0/b;", "kotlin.jvm.PlatformType", "stateSubject", "Lh/c/v0/b;", "Lh/c/k0/a;", "disposeBag$delegate", "getDisposeBag", "()Lh/c/k0/a;", "disposeBag", "Lcom/coinbase/wallet/commonui/models/ViewModelNavRoute;", "navigationObservable", "getNavigationObservable", "Lcom/coinbase/wallet/wallets/formatters/CurrencyFormatter;", "currencyFormatter", "Lcom/coinbase/wallet/wallets/formatters/CurrencyFormatter;", "hadNewSignin", "Z", "navigationSubject", "hasShownSplashScreen", "stateObservable", "getStateObservable", "eventsSubject", "savedStateHandle", "Landroidx/lifecycle/z;", "Ljava/util/concurrent/atomic/AtomicReference;", "shouldShowPaymentMethodFlow", "Ljava/util/concurrent/atomic/AtomicReference;", "Lcom/coinbase/wallet/consumer/repositories/ConsumerAccountsRepository;", "consumerAccountsRepository", "Lcom/coinbase/wallet/consumer/repositories/ConsumerAccountsRepository;", "dismissSubject", "exchangeRateObservable", "Lcom/coinbase/wallet/consumer/repositories/ConsumerUserRepository;", "consumerUserRepository", "Lcom/coinbase/wallet/consumer/repositories/ConsumerUserRepository;", "forwardingAccount", "dismissObservable", "getDismissObservable", "Lcom/coinbase/wallet/consumer/repositories/ConsumerTransferRepository;", "consumerTransferRepository", "Lcom/coinbase/wallet/consumer/repositories/ConsumerTransferRepository;", "Lcom/coinbase/wallet/wallets/interfaces/IExchangeRateRepository;", "exchangeRateRepository", "Lcom/coinbase/wallet/wallets/interfaces/IWalletRepository;", "walletRepository", "<init>", "(Lcom/coinbase/wallet/consumer/repositories/ConsumerAccountsRepository;Lcom/coinbase/wallet/consumer/repositories/ConsumerUserRepository;Lcom/coinbase/wallet/wallets/formatters/CurrencyFormatter;Lcom/coinbase/wallet/consumer/repositories/ConsumerTransferRepository;Landroidx/lifecycle/z;Lcom/coinbase/wallet/wallets/interfaces/IExchangeRateRepository;Lcom/coinbase/wallet/wallets/interfaces/IWalletRepository;)V", "Factory", "consumer_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class ConsumerAccountsViewModel extends androidx.lifecycle.b0 {
    private final ConsumerAccountsRepository consumerAccountsRepository;
    private final ConsumerTransferRepository consumerTransferRepository;
    private final ConsumerUserRepository consumerUserRepository;
    private final CurrencyFormatter currencyFormatter;
    private final h.c.s<kotlin.x> dismissObservable;
    private final h.c.v0.b<kotlin.x> dismissSubject;
    private final kotlin.h disposeBag$delegate;
    private final h.c.s<ConsumerAccountViewEvent> eventsObservable;
    private final h.c.v0.b<ConsumerAccountViewEvent> eventsSubject;
    private final h.c.s<List<ExchangeRate>> exchangeRateObservable;
    private AtomicReference<ConsumerAccount> forwardingAccount;
    private boolean hadNewSignin;
    private boolean hasShownSplashScreen;
    private final h.c.s<ViewModelNavRoute> navigationObservable;
    private final h.c.v0.b<ViewModelNavRoute> navigationSubject;
    private final kotlin.h onrampEnabled$delegate;
    private final androidx.lifecycle.z savedStateHandle;
    private final AtomicReference<Boolean> shouldShowPaymentMethodFlow;
    private ConsumerAccountViewState state;
    private final h.c.s<ConsumerAccountViewState> stateObservable;
    private final h.c.v0.b<ConsumerAccountViewState> stateSubject;
    private final h.c.b0<List<CryptoCurrency>> supportedCurrenciesSingle;

    /* compiled from: ConsumerAccountsViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/coinbase/wallet/consumer/viewmodels/ConsumerAccountsViewModel$Factory;", "", "Landroidx/lifecycle/z;", "savedStateHandle", "Lcom/coinbase/wallet/consumer/viewmodels/ConsumerAccountsViewModel;", "create", "(Landroidx/lifecycle/z;)Lcom/coinbase/wallet/consumer/viewmodels/ConsumerAccountsViewModel;", "consumer_productionRelease"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public interface Factory {
        ConsumerAccountsViewModel create(androidx.lifecycle.z zVar);
    }

    public ConsumerAccountsViewModel(ConsumerAccountsRepository consumerAccountsRepository, ConsumerUserRepository consumerUserRepository, CurrencyFormatter currencyFormatter, ConsumerTransferRepository consumerTransferRepository, androidx.lifecycle.z savedStateHandle, IExchangeRateRepository exchangeRateRepository, IWalletRepository walletRepository) {
        kotlin.h b2;
        kotlin.h b3;
        kotlin.jvm.internal.m.g(consumerAccountsRepository, "consumerAccountsRepository");
        kotlin.jvm.internal.m.g(consumerUserRepository, "consumerUserRepository");
        kotlin.jvm.internal.m.g(currencyFormatter, "currencyFormatter");
        kotlin.jvm.internal.m.g(consumerTransferRepository, "consumerTransferRepository");
        kotlin.jvm.internal.m.g(savedStateHandle, "savedStateHandle");
        kotlin.jvm.internal.m.g(exchangeRateRepository, "exchangeRateRepository");
        kotlin.jvm.internal.m.g(walletRepository, "walletRepository");
        this.consumerAccountsRepository = consumerAccountsRepository;
        this.consumerUserRepository = consumerUserRepository;
        this.currencyFormatter = currencyFormatter;
        this.consumerTransferRepository = consumerTransferRepository;
        this.savedStateHandle = savedStateHandle;
        b2 = kotlin.k.b(ConsumerAccountsViewModel$disposeBag$2.INSTANCE);
        this.disposeBag$delegate = b2;
        this.supportedCurrenciesSingle = IWalletRepository.DefaultImpls.getCryptoCurrencies$default(walletRepository, null, 1, null);
        this.exchangeRateObservable = exchangeRateRepository.getExchangeRateObservable();
        h.c.v0.b<ViewModelNavRoute> d2 = h.c.v0.b.d();
        kotlin.jvm.internal.m.f(d2, "create<ViewModelNavRoute>()");
        this.navigationSubject = d2;
        h.c.v0.b<kotlin.x> d3 = h.c.v0.b.d();
        kotlin.jvm.internal.m.f(d3, "create<Unit>()");
        this.dismissSubject = d3;
        h.c.v0.b<ConsumerAccountViewEvent> d4 = h.c.v0.b.d();
        kotlin.jvm.internal.m.f(d4, "create<ConsumerAccountViewEvent>()");
        this.eventsSubject = d4;
        h.c.v0.b<ConsumerAccountViewState> d5 = h.c.v0.b.d();
        kotlin.jvm.internal.m.f(d5, "create<ConsumerAccountViewState>()");
        this.stateSubject = d5;
        this.shouldShowPaymentMethodFlow = new AtomicReference<>(null);
        this.forwardingAccount = new AtomicReference<>(null);
        this.state = new ConsumerAccountViewState(false, false, null, null, 15, null);
        h.c.s<ViewModelNavRoute> hide = d2.hide();
        kotlin.jvm.internal.m.f(hide, "navigationSubject.hide()");
        this.navigationObservable = hide;
        h.c.s<kotlin.x> hide2 = d3.hide();
        kotlin.jvm.internal.m.f(hide2, "dismissSubject.hide()");
        this.dismissObservable = hide2;
        h.c.s<ConsumerAccountViewEvent> hide3 = d4.hide();
        kotlin.jvm.internal.m.f(hide3, "eventsSubject.hide()");
        this.eventsObservable = hide3;
        b3 = kotlin.k.b(new ConsumerAccountsViewModel$onrampEnabled$2(this));
        this.onrampEnabled$delegate = b3;
        h.c.s<ConsumerAccountViewState> doOnDispose = d5.hide().doOnDispose(new h.c.m0.a() { // from class: com.coinbase.wallet.consumer.viewmodels.f
            @Override // h.c.m0.a
            public final void run() {
                ConsumerAccountsViewModel.f(ConsumerAccountsViewModel.this);
            }
        });
        kotlin.jvm.internal.m.f(doOnDispose, "stateSubject.hide()\n        .doOnDispose { disposeBag.clear() }");
        this.stateObservable = doOnDispose;
    }

    public static /* synthetic */ h.c.h0 a(ConsumerAccountsViewModel consumerAccountsViewModel, boolean z, kotlin.o oVar) {
        return m957loadAccounts$lambda7(consumerAccountsViewModel, z, oVar);
    }

    public static final /* synthetic */ BigDecimal access$calculateBalance(ConsumerAccountsViewModel consumerAccountsViewModel, BigInteger bigInteger, int i2, BigDecimal bigDecimal) {
        return consumerAccountsViewModel.calculateBalance(bigInteger, i2, bigDecimal);
    }

    public static /* synthetic */ Object b(ConsumerAccountsViewModel consumerAccountsViewModel, boolean z, List list) {
        return m952loadAccounts$lambda13(consumerAccountsViewModel, z, list);
    }

    private final List<ConsumerCoinCellViewState> buildSupportedCoins(List<ConsumerAccount> list, List<ExchangeRate> list2, List<CryptoCurrency> list3, boolean z) {
        List<ConsumerAccount> sortAccounts = sortAccounts(list, list3, list2);
        ArrayList arrayList = new ArrayList();
        for (ConsumerAccount consumerAccount : sortAccounts) {
            boolean z2 = !kotlin.jvm.internal.m.c(consumerAccount.getType(), "vault");
            String str = null;
            ConsumerCoinCellViewState consumerCoinCellViewState = null;
            str = null;
            if (z || !z2 || consumerAccount.getBalance().compareTo(BigInteger.ZERO) > 0) {
                String formatToFiat = this.currencyFormatter.formatToFiat(consumerAccount.getCurrencyCode(), null, consumerAccount.getDecimals(), consumerAccount.getBalance(), false, consumerAccount.getCurrencyName(), Integer.valueOf(EthereumChain.ETHEREUM_MAINNET.getChainId()));
                if (z && kotlin.jvm.internal.m.c(consumerAccount.getBalance(), BigInteger.ZERO)) {
                    str = LocalizedStrings.INSTANCE.get(R.string.buy);
                }
                consumerCoinCellViewState = new ConsumerCoinCellViewState(this.currencyFormatter, consumerAccount, consumerAccount.getName(), formatToFiat, z2, z2, false, str, 64, null);
            }
            if (consumerCoinCellViewState != null) {
                arrayList.add(consumerCoinCellViewState);
            }
        }
        return arrayList;
    }

    private final List<ConsumerCoinCellViewState> buildUnsupportedCoins(List<ConsumerAccount> list, List<CurrencyCode> list2) {
        List<ConsumerAccount> B0;
        int r;
        String formatToFiat;
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (!list2.contains(((ConsumerAccount) obj).getCurrencyCode())) {
                arrayList.add(obj);
            }
        }
        B0 = kotlin.a0.z.B0(arrayList, new Comparator<T>() { // from class: com.coinbase.wallet.consumer.viewmodels.ConsumerAccountsViewModel$buildUnsupportedCoins$$inlined$sortedBy$1
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                int c2;
                c2 = kotlin.b0.b.c(((ConsumerAccount) t).getCurrencyName(), ((ConsumerAccount) t2).getCurrencyName());
                return c2;
            }
        });
        r = kotlin.a0.s.r(B0, 10);
        ArrayList arrayList2 = new ArrayList(r);
        for (ConsumerAccount consumerAccount : B0) {
            formatToFiat = this.currencyFormatter.formatToFiat(consumerAccount.getCurrencyCode(), null, consumerAccount.getDecimals(), consumerAccount.getBalance(), (r17 & 16) != 0 ? false : false, (r17 & 32) != 0 ? null : consumerAccount.getCurrencyName(), (r17 & 64) != 0 ? null : null);
            arrayList2.add(new ConsumerCoinCellViewState(this.currencyFormatter, consumerAccount, consumerAccount.getCurrencyName(), formatToFiat, false, false, false, null, 128, null));
        }
        return arrayList2;
    }

    public static /* synthetic */ boolean c(List list) {
        return m955loadAccounts$lambda3(list);
    }

    public final BigDecimal calculateBalance(BigInteger bigInteger, int i2, BigDecimal bigDecimal) {
        BigDecimal multiply = new BigDecimal(bigInteger).movePointLeft(i2).multiply(bigDecimal);
        kotlin.jvm.internal.m.f(multiply, "valueBigDecimal.multiply(exchangeRate)");
        return multiply;
    }

    public static /* synthetic */ List d(ConsumerAccountsViewModel consumerAccountsViewModel, kotlin.t tVar) {
        return m951loadAccounts$lambda12(consumerAccountsViewModel, tVar);
    }

    public static /* synthetic */ void f(ConsumerAccountsViewModel consumerAccountsViewModel) {
        m958stateObservable$lambda0(consumerAccountsViewModel);
    }

    public static /* synthetic */ List g(List list) {
        return m954loadAccounts$lambda2(list);
    }

    private final h.c.k0.a getDisposeBag() {
        return (h.c.k0.a) this.disposeBag$delegate.getValue();
    }

    public static /* synthetic */ List h(List list) {
        return m956loadAccounts$lambda5(list);
    }

    private final void loadAccounts(final boolean z) {
        h.c.b0<kotlin.x> just;
        List<? extends Refreshable> b2;
        getDisposeBag().d();
        if (this.state.getAccounts().isEmpty()) {
            setState(this.state.switchToLoading());
        }
        final boolean c2 = kotlin.jvm.internal.m.c(this.savedStateHandle.e(ConsumerAccountsArgs.newSignInKey), Boolean.TRUE);
        if (c2) {
            this.hadNewSignin = true;
        }
        h.c.x usablePaymentMethodsObservable = this.consumerTransferRepository.getPaymentMethodsObservable().map(new h.c.m0.n() { // from class: com.coinbase.wallet.consumer.viewmodels.g
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return ConsumerAccountsViewModel.g((List) obj);
            }
        });
        h.c.x consumerAccountsObservable = this.consumerAccountsRepository.getAccountsObservable().filter(new h.c.m0.p() { // from class: com.coinbase.wallet.consumer.viewmodels.c
            @Override // h.c.m0.p
            public final boolean test(Object obj) {
                return ConsumerAccountsViewModel.c((List) obj);
            }
        }).map(new h.c.m0.n() { // from class: com.coinbase.wallet.consumer.viewmodels.h
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return ConsumerAccountsViewModel.h((List) obj);
            }
        });
        h.c.t0.c cVar = h.c.t0.c.a;
        kotlin.jvm.internal.m.f(consumerAccountsObservable, "consumerAccountsObservable");
        kotlin.jvm.internal.m.f(usablePaymentMethodsObservable, "usablePaymentMethodsObservable");
        final h.c.s map = cVar.a(consumerAccountsObservable, usablePaymentMethodsObservable).flatMapSingle(new h.c.m0.n() { // from class: com.coinbase.wallet.consumer.viewmodels.a
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return ConsumerAccountsViewModel.a(ConsumerAccountsViewModel.this, z, (kotlin.o) obj);
            }
        }).map(new h.c.m0.n() { // from class: com.coinbase.wallet.consumer.viewmodels.d
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return ConsumerAccountsViewModel.d(ConsumerAccountsViewModel.this, (kotlin.t) obj);
            }
        }).observeOn(h.c.j0.c.a.b()).map(new h.c.m0.n() { // from class: com.coinbase.wallet.consumer.viewmodels.b
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return ConsumerAccountsViewModel.b(ConsumerAccountsViewModel.this, c2, (List) obj);
            }
        });
        if (c2) {
            ConsumerTransferRepository consumerTransferRepository = this.consumerTransferRepository;
            b2 = kotlin.a0.q.b(this.consumerUserRepository);
            just = consumerTransferRepository.refreshBlocking(b2);
        } else {
            just = h.c.b0.just(kotlin.x.a);
            kotlin.jvm.internal.m.f(just, "{\n            Single.just(Unit)\n        }");
        }
        h.c.s<R> flatMapObservable = just.flatMapObservable(new h.c.m0.n() { // from class: com.coinbase.wallet.consumer.viewmodels.e
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                h.c.x m953loadAccounts$lambda14;
                m953loadAccounts$lambda14 = ConsumerAccountsViewModel.m953loadAccounts$lambda14(ConsumerAccountsViewModel.this, map, (kotlin.x) obj);
                return m953loadAccounts$lambda14;
            }
        });
        kotlin.jvm.internal.m.f(flatMapObservable, "userRefresh\n            .flatMapObservable {\n                consumerTransferRepository\n                    .refreshBlocking(listOf(consumerAccountsRepository, consumerTransferRepository))\n                    .subscribeBy {}\n                    .addTo(disposeBag)\n\n                setupObservable\n            }");
        h.c.t0.a.a(h.c.t0.g.h(Observable_CoreKt.asUnit(flatMapObservable), null, null, ConsumerAccountsViewModel$loadAccounts$2.INSTANCE, 3, null), getDisposeBag());
    }

    static /* synthetic */ void loadAccounts$default(ConsumerAccountsViewModel consumerAccountsViewModel, boolean z, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            z = false;
        }
        consumerAccountsViewModel.loadAccounts(z);
    }

    /* renamed from: loadAccounts$lambda-12 */
    public static final List m951loadAccounts$lambda12(ConsumerAccountsViewModel this$0, kotlin.t dstr$cryptoAccounts$supportedCurrencies$exchangeRates) {
        int r;
        ConsumerAccount consumerAccount;
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(dstr$cryptoAccounts$supportedCurrencies$exchangeRates, "$dstr$cryptoAccounts$supportedCurrencies$exchangeRates");
        List<ConsumerAccount> cryptoAccounts = (List) dstr$cryptoAccounts$supportedCurrencies$exchangeRates.a();
        List<CryptoCurrency> supportedCurrencies = (List) dstr$cryptoAccounts$supportedCurrencies$exchangeRates.b();
        List<ExchangeRate> exchangeRates = (List) dstr$cryptoAccounts$supportedCurrencies$exchangeRates.c();
        kotlin.jvm.internal.m.f(supportedCurrencies, "supportedCurrencies");
        r = kotlin.a0.s.r(supportedCurrencies, 10);
        List<CurrencyCode> arrayList = new ArrayList<>(r);
        for (CryptoCurrency cryptoCurrency : supportedCurrencies) {
            arrayList.add(cryptoCurrency.getCode());
        }
        kotlin.jvm.internal.m.f(cryptoAccounts, "cryptoAccounts");
        List<ConsumerAccount> arrayList2 = new ArrayList<>();
        for (Object obj : cryptoAccounts) {
            if (arrayList.contains(((ConsumerAccount) obj).getCurrencyCode())) {
                arrayList2.add(obj);
            }
        }
        kotlin.jvm.internal.m.f(exchangeRates, "exchangeRates");
        List<ConsumerCoinCellViewState> buildSupportedCoins = this$0.buildSupportedCoins(arrayList2, exchangeRates, supportedCurrencies, this$0.getOnrampEnabled());
        CurrencyCode currencyCode = (CurrencyCode) this$0.savedStateHandle.e(ConsumerAccountsArgs.forwardingCurrencyKey);
        AtomicReference<ConsumerAccount> atomicReference = this$0.forwardingAccount;
        ListIterator<ConsumerAccount> listIterator = arrayList2.listIterator(arrayList2.size());
        while (true) {
            if (!listIterator.hasPrevious()) {
                consumerAccount = null;
                break;
            }
            consumerAccount = listIterator.previous();
            if (kotlin.jvm.internal.m.c(consumerAccount.getCurrencyCode(), currencyCode)) {
                break;
            }
        }
        atomicReference.set(consumerAccount);
        List<ConsumerCoinCellViewState> buildUnsupportedCoins = this$0.buildUnsupportedCoins(cryptoAccounts, arrayList);
        ArrayList arrayList3 = new ArrayList();
        arrayList3.addAll(buildSupportedCoins);
        arrayList3.add(new SectionHeader(LocalizedStrings.INSTANCE.get(R.string.not_yet_supported)));
        arrayList3.addAll(buildUnsupportedCoins);
        return arrayList3;
    }

    /* renamed from: loadAccounts$lambda-13 */
    public static final Object m952loadAccounts$lambda13(ConsumerAccountsViewModel this$0, boolean z, List accounts) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(accounts, "accounts");
        ConsumerAccount consumerAccount = this$0.forwardingAccount.get();
        if (this$0.getOnrampEnabled() && kotlin.jvm.internal.m.c(this$0.shouldShowPaymentMethodFlow.get(), Boolean.TRUE) && z) {
            this$0.navigationSubject.onNext(new ViewModelNavRoute(R.id.action_consumerFragment_to_consumerAvailablePaymentMethodsFragment, ForwardArgs.INSTANCE.create(R.id.consumerFragment), null, 4, null));
            this$0.setState(ConsumerAccountViewState.copy$default(this$0.state, false, false, null, accounts, 7, null));
            return Analytics.INSTANCE.log(AnalyticsEvent_ConsumerKt.consumerOnrampNewUserPaymentMethodFlowShown(AnalyticsEvent.Companion));
        } else if (this$0.hadNewSignin && !this$0.hasShownSplashScreen) {
            this$0.hasShownSplashScreen = true;
            this$0.setState(ConsumerAccountViewState.copy$default(this$0.state, true, false, null, accounts, 4, null));
            return kotlin.x.a;
        } else if (consumerAccount != null && (consumerAccount.getBalance().compareTo(BigInteger.ZERO) > 0 || this$0.getOnrampEnabled())) {
            this$0.forwardingAccount.set(null);
            this$0.navigationSubject.onNext(new ViewModelNavRoute(R.id.action_consumerFragment_to_consumerAmountPickerFragment, ConsumerAmountPickerArgs.INSTANCE.createArguments(consumerAccount, this$0.getOnrampEnabled()), null, 4, null));
            return kotlin.x.a;
        } else if (accounts.isEmpty()) {
            this$0.setState(this$0.state.switchToLoading());
            return kotlin.x.a;
        } else {
            this$0.setState(ConsumerAccountViewState.copy$default(this$0.state, false, false, null, accounts, 5, null));
            return kotlin.x.a;
        }
    }

    /* renamed from: loadAccounts$lambda-14 */
    public static final h.c.x m953loadAccounts$lambda14(ConsumerAccountsViewModel this$0, h.c.s sVar, kotlin.x it) {
        List<? extends Refreshable> j2;
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(it, "it");
        ConsumerTransferRepository consumerTransferRepository = this$0.consumerTransferRepository;
        j2 = kotlin.a0.r.j(this$0.consumerAccountsRepository, consumerTransferRepository);
        h.c.t0.a.a(h.c.t0.g.i(consumerTransferRepository.refreshBlocking(j2), null, ConsumerAccountsViewModel$loadAccounts$1$1.INSTANCE, 1, null), this$0.getDisposeBag());
        return sVar;
    }

    /* renamed from: loadAccounts$lambda-2 */
    public static final List m954loadAccounts$lambda2(List paymentMethods) {
        kotlin.jvm.internal.m.g(paymentMethods, "paymentMethods");
        ArrayList arrayList = new ArrayList();
        for (Object obj : paymentMethods) {
            ConsumerPaymentMethod consumerPaymentMethod = (ConsumerPaymentMethod) obj;
            if (!kotlin.jvm.internal.m.c(consumerPaymentMethod.getType(), ConsumerPaymentMethodType.FIAT_ACCOUNT.toString()) || consumerPaymentMethod.getBuyLimit().compareTo(BigDecimal.ZERO) > 0) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    /* renamed from: loadAccounts$lambda-3 */
    public static final boolean m955loadAccounts$lambda3(List it) {
        kotlin.jvm.internal.m.g(it, "it");
        return !it.isEmpty();
    }

    /* renamed from: loadAccounts$lambda-5 */
    public static final List m956loadAccounts$lambda5(List it) {
        kotlin.jvm.internal.m.g(it, "it");
        ArrayList arrayList = new ArrayList();
        for (Object obj : it) {
            ConsumerAccount consumerAccount = (ConsumerAccount) obj;
            boolean z = true;
            if ((kotlin.jvm.internal.m.c(consumerAccount.getType(), "fiat") || (kotlin.jvm.internal.m.c(consumerAccount.getCurrencyCode(), new CurrencyCode("XRP")) && kotlin.jvm.internal.m.c(consumerAccount.getBalance(), BigInteger.ZERO))) ? false : false) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    /* renamed from: loadAccounts$lambda-7 */
    public static final h.c.h0 m957loadAccounts$lambda7(ConsumerAccountsViewModel this$0, boolean z, kotlin.o dstr$cryptoAccounts$usablePaymentMethods) {
        boolean z2;
        Object obj;
        boolean z3;
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(dstr$cryptoAccounts$usablePaymentMethods, "$dstr$cryptoAccounts$usablePaymentMethods");
        List cryptoAccounts = (List) dstr$cryptoAccounts$usablePaymentMethods.a();
        List usablePaymentMethods = (List) dstr$cryptoAccounts$usablePaymentMethods.b();
        kotlin.jvm.internal.m.f(cryptoAccounts, "cryptoAccounts");
        Iterator it = cryptoAccounts.iterator();
        while (true) {
            z2 = false;
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (((ConsumerAccount) obj).getBalance().compareTo(BigInteger.ZERO) > 0) {
                z3 = true;
                continue;
            } else {
                z3 = false;
                continue;
            }
            if (z3) {
                break;
            }
        }
        boolean z4 = obj != null;
        Analytics analytics = Analytics.INSTANCE;
        UserProperties userProperties = UserProperties.INSTANCE;
        analytics.setUserProperties(userProperties.consumerConnectHasUsableAccount(z4));
        if (this$0.getOnrampEnabled()) {
            kotlin.jvm.internal.m.f(usablePaymentMethods, "usablePaymentMethods");
            analytics.setUserProperties(userProperties.consumerConnectHasPaymentMethods(!usablePaymentMethods.isEmpty()));
        }
        AtomicReference<Boolean> atomicReference = this$0.shouldShowPaymentMethodFlow;
        if (this$0.getOnrampEnabled() && usablePaymentMethods.isEmpty() && !z4 && !z) {
            z2 = true;
        }
        atomicReference.set(Boolean.valueOf(z2));
        h.c.t0.e eVar = h.c.t0.e.a;
        h.c.b0 just = h.c.b0.just(cryptoAccounts);
        kotlin.jvm.internal.m.f(just, "just(cryptoAccounts)");
        return eVar.b(just, this$0.supportedCurrenciesSingle, Observable_CoreKt.takeSingle(this$0.exchangeRateObservable));
    }

    private final void setState(ConsumerAccountViewState consumerAccountViewState) {
        this.state = consumerAccountViewState;
        this.stateSubject.onNext(consumerAccountViewState);
    }

    private final void setupState(boolean z) {
        ConsumerSplashScreenState consumerSplashScreenState;
        if (z) {
            LocalizedStrings localizedStrings = LocalizedStrings.INSTANCE;
            consumerSplashScreenState = new ConsumerSplashScreenState(localizedStrings.get(R.string.ready_to_transfer_coins_onramp), localizedStrings.get(R.string.ready_to_transfer_coins_explanation_onramp), localizedStrings.get(R.string.start_transfer_onramp), localizedStrings.get(R.string.transfer_later_onramp), localizedStrings.get(R.string.label__transfer_from_coinbase_onramp));
        } else {
            LocalizedStrings localizedStrings2 = LocalizedStrings.INSTANCE;
            consumerSplashScreenState = new ConsumerSplashScreenState(localizedStrings2.get(R.string.ready_to_transfer_coins), localizedStrings2.get(R.string.ready_to_transfer_coins_explanation), localizedStrings2.get(R.string.start_transfer), localizedStrings2.get(R.string.transfer_later), localizedStrings2.get(R.string.label__transfer_from_coinbase));
        }
        boolean isEmpty = this.state.getAccounts().isEmpty();
        setState(ConsumerAccountViewState.copy$default(this.state, false, isEmpty, consumerSplashScreenState, null, 9, null));
    }

    private final List<ConsumerAccount> sortAccounts(List<ConsumerAccount> list, List<CryptoCurrency> list2, final List<ExchangeRate> list3) {
        int r;
        final Map r2;
        List<ConsumerAccount> B0;
        r = kotlin.a0.s.r(list2, 10);
        ArrayList arrayList = new ArrayList(r);
        for (CryptoCurrency cryptoCurrency : list2) {
            arrayList.add(kotlin.u.a(cryptoCurrency.getCode(), cryptoCurrency));
        }
        r2 = kotlin.a0.m0.r(arrayList);
        B0 = kotlin.a0.z.B0(list, new Comparator<ConsumerAccount>() { // from class: com.coinbase.wallet.consumer.viewmodels.ConsumerAccountsViewModel$sortAccounts$1
            @Override // java.util.Comparator
            public int compare(ConsumerAccount consumerAccount, ConsumerAccount consumerAccount2) {
                CryptoCurrency cryptoCurrency2;
                if (consumerAccount != null || consumerAccount2 == null) {
                    if (consumerAccount != null && consumerAccount2 == null) {
                        return -1;
                    }
                    if (consumerAccount == null || consumerAccount2 == null) {
                        return 0;
                    }
                    if (!kotlin.jvm.internal.m.c(consumerAccount.getType(), "vault") || kotlin.jvm.internal.m.c(consumerAccount2.getType(), "vault")) {
                        if (kotlin.jvm.internal.m.c(consumerAccount.getType(), "vault") || !kotlin.jvm.internal.m.c(consumerAccount2.getType(), "vault")) {
                            CryptoCurrency cryptoCurrency3 = r2.get(consumerAccount.getCurrencyCode());
                            if (cryptoCurrency3 == null || (cryptoCurrency2 = r2.get(consumerAccount2.getCurrencyCode())) == null) {
                                return 0;
                            }
                            ConsumerAccountsViewModel consumerAccountsViewModel = this;
                            BigInteger balance = consumerAccount.getBalance();
                            int decimals = consumerAccount.getDecimals();
                            List<ExchangeRate> list4 = list3;
                            CurrencyCode currencyCode = consumerAccount.getCurrencyCode();
                            String currencyName = consumerAccount.getCurrencyName();
                            EthereumChain ethereumChain = EthereumChain.ETHEREUM_MAINNET;
                            BigDecimal rateFor = List_WalletsKt.rateFor(list4, currencyCode, null, currencyName, Integer.valueOf(ethereumChain.getChainId()));
                            if (rateFor == null) {
                                rateFor = BigDecimal.ONE;
                            }
                            kotlin.jvm.internal.m.f(rateFor, "exchangeRates.rateFor(\n                                currencyCode = lhs.currencyCode,\n                                contractAddress = null,\n                                name = lhs.currencyName,\n                                /* Currently, consumer only supports mainnet assets */\n                                chainId = EthereumChain.ETHEREUM_MAINNET.chainId\n                            ) ?: BigDecimal.ONE");
                            BigDecimal access$calculateBalance = ConsumerAccountsViewModel.access$calculateBalance(consumerAccountsViewModel, balance, decimals, rateFor);
                            ConsumerAccountsViewModel consumerAccountsViewModel2 = this;
                            BigInteger balance2 = consumerAccount2.getBalance();
                            int decimals2 = consumerAccount2.getDecimals();
                            BigDecimal rateFor2 = List_WalletsKt.rateFor(list3, consumerAccount2.getCurrencyCode(), null, consumerAccount2.getCurrencyName(), Integer.valueOf(ethereumChain.getChainId()));
                            if (rateFor2 == null) {
                                rateFor2 = BigDecimal.ONE;
                            }
                            kotlin.jvm.internal.m.f(rateFor2, "exchangeRates.rateFor(\n                                currencyCode = rhs.currencyCode,\n                                contractAddress = null,\n                                name = rhs.currencyName,\n                                /* Currently, consumer only supports mainnet assets */\n                                chainId = EthereumChain.ETHEREUM_MAINNET.chainId\n                            ) ?: BigDecimal.ONE");
                            int compareTo = ConsumerAccountsViewModel.access$calculateBalance(consumerAccountsViewModel2, balance2, decimals2, rateFor2).compareTo(access$calculateBalance);
                            return compareTo == 0 ? kotlin.jvm.internal.m.i(cryptoCurrency3.getSortIndex(), cryptoCurrency2.getSortIndex()) : compareTo;
                        }
                        return -1;
                    }
                }
                return 1;
            }
        });
        return B0;
    }

    /* renamed from: stateObservable$lambda-0 */
    public static final void m958stateObservable$lambda0(ConsumerAccountsViewModel this$0) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        this$0.getDisposeBag().d();
    }

    public final void accountClicked(ConsumerAccount account) {
        kotlin.jvm.internal.m.g(account, "account");
        Analytics.INSTANCE.log(AnalyticsEvent_ConsumerKt.transferCoinSelected(AnalyticsEvent.Companion, account));
        this.navigationSubject.onNext(new ViewModelNavRoute(R.id.action_consumerFragment_to_consumerAmountPickerFragment, ConsumerAmountPickerArgs.INSTANCE.createArguments(account, getOnrampEnabled()), null, 4, null));
    }

    public final h.c.s<kotlin.x> getDismissObservable() {
        return this.dismissObservable;
    }

    public final h.c.s<ConsumerAccountViewEvent> getEventsObservable() {
        return this.eventsObservable;
    }

    public final h.c.s<ViewModelNavRoute> getNavigationObservable() {
        return this.navigationObservable;
    }

    public final boolean getOnrampEnabled() {
        return ((Boolean) this.onrampEnabled$delegate.getValue()).booleanValue();
    }

    public final h.c.s<ConsumerAccountViewState> getStateObservable() {
        return this.stateObservable;
    }

    @Override // androidx.lifecycle.b0
    public void onCleared() {
        super.onCleared();
        getDisposeBag().d();
    }

    public final void onStartTransferClicked() {
        ConsumerAccount consumerAccount = this.forwardingAccount.get();
        if (consumerAccount != null && (consumerAccount.getBalance().compareTo(BigInteger.ZERO) > 0 || getOnrampEnabled())) {
            this.forwardingAccount.set(null);
            this.navigationSubject.onNext(new ViewModelNavRoute(R.id.action_consumerFragment_to_consumerAmountPickerFragment, ConsumerAmountPickerArgs.INSTANCE.createArguments(consumerAccount, getOnrampEnabled()), null, 4, null));
            return;
        }
        setState(ConsumerAccountViewState.copy$default(this.state, false, this.state.getAccounts().isEmpty(), null, null, 12, null));
    }

    public final h.c.b0<kotlin.x> revokeToken() {
        setState(this.state.switchToLoading());
        return Single_CoreKt.asUnit(h.c.t0.f.a(h.c.t0.f.a(this.consumerAccountsRepository.deleteAccounts(), this.consumerTransferRepository.delete()), this.consumerUserRepository.revokeToken()));
    }

    public final void setup(androidx.lifecycle.z zVar) {
        setupState(getOnrampEnabled());
        boolean z = (zVar == null ? null : (ConsumerCardCDVResult) zVar.e(ConsumerCardCDVArgs.RESULT_KEY)) instanceof ConsumerCardCDVResult.Verified;
        if (z) {
            Analytics.INSTANCE.log(AnalyticsEvent_ConsumerKt.consumerOnrampNewUserAddedPaymentMethod(AnalyticsEvent.Companion));
        }
        loadAccounts(z);
    }
}