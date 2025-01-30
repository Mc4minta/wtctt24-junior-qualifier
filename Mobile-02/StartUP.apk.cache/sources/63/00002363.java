package com.coinbase.wallet.features.wallets.viewmodels;

import androidx.lifecycle.b0;
import com.coinbase.ciphercore.ethereum.EthereumChain;
import com.coinbase.wallet.analytics.Analytics;
import com.coinbase.wallet.analytics.models.AnalyticsEvent;
import com.coinbase.wallet.application.extensions.AnalyticsEvent_ApplicationKt;
import com.coinbase.wallet.blockchains.models.Blockchain;
import com.coinbase.wallet.blockchains.models.CurrencyCode;
import com.coinbase.wallet.blockchains.models.Network;
import com.coinbase.wallet.blockchains.models.Wallet;
import com.coinbase.wallet.common.extensions.BigInteger_CommonKt;
import com.coinbase.wallet.common.extensions.WalletRepository_CommonKt;
import com.coinbase.wallet.common.utilities.LocalizedStrings;
import com.coinbase.wallet.commonui.models.ActionStyle;
import com.coinbase.wallet.commonui.models.ViewModelNavRoute;
import com.coinbase.wallet.commonui.utilities.ActionSheetDialogHelper;
import com.coinbase.wallet.consumer.models.ConsumerConnectionStatus;
import com.coinbase.wallet.consumer.repositories.ConsumerUserRepository;
import com.coinbase.wallet.core.extensions.Observable_CoreKt;
import com.coinbase.wallet.core.extensions.Singles_CoreKt;
import com.coinbase.wallet.core.extensions.Strings;
import com.coinbase.wallet.core.extensions.Strings_CoreKt;
import com.coinbase.wallet.core.models.Four;
import com.coinbase.wallet.core.util.Optional;
import com.coinbase.wallet.core.util.OptionalKt;
import com.coinbase.wallet.ethereum.extensions.Blockchain_EthereumKt;
import com.coinbase.wallet.ethereum.extensions.CurrencyCode_EthereumKt;
import com.coinbase.wallet.ethereum.extensions.EthereumChain_EthereumKt;
import com.coinbase.wallet.featureflags.models.FeatureFlag;
import com.coinbase.wallet.featureflags.repositories.FeatureFlagsRepository;
import com.coinbase.wallet.features.lend.interfaces.LendBalanceFetching;
import com.coinbase.wallet.features.lend.interfaces.LendBalanceManaging;
import com.coinbase.wallet.features.wallets.models.ListItem;
import com.coinbase.wallet.lending.interfaces.ILendRepository;
import com.coinbase.wallet.lending.models.LendToken;
import com.coinbase.wallet.txhistory.repositories.TxHistoryRepository;
import com.coinbase.wallet.wallets.formatters.CurrencyFormatter;
import com.coinbase.wallet.wallets.interfaces.IExchangeRateRepository;
import com.coinbase.wallet.wallets.interfaces.IFiatCurrencyRepository;
import com.coinbase.wallet.wallets.interfaces.IWalletRepository;
import com.coinbase.wallet.wallets.models.ExchangeRate;
import com.coinbase.wallet.wallets.models.FiatCurrency;
import h.c.h0;
import h.c.m0.p;
import h.c.s;
import java.math.BigInteger;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.a0.r;
import kotlin.t;
import kotlin.x;
import org.toshi.R;

/* compiled from: ActionItemsViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000¶\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003BI\b\u0007\u0012\u0006\u0010D\u001a\u00020C\u0012\u0006\u00100\u001a\u00020/\u0012\u0006\u0010Q\u001a\u00020P\u0012\u0006\u0010S\u001a\u00020R\u0012\u0006\u0010U\u001a\u00020T\u0012\u0006\u0010&\u001a\u00020%\u0012\u0006\u00105\u001a\u000204\u0012\u0006\u0010\u001f\u001a\u00020\u001e¢\u0006\u0004\bV\u0010WJ#\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0002¢\u0006\u0004\b\t\u0010\nJ#\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0002¢\u0006\u0004\b\u000b\u0010\nJ#\u0010\f\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0002¢\u0006\u0004\b\f\u0010\nJ\u001d\u0010\u000e\u001a\u00020\r2\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\r\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0011\u0010\u0012J\u001b\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u00072\u0006\u0010\u0013\u001a\u00020\r¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\u0010H\u0014¢\u0006\u0004\b\u0017\u0010\u0012R\u001f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00190\u00188\u0006@\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u001c\u0010\u001f\u001a\u00020\u001e8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"R\u0016\u0010#\u001a\u00020\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b#\u0010$R\u0016\u0010&\u001a\u00020%8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b&\u0010'R\u001c\u0010)\u001a\b\u0012\u0004\u0012\u00020(0\u00078\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b)\u0010*R$\u0010-\u001a\u0010\u0012\f\u0012\n ,*\u0004\u0018\u00010\u00100\u00100+8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b-\u0010.R\u001c\u00100\u001a\u00020/8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b0\u00101\u001a\u0004\b2\u00103R\u0016\u00105\u001a\u0002048\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b5\u00106R$\u00107\u001a\u0010\u0012\f\u0012\n ,*\u0004\u0018\u00010\u00190\u00190+8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b7\u0010.R\u0016\u00109\u001a\u0002088\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b9\u0010:R\u001f\u0010;\u001a\b\u0012\u0004\u0012\u00020\u00100\u00188\u0006@\u0006¢\u0006\f\n\u0004\b;\u0010\u001b\u001a\u0004\b<\u0010\u001dR\"\u0010>\u001a\b\u0012\u0004\u0012\u00020=0\u00188\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b>\u0010\u001b\u001a\u0004\b?\u0010\u001dR\u001c\u0010B\u001a\b\u0012\u0004\u0012\u00020\r0\u00078B@\u0002X\u0082\u0004¢\u0006\u0006\u001a\u0004\b@\u0010AR\u001c\u0010D\u001a\u00020C8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\bD\u0010E\u001a\u0004\bF\u0010GR(\u0010I\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020H0\u00040\u00188\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\bI\u0010\u001b\u001a\u0004\bJ\u0010\u001dR%\u0010L\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020K0\u00040\u00188\u0006@\u0006¢\u0006\f\n\u0004\bL\u0010\u001b\u001a\u0004\bM\u0010\u001dR\u001c\u0010O\u001a\b\u0012\u0004\u0012\u00020\r0\u00078B@\u0002X\u0082\u0004¢\u0006\u0006\u001a\u0004\bN\u0010A¨\u0006X"}, d2 = {"Lcom/coinbase/wallet/features/wallets/viewmodels/ActionItemsViewModel;", "Landroidx/lifecycle/b0;", "Lcom/coinbase/wallet/features/lend/interfaces/LendBalanceManaging;", "Lcom/coinbase/wallet/features/lend/interfaces/LendBalanceFetching;", "", "Lcom/coinbase/wallet/lending/models/LendToken;", "tokens", "Lh/c/b0;", "", "getLendItemTitle", "(Ljava/util/List;)Lh/c/b0;", "getLendItemDescription", "getLendItemTotalSupplied", "", "hasLendingBalance", "(Ljava/util/List;)Z", "Lkotlin/x;", "onLendItemClick", "()V", "isWalletsEmpty", "Lcom/coinbase/wallet/commonui/utilities/ActionSheetDialogHelper$Properties;", "getFundActionSheetProperties", "(Z)Lh/c/b0;", "onCleared", "Lh/c/s;", "Lcom/coinbase/wallet/commonui/models/ViewModelNavRoute;", "navigationObservable", "Lh/c/s;", "getNavigationObservable", "()Lh/c/s;", "Lcom/coinbase/wallet/wallets/formatters/CurrencyFormatter;", "currencyFormatter", "Lcom/coinbase/wallet/wallets/formatters/CurrencyFormatter;", "getCurrencyFormatter", "()Lcom/coinbase/wallet/wallets/formatters/CurrencyFormatter;", "isFirstUpdate", "Z", "Lcom/coinbase/wallet/featureflags/repositories/FeatureFlagsRepository;", "featureFlagsRepository", "Lcom/coinbase/wallet/featureflags/repositories/FeatureFlagsRepository;", "Lcom/coinbase/wallet/blockchains/models/Wallet;", "walletSingle", "Lh/c/b0;", "Lh/c/v0/b;", "kotlin.jvm.PlatformType", "testNetDialogSubject", "Lh/c/v0/b;", "Lcom/coinbase/wallet/txhistory/repositories/TxHistoryRepository;", "txHistoryRepository", "Lcom/coinbase/wallet/txhistory/repositories/TxHistoryRepository;", "getTxHistoryRepository", "()Lcom/coinbase/wallet/txhistory/repositories/TxHistoryRepository;", "Lcom/coinbase/wallet/consumer/repositories/ConsumerUserRepository;", "consumerUserRepository", "Lcom/coinbase/wallet/consumer/repositories/ConsumerUserRepository;", "navigationSubject", "Lh/c/k0/a;", "disposeBag", "Lh/c/k0/a;", "testNetDialogObservable", "getTestNetDialogObservable", "Lcom/coinbase/wallet/wallets/models/FiatCurrency;", "activeFiatCurrencyObservable", "getActiveFiatCurrencyObservable", "getGetOnrampFeatureFlag", "()Lh/c/b0;", "getOnrampFeatureFlag", "Lcom/coinbase/wallet/lending/interfaces/ILendRepository;", "lendRepository", "Lcom/coinbase/wallet/lending/interfaces/ILendRepository;", "getLendRepository", "()Lcom/coinbase/wallet/lending/interfaces/ILendRepository;", "Lcom/coinbase/wallet/wallets/models/ExchangeRate;", "exchangeRateObservable", "getExchangeRateObservable", "Lcom/coinbase/wallet/features/wallets/models/ListItem;", "actionItemsObservable", "getActionItemsObservable", "getGetSwapFeatureFlag", "getSwapFeatureFlag", "Lcom/coinbase/wallet/wallets/interfaces/IWalletRepository;", "walletRepository", "Lcom/coinbase/wallet/wallets/interfaces/IExchangeRateRepository;", "exchangeRateRepository", "Lcom/coinbase/wallet/wallets/interfaces/IFiatCurrencyRepository;", "fiatCurrencyRepository", "<init>", "(Lcom/coinbase/wallet/lending/interfaces/ILendRepository;Lcom/coinbase/wallet/txhistory/repositories/TxHistoryRepository;Lcom/coinbase/wallet/wallets/interfaces/IWalletRepository;Lcom/coinbase/wallet/wallets/interfaces/IExchangeRateRepository;Lcom/coinbase/wallet/wallets/interfaces/IFiatCurrencyRepository;Lcom/coinbase/wallet/featureflags/repositories/FeatureFlagsRepository;Lcom/coinbase/wallet/consumer/repositories/ConsumerUserRepository;Lcom/coinbase/wallet/wallets/formatters/CurrencyFormatter;)V", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class ActionItemsViewModel extends b0 implements LendBalanceManaging, LendBalanceFetching {
    private final s<List<ListItem>> actionItemsObservable;
    private final s<FiatCurrency> activeFiatCurrencyObservable;
    private final ConsumerUserRepository consumerUserRepository;
    private final CurrencyFormatter currencyFormatter;
    private final h.c.k0.a disposeBag;
    private final s<List<ExchangeRate>> exchangeRateObservable;
    private final FeatureFlagsRepository featureFlagsRepository;
    private boolean isFirstUpdate;
    private final ILendRepository lendRepository;
    private final s<ViewModelNavRoute> navigationObservable;
    private final h.c.v0.b<ViewModelNavRoute> navigationSubject;
    private final s<x> testNetDialogObservable;
    private final h.c.v0.b<x> testNetDialogSubject;
    private final TxHistoryRepository txHistoryRepository;
    private final h.c.b0<Wallet> walletSingle;

    public ActionItemsViewModel(ILendRepository lendRepository, TxHistoryRepository txHistoryRepository, final IWalletRepository walletRepository, IExchangeRateRepository exchangeRateRepository, IFiatCurrencyRepository fiatCurrencyRepository, FeatureFlagsRepository featureFlagsRepository, ConsumerUserRepository consumerUserRepository, CurrencyFormatter currencyFormatter) {
        kotlin.jvm.internal.m.g(lendRepository, "lendRepository");
        kotlin.jvm.internal.m.g(txHistoryRepository, "txHistoryRepository");
        kotlin.jvm.internal.m.g(walletRepository, "walletRepository");
        kotlin.jvm.internal.m.g(exchangeRateRepository, "exchangeRateRepository");
        kotlin.jvm.internal.m.g(fiatCurrencyRepository, "fiatCurrencyRepository");
        kotlin.jvm.internal.m.g(featureFlagsRepository, "featureFlagsRepository");
        kotlin.jvm.internal.m.g(consumerUserRepository, "consumerUserRepository");
        kotlin.jvm.internal.m.g(currencyFormatter, "currencyFormatter");
        this.lendRepository = lendRepository;
        this.txHistoryRepository = txHistoryRepository;
        this.featureFlagsRepository = featureFlagsRepository;
        this.consumerUserRepository = consumerUserRepository;
        this.currencyFormatter = currencyFormatter;
        this.isFirstUpdate = true;
        this.disposeBag = new h.c.k0.a();
        h.c.v0.b<ViewModelNavRoute> d2 = h.c.v0.b.d();
        kotlin.jvm.internal.m.f(d2, "create<ViewModelNavRoute>()");
        this.navigationSubject = d2;
        h.c.v0.b<x> d3 = h.c.v0.b.d();
        kotlin.jvm.internal.m.f(d3, "create<Unit>()");
        this.testNetDialogSubject = d3;
        s<Optional<Wallet>> observeWallet = WalletRepository_CommonKt.observeWallet(walletRepository, Blockchain_EthereumKt.getETHEREUM(Blockchain.Companion), CurrencyCode_EthereumKt.getETH(CurrencyCode.Companion));
        kotlin.jvm.internal.m.f(observeWallet, "walletRepository.observeWallet(Blockchain.ETHEREUM, CurrencyCode.ETH)");
        s<R> map = observeWallet.filter(new p() { // from class: com.coinbase.wallet.features.wallets.viewmodels.ActionItemsViewModel$special$$inlined$unwrap$1
            public final boolean test(Optional<? extends T> it) {
                kotlin.jvm.internal.m.g(it, "it");
                return it.toNullable() != null;
            }

            @Override // h.c.m0.p
            public /* bridge */ /* synthetic */ boolean test(Object obj) {
                return test((Optional) ((Optional) obj));
            }
        }).map(new h.c.m0.n() { // from class: com.coinbase.wallet.features.wallets.viewmodels.ActionItemsViewModel$special$$inlined$unwrap$2
            public final T apply(Optional<? extends T> it) {
                kotlin.jvm.internal.m.g(it, "it");
                return it.toNullable();
            }

            @Override // h.c.m0.n
            public /* bridge */ /* synthetic */ Object apply(Object obj) {
                return apply((Optional) ((Optional) obj));
            }
        });
        kotlin.jvm.internal.m.f(map, "this\n    .filter { it.toNullable() != null }\n    .map { it.toNullable() }");
        this.walletSingle = Observable_CoreKt.takeSingle(map);
        s<List<ExchangeRate>> distinctUntilChanged = exchangeRateRepository.getExchangeRateObservable().distinctUntilChanged();
        kotlin.jvm.internal.m.f(distinctUntilChanged, "exchangeRateRepository\n        .exchangeRateObservable\n        .distinctUntilChanged()");
        this.exchangeRateObservable = distinctUntilChanged;
        s<FiatCurrency> distinctUntilChanged2 = fiatCurrencyRepository.getActiveCurrencyObservable().distinctUntilChanged();
        kotlin.jvm.internal.m.f(distinctUntilChanged2, "fiatCurrencyRepository\n        .activeCurrencyObservable\n        .distinctUntilChanged()");
        this.activeFiatCurrencyObservable = distinctUntilChanged2;
        s<List<ListItem>> switchMap = h.c.t0.c.a.b(walletRepository.observeWallets(true), getExchangeRateObservable(), getActiveFiatCurrencyObservable()).flatMapSingle(new h.c.m0.n() { // from class: com.coinbase.wallet.features.wallets.viewmodels.g
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return ActionItemsViewModel.g(ActionItemsViewModel.this, walletRepository, (t) obj);
            }
        }).switchMap(new h.c.m0.n() { // from class: com.coinbase.wallet.features.wallets.viewmodels.e
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return ActionItemsViewModel.e(ActionItemsViewModel.this, (Four) obj);
            }
        });
        kotlin.jvm.internal.m.f(switchMap, "Observables\n        .combineLatest(\n            walletRepository.observeWallets(onlyUsable = true),\n            exchangeRateObservable,\n            activeFiatCurrencyObservable\n        )\n        .flatMapSingle { (wallets, _, _) ->\n            val getLendFeatureFlag = featureFlagsRepository\n                .value(featureFlag = FeatureFlag.LENDING, requireRefresh = !isFirstUpdate)\n\n            if (isFirstUpdate && wallets.isNotEmpty()) isFirstUpdate = false\n\n            val networkSingle = walletRepository.observeNetwork(Blockchain.ETHEREUM).takeSingle()\n\n            Singles.zip(Single.just(wallets), getLendFeatureFlag, getOnrampFeatureFlag, networkSingle)\n        }\n        .switchMap { (wallets, lendingEnabled, onrampEnabled, network) ->\n            if (wallets.isEmpty()) return@switchMap Observable.just(emptyList<ListItem>())\n\n            val isMainnetEth = EthereumChain.fromNetworkRawValue(network.rawValue) == EthereumChain.ETHEREUM_MAINNET\n            val lendItemObservable: Observable<Optional<ListItem.LendListItem>> = if (lendingEnabled && isMainnetEth) {\n                lendRepository.observeTokens()\n                    .flatMapSingle { tokens ->\n                        Singles.zip(\n                            getLendItemTitle(tokens),\n                            getLendItemDescription(tokens),\n                            getLendItemTotalSupplied(tokens)\n                        )\n                    }\n                    .map { (title, description, fiatBalance) ->\n                        ListItem.LendListItem(title, description, fiatBalance).toOptional()\n                    }\n            } else {\n                Observable.just(Optional(null))\n            }\n\n            val fundItem: ListItem.FundListItem? = when {\n                onrampEnabled -> {\n                    ListItem.FundListItem(\n                        title = LocalizedStrings[R.string.fund_item_title_onramp_only],\n                        description = LocalizedStrings[R.string.fund_item_description]\n                    )\n                }\n                else -> {\n                    null\n                }\n            }\n\n            lendItemObservable\n                .map { lendItemOptional -> listOfNotNull(fundItem, lendItemOptional.value) }\n        }");
        this.actionItemsObservable = switchMap;
        s<ViewModelNavRoute> hide = d2.hide();
        kotlin.jvm.internal.m.f(hide, "navigationSubject.hide()");
        this.navigationObservable = hide;
        s<x> hide2 = d3.hide();
        kotlin.jvm.internal.m.f(hide2, "testNetDialogSubject.hide()");
        this.testNetDialogObservable = hide2;
    }

    /* renamed from: _get_getOnrampFeatureFlag_$lambda-0 */
    public static final Boolean m1541_get_getOnrampFeatureFlag_$lambda0(ConsumerConnectionStatus it) {
        kotlin.jvm.internal.m.g(it, "it");
        return Boolean.valueOf(it.getOnrampEnabled());
    }

    public static /* synthetic */ String a(String str) {
        return m1548getLendItemDescription$lambda7(str);
    }

    /* renamed from: actionItemsObservable$lambda-1 */
    public static final h0 m1542actionItemsObservable$lambda1(ActionItemsViewModel this$0, IWalletRepository walletRepository, t dstr$wallets$_u24__u24$_u24__u24) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(walletRepository, "$walletRepository");
        kotlin.jvm.internal.m.g(dstr$wallets$_u24__u24$_u24__u24, "$dstr$wallets$_u24__u24$_u24__u24");
        List list = (List) dstr$wallets$_u24__u24$_u24__u24.a();
        h.c.b0 value$default = FeatureFlagsRepository.value$default(this$0.featureFlagsRepository, FeatureFlag.LENDING, !this$0.isFirstUpdate, 0L, 4, null);
        if (this$0.isFirstUpdate && (!list.isEmpty())) {
            this$0.isFirstUpdate = false;
        }
        h.c.b0 takeSingle = Observable_CoreKt.takeSingle(walletRepository.observeNetwork(Blockchain_EthereumKt.getETHEREUM(Blockchain.Companion)));
        h.c.t0.e eVar = h.c.t0.e.a;
        h.c.b0 just = h.c.b0.just(list);
        kotlin.jvm.internal.m.f(just, "just(wallets)");
        return Singles_CoreKt.zip(eVar, just, value$default, this$0.getGetOnrampFeatureFlag(), takeSingle);
    }

    /* renamed from: actionItemsObservable$lambda-5 */
    public static final h.c.x m1543actionItemsObservable$lambda5(ActionItemsViewModel this$0, Four dstr$wallets$lendingEnabled$onrampEnabled$network) {
        s just;
        List g2;
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(dstr$wallets$lendingEnabled$onrampEnabled$network, "$dstr$wallets$lendingEnabled$onrampEnabled$network");
        boolean booleanValue = ((Boolean) dstr$wallets$lendingEnabled$onrampEnabled$network.component2()).booleanValue();
        boolean booleanValue2 = ((Boolean) dstr$wallets$lendingEnabled$onrampEnabled$network.component3()).booleanValue();
        Network network = (Network) dstr$wallets$lendingEnabled$onrampEnabled$network.component4();
        if (((List) dstr$wallets$lendingEnabled$onrampEnabled$network.component1()).isEmpty()) {
            g2 = r.g();
            return s.just(g2);
        }
        boolean z = EthereumChain_EthereumKt.fromNetworkRawValue(EthereumChain.Companion, network.getRawValue()) == EthereumChain.ETHEREUM_MAINNET;
        final ListItem.FundListItem fundListItem = null;
        if (booleanValue && z) {
            just = this$0.getLendRepository().observeTokens().flatMapSingle(new h.c.m0.n() { // from class: com.coinbase.wallet.features.wallets.viewmodels.c
                @Override // h.c.m0.n
                public final Object apply(Object obj) {
                    return ActionItemsViewModel.c(ActionItemsViewModel.this, (List) obj);
                }
            }).map(new h.c.m0.n() { // from class: com.coinbase.wallet.features.wallets.viewmodels.h
                @Override // h.c.m0.n
                public final Object apply(Object obj) {
                    return ActionItemsViewModel.h((t) obj);
                }
            });
            kotlin.jvm.internal.m.f(just, "{\n                lendRepository.observeTokens()\n                    .flatMapSingle { tokens ->\n                        Singles.zip(\n                            getLendItemTitle(tokens),\n                            getLendItemDescription(tokens),\n                            getLendItemTotalSupplied(tokens)\n                        )\n                    }\n                    .map { (title, description, fiatBalance) ->\n                        ListItem.LendListItem(title, description, fiatBalance).toOptional()\n                    }\n            }");
        } else {
            just = s.just(new Optional(null));
            kotlin.jvm.internal.m.f(just, "{\n                Observable.just(Optional(null))\n            }");
        }
        if (booleanValue2) {
            LocalizedStrings localizedStrings = LocalizedStrings.INSTANCE;
            fundListItem = new ListItem.FundListItem(localizedStrings.get(R.string.fund_item_title_onramp_only), localizedStrings.get(R.string.fund_item_description));
        }
        return just.map(new h.c.m0.n() { // from class: com.coinbase.wallet.features.wallets.viewmodels.d
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return ActionItemsViewModel.d(ListItem.FundListItem.this, (Optional) obj);
            }
        });
    }

    /* renamed from: actionItemsObservable$lambda-5$lambda-2 */
    public static final h0 m1544actionItemsObservable$lambda5$lambda2(ActionItemsViewModel this$0, List tokens) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(tokens, "tokens");
        return h.c.t0.e.a.b(this$0.getLendItemTitle(tokens), this$0.getLendItemDescription(tokens), this$0.getLendItemTotalSupplied(tokens));
    }

    /* renamed from: actionItemsObservable$lambda-5$lambda-3 */
    public static final Optional m1545actionItemsObservable$lambda5$lambda3(t dstr$title$description$fiatBalance) {
        kotlin.jvm.internal.m.g(dstr$title$description$fiatBalance, "$dstr$title$description$fiatBalance");
        String title = (String) dstr$title$description$fiatBalance.a();
        String description = (String) dstr$title$description$fiatBalance.b();
        String fiatBalance = (String) dstr$title$description$fiatBalance.c();
        kotlin.jvm.internal.m.f(title, "title");
        kotlin.jvm.internal.m.f(description, "description");
        kotlin.jvm.internal.m.f(fiatBalance, "fiatBalance");
        return OptionalKt.toOptional(new ListItem.LendListItem(title, description, fiatBalance));
    }

    /* renamed from: actionItemsObservable$lambda-5$lambda-4 */
    public static final List m1546actionItemsObservable$lambda5$lambda4(ListItem.FundListItem fundListItem, Optional lendItemOptional) {
        List l2;
        kotlin.jvm.internal.m.g(lendItemOptional, "lendItemOptional");
        l2 = r.l(fundListItem, (ListItem) lendItemOptional.getValue());
        return l2;
    }

    public static /* synthetic */ Boolean b(ConsumerConnectionStatus consumerConnectionStatus) {
        return m1541_get_getOnrampFeatureFlag_$lambda0(consumerConnectionStatus);
    }

    public static /* synthetic */ h0 c(ActionItemsViewModel actionItemsViewModel, List list) {
        return m1544actionItemsObservable$lambda5$lambda2(actionItemsViewModel, list);
    }

    public static /* synthetic */ List d(ListItem.FundListItem fundListItem, Optional optional) {
        return m1546actionItemsObservable$lambda5$lambda4(fundListItem, optional);
    }

    public static /* synthetic */ h.c.x e(ActionItemsViewModel actionItemsViewModel, Four four) {
        return m1543actionItemsObservable$lambda5(actionItemsViewModel, four);
    }

    public static /* synthetic */ ActionSheetDialogHelper.Properties f(ActionItemsViewModel actionItemsViewModel, Boolean bool) {
        return m1547getFundActionSheetProperties$lambda6(actionItemsViewModel, bool);
    }

    public static /* synthetic */ h0 g(ActionItemsViewModel actionItemsViewModel, IWalletRepository iWalletRepository, t tVar) {
        return m1542actionItemsObservable$lambda1(actionItemsViewModel, iWalletRepository, tVar);
    }

    /* renamed from: getFundActionSheetProperties$lambda-6 */
    public static final ActionSheetDialogHelper.Properties m1547getFundActionSheetProperties$lambda6(ActionItemsViewModel this$0, Boolean isSwapEnabled) {
        String str;
        List m;
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(isSwapEnabled, "isSwapEnabled");
        ConsumerConnectionStatus connectStatus = this$0.consumerUserRepository.getConnectStatus();
        boolean onrampEnabled = connectStatus.getOnrampEnabled();
        Analytics.INSTANCE.log(AnalyticsEvent_ApplicationKt.walletsFundActionViewed(AnalyticsEvent.Companion, isSwapEnabled.booleanValue(), onrampEnabled));
        ActionSheetDialogHelper.Action[] actionArr = new ActionSheetDialogHelper.Action[2];
        if (onrampEnabled) {
            str = LocalizedStrings.INSTANCE.get(R.string.fund_action_transfer_from_coinbase_onramp);
        } else {
            str = LocalizedStrings.INSTANCE.get(R.string.fund_action_transfer_from_coinbase);
        }
        ActionStyle actionStyle = ActionStyle.NEUTRAL;
        actionArr[0] = new ActionSheetDialogHelper.Action(str, actionStyle, new ActionItemsViewModel$getFundActionSheetProperties$1$actions$1(connectStatus, this$0, onrampEnabled));
        LocalizedStrings localizedStrings = LocalizedStrings.INSTANCE;
        actionArr[1] = new ActionSheetDialogHelper.Action(localizedStrings.get(R.string.fund_action_transfer_from_elsewhere), actionStyle, new ActionItemsViewModel$getFundActionSheetProperties$1$actions$2(this$0));
        m = r.m(actionArr);
        return new ActionSheetDialogHelper.Properties(localizedStrings.get(R.string.fund_sheet_dialog_title), m, false, null, null, 28, null);
    }

    private final h.c.b0<Boolean> getGetOnrampFeatureFlag() {
        h.c.b0 map = this.consumerUserRepository.getConnectStatus(this.isFirstUpdate).map(new h.c.m0.n() { // from class: com.coinbase.wallet.features.wallets.viewmodels.b
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return ActionItemsViewModel.b((ConsumerConnectionStatus) obj);
            }
        });
        kotlin.jvm.internal.m.f(map, "consumerUserRepository.getConnectStatus(requireRefresh = isFirstUpdate)\n                .map { it.onrampEnabled }");
        return map;
    }

    private final h.c.b0<Boolean> getGetSwapFeatureFlag() {
        return FeatureFlagsRepository.value$default(this.featureFlagsRepository, FeatureFlag.NATIVE_DEX, this.isFirstUpdate, 0L, 4, null);
    }

    private final h.c.b0<String> getLendItemDescription(List<LendToken> list) {
        Object obj;
        if (hasLendingBalance(list)) {
            h.c.b0 map = getAverageWeightedInterest().map(new h.c.m0.n() { // from class: com.coinbase.wallet.features.wallets.viewmodels.a
                @Override // h.c.m0.n
                public final Object apply(Object obj2) {
                    return ActionItemsViewModel.a((String) obj2);
                }
            });
            kotlin.jvm.internal.m.f(map, "{\n            getAverageWeightedInterest()\n                .map { result -> LocalizedStrings[R.string.lend_item_description_has_balance, result] }\n        }");
            return map;
        }
        Iterator<T> it = list.iterator();
        if (it.hasNext()) {
            Object next = it.next();
            if (it.hasNext()) {
                BigInteger supplyInterestRate = ((LendToken) next).getSupplyInterestRate();
                do {
                    Object next2 = it.next();
                    BigInteger supplyInterestRate2 = ((LendToken) next2).getSupplyInterestRate();
                    if (supplyInterestRate.compareTo(supplyInterestRate2) < 0) {
                        next = next2;
                        supplyInterestRate = supplyInterestRate2;
                    }
                } while (it.hasNext());
                obj = next;
            } else {
                obj = next;
            }
        } else {
            obj = null;
        }
        LendToken lendToken = (LendToken) obj;
        if (lendToken == null) {
            h.c.b0<String> just = h.c.b0.just(LocalizedStrings.INSTANCE.get(R.string.lend_item_loading));
            kotlin.jvm.internal.m.f(just, "just(LocalizedStrings[R.string.lend_item_loading])");
            return just;
        }
        h.c.b0<String> just2 = h.c.b0.just(LocalizedStrings.INSTANCE.get(R.string.lend_item_description_no_balance, BigInteger_CommonKt.asRoundedPercentage(lendToken.getSupplyInterestRate(), lendToken.getRateDecimals())));
        kotlin.jvm.internal.m.f(just2, "{\n            val highest = tokens.maxByOrNull { it.supplyInterestRate }\n                ?: return Single.just(LocalizedStrings[R.string.lend_item_loading])\n\n            val rate = highest.supplyInterestRate.asRoundedPercentage(decimals = highest.rateDecimals)\n\n            Single.just(LocalizedStrings[R.string.lend_item_description_no_balance, rate])\n        }");
        return just2;
    }

    /* renamed from: getLendItemDescription$lambda-7 */
    public static final String m1548getLendItemDescription$lambda7(String result) {
        kotlin.jvm.internal.m.g(result, "result");
        return LocalizedStrings.INSTANCE.get(R.string.lend_item_description_has_balance, result);
    }

    private final h.c.b0<String> getLendItemTitle(List<LendToken> list) {
        h.c.b0<String> just = h.c.b0.just(LocalizedStrings.INSTANCE.get(hasLendingBalance(list) ? R.string.lend_item_title_has_balance : R.string.lend_item_title_no_balance));
        kotlin.jvm.internal.m.f(just, "just(LocalizedStrings[stringID])");
        return just;
    }

    private final h.c.b0<String> getLendItemTotalSupplied(List<LendToken> list) {
        if (hasLendingBalance(list)) {
            return getTotalFiatBalance();
        }
        h.c.b0<String> just = h.c.b0.just(Strings_CoreKt.getEmpty(Strings.INSTANCE));
        kotlin.jvm.internal.m.f(just, "{\n            Single.just(Strings.empty)\n        }");
        return just;
    }

    public static /* synthetic */ Optional h(t tVar) {
        return m1545actionItemsObservable$lambda5$lambda3(tVar);
    }

    private final boolean hasLendingBalance(List<LendToken> list) {
        boolean z;
        if (!(list instanceof Collection) || !list.isEmpty()) {
            for (LendToken lendToken : list) {
                if (lendToken.getSupplyBalance().compareTo(BigInteger.ZERO) > 0) {
                    z = true;
                    continue;
                } else {
                    z = false;
                    continue;
                }
                if (z) {
                    return true;
                }
            }
        }
        return false;
    }

    public final s<List<ListItem>> getActionItemsObservable() {
        return this.actionItemsObservable;
    }

    @Override // com.coinbase.wallet.features.lend.interfaces.LendBalanceManaging
    public s<FiatCurrency> getActiveFiatCurrencyObservable() {
        return this.activeFiatCurrencyObservable;
    }

    @Override // com.coinbase.wallet.features.lend.interfaces.LendBalanceManaging
    public h.c.b0<String> getAverageWeightedInterest() {
        return LendBalanceManaging.DefaultImpls.getAverageWeightedInterest(this);
    }

    @Override // com.coinbase.wallet.features.lend.interfaces.LendBalanceManaging
    public CurrencyFormatter getCurrencyFormatter() {
        return this.currencyFormatter;
    }

    @Override // com.coinbase.wallet.features.lend.interfaces.LendBalanceManaging
    public s<List<ExchangeRate>> getExchangeRateObservable() {
        return this.exchangeRateObservable;
    }

    public final h.c.b0<ActionSheetDialogHelper.Properties> getFundActionSheetProperties(boolean z) {
        h.c.b0 map = getGetSwapFeatureFlag().map(new h.c.m0.n() { // from class: com.coinbase.wallet.features.wallets.viewmodels.f
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return ActionItemsViewModel.f(ActionItemsViewModel.this, (Boolean) obj);
            }
        });
        kotlin.jvm.internal.m.f(map, "getSwapFeatureFlag\n            .map { isSwapEnabled ->\n                val connectStatus = consumerUserRepository.getConnectStatus()\n                val isOnrampEnabled = connectStatus.onrampEnabled\n\n                Analytics.log(\n                    AnalyticsEvent\n                        .walletsFundActionViewed(swapEnabled = isSwapEnabled, onrampEnabled = isOnrampEnabled)\n                )\n\n                val actions = mutableListOf(\n                    ActionSheetDialogHelper.Action(\n                        text = if (isOnrampEnabled) {\n                            LocalizedStrings[R.string.fund_action_transfer_from_coinbase_onramp]\n                        } else {\n                            LocalizedStrings[R.string.fund_action_transfer_from_coinbase]\n                        },\n                        style = ActionStyle.NEUTRAL\n                    ) { dialog ->\n                        dialog.dismiss()\n                        val arguments = ConsumerInterstitialArgs\n                            .createArguments(connectionStatus = connectStatus, hasSharedElementTransition = true)\n\n                        val route = ViewModelNavRoute(\n                            resourceId = R.id.action_walletFragment_to_consumerNavGraph,\n                            args = arguments,\n                            navOptions = holdNavOptions\n                        )\n\n                        Analytics.log(AnalyticsEvent.walletsFundActionConsumerTapped(onrampEnabled = isOnrampEnabled))\n                        navigationSubject.onNext(route)\n                    },\n                    ActionSheetDialogHelper.Action(\n                        text = LocalizedStrings[R.string.fund_action_transfer_from_elsewhere],\n                        style = ActionStyle.NEUTRAL\n                    ) { dialog ->\n                        dialog.dismiss()\n\n                        val route = ViewModelNavRoute(\n                            resourceId = R.id.receiveCoinPickerFragment,\n                            navOptions = verticalNavOptionsBuilder.build()\n                        )\n\n                        navigationSubject.onNext(route)\n                    }\n                )\n\n                ActionSheetDialogHelper.Properties(\n                    title = LocalizedStrings[R.string.fund_sheet_dialog_title],\n                    actions = actions\n                )\n            }");
        return map;
    }

    @Override // com.coinbase.wallet.features.lend.interfaces.LendBalanceManaging
    public ILendRepository getLendRepository() {
        return this.lendRepository;
    }

    public final s<ViewModelNavRoute> getNavigationObservable() {
        return this.navigationObservable;
    }

    public final s<x> getTestNetDialogObservable() {
        return this.testNetDialogObservable;
    }

    @Override // com.coinbase.wallet.features.lend.interfaces.LendBalanceManaging
    public h.c.b0<String> getTotalFiatBalance() {
        return LendBalanceManaging.DefaultImpls.getTotalFiatBalance(this);
    }

    @Override // com.coinbase.wallet.features.lend.interfaces.LendBalanceFetching
    public TxHistoryRepository getTxHistoryRepository() {
        return this.txHistoryRepository;
    }

    @Override // com.coinbase.wallet.features.lend.interfaces.LendBalanceFetching
    public h.c.b0<Boolean> isBalanceAvailable() {
        return LendBalanceFetching.DefaultImpls.isBalanceAvailable(this);
    }

    @Override // androidx.lifecycle.b0
    public void onCleared() {
        super.onCleared();
        this.disposeBag.d();
    }

    public final void onLendItemClick() {
        h.c.t0.a.a(h.c.t0.g.i(this.walletSingle, null, new ActionItemsViewModel$onLendItemClick$1(this), 1, null), this.disposeBag);
    }
}