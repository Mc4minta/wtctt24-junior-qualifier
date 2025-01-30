package com.coinbase.wallet.features.lend.viewmodels;

import android.annotation.SuppressLint;
import androidx.lifecycle.b0;
import com.appsflyer.AppsFlyerProperties;
import com.coinbase.ApiConstants;
import com.coinbase.ciphercore.CipherCoreInterface;
import com.coinbase.ciphercore.ERC20Info;
import com.coinbase.ciphercore.ethereum.EthereumChain;
import com.coinbase.wallet.analytics.Analytics;
import com.coinbase.wallet.analytics.extensions.Observable_AnalyticsKt;
import com.coinbase.wallet.analytics.extensions.Single_AnalyticsKt;
import com.coinbase.wallet.analytics.models.AnalyticsEvent;
import com.coinbase.wallet.application.extensions.AnalyticsEvent_ApplicationKt;
import com.coinbase.wallet.application.extensions.BigInteger_ApplicationKt;
import com.coinbase.wallet.blockchains.models.AddressType;
import com.coinbase.wallet.blockchains.models.Blockchain;
import com.coinbase.wallet.blockchains.models.CurrencyCode;
import com.coinbase.wallet.blockchains.models.CurrencyDecimal;
import com.coinbase.wallet.blockchains.models.Transaction;
import com.coinbase.wallet.blockchains.models.TxMetadataKey;
import com.coinbase.wallet.blockchains.models.Wallet;
import com.coinbase.wallet.blockchains.models.WalletAddress;
import com.coinbase.wallet.common.extensions.BigInteger_CommonKt;
import com.coinbase.wallet.common.extensions.FiatCurrency_CommonKt;
import com.coinbase.wallet.common.extensions.List_WalletsKt;
import com.coinbase.wallet.common.extensions.WalletRepository_CommonKt;
import com.coinbase.wallet.common.utilities.LocalizedStrings;
import com.coinbase.wallet.commonui.models.ViewModelNavRoute;
import com.coinbase.wallet.core.extensions.BigIntegers;
import com.coinbase.wallet.core.extensions.BigIntegers_CoreKt;
import com.coinbase.wallet.core.extensions.Map_CoreKt;
import com.coinbase.wallet.core.extensions.Observable_CoreKt;
import com.coinbase.wallet.core.extensions.Single_CoreKt;
import com.coinbase.wallet.core.extensions.Strings;
import com.coinbase.wallet.core.extensions.Strings_CoreKt;
import com.coinbase.wallet.core.interfaces.RefreshInterval;
import com.coinbase.wallet.core.util.Optional;
import com.coinbase.wallet.ethereum.extensions.AddressKind_EthereumKt;
import com.coinbase.wallet.ethereum.extensions.Blockchain_EthereumKt;
import com.coinbase.wallet.ethereum.extensions.CurrencyCode_EthereumKt;
import com.coinbase.wallet.ethereum.extensions.CurrencyDecimal_EthereumKt;
import com.coinbase.wallet.ethereum.extensions.EthereumChain_EthereumKt;
import com.coinbase.wallet.ethereum.models.ContractAction;
import com.coinbase.wallet.ethereum.models.ContractAddress;
import com.coinbase.wallet.features.lend.LendError;
import com.coinbase.wallet.features.lend.interfaces.LendBalanceManaging;
import com.coinbase.wallet.features.lend.models.BalanceInfo;
import com.coinbase.wallet.features.lend.models.LendAmountPickerArgs;
import com.coinbase.wallet.features.lend.models.LendCoinPickerArgs;
import com.coinbase.wallet.features.lend.models.LendDashboardItem;
import com.coinbase.wallet.features.lend.models.LendDashboardState;
import com.coinbase.wallet.lending.extensions.TxMetadataKey_LendKt;
import com.coinbase.wallet.lending.interfaces.ILendRepository;
import com.coinbase.wallet.lending.models.LendInterest;
import com.coinbase.wallet.lending.models.LendToken;
import com.coinbase.wallet.routing.models.RouteActionKey;
import com.coinbase.wallet.txhistory.repositories.TxHistoryRepository;
import com.coinbase.wallet.wallets.formatters.CurrencyFormatter;
import com.coinbase.wallet.wallets.interfaces.IExchangeRateRepository;
import com.coinbase.wallet.wallets.interfaces.IFiatCurrencyRepository;
import com.coinbase.wallet.wallets.interfaces.IWalletRepository;
import com.coinbase.wallet.wallets.models.ExchangeRate;
import com.coinbase.wallet.wallets.models.FiatCurrency;
import h.c.h0;
import h.c.s;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.a0.m0;
import kotlin.a0.r;
import kotlin.a0.z;
import kotlin.t;
import kotlin.u;
import kotlin.x;
import org.toshi.R;

/* compiled from: LendDashboardViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Ø\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002BA\b\u0007\u0012\u0006\u0010d\u001a\u00020c\u0012\u0006\u0010j\u001a\u00020i\u0012\u0006\u00102\u001a\u000201\u0012\u0006\u0010G\u001a\u00020F\u0012\u0006\u0010l\u001a\u00020k\u0012\u0006\u0010n\u001a\u00020m\u0012\u0006\u00107\u001a\u000206¢\u0006\u0004\bo\u0010pJ\u0015\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0015\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0002¢\u0006\u0004\b\u0007\u0010\u0006J5\u0010\u000e\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\b0\u000b0\u00032\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ?\u0010\u0019\u001a\u0010\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u00182\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00122\b\u0010\u0015\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0017\u001a\u00020\u0016H\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ%\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001d0\u00032\u0006\u0010\u0015\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0016H\u0002¢\u0006\u0004\b\u001e\u0010\u001fJ\u0015\u0010!\u001a\u00020\u00042\u0006\u0010 \u001a\u00020\r¢\u0006\u0004\b!\u0010\"J\r\u0010#\u001a\u00020\u0004¢\u0006\u0004\b#\u0010$J\r\u0010%\u001a\u00020\u0004¢\u0006\u0004\b%\u0010$J\r\u0010&\u001a\u00020\u0004¢\u0006\u0004\b&\u0010$J\r\u0010'\u001a\u00020\u0004¢\u0006\u0004\b'\u0010$J\r\u0010(\u001a\u00020\u0004¢\u0006\u0004\b(\u0010$J\u0015\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00040)H\u0007¢\u0006\u0004\b*\u0010+J\u000f\u0010,\u001a\u00020\u0004H\u0014¢\u0006\u0004\b,\u0010$R\"\u0010.\u001a\b\u0012\u0004\u0012\u00020-0)8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b.\u0010/\u001a\u0004\b0\u0010+R\u001c\u00102\u001a\u0002018\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b2\u00103\u001a\u0004\b4\u00105R\u0016\u00107\u001a\u0002068\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b7\u00108R\u001f\u0010:\u001a\b\u0012\u0004\u0012\u0002090)8\u0006@\u0006¢\u0006\f\n\u0004\b:\u0010/\u001a\u0004\b;\u0010+R\u001f\u0010=\u001a\b\u0012\u0004\u0012\u00020<0)8\u0006@\u0006¢\u0006\f\n\u0004\b=\u0010/\u001a\u0004\b>\u0010+R\u0013\u0010A\u001a\u00020\u00148F@\u0006¢\u0006\u0006\u001a\u0004\b?\u0010@R\"\u0010D\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020C0\b0B8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bD\u0010ER\u001c\u0010G\u001a\u00020F8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\bG\u0010H\u001a\u0004\bI\u0010JR*\u0010L\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u001b\u0012\u0004\u0012\u00020K0\u000b0\u00038\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bL\u0010MR\u001c\u0010N\u001a\b\u0012\u0004\u0012\u00020<0B8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bN\u0010ER\u001c\u0010O\u001a\b\u0012\u0004\u0012\u00020K0\u00038\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bO\u0010MR\u001c\u0010P\u001a\b\u0012\u0004\u0012\u00020\u00040B8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bP\u0010ER\u0018\u0010Q\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bQ\u0010RR0\u0010T\u001a\b\u0012\u0004\u0012\u00020C0\b2\f\u0010S\u001a\b\u0012\u0004\u0012\u00020C0\b8\u0002@BX\u0082\u000e¢\u0006\f\n\u0004\bT\u0010U\"\u0004\bV\u0010WR\u001f\u0010X\u001a\b\u0012\u0004\u0012\u00020\u00040)8\u0006@\u0006¢\u0006\f\n\u0004\bX\u0010/\u001a\u0004\bY\u0010+R%\u0010Z\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020C0\b0)8\u0006@\u0006¢\u0006\f\n\u0004\bZ\u0010/\u001a\u0004\b[\u0010+R$\u0010\\\u001a\u0002092\u0006\u0010S\u001a\u0002098\u0002@BX\u0082\u000e¢\u0006\f\n\u0004\b\\\u0010]\"\u0004\b^\u0010_R(\u0010a\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020`0\b0)8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\ba\u0010/\u001a\u0004\bb\u0010+R\u0016\u0010d\u001a\u00020c8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bd\u0010eR\u001c\u0010g\u001a\b\u0012\u0004\u0012\u0002090f8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bg\u0010h¨\u0006q"}, d2 = {"Lcom/coinbase/wallet/features/lend/viewmodels/LendDashboardViewModel;", "Lcom/coinbase/wallet/features/lend/interfaces/LendBalanceManaging;", "Landroidx/lifecycle/b0;", "Lh/c/b0;", "Lkotlin/x;", "getInterestEarned", "()Lh/c/b0;", "getAverageInterest", "", "Lcom/coinbase/wallet/features/lend/models/BalanceInfo;", "balanceInfos", "", "Lcom/coinbase/wallet/features/lend/models/LendDashboardItem$Token;", "Lcom/coinbase/wallet/features/lend/models/LendDashboardItem$Provider;", "getItems", "(Ljava/util/List;)Lh/c/b0;", "Ljava/math/BigInteger;", "amount", "Lcom/coinbase/wallet/blockchains/models/CurrencyCode;", AppsFlyerProperties.CURRENCY_CODE, "", RouteActionKey.RouteActionKeys.CONTRACT_ADDRESS, "", "decimals", "Lkotlin/o;", "getFormattedAmounts", "(Ljava/math/BigInteger;Lcom/coinbase/wallet/blockchains/models/CurrencyCode;Ljava/lang/String;I)Lkotlin/o;", "Lcom/coinbase/wallet/ethereum/models/ContractAddress;", "chainID", "Lcom/coinbase/ciphercore/ERC20Info;", "getERC20", "(Lcom/coinbase/wallet/ethereum/models/ContractAddress;I)Lh/c/b0;", "item", "showLendingActionSheet", "(Lcom/coinbase/wallet/features/lend/models/LendDashboardItem$Provider;)V", "hideLendingActionSheet", "()V", "proceedToCoinPicker", "proceedToSupply", "proceedToWithdraw", "dismissView", "Lh/c/s;", "setup", "()Lh/c/s;", "onCleared", "Lcom/coinbase/wallet/wallets/models/FiatCurrency;", "activeFiatCurrencyObservable", "Lh/c/s;", "getActiveFiatCurrencyObservable", "Lcom/coinbase/wallet/wallets/formatters/CurrencyFormatter;", "currencyFormatter", "Lcom/coinbase/wallet/wallets/formatters/CurrencyFormatter;", "getCurrencyFormatter", "()Lcom/coinbase/wallet/wallets/formatters/CurrencyFormatter;", "Lcom/coinbase/ciphercore/CipherCoreInterface;", "cipherCore", "Lcom/coinbase/ciphercore/CipherCoreInterface;", "Lcom/coinbase/wallet/features/lend/models/LendDashboardState;", "stateObservable", "getStateObservable", "Lcom/coinbase/wallet/commonui/models/ViewModelNavRoute;", "navigationObservable", "getNavigationObservable", "getSelectedItemDescription", "()Ljava/lang/String;", "selectedItemDescription", "Lh/c/v0/b;", "Lcom/coinbase/wallet/features/lend/models/LendDashboardItem;", "dataUpdatedSubject", "Lh/c/v0/b;", "Lcom/coinbase/wallet/lending/interfaces/ILendRepository;", "lendRepository", "Lcom/coinbase/wallet/lending/interfaces/ILendRepository;", "getLendRepository", "()Lcom/coinbase/wallet/lending/interfaces/ILendRepository;", "Lcom/coinbase/wallet/blockchains/models/Wallet;", "walletMapSingle", "Lh/c/b0;", "navigationSubject", "walletSingle", "dismissSubject", "selectedItem", "Lcom/coinbase/wallet/features/lend/models/LendDashboardItem$Provider;", "value", "data", "Ljava/util/List;", "setData", "(Ljava/util/List;)V", "dismissObservable", "getDismissObservable", "dataUpdatedObservable", "getDataUpdatedObservable", ApiConstants.STATE, "Lcom/coinbase/wallet/features/lend/models/LendDashboardState;", "setState", "(Lcom/coinbase/wallet/features/lend/models/LendDashboardState;)V", "Lcom/coinbase/wallet/wallets/models/ExchangeRate;", "exchangeRateObservable", "getExchangeRateObservable", "Lcom/coinbase/wallet/txhistory/repositories/TxHistoryRepository;", "txHistoryRepository", "Lcom/coinbase/wallet/txhistory/repositories/TxHistoryRepository;", "Lh/c/v0/a;", "stateSubject", "Lh/c/v0/a;", "Lcom/coinbase/wallet/wallets/interfaces/IWalletRepository;", "walletRepository", "Lcom/coinbase/wallet/wallets/interfaces/IExchangeRateRepository;", "exchangeRateRepository", "Lcom/coinbase/wallet/wallets/interfaces/IFiatCurrencyRepository;", "fiatCurrencyRepository", "<init>", "(Lcom/coinbase/wallet/txhistory/repositories/TxHistoryRepository;Lcom/coinbase/wallet/wallets/interfaces/IWalletRepository;Lcom/coinbase/wallet/wallets/formatters/CurrencyFormatter;Lcom/coinbase/wallet/lending/interfaces/ILendRepository;Lcom/coinbase/wallet/wallets/interfaces/IExchangeRateRepository;Lcom/coinbase/wallet/wallets/interfaces/IFiatCurrencyRepository;Lcom/coinbase/ciphercore/CipherCoreInterface;)V", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class LendDashboardViewModel extends b0 implements LendBalanceManaging {
    private final s<FiatCurrency> activeFiatCurrencyObservable;
    private final CipherCoreInterface cipherCore;
    private final CurrencyFormatter currencyFormatter;
    private List<? extends LendDashboardItem> data;
    private final s<List<LendDashboardItem>> dataUpdatedObservable;
    private final h.c.v0.b<List<LendDashboardItem>> dataUpdatedSubject;
    private final s<x> dismissObservable;
    private final h.c.v0.b<x> dismissSubject;
    private final s<List<ExchangeRate>> exchangeRateObservable;
    private final ILendRepository lendRepository;
    private final s<ViewModelNavRoute> navigationObservable;
    private final h.c.v0.b<ViewModelNavRoute> navigationSubject;
    private LendDashboardItem.Provider selectedItem;
    private LendDashboardState state;
    private final s<LendDashboardState> stateObservable;
    private final h.c.v0.a<LendDashboardState> stateSubject;
    private final TxHistoryRepository txHistoryRepository;
    private final h.c.b0<Map<ContractAddress, Wallet>> walletMapSingle;
    private final h.c.b0<Wallet> walletSingle;

    public LendDashboardViewModel(TxHistoryRepository txHistoryRepository, IWalletRepository walletRepository, CurrencyFormatter currencyFormatter, ILendRepository lendRepository, IExchangeRateRepository exchangeRateRepository, IFiatCurrencyRepository fiatCurrencyRepository, CipherCoreInterface cipherCore) {
        List<? extends LendDashboardItem> g2;
        kotlin.jvm.internal.m.g(txHistoryRepository, "txHistoryRepository");
        kotlin.jvm.internal.m.g(walletRepository, "walletRepository");
        kotlin.jvm.internal.m.g(currencyFormatter, "currencyFormatter");
        kotlin.jvm.internal.m.g(lendRepository, "lendRepository");
        kotlin.jvm.internal.m.g(exchangeRateRepository, "exchangeRateRepository");
        kotlin.jvm.internal.m.g(fiatCurrencyRepository, "fiatCurrencyRepository");
        kotlin.jvm.internal.m.g(cipherCore, "cipherCore");
        this.txHistoryRepository = txHistoryRepository;
        this.currencyFormatter = currencyFormatter;
        this.lendRepository = lendRepository;
        this.cipherCore = cipherCore;
        h.c.v0.b<ViewModelNavRoute> d2 = h.c.v0.b.d();
        kotlin.jvm.internal.m.f(d2, "create()");
        this.navigationSubject = d2;
        h.c.v0.b<x> d3 = h.c.v0.b.d();
        kotlin.jvm.internal.m.f(d3, "create()");
        this.dismissSubject = d3;
        h.c.v0.a<LendDashboardState> d4 = h.c.v0.a.d();
        kotlin.jvm.internal.m.f(d4, "create()");
        this.stateSubject = d4;
        h.c.v0.b<List<LendDashboardItem>> d5 = h.c.v0.b.d();
        kotlin.jvm.internal.m.f(d5, "create()");
        this.dataUpdatedSubject = d5;
        s<Optional<Wallet>> observeWallet = WalletRepository_CommonKt.observeWallet(walletRepository, Blockchain_EthereumKt.getETHEREUM(Blockchain.Companion), CurrencyCode_EthereumKt.getETH(CurrencyCode.Companion));
        kotlin.jvm.internal.m.f(observeWallet, "walletRepository\n        .observeWallet(Blockchain.ETHEREUM, CurrencyCode.ETH)");
        s<R> map = observeWallet.filter(new h.c.m0.p() { // from class: com.coinbase.wallet.features.lend.viewmodels.LendDashboardViewModel$special$$inlined$unwrap$1
            public final boolean test(Optional<? extends T> it) {
                kotlin.jvm.internal.m.g(it, "it");
                return it.toNullable() != null;
            }

            @Override // h.c.m0.p
            public /* bridge */ /* synthetic */ boolean test(Object obj) {
                return test((Optional) ((Optional) obj));
            }
        }).map(new h.c.m0.n() { // from class: com.coinbase.wallet.features.lend.viewmodels.LendDashboardViewModel$special$$inlined$unwrap$2
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
        h.c.b0<Map<ContractAddress, Wallet>> map2 = Observable_CoreKt.takeSingle(walletRepository.observeWallets(false)).map(new h.c.m0.n() { // from class: com.coinbase.wallet.features.lend.viewmodels.k
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return LendDashboardViewModel.i((List) obj);
            }
        });
        kotlin.jvm.internal.m.f(map2, "walletRepository.observeWallets(false)\n        .takeSingle()\n        .map { wallets ->\n            wallets\n                .filter { it.blockchain == Blockchain.ETHEREUM }\n                .reduceIntoMap(mutableMapOf<ContractAddress?, Wallet>()) { walletMap, wallet ->\n                    if (wallet.currencyCode == CurrencyCode.ETH) {\n                        walletMap[null] = wallet\n                    } else {\n                        wallet.contractAddress?.let { walletMap[ContractAddress(it)] = wallet }\n                    }\n                }\n        }");
        this.walletMapSingle = map2;
        this.state = new LendDashboardState(null, null, null, 0.0d, null, null, 0.0d, null, null, false, 1023, null);
        g2 = r.g();
        this.data = g2;
        this.exchangeRateObservable = exchangeRateRepository.getExchangeRateObservable();
        this.activeFiatCurrencyObservable = fiatCurrencyRepository.getActiveCurrencyObservable();
        s<LendDashboardState> distinctUntilChanged = d4.hide().distinctUntilChanged();
        kotlin.jvm.internal.m.f(distinctUntilChanged, "stateSubject.hide().distinctUntilChanged()");
        this.stateObservable = distinctUntilChanged;
        s<List<LendDashboardItem>> hide = d5.hide();
        kotlin.jvm.internal.m.f(hide, "dataUpdatedSubject.hide()");
        this.dataUpdatedObservable = hide;
        s<ViewModelNavRoute> hide2 = d2.hide();
        kotlin.jvm.internal.m.f(hide2, "navigationSubject.hide()");
        this.navigationObservable = hide2;
        s<x> hide3 = d3.hide();
        kotlin.jvm.internal.m.f(hide3, "dismissSubject.hide()");
        this.dismissObservable = hide3;
    }

    public static /* synthetic */ h0 a(LendDashboardViewModel lendDashboardViewModel, Wallet wallet) {
        return m1276getInterestEarned$lambda18(lendDashboardViewModel, wallet);
    }

    public static /* synthetic */ h.c.x b(LendDashboardViewModel lendDashboardViewModel, Wallet wallet) {
        return m1285setup$lambda4(lendDashboardViewModel, wallet);
    }

    public static /* synthetic */ kotlin.o d(LendDashboardViewModel lendDashboardViewModel, t tVar) {
        return m1277getInterestEarned$lambda21(lendDashboardViewModel, tVar);
    }

    public static /* synthetic */ h0 e(LendDashboardViewModel lendDashboardViewModel, List list) {
        return m1281setup$lambda12$lambda11(lendDashboardViewModel, list);
    }

    public static /* synthetic */ x f(LendDashboardViewModel lendDashboardViewModel, String str) {
        return m1286setup$lambda5(lendDashboardViewModel, str);
    }

    public static /* synthetic */ Map g(List list, LendDashboardViewModel lendDashboardViewModel, List list2) {
        return m1279getItems$lambda29(list, lendDashboardViewModel, list2);
    }

    private final h.c.b0<x> getAverageInterest() {
        h.c.b0 map = getAverageWeightedInterest().observeOn(h.c.j0.c.a.b()).map(new h.c.m0.n() { // from class: com.coinbase.wallet.features.lend.viewmodels.j
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return LendDashboardViewModel.h(LendDashboardViewModel.this, (String) obj);
            }
        });
        kotlin.jvm.internal.m.f(map, "getAverageWeightedInterest()\n        .observeOn(AndroidSchedulers.mainThread())\n        .map { result ->\n            state = state.copy(\n                interestAPR = LocalizedStrings[R.string.lend_dashboard_interest_apr, result],\n                interestAPRTitle = LocalizedStrings[R.string.lend_dashboard_interest_apr_title, result]\n            )\n        }");
        return map;
    }

    /* renamed from: getAverageInterest$lambda-23 */
    public static final x m1275getAverageInterest$lambda23(LendDashboardViewModel this$0, String result) {
        LendDashboardState copy;
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(result, "result");
        LendDashboardState lendDashboardState = this$0.state;
        LocalizedStrings localizedStrings = LocalizedStrings.INSTANCE;
        copy = lendDashboardState.copy((r26 & 1) != 0 ? lendDashboardState.balance : null, (r26 & 2) != 0 ? lendDashboardState.interestAPR : localizedStrings.get(R.string.lend_dashboard_interest_apr, result), (r26 & 4) != 0 ? lendDashboardState.interestAPRTitle : localizedStrings.get(R.string.lend_dashboard_interest_apr_title, result), (r26 & 8) != 0 ? lendDashboardState.interestAPROpacity : 0.0d, (r26 & 16) != 0 ? lendDashboardState.fiatCurrencySymbol : null, (r26 & 32) != 0 ? lendDashboardState.fiatCurrencyCode : null, (r26 & 64) != 0 ? lendDashboardState.contentOpacity : 0.0d, (r26 & 128) != 0 ? lendDashboardState.lifetimeInterestEarned : null, (r26 & 256) != 0 ? lendDashboardState.earnMore : null, (r26 & 512) != 0 ? lendDashboardState.showLendingActionSheet : false);
        this$0.setState(copy);
        return x.a;
    }

    private final h.c.b0<ERC20Info> getERC20(ContractAddress contractAddress, int i2) {
        return this.cipherCore.getERC20Info(contractAddress.getRawValue(), i2);
    }

    private final kotlin.o<String, String> getFormattedAmounts(BigInteger bigInteger, CurrencyCode currencyCode, String str, int i2) {
        String formatToFiat;
        formatToFiat = getCurrencyFormatter().formatToFiat(currencyCode, str, i2, bigInteger, (r17 & 16) != 0 ? false : false, (r17 & 32) != 0 ? null : null, (r17 & 64) != 0 ? null : null);
        if (formatToFiat == null) {
            return null;
        }
        return new kotlin.o<>(formatToFiat, CurrencyFormatter.formatToCrypto$default(getCurrencyFormatter(), currencyCode, i2, bigInteger, false, 0, 0, 56, (Object) null));
    }

    private final h.c.b0<x> getInterestEarned() {
        h.c.b0 map = this.walletSingle.flatMap(new h.c.m0.n() { // from class: com.coinbase.wallet.features.lend.viewmodels.c
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return LendDashboardViewModel.a(LendDashboardViewModel.this, (Wallet) obj);
            }
        }).map(new h.c.m0.n() { // from class: com.coinbase.wallet.features.lend.viewmodels.f
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return LendDashboardViewModel.d(LendDashboardViewModel.this, (t) obj);
            }
        });
        kotlin.jvm.internal.m.f(map, "walletSingle\n            .flatMap { wallet ->\n                val index = wallet.selectedIndex ?: throw LendError.unableToGetLendingData\n                val walletAddress = WalletAddress(\n                    type = AddressType.Ethereum,\n                    address = wallet.primaryAddress,\n                    index = index\n                )\n\n                Singles.zip(\n                    lendRepository.getLifetimeInterestEarned(address = walletAddress),\n                    exchangeRateObservable.takeSingle(),\n                    activeFiatCurrencyObservable.takeSingle()\n                )\n            }\n            .map { (interests, exchangeRates, activeFiatCurrency) ->\n                val interestEarned: BigDecimal = interests\n                    .mapNotNull { interest ->\n                        val interestValue = BigIntegers.fromHex(interest.interestEarned) ?: return@mapNotNull null\n                        val exchangeRate = exchangeRates.rateFor(\n                            currencyCode = interest.code,\n                            contractAddress = interest.contractAddress?.rawValue\n                        ) ?: return@mapNotNull null\n\n                        (exchangeRate * BigDecimal(interestValue)).movePointLeft(interest.decimals)\n                    }\n                    .fold(BigDecimal.ZERO) { acc, interest -> acc + interest }\n\n                val formattedInterestEarnedString = currencyFormatter.fiatValueString(\n                    value = interestEarned,\n                    showCurrencySymbol = true\n                )\n\n                Pair(formattedInterestEarnedString, activeFiatCurrency)\n            }");
        h.c.b0<x> map2 = Single_AnalyticsKt.logError$default(map, null, null, 3, null).subscribeOn(h.c.u0.a.c()).observeOn(h.c.j0.c.a.b()).map(new h.c.m0.n() { // from class: com.coinbase.wallet.features.lend.viewmodels.o
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return LendDashboardViewModel.m(LendDashboardViewModel.this, (kotlin.o) obj);
            }
        });
        kotlin.jvm.internal.m.f(map2, "walletSingle\n            .flatMap { wallet ->\n                val index = wallet.selectedIndex ?: throw LendError.unableToGetLendingData\n                val walletAddress = WalletAddress(\n                    type = AddressType.Ethereum,\n                    address = wallet.primaryAddress,\n                    index = index\n                )\n\n                Singles.zip(\n                    lendRepository.getLifetimeInterestEarned(address = walletAddress),\n                    exchangeRateObservable.takeSingle(),\n                    activeFiatCurrencyObservable.takeSingle()\n                )\n            }\n            .map { (interests, exchangeRates, activeFiatCurrency) ->\n                val interestEarned: BigDecimal = interests\n                    .mapNotNull { interest ->\n                        val interestValue = BigIntegers.fromHex(interest.interestEarned) ?: return@mapNotNull null\n                        val exchangeRate = exchangeRates.rateFor(\n                            currencyCode = interest.code,\n                            contractAddress = interest.contractAddress?.rawValue\n                        ) ?: return@mapNotNull null\n\n                        (exchangeRate * BigDecimal(interestValue)).movePointLeft(interest.decimals)\n                    }\n                    .fold(BigDecimal.ZERO) { acc, interest -> acc + interest }\n\n                val formattedInterestEarnedString = currencyFormatter.fiatValueString(\n                    value = interestEarned,\n                    showCurrencySymbol = true\n                )\n\n                Pair(formattedInterestEarnedString, activeFiatCurrency)\n            }\n            .logError()\n            .subscribeOn(Schedulers.io())\n            .observeOn(AndroidSchedulers.mainThread())\n            .map { (interestEarned, fiatCurrency) ->\n                state = state.copy(\n                    lifetimeInterestEarned = interestEarned,\n                    fiatCurrencySymbol = fiatCurrency.symbol,\n                    fiatCurrencyCode = fiatCurrency.code\n                )\n            }");
        return map2;
    }

    /* renamed from: getInterestEarned$lambda-18 */
    public static final h0 m1276getInterestEarned$lambda18(LendDashboardViewModel this$0, Wallet wallet) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(wallet, "wallet");
        Integer selectedIndex = wallet.getSelectedIndex();
        if (selectedIndex != null) {
            return h.c.t0.e.a.b(this$0.getLendRepository().getLifetimeInterestEarned(new WalletAddress(AddressKind_EthereumKt.getEthereum(AddressType.Companion), wallet.getPrimaryAddress(), selectedIndex.intValue())), Observable_CoreKt.takeSingle(this$0.getExchangeRateObservable()), Observable_CoreKt.takeSingle(this$0.getActiveFiatCurrencyObservable()));
        }
        throw LendError.unableToGetLendingData.INSTANCE;
    }

    /* renamed from: getInterestEarned$lambda-21 */
    public static final kotlin.o m1277getInterestEarned$lambda21(LendDashboardViewModel this$0, t dstr$interests$exchangeRates$activeFiatCurrency) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(dstr$interests$exchangeRates$activeFiatCurrency, "$dstr$interests$exchangeRates$activeFiatCurrency");
        List<LendInterest> interests = (List) dstr$interests$exchangeRates$activeFiatCurrency.a();
        List exchangeRates = (List) dstr$interests$exchangeRates$activeFiatCurrency.b();
        FiatCurrency fiatCurrency = (FiatCurrency) dstr$interests$exchangeRates$activeFiatCurrency.c();
        kotlin.jvm.internal.m.f(interests, "interests");
        ArrayList<BigDecimal> arrayList = new ArrayList();
        for (LendInterest lendInterest : interests) {
            BigInteger fromHex = BigIntegers_CoreKt.fromHex(BigIntegers.INSTANCE, lendInterest.getInterestEarned());
            BigDecimal bigDecimal = null;
            if (fromHex != null) {
                kotlin.jvm.internal.m.f(exchangeRates, "exchangeRates");
                CurrencyCode code = lendInterest.getCode();
                ContractAddress contractAddress = lendInterest.getContractAddress();
                BigDecimal rateFor$default = List_WalletsKt.rateFor$default(exchangeRates, code, contractAddress == null ? null : contractAddress.getRawValue(), null, null, 12, null);
                if (rateFor$default != null) {
                    BigDecimal multiply = rateFor$default.multiply(new BigDecimal(fromHex));
                    kotlin.jvm.internal.m.f(multiply, "this.multiply(other)");
                    bigDecimal = multiply.movePointLeft(lendInterest.getDecimals());
                }
            }
            if (bigDecimal != null) {
                arrayList.add(bigDecimal);
            }
        }
        BigDecimal acc = BigDecimal.ZERO;
        for (BigDecimal bigDecimal2 : arrayList) {
            kotlin.jvm.internal.m.f(acc, "acc");
            acc = acc.add(bigDecimal2);
            kotlin.jvm.internal.m.f(acc, "this.add(other)");
        }
        kotlin.jvm.internal.m.f(acc, "interests\n                    .mapNotNull { interest ->\n                        val interestValue = BigIntegers.fromHex(interest.interestEarned) ?: return@mapNotNull null\n                        val exchangeRate = exchangeRates.rateFor(\n                            currencyCode = interest.code,\n                            contractAddress = interest.contractAddress?.rawValue\n                        ) ?: return@mapNotNull null\n\n                        (exchangeRate * BigDecimal(interestValue)).movePointLeft(interest.decimals)\n                    }\n                    .fold(BigDecimal.ZERO) { acc, interest -> acc + interest }");
        return new kotlin.o(this$0.getCurrencyFormatter().fiatValueString(acc, true), fiatCurrency);
    }

    /* renamed from: getInterestEarned$lambda-22 */
    public static final x m1278getInterestEarned$lambda22(LendDashboardViewModel this$0, kotlin.o dstr$interestEarned$fiatCurrency) {
        LendDashboardState copy;
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(dstr$interestEarned$fiatCurrency, "$dstr$interestEarned$fiatCurrency");
        String str = (String) dstr$interestEarned$fiatCurrency.a();
        FiatCurrency fiatCurrency = (FiatCurrency) dstr$interestEarned$fiatCurrency.b();
        kotlin.jvm.internal.m.f(fiatCurrency, "fiatCurrency");
        copy = r2.copy((r26 & 1) != 0 ? r2.balance : null, (r26 & 2) != 0 ? r2.interestAPR : null, (r26 & 4) != 0 ? r2.interestAPRTitle : null, (r26 & 8) != 0 ? r2.interestAPROpacity : 0.0d, (r26 & 16) != 0 ? r2.fiatCurrencySymbol : FiatCurrency_CommonKt.getSymbol(fiatCurrency), (r26 & 32) != 0 ? r2.fiatCurrencyCode : fiatCurrency.getCode(), (r26 & 64) != 0 ? r2.contentOpacity : 0.0d, (r26 & 128) != 0 ? r2.lifetimeInterestEarned : str, (r26 & 256) != 0 ? r2.earnMore : null, (r26 & 512) != 0 ? this$0.state.showLendingActionSheet : false);
        this$0.setState(copy);
        return x.a;
    }

    private final h.c.b0<Map<LendDashboardItem.Token, List<LendDashboardItem.Provider>>> getItems(final List<BalanceInfo> list) {
        s<R> map = getExchangeRateObservable().map(new h.c.m0.n() { // from class: com.coinbase.wallet.features.lend.viewmodels.i
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return LendDashboardViewModel.g(list, this, (List) obj);
            }
        });
        kotlin.jvm.internal.m.f(map, "exchangeRateObservable\n        .map { exchangeRates ->\n            val sectionWallets: List<Wallet> = balanceInfos\n                .map { it.wallet }\n                .distinct()\n\n            sectionWallets\n                .mapNotNull mapNotNullOuter@{ wallet ->\n                    val infoList = balanceInfos.filter { it.wallet.id == wallet.id }\n                    val items: List<LendDashboardItem.Provider> = infoList.mapNotNull { info ->\n                        val supplyBalance: BigInteger = when {\n                            info.lendToken.supplyBalance <= BigInteger.ZERO && !info.isPending -> return@mapNotNull null\n                            else -> info.lendToken.supplyBalance\n                        }\n\n                        val decimals = CurrencyDecimal.ETH\n                        val supplyRateText = LocalizedStrings[\n                            R.string.lend_dashboard_item_percent_apr,\n                            info.supplyRate.asRoundedPercentage(decimals = decimals)\n                        ]\n\n                        val amounts = getFormattedAmounts(\n                            amount = supplyBalance,\n                            currencyCode = info.lendToken.currencyCode,\n                            contractAddress = info.lendToken.contractAddress?.rawValue,\n                            decimals = info.lendToken.decimals\n                        ) ?: return@mapNotNull null\n\n                        LendDashboardItem.Provider(\n                            balanceInfo = info,\n                            supplyRateText = supplyRateText,\n                            fiatValue = amounts.first,\n                            cryptoValue = amounts.second\n                        )\n                    }\n\n                    if (items.isEmpty()) {\n                        return@mapNotNullOuter null\n                    }\n\n                    val sortedItems = items.sortedByDescending { it.balanceInfo.lendToken.supplyBalance }\n\n                    LendDashboardItem.Token(\n                        currencyFormatter = currencyFormatter,\n                        exchangeRates = exchangeRates,\n                        items = sortedItems\n                    ) to sortedItems\n                }.toMap()\n        }");
        return Observable_CoreKt.takeSingle(map);
    }

    /* renamed from: getItems$lambda-29 */
    public static final Map m1279getItems$lambda29(List balanceInfos, LendDashboardViewModel this$0, List exchangeRates) {
        int r;
        List<Wallet> P;
        Map r2;
        Object obj;
        List B0;
        kotlin.jvm.internal.m.g(balanceInfos, "$balanceInfos");
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(exchangeRates, "exchangeRates");
        r = kotlin.a0.s.r(balanceInfos, 10);
        ArrayList arrayList = new ArrayList(r);
        Iterator it = balanceInfos.iterator();
        while (it.hasNext()) {
            arrayList.add(((BalanceInfo) it.next()).getWallet());
        }
        P = z.P(arrayList);
        ArrayList arrayList2 = new ArrayList();
        for (Wallet wallet : P) {
            ArrayList arrayList3 = new ArrayList();
            for (Object obj2 : balanceInfos) {
                if (kotlin.jvm.internal.m.c(((BalanceInfo) obj2).getWallet().getId(), wallet.getId())) {
                    arrayList3.add(obj2);
                }
            }
            ArrayList arrayList4 = new ArrayList();
            Iterator it2 = arrayList3.iterator();
            while (true) {
                obj = null;
                if (!it2.hasNext()) {
                    break;
                }
                BalanceInfo balanceInfo = (BalanceInfo) it2.next();
                if (balanceInfo.getLendToken().getSupplyBalance().compareTo(BigInteger.ZERO) > 0 || balanceInfo.isPending()) {
                    BigInteger supplyBalance = balanceInfo.getLendToken().getSupplyBalance();
                    String str = LocalizedStrings.INSTANCE.get(R.string.lend_dashboard_item_percent_apr, BigInteger_CommonKt.asRoundedPercentage(balanceInfo.getSupplyRate(), CurrencyDecimal_EthereumKt.getETH(CurrencyDecimal.INSTANCE)));
                    CurrencyCode currencyCode = balanceInfo.getLendToken().getCurrencyCode();
                    ContractAddress contractAddress = balanceInfo.getLendToken().getContractAddress();
                    kotlin.o<String, String> formattedAmounts = this$0.getFormattedAmounts(supplyBalance, currencyCode, contractAddress == null ? null : contractAddress.getRawValue(), balanceInfo.getLendToken().getDecimals());
                    if (formattedAmounts != null) {
                        obj = new LendDashboardItem.Provider(balanceInfo, str, formattedAmounts.c(), formattedAmounts.d());
                    }
                }
                if (obj != null) {
                    arrayList4.add(obj);
                }
            }
            if (!arrayList4.isEmpty()) {
                B0 = z.B0(arrayList4, new Comparator<T>() { // from class: com.coinbase.wallet.features.lend.viewmodels.LendDashboardViewModel$getItems$lambda-29$lambda-28$$inlined$sortedByDescending$1
                    @Override // java.util.Comparator
                    public final int compare(T t, T t2) {
                        int c2;
                        c2 = kotlin.b0.b.c(((LendDashboardItem.Provider) t2).getBalanceInfo().getLendToken().getSupplyBalance(), ((LendDashboardItem.Provider) t).getBalanceInfo().getLendToken().getSupplyBalance());
                        return c2;
                    }
                });
                obj = u.a(new LendDashboardItem.Token(this$0.getCurrencyFormatter(), exchangeRates, B0), B0);
            }
            if (obj != null) {
                arrayList2.add(obj);
            }
        }
        r2 = m0.r(arrayList2);
        return r2;
    }

    public static /* synthetic */ x h(LendDashboardViewModel lendDashboardViewModel, String str) {
        return m1275getAverageInterest$lambda23(lendDashboardViewModel, str);
    }

    public static /* synthetic */ Map i(List list) {
        return m1287walletMapSingle$lambda3(list);
    }

    public static /* synthetic */ List j(List list, List list2) {
        return m1282setup$lambda12$lambda11$lambda10(list, list2);
    }

    public static /* synthetic */ h0 k(LendDashboardViewModel lendDashboardViewModel, t tVar) {
        return m1280setup$lambda12(lendDashboardViewModel, tVar);
    }

    public static /* synthetic */ x l(LendDashboardViewModel lendDashboardViewModel, kotlin.o oVar) {
        return m1284setup$lambda17(lendDashboardViewModel, oVar);
    }

    public static /* synthetic */ x m(LendDashboardViewModel lendDashboardViewModel, kotlin.o oVar) {
        return m1278getInterestEarned$lambda22(lendDashboardViewModel, oVar);
    }

    private final void setData(List<? extends LendDashboardItem> list) {
        this.data = list;
        this.dataUpdatedSubject.onNext(list);
    }

    private final void setState(LendDashboardState lendDashboardState) {
        this.state = lendDashboardState;
        this.stateSubject.onNext(lendDashboardState);
    }

    /* renamed from: setup$lambda-12 */
    public static final h0 m1280setup$lambda12(LendDashboardViewModel this$0, t dstr$wallet$tokens$walletMap) {
        AnalyticsEvent lendDashboardConfirmed;
        int r;
        h.c.b0 zip;
        List g2;
        h.c.b0 just;
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(dstr$wallet$tokens$walletMap, "$dstr$wallet$tokens$walletMap");
        Wallet wallet = (Wallet) dstr$wallet$tokens$walletMap.a();
        List<LendToken> list = (List) dstr$wallet$tokens$walletMap.b();
        Map map = (Map) dstr$wallet$tokens$walletMap.c();
        if (list.isEmpty()) {
            lendDashboardConfirmed = AnalyticsEvent_ApplicationKt.lendDashboardPending(AnalyticsEvent.Companion);
        } else {
            lendDashboardConfirmed = AnalyticsEvent_ApplicationKt.lendDashboardConfirmed(AnalyticsEvent.Companion);
        }
        Analytics.INSTANCE.log(lendDashboardConfirmed);
        r = kotlin.a0.s.r(list, 10);
        ArrayList arrayList = new ArrayList(r);
        for (LendToken lendToken : list) {
            ContractAddress contractAddress = lendToken.getContractAddress();
            if (contractAddress == null) {
                just = h.c.b0.just(new kotlin.o(lendToken, wallet));
                kotlin.jvm.internal.m.f(just, "just(Pair(token, wallet))");
            } else {
                Wallet wallet2 = (Wallet) map.get(contractAddress);
                if (kotlin.jvm.internal.m.c(lendToken.getCurrencyCode(), CurrencyCode_EthereumKt.getETH(CurrencyCode.Companion))) {
                    wallet2 = (Wallet) map.get(null);
                }
                if (wallet2 != null) {
                    just = h.c.b0.just(new kotlin.o(lendToken, wallet2));
                } else {
                    String primaryAddress = wallet.getPrimaryAddress();
                    List<WalletAddress> addresses = wallet.getAddresses();
                    String name = lendToken.getName();
                    String rawValue = lendToken.getCurrencyCode().getRawValue();
                    Locale US = Locale.US;
                    kotlin.jvm.internal.m.f(US, "US");
                    Objects.requireNonNull(rawValue, "null cannot be cast to non-null type java.lang.String");
                    String upperCase = rawValue.toUpperCase(US);
                    kotlin.jvm.internal.m.f(upperCase, "(this as java.lang.String).toUpperCase(locale)");
                    CurrencyCode currencyCode = new CurrencyCode(upperCase);
                    BigInteger ZERO = BigInteger.ZERO;
                    kotlin.jvm.internal.m.f(ZERO, "ZERO");
                    just = h.c.b0.just(u.a(lendToken, new Wallet(primaryAddress, addresses, name, currencyCode, null, ZERO, lendToken.getDecimals(), wallet.getBlockchain(), null, EthereumChain_EthereumKt.getAsNetwork(EthereumChain.ETHEREUM_MAINNET), contractAddress.getRawValue(), wallet.getSelectedIndex())));
                }
                kotlin.jvm.internal.m.f(just, "if (userWallet != null) {\n                            Single.just(Pair(token, userWallet))\n                        } else {\n                            Single.just(\n                                token to Wallet(\n                                    primaryAddress = wallet.primaryAddress,\n                                    addresses = wallet.addresses,\n                                    displayName = token.name,\n                                    currencyCode = CurrencyCode(token.currencyCode.rawValue.toUpperCase(Locale.US)),\n                                    imageURL = null,\n                                    balance = BigInteger.ZERO,\n                                    decimals = token.decimals,\n                                    blockchain = wallet.blockchain,\n                                    minimumBalance = null,\n                                    network = EthereumChain.ETHEREUM_MAINNET.asNetwork,\n                                    contractAddress = contractAddress.rawValue,\n                                    selectedIndex = wallet.selectedIndex\n                                )\n                            )\n                        }");
            }
            arrayList.add(just);
        }
        h.c.t0.e eVar = h.c.t0.e.a;
        if (arrayList.isEmpty()) {
            g2 = r.g();
            zip = h.c.b0.just(g2);
            kotlin.jvm.internal.m.f(zip, "just(emptyList())");
        } else {
            zip = h.c.b0.zip(arrayList, new h.c.m0.n() { // from class: com.coinbase.wallet.features.lend.viewmodels.LendDashboardViewModel$setup$lambda-12$$inlined$zipOrEmpty$1
                @Override // h.c.m0.n
                public final List<T> apply(Object[] it) {
                    List<T> g3;
                    kotlin.jvm.internal.m.g(it, "it");
                    if (it.length == 0) {
                        g3 = r.g();
                        return g3;
                    }
                    ArrayList arrayList2 = new ArrayList();
                    int length = it.length;
                    for (int i2 = 0; i2 < length; i2++) {
                        Object obj = it[i2];
                        if (obj != null ? obj instanceof kotlin.o : true) {
                            arrayList2.add(obj);
                        }
                    }
                    return arrayList2;
                }
            });
            kotlin.jvm.internal.m.f(zip, "zip(singles) { if (it.isEmpty()) emptyList() else it.filterIsInstance<T>() }");
        }
        return zip.flatMap(new h.c.m0.n() { // from class: com.coinbase.wallet.features.lend.viewmodels.g
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return LendDashboardViewModel.e(LendDashboardViewModel.this, (List) obj);
            }
        });
    }

    /* renamed from: setup$lambda-12$lambda-11 */
    public static final h0 m1281setup$lambda12$lambda11(LendDashboardViewModel this$0, final List lendTokenAndWalletList) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(lendTokenAndWalletList, "lendTokenAndWalletList");
        return this$0.txHistoryRepository.getPendingTxs().map(new h.c.m0.n() { // from class: com.coinbase.wallet.features.lend.viewmodels.l
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return LendDashboardViewModel.j(lendTokenAndWalletList, (List) obj);
            }
        });
    }

    /* renamed from: setup$lambda-12$lambda-11$lambda-10 */
    public static final List m1282setup$lambda12$lambda11$lambda10(List lendTokenAndWalletList, List pendingTxList) {
        int r;
        kotlin.jvm.internal.m.g(lendTokenAndWalletList, "$lendTokenAndWalletList");
        kotlin.jvm.internal.m.g(pendingTxList, "pendingTxList");
        r = kotlin.a0.s.r(lendTokenAndWalletList, 10);
        ArrayList arrayList = new ArrayList(r);
        Iterator it = lendTokenAndWalletList.iterator();
        while (it.hasNext()) {
            kotlin.o oVar = (kotlin.o) it.next();
            LendToken lendToken = (LendToken) oVar.a();
            Wallet wallet = (Wallet) oVar.b();
            ArrayList arrayList2 = new ArrayList();
            for (Object obj : pendingTxList) {
                Object obj2 = ((Transaction) obj).getMetadata().get(TxMetadataKey_LendKt.getLendTokenID(TxMetadataKey.Companion));
                String str = obj2 instanceof String ? (String) obj2 : null;
                if (str == null ? false : kotlin.jvm.internal.m.c(str, lendToken.getId())) {
                    arrayList2.add(obj);
                }
            }
            kotlin.jvm.internal.m.f(wallet, "wallet");
            arrayList.add(new BalanceInfo(lendToken, wallet, arrayList2));
        }
        return arrayList;
    }

    /* renamed from: setup$lambda-13 */
    public static final h0 m1283setup$lambda13(LendDashboardViewModel this$0, h.c.b0 fiatBalanceObservable, List balanceInfoList) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(fiatBalanceObservable, "$fiatBalanceObservable");
        kotlin.jvm.internal.m.g(balanceInfoList, "balanceInfoList");
        h.c.t0.e eVar = h.c.t0.e.a;
        h.c.b0<x> asUnit = Single_CoreKt.asUnit(eVar.a(this$0.getAverageInterest(), fiatBalanceObservable));
        this$0.getInterestEarned().subscribe();
        return eVar.a(this$0.getItems(balanceInfoList), asUnit);
    }

    /* renamed from: setup$lambda-17 */
    public static final x m1284setup$lambda17(LendDashboardViewModel this$0, kotlin.o dstr$newData$_u24__u24) {
        String interestAPR;
        List b2;
        List<LendDashboardItem.Token> B0;
        int r;
        List u;
        List<? extends LendDashboardItem> t0;
        LendDashboardState copy;
        List m;
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(dstr$newData$_u24__u24, "$dstr$newData$_u24__u24");
        Map newData = (Map) dstr$newData$_u24__u24.a();
        boolean isEmpty = newData.isEmpty();
        if (isEmpty) {
            interestAPR = LocalizedStrings.INSTANCE.get(R.string.lend_dashboard_not_earning_interest);
        } else {
            interestAPR = this$0.state.getInterestAPR();
        }
        b2 = kotlin.a0.q.b(new LendDashboardItem.Balance(this$0.state.getFiatCurrencySymbol(), this$0.state.getBalance(), interestAPR, isEmpty, this$0.state.getFiatCurrencyCode()));
        B0 = z.B0(newData.keySet(), new Comparator<T>() { // from class: com.coinbase.wallet.features.lend.viewmodels.LendDashboardViewModel$setup$lambda-17$$inlined$sortedBy$1
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                int c2;
                BigDecimal negate = ((LendDashboardItem.Token) t).getTotalFiatValue().negate();
                kotlin.jvm.internal.m.f(negate, "this.negate()");
                BigDecimal negate2 = ((LendDashboardItem.Token) t2).getTotalFiatValue().negate();
                kotlin.jvm.internal.m.f(negate2, "this.negate()");
                c2 = kotlin.b0.b.c(negate, negate2);
                return c2;
            }
        });
        r = kotlin.a0.s.r(B0, 10);
        ArrayList arrayList = new ArrayList(r);
        for (LendDashboardItem.Token token : B0) {
            m = r.m(token);
            kotlin.jvm.internal.m.f(newData, "newData");
            m.addAll((Collection) Map_CoreKt.require(newData, token));
            arrayList.add(m);
        }
        u = kotlin.a0.s.u(arrayList);
        t0 = z.t0(b2, u);
        this$0.setData(t0);
        copy = r2.copy((r26 & 1) != 0 ? r2.balance : null, (r26 & 2) != 0 ? r2.interestAPR : null, (r26 & 4) != 0 ? r2.interestAPRTitle : null, (r26 & 8) != 0 ? r2.interestAPROpacity : 0.5d, (r26 & 16) != 0 ? r2.fiatCurrencySymbol : null, (r26 & 32) != 0 ? r2.fiatCurrencyCode : null, (r26 & 64) != 0 ? r2.contentOpacity : 1.0d, (r26 & 128) != 0 ? r2.lifetimeInterestEarned : null, (r26 & 256) != 0 ? r2.earnMore : null, (r26 & 512) != 0 ? this$0.state.showLendingActionSheet : false);
        this$0.setState(copy);
        return x.a;
    }

    /* renamed from: setup$lambda-4 */
    public static final h.c.x m1285setup$lambda4(LendDashboardViewModel this$0, Wallet wallet) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(wallet, "wallet");
        return this$0.txHistoryRepository.hasSyncedHistoryObservable(wallet.getBlockchain(), CurrencyCode_EthereumKt.getETH(CurrencyCode.Companion), wallet.getPrimaryAddress(), wallet.getNetwork());
    }

    /* renamed from: setup$lambda-5 */
    public static final x m1286setup$lambda5(LendDashboardViewModel this$0, String balance) {
        LendDashboardState copy;
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(balance, "balance");
        copy = r2.copy((r26 & 1) != 0 ? r2.balance : balance, (r26 & 2) != 0 ? r2.interestAPR : null, (r26 & 4) != 0 ? r2.interestAPRTitle : null, (r26 & 8) != 0 ? r2.interestAPROpacity : 0.0d, (r26 & 16) != 0 ? r2.fiatCurrencySymbol : null, (r26 & 32) != 0 ? r2.fiatCurrencyCode : null, (r26 & 64) != 0 ? r2.contentOpacity : 0.0d, (r26 & 128) != 0 ? r2.lifetimeInterestEarned : null, (r26 & 256) != 0 ? r2.earnMore : null, (r26 & 512) != 0 ? this$0.state.showLendingActionSheet : false);
        this$0.setState(copy);
        return x.a;
    }

    /* renamed from: walletMapSingle$lambda-3 */
    public static final Map m1287walletMapSingle$lambda3(List wallets) {
        kotlin.jvm.internal.m.g(wallets, "wallets");
        ArrayList<Wallet> arrayList = new ArrayList();
        for (Object obj : wallets) {
            if (kotlin.jvm.internal.m.c(((Wallet) obj).getBlockchain(), Blockchain_EthereumKt.getETHEREUM(Blockchain.Companion))) {
                arrayList.add(obj);
            }
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Wallet wallet : arrayList) {
            if (kotlin.jvm.internal.m.c(wallet.getCurrencyCode(), CurrencyCode_EthereumKt.getETH(CurrencyCode.Companion))) {
                linkedHashMap.put(null, wallet);
            } else {
                String contractAddress = wallet.getContractAddress();
                if (contractAddress != null) {
                    linkedHashMap.put(new ContractAddress(contractAddress), wallet);
                }
            }
        }
        return linkedHashMap;
    }

    public final void dismissView() {
        this.dismissSubject.onNext(x.a);
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

    public final s<List<LendDashboardItem>> getDataUpdatedObservable() {
        return this.dataUpdatedObservable;
    }

    public final s<x> getDismissObservable() {
        return this.dismissObservable;
    }

    @Override // com.coinbase.wallet.features.lend.interfaces.LendBalanceManaging
    public s<List<ExchangeRate>> getExchangeRateObservable() {
        return this.exchangeRateObservable;
    }

    @Override // com.coinbase.wallet.features.lend.interfaces.LendBalanceManaging
    public ILendRepository getLendRepository() {
        return this.lendRepository;
    }

    public final s<ViewModelNavRoute> getNavigationObservable() {
        return this.navigationObservable;
    }

    public final String getSelectedItemDescription() {
        LendDashboardItem.Provider provider = this.selectedItem;
        String description = provider == null ? null : provider.getDescription();
        return description == null ? Strings_CoreKt.getEmpty(Strings.INSTANCE) : description;
    }

    public final s<LendDashboardState> getStateObservable() {
        return this.stateObservable;
    }

    @Override // com.coinbase.wallet.features.lend.interfaces.LendBalanceManaging
    public h.c.b0<String> getTotalFiatBalance() {
        return LendBalanceManaging.DefaultImpls.getTotalFiatBalance(this);
    }

    public final void hideLendingActionSheet() {
        LendDashboardState copy;
        this.selectedItem = null;
        copy = r2.copy((r26 & 1) != 0 ? r2.balance : null, (r26 & 2) != 0 ? r2.interestAPR : null, (r26 & 4) != 0 ? r2.interestAPRTitle : null, (r26 & 8) != 0 ? r2.interestAPROpacity : 0.0d, (r26 & 16) != 0 ? r2.fiatCurrencySymbol : null, (r26 & 32) != 0 ? r2.fiatCurrencyCode : null, (r26 & 64) != 0 ? r2.contentOpacity : 0.0d, (r26 & 128) != 0 ? r2.lifetimeInterestEarned : null, (r26 & 256) != 0 ? r2.earnMore : null, (r26 & 512) != 0 ? this.state.showLendingActionSheet : false);
        setState(copy);
    }

    @Override // androidx.lifecycle.b0
    public void onCleared() {
        super.onCleared();
        getLendRepository().updateRefreshInterval(RefreshInterval.FIVE_MIN);
    }

    public final void proceedToCoinPicker() {
        Analytics.INSTANCE.log(AnalyticsEvent_ApplicationKt.lendDashboardEarnMoreStart(AnalyticsEvent.Companion));
        this.navigationSubject.onNext(new ViewModelNavRoute(R.id.action_lendDashboardFragment_to_lendCoinPickerFragment, LendCoinPickerArgs.INSTANCE.createArguments(ContractAction.SUPPLY), null, 4, null));
    }

    public final void proceedToSupply() {
        ViewModelNavRoute viewModelNavRoute;
        LendDashboardItem.Provider provider = this.selectedItem;
        if (provider != null) {
            Analytics.INSTANCE.log(AnalyticsEvent_ApplicationKt.lendDashboardEarnMoreLendStart(AnalyticsEvent.Companion));
            if (BigInteger_ApplicationKt.isMoreThanZero(provider.getBalanceInfo().getWallet().getBalance())) {
                Wallet wallet = provider.getBalanceInfo().getWallet();
                ContractAction contractAction = ContractAction.SUPPLY;
                viewModelNavRoute = new ViewModelNavRoute(R.id.action_lendDashboardFragment_to_sendAmountPickerFragment, LendAmountPickerArgs.INSTANCE.createArguments(wallet, provider.getBalanceInfo().getLendToken(), contractAction), null, 4, null);
            } else {
                viewModelNavRoute = new ViewModelNavRoute(R.id.action_lendDashboardFragment_to_lendCoinPickerFragment, LendCoinPickerArgs.INSTANCE.createArguments(ContractAction.SUPPLY), null, 4, null);
            }
            this.navigationSubject.onNext(viewModelNavRoute);
            return;
        }
        proceedToCoinPicker();
    }

    public final void proceedToWithdraw() {
        Analytics.INSTANCE.log(AnalyticsEvent_ApplicationKt.lendDashboardEarnMoreWithdrawStart(AnalyticsEvent.Companion));
        LendDashboardItem.Provider provider = this.selectedItem;
        if (provider == null) {
            return;
        }
        Wallet wallet = provider.getBalanceInfo().getWallet();
        ContractAction contractAction = ContractAction.WITHDRAW;
        this.navigationSubject.onNext(new ViewModelNavRoute(R.id.action_lendDashboardFragment_to_sendAmountPickerFragment, LendAmountPickerArgs.INSTANCE.createArguments(wallet, provider.getBalanceInfo().getLendToken(), contractAction), null, 4, null));
    }

    @SuppressLint({"CheckResult"})
    public final s<x> setup() {
        getLendRepository().updateRefreshInterval(RefreshInterval.DEFAULT);
        h.c.t0.g.i(getLendRepository().refresh(true), null, LendDashboardViewModel$setup$1.INSTANCE, 1, null);
        h.c.x flatMap = this.walletSingle.toObservable().flatMap(new h.c.m0.n() { // from class: com.coinbase.wallet.features.lend.viewmodels.d
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return LendDashboardViewModel.b(LendDashboardViewModel.this, (Wallet) obj);
            }
        });
        kotlin.jvm.internal.m.f(flatMap, "walletSingle.toObservable()\n            .flatMap { wallet ->\n                txHistoryRepository.hasSyncedHistoryObservable(\n                    blockchain = wallet.blockchain,\n                    currencyCode = CurrencyCode.ETH,\n                    address = wallet.primaryAddress,\n                    network = wallet.network\n                )\n            }");
        final h.c.b0<R> map = getTotalFiatBalance().observeOn(h.c.j0.c.a.b()).map(new h.c.m0.n() { // from class: com.coinbase.wallet.features.lend.viewmodels.h
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return LendDashboardViewModel.f(LendDashboardViewModel.this, (String) obj);
            }
        });
        kotlin.jvm.internal.m.f(map, "getTotalFiatBalance()\n            .observeOn(AndroidSchedulers.mainThread())\n            .map { balance -> state = state.copy(balance = balance) }");
        h.c.t0.c cVar = h.c.t0.c.a;
        s<Wallet> observable = this.walletSingle.toObservable();
        kotlin.jvm.internal.m.f(observable, "walletSingle.toObservable()");
        s<List<LendToken>> observeTokens = getLendRepository().observeTokens();
        s<Map<ContractAddress, Wallet>> observable2 = this.walletMapSingle.toObservable();
        kotlin.jvm.internal.m.f(observable2, "walletMapSingle.toObservable()");
        s flatMapSingle = s.combineLatest(observable, observeTokens, observable2, flatMap, new h.c.m0.h<T1, T2, T3, T4, R>() { // from class: com.coinbase.wallet.features.lend.viewmodels.LendDashboardViewModel$setup$$inlined$combineLatest$1
            @Override // h.c.m0.h
            public final R apply(T1 t1, T2 t2, T3 t3, T4 t4) {
                ((Boolean) t4).booleanValue();
                return (R) new t((Wallet) t1, (List) t2, (Map) t3);
            }
        }).flatMapSingle(new h.c.m0.n() { // from class: com.coinbase.wallet.features.lend.viewmodels.m
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return LendDashboardViewModel.k(LendDashboardViewModel.this, (t) obj);
            }
        });
        kotlin.jvm.internal.m.f(flatMapSingle, "Observables\n            .combineLatest(\n                walletSingle.toObservable(),\n                lendRepository.observeTokens(),\n                walletMapSingle.toObservable(),\n                historySyncedObservable\n            ) { wallet, tokens, walletMap, _ ->\n                Triple(wallet, tokens, walletMap)\n            }\n            .flatMapSingle { (wallet, tokens, walletMap) ->\n                val event = if (tokens.isEmpty()) {\n                    AnalyticsEvent.lendDashboardPending()\n                } else {\n                    AnalyticsEvent.lendDashboardConfirmed()\n                }\n                Analytics.log(event)\n\n                tokens\n                    .map { token ->\n                        val contractAddress = token.contractAddress\n                            ?: return@map Single.just(Pair(token, wallet))\n\n                        var userWallet = walletMap[contractAddress]\n                        // Special logic to deal with ethereum as some lending returns WETH contract address\n                        // for ethereum underlying address (e.g aave-v2), groups the ethereum into one section.\n                        if (token.currencyCode == CurrencyCode.ETH) {\n                            userWallet = walletMap[null]\n                        }\n\n                        if (userWallet != null) {\n                            Single.just(Pair(token, userWallet))\n                        } else {\n                            Single.just(\n                                token to Wallet(\n                                    primaryAddress = wallet.primaryAddress,\n                                    addresses = wallet.addresses,\n                                    displayName = token.name,\n                                    currencyCode = CurrencyCode(token.currencyCode.rawValue.toUpperCase(Locale.US)),\n                                    imageURL = null,\n                                    balance = BigInteger.ZERO,\n                                    decimals = token.decimals,\n                                    blockchain = wallet.blockchain,\n                                    minimumBalance = null,\n                                    network = EthereumChain.ETHEREUM_MAINNET.asNetwork,\n                                    contractAddress = contractAddress.rawValue,\n                                    selectedIndex = wallet.selectedIndex\n                                )\n                            )\n                        }\n                    }\n                    .zipOrEmpty()\n                    .flatMap { lendTokenAndWalletList ->\n                        txHistoryRepository.getPendingTxs()\n                            .map { pendingTxList ->\n                                lendTokenAndWalletList.map { (token, wallet) ->\n                                    // Find any matching pending txs associated w/ this token's lendTokenId\n                                    val lendTxs = pendingTxList.filter { pendingTx ->\n                                        val tokenID = pendingTx.metadata[TxMetadataKey.lendTokenID] as? String\n                                            ?: return@filter false\n\n                                        tokenID == token.id\n                                    }\n                                    BalanceInfo(\n                                        lendToken = token,\n                                        wallet = wallet,\n                                        pendingTxs = lendTxs // Empty if no pending tx's\n                                    )\n                                }\n                            }\n                    }\n            }");
        s<x> map2 = Observable_AnalyticsKt.logError$default(flatMapSingle, null, null, 3, null).observeOn(h.c.j0.c.a.b()).flatMapSingle(new h.c.m0.n() { // from class: com.coinbase.wallet.features.lend.viewmodels.e
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                h0 m1283setup$lambda13;
                m1283setup$lambda13 = LendDashboardViewModel.m1283setup$lambda13(LendDashboardViewModel.this, map, (List) obj);
                return m1283setup$lambda13;
            }
        }).map(new h.c.m0.n() { // from class: com.coinbase.wallet.features.lend.viewmodels.n
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return LendDashboardViewModel.l(LendDashboardViewModel.this, (kotlin.o) obj);
            }
        });
        kotlin.jvm.internal.m.f(map2, "Observables\n            .combineLatest(\n                walletSingle.toObservable(),\n                lendRepository.observeTokens(),\n                walletMapSingle.toObservable(),\n                historySyncedObservable\n            ) { wallet, tokens, walletMap, _ ->\n                Triple(wallet, tokens, walletMap)\n            }\n            .flatMapSingle { (wallet, tokens, walletMap) ->\n                val event = if (tokens.isEmpty()) {\n                    AnalyticsEvent.lendDashboardPending()\n                } else {\n                    AnalyticsEvent.lendDashboardConfirmed()\n                }\n                Analytics.log(event)\n\n                tokens\n                    .map { token ->\n                        val contractAddress = token.contractAddress\n                            ?: return@map Single.just(Pair(token, wallet))\n\n                        var userWallet = walletMap[contractAddress]\n                        // Special logic to deal with ethereum as some lending returns WETH contract address\n                        // for ethereum underlying address (e.g aave-v2), groups the ethereum into one section.\n                        if (token.currencyCode == CurrencyCode.ETH) {\n                            userWallet = walletMap[null]\n                        }\n\n                        if (userWallet != null) {\n                            Single.just(Pair(token, userWallet))\n                        } else {\n                            Single.just(\n                                token to Wallet(\n                                    primaryAddress = wallet.primaryAddress,\n                                    addresses = wallet.addresses,\n                                    displayName = token.name,\n                                    currencyCode = CurrencyCode(token.currencyCode.rawValue.toUpperCase(Locale.US)),\n                                    imageURL = null,\n                                    balance = BigInteger.ZERO,\n                                    decimals = token.decimals,\n                                    blockchain = wallet.blockchain,\n                                    minimumBalance = null,\n                                    network = EthereumChain.ETHEREUM_MAINNET.asNetwork,\n                                    contractAddress = contractAddress.rawValue,\n                                    selectedIndex = wallet.selectedIndex\n                                )\n                            )\n                        }\n                    }\n                    .zipOrEmpty()\n                    .flatMap { lendTokenAndWalletList ->\n                        txHistoryRepository.getPendingTxs()\n                            .map { pendingTxList ->\n                                lendTokenAndWalletList.map { (token, wallet) ->\n                                    // Find any matching pending txs associated w/ this token's lendTokenId\n                                    val lendTxs = pendingTxList.filter { pendingTx ->\n                                        val tokenID = pendingTx.metadata[TxMetadataKey.lendTokenID] as? String\n                                            ?: return@filter false\n\n                                        tokenID == token.id\n                                    }\n                                    BalanceInfo(\n                                        lendToken = token,\n                                        wallet = wallet,\n                                        pendingTxs = lendTxs // Empty if no pending tx's\n                                    )\n                                }\n                            }\n                    }\n            }\n            .logError()\n            .observeOn(AndroidSchedulers.mainThread())\n            .flatMapSingle { balanceInfoList ->\n                val balancesSingle = Singles.zip(\n                    getAverageInterest(),\n                    fiatBalanceObservable\n                ).asUnit()\n\n                getInterestEarned().subscribe()\n\n                Singles.zip(getItems(balanceInfos = balanceInfoList), balancesSingle)\n            }\n            .map { (newData, _) ->\n                val isZeroBalance = newData.isEmpty()\n                val balanceInterestText = if (isZeroBalance) {\n                    LocalizedStrings[R.string.lend_dashboard_not_earning_interest]\n                } else {\n                    state.interestAPR\n                }\n\n                val balance = LendDashboardItem.Balance(\n                    state.fiatCurrencySymbol,\n                    state.balance,\n                    balanceInterestText,\n                    isZeroBalance,\n                    state.fiatCurrencyCode\n                )\n\n                data = listOf(balance) + newData.keys\n                    .sortedBy { -it.totalFiatValue }\n                    .map {\n                        mutableListOf<LendDashboardItem>(it).also { list -> list.addAll(newData.require(it)) }\n                    }\n                    .flatten()\n\n                state = state.copy(contentOpacity = 1.0, interestAPROpacity = 0.5)\n            }");
        return map2;
    }

    public final void showLendingActionSheet(LendDashboardItem.Provider item) {
        LendDashboardState copy;
        kotlin.jvm.internal.m.g(item, "item");
        this.selectedItem = item;
        copy = r3.copy((r26 & 1) != 0 ? r3.balance : null, (r26 & 2) != 0 ? r3.interestAPR : null, (r26 & 4) != 0 ? r3.interestAPRTitle : null, (r26 & 8) != 0 ? r3.interestAPROpacity : 0.0d, (r26 & 16) != 0 ? r3.fiatCurrencySymbol : null, (r26 & 32) != 0 ? r3.fiatCurrencyCode : null, (r26 & 64) != 0 ? r3.contentOpacity : 0.0d, (r26 & 128) != 0 ? r3.lifetimeInterestEarned : null, (r26 & 256) != 0 ? r3.earnMore : null, (r26 & 512) != 0 ? this.state.showLendingActionSheet : true);
        setState(copy);
    }
}