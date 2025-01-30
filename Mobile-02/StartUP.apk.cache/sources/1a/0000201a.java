package com.coinbase.wallet.features.send.viewmodels;

import android.annotation.SuppressLint;
import android.os.Bundle;
import com.coinbase.ciphercore.ethereum.EthereumChain;
import com.coinbase.wallet.analytics.Analytics;
import com.coinbase.wallet.analytics.extensions.Single_AnalyticsKt;
import com.coinbase.wallet.analytics.models.AnalyticsEvent;
import com.coinbase.wallet.application.extensions.AnalyticsEvent_ApplicationKt;
import com.coinbase.wallet.application.extensions.TraceKey_ApplicationKt;
import com.coinbase.wallet.blockchains.exceptions.TxException;
import com.coinbase.wallet.blockchains.interfaces.UnsignedTx;
import com.coinbase.wallet.blockchains.models.Blockchain;
import com.coinbase.wallet.blockchains.models.TransferValue;
import com.coinbase.wallet.blockchains.models.TxMetadata;
import com.coinbase.wallet.blockchains.models.TxMetadataKey;
import com.coinbase.wallet.blockchains.models.TxSource;
import com.coinbase.wallet.blockchains.models.UnsignedTxResult;
import com.coinbase.wallet.blockchains.models.Wallet;
import com.coinbase.wallet.common.extensions.String_CommonKt;
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
import com.coinbase.wallet.ethereum.exceptions.EthereumException;
import com.coinbase.wallet.ethereum.extensions.Blockchain_EthereumKt;
import com.coinbase.wallet.ethereum.extensions.Network_EthereumKt;
import com.coinbase.wallet.ethereum.extensions.TxMetadataKey_EthereumKt;
import com.coinbase.wallet.ethereum.models.EthereumUnsigned1559Tx;
import com.coinbase.wallet.ethereum.models.EthereumUnsignedLegacyTx;
import com.coinbase.wallet.ethereum.models.EthereumUnsignedTx;
import com.coinbase.wallet.featureflags.models.FeatureFlag;
import com.coinbase.wallet.featureflags.repositories.FeatureFlagsRepository;
import com.coinbase.wallet.features.applock.legacy.AuthenticationHelper;
import com.coinbase.wallet.features.cloudbackup.models.OnboardingBackupRecoveryPhraseArgs;
import com.coinbase.wallet.features.send.models.AdjustableMinerFeeArgs;
import com.coinbase.wallet.features.send.models.AdjustableMinerFeeLegacySelection;
import com.coinbase.wallet.features.send.models.AdjustableMinerFeeSelection;
import com.coinbase.wallet.features.send.models.ConfirmationSettings;
import com.coinbase.wallet.features.send.models.MinerFee1559Data;
import com.coinbase.wallet.features.send.models.Recipient;
import com.coinbase.wallet.features.send.models.SendAmounts;
import com.coinbase.wallet.features.send.models.SendConfirmationArgs;
import com.coinbase.wallet.features.send.models.SendConfirmationResult;
import com.coinbase.wallet.features.send.models.SendConfirmationState;
import com.coinbase.wallet.features.send.prompts.HighMinerFeesPrompt;
import com.coinbase.wallet.features.wallets.extensions.Wallet_ApplicationKt;
import com.coinbase.wallet.features.wallets.extensions.legacy.Wallet_Erc20Kt;
import com.coinbase.wallet.performance.Tracer;
import com.coinbase.wallet.txhistory.models.RecipientType;
import com.coinbase.wallet.wallets.formatters.CurrencyFormatter;
import com.coinbase.wallet.wallets.interfaces.IExchangeRateRepository;
import com.coinbase.wallet.wallets.interfaces.ITxRepository;
import com.coinbase.wallet.wallets.interfaces.IWalletRepository;
import com.coinbase.wallet.wallets.models.ExchangeRate;
import com.toshi.exception.UnableToGenerateUnsignedTransactionException;
import h.c.h0;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import org.toshi.R;

/* compiled from: SendConfirmationViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000æ\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001BE\b\u0007\u0012\u0006\u0010O\u001a\u00020N\u0012\u0006\u0010\\\u001a\u00020[\u0012\u0006\u0010u\u001a\u00020t\u0012\u0006\u0010I\u001a\u00020H\u0012\b\u0010\u008e\u0001\u001a\u00030\u008d\u0001\u0012\u0006\u0010?\u001a\u00020>\u0012\u0006\u0010B\u001a\u00020A¢\u0006\u0006\b\u0093\u0001\u0010\u0094\u0001J'\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0003¢\u0006\u0004\b\t\u0010\nJ\u001d\u0010\u000e\u001a\u00020\b2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u0019\u0010\u0016\u001a\u00020\b2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0018\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u001c\u001a\u00020\u00192\u0006\u0010\u0018\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u001c\u0010\u001bJ\u0019\u0010\u001e\u001a\u00020\b2\b\u0010\u001d\u001a\u0004\u0018\u00010\fH\u0017¢\u0006\u0004\b\u001e\u0010\u001fJ\u0017\u0010 \u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\u0014H\u0007¢\u0006\u0004\b \u0010\u0017R\"\u0010#\u001a\b\u0012\u0004\u0012\u00020\"0!8\u0014@\u0014X\u0094\u0004¢\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&R\u001c\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00140\u000b8V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\b'\u0010(R\u0016\u0010+\u001a\u00020*8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b+\u0010,R\u001d\u00102\u001a\u00020-8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b.\u0010/\u001a\u0004\b0\u00101R\"\u00103\u001a\b\u0012\u0004\u0012\u00020\"0\u000b8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b3\u00104\u001a\u0004\b5\u0010(R\u001d\u00109\u001a\u00020\u00148B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b6\u0010/\u001a\u0004\b7\u00108R\u001d\u0010=\u001a\u00020\u00048T@\u0014X\u0094\u0084\u0002¢\u0006\f\n\u0004\b:\u0010/\u001a\u0004\b;\u0010<R\u0016\u0010?\u001a\u00020>8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b?\u0010@R\u0016\u0010B\u001a\u00020A8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bB\u0010CR\u0016\u0010G\u001a\u00020D8V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\bE\u0010FR\u0016\u0010I\u001a\u00020H8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bI\u0010JR\u0018\u0010L\u001a\u0004\u0018\u00010K8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bL\u0010MR\u001c\u0010O\u001a\u00020N8\u0014@\u0014X\u0094\u0004¢\u0006\f\n\u0004\bO\u0010P\u001a\u0004\bQ\u0010RR\"\u0010T\u001a\b\u0012\u0004\u0012\u00020S0\u000b8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\bT\u00104\u001a\u0004\bU\u0010(R\u001d\u0010Z\u001a\u00020V8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\bW\u0010/\u001a\u0004\bX\u0010YR\u0016\u0010\\\u001a\u00020[8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\\\u0010]R$\u0010_\u001a\u0010\u0012\f\u0012\n ^*\u0004\u0018\u00010\u00060\u00060!8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b_\u0010$R\"\u0010a\u001a\b\u0012\u0004\u0012\u00020`0\u000b8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\ba\u00104\u001a\u0004\bb\u0010(R\"\u0010c\u001a\b\u0012\u0004\u0012\u00020\"0\u000b8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\bc\u00104\u001a\u0004\bd\u0010(R\"\u0010e\u001a\b\u0012\u0004\u0012\u00020\u00060\u000b8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\be\u00104\u001a\u0004\bf\u0010(R\"\u0010i\u001a\b\u0012\u0004\u0012\u00020h0g8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\bi\u0010j\u001a\u0004\bk\u0010lR$\u0010m\u001a\u0010\u0012\f\u0012\n ^*\u0004\u0018\u00010\"0\"0!8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bm\u0010$R\u001c\u0010o\u001a\b\u0012\u0004\u0012\u00020\u00140\u000b8V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\bn\u0010(R\"\u0010p\u001a\u00020\u00148\u0016@\u0016X\u0096.¢\u0006\u0012\n\u0004\bp\u0010q\u001a\u0004\br\u00108\"\u0004\bs\u0010\u0017R\u0016\u0010u\u001a\u00020t8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bu\u0010vR\u001f\u0010{\u001a\u0004\u0018\u00010w8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\bx\u0010/\u001a\u0004\by\u0010zR*\u0010|\u001a\u0010\u0012\f\u0012\n ^*\u0004\u0018\u00010`0`0!8\u0014@\u0014X\u0094\u0004¢\u0006\f\n\u0004\b|\u0010$\u001a\u0004\b}\u0010&R-\u0010\u007f\u001a\u0010\u0012\f\u0012\n ^*\u0004\u0018\u00010\u00140\u00140~8\u0014@\u0014X\u0094\u0004¢\u0006\u000f\n\u0005\b\u007f\u0010\u0080\u0001\u001a\u0006\b\u0081\u0001\u0010\u0082\u0001R'\u0010\u0083\u0001\u001a\u0010\u0012\f\u0012\n ^*\u0004\u0018\u00010\u00140\u00140~8\u0002@\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0083\u0001\u0010\u0080\u0001R\"\u0010\u0088\u0001\u001a\u00030\u0084\u00018B@\u0002X\u0082\u0084\u0002¢\u0006\u000f\n\u0005\b\u0085\u0001\u0010/\u001a\u0006\b\u0086\u0001\u0010\u0087\u0001R&\u0010\u0089\u0001\u001a\u0010\u0012\f\u0012\n ^*\u0004\u0018\u00010S0S0!8\u0002@\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\b\u0089\u0001\u0010$R(\u0010\u008a\u0001\u001a\u0004\u0018\u00010\u00148\u0016@\u0016X\u0096\u000e¢\u0006\u0015\n\u0005\b\u008a\u0001\u0010q\u001a\u0005\b\u008b\u0001\u00108\"\u0005\b\u008c\u0001\u0010\u0017R\u001a\u0010\u008e\u0001\u001a\u00030\u008d\u00018\u0002@\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u008e\u0001\u0010\u008f\u0001R#\u0010\u0091\u0001\u001a\f ^*\u0005\u0018\u00010\u0090\u00010\u0090\u00018\u0002@\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0091\u0001\u0010\u0092\u0001¨\u0006\u0095\u0001"}, d2 = {"Lcom/coinbase/wallet/features/send/viewmodels/SendConfirmationViewModel;", "Lcom/coinbase/wallet/features/send/viewmodels/ConfirmationViewModel;", "Lcom/coinbase/wallet/blockchains/models/UnsignedTxResult;", "txResult", "Lcom/coinbase/wallet/blockchains/models/Wallet;", "feeWallet", "", "forceExpand", "Lkotlin/x;", "handleUnsignedTx", "(Lcom/coinbase/wallet/blockchains/models/UnsignedTxResult;Lcom/coinbase/wallet/blockchains/models/Wallet;Z)V", "Lh/c/s;", "Lcom/coinbase/wallet/features/send/models/AdjustableMinerFeeSelection;", "minerFeeSelectionObservable", "setup", "(Lh/c/s;)V", "isAdjustableMinerFeeEnabled", "()Z", "adjustableMinerFeeClicked", "()V", "", OnboardingBackupRecoveryPhraseArgs.mnemonicKey, "confirmTx", "(Ljava/lang/String;)V", "expanded", "", "detailsTextColor", "(Z)I", "detailsContainerColor", "adjustableMinerFeeSelection", "fetchReceiptInformation", "(Lcom/coinbase/wallet/features/send/models/AdjustableMinerFeeSelection;)V", "confirmSend", "Lh/c/v0/b;", "Lcom/coinbase/wallet/commonui/models/ViewModelNavRoute;", "navigationSubject", "Lh/c/v0/b;", "getNavigationSubject", "()Lh/c/v0/b;", "getMinerFeeExplainerObservable", "()Lh/c/s;", "minerFeeExplainerObservable", "Lh/c/k0/a;", "disposeBag", "Lh/c/k0/a;", "Lcom/coinbase/wallet/blockchains/models/TxMetadata;", "metadata$delegate", "Lkotlin/h;", "getMetadata", "()Lcom/coinbase/wallet/blockchains/models/TxMetadata;", SendConfirmationArgs.metadataKey, "navigateToSendCompleteViewObservable", "Lh/c/s;", "getNavigateToSendCompleteViewObservable", "recipientAddress$delegate", "getRecipientAddress", "()Ljava/lang/String;", SendConfirmationArgs.recipientAddressKey, "wallet$delegate", "getWallet", "()Lcom/coinbase/wallet/blockchains/models/Wallet;", "wallet", "Lcom/coinbase/wallet/featureflags/repositories/FeatureFlagsRepository;", "featureFlagsRepository", "Lcom/coinbase/wallet/featureflags/repositories/FeatureFlagsRepository;", "Lcom/coinbase/wallet/features/send/prompts/HighMinerFeesPrompt;", "highMinerFeesPrompt", "Lcom/coinbase/wallet/features/send/prompts/HighMinerFeesPrompt;", "Lcom/coinbase/wallet/features/send/models/ConfirmationSettings;", "getSettings", "()Lcom/coinbase/wallet/features/send/models/ConfirmationSettings;", "settings", "Lcom/coinbase/wallet/wallets/interfaces/ITxRepository;", "txRepository", "Lcom/coinbase/wallet/wallets/interfaces/ITxRepository;", "Lcom/coinbase/wallet/blockchains/interfaces/UnsignedTx;", "tx", "Lcom/coinbase/wallet/blockchains/interfaces/UnsignedTx;", "Lcom/coinbase/wallet/features/applock/legacy/AuthenticationHelper;", "authenticationHelper", "Lcom/coinbase/wallet/features/applock/legacy/AuthenticationHelper;", "getAuthenticationHelper", "()Lcom/coinbase/wallet/features/applock/legacy/AuthenticationHelper;", "Lcom/coinbase/wallet/features/send/models/SendConfirmationResult;", "sendConfirmationObservable", "getSendConfirmationObservable", "Lcom/coinbase/wallet/features/send/models/Recipient;", "recipient$delegate", "getRecipient", "()Lcom/coinbase/wallet/features/send/models/Recipient;", "recipient", "Lcom/coinbase/wallet/wallets/formatters/CurrencyFormatter;", "currencyFormatter", "Lcom/coinbase/wallet/wallets/formatters/CurrencyFormatter;", "kotlin.jvm.PlatformType", "expandCardSubject", "Lcom/coinbase/wallet/commonui/utilities/PromptDialogHelper$Properties;", "promptObservable", "getPromptObservable", "navigationObservable", "getNavigationObservable", "expandCardObservable", "getExpandCardObservable", "Lh/c/b0;", "Lcom/coinbase/wallet/features/send/models/SendAmounts;", "sendAmounts", "Lh/c/b0;", "getSendAmounts", "()Lh/c/b0;", "navigateToSendCompleteViewSubject", "getAnnualInterestObservable", "annualInterestObservable", "recipientTitle", "Ljava/lang/String;", "getRecipientTitle", "setRecipientTitle", "Lcom/coinbase/wallet/wallets/interfaces/IWalletRepository;", "walletRepository", "Lcom/coinbase/wallet/wallets/interfaces/IWalletRepository;", "Ljava/math/BigInteger;", "txGasLimit$delegate", "getTxGasLimit", "()Ljava/math/BigInteger;", "txGasLimit", "promptSubject", "getPromptSubject", "Lh/c/v0/a;", "minerFeeExplainerSubject", "Lh/c/v0/a;", "getMinerFeeExplainerSubject", "()Lh/c/v0/a;", "annualInterestSubject", "Lcom/coinbase/wallet/blockchains/models/TransferValue;", "amount$delegate", "getAmount", "()Lcom/coinbase/wallet/blockchains/models/TransferValue;", "amount", "sendConfirmationSubject", "recipientSubtitle", "getRecipientSubtitle", "setRecipientSubtitle", "Lcom/coinbase/wallet/wallets/interfaces/IExchangeRateRepository;", "exchangeRateRepository", "Lcom/coinbase/wallet/wallets/interfaces/IExchangeRateRepository;", "Ljava/math/BigDecimal;", "highFeeThreshold", "Ljava/math/BigDecimal;", "<init>", "(Lcom/coinbase/wallet/features/applock/legacy/AuthenticationHelper;Lcom/coinbase/wallet/wallets/formatters/CurrencyFormatter;Lcom/coinbase/wallet/wallets/interfaces/IWalletRepository;Lcom/coinbase/wallet/wallets/interfaces/ITxRepository;Lcom/coinbase/wallet/wallets/interfaces/IExchangeRateRepository;Lcom/coinbase/wallet/featureflags/repositories/FeatureFlagsRepository;Lcom/coinbase/wallet/features/send/prompts/HighMinerFeesPrompt;)V", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class SendConfirmationViewModel extends ConfirmationViewModel {
    private final kotlin.h amount$delegate;
    private final h.c.v0.a<String> annualInterestSubject;
    private final AuthenticationHelper authenticationHelper;
    private final CurrencyFormatter currencyFormatter;
    private final h.c.k0.a disposeBag;
    private final IExchangeRateRepository exchangeRateRepository;
    private final h.c.s<Boolean> expandCardObservable;
    private final h.c.v0.b<Boolean> expandCardSubject;
    private final FeatureFlagsRepository featureFlagsRepository;
    private final BigDecimal highFeeThreshold;
    private final HighMinerFeesPrompt highMinerFeesPrompt;
    private final kotlin.h metadata$delegate;
    private final h.c.v0.a<String> minerFeeExplainerSubject;
    private final h.c.s<ViewModelNavRoute> navigateToSendCompleteViewObservable;
    private final h.c.v0.b<ViewModelNavRoute> navigateToSendCompleteViewSubject;
    private final h.c.s<ViewModelNavRoute> navigationObservable;
    private final h.c.v0.b<ViewModelNavRoute> navigationSubject;
    private final h.c.s<PromptDialogHelper.Properties> promptObservable;
    private final h.c.v0.b<PromptDialogHelper.Properties> promptSubject;
    private final kotlin.h recipient$delegate;
    private final kotlin.h recipientAddress$delegate;
    private String recipientSubtitle;
    public String recipientTitle;
    private final h.c.b0<SendAmounts> sendAmounts;
    private final h.c.s<SendConfirmationResult> sendConfirmationObservable;
    private final h.c.v0.b<SendConfirmationResult> sendConfirmationSubject;
    private UnsignedTx tx;
    private final kotlin.h txGasLimit$delegate;
    private final ITxRepository txRepository;
    private final kotlin.h wallet$delegate;
    private final IWalletRepository walletRepository;

    /* compiled from: SendConfirmationViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[RecipientType.values().length];
            iArr[RecipientType.Address.ordinal()] = 1;
            iArr[RecipientType.Coinbase.ordinal()] = 2;
            iArr[RecipientType.ENS.ordinal()] = 3;
            iArr[RecipientType.User.ordinal()] = 4;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public SendConfirmationViewModel(AuthenticationHelper authenticationHelper, CurrencyFormatter currencyFormatter, IWalletRepository walletRepository, ITxRepository txRepository, IExchangeRateRepository exchangeRateRepository, FeatureFlagsRepository featureFlagsRepository, HighMinerFeesPrompt highMinerFeesPrompt) {
        kotlin.h b2;
        kotlin.h b3;
        kotlin.h b4;
        kotlin.h b5;
        kotlin.h b6;
        kotlin.h b7;
        kotlin.jvm.internal.m.g(authenticationHelper, "authenticationHelper");
        kotlin.jvm.internal.m.g(currencyFormatter, "currencyFormatter");
        kotlin.jvm.internal.m.g(walletRepository, "walletRepository");
        kotlin.jvm.internal.m.g(txRepository, "txRepository");
        kotlin.jvm.internal.m.g(exchangeRateRepository, "exchangeRateRepository");
        kotlin.jvm.internal.m.g(featureFlagsRepository, "featureFlagsRepository");
        kotlin.jvm.internal.m.g(highMinerFeesPrompt, "highMinerFeesPrompt");
        this.authenticationHelper = authenticationHelper;
        this.currencyFormatter = currencyFormatter;
        this.walletRepository = walletRepository;
        this.txRepository = txRepository;
        this.exchangeRateRepository = exchangeRateRepository;
        this.featureFlagsRepository = featureFlagsRepository;
        this.highMinerFeesPrompt = highMinerFeesPrompt;
        Strings strings = Strings.INSTANCE;
        h.c.v0.a<String> e2 = h.c.v0.a.e(Strings_CoreKt.getEllipsis(strings));
        kotlin.jvm.internal.m.f(e2, "createDefault(Strings.ellipsis)");
        this.annualInterestSubject = e2;
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
        this.disposeBag = new h.c.k0.a();
        b2 = kotlin.k.b(new SendConfirmationViewModel$recipient$2(this));
        this.recipient$delegate = b2;
        b3 = kotlin.k.b(new SendConfirmationViewModel$recipientAddress$2(this));
        this.recipientAddress$delegate = b3;
        b4 = kotlin.k.b(new SendConfirmationViewModel$amount$2(this));
        this.amount$delegate = b4;
        b5 = kotlin.k.b(new SendConfirmationViewModel$metadata$2(this));
        this.metadata$delegate = b5;
        b6 = kotlin.k.b(new SendConfirmationViewModel$txGasLimit$2(this));
        this.txGasLimit$delegate = b6;
        b7 = kotlin.k.b(new SendConfirmationViewModel$wallet$2(this));
        this.wallet$delegate = b7;
        h.c.v0.b<PromptDialogHelper.Properties> d5 = h.c.v0.b.d();
        kotlin.jvm.internal.m.f(d5, "create<PromptDialogHelper.Properties>()");
        this.promptSubject = d5;
        h.c.v0.a<String> e3 = h.c.v0.a.e(Strings_CoreKt.getEllipsis(strings));
        kotlin.jvm.internal.m.f(e3, "createDefault(Strings.ellipsis)");
        this.minerFeeExplainerSubject = e3;
        h.c.v0.b<ViewModelNavRoute> d6 = h.c.v0.b.d();
        kotlin.jvm.internal.m.f(d6, "create()");
        this.navigationSubject = d6;
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
        h.c.s<List<ExchangeRate>> filter = exchangeRateRepository.getExchangeRateObservable().filter(new h.c.m0.p() { // from class: com.coinbase.wallet.features.send.viewmodels.r
            @Override // h.c.m0.p
            public final boolean test(Object obj) {
                return SendConfirmationViewModel.e((List) obj);
            }
        });
        kotlin.jvm.internal.m.f(filter, "exchangeRateRepository\n        .exchangeRateObservable\n        .filter { it.isNotEmpty() }");
        h.c.b0<SendAmounts> map = Observable_CoreKt.takeSingle(filter).map(new h.c.m0.n() { // from class: com.coinbase.wallet.features.send.viewmodels.p
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return SendConfirmationViewModel.c(SendConfirmationViewModel.this, (List) obj);
            }
        });
        kotlin.jvm.internal.m.f(map, "exchangeRateRepository\n        .exchangeRateObservable\n        .filter { it.isNotEmpty() }\n        .takeSingle()\n        .map {\n            val transferValue: BigInteger = when (amount) {\n                is TransferValue.Amount -> (amount as TransferValue.Amount).value\n                is TransferValue.EntireBalance -> wallet.maximumAvailableBalance()\n            }\n\n            val formattedFiat = currencyFormatter.formatToFiat(\n                fromCurrencyCode = wallet.currencyCode,\n                contractAddress = wallet.contractAddress,\n                decimals = wallet.decimals,\n                value = transferValue\n            ) ?: Strings.ellipsis\n\n            val formattedCrypto = currencyFormatter.formatToCrypto(\n                currencyCode = wallet.currencyCode,\n                decimals = wallet.decimals,\n                value = transferValue,\n                includeCode = true\n            )\n\n            SendAmounts(formattedFiat, formattedCrypto)\n        }");
        this.sendAmounts = map;
    }

    public static /* synthetic */ h0 a(SendConfirmationViewModel sendConfirmationViewModel, UnsignedTxResult unsignedTxResult) {
        return m1367fetchReceiptInformation$lambda4(sendConfirmationViewModel, unsignedTxResult);
    }

    public static /* synthetic */ kotlin.o b(UnsignedTxResult unsignedTxResult, Optional optional) {
        return m1368fetchReceiptInformation$lambda4$lambda3(unsignedTxResult, optional);
    }

    public static /* synthetic */ SendAmounts c(SendConfirmationViewModel sendConfirmationViewModel, List list) {
        return m1370sendAmounts$lambda1(sendConfirmationViewModel, list);
    }

    public static /* synthetic */ kotlin.x d(SendConfirmationViewModel sendConfirmationViewModel, AdjustableMinerFeeSelection adjustableMinerFeeSelection) {
        return m1371setup$lambda2(sendConfirmationViewModel, adjustableMinerFeeSelection);
    }

    public static /* synthetic */ boolean e(List list) {
        return m1369sendAmounts$lambda0(list);
    }

    /* renamed from: fetchReceiptInformation$lambda-4 */
    public static final h0 m1367fetchReceiptInformation$lambda4(SendConfirmationViewModel this$0, final UnsignedTxResult result) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(result, "result");
        UnsignedTx transaction = result.getTransaction();
        if (transaction != null) {
            if (!(result instanceof UnsignedTxResult.Error)) {
                h.c.s<Optional<Wallet>> observeWallet = WalletRepository_CommonKt.observeWallet(this$0.walletRepository, transaction.getBlockchain(), transaction.getFeeCurrencyCode());
                kotlin.jvm.internal.m.f(observeWallet, "walletRepository.observeWallet(tx.blockchain, tx.feeCurrencyCode)");
                return Observable_CoreKt.takeSingle(observeWallet).map(new h.c.m0.n() { // from class: com.coinbase.wallet.features.send.viewmodels.o
                    @Override // h.c.m0.n
                    public final Object apply(Object obj) {
                        return SendConfirmationViewModel.b(UnsignedTxResult.this, (Optional) obj);
                    }
                });
            }
            throw ((UnsignedTxResult.Error) result).getErr();
        }
        throw new UnableToGenerateUnsignedTransactionException("Unable to generate tx");
    }

    /* renamed from: fetchReceiptInformation$lambda-4$lambda-3 */
    public static final kotlin.o m1368fetchReceiptInformation$lambda4$lambda3(UnsignedTxResult result, Optional it) {
        kotlin.jvm.internal.m.g(result, "$result");
        kotlin.jvm.internal.m.g(it, "it");
        return kotlin.u.a(result, it);
    }

    public final TransferValue getAmount() {
        return (TransferValue) this.amount$delegate.getValue();
    }

    private final TxMetadata getMetadata() {
        return (TxMetadata) this.metadata$delegate.getValue();
    }

    private final Recipient getRecipient() {
        return (Recipient) this.recipient$delegate.getValue();
    }

    public final String getRecipientAddress() {
        return (String) this.recipientAddress$delegate.getValue();
    }

    private final BigInteger getTxGasLimit() {
        return (BigInteger) this.txGasLimit$delegate.getValue();
    }

    @SuppressLint({"CheckResult"})
    public final void handleUnsignedTx(UnsignedTxResult unsignedTxResult, Wallet wallet, boolean z) {
        SendConfirmationResult create;
        UnsignedTx transaction = unsignedTxResult.getTransaction();
        if (transaction == null) {
            return;
        }
        BigInteger transferValue = transaction.getTransferValue();
        if (kotlin.jvm.internal.m.c(wallet.getBlockchain(), getWallet().getBlockchain()) && kotlin.jvm.internal.m.c(wallet.getCurrencyCode(), getWallet().getCurrencyCode())) {
            transferValue = transferValue.add(transaction.getEstimatedFee());
            kotlin.jvm.internal.m.f(transferValue, "this.add(other)");
        }
        boolean z2 = unsignedTxResult instanceof UnsignedTxResult.Error;
        if (z2 && (((UnsignedTxResult.Error) unsignedTxResult).getErr() instanceof TxException.InsufficientBalance)) {
            create = SendConfirmationResult.Companion.create(new SendConfirmationState.InsufficientBalance(LocalizedStrings.INSTANCE.get(R.string.confirmation_error_coin_selection)), transaction, wallet, getWallet(), this.currencyFormatter);
        } else if (transferValue.compareTo(Wallet_ApplicationKt.maximumAvailableBalance(getWallet())) > 0) {
            BigInteger add = transaction.getTransferValue().add(transaction.getEstimatedFee());
            kotlin.jvm.internal.m.f(add, "this.add(other)");
            BigInteger subtract = add.subtract(Wallet_ApplicationKt.maximumAvailableBalance(getWallet()));
            kotlin.jvm.internal.m.f(subtract, "this.subtract(other)");
            create = SendConfirmationResult.Companion.create(new SendConfirmationState.InsufficientBalance(LocalizedStrings.INSTANCE.get(R.string.insufficient_balance_error, getWallet().getCurrencyCode().getRawValue(), CurrencyFormatter.formatToCrypto$default(this.currencyFormatter, transaction.getCurrencyCode(), getWallet().getDecimals(), subtract, false, 0, 0, 56, (Object) null))), transaction, wallet, getWallet(), this.currencyFormatter);
        } else if (transaction.getEstimatedFee().compareTo(Wallet_ApplicationKt.maximumAvailableBalance(wallet)) > 0 && Wallet_Erc20Kt.isErc20(getWallet())) {
            create = SendConfirmationResult.Companion.create(new SendConfirmationState.InsufficientBalance(LocalizedStrings.INSTANCE.get(R.string.insufficient_fee_balance_info_prompt_subtitle)), transaction, wallet, getWallet(), this.currencyFormatter);
        } else if (z2 && (((UnsignedTxResult.Error) unsignedTxResult).getErr() instanceof EthereumException.UnableToEstimateGas)) {
            create = SendConfirmationResult.Companion.create(new SendConfirmationState.FeeCalculationFailed(LocalizedStrings.INSTANCE.get(R.string.send_confirm_calculation_error)), transaction, wallet, getWallet(), this.currencyFormatter);
        } else if (transaction instanceof EthereumUnsignedTx) {
            create = SendConfirmationResult.Companion.create(SendConfirmationState.SufficientBalance.INSTANCE, transaction, wallet, getWallet(), this.currencyFormatter);
        } else {
            create = SendConfirmationResult.Companion.create(SendConfirmationState.SufficientBalance.INSTANCE, transaction, wallet, getWallet(), this.currencyFormatter);
        }
        h.c.t0.g.i(IExchangeRateRepository.DefaultImpls.getCryptoExchangeRate$default(this.exchangeRateRepository, transaction.getFeeCurrencyCode(), null, 0, 6, null), null, new SendConfirmationViewModel$handleUnsignedTx$1(transaction, wallet, this, z), 1, null);
        this.sendConfirmationSubject.onNext(create);
    }

    /* renamed from: sendAmounts$lambda-0 */
    public static final boolean m1369sendAmounts$lambda0(List it) {
        kotlin.jvm.internal.m.g(it, "it");
        return !it.isEmpty();
    }

    /* renamed from: sendAmounts$lambda-1 */
    public static final SendAmounts m1370sendAmounts$lambda1(SendConfirmationViewModel this$0, List it) {
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
            maximumAvailableBalance = Wallet_ApplicationKt.maximumAvailableBalance(this$0.getWallet());
        }
        formatToFiat = this$0.currencyFormatter.formatToFiat(this$0.getWallet().getCurrencyCode(), this$0.getWallet().getContractAddress(), this$0.getWallet().getDecimals(), maximumAvailableBalance, (r17 & 16) != 0 ? false : false, (r17 & 32) != 0 ? null : null, (r17 & 64) != 0 ? null : null);
        if (formatToFiat == null) {
            formatToFiat = Strings_CoreKt.getEllipsis(Strings.INSTANCE);
        }
        return new SendAmounts(formatToFiat, CurrencyFormatter.formatToCrypto$default(this$0.currencyFormatter, this$0.getWallet().getCurrencyCode(), this$0.getWallet().getDecimals(), maximumAvailableBalance, true, 0, 0, 48, (Object) null));
    }

    /* renamed from: setup$lambda-2 */
    public static final kotlin.x m1371setup$lambda2(SendConfirmationViewModel this$0, AdjustableMinerFeeSelection selection) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(selection, "selection");
        this$0.fetchReceiptInformation(selection);
        return kotlin.x.a;
    }

    @Override // com.coinbase.wallet.features.send.viewmodels.ConfirmationViewModel
    public void adjustableMinerFeeClicked() {
        EthereumChain asEthereumChain;
        Bundle createArgs;
        ViewModelNavRoute viewModelNavRoute;
        Bundle createArgs2;
        UnsignedTx unsignedTx = this.tx;
        EthereumUnsignedTx ethereumUnsignedTx = unsignedTx instanceof EthereumUnsignedTx ? (EthereumUnsignedTx) unsignedTx : null;
        if (ethereumUnsignedTx == null || (asEthereumChain = Network_EthereumKt.getAsEthereumChain(ethereumUnsignedTx.getNetwork())) == null) {
            return;
        }
        Analytics.INSTANCE.log(AnalyticsEvent_ApplicationKt.adjustableMinerFeeButtonTapped(AnalyticsEvent.Companion, "Send", ethereumUnsignedTx.getCurrencyCode(), ethereumUnsignedTx.getNetwork()));
        if (ethereumUnsignedTx instanceof EthereumUnsignedLegacyTx) {
            createArgs2 = AdjustableMinerFeeArgs.INSTANCE.createArgs("Send", ethereumUnsignedTx.getGasLimit(), ethereumUnsignedTx.getFromAddress(), asEthereumChain, (r16 & 16) != 0 ? null : null, (r16 & 32) != 0 ? null : ethereumUnsignedTx.getNonce());
            viewModelNavRoute = new ViewModelNavRoute(R.id.action_confirmationFragment_to_adjustableMinerFeeFragment, createArgs2, null, 4, null);
        } else if (ethereumUnsignedTx instanceof EthereumUnsigned1559Tx) {
            createArgs = AdjustableMinerFeeArgs.INSTANCE.createArgs("Send", ethereumUnsignedTx.getGasLimit(), ethereumUnsignedTx.getFromAddress(), asEthereumChain, (r16 & 16) != 0 ? null : null, (r16 & 32) != 0 ? null : ethereumUnsignedTx.getNonce());
            viewModelNavRoute = new ViewModelNavRoute(R.id.action_confirmationFragment_to_adjustableMinerFee1559Fragment, createArgs, null, 4, null);
        } else {
            throw new NoWhenBranchMatchedException();
        }
        getNavigationSubject().onNext(viewModelNavRoute);
    }

    @SuppressLint({"CheckResult"})
    public final void confirmSend(String mnemonic) {
        kotlin.jvm.internal.m.g(mnemonic, "mnemonic");
        UnsignedTx unsignedTx = this.tx;
        if (unsignedTx == null) {
            return;
        }
        h.c.b0 observeOn = Single_CoreKt.trace(this.txRepository.signAndSubmit(unsignedTx, mnemonic, true), TraceKey_ApplicationKt.getConfirmSendKey(TraceKey.Companion), Tracer.INSTANCE).observeOn(h.c.j0.c.a.b());
        kotlin.jvm.internal.m.f(observeOn, "txRepository.signAndSubmit(tx, mnemonic, true)\n            .trace(TraceKey.confirmSendKey, Tracer)\n            .observeOn(AndroidSchedulers.mainThread())");
        h.c.t0.g.f(observeOn, new SendConfirmationViewModel$confirmSend$1(unsignedTx, this), new SendConfirmationViewModel$confirmSend$2(this, unsignedTx));
    }

    @Override // com.coinbase.wallet.features.send.viewmodels.ConfirmationViewModel
    public void confirmTx(String str) {
        if (str == null) {
            return;
        }
        confirmSend(str);
    }

    @Override // com.coinbase.wallet.features.send.viewmodels.ConfirmationViewModel
    public int detailsContainerColor(boolean z) {
        return z ? R.color.primary_blue : R.color.white;
    }

    @Override // com.coinbase.wallet.features.send.viewmodels.ConfirmationViewModel
    public int detailsTextColor(boolean z) {
        return z ? R.color.grey_30 : R.color.white;
    }

    @Override // com.coinbase.wallet.features.send.viewmodels.ConfirmationViewModel
    @SuppressLint({"CheckResult"})
    public void fetchReceiptInformation(AdjustableMinerFeeSelection adjustableMinerFeeSelection) {
        h.c.b0<UnsignedTxResult> generateUnsignedTx;
        Map<TxMetadataKey, ? extends Object> mutableMap = getMetadata().toMutableMap();
        mutableMap.put(TxMetadataKey_EthereumKt.getTxSource(TxMetadataKey.Companion), TxSource.Send.getValue());
        EthereumChain asEthereumChain = Network_EthereumKt.getAsEthereumChain(getWallet().getNetwork());
        boolean z = false;
        if (asEthereumChain != null && asEthereumChain.is1559Enabled()) {
            z = true;
        }
        if (z) {
            MinerFee1559Data minerFee1559Data = adjustableMinerFeeSelection instanceof MinerFee1559Data ? (MinerFee1559Data) adjustableMinerFeeSelection : null;
            generateUnsignedTx = this.txRepository.generateUnsigned1559Tx(getWallet(), getAmount(), getRecipientAddress(), mutableMap, minerFee1559Data == null ? null : minerFee1559Data.getMaxFeePerGas(), minerFee1559Data == null ? null : minerFee1559Data.getBaseFeePerGas(), minerFee1559Data == null ? null : minerFee1559Data.getMaxPriorityFee(), minerFee1559Data == null ? null : minerFee1559Data.getGasLimit(), minerFee1559Data == null ? null : minerFee1559Data.getNonce());
        } else {
            AdjustableMinerFeeLegacySelection adjustableMinerFeeLegacySelection = adjustableMinerFeeSelection instanceof AdjustableMinerFeeLegacySelection ? (AdjustableMinerFeeLegacySelection) adjustableMinerFeeSelection : null;
            generateUnsignedTx = this.txRepository.generateUnsignedTx(getWallet(), getAmount(), getRecipientAddress(), mutableMap, adjustableMinerFeeLegacySelection == null ? null : adjustableMinerFeeLegacySelection.getGasPrice(), adjustableMinerFeeLegacySelection == null ? null : adjustableMinerFeeLegacySelection.getGasLimit(), adjustableMinerFeeLegacySelection == null ? null : adjustableMinerFeeLegacySelection.getNonce());
        }
        h.c.b0<R> flatMap = generateUnsignedTx.flatMap(new h.c.m0.n() { // from class: com.coinbase.wallet.features.send.viewmodels.n
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return SendConfirmationViewModel.a(SendConfirmationViewModel.this, (UnsignedTxResult) obj);
            }
        });
        kotlin.jvm.internal.m.f(flatMap, "unsignedTxSingle.flatMap { result ->\n            val tx = result.transaction\n                ?: throw UnableToGenerateUnsignedTransactionException(\"Unable to generate tx\")\n\n            if (result is UnsignedTxResult.Error) throw result.err\n\n            walletRepository.observeWallet(tx.blockchain, tx.feeCurrencyCode)\n                .takeSingle()\n                .map { result to it }\n        }");
        h.c.t0.g.f(Single_AnalyticsKt.logError$default(Single_CoreKt.retryIfNeeded(flatMap, 3, SendConfirmationViewModel$fetchReceiptInformation$2.INSTANCE), null, null, 3, null), new SendConfirmationViewModel$fetchReceiptInformation$3(this), new SendConfirmationViewModel$fetchReceiptInformation$4(this, adjustableMinerFeeSelection));
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
        LocalizedStrings localizedStrings = LocalizedStrings.INSTANCE;
        return new ConfirmationSettings(localizedStrings.get(R.string.send_confirm_title), false, true, R.color.white, R.color.white, R.color.white, localizedStrings.get(R.string.send_confirm_to), new kotlin.o(null, Integer.valueOf((int) R.drawable.ic_wallet_send)), R.color.primary_blue, localizedStrings.get(R.string.send_confirm_button), R.drawable.button_primary);
    }

    @Override // com.coinbase.wallet.features.send.viewmodels.ConfirmationViewModel
    public Wallet getWallet() {
        return (Wallet) this.wallet$delegate.getValue();
    }

    @Override // com.coinbase.wallet.features.send.viewmodels.ConfirmationViewModel
    public boolean isAdjustableMinerFeeEnabled() {
        return this.featureFlagsRepository.valueSync(FeatureFlag.ADJUSTABLE_MINER_FEE) && kotlin.jvm.internal.m.c(getWallet().getBlockchain(), Blockchain_EthereumKt.getETHEREUM(Blockchain.Companion)) && (this.tx instanceof EthereumUnsignedTx);
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
        h.c.s<R> map = minerFeeSelectionObservable.map(new h.c.m0.n() { // from class: com.coinbase.wallet.features.send.viewmodels.q
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return SendConfirmationViewModel.d(SendConfirmationViewModel.this, (AdjustableMinerFeeSelection) obj);
            }
        });
        kotlin.jvm.internal.m.f(map, "minerFeeSelectionObservable\n            .map { selection ->\n                fetchReceiptInformation(selection)\n            }");
        h.c.t0.a.a(h.c.t0.g.h(map, null, null, SendConfirmationViewModel$setup$2.INSTANCE, 3, null), this.disposeBag);
        int i2 = WhenMappings.$EnumSwitchMapping$0[getRecipient().getRecipientType().ordinal()];
        if (i2 == 1) {
            setRecipientTitle(String_CommonKt.truncateMiddle$default(getRecipientAddress(), 6, 4, null, 4, null));
            setRecipientSubtitle(null);
        } else if (i2 == 2 || i2 == 3) {
            setRecipientTitle(getRecipient().getDestination());
            setRecipientSubtitle(String_CommonKt.truncateMiddle$default(getRecipientAddress(), 6, 4, null, 4, null));
        } else if (i2 == 4) {
            setRecipientTitle(kotlin.jvm.internal.m.o(Strings_CoreKt.getAt(Strings.INSTANCE), getRecipient().getDestination()));
            setRecipientSubtitle(String_CommonKt.truncateMiddle$default(getRecipientAddress(), 6, 4, null, 4, null));
        }
        Analytics.INSTANCE.log(AnalyticsEvent_ApplicationKt.sendConfirmLanded(AnalyticsEvent.Companion, getAmount().isMax()));
    }
}