package com.coinbase.wallet.features.swap.viewmodels;

import android.annotation.SuppressLint;
import com.coinbase.ApiConstants;
import com.coinbase.ciphercore.ByteArray_CipherCoreKt;
import com.coinbase.ciphercore.ethereum.EthereumChain;
import com.coinbase.wallet.analytics.Analytics;
import com.coinbase.wallet.analytics.extensions.Single_AnalyticsKt;
import com.coinbase.wallet.analytics.models.AnalyticsEvent;
import com.coinbase.wallet.application.extensions.AnalyticsEvent_ApplicationKt;
import com.coinbase.wallet.authentication.AppLockType;
import com.coinbase.wallet.authentication.AuthenticationResult;
import com.coinbase.wallet.blockchains.models.Blockchain;
import com.coinbase.wallet.blockchains.models.CurrencyCode;
import com.coinbase.wallet.blockchains.models.TransferValue;
import com.coinbase.wallet.blockchains.models.Wallet;
import com.coinbase.wallet.common.extensions.SavedStateHandle_CommonKt;
import com.coinbase.wallet.common.extensions.WalletRepository_CommonKt;
import com.coinbase.wallet.common.utilities.LocalizedStrings;
import com.coinbase.wallet.commonui.extensions.Fragment_CommonKt;
import com.coinbase.wallet.commonui.models.ActionStyle;
import com.coinbase.wallet.commonui.models.ViewModelNavRoute;
import com.coinbase.wallet.commonui.utilities.PromptDialogHelper;
import com.coinbase.wallet.core.extensions.Observable_CoreKt;
import com.coinbase.wallet.core.extensions.Single_CoreKt;
import com.coinbase.wallet.core.extensions.Strings;
import com.coinbase.wallet.core.extensions.Strings_CoreKt;
import com.coinbase.wallet.core.util.Optional;
import com.coinbase.wallet.ethereum.extensions.Blockchain_EthereumKt;
import com.coinbase.wallet.ethereum.extensions.Network_EthereumKt;
import com.coinbase.wallet.ethereum.interfaces.IETHTxRepository;
import com.coinbase.wallet.ethereum.models.ContractAddress;
import com.coinbase.wallet.ethereum.models.EthereumSignedTx;
import com.coinbase.wallet.ethereum.models.EthereumUnsigned1559Tx;
import com.coinbase.wallet.ethereum.models.EthereumUnsignedLegacyTx;
import com.coinbase.wallet.ethereum.models.EthereumUnsignedTx;
import com.coinbase.wallet.features.applock.exceptions.AppLockException;
import com.coinbase.wallet.features.applock.legacy.AuthenticationHelper;
import com.coinbase.wallet.features.cloudbackup.models.OnboardingBackupRecoveryPhraseArgs;
import com.coinbase.wallet.features.send.prompts.HighMinerFeesPrompt;
import com.coinbase.wallet.features.swap.models.SwapCompleteFragmentArgs;
import com.coinbase.wallet.features.swap.models.SwapConfirmationArgs;
import com.coinbase.wallet.features.swap.models.SwapConfirmationError;
import com.coinbase.wallet.features.swap.models.SwapConfirmationEvent;
import com.coinbase.wallet.features.swap.models.SwapConfirmationViewState;
import com.coinbase.wallet.features.swap.models.SwapConfirmationViewStateKt;
import com.coinbase.wallet.features.swap.models.SwapCurrencyType;
import com.coinbase.wallet.features.swap.viewmodels.SwapConfirmationViewModel;
import com.coinbase.wallet.features.wallets.extensions.Wallet_ApplicationKt;
import com.coinbase.wallet.swap.interfaces.ISwapRepository;
import com.coinbase.wallet.swap.models.Aggregator;
import com.coinbase.wallet.swap.models.AmountBase;
import com.coinbase.wallet.swap.models.SwapAsset;
import com.coinbase.wallet.swap.models.SwapTrade;
import com.coinbase.wallet.wallets.formatters.CurrencyFormatter;
import com.coinbase.wallet.wallets.interfaces.IExchangeRateRepository;
import com.coinbase.wallet.wallets.interfaces.IWalletRepository;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import okhttp3.internal.http2.Settings;
import org.spongycastle.asn1.cmp.PKIFailureInfo;
import org.toshi.R;

/* compiled from: SwapConfirmationViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000ü\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0006\u0082\u0001\u0083\u0001\u0084\u0001BM\b\u0007\u0012\u0006\u0010\u007f\u001a\u00020~\u0012\u0006\u0010n\u001a\u00020m\u0012\u0006\u0010D\u001a\u00020C\u0012\u0006\u0010q\u001a\u00020p\u0012\u0006\u0010S\u001a\u00020R\u0012\u0006\u0010a\u001a\u00020`\u0012\u0006\u0010:\u001a\u000209\u0012\b\b\u0001\u0010g\u001a\u00020f¢\u0006\u0006\b\u0080\u0001\u0010\u0081\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0003\u0010\u0004J/\u0010\n\u001a\"\u0012\u001e\u0012\u001c\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0012\u0004\u0012\u00020\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u00060\u0005H\u0002¢\u0006\u0004\b\n\u0010\u000bJ7\u0010\u000e\u001a\"\u0012\u001e\u0012\u001c\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0012\u0004\u0012\u00020\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u00060\u00052\u0006\u0010\r\u001a\u00020\fH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ?\u0010\u0012\u001a\"\u0012\u001e\u0012\u001c\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0012\u0004\u0012\u00020\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u00060\u00052\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0014H\u0002¢\u0006\u0004\b\u0016\u0010\u0017JI\u0010!\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u00072\b\u0010\u001c\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020\u001d2\u0006\u0010 \u001a\u00020\u0018H\u0002¢\u0006\u0004\b!\u0010\"J\u000f\u0010#\u001a\u00020\u0002H\u0002¢\u0006\u0004\b#\u0010\u0004J\u0013\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00020\u0005¢\u0006\u0004\b$\u0010\u000bJ\u0015\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00020\u0005H\u0007¢\u0006\u0004\b%\u0010\u000bJ\r\u0010&\u001a\u00020\u0002¢\u0006\u0004\b&\u0010\u0004J\r\u0010'\u001a\u00020\u0002¢\u0006\u0004\b'\u0010\u0004J\r\u0010(\u001a\u00020\u0002¢\u0006\u0004\b(\u0010\u0004J\r\u0010)\u001a\u00020\u0002¢\u0006\u0004\b)\u0010\u0004J\r\u0010*\u001a\u00020\u0002¢\u0006\u0004\b*\u0010\u0004J\r\u0010+\u001a\u00020\u0002¢\u0006\u0004\b+\u0010\u0004J\u000f\u0010,\u001a\u00020\u0002H\u0014¢\u0006\u0004\b,\u0010\u0004R\u0016\u0010.\u001a\u00020-8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b.\u0010/R\u001c\u00100\u001a\b\u0012\u0004\u0012\u00020\u001d0\u00058\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b0\u00101R\u001c\u00104\u001a\b\u0012\u0004\u0012\u000203028\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b4\u00105R\u0016\u00107\u001a\u0002068\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b7\u00108R\u0016\u0010:\u001a\u0002098\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b:\u0010;R\u001c\u0010<\u001a\b\u0012\u0004\u0012\u00020\u001d0\u00058\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b<\u00101R\u001f\u0010>\u001a\b\u0012\u0004\u0012\u0002030=8\u0006@\u0006¢\u0006\f\n\u0004\b>\u0010?\u001a\u0004\b@\u0010AR\u0016\u0010B\u001a\u0002068\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bB\u00108R\u0016\u0010D\u001a\u00020C8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bD\u0010ER\u001c\u0010F\u001a\b\u0012\u0004\u0012\u00020\u0002028\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bF\u00105R\u001f\u0010H\u001a\b\u0012\u0004\u0012\u00020G0=8\u0006@\u0006¢\u0006\f\n\u0004\bH\u0010?\u001a\u0004\bI\u0010AR$\u0010L\u001a\u00020J2\u0006\u0010K\u001a\u00020J8\u0002@BX\u0082\u000e¢\u0006\f\n\u0004\bL\u0010M\"\u0004\bN\u0010OR\u001f\u0010P\u001a\b\u0012\u0004\u0012\u00020J0=8\u0006@\u0006¢\u0006\f\n\u0004\bP\u0010?\u001a\u0004\bQ\u0010AR\u0016\u0010S\u001a\u00020R8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bS\u0010TR\u0016\u0010V\u001a\u00020U8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bV\u0010WR\u0016\u0010Y\u001a\u00020X8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bY\u0010ZR\u001c\u0010\\\u001a\b\u0012\u0004\u0012\u00020J0[8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\\\u0010]R\u001f\u0010^\u001a\b\u0012\u0004\u0012\u00020\u00020=8\u0006@\u0006¢\u0006\f\n\u0004\b^\u0010?\u001a\u0004\b_\u0010AR\u0016\u0010a\u001a\u00020`8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\ba\u0010bR\u0016\u0010d\u001a\u00020c8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bd\u0010eR\u0016\u0010g\u001a\u00020f8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bg\u0010hR\u0016\u0010j\u001a\u00020i8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bj\u0010kR\u001c\u0010l\u001a\b\u0012\u0004\u0012\u00020G028\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bl\u00105R\u0016\u0010n\u001a\u00020m8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bn\u0010oR\u0016\u0010q\u001a\u00020p8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bq\u0010rR\u0016\u0010t\u001a\u00020s8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bt\u0010uR\u001c\u0010v\u001a\b\u0012\u0004\u0012\u00020\t0\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bv\u0010wR\u0018\u0010x\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bx\u0010yR\u001c\u0010{\u001a\b\u0012\u0004\u0012\u00020z028\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b{\u00105R\u001f\u0010|\u001a\b\u0012\u0004\u0012\u00020z0=8\u0006@\u0006¢\u0006\f\n\u0004\b|\u0010?\u001a\u0004\b}\u0010A¨\u0006\u0085\u0001"}, d2 = {"Lcom/coinbase/wallet/features/swap/viewmodels/SwapConfirmationViewModel;", "Landroidx/lifecycle/b0;", "Lkotlin/x;", "fetchReceiptInformation", "()V", "Lh/c/b0;", "Lkotlin/t;", "Ljava/math/BigInteger;", "", "Lcom/coinbase/wallet/features/swap/viewmodels/SwapConfirmationViewModel$SwapTxPair;", "getMinerFeeAndTxs", "()Lh/c/b0;", "", OnboardingBackupRecoveryPhraseArgs.mnemonicKey, "getMinerFeeAndSignedTxs", "(Ljava/lang/String;)Lh/c/b0;", "Lcom/coinbase/wallet/ethereum/models/EthereumUnsignedTx;", "unsignedApproveTx", "getSimulatorServiceMinerFeeAndSignedTxs", "(Ljava/lang/String;Lcom/coinbase/wallet/ethereum/models/EthereumUnsignedTx;)Lh/c/b0;", "Lcom/coinbase/wallet/features/swap/viewmodels/SwapConfirmationViewModel$ConfirmationResult;", "result", "handleUnsignedSwapTxs", "(Lcom/coinbase/wallet/features/swap/viewmodels/SwapConfirmationViewModel$ConfirmationResult;)V", "", "isSourceAndFeeSame", "coinbaseFee", "estimatedMinerFee", "gasPrice", "Lcom/coinbase/wallet/blockchains/models/Wallet;", "minerFeeWallet", "sourceWallet", "hasHighPriceImpact", "handleFees", "(ZLjava/math/BigInteger;Ljava/math/BigInteger;Ljava/math/BigInteger;Lcom/coinbase/wallet/blockchains/models/Wallet;Lcom/coinbase/wallet/blockchains/models/Wallet;Z)V", "handleNotEnoughFundsError", "setup", "confirmTx", "retry", "toggleDetails", "presentEstimatedInfo", "presentMinerFeeInfo", "presentCoinbaseFeeInfo", "presentPriceImpactInfo", "onCleared", "Ljava/math/BigDecimal;", "highFeeThreshold", "Ljava/math/BigDecimal;", "ethereumWalletSingle", "Lh/c/b0;", "Lh/c/v0/b;", "Lcom/coinbase/wallet/commonui/models/ViewModelNavRoute;", "navigationSubject", "Lh/c/v0/b;", "Lcom/coinbase/wallet/swap/models/SwapAsset;", "sourceAsset", "Lcom/coinbase/wallet/swap/models/SwapAsset;", "Lcom/coinbase/wallet/features/send/prompts/HighMinerFeesPrompt;", "highMinerFeesPrompt", "Lcom/coinbase/wallet/features/send/prompts/HighMinerFeesPrompt;", "sourceWalletSingle", "Lh/c/s;", "navigationObservable", "Lh/c/s;", "getNavigationObservable", "()Lh/c/s;", "targetAsset", "Lcom/coinbase/wallet/wallets/interfaces/IExchangeRateRepository;", "exchangeRateRepository", "Lcom/coinbase/wallet/wallets/interfaces/IExchangeRateRepository;", "dismissSubject", "Lcom/coinbase/wallet/features/swap/models/SwapConfirmationEvent;", "eventObservable", "getEventObservable", "Lcom/coinbase/wallet/features/swap/models/SwapConfirmationViewState;", "value", ApiConstants.STATE, "Lcom/coinbase/wallet/features/swap/models/SwapConfirmationViewState;", "setState", "(Lcom/coinbase/wallet/features/swap/models/SwapConfirmationViewState;)V", "stateObservable", "getStateObservable", "Lcom/coinbase/wallet/wallets/formatters/CurrencyFormatter;", "currencyFormatter", "Lcom/coinbase/wallet/wallets/formatters/CurrencyFormatter;", "Lcom/coinbase/wallet/swap/models/SwapTrade;", SwapConfirmationArgs.swapTradeKey, "Lcom/coinbase/wallet/swap/models/SwapTrade;", "Lcom/coinbase/wallet/blockchains/models/TransferValue;", "transferAmount", "Lcom/coinbase/wallet/blockchains/models/TransferValue;", "Lh/c/v0/a;", "stateSubject", "Lh/c/v0/a;", "dismissObservable", "getDismissObservable", "Lcom/coinbase/wallet/features/applock/legacy/AuthenticationHelper;", "authenticationHelper", "Lcom/coinbase/wallet/features/applock/legacy/AuthenticationHelper;", "Lh/c/k0/a;", "disposeBag", "Lh/c/k0/a;", "Landroidx/lifecycle/z;", "savedStateHandle", "Landroidx/lifecycle/z;", "Lcom/coinbase/wallet/features/swap/models/SwapCurrencyType;", SwapConfirmationArgs.currencyTypeKey, "Lcom/coinbase/wallet/features/swap/models/SwapCurrencyType;", "eventSubject", "Lcom/coinbase/wallet/swap/interfaces/ISwapRepository;", "swapRepository", "Lcom/coinbase/wallet/swap/interfaces/ISwapRepository;", "Lcom/coinbase/wallet/ethereum/interfaces/IETHTxRepository;", "ethTxRepository", "Lcom/coinbase/wallet/ethereum/interfaces/IETHTxRepository;", "Lcom/coinbase/wallet/swap/models/AmountBase;", "amountBase", "Lcom/coinbase/wallet/swap/models/AmountBase;", "swapTxs", "Ljava/util/List;", "coinbaseFeePercentage", "Ljava/lang/String;", "Lcom/coinbase/wallet/commonui/utilities/PromptDialogHelper$Properties;", "promptSubject", "promptObservable", "getPromptObservable", "Lcom/coinbase/wallet/wallets/interfaces/IWalletRepository;", "walletRepository", "<init>", "(Lcom/coinbase/wallet/wallets/interfaces/IWalletRepository;Lcom/coinbase/wallet/swap/interfaces/ISwapRepository;Lcom/coinbase/wallet/wallets/interfaces/IExchangeRateRepository;Lcom/coinbase/wallet/ethereum/interfaces/IETHTxRepository;Lcom/coinbase/wallet/wallets/formatters/CurrencyFormatter;Lcom/coinbase/wallet/features/applock/legacy/AuthenticationHelper;Lcom/coinbase/wallet/features/send/prompts/HighMinerFeesPrompt;Landroidx/lifecycle/z;)V", "ConfirmationResult", "Factory", "SwapTxPair", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class SwapConfirmationViewModel extends androidx.lifecycle.b0 {
    private final AmountBase amountBase;
    private final AuthenticationHelper authenticationHelper;
    private String coinbaseFeePercentage;
    private final CurrencyFormatter currencyFormatter;
    private final SwapCurrencyType currencyType;
    private final h.c.s<kotlin.x> dismissObservable;
    private final h.c.v0.b<kotlin.x> dismissSubject;
    private final h.c.k0.a disposeBag;
    private final IETHTxRepository ethTxRepository;
    private final h.c.b0<Wallet> ethereumWalletSingle;
    private final h.c.s<SwapConfirmationEvent> eventObservable;
    private final h.c.v0.b<SwapConfirmationEvent> eventSubject;
    private final IExchangeRateRepository exchangeRateRepository;
    private final BigDecimal highFeeThreshold;
    private final HighMinerFeesPrompt highMinerFeesPrompt;
    private final h.c.s<ViewModelNavRoute> navigationObservable;
    private final h.c.v0.b<ViewModelNavRoute> navigationSubject;
    private final h.c.s<PromptDialogHelper.Properties> promptObservable;
    private final h.c.v0.b<PromptDialogHelper.Properties> promptSubject;
    private final androidx.lifecycle.z savedStateHandle;
    private final SwapAsset sourceAsset;
    private final h.c.b0<Wallet> sourceWalletSingle;
    private SwapConfirmationViewState state;
    private final h.c.s<SwapConfirmationViewState> stateObservable;
    private final h.c.v0.a<SwapConfirmationViewState> stateSubject;
    private final ISwapRepository swapRepository;
    private final SwapTrade swapTrade;
    private List<SwapTxPair> swapTxs;
    private final SwapAsset targetAsset;
    private final TransferValue transferAmount;

    /* compiled from: SwapConfirmationViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\r\b\u0082\b\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u000f\u001a\u00020\u0005\u0012\u0006\u0010\u0010\u001a\u00020\t\u0012\u0006\u0010\u0011\u001a\u00020\t¢\u0006\u0004\b&\u0010'J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\b\u0010\u0007J\u0010\u0010\n\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b\f\u0010\u000bJD\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\r\u001a\u00020\u00022\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u000f\u001a\u00020\u00052\b\b\u0002\u0010\u0010\u001a\u00020\t2\b\b\u0002\u0010\u0011\u001a\u00020\tHÆ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0015\u001a\u00020\u0014HÖ\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0018\u001a\u00020\u0017HÖ\u0001¢\u0006\u0004\b\u0018\u0010\u0019J\u001a\u0010\u001c\u001a\u00020\u001b2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001c\u0010\u001dR\u0019\u0010\u000f\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u001e\u001a\u0004\b\u001f\u0010\u0007R\u0019\u0010\u0010\u001a\u00020\t8\u0006@\u0006¢\u0006\f\n\u0004\b\u0010\u0010 \u001a\u0004\b!\u0010\u000bR\u0019\u0010\u0011\u001a\u00020\t8\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010 \u001a\u0004\b\"\u0010\u000bR\u001b\u0010\u000e\u001a\u0004\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u001e\u001a\u0004\b#\u0010\u0007R\u0019\u0010\r\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010$\u001a\u0004\b%\u0010\u0004¨\u0006("}, d2 = {"Lcom/coinbase/wallet/features/swap/viewmodels/SwapConfirmationViewModel$ConfirmationResult;", "", "Lcom/coinbase/wallet/swap/models/SwapTrade;", "component1", "()Lcom/coinbase/wallet/swap/models/SwapTrade;", "Ljava/math/BigInteger;", "component2", "()Ljava/math/BigInteger;", "component3", "Lcom/coinbase/wallet/blockchains/models/Wallet;", "component4", "()Lcom/coinbase/wallet/blockchains/models/Wallet;", "component5", "trade", "lowerBoundFee", "estimatedMinerFee", "sourceWallet", "minerFeeWallet", "copy", "(Lcom/coinbase/wallet/swap/models/SwapTrade;Ljava/math/BigInteger;Ljava/math/BigInteger;Lcom/coinbase/wallet/blockchains/models/Wallet;Lcom/coinbase/wallet/blockchains/models/Wallet;)Lcom/coinbase/wallet/features/swap/viewmodels/SwapConfirmationViewModel$ConfirmationResult;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/math/BigInteger;", "getEstimatedMinerFee", "Lcom/coinbase/wallet/blockchains/models/Wallet;", "getSourceWallet", "getMinerFeeWallet", "getLowerBoundFee", "Lcom/coinbase/wallet/swap/models/SwapTrade;", "getTrade", "<init>", "(Lcom/coinbase/wallet/swap/models/SwapTrade;Ljava/math/BigInteger;Ljava/math/BigInteger;Lcom/coinbase/wallet/blockchains/models/Wallet;Lcom/coinbase/wallet/blockchains/models/Wallet;)V", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public static final class ConfirmationResult {
        private final BigInteger estimatedMinerFee;
        private final BigInteger lowerBoundFee;
        private final Wallet minerFeeWallet;
        private final Wallet sourceWallet;
        private final SwapTrade trade;

        public ConfirmationResult(SwapTrade trade, BigInteger bigInteger, BigInteger estimatedMinerFee, Wallet sourceWallet, Wallet minerFeeWallet) {
            kotlin.jvm.internal.m.g(trade, "trade");
            kotlin.jvm.internal.m.g(estimatedMinerFee, "estimatedMinerFee");
            kotlin.jvm.internal.m.g(sourceWallet, "sourceWallet");
            kotlin.jvm.internal.m.g(minerFeeWallet, "minerFeeWallet");
            this.trade = trade;
            this.lowerBoundFee = bigInteger;
            this.estimatedMinerFee = estimatedMinerFee;
            this.sourceWallet = sourceWallet;
            this.minerFeeWallet = minerFeeWallet;
        }

        public static /* synthetic */ ConfirmationResult copy$default(ConfirmationResult confirmationResult, SwapTrade swapTrade, BigInteger bigInteger, BigInteger bigInteger2, Wallet wallet, Wallet wallet2, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                swapTrade = confirmationResult.trade;
            }
            if ((i2 & 2) != 0) {
                bigInteger = confirmationResult.lowerBoundFee;
            }
            BigInteger bigInteger3 = bigInteger;
            if ((i2 & 4) != 0) {
                bigInteger2 = confirmationResult.estimatedMinerFee;
            }
            BigInteger bigInteger4 = bigInteger2;
            if ((i2 & 8) != 0) {
                wallet = confirmationResult.sourceWallet;
            }
            Wallet wallet3 = wallet;
            if ((i2 & 16) != 0) {
                wallet2 = confirmationResult.minerFeeWallet;
            }
            return confirmationResult.copy(swapTrade, bigInteger3, bigInteger4, wallet3, wallet2);
        }

        public final SwapTrade component1() {
            return this.trade;
        }

        public final BigInteger component2() {
            return this.lowerBoundFee;
        }

        public final BigInteger component3() {
            return this.estimatedMinerFee;
        }

        public final Wallet component4() {
            return this.sourceWallet;
        }

        public final Wallet component5() {
            return this.minerFeeWallet;
        }

        public final ConfirmationResult copy(SwapTrade trade, BigInteger bigInteger, BigInteger estimatedMinerFee, Wallet sourceWallet, Wallet minerFeeWallet) {
            kotlin.jvm.internal.m.g(trade, "trade");
            kotlin.jvm.internal.m.g(estimatedMinerFee, "estimatedMinerFee");
            kotlin.jvm.internal.m.g(sourceWallet, "sourceWallet");
            kotlin.jvm.internal.m.g(minerFeeWallet, "minerFeeWallet");
            return new ConfirmationResult(trade, bigInteger, estimatedMinerFee, sourceWallet, minerFeeWallet);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof ConfirmationResult) {
                ConfirmationResult confirmationResult = (ConfirmationResult) obj;
                return kotlin.jvm.internal.m.c(this.trade, confirmationResult.trade) && kotlin.jvm.internal.m.c(this.lowerBoundFee, confirmationResult.lowerBoundFee) && kotlin.jvm.internal.m.c(this.estimatedMinerFee, confirmationResult.estimatedMinerFee) && kotlin.jvm.internal.m.c(this.sourceWallet, confirmationResult.sourceWallet) && kotlin.jvm.internal.m.c(this.minerFeeWallet, confirmationResult.minerFeeWallet);
            }
            return false;
        }

        public final BigInteger getEstimatedMinerFee() {
            return this.estimatedMinerFee;
        }

        public final BigInteger getLowerBoundFee() {
            return this.lowerBoundFee;
        }

        public final Wallet getMinerFeeWallet() {
            return this.minerFeeWallet;
        }

        public final Wallet getSourceWallet() {
            return this.sourceWallet;
        }

        public final SwapTrade getTrade() {
            return this.trade;
        }

        public int hashCode() {
            int hashCode = this.trade.hashCode() * 31;
            BigInteger bigInteger = this.lowerBoundFee;
            return ((((((hashCode + (bigInteger == null ? 0 : bigInteger.hashCode())) * 31) + this.estimatedMinerFee.hashCode()) * 31) + this.sourceWallet.hashCode()) * 31) + this.minerFeeWallet.hashCode();
        }

        public String toString() {
            return "ConfirmationResult(trade=" + this.trade + ", lowerBoundFee=" + this.lowerBoundFee + ", estimatedMinerFee=" + this.estimatedMinerFee + ", sourceWallet=" + this.sourceWallet + ", minerFeeWallet=" + this.minerFeeWallet + ')';
        }
    }

    /* compiled from: SwapConfirmationViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/coinbase/wallet/features/swap/viewmodels/SwapConfirmationViewModel$Factory;", "", "Landroidx/lifecycle/z;", "savedStateHandle", "Lcom/coinbase/wallet/features/swap/viewmodels/SwapConfirmationViewModel;", "create", "(Landroidx/lifecycle/z;)Lcom/coinbase/wallet/features/swap/viewmodels/SwapConfirmationViewModel;", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public interface Factory {
        SwapConfirmationViewModel create(androidx.lifecycle.z zVar);
    }

    /* compiled from: SwapConfirmationViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\b\u0082\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0005¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J$\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015R\u0019\u0010\b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\u0016\u001a\u0004\b\u0017\u0010\u0004R\u0019\u0010\t\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\u0018\u001a\u0004\b\u0019\u0010\u0007¨\u0006\u001c"}, d2 = {"Lcom/coinbase/wallet/features/swap/viewmodels/SwapConfirmationViewModel$SwapTxPair;", "", "Lcom/coinbase/wallet/ethereum/models/EthereumUnsignedTx;", "component1", "()Lcom/coinbase/wallet/ethereum/models/EthereumUnsignedTx;", "Lcom/coinbase/wallet/ethereum/models/EthereumSignedTx;", "component2", "()Lcom/coinbase/wallet/ethereum/models/EthereumSignedTx;", "unsignedTx", "signedTx", "copy", "(Lcom/coinbase/wallet/ethereum/models/EthereumUnsignedTx;Lcom/coinbase/wallet/ethereum/models/EthereumSignedTx;)Lcom/coinbase/wallet/features/swap/viewmodels/SwapConfirmationViewModel$SwapTxPair;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/coinbase/wallet/ethereum/models/EthereumUnsignedTx;", "getUnsignedTx", "Lcom/coinbase/wallet/ethereum/models/EthereumSignedTx;", "getSignedTx", "<init>", "(Lcom/coinbase/wallet/ethereum/models/EthereumUnsignedTx;Lcom/coinbase/wallet/ethereum/models/EthereumSignedTx;)V", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public static final class SwapTxPair {
        private final EthereumSignedTx signedTx;
        private final EthereumUnsignedTx unsignedTx;

        public SwapTxPair(EthereumUnsignedTx unsignedTx, EthereumSignedTx signedTx) {
            kotlin.jvm.internal.m.g(unsignedTx, "unsignedTx");
            kotlin.jvm.internal.m.g(signedTx, "signedTx");
            this.unsignedTx = unsignedTx;
            this.signedTx = signedTx;
        }

        public static /* synthetic */ SwapTxPair copy$default(SwapTxPair swapTxPair, EthereumUnsignedTx ethereumUnsignedTx, EthereumSignedTx ethereumSignedTx, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                ethereumUnsignedTx = swapTxPair.unsignedTx;
            }
            if ((i2 & 2) != 0) {
                ethereumSignedTx = swapTxPair.signedTx;
            }
            return swapTxPair.copy(ethereumUnsignedTx, ethereumSignedTx);
        }

        public final EthereumUnsignedTx component1() {
            return this.unsignedTx;
        }

        public final EthereumSignedTx component2() {
            return this.signedTx;
        }

        public final SwapTxPair copy(EthereumUnsignedTx unsignedTx, EthereumSignedTx signedTx) {
            kotlin.jvm.internal.m.g(unsignedTx, "unsignedTx");
            kotlin.jvm.internal.m.g(signedTx, "signedTx");
            return new SwapTxPair(unsignedTx, signedTx);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof SwapTxPair) {
                SwapTxPair swapTxPair = (SwapTxPair) obj;
                return kotlin.jvm.internal.m.c(this.unsignedTx, swapTxPair.unsignedTx) && kotlin.jvm.internal.m.c(this.signedTx, swapTxPair.signedTx);
            }
            return false;
        }

        public final EthereumSignedTx getSignedTx() {
            return this.signedTx;
        }

        public final EthereumUnsignedTx getUnsignedTx() {
            return this.unsignedTx;
        }

        public int hashCode() {
            return (this.unsignedTx.hashCode() * 31) + this.signedTx.hashCode();
        }

        public String toString() {
            return "SwapTxPair(unsignedTx=" + this.unsignedTx + ", signedTx=" + this.signedTx + ')';
        }
    }

    public SwapConfirmationViewModel(IWalletRepository walletRepository, ISwapRepository swapRepository, IExchangeRateRepository exchangeRateRepository, IETHTxRepository ethTxRepository, CurrencyFormatter currencyFormatter, AuthenticationHelper authenticationHelper, HighMinerFeesPrompt highMinerFeesPrompt, androidx.lifecycle.z savedStateHandle) {
        List<SwapTxPair> g2;
        SwapConfirmationViewState copy;
        kotlin.jvm.internal.m.g(walletRepository, "walletRepository");
        kotlin.jvm.internal.m.g(swapRepository, "swapRepository");
        kotlin.jvm.internal.m.g(exchangeRateRepository, "exchangeRateRepository");
        kotlin.jvm.internal.m.g(ethTxRepository, "ethTxRepository");
        kotlin.jvm.internal.m.g(currencyFormatter, "currencyFormatter");
        kotlin.jvm.internal.m.g(authenticationHelper, "authenticationHelper");
        kotlin.jvm.internal.m.g(highMinerFeesPrompt, "highMinerFeesPrompt");
        kotlin.jvm.internal.m.g(savedStateHandle, "savedStateHandle");
        this.swapRepository = swapRepository;
        this.exchangeRateRepository = exchangeRateRepository;
        this.ethTxRepository = ethTxRepository;
        this.currencyFormatter = currencyFormatter;
        this.authenticationHelper = authenticationHelper;
        this.highMinerFeesPrompt = highMinerFeesPrompt;
        this.savedStateHandle = savedStateHandle;
        SwapCurrencyType swapCurrencyType = (SwapCurrencyType) SavedStateHandle_CommonKt.require(savedStateHandle, SwapConfirmationArgs.currencyTypeKey);
        this.currencyType = swapCurrencyType;
        AmountBase amountBase = (AmountBase) SavedStateHandle_CommonKt.require(savedStateHandle, "amountBase");
        this.amountBase = amountBase;
        SwapAsset swapAsset = (SwapAsset) SavedStateHandle_CommonKt.require(savedStateHandle, "sourceAsset");
        this.sourceAsset = swapAsset;
        SwapAsset swapAsset2 = (SwapAsset) SavedStateHandle_CommonKt.require(savedStateHandle, "targetAsset");
        this.targetAsset = swapAsset2;
        this.transferAmount = (TransferValue) SavedStateHandle_CommonKt.require(savedStateHandle, "amount");
        this.swapTrade = (SwapTrade) SavedStateHandle_CommonKt.require(savedStateHandle, SwapConfirmationArgs.swapTradeKey);
        BigDecimal ONE = BigDecimal.ONE;
        kotlin.jvm.internal.m.f(ONE, "ONE");
        this.highFeeThreshold = ONE;
        this.disposeBag = new h.c.k0.a();
        h.c.v0.b<SwapConfirmationEvent> d2 = h.c.v0.b.d();
        kotlin.jvm.internal.m.f(d2, "create()");
        this.eventSubject = d2;
        h.c.v0.b<PromptDialogHelper.Properties> d3 = h.c.v0.b.d();
        kotlin.jvm.internal.m.f(d3, "create()");
        this.promptSubject = d3;
        h.c.v0.b<ViewModelNavRoute> d4 = h.c.v0.b.d();
        kotlin.jvm.internal.m.f(d4, "create()");
        this.navigationSubject = d4;
        h.c.v0.b<kotlin.x> d5 = h.c.v0.b.d();
        kotlin.jvm.internal.m.f(d5, "create()");
        this.dismissSubject = d5;
        h.c.v0.a<SwapConfirmationViewState> d6 = h.c.v0.a.d();
        kotlin.jvm.internal.m.f(d6, "create()");
        this.stateSubject = d6;
        Blockchain.Companion companion = Blockchain.Companion;
        h.c.s<R> map = WalletRepository_CommonKt.observeWallet(walletRepository, Blockchain_EthereumKt.getETHEREUM(companion), (ContractAddress) null).filter(new h.c.m0.p() { // from class: com.coinbase.wallet.features.swap.viewmodels.SwapConfirmationViewModel$special$$inlined$unwrap$1
            public final boolean test(Optional<? extends T> it) {
                kotlin.jvm.internal.m.g(it, "it");
                return it.toNullable() != null;
            }

            @Override // h.c.m0.p
            public /* bridge */ /* synthetic */ boolean test(Object obj) {
                return test((Optional) ((Optional) obj));
            }
        }).map(new h.c.m0.n() { // from class: com.coinbase.wallet.features.swap.viewmodels.SwapConfirmationViewModel$special$$inlined$unwrap$2
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
        this.ethereumWalletSingle = Observable_CoreKt.takeSingle(map);
        h.c.s<R> map2 = WalletRepository_CommonKt.observeWallet(walletRepository, Blockchain_EthereumKt.getETHEREUM(companion), swapAsset.getContractAddress()).filter(new h.c.m0.p() { // from class: com.coinbase.wallet.features.swap.viewmodels.SwapConfirmationViewModel$special$$inlined$unwrap$3
            public final boolean test(Optional<? extends T> it) {
                kotlin.jvm.internal.m.g(it, "it");
                return it.toNullable() != null;
            }

            @Override // h.c.m0.p
            public /* bridge */ /* synthetic */ boolean test(Object obj) {
                return test((Optional) ((Optional) obj));
            }
        }).map(new h.c.m0.n() { // from class: com.coinbase.wallet.features.swap.viewmodels.SwapConfirmationViewModel$special$$inlined$unwrap$4
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
        this.sourceWalletSingle = Observable_CoreKt.takeSingle(map2);
        g2 = kotlin.a0.r.g();
        this.swapTxs = g2;
        this.state = new SwapConfirmationViewState(null, null, null, false, false, false, null, null, null, null, null, null, null, null, null, null, Settings.DEFAULT_INITIAL_WINDOW_SIZE, null);
        h.c.s<SwapConfirmationEvent> hide = d2.hide();
        kotlin.jvm.internal.m.f(hide, "eventSubject.hide()");
        this.eventObservable = hide;
        h.c.s<PromptDialogHelper.Properties> hide2 = d3.hide();
        kotlin.jvm.internal.m.f(hide2, "promptSubject.hide()");
        this.promptObservable = hide2;
        h.c.s<ViewModelNavRoute> hide3 = d4.hide();
        kotlin.jvm.internal.m.f(hide3, "navigationSubject.hide()");
        this.navigationObservable = hide3;
        h.c.s<kotlin.x> hide4 = d5.hide();
        kotlin.jvm.internal.m.f(hide4, "dismissSubject.hide()");
        this.dismissObservable = hide4;
        h.c.s<SwapConfirmationViewState> hide5 = d6.hide();
        kotlin.jvm.internal.m.f(hide5, "stateSubject.hide()");
        this.stateObservable = hide5;
        String code = swapAsset2.getCurrencyCode().getCode();
        URL imageURL = swapAsset2.getImageURL();
        copy = r3.copy((r34 & 1) != 0 ? r3.amountBase : amountBase, (r34 & 2) != 0 ? r3.currencyType : swapCurrencyType, (r34 & 4) != 0 ? r3.cardTitle : null, (r34 & 8) != 0 ? r3.isLoading : false, (r34 & 16) != 0 ? r3.isConverting : false, (r34 & 32) != 0 ? r3.isConvertButtonVisible : false, (r34 & 64) != 0 ? r3.targetCurrencyCode : code, (r34 & 128) != 0 ? r3.targetImageURL : imageURL == null ? null : imageURL.toString(), (r34 & 256) != 0 ? r3.sourceCryptoAmount : null, (r34 & 512) != 0 ? r3.sourceFiatAmount : null, (r34 & 1024) != 0 ? r3.targetCryptoAmount : null, (r34 & PKIFailureInfo.wrongIntegrity) != 0 ? r3.minerFeeFiatAmount : null, (r34 & 4096) != 0 ? r3.minerFeeCryptoAmount : null, (r34 & PKIFailureInfo.certRevoked) != 0 ? r3.coinbaseFeeFiatAmount : null, (r34 & 16384) != 0 ? r3.coinbaseFeeCryptoAmount : null, (r34 & 32768) != 0 ? this.state.error : null);
        setState(copy);
    }

    public static /* synthetic */ h.c.h0 a(SwapConfirmationViewModel swapConfirmationViewModel, String str, EthereumUnsignedTx ethereumUnsignedTx, kotlin.o oVar) {
        return m1499getSimulatorServiceMinerFeeAndSignedTxs$lambda21(swapConfirmationViewModel, str, ethereumUnsignedTx, oVar);
    }

    public static /* synthetic */ kotlin.t b(BigInteger bigInteger, SwapTxPair swapTxPair) {
        return m1487getMinerFeeAndSignedTxs$lambda12(bigInteger, swapTxPair);
    }

    public static /* synthetic */ h.c.h0 c(SwapConfirmationViewModel swapConfirmationViewModel, String str, EthereumUnsignedTx ethereumUnsignedTx, kotlin.o oVar) {
        return m1494getSimulatorServiceMinerFeeAndSignedTxs$lambda15(swapConfirmationViewModel, str, ethereumUnsignedTx, oVar);
    }

    /* renamed from: confirmTx$lambda-3 */
    public static final void m1483confirmTx$lambda3(SwapConfirmationViewModel this$0, List list) {
        List<SwapTxPair> g2;
        kotlin.jvm.internal.m.g(this$0, "this$0");
        g2 = kotlin.a0.r.g();
        this$0.swapTxs = g2;
        this$0.navigationSubject.onNext(new ViewModelNavRoute(R.id.action_swapConfirmationFragment_to_swapCompleteFragment, SwapCompleteFragmentArgs.INSTANCE.createArguments(this$0.sourceAsset.getCurrencyCode()), Fragment_CommonKt.getFadeInNavOptions(this$0)));
    }

    /* renamed from: confirmTx$lambda-4 */
    public static final void m1484confirmTx$lambda4(SwapConfirmationViewModel this$0, Throwable th) {
        SwapConfirmationViewState copy;
        kotlin.jvm.internal.m.g(this$0, "this$0");
        SwapConfirmationError.FeeCalculationFailed feeCalculationFailed = new SwapConfirmationError.FeeCalculationFailed(LocalizedStrings.INSTANCE.get(R.string.send_confirm_calculation_error));
        copy = r2.copy((r34 & 1) != 0 ? r2.amountBase : null, (r34 & 2) != 0 ? r2.currencyType : null, (r34 & 4) != 0 ? r2.cardTitle : null, (r34 & 8) != 0 ? r2.isLoading : false, (r34 & 16) != 0 ? r2.isConverting : false, (r34 & 32) != 0 ? r2.isConvertButtonVisible : false, (r34 & 64) != 0 ? r2.targetCurrencyCode : null, (r34 & 128) != 0 ? r2.targetImageURL : null, (r34 & 256) != 0 ? r2.sourceCryptoAmount : null, (r34 & 512) != 0 ? r2.sourceFiatAmount : null, (r34 & 1024) != 0 ? r2.targetCryptoAmount : null, (r34 & PKIFailureInfo.wrongIntegrity) != 0 ? r2.minerFeeFiatAmount : null, (r34 & 4096) != 0 ? r2.minerFeeCryptoAmount : null, (r34 & PKIFailureInfo.certRevoked) != 0 ? r2.coinbaseFeeFiatAmount : null, (r34 & 16384) != 0 ? r2.coinbaseFeeCryptoAmount : null, (r34 & 32768) != 0 ? this$0.state.error : feeCalculationFailed);
        this$0.setState(copy);
        Analytics.INSTANCE.log(AnalyticsEvent_ApplicationKt.swapConfirmErrorReceived(AnalyticsEvent.Companion, feeCalculationFailed.getDescription(), this$0.sourceAsset.getCurrencyCode().getCode(), this$0.targetAsset.getCurrencyCode().getCode()));
    }

    public static /* synthetic */ h.c.h0 d(SwapConfirmationViewModel swapConfirmationViewModel, List list) {
        return m1496getSimulatorServiceMinerFeeAndSignedTxs$lambda17(swapConfirmationViewModel, list);
    }

    public static /* synthetic */ h.c.h0 e(SwapConfirmationViewModel swapConfirmationViewModel, EthereumSignedTx ethereumSignedTx) {
        return m1493getSimulatorServiceMinerFeeAndSignedTxs$lambda13(swapConfirmationViewModel, ethereumSignedTx);
    }

    public static /* synthetic */ kotlin.o f(BigDecimal bigDecimal) {
        return m1504handleFees$lambda26(bigDecimal);
    }

    private final void fetchReceiptInformation() {
        SwapConfirmationViewState copy;
        copy = r1.copy((r34 & 1) != 0 ? r1.amountBase : null, (r34 & 2) != 0 ? r1.currencyType : null, (r34 & 4) != 0 ? r1.cardTitle : null, (r34 & 8) != 0 ? r1.isLoading : true, (r34 & 16) != 0 ? r1.isConverting : false, (r34 & 32) != 0 ? r1.isConvertButtonVisible : false, (r34 & 64) != 0 ? r1.targetCurrencyCode : null, (r34 & 128) != 0 ? r1.targetImageURL : null, (r34 & 256) != 0 ? r1.sourceCryptoAmount : null, (r34 & 512) != 0 ? r1.sourceFiatAmount : null, (r34 & 1024) != 0 ? r1.targetCryptoAmount : null, (r34 & PKIFailureInfo.wrongIntegrity) != 0 ? r1.minerFeeFiatAmount : null, (r34 & 4096) != 0 ? r1.minerFeeCryptoAmount : null, (r34 & PKIFailureInfo.certRevoked) != 0 ? r1.coinbaseFeeFiatAmount : null, (r34 & 16384) != 0 ? r1.coinbaseFeeCryptoAmount : null, (r34 & 32768) != 0 ? this.state.error : null);
        setState(copy);
        h.c.b0 observeOn = Single_AnalyticsKt.logError$default(h.c.t0.e.a.b(this.ethereumWalletSingle, this.sourceWalletSingle, getMinerFeeAndTxs()), null, null, 3, null).observeOn(h.c.j0.c.a.b());
        kotlin.jvm.internal.m.f(observeOn, "Singles.zip(ethereumWalletSingle, sourceWalletSingle, getMinerFeeAndTxs())\n            .logError()\n            .observeOn(AndroidSchedulers.mainThread())");
        h.c.t0.a.a(h.c.t0.g.f(observeOn, new SwapConfirmationViewModel$fetchReceiptInformation$1(this), new SwapConfirmationViewModel$fetchReceiptInformation$2(this)), this.disposeBag);
    }

    public static /* synthetic */ h.c.h0 g(SwapConfirmationViewModel swapConfirmationViewModel, String str, Optional optional) {
        return m1485getMinerFeeAndSignedTxs$lambda11(swapConfirmationViewModel, str, optional);
    }

    private final h.c.b0<kotlin.t<BigInteger, BigInteger, List<SwapTxPair>>> getMinerFeeAndSignedTxs(final String str) {
        EthereumChain fromChainId = EthereumChain.Companion.fromChainId(this.swapTrade.getChainId());
        boolean z = false;
        if (fromChainId != null && fromChainId.is1559Enabled()) {
            z = true;
        }
        if (z) {
            h.c.b0<kotlin.t<BigInteger, BigInteger, List<SwapTxPair>>> flatMap = ISwapRepository.DefaultImpls.generateUnsigned1559SwapTx$default(this.swapRepository, this.swapTrade, null, 2, null).flatMap(new h.c.m0.n() { // from class: com.coinbase.wallet.features.swap.viewmodels.m0
                @Override // h.c.m0.n
                public final Object apply(Object obj) {
                    return SwapConfirmationViewModel.t(SwapConfirmationViewModel.this, str, (Optional) obj);
                }
            });
            kotlin.jvm.internal.m.f(flatMap, "swapRepository.generateUnsigned1559SwapTx(swapTrade)\n                .flatMap { swapTx ->\n                    val unsignedSwapTx = swapTx.value ?: throw Exception(\"Unable to get swap tx\")\n                    ethTxRepository.sign1559Tx(tx = unsignedSwapTx, mnemonic = mnemonic)\n                        .map {\n                            Triple(\n                                unsignedSwapTx.lowerBoundFee,\n                                unsignedSwapTx.estimatedFee,\n                                listOf(SwapTxPair(unsignedTx = unsignedSwapTx, signedTx = it))\n                            )\n                        }\n                }");
            return flatMap;
        }
        final BigInteger estimatedSwapTxMinerFee = this.swapTrade.getEstimatedSwapTxMinerFee();
        if (estimatedSwapTxMinerFee == null) {
            h.c.b0<kotlin.t<BigInteger, BigInteger, List<SwapTxPair>>> error = h.c.b0.error(new Exception("Unable to get swap tx gas limit"));
            kotlin.jvm.internal.m.f(error, "error(Exception(\"Unable to get swap tx gas limit\"))");
            return error;
        }
        h.c.b0<kotlin.t<BigInteger, BigInteger, List<SwapTxPair>>> map = ISwapRepository.DefaultImpls.generateUnsignedSwapTx$default(this.swapRepository, this.swapTrade, null, 2, null).flatMap(new h.c.m0.n() { // from class: com.coinbase.wallet.features.swap.viewmodels.z
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return SwapConfirmationViewModel.g(SwapConfirmationViewModel.this, str, (Optional) obj);
            }
        }).map(new h.c.m0.n() { // from class: com.coinbase.wallet.features.swap.viewmodels.u
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return SwapConfirmationViewModel.b(estimatedSwapTxMinerFee, (SwapConfirmationViewModel.SwapTxPair) obj);
            }
        });
        kotlin.jvm.internal.m.f(map, "swapRepository.generateUnsignedSwapTx(swapTrade)\n                .flatMap { swapTx ->\n                    val unsignedSwapTx = swapTx.value ?: throw Exception(\"Unable to get swap tx\")\n                    ethTxRepository.signTx(tx = unsignedSwapTx, mnemonic = mnemonic)\n                        .map { SwapTxPair(unsignedTx = unsignedSwapTx, signedTx = it) }\n                }\n                .map { swapTx ->\n                    Triple(null, estimatedMinerFee, listOf(swapTx))\n                }");
        return map;
    }

    /* renamed from: getMinerFeeAndSignedTxs$lambda-11 */
    public static final h.c.h0 m1485getMinerFeeAndSignedTxs$lambda11(SwapConfirmationViewModel this$0, String mnemonic, Optional swapTx) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(mnemonic, "$mnemonic");
        kotlin.jvm.internal.m.g(swapTx, "swapTx");
        final EthereumUnsignedLegacyTx ethereumUnsignedLegacyTx = (EthereumUnsignedLegacyTx) swapTx.getValue();
        if (ethereumUnsignedLegacyTx != null) {
            return IETHTxRepository.DefaultImpls.signTx$default(this$0.ethTxRepository, ethereumUnsignedLegacyTx, mnemonic, false, 4, null).map(new h.c.m0.n() { // from class: com.coinbase.wallet.features.swap.viewmodels.d0
                @Override // h.c.m0.n
                public final Object apply(Object obj) {
                    return SwapConfirmationViewModel.k(EthereumUnsignedLegacyTx.this, (EthereumSignedTx) obj);
                }
            });
        }
        throw new Exception("Unable to get swap tx");
    }

    /* renamed from: getMinerFeeAndSignedTxs$lambda-11$lambda-10 */
    public static final SwapTxPair m1486getMinerFeeAndSignedTxs$lambda11$lambda10(EthereumUnsignedLegacyTx unsignedSwapTx, EthereumSignedTx it) {
        kotlin.jvm.internal.m.g(unsignedSwapTx, "$unsignedSwapTx");
        kotlin.jvm.internal.m.g(it, "it");
        return new SwapTxPair(unsignedSwapTx, it);
    }

    /* renamed from: getMinerFeeAndSignedTxs$lambda-12 */
    public static final kotlin.t m1487getMinerFeeAndSignedTxs$lambda12(BigInteger estimatedMinerFee, SwapTxPair swapTx) {
        List b2;
        kotlin.jvm.internal.m.g(estimatedMinerFee, "$estimatedMinerFee");
        kotlin.jvm.internal.m.g(swapTx, "swapTx");
        b2 = kotlin.a0.q.b(swapTx);
        return new kotlin.t(null, estimatedMinerFee, b2);
    }

    /* renamed from: getMinerFeeAndSignedTxs$lambda-9 */
    public static final h.c.h0 m1488getMinerFeeAndSignedTxs$lambda9(SwapConfirmationViewModel this$0, String mnemonic, Optional swapTx) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(mnemonic, "$mnemonic");
        kotlin.jvm.internal.m.g(swapTx, "swapTx");
        final EthereumUnsigned1559Tx ethereumUnsigned1559Tx = (EthereumUnsigned1559Tx) swapTx.getValue();
        if (ethereumUnsigned1559Tx != null) {
            return IETHTxRepository.DefaultImpls.sign1559Tx$default(this$0.ethTxRepository, ethereumUnsigned1559Tx, mnemonic, false, 4, null).map(new h.c.m0.n() { // from class: com.coinbase.wallet.features.swap.viewmodels.o0
                @Override // h.c.m0.n
                public final Object apply(Object obj) {
                    return SwapConfirmationViewModel.v(EthereumUnsigned1559Tx.this, (EthereumSignedTx) obj);
                }
            });
        }
        throw new Exception("Unable to get swap tx");
    }

    /* renamed from: getMinerFeeAndSignedTxs$lambda-9$lambda-8 */
    public static final kotlin.t m1489getMinerFeeAndSignedTxs$lambda9$lambda8(EthereumUnsigned1559Tx unsignedSwapTx, EthereumSignedTx it) {
        List b2;
        kotlin.jvm.internal.m.g(unsignedSwapTx, "$unsignedSwapTx");
        kotlin.jvm.internal.m.g(it, "it");
        BigInteger lowerBoundFee = unsignedSwapTx.getLowerBoundFee();
        BigInteger estimatedFee = unsignedSwapTx.getEstimatedFee();
        b2 = kotlin.a0.q.b(new SwapTxPair(unsignedSwapTx, it));
        return new kotlin.t(lowerBoundFee, estimatedFee, b2);
    }

    private final h.c.b0<kotlin.t<BigInteger, BigInteger, List<SwapTxPair>>> getMinerFeeAndTxs() {
        final h.c.b0 generateUnsignedApproveTx;
        EthereumChain fromChainId = EthereumChain.Companion.fromChainId(this.swapTrade.getChainId());
        boolean z = false;
        if (fromChainId != null && fromChainId.is1559Enabled()) {
            z = true;
        }
        if (z) {
            generateUnsignedApproveTx = this.swapRepository.generateUnsigned1559ApproveTx(this.swapTrade);
        } else {
            generateUnsignedApproveTx = this.swapRepository.generateUnsignedApproveTx(this.swapTrade);
        }
        h.c.b0<kotlin.t<BigInteger, BigInteger, List<SwapTxPair>>> flatMap = h.c.b0.just(AppLockType.Transactions.INSTANCE).observeOn(h.c.j0.c.a.b()).flatMap(new h.c.m0.n() { // from class: com.coinbase.wallet.features.swap.viewmodels.p0
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                h.c.h0 m1490getMinerFeeAndTxs$lambda6;
                m1490getMinerFeeAndTxs$lambda6 = SwapConfirmationViewModel.m1490getMinerFeeAndTxs$lambda6(SwapConfirmationViewModel.this, generateUnsignedApproveTx, (AppLockType.Transactions) obj);
                return m1490getMinerFeeAndTxs$lambda6;
            }
        }).flatMap(new h.c.m0.n() { // from class: com.coinbase.wallet.features.swap.viewmodels.c0
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return SwapConfirmationViewModel.j(SwapConfirmationViewModel.this, (kotlin.o) obj);
            }
        });
        kotlin.jvm.internal.m.f(flatMap, "just(AppLockType.Transactions)\n            .observeOn(AndroidSchedulers.mainThread())\n            .flatMap { appLockType ->\n                val mnemonicSingle: Single<String> = authenticationHelper.unlock(appLockType)\n                    .map { authenticationResult ->\n                        if (authenticationResult !is AuthenticationResult.RecoveryPhrase) {\n                            throw AppLockException.UserCancelledException\n                        }\n\n                        authenticationResult.recoveryPhrase\n                    }\n\n                Singles.zip(swapSingle, mnemonicSingle)\n            }\n            .flatMap { (approveTx, mnemonic) ->\n                // Approve being null means that we can skip approval and forward the gas estimate from the swap tx\n                val unsignedApproveTx = approveTx?.value\n                    ?: return@flatMap getMinerFeeAndSignedTxs(mnemonic = mnemonic)\n\n                // Approve needs to execute so ask simulator service to get the gas estimate\n                return@flatMap getSimulatorServiceMinerFeeAndSignedTxs(\n                    mnemonic = mnemonic,\n                    unsignedApproveTx = unsignedApproveTx\n                )\n            }");
        return flatMap;
    }

    /* renamed from: getMinerFeeAndTxs$lambda-6 */
    public static final h.c.h0 m1490getMinerFeeAndTxs$lambda6(SwapConfirmationViewModel this$0, h.c.b0 swapSingle, AppLockType.Transactions appLockType) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(swapSingle, "$swapSingle");
        kotlin.jvm.internal.m.g(appLockType, "appLockType");
        h.c.h0 map = this$0.authenticationHelper.unlock(appLockType).map(new h.c.m0.n() { // from class: com.coinbase.wallet.features.swap.viewmodels.a0
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return SwapConfirmationViewModel.h((AuthenticationResult) obj);
            }
        });
        kotlin.jvm.internal.m.f(map, "authenticationHelper.unlock(appLockType)\n                    .map { authenticationResult ->\n                        if (authenticationResult !is AuthenticationResult.RecoveryPhrase) {\n                            throw AppLockException.UserCancelledException\n                        }\n\n                        authenticationResult.recoveryPhrase\n                    }");
        return h.c.t0.e.a.a(swapSingle, map);
    }

    /* renamed from: getMinerFeeAndTxs$lambda-6$lambda-5 */
    public static final String m1491getMinerFeeAndTxs$lambda6$lambda5(AuthenticationResult authenticationResult) {
        kotlin.jvm.internal.m.g(authenticationResult, "authenticationResult");
        if (authenticationResult instanceof AuthenticationResult.RecoveryPhrase) {
            return ((AuthenticationResult.RecoveryPhrase) authenticationResult).getRecoveryPhrase();
        }
        throw AppLockException.UserCancelledException.INSTANCE;
    }

    /* renamed from: getMinerFeeAndTxs$lambda-7 */
    public static final h.c.h0 m1492getMinerFeeAndTxs$lambda7(SwapConfirmationViewModel this$0, kotlin.o dstr$approveTx$mnemonic) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(dstr$approveTx$mnemonic, "$dstr$approveTx$mnemonic");
        Optional optional = (Optional) dstr$approveTx$mnemonic.a();
        String mnemonic = (String) dstr$approveTx$mnemonic.b();
        EthereumUnsignedTx ethereumUnsignedTx = optional == null ? null : (EthereumUnsignedTx) optional.getValue();
        if (ethereumUnsignedTx == null) {
            kotlin.jvm.internal.m.f(mnemonic, "mnemonic");
            return this$0.getMinerFeeAndSignedTxs(mnemonic);
        }
        kotlin.jvm.internal.m.f(mnemonic, "mnemonic");
        return this$0.getSimulatorServiceMinerFeeAndSignedTxs(mnemonic, ethereumUnsignedTx);
    }

    private final h.c.b0<kotlin.t<BigInteger, BigInteger, List<SwapTxPair>>> getSimulatorServiceMinerFeeAndSignedTxs(final String str, final EthereumUnsignedTx ethereumUnsignedTx) {
        if (ethereumUnsignedTx instanceof EthereumUnsigned1559Tx) {
            h.c.b0<kotlin.t<BigInteger, BigInteger, List<SwapTxPair>>> map = IETHTxRepository.DefaultImpls.sign1559Tx$default(this.ethTxRepository, (EthereumUnsigned1559Tx) ethereumUnsignedTx, str, false, 4, null).flatMap(new h.c.m0.n() { // from class: com.coinbase.wallet.features.swap.viewmodels.x
                @Override // h.c.m0.n
                public final Object apply(Object obj) {
                    return SwapConfirmationViewModel.e(SwapConfirmationViewModel.this, (EthereumSignedTx) obj);
                }
            }).flatMap(new h.c.m0.n() { // from class: com.coinbase.wallet.features.swap.viewmodels.v
                @Override // h.c.m0.n
                public final Object apply(Object obj) {
                    return SwapConfirmationViewModel.c(SwapConfirmationViewModel.this, str, ethereumUnsignedTx, (kotlin.o) obj);
                }
            }).flatMap(new h.c.m0.n() { // from class: com.coinbase.wallet.features.swap.viewmodels.w
                @Override // h.c.m0.n
                public final Object apply(Object obj) {
                    return SwapConfirmationViewModel.d(SwapConfirmationViewModel.this, (List) obj);
                }
            }).map(new h.c.m0.n() { // from class: com.coinbase.wallet.features.swap.viewmodels.h0
                @Override // h.c.m0.n
                public final Object apply(Object obj) {
                    return SwapConfirmationViewModel.o(EthereumUnsignedTx.this, (kotlin.o) obj);
                }
            });
            kotlin.jvm.internal.m.f(map, "ethTxRepository.sign1559Tx(tx = unsignedApproveTx, mnemonic = mnemonic)\n                    .flatMap { signedApproveTx ->\n                        val unsignedSwapTxSingle = swapRepository.generateUnsigned1559SwapTx(\n                            trade = swapTrade,\n                            nonce = signedApproveTx.nonce + 1\n                        )\n\n                        Singles.zip(Single.just(signedApproveTx), unsignedSwapTxSingle)\n                    }\n                    .flatMap { (signedApproveTx, swapTx) ->\n                        val unsignedSwapTx = swapTx.value ?: throw Exception(\"Unable to get swap tx\")\n                        ethTxRepository.sign1559Tx(tx = unsignedSwapTx, mnemonic = mnemonic, skipNonceCheck = true)\n                            .map {\n                                listOf(\n                                    SwapTxPair(unsignedTx = unsignedApproveTx, signedTx = signedApproveTx),\n                                    SwapTxPair(unsignedTx = unsignedSwapTx, signedTx = it)\n                                )\n                            }\n                    }\n                    .flatMap { swapTxs ->\n                        Singles.zip(\n                            swapRepository.getEstimatedGasLimit(\n                                signedTxHashes = swapTxs.map { it.signedTx.signedTxData.toHexEncodedString(true) },\n                                chainId = swapTrade.chainId\n                            ),\n                            Single.just(swapTxs)\n                        )\n                    }.map { (gasLimit, swapTxs) ->\n                        val lowerBoundFee = unsignedApproveTx\n                            .baseFeePerGas\n                            .plus(unsignedApproveTx.maxPriorityFeePerGas)\n                            .times(gasLimit)\n                        val upperBoundFee = unsignedApproveTx\n                            .maxFeePerGas\n                            .times(gasLimit)\n                        Triple(\n                            lowerBoundFee,\n                            upperBoundFee,\n                            swapTxs\n                        )\n                    }");
            return map;
        } else if (ethereumUnsignedTx instanceof EthereumUnsignedLegacyTx) {
            h.c.b0<kotlin.t<BigInteger, BigInteger, List<SwapTxPair>>> map2 = IETHTxRepository.DefaultImpls.signTx$default(this.ethTxRepository, (EthereumUnsignedLegacyTx) ethereumUnsignedTx, str, false, 4, null).flatMap(new h.c.m0.n() { // from class: com.coinbase.wallet.features.swap.viewmodels.i0
                @Override // h.c.m0.n
                public final Object apply(Object obj) {
                    return SwapConfirmationViewModel.p(SwapConfirmationViewModel.this, (EthereumSignedTx) obj);
                }
            }).flatMap(new h.c.m0.n() { // from class: com.coinbase.wallet.features.swap.viewmodels.t
                @Override // h.c.m0.n
                public final Object apply(Object obj) {
                    return SwapConfirmationViewModel.a(SwapConfirmationViewModel.this, str, ethereumUnsignedTx, (kotlin.o) obj);
                }
            }).flatMap(new h.c.m0.n() { // from class: com.coinbase.wallet.features.swap.viewmodels.n0
                @Override // h.c.m0.n
                public final Object apply(Object obj) {
                    return SwapConfirmationViewModel.u(SwapConfirmationViewModel.this, (List) obj);
                }
            }).map(new h.c.m0.n() { // from class: com.coinbase.wallet.features.swap.viewmodels.e0
                @Override // h.c.m0.n
                public final Object apply(Object obj) {
                    return SwapConfirmationViewModel.l((kotlin.o) obj);
                }
            });
            kotlin.jvm.internal.m.f(map2, "ethTxRepository.signTx(tx = unsignedApproveTx, mnemonic = mnemonic)\n                    .flatMap { signedApproveTx ->\n                        val unsignedSwapTxSingle = swapRepository.generateUnsignedSwapTx(\n                            trade = swapTrade,\n                            nonce = signedApproveTx.nonce + 1\n                        )\n\n                        Singles.zip(Single.just(signedApproveTx), unsignedSwapTxSingle)\n                    }\n                    .flatMap { (signedApproveTx, swapTx) ->\n                        val unsignedSwapTx = swapTx.value ?: throw Exception(\"Unable to get swap tx\")\n                        ethTxRepository.signTx(tx = unsignedSwapTx, mnemonic = mnemonic, skipNonceCheck = true)\n                            .map {\n                                listOf(\n                                    SwapTxPair(unsignedTx = unsignedApproveTx, signedTx = signedApproveTx),\n                                    SwapTxPair(unsignedTx = unsignedSwapTx, signedTx = it)\n                                )\n                            }\n                    }\n                    .flatMap { swapTxs ->\n                        Singles.zip(\n                            swapRepository.getEstimatedMinerFee(\n                                signedTxHashes = swapTxs.map { it.signedTx.signedTxData.toHexEncodedString(true) },\n                                chainId = swapTrade.chainId\n                            ),\n                            Single.just(swapTxs)\n                        )\n                    }.map { (estimatedMinerFee, swapTxs) ->\n                        Triple(null, estimatedMinerFee, swapTxs)\n                    }");
            return map2;
        } else {
            throw new NoWhenBranchMatchedException();
        }
    }

    /* renamed from: getSimulatorServiceMinerFeeAndSignedTxs$lambda-13 */
    public static final h.c.h0 m1493getSimulatorServiceMinerFeeAndSignedTxs$lambda13(SwapConfirmationViewModel this$0, EthereumSignedTx signedApproveTx) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(signedApproveTx, "signedApproveTx");
        h.c.b0<Optional<EthereumUnsigned1559Tx>> generateUnsigned1559SwapTx = this$0.swapRepository.generateUnsigned1559SwapTx(this$0.swapTrade, Integer.valueOf(signedApproveTx.getNonce() + 1));
        h.c.t0.e eVar = h.c.t0.e.a;
        h.c.b0 just = h.c.b0.just(signedApproveTx);
        kotlin.jvm.internal.m.f(just, "just(signedApproveTx)");
        return eVar.a(just, generateUnsigned1559SwapTx);
    }

    /* renamed from: getSimulatorServiceMinerFeeAndSignedTxs$lambda-15 */
    public static final h.c.h0 m1494getSimulatorServiceMinerFeeAndSignedTxs$lambda15(SwapConfirmationViewModel this$0, String mnemonic, final EthereumUnsignedTx unsignedApproveTx, kotlin.o dstr$signedApproveTx$swapTx) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(mnemonic, "$mnemonic");
        kotlin.jvm.internal.m.g(unsignedApproveTx, "$unsignedApproveTx");
        kotlin.jvm.internal.m.g(dstr$signedApproveTx$swapTx, "$dstr$signedApproveTx$swapTx");
        final EthereumSignedTx ethereumSignedTx = (EthereumSignedTx) dstr$signedApproveTx$swapTx.a();
        final EthereumUnsigned1559Tx ethereumUnsigned1559Tx = (EthereumUnsigned1559Tx) ((Optional) dstr$signedApproveTx$swapTx.b()).getValue();
        if (ethereumUnsigned1559Tx != null) {
            return this$0.ethTxRepository.sign1559Tx(ethereumUnsigned1559Tx, mnemonic, true).map(new h.c.m0.n() { // from class: com.coinbase.wallet.features.swap.viewmodels.k0
                @Override // h.c.m0.n
                public final Object apply(Object obj) {
                    return SwapConfirmationViewModel.r(EthereumUnsignedTx.this, ethereumSignedTx, ethereumUnsigned1559Tx, (EthereumSignedTx) obj);
                }
            });
        }
        throw new Exception("Unable to get swap tx");
    }

    /* renamed from: getSimulatorServiceMinerFeeAndSignedTxs$lambda-15$lambda-14 */
    public static final List m1495getSimulatorServiceMinerFeeAndSignedTxs$lambda15$lambda14(EthereumUnsignedTx unsignedApproveTx, EthereumSignedTx signedApproveTx, EthereumUnsigned1559Tx unsignedSwapTx, EthereumSignedTx it) {
        List j2;
        kotlin.jvm.internal.m.g(unsignedApproveTx, "$unsignedApproveTx");
        kotlin.jvm.internal.m.g(unsignedSwapTx, "$unsignedSwapTx");
        kotlin.jvm.internal.m.g(it, "it");
        kotlin.jvm.internal.m.f(signedApproveTx, "signedApproveTx");
        j2 = kotlin.a0.r.j(new SwapTxPair(unsignedApproveTx, signedApproveTx), new SwapTxPair(unsignedSwapTx, it));
        return j2;
    }

    /* renamed from: getSimulatorServiceMinerFeeAndSignedTxs$lambda-17 */
    public static final h.c.h0 m1496getSimulatorServiceMinerFeeAndSignedTxs$lambda17(SwapConfirmationViewModel this$0, List swapTxs) {
        int r;
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(swapTxs, "swapTxs");
        h.c.t0.e eVar = h.c.t0.e.a;
        ISwapRepository iSwapRepository = this$0.swapRepository;
        r = kotlin.a0.s.r(swapTxs, 10);
        ArrayList arrayList = new ArrayList(r);
        Iterator it = swapTxs.iterator();
        while (it.hasNext()) {
            arrayList.add(ByteArray_CipherCoreKt.toHexEncodedString(((SwapTxPair) it.next()).getSignedTx().getSignedTxData(), true));
        }
        h.c.b0<BigInteger> estimatedGasLimit = iSwapRepository.getEstimatedGasLimit(arrayList, this$0.swapTrade.getChainId());
        h.c.b0 just = h.c.b0.just(swapTxs);
        kotlin.jvm.internal.m.f(just, "just(swapTxs)");
        return eVar.a(estimatedGasLimit, just);
    }

    /* renamed from: getSimulatorServiceMinerFeeAndSignedTxs$lambda-18 */
    public static final kotlin.t m1497getSimulatorServiceMinerFeeAndSignedTxs$lambda18(EthereumUnsignedTx unsignedApproveTx, kotlin.o dstr$gasLimit$swapTxs) {
        kotlin.jvm.internal.m.g(unsignedApproveTx, "$unsignedApproveTx");
        kotlin.jvm.internal.m.g(dstr$gasLimit$swapTxs, "$dstr$gasLimit$swapTxs");
        BigInteger gasLimit = (BigInteger) dstr$gasLimit$swapTxs.a();
        EthereumUnsigned1559Tx ethereumUnsigned1559Tx = (EthereumUnsigned1559Tx) unsignedApproveTx;
        BigInteger add = ethereumUnsigned1559Tx.getBaseFeePerGas().add(ethereumUnsigned1559Tx.getMaxPriorityFeePerGas());
        kotlin.jvm.internal.m.f(add, "this.add(other)");
        kotlin.jvm.internal.m.f(gasLimit, "gasLimit");
        BigInteger multiply = add.multiply(gasLimit);
        kotlin.jvm.internal.m.f(multiply, "this.multiply(other)");
        BigInteger multiply2 = ethereumUnsigned1559Tx.getMaxFeePerGas().multiply(gasLimit);
        kotlin.jvm.internal.m.f(multiply2, "this.multiply(other)");
        return new kotlin.t(multiply, multiply2, (List) dstr$gasLimit$swapTxs.b());
    }

    /* renamed from: getSimulatorServiceMinerFeeAndSignedTxs$lambda-19 */
    public static final h.c.h0 m1498getSimulatorServiceMinerFeeAndSignedTxs$lambda19(SwapConfirmationViewModel this$0, EthereumSignedTx signedApproveTx) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(signedApproveTx, "signedApproveTx");
        h.c.b0<Optional<EthereumUnsignedLegacyTx>> generateUnsignedSwapTx = this$0.swapRepository.generateUnsignedSwapTx(this$0.swapTrade, Integer.valueOf(signedApproveTx.getNonce() + 1));
        h.c.t0.e eVar = h.c.t0.e.a;
        h.c.b0 just = h.c.b0.just(signedApproveTx);
        kotlin.jvm.internal.m.f(just, "just(signedApproveTx)");
        return eVar.a(just, generateUnsignedSwapTx);
    }

    /* renamed from: getSimulatorServiceMinerFeeAndSignedTxs$lambda-21 */
    public static final h.c.h0 m1499getSimulatorServiceMinerFeeAndSignedTxs$lambda21(SwapConfirmationViewModel this$0, String mnemonic, final EthereumUnsignedTx unsignedApproveTx, kotlin.o dstr$signedApproveTx$swapTx) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(mnemonic, "$mnemonic");
        kotlin.jvm.internal.m.g(unsignedApproveTx, "$unsignedApproveTx");
        kotlin.jvm.internal.m.g(dstr$signedApproveTx$swapTx, "$dstr$signedApproveTx$swapTx");
        final EthereumSignedTx ethereumSignedTx = (EthereumSignedTx) dstr$signedApproveTx$swapTx.a();
        final EthereumUnsignedLegacyTx ethereumUnsignedLegacyTx = (EthereumUnsignedLegacyTx) ((Optional) dstr$signedApproveTx$swapTx.b()).getValue();
        if (ethereumUnsignedLegacyTx != null) {
            return this$0.ethTxRepository.signTx(ethereumUnsignedLegacyTx, mnemonic, true).map(new h.c.m0.n() { // from class: com.coinbase.wallet.features.swap.viewmodels.l0
                @Override // h.c.m0.n
                public final Object apply(Object obj) {
                    return SwapConfirmationViewModel.s(EthereumUnsignedTx.this, ethereumSignedTx, ethereumUnsignedLegacyTx, (EthereumSignedTx) obj);
                }
            });
        }
        throw new Exception("Unable to get swap tx");
    }

    /* renamed from: getSimulatorServiceMinerFeeAndSignedTxs$lambda-21$lambda-20 */
    public static final List m1500getSimulatorServiceMinerFeeAndSignedTxs$lambda21$lambda20(EthereumUnsignedTx unsignedApproveTx, EthereumSignedTx signedApproveTx, EthereumUnsignedLegacyTx unsignedSwapTx, EthereumSignedTx it) {
        List j2;
        kotlin.jvm.internal.m.g(unsignedApproveTx, "$unsignedApproveTx");
        kotlin.jvm.internal.m.g(unsignedSwapTx, "$unsignedSwapTx");
        kotlin.jvm.internal.m.g(it, "it");
        kotlin.jvm.internal.m.f(signedApproveTx, "signedApproveTx");
        j2 = kotlin.a0.r.j(new SwapTxPair(unsignedApproveTx, signedApproveTx), new SwapTxPair(unsignedSwapTx, it));
        return j2;
    }

    /* renamed from: getSimulatorServiceMinerFeeAndSignedTxs$lambda-23 */
    public static final h.c.h0 m1501getSimulatorServiceMinerFeeAndSignedTxs$lambda23(SwapConfirmationViewModel this$0, List swapTxs) {
        int r;
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(swapTxs, "swapTxs");
        h.c.t0.e eVar = h.c.t0.e.a;
        ISwapRepository iSwapRepository = this$0.swapRepository;
        r = kotlin.a0.s.r(swapTxs, 10);
        ArrayList arrayList = new ArrayList(r);
        Iterator it = swapTxs.iterator();
        while (it.hasNext()) {
            arrayList.add(ByteArray_CipherCoreKt.toHexEncodedString(((SwapTxPair) it.next()).getSignedTx().getSignedTxData(), true));
        }
        h.c.b0<BigInteger> estimatedMinerFee = iSwapRepository.getEstimatedMinerFee(arrayList, this$0.swapTrade.getChainId());
        h.c.b0 just = h.c.b0.just(swapTxs);
        kotlin.jvm.internal.m.f(just, "just(swapTxs)");
        return eVar.a(estimatedMinerFee, just);
    }

    /* renamed from: getSimulatorServiceMinerFeeAndSignedTxs$lambda-24 */
    public static final kotlin.t m1502getSimulatorServiceMinerFeeAndSignedTxs$lambda24(kotlin.o dstr$estimatedMinerFee$swapTxs) {
        kotlin.jvm.internal.m.g(dstr$estimatedMinerFee$swapTxs, "$dstr$estimatedMinerFee$swapTxs");
        return new kotlin.t(null, (BigInteger) dstr$estimatedMinerFee$swapTxs.a(), (List) dstr$estimatedMinerFee$swapTxs.b());
    }

    public static /* synthetic */ String h(AuthenticationResult authenticationResult) {
        return m1491getMinerFeeAndTxs$lambda6$lambda5(authenticationResult);
    }

    private final void handleFees(boolean z, BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, Wallet wallet, Wallet wallet2, boolean z2) {
        h.c.b0 a;
        List<Integer> b2;
        List<Integer> b3;
        List<Integer> b4;
        SwapConfirmationViewState copy;
        if (z2) {
            copy = r8.copy((r34 & 1) != 0 ? r8.amountBase : null, (r34 & 2) != 0 ? r8.currencyType : null, (r34 & 4) != 0 ? r8.cardTitle : null, (r34 & 8) != 0 ? r8.isLoading : false, (r34 & 16) != 0 ? r8.isConverting : false, (r34 & 32) != 0 ? r8.isConvertButtonVisible : false, (r34 & 64) != 0 ? r8.targetCurrencyCode : null, (r34 & 128) != 0 ? r8.targetImageURL : null, (r34 & 256) != 0 ? r8.sourceCryptoAmount : null, (r34 & 512) != 0 ? r8.sourceFiatAmount : null, (r34 & 1024) != 0 ? r8.targetCryptoAmount : null, (r34 & PKIFailureInfo.wrongIntegrity) != 0 ? r8.minerFeeFiatAmount : null, (r34 & 4096) != 0 ? r8.minerFeeCryptoAmount : null, (r34 & PKIFailureInfo.certRevoked) != 0 ? r8.coinbaseFeeFiatAmount : null, (r34 & 16384) != 0 ? r8.coinbaseFeeCryptoAmount : null, (r34 & 32768) != 0 ? this.state.error : new SwapConfirmationError.HighPriceImpactWarning(LocalizedStrings.INSTANCE.get(R.string.swap_confirmation_high_price_impact)));
            setState(copy);
            this.eventSubject.onNext(SwapConfirmationEvent.ExpandDetails.INSTANCE);
            Analytics analytics = Analytics.INSTANCE;
            AnalyticsEvent.Companion companion = AnalyticsEvent.Companion;
            String code = this.sourceAsset.getCurrencyCode().getCode();
            ContractAddress contractAddress = this.sourceAsset.getContractAddress();
            String rawValue = contractAddress == null ? null : contractAddress.getRawValue();
            String code2 = this.targetAsset.getCurrencyCode().getCode();
            ContractAddress contractAddress2 = this.targetAsset.getContractAddress();
            analytics.log(AnalyticsEvent_ApplicationKt.swapPriceImpact(companion, code, rawValue, code2, contractAddress2 == null ? null : contractAddress2.getRawValue(), this.swapTrade.getChainId()));
        }
        if (z) {
            if (this.swapTrade.getChainId() != EthereumChain.ETHEREUM_MAINNET.getChainId()) {
                IExchangeRateRepository iExchangeRateRepository = this.exchangeRateRepository;
                CurrencyCode currencyCode = wallet.getCurrencyCode();
                String contractAddress3 = wallet.getContractAddress();
                b4 = kotlin.a0.q.b(Integer.valueOf(this.swapTrade.getChainId()));
                a = iExchangeRateRepository.getL2CryptoExchangeRate(currencyCode, contractAddress3, b4).map(new h.c.m0.n() { // from class: com.coinbase.wallet.features.swap.viewmodels.b0
                    @Override // h.c.m0.n
                    public final Object apply(Object obj) {
                        return SwapConfirmationViewModel.i((BigDecimal) obj);
                    }
                });
            } else {
                a = this.exchangeRateRepository.getCryptoExchangeRate(wallet.getCurrencyCode(), wallet.getContractAddress(), this.swapTrade.getChainId()).map(new h.c.m0.n() { // from class: com.coinbase.wallet.features.swap.viewmodels.y
                    @Override // h.c.m0.n
                    public final Object apply(Object obj) {
                        return SwapConfirmationViewModel.f((BigDecimal) obj);
                    }
                });
            }
            kotlin.jvm.internal.m.f(a, "{\n            if (swapTrade.chainId != EthereumChain.ETHEREUM_MAINNET.chainId) {\n                exchangeRateRepository\n                    .getL2CryptoExchangeRate(\n                        cryptoCurrencyCode = minerFeeWallet.currencyCode,\n                        contractAddress = minerFeeWallet.contractAddress,\n                        chainIds = listOf(swapTrade.chainId)\n                    )\n                    .map { Pair(it, it) }\n            } else {\n                exchangeRateRepository\n                    .getCryptoExchangeRate(\n                        cryptoCurrencyCode = minerFeeWallet.currencyCode,\n                        contractAddress = minerFeeWallet.contractAddress,\n                        chainId = swapTrade.chainId\n                    )\n                    .map { Pair(it, it) }\n            }\n        }");
        } else if (this.swapTrade.getChainId() != EthereumChain.ETHEREUM_MAINNET.getChainId()) {
            h.c.t0.e eVar = h.c.t0.e.a;
            IExchangeRateRepository iExchangeRateRepository2 = this.exchangeRateRepository;
            CurrencyCode currencyCode2 = wallet.getCurrencyCode();
            String contractAddress4 = wallet.getContractAddress();
            b2 = kotlin.a0.q.b(Integer.valueOf(this.swapTrade.getChainId()));
            h.c.b0<BigDecimal> l2CryptoExchangeRate = iExchangeRateRepository2.getL2CryptoExchangeRate(currencyCode2, contractAddress4, b2);
            IExchangeRateRepository iExchangeRateRepository3 = this.exchangeRateRepository;
            CurrencyCode currencyCode3 = wallet2.getCurrencyCode();
            String contractAddress5 = wallet2.getContractAddress();
            b3 = kotlin.a0.q.b(Integer.valueOf(this.swapTrade.getChainId()));
            a = eVar.a(l2CryptoExchangeRate, iExchangeRateRepository3.getL2CryptoExchangeRate(currencyCode3, contractAddress5, b3));
        } else {
            a = h.c.t0.e.a.a(this.exchangeRateRepository.getCryptoExchangeRate(wallet.getCurrencyCode(), wallet.getContractAddress(), this.swapTrade.getChainId()), this.exchangeRateRepository.getCryptoExchangeRate(wallet2.getCurrencyCode(), wallet2.getContractAddress(), this.swapTrade.getChainId()));
        }
        h.c.b0 observeOn = a.observeOn(h.c.j0.c.a.b());
        kotlin.jvm.internal.m.f(observeOn, "feeExchangeRateSingle\n            .observeOn(AndroidSchedulers.mainThread())");
        h.c.t0.a.a(h.c.t0.g.f(Single_AnalyticsKt.logError$default(observeOn, null, null, 3, null), new SwapConfirmationViewModel$handleFees$1(this), new SwapConfirmationViewModel$handleFees$2(bigInteger2, wallet, bigInteger, wallet2, this, bigInteger3)), this.disposeBag);
    }

    /* renamed from: handleFees$lambda-25 */
    public static final kotlin.o m1503handleFees$lambda25(BigDecimal it) {
        kotlin.jvm.internal.m.g(it, "it");
        return new kotlin.o(it, it);
    }

    /* renamed from: handleFees$lambda-26 */
    public static final kotlin.o m1504handleFees$lambda26(BigDecimal it) {
        kotlin.jvm.internal.m.g(it, "it");
        return new kotlin.o(it, it);
    }

    /* JADX WARN: Type inference failed for: r0v7, types: [T, java.math.BigInteger, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r0v8, types: [T, java.math.BigInteger, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v0, types: [T, java.math.BigInteger, java.lang.Object] */
    public final void handleNotEnoughFundsError() {
        BigInteger estimatedSwapTxMinerFee = this.swapTrade.getEstimatedSwapTxMinerFee();
        BigInteger estimatedApproveTxMinerFee = this.swapTrade.getEstimatedApproveTxMinerFee();
        kotlin.jvm.internal.d0 d0Var = new kotlin.jvm.internal.d0();
        ?? ZERO = BigInteger.ZERO;
        kotlin.jvm.internal.m.f(ZERO, "ZERO");
        d0Var.a = ZERO;
        if (estimatedSwapTxMinerFee != null) {
            ?? add = ((BigInteger) ZERO).add(estimatedSwapTxMinerFee);
            kotlin.jvm.internal.m.f(add, "this.add(other)");
            d0Var.a = add;
        }
        if (estimatedApproveTxMinerFee != null) {
            ?? add2 = ((BigInteger) d0Var.a).add(estimatedApproveTxMinerFee);
            kotlin.jvm.internal.m.f(add2, "this.add(other)");
            d0Var.a = add2;
        }
        h.c.b0<Wallet> observeOn = this.ethereumWalletSingle.observeOn(h.c.j0.c.a.b());
        kotlin.jvm.internal.m.f(observeOn, "ethereumWalletSingle\n            .observeOn(AndroidSchedulers.mainThread())");
        h.c.t0.a.a(h.c.t0.g.f(observeOn, new SwapConfirmationViewModel$handleNotEnoughFundsError$1(this), new SwapConfirmationViewModel$handleNotEnoughFundsError$2(d0Var, this)), this.disposeBag);
    }

    public final void handleUnsignedSwapTxs(ConfirmationResult confirmationResult) {
        BigInteger fromAmount;
        SwapConfirmationError.InsufficientBalance insufficientBalance;
        SwapTrade trade = confirmationResult.getTrade();
        Wallet minerFeeWallet = confirmationResult.getMinerFeeWallet();
        Wallet sourceWallet = confirmationResult.getSourceWallet();
        BigInteger coinbaseFee = trade.getFee().getAmount().toBigInteger();
        BigInteger lowerBoundFee = confirmationResult.getLowerBoundFee();
        BigInteger estimatedMinerFee = confirmationResult.getEstimatedMinerFee();
        BigInteger maximumAvailableBalance = Wallet_ApplicationKt.maximumAvailableBalance(minerFeeWallet);
        ContractAddress contractAddress = this.sourceAsset.getContractAddress();
        boolean z = kotlin.jvm.internal.m.c(contractAddress == null ? null : contractAddress.getRawValue(), minerFeeWallet.getContractAddress()) && kotlin.jvm.internal.m.c(this.sourceAsset.getCurrencyCode(), minerFeeWallet.getCurrencyCode());
        TransferValue transferValue = this.transferAmount;
        if (kotlin.jvm.internal.m.c(transferValue, TransferValue.EntireBalance.INSTANCE)) {
            fromAmount = Wallet_ApplicationKt.maximumAvailableBalance(sourceWallet);
        } else if (!(transferValue instanceof TransferValue.Amount)) {
            throw new NoWhenBranchMatchedException();
        } else {
            if (z) {
                fromAmount = trade.getQuote().getFromAmount().add(estimatedMinerFee);
                kotlin.jvm.internal.m.f(fromAmount, "this.add(other)");
            } else {
                fromAmount = trade.getQuote().getFromAmount();
            }
        }
        if (z && fromAmount.compareTo(maximumAvailableBalance) > 0) {
            CurrencyFormatter currencyFormatter = this.currencyFormatter;
            CurrencyCode currencyCode = minerFeeWallet.getCurrencyCode();
            int decimals = minerFeeWallet.getDecimals();
            BigInteger subtract = fromAmount.subtract(maximumAvailableBalance);
            kotlin.jvm.internal.m.f(subtract, "this.subtract(other)");
            insufficientBalance = new SwapConfirmationError.InsufficientBalance(LocalizedStrings.INSTANCE.get(R.string.insufficient_balance_error, minerFeeWallet.getCurrencyCode(), CurrencyFormatter.formatToCrypto$default(currencyFormatter, currencyCode, decimals, subtract, false, 0, 0, 56, (Object) null)));
        } else if (estimatedMinerFee.compareTo(maximumAvailableBalance) > 0) {
            CurrencyFormatter currencyFormatter2 = this.currencyFormatter;
            CurrencyCode currencyCode2 = minerFeeWallet.getCurrencyCode();
            int decimals2 = minerFeeWallet.getDecimals();
            BigInteger subtract2 = estimatedMinerFee.subtract(maximumAvailableBalance);
            kotlin.jvm.internal.m.f(subtract2, "this.subtract(other)");
            insufficientBalance = new SwapConfirmationError.InsufficientBalance(LocalizedStrings.INSTANCE.get(R.string.insufficient_balance_error, minerFeeWallet.getCurrencyCode(), CurrencyFormatter.formatToCrypto$default(currencyFormatter2, currencyCode2, decimals2, subtract2, false, 0, 0, 56, (Object) null)));
        } else {
            insufficientBalance = null;
        }
        setState(SwapConfirmationViewStateKt.newState(this.state, this.currencyFormatter, minerFeeWallet, lowerBoundFee, estimatedMinerFee, trade.getFee(), trade.getQuote(), insufficientBalance));
        Analytics analytics = Analytics.INSTANCE;
        String code = this.sourceAsset.getCurrencyCode().getCode();
        ContractAddress contractAddress2 = this.sourceAsset.getContractAddress();
        String rawValue = contractAddress2 == null ? null : contractAddress2.getRawValue();
        String sourceCryptoAmount = this.state.getSourceCryptoAmount();
        String sourceFiatAmount = this.state.getSourceFiatAmount();
        String code2 = this.targetAsset.getCurrencyCode().getCode();
        ContractAddress contractAddress3 = this.targetAsset.getContractAddress();
        String rawValue2 = contractAddress3 == null ? null : contractAddress3.getRawValue();
        String targetCryptoAmount = this.state.getTargetCryptoAmount();
        String minerFeeFiatAmount = this.state.getMinerFeeFiatAmount();
        int chainId = trade.getChainId();
        AnalyticsEvent.Companion companion = AnalyticsEvent.Companion;
        analytics.log(AnalyticsEvent_ApplicationKt.swapConfirmMinerFee(companion, code, rawValue, code2, rawValue2, minerFeeFiatAmount, sourceCryptoAmount, sourceFiatAmount, targetCryptoAmount, chainId));
        if (insufficientBalance != null) {
            this.eventSubject.onNext(SwapConfirmationEvent.ExpandDetails.INSTANCE);
            analytics.log(AnalyticsEvent_ApplicationKt.swapConfirmErrorReceived(companion, insufficientBalance.getDescription(), this.sourceAsset.getCurrencyCode().getCode(), this.targetAsset.getCurrencyCode().getCode()));
        }
        BigInteger gasPrice = trade.getGasPrice();
        boolean highPriceImpact = trade.getHighPriceImpact();
        kotlin.jvm.internal.m.f(coinbaseFee, "coinbaseFee");
        handleFees(z, coinbaseFee, estimatedMinerFee, gasPrice, minerFeeWallet, sourceWallet, highPriceImpact);
    }

    public static /* synthetic */ kotlin.o i(BigDecimal bigDecimal) {
        return m1503handleFees$lambda25(bigDecimal);
    }

    public static /* synthetic */ h.c.h0 j(SwapConfirmationViewModel swapConfirmationViewModel, kotlin.o oVar) {
        return m1492getMinerFeeAndTxs$lambda7(swapConfirmationViewModel, oVar);
    }

    public static /* synthetic */ SwapTxPair k(EthereumUnsignedLegacyTx ethereumUnsignedLegacyTx, EthereumSignedTx ethereumSignedTx) {
        return m1486getMinerFeeAndSignedTxs$lambda11$lambda10(ethereumUnsignedLegacyTx, ethereumSignedTx);
    }

    public static /* synthetic */ kotlin.t l(kotlin.o oVar) {
        return m1502getSimulatorServiceMinerFeeAndSignedTxs$lambda24(oVar);
    }

    public static /* synthetic */ void m(SwapConfirmationViewModel swapConfirmationViewModel, List list) {
        m1483confirmTx$lambda3(swapConfirmationViewModel, list);
    }

    public static /* synthetic */ kotlin.x n(SwapConfirmationViewModel swapConfirmationViewModel, kotlin.o oVar) {
        return m1506setup$lambda1(swapConfirmationViewModel, oVar);
    }

    public static /* synthetic */ kotlin.t o(EthereumUnsignedTx ethereumUnsignedTx, kotlin.o oVar) {
        return m1497getSimulatorServiceMinerFeeAndSignedTxs$lambda18(ethereumUnsignedTx, oVar);
    }

    public static /* synthetic */ h.c.h0 p(SwapConfirmationViewModel swapConfirmationViewModel, EthereumSignedTx ethereumSignedTx) {
        return m1498getSimulatorServiceMinerFeeAndSignedTxs$lambda19(swapConfirmationViewModel, ethereumSignedTx);
    }

    public static /* synthetic */ void q(SwapConfirmationViewModel swapConfirmationViewModel, Throwable th) {
        m1484confirmTx$lambda4(swapConfirmationViewModel, th);
    }

    public static /* synthetic */ List r(EthereumUnsignedTx ethereumUnsignedTx, EthereumSignedTx ethereumSignedTx, EthereumUnsigned1559Tx ethereumUnsigned1559Tx, EthereumSignedTx ethereumSignedTx2) {
        return m1495getSimulatorServiceMinerFeeAndSignedTxs$lambda15$lambda14(ethereumUnsignedTx, ethereumSignedTx, ethereumUnsigned1559Tx, ethereumSignedTx2);
    }

    public static /* synthetic */ List s(EthereumUnsignedTx ethereumUnsignedTx, EthereumSignedTx ethereumSignedTx, EthereumUnsignedLegacyTx ethereumUnsignedLegacyTx, EthereumSignedTx ethereumSignedTx2) {
        return m1500getSimulatorServiceMinerFeeAndSignedTxs$lambda21$lambda20(ethereumUnsignedTx, ethereumSignedTx, ethereumUnsignedLegacyTx, ethereumSignedTx2);
    }

    public final void setState(SwapConfirmationViewState swapConfirmationViewState) {
        this.state = swapConfirmationViewState;
        this.stateSubject.onNext(swapConfirmationViewState);
    }

    /* renamed from: setup$lambda-0 */
    public static final Aggregator m1505setup$lambda0(List it) {
        kotlin.jvm.internal.m.g(it, "it");
        return (Aggregator) kotlin.a0.p.Y(it);
    }

    /* renamed from: setup$lambda-1 */
    public static final kotlin.x m1506setup$lambda1(SwapConfirmationViewModel this$0, kotlin.o dstr$sourceWallet$aggregator) {
        String empty;
        String empty2;
        String formatToCrypto$default;
        SwapConfirmationViewState copy;
        BigInteger value;
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(dstr$sourceWallet$aggregator, "$dstr$sourceWallet$aggregator");
        Wallet sourceWallet = (Wallet) dstr$sourceWallet$aggregator.a();
        Aggregator aggregator = (Aggregator) dstr$sourceWallet$aggregator.b();
        AmountBase amountBase = this$0.amountBase;
        if (kotlin.jvm.internal.m.c(amountBase, AmountBase.Source.INSTANCE)) {
            Strings strings = Strings.INSTANCE;
            formatToCrypto$default = Strings_CoreKt.getEmpty(strings);
            TransferValue transferValue = this$0.transferAmount;
            if (kotlin.jvm.internal.m.c(transferValue, TransferValue.EntireBalance.INSTANCE)) {
                kotlin.jvm.internal.m.f(sourceWallet, "sourceWallet");
                value = Wallet_ApplicationKt.maximumAvailableBalance(sourceWallet);
            } else if (!(transferValue instanceof TransferValue.Amount)) {
                throw new NoWhenBranchMatchedException();
            } else {
                value = ((TransferValue.Amount) this$0.transferAmount).getValue();
            }
            empty = CurrencyFormatter.formatToCrypto$default(this$0.currencyFormatter, this$0.sourceAsset.getCurrencyCode(), this$0.sourceAsset.getDecimals(), value, true, 0, 0, 48, (Object) null);
            CurrencyFormatter currencyFormatter = this$0.currencyFormatter;
            CurrencyCode currencyCode = this$0.sourceAsset.getCurrencyCode();
            ContractAddress contractAddress = this$0.sourceAsset.getContractAddress();
            String rawValue = contractAddress == null ? null : contractAddress.getRawValue();
            int decimals = this$0.sourceAsset.getDecimals();
            EthereumChain asEthereumChain = Network_EthereumKt.getAsEthereumChain(sourceWallet.getNetwork());
            BigDecimal fiatValue$default = CurrencyFormatter.fiatValue$default(currencyFormatter, currencyCode, rawValue, decimals, value, null, asEthereumChain == null ? null : Integer.valueOf(asEthereumChain.getChainId()), 16, null);
            if (fiatValue$default == null) {
                empty2 = Strings_CoreKt.getEmpty(strings);
            } else {
                empty2 = this$0.currencyFormatter.fiatValueString(fiatValue$default, true);
            }
        } else if (kotlin.jvm.internal.m.c(amountBase, AmountBase.Target.INSTANCE)) {
            Strings strings2 = Strings.INSTANCE;
            empty = Strings_CoreKt.getEmpty(strings2);
            empty2 = Strings_CoreKt.getEmpty(strings2);
            TransferValue transferValue2 = this$0.transferAmount;
            if (!kotlin.jvm.internal.m.c(transferValue2, TransferValue.EntireBalance.INSTANCE)) {
                if (transferValue2 instanceof TransferValue.Amount) {
                    formatToCrypto$default = CurrencyFormatter.formatToCrypto$default(this$0.currencyFormatter, this$0.targetAsset.getCurrencyCode(), this$0.targetAsset.getDecimals(), ((TransferValue.Amount) this$0.transferAmount).getValue(), true, 0, 0, 48, (Object) null);
                } else {
                    throw new NoWhenBranchMatchedException();
                }
            } else {
                throw new IllegalArgumentException("Target amount should never be EntireBalance");
            }
        } else {
            throw new NoWhenBranchMatchedException();
        }
        copy = r1.copy((r34 & 1) != 0 ? r1.amountBase : null, (r34 & 2) != 0 ? r1.currencyType : null, (r34 & 4) != 0 ? r1.cardTitle : LocalizedStrings.INSTANCE.get(R.string.swap_confirmation_title, aggregator.getName()), (r34 & 8) != 0 ? r1.isLoading : false, (r34 & 16) != 0 ? r1.isConverting : false, (r34 & 32) != 0 ? r1.isConvertButtonVisible : false, (r34 & 64) != 0 ? r1.targetCurrencyCode : null, (r34 & 128) != 0 ? r1.targetImageURL : null, (r34 & 256) != 0 ? r1.sourceCryptoAmount : empty, (r34 & 512) != 0 ? r1.sourceFiatAmount : empty2, (r34 & 1024) != 0 ? r1.targetCryptoAmount : formatToCrypto$default, (r34 & PKIFailureInfo.wrongIntegrity) != 0 ? r1.minerFeeFiatAmount : null, (r34 & 4096) != 0 ? r1.minerFeeCryptoAmount : null, (r34 & PKIFailureInfo.certRevoked) != 0 ? r1.coinbaseFeeFiatAmount : null, (r34 & 16384) != 0 ? r1.coinbaseFeeCryptoAmount : null, (r34 & 32768) != 0 ? this$0.state.error : null);
        this$0.setState(copy);
        this$0.fetchReceiptInformation();
        return kotlin.x.a;
    }

    public static /* synthetic */ h.c.h0 t(SwapConfirmationViewModel swapConfirmationViewModel, String str, Optional optional) {
        return m1488getMinerFeeAndSignedTxs$lambda9(swapConfirmationViewModel, str, optional);
    }

    public static /* synthetic */ h.c.h0 u(SwapConfirmationViewModel swapConfirmationViewModel, List list) {
        return m1501getSimulatorServiceMinerFeeAndSignedTxs$lambda23(swapConfirmationViewModel, list);
    }

    public static /* synthetic */ kotlin.t v(EthereumUnsigned1559Tx ethereumUnsigned1559Tx, EthereumSignedTx ethereumSignedTx) {
        return m1489getMinerFeeAndSignedTxs$lambda9$lambda8(ethereumUnsigned1559Tx, ethereumSignedTx);
    }

    public static /* synthetic */ Aggregator x(List list) {
        return m1505setup$lambda0(list);
    }

    @SuppressLint({"CheckResult"})
    public final h.c.b0<kotlin.x> confirmTx() {
        SwapConfirmationViewState copy;
        int r;
        h.c.b0 zip;
        List g2;
        copy = r1.copy((r34 & 1) != 0 ? r1.amountBase : null, (r34 & 2) != 0 ? r1.currencyType : null, (r34 & 4) != 0 ? r1.cardTitle : null, (r34 & 8) != 0 ? r1.isLoading : false, (r34 & 16) != 0 ? r1.isConverting : true, (r34 & 32) != 0 ? r1.isConvertButtonVisible : false, (r34 & 64) != 0 ? r1.targetCurrencyCode : null, (r34 & 128) != 0 ? r1.targetImageURL : null, (r34 & 256) != 0 ? r1.sourceCryptoAmount : null, (r34 & 512) != 0 ? r1.sourceFiatAmount : null, (r34 & 1024) != 0 ? r1.targetCryptoAmount : null, (r34 & PKIFailureInfo.wrongIntegrity) != 0 ? r1.minerFeeFiatAmount : null, (r34 & 4096) != 0 ? r1.minerFeeCryptoAmount : null, (r34 & PKIFailureInfo.certRevoked) != 0 ? r1.coinbaseFeeFiatAmount : null, (r34 & 16384) != 0 ? r1.coinbaseFeeCryptoAmount : null, (r34 & 32768) != 0 ? this.state.error : null);
        setState(copy);
        Analytics analytics = Analytics.INSTANCE;
        AnalyticsEvent.Companion companion = AnalyticsEvent.Companion;
        String code = this.sourceAsset.getCurrencyCode().getCode();
        ContractAddress contractAddress = this.sourceAsset.getContractAddress();
        String rawValue = contractAddress == null ? null : contractAddress.getRawValue();
        String sourceCryptoAmount = this.state.getSourceCryptoAmount();
        String sourceFiatAmount = this.state.getSourceFiatAmount();
        String code2 = this.targetAsset.getCurrencyCode().getCode();
        ContractAddress contractAddress2 = this.targetAsset.getContractAddress();
        analytics.log(AnalyticsEvent_ApplicationKt.swapConfirmConvertSelected(companion, code, rawValue, sourceCryptoAmount, sourceFiatAmount, code2, contractAddress2 == null ? null : contractAddress2.getRawValue(), this.state.getTargetCryptoAmount(), this.swapTrade.getChainId()));
        List<SwapTxPair> list = this.swapTxs;
        r = kotlin.a0.s.r(list, 10);
        ArrayList arrayList = new ArrayList(r);
        for (SwapTxPair swapTxPair : list) {
            arrayList.add(this.ethTxRepository.submitTx(swapTxPair.getSignedTx(), swapTxPair.getUnsignedTx(), true));
        }
        h.c.t0.e eVar = h.c.t0.e.a;
        if (arrayList.isEmpty()) {
            g2 = kotlin.a0.r.g();
            zip = h.c.b0.just(g2);
            kotlin.jvm.internal.m.f(zip, "just(emptyList())");
        } else {
            zip = h.c.b0.zip(arrayList, new h.c.m0.n() { // from class: com.coinbase.wallet.features.swap.viewmodels.SwapConfirmationViewModel$confirmTx$$inlined$zipOrEmpty$1
                @Override // h.c.m0.n
                public final List<T> apply(Object[] it) {
                    List<T> g3;
                    kotlin.jvm.internal.m.g(it, "it");
                    if (it.length == 0) {
                        g3 = kotlin.a0.r.g();
                        return g3;
                    }
                    ArrayList arrayList2 = new ArrayList();
                    for (Object obj : it) {
                        if (obj instanceof EthereumSignedTx) {
                            arrayList2.add(obj);
                        }
                    }
                    return arrayList2;
                }
            });
            kotlin.jvm.internal.m.f(zip, "zip(singles) { if (it.isEmpty()) emptyList() else it.filterIsInstance<T>() }");
        }
        h.c.b0 doOnError = Single_AnalyticsKt.logError$default(zip, null, null, 3, null).observeOn(h.c.j0.c.a.b()).doOnSuccess(new h.c.m0.f() { // from class: com.coinbase.wallet.features.swap.viewmodels.f0
            @Override // h.c.m0.f
            public final void accept(Object obj) {
                SwapConfirmationViewModel.m(SwapConfirmationViewModel.this, (List) obj);
            }
        }).doOnError(new h.c.m0.f() { // from class: com.coinbase.wallet.features.swap.viewmodels.j0
            @Override // h.c.m0.f
            public final void accept(Object obj) {
                SwapConfirmationViewModel.q(SwapConfirmationViewModel.this, (Throwable) obj);
            }
        });
        kotlin.jvm.internal.m.f(doOnError, "swapTxs\n            .map {\n                ethTxRepository.submitTx(tx = it.signedTx, unsignedTx = it.unsignedTx, shouldResubmit = true)\n            }\n            .zipOrEmpty()\n            .logError()\n            .observeOn(AndroidSchedulers.mainThread())\n            .doOnSuccess {\n                swapTxs = emptyList()\n\n                val route = ViewModelNavRoute(\n                    resourceId = R.id.action_swapConfirmationFragment_to_swapCompleteFragment,\n                    args = SwapCompleteFragmentArgs.createArguments(sourceAsset.currencyCode),\n                    navOptions = fadeInNavOptions\n                )\n                navigationSubject.onNext(route)\n            }\n            .doOnError {\n                val error = FeeCalculationFailed(LocalizedStrings[R.string.send_confirm_calculation_error])\n                state = state.copy(isConverting = false, error = error)\n                Analytics.log(\n                    AnalyticsEvent.swapConfirmErrorReceived(\n                        error = error.description,\n                        source = sourceAsset.currencyCode.code,\n                        target = targetAsset.currencyCode.code\n                    )\n                )\n            }");
        return Single_CoreKt.asUnit(doOnError);
    }

    public final h.c.s<kotlin.x> getDismissObservable() {
        return this.dismissObservable;
    }

    public final h.c.s<SwapConfirmationEvent> getEventObservable() {
        return this.eventObservable;
    }

    public final h.c.s<ViewModelNavRoute> getNavigationObservable() {
        return this.navigationObservable;
    }

    public final h.c.s<PromptDialogHelper.Properties> getPromptObservable() {
        return this.promptObservable;
    }

    public final h.c.s<SwapConfirmationViewState> getStateObservable() {
        return this.stateObservable;
    }

    @Override // androidx.lifecycle.b0
    public void onCleared() {
        super.onCleared();
        this.disposeBag.d();
    }

    public final void presentCoinbaseFeeInfo() {
        String str;
        List b2;
        Analytics.INSTANCE.log(AnalyticsEvent_ApplicationKt.getSwapConfirmCoinbaseFeeInfo(AnalyticsEvent.Companion));
        String str2 = this.coinbaseFeePercentage;
        if (str2 == null) {
            str = LocalizedStrings.INSTANCE.get(R.string.swap_prompt_coinbase_fee_body);
        } else {
            str = LocalizedStrings.INSTANCE.get(R.string.swap_prompt_coinbase_fee_body_fee, str2);
        }
        LocalizedStrings localizedStrings = LocalizedStrings.INSTANCE;
        String str3 = localizedStrings.get(R.string.swap_prompt_coinbase_fee_title);
        Integer valueOf = Integer.valueOf((int) R.drawable.illustration_swap_coinbase_fee);
        b2 = kotlin.a0.q.b(new PromptDialogHelper.Action(localizedStrings.get(R.string.ok), ActionStyle.POSITIVE, SwapConfirmationViewModel$presentCoinbaseFeeInfo$properties$1.INSTANCE));
        this.promptSubject.onNext(new PromptDialogHelper.Properties(null, str3, str, null, valueOf, b2, null, false, null, null, SwapConfirmationViewModel$presentCoinbaseFeeInfo$properties$2.INSTANCE, null, null, false, 15305, null));
    }

    public final void presentEstimatedInfo() {
        List b2;
        Analytics.INSTANCE.log(AnalyticsEvent_ApplicationKt.getSwapConfirmEstimatedAmountInfo(AnalyticsEvent.Companion));
        LocalizedStrings localizedStrings = LocalizedStrings.INSTANCE;
        String str = localizedStrings.get(R.string.swap_prompt_estimated_amount_title);
        String str2 = localizedStrings.get(R.string.swap_prompt_estimated_amount_body);
        Integer valueOf = Integer.valueOf((int) R.drawable.illustration_swap_estimated_amount);
        b2 = kotlin.a0.q.b(new PromptDialogHelper.Action(localizedStrings.get(R.string.ok), ActionStyle.POSITIVE, SwapConfirmationViewModel$presentEstimatedInfo$properties$1.INSTANCE));
        this.promptSubject.onNext(new PromptDialogHelper.Properties(null, str, str2, null, valueOf, b2, null, false, null, null, SwapConfirmationViewModel$presentEstimatedInfo$properties$2.INSTANCE, null, null, false, 15305, null));
    }

    public final void presentMinerFeeInfo() {
        String str;
        List b2;
        Analytics.INSTANCE.log(AnalyticsEvent_ApplicationKt.getSwapConfirmMinerFeeInfo(AnalyticsEvent.Companion));
        EthereumChain fromChainId = EthereumChain.Companion.fromChainId(this.swapTrade.getChainId());
        if (fromChainId == null) {
            return;
        }
        if (fromChainId.is1559Enabled()) {
            LocalizedStrings localizedStrings = LocalizedStrings.INSTANCE;
            str = localizedStrings.get(R.string.combine, localizedStrings.get(R.string.send_miner_fee_description), localizedStrings.get(R.string.miner_fee_1559_postfix));
        } else {
            str = LocalizedStrings.INSTANCE.get(R.string.send_miner_fee_description, fromChainId.getDisplayName());
        }
        LocalizedStrings localizedStrings2 = LocalizedStrings.INSTANCE;
        String str2 = localizedStrings2.get(R.string.send_confirmation_miner_fee_dialog_title);
        Integer valueOf = Integer.valueOf((int) R.drawable.illustration_swap_miner_fee);
        b2 = kotlin.a0.q.b(new PromptDialogHelper.Action(localizedStrings2.get(R.string.ok), ActionStyle.POSITIVE, SwapConfirmationViewModel$presentMinerFeeInfo$properties$1.INSTANCE));
        this.promptSubject.onNext(new PromptDialogHelper.Properties(null, str2, str, null, valueOf, b2, null, false, null, null, SwapConfirmationViewModel$presentMinerFeeInfo$properties$2.INSTANCE, null, null, false, 15305, null));
    }

    public final void presentPriceImpactInfo() {
        List b2;
        LocalizedStrings localizedStrings = LocalizedStrings.INSTANCE;
        b2 = kotlin.a0.q.b(new PromptDialogHelper.Action(localizedStrings.get(R.string.ok), ActionStyle.POSITIVE, SwapConfirmationViewModel$presentPriceImpactInfo$actions$1.INSTANCE));
        this.promptSubject.onNext(new PromptDialogHelper.Properties(null, localizedStrings.get(R.string.prompt_high_price_impact_title), localizedStrings.get(R.string.prompt_high_price_impact_message), null, Integer.valueOf((int) R.drawable.ic_dex_prompt_warning), b2, null, false, null, null, SwapConfirmationViewModel$presentPriceImpactInfo$promptProperties$1.INSTANCE, null, null, false, 15305, null));
    }

    public final void retry() {
        this.eventSubject.onNext(SwapConfirmationEvent.CollapseDetails.INSTANCE);
        fetchReceiptInformation();
    }

    public final h.c.b0<kotlin.x> setup() {
        List<String> b2;
        ISwapRepository iSwapRepository = this.swapRepository;
        b2 = kotlin.a0.q.b(this.swapTrade.getQuote().getAggregatorID());
        h.c.h0 map = iSwapRepository.getAggregators(b2).map(new h.c.m0.n() { // from class: com.coinbase.wallet.features.swap.viewmodels.q0
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return SwapConfirmationViewModel.x((List) obj);
            }
        });
        kotlin.jvm.internal.m.f(map, "swapRepository.getAggregators(listOf(swapTrade.quote.aggregatorID)).map { it.first() }");
        h.c.b0 map2 = h.c.t0.e.a.a(this.sourceWalletSingle, map).observeOn(h.c.j0.c.a.b()).map(new h.c.m0.n() { // from class: com.coinbase.wallet.features.swap.viewmodels.g0
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return SwapConfirmationViewModel.n(SwapConfirmationViewModel.this, (kotlin.o) obj);
            }
        });
        kotlin.jvm.internal.m.f(map2, "Singles.zip(sourceWalletSingle, aggregatorSingle)\n            .observeOn(AndroidSchedulers.mainThread())\n            .map { (sourceWallet, aggregator) ->\n                val sourceCryptoAmount: String\n                val sourceFiatAmount: String\n                val targetCryptoAmount: String\n\n                when (amountBase) {\n                    AmountBase.Source -> {\n                        targetCryptoAmount = Strings.empty\n                        val amount = when (transferAmount) {\n                            TransferValue.EntireBalance -> sourceWallet.maximumAvailableBalance()\n                            is TransferValue.Amount -> transferAmount.value\n                        }\n\n                        sourceCryptoAmount = currencyFormatter.formatToCrypto(\n                            currencyCode = sourceAsset.currencyCode,\n                            decimals = sourceAsset.decimals,\n                            includeCode = true,\n                            value = amount\n                        )\n\n                        val sourceFiat = currencyFormatter.fiatValue(\n                            currencyCode = sourceAsset.currencyCode,\n                            contractAddress = sourceAsset.contractAddress?.rawValue,\n                            decimals = sourceAsset.decimals,\n                            value = amount,\n                            chainId = sourceWallet.network.asEthereumChain?.chainId\n                        )\n\n                        sourceFiatAmount = if (sourceFiat == null) {\n                            Strings.empty\n                        } else {\n                            currencyFormatter.fiatValueString(sourceFiat, showCurrencySymbol = true)\n                        }\n                    }\n                    AmountBase.Target -> {\n                        sourceCryptoAmount = Strings.empty\n                        sourceFiatAmount = Strings.empty\n\n                        when (transferAmount) {\n                            TransferValue.EntireBalance -> {\n                                throw IllegalArgumentException(\"Target amount should never be EntireBalance\")\n                            }\n                            is TransferValue.Amount -> {\n                                targetCryptoAmount = currencyFormatter.formatToCrypto(\n                                    currencyCode = targetAsset.currencyCode,\n                                    decimals = targetAsset.decimals,\n                                    includeCode = true,\n                                    value = transferAmount.value\n                                )\n                            }\n                        }\n                    }\n                }\n\n                state = state.copy(\n                    cardTitle = LocalizedStrings[R.string.swap_confirmation_title, aggregator.name],\n                    sourceCryptoAmount = sourceCryptoAmount,\n                    sourceFiatAmount = sourceFiatAmount,\n                    targetCryptoAmount = targetCryptoAmount\n                )\n\n                fetchReceiptInformation()\n            }");
        return Single_CoreKt.asUnit(map2);
    }

    public final void toggleDetails() {
        if (this.state.isLoading()) {
            return;
        }
        this.eventSubject.onNext(SwapConfirmationEvent.ToggleDetails.INSTANCE);
    }
}