package com.coinbase.wallet.features.send.viewmodels;

import android.annotation.SuppressLint;
import com.coinbase.wallet.analytics.Analytics;
import com.coinbase.wallet.analytics.extensions.Single_AnalyticsKt;
import com.coinbase.wallet.analytics.models.AnalyticsEvent;
import com.coinbase.wallet.application.extensions.AnalyticsEvent_ApplicationKt;
import com.coinbase.wallet.application.extensions.TraceKey_ApplicationKt;
import com.coinbase.wallet.blockchains.interfaces.SignedTx;
import com.coinbase.wallet.blockchains.models.AddressType;
import com.coinbase.wallet.blockchains.models.Blockchain;
import com.coinbase.wallet.blockchains.models.CurrencyCode;
import com.coinbase.wallet.blockchains.models.TransferValue;
import com.coinbase.wallet.blockchains.models.Wallet;
import com.coinbase.wallet.blockchains.models.WalletAddress;
import com.coinbase.wallet.common.extensions.WalletRepository_CommonKt;
import com.coinbase.wallet.common.utilities.LocalizedStrings;
import com.coinbase.wallet.commonui.models.ViewModelNavRoute;
import com.coinbase.wallet.commonui.utilities.PromptDialogHelper;
import com.coinbase.wallet.core.extensions.Observable_CoreKt;
import com.coinbase.wallet.core.extensions.Single_CoreKt;
import com.coinbase.wallet.core.extensions.Strings;
import com.coinbase.wallet.core.extensions.Strings_CoreKt;
import com.coinbase.wallet.core.models.TraceKey;
import com.coinbase.wallet.core.util.Optional;
import com.coinbase.wallet.ethereum.extensions.AddressKind_EthereumKt;
import com.coinbase.wallet.ethereum.extensions.Blockchain_EthereumKt;
import com.coinbase.wallet.ethereum.extensions.CurrencyCode_EthereumKt;
import com.coinbase.wallet.ethereum.models.ContractAction;
import com.coinbase.wallet.ethereum.models.EthereumUnsigned1559Tx;
import com.coinbase.wallet.features.applock.legacy.AuthenticationHelper;
import com.coinbase.wallet.features.cloudbackup.models.OnboardingBackupRecoveryPhraseArgs;
import com.coinbase.wallet.features.lend.LendError;
import com.coinbase.wallet.features.lend.models.LendConfirmationArgs;
import com.coinbase.wallet.features.send.models.AdjustableMinerFeeSelection;
import com.coinbase.wallet.features.send.models.ConfirmationSettings;
import com.coinbase.wallet.features.send.models.SendAmounts;
import com.coinbase.wallet.features.send.models.SendConfirmationResult;
import com.coinbase.wallet.features.send.models.SendConfirmationState;
import com.coinbase.wallet.features.send.prompts.HighMinerFeesPrompt;
import com.coinbase.wallet.features.wallets.extensions.Wallet_ApplicationKt;
import com.coinbase.wallet.lending.interfaces.ILendRepository;
import com.coinbase.wallet.lending.models.LendToken;
import com.coinbase.wallet.performance.Tracer;
import com.coinbase.wallet.wallets.formatters.CurrencyFormatter;
import com.coinbase.wallet.wallets.interfaces.IExchangeRateRepository;
import com.coinbase.wallet.wallets.interfaces.ITxRepository;
import com.coinbase.wallet.wallets.interfaces.IWalletRepository;
import com.coinbase.wallet.wallets.models.ExchangeRate;
import h.c.h0;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import org.toshi.R;

/* compiled from: LendConfirmationViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000æ\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001BG\b\u0007\u0012\u0006\u0010n\u001a\u00020m\u0012\u0006\u0010\\\u001a\u00020[\u0012\u0006\u0010k\u001a\u00020j\u0012\u0006\u0010_\u001a\u00020^\u0012\b\u0010\u0082\u0001\u001a\u00030\u0081\u0001\u0012\u0006\u0010K\u001a\u00020J\u0012\b\u0010\u0092\u0001\u001a\u00030\u0091\u0001¢\u0006\u0006\b\u0093\u0001\u0010\u0094\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0003¢\u0006\u0004\b\u0005\u0010\u0006J5\u0010\u0010\u001a\u00020\u00042\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000eH\u0003¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0012H\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u001d\u0010\u0019\u001a\u00020\u00042\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u001b\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ\u0019\u0010\u001d\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u001d\u0010\u0006J\u0017\u0010!\u001a\u00020 2\u0006\u0010\u001f\u001a\u00020\u001eH\u0016¢\u0006\u0004\b!\u0010\"J\u0017\u0010#\u001a\u00020 2\u0006\u0010\u001f\u001a\u00020\u001eH\u0016¢\u0006\u0004\b#\u0010\"J\u000f\u0010$\u001a\u00020\u001eH\u0016¢\u0006\u0004\b$\u0010%J\u0019\u0010'\u001a\u00020\u00042\b\u0010&\u001a\u0004\u0018\u00010\u0017H\u0017¢\u0006\u0004\b'\u0010(R\u001e\u0010+\u001a\n **\u0004\u0018\u00010)0)8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b+\u0010,R\u001c\u0010.\u001a\b\u0012\u0004\u0012\u00020\f0-8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b.\u0010/R\u001c\u00102\u001a\b\u0012\u0004\u0012\u00020\u00020\u00168V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\b0\u00101R\"\u00104\u001a\b\u0012\u0004\u0012\u0002030\u00168\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b4\u00105\u001a\u0004\b6\u00101R$\u00108\u001a\u0010\u0012\f\u0012\n **\u0004\u0018\u00010\u00020\u0002078\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b8\u00109R\"\u0010:\u001a\u00020\u00028\u0016@\u0016X\u0096.¢\u0006\u0012\n\u0004\b:\u0010;\u001a\u0004\b<\u0010=\"\u0004\b>\u0010\u0006R\"\u0010@\u001a\b\u0012\u0004\u0012\u0002030?8\u0014@\u0014X\u0094\u0004¢\u0006\f\n\u0004\b@\u0010A\u001a\u0004\bB\u0010CR$\u0010D\u001a\u0010\u0012\f\u0012\n **\u0004\u0018\u00010\u001e0\u001e0?8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bD\u0010AR\u001d\u0010I\u001a\u00020\f8T@\u0014X\u0094\u0084\u0002¢\u0006\f\n\u0004\bE\u0010F\u001a\u0004\bG\u0010HR\u0016\u0010K\u001a\u00020J8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bK\u0010LR\u001d\u0010O\u001a\u00020\u00028B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\bM\u0010F\u001a\u0004\bN\u0010=R\u001d\u0010\u000b\u001a\u00020\n8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\bP\u0010F\u001a\u0004\bQ\u0010RR\u0016\u0010V\u001a\u00020S8V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\bT\u0010UR$\u0010W\u001a\u0010\u0012\f\u0012\n **\u0004\u0018\u000103030?8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bW\u0010AR\"\u0010Y\u001a\b\u0012\u0004\u0012\u00020X0\u00168\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\bY\u00105\u001a\u0004\bZ\u00101R\u0016\u0010\\\u001a\u00020[8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\\\u0010]R\u0016\u0010_\u001a\u00020^8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b_\u0010`R$\u0010a\u001a\u0010\u0012\f\u0012\n **\u0004\u0018\u00010X0X0?8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\ba\u0010AR*\u0010c\u001a\u0010\u0012\f\u0012\n **\u0004\u0018\u00010b0b0?8\u0014@\u0014X\u0094\u0004¢\u0006\f\n\u0004\bc\u0010A\u001a\u0004\bd\u0010CR\u001d\u0010i\u001a\u00020e8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\bf\u0010F\u001a\u0004\bg\u0010hR\u0016\u0010k\u001a\u00020j8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bk\u0010lR\u001c\u0010n\u001a\u00020m8\u0014@\u0014X\u0094\u0004¢\u0006\f\n\u0004\bn\u0010o\u001a\u0004\bp\u0010qR\"\u0010r\u001a\b\u0012\u0004\u0012\u00020b0\u00168\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\br\u00105\u001a\u0004\bs\u00101R\u001c\u0010u\u001a\b\u0012\u0004\u0012\u00020\u00020\u00168V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\bt\u00101R$\u0010v\u001a\u0004\u0018\u00010\u00028\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\bv\u0010;\u001a\u0004\bw\u0010=\"\u0004\bx\u0010\u0006R\"\u0010y\u001a\b\u0012\u0004\u0012\u0002030\u00168\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\by\u00105\u001a\u0004\bz\u00101R\u001c\u0010{\u001a\b\u0012\u0004\u0012\u00020\b0\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b{\u0010|R#\u0010~\u001a\b\u0012\u0004\u0012\u00020}0-8\u0016@\u0016X\u0096\u0004¢\u0006\r\n\u0004\b~\u0010/\u001a\u0005\b\u007f\u0010\u0080\u0001R\u001a\u0010\u0082\u0001\u001a\u00030\u0081\u00018\u0002@\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0082\u0001\u0010\u0083\u0001R \u0010\u000f\u001a\u00020\u000e8B@\u0002X\u0082\u0084\u0002¢\u0006\u000f\n\u0005\b\u0084\u0001\u0010F\u001a\u0006\b\u0085\u0001\u0010\u0086\u0001R.\u0010\u0087\u0001\u001a\u0010\u0012\f\u0012\n **\u0004\u0018\u00010\u00020\u0002078\u0014@\u0014X\u0094\u0004¢\u0006\u000f\n\u0005\b\u0087\u0001\u00109\u001a\u0006\b\u0088\u0001\u0010\u0089\u0001R%\u0010\u008a\u0001\u001a\b\u0012\u0004\u0012\u00020\u001e0\u00168\u0016@\u0016X\u0096\u0004¢\u0006\u000e\n\u0005\b\u008a\u0001\u00105\u001a\u0005\b\u008b\u0001\u00101R+\u0010\u0090\u0001\u001a\f **\u0005\u0018\u00010\u008c\u00010\u008c\u00018B@\u0002X\u0082\u0084\u0002¢\u0006\u000f\n\u0005\b\u008d\u0001\u0010F\u001a\u0006\b\u008e\u0001\u0010\u008f\u0001¨\u0006\u0095\u0001"}, d2 = {"Lcom/coinbase/wallet/features/send/viewmodels/LendConfirmationViewModel;", "Lcom/coinbase/wallet/features/send/viewmodels/ConfirmationViewModel;", "", OnboardingBackupRecoveryPhraseArgs.mnemonicKey, "Lkotlin/x;", "confirmLend", "(Ljava/lang/String;)V", "", "Lcom/coinbase/wallet/ethereum/models/EthereumUnsigned1559Tx;", "txs", "Lcom/coinbase/wallet/lending/models/LendToken;", LendConfirmationArgs.lendTokenKey, "Lcom/coinbase/wallet/blockchains/models/Wallet;", "feeWallet", "Lcom/coinbase/wallet/blockchains/models/TransferValue;", "amount", "handleUnsignedLendTxs", "(Ljava/util/List;Lcom/coinbase/wallet/lending/models/LendToken;Lcom/coinbase/wallet/blockchains/models/Wallet;Lcom/coinbase/wallet/blockchains/models/TransferValue;)V", "", "error", "handleLendError", "(Ljava/lang/Throwable;)V", "Lh/c/s;", "Lcom/coinbase/wallet/features/send/models/AdjustableMinerFeeSelection;", "minerFeeSelectionObservable", "setup", "(Lh/c/s;)V", "adjustableMinerFeeClicked", "()V", "confirmTx", "", "expanded", "", "detailsTextColor", "(Z)I", "detailsContainerColor", "isAdjustableMinerFeeEnabled", "()Z", "adjustableMinerFeeSelection", "fetchReceiptInformation", "(Lcom/coinbase/wallet/features/send/models/AdjustableMinerFeeSelection;)V", "Ljava/math/BigDecimal;", "kotlin.jvm.PlatformType", "highFeeThreshold", "Ljava/math/BigDecimal;", "Lh/c/b0;", "ethereumWalletSingle", "Lh/c/b0;", "getAnnualInterestObservable", "()Lh/c/s;", "annualInterestObservable", "Lcom/coinbase/wallet/commonui/models/ViewModelNavRoute;", "navigationObservable", "Lh/c/s;", "getNavigationObservable", "Lh/c/v0/a;", "annualInterestSubject", "Lh/c/v0/a;", "recipientTitle", "Ljava/lang/String;", "getRecipientTitle", "()Ljava/lang/String;", "setRecipientTitle", "Lh/c/v0/b;", "navigationSubject", "Lh/c/v0/b;", "getNavigationSubject", "()Lh/c/v0/b;", "expandCardSubject", "wallet$delegate", "Lkotlin/h;", "getWallet", "()Lcom/coinbase/wallet/blockchains/models/Wallet;", "wallet", "Lcom/coinbase/wallet/lending/interfaces/ILendRepository;", "lendRepository", "Lcom/coinbase/wallet/lending/interfaces/ILendRepository;", "annualInterestText$delegate", "getAnnualInterestText", "annualInterestText", "lendToken$delegate", "getLendToken", "()Lcom/coinbase/wallet/lending/models/LendToken;", "Lcom/coinbase/wallet/features/send/models/ConfirmationSettings;", "getSettings", "()Lcom/coinbase/wallet/features/send/models/ConfirmationSettings;", "settings", "navigateToSendCompleteViewSubject", "Lcom/coinbase/wallet/features/send/models/SendConfirmationResult;", "sendConfirmationObservable", "getSendConfirmationObservable", "Lcom/coinbase/wallet/features/send/prompts/HighMinerFeesPrompt;", "highMinerFeesPrompt", "Lcom/coinbase/wallet/features/send/prompts/HighMinerFeesPrompt;", "Lcom/coinbase/wallet/wallets/interfaces/ITxRepository;", "txRepository", "Lcom/coinbase/wallet/wallets/interfaces/ITxRepository;", "sendConfirmationSubject", "Lcom/coinbase/wallet/commonui/utilities/PromptDialogHelper$Properties;", "promptSubject", "getPromptSubject", "Lcom/coinbase/wallet/ethereum/models/ContractAction;", "contractAction$delegate", "getContractAction", "()Lcom/coinbase/wallet/ethereum/models/ContractAction;", "contractAction", "Lcom/coinbase/wallet/wallets/formatters/CurrencyFormatter;", "currencyFormatter", "Lcom/coinbase/wallet/wallets/formatters/CurrencyFormatter;", "Lcom/coinbase/wallet/features/applock/legacy/AuthenticationHelper;", "authenticationHelper", "Lcom/coinbase/wallet/features/applock/legacy/AuthenticationHelper;", "getAuthenticationHelper", "()Lcom/coinbase/wallet/features/applock/legacy/AuthenticationHelper;", "promptObservable", "getPromptObservable", "getMinerFeeExplainerObservable", "minerFeeExplainerObservable", "recipientSubtitle", "getRecipientSubtitle", "setRecipientSubtitle", "navigateToSendCompleteViewObservable", "getNavigateToSendCompleteViewObservable", "lendingTxs", "Ljava/util/List;", "Lcom/coinbase/wallet/features/send/models/SendAmounts;", "sendAmounts", "getSendAmounts", "()Lh/c/b0;", "Lcom/coinbase/wallet/wallets/interfaces/IExchangeRateRepository;", "exchangeRateRepository", "Lcom/coinbase/wallet/wallets/interfaces/IExchangeRateRepository;", "amount$delegate", "getAmount", "()Lcom/coinbase/wallet/blockchains/models/TransferValue;", "minerFeeExplainerSubject", "getMinerFeeExplainerSubject", "()Lh/c/v0/a;", "expandCardObservable", "getExpandCardObservable", "Lh/c/a0;", "mainScheduler$delegate", "getMainScheduler", "()Lh/c/a0;", "mainScheduler", "Lcom/coinbase/wallet/wallets/interfaces/IWalletRepository;", "walletRepository", "<init>", "(Lcom/coinbase/wallet/features/applock/legacy/AuthenticationHelper;Lcom/coinbase/wallet/features/send/prompts/HighMinerFeesPrompt;Lcom/coinbase/wallet/wallets/formatters/CurrencyFormatter;Lcom/coinbase/wallet/wallets/interfaces/ITxRepository;Lcom/coinbase/wallet/wallets/interfaces/IExchangeRateRepository;Lcom/coinbase/wallet/lending/interfaces/ILendRepository;Lcom/coinbase/wallet/wallets/interfaces/IWalletRepository;)V", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class LendConfirmationViewModel extends ConfirmationViewModel {
    private final kotlin.h amount$delegate;
    private final h.c.v0.a<String> annualInterestSubject;
    private final kotlin.h annualInterestText$delegate;
    private final AuthenticationHelper authenticationHelper;
    private final kotlin.h contractAction$delegate;
    private final CurrencyFormatter currencyFormatter;
    private final h.c.b0<Wallet> ethereumWalletSingle;
    private final IExchangeRateRepository exchangeRateRepository;
    private final h.c.s<Boolean> expandCardObservable;
    private final h.c.v0.b<Boolean> expandCardSubject;
    private final BigDecimal highFeeThreshold;
    private final HighMinerFeesPrompt highMinerFeesPrompt;
    private final ILendRepository lendRepository;
    private final kotlin.h lendToken$delegate;
    private List<EthereumUnsigned1559Tx> lendingTxs;
    private final kotlin.h mainScheduler$delegate;
    private final h.c.v0.a<String> minerFeeExplainerSubject;
    private final h.c.s<ViewModelNavRoute> navigateToSendCompleteViewObservable;
    private final h.c.v0.b<ViewModelNavRoute> navigateToSendCompleteViewSubject;
    private final h.c.s<ViewModelNavRoute> navigationObservable;
    private final h.c.v0.b<ViewModelNavRoute> navigationSubject;
    private final h.c.s<PromptDialogHelper.Properties> promptObservable;
    private final h.c.v0.b<PromptDialogHelper.Properties> promptSubject;
    private String recipientSubtitle;
    public String recipientTitle;
    private final h.c.b0<SendAmounts> sendAmounts;
    private final h.c.s<SendConfirmationResult> sendConfirmationObservable;
    private final h.c.v0.b<SendConfirmationResult> sendConfirmationSubject;
    private final ITxRepository txRepository;
    private final kotlin.h wallet$delegate;

    /* compiled from: LendConfirmationViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ContractAction.values().length];
            iArr[ContractAction.SUPPLY.ordinal()] = 1;
            iArr[ContractAction.WITHDRAW.ordinal()] = 2;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public LendConfirmationViewModel(AuthenticationHelper authenticationHelper, HighMinerFeesPrompt highMinerFeesPrompt, CurrencyFormatter currencyFormatter, ITxRepository txRepository, IExchangeRateRepository exchangeRateRepository, ILendRepository lendRepository, IWalletRepository walletRepository) {
        kotlin.h b2;
        kotlin.h b3;
        kotlin.h b4;
        kotlin.h b5;
        kotlin.h b6;
        List<EthereumUnsigned1559Tx> g2;
        kotlin.h b7;
        kotlin.jvm.internal.m.g(authenticationHelper, "authenticationHelper");
        kotlin.jvm.internal.m.g(highMinerFeesPrompt, "highMinerFeesPrompt");
        kotlin.jvm.internal.m.g(currencyFormatter, "currencyFormatter");
        kotlin.jvm.internal.m.g(txRepository, "txRepository");
        kotlin.jvm.internal.m.g(exchangeRateRepository, "exchangeRateRepository");
        kotlin.jvm.internal.m.g(lendRepository, "lendRepository");
        kotlin.jvm.internal.m.g(walletRepository, "walletRepository");
        this.authenticationHelper = authenticationHelper;
        this.highMinerFeesPrompt = highMinerFeesPrompt;
        this.currencyFormatter = currencyFormatter;
        this.txRepository = txRepository;
        this.exchangeRateRepository = exchangeRateRepository;
        this.lendRepository = lendRepository;
        h.c.v0.b<ViewModelNavRoute> d2 = h.c.v0.b.d();
        kotlin.jvm.internal.m.f(d2, "create<ViewModelNavRoute>()");
        this.navigateToSendCompleteViewSubject = d2;
        h.c.v0.b<SendConfirmationResult> d3 = h.c.v0.b.d();
        kotlin.jvm.internal.m.f(d3, "create<SendConfirmationResult>()");
        this.sendConfirmationSubject = d3;
        h.c.v0.b<Boolean> d4 = h.c.v0.b.d();
        kotlin.jvm.internal.m.f(d4, "create<Boolean>()");
        this.expandCardSubject = d4;
        this.highFeeThreshold = BigDecimal.ONE;
        Strings strings = Strings.INSTANCE;
        h.c.v0.a<String> e2 = h.c.v0.a.e(Strings_CoreKt.getEllipsis(strings));
        kotlin.jvm.internal.m.f(e2, "createDefault(Strings.ellipsis)");
        this.annualInterestSubject = e2;
        b2 = kotlin.k.b(new LendConfirmationViewModel$amount$2(this));
        this.amount$delegate = b2;
        b3 = kotlin.k.b(new LendConfirmationViewModel$lendToken$2(this));
        this.lendToken$delegate = b3;
        b4 = kotlin.k.b(new LendConfirmationViewModel$annualInterestText$2(this));
        this.annualInterestText$delegate = b4;
        b5 = kotlin.k.b(new LendConfirmationViewModel$contractAction$2(this));
        this.contractAction$delegate = b5;
        b6 = kotlin.k.b(LendConfirmationViewModel$mainScheduler$2.INSTANCE);
        this.mainScheduler$delegate = b6;
        g2 = kotlin.a0.r.g();
        this.lendingTxs = g2;
        h.c.s<Optional<Wallet>> observeWallet = WalletRepository_CommonKt.observeWallet(walletRepository, Blockchain_EthereumKt.getETHEREUM(Blockchain.Companion), CurrencyCode_EthereumKt.getETH(CurrencyCode.Companion));
        kotlin.jvm.internal.m.f(observeWallet, "walletRepository\n        .observeWallet(Blockchain.ETHEREUM, CurrencyCode.ETH)");
        h.c.s<R> map = observeWallet.filter(new h.c.m0.p() { // from class: com.coinbase.wallet.features.send.viewmodels.LendConfirmationViewModel$special$$inlined$unwrap$1
            public final boolean test(Optional<? extends T> it) {
                kotlin.jvm.internal.m.g(it, "it");
                return it.toNullable() != null;
            }

            @Override // h.c.m0.p
            public /* bridge */ /* synthetic */ boolean test(Object obj) {
                return test((Optional) ((Optional) obj));
            }
        }).map(new h.c.m0.n() { // from class: com.coinbase.wallet.features.send.viewmodels.LendConfirmationViewModel$special$$inlined$unwrap$2
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
        h.c.v0.b<PromptDialogHelper.Properties> d5 = h.c.v0.b.d();
        kotlin.jvm.internal.m.f(d5, "create<PromptDialogHelper.Properties>()");
        this.promptSubject = d5;
        h.c.v0.a<String> e3 = h.c.v0.a.e(Strings_CoreKt.getEllipsis(strings));
        kotlin.jvm.internal.m.f(e3, "createDefault(Strings.ellipsis)");
        this.minerFeeExplainerSubject = e3;
        h.c.v0.b<ViewModelNavRoute> d6 = h.c.v0.b.d();
        kotlin.jvm.internal.m.f(d6, "create()");
        this.navigationSubject = d6;
        b7 = kotlin.k.b(new LendConfirmationViewModel$wallet$2(this));
        this.wallet$delegate = b7;
        h.c.s<SendConfirmationResult> onErrorReturnItem = d3.hide().onErrorReturnItem(new SendConfirmationResult(SendConfirmationState.None.INSTANCE, null, null, null, null, null, null, 126, null));
        kotlin.jvm.internal.m.f(onErrorReturnItem, "sendConfirmationSubject\n        .hide()\n        .onErrorReturnItem(SendConfirmationResult(state = SendConfirmationState.None))");
        this.sendConfirmationObservable = onErrorReturnItem;
        h.c.s<ViewModelNavRoute> hide = d2.hide();
        kotlin.jvm.internal.m.f(hide, "navigateToSendCompleteViewSubject.hide()");
        this.navigateToSendCompleteViewObservable = hide;
        h.c.s<PromptDialogHelper.Properties> hide2 = getPromptSubject().hide();
        kotlin.jvm.internal.m.f(hide2, "promptSubject.hide()");
        this.promptObservable = hide2;
        h.c.s<Boolean> hide3 = d4.hide();
        kotlin.jvm.internal.m.f(hide3, "expandCardSubject.hide()");
        this.expandCardObservable = hide3;
        h.c.s<ViewModelNavRoute> hide4 = getNavigationSubject().hide();
        kotlin.jvm.internal.m.f(hide4, "navigationSubject.hide()");
        this.navigationObservable = hide4;
        h.c.s<List<ExchangeRate>> filter = exchangeRateRepository.getExchangeRateObservable().filter(new h.c.m0.p() { // from class: com.coinbase.wallet.features.send.viewmodels.h
            @Override // h.c.m0.p
            public final boolean test(Object obj) {
                return LendConfirmationViewModel.c((List) obj);
            }
        });
        kotlin.jvm.internal.m.f(filter, "exchangeRateRepository\n        .exchangeRateObservable\n        .filter { it.isNotEmpty() }");
        h.c.b0<SendAmounts> map2 = Observable_CoreKt.takeSingle(filter).map(new h.c.m0.n() { // from class: com.coinbase.wallet.features.send.viewmodels.i
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return LendConfirmationViewModel.d(LendConfirmationViewModel.this, (List) obj);
            }
        });
        kotlin.jvm.internal.m.f(map2, "exchangeRateRepository\n        .exchangeRateObservable\n        .filter { it.isNotEmpty() }\n        .takeSingle()\n        .map {\n            val transferValue: BigInteger = when (amount) {\n                is TransferValue.Amount -> (amount as TransferValue.Amount).value\n                is TransferValue.EntireBalance -> when (contractAction) {\n                    ContractAction.SUPPLY -> {\n                        wallet.maximumAvailableBalance()\n                    }\n                    ContractAction.WITHDRAW -> {\n                        lendToken.supplyBalance\n                    }\n                }\n            }\n\n            val formattedFiat = currencyFormatter.formatToFiat(\n                fromCurrencyCode = wallet.currencyCode,\n                contractAddress = wallet.contractAddress,\n                decimals = wallet.decimals,\n                value = transferValue\n            ) ?: Strings.ellipsis\n\n            val formattedCrypto = currencyFormatter.formatToCrypto(\n                currencyCode = wallet.currencyCode,\n                decimals = wallet.decimals,\n                value = transferValue,\n                includeCode = true\n            )\n\n            SendAmounts(formattedFiat, formattedCrypto)\n        }");
        this.sendAmounts = map2;
    }

    public static /* synthetic */ List a(EthereumUnsigned1559Tx ethereumUnsigned1559Tx) {
        return m1360fetchReceiptInformation$lambda4$lambda3(ethereumUnsigned1559Tx);
    }

    public static /* synthetic */ h0 b(LendConfirmationViewModel lendConfirmationViewModel, kotlin.o oVar) {
        return m1359fetchReceiptInformation$lambda4(lendConfirmationViewModel, oVar);
    }

    public static /* synthetic */ boolean c(List list) {
        return m1361sendAmounts$lambda0(list);
    }

    @SuppressLint({"CheckResult"})
    private final void confirmLend(String str) {
        int r;
        h.c.b0 zip;
        List g2;
        int i2 = WhenMappings.$EnumSwitchMapping$0[getContractAction().ordinal()];
        if (i2 == 1) {
            Analytics.INSTANCE.log(AnalyticsEvent_ApplicationKt.lendConfirmationLendStart(AnalyticsEvent.Companion));
        } else if (i2 == 2) {
            Analytics.INSTANCE.log(AnalyticsEvent_ApplicationKt.lendConfirmationWithdrawStart(AnalyticsEvent.Companion));
        }
        List<EthereumUnsigned1559Tx> list = this.lendingTxs;
        r = kotlin.a0.s.r(list, 10);
        ArrayList arrayList = new ArrayList(r);
        for (EthereumUnsigned1559Tx ethereumUnsigned1559Tx : list) {
            if (!(ethereumUnsigned1559Tx instanceof EthereumUnsigned1559Tx)) {
                Analytics.INSTANCE.log(AnalyticsEvent_ApplicationKt.lendTxGenerationError(AnalyticsEvent.Companion));
                l.a.a.d("Unexpected tx type in lend", new Object[0]);
                return;
            }
            arrayList.add(this.txRepository.signAndSubmit(ethereumUnsigned1559Tx, str, false));
        }
        h.c.t0.e eVar = h.c.t0.e.a;
        if (arrayList.isEmpty()) {
            g2 = kotlin.a0.r.g();
            zip = h.c.b0.just(g2);
            kotlin.jvm.internal.m.f(zip, "just(emptyList())");
        } else {
            zip = h.c.b0.zip(arrayList, new h.c.m0.n() { // from class: com.coinbase.wallet.features.send.viewmodels.LendConfirmationViewModel$confirmLend$$inlined$zipOrEmpty$1
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
                        if (obj instanceof SignedTx) {
                            arrayList2.add(obj);
                        }
                    }
                    return arrayList2;
                }
            });
            kotlin.jvm.internal.m.f(zip, "zip(singles) { if (it.isEmpty()) emptyList() else it.filterIsInstance<T>() }");
        }
        h.c.b0 trace = Single_CoreKt.trace(Single_AnalyticsKt.logError$default(zip, null, null, 3, null), TraceKey_ApplicationKt.getConfirmLendKey(TraceKey.Companion), Tracer.INSTANCE);
        kotlin.jvm.internal.m.f(trace, "signedTxObservables.zipOrEmpty()\n            .logError()\n            .trace(TraceKey.confirmLendKey, Tracer)");
        h.c.t0.g.f(trace, new LendConfirmationViewModel$confirmLend$1(this), new LendConfirmationViewModel$confirmLend$2(this));
    }

    public static /* synthetic */ SendAmounts d(LendConfirmationViewModel lendConfirmationViewModel, List list) {
        return m1362sendAmounts$lambda1(lendConfirmationViewModel, list);
    }

    /* renamed from: fetchReceiptInformation$lambda-4 */
    public static final h0 m1359fetchReceiptInformation$lambda4(LendConfirmationViewModel this$0, kotlin.o dstr$feeWallet$tokens) {
        Object obj;
        h.c.b0<List<EthereumUnsigned1559Tx>> supply;
        boolean z;
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(dstr$feeWallet$tokens, "$dstr$feeWallet$tokens");
        Wallet wallet = (Wallet) dstr$feeWallet$tokens.a();
        List tokens = (List) dstr$feeWallet$tokens.b();
        kotlin.jvm.internal.m.f(tokens, "tokens");
        Iterator it = tokens.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            LendToken lendToken = (LendToken) obj;
            if (kotlin.jvm.internal.m.c(lendToken.getCurrencyCode(), this$0.getLendToken().getCurrencyCode()) && kotlin.jvm.internal.m.c(lendToken.getProvider().getId(), this$0.getLendToken().getProvider().getId())) {
                z = true;
                continue;
            } else {
                z = false;
                continue;
            }
            if (z) {
                break;
            }
        }
        LendToken lendToken2 = (LendToken) obj;
        if (lendToken2 != null) {
            Integer selectedIndex = this$0.getWallet().getSelectedIndex();
            if (selectedIndex != null) {
                WalletAddress walletAddress = new WalletAddress(AddressKind_EthereumKt.getEthereum(AddressType.Companion), this$0.getWallet().getPrimaryAddress(), selectedIndex.intValue());
                int i2 = WhenMappings.$EnumSwitchMapping$0[this$0.getContractAction().ordinal()];
                if (i2 == 1) {
                    supply = this$0.lendRepository.supply(walletAddress, lendToken2, this$0.getAmount());
                } else if (i2 != 2) {
                    throw new NoWhenBranchMatchedException();
                } else {
                    supply = this$0.lendRepository.withdraw(walletAddress, lendToken2, this$0.getAmount()).map(new h.c.m0.n() { // from class: com.coinbase.wallet.features.send.viewmodels.f
                        @Override // h.c.m0.n
                        public final Object apply(Object obj2) {
                            return LendConfirmationViewModel.a((EthereumUnsigned1559Tx) obj2);
                        }
                    });
                    kotlin.jvm.internal.m.f(supply, "{\n                        lendRepository.withdraw(address = walletAddress, token = token, amount = amount)\n                            .map { listOf(it) }\n                    }");
                }
                h.c.t0.e eVar = h.c.t0.e.a;
                h.c.b0 just = h.c.b0.just(wallet);
                kotlin.jvm.internal.m.f(just, "just(feeWallet)");
                h.c.b0 just2 = h.c.b0.just(lendToken2);
                kotlin.jvm.internal.m.f(just2, "just(token)");
                return eVar.b(supply, just, just2);
            }
            throw LendError.unableToSupply.INSTANCE;
        }
        throw LendError.unableToSupply.INSTANCE;
    }

    /* renamed from: fetchReceiptInformation$lambda-4$lambda-3 */
    public static final List m1360fetchReceiptInformation$lambda4$lambda3(EthereumUnsigned1559Tx it) {
        List b2;
        kotlin.jvm.internal.m.g(it, "it");
        b2 = kotlin.a0.q.b(it);
        return b2;
    }

    public final TransferValue getAmount() {
        return (TransferValue) this.amount$delegate.getValue();
    }

    private final String getAnnualInterestText() {
        return (String) this.annualInterestText$delegate.getValue();
    }

    private final ContractAction getContractAction() {
        return (ContractAction) this.contractAction$delegate.getValue();
    }

    private final LendToken getLendToken() {
        return (LendToken) this.lendToken$delegate.getValue();
    }

    public final h.c.a0 getMainScheduler() {
        return (h.c.a0) this.mainScheduler$delegate.getValue();
    }

    public final void handleLendError(Throwable th) {
        String message = th.getMessage();
        if (message == null) {
            message = LocalizedStrings.INSTANCE.get(R.string.send_fee_error);
        }
        this.sendConfirmationSubject.onNext(new SendConfirmationResult(new SendConfirmationState.Error(message), null, null, null, null, null, null, 126, null));
    }

    @SuppressLint({"CheckResult"})
    public final void handleUnsignedLendTxs(List<EthereumUnsigned1559Tx> list, LendToken lendToken, Wallet wallet, TransferValue transferValue) {
        int r;
        BigInteger maximumAvailableBalance;
        BigInteger bigInteger;
        SendConfirmationState sendConfirmationState;
        SendConfirmationState sendConfirmationState2;
        BigInteger maximumAvailableBalance2 = Wallet_ApplicationKt.maximumAvailableBalance(wallet);
        r = kotlin.a0.s.r(list, 10);
        ArrayList arrayList = new ArrayList(r);
        for (EthereumUnsigned1559Tx ethereumUnsigned1559Tx : list) {
            arrayList.add(ethereumUnsigned1559Tx.getEstimatedFee());
        }
        Iterator it = arrayList.iterator();
        if (it.hasNext()) {
            Object obj = it.next();
            while (it.hasNext()) {
                Object add = ((BigInteger) obj).add((BigInteger) it.next());
                kotlin.jvm.internal.m.f(add, "this.add(other)");
                obj = add;
            }
            BigInteger bigInteger2 = (BigInteger) obj;
            CurrencyCode.Companion companion = CurrencyCode.Companion;
            CurrencyCode eth = CurrencyCode_EthereumKt.getETH(companion);
            if (transferValue instanceof TransferValue.Amount) {
                BigInteger value = ((TransferValue.Amount) transferValue).getValue();
                int i2 = WhenMappings.$EnumSwitchMapping$0[getContractAction().ordinal()];
                if (i2 == 1) {
                    BigInteger bigInteger3 = kotlin.jvm.internal.m.c(lendToken.getCurrencyCode(), eth) ? bigInteger2 : BigInteger.ZERO;
                    kotlin.jvm.internal.m.f(bigInteger3, "if (lendToken.currencyCode == feeCode) estimatedFee else BigInteger.ZERO");
                    maximumAvailableBalance = value.add(bigInteger3);
                    kotlin.jvm.internal.m.f(maximumAvailableBalance, "this.add(other)");
                } else if (i2 != 2) {
                    throw new NoWhenBranchMatchedException();
                } else {
                    maximumAvailableBalance = bigInteger2;
                }
                bigInteger = value;
            } else if (!(transferValue instanceof TransferValue.EntireBalance)) {
                throw new NoWhenBranchMatchedException();
            } else {
                int i3 = WhenMappings.$EnumSwitchMapping$0[getContractAction().ordinal()];
                if (i3 == 1) {
                    maximumAvailableBalance = Wallet_ApplicationKt.maximumAvailableBalance(getWallet());
                } else if (i3 == 2) {
                    maximumAvailableBalance = lendToken.getSupplyBalance();
                } else {
                    throw new NoWhenBranchMatchedException();
                }
                bigInteger = maximumAvailableBalance;
            }
            if (kotlin.jvm.internal.m.c(lendToken.getCurrencyCode(), CurrencyCode_EthereumKt.getETH(companion)) && maximumAvailableBalance.compareTo(maximumAvailableBalance2) > 0) {
                BigInteger subtract = maximumAvailableBalance.subtract(maximumAvailableBalance2);
                kotlin.jvm.internal.m.f(subtract, "this.subtract(other)");
                sendConfirmationState2 = new SendConfirmationState.InsufficientBalance(LocalizedStrings.INSTANCE.get(R.string.insufficient_balance_error, getWallet().getCurrencyCode(), CurrencyFormatter.formatToCrypto$default(this.currencyFormatter, eth, wallet.getDecimals(), subtract, false, 0, 0, 56, (Object) null)));
            } else {
                if (bigInteger2.compareTo(maximumAvailableBalance2) > 0) {
                    sendConfirmationState = new SendConfirmationState.InsufficientFee(LocalizedStrings.INSTANCE.get(R.string.insufficient_fee_balance_info_prompt_subtitle));
                } else {
                    sendConfirmationState = SendConfirmationState.SufficientBalance.INSTANCE;
                }
                sendConfirmationState2 = sendConfirmationState;
            }
            this.sendConfirmationSubject.onNext(SendConfirmationResult.Companion.create(sendConfirmationState2, list, lendToken, bigInteger, this.currencyFormatter));
            h.c.t0.g.i(IExchangeRateRepository.DefaultImpls.getCryptoExchangeRate$default(this.exchangeRateRepository, CurrencyCode_EthereumKt.getETH(companion), null, 0, 6, null), null, new LendConfirmationViewModel$handleUnsignedLendTxs$1(bigInteger2, this, list, wallet), 1, null);
            return;
        }
        throw new UnsupportedOperationException("Empty collection can't be reduced.");
    }

    /* renamed from: sendAmounts$lambda-0 */
    public static final boolean m1361sendAmounts$lambda0(List it) {
        kotlin.jvm.internal.m.g(it, "it");
        return !it.isEmpty();
    }

    /* renamed from: sendAmounts$lambda-1 */
    public static final SendAmounts m1362sendAmounts$lambda1(LendConfirmationViewModel this$0, List it) {
        BigInteger maximumAvailableBalance;
        String formatToFiat;
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(it, "it");
        TransferValue amount = this$0.getAmount();
        if (amount instanceof TransferValue.Amount) {
            maximumAvailableBalance = ((TransferValue.Amount) this$0.getAmount()).getValue();
        } else if (!(amount instanceof TransferValue.EntireBalance)) {
            throw new NoWhenBranchMatchedException();
        } else {
            int i2 = WhenMappings.$EnumSwitchMapping$0[this$0.getContractAction().ordinal()];
            if (i2 == 1) {
                maximumAvailableBalance = Wallet_ApplicationKt.maximumAvailableBalance(this$0.getWallet());
            } else if (i2 != 2) {
                throw new NoWhenBranchMatchedException();
            } else {
                maximumAvailableBalance = this$0.getLendToken().getSupplyBalance();
            }
        }
        formatToFiat = this$0.currencyFormatter.formatToFiat(this$0.getWallet().getCurrencyCode(), this$0.getWallet().getContractAddress(), this$0.getWallet().getDecimals(), maximumAvailableBalance, (r17 & 16) != 0 ? false : false, (r17 & 32) != 0 ? null : null, (r17 & 64) != 0 ? null : null);
        if (formatToFiat == null) {
            formatToFiat = Strings_CoreKt.getEllipsis(Strings.INSTANCE);
        }
        return new SendAmounts(formatToFiat, CurrencyFormatter.formatToCrypto$default(this$0.currencyFormatter, this$0.getWallet().getCurrencyCode(), this$0.getWallet().getDecimals(), maximumAvailableBalance, true, 0, 0, 48, (Object) null));
    }

    @Override // com.coinbase.wallet.features.send.viewmodels.ConfirmationViewModel
    public void adjustableMinerFeeClicked() {
    }

    @Override // com.coinbase.wallet.features.send.viewmodels.ConfirmationViewModel
    public void confirmTx(String str) {
        if (str == null) {
            return;
        }
        confirmLend(str);
    }

    @Override // com.coinbase.wallet.features.send.viewmodels.ConfirmationViewModel
    public int detailsContainerColor(boolean z) {
        return R.color.white;
    }

    @Override // com.coinbase.wallet.features.send.viewmodels.ConfirmationViewModel
    public int detailsTextColor(boolean z) {
        return R.color.primary_black;
    }

    @Override // com.coinbase.wallet.features.send.viewmodels.ConfirmationViewModel
    @SuppressLint({"CheckResult"})
    public void fetchReceiptInformation(AdjustableMinerFeeSelection adjustableMinerFeeSelection) {
        h.c.b0 flatMap = h.c.t0.e.a.a(this.ethereumWalletSingle, Observable_CoreKt.takeSingle(this.lendRepository.observeTokens())).flatMap(new h.c.m0.n() { // from class: com.coinbase.wallet.features.send.viewmodels.g
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return LendConfirmationViewModel.b(LendConfirmationViewModel.this, (kotlin.o) obj);
            }
        });
        kotlin.jvm.internal.m.f(flatMap, "Singles.zip(ethereumWalletSingle, lendRepository.observeTokens().takeSingle())\n            .flatMap { (feeWallet, tokens) ->\n                val matchingToken = tokens.firstOrNull(\n                    predicate = {\n                        it.currencyCode == this.lendToken.currencyCode && it.provider.id == lendToken.provider.id\n                    }\n                )\n                val token = matchingToken ?: throw LendError.unableToSupply\n                val index = wallet.selectedIndex ?: throw LendError.unableToSupply\n                val walletAddress = WalletAddress(\n                    type = AddressType.Ethereum,\n                    address = wallet.primaryAddress,\n                    index = index\n                )\n                val lendSingle = when (contractAction) {\n                    ContractAction.SUPPLY -> {\n                        lendRepository.supply(address = walletAddress, token = token, amount = amount)\n                    }\n                    ContractAction.WITHDRAW -> {\n                        lendRepository.withdraw(address = walletAddress, token = token, amount = amount)\n                            .map { listOf(it) }\n                    }\n                }\n\n                Singles.zip(lendSingle, Single.just(feeWallet), Single.just(token))\n            }");
        h.c.t0.g.f(Single_AnalyticsKt.logError$default(flatMap, null, null, 3, null), new LendConfirmationViewModel$fetchReceiptInformation$2(this), new LendConfirmationViewModel$fetchReceiptInformation$3(this));
    }

    @Override // com.coinbase.wallet.features.send.viewmodels.ConfirmationViewModel
    public h.c.s<String> getAnnualInterestObservable() {
        h.c.s<String> hide = this.annualInterestSubject.hide();
        kotlin.jvm.internal.m.f(hide, "annualInterestSubject.hide()");
        return hide;
    }

    @Override // com.coinbase.wallet.features.send.viewmodels.ConfirmationViewModel
    protected AuthenticationHelper getAuthenticationHelper() {
        return this.authenticationHelper;
    }

    @Override // com.coinbase.wallet.features.send.viewmodels.ConfirmationViewModel
    public h.c.s<Boolean> getExpandCardObservable() {
        return this.expandCardObservable;
    }

    @Override // com.coinbase.wallet.features.send.viewmodels.ConfirmationViewModel
    public h.c.s<String> getMinerFeeExplainerObservable() {
        h.c.s<String> hide = getMinerFeeExplainerSubject().hide();
        kotlin.jvm.internal.m.f(hide, "minerFeeExplainerSubject.hide()");
        return hide;
    }

    @Override // com.coinbase.wallet.features.send.viewmodels.ConfirmationViewModel
    protected h.c.v0.a<String> getMinerFeeExplainerSubject() {
        return this.minerFeeExplainerSubject;
    }

    @Override // com.coinbase.wallet.features.send.viewmodels.ConfirmationViewModel
    public h.c.s<ViewModelNavRoute> getNavigateToSendCompleteViewObservable() {
        return this.navigateToSendCompleteViewObservable;
    }

    @Override // com.coinbase.wallet.features.send.viewmodels.ConfirmationViewModel
    public h.c.s<ViewModelNavRoute> getNavigationObservable() {
        return this.navigationObservable;
    }

    @Override // com.coinbase.wallet.features.send.viewmodels.ConfirmationViewModel
    protected h.c.v0.b<ViewModelNavRoute> getNavigationSubject() {
        return this.navigationSubject;
    }

    @Override // com.coinbase.wallet.features.send.viewmodels.ConfirmationViewModel
    public h.c.s<PromptDialogHelper.Properties> getPromptObservable() {
        return this.promptObservable;
    }

    @Override // com.coinbase.wallet.features.send.viewmodels.ConfirmationViewModel
    public h.c.v0.b<PromptDialogHelper.Properties> getPromptSubject() {
        return this.promptSubject;
    }

    @Override // com.coinbase.wallet.features.send.viewmodels.ConfirmationViewModel
    public String getRecipientSubtitle() {
        return this.recipientSubtitle;
    }

    @Override // com.coinbase.wallet.features.send.viewmodels.ConfirmationViewModel
    public String getRecipientTitle() {
        String str = this.recipientTitle;
        if (str != null) {
            return str;
        }
        kotlin.jvm.internal.m.w("recipientTitle");
        throw null;
    }

    @Override // com.coinbase.wallet.features.send.viewmodels.ConfirmationViewModel
    public h.c.b0<SendAmounts> getSendAmounts() {
        return this.sendAmounts;
    }

    @Override // com.coinbase.wallet.features.send.viewmodels.ConfirmationViewModel
    public h.c.s<SendConfirmationResult> getSendConfirmationObservable() {
        return this.sendConfirmationObservable;
    }

    @Override // com.coinbase.wallet.features.send.viewmodels.ConfirmationViewModel
    public ConfirmationSettings getSettings() {
        String str;
        String str2;
        String str3;
        ContractAction contractAction = getContractAction();
        ContractAction contractAction2 = ContractAction.SUPPLY;
        if (contractAction == contractAction2) {
            str = LocalizedStrings.INSTANCE.get(R.string.lend_confirm_title);
        } else {
            str = LocalizedStrings.INSTANCE.get(R.string.lend_confirm_withdraw_title);
        }
        String str4 = str;
        boolean z = getContractAction() != contractAction2;
        if (getContractAction() == contractAction2) {
            str2 = LocalizedStrings.INSTANCE.get(R.string.lend_confirm_to);
        } else {
            str2 = LocalizedStrings.INSTANCE.get(R.string.lend_confirm_from);
        }
        String str5 = str2;
        kotlin.o oVar = new kotlin.o(getLendToken().getProviderImageURL(), null);
        if (getContractAction() == contractAction2) {
            str3 = LocalizedStrings.INSTANCE.get(R.string.lend_confirm_button);
        } else {
            str3 = LocalizedStrings.INSTANCE.get(R.string.lend_confirm_withdraw_button);
        }
        return new ConfirmationSettings(str4, true, z, R.color.primary_black, R.color.primary_black, R.color.primary_black, str5, oVar, R.color.white, str3, getContractAction() == contractAction2 ? R.drawable.button_primary : R.drawable.button_primary_red);
    }

    @Override // com.coinbase.wallet.features.send.viewmodels.ConfirmationViewModel
    protected Wallet getWallet() {
        return (Wallet) this.wallet$delegate.getValue();
    }

    @Override // com.coinbase.wallet.features.send.viewmodels.ConfirmationViewModel
    public boolean isAdjustableMinerFeeEnabled() {
        return false;
    }

    public void setRecipientSubtitle(String str) {
        this.recipientSubtitle = str;
    }

    public void setRecipientTitle(String str) {
        kotlin.jvm.internal.m.g(str, "<set-?>");
        this.recipientTitle = str;
    }

    @Override // com.coinbase.wallet.features.send.viewmodels.ConfirmationViewModel
    public void setup(h.c.s<AdjustableMinerFeeSelection> minerFeeSelectionObservable) {
        kotlin.jvm.internal.m.g(minerFeeSelectionObservable, "minerFeeSelectionObservable");
        setRecipientTitle(getLendToken().getProviderName());
        this.annualInterestSubject.onNext(getAnnualInterestText());
        Analytics.INSTANCE.log(AnalyticsEvent_ApplicationKt.lendConfirmationLanded(AnalyticsEvent.Companion, getAmount().isMax()));
    }
}