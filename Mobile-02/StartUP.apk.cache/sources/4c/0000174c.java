package com.coinbase.wallet.consumer.viewmodels;

import android.os.Bundle;
import com.appsflyer.internal.referrer.Payload;
import com.coinbase.ApiConstants;
import com.coinbase.ciphercore.ethereum.EthereumChain;
import com.coinbase.errors.CoinbaseException;
import com.coinbase.wallet.analytics.Analytics;
import com.coinbase.wallet.analytics.extensions.Single_AnalyticsKt;
import com.coinbase.wallet.analytics.models.AnalyticsEvent;
import com.coinbase.wallet.blockchains.models.Blockchain;
import com.coinbase.wallet.blockchains.models.CurrencyCode;
import com.coinbase.wallet.blockchains.models.Network;
import com.coinbase.wallet.blockchains.models.TransferValue;
import com.coinbase.wallet.blockchains.models.Wallet;
import com.coinbase.wallet.common.extensions.BigDecimal_CommonKt;
import com.coinbase.wallet.common.extensions.BigInteger_CommonKt;
import com.coinbase.wallet.common.extensions.List_WalletsKt;
import com.coinbase.wallet.common.utilities.LocalizedStrings;
import com.coinbase.wallet.commonui.models.ActionStyle;
import com.coinbase.wallet.commonui.models.ForwardArgs;
import com.coinbase.wallet.commonui.models.ViewModelNavRoute;
import com.coinbase.wallet.commonui.utilities.PromptDialogHelper;
import com.coinbase.wallet.commonui.viewmodels.AmountViewModel;
import com.coinbase.wallet.commonui.views.NumberKeyboardDigit;
import com.coinbase.wallet.consumer.R;
import com.coinbase.wallet.consumer.extensions.AnalyticsEvent_ConsumerKt;
import com.coinbase.wallet.consumer.extensions.StoreKeys_ConsumerConnectKt;
import com.coinbase.wallet.consumer.models.AvailableSendTransfer;
import com.coinbase.wallet.consumer.models.ConsumerAccount;
import com.coinbase.wallet.consumer.models.ConsumerAmountPickerEvent;
import com.coinbase.wallet.consumer.models.ConsumerAmountPickerViewState;
import com.coinbase.wallet.consumer.models.ConsumerAvailableTransferContainer;
import com.coinbase.wallet.consumer.models.ConsumerCardCDVArgs;
import com.coinbase.wallet.consumer.models.ConsumerCardCDVResult;
import com.coinbase.wallet.consumer.models.ConsumerTransferConfirmationArgs;
import com.coinbase.wallet.consumer.models.ConsumerTransferMethodResult;
import com.coinbase.wallet.consumer.models.ConsumerTransferMethodsArgs;
import com.coinbase.wallet.consumer.models.ReceivableWallet;
import com.coinbase.wallet.consumer.models.TransferMoneyRequest;
import com.coinbase.wallet.consumer.repositories.ConsumerTransferRepository;
import com.coinbase.wallet.core.extensions.Observable_CoreKt;
import com.coinbase.wallet.core.extensions.Strings;
import com.coinbase.wallet.core.extensions.Strings_CoreKt;
import com.coinbase.wallet.core.util.Optional;
import com.coinbase.wallet.ethereum.extensions.Blockchain_EthereumKt;
import com.coinbase.wallet.ethereum.extensions.Network_EthereumKt;
import com.coinbase.wallet.ethereum.extensions.WalletConfiguration_EthereumKt;
import com.coinbase.wallet.ethereum.models.EthereumBasedConfiguration;
import com.coinbase.wallet.store.interfaces.StoreInterface;
import com.coinbase.wallet.store.models.StoreKeys;
import com.coinbase.wallet.wallets.formatters.CurrencyFormatter;
import com.coinbase.wallet.wallets.interfaces.IExchangeRateRepository;
import com.coinbase.wallet.wallets.interfaces.IFiatCurrencyRepository;
import com.coinbase.wallet.wallets.interfaces.IWalletRepository;
import com.coinbase.wallet.wallets.models.CryptoCurrency;
import io.reactivex.exceptions.CompositeException;
import java.math.BigDecimal;
import java.math.MathContext;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.Callable;
import kotlin.Metadata;
import org.spongycastle.asn1.cmp.PKIFailureInfo;

/* compiled from: ConsumerAmountPickerViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Ú\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001:\u0001qBK\b\u0007\u0012\u0006\u0010_\u001a\u00020^\u0012\u0006\u00102\u001a\u000201\u0012\u0006\u0010h\u001a\u00020g\u0012\u0006\u0010'\u001a\u00020&\u0012\u0006\u0010N\u001a\u00020M\u0012\u0006\u0010k\u001a\u00020j\u0012\u0006\u0010/\u001a\u00020.\u0012\b\b\u0001\u0010R\u001a\u00020Q¢\u0006\u0004\bo\u0010pJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\u000b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u001d\u0010\u0015\u001a\u00020\u00022\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012H\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u001d\u0010\u0019\u001a\u00020\u00022\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00170\u0012H\u0002¢\u0006\u0004\b\u0019\u0010\u0016J/\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00020\u001a2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u00122\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00170\u0012¢\u0006\u0004\b\u001b\u0010\u001cJ\u001d\u0010!\u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010 \u001a\u00020\u001f¢\u0006\u0004\b!\u0010\"J\r\u0010#\u001a\u00020\u0002¢\u0006\u0004\b#\u0010\u0004J\r\u0010$\u001a\u00020\u0002¢\u0006\u0004\b$\u0010\u0004J\r\u0010%\u001a\u00020\u0002¢\u0006\u0004\b%\u0010\u0004R\u0016\u0010'\u001a\u00020&8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b'\u0010(R\u0016\u0010)\u001a\u00020\u001f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b)\u0010*R\u001c\u0010,\u001a\b\u0012\u0004\u0012\u00020+0\u001a8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b,\u0010-R\u0016\u0010/\u001a\u00020.8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b/\u00100R\u0016\u00102\u001a\u0002018\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b2\u00103R\u001d\u00108\u001a\u00020\u001f8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b4\u00105\u001a\u0004\b6\u00107R\u0016\u0010:\u001a\u0002098\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b:\u0010;R#\u0010@\u001a\b\u0012\u0004\u0012\u00020<0\u00128F@\u0006X\u0086\u0084\u0002¢\u0006\f\n\u0004\b=\u00105\u001a\u0004\b>\u0010?R\u0018\u0010B\u001a\u0004\u0018\u00010A8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bB\u0010CR\u0016\u0010D\u001a\u0002098\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bD\u0010;R\u0016\u0010F\u001a\u00020E8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\bF\u0010GR$\u0010K\u001a\u0010\u0012\f\u0012\n J*\u0004\u0018\u00010I0I0H8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bK\u0010LR\u0016\u0010N\u001a\u00020M8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bN\u0010OR$\u0010P\u001a\u0010\u0012\f\u0012\n J*\u0004\u0018\u00010<0<0H8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bP\u0010LR\u0016\u0010R\u001a\u00020Q8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bR\u0010SR$\u0010U\u001a\u00020<2\u0006\u0010T\u001a\u00020<8\u0002@BX\u0082\u000e¢\u0006\f\n\u0004\bU\u0010V\"\u0004\bW\u0010XR\u001f\u0010Y\u001a\b\u0012\u0004\u0012\u00020I0\u00128\u0006@\u0006¢\u0006\f\n\u0004\bY\u0010Z\u001a\u0004\b[\u0010?R$\u0010]\u001a\u0010\u0012\f\u0012\n J*\u0004\u0018\u00010\\0\\0H8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b]\u0010LR\u0016\u0010_\u001a\u00020^8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b_\u0010`R\u001d\u0010e\u001a\u00020a8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\bb\u00105\u001a\u0004\bc\u0010dR\u0018\u0010f\u001a\u0004\u0018\u00010A8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bf\u0010CR\u0016\u0010h\u001a\u00020g8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bh\u0010iR\u0016\u0010k\u001a\u00020j8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bk\u0010lR\u001f\u0010m\u001a\b\u0012\u0004\u0012\u00020\\0\u00128\u0006@\u0006¢\u0006\f\n\u0004\bm\u0010Z\u001a\u0004\bn\u0010?¨\u0006r"}, d2 = {"Lcom/coinbase/wallet/consumer/viewmodels/ConsumerAmountPickerViewModel;", "Landroidx/lifecycle/b0;", "Lkotlin/x;", "observeAmountUpdates", "()V", "Ljava/util/UUID;", "uuid", "fetchMaxTransferableAmount", "(Ljava/util/UUID;)V", "", "cryptoAmountString", "updateCryptoAmount", "(Ljava/lang/String;Ljava/util/UUID;)V", "Lcom/coinbase/wallet/consumer/models/AvailableSendTransfer;", "transfer", "Lcom/coinbase/wallet/commonui/utilities/PromptDialogHelper$Properties;", "generateWblPrompt", "(Lcom/coinbase/wallet/consumer/models/AvailableSendTransfer;)Lcom/coinbase/wallet/commonui/utilities/PromptDialogHelper$Properties;", "Lh/c/s;", "Lcom/coinbase/wallet/consumer/models/ConsumerTransferMethodResult;", "transferResultObservable", "observeTransferMethodsResult", "(Lh/c/s;)V", "Lcom/coinbase/wallet/consumer/models/ConsumerCardCDVResult;", "cardVerificationResultObservable", "observeCardVerificationResult", "Lh/c/b0;", "setup", "(Lh/c/s;Lh/c/s;)Lh/c/b0;", "Lcom/coinbase/wallet/commonui/views/NumberKeyboardDigit;", "digit", "", "longPress", "inputDigit", "(Lcom/coinbase/wallet/commonui/views/NumberKeyboardDigit;Z)V", "swapFields", "displayMaxAmount", "nextAction", "Lcom/coinbase/wallet/wallets/formatters/CurrencyFormatter;", "currencyFormatter", "Lcom/coinbase/wallet/wallets/formatters/CurrencyFormatter;", "isSendingEntireBalance", "Z", "Ljava/math/BigDecimal;", "consumerExchangeRateSingle", "Lh/c/b0;", "Lcom/coinbase/wallet/wallets/interfaces/IExchangeRateRepository;", "exchangeRateRepository", "Lcom/coinbase/wallet/wallets/interfaces/IExchangeRateRepository;", "Lcom/coinbase/wallet/commonui/viewmodels/AmountViewModel;", "amountViewModel", "Lcom/coinbase/wallet/commonui/viewmodels/AmountViewModel;", "onrampEnabled$delegate", "Lkotlin/h;", "getOnrampEnabled", "()Z", "onrampEnabled", "Lh/c/k0/a;", "disposeBag", "Lh/c/k0/a;", "Lcom/coinbase/wallet/consumer/models/ConsumerAmountPickerViewState;", "stateObservable$delegate", "getStateObservable", "()Lh/c/s;", "stateObservable", "Lcom/coinbase/wallet/consumer/models/TransferMoneyRequest;", "cachedTransferForTransferMethods", "Lcom/coinbase/wallet/consumer/models/TransferMoneyRequest;", "amountUpdateDisposable", "Lcom/coinbase/wallet/consumer/models/ReceivableWallet;", "wallet", "Lcom/coinbase/wallet/consumer/models/ReceivableWallet;", "Lh/c/v0/b;", "Lcom/coinbase/wallet/commonui/models/ViewModelNavRoute;", "kotlin.jvm.PlatformType", "navigateSubject", "Lh/c/v0/b;", "Lcom/coinbase/wallet/store/interfaces/StoreInterface;", Payload.TYPE_STORE, "Lcom/coinbase/wallet/store/interfaces/StoreInterface;", "stateSubject", "Landroidx/lifecycle/z;", "savedStateHandle", "Landroidx/lifecycle/z;", "value", ApiConstants.STATE, "Lcom/coinbase/wallet/consumer/models/ConsumerAmountPickerViewState;", "setState", "(Lcom/coinbase/wallet/consumer/models/ConsumerAmountPickerViewState;)V", "navigateObservable", "Lh/c/s;", "getNavigateObservable", "Lcom/coinbase/wallet/consumer/models/ConsumerAmountPickerEvent;", "eventSubject", "Lcom/coinbase/wallet/wallets/interfaces/IFiatCurrencyRepository;", "currencyRepository", "Lcom/coinbase/wallet/wallets/interfaces/IFiatCurrencyRepository;", "Lcom/coinbase/wallet/consumer/models/ConsumerAccount;", "consumerAccount$delegate", "getConsumerAccount", "()Lcom/coinbase/wallet/consumer/models/ConsumerAccount;", "consumerAccount", "cachedTransfer", "Lcom/coinbase/wallet/wallets/interfaces/IWalletRepository;", "walletRepository", "Lcom/coinbase/wallet/wallets/interfaces/IWalletRepository;", "Lcom/coinbase/wallet/consumer/repositories/ConsumerTransferRepository;", "consumerTransferRepository", "Lcom/coinbase/wallet/consumer/repositories/ConsumerTransferRepository;", "eventObservable", "getEventObservable", "<init>", "(Lcom/coinbase/wallet/wallets/interfaces/IFiatCurrencyRepository;Lcom/coinbase/wallet/commonui/viewmodels/AmountViewModel;Lcom/coinbase/wallet/wallets/interfaces/IWalletRepository;Lcom/coinbase/wallet/wallets/formatters/CurrencyFormatter;Lcom/coinbase/wallet/store/interfaces/StoreInterface;Lcom/coinbase/wallet/consumer/repositories/ConsumerTransferRepository;Lcom/coinbase/wallet/wallets/interfaces/IExchangeRateRepository;Landroidx/lifecycle/z;)V", "Factory", "consumer_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class ConsumerAmountPickerViewModel extends androidx.lifecycle.b0 {
    private final h.c.k0.a amountUpdateDisposable;
    private final AmountViewModel amountViewModel;
    private TransferMoneyRequest cachedTransfer;
    private TransferMoneyRequest cachedTransferForTransferMethods;
    private final kotlin.h consumerAccount$delegate;
    private final h.c.b0<BigDecimal> consumerExchangeRateSingle;
    private final ConsumerTransferRepository consumerTransferRepository;
    private final CurrencyFormatter currencyFormatter;
    private final IFiatCurrencyRepository currencyRepository;
    private final h.c.k0.a disposeBag;
    private final h.c.s<ConsumerAmountPickerEvent> eventObservable;
    private final h.c.v0.b<ConsumerAmountPickerEvent> eventSubject;
    private final IExchangeRateRepository exchangeRateRepository;
    private boolean isSendingEntireBalance;
    private final h.c.s<ViewModelNavRoute> navigateObservable;
    private final h.c.v0.b<ViewModelNavRoute> navigateSubject;
    private final kotlin.h onrampEnabled$delegate;
    private final androidx.lifecycle.z savedStateHandle;
    private ConsumerAmountPickerViewState state;
    private final kotlin.h stateObservable$delegate;
    private final h.c.v0.b<ConsumerAmountPickerViewState> stateSubject;
    private final StoreInterface store;
    private ReceivableWallet wallet;
    private final IWalletRepository walletRepository;

    /* compiled from: ConsumerAmountPickerViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/coinbase/wallet/consumer/viewmodels/ConsumerAmountPickerViewModel$Factory;", "", "Landroidx/lifecycle/z;", "savedStateHandle", "Lcom/coinbase/wallet/consumer/viewmodels/ConsumerAmountPickerViewModel;", "create", "(Landroidx/lifecycle/z;)Lcom/coinbase/wallet/consumer/viewmodels/ConsumerAmountPickerViewModel;", "consumer_productionRelease"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public interface Factory {
        ConsumerAmountPickerViewModel create(androidx.lifecycle.z zVar);
    }

    public ConsumerAmountPickerViewModel(IFiatCurrencyRepository currencyRepository, AmountViewModel amountViewModel, IWalletRepository walletRepository, CurrencyFormatter currencyFormatter, StoreInterface store, ConsumerTransferRepository consumerTransferRepository, IExchangeRateRepository exchangeRateRepository, androidx.lifecycle.z savedStateHandle) {
        kotlin.h b2;
        kotlin.h b3;
        kotlin.h b4;
        kotlin.jvm.internal.m.g(currencyRepository, "currencyRepository");
        kotlin.jvm.internal.m.g(amountViewModel, "amountViewModel");
        kotlin.jvm.internal.m.g(walletRepository, "walletRepository");
        kotlin.jvm.internal.m.g(currencyFormatter, "currencyFormatter");
        kotlin.jvm.internal.m.g(store, "store");
        kotlin.jvm.internal.m.g(consumerTransferRepository, "consumerTransferRepository");
        kotlin.jvm.internal.m.g(exchangeRateRepository, "exchangeRateRepository");
        kotlin.jvm.internal.m.g(savedStateHandle, "savedStateHandle");
        this.currencyRepository = currencyRepository;
        this.amountViewModel = amountViewModel;
        this.walletRepository = walletRepository;
        this.currencyFormatter = currencyFormatter;
        this.store = store;
        this.consumerTransferRepository = consumerTransferRepository;
        this.exchangeRateRepository = exchangeRateRepository;
        this.savedStateHandle = savedStateHandle;
        h.c.v0.b<ConsumerAmountPickerViewState> d2 = h.c.v0.b.d();
        kotlin.jvm.internal.m.f(d2, "create<ConsumerAmountPickerViewState>()");
        this.stateSubject = d2;
        h.c.v0.b<ViewModelNavRoute> d3 = h.c.v0.b.d();
        kotlin.jvm.internal.m.f(d3, "create<ViewModelNavRoute>()");
        this.navigateSubject = d3;
        h.c.v0.b<ConsumerAmountPickerEvent> d4 = h.c.v0.b.d();
        kotlin.jvm.internal.m.f(d4, "create<ConsumerAmountPickerEvent>()");
        this.eventSubject = d4;
        this.amountUpdateDisposable = new h.c.k0.a();
        this.disposeBag = new h.c.k0.a();
        h.c.b0<BigDecimal> map = Observable_CoreKt.takeSingle(exchangeRateRepository.getExchangeRateObservable()).map(new h.c.m0.n() { // from class: com.coinbase.wallet.consumer.viewmodels.c0
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return ConsumerAmountPickerViewModel.o(ConsumerAmountPickerViewModel.this, (List) obj);
            }
        }).map(new h.c.m0.n() { // from class: com.coinbase.wallet.consumer.viewmodels.n
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return ConsumerAmountPickerViewModel.b((BigDecimal) obj);
            }
        });
        kotlin.jvm.internal.m.f(map, "exchangeRateRepository.exchangeRateObservable\n        .takeSingle()\n        .map { exchangeRates ->\n            exchangeRates.rateFor(\n                currencyCode = consumerAccount.currencyCode,\n                contractAddress = null,\n                name = consumerAccount.currencyName\n            ) ?: throw NullPointerException()\n        }\n        .map { BigDecimal.ONE.divide(it, MathContext.DECIMAL128) }");
        this.consumerExchangeRateSingle = map;
        b2 = kotlin.k.b(new ConsumerAmountPickerViewModel$onrampEnabled$2(this));
        this.onrampEnabled$delegate = b2;
        b3 = kotlin.k.b(new ConsumerAmountPickerViewModel$consumerAccount$2(this));
        this.consumerAccount$delegate = b3;
        this.state = new ConsumerAmountPickerViewState(null, false, false, false, false, null, null, false, null, null, false, null, null, false, null, 32767, null);
        h.c.s<ViewModelNavRoute> hide = d3.hide();
        kotlin.jvm.internal.m.f(hide, "navigateSubject.hide()");
        this.navigateObservable = hide;
        h.c.s<ConsumerAmountPickerEvent> hide2 = d4.hide();
        kotlin.jvm.internal.m.f(hide2, "eventSubject.hide()");
        this.eventObservable = hide2;
        b4 = kotlin.k.b(new ConsumerAmountPickerViewModel$stateObservable$2(this));
        this.stateObservable$delegate = b4;
    }

    public static /* synthetic */ kotlin.x a(ConsumerAmountPickerViewModel consumerAmountPickerViewModel, ReceivableWallet receivableWallet) {
        return m977setup$lambda9(consumerAmountPickerViewModel, receivableWallet);
    }

    public static /* synthetic */ BigDecimal b(BigDecimal bigDecimal) {
        return m964consumerExchangeRateSingle$lambda1(bigDecimal);
    }

    /* renamed from: consumerExchangeRateSingle$lambda-0 */
    public static final BigDecimal m963consumerExchangeRateSingle$lambda0(ConsumerAmountPickerViewModel this$0, List exchangeRates) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(exchangeRates, "exchangeRates");
        BigDecimal rateFor$default = List_WalletsKt.rateFor$default(exchangeRates, this$0.getConsumerAccount().getCurrencyCode(), null, this$0.getConsumerAccount().getCurrencyName(), null, 8, null);
        Objects.requireNonNull(rateFor$default);
        return rateFor$default;
    }

    /* renamed from: consumerExchangeRateSingle$lambda-1 */
    public static final BigDecimal m964consumerExchangeRateSingle$lambda1(BigDecimal it) {
        kotlin.jvm.internal.m.g(it, "it");
        return BigDecimal.ONE.divide(it, MathContext.DECIMAL128);
    }

    public static /* synthetic */ kotlin.x d(ConsumerTransferMethodResult consumerTransferMethodResult, ConsumerAmountPickerViewModel consumerAmountPickerViewModel) {
        return m969observeTransferMethodsResult$lambda18$lambda16(consumerTransferMethodResult, consumerAmountPickerViewModel);
    }

    public static /* synthetic */ h.c.h0 e(ConsumerAmountPickerViewModel consumerAmountPickerViewModel, ConsumerTransferMethodResult consumerTransferMethodResult) {
        return m968observeTransferMethodsResult$lambda18(consumerAmountPickerViewModel, consumerTransferMethodResult);
    }

    public static /* synthetic */ void f(ConsumerAmountPickerViewModel consumerAmountPickerViewModel, Throwable th) {
        m965fetchMaxTransferableAmount$lambda14(consumerAmountPickerViewModel, th);
    }

    private final void fetchMaxTransferableAmount(UUID uuid) {
        h.c.b0<ConsumerAvailableTransferContainer> availableSendTransfer;
        if (getOnrampEnabled()) {
            ConsumerTransferRepository consumerTransferRepository = this.consumerTransferRepository;
            ConsumerAccount consumerAccount = getConsumerAccount();
            ReceivableWallet receivableWallet = this.wallet;
            if (receivableWallet == null) {
                kotlin.jvm.internal.m.w("wallet");
                throw null;
            }
            availableSendTransfer = consumerTransferRepository.getMaxTransfer(consumerAccount, receivableWallet.getAddress());
        } else {
            ConsumerTransferRepository consumerTransferRepository2 = this.consumerTransferRepository;
            ConsumerAccount consumerAccount2 = getConsumerAccount();
            TransferValue.EntireBalance entireBalance = TransferValue.EntireBalance.INSTANCE;
            ReceivableWallet receivableWallet2 = this.wallet;
            if (receivableWallet2 == null) {
                kotlin.jvm.internal.m.w("wallet");
                throw null;
            }
            availableSendTransfer = consumerTransferRepository2.getAvailableSendTransfer(consumerAccount2, entireBalance, receivableWallet2.getAddress());
        }
        h.c.b0 doOnError = Single_AnalyticsKt.logError$default(h.c.t0.e.a.a(availableSendTransfer, this.consumerExchangeRateSingle), null, null, 3, null).observeOn(h.c.j0.c.a.b()).doOnError(new h.c.m0.f() { // from class: com.coinbase.wallet.consumer.viewmodels.r
            @Override // h.c.m0.f
            public final void accept(Object obj) {
                ConsumerAmountPickerViewModel.f(ConsumerAmountPickerViewModel.this, (Throwable) obj);
            }
        });
        kotlin.jvm.internal.m.f(doOnError, "zip(\n            maxTransferSingle,\n            consumerExchangeRateSingle\n        )\n            .logError()\n            .observeOn(AndroidSchedulers.mainThread())\n            .doOnError {\n                state = state.copy(isMaxButtonLoading = false, isNextButtonLoading = false)\n                eventSubject.onNext(\n                    ConsumerAmountPickerEvent.FetchMaxAmountError(\n                        LocalizedStrings[R.string.fetch_max_error]\n                    )\n                )\n            }");
        h.c.t0.a.a(h.c.t0.g.i(doOnError, null, new ConsumerAmountPickerViewModel$fetchMaxTransferableAmount$2(this, uuid), 1, null), this.amountUpdateDisposable);
    }

    /* renamed from: fetchMaxTransferableAmount$lambda-14 */
    public static final void m965fetchMaxTransferableAmount$lambda14(ConsumerAmountPickerViewModel this$0, Throwable th) {
        ConsumerAmountPickerViewState copy;
        kotlin.jvm.internal.m.g(this$0, "this$0");
        copy = r2.copy((r32 & 1) != 0 ? r2.maxAmount : null, (r32 & 2) != 0 ? r2.isMaxButtonLoading : false, (r32 & 4) != 0 ? r2.isNextButtonVisible : false, (r32 & 8) != 0 ? r2.isNextButtonLoading : false, (r32 & 16) != 0 ? r2.isFiatSelected : false, (r32 & 32) != 0 ? r2.primaryText : null, (r32 & 64) != 0 ? r2.secondaryText : null, (r32 & 128) != 0 ? r2.swapButtonEnabled : false, (r32 & 256) != 0 ? r2.currencyCode : null, (r32 & 512) != 0 ? r2.keyboardLocale : null, (r32 & 1024) != 0 ? r2.isOnrampEnabled : false, (r32 & PKIFailureInfo.wrongIntegrity) != 0 ? r2.cryptoBalance : null, (r32 & 4096) != 0 ? r2.fiatBalance : null, (r32 & PKIFailureInfo.certRevoked) != 0 ? r2.isInsufficientBalance : false, (r32 & 16384) != 0 ? this$0.state.wallet : null);
        this$0.setState(copy);
        this$0.eventSubject.onNext(new ConsumerAmountPickerEvent.FetchMaxAmountError(LocalizedStrings.INSTANCE.get(R.string.fetch_max_error)));
    }

    public static /* synthetic */ kotlin.x g(ConsumerAmountPickerViewModel consumerAmountPickerViewModel) {
        return m970observeTransferMethodsResult$lambda18$lambda17(consumerAmountPickerViewModel);
    }

    public final PromptDialogHelper.Properties generateWblPrompt(AvailableSendTransfer availableSendTransfer) {
        String formatToFiat;
        List b2;
        formatToFiat = this.currencyFormatter.formatToFiat(availableSendTransfer.getAccount().getCurrencyCode(), null, availableSendTransfer.getAccount().getDecimals(), availableSendTransfer.getMaxAmountCrypto(), (r17 & 16) != 0 ? false : false, (r17 & 32) != 0 ? null : availableSendTransfer.getAccount().getCurrencyName(), (r17 & 64) != 0 ? null : null);
        String str = formatToFiat != null ? LocalizedStrings.INSTANCE.get(R.string.consumer_wbl_info_transfer_limit_subtext, formatToFiat) : null;
        LocalizedStrings localizedStrings = LocalizedStrings.INSTANCE;
        PromptDialogHelper.Action action = new PromptDialogHelper.Action(localizedStrings.get(R.string.consumer_wbl_ok), ActionStyle.POSITIVE, ConsumerAmountPickerViewModel$generateWblPrompt$action$1.INSTANCE);
        String str2 = localizedStrings.get(R.string.consumer_wbl_info_transfer_limit);
        Integer valueOf = Integer.valueOf(R.drawable.ic_consumer_wbl_info);
        b2 = kotlin.a0.q.b(action);
        return new PromptDialogHelper.Properties(null, str2, str, null, valueOf, b2, null, false, null, null, null, null, null, false, 16329, null);
    }

    public final ConsumerAccount getConsumerAccount() {
        return (ConsumerAccount) this.consumerAccount$delegate.getValue();
    }

    public final boolean getOnrampEnabled() {
        return ((Boolean) this.onrampEnabled$delegate.getValue()).booleanValue();
    }

    public static /* synthetic */ ReceivableWallet h(ConsumerAmountPickerViewModel consumerAmountPickerViewModel, Wallet wallet) {
        return m976setup$lambda8$lambda7(consumerAmountPickerViewModel, wallet);
    }

    public static /* synthetic */ CryptoCurrency i(ConsumerAmountPickerViewModel consumerAmountPickerViewModel, List list) {
        return m973setup$lambda3(consumerAmountPickerViewModel, list);
    }

    public static /* synthetic */ void j(ConsumerAmountPickerViewModel consumerAmountPickerViewModel, Throwable th) {
        m966nextAction$lambda13(consumerAmountPickerViewModel, th);
    }

    public static /* synthetic */ h.c.x k(ConsumerAmountPickerViewModel consumerAmountPickerViewModel, kotlin.o oVar) {
        return m974setup$lambda8(consumerAmountPickerViewModel, oVar);
    }

    public static /* synthetic */ kotlin.x l(ConsumerAmountPickerViewModel consumerAmountPickerViewModel, ConsumerCardCDVResult consumerCardCDVResult) {
        return m967observeCardVerificationResult$lambda20(consumerAmountPickerViewModel, consumerCardCDVResult);
    }

    public static /* synthetic */ Optional m(CurrencyCode currencyCode, CryptoCurrency cryptoCurrency, Set set) {
        return m975setup$lambda8$lambda6(currencyCode, cryptoCurrency, set);
    }

    public static /* synthetic */ void n(ConsumerAmountPickerViewModel consumerAmountPickerViewModel) {
        m972setup$lambda11(consumerAmountPickerViewModel);
    }

    /* renamed from: nextAction$lambda-13 */
    public static final void m966nextAction$lambda13(ConsumerAmountPickerViewModel this$0, Throwable th) {
        ConsumerAmountPickerViewState copy;
        String str;
        kotlin.jvm.internal.m.g(this$0, "this$0");
        copy = r3.copy((r32 & 1) != 0 ? r3.maxAmount : null, (r32 & 2) != 0 ? r3.isMaxButtonLoading : false, (r32 & 4) != 0 ? r3.isNextButtonVisible : false, (r32 & 8) != 0 ? r3.isNextButtonLoading : false, (r32 & 16) != 0 ? r3.isFiatSelected : false, (r32 & 32) != 0 ? r3.primaryText : null, (r32 & 64) != 0 ? r3.secondaryText : null, (r32 & 128) != 0 ? r3.swapButtonEnabled : false, (r32 & 256) != 0 ? r3.currencyCode : null, (r32 & 512) != 0 ? r3.keyboardLocale : null, (r32 & 1024) != 0 ? r3.isOnrampEnabled : false, (r32 & PKIFailureInfo.wrongIntegrity) != 0 ? r3.cryptoBalance : null, (r32 & 4096) != 0 ? r3.fiatBalance : null, (r32 & PKIFailureInfo.certRevoked) != 0 ? r3.isInsufficientBalance : false, (r32 & 16384) != 0 ? this$0.state.wallet : null);
        this$0.setState(copy);
        if (th instanceof CoinbaseException) {
            str = ((CoinbaseException) th).getServerError().getMessage();
            if (str == null) {
                str = LocalizedStrings.INSTANCE.get(R.string.next_action_error);
            }
        } else {
            if (th instanceof CompositeException) {
                CompositeException compositeException = (CompositeException) th;
                List<Throwable> b2 = compositeException.b();
                kotlin.jvm.internal.m.f(b2, "it.exceptions");
                if (kotlin.a0.p.Y(b2) instanceof CoinbaseException) {
                    List<Throwable> b3 = compositeException.b();
                    kotlin.jvm.internal.m.f(b3, "it.exceptions");
                    Object Y = kotlin.a0.p.Y(b3);
                    Objects.requireNonNull(Y, "null cannot be cast to non-null type com.coinbase.errors.CoinbaseException");
                    str = ((CoinbaseException) Y).getServerError().getMessage();
                    if (str == null) {
                        str = LocalizedStrings.INSTANCE.get(R.string.next_action_error);
                    }
                }
            }
            str = LocalizedStrings.INSTANCE.get(R.string.next_action_error);
        }
        kotlin.jvm.internal.m.f(str, "when {\n                    it is CoinbaseException -> {\n                        it.serverError.message ?: LocalizedStrings[R.string.next_action_error]\n                    }\n                    it is CompositeException && it.exceptions.first() is CoinbaseException -> {\n                        val innerException = it.exceptions.first() as CoinbaseException\n                        innerException.serverError.message ?: LocalizedStrings[R.string.next_action_error]\n                    }\n                    else -> {\n                        LocalizedStrings[R.string.next_action_error]\n                    }\n                }");
        this$0.eventSubject.onNext(new ConsumerAmountPickerEvent.FetchNextActionError(str));
    }

    public static /* synthetic */ BigDecimal o(ConsumerAmountPickerViewModel consumerAmountPickerViewModel, List list) {
        return m963consumerExchangeRateSingle$lambda0(consumerAmountPickerViewModel, list);
    }

    public final void observeAmountUpdates() {
        h.c.s<String> observeOn = this.amountViewModel.getPrimaryTextObservable().observeOn(h.c.j0.c.a.b());
        kotlin.jvm.internal.m.f(observeOn, "amountViewModel.primaryTextObservable\n            .observeOn(AndroidSchedulers.mainThread())");
        h.c.t0.a.a(h.c.t0.g.h(observeOn, null, null, new ConsumerAmountPickerViewModel$observeAmountUpdates$1(this), 3, null), this.amountUpdateDisposable);
        h.c.s<String> observeOn2 = this.amountViewModel.getSecondaryTextObservable().observeOn(h.c.j0.c.a.b());
        kotlin.jvm.internal.m.f(observeOn2, "amountViewModel.secondaryTextObservable\n            .observeOn(AndroidSchedulers.mainThread())");
        h.c.t0.a.a(h.c.t0.g.h(observeOn2, null, null, new ConsumerAmountPickerViewModel$observeAmountUpdates$2(this), 3, null), this.amountUpdateDisposable);
        h.c.s<String> observeOn3 = this.amountViewModel.getCryptoAmountObservable().observeOn(h.c.j0.c.a.b());
        kotlin.jvm.internal.m.f(observeOn3, "amountViewModel.cryptoAmountObservable\n            .observeOn(AndroidSchedulers.mainThread())");
        h.c.t0.a.a(h.c.t0.g.h(observeOn3, null, null, new ConsumerAmountPickerViewModel$observeAmountUpdates$3(this), 3, null), this.amountUpdateDisposable);
        h.c.s<CurrencyCode> observeOn4 = this.amountViewModel.getCurrencyCodeObservable().observeOn(h.c.j0.c.a.b());
        kotlin.jvm.internal.m.f(observeOn4, "amountViewModel.currencyCodeObservable\n            .observeOn(AndroidSchedulers.mainThread())");
        h.c.t0.a.a(h.c.t0.g.h(observeOn4, null, null, new ConsumerAmountPickerViewModel$observeAmountUpdates$4(this), 3, null), this.amountUpdateDisposable);
        h.c.s<Locale> observeOn5 = this.amountViewModel.getKeyboardLocaleObservable().observeOn(h.c.j0.c.a.b());
        kotlin.jvm.internal.m.f(observeOn5, "amountViewModel.keyboardLocaleObservable\n            .observeOn(AndroidSchedulers.mainThread())");
        h.c.t0.a.a(h.c.t0.g.h(observeOn5, null, null, new ConsumerAmountPickerViewModel$observeAmountUpdates$5(this), 3, null), this.amountUpdateDisposable);
        h.c.s<kotlin.x> observeOn6 = this.amountViewModel.getTextEntryErrorObservable().observeOn(h.c.j0.c.a.b());
        kotlin.jvm.internal.m.f(observeOn6, "amountViewModel.textEntryErrorObservable\n            .observeOn(AndroidSchedulers.mainThread())");
        h.c.t0.a.a(h.c.t0.g.h(observeOn6, null, null, new ConsumerAmountPickerViewModel$observeAmountUpdates$6(this), 3, null), this.amountUpdateDisposable);
    }

    private final void observeCardVerificationResult(h.c.s<ConsumerCardCDVResult> sVar) {
        h.c.s<R> map = sVar.observeOn(h.c.j0.c.a.b()).map(new h.c.m0.n() { // from class: com.coinbase.wallet.consumer.viewmodels.x
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return ConsumerAmountPickerViewModel.l(ConsumerAmountPickerViewModel.this, (ConsumerCardCDVResult) obj);
            }
        });
        kotlin.jvm.internal.m.f(map, "cardVerificationResultObservable\n            .observeOn(AndroidSchedulers.mainThread())\n            .map { cardVerificationResult ->\n                val transferRequest = cachedTransferForTransferMethods ?: return@map\n                val args = ConsumerTransferMethodsArgs\n                    .createArgs(\n                        transferRequest = transferRequest,\n                        addedPaymentMethodResult = cardVerificationResult\n                    )\n                    .apply { putAll(ForwardArgs.create(R.id.consumerAmountPickerFragment)) }\n\n                val route = ViewModelNavRoute(R.id.consumerTransferMethodsFragment, args)\n                navigateSubject.onNext(route)\n            }");
        h.c.t0.a.a(h.c.t0.g.h(map, null, null, ConsumerAmountPickerViewModel$observeCardVerificationResult$2.INSTANCE, 3, null), this.disposeBag);
    }

    /* renamed from: observeCardVerificationResult$lambda-20 */
    public static final kotlin.x m967observeCardVerificationResult$lambda20(ConsumerAmountPickerViewModel this$0, ConsumerCardCDVResult cardVerificationResult) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(cardVerificationResult, "cardVerificationResult");
        TransferMoneyRequest transferMoneyRequest = this$0.cachedTransferForTransferMethods;
        if (transferMoneyRequest == null) {
            return kotlin.x.a;
        }
        Bundle createArgs = ConsumerTransferMethodsArgs.INSTANCE.createArgs(transferMoneyRequest, cardVerificationResult);
        createArgs.putAll(ForwardArgs.INSTANCE.create(R.id.consumerAmountPickerFragment));
        this$0.navigateSubject.onNext(new ViewModelNavRoute(R.id.consumerTransferMethodsFragment, createArgs, null, 4, null));
        return kotlin.x.a;
    }

    private final void observeTransferMethodsResult(h.c.s<ConsumerTransferMethodResult> sVar) {
        h.c.s<R> flatMapSingle = sVar.flatMapSingle(new h.c.m0.n() { // from class: com.coinbase.wallet.consumer.viewmodels.q
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return ConsumerAmountPickerViewModel.e(ConsumerAmountPickerViewModel.this, (ConsumerTransferMethodResult) obj);
            }
        });
        kotlin.jvm.internal.m.f(flatMapSingle, "transferResultObservable\n            .flatMapSingle { result ->\n                when (result) {\n                    is ConsumerTransferMethodResult.VerifyingPaymentMethod -> {\n                        Single\n                            .fromCallable {\n                                val args = ConsumerCardCDVArgs.createArgs(result.paymentMethod)\n                                    .apply { putAll(ForwardArgs.create(R.id.consumerAmountPickerFragment)) }\n\n                                navigateSubject.onNext(ViewModelNavRoute(R.id.consumerCardCDVFragment, args))\n                            }\n                            .subscribeOn(AndroidSchedulers.mainThread())\n                    }\n                    ConsumerTransferMethodResult.AddingPaymentMethod -> {\n                        Single\n                            .fromCallable {\n                                val args = ForwardArgs.create(R.id.consumerAmountPickerFragment)\n                                navigateSubject\n                                    .onNext(ViewModelNavRoute(R.id.consumerAvailablePaymentMethodsFragment, args))\n                            }\n                            .subscribeOn(AndroidSchedulers.mainThread())\n                    }\n                    else -> {\n                        Single.just(Unit)\n                    }\n                }\n            }");
        h.c.t0.a.a(h.c.t0.g.h(flatMapSingle, null, null, ConsumerAmountPickerViewModel$observeTransferMethodsResult$2.INSTANCE, 3, null), this.disposeBag);
    }

    /* renamed from: observeTransferMethodsResult$lambda-18 */
    public static final h.c.h0 m968observeTransferMethodsResult$lambda18(final ConsumerAmountPickerViewModel this$0, final ConsumerTransferMethodResult result) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(result, "result");
        if (result instanceof ConsumerTransferMethodResult.VerifyingPaymentMethod) {
            return h.c.b0.fromCallable(new Callable() { // from class: com.coinbase.wallet.consumer.viewmodels.p
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return ConsumerAmountPickerViewModel.d(ConsumerTransferMethodResult.this, this$0);
                }
            }).subscribeOn(h.c.j0.c.a.b());
        }
        if (kotlin.jvm.internal.m.c(result, ConsumerTransferMethodResult.AddingPaymentMethod.INSTANCE)) {
            return h.c.b0.fromCallable(new Callable() { // from class: com.coinbase.wallet.consumer.viewmodels.s
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return ConsumerAmountPickerViewModel.g(ConsumerAmountPickerViewModel.this);
                }
            }).subscribeOn(h.c.j0.c.a.b());
        }
        return h.c.b0.just(kotlin.x.a);
    }

    /* renamed from: observeTransferMethodsResult$lambda-18$lambda-16 */
    public static final kotlin.x m969observeTransferMethodsResult$lambda18$lambda16(ConsumerTransferMethodResult result, ConsumerAmountPickerViewModel this$0) {
        kotlin.jvm.internal.m.g(result, "$result");
        kotlin.jvm.internal.m.g(this$0, "this$0");
        Bundle createArgs = ConsumerCardCDVArgs.INSTANCE.createArgs(((ConsumerTransferMethodResult.VerifyingPaymentMethod) result).getPaymentMethod());
        createArgs.putAll(ForwardArgs.INSTANCE.create(R.id.consumerAmountPickerFragment));
        this$0.navigateSubject.onNext(new ViewModelNavRoute(R.id.consumerCardCDVFragment, createArgs, null, 4, null));
        return kotlin.x.a;
    }

    /* renamed from: observeTransferMethodsResult$lambda-18$lambda-17 */
    public static final kotlin.x m970observeTransferMethodsResult$lambda18$lambda17(ConsumerAmountPickerViewModel this$0) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        this$0.navigateSubject.onNext(new ViewModelNavRoute(R.id.consumerAvailablePaymentMethodsFragment, ForwardArgs.INSTANCE.create(R.id.consumerAmountPickerFragment), null, 4, null));
        return kotlin.x.a;
    }

    public final void setState(ConsumerAmountPickerViewState consumerAmountPickerViewState) {
        this.state = consumerAmountPickerViewState;
        this.stateSubject.onNext(consumerAmountPickerViewState);
    }

    /* renamed from: setup$lambda-10 */
    public static final void m971setup$lambda10(ConsumerAmountPickerViewModel this$0, h.c.s transferResultObservable, h.c.s cardVerificationResultObservable, h.c.k0.b bVar) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(transferResultObservable, "$transferResultObservable");
        kotlin.jvm.internal.m.g(cardVerificationResultObservable, "$cardVerificationResultObservable");
        this$0.observeTransferMethodsResult(transferResultObservable);
        this$0.observeCardVerificationResult(cardVerificationResultObservable);
    }

    /* renamed from: setup$lambda-11 */
    public static final void m972setup$lambda11(ConsumerAmountPickerViewModel this$0) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        this$0.disposeBag.d();
    }

    /* renamed from: setup$lambda-3 */
    public static final CryptoCurrency m973setup$lambda3(ConsumerAmountPickerViewModel this$0, List list) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(list, "list");
        Iterator it = list.iterator();
        while (it.hasNext()) {
            CryptoCurrency cryptoCurrency = (CryptoCurrency) it.next();
            if (kotlin.jvm.internal.m.c(cryptoCurrency.getCode(), this$0.getConsumerAccount().getCurrencyCode())) {
                return cryptoCurrency;
            }
        }
        throw new NoSuchElementException("Collection contains no element matching the predicate.");
    }

    /* renamed from: setup$lambda-8 */
    public static final h.c.x m974setup$lambda8(ConsumerAmountPickerViewModel this$0, kotlin.o dstr$cryptoCurrency$network) {
        final CurrencyCode currencyCode;
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(dstr$cryptoCurrency$network, "$dstr$cryptoCurrency$network");
        final CryptoCurrency cryptoCurrency = (CryptoCurrency) dstr$cryptoCurrency$network.a();
        Network network = (Network) dstr$cryptoCurrency$network.b();
        if (kotlin.jvm.internal.m.c(cryptoCurrency.getBlockchain(), Blockchain_EthereumKt.getETHEREUM(Blockchain.Companion))) {
            currencyCode = WalletConfiguration_EthereumKt.getETH(EthereumBasedConfiguration.Companion).currencyCodeForNetwork(network);
        } else {
            currencyCode = this$0.getConsumerAccount().getCurrencyCode();
        }
        h.c.s<R> map = this$0.walletRepository.consumerWalletsObservableAVAXFix().map(new h.c.m0.n() { // from class: com.coinbase.wallet.consumer.viewmodels.y
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return ConsumerAmountPickerViewModel.m(CurrencyCode.this, cryptoCurrency, (Set) obj);
            }
        });
        kotlin.jvm.internal.m.f(map, "walletRepository.consumerWalletsObservableAVAXFix().map { wallets ->\n                    val filteredWallets = wallets.filter { wallet ->\n                        val isCorrectBlockchain = if (currencyCode.code == \"AVAX\") {\n                            wallet.blockchain == Blockchain.ETHEREUM\n                        } else {\n                            wallet.blockchain == cryptoCurrency.blockchain\n                        }\n                        wallet.currencyCode == currencyCode && !wallet.network.isTestnet && isCorrectBlockchain\n                    }\n\n                    return@map when {\n                        filteredWallets.isEmpty() -> {\n                            Optional(null)\n                        }\n                        filteredWallets.size == 1 -> {\n                            Optional(filteredWallets.first())\n                        }\n                        else -> {\n                            Optional(\n                                filteredWallets.first { it.network.asEthereumChain == EthereumChain.ETHEREUM_MAINNET }\n                            )\n                        }\n                    }\n                }");
        h.c.s map2 = map.filter(new h.c.m0.p() { // from class: com.coinbase.wallet.consumer.viewmodels.ConsumerAmountPickerViewModel$setup$lambda-8$$inlined$unwrap$1
            public final boolean test(Optional<? extends T> it) {
                kotlin.jvm.internal.m.g(it, "it");
                return it.toNullable() != null;
            }

            @Override // h.c.m0.p
            public /* bridge */ /* synthetic */ boolean test(Object obj) {
                return test((Optional) ((Optional) obj));
            }
        }).map(new h.c.m0.n() { // from class: com.coinbase.wallet.consumer.viewmodels.ConsumerAmountPickerViewModel$setup$lambda-8$$inlined$unwrap$2
            public final T apply(Optional<? extends T> it) {
                kotlin.jvm.internal.m.g(it, "it");
                return it.toNullable();
            }

            @Override // h.c.m0.n
            public /* bridge */ /* synthetic */ Object apply(Object obj) {
                return apply((Optional) ((Optional) obj));
            }
        });
        kotlin.jvm.internal.m.f(map2, "this\n    .filter { it.toNullable() != null }\n    .map { it.toNullable() }");
        return map2.map(new h.c.m0.n() { // from class: com.coinbase.wallet.consumer.viewmodels.t
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return ConsumerAmountPickerViewModel.h(ConsumerAmountPickerViewModel.this, (Wallet) obj);
            }
        });
    }

    /* renamed from: setup$lambda-8$lambda-6 */
    public static final Optional m975setup$lambda8$lambda6(CurrencyCode currencyCode, CryptoCurrency cryptoCurrency, Set wallets) {
        boolean z;
        boolean c2;
        kotlin.jvm.internal.m.g(currencyCode, "$currencyCode");
        kotlin.jvm.internal.m.g(wallets, "wallets");
        ArrayList arrayList = new ArrayList();
        Iterator it = wallets.iterator();
        while (true) {
            boolean z2 = false;
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            Wallet wallet = (Wallet) next;
            if (kotlin.jvm.internal.m.c(currencyCode.getCode(), "AVAX")) {
                c2 = kotlin.jvm.internal.m.c(wallet.getBlockchain(), Blockchain_EthereumKt.getETHEREUM(Blockchain.Companion));
            } else {
                c2 = kotlin.jvm.internal.m.c(wallet.getBlockchain(), cryptoCurrency.getBlockchain());
            }
            if (kotlin.jvm.internal.m.c(wallet.getCurrencyCode(), currencyCode) && !wallet.getNetwork().isTestnet() && c2) {
                z2 = true;
            }
            if (z2) {
                arrayList.add(next);
            }
        }
        if (arrayList.isEmpty()) {
            return new Optional(null);
        }
        if (arrayList.size() == 1) {
            return new Optional(kotlin.a0.p.Y(arrayList));
        }
        for (Object obj : arrayList) {
            if (Network_EthereumKt.getAsEthereumChain(((Wallet) obj).getNetwork()) == EthereumChain.ETHEREUM_MAINNET) {
                z = true;
                continue;
            } else {
                z = false;
                continue;
            }
            if (z) {
                return new Optional(obj);
            }
        }
        throw new NoSuchElementException("Collection contains no element matching the predicate.");
    }

    /* renamed from: setup$lambda-8$lambda-7 */
    public static final ReceivableWallet m976setup$lambda8$lambda7(ConsumerAmountPickerViewModel this$0, Wallet wallet) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(wallet, "wallet");
        return new ReceivableWallet(this$0.getConsumerAccount().getName(), wallet.getNetwork(), this$0.getConsumerAccount().getCurrencyCode(), this$0.getConsumerAccount().getDecimals(), wallet.getAddresses().get(0).getAddress(), wallet.getAddresses().get(0).getIndex(), wallet.getBlockchain(), this$0.getConsumerAccount().getImageUrl());
    }

    /* renamed from: setup$lambda-9 */
    public static final kotlin.x m977setup$lambda9(ConsumerAmountPickerViewModel this$0, ReceivableWallet wallet) {
        String formatToFiat;
        ConsumerAmountPickerViewState copy;
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(wallet, "wallet");
        this$0.wallet = wallet;
        CurrencyFormatter currencyFormatter = this$0.currencyFormatter;
        CurrencyCode code = wallet.getCode();
        EthereumChain asEthereumChain = Network_EthereumKt.getAsEthereumChain(wallet.getNetwork());
        boolean hasFiatRepresentation = currencyFormatter.hasFiatRepresentation(code, null, asEthereumChain == null ? null : Integer.valueOf(asEthereumChain.getChainId()));
        Boolean bool = (Boolean) this$0.store.get(StoreKeys_ConsumerConnectKt.isFiatSelectedForConsumer(StoreKeys.INSTANCE));
        boolean z = (bool == null ? true : bool.booleanValue()) && hasFiatRepresentation;
        int decimals = this$0.getConsumerAccount().getDecimals();
        AmountViewModel amountViewModel = this$0.amountViewModel;
        CurrencyCode code2 = wallet.getCode();
        EthereumChain asEthereumChain2 = Network_EthereumKt.getAsEthereumChain(wallet.getNetwork());
        amountViewModel.setup(code2, null, decimals, z, asEthereumChain2 != null ? Integer.valueOf(asEthereumChain2.getChainId()) : null);
        this$0.amountViewModel.setFiatSelected(z);
        String formatToCrypto$default = CurrencyFormatter.formatToCrypto$default(this$0.currencyFormatter, this$0.getConsumerAccount().getCurrencyCode(), this$0.getConsumerAccount().getDecimals(), this$0.getConsumerAccount().getBalance(), true, 0, 0, 48, (Object) null);
        formatToFiat = this$0.currencyFormatter.formatToFiat(this$0.getConsumerAccount().getCurrencyCode(), null, this$0.getConsumerAccount().getDecimals(), this$0.getConsumerAccount().getBalance(), (r17 & 16) != 0 ? false : false, (r17 & 32) != 0 ? null : this$0.getConsumerAccount().getCurrencyName(), (r17 & 64) != 0 ? null : null);
        if (formatToFiat == null) {
            formatToFiat = Strings_CoreKt.getEmpty(Strings.INSTANCE);
        }
        this$0.eventSubject.onNext(ConsumerAmountPickerEvent.HideKeyboard.INSTANCE);
        copy = r1.copy((r32 & 1) != 0 ? r1.maxAmount : null, (r32 & 2) != 0 ? r1.isMaxButtonLoading : false, (r32 & 4) != 0 ? r1.isNextButtonVisible : false, (r32 & 8) != 0 ? r1.isNextButtonLoading : false, (r32 & 16) != 0 ? r1.isFiatSelected : z, (r32 & 32) != 0 ? r1.primaryText : null, (r32 & 64) != 0 ? r1.secondaryText : null, (r32 & 128) != 0 ? r1.swapButtonEnabled : hasFiatRepresentation, (r32 & 256) != 0 ? r1.currencyCode : null, (r32 & 512) != 0 ? r1.keyboardLocale : null, (r32 & 1024) != 0 ? r1.isOnrampEnabled : false, (r32 & PKIFailureInfo.wrongIntegrity) != 0 ? r1.cryptoBalance : formatToCrypto$default, (r32 & 4096) != 0 ? r1.fiatBalance : formatToFiat, (r32 & PKIFailureInfo.certRevoked) != 0 ? r1.isInsufficientBalance : false, (r32 & 16384) != 0 ? this$0.state.wallet : wallet);
        this$0.setState(copy);
        return kotlin.x.a;
    }

    public final void updateCryptoAmount(String str, UUID uuid) {
        BigDecimal j2;
        ConsumerAmountPickerViewState copy;
        j2 = kotlin.l0.v.j(str);
        if (j2 == null) {
            j2 = BigDecimal.ZERO;
        }
        BigDecimal asBigDecimal = BigInteger_CommonKt.asBigDecimal(getConsumerAccount().getBalance(), getConsumerAccount().getDecimals());
        boolean z = !getOnrampEnabled() ? j2.compareTo(BigDecimal.ZERO) <= 0 || j2.compareTo(asBigDecimal) > 0 : j2.compareTo(BigDecimal.ZERO) <= 0;
        boolean z2 = j2.compareTo(asBigDecimal) > 0;
        if (z2) {
            Analytics.INSTANCE.log(AnalyticsEvent_ConsumerKt.consumerAmountPickerInsufficientBalanceViewed(AnalyticsEvent.Companion, getConsumerAccount().getCurrencyCode(), uuid));
        }
        copy = r6.copy((r32 & 1) != 0 ? r6.maxAmount : null, (r32 & 2) != 0 ? r6.isMaxButtonLoading : false, (r32 & 4) != 0 ? r6.isNextButtonVisible : z, (r32 & 8) != 0 ? r6.isNextButtonLoading : false, (r32 & 16) != 0 ? r6.isFiatSelected : false, (r32 & 32) != 0 ? r6.primaryText : null, (r32 & 64) != 0 ? r6.secondaryText : null, (r32 & 128) != 0 ? r6.swapButtonEnabled : false, (r32 & 256) != 0 ? r6.currencyCode : null, (r32 & 512) != 0 ? r6.keyboardLocale : null, (r32 & 1024) != 0 ? r6.isOnrampEnabled : false, (r32 & PKIFailureInfo.wrongIntegrity) != 0 ? r6.cryptoBalance : null, (r32 & 4096) != 0 ? r6.fiatBalance : null, (r32 & PKIFailureInfo.certRevoked) != 0 ? r6.isInsufficientBalance : z2, (r32 & 16384) != 0 ? this.state.wallet : null);
        setState(copy);
        this.amountViewModel.updateCryptoAmount(str);
    }

    public final void displayMaxAmount() {
        ConsumerAmountPickerViewState copy;
        if (this.wallet == null) {
            return;
        }
        this.isSendingEntireBalance = true;
        UUID uuid = UUID.randomUUID();
        Analytics analytics = Analytics.INSTANCE;
        AnalyticsEvent.Companion companion = AnalyticsEvent.Companion;
        boolean onrampEnabled = getOnrampEnabled();
        CurrencyCode currencyCode = getConsumerAccount().getCurrencyCode();
        kotlin.jvm.internal.m.f(uuid, "uuid");
        analytics.log(AnalyticsEvent_ConsumerKt.consumerAmountPickerMaxTapped(companion, onrampEnabled, currencyCode, uuid));
        BigDecimal maxAmount = this.state.getMaxAmount();
        if (maxAmount != null && maxAmount.compareTo(BigDecimal.ZERO) > 0) {
            String plainString = maxAmount.toPlainString();
            kotlin.jvm.internal.m.f(plainString, "maxAmount.toPlainString()");
            updateCryptoAmount(plainString, uuid);
            analytics.log(AnalyticsEvent_ConsumerKt.consumerAmountPickerCachedMaxViewed(companion, getOnrampEnabled(), getConsumerAccount().getCurrencyCode(), uuid));
            return;
        }
        copy = r3.copy((r32 & 1) != 0 ? r3.maxAmount : null, (r32 & 2) != 0 ? r3.isMaxButtonLoading : true, (r32 & 4) != 0 ? r3.isNextButtonVisible : false, (r32 & 8) != 0 ? r3.isNextButtonLoading : false, (r32 & 16) != 0 ? r3.isFiatSelected : false, (r32 & 32) != 0 ? r3.primaryText : null, (r32 & 64) != 0 ? r3.secondaryText : null, (r32 & 128) != 0 ? r3.swapButtonEnabled : false, (r32 & 256) != 0 ? r3.currencyCode : null, (r32 & 512) != 0 ? r3.keyboardLocale : null, (r32 & 1024) != 0 ? r3.isOnrampEnabled : false, (r32 & PKIFailureInfo.wrongIntegrity) != 0 ? r3.cryptoBalance : null, (r32 & 4096) != 0 ? r3.fiatBalance : null, (r32 & PKIFailureInfo.certRevoked) != 0 ? r3.isInsufficientBalance : false, (r32 & 16384) != 0 ? this.state.wallet : null);
        setState(copy);
        fetchMaxTransferableAmount(uuid);
    }

    public final h.c.s<ConsumerAmountPickerEvent> getEventObservable() {
        return this.eventObservable;
    }

    public final h.c.s<ViewModelNavRoute> getNavigateObservable() {
        return this.navigateObservable;
    }

    public final h.c.s<ConsumerAmountPickerViewState> getStateObservable() {
        Object value = this.stateObservable$delegate.getValue();
        kotlin.jvm.internal.m.f(value, "<get-stateObservable>(...)");
        return (h.c.s) value;
    }

    public final void inputDigit(NumberKeyboardDigit digit, boolean z) {
        ConsumerAmountPickerViewState copy;
        kotlin.jvm.internal.m.g(digit, "digit");
        if (this.wallet == null) {
            return;
        }
        this.isSendingEntireBalance = false;
        copy = r3.copy((r32 & 1) != 0 ? r3.maxAmount : null, (r32 & 2) != 0 ? r3.isMaxButtonLoading : false, (r32 & 4) != 0 ? r3.isNextButtonVisible : false, (r32 & 8) != 0 ? r3.isNextButtonLoading : false, (r32 & 16) != 0 ? r3.isFiatSelected : false, (r32 & 32) != 0 ? r3.primaryText : null, (r32 & 64) != 0 ? r3.secondaryText : null, (r32 & 128) != 0 ? r3.swapButtonEnabled : false, (r32 & 256) != 0 ? r3.currencyCode : null, (r32 & 512) != 0 ? r3.keyboardLocale : null, (r32 & 1024) != 0 ? r3.isOnrampEnabled : false, (r32 & PKIFailureInfo.wrongIntegrity) != 0 ? r3.cryptoBalance : null, (r32 & 4096) != 0 ? r3.fiatBalance : null, (r32 & PKIFailureInfo.certRevoked) != 0 ? r3.isInsufficientBalance : false, (r32 & 16384) != 0 ? this.state.wallet : null);
        setState(copy);
        this.amountViewModel.updateAmount(digit, z);
    }

    public final void nextAction() {
        ConsumerAmountPickerViewState copy;
        String h0;
        h.c.b0<ConsumerAvailableTransferContainer> availableSendTransfer;
        UUID uuid = UUID.randomUUID();
        Analytics analytics = Analytics.INSTANCE;
        AnalyticsEvent.Companion companion = AnalyticsEvent.Companion;
        boolean onrampEnabled = getOnrampEnabled();
        CurrencyCode currencyCode = getConsumerAccount().getCurrencyCode();
        boolean isFiatSelected = this.amountViewModel.isFiatSelected();
        kotlin.jvm.internal.m.f(uuid, "uuid");
        analytics.log(AnalyticsEvent_ConsumerKt.consumerAmountPickerContinueTapped(companion, onrampEnabled, currencyCode, isFiatSelected, uuid));
        if (this.isSendingEntireBalance) {
            TransferMoneyRequest transferMoneyRequest = this.cachedTransfer;
            TransferMoneyRequest copy2 = transferMoneyRequest == null ? null : transferMoneyRequest.copy((r22 & 1) != 0 ? transferMoneyRequest.account : null, (r22 & 2) != 0 ? transferMoneyRequest.maxAtomicDecimals : 0, (r22 & 4) != 0 ? transferMoneyRequest.originalRequestAmount : null, (r22 & 8) != 0 ? transferMoneyRequest.availableTransfers : null, (r22 & 16) != 0 ? transferMoneyRequest.fiatExchangeRate : null, (r22 & 32) != 0 ? transferMoneyRequest.fiatCurrency : null, (r22 & 64) != 0 ? transferMoneyRequest.isFiatPrimary : this.amountViewModel.isFiatSelected(), (r22 & 128) != 0 ? transferMoneyRequest.supportsDestinationTag : false, (r22 & 256) != 0 ? transferMoneyRequest.wallet : null, (r22 & 512) != 0 ? transferMoneyRequest.onrampEnabled : false);
            BigDecimal maxAmount = this.state.getMaxAmount();
            if (maxAmount != null && maxAmount.compareTo(BigDecimal.ZERO) > 0 && copy2 != null) {
                Bundle createArguments = ConsumerTransferConfirmationArgs.INSTANCE.createArguments(copy2);
                createArguments.putAll(ForwardArgs.INSTANCE.create(R.id.consumerAmountPickerFragment));
                this.navigateSubject.onNext(new ViewModelNavRoute(R.id.action_consumerAmountPickerFragment_to_consumerTransferConfirmationFragment, createArguments, null, 4, null));
                analytics.log(AnalyticsEvent_ConsumerKt.consumerAmountPickerToConfirmationNavigated(companion, getOnrampEnabled(), getConsumerAccount().getCurrencyCode(), this.amountViewModel.isFiatSelected(), uuid));
                return;
            }
        }
        copy = r6.copy((r32 & 1) != 0 ? r6.maxAmount : null, (r32 & 2) != 0 ? r6.isMaxButtonLoading : false, (r32 & 4) != 0 ? r6.isNextButtonVisible : false, (r32 & 8) != 0 ? r6.isNextButtonLoading : true, (r32 & 16) != 0 ? r6.isFiatSelected : false, (r32 & 32) != 0 ? r6.primaryText : null, (r32 & 64) != 0 ? r6.secondaryText : null, (r32 & 128) != 0 ? r6.swapButtonEnabled : false, (r32 & 256) != 0 ? r6.currencyCode : null, (r32 & 512) != 0 ? r6.keyboardLocale : null, (r32 & 1024) != 0 ? r6.isOnrampEnabled : false, (r32 & PKIFailureInfo.wrongIntegrity) != 0 ? r6.cryptoBalance : null, (r32 & 4096) != 0 ? r6.fiatBalance : null, (r32 & PKIFailureInfo.certRevoked) != 0 ? r6.isInsufficientBalance : false, (r32 & 16384) != 0 ? this.state.wallet : null);
        setState(copy);
        h0 = kotlin.a0.z.h0(this.amountViewModel.getRawCryptoAmount(), Strings_CoreKt.getEmpty(Strings.INSTANCE), null, null, 0, null, null, 62, null);
        BigDecimal bigDecimal = new BigDecimal(h0);
        ReceivableWallet receivableWallet = this.wallet;
        if (receivableWallet != null) {
            TransferValue.Amount amount = new TransferValue.Amount(BigDecimal_CommonKt.asBigInteger(bigDecimal, receivableWallet.getDecimals()));
            if (getOnrampEnabled()) {
                ConsumerTransferRepository consumerTransferRepository = this.consumerTransferRepository;
                ConsumerAccount consumerAccount = getConsumerAccount();
                ReceivableWallet receivableWallet2 = this.wallet;
                if (receivableWallet2 == null) {
                    kotlin.jvm.internal.m.w("wallet");
                    throw null;
                }
                availableSendTransfer = consumerTransferRepository.getAvailableTransfers(consumerAccount, amount, receivableWallet2.getAddress());
            } else {
                ConsumerTransferRepository consumerTransferRepository2 = this.consumerTransferRepository;
                ConsumerAccount consumerAccount2 = getConsumerAccount();
                ReceivableWallet receivableWallet3 = this.wallet;
                if (receivableWallet3 == null) {
                    kotlin.jvm.internal.m.w("wallet");
                    throw null;
                }
                availableSendTransfer = consumerTransferRepository2.getAvailableSendTransfer(consumerAccount2, amount, receivableWallet3.getAddress());
            }
            h.c.b0 doOnError = h.c.t0.e.a.a(availableSendTransfer, this.consumerExchangeRateSingle).observeOn(h.c.j0.c.a.b()).doOnError(new h.c.m0.f() { // from class: com.coinbase.wallet.consumer.viewmodels.v
                @Override // h.c.m0.f
                public final void accept(Object obj) {
                    ConsumerAmountPickerViewModel.j(ConsumerAmountPickerViewModel.this, (Throwable) obj);
                }
            });
            kotlin.jvm.internal.m.f(doOnError, "zip(\n            transferSingle,\n            consumerExchangeRateSingle\n        )\n            .observeOn(AndroidSchedulers.mainThread())\n            .doOnError {\n                state = state.copy(isNextButtonLoading = false)\n                val errorMessage = when {\n                    it is CoinbaseException -> {\n                        it.serverError.message ?: LocalizedStrings[R.string.next_action_error]\n                    }\n                    it is CompositeException && it.exceptions.first() is CoinbaseException -> {\n                        val innerException = it.exceptions.first() as CoinbaseException\n                        innerException.serverError.message ?: LocalizedStrings[R.string.next_action_error]\n                    }\n                    else -> {\n                        LocalizedStrings[R.string.next_action_error]\n                    }\n                }\n\n                eventSubject.onNext(ConsumerAmountPickerEvent.FetchNextActionError(errorMessage))\n            }");
            h.c.t0.a.a(h.c.t0.g.i(doOnError, null, new ConsumerAmountPickerViewModel$nextAction$2(this, amount, uuid), 1, null), this.amountUpdateDisposable);
            return;
        }
        kotlin.jvm.internal.m.w("wallet");
        throw null;
    }

    public final h.c.b0<kotlin.x> setup(final h.c.s<ConsumerTransferMethodResult> transferResultObservable, final h.c.s<ConsumerCardCDVResult> cardVerificationResultObservable) {
        ConsumerAmountPickerViewState copy;
        kotlin.jvm.internal.m.g(transferResultObservable, "transferResultObservable");
        kotlin.jvm.internal.m.g(cardVerificationResultObservable, "cardVerificationResultObservable");
        Analytics.INSTANCE.log(AnalyticsEvent_ConsumerKt.consumerAmountPickerViewed(AnalyticsEvent.Companion, getOnrampEnabled(), getConsumerAccount().getCurrencyCode()));
        copy = r5.copy((r32 & 1) != 0 ? r5.maxAmount : null, (r32 & 2) != 0 ? r5.isMaxButtonLoading : false, (r32 & 4) != 0 ? r5.isNextButtonVisible : false, (r32 & 8) != 0 ? r5.isNextButtonLoading : false, (r32 & 16) != 0 ? r5.isFiatSelected : false, (r32 & 32) != 0 ? r5.primaryText : null, (r32 & 64) != 0 ? r5.secondaryText : null, (r32 & 128) != 0 ? r5.swapButtonEnabled : false, (r32 & 256) != 0 ? r5.currencyCode : null, (r32 & 512) != 0 ? r5.keyboardLocale : null, (r32 & 1024) != 0 ? r5.isOnrampEnabled : getOnrampEnabled(), (r32 & PKIFailureInfo.wrongIntegrity) != 0 ? r5.cryptoBalance : null, (r32 & 4096) != 0 ? r5.fiatBalance : null, (r32 & PKIFailureInfo.certRevoked) != 0 ? r5.isInsufficientBalance : false, (r32 & 16384) != 0 ? this.state.wallet : null);
        setState(copy);
        h.c.t0.c cVar = h.c.t0.c.a;
        h.c.s observable = IWalletRepository.DefaultImpls.getCryptoCurrencies$default(this.walletRepository, null, 1, null).map(new h.c.m0.n() { // from class: com.coinbase.wallet.consumer.viewmodels.u
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return ConsumerAmountPickerViewModel.i(ConsumerAmountPickerViewModel.this, (List) obj);
            }
        }).toObservable();
        kotlin.jvm.internal.m.f(observable, "walletRepository.getCryptoCurrencies()\n                .map { list -> list.first { it.code == consumerAccount.currencyCode } }\n                .toObservable()");
        h.c.s flatMap = cVar.c(observable, this.walletRepository.observeNetwork(Blockchain_EthereumKt.getETHEREUM(Blockchain.Companion))).flatMap(new h.c.m0.n() { // from class: com.coinbase.wallet.consumer.viewmodels.w
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return ConsumerAmountPickerViewModel.k(ConsumerAmountPickerViewModel.this, (kotlin.o) obj);
            }
        });
        kotlin.jvm.internal.m.f(flatMap, "Observables.zip(\n            walletRepository.getCryptoCurrencies()\n                .map { list -> list.first { it.code == consumerAccount.currencyCode } }\n                .toObservable(),\n            walletRepository.observeNetwork(Blockchain.ETHEREUM)\n        )\n            .flatMap { (cryptoCurrency, network) ->\n                val currencyCode = if (cryptoCurrency.blockchain == Blockchain.ETHEREUM) {\n                    EthereumBasedConfiguration.ETH.currencyCodeForNetwork(network)\n                } else {\n                    consumerAccount.currencyCode\n                }\n\n                walletRepository.consumerWalletsObservableAVAXFix().map { wallets ->\n                    val filteredWallets = wallets.filter { wallet ->\n                        val isCorrectBlockchain = if (currencyCode.code == \"AVAX\") {\n                            wallet.blockchain == Blockchain.ETHEREUM\n                        } else {\n                            wallet.blockchain == cryptoCurrency.blockchain\n                        }\n                        wallet.currencyCode == currencyCode && !wallet.network.isTestnet && isCorrectBlockchain\n                    }\n\n                    return@map when {\n                        filteredWallets.isEmpty() -> {\n                            Optional(null)\n                        }\n                        filteredWallets.size == 1 -> {\n                            Optional(filteredWallets.first())\n                        }\n                        else -> {\n                            Optional(\n                                filteredWallets.first { it.network.asEthereumChain == EthereumChain.ETHEREUM_MAINNET }\n                            )\n                        }\n                    }\n                }\n                    .unwrap()\n                    .map { wallet ->\n                        ReceivableWallet(\n                            name = consumerAccount.name,\n                            network = wallet.network,\n                            code = consumerAccount.currencyCode,\n                            decimals = consumerAccount.decimals,\n                            address = wallet.addresses[0].address,\n                            index = wallet.addresses[0].index,\n                            blockchain = wallet.blockchain,\n                            imageURL = consumerAccount.imageUrl\n                        )\n                    }\n            }");
        h.c.b0<kotlin.x> doOnDispose = Observable_CoreKt.takeSingle(flatMap).observeOn(h.c.j0.c.a.b()).map(new h.c.m0.n() { // from class: com.coinbase.wallet.consumer.viewmodels.m
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return ConsumerAmountPickerViewModel.a(ConsumerAmountPickerViewModel.this, (ReceivableWallet) obj);
            }
        }).doOnSubscribe(new h.c.m0.f() { // from class: com.coinbase.wallet.consumer.viewmodels.o
            @Override // h.c.m0.f
            public final void accept(Object obj) {
                ConsumerAmountPickerViewModel.m971setup$lambda10(ConsumerAmountPickerViewModel.this, transferResultObservable, cardVerificationResultObservable, (h.c.k0.b) obj);
            }
        }).doOnDispose(new h.c.m0.a() { // from class: com.coinbase.wallet.consumer.viewmodels.z
            @Override // h.c.m0.a
            public final void run() {
                ConsumerAmountPickerViewModel.n(ConsumerAmountPickerViewModel.this);
            }
        });
        kotlin.jvm.internal.m.f(doOnDispose, "Observables.zip(\n            walletRepository.getCryptoCurrencies()\n                .map { list -> list.first { it.code == consumerAccount.currencyCode } }\n                .toObservable(),\n            walletRepository.observeNetwork(Blockchain.ETHEREUM)\n        )\n            .flatMap { (cryptoCurrency, network) ->\n                val currencyCode = if (cryptoCurrency.blockchain == Blockchain.ETHEREUM) {\n                    EthereumBasedConfiguration.ETH.currencyCodeForNetwork(network)\n                } else {\n                    consumerAccount.currencyCode\n                }\n\n                walletRepository.consumerWalletsObservableAVAXFix().map { wallets ->\n                    val filteredWallets = wallets.filter { wallet ->\n                        val isCorrectBlockchain = if (currencyCode.code == \"AVAX\") {\n                            wallet.blockchain == Blockchain.ETHEREUM\n                        } else {\n                            wallet.blockchain == cryptoCurrency.blockchain\n                        }\n                        wallet.currencyCode == currencyCode && !wallet.network.isTestnet && isCorrectBlockchain\n                    }\n\n                    return@map when {\n                        filteredWallets.isEmpty() -> {\n                            Optional(null)\n                        }\n                        filteredWallets.size == 1 -> {\n                            Optional(filteredWallets.first())\n                        }\n                        else -> {\n                            Optional(\n                                filteredWallets.first { it.network.asEthereumChain == EthereumChain.ETHEREUM_MAINNET }\n                            )\n                        }\n                    }\n                }\n                    .unwrap()\n                    .map { wallet ->\n                        ReceivableWallet(\n                            name = consumerAccount.name,\n                            network = wallet.network,\n                            code = consumerAccount.currencyCode,\n                            decimals = consumerAccount.decimals,\n                            address = wallet.addresses[0].address,\n                            index = wallet.addresses[0].index,\n                            blockchain = wallet.blockchain,\n                            imageURL = consumerAccount.imageUrl\n                        )\n                    }\n            }\n            .takeSingle()\n            .observeOn(AndroidSchedulers.mainThread())\n            .map { wallet ->\n                this.wallet = wallet\n                val hasFiatRepresentation = currencyFormatter.hasFiatRepresentation(\n                    wallet.code,\n                    null,\n                    wallet.network.asEthereumChain?.chainId\n                )\n                val isFiatSelected = (store.get(StoreKeys.isFiatSelectedForConsumer) ?: true) && hasFiatRepresentation\n                val decimals = consumerAccount.decimals\n                amountViewModel.setup(\n                    wallet.code,\n                    null,\n                    decimals,\n                    isFiatSelected,\n                    wallet.network.asEthereumChain?.chainId\n                )\n\n                amountViewModel.isFiatSelected = isFiatSelected\n\n                val cryptoBalance = currencyFormatter.formatToCrypto(\n                    currencyCode = consumerAccount.currencyCode,\n                    decimals = consumerAccount.decimals,\n                    value = consumerAccount.balance,\n                    includeCode = true\n                )\n\n                val fiatBalance = currencyFormatter.formatToFiat(\n                    consumerAccount.currencyCode,\n                    null,\n                    consumerAccount.decimals,\n                    consumerAccount.balance,\n                    false,\n                    consumerAccount.currencyName\n                ) ?: Strings.empty\n\n                eventSubject.onNext(ConsumerAmountPickerEvent.HideKeyboard)\n                state = state.copy(\n                    isFiatSelected = isFiatSelected,\n                    swapButtonEnabled = hasFiatRepresentation,\n                    wallet = wallet,\n                    cryptoBalance = cryptoBalance,\n                    fiatBalance = fiatBalance\n                )\n            }\n            .doOnSubscribe {\n                observeTransferMethodsResult(transferResultObservable)\n                observeCardVerificationResult(cardVerificationResultObservable)\n            }\n            .doOnDispose {\n                disposeBag.clear()\n            }");
        return doOnDispose;
    }

    public final void swapFields() {
        ConsumerAmountPickerViewState copy;
        this.amountViewModel.swapFields();
        this.store.set(StoreKeys_ConsumerConnectKt.isFiatSelectedForConsumer(StoreKeys.INSTANCE), Boolean.valueOf(this.amountViewModel.isFiatSelected()));
        copy = r4.copy((r32 & 1) != 0 ? r4.maxAmount : null, (r32 & 2) != 0 ? r4.isMaxButtonLoading : false, (r32 & 4) != 0 ? r4.isNextButtonVisible : false, (r32 & 8) != 0 ? r4.isNextButtonLoading : false, (r32 & 16) != 0 ? r4.isFiatSelected : this.amountViewModel.isFiatSelected(), (r32 & 32) != 0 ? r4.primaryText : null, (r32 & 64) != 0 ? r4.secondaryText : null, (r32 & 128) != 0 ? r4.swapButtonEnabled : false, (r32 & 256) != 0 ? r4.currencyCode : null, (r32 & 512) != 0 ? r4.keyboardLocale : null, (r32 & 1024) != 0 ? r4.isOnrampEnabled : false, (r32 & PKIFailureInfo.wrongIntegrity) != 0 ? r4.cryptoBalance : null, (r32 & 4096) != 0 ? r4.fiatBalance : null, (r32 & PKIFailureInfo.certRevoked) != 0 ? r4.isInsufficientBalance : false, (r32 & 16384) != 0 ? this.state.wallet : null);
        setState(copy);
    }
}