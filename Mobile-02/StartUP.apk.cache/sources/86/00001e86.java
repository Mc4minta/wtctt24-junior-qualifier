package com.coinbase.wallet.features.lend.viewmodels;

import com.coinbase.ApiConstants;
import com.coinbase.wallet.analytics.Analytics;
import com.coinbase.wallet.analytics.extensions.Single_AnalyticsKt;
import com.coinbase.wallet.analytics.models.AnalyticsEvent;
import com.coinbase.wallet.application.extensions.AnalyticsEvent_ApplicationKt;
import com.coinbase.wallet.blockchains.models.Blockchain;
import com.coinbase.wallet.blockchains.models.CurrencyCode;
import com.coinbase.wallet.blockchains.models.Network;
import com.coinbase.wallet.blockchains.models.Wallet;
import com.coinbase.wallet.common.utilities.LocalizedStrings;
import com.coinbase.wallet.commonui.models.ActionStyle;
import com.coinbase.wallet.commonui.models.ViewModelNavRoute;
import com.coinbase.wallet.commonui.utilities.ActionSheetDialogHelper;
import com.coinbase.wallet.commonui.viewmodels.ViewModelWithArgs;
import com.coinbase.wallet.consumer.models.ConsumerConnectionStatus;
import com.coinbase.wallet.consumer.repositories.ConsumerUserRepository;
import com.coinbase.wallet.core.extensions.Observable_CoreKt;
import com.coinbase.wallet.core.extensions.Strings;
import com.coinbase.wallet.core.extensions.Strings_CoreKt;
import com.coinbase.wallet.ethereum.extensions.Blockchain_EthereumKt;
import com.coinbase.wallet.ethereum.extensions.WalletConfiguration_EthereumKt;
import com.coinbase.wallet.ethereum.models.ContractAction;
import com.coinbase.wallet.ethereum.models.ContractAddress;
import com.coinbase.wallet.ethereum.models.EthereumBasedConfiguration;
import com.coinbase.wallet.featureflags.models.FeatureFlag;
import com.coinbase.wallet.featureflags.repositories.FeatureFlagsRepository;
import com.coinbase.wallet.features.lend.interfaces.LendWalletMapping;
import com.coinbase.wallet.features.lend.models.LendCoinPickerItem;
import com.coinbase.wallet.features.lend.models.LendCoinPickerState;
import com.coinbase.wallet.features.lend.models.LendProviderPickerArgs;
import com.coinbase.wallet.lending.interfaces.ILendRepository;
import com.coinbase.wallet.lending.models.LendToken;
import com.coinbase.wallet.wallets.formatters.CurrencyFormatter;
import com.coinbase.wallet.wallets.interfaces.IWalletRepository;
import h.c.a0;
import h.c.b0;
import h.c.s;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.a0.r;
import kotlin.a0.z;
import kotlin.t;
import kotlin.x;
import org.toshi.R;

/* compiled from: LendCoinPickerViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u009e\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B1\b\u0007\u0012\u0006\u0010G\u001a\u00020F\u0012\u0006\u0010I\u001a\u00020H\u0012\u0006\u00102\u001a\u000201\u0012\u0006\u0010\u0017\u001a\u00020\u0016\u0012\u0006\u0010K\u001a\u00020J¢\u0006\u0004\bL\u0010MJ'\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0002¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\rH\u0014¢\u0006\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u00128\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0017\u001a\u00020\u00168\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R*\u0010\u001a\u001a\u00020\u00132\u0006\u0010\u0019\u001a\u00020\u00138\u0006@BX\u0086\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001c\u0010\"\u001a\b\u0012\u0004\u0012\u00020!0 8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\"\u0010#R\u0016\u0010%\u001a\u00020$8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b%\u0010&R\u001f\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00130'8\u0006@\u0006¢\u0006\f\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+R(\u0010-\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00070,8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b-\u0010.\u001a\u0004\b/\u00100R\u0016\u00102\u001a\u0002018\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b2\u00103R\u001f\u00105\u001a\b\u0012\u0004\u0012\u0002040'8\u0006@\u0006¢\u0006\f\n\u0004\b5\u0010)\u001a\u0004\b6\u0010+R\u001c\u00107\u001a\b\u0012\u0004\u0012\u0002040 8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b7\u0010#R\u001f\u00108\u001a\b\u0012\u0004\u0012\u00020!0'8\u0006@\u0006¢\u0006\f\n\u0004\b8\u0010)\u001a\u0004\b9\u0010+R\u001d\u0010?\u001a\u00020:8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b;\u0010<\u001a\u0004\b=\u0010>R%\u0010E\u001a\n A*\u0004\u0018\u00010@0@8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\bB\u0010<\u001a\u0004\bC\u0010D¨\u0006N"}, d2 = {"Lcom/coinbase/wallet/features/lend/viewmodels/LendCoinPickerViewModel;", "Lcom/coinbase/wallet/commonui/viewmodels/ViewModelWithArgs;", "Lcom/coinbase/wallet/features/lend/interfaces/LendWalletMapping;", "", "isSwapEnabled", "Lcom/coinbase/wallet/blockchains/models/Wallet;", "wallet", "", "Lcom/coinbase/wallet/commonui/utilities/ActionSheetDialogHelper$Action;", "fundActions", "(ZLcom/coinbase/wallet/blockchains/models/Wallet;)Ljava/util/List;", "Lcom/coinbase/wallet/features/lend/models/LendCoinPickerItem;", "item", "Lkotlin/x;", "onItemClicked", "(Lcom/coinbase/wallet/features/lend/models/LendCoinPickerItem;)V", "onCleared", "()V", "Lh/c/v0/a;", "Lcom/coinbase/wallet/features/lend/models/LendCoinPickerState;", "stateSubject", "Lh/c/v0/a;", "Lcom/coinbase/wallet/consumer/repositories/ConsumerUserRepository;", "consumerUserRepository", "Lcom/coinbase/wallet/consumer/repositories/ConsumerUserRepository;", "value", ApiConstants.STATE, "Lcom/coinbase/wallet/features/lend/models/LendCoinPickerState;", "getState", "()Lcom/coinbase/wallet/features/lend/models/LendCoinPickerState;", "setState", "(Lcom/coinbase/wallet/features/lend/models/LendCoinPickerState;)V", "Lh/c/v0/b;", "Lcom/coinbase/wallet/commonui/utilities/ActionSheetDialogHelper$Properties;", "actionSheetSubject", "Lh/c/v0/b;", "Lh/c/k0/a;", "disposeBag", "Lh/c/k0/a;", "Lh/c/s;", "stateObservable", "Lh/c/s;", "getStateObservable", "()Lh/c/s;", "Lh/c/b0;", "walletsSingle", "Lh/c/b0;", "getWalletsSingle", "()Lh/c/b0;", "Lcom/coinbase/wallet/featureflags/repositories/FeatureFlagsRepository;", "featureFlagsRepository", "Lcom/coinbase/wallet/featureflags/repositories/FeatureFlagsRepository;", "Lcom/coinbase/wallet/commonui/models/ViewModelNavRoute;", "navigationObservable", "getNavigationObservable", "navigationSubject", "actionSheetObservable", "getActionSheetObservable", "Lcom/coinbase/wallet/ethereum/models/ContractAction;", "contractAction$delegate", "Lkotlin/h;", "getContractAction", "()Lcom/coinbase/wallet/ethereum/models/ContractAction;", "contractAction", "Lh/c/a0;", "kotlin.jvm.PlatformType", "mainScheduler$delegate", "getMainScheduler", "()Lh/c/a0;", "mainScheduler", "Lcom/coinbase/wallet/wallets/interfaces/IWalletRepository;", "walletRepository", "Lcom/coinbase/wallet/lending/interfaces/ILendRepository;", "lendRepository", "Lcom/coinbase/wallet/wallets/formatters/CurrencyFormatter;", "currencyFormatter", "<init>", "(Lcom/coinbase/wallet/wallets/interfaces/IWalletRepository;Lcom/coinbase/wallet/lending/interfaces/ILendRepository;Lcom/coinbase/wallet/featureflags/repositories/FeatureFlagsRepository;Lcom/coinbase/wallet/consumer/repositories/ConsumerUserRepository;Lcom/coinbase/wallet/wallets/formatters/CurrencyFormatter;)V", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class LendCoinPickerViewModel extends ViewModelWithArgs implements LendWalletMapping {
    private final s<ActionSheetDialogHelper.Properties> actionSheetObservable;
    private final h.c.v0.b<ActionSheetDialogHelper.Properties> actionSheetSubject;
    private final ConsumerUserRepository consumerUserRepository;
    private final kotlin.h contractAction$delegate;
    private final h.c.k0.a disposeBag;
    private final FeatureFlagsRepository featureFlagsRepository;
    private final kotlin.h mainScheduler$delegate;
    private final s<ViewModelNavRoute> navigationObservable;
    private final h.c.v0.b<ViewModelNavRoute> navigationSubject;
    private LendCoinPickerState state;
    private final s<LendCoinPickerState> stateObservable;
    private final h.c.v0.a<LendCoinPickerState> stateSubject;
    private final b0<List<Wallet>> walletsSingle;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: LendCoinPickerViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\n\u001a\u00020\t2³\u0001\u0010\b\u001a®\u0001\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u0002 \u0003*\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00010\u0001\u0012(\u0012&\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0012\u0004\u0012\u00020\u0006 \u0003*\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00040\u0004\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00070\u0007 \u0003*V\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u0002 \u0003*\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00010\u0001\u0012(\u0012&\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0012\u0004\u0012\u00020\u0006 \u0003*\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00040\u0004\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00070\u0007\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\n\u0010\u000b"}, d2 = {"Lkotlin/t;", "", "Lcom/coinbase/wallet/lending/models/LendToken;", "kotlin.jvm.PlatformType", "", "Lcom/coinbase/wallet/ethereum/models/ContractAddress;", "Lcom/coinbase/wallet/blockchains/models/Wallet;", "Lcom/coinbase/wallet/blockchains/models/Network;", "<name for destructuring parameter 0>", "Lkotlin/x;", "<anonymous>", "(Lkotlin/t;)V"}, k = 3, mv = {1, 5, 1})
    /* renamed from: com.coinbase.wallet.features.lend.viewmodels.LendCoinPickerViewModel$1 */
    /* loaded from: classes.dex */
    public static final class AnonymousClass1 extends kotlin.jvm.internal.o implements kotlin.e0.c.l<t<? extends List<? extends LendToken>, ? extends Map<ContractAddress, ? extends Wallet>, ? extends Network>, x> {
        final /* synthetic */ CurrencyFormatter $currencyFormatter;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(CurrencyFormatter currencyFormatter) {
            super(1);
            LendCoinPickerViewModel.this = r1;
            this.$currencyFormatter = currencyFormatter;
        }

        @Override // kotlin.e0.c.l
        public /* bridge */ /* synthetic */ x invoke(t<? extends List<? extends LendToken>, ? extends Map<ContractAddress, ? extends Wallet>, ? extends Network> tVar) {
            invoke2((t<? extends List<LendToken>, ? extends Map<ContractAddress, Wallet>, Network>) tVar);
            return x.a;
        }

        /* renamed from: invoke */
        public final void invoke2(t<? extends List<LendToken>, ? extends Map<ContractAddress, Wallet>, Network> tVar) {
            int r;
            int r2;
            List<LendCoinPickerItem> B0;
            List<LendToken> tokens = tVar.a();
            Map<ContractAddress, Wallet> b2 = tVar.b();
            Network network = tVar.c();
            kotlin.jvm.internal.m.f(tokens, "tokens");
            HashSet hashSet = new HashSet();
            ArrayList<LendToken> arrayList = new ArrayList();
            for (Object obj : tokens) {
                if (hashSet.add(((LendToken) obj).getCurrencyCode().getCode())) {
                    arrayList.add(obj);
                }
            }
            r = kotlin.a0.s.r(arrayList, 10);
            ArrayList<CurrencyCode> arrayList2 = new ArrayList(r);
            for (LendToken lendToken : arrayList) {
                arrayList2.add(lendToken.getCurrencyCode());
            }
            CurrencyFormatter currencyFormatter = this.$currencyFormatter;
            r2 = kotlin.a0.s.r(arrayList2, 10);
            ArrayList arrayList3 = new ArrayList(r2);
            for (CurrencyCode currencyCode : arrayList2) {
                ArrayList arrayList4 = new ArrayList();
                for (Object obj2 : tokens) {
                    if (kotlin.jvm.internal.m.c(((LendToken) obj2).getCurrencyCode(), currencyCode)) {
                        arrayList4.add(obj2);
                    }
                }
                LendToken lendToken2 = (LendToken) kotlin.a0.p.a0(arrayList4);
                ContractAddress contractAddress = null;
                ContractAddress contractAddress2 = lendToken2 == null ? null : lendToken2.getContractAddress();
                EthereumBasedConfiguration eth = WalletConfiguration_EthereumKt.getETH(EthereumBasedConfiguration.Companion);
                kotlin.jvm.internal.m.f(network, "network");
                if (!kotlin.jvm.internal.m.c(currencyCode, eth.currencyCodeForNetwork(network))) {
                    contractAddress = contractAddress2;
                }
                arrayList3.add(new LendCoinPickerItem(b2.get(contractAddress), arrayList4, currencyFormatter));
            }
            LendCoinPickerViewModel lendCoinPickerViewModel = LendCoinPickerViewModel.this;
            LendCoinPickerState state = lendCoinPickerViewModel.getState();
            B0 = z.B0(arrayList3, new Comparator<T>() { // from class: com.coinbase.wallet.features.lend.viewmodels.LendCoinPickerViewModel$1$invoke$$inlined$sortedByDescending$1
                @Override // java.util.Comparator
                public final int compare(T t, T t2) {
                    int c2;
                    c2 = kotlin.b0.b.c(((LendCoinPickerItem) t2).getMaxRate(), ((LendCoinPickerItem) t).getMaxRate());
                    return c2;
                }
            });
            lendCoinPickerViewModel.setState(state.copy(B0, false));
        }
    }

    public LendCoinPickerViewModel(IWalletRepository walletRepository, ILendRepository lendRepository, FeatureFlagsRepository featureFlagsRepository, ConsumerUserRepository consumerUserRepository, CurrencyFormatter currencyFormatter) {
        kotlin.h b2;
        kotlin.h b3;
        kotlin.jvm.internal.m.g(walletRepository, "walletRepository");
        kotlin.jvm.internal.m.g(lendRepository, "lendRepository");
        kotlin.jvm.internal.m.g(featureFlagsRepository, "featureFlagsRepository");
        kotlin.jvm.internal.m.g(consumerUserRepository, "consumerUserRepository");
        kotlin.jvm.internal.m.g(currencyFormatter, "currencyFormatter");
        this.featureFlagsRepository = featureFlagsRepository;
        this.consumerUserRepository = consumerUserRepository;
        b2 = kotlin.k.b(new LendCoinPickerViewModel$contractAction$2(this));
        this.contractAction$delegate = b2;
        h.c.k0.a aVar = new h.c.k0.a();
        this.disposeBag = aVar;
        b3 = kotlin.k.b(LendCoinPickerViewModel$mainScheduler$2.INSTANCE);
        this.mainScheduler$delegate = b3;
        h.c.v0.a<LendCoinPickerState> d2 = h.c.v0.a.d();
        kotlin.jvm.internal.m.f(d2, "create()");
        this.stateSubject = d2;
        h.c.v0.b<ViewModelNavRoute> d3 = h.c.v0.b.d();
        kotlin.jvm.internal.m.f(d3, "create()");
        this.navigationSubject = d3;
        h.c.v0.b<ActionSheetDialogHelper.Properties> d4 = h.c.v0.b.d();
        kotlin.jvm.internal.m.f(d4, "create()");
        this.actionSheetSubject = d4;
        b0<List<Wallet>> map = Observable_CoreKt.takeSingle(walletRepository.observeWallets(false)).map(new h.c.m0.n() { // from class: com.coinbase.wallet.features.lend.viewmodels.b
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return LendCoinPickerViewModel.a((List) obj);
            }
        });
        kotlin.jvm.internal.m.f(map, "walletRepository.observeWallets(onlyUsable = false)\n        .takeSingle()\n        .map { wallets -> wallets.filter { it.blockchain == Blockchain.ETHEREUM } }");
        this.walletsSingle = map;
        s<LendCoinPickerState> hide = d2.hide();
        kotlin.jvm.internal.m.f(hide, "stateSubject.hide()");
        this.stateObservable = hide;
        s<ViewModelNavRoute> hide2 = d3.hide();
        kotlin.jvm.internal.m.f(hide2, "navigationSubject.hide()");
        this.navigationObservable = hide2;
        s<ActionSheetDialogHelper.Properties> hide3 = d4.hide();
        kotlin.jvm.internal.m.f(hide3, "actionSheetSubject.hide()");
        this.actionSheetObservable = hide3;
        this.state = new LendCoinPickerState(null, false, 3, null);
        b0 observeOn = Single_AnalyticsKt.logError$default(h.c.t0.e.a.b(Observable_CoreKt.takeSingle(lendRepository.observeTokens()), getWalletMapSingle(), Observable_CoreKt.takeSingle(walletRepository.observeNetwork(Blockchain_EthereumKt.getETHEREUM(Blockchain.Companion)))), null, null, 3, null).observeOn(getMainScheduler());
        kotlin.jvm.internal.m.f(observeOn, "Singles.zip(\n            lendRepository.observeTokens().takeSingle(),\n            walletMapSingle,\n            walletRepository.observeNetwork(Blockchain.ETHEREUM).takeSingle()\n        )\n            .logError()\n            .observeOn(mainScheduler)");
        h.c.t0.a.a(h.c.t0.g.i(observeOn, null, new AnonymousClass1(currencyFormatter), 1, null), aVar);
    }

    public static /* synthetic */ List a(List list) {
        return m1274walletsSingle$lambda1(list);
    }

    public final List<ActionSheetDialogHelper.Action> fundActions(boolean z, Wallet wallet) {
        String str;
        List<ActionSheetDialogHelper.Action> m;
        ConsumerConnectionStatus connectStatus = this.consumerUserRepository.getConnectStatus();
        if (connectStatus.getOnrampEnabled()) {
            str = LocalizedStrings.INSTANCE.get(R.string.fund_action_transfer_from_coinbase_onramp);
        } else {
            str = LocalizedStrings.INSTANCE.get(R.string.fund_action_transfer_from_coinbase);
        }
        LocalizedStrings localizedStrings = LocalizedStrings.INSTANCE;
        String str2 = localizedStrings.get(R.string.fund_action_transfer_from_elsewhere);
        ActionStyle actionStyle = ActionStyle.NEUTRAL;
        m = r.m(new ActionSheetDialogHelper.Action(str, actionStyle, new LendCoinPickerViewModel$fundActions$actions$1(wallet, connectStatus, this)), new ActionSheetDialogHelper.Action(str2, actionStyle, new LendCoinPickerViewModel$fundActions$actions$2(this)));
        if (z) {
            Object[] objArr = new Object[1];
            String displayName = wallet == null ? null : wallet.getDisplayName();
            if (displayName == null) {
                displayName = Strings_CoreKt.getEmpty(Strings.INSTANCE);
            }
            objArr[0] = displayName;
            m.add(new ActionSheetDialogHelper.Action(localizedStrings.get(R.string.wallet_detail_convert_token_action, objArr), actionStyle, new LendCoinPickerViewModel$fundActions$1(this)));
        }
        return m;
    }

    private final ContractAction getContractAction() {
        return (ContractAction) this.contractAction$delegate.getValue();
    }

    private final a0 getMainScheduler() {
        return (a0) this.mainScheduler$delegate.getValue();
    }

    public final void setState(LendCoinPickerState lendCoinPickerState) {
        this.state = lendCoinPickerState;
        this.stateSubject.onNext(lendCoinPickerState);
    }

    /* renamed from: walletsSingle$lambda-1 */
    public static final List m1274walletsSingle$lambda1(List wallets) {
        kotlin.jvm.internal.m.g(wallets, "wallets");
        ArrayList arrayList = new ArrayList();
        for (Object obj : wallets) {
            if (kotlin.jvm.internal.m.c(((Wallet) obj).getBlockchain(), Blockchain_EthereumKt.getETHEREUM(Blockchain.Companion))) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    public final s<ActionSheetDialogHelper.Properties> getActionSheetObservable() {
        return this.actionSheetObservable;
    }

    public final s<ViewModelNavRoute> getNavigationObservable() {
        return this.navigationObservable;
    }

    public final LendCoinPickerState getState() {
        return this.state;
    }

    public final s<LendCoinPickerState> getStateObservable() {
        return this.stateObservable;
    }

    @Override // com.coinbase.wallet.features.lend.interfaces.LendWalletMapping
    public b0<Map<ContractAddress, Wallet>> getWalletMapSingle() {
        return LendWalletMapping.DefaultImpls.getWalletMapSingle(this);
    }

    @Override // com.coinbase.wallet.features.lend.interfaces.LendWalletMapping
    public b0<List<Wallet>> getWalletsSingle() {
        return this.walletsSingle;
    }

    @Override // androidx.lifecycle.b0
    public void onCleared() {
        super.onCleared();
        this.disposeBag.d();
    }

    public final void onItemClicked(LendCoinPickerItem item) {
        kotlin.jvm.internal.m.g(item, "item");
        if (item.getWallet() != null && item.getWallet().getBalance().compareTo(BigInteger.ZERO) > 0) {
            this.navigationSubject.onNext(new ViewModelNavRoute(R.id.action_lendCoinPickerFragment_to_lendProviderPickerFragment, LendProviderPickerArgs.INSTANCE.createArguments(item.getWallet(), item.getTokens(), getContractAction()), null, 4, null));
            return;
        }
        Analytics.INSTANCE.log(AnalyticsEvent_ApplicationKt.lendCoinPickerTransferSheetStart(AnalyticsEvent.Companion));
        b0 observeOn = FeatureFlagsRepository.value$default(this.featureFlagsRepository, FeatureFlag.NATIVE_DEX, false, 0L, 6, null).observeOn(h.c.j0.c.a.b());
        kotlin.jvm.internal.m.f(observeOn, "featureFlagsRepository.value(FeatureFlag.NATIVE_DEX)\n                .observeOn(AndroidSchedulers.mainThread())");
        h.c.t0.a.a(h.c.t0.g.i(observeOn, null, new LendCoinPickerViewModel$onItemClicked$1(this, item), 1, null), this.disposeBag);
    }
}