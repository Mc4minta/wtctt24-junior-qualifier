package com.toshi.view.fragment.coin;

import android.content.DialogInterface;
import androidx.lifecycle.b0;
import com.coinbase.ciphercore.ethereum.EthereumChain;
import com.coinbase.wallet.analytics.Analytics;
import com.coinbase.wallet.analytics.models.AnalyticsEvent;
import com.coinbase.wallet.application.extensions.AnalyticsEvent_ApplicationKt;
import com.coinbase.wallet.blockchains.models.Blockchain;
import com.coinbase.wallet.blockchains.models.CurrencyCode;
import com.coinbase.wallet.blockchains.models.Transaction;
import com.coinbase.wallet.blockchains.models.TxMetadata;
import com.coinbase.wallet.blockchains.models.TxMetadataKey;
import com.coinbase.wallet.blockchains.models.TxState;
import com.coinbase.wallet.blockchains.models.Wallet;
import com.coinbase.wallet.common.extensions.WalletRepository_CommonKt;
import com.coinbase.wallet.common.utilities.LocalizedStrings;
import com.coinbase.wallet.commonui.extensions.Fragment_CommonKt;
import com.coinbase.wallet.commonui.models.ActionStyle;
import com.coinbase.wallet.commonui.models.ViewModelNavRoute;
import com.coinbase.wallet.commonui.utilities.ActionSheetDialogHelper;
import com.coinbase.wallet.commonui.utilities.PromptDialogHelper;
import com.coinbase.wallet.consumer.extensions.TxMetadataKey_ConsumerConnectKt;
import com.coinbase.wallet.consumer.models.ConsumerConnectionStatus;
import com.coinbase.wallet.consumer.models.ConsumerInterstitialArgs;
import com.coinbase.wallet.consumer.repositories.ConsumerUserRepository;
import com.coinbase.wallet.core.extensions.Observable_CoreKt;
import com.coinbase.wallet.core.extensions.Strings;
import com.coinbase.wallet.core.extensions.Strings_CoreKt;
import com.coinbase.wallet.core.util.Optional;
import com.coinbase.wallet.ethereum.extensions.Network_EthereumKt;
import com.coinbase.wallet.ethereum.models.ContractAddress;
import com.coinbase.wallet.featureflags.models.FeatureFlag;
import com.coinbase.wallet.featureflags.repositories.FeatureFlagsRepository;
import com.coinbase.wallet.features.swap.models.SwapInterstitialFragmentArgs;
import com.coinbase.wallet.features.swap.prompts.UnsupportedSwapAssetPrompt;
import com.coinbase.wallet.ripple.extensions.Blockchain_RippleKt;
import com.coinbase.wallet.ripple.extensions.TxMetadataKey_RippleKt;
import com.coinbase.wallet.stellar.extensions.Blockchain_StellarKt;
import com.coinbase.wallet.swap.interfaces.ISwapRepository;
import com.coinbase.wallet.swap.models.Aggregator;
import com.coinbase.wallet.swap.models.SwapAsset;
import com.coinbase.wallet.txhistory.extensions.Transaction_TxHistoryKt;
import com.coinbase.wallet.txhistory.models.RecipientType;
import com.coinbase.wallet.txhistory.models.TxAddress;
import com.coinbase.wallet.txhistory.models.TxHistoryCellViewState;
import com.coinbase.wallet.txhistory.repositories.TxHistoryRepository;
import com.coinbase.wallet.txhistory.views.TxHistoryDetailFragment;
import com.coinbase.wallet.wallets.formatters.CurrencyFormatter;
import com.coinbase.wallet.wallets.interfaces.IExchangeRateRepository;
import com.coinbase.wallet.wallets.interfaces.IFiatCurrencyRepository;
import com.coinbase.wallet.wallets.interfaces.IWalletRepository;
import com.coinbase.wallet.wallets.models.ExchangeRate;
import com.coinbase.wallet.wallets.models.FiatCurrency;
import h.c.h0;
import h.c.s;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import kotlin.a0.r;
import kotlin.a0.z;
import kotlin.l0.y;
import kotlin.t;
import kotlin.u;
import kotlin.x;
import org.toshi.R;

/* compiled from: WalletDetailViewModel.kt */
/* loaded from: classes2.dex */
public final class m extends b0 {
    private final TxHistoryRepository a;

    /* renamed from: b */
    private final CurrencyFormatter f11312b;

    /* renamed from: c */
    private final IWalletRepository f11313c;

    /* renamed from: d */
    private final FeatureFlagsRepository f11314d;

    /* renamed from: e */
    private final ISwapRepository f11315e;

    /* renamed from: f */
    private final UnsupportedSwapAssetPrompt f11316f;

    /* renamed from: g */
    private final ConsumerUserRepository f11317g;

    /* renamed from: h */
    private final h.c.k0.a f11318h;

    /* renamed from: i */
    private final s<FiatCurrency> f11319i;

    /* renamed from: j */
    private final s<List<ExchangeRate>> f11320j;

    /* renamed from: k */
    private final s<x> f11321k;

    /* renamed from: l */
    private final h.c.v0.b<ViewModelNavRoute> f11322l;
    private final h.c.v0.b<PromptDialogHelper.Properties> m;
    private final h.c.b0<Boolean> n;
    private final s<ViewModelNavRoute> o;
    private final s<PromptDialogHelper.Properties> p;
    public Wallet q;

    /* compiled from: Observable+Core.kt */
    /* loaded from: classes2.dex */
    public static final class a<T> implements h.c.m0.p {
        public static final a<T> a = new a<>();

        @Override // h.c.m0.p
        /* renamed from: a */
        public final boolean test(Optional<? extends T> it) {
            kotlin.jvm.internal.m.g(it, "it");
            return it.toNullable() != null;
        }
    }

    /* compiled from: Observable+Core.kt */
    /* loaded from: classes2.dex */
    public static final class b<T, R> implements h.c.m0.n {
        public static final b<T, R> a = new b<>();

        @Override // h.c.m0.n
        /* renamed from: a */
        public final T apply(Optional<? extends T> it) {
            kotlin.jvm.internal.m.g(it, "it");
            return it.toNullable();
        }
    }

    /* compiled from: Observable+Core.kt */
    /* loaded from: classes2.dex */
    public static final class c<T> implements h.c.m0.p {
        public static final c<T> a = new c<>();

        @Override // h.c.m0.p
        /* renamed from: a */
        public final boolean test(Optional<? extends T> it) {
            kotlin.jvm.internal.m.g(it, "it");
            return it.toNullable() != null;
        }
    }

    /* compiled from: Observable+Core.kt */
    /* loaded from: classes2.dex */
    public static final class d<T, R> implements h.c.m0.n {
        public static final d<T, R> a = new d<>();

        @Override // h.c.m0.n
        /* renamed from: a */
        public final T apply(Optional<? extends T> it) {
            kotlin.jvm.internal.m.g(it, "it");
            return it.toNullable();
        }
    }

    /* compiled from: Observable+Core.kt */
    /* loaded from: classes2.dex */
    public static final class e<T> implements h.c.m0.p {
        public static final e<T> a = new e<>();

        @Override // h.c.m0.p
        /* renamed from: a */
        public final boolean test(Optional<? extends T> it) {
            kotlin.jvm.internal.m.g(it, "it");
            return it.toNullable() != null;
        }
    }

    /* compiled from: Observable+Core.kt */
    /* loaded from: classes2.dex */
    public static final class f<T, R> implements h.c.m0.n {
        public static final f<T, R> a = new f<>();

        @Override // h.c.m0.n
        /* renamed from: a */
        public final T apply(Optional<? extends T> it) {
            kotlin.jvm.internal.m.g(it, "it");
            return it.toNullable();
        }
    }

    /* compiled from: WalletDetailViewModel.kt */
    /* loaded from: classes2.dex */
    public static final class g extends kotlin.jvm.internal.o implements kotlin.e0.c.l<DialogInterface, x> {
        final /* synthetic */ SwapAsset a;

        /* renamed from: b */
        final /* synthetic */ m f11323b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        g(SwapAsset swapAsset, m mVar) {
            super(1);
            this.a = swapAsset;
            this.f11323b = mVar;
        }

        @Override // kotlin.e0.c.l
        public /* bridge */ /* synthetic */ x invoke(DialogInterface dialogInterface) {
            invoke2(dialogInterface);
            return x.a;
        }

        /* renamed from: invoke */
        public final void invoke2(DialogInterface dialog) {
            kotlin.jvm.internal.m.g(dialog, "dialog");
            dialog.dismiss();
            if (this.a.getSwappable()) {
                Analytics.INSTANCE.log(AnalyticsEvent_ApplicationKt.getSwapEntryPointDetails(AnalyticsEvent.Companion));
                this.f11323b.f11322l.onNext(new ViewModelNavRoute(R.id.action_coinDetailsFragment_to_swapInterstitialFragment, SwapInterstitialFragmentArgs.createArguments$default(SwapInterstitialFragmentArgs.INSTANCE, false, this.a, null, 4, null), Fragment_CommonKt.getVerticalNavOptions(this.f11323b)));
                return;
            }
            Analytics.INSTANCE.log(AnalyticsEvent_ApplicationKt.swapEntryPointNotSupported(AnalyticsEvent.Companion, this.a.getCurrencyCode().getCode()));
            this.f11323b.H(this.a);
        }
    }

    /* compiled from: WalletDetailViewModel.kt */
    /* loaded from: classes2.dex */
    public static final class h extends kotlin.jvm.internal.o implements kotlin.e0.c.l<DialogInterface, x> {

        /* renamed from: b */
        final /* synthetic */ Boolean f11324b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        h(Boolean bool) {
            super(1);
            m.this = r1;
            this.f11324b = bool;
        }

        @Override // kotlin.e0.c.l
        public /* bridge */ /* synthetic */ x invoke(DialogInterface dialogInterface) {
            invoke2(dialogInterface);
            return x.a;
        }

        /* renamed from: invoke */
        public final void invoke2(DialogInterface dialog) {
            kotlin.jvm.internal.m.g(dialog, "dialog");
            dialog.dismiss();
            ViewModelNavRoute viewModelNavRoute = new ViewModelNavRoute(R.id.consumer_nav_graph, ConsumerInterstitialArgs.createArguments$default(ConsumerInterstitialArgs.INSTANCE, false, m.this.f11317g.getConnectStatus(), m.this.getWallet().getCurrencyCode(), false, 8, null), Fragment_CommonKt.getVerticalNavOptions(m.this));
            Analytics analytics = Analytics.INSTANCE;
            AnalyticsEvent.Companion companion = AnalyticsEvent.Companion;
            Boolean isOnrampEnabled = this.f11324b;
            kotlin.jvm.internal.m.f(isOnrampEnabled, "isOnrampEnabled");
            analytics.log(AnalyticsEvent_ApplicationKt.walletDetailFundActionConsumerTapped(companion, isOnrampEnabled.booleanValue(), m.this.getWallet().getCurrencyCode(), m.this.getWallet().getBlockchain()));
            m.this.f11322l.onNext(viewModelNavRoute);
        }
    }

    /* compiled from: WalletDetailViewModel.kt */
    /* loaded from: classes2.dex */
    public static final class i extends kotlin.jvm.internal.o implements kotlin.e0.c.l<DialogInterface, x> {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        i() {
            super(1);
            m.this = r1;
        }

        @Override // kotlin.e0.c.l
        public /* bridge */ /* synthetic */ x invoke(DialogInterface dialogInterface) {
            invoke2(dialogInterface);
            return x.a;
        }

        /* renamed from: invoke */
        public final void invoke2(DialogInterface dialog) {
            kotlin.jvm.internal.m.g(dialog, "dialog");
            dialog.dismiss();
            m.this.f11322l.onNext(new ViewModelNavRoute(R.id.receiveCoinPickerFragment, null, Fragment_CommonKt.getNoneNavOptions(m.this), 2, null));
        }
    }

    /* compiled from: WalletDetailViewModel.kt */
    /* loaded from: classes2.dex */
    public static final class j extends kotlin.jvm.internal.o implements kotlin.e0.c.l<List<? extends Aggregator>, x> {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        j() {
            super(1);
            m.this = r1;
        }

        @Override // kotlin.e0.c.l
        public /* bridge */ /* synthetic */ x invoke(List<? extends Aggregator> list) {
            invoke2((List<Aggregator>) list);
            return x.a;
        }

        /* renamed from: invoke */
        public final void invoke2(List<Aggregator> aggregatorList) {
            UnsupportedSwapAssetPrompt unsupportedSwapAssetPrompt = m.this.f11316f;
            kotlin.jvm.internal.m.f(aggregatorList, "aggregatorList");
            m.this.m.onNext(unsupportedSwapAssetPrompt.promptProperties(aggregatorList));
        }
    }

    /* compiled from: WalletDetailViewModel.kt */
    /* loaded from: classes2.dex */
    public static final class k extends kotlin.jvm.internal.o implements kotlin.e0.c.l<Transaction, TxHistoryCellViewState.Item> {

        /* renamed from: b */
        final /* synthetic */ Map<String, TxAddress> f11325b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        k(Map<String, TxAddress> map) {
            super(1);
            m.this = r1;
            this.f11325b = map;
        }

        @Override // kotlin.e0.c.l
        /* renamed from: a */
        public final TxHistoryCellViewState.Item invoke(Transaction tx) {
            String empty;
            String title;
            kotlin.jvm.internal.m.g(tx, "tx");
            TxAddress M = m.this.M(tx, this.f11325b);
            String str = null;
            RecipientType recipientType = M == null ? null : M.getRecipientType();
            if (recipientType == null) {
                recipientType = RecipientType.Address;
            }
            RecipientType recipientType2 = recipientType;
            if (M != null && (title = M.getTitle()) != null) {
                if (recipientType2 == RecipientType.User) {
                    title = kotlin.jvm.internal.m.o(Strings_CoreKt.getAt(Strings.INSTANCE), title);
                }
                str = title;
            }
            String entityDisplayName = str == null ? Transaction_TxHistoryKt.entityDisplayName(tx, false) : str;
            if (tx.isSent()) {
                empty = tx.getToAddress();
                if (empty == null) {
                    empty = Strings_CoreKt.getEmpty(Strings.INSTANCE);
                }
            } else if (tx.getFromAddress() != null) {
                empty = tx.getFromAddress();
                if (empty == null) {
                    empty = Strings_CoreKt.getEmpty(Strings.INSTANCE);
                }
            } else if (tx.getMetadata().get(TxMetadataKey_ConsumerConnectKt.getConsumerAccountID(TxMetadataKey.Companion)) != null) {
                empty = LocalizedStrings.INSTANCE.get(R.string.coinbase);
            } else {
                empty = Strings_CoreKt.getEmpty(Strings.INSTANCE);
            }
            String str2 = empty;
            int decimals = m.this.getWallet().getDecimals();
            CurrencyFormatter currencyFormatter = m.this.f11312b;
            s sVar = m.this.f11321k;
            s<Optional<Wallet>> observeWallet = WalletRepository_CommonKt.observeWallet(m.this.f11313c, m.this.getWallet().getBlockchain(), tx.getFeeCurrencyCode());
            kotlin.jvm.internal.m.f(observeWallet, "walletRepository.observeWallet(wallet.blockchain, tx.feeCurrencyCode)");
            return new TxHistoryCellViewState.Item(tx, entityDisplayName, str2, recipientType2, decimals, currencyFormatter, sVar, observeWallet);
        }
    }

    public m(TxHistoryRepository txHistoryRepository, CurrencyFormatter currencyFormatter, IWalletRepository walletRepository, FeatureFlagsRepository featureFlagsRepository, ISwapRepository swapRepository, UnsupportedSwapAssetPrompt unsupportedSwapAssetPrompt, ConsumerUserRepository consumerUserRepository, IFiatCurrencyRepository fiatCurrencyRepository, IExchangeRateRepository exchangeRateRepository) {
        kotlin.jvm.internal.m.g(txHistoryRepository, "txHistoryRepository");
        kotlin.jvm.internal.m.g(currencyFormatter, "currencyFormatter");
        kotlin.jvm.internal.m.g(walletRepository, "walletRepository");
        kotlin.jvm.internal.m.g(featureFlagsRepository, "featureFlagsRepository");
        kotlin.jvm.internal.m.g(swapRepository, "swapRepository");
        kotlin.jvm.internal.m.g(unsupportedSwapAssetPrompt, "unsupportedSwapAssetPrompt");
        kotlin.jvm.internal.m.g(consumerUserRepository, "consumerUserRepository");
        kotlin.jvm.internal.m.g(fiatCurrencyRepository, "fiatCurrencyRepository");
        kotlin.jvm.internal.m.g(exchangeRateRepository, "exchangeRateRepository");
        this.a = txHistoryRepository;
        this.f11312b = currencyFormatter;
        this.f11313c = walletRepository;
        this.f11314d = featureFlagsRepository;
        this.f11315e = swapRepository;
        this.f11316f = unsupportedSwapAssetPrompt;
        this.f11317g = consumerUserRepository;
        h.c.k0.a aVar = new h.c.k0.a();
        this.f11318h = aVar;
        s<FiatCurrency> activeCurrencyObservable = fiatCurrencyRepository.getActiveCurrencyObservable();
        this.f11319i = activeCurrencyObservable;
        s<List<ExchangeRate>> exchangeRateObservable = exchangeRateRepository.getExchangeRateObservable();
        this.f11320j = exchangeRateObservable;
        s a2 = h.c.t0.c.a.a(activeCurrencyObservable, exchangeRateObservable);
        kotlin.jvm.internal.m.f(a2, "Observables\n        .combineLatest(activeCurrencyObservable, exchangeRateObservable)");
        this.f11321k = Observable_CoreKt.asUnit(a2);
        h.c.v0.b<ViewModelNavRoute> d2 = h.c.v0.b.d();
        kotlin.jvm.internal.m.f(d2, "create<ViewModelNavRoute>()");
        this.f11322l = d2;
        h.c.v0.b<PromptDialogHelper.Properties> d3 = h.c.v0.b.d();
        kotlin.jvm.internal.m.f(d3, "create<PromptDialogHelper.Properties>()");
        this.m = d3;
        this.n = FeatureFlagsRepository.value$default(featureFlagsRepository, FeatureFlag.NATIVE_DEX, true, 0L, 4, null);
        s<ViewModelNavRoute> hide = d2.hide();
        kotlin.jvm.internal.m.f(hide, "navigationSubject.hide()");
        this.o = hide;
        s<PromptDialogHelper.Properties> hide2 = d3.hide();
        kotlin.jvm.internal.m.f(hide2, "promptSubject.hide()");
        this.p = hide2;
        h.c.t0.a.a(h.c.t0.g.i(swapRepository.refresh(true), null, null, 3, null), aVar);
    }

    public static /* synthetic */ kotlin.o A(Transaction transaction, Wallet wallet) {
        return p(transaction, wallet);
    }

    public static /* synthetic */ List B(m mVar, kotlin.o oVar) {
        return L(mVar, oVar);
    }

    public static /* synthetic */ h0 C(m mVar, x xVar) {
        return O(mVar, xVar);
    }

    public static /* synthetic */ h0 D(m mVar, Optional optional) {
        return K(mVar, optional);
    }

    public static /* synthetic */ ActionSheetDialogHelper.Properties E(m mVar, t tVar) {
        return G(mVar, tVar);
    }

    public static final ActionSheetDialogHelper.Properties G(m this$0, t dstr$isSwapEnabled$isOnrampEnabled$swapAssetOptional) {
        String str;
        List m;
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(dstr$isSwapEnabled$isOnrampEnabled$swapAssetOptional, "$dstr$isSwapEnabled$isOnrampEnabled$swapAssetOptional");
        Boolean isSwapEnabled = (Boolean) dstr$isSwapEnabled$isOnrampEnabled$swapAssetOptional.a();
        Boolean isOnrampEnabled = (Boolean) dstr$isSwapEnabled$isOnrampEnabled$swapAssetOptional.b();
        Optional optional = (Optional) dstr$isSwapEnabled$isOnrampEnabled$swapAssetOptional.c();
        Analytics analytics = Analytics.INSTANCE;
        AnalyticsEvent.Companion companion = AnalyticsEvent.Companion;
        kotlin.jvm.internal.m.f(isSwapEnabled, "isSwapEnabled");
        boolean booleanValue = isSwapEnabled.booleanValue();
        kotlin.jvm.internal.m.f(isOnrampEnabled, "isOnrampEnabled");
        analytics.log(AnalyticsEvent_ApplicationKt.walletDetailFundActionViewed(companion, booleanValue, isOnrampEnabled.booleanValue(), this$0.getWallet().getCurrencyCode(), this$0.getWallet().getBlockchain()));
        ActionSheetDialogHelper.Action[] actionArr = new ActionSheetDialogHelper.Action[2];
        if (isOnrampEnabled.booleanValue()) {
            str = LocalizedStrings.INSTANCE.get(R.string.fund_action_transfer_from_coinbase_onramp);
        } else {
            str = LocalizedStrings.INSTANCE.get(R.string.fund_action_transfer_from_coinbase);
        }
        ActionStyle actionStyle = ActionStyle.NEUTRAL;
        actionArr[0] = new ActionSheetDialogHelper.Action(str, actionStyle, new h(isOnrampEnabled));
        LocalizedStrings localizedStrings = LocalizedStrings.INSTANCE;
        actionArr[1] = new ActionSheetDialogHelper.Action(localizedStrings.get(R.string.fund_action_transfer_from_elsewhere), actionStyle, new i());
        m = r.m(actionArr);
        SwapAsset swapAsset = (SwapAsset) optional.getValue();
        if (swapAsset != null && isSwapEnabled.booleanValue()) {
            m.add(new ActionSheetDialogHelper.Action(localizedStrings.get(R.string.wallet_detail_convert_token_action, this$0.getWallet().getDisplayName()), actionStyle, new g(swapAsset, this$0)));
        }
        return new ActionSheetDialogHelper.Properties(localizedStrings.get(R.string.fund_sheet_dialog_title), m, false, null, null, 28, null);
    }

    public final void H(SwapAsset swapAsset) {
        h.c.b0<List<Aggregator>> observeOn = this.f11315e.getAggregators(swapAsset.getAggregatorIDs()).observeOn(h.c.j0.c.a.b());
        kotlin.jvm.internal.m.f(observeOn, "swapRepository.getAggregators(asset.aggregatorIDs)\n            .observeOn(AndroidSchedulers.mainThread())");
        h.c.t0.a.a(h.c.t0.g.i(observeOn, null, new j(), 1, null), this.f11318h);
    }

    private final List<TxHistoryCellViewState> I(List<Transaction> list, List<TxAddress> list2) {
        int r;
        int r2;
        ArrayList<TxAddress> arrayList = new ArrayList();
        Iterator<T> it = list2.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            if (((TxAddress) next).getRecipientType() != RecipientType.Address) {
                arrayList.add(next);
            }
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (TxAddress txAddress : arrayList) {
            linkedHashMap.put(l(txAddress.getAddress(), txAddress.getMetadataKey(), txAddress.getMetadata()), txAddress);
        }
        k kVar = new k(linkedHashMap);
        ArrayList<Object> arrayList2 = new ArrayList();
        for (Object obj : list) {
            if (((Transaction) obj).getState() == TxState.PENDING) {
                arrayList2.add(obj);
            }
        }
        r = kotlin.a0.s.r(arrayList2, 10);
        ArrayList arrayList3 = new ArrayList(r);
        for (Object obj2 : arrayList2) {
            arrayList3.add(kVar.invoke(obj2));
        }
        ArrayList<Object> arrayList4 = new ArrayList();
        for (Object obj3 : list) {
            if (((Transaction) obj3).getState() != TxState.PENDING) {
                arrayList4.add(obj3);
            }
        }
        r2 = kotlin.a0.s.r(arrayList4, 10);
        ArrayList arrayList5 = new ArrayList(r2);
        for (Object obj4 : arrayList4) {
            arrayList5.add(kVar.invoke(obj4));
        }
        ArrayList arrayList6 = new ArrayList();
        if (!arrayList3.isEmpty()) {
            arrayList6.add(new TxHistoryCellViewState.Header(R.string.transaction_header_pending));
            arrayList6.addAll(arrayList3);
        }
        if (!arrayList5.isEmpty()) {
            arrayList6.add(new TxHistoryCellViewState.Header(R.string.transaction_header_complete));
            arrayList6.addAll(arrayList5);
        }
        return arrayList6;
    }

    private final h.c.b0<List<TxHistoryCellViewState>> J() {
        s<Optional<Wallet>> observeWallet = WalletRepository_CommonKt.observeWallet(this.f11313c, getWallet().getBlockchain(), getWallet().getCurrencyCode());
        kotlin.jvm.internal.m.f(observeWallet, "walletRepository\n        .observeWallet(wallet.blockchain, wallet.currencyCode)");
        h.c.b0<List<TxHistoryCellViewState>> map = Observable_CoreKt.takeSingle(observeWallet).flatMap(new h.c.m0.n() { // from class: com.toshi.view.fragment.coin.j
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return m.D(m.this, (Optional) obj);
            }
        }).observeOn(h.c.j0.c.a.b()).map(new h.c.m0.n() { // from class: com.toshi.view.fragment.coin.h
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return m.B(m.this, (kotlin.o) obj);
            }
        });
        kotlin.jvm.internal.m.f(map, "walletRepository\n        .observeWallet(wallet.blockchain, wallet.currencyCode)\n        .takeSingle()\n        .flatMap { walletOptional ->\n            val wallet = walletOptional.toNullable()\n                ?: return@flatMap Single.just(emptyList<Transaction>() to emptyList<TxAddress>())\n\n            val getTxAddresses = txHistoryRepository.getTxAddresses(\n                blockchain = wallet.blockchain,\n                currencyCode = wallet.currencyCode,\n                network = wallet.network\n            )\n\n            Singles.zip(txHistoryRepository.getTxs(wallet), getTxAddresses)\n        }\n        .observeOn(AndroidSchedulers.mainThread())\n        .map { rebuildSections(it.first, it.second) }");
        return map;
    }

    public static final h0 K(m this$0, Optional walletOptional) {
        List g2;
        List g3;
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(walletOptional, "walletOptional");
        Wallet wallet = (Wallet) walletOptional.toNullable();
        if (wallet == null) {
            g2 = r.g();
            g3 = r.g();
            return h.c.b0.just(u.a(g2, g3));
        }
        return h.c.t0.e.a.a(this$0.a.getTxs(wallet), this$0.a.getTxAddresses(wallet.getBlockchain(), wallet.getCurrencyCode(), wallet.getNetwork()));
    }

    public static final List L(m this$0, kotlin.o it) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(it, "it");
        return this$0.I((List) it.c(), (List) it.d());
    }

    public final TxAddress M(Transaction transaction, Map<String, TxAddress> map) {
        kotlin.o a2;
        Set set;
        String toAddress = transaction.isSent() ? transaction.getToAddress() : transaction.getFromAddress();
        if (toAddress == null || toAddress.length() == 0) {
            return null;
        }
        Blockchain blockchain = transaction.getBlockchain();
        Blockchain.Companion companion = Blockchain.Companion;
        if (kotlin.jvm.internal.m.c(blockchain, Blockchain_StellarKt.getSTELLAR(companion))) {
            Set<TxMetadataKey> keySet = transaction.getMetadata().toMap().keySet();
            ArrayList arrayList = new ArrayList();
            for (Object obj : keySet) {
                set = n.a;
                if (set.contains((TxMetadataKey) obj)) {
                    arrayList.add(obj);
                }
            }
            TxMetadataKey txMetadataKey = (TxMetadataKey) kotlin.a0.p.a0(arrayList);
            Object obj2 = txMetadataKey == null ? null : transaction.getMetadata().get(txMetadataKey);
            if (txMetadataKey != null && obj2 != null) {
                a2 = u.a(txMetadataKey, obj2);
            } else {
                a2 = u.a(null, null);
            }
        } else if (kotlin.jvm.internal.m.c(blockchain, Blockchain_RippleKt.getXRP(companion))) {
            TxMetadata metadata = transaction.getMetadata();
            TxMetadataKey.Companion companion2 = TxMetadataKey.Companion;
            Object obj3 = metadata.get(TxMetadataKey_RippleKt.getDestinationTag(companion2));
            if (obj3 != null) {
                a2 = u.a(TxMetadataKey_RippleKt.getDestinationTag(companion2), obj3);
            } else {
                a2 = u.a(null, null);
            }
        } else {
            a2 = u.a(null, null);
        }
        TxMetadataKey txMetadataKey2 = (TxMetadataKey) a2.a();
        Object b2 = a2.b();
        return map.get(l(toAddress, txMetadataKey2, b2 != null ? b2.toString() : null));
    }

    public static final h0 O(m this$0, x it) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(it, "it");
        return this$0.J();
    }

    /* renamed from: _get_getOnrampFeatureFlag_$lambda-0 */
    public static final Boolean m2201_get_getOnrampFeatureFlag_$lambda0(ConsumerConnectionStatus it) {
        kotlin.jvm.internal.m.g(it, "it");
        return Boolean.valueOf(it.getOnrampEnabled());
    }

    private final h.c.b0<Boolean> getGetOnrampFeatureFlag() {
        h.c.b0 map = this.f11317g.getConnectStatus(false).map(new h.c.m0.n() { // from class: com.toshi.view.fragment.coin.d
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return m.x((ConsumerConnectionStatus) obj);
            }
        });
        kotlin.jvm.internal.m.f(map, "consumerUserRepository.getConnectStatus(requireRefresh = false)\n                .map { it.onrampEnabled }");
        return map;
    }

    public static final q k(m this$0, Wallet updatedWallet) {
        String formatToFiat;
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(updatedWallet, "updatedWallet");
        CurrencyFormatter currencyFormatter = this$0.f11312b;
        CurrencyCode currencyCode = updatedWallet.getCurrencyCode();
        String contractAddress = updatedWallet.getContractAddress();
        int decimals = updatedWallet.getDecimals();
        BigInteger balance = updatedWallet.getBalance();
        EthereumChain asEthereumChain = Network_EthereumKt.getAsEthereumChain(updatedWallet.getNetwork());
        formatToFiat = currencyFormatter.formatToFiat(currencyCode, contractAddress, decimals, balance, (r17 & 16) != 0 ? false : false, (r17 & 32) != 0 ? null : null, (r17 & 64) != 0 ? null : asEthereumChain == null ? null : Integer.valueOf(asEthereumChain.getChainId()));
        return new q(updatedWallet, formatToFiat, CurrencyFormatter.formatToCrypto$default(this$0.f11312b, updatedWallet.getCurrencyCode(), updatedWallet.getDecimals(), updatedWallet.getBalance(), true, 0, 0, 48, (Object) null));
    }

    private final String l(String str, TxMetadataKey txMetadataKey, String str2) {
        List<String> l2;
        int r;
        String h0;
        CharSequence h1;
        String[] strArr = new String[3];
        strArr[0] = str;
        strArr[1] = txMetadataKey == null ? null : txMetadataKey.getRawValue();
        strArr[2] = str2;
        l2 = r.l(strArr);
        r = kotlin.a0.s.r(l2, 10);
        ArrayList arrayList = new ArrayList(r);
        for (String str3 : l2) {
            Objects.requireNonNull(str3, "null cannot be cast to non-null type kotlin.CharSequence");
            h1 = y.h1(str3);
            arrayList.add(h1.toString());
        }
        h0 = z.h0(arrayList, "/", null, null, 0, null, null, 62, null);
        return h0;
    }

    public static final h.c.x n(m this$0, final Transaction tx) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(tx, "tx");
        if (kotlin.jvm.internal.m.c(tx.getFeeCurrencyCode(), tx.getCurrencyCode())) {
            return s.just(this$0.getWallet()).map(new h.c.m0.n() { // from class: com.toshi.view.fragment.coin.e
                @Override // h.c.m0.n
                public final Object apply(Object obj) {
                    return m.y(Transaction.this, (Wallet) obj);
                }
            });
        }
        s<Optional<Wallet>> observeWallet = WalletRepository_CommonKt.observeWallet(this$0.f11313c, tx.getBlockchain(), tx.getFeeCurrencyCode());
        kotlin.jvm.internal.m.f(observeWallet, "walletRepository.observeWallet(tx.blockchain, tx.feeCurrencyCode)");
        s<R> map = observeWallet.filter(e.a).map(f.a);
        kotlin.jvm.internal.m.f(map, "this\n    .filter { it.toNullable() != null }\n    .map { it.toNullable() }");
        return map.map(new h.c.m0.n() { // from class: com.toshi.view.fragment.coin.g
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return m.A(Transaction.this, (Wallet) obj);
            }
        });
    }

    public static final kotlin.o o(Transaction tx, Wallet it) {
        kotlin.jvm.internal.m.g(tx, "$tx");
        kotlin.jvm.internal.m.g(it, "it");
        return u.a(tx, it);
    }

    public static final kotlin.o p(Transaction tx, Wallet it) {
        kotlin.jvm.internal.m.g(tx, "$tx");
        kotlin.jvm.internal.m.g(it, "it");
        return u.a(tx, it);
    }

    public static final TxHistoryDetailFragment.Args q(m this$0, TxHistoryCellViewState.Item viewCellState, kotlin.o dstr$tx$feeWallet) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(viewCellState, "$viewCellState");
        kotlin.jvm.internal.m.g(dstr$tx$feeWallet, "$dstr$tx$feeWallet");
        Transaction tx = (Transaction) dstr$tx$feeWallet.a();
        Wallet wallet = (Wallet) dstr$tx$feeWallet.b();
        kotlin.jvm.internal.m.f(tx, "tx");
        return new TxHistoryDetailFragment.Args(tx, this$0.getWallet().getBlockchain(), this$0.getWallet().getDecimals(), this$0.getWallet().getImageURL(), wallet.getDecimals(), wallet.getImageURL(), viewCellState.getDisplayName(), viewCellState.getDisplayAddress(), viewCellState.getRecipientType());
    }

    public static final p s(Boolean it) {
        kotlin.jvm.internal.m.g(it, "it");
        return it.booleanValue() ? p.All : p.Loading;
    }

    public static /* synthetic */ TxHistoryDetailFragment.Args u(m mVar, TxHistoryCellViewState.Item item, kotlin.o oVar) {
        return q(mVar, item, oVar);
    }

    public static /* synthetic */ h.c.x v(m mVar, Transaction transaction) {
        return n(mVar, transaction);
    }

    public static /* synthetic */ q w(m mVar, Wallet wallet) {
        return k(mVar, wallet);
    }

    public static /* synthetic */ Boolean x(ConsumerConnectionStatus consumerConnectionStatus) {
        return m2201_get_getOnrampFeatureFlag_$lambda0(consumerConnectionStatus);
    }

    public static /* synthetic */ kotlin.o y(Transaction transaction, Wallet wallet) {
        return o(transaction, wallet);
    }

    public static /* synthetic */ p z(Boolean bool) {
        return s(bool);
    }

    public final h.c.b0<ActionSheetDialogHelper.Properties> F() {
        String contractAddress = getWallet().getContractAddress();
        h.c.b0<ActionSheetDialogHelper.Properties> map = h.c.t0.e.a.b(this.n, getGetOnrampFeatureFlag(), Observable_CoreKt.takeSingle(this.f11315e.observeSwapAsset(getWallet().getCurrencyCode(), contractAddress == null ? null : new ContractAddress(contractAddress)))).observeOn(h.c.j0.c.a.b()).map(new h.c.m0.n() { // from class: com.toshi.view.fragment.coin.k
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return m.E(m.this, (t) obj);
            }
        });
        kotlin.jvm.internal.m.f(map, "Singles.zip(swapFeatureFlagSingle, getOnrampFeatureFlag, swapAssetSingle)\n            .observeOn(AndroidSchedulers.mainThread())\n            .map { (isSwapEnabled, isOnrampEnabled, swapAssetOptional) ->\n                Analytics.log(\n                    AnalyticsEvent\n                        .walletDetailFundActionViewed(\n                            swapEnabled = isSwapEnabled,\n                            onrampEnabled = isOnrampEnabled,\n                            currencyCode = wallet.currencyCode,\n                            blockchain = wallet.blockchain\n                        )\n                )\n\n                val actions = mutableListOf(\n                    ActionSheetDialogHelper.Action(\n                        text = if (isOnrampEnabled) {\n                            LocalizedStrings[R.string.fund_action_transfer_from_coinbase_onramp]\n                        } else {\n                            LocalizedStrings[R.string.fund_action_transfer_from_coinbase]\n                        },\n                        style = ActionStyle.NEUTRAL\n                    ) { dialog ->\n                        dialog.dismiss()\n\n                        val arguments = ConsumerInterstitialArgs.createArguments(\n                            connectionStatus = consumerUserRepository.getConnectStatus(),\n                            forwardingCurrencyCode = wallet.currencyCode,\n                            hasSharedElementTransition = false\n                        )\n\n                        val route = ViewModelNavRoute(\n                            resourceId = R.id.consumer_nav_graph,\n                            args = arguments,\n                            navOptions = verticalNavOptions\n                        )\n\n                        Analytics.log(\n                            AnalyticsEvent.walletDetailFundActionConsumerTapped(\n                                onrampEnabled = isOnrampEnabled,\n                                currencyCode = wallet.currencyCode,\n                                blockchain = wallet.blockchain\n                            )\n                        )\n\n                        navigationSubject.onNext(route)\n                    },\n                    ActionSheetDialogHelper.Action(\n                        text = LocalizedStrings[R.string.fund_action_transfer_from_elsewhere],\n                        style = ActionStyle.NEUTRAL\n                    ) { dialog ->\n                        dialog.dismiss()\n\n                        val route = ViewModelNavRoute(\n                            resourceId = R.id.receiveCoinPickerFragment,\n                            navOptions = noneNavOptions\n                        )\n\n                        navigationSubject.onNext(route)\n                    }\n                )\n\n                val swapAsset = swapAssetOptional.value\n                if (swapAsset != null && isSwapEnabled) {\n                    actions.add(\n                        ActionSheetDialogHelper.Action(\n                            text = LocalizedStrings[R.string.wallet_detail_convert_token_action, wallet.displayName],\n                            style = ActionStyle.NEUTRAL\n                        ) { dialog ->\n                            dialog.dismiss()\n\n                            if (swapAsset.swappable) {\n                                Analytics.log(AnalyticsEvent.swapEntryPointDetails)\n                                val route = ViewModelNavRoute(\n                                    resourceId = R.id.action_coinDetailsFragment_to_swapInterstitialFragment,\n                                    args = SwapInterstitialFragmentArgs.createArguments(false, swapAsset),\n                                    navOptions = verticalNavOptions\n                                )\n\n                                navigationSubject.onNext(route)\n                            } else {\n                                Analytics.log(AnalyticsEvent.swapEntryPointNotSupported(swapAsset.currencyCode.code))\n                                presentUnsupportedAssetPrompt(swapAsset)\n                            }\n                        }\n                    )\n                }\n\n                ActionSheetDialogHelper.Properties(\n                    title = LocalizedStrings[R.string.fund_sheet_dialog_title],\n                    actions = actions\n                )\n            }");
        return map;
    }

    public final s<List<TxHistoryCellViewState>> N() {
        s flatMapSingle = this.a.observeHistoryUpdates(getWallet().getBlockchain(), getWallet().getCurrencyCode()).throttleLast(500L, TimeUnit.MILLISECONDS).startWith((s<x>) x.a).flatMapSingle(new h.c.m0.n() { // from class: com.toshi.view.fragment.coin.i
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return m.C(m.this, (x) obj);
            }
        });
        kotlin.jvm.internal.m.f(flatMapSingle, "txHistoryRepository\n        .observeHistoryUpdates(wallet.blockchain, wallet.currencyCode)\n        .throttleLast(500, TimeUnit.MILLISECONDS)\n        .startWith(Unit)\n        .flatMapSingle { reloadHistoryItems() }");
        return flatMapSingle;
    }

    public final s<ViewModelNavRoute> getNavigationObservable() {
        return this.o;
    }

    public final s<PromptDialogHelper.Properties> getPromptObservable() {
        return this.p;
    }

    public final Wallet getWallet() {
        Wallet wallet = this.q;
        if (wallet != null) {
            return wallet;
        }
        kotlin.jvm.internal.m.w("wallet");
        throw null;
    }

    public final s<q> j() {
        s<Optional<Wallet>> observeWallet = WalletRepository_CommonKt.observeWallet(this.f11313c, getWallet().getBlockchain(), getWallet().getCurrencyCode());
        kotlin.jvm.internal.m.f(observeWallet, "walletRepository\n        .observeWallet(wallet.blockchain, wallet.currencyCode)");
        s<R> map = observeWallet.filter(a.a).map(b.a);
        kotlin.jvm.internal.m.f(map, "this\n    .filter { it.toNullable() != null }\n    .map { it.toNullable() }");
        s<q> map2 = map.map(new h.c.m0.n() { // from class: com.toshi.view.fragment.coin.c
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return m.w(m.this, (Wallet) obj);
            }
        });
        kotlin.jvm.internal.m.f(map2, "walletRepository\n        .observeWallet(wallet.blockchain, wallet.currencyCode)\n        .unwrap()\n        .map { updatedWallet ->\n            val fiatBalance = currencyFormatter.formatToFiat(\n                fromCurrencyCode = updatedWallet.currencyCode,\n                contractAddress = updatedWallet.contractAddress,\n                decimals = updatedWallet.decimals,\n                value = updatedWallet.balance,\n                chainId = updatedWallet.network.asEthereumChain?.chainId\n            )\n\n            val cryptoBalance = currencyFormatter.formatToCrypto(\n                currencyCode = updatedWallet.currencyCode,\n                decimals = updatedWallet.decimals,\n                value = updatedWallet.balance,\n                includeCode = true\n            )\n\n            WalletUpdate(updatedWallet, fiatBalance, cryptoBalance)\n        }");
        return map2;
    }

    public final s<TxHistoryDetailFragment.Args> m(final TxHistoryCellViewState.Item viewCellState) {
        kotlin.jvm.internal.m.g(viewCellState, "viewCellState");
        s<Optional<Transaction>> observable = this.a.getTxById(viewCellState.getTx().getId()).toObservable();
        kotlin.jvm.internal.m.f(observable, "txHistoryRepository\n        .getTxById(viewCellState.tx.id)\n        .toObservable()");
        s<R> map = observable.filter(c.a).map(d.a);
        kotlin.jvm.internal.m.f(map, "this\n    .filter { it.toNullable() != null }\n    .map { it.toNullable() }");
        s<TxHistoryDetailFragment.Args> map2 = map.flatMap(new h.c.m0.n() { // from class: com.toshi.view.fragment.coin.b
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return m.v(m.this, (Transaction) obj);
            }
        }).map(new h.c.m0.n() { // from class: com.toshi.view.fragment.coin.a
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return m.u(m.this, viewCellState, (kotlin.o) obj);
            }
        });
        kotlin.jvm.internal.m.f(map2, "txHistoryRepository\n        .getTxById(viewCellState.tx.id)\n        .toObservable()\n        .unwrap()\n        .flatMap { tx ->\n            if (tx.feeCurrencyCode == tx.currencyCode) {\n                Observable.just(wallet).map { tx to it }\n            } else {\n                walletRepository.observeWallet(tx.blockchain, tx.feeCurrencyCode).unwrap().map { tx to it }\n            }\n        }\n        .map { (tx, feeWallet) ->\n            TxHistoryDetailFragment.Args(\n                tx = tx,\n                blockchain = wallet.blockchain,\n                walletDecimals = wallet.decimals,\n                walletImageUrl = wallet.imageURL,\n                feeDecimals = feeWallet.decimals,\n                feeWalletImageUrl = feeWallet.imageURL,\n                displayName = viewCellState.displayName,\n                displayAddress = viewCellState.displayAddress,\n                recipientType = viewCellState.recipientType\n            )\n        }");
        return map2;
    }

    @Override // androidx.lifecycle.b0
    public void onCleared() {
        super.onCleared();
        this.f11318h.d();
    }

    public final s<p> r() {
        if (!this.a.canShowFullHistory(getWallet().getBlockchain())) {
            s<p> just = s.just(p.SendOnly);
            kotlin.jvm.internal.m.f(just, "just(WalletHistoryType.SendOnly)");
            return just;
        }
        s map = this.a.hasSyncedHistoryObservable(getWallet().getBlockchain(), getWallet().getCurrencyCode(), getWallet().getPrimaryAddress(), getWallet().getNetwork()).map(new h.c.m0.n() { // from class: com.toshi.view.fragment.coin.f
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return m.z((Boolean) obj);
            }
        });
        kotlin.jvm.internal.m.f(map, "txHistoryRepository\n            .hasSyncedHistoryObservable(\n                wallet.blockchain,\n                wallet.currencyCode,\n                wallet.primaryAddress,\n                wallet.network\n            )\n            .map {\n                if (it) WalletHistoryType.All else WalletHistoryType.Loading\n            }");
        return map;
    }

    public final void setWallet(Wallet wallet) {
        kotlin.jvm.internal.m.g(wallet, "<set-?>");
        this.q = wallet;
    }

    public final s<Boolean> t() {
        return this.f11313c.isSynced(getWallet().getBlockchain(), getWallet().getNetwork());
    }
}