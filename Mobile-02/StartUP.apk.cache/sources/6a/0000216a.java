package com.coinbase.wallet.features.signer.viewmodel;

import android.os.Bundle;
import com.appsflyer.internal.referrer.Payload;
import com.coinbase.ciphercore.ethereum.EthereumChain;
import com.coinbase.wallet.analytics.Analytics;
import com.coinbase.wallet.analytics.extensions.Single_AnalyticsKt;
import com.coinbase.wallet.analytics.models.AnalyticsEvent;
import com.coinbase.wallet.application.extensions.AnalyticsEvent_ApplicationKt;
import com.coinbase.wallet.authentication.AppLockType;
import com.coinbase.wallet.authentication.AuthenticationResult;
import com.coinbase.wallet.blockchains.interfaces.SignedTx;
import com.coinbase.wallet.blockchains.interfaces.UnsignedTx;
import com.coinbase.wallet.blockchains.models.Blockchain;
import com.coinbase.wallet.blockchains.models.CurrencyCode;
import com.coinbase.wallet.blockchains.models.Network;
import com.coinbase.wallet.blockchains.models.UnsignedTxResult;
import com.coinbase.wallet.blockchains.models.Wallet;
import com.coinbase.wallet.common.utilities.LocalizedStrings;
import com.coinbase.wallet.commonui.models.ActionStyle;
import com.coinbase.wallet.commonui.utilities.PromptDialogHelper;
import com.coinbase.wallet.core.extensions.Single_CoreKt;
import com.coinbase.wallet.core.extensions.String_CoreKt;
import com.coinbase.wallet.ethereum.apis.MinerFeeAPI;
import com.coinbase.wallet.ethereum.extensions.Blockchain_EthereumKt;
import com.coinbase.wallet.ethereum.extensions.CurrencyCode_EthereumKt;
import com.coinbase.wallet.ethereum.extensions.Network_EthereumKt;
import com.coinbase.wallet.ethereum.extensions.WalletConfiguration_EthereumKt;
import com.coinbase.wallet.ethereum.interfaces.IETHTxRepository;
import com.coinbase.wallet.ethereum.models.EthereumBasedConfiguration;
import com.coinbase.wallet.ethereum.models.EthereumSignedTx;
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
import com.coinbase.wallet.features.send.models.MinerFee1559Data;
import com.coinbase.wallet.features.send.models.SendBalances;
import com.coinbase.wallet.features.send.models.SendConfirmationResult;
import com.coinbase.wallet.features.send.models.SendConfirmationState;
import com.coinbase.wallet.features.send.prompts.HighMinerFeesPrompt;
import com.coinbase.wallet.features.send.views.AdjustableMinerFee1559Fragment;
import com.coinbase.wallet.features.send.views.AdjustableMinerFeeFragment;
import com.coinbase.wallet.features.signer.interfaces.StackedRequestItem;
import com.coinbase.wallet.features.signer.models.SigningSessionEvent;
import com.coinbase.wallet.features.signer.viewmodel.SignatureRequestViewState;
import com.coinbase.wallet.features.walletlink.repositories.WalletLinkRepository;
import com.coinbase.wallet.features.wallets.extensions.Wallet_ApplicationKt;
import com.coinbase.wallet.routing.models.RouteActionKey;
import com.coinbase.wallet.store.interfaces.StoreInterface;
import com.coinbase.wallet.store.models.StoreKeys;
import com.coinbase.wallet.wallets.extensions.StoreKeys_WalletsKt;
import com.coinbase.wallet.wallets.formatters.CurrencyFormatter;
import com.coinbase.wallet.wallets.interfaces.IExchangeRateRepository;
import com.coinbase.wallet.wallets.interfaces.ITxRepository;
import com.coinbase.wallet.wallets.interfaces.IWalletRepository;
import com.coinbase.walletlink.models.HostRequestId;
import com.toshi.exception.SignatureOnlyNotSupported;
import h.c.b0;
import h.c.h0;
import java.math.BigInteger;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.x;
import org.spongycastle.asn1.cmp.PKIFailureInfo;
import org.toshi.R;

/* compiled from: TxSignerViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000ð\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001Ba\b\u0007\u0012\u0006\u0010M\u001a\u00020L\u0012\u0006\u0010v\u001a\u00020u\u0012\u0006\u0010{\u001a\u00020z\u0012\u0006\u00104\u001a\u000203\u0012\u0006\u0010=\u001a\u00020<\u0012\u0006\u0010f\u001a\u00020e\u0012\u0006\u0010m\u001a\u00020l\u0012\u0006\u0010&\u001a\u00020%\u0012\u0006\u0010P\u001a\u00020O\u0012\u0006\u0010i\u001a\u00020h\u0012\u0006\u0010S\u001a\u00020R¢\u0006\u0004\b}\u0010~J\u001f\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\b\u0010\tJ\u001f\u0010\n\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\n\u0010\tJ\u001f\u0010\u000b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u000b\u0010\tJ\u001f\u0010\u000f\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u001f\u0010\u0011\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b\u0011\u0010\u0010J\r\u0010\u0012\u001a\u00020\u0007¢\u0006\u0004\b\u0012\u0010\u0013J\r\u0010\u0014\u001a\u00020\u0007¢\u0006\u0004\b\u0014\u0010\u0013J\r\u0010\u0015\u001a\u00020\u0007¢\u0006\u0004\b\u0015\u0010\u0013J\r\u0010\u0017\u001a\u00020\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u0019\u001a\u00020\u0007H\u0014¢\u0006\u0004\b\u0019\u0010\u0013J\r\u0010\u001a\u001a\u00020\u0007¢\u0006\u0004\b\u001a\u0010\u0013J\u0015\u0010\u001d\u001a\u00020\u00072\u0006\u0010\u001c\u001a\u00020\u001b¢\u0006\u0004\b\u001d\u0010\u001eR\"\u0010\u001f\u001a\u00020\u00028\u0016@\u0016X\u0096.¢\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u0016\u0010&\u001a\u00020%8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b&\u0010'R$\u0010+\u001a\u0010\u0012\f\u0012\n **\u0004\u0018\u00010)0)0(8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b+\u0010,R\u001f\u00102\u001a\u0004\u0018\u00010-8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b.\u0010/\u001a\u0004\b0\u00101R\u0016\u00104\u001a\u0002038\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b4\u00105R#\u0010;\u001a\b\u0012\u0004\u0012\u000207068B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b8\u0010/\u001a\u0004\b9\u0010:R\u0016\u0010=\u001a\u00020<8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b=\u0010>R\u0016\u0010@\u001a\u00020?8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b@\u0010AR\u001f\u0010C\u001a\b\u0012\u0004\u0012\u00020)0B8\u0006@\u0006¢\u0006\f\n\u0004\bC\u0010D\u001a\u0004\bE\u0010FR$\u0010H\u001a\u0010\u0012\f\u0012\n **\u0004\u0018\u00010G0G0(8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bH\u0010,R\u001f\u0010K\u001a\u0004\u0018\u00010-8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\bI\u0010/\u001a\u0004\bJ\u00101R\u0016\u0010M\u001a\u00020L8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bM\u0010NR\u0016\u0010P\u001a\u00020O8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bP\u0010QR\u0016\u0010S\u001a\u00020R8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bS\u0010TR#\u0010X\u001a\b\u0012\u0004\u0012\u00020U0B8F@\u0006X\u0086\u0084\u0002¢\u0006\f\n\u0004\bV\u0010/\u001a\u0004\bW\u0010FR\u001f\u0010]\u001a\u0004\u0018\u00010Y8F@\u0006X\u0086\u0084\u0002¢\u0006\f\n\u0004\bZ\u0010/\u001a\u0004\b[\u0010\\R\u0016\u0010a\u001a\u00020^8B@\u0002X\u0082\u0004¢\u0006\u0006\u001a\u0004\b_\u0010`R\u0013\u0010c\u001a\u00020b8F@\u0006¢\u0006\u0006\u001a\u0004\bc\u0010dR\u0016\u0010f\u001a\u00020e8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bf\u0010gR\u0016\u0010i\u001a\u00020h8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bi\u0010jR$\u0010k\u001a\u0010\u0012\f\u0012\n **\u0004\u0018\u00010U0U0(8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bk\u0010,R\u0016\u0010m\u001a\u00020l8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bm\u0010nR\u0018\u0010\f\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\f\u0010oR\u0016\u0010s\u001a\u00020p8B@\u0002X\u0082\u0004¢\u0006\u0006\u001a\u0004\bq\u0010rR\u0013\u0010t\u001a\u00020b8F@\u0006¢\u0006\u0006\u001a\u0004\bt\u0010dR\u0016\u0010v\u001a\u00020u8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bv\u0010wR\u001f\u0010x\u001a\b\u0012\u0004\u0012\u00020G0B8\u0006@\u0006¢\u0006\f\n\u0004\bx\u0010D\u001a\u0004\by\u0010FR\u0016\u0010{\u001a\u00020z8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b{\u0010|¨\u0006\u007f"}, d2 = {"Lcom/coinbase/wallet/features/signer/viewmodel/TxSignerViewModel;", "Lcom/coinbase/wallet/features/signer/interfaces/StackedRequestItem;", "Lcom/coinbase/wallet/features/signer/viewmodel/SignatureRequestViewState$SignAndSubmitTxViewState;", "Lcom/coinbase/wallet/blockchains/interfaces/UnsignedTx;", "unsignedTx", "", OnboardingBackupRecoveryPhraseArgs.mnemonicKey, "Lkotlin/x;", "confirm", "(Lcom/coinbase/wallet/blockchains/interfaces/UnsignedTx;Ljava/lang/String;)V", "sign", "signAndSubmit", "tx", "Lcom/coinbase/wallet/blockchains/models/Wallet;", "feeWallet", "handleUnsignedTx", "(Lcom/coinbase/wallet/blockchains/interfaces/UnsignedTx;Lcom/coinbase/wallet/blockchains/models/Wallet;)V", "handleFees", "approve", "()V", "reject", "presentMinerFee", "Lh/c/k0/b;", "fetchReceiptInformation", "()Lh/c/k0/b;", "onCleared", "adjustableMinerFeeClicked", "Lcom/coinbase/wallet/features/send/models/AdjustableMinerFeeSelection;", "adjustableMinerFeeSelection", "handleAdjustableMinerFeeResult", "(Lcom/coinbase/wallet/features/send/models/AdjustableMinerFeeSelection;)V", "viewState", "Lcom/coinbase/wallet/features/signer/viewmodel/SignatureRequestViewState$SignAndSubmitTxViewState;", "getViewState", "()Lcom/coinbase/wallet/features/signer/viewmodel/SignatureRequestViewState$SignAndSubmitTxViewState;", "setViewState", "(Lcom/coinbase/wallet/features/signer/viewmodel/SignatureRequestViewState$SignAndSubmitTxViewState;)V", "Lcom/coinbase/wallet/wallets/interfaces/IExchangeRateRepository;", "exchangeRateRepository", "Lcom/coinbase/wallet/wallets/interfaces/IExchangeRateRepository;", "Lh/c/v0/b;", "Landroidx/fragment/app/c;", "kotlin.jvm.PlatformType", "navigationSubject", "Lh/c/v0/b;", "Ljava/math/BigInteger;", "txLimit$delegate", "Lkotlin/h;", "getTxLimit", "()Ljava/math/BigInteger;", "txLimit", "Lcom/coinbase/wallet/wallets/interfaces/ITxRepository;", "txRepository", "Lcom/coinbase/wallet/wallets/interfaces/ITxRepository;", "Lh/c/b0;", "Lcom/coinbase/wallet/blockchains/models/UnsignedTxResult;", "transactionSingle$delegate", "getTransactionSingle", "()Lh/c/b0;", "transactionSingle", "Lcom/coinbase/wallet/ethereum/interfaces/IETHTxRepository;", "ethereumTxRepository", "Lcom/coinbase/wallet/ethereum/interfaces/IETHTxRepository;", "Lh/c/k0/a;", "disposeBag", "Lh/c/k0/a;", "Lh/c/s;", "navigationObservable", "Lh/c/s;", "getNavigationObservable", "()Lh/c/s;", "Lcom/coinbase/wallet/commonui/utilities/PromptDialogHelper$Properties;", "promptSubject", "txGasPrice$delegate", "getTxGasPrice", "txGasPrice", "Lcom/coinbase/wallet/wallets/formatters/CurrencyFormatter;", "currencyFormatter", "Lcom/coinbase/wallet/wallets/formatters/CurrencyFormatter;", "Lcom/coinbase/wallet/features/applock/legacy/AuthenticationHelper;", "authenticationHelper", "Lcom/coinbase/wallet/features/applock/legacy/AuthenticationHelper;", "Lcom/coinbase/wallet/store/interfaces/StoreInterface;", Payload.TYPE_STORE, "Lcom/coinbase/wallet/store/interfaces/StoreInterface;", "Lcom/coinbase/wallet/features/send/models/SendConfirmationResult;", "signConfirmationObservable$delegate", "getSignConfirmationObservable", "signConfirmationObservable", "Ljava/net/URL;", "imageUrl$delegate", "getImageUrl", "()Ljava/net/URL;", "imageUrl", "", "getChainId", "()I", RouteActionKey.RouteActionKeys.CHAIN_ID, "", "isAdjustableMinerFeeEnabled", "()Z", "Lcom/coinbase/wallet/features/walletlink/repositories/WalletLinkRepository;", "walletLinkRepository", "Lcom/coinbase/wallet/features/walletlink/repositories/WalletLinkRepository;", "Lcom/coinbase/wallet/ethereum/apis/MinerFeeAPI;", "minerFeeAPI", "Lcom/coinbase/wallet/ethereum/apis/MinerFeeAPI;", "signConfirmationSubject", "Lcom/coinbase/wallet/featureflags/repositories/FeatureFlagsRepository;", "featureFlagsRepository", "Lcom/coinbase/wallet/featureflags/repositories/FeatureFlagsRepository;", "Lcom/coinbase/wallet/blockchains/interfaces/UnsignedTx;", "Lcom/coinbase/wallet/features/send/models/SendBalances;", "getSendAmounts", "()Lcom/coinbase/wallet/features/send/models/SendBalances;", "sendAmounts", "isAmountZero", "Lcom/coinbase/wallet/features/send/prompts/HighMinerFeesPrompt;", "highMinerFeesPrompt", "Lcom/coinbase/wallet/features/send/prompts/HighMinerFeesPrompt;", "promptObservable", "getPromptObservable", "Lcom/coinbase/wallet/wallets/interfaces/IWalletRepository;", "walletRepository", "Lcom/coinbase/wallet/wallets/interfaces/IWalletRepository;", "<init>", "(Lcom/coinbase/wallet/wallets/formatters/CurrencyFormatter;Lcom/coinbase/wallet/features/send/prompts/HighMinerFeesPrompt;Lcom/coinbase/wallet/wallets/interfaces/IWalletRepository;Lcom/coinbase/wallet/wallets/interfaces/ITxRepository;Lcom/coinbase/wallet/ethereum/interfaces/IETHTxRepository;Lcom/coinbase/wallet/features/walletlink/repositories/WalletLinkRepository;Lcom/coinbase/wallet/featureflags/repositories/FeatureFlagsRepository;Lcom/coinbase/wallet/wallets/interfaces/IExchangeRateRepository;Lcom/coinbase/wallet/features/applock/legacy/AuthenticationHelper;Lcom/coinbase/wallet/ethereum/apis/MinerFeeAPI;Lcom/coinbase/wallet/store/interfaces/StoreInterface;)V", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class TxSignerViewModel extends StackedRequestItem<SignatureRequestViewState.SignAndSubmitTxViewState> {
    private final AuthenticationHelper authenticationHelper;
    private final CurrencyFormatter currencyFormatter;
    private final h.c.k0.a disposeBag;
    private final IETHTxRepository ethereumTxRepository;
    private final IExchangeRateRepository exchangeRateRepository;
    private final FeatureFlagsRepository featureFlagsRepository;
    private final HighMinerFeesPrompt highMinerFeesPrompt;
    private final kotlin.h imageUrl$delegate;
    private final MinerFeeAPI minerFeeAPI;
    private final h.c.s<androidx.fragment.app.c> navigationObservable;
    private final h.c.v0.b<androidx.fragment.app.c> navigationSubject;
    private final h.c.s<PromptDialogHelper.Properties> promptObservable;
    private final h.c.v0.b<PromptDialogHelper.Properties> promptSubject;
    private final kotlin.h signConfirmationObservable$delegate;
    private final h.c.v0.b<SendConfirmationResult> signConfirmationSubject;
    private final StoreInterface store;
    private final kotlin.h transactionSingle$delegate;
    private UnsignedTx tx;
    private final kotlin.h txGasPrice$delegate;
    private final kotlin.h txLimit$delegate;
    private final ITxRepository txRepository;
    public SignatureRequestViewState.SignAndSubmitTxViewState viewState;
    private final WalletLinkRepository walletLinkRepository;
    private final IWalletRepository walletRepository;

    public TxSignerViewModel(CurrencyFormatter currencyFormatter, HighMinerFeesPrompt highMinerFeesPrompt, IWalletRepository walletRepository, ITxRepository txRepository, IETHTxRepository ethereumTxRepository, WalletLinkRepository walletLinkRepository, FeatureFlagsRepository featureFlagsRepository, IExchangeRateRepository exchangeRateRepository, AuthenticationHelper authenticationHelper, MinerFeeAPI minerFeeAPI, StoreInterface store) {
        kotlin.h b2;
        kotlin.h b3;
        kotlin.h b4;
        kotlin.h b5;
        kotlin.h b6;
        kotlin.jvm.internal.m.g(currencyFormatter, "currencyFormatter");
        kotlin.jvm.internal.m.g(highMinerFeesPrompt, "highMinerFeesPrompt");
        kotlin.jvm.internal.m.g(walletRepository, "walletRepository");
        kotlin.jvm.internal.m.g(txRepository, "txRepository");
        kotlin.jvm.internal.m.g(ethereumTxRepository, "ethereumTxRepository");
        kotlin.jvm.internal.m.g(walletLinkRepository, "walletLinkRepository");
        kotlin.jvm.internal.m.g(featureFlagsRepository, "featureFlagsRepository");
        kotlin.jvm.internal.m.g(exchangeRateRepository, "exchangeRateRepository");
        kotlin.jvm.internal.m.g(authenticationHelper, "authenticationHelper");
        kotlin.jvm.internal.m.g(minerFeeAPI, "minerFeeAPI");
        kotlin.jvm.internal.m.g(store, "store");
        this.currencyFormatter = currencyFormatter;
        this.highMinerFeesPrompt = highMinerFeesPrompt;
        this.walletRepository = walletRepository;
        this.txRepository = txRepository;
        this.ethereumTxRepository = ethereumTxRepository;
        this.walletLinkRepository = walletLinkRepository;
        this.featureFlagsRepository = featureFlagsRepository;
        this.exchangeRateRepository = exchangeRateRepository;
        this.authenticationHelper = authenticationHelper;
        this.minerFeeAPI = minerFeeAPI;
        this.store = store;
        h.c.v0.b<PromptDialogHelper.Properties> d2 = h.c.v0.b.d();
        kotlin.jvm.internal.m.f(d2, "create<PromptDialogHelper.Properties>()");
        this.promptSubject = d2;
        h.c.v0.b<SendConfirmationResult> d3 = h.c.v0.b.d();
        kotlin.jvm.internal.m.f(d3, "create<SendConfirmationResult>()");
        this.signConfirmationSubject = d3;
        h.c.v0.b<androidx.fragment.app.c> d4 = h.c.v0.b.d();
        kotlin.jvm.internal.m.f(d4, "create<DialogFragment>()");
        this.navigationSubject = d4;
        this.disposeBag = new h.c.k0.a();
        b2 = kotlin.k.b(new TxSignerViewModel$transactionSingle$2(this));
        this.transactionSingle$delegate = b2;
        b3 = kotlin.k.b(new TxSignerViewModel$txGasPrice$2(this));
        this.txGasPrice$delegate = b3;
        b4 = kotlin.k.b(new TxSignerViewModel$txLimit$2(this));
        this.txLimit$delegate = b4;
        b5 = kotlin.k.b(new TxSignerViewModel$signConfirmationObservable$2(this));
        this.signConfirmationObservable$delegate = b5;
        h.c.s<PromptDialogHelper.Properties> hide = d2.hide();
        kotlin.jvm.internal.m.f(hide, "promptSubject.hide()");
        this.promptObservable = hide;
        h.c.s<androidx.fragment.app.c> hide2 = d4.hide();
        kotlin.jvm.internal.m.f(hide2, "navigationSubject.hide()");
        this.navigationObservable = hide2;
        b6 = kotlin.k.b(new TxSignerViewModel$imageUrl$2(this));
        this.imageUrl$delegate = b6;
    }

    public static /* synthetic */ Wallet a(UnsignedTxResult.Success success, List list) {
        return m1439fetchReceiptInformation$lambda3$lambda1(success, list);
    }

    public static /* synthetic */ x b(EthereumUnsignedTx ethereumUnsignedTx, AdjustableMinerFeeSelection adjustableMinerFeeSelection, TxSignerViewModel txSignerViewModel, Wallet wallet) {
        return m1442handleAdjustableMinerFeeResult$lambda12(ethereumUnsignedTx, adjustableMinerFeeSelection, txSignerViewModel, wallet);
    }

    public static /* synthetic */ EthereumSignedTx c(EthereumSignedTx ethereumSignedTx, x xVar) {
        return m1444sign$lambda5$lambda4(ethereumSignedTx, xVar);
    }

    public final void confirm(UnsignedTx unsignedTx, String str) {
        if (getViewState().getShouldSubmit()) {
            signAndSubmit(unsignedTx, str);
        } else {
            sign(unsignedTx, str);
        }
    }

    public static /* synthetic */ SignedTx d(SignedTx signedTx, x xVar) {
        return m1446signAndSubmit$lambda7$lambda6(signedTx, xVar);
    }

    public static /* synthetic */ h0 e(TxSignerViewModel txSignerViewModel, SignedTx signedTx) {
        return m1445signAndSubmit$lambda7(txSignerViewModel, signedTx);
    }

    public static /* synthetic */ kotlin.o f(UnsignedTxResult.Success success, Wallet wallet) {
        return m1440fetchReceiptInformation$lambda3$lambda2(success, wallet);
    }

    /* renamed from: fetchReceiptInformation$lambda-3 */
    public static final h0 m1438fetchReceiptInformation$lambda3(TxSignerViewModel this$0, UnsignedTxResult result) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(result, "result");
        if (!(result instanceof UnsignedTxResult.Error)) {
            final UnsignedTxResult.Success success = (UnsignedTxResult.Success) result;
            return this$0.walletRepository.getAllActiveEthWallets().map(new h.c.m0.n() { // from class: com.coinbase.wallet.features.signer.viewmodel.n
                @Override // h.c.m0.n
                public final Object apply(Object obj) {
                    return TxSignerViewModel.a(UnsignedTxResult.Success.this, (List) obj);
                }
            }).map(new h.c.m0.n() { // from class: com.coinbase.wallet.features.signer.viewmodel.s
                @Override // h.c.m0.n
                public final Object apply(Object obj) {
                    return TxSignerViewModel.f(UnsignedTxResult.Success.this, (Wallet) obj);
                }
            });
        }
        throw ((UnsignedTxResult.Error) result).getErr();
    }

    /* renamed from: fetchReceiptInformation$lambda-3$lambda-1 */
    public static final Wallet m1439fetchReceiptInformation$lambda3$lambda1(UnsignedTxResult.Success successResult, List wallets) {
        boolean z;
        kotlin.jvm.internal.m.g(successResult, "$successResult");
        kotlin.jvm.internal.m.g(wallets, "wallets");
        Iterator it = wallets.iterator();
        while (it.hasNext()) {
            Wallet wallet = (Wallet) it.next();
            if (kotlin.jvm.internal.m.c(wallet.getCurrencyCode(), successResult.getTx().getFeeCurrencyCode()) && kotlin.jvm.internal.m.c(successResult.getTx().getNetwork(), wallet.getNetwork())) {
                z = true;
                continue;
            } else {
                z = false;
                continue;
            }
            if (z) {
                return wallet;
            }
        }
        throw new NoSuchElementException("Collection contains no element matching the predicate.");
    }

    /* renamed from: fetchReceiptInformation$lambda-3$lambda-2 */
    public static final kotlin.o m1440fetchReceiptInformation$lambda3$lambda2(UnsignedTxResult.Success successResult, Wallet it) {
        kotlin.jvm.internal.m.g(successResult, "$successResult");
        kotlin.jvm.internal.m.g(it, "it");
        return new kotlin.o(successResult, it);
    }

    public static /* synthetic */ h0 g(TxSignerViewModel txSignerViewModel, EthereumSignedTx ethereumSignedTx) {
        return m1443sign$lambda5(txSignerViewModel, ethereumSignedTx);
    }

    public final int getChainId() {
        EthereumChain asEthereumChain;
        Network network = (Network) this.store.get(StoreKeys_WalletsKt.activeNetwork(StoreKeys.INSTANCE, Blockchain_EthereumKt.getETHEREUM(Blockchain.Companion)));
        Integer valueOf = (network == null || (asEthereumChain = Network_EthereumKt.getAsEthereumChain(network)) == null) ? null : Integer.valueOf(asEthereumChain.getChainId());
        EthereumChain asEthereumChain2 = Network_EthereumKt.getAsEthereumChain(getViewState().getNetwork());
        Integer valueOf2 = asEthereumChain2 != null ? Integer.valueOf(asEthereumChain2.getChainId()) : null;
        if (valueOf2 == null) {
            if (valueOf == null) {
                return 1;
            }
            return valueOf.intValue();
        }
        return valueOf2.intValue();
    }

    public final SendBalances getSendAmounts() {
        String formatToFiat;
        CurrencyFormatter currencyFormatter = this.currencyFormatter;
        CurrencyCode currencyCode = getViewState().getWallet().getCurrencyCode();
        String contractAddress = getViewState().getWallet().getContractAddress();
        int decimals = getViewState().getWallet().getDecimals();
        BigInteger weiValue = getViewState().getWeiValue();
        EthereumChain asEthereumChain = Network_EthereumKt.getAsEthereumChain(getViewState().getWallet().getNetwork());
        formatToFiat = currencyFormatter.formatToFiat(currencyCode, contractAddress, decimals, weiValue, (r17 & 16) != 0 ? false : false, (r17 & 32) != 0 ? null : null, (r17 & 64) != 0 ? null : asEthereumChain == null ? null : Integer.valueOf(asEthereumChain.getChainId()));
        return new SendBalances(formatToFiat, CurrencyFormatter.formatToCrypto$default(this.currencyFormatter, getViewState().getWallet().getCurrencyCode(), getViewState().getWallet().getDecimals(), getViewState().getWeiValue(), false, 0, 0, 56, (Object) null));
    }

    private final b0<UnsignedTxResult> getTransactionSingle() {
        return (b0) this.transactionSingle$delegate.getValue();
    }

    private final BigInteger getTxGasPrice() {
        return (BigInteger) this.txGasPrice$delegate.getValue();
    }

    private final BigInteger getTxLimit() {
        return (BigInteger) this.txLimit$delegate.getValue();
    }

    public static /* synthetic */ h0 h(TxSignerViewModel txSignerViewModel, UnsignedTxResult unsignedTxResult) {
        return m1438fetchReceiptInformation$lambda3(txSignerViewModel, unsignedTxResult);
    }

    /* renamed from: handleAdjustableMinerFeeResult$lambda-11 */
    public static final Wallet m1441handleAdjustableMinerFeeResult$lambda11(EthereumUnsignedTx tx, List wallets) {
        boolean z;
        kotlin.jvm.internal.m.g(tx, "$tx");
        kotlin.jvm.internal.m.g(wallets, "wallets");
        Iterator it = wallets.iterator();
        while (it.hasNext()) {
            Wallet wallet = (Wallet) it.next();
            if (kotlin.jvm.internal.m.c(wallet.getCurrencyCode(), tx.getFeeCurrencyCode()) && kotlin.jvm.internal.m.c(tx.getNetwork(), wallet.getNetwork())) {
                z = true;
                continue;
            } else {
                z = false;
                continue;
            }
            if (z) {
                return wallet;
            }
        }
        throw new NoSuchElementException("Collection contains no element matching the predicate.");
    }

    /* renamed from: handleAdjustableMinerFeeResult$lambda-12 */
    public static final x m1442handleAdjustableMinerFeeResult$lambda12(EthereumUnsignedTx tx, AdjustableMinerFeeSelection adjustableMinerFeeSelection, TxSignerViewModel this$0, Wallet feeWallet) {
        UnsignedTx copy;
        kotlin.jvm.internal.m.g(tx, "$tx");
        kotlin.jvm.internal.m.g(adjustableMinerFeeSelection, "$adjustableMinerFeeSelection");
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(feeWallet, "feeWallet");
        if (tx instanceof EthereumUnsignedLegacyTx) {
            AdjustableMinerFeeLegacySelection adjustableMinerFeeLegacySelection = (AdjustableMinerFeeLegacySelection) adjustableMinerFeeSelection;
            BigInteger gasPrice = adjustableMinerFeeLegacySelection.getGasPrice();
            BigInteger gasLimit = adjustableMinerFeeLegacySelection.getGasLimit();
            if (gasLimit == null) {
                gasLimit = tx.getGasLimit();
            }
            BigInteger bigInteger = gasLimit;
            Integer nonce = adjustableMinerFeeLegacySelection.getNonce();
            if (nonce == null) {
                nonce = tx.getNonce();
            }
            copy = r4.copy((r34 & 1) != 0 ? r4.getToAddress() : null, (r34 & 2) != 0 ? r4.getFromAddress() : null, (r34 & 4) != 0 ? r4.getWalletIndex() : 0, (r34 & 8) != 0 ? r4.getNonce() : nonce, (r34 & 16) != 0 ? r4.getWeiValue() : null, (r34 & 32) != 0 ? r4.getErc20Value() : null, (r34 & 64) != 0 ? r4.getData() : null, (r34 & 128) != 0 ? r4.gasPrice : gasPrice, (r34 & 256) != 0 ? r4.getGasLimit() : bigInteger, (r34 & 512) != 0 ? r4.getNetwork() : null, (r34 & 1024) != 0 ? r4.getCurrencyCode() : null, (r34 & PKIFailureInfo.wrongIntegrity) != 0 ? r4.getBlockchain() : null, (r34 & 4096) != 0 ? r4.getTransferValue() : null, (r34 & PKIFailureInfo.certRevoked) != 0 ? r4.getFeeCurrencyCode() : null, (r34 & 16384) != 0 ? r4.getRecipientAddress() : null, (r34 & 32768) != 0 ? ((EthereumUnsignedLegacyTx) tx).getMetadata() : null);
        } else if (tx instanceof EthereumUnsigned1559Tx) {
            MinerFee1559Data minerFee1559Data = (MinerFee1559Data) adjustableMinerFeeSelection;
            BigInteger maxFeePerGas = minerFee1559Data.getMaxFeePerGas();
            BigInteger baseFeePerGas = minerFee1559Data.getBaseFeePerGas();
            BigInteger maxPriorityFee = minerFee1559Data.getMaxPriorityFee();
            BigInteger gasLimit2 = minerFee1559Data.getGasLimit();
            if (gasLimit2 == null) {
                gasLimit2 = tx.getGasLimit();
            }
            BigInteger bigInteger2 = gasLimit2;
            Integer nonce2 = minerFee1559Data.getNonce();
            if (nonce2 == null) {
                nonce2 = tx.getNonce();
            }
            copy = r4.copy((r38 & 1) != 0 ? r4.getToAddress() : null, (r38 & 2) != 0 ? r4.getFromAddress() : null, (r38 & 4) != 0 ? r4.getWalletIndex() : 0, (r38 & 8) != 0 ? r4.getNonce() : nonce2, (r38 & 16) != 0 ? r4.getWeiValue() : null, (r38 & 32) != 0 ? r4.getErc20Value() : null, (r38 & 64) != 0 ? r4.getData() : null, (r38 & 128) != 0 ? r4.maxFeePerGas : maxFeePerGas, (r38 & 256) != 0 ? r4.baseFeePerGas : baseFeePerGas, (r38 & 512) != 0 ? r4.maxPriorityFeePerGas : maxPriorityFee, (r38 & 1024) != 0 ? r4.getGasLimit() : bigInteger2, (r38 & PKIFailureInfo.wrongIntegrity) != 0 ? r4.getNetwork() : null, (r38 & 4096) != 0 ? r4.getCurrencyCode() : null, (r38 & PKIFailureInfo.certRevoked) != 0 ? r4.getBlockchain() : null, (r38 & 16384) != 0 ? r4.getTransferValue() : null, (r38 & 32768) != 0 ? r4.getFeeCurrencyCode() : null, (r38 & 65536) != 0 ? r4.getRecipientAddress() : null, (r38 & PKIFailureInfo.unsupportedVersion) != 0 ? ((EthereumUnsigned1559Tx) tx).getMetadata() : null);
        } else {
            throw new NoWhenBranchMatchedException();
        }
        this$0.handleUnsignedTx(copy, feeWallet);
        return x.a;
    }

    private final void handleFees(UnsignedTx unsignedTx, Wallet wallet) {
        h.c.t0.a.a(h.c.t0.g.i(IExchangeRateRepository.DefaultImpls.getCryptoExchangeRate$default(this.exchangeRateRepository, wallet.getCurrencyCode(), wallet.getContractAddress(), 0, 4, null), null, new TxSignerViewModel$handleFees$1(unsignedTx, this, wallet), 1, null), this.disposeBag);
    }

    public final void handleUnsignedTx(UnsignedTx unsignedTx, Wallet wallet) {
        SendConfirmationResult create;
        Wallet wallet2 = getViewState().getWallet();
        this.tx = unsignedTx;
        BigInteger transferValue = unsignedTx.getTransferValue();
        if (kotlin.jvm.internal.m.c(wallet.getCurrencyCode(), wallet2.getCurrencyCode())) {
            transferValue = transferValue.add(unsignedTx.getEstimatedFee());
            kotlin.jvm.internal.m.f(transferValue, "this.add(other)");
        }
        BigInteger balance = wallet2.getBalance();
        BigInteger minimumBalance = wallet2.getMinimumBalance();
        if (minimumBalance == null) {
            minimumBalance = BigInteger.ZERO;
        }
        kotlin.jvm.internal.m.f(minimumBalance, "wallet.minimumBalance ?: BigInteger.ZERO");
        BigInteger subtract = balance.subtract(minimumBalance);
        kotlin.jvm.internal.m.f(subtract, "this.subtract(other)");
        if (transferValue.compareTo(subtract) > 0) {
            BigInteger add = unsignedTx.getTransferValue().add(unsignedTx.getEstimatedFee());
            kotlin.jvm.internal.m.f(add, "this.add(other)");
            BigInteger subtract2 = add.subtract(subtract);
            kotlin.jvm.internal.m.f(subtract2, "this.subtract(other)");
            create = SendConfirmationResult.Companion.create(new SendConfirmationState.InsufficientBalance(LocalizedStrings.INSTANCE.get(R.string.insufficient_balance_error, wallet2.getCurrencyCode(), CurrencyFormatter.formatToCrypto$default(this.currencyFormatter, unsignedTx.getCurrencyCode(), wallet2.getDecimals(), subtract2, false, 0, 0, 56, (Object) null))), unsignedTx, wallet, wallet2, this.currencyFormatter);
        } else if (unsignedTx.getEstimatedFee().compareTo(Wallet_ApplicationKt.maximumAvailableBalance(wallet)) > 0 && kotlin.jvm.internal.m.c(wallet2.getBlockchain(), Blockchain_EthereumKt.getETHEREUM(Blockchain.Companion)) && !kotlin.jvm.internal.m.c(wallet2.getCurrencyCode(), WalletConfiguration_EthereumKt.getETH(EthereumBasedConfiguration.Companion).currencyCodeForNetwork(wallet.getNetwork()))) {
            create = SendConfirmationResult.Companion.create(new SendConfirmationState.InsufficientFee(LocalizedStrings.INSTANCE.get(R.string.insufficient_fee_balance_info_prompt_subtitle)), unsignedTx, wallet, wallet2, this.currencyFormatter);
        } else {
            create = SendConfirmationResult.Companion.create(SendConfirmationState.SufficientBalance.INSTANCE, unsignedTx, wallet, wallet2, this.currencyFormatter);
        }
        this.signConfirmationSubject.onNext(create);
        handleFees(unsignedTx, wallet);
    }

    public static /* synthetic */ Wallet i(EthereumUnsignedTx ethereumUnsignedTx, List list) {
        return m1441handleAdjustableMinerFeeResult$lambda11(ethereumUnsignedTx, list);
    }

    private final void sign(UnsignedTx unsignedTx, String str) {
        if (unsignedTx instanceof EthereumUnsignedLegacyTx) {
            if (!kotlin.jvm.internal.m.c(unsignedTx.getCurrencyCode(), CurrencyCode_EthereumKt.getETH(CurrencyCode.Companion))) {
                getSignatureRequestEventSubject().onNext(new SigningSessionEvent.Failure(getViewState().getUuid(), SignatureOnlyNotSupported.a));
                return;
            }
            getSignatureRequestEventSubject().onNext(new SigningSessionEvent.Signing(getViewState().getUuid()));
            b0 observeOn = IETHTxRepository.DefaultImpls.signTx$default(this.ethereumTxRepository, (EthereumUnsignedLegacyTx) unsignedTx, str, false, 4, null).flatMap(new h.c.m0.n() { // from class: com.coinbase.wallet.features.signer.viewmodel.t
                @Override // h.c.m0.n
                public final Object apply(Object obj) {
                    return TxSignerViewModel.g(TxSignerViewModel.this, (EthereumSignedTx) obj);
                }
            }).observeOn(h.c.j0.c.a.b());
            kotlin.jvm.internal.m.f(observeOn, "ethereumTxRepository.signTx(unsignedTx, mnemonic)\n            .flatMap { signedTx ->\n                val requestId = viewState.hostRequestId ?: return@flatMap Single.just(signedTx)\n\n                walletLinkRepository.approve(requestId, signedTx.signedTxData)\n                    .map { signedTx }\n                    .onErrorReturnItem(signedTx)\n            }\n            .observeOn(AndroidSchedulers.mainThread())");
            h.c.t0.a.a(h.c.t0.g.f(observeOn, new TxSignerViewModel$sign$2(this), new TxSignerViewModel$sign$3(this, str)), this.disposeBag);
        }
    }

    /* renamed from: sign$lambda-5 */
    public static final h0 m1443sign$lambda5(TxSignerViewModel this$0, final EthereumSignedTx signedTx) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(signedTx, "signedTx");
        HostRequestId hostRequestId = this$0.getViewState().getHostRequestId();
        return hostRequestId == null ? b0.just(signedTx) : this$0.walletLinkRepository.approve(hostRequestId, signedTx.getSignedTxData()).map(new h.c.m0.n() { // from class: com.coinbase.wallet.features.signer.viewmodel.p
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return TxSignerViewModel.c(EthereumSignedTx.this, (x) obj);
            }
        }).onErrorReturnItem(signedTx);
    }

    /* renamed from: sign$lambda-5$lambda-4 */
    public static final EthereumSignedTx m1444sign$lambda5$lambda4(EthereumSignedTx signedTx, x it) {
        kotlin.jvm.internal.m.g(signedTx, "$signedTx");
        kotlin.jvm.internal.m.g(it, "it");
        return signedTx;
    }

    private final void signAndSubmit(UnsignedTx unsignedTx, String str) {
        getSignatureRequestEventSubject().onNext(new SigningSessionEvent.Signing(getViewState().getUuid()));
        b0 observeOn = this.txRepository.signAndSubmit(unsignedTx, str, true).flatMap(new h.c.m0.n() { // from class: com.coinbase.wallet.features.signer.viewmodel.r
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return TxSignerViewModel.e(TxSignerViewModel.this, (SignedTx) obj);
            }
        }).observeOn(h.c.j0.c.a.b());
        kotlin.jvm.internal.m.f(observeOn, "txRepository.signAndSubmit(unsignedTx, mnemonic, true)\n            .flatMap { signedTx ->\n                val requestId = viewState.hostRequestId ?: return@flatMap Single.just(signedTx)\n                val signedData = signedTx.txHash.asHexEncodedData()\n                    ?: return@flatMap Single.just(signedTx)\n\n                walletLinkRepository.approve(requestId, signedData)\n                    .map { signedTx }\n                    .onErrorReturnItem(signedTx)\n            }\n            .observeOn(AndroidSchedulers.mainThread())");
        h.c.t0.a.a(h.c.t0.g.f(observeOn, new TxSignerViewModel$signAndSubmit$2(this), new TxSignerViewModel$signAndSubmit$3(this, str)), this.disposeBag);
    }

    /* renamed from: signAndSubmit$lambda-7 */
    public static final h0 m1445signAndSubmit$lambda7(TxSignerViewModel this$0, final SignedTx signedTx) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(signedTx, "signedTx");
        HostRequestId hostRequestId = this$0.getViewState().getHostRequestId();
        if (hostRequestId == null) {
            return b0.just(signedTx);
        }
        byte[] asHexEncodedData = String_CoreKt.asHexEncodedData(signedTx.getTxHash());
        if (asHexEncodedData == null) {
            return b0.just(signedTx);
        }
        return this$0.walletLinkRepository.approve(hostRequestId, asHexEncodedData).map(new h.c.m0.n() { // from class: com.coinbase.wallet.features.signer.viewmodel.q
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return TxSignerViewModel.d(SignedTx.this, (x) obj);
            }
        }).onErrorReturnItem(signedTx);
    }

    /* renamed from: signAndSubmit$lambda-7$lambda-6 */
    public static final SignedTx m1446signAndSubmit$lambda7$lambda6(SignedTx signedTx, x it) {
        kotlin.jvm.internal.m.g(signedTx, "$signedTx");
        kotlin.jvm.internal.m.g(it, "it");
        return signedTx;
    }

    public final void adjustableMinerFeeClicked() {
        androidx.fragment.app.c adjustableMinerFeeFragment;
        Bundle createArgs;
        UnsignedTx unsignedTx = this.tx;
        EthereumUnsignedTx ethereumUnsignedTx = unsignedTx instanceof EthereumUnsignedTx ? (EthereumUnsignedTx) unsignedTx : null;
        if (ethereumUnsignedTx == null) {
            return;
        }
        EthereumChain fromChainId = EthereumChain.Companion.fromChainId(getChainId());
        boolean z = false;
        if (fromChainId != null && fromChainId.is1559Enabled()) {
            z = true;
        }
        if (z) {
            adjustableMinerFeeFragment = new AdjustableMinerFee1559Fragment();
            AdjustableMinerFeeArgs adjustableMinerFeeArgs = AdjustableMinerFeeArgs.INSTANCE;
            BigInteger gasLimit = ethereumUnsignedTx.getGasLimit();
            String fromAddress = ethereumUnsignedTx.getFromAddress();
            EthereumChain asEthereumChain = Network_EthereumKt.getAsEthereumChain(ethereumUnsignedTx.getNetwork());
            if (asEthereumChain == null) {
                return;
            }
            createArgs = adjustableMinerFeeArgs.createArgs("Dapp or WalletLink", gasLimit, fromAddress, asEthereumChain, (r16 & 16) != 0 ? null : null, (r16 & 32) != 0 ? null : ethereumUnsignedTx.getNonce());
            adjustableMinerFeeFragment.setArguments(createArgs);
        } else {
            adjustableMinerFeeFragment = new AdjustableMinerFeeFragment();
            AdjustableMinerFeeArgs adjustableMinerFeeArgs2 = AdjustableMinerFeeArgs.INSTANCE;
            BigInteger gasLimit2 = ethereumUnsignedTx.getGasLimit();
            String fromAddress2 = ethereumUnsignedTx.getFromAddress();
            EthereumChain asEthereumChain2 = Network_EthereumKt.getAsEthereumChain(ethereumUnsignedTx.getNetwork());
            if (asEthereumChain2 == null) {
                return;
            }
            adjustableMinerFeeFragment.setArguments(adjustableMinerFeeArgs2.createArgs("Dapp or WalletLink", gasLimit2, fromAddress2, asEthereumChain2, getTxGasPrice(), ethereumUnsignedTx.getNonce()));
        }
        this.navigationSubject.onNext(adjustableMinerFeeFragment);
        Analytics.INSTANCE.log(AnalyticsEvent_ApplicationKt.adjustableMinerFeeButtonTapped(AnalyticsEvent.Companion, "Dapp or WalletLink", ethereumUnsignedTx.getCurrencyCode(), ethereumUnsignedTx.getNetwork()));
    }

    public final void approve() {
        b0<AuthenticationResult> observeOn = this.authenticationHelper.unlock(AppLockType.Transactions.INSTANCE).observeOn(h.c.j0.c.a.b());
        kotlin.jvm.internal.m.f(observeOn, "authenticationHelper.unlock(AppLockType.Transactions)\n            .observeOn(AndroidSchedulers.mainThread())");
        h.c.t0.a.a(h.c.t0.g.f(observeOn, new TxSignerViewModel$approve$1(this), new TxSignerViewModel$approve$2(this)), this.disposeBag);
    }

    public final h.c.k0.b fetchReceiptInformation() {
        b0<R> flatMap = getTransactionSingle().flatMap(new h.c.m0.n() { // from class: com.coinbase.wallet.features.signer.viewmodel.u
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return TxSignerViewModel.h(TxSignerViewModel.this, (UnsignedTxResult) obj);
            }
        });
        kotlin.jvm.internal.m.f(flatMap, "transactionSingle\n        .flatMap { result ->\n            if (result is UnsignedTxResult.Error) throw result.err\n\n            val successResult = result as UnsignedTxResult.Success\n\n            walletRepository.getAllActiveEthWallets()\n                .map { wallets ->\n                    wallets.first { wallet ->\n                        wallet.currencyCode == successResult.tx.feeCurrencyCode &&\n                            successResult.tx.network == wallet.network\n                    }\n                }\n                .map { Pair(successResult, it) }\n        }");
        return h.c.t0.a.a(h.c.t0.g.f(Single_AnalyticsKt.logError$default(Single_CoreKt.retryIfNeeded(flatMap, 3, TxSignerViewModel$fetchReceiptInformation$2.INSTANCE), "error generating tx", null, 2, null), new TxSignerViewModel$fetchReceiptInformation$3(this), new TxSignerViewModel$fetchReceiptInformation$4(this)), this.disposeBag);
    }

    public final URL getImageUrl() {
        return (URL) this.imageUrl$delegate.getValue();
    }

    public final h.c.s<androidx.fragment.app.c> getNavigationObservable() {
        return this.navigationObservable;
    }

    public final h.c.s<PromptDialogHelper.Properties> getPromptObservable() {
        return this.promptObservable;
    }

    public final h.c.s<SendConfirmationResult> getSignConfirmationObservable() {
        Object value = this.signConfirmationObservable$delegate.getValue();
        kotlin.jvm.internal.m.f(value, "<get-signConfirmationObservable>(...)");
        return (h.c.s) value;
    }

    public final void handleAdjustableMinerFeeResult(final AdjustableMinerFeeSelection adjustableMinerFeeSelection) {
        kotlin.jvm.internal.m.g(adjustableMinerFeeSelection, "adjustableMinerFeeSelection");
        UnsignedTx unsignedTx = this.tx;
        if (unsignedTx == null) {
            return;
        }
        final EthereumUnsignedTx ethereumUnsignedTx = unsignedTx instanceof EthereumUnsignedTx ? (EthereumUnsignedTx) unsignedTx : null;
        if (ethereumUnsignedTx == null) {
            return;
        }
        h.c.k0.b subscribe = this.walletRepository.getAllActiveEthWallets().map(new h.c.m0.n() { // from class: com.coinbase.wallet.features.signer.viewmodel.v
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return TxSignerViewModel.i(EthereumUnsignedTx.this, (List) obj);
            }
        }).map(new h.c.m0.n() { // from class: com.coinbase.wallet.features.signer.viewmodel.o
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return TxSignerViewModel.b(EthereumUnsignedTx.this, adjustableMinerFeeSelection, this, (Wallet) obj);
            }
        }).subscribe();
        kotlin.jvm.internal.m.f(subscribe, "walletRepository.getAllActiveEthWallets()\n            .map { wallets ->\n                wallets.first { wallet ->\n                    wallet.currencyCode == tx.feeCurrencyCode &&\n                        tx.network == wallet.network\n                }\n            }\n            .map { feeWallet ->\n                val adjustedTx = when (tx) {\n                    is EthereumUnsignedLegacyTx -> {\n                        adjustableMinerFeeSelection as AdjustableMinerFeeLegacySelection\n                        tx.copy(\n                            gasPrice = adjustableMinerFeeSelection.gasPrice,\n                            gasLimit = adjustableMinerFeeSelection.gasLimit ?: tx.gasLimit,\n                            nonce = adjustableMinerFeeSelection.nonce ?: tx.nonce\n                        )\n                    }\n                    is EthereumUnsigned1559Tx -> {\n                        adjustableMinerFeeSelection as MinerFee1559Data\n                        tx.copy(\n                            maxFeePerGas = adjustableMinerFeeSelection.maxFeePerGas,\n                            baseFeePerGas = adjustableMinerFeeSelection.baseFeePerGas,\n                            maxPriorityFeePerGas = adjustableMinerFeeSelection.maxPriorityFee,\n                            gasLimit = adjustableMinerFeeSelection.gasLimit ?: tx.gasLimit,\n                            nonce = adjustableMinerFeeSelection.nonce ?: tx.nonce\n                        )\n                    }\n                }\n                handleUnsignedTx(adjustedTx, feeWallet)\n            }\n            .subscribe()");
        h.c.t0.a.a(subscribe, this.disposeBag);
    }

    public final boolean isAdjustableMinerFeeEnabled() {
        return this.featureFlagsRepository.valueSync(FeatureFlag.ADJUSTABLE_MINER_FEE) && kotlin.jvm.internal.m.c(getViewState().getWallet().getBlockchain(), Blockchain_EthereumKt.getETHEREUM(Blockchain.Companion)) && Network_EthereumKt.getAsEthereumChain(getViewState().getWallet().getNetwork()) == EthereumChain.ETHEREUM_MAINNET && (this.tx instanceof EthereumUnsignedTx);
    }

    public final boolean isAmountZero() {
        return kotlin.jvm.internal.m.c(getViewState().getWeiValue(), BigInteger.ZERO);
    }

    @Override // androidx.lifecycle.b0
    public void onCleared() {
        super.onCleared();
        this.disposeBag.d();
    }

    public final void presentMinerFee() {
        String str;
        int i2;
        List b2;
        Wallet wallet = getViewState().getWallet();
        String rawValue = wallet.getCurrencyCode().getRawValue();
        if (kotlin.jvm.internal.m.c(wallet.getBlockchain(), Blockchain_EthereumKt.getETHEREUM(Blockchain.Companion)) && !kotlin.jvm.internal.m.c(wallet.getCurrencyCode(), CurrencyCode_EthereumKt.getETH(CurrencyCode.Companion))) {
            str = LocalizedStrings.INSTANCE.get(R.string.send_miner_fee_erc20_description, rawValue);
            i2 = R.drawable.illustration_no_eth;
        } else {
            str = LocalizedStrings.INSTANCE.get(R.string.send_miner_fee_description, wallet.getDisplayName());
            i2 = R.drawable.illustration_dollar_arrows;
        }
        String str2 = str;
        LocalizedStrings localizedStrings = LocalizedStrings.INSTANCE;
        PromptDialogHelper.Action action = new PromptDialogHelper.Action(localizedStrings.get(R.string.send_confirmation_miner_dialog_button), ActionStyle.POSITIVE, TxSignerViewModel$presentMinerFee$action$1.INSTANCE);
        String str3 = localizedStrings.get(R.string.send_confirmation_miner_fee_dialog_title);
        b2 = kotlin.a0.q.b(action);
        this.promptSubject.onNext(new PromptDialogHelper.Properties(null, str3, str2, null, Integer.valueOf(i2), b2, null, true, null, null, TxSignerViewModel$presentMinerFee$properties$1.INSTANCE, null, null, false, 15177, null));
    }

    public final void reject() {
        HostRequestId hostRequestId = getViewState().getHostRequestId();
        if (hostRequestId == null) {
            getSignatureRequestEventSubject().onNext(new SigningSessionEvent.Cancelled(getViewState().getUuid()));
            return;
        }
        getSignatureRequestEventSubject().onNext(new SigningSessionEvent.Signing(getViewState().getUuid()));
        b0 subscribeOn = Single_AnalyticsKt.logError$default(this.walletLinkRepository.reject(hostRequestId), null, null, 3, null).subscribeOn(h.c.j0.c.a.b());
        kotlin.jvm.internal.m.f(subscribeOn, "walletLinkRepository.reject(hostRequestId)\n            .logError()\n            .subscribeOn(AndroidSchedulers.mainThread())");
        h.c.t0.a.a(h.c.t0.g.f(subscribeOn, new TxSignerViewModel$reject$1(this), new TxSignerViewModel$reject$2(this)), this.disposeBag);
    }

    @Override // com.coinbase.wallet.features.signer.interfaces.StackedRequestItem
    public SignatureRequestViewState.SignAndSubmitTxViewState getViewState() {
        SignatureRequestViewState.SignAndSubmitTxViewState signAndSubmitTxViewState = this.viewState;
        if (signAndSubmitTxViewState != null) {
            return signAndSubmitTxViewState;
        }
        kotlin.jvm.internal.m.w("viewState");
        throw null;
    }

    @Override // com.coinbase.wallet.features.signer.interfaces.StackedRequestItem
    public void setViewState(SignatureRequestViewState.SignAndSubmitTxViewState signAndSubmitTxViewState) {
        kotlin.jvm.internal.m.g(signAndSubmitTxViewState, "<set-?>");
        this.viewState = signAndSubmitTxViewState;
    }
}