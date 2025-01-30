package com.coinbase.wallet.features.swap.viewmodels;

import com.coinbase.ApiConstants;
import com.coinbase.ciphercore.ethereum.EthereumChain;
import com.coinbase.wallet.analytics.Analytics;
import com.coinbase.wallet.analytics.extensions.Observable_AnalyticsKt;
import com.coinbase.wallet.analytics.models.AnalyticsEvent;
import com.coinbase.wallet.application.extensions.AnalyticsEvent_ApplicationKt;
import com.coinbase.wallet.blockchains.models.Blockchain;
import com.coinbase.wallet.blockchains.models.CurrencyCode;
import com.coinbase.wallet.blockchains.models.Wallet;
import com.coinbase.wallet.common.extensions.SavedStateHandle_CommonKt;
import com.coinbase.wallet.common.utilities.LocalizedStrings;
import com.coinbase.wallet.commonui.models.ActionStyle;
import com.coinbase.wallet.commonui.utilities.PromptDialogHelper;
import com.coinbase.wallet.core.extensions.Observable_CoreKt;
import com.coinbase.wallet.core.extensions.Strings;
import com.coinbase.wallet.core.extensions.Strings_CoreKt;
import com.coinbase.wallet.ethereum.extensions.Blockchain_EthereumKt;
import com.coinbase.wallet.ethereum.extensions.Network_EthereumKt;
import com.coinbase.wallet.ethereum.extensions.WalletConfiguration_EthereumKt;
import com.coinbase.wallet.ethereum.models.ContractAddress;
import com.coinbase.wallet.ethereum.models.EthereumBasedConfiguration;
import com.coinbase.wallet.features.swap.models.SwapAssetPickerEvent;
import com.coinbase.wallet.features.swap.models.SwapAssetPickerItem;
import com.coinbase.wallet.features.swap.models.SwapAssetPickerViewState;
import com.coinbase.wallet.features.swap.models.SwapAssetType;
import com.coinbase.wallet.features.swap.prompts.UnsupportedSwapAssetPrompt;
import com.coinbase.wallet.swap.interfaces.ISwapRepository;
import com.coinbase.wallet.swap.models.Aggregator;
import com.coinbase.wallet.swap.models.AmountBase;
import com.coinbase.wallet.swap.models.SwapAsset;
import com.coinbase.wallet.swap.models.SwapAssetStats;
import com.coinbase.wallet.wallets.formatters.CurrencyFormatter;
import com.coinbase.wallet.wallets.interfaces.IWalletRepository;
import java.math.BigInteger;
import java.net.URL;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import org.toshi.R;

/* compiled from: SwapAssetPickerViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u009a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001`B3\b\u0007\u0012\u0006\u0010]\u001a\u00020\\\u0012\u0006\u0010Z\u001a\u00020Y\u0012\u0006\u0010W\u001a\u00020V\u0012\u0006\u0010<\u001a\u00020;\u0012\b\b\u0001\u00104\u001a\u000203¢\u0006\u0004\b^\u0010_J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0007\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\b\u0010\tJ#\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r0\f2\u0006\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u001b\u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\r0\fH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u001b\u0010\u0014\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r0\u0013H\u0002¢\u0006\u0004\b\u0014\u0010\u0015J1\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00180\r2\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ\u0013\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00040\f¢\u0006\u0004\b\u001b\u0010\u0012J\u0015\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u000e¢\u0006\u0004\b\u001d\u0010\u001eJ\u000f\u0010\u001f\u001a\u00020\u0004H\u0014¢\u0006\u0004\b\u001f\u0010\tR\"\u0010!\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00180\r0 8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b!\u0010\"R\u001f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00040\f8\u0006@\u0006¢\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b%\u0010\u0012R\u0016\u0010'\u001a\u00020&8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b'\u0010(R0\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00180\r2\f\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00180\r8\u0002@BX\u0082\u000e¢\u0006\f\n\u0004\b*\u0010+\"\u0004\b,\u0010-R(\u00101\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u000200\u0012\u0004\u0012\u00020\u00020/0.8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b1\u00102R\u0019\u00104\u001a\u0002038\u0006@\u0006¢\u0006\f\n\u0004\b4\u00105\u001a\u0004\b6\u00107R\u001c\u00108\u001a\b\u0012\u0004\u0012\u0002000 8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b8\u0010\"R\u001c\u0010:\u001a\b\u0012\u0004\u0012\u0002090 8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b:\u0010\"R\u0016\u0010<\u001a\u00020;8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b<\u0010=R\u001c\u0010?\u001a\b\u0012\u0004\u0012\u00020>0.8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b?\u00102R\u0016\u0010\u000b\u001a\u00020\n8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010@R%\u0010A\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00180\r0\f8\u0006@\u0006¢\u0006\f\n\u0004\bA\u0010$\u001a\u0004\bB\u0010\u0012R*\u0010C\u001a\u0002002\u0006\u0010)\u001a\u0002008\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\bC\u0010D\u001a\u0004\bE\u0010F\"\u0004\bG\u0010HR\u001f\u0010I\u001a\b\u0012\u0004\u0012\u00020>0\f8\u0006@\u0006¢\u0006\f\n\u0004\bI\u0010$\u001a\u0004\bJ\u0010\u0012R\u001f\u0010K\u001a\b\u0012\u0004\u0012\u0002090\f8\u0006@\u0006¢\u0006\f\n\u0004\bK\u0010$\u001a\u0004\bL\u0010\u0012R+\u0010M\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u000200\u0012\u0004\u0012\u00020\u00020/0\f8\u0006@\u0006¢\u0006\f\n\u0004\bM\u0010$\u001a\u0004\bN\u0010\u0012R$\u0010O\u001a\u0002092\u0006\u0010)\u001a\u0002098\u0002@BX\u0082\u000e¢\u0006\f\n\u0004\bO\u0010P\"\u0004\bQ\u0010RR\"\u0010T\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020S0\r0\u00138\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bT\u0010UR\u0016\u0010W\u001a\u00020V8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bW\u0010XR\u0016\u0010Z\u001a\u00020Y8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bZ\u0010[¨\u0006a"}, d2 = {"Lcom/coinbase/wallet/features/swap/viewmodels/SwapAssetPickerViewModel;", "Landroidx/lifecycle/b0;", "Lcom/coinbase/wallet/swap/models/SwapAsset;", "swapAsset", "Lkotlin/x;", "selectAsset", "(Lcom/coinbase/wallet/swap/models/SwapAsset;)V", "presentUnsupportedPrompt", "presentNonConvertiblePrompt", "()V", "Lcom/coinbase/wallet/swap/models/AmountBase;", "amountBase", "Lh/c/s;", "", "Lcom/coinbase/wallet/features/swap/models/SwapAssetPickerItem$SwapAssetItem;", "getConvertibleAssets", "(Lcom/coinbase/wallet/swap/models/AmountBase;)Lh/c/s;", "getSortedSwapAssets", "()Lh/c/s;", "Lh/c/b0;", "getNonConvertibleAssets", "()Lh/c/b0;", "convertibleAssets", "nonConvertibleAssets", "Lcom/coinbase/wallet/features/swap/models/SwapAssetPickerItem;", "buildItemList", "(Ljava/util/List;Ljava/util/List;)Ljava/util/List;", "setup", "item", "onAssetSelected", "(Lcom/coinbase/wallet/features/swap/models/SwapAssetPickerItem$SwapAssetItem;)V", "onCleared", "Lh/c/v0/a;", "dataSubject", "Lh/c/v0/a;", "dismissObservable", "Lh/c/s;", "getDismissObservable", "Lh/c/k0/a;", "disposeBag", "Lh/c/k0/a;", "value", "data", "Ljava/util/List;", "setData", "(Ljava/util/List;)V", "Lh/c/v0/b;", "Lkotlin/o;", "", "selectedAssetSubject", "Lh/c/v0/b;", "Landroidx/lifecycle/z;", "savedStateHandle", "Landroidx/lifecycle/z;", "getSavedStateHandle", "()Landroidx/lifecycle/z;", "searchSubject", "Lcom/coinbase/wallet/features/swap/models/SwapAssetPickerViewState;", "stateSubject", "Lcom/coinbase/wallet/features/swap/prompts/UnsupportedSwapAssetPrompt;", "unsupportedSwapAssetPrompt", "Lcom/coinbase/wallet/features/swap/prompts/UnsupportedSwapAssetPrompt;", "Lcom/coinbase/wallet/features/swap/models/SwapAssetPickerEvent;", "eventSubject", "Lcom/coinbase/wallet/swap/models/AmountBase;", "dataObservable", "getDataObservable", "query", "Ljava/lang/String;", "getQuery", "()Ljava/lang/String;", "setQuery", "(Ljava/lang/String;)V", "eventObservable", "getEventObservable", "stateObservable", "getStateObservable", "selectedAssetObservable", "getSelectedAssetObservable", ApiConstants.STATE, "Lcom/coinbase/wallet/features/swap/models/SwapAssetPickerViewState;", "setState", "(Lcom/coinbase/wallet/features/swap/models/SwapAssetPickerViewState;)V", "Lcom/coinbase/wallet/blockchains/models/Wallet;", "walletsSingle", "Lh/c/b0;", "Lcom/coinbase/wallet/wallets/formatters/CurrencyFormatter;", "currencyFormatter", "Lcom/coinbase/wallet/wallets/formatters/CurrencyFormatter;", "Lcom/coinbase/wallet/swap/interfaces/ISwapRepository;", "swapRepository", "Lcom/coinbase/wallet/swap/interfaces/ISwapRepository;", "Lcom/coinbase/wallet/wallets/interfaces/IWalletRepository;", "walletRepository", "<init>", "(Lcom/coinbase/wallet/wallets/interfaces/IWalletRepository;Lcom/coinbase/wallet/swap/interfaces/ISwapRepository;Lcom/coinbase/wallet/wallets/formatters/CurrencyFormatter;Lcom/coinbase/wallet/features/swap/prompts/UnsupportedSwapAssetPrompt;Landroidx/lifecycle/z;)V", "Factory", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class SwapAssetPickerViewModel extends androidx.lifecycle.b0 {
    private final AmountBase amountBase;
    private final CurrencyFormatter currencyFormatter;
    private List<? extends SwapAssetPickerItem> data;
    private final h.c.s<List<SwapAssetPickerItem>> dataObservable;
    private final h.c.v0.a<List<SwapAssetPickerItem>> dataSubject;
    private final h.c.s<kotlin.x> dismissObservable;
    private final h.c.k0.a disposeBag;
    private final h.c.s<SwapAssetPickerEvent> eventObservable;
    private final h.c.v0.b<SwapAssetPickerEvent> eventSubject;
    private String query;
    private final androidx.lifecycle.z savedStateHandle;
    private final h.c.v0.a<String> searchSubject;
    private final h.c.s<kotlin.o<String, SwapAsset>> selectedAssetObservable;
    private final h.c.v0.b<kotlin.o<String, SwapAsset>> selectedAssetSubject;
    private SwapAssetPickerViewState state;
    private final h.c.s<SwapAssetPickerViewState> stateObservable;
    private final h.c.v0.a<SwapAssetPickerViewState> stateSubject;
    private final ISwapRepository swapRepository;
    private final UnsupportedSwapAssetPrompt unsupportedSwapAssetPrompt;
    private final h.c.b0<List<Wallet>> walletsSingle;

    /* compiled from: SwapAssetPickerViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/coinbase/wallet/features/swap/viewmodels/SwapAssetPickerViewModel$Factory;", "", "Landroidx/lifecycle/z;", "savedStateHandle", "Lcom/coinbase/wallet/features/swap/viewmodels/SwapAssetPickerViewModel;", "create", "(Landroidx/lifecycle/z;)Lcom/coinbase/wallet/features/swap/viewmodels/SwapAssetPickerViewModel;", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public interface Factory {
        SwapAssetPickerViewModel create(androidx.lifecycle.z zVar);
    }

    public SwapAssetPickerViewModel(IWalletRepository walletRepository, ISwapRepository swapRepository, CurrencyFormatter currencyFormatter, UnsupportedSwapAssetPrompt unsupportedSwapAssetPrompt, androidx.lifecycle.z savedStateHandle) {
        List<? extends SwapAssetPickerItem> g2;
        kotlin.jvm.internal.m.g(walletRepository, "walletRepository");
        kotlin.jvm.internal.m.g(swapRepository, "swapRepository");
        kotlin.jvm.internal.m.g(currencyFormatter, "currencyFormatter");
        kotlin.jvm.internal.m.g(unsupportedSwapAssetPrompt, "unsupportedSwapAssetPrompt");
        kotlin.jvm.internal.m.g(savedStateHandle, "savedStateHandle");
        this.swapRepository = swapRepository;
        this.currencyFormatter = currencyFormatter;
        this.unsupportedSwapAssetPrompt = unsupportedSwapAssetPrompt;
        this.savedStateHandle = savedStateHandle;
        h.c.v0.a<List<SwapAssetPickerItem>> d2 = h.c.v0.a.d();
        kotlin.jvm.internal.m.f(d2, "create()");
        this.dataSubject = d2;
        h.c.v0.a<SwapAssetPickerViewState> d3 = h.c.v0.a.d();
        kotlin.jvm.internal.m.f(d3, "create()");
        this.stateSubject = d3;
        h.c.v0.b<SwapAssetPickerEvent> d4 = h.c.v0.b.d();
        kotlin.jvm.internal.m.f(d4, "create()");
        this.eventSubject = d4;
        h.c.v0.b<kotlin.o<String, SwapAsset>> d5 = h.c.v0.b.d();
        kotlin.jvm.internal.m.f(d5, "create()");
        this.selectedAssetSubject = d5;
        h.c.v0.a<String> d6 = h.c.v0.a.d();
        kotlin.jvm.internal.m.f(d6, "create()");
        this.searchSubject = d6;
        this.disposeBag = new h.c.k0.a();
        this.amountBase = (AmountBase) SavedStateHandle_CommonKt.require(savedStateHandle, "amountBase");
        this.walletsSingle = Observable_CoreKt.takeSingle(IWalletRepository.DefaultImpls.observeWallets$default(walletRepository, false, 1, null));
        this.state = new SwapAssetPickerViewState(null, null, null, false, 15, null);
        g2 = kotlin.a0.r.g();
        this.data = g2;
        h.c.s<SwapAssetPickerViewState> hide = d3.hide();
        kotlin.jvm.internal.m.f(hide, "stateSubject.hide()");
        this.stateObservable = hide;
        h.c.s<List<SwapAssetPickerItem>> hide2 = d2.hide();
        kotlin.jvm.internal.m.f(hide2, "dataSubject.hide()");
        this.dataObservable = hide2;
        h.c.s<SwapAssetPickerEvent> hide3 = d4.hide();
        kotlin.jvm.internal.m.f(hide3, "eventSubject.hide()");
        this.eventObservable = hide3;
        h.c.s<kotlin.o<String, SwapAsset>> hide4 = d5.hide();
        kotlin.jvm.internal.m.f(hide4, "selectedAssetSubject.hide()");
        this.selectedAssetObservable = hide4;
        this.dismissObservable = unsupportedSwapAssetPrompt.getDismissObservable();
        this.query = Strings_CoreKt.getEmpty(Strings.INSTANCE);
    }

    public static /* synthetic */ void a(SwapAssetPickerViewModel swapAssetPickerViewModel, Throwable th) {
        m1481setup$lambda2(swapAssetPickerViewModel, th);
    }

    public static /* synthetic */ List b(SwapAssetPickerViewModel swapAssetPickerViewModel, kotlin.t tVar) {
        return m1479setup$lambda0(swapAssetPickerViewModel, tVar);
    }

    private final List<SwapAssetPickerItem> buildItemList(List<SwapAssetPickerItem.SwapAssetItem> list, List<SwapAssetPickerItem.SwapAssetItem> list2) {
        List<SwapAssetPickerItem> K0;
        K0 = kotlin.a0.z.K0(list);
        if (!list2.isEmpty()) {
            K0.add(new SwapAssetPickerItem.SectionHeader(LocalizedStrings.INSTANCE.get(R.string.swap_not_convertible_header)));
            K0.addAll(list2);
        }
        return K0;
    }

    public static /* synthetic */ kotlin.x c(SwapAssetPickerViewModel swapAssetPickerViewModel, List list) {
        return m1480setup$lambda1(swapAssetPickerViewModel, list);
    }

    public static /* synthetic */ Map d(List list) {
        return m1478getSortedSwapAssets$lambda10(list);
    }

    public static /* synthetic */ List e(List list) {
        return m1476getConvertibleAssets$lambda8(list);
    }

    public static /* synthetic */ List f(List list) {
        return m1477getNonConvertibleAssets$lambda15(list);
    }

    private final h.c.s<List<SwapAssetPickerItem.SwapAssetItem>> getConvertibleAssets(AmountBase amountBase) {
        if (amountBase instanceof AmountBase.Source) {
            h.c.t0.c cVar = h.c.t0.c.a;
            h.c.s<List<Wallet>> observable = this.walletsSingle.toObservable();
            kotlin.jvm.internal.m.f(observable, "walletsSingle.toObservable()");
            h.c.s<List<SwapAssetPickerItem.SwapAssetItem>> combineLatest = h.c.s.combineLatest(observable, getSortedSwapAssets(), new h.c.m0.c<T1, T2, R>() { // from class: com.coinbase.wallet.features.swap.viewmodels.SwapAssetPickerViewModel$getConvertibleAssets$$inlined$combineLatest$1
                /* JADX WARN: Type inference failed for: r2v3, types: [R, java.util.Collection, java.util.ArrayList] */
                @Override // h.c.m0.c
                public final R apply(T1 t1, T2 t2) {
                    CurrencyFormatter currencyFormatter;
                    String formatToFiat;
                    CurrencyFormatter currencyFormatter2;
                    SwapAssetType unsupported;
                    SwapAssetPickerItem.SwapAssetItem swapAssetItem;
                    List<SwapAsset> list = (List) t2;
                    List<Wallet> wallets = (List) t1;
                    kotlin.jvm.internal.m.f(wallets, "wallets");
                    LinkedHashMap linkedHashMap = new LinkedHashMap();
                    for (Wallet wallet : wallets) {
                        if (kotlin.jvm.internal.m.c(WalletConfiguration_EthereumKt.getETH(EthereumBasedConfiguration.Companion).currencyCodeForNetwork(wallet.getNetwork()), wallet.getCurrencyCode()) && wallet.getContractAddress() == null) {
                            linkedHashMap.put(null, wallet);
                        } else {
                            String contractAddress = wallet.getContractAddress();
                            if (contractAddress != null) {
                                linkedHashMap.put(new ContractAddress(contractAddress), wallet);
                            }
                        }
                    }
                    ?? r2 = (R) new ArrayList();
                    for (SwapAsset swapAsset : list) {
                        Wallet wallet2 = (Wallet) linkedHashMap.get(swapAsset.getContractAddress());
                        if (wallet2 != null && kotlin.jvm.internal.m.c(wallet2.getBlockchain(), Blockchain_EthereumKt.getETHEREUM(Blockchain.Companion)) && wallet2.getBalance().compareTo(BigInteger.ZERO) > 0) {
                            currencyFormatter = SwapAssetPickerViewModel.this.currencyFormatter;
                            CurrencyCode currencyCode = wallet2.getCurrencyCode();
                            String contractAddress2 = wallet2.getContractAddress();
                            int decimals = wallet2.getDecimals();
                            BigInteger balance = wallet2.getBalance();
                            EthereumChain asEthereumChain = Network_EthereumKt.getAsEthereumChain(wallet2.getNetwork());
                            formatToFiat = currencyFormatter.formatToFiat(currencyCode, contractAddress2, decimals, balance, (r17 & 16) != 0 ? false : false, (r17 & 32) != 0 ? null : null, (r17 & 64) != 0 ? null : asEthereumChain == null ? null : Integer.valueOf(asEthereumChain.getChainId()));
                            if (formatToFiat == null) {
                                formatToFiat = Strings_CoreKt.getEmpty(Strings.INSTANCE);
                            }
                            String str = formatToFiat;
                            currencyFormatter2 = SwapAssetPickerViewModel.this.currencyFormatter;
                            String formatToCrypto$default = CurrencyFormatter.formatToCrypto$default(currencyFormatter2, wallet2.getCurrencyCode(), wallet2.getDecimals(), wallet2.getBalance(), false, 0, 0, 48, (Object) null);
                            if (swapAsset.getSwappable()) {
                                unsupported = new SwapAssetType.Supported(swapAsset);
                            } else {
                                unsupported = new SwapAssetType.Unsupported(swapAsset);
                            }
                            SwapAssetType swapAssetType = unsupported;
                            String name = swapAsset.getName();
                            String code = swapAsset.getCurrencyCode().getCode();
                            URL imageURL = swapAsset.getImageURL();
                            swapAssetItem = new SwapAssetPickerItem.SwapAssetItem(swapAssetType, name, code, imageURL == null ? null : imageURL.toString(), str, formatToCrypto$default);
                        } else {
                            swapAssetItem = null;
                        }
                        if (swapAssetItem != null) {
                            r2.add(swapAssetItem);
                        }
                    }
                    return r2;
                }
            });
            kotlin.jvm.internal.m.f(combineLatest, "{\n                Observables\n                    .combineLatest(walletsSingle.toObservable(), getSortedSwapAssets()) { wallets, assets ->\n                        val walletMap = wallets.reduceIntoMap<ContractAddress?, Wallet, Wallet> { walletMap, wallet ->\n                            if (\n                                EthereumBasedConfiguration.ETH.currencyCodeForNetwork(wallet.network)\n                                == wallet.currencyCode &&\n                                wallet.contractAddress == null\n                            ) {\n                                walletMap[null] = wallet\n                            } else {\n                                wallet.contractAddress?.let { walletMap[ContractAddress(it)] = wallet }\n                            }\n                        }\n\n                        assets.mapNotNull { asset ->\n                            val wallet = walletMap[asset.contractAddress] ?: return@mapNotNull null\n                            if (wallet.blockchain != Blockchain.ETHEREUM) return@mapNotNull null\n                            if (wallet.balance <= BigInteger.ZERO) return@mapNotNull null\n\n                            val fiatBalance = currencyFormatter.formatToFiat(\n                                fromCurrencyCode = wallet.currencyCode,\n                                contractAddress = wallet.contractAddress,\n                                decimals = wallet.decimals,\n                                value = wallet.balance,\n                                chainId = wallet.network.asEthereumChain?.chainId\n                            ) ?: Strings.empty\n\n                            val cryptoBalance = currencyFormatter.formatToCrypto(\n                                currencyCode = wallet.currencyCode,\n                                decimals = wallet.decimals,\n                                value = wallet.balance,\n                                includeCode = false\n                            )\n\n                            val type = if (asset.swappable) {\n                                SwapAssetType.Supported(asset)\n                            } else {\n                                SwapAssetType.Unsupported(asset)\n                            }\n\n                            SwapAssetItem(\n                                type = type,\n                                name = asset.name,\n                                currencyCode = asset.currencyCode.code,\n                                imageURL = asset.imageURL?.toString(),\n                                cryptoBalance = cryptoBalance,\n                                fiatBalance = fiatBalance\n                            )\n                        }\n                    }\n            }");
            return combineLatest;
        } else if (amountBase instanceof AmountBase.Target) {
            h.c.s map = getSortedSwapAssets().map(new h.c.m0.n() { // from class: com.coinbase.wallet.features.swap.viewmodels.q
                @Override // h.c.m0.n
                public final Object apply(Object obj) {
                    return SwapAssetPickerViewModel.e((List) obj);
                }
            });
            kotlin.jvm.internal.m.f(map, "{\n                getSortedSwapAssets()\n                    .map { assets ->\n                        assets.map { asset ->\n                            val type = if (asset.swappable) {\n                                SwapAssetType.Supported(asset)\n                            } else {\n                                SwapAssetType.Unsupported(asset)\n                            }\n\n                            SwapAssetItem(\n                                type = type,\n                                name = asset.name,\n                                currencyCode = asset.currencyCode.code,\n                                imageURL = asset.imageURL?.toString()\n                            )\n                        }\n                    }\n            }");
            return map;
        } else {
            throw new NoWhenBranchMatchedException();
        }
    }

    /* renamed from: getConvertibleAssets$lambda-8 */
    public static final List m1476getConvertibleAssets$lambda8(List assets) {
        int r;
        SwapAssetType unsupported;
        kotlin.jvm.internal.m.g(assets, "assets");
        r = kotlin.a0.s.r(assets, 10);
        ArrayList arrayList = new ArrayList(r);
        Iterator it = assets.iterator();
        while (it.hasNext()) {
            SwapAsset swapAsset = (SwapAsset) it.next();
            if (swapAsset.getSwappable()) {
                unsupported = new SwapAssetType.Supported(swapAsset);
            } else {
                unsupported = new SwapAssetType.Unsupported(swapAsset);
            }
            SwapAssetType swapAssetType = unsupported;
            String name = swapAsset.getName();
            String code = swapAsset.getCurrencyCode().getCode();
            URL imageURL = swapAsset.getImageURL();
            arrayList.add(new SwapAssetPickerItem.SwapAssetItem(swapAssetType, name, code, imageURL == null ? null : imageURL.toString(), null, null, 48, null));
        }
        return arrayList;
    }

    private final h.c.b0<List<SwapAssetPickerItem.SwapAssetItem>> getNonConvertibleAssets() {
        h.c.b0 map = this.walletsSingle.map(new h.c.m0.n() { // from class: com.coinbase.wallet.features.swap.viewmodels.r
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return SwapAssetPickerViewModel.f((List) obj);
            }
        });
        kotlin.jvm.internal.m.f(map, "walletsSingle\n            .map { wallets ->\n                wallets\n                    .filter { wallet -> wallet.blockchain != Blockchain.ETHEREUM }\n                    .map { wallet ->\n                        SwapAssetItem(\n                            type = SwapAssetType.NonConvertible,\n                            name = wallet.displayName,\n                            currencyCode = wallet.currencyCode.code,\n                            imageURL = wallet.imageURL?.toString()\n                        )\n                    }\n            }");
        return map;
    }

    /* renamed from: getNonConvertibleAssets$lambda-15 */
    public static final List m1477getNonConvertibleAssets$lambda15(List wallets) {
        int r;
        kotlin.jvm.internal.m.g(wallets, "wallets");
        ArrayList<Wallet> arrayList = new ArrayList();
        for (Object obj : wallets) {
            if (!kotlin.jvm.internal.m.c(((Wallet) obj).getBlockchain(), Blockchain_EthereumKt.getETHEREUM(Blockchain.Companion))) {
                arrayList.add(obj);
            }
        }
        r = kotlin.a0.s.r(arrayList, 10);
        ArrayList arrayList2 = new ArrayList(r);
        for (Wallet wallet : arrayList) {
            SwapAssetType.NonConvertible nonConvertible = SwapAssetType.NonConvertible.INSTANCE;
            String displayName = wallet.getDisplayName();
            String code = wallet.getCurrencyCode().getCode();
            URL imageURL = wallet.getImageURL();
            arrayList2.add(new SwapAssetPickerItem.SwapAssetItem(nonConvertible, displayName, code, imageURL == null ? null : imageURL.toString(), null, null, 48, null));
        }
        return arrayList2;
    }

    private final h.c.s<List<SwapAsset>> getSortedSwapAssets() {
        h.c.b0<R> map = this.swapRepository.getSwapAssetStats().map(new h.c.m0.n() { // from class: com.coinbase.wallet.features.swap.viewmodels.p
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return SwapAssetPickerViewModel.d((List) obj);
            }
        });
        kotlin.jvm.internal.m.f(map, "swapRepository.getSwapAssetStats()\n            .map<Map<ContractAddress?, Int>> { assetStatsList ->\n                assetStatsList.reduceIntoMap { mutableMap, assetStat ->\n                    mutableMap[assetStat.contractAddress] = assetStat.selectedCount\n                }\n            }");
        h.c.t0.c cVar = h.c.t0.c.a;
        h.c.s<List<SwapAsset>> swapAssetListObservable = this.swapRepository.getSwapAssetListObservable();
        h.c.s observable = map.toObservable();
        kotlin.jvm.internal.m.f(observable, "selectionCountSingle.toObservable()");
        h.c.s<List<SwapAsset>> combineLatest = h.c.s.combineLatest(swapAssetListObservable, observable, new h.c.m0.c<T1, T2, R>() { // from class: com.coinbase.wallet.features.swap.viewmodels.SwapAssetPickerViewModel$getSortedSwapAssets$$inlined$combineLatest$1
            /* JADX WARN: Type inference failed for: r3v2, types: [R, java.util.Collection, java.util.ArrayList] */
            @Override // h.c.m0.c
            public final R apply(T1 t1, T2 t2) {
                List<kotlin.a0.e0> B0;
                int r;
                final Map map2 = (Map) t2;
                B0 = kotlin.a0.z.B0(e.j.f.g.a((List) t1), new Comparator() { // from class: com.coinbase.wallet.features.swap.viewmodels.SwapAssetPickerViewModel$getSortedSwapAssets$1$1
                    @Override // java.util.Comparator
                    public final int compare(kotlin.a0.e0<SwapAsset> e0Var, kotlin.a0.e0<SwapAsset> e0Var2) {
                        SwapAsset d2 = e0Var.d();
                        SwapAsset d3 = e0Var2.d();
                        if (!d2.getSwappable() || d3.getSwappable()) {
                            if (d2.getSwappable() || !d3.getSwappable()) {
                                Integer num = map2.get(d2.getContractAddress());
                                int intValue = num == null ? 0 : num.intValue();
                                Integer num2 = map2.get(d3.getContractAddress());
                                int intValue2 = num2 != null ? num2.intValue() : 0;
                                return intValue == intValue2 ? e0Var.c() - e0Var2.c() : intValue2 - intValue;
                            }
                            return 1;
                        }
                        return -1;
                    }
                });
                r = kotlin.a0.s.r(B0, 10);
                ?? r3 = (R) new ArrayList(r);
                for (kotlin.a0.e0 e0Var : B0) {
                    r3.add((SwapAsset) e0Var.d());
                }
                return r3;
            }
        });
        kotlin.jvm.internal.m.f(combineLatest, "Observables\n            .combineLatest(\n                swapRepository.swapAssetListObservable,\n                selectionCountSingle.toObservable()\n            ) { assets, selectionCountMap ->\n                assets.enumerated()\n                    .sortedWith(\n                        Comparator { left, right ->\n                            val leftAsset = left.value\n                            val rightAsset = right.value\n\n                            // Supported assets on top; unsupported assets at the bottom\n                            when {\n                                leftAsset.swappable && !rightAsset.swappable -> return@Comparator -1\n                                !leftAsset.swappable && rightAsset.swappable -> return@Comparator 1\n                            }\n\n                            // Fall through to sort by selection count\n                            val leftCount = selectionCountMap[leftAsset.contractAddress] ?: 0\n                            val rightCount = selectionCountMap[rightAsset.contractAddress] ?: 0\n\n                            // Sort by selection count in descending order while preserving sort order for items with the\n                            // same selection count\n                            if (leftCount == rightCount) {\n                                left.index - right.index // Preserve order\n                            } else {\n                                rightCount - leftCount\n                            }\n                        }\n                    )\n                    .map { it.value }\n            }");
        return combineLatest;
    }

    /* renamed from: getSortedSwapAssets$lambda-10 */
    public static final Map m1478getSortedSwapAssets$lambda10(List assetStatsList) {
        kotlin.jvm.internal.m.g(assetStatsList, "assetStatsList");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator it = assetStatsList.iterator();
        while (it.hasNext()) {
            SwapAssetStats swapAssetStats = (SwapAssetStats) it.next();
            linkedHashMap.put(swapAssetStats.getContractAddress(), Integer.valueOf(swapAssetStats.getSelectedCount()));
        }
        return linkedHashMap;
    }

    private final void presentNonConvertiblePrompt() {
        List b2;
        LocalizedStrings localizedStrings = LocalizedStrings.INSTANCE;
        String str = localizedStrings.get(R.string.swap_non_convertible_token_prompt_title);
        String str2 = localizedStrings.get(R.string.swap_non_convertible_token_prompt_body);
        b2 = kotlin.a0.q.b(new PromptDialogHelper.Action(localizedStrings.get(R.string.ok), ActionStyle.POSITIVE, SwapAssetPickerViewModel$presentNonConvertiblePrompt$properties$1.INSTANCE));
        this.eventSubject.onNext(new SwapAssetPickerEvent.LaunchPrompt(new PromptDialogHelper.Properties(null, str, str2, null, Integer.valueOf((int) R.drawable.illustration_crypto_non_convertible), b2, Integer.valueOf((int) R.style.DialogFadeScaleAnimation), false, null, null, SwapAssetPickerViewModel$presentNonConvertiblePrompt$properties$2.INSTANCE, null, null, false, 15241, null)));
    }

    private final void presentUnsupportedPrompt(SwapAsset swapAsset) {
        h.c.b0<List<Aggregator>> observeOn = this.swapRepository.getAggregators(swapAsset.getAggregatorIDs()).observeOn(h.c.j0.c.a.b());
        kotlin.jvm.internal.m.f(observeOn, "swapRepository.getAggregators(swapAsset.aggregatorIDs)\n            .observeOn(AndroidSchedulers.mainThread())");
        h.c.t0.a.a(h.c.t0.g.i(observeOn, null, new SwapAssetPickerViewModel$presentUnsupportedPrompt$1(this), 1, null), this.disposeBag);
    }

    private final void selectAsset(SwapAsset swapAsset) {
        h.c.b0<kotlin.x> observeOn = this.swapRepository.selectSwapAsset(swapAsset).observeOn(h.c.j0.c.a.b());
        kotlin.jvm.internal.m.f(observeOn, "swapRepository.selectSwapAsset(swapAsset)\n            .observeOn(AndroidSchedulers.mainThread())");
        h.c.t0.a.a(h.c.t0.g.i(observeOn, null, new SwapAssetPickerViewModel$selectAsset$1(this, swapAsset), 1, null), this.disposeBag);
    }

    private final void setData(List<? extends SwapAssetPickerItem> list) {
        this.data = list;
        this.dataSubject.onNext(list);
    }

    private final void setState(SwapAssetPickerViewState swapAssetPickerViewState) {
        this.state = swapAssetPickerViewState;
        this.stateSubject.onNext(swapAssetPickerViewState);
    }

    /* renamed from: setup$lambda-0 */
    public static final List m1479setup$lambda0(SwapAssetPickerViewModel this$0, kotlin.t dstr$convertibleAssets$nonConvertibleAssets$searchQuery) {
        CharSequence h1;
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(dstr$convertibleAssets$nonConvertibleAssets$searchQuery, "$dstr$convertibleAssets$nonConvertibleAssets$searchQuery");
        List<SwapAssetPickerItem.SwapAssetItem> list = (List) dstr$convertibleAssets$nonConvertibleAssets$searchQuery.a();
        List<SwapAssetPickerItem.SwapAssetItem> nonConvertibleAssets = (List) dstr$convertibleAssets$nonConvertibleAssets$searchQuery.b();
        String searchQuery = (String) dstr$convertibleAssets$nonConvertibleAssets$searchQuery.c();
        kotlin.jvm.internal.m.f(searchQuery, "searchQuery");
        h1 = kotlin.l0.y.h1(searchQuery);
        String obj = h1.toString();
        if (obj.length() == 0) {
            kotlin.jvm.internal.m.f(nonConvertibleAssets, "nonConvertibleAssets");
            return this$0.buildItemList(list, nonConvertibleAssets);
        }
        SwapAssetPickerViewModel$setup$1$filter$1 swapAssetPickerViewModel$setup$1$filter$1 = new SwapAssetPickerViewModel$setup$1$filter$1(obj);
        List<SwapAssetPickerItem.SwapAssetItem> arrayList = new ArrayList<>();
        for (Object obj2 : list) {
            if (swapAssetPickerViewModel$setup$1$filter$1.invoke((SwapAssetPickerViewModel$setup$1$filter$1) obj2).booleanValue()) {
                arrayList.add(obj2);
            }
        }
        kotlin.jvm.internal.m.f(nonConvertibleAssets, "nonConvertibleAssets");
        List<SwapAssetPickerItem.SwapAssetItem> arrayList2 = new ArrayList<>();
        for (Object obj3 : nonConvertibleAssets) {
            if (swapAssetPickerViewModel$setup$1$filter$1.invoke((SwapAssetPickerViewModel$setup$1$filter$1) obj3).booleanValue()) {
                arrayList2.add(obj3);
            }
        }
        return this$0.buildItemList(arrayList, arrayList2);
    }

    /* renamed from: setup$lambda-1 */
    public static final kotlin.x m1480setup$lambda1(SwapAssetPickerViewModel this$0, List assets) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(assets, "assets");
        this$0.setState(SwapAssetPickerViewState.copy$default(this$0.state, null, null, null, false, 7, null));
        this$0.setData(assets);
        return kotlin.x.a;
    }

    /* renamed from: setup$lambda-2 */
    public static final void m1481setup$lambda2(SwapAssetPickerViewModel this$0, Throwable th) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        this$0.setState(SwapAssetPickerViewState.copy$default(this$0.state, null, null, null, false, 7, null));
    }

    public final h.c.s<List<SwapAssetPickerItem>> getDataObservable() {
        return this.dataObservable;
    }

    public final h.c.s<kotlin.x> getDismissObservable() {
        return this.dismissObservable;
    }

    public final h.c.s<SwapAssetPickerEvent> getEventObservable() {
        return this.eventObservable;
    }

    public final String getQuery() {
        return this.query;
    }

    public final androidx.lifecycle.z getSavedStateHandle() {
        return this.savedStateHandle;
    }

    public final h.c.s<kotlin.o<String, SwapAsset>> getSelectedAssetObservable() {
        return this.selectedAssetObservable;
    }

    public final h.c.s<SwapAssetPickerViewState> getStateObservable() {
        return this.stateObservable;
    }

    public final void onAssetSelected(SwapAssetPickerItem.SwapAssetItem item) {
        kotlin.jvm.internal.m.g(item, "item");
        SwapAssetType type = item.getType();
        if (type instanceof SwapAssetType.Supported) {
            Analytics.INSTANCE.log(AnalyticsEvent_ApplicationKt.swapSupportedAssetSelected(AnalyticsEvent.Companion, ((SwapAssetType.Supported) item.getType()).getAsset().getCurrencyCode().getCode()));
            selectAsset(((SwapAssetType.Supported) item.getType()).getAsset());
        } else if (type instanceof SwapAssetType.Unsupported) {
            Analytics.INSTANCE.log(AnalyticsEvent_ApplicationKt.swapNotSupportedAssetSelected(AnalyticsEvent.Companion, ((SwapAssetType.Unsupported) item.getType()).getAsset().getCurrencyCode().getCode()));
            presentUnsupportedPrompt(((SwapAssetType.Unsupported) item.getType()).getAsset());
        } else if (kotlin.jvm.internal.m.c(type, SwapAssetType.NonConvertible.INSTANCE)) {
            Analytics.INSTANCE.log(AnalyticsEvent_ApplicationKt.swapNonConvertibleAssetSelected(AnalyticsEvent.Companion, item.getCurrencyCode()));
            presentNonConvertiblePrompt();
        }
    }

    @Override // androidx.lifecycle.b0
    public void onCleared() {
        super.onCleared();
        this.disposeBag.d();
    }

    public final void setQuery(String value) {
        kotlin.jvm.internal.m.g(value, "value");
        this.query = value;
        this.searchSubject.onNext(value);
    }

    public final h.c.s<kotlin.x> setup() {
        SwapAssetPickerViewState copy;
        Analytics.INSTANCE.log(AnalyticsEvent_ApplicationKt.swapAssetPickerLanded(AnalyticsEvent.Companion, this.amountBase.getDescription()));
        AmountBase amountBase = this.amountBase;
        if (amountBase instanceof AmountBase.Source) {
            SwapAssetPickerViewState swapAssetPickerViewState = this.state;
            LocalizedStrings localizedStrings = LocalizedStrings.INSTANCE;
            copy = swapAssetPickerViewState.copy(localizedStrings.get(R.string.swap_asset_picker_title_source), localizedStrings.get(R.string.swap_asset_picker_empty_title_source), localizedStrings.get(R.string.swap_asset_picker_empty_source), true);
        } else if (amountBase instanceof AmountBase.Target) {
            SwapAssetPickerViewState swapAssetPickerViewState2 = this.state;
            LocalizedStrings localizedStrings2 = LocalizedStrings.INSTANCE;
            copy = swapAssetPickerViewState2.copy(localizedStrings2.get(R.string.swap_asset_picker_title_target), localizedStrings2.get(R.string.swap_asset_picker_empty_title_target), localizedStrings2.get(R.string.swap_asset_picker_empty_target), true);
        } else {
            throw new NoWhenBranchMatchedException();
        }
        setState(copy);
        h.c.t0.a.a(h.c.t0.g.i(this.swapRepository.refresh(true), null, null, 3, null), this.disposeBag);
        h.c.t0.c cVar = h.c.t0.c.a;
        h.c.s<List<SwapAssetPickerItem.SwapAssetItem>> convertibleAssets = getConvertibleAssets(this.amountBase);
        h.c.s<List<SwapAssetPickerItem.SwapAssetItem>> observable = getNonConvertibleAssets().toObservable();
        kotlin.jvm.internal.m.f(observable, "getNonConvertibleAssets().toObservable()");
        h.c.s<String> throttleLatest = this.searchSubject.throttleLatest(100L, TimeUnit.MILLISECONDS, true);
        kotlin.jvm.internal.m.f(throttleLatest, "searchSubject.throttleLatest(100, TimeUnit.MILLISECONDS, true)");
        h.c.s observeOn = cVar.b(convertibleAssets, observable, throttleLatest).observeOn(h.c.u0.a.a()).map(new h.c.m0.n() { // from class: com.coinbase.wallet.features.swap.viewmodels.n
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return SwapAssetPickerViewModel.b(SwapAssetPickerViewModel.this, (kotlin.t) obj);
            }
        }).observeOn(h.c.j0.c.a.b());
        kotlin.jvm.internal.m.f(observeOn, "Observables\n            .combineLatest(\n                getConvertibleAssets(amountBase),\n                getNonConvertibleAssets().toObservable(),\n                searchSubject.throttleLatest(100, TimeUnit.MILLISECONDS, true)\n            )\n            .observeOn(Schedulers.computation())\n            .map { (convertibleAssets, nonConvertibleAssets, searchQuery) ->\n                val query = searchQuery.trim()\n                if (query.isEmpty()) return@map buildItemList(convertibleAssets, nonConvertibleAssets)\n\n                val filter: (SwapAssetItem) -> Boolean = { assetItem ->\n                    val contractAddress = when (val type = assetItem.type) {\n                        is SwapAssetType.Supported -> type.asset.contractAddress?.rawValue\n                        is SwapAssetType.Unsupported -> type.asset.contractAddress?.rawValue\n                        else -> null\n                    }\n\n                    val inName = assetItem.name.contains(query, true)\n                    val inCurrencyCode = assetItem.currencyCode.contains(query, true)\n                    val inContractAddress = query.length >= 6 && contractAddress?.contains(query, true) == true\n\n                    inName || inCurrencyCode || inContractAddress\n                }\n\n                val filteredConvertibleAssets = convertibleAssets.filter(filter)\n                val filteredNonConvertibleAssets = nonConvertibleAssets.filter(filter)\n\n                buildItemList(filteredConvertibleAssets, filteredNonConvertibleAssets)\n            }\n            .observeOn(AndroidSchedulers.mainThread())");
        h.c.s doOnError = Observable_AnalyticsKt.logError$default(observeOn, null, null, 3, null).map(new h.c.m0.n() { // from class: com.coinbase.wallet.features.swap.viewmodels.o
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return SwapAssetPickerViewModel.c(SwapAssetPickerViewModel.this, (List) obj);
            }
        }).doOnError(new h.c.m0.f() { // from class: com.coinbase.wallet.features.swap.viewmodels.m
            @Override // h.c.m0.f
            public final void accept(Object obj) {
                SwapAssetPickerViewModel.a(SwapAssetPickerViewModel.this, (Throwable) obj);
            }
        });
        kotlin.jvm.internal.m.f(doOnError, "Observables\n            .combineLatest(\n                getConvertibleAssets(amountBase),\n                getNonConvertibleAssets().toObservable(),\n                searchSubject.throttleLatest(100, TimeUnit.MILLISECONDS, true)\n            )\n            .observeOn(Schedulers.computation())\n            .map { (convertibleAssets, nonConvertibleAssets, searchQuery) ->\n                val query = searchQuery.trim()\n                if (query.isEmpty()) return@map buildItemList(convertibleAssets, nonConvertibleAssets)\n\n                val filter: (SwapAssetItem) -> Boolean = { assetItem ->\n                    val contractAddress = when (val type = assetItem.type) {\n                        is SwapAssetType.Supported -> type.asset.contractAddress?.rawValue\n                        is SwapAssetType.Unsupported -> type.asset.contractAddress?.rawValue\n                        else -> null\n                    }\n\n                    val inName = assetItem.name.contains(query, true)\n                    val inCurrencyCode = assetItem.currencyCode.contains(query, true)\n                    val inContractAddress = query.length >= 6 && contractAddress?.contains(query, true) == true\n\n                    inName || inCurrencyCode || inContractAddress\n                }\n\n                val filteredConvertibleAssets = convertibleAssets.filter(filter)\n                val filteredNonConvertibleAssets = nonConvertibleAssets.filter(filter)\n\n                buildItemList(filteredConvertibleAssets, filteredNonConvertibleAssets)\n            }\n            .observeOn(AndroidSchedulers.mainThread())\n            .logError()\n            .map { assets ->\n                state = state.copy(isLoading = false)\n                data = assets\n            }\n            .doOnError { state = state.copy(isLoading = false) }");
        return Observable_CoreKt.asUnit(doOnError);
    }
}