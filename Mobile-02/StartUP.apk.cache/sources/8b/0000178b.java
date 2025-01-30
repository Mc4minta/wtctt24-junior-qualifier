package com.coinbase.wallet.consumer.viewmodels;

import android.os.Bundle;
import com.coinbase.ApiConstants;
import com.coinbase.resources.trades.Trade;
import com.coinbase.wallet.analytics.Analytics;
import com.coinbase.wallet.analytics.extensions.Single_AnalyticsKt;
import com.coinbase.wallet.analytics.models.AnalyticsEvent;
import com.coinbase.wallet.blockchains.models.Blockchain;
import com.coinbase.wallet.blockchains.models.CurrencyCode;
import com.coinbase.wallet.blockchains.models.TransferValue;
import com.coinbase.wallet.common.extensions.List_CommonKt;
import com.coinbase.wallet.common.utilities.LocalizedStrings;
import com.coinbase.wallet.commonui.models.ActionStyle;
import com.coinbase.wallet.commonui.models.ForwardArgs;
import com.coinbase.wallet.commonui.models.ViewModelNavRoute;
import com.coinbase.wallet.commonui.utilities.PromptDialogHelper;
import com.coinbase.wallet.consumer.R;
import com.coinbase.wallet.consumer.exceptions.ConsumerException;
import com.coinbase.wallet.consumer.extensions.AnalyticsEvent_ConsumerKt;
import com.coinbase.wallet.consumer.models.AvailableBuyAndSendTransfer;
import com.coinbase.wallet.consumer.models.AvailableSendTransfer;
import com.coinbase.wallet.consumer.models.AvailableTransfer;
import com.coinbase.wallet.consumer.models.BuyStatus;
import com.coinbase.wallet.consumer.models.ConsumerAccount;
import com.coinbase.wallet.consumer.models.ConsumerBuyOrder;
import com.coinbase.wallet.consumer.models.ConsumerCardCDVArgs;
import com.coinbase.wallet.consumer.models.ConsumerCardCDVResult;
import com.coinbase.wallet.consumer.models.ConsumerConfirmationEvent;
import com.coinbase.wallet.consumer.models.ConsumerConfirmationPromptEvent;
import com.coinbase.wallet.consumer.models.ConsumerPaymentMethod;
import com.coinbase.wallet.consumer.models.ConsumerPaymentMethodType;
import com.coinbase.wallet.consumer.models.ConsumerSecure3DVerificationArgs;
import com.coinbase.wallet.consumer.models.ConsumerSecure3DVerificationResult;
import com.coinbase.wallet.consumer.models.ConsumerTransferConfirmationViewState;
import com.coinbase.wallet.consumer.models.ConsumerTransferMethodResult;
import com.coinbase.wallet.consumer.models.ConsumerTransferMethodsArgs;
import com.coinbase.wallet.consumer.models.ReceivableWallet;
import com.coinbase.wallet.consumer.models.Secure3DVerification;
import com.coinbase.wallet.consumer.models.TransferMoneyRequest;
import com.coinbase.wallet.consumer.repositories.ConsumerTransferRepository;
import com.coinbase.wallet.consumer.views.ConsumerSendTwoFactorFragment;
import com.coinbase.wallet.core.extensions.Single_CoreKt;
import com.coinbase.wallet.core.util.AssertionException;
import com.coinbase.wallet.ethereum.extensions.Blockchain_EthereumKt;
import com.coinbase.wallet.ethereum.extensions.WalletConfiguration_EthereumKt;
import com.coinbase.wallet.ethereum.models.EthereumBasedConfiguration;
import com.coinbase.wallet.wallets.formatters.CurrencyFormatter;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import org.spongycastle.asn1.cmp.PKIFailureInfo;

/* compiled from: ConsumerTransferConfirmationViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000¬\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001_B#\b\u0007\u0012\u0006\u0010X\u001a\u00020W\u0012\u0006\u0010;\u001a\u00020:\u0012\b\b\u0001\u0010[\u001a\u00020Z¢\u0006\u0004\b]\u0010^J5\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\f\u0010\rJ\u0019\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u001d\u0010\u0016\u001a\u00020\u000b2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013H\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u001d\u0010\u001a\u001a\u00020\u000b2\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00180\u0013H\u0002¢\u0006\u0004\b\u001a\u0010\u0017J\u001d\u0010\u001d\u001a\u00020\u000b2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001b0\u0013H\u0002¢\u0006\u0004\b\u001d\u0010\u0017J-\u0010 \u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u0010\u0003\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b \u0010!J-\u0010#\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\"\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b#\u0010$J-\u0010%\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\"\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b%\u0010&J-\u0010)\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010(\u001a\u00020'2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b)\u0010*J\u0013\u0010,\u001a\u00020\u001e*\u00020+H\u0002¢\u0006\u0004\b,\u0010-J=\u0010.\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u00132\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00180\u00132\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001b0\u0013¢\u0006\u0004\b.\u0010/J\u0013\u00100\u001a\b\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\u0004\b0\u00101J\r\u00102\u001a\u00020\u000b¢\u0006\u0004\b2\u00103J\r\u00104\u001a\u00020\u000b¢\u0006\u0004\b4\u00103J\r\u00105\u001a\u00020\u000b¢\u0006\u0004\b5\u00103J\r\u00106\u001a\u00020\u000b¢\u0006\u0004\b6\u00103R\u001c\u00108\u001a\b\u0012\u0004\u0012\u00020\u0010078\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b8\u00109R\u0016\u0010;\u001a\u00020:8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b;\u0010<R\u0016\u0010>\u001a\u00020=8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b>\u0010?R\u001f\u0010A\u001a\b\u0012\u0004\u0012\u00020@0\u00138\u0006@\u0006¢\u0006\f\n\u0004\bA\u0010B\u001a\u0004\bC\u0010DR\u001c\u0010F\u001a\b\u0012\u0004\u0012\u00020E078\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bF\u00109R\u001d\u0010L\u001a\u00020G8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\bH\u0010I\u001a\u0004\bJ\u0010KR\u001f\u0010M\u001a\b\u0012\u0004\u0012\u00020\u00100\u00138\u0006@\u0006¢\u0006\f\n\u0004\bM\u0010B\u001a\u0004\bN\u0010DR\u001c\u0010O\u001a\b\u0012\u0004\u0012\u00020@078\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bO\u00109R$\u0010Q\u001a\u00020\u00102\u0006\u0010P\u001a\u00020\u00108\u0002@BX\u0082\u000e¢\u0006\f\n\u0004\bQ\u0010R\"\u0004\bS\u0010TR\u001f\u0010U\u001a\b\u0012\u0004\u0012\u00020E0\u00138\u0006@\u0006¢\u0006\f\n\u0004\bU\u0010B\u001a\u0004\bV\u0010DR\u0016\u0010X\u001a\u00020W8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bX\u0010YR\u0016\u0010[\u001a\u00020Z8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b[\u0010\\¨\u0006`"}, d2 = {"Lcom/coinbase/wallet/consumer/viewmodels/ConsumerTransferConfirmationViewModel;", "Landroidx/lifecycle/b0;", "Lcom/coinbase/wallet/consumer/models/AvailableBuyAndSendTransfer;", "selectedTransferMethod", "Lcom/coinbase/wallet/consumer/models/ConsumerBuyOrder;", "originalBuyOrder", "", "paymentResult", "Ljava/util/UUID;", "uuid", "Lh/c/b0;", "Lkotlin/x;", "completeBuyOrderAfterSecure3DVerification", "(Lcom/coinbase/wallet/consumer/models/AvailableBuyAndSendTransfer;Lcom/coinbase/wallet/consumer/models/ConsumerBuyOrder;Ljava/lang/String;Ljava/util/UUID;)Lh/c/b0;", "Lcom/coinbase/wallet/consumer/models/AvailableTransfer;", "selectedTransfer", "Lcom/coinbase/wallet/consumer/models/ConsumerTransferConfirmationViewState;", "consumerTransferViewState", "(Lcom/coinbase/wallet/consumer/models/AvailableTransfer;)Lcom/coinbase/wallet/consumer/models/ConsumerTransferConfirmationViewState;", "Lh/c/s;", "Lcom/coinbase/wallet/consumer/models/ConsumerTransferMethodResult;", "transferResultObservable", "observeTransferMethodsResult", "(Lh/c/s;)V", "Lcom/coinbase/wallet/consumer/models/ConsumerCardCDVResult;", "cardVerificationResultObservable", "observeCardVerificationResult", "Lcom/coinbase/wallet/consumer/models/ConsumerSecure3DVerificationResult;", "secure3DVerificationResultObservable", "observeSecure3DVerificationResult", "", "triedBuying", "startSend", "(ZLcom/coinbase/wallet/consumer/models/AvailableTransfer;Ljava/util/UUID;)Lh/c/b0;", "buyOrder", "pollForBuyOrder", "(Lcom/coinbase/wallet/consumer/models/ConsumerBuyOrder;Lcom/coinbase/wallet/consumer/models/AvailableBuyAndSendTransfer;Ljava/util/UUID;)Lh/c/b0;", "pollForBuyStatus", "(Lcom/coinbase/wallet/consumer/models/ConsumerBuyOrder;Ljava/util/UUID;Lcom/coinbase/wallet/consumer/models/AvailableBuyAndSendTransfer;)Lh/c/b0;", "Lcom/coinbase/wallet/consumer/models/ConsumerAccount;", "account", "pollForBalanceIncrease", "(Lcom/coinbase/wallet/consumer/models/ConsumerAccount;Ljava/util/UUID;Lcom/coinbase/wallet/consumer/models/AvailableBuyAndSendTransfer;)Lh/c/b0;", "Lcom/coinbase/wallet/consumer/models/ReceivableWallet;", "isErc20", "(Lcom/coinbase/wallet/consumer/models/ReceivableWallet;)Z", "setup", "(Lh/c/s;Lh/c/s;Lh/c/s;)Lh/c/b0;", "transfer", "()Lh/c/b0;", "detailsClicked", "()V", "switchPaymentMethod", "presentMinerFee", "presentCoinbaseFee", "Lh/c/v0/b;", "stateSubject", "Lh/c/v0/b;", "Lcom/coinbase/wallet/wallets/formatters/CurrencyFormatter;", "currencyFormatter", "Lcom/coinbase/wallet/wallets/formatters/CurrencyFormatter;", "Lh/c/k0/a;", "disposeBag", "Lh/c/k0/a;", "Lcom/coinbase/wallet/consumer/models/ConsumerConfirmationEvent;", "eventObservable", "Lh/c/s;", "getEventObservable", "()Lh/c/s;", "Lcom/coinbase/wallet/commonui/models/ViewModelNavRoute;", "navigationSubject", "Lcom/coinbase/wallet/consumer/models/TransferMoneyRequest;", "transferRequest$delegate", "Lkotlin/h;", "getTransferRequest", "()Lcom/coinbase/wallet/consumer/models/TransferMoneyRequest;", "transferRequest", "stateObservable", "getStateObservable", "eventSubject", "value", ApiConstants.STATE, "Lcom/coinbase/wallet/consumer/models/ConsumerTransferConfirmationViewState;", "setState", "(Lcom/coinbase/wallet/consumer/models/ConsumerTransferConfirmationViewState;)V", "navigationObservable", "getNavigationObservable", "Lcom/coinbase/wallet/consumer/repositories/ConsumerTransferRepository;", "consumerTransferRepository", "Lcom/coinbase/wallet/consumer/repositories/ConsumerTransferRepository;", "Landroidx/lifecycle/z;", "savedStateHandle", "Landroidx/lifecycle/z;", "<init>", "(Lcom/coinbase/wallet/consumer/repositories/ConsumerTransferRepository;Lcom/coinbase/wallet/wallets/formatters/CurrencyFormatter;Landroidx/lifecycle/z;)V", "Factory", "consumer_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class ConsumerTransferConfirmationViewModel extends androidx.lifecycle.b0 {
    private final ConsumerTransferRepository consumerTransferRepository;
    private final CurrencyFormatter currencyFormatter;
    private final h.c.k0.a disposeBag;
    private final h.c.s<ConsumerConfirmationEvent> eventObservable;
    private final h.c.v0.b<ConsumerConfirmationEvent> eventSubject;
    private final h.c.s<ViewModelNavRoute> navigationObservable;
    private final h.c.v0.b<ViewModelNavRoute> navigationSubject;
    private final androidx.lifecycle.z savedStateHandle;
    private ConsumerTransferConfirmationViewState state;
    private final h.c.s<ConsumerTransferConfirmationViewState> stateObservable;
    private final h.c.v0.b<ConsumerTransferConfirmationViewState> stateSubject;
    private final kotlin.h transferRequest$delegate;

    /* compiled from: ConsumerTransferConfirmationViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/coinbase/wallet/consumer/viewmodels/ConsumerTransferConfirmationViewModel$Factory;", "", "Landroidx/lifecycle/z;", "savedStateHandle", "Lcom/coinbase/wallet/consumer/viewmodels/ConsumerTransferConfirmationViewModel;", "create", "(Landroidx/lifecycle/z;)Lcom/coinbase/wallet/consumer/viewmodels/ConsumerTransferConfirmationViewModel;", "consumer_productionRelease"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public interface Factory {
        ConsumerTransferConfirmationViewModel create(androidx.lifecycle.z zVar);
    }

    public ConsumerTransferConfirmationViewModel(ConsumerTransferRepository consumerTransferRepository, CurrencyFormatter currencyFormatter, androidx.lifecycle.z savedStateHandle) {
        kotlin.h b2;
        kotlin.jvm.internal.m.g(consumerTransferRepository, "consumerTransferRepository");
        kotlin.jvm.internal.m.g(currencyFormatter, "currencyFormatter");
        kotlin.jvm.internal.m.g(savedStateHandle, "savedStateHandle");
        this.consumerTransferRepository = consumerTransferRepository;
        this.currencyFormatter = currencyFormatter;
        this.savedStateHandle = savedStateHandle;
        h.c.v0.b<ViewModelNavRoute> d2 = h.c.v0.b.d();
        kotlin.jvm.internal.m.f(d2, "create()");
        this.navigationSubject = d2;
        h.c.v0.b<ConsumerTransferConfirmationViewState> d3 = h.c.v0.b.d();
        kotlin.jvm.internal.m.f(d3, "create()");
        this.stateSubject = d3;
        h.c.v0.b<ConsumerConfirmationEvent> d4 = h.c.v0.b.d();
        kotlin.jvm.internal.m.f(d4, "create()");
        this.eventSubject = d4;
        this.disposeBag = new h.c.k0.a();
        b2 = kotlin.k.b(new ConsumerTransferConfirmationViewModel$transferRequest$2(this));
        this.transferRequest$delegate = b2;
        this.state = new ConsumerTransferConfirmationViewState(null, null, null, null, null, null, null, false, null, null, null, null, null, null, null, null, null, null, false, null, false, null, false, 8388607, null);
        h.c.s<ViewModelNavRoute> hide = d2.hide();
        kotlin.jvm.internal.m.f(hide, "navigationSubject.hide()");
        this.navigationObservable = hide;
        h.c.s<ConsumerTransferConfirmationViewState> hide2 = d3.hide();
        kotlin.jvm.internal.m.f(hide2, "stateSubject.hide()");
        this.stateObservable = hide2;
        h.c.s<ConsumerConfirmationEvent> hide3 = d4.hide();
        kotlin.jvm.internal.m.f(hide3, "eventSubject.hide()");
        this.eventObservable = hide3;
    }

    public static /* synthetic */ kotlin.x a(ConsumerTransferConfirmationViewModel consumerTransferConfirmationViewModel) {
        return m1014observeTransferMethodsResult$lambda17$lambda16(consumerTransferConfirmationViewModel);
    }

    public static /* synthetic */ kotlin.x b(ConsumerTransferConfirmationViewModel consumerTransferConfirmationViewModel, ConsumerTransferConfirmationViewState consumerTransferConfirmationViewState) {
        return m1012observeTransferMethodsResult$lambda17$lambda13(consumerTransferConfirmationViewModel, consumerTransferConfirmationViewState);
    }

    public static /* synthetic */ h.c.h0 c(ConsumerTransferConfirmationViewModel consumerTransferConfirmationViewModel, ConsumerTransferMethodResult consumerTransferMethodResult) {
        return m1010observeTransferMethodsResult$lambda17(consumerTransferConfirmationViewModel, consumerTransferMethodResult);
    }

    private final h.c.b0<kotlin.x> completeBuyOrderAfterSecure3DVerification(final AvailableBuyAndSendTransfer availableBuyAndSendTransfer, ConsumerBuyOrder consumerBuyOrder, String str, final UUID uuid) {
        ConsumerTransferConfirmationViewState copy;
        copy = r9.copy((r41 & 1) != 0 ? r9.modeText : null, (r41 & 2) != 0 ? r9.progressButtonText : null, (r41 & 4) != 0 ? r9.fromLabel : null, (r41 & 8) != 0 ? r9.fromPrimaryText : null, (r41 & 16) != 0 ? r9.fromSecondaryText : null, (r41 & 32) != 0 ? r9.fromImage : null, (r41 & 64) != 0 ? r9.fromImageUrl : null, (r41 & 128) != 0 ? r9.isDetailsShowing : false, (r41 & 256) != 0 ? r9.primaryAmount : null, (r41 & 512) != 0 ? r9.secondaryAmount : null, (r41 & 1024) != 0 ? r9.minerFeePrimaryAmount : null, (r41 & PKIFailureInfo.wrongIntegrity) != 0 ? r9.minerFeeSecondaryAmount : null, (r41 & 4096) != 0 ? r9.totalPrimaryAmount : null, (r41 & PKIFailureInfo.certRevoked) != 0 ? r9.totalSecondaryAmount : null, (r41 & 16384) != 0 ? r9.coinbaseFeeAmount : null, (r41 & 32768) != 0 ? r9.selectedTransferMethod : null, (r41 & 65536) != 0 ? r9.selectedTransferMethodText : null, (r41 & PKIFailureInfo.unsupportedVersion) != 0 ? r9.loading : Boolean.TRUE, (r41 & PKIFailureInfo.transactionIdInUse) != 0 ? r9.onrampEnabled : false, (r41 & PKIFailureInfo.signerNotTrusted) != 0 ? r9.transferExplanation : null, (r41 & PKIFailureInfo.badCertTemplate) != 0 ? r9.showWorldpay : false, (r41 & PKIFailureInfo.badSenderNonce) != 0 ? r9.errorText : null, (r41 & 4194304) != 0 ? this.state.detailsChanged : false);
        setState(copy);
        h.c.b0<kotlin.x> flatMap = Single_AnalyticsKt.onSubscribeTrack(this.consumerTransferRepository.completeBuyOrderAfterSecure3DVerification(getTransferRequest().getAccount(), consumerBuyOrder.getId(), str), AnalyticsEvent_ConsumerKt.consumerTransferConfirmationCompleteBuyAfterSecure3DStarted(AnalyticsEvent.Companion, getTransferRequest().getAccount().getCurrencyCode(), getTransferRequest().isFiatPrimary(), availableBuyAndSendTransfer.getPaymentMethod().getType(), getTransferRequest().getOriginalRequestAmount() instanceof TransferValue.EntireBalance, uuid)).observeOn(h.c.j0.c.a.b()).onErrorResumeNext(new h.c.m0.n() { // from class: com.coinbase.wallet.consumer.viewmodels.r1
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return ConsumerTransferConfirmationViewModel.p(ConsumerTransferConfirmationViewModel.this, availableBuyAndSendTransfer, uuid, (Throwable) obj);
            }
        }).flatMap(new h.c.m0.n() { // from class: com.coinbase.wallet.consumer.viewmodels.p1
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return ConsumerTransferConfirmationViewModel.n(ConsumerTransferConfirmationViewModel.this, availableBuyAndSendTransfer, uuid, (ConsumerBuyOrder) obj);
            }
        }).flatMap(new h.c.m0.n() { // from class: com.coinbase.wallet.consumer.viewmodels.t1
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return ConsumerTransferConfirmationViewModel.r(ConsumerTransferConfirmationViewModel.this, availableBuyAndSendTransfer, uuid, (kotlin.x) obj);
            }
        });
        kotlin.jvm.internal.m.f(flatMap, "consumerTransferRepository\n            .completeBuyOrderAfterSecure3DVerification(transferRequest.account, originalBuyOrder.id, paymentResult)\n            .onSubscribeTrack(\n                AnalyticsEvent.consumerTransferConfirmationCompleteBuyAfterSecure3DStarted(\n                    currencyCode = transferRequest.account.currencyCode,\n                    fiatSelected = transferRequest.isFiatPrimary,\n                    paymentMethodType = selectedTransferMethod.paymentMethod.type,\n                    maxTransfer = transferRequest.originalRequestAmount is TransferValue.EntireBalance,\n                    uuid = uuid\n                )\n            )\n            .observeOn(AndroidSchedulers.mainThread())\n            .onErrorResumeNext { throwable ->\n                // Allow user to try again if they failed committing the buy\n                Analytics.log(\n                    AnalyticsEvent.consumerTransferConfirmationCompleteBuyAfterSecure3DError(\n                        currencyCode = transferRequest.account.currencyCode,\n                        fiatSelected = transferRequest.isFiatPrimary,\n                        paymentMethodType = selectedTransferMethod.paymentMethod.type,\n                        maxTransfer = transferRequest.originalRequestAmount is TransferValue.EntireBalance,\n                        uuid = uuid\n                    )\n                )\n\n                state = state\n                    .copy(loading = false, isDetailsShowing = true, errorText = throwable.localizedMessage)\n                Single.error(throwable)\n            }\n            .flatMap { buyOrder -> pollForBuyOrder(buyOrder, selectedTransferMethod, uuid) }\n            .flatMap { startSend(triedBuying = true, selectedTransferMethod = selectedTransferMethod, uuid = uuid) }");
        return flatMap;
    }

    /* renamed from: completeBuyOrderAfterSecure3DVerification$lambda-7 */
    public static final h.c.h0 m1005completeBuyOrderAfterSecure3DVerification$lambda7(ConsumerTransferConfirmationViewModel this$0, AvailableBuyAndSendTransfer selectedTransferMethod, UUID uuid, Throwable throwable) {
        ConsumerTransferConfirmationViewState copy;
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(selectedTransferMethod, "$selectedTransferMethod");
        kotlin.jvm.internal.m.g(uuid, "$uuid");
        kotlin.jvm.internal.m.g(throwable, "throwable");
        Analytics.INSTANCE.log(AnalyticsEvent_ConsumerKt.consumerTransferConfirmationCompleteBuyAfterSecure3DError(AnalyticsEvent.Companion, this$0.getTransferRequest().getAccount().getCurrencyCode(), this$0.getTransferRequest().isFiatPrimary(), selectedTransferMethod.getPaymentMethod().getType(), this$0.getTransferRequest().getOriginalRequestAmount() instanceof TransferValue.EntireBalance, uuid));
        copy = r9.copy((r41 & 1) != 0 ? r9.modeText : null, (r41 & 2) != 0 ? r9.progressButtonText : null, (r41 & 4) != 0 ? r9.fromLabel : null, (r41 & 8) != 0 ? r9.fromPrimaryText : null, (r41 & 16) != 0 ? r9.fromSecondaryText : null, (r41 & 32) != 0 ? r9.fromImage : null, (r41 & 64) != 0 ? r9.fromImageUrl : null, (r41 & 128) != 0 ? r9.isDetailsShowing : true, (r41 & 256) != 0 ? r9.primaryAmount : null, (r41 & 512) != 0 ? r9.secondaryAmount : null, (r41 & 1024) != 0 ? r9.minerFeePrimaryAmount : null, (r41 & PKIFailureInfo.wrongIntegrity) != 0 ? r9.minerFeeSecondaryAmount : null, (r41 & 4096) != 0 ? r9.totalPrimaryAmount : null, (r41 & PKIFailureInfo.certRevoked) != 0 ? r9.totalSecondaryAmount : null, (r41 & 16384) != 0 ? r9.coinbaseFeeAmount : null, (r41 & 32768) != 0 ? r9.selectedTransferMethod : null, (r41 & 65536) != 0 ? r9.selectedTransferMethodText : null, (r41 & PKIFailureInfo.unsupportedVersion) != 0 ? r9.loading : Boolean.FALSE, (r41 & PKIFailureInfo.transactionIdInUse) != 0 ? r9.onrampEnabled : false, (r41 & PKIFailureInfo.signerNotTrusted) != 0 ? r9.transferExplanation : null, (r41 & PKIFailureInfo.badCertTemplate) != 0 ? r9.showWorldpay : false, (r41 & PKIFailureInfo.badSenderNonce) != 0 ? r9.errorText : throwable.getLocalizedMessage(), (r41 & 4194304) != 0 ? this$0.state.detailsChanged : false);
        this$0.setState(copy);
        return h.c.b0.error(throwable);
    }

    /* renamed from: completeBuyOrderAfterSecure3DVerification$lambda-8 */
    public static final h.c.h0 m1006completeBuyOrderAfterSecure3DVerification$lambda8(ConsumerTransferConfirmationViewModel this$0, AvailableBuyAndSendTransfer selectedTransferMethod, UUID uuid, ConsumerBuyOrder buyOrder) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(selectedTransferMethod, "$selectedTransferMethod");
        kotlin.jvm.internal.m.g(uuid, "$uuid");
        kotlin.jvm.internal.m.g(buyOrder, "buyOrder");
        return this$0.pollForBuyOrder(buyOrder, selectedTransferMethod, uuid);
    }

    /* renamed from: completeBuyOrderAfterSecure3DVerification$lambda-9 */
    public static final h.c.h0 m1007completeBuyOrderAfterSecure3DVerification$lambda9(ConsumerTransferConfirmationViewModel this$0, AvailableBuyAndSendTransfer selectedTransferMethod, UUID uuid, kotlin.x it) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(selectedTransferMethod, "$selectedTransferMethod");
        kotlin.jvm.internal.m.g(uuid, "$uuid");
        kotlin.jvm.internal.m.g(it, "it");
        return this$0.startSend(true, selectedTransferMethod, uuid);
    }

    /* JADX WARN: Removed duplicated region for block: B:241:0x02d5  */
    /* JADX WARN: Removed duplicated region for block: B:242:0x033c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final com.coinbase.wallet.consumer.models.ConsumerTransferConfirmationViewState consumerTransferViewState(com.coinbase.wallet.consumer.models.AvailableTransfer r62) {
        /*
            Method dump skipped, instructions count: 945
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.coinbase.wallet.consumer.viewmodels.ConsumerTransferConfirmationViewModel.consumerTransferViewState(com.coinbase.wallet.consumer.models.AvailableTransfer):com.coinbase.wallet.consumer.models.ConsumerTransferConfirmationViewState");
    }

    public static /* synthetic */ h.c.h0 d(ConsumerTransferConfirmationViewModel consumerTransferConfirmationViewModel, AvailableBuyAndSendTransfer availableBuyAndSendTransfer, UUID uuid, Throwable th) {
        return m1016pollForBuyOrder$lambda24(consumerTransferConfirmationViewModel, availableBuyAndSendTransfer, uuid, th);
    }

    public static /* synthetic */ ConsumerTransferConfirmationViewState f(ConsumerTransferConfirmationViewModel consumerTransferConfirmationViewModel) {
        return m1018setup$lambda0(consumerTransferConfirmationViewModel);
    }

    public static /* synthetic */ h.c.h0 g(ConsumerTransferConfirmationViewModel consumerTransferConfirmationViewModel, AvailableTransfer availableTransfer, String str, boolean z, UUID uuid, kotlin.jvm.internal.b0 b0Var, Throwable th) {
        return m1023startSend$lambda22(consumerTransferConfirmationViewModel, availableTransfer, str, z, uuid, b0Var, th);
    }

    private final TransferMoneyRequest getTransferRequest() {
        return (TransferMoneyRequest) this.transferRequest$delegate.getValue();
    }

    public static /* synthetic */ void h(ConsumerTransferConfirmationViewModel consumerTransferConfirmationViewModel) {
        m1021setup$lambda3(consumerTransferConfirmationViewModel);
    }

    public static /* synthetic */ h.c.h0 i(ConsumerTransferConfirmationViewModel consumerTransferConfirmationViewModel, ConsumerSecure3DVerificationResult consumerSecure3DVerificationResult) {
        return m1009observeSecure3DVerificationResult$lambda20(consumerTransferConfirmationViewModel, consumerSecure3DVerificationResult);
    }

    private final boolean isErc20(ReceivableWallet receivableWallet) {
        return kotlin.jvm.internal.m.c(receivableWallet.getBlockchain(), Blockchain_EthereumKt.getETHEREUM(Blockchain.Companion)) && !kotlin.jvm.internal.m.c(receivableWallet.getCode(), WalletConfiguration_EthereumKt.getETH(EthereumBasedConfiguration.Companion).currencyCodeForNetwork(getTransferRequest().getWallet().getNetwork()));
    }

    public static /* synthetic */ kotlin.x j(ConsumerTransferConfirmationViewModel consumerTransferConfirmationViewModel, AvailableBuyAndSendTransfer availableBuyAndSendTransfer, UUID uuid, kotlin.jvm.internal.b0 b0Var, ConsumerBuyOrder consumerBuyOrder, BuyStatus buyStatus) {
        return m1017pollForBuyStatus$lambda26(consumerTransferConfirmationViewModel, availableBuyAndSendTransfer, uuid, b0Var, consumerBuyOrder, buyStatus);
    }

    public static /* synthetic */ h.c.h0 k(ConsumerTransferConfirmationViewModel consumerTransferConfirmationViewModel, AvailableTransfer availableTransfer, UUID uuid, Throwable th) {
        return m1025transfer$lambda4(consumerTransferConfirmationViewModel, availableTransfer, uuid, th);
    }

    public static /* synthetic */ kotlin.x l(ConsumerTransferConfirmationViewModel consumerTransferConfirmationViewModel, boolean z, Throwable th) {
        return m1024startSend$lambda23(consumerTransferConfirmationViewModel, z, th);
    }

    public static /* synthetic */ kotlin.x m(ConsumerTransferMethodResult consumerTransferMethodResult, ConsumerTransferConfirmationViewModel consumerTransferConfirmationViewModel) {
        return m1013observeTransferMethodsResult$lambda17$lambda15(consumerTransferMethodResult, consumerTransferConfirmationViewModel);
    }

    public static /* synthetic */ h.c.h0 n(ConsumerTransferConfirmationViewModel consumerTransferConfirmationViewModel, AvailableBuyAndSendTransfer availableBuyAndSendTransfer, UUID uuid, ConsumerBuyOrder consumerBuyOrder) {
        return m1006completeBuyOrderAfterSecure3DVerification$lambda8(consumerTransferConfirmationViewModel, availableBuyAndSendTransfer, uuid, consumerBuyOrder);
    }

    public static /* synthetic */ kotlin.x o(ConsumerTransferConfirmationViewModel consumerTransferConfirmationViewModel, ConsumerCardCDVResult consumerCardCDVResult) {
        return m1008observeCardVerificationResult$lambda19(consumerTransferConfirmationViewModel, consumerCardCDVResult);
    }

    private final void observeCardVerificationResult(h.c.s<ConsumerCardCDVResult> sVar) {
        h.c.s<R> map = sVar.observeOn(h.c.j0.c.a.b()).map(new h.c.m0.n() { // from class: com.coinbase.wallet.consumer.viewmodels.q1
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return ConsumerTransferConfirmationViewModel.o(ConsumerTransferConfirmationViewModel.this, (ConsumerCardCDVResult) obj);
            }
        });
        kotlin.jvm.internal.m.f(map, "cardVerificationResultObservable\n            .observeOn(AndroidSchedulers.mainThread())\n            .map { cardVerificationResult ->\n                val args = ConsumerTransferMethodsArgs\n                    .createArgs(\n                        transferRequest = transferRequest,\n                        addedPaymentMethodResult = cardVerificationResult\n                    )\n                    .apply { putAll(ForwardArgs.create(R.id.consumerTransferConfirmationFragment)) }\n\n                val route = ViewModelNavRoute(R.id.consumerTransferMethodsFragment, args)\n                navigationSubject.onNext(route)\n            }");
        h.c.t0.a.a(h.c.t0.g.h(map, null, null, ConsumerTransferConfirmationViewModel$observeCardVerificationResult$2.INSTANCE, 3, null), this.disposeBag);
    }

    /* renamed from: observeCardVerificationResult$lambda-19 */
    public static final kotlin.x m1008observeCardVerificationResult$lambda19(ConsumerTransferConfirmationViewModel this$0, ConsumerCardCDVResult cardVerificationResult) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(cardVerificationResult, "cardVerificationResult");
        Bundle createArgs = ConsumerTransferMethodsArgs.INSTANCE.createArgs(this$0.getTransferRequest(), cardVerificationResult);
        createArgs.putAll(ForwardArgs.INSTANCE.create(R.id.consumerTransferConfirmationFragment));
        this$0.navigationSubject.onNext(new ViewModelNavRoute(R.id.consumerTransferMethodsFragment, createArgs, null, 4, null));
        return kotlin.x.a;
    }

    private final void observeSecure3DVerificationResult(h.c.s<ConsumerSecure3DVerificationResult> sVar) {
        h.c.s<R> flatMapSingle = sVar.observeOn(h.c.j0.c.a.b()).flatMapSingle(new h.c.m0.n() { // from class: com.coinbase.wallet.consumer.viewmodels.k1
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return ConsumerTransferConfirmationViewModel.i(ConsumerTransferConfirmationViewModel.this, (ConsumerSecure3DVerificationResult) obj);
            }
        });
        kotlin.jvm.internal.m.f(flatMapSingle, "secure3DVerificationResultObservable\n            .observeOn(AndroidSchedulers.mainThread())\n            .flatMapSingle { result ->\n                when (result) {\n                    is ConsumerSecure3DVerificationResult.Success -> {\n                        completeBuyOrderAfterSecure3DVerification(\n                            result.selectedTransferMethod,\n                            result.buyOrder,\n                            result.paymentResult,\n                            result.uuid\n                        )\n                    }\n                    is ConsumerSecure3DVerificationResult.Failed -> {\n                        TODO(\"Alex - fill this in\")\n                    }\n                    is ConsumerSecure3DVerificationResult.Canceled -> {\n                        TODO(\"Alex - fill this on\")\n                    }\n                }\n            }");
        h.c.t0.a.a(h.c.t0.g.h(flatMapSingle, null, null, ConsumerTransferConfirmationViewModel$observeSecure3DVerificationResult$2.INSTANCE, 3, null), this.disposeBag);
    }

    /* renamed from: observeSecure3DVerificationResult$lambda-20 */
    public static final h.c.h0 m1009observeSecure3DVerificationResult$lambda20(ConsumerTransferConfirmationViewModel this$0, ConsumerSecure3DVerificationResult result) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(result, "result");
        if (result instanceof ConsumerSecure3DVerificationResult.Success) {
            ConsumerSecure3DVerificationResult.Success success = (ConsumerSecure3DVerificationResult.Success) result;
            return this$0.completeBuyOrderAfterSecure3DVerification(success.getSelectedTransferMethod(), success.getBuyOrder(), success.getPaymentResult(), success.getUuid());
        } else if (!(result instanceof ConsumerSecure3DVerificationResult.Failed)) {
            if (result instanceof ConsumerSecure3DVerificationResult.Canceled) {
                throw new kotlin.n("An operation is not implemented: Alex - fill this on");
            }
            throw new NoWhenBranchMatchedException();
        } else {
            throw new kotlin.n("An operation is not implemented: Alex - fill this in");
        }
    }

    private final void observeTransferMethodsResult(h.c.s<ConsumerTransferMethodResult> sVar) {
        h.c.s<R> flatMapSingle = sVar.flatMapSingle(new h.c.m0.n() { // from class: com.coinbase.wallet.consumer.viewmodels.e1
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return ConsumerTransferConfirmationViewModel.c(ConsumerTransferConfirmationViewModel.this, (ConsumerTransferMethodResult) obj);
            }
        });
        kotlin.jvm.internal.m.f(flatMapSingle, "transferResultObservable\n            .flatMapSingle { result ->\n                when (result) {\n                    is ConsumerTransferMethodResult.SelectedTransfer -> {\n                        Single\n                            .fromCallable { consumerTransferViewState(result.transfer) }\n                            .subscribeOn(Schedulers.computation())\n                            .observeOn(AndroidSchedulers.mainThread())\n                            .map { state = it }\n                    }\n                    is ConsumerTransferMethodResult.VerifyingPaymentMethod -> {\n                        Single\n                            .fromCallable {\n                                val args = ConsumerCardCDVArgs.createArgs(result.paymentMethod)\n                                    .apply { putAll(ForwardArgs.create(R.id.consumerTransferConfirmationFragment)) }\n\n                                navigationSubject.onNext(ViewModelNavRoute(R.id.consumerCardCDVFragment, args))\n                            }\n                            .subscribeOn(AndroidSchedulers.mainThread())\n                    }\n                    ConsumerTransferMethodResult.AddingPaymentMethod -> {\n                        Single\n                            .fromCallable {\n                                val args = ForwardArgs.create(R.id.consumerTransferConfirmationFragment)\n                                navigationSubject\n                                    .onNext(ViewModelNavRoute(R.id.consumerAvailablePaymentMethodsFragment, args))\n                            }\n                            .subscribeOn(AndroidSchedulers.mainThread())\n                    }\n                }\n            }");
        h.c.t0.a.a(h.c.t0.g.h(flatMapSingle, null, null, ConsumerTransferConfirmationViewModel$observeTransferMethodsResult$2.INSTANCE, 3, null), this.disposeBag);
    }

    /* renamed from: observeTransferMethodsResult$lambda-17 */
    public static final h.c.h0 m1010observeTransferMethodsResult$lambda17(final ConsumerTransferConfirmationViewModel this$0, final ConsumerTransferMethodResult result) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(result, "result");
        if (result instanceof ConsumerTransferMethodResult.SelectedTransfer) {
            return h.c.b0.fromCallable(new Callable() { // from class: com.coinbase.wallet.consumer.viewmodels.v1
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return ConsumerTransferConfirmationViewModel.t(ConsumerTransferConfirmationViewModel.this, result);
                }
            }).subscribeOn(h.c.u0.a.a()).observeOn(h.c.j0.c.a.b()).map(new h.c.m0.n() { // from class: com.coinbase.wallet.consumer.viewmodels.d1
                @Override // h.c.m0.n
                public final Object apply(Object obj) {
                    return ConsumerTransferConfirmationViewModel.b(ConsumerTransferConfirmationViewModel.this, (ConsumerTransferConfirmationViewState) obj);
                }
            });
        }
        if (result instanceof ConsumerTransferMethodResult.VerifyingPaymentMethod) {
            return h.c.b0.fromCallable(new Callable() { // from class: com.coinbase.wallet.consumer.viewmodels.o1
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return ConsumerTransferConfirmationViewModel.m(ConsumerTransferMethodResult.this, this$0);
                }
            }).subscribeOn(h.c.j0.c.a.b());
        }
        if (kotlin.jvm.internal.m.c(result, ConsumerTransferMethodResult.AddingPaymentMethod.INSTANCE)) {
            return h.c.b0.fromCallable(new Callable() { // from class: com.coinbase.wallet.consumer.viewmodels.c1
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return ConsumerTransferConfirmationViewModel.a(ConsumerTransferConfirmationViewModel.this);
                }
            }).subscribeOn(h.c.j0.c.a.b());
        }
        throw new NoWhenBranchMatchedException();
    }

    /* renamed from: observeTransferMethodsResult$lambda-17$lambda-12 */
    public static final ConsumerTransferConfirmationViewState m1011observeTransferMethodsResult$lambda17$lambda12(ConsumerTransferConfirmationViewModel this$0, ConsumerTransferMethodResult result) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(result, "$result");
        return this$0.consumerTransferViewState(((ConsumerTransferMethodResult.SelectedTransfer) result).getTransfer());
    }

    /* renamed from: observeTransferMethodsResult$lambda-17$lambda-13 */
    public static final kotlin.x m1012observeTransferMethodsResult$lambda17$lambda13(ConsumerTransferConfirmationViewModel this$0, ConsumerTransferConfirmationViewState it) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(it, "it");
        this$0.setState(it);
        return kotlin.x.a;
    }

    /* renamed from: observeTransferMethodsResult$lambda-17$lambda-15 */
    public static final kotlin.x m1013observeTransferMethodsResult$lambda17$lambda15(ConsumerTransferMethodResult result, ConsumerTransferConfirmationViewModel this$0) {
        kotlin.jvm.internal.m.g(result, "$result");
        kotlin.jvm.internal.m.g(this$0, "this$0");
        Bundle createArgs = ConsumerCardCDVArgs.INSTANCE.createArgs(((ConsumerTransferMethodResult.VerifyingPaymentMethod) result).getPaymentMethod());
        createArgs.putAll(ForwardArgs.INSTANCE.create(R.id.consumerTransferConfirmationFragment));
        this$0.navigationSubject.onNext(new ViewModelNavRoute(R.id.consumerCardCDVFragment, createArgs, null, 4, null));
        return kotlin.x.a;
    }

    /* renamed from: observeTransferMethodsResult$lambda-17$lambda-16 */
    public static final kotlin.x m1014observeTransferMethodsResult$lambda17$lambda16(ConsumerTransferConfirmationViewModel this$0) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        this$0.navigationSubject.onNext(new ViewModelNavRoute(R.id.consumerAvailablePaymentMethodsFragment, ForwardArgs.INSTANCE.create(R.id.consumerTransferConfirmationFragment), null, 4, null));
        return kotlin.x.a;
    }

    public static /* synthetic */ h.c.h0 p(ConsumerTransferConfirmationViewModel consumerTransferConfirmationViewModel, AvailableBuyAndSendTransfer availableBuyAndSendTransfer, UUID uuid, Throwable th) {
        return m1005completeBuyOrderAfterSecure3DVerification$lambda7(consumerTransferConfirmationViewModel, availableBuyAndSendTransfer, uuid, th);
    }

    private final h.c.b0<kotlin.x> pollForBalanceIncrease(final ConsumerAccount consumerAccount, final UUID uuid, final AvailableBuyAndSendTransfer availableBuyAndSendTransfer) {
        final kotlin.jvm.internal.b0 b0Var = new kotlin.jvm.internal.b0();
        b0Var.a = 1;
        h.c.b0<kotlin.x> map = Single_AnalyticsKt.onSubscribeTrack(this.consumerTransferRepository.refreshAccountBalance(consumerAccount), AnalyticsEvent_ConsumerKt.consumerTransferConfirmationBuyAccountBalanceCheckStarted(AnalyticsEvent.Companion, getTransferRequest().getAccount().getCurrencyCode(), getTransferRequest().isFiatPrimary(), availableBuyAndSendTransfer.getPaymentMethod().getType(), getTransferRequest().getOriginalRequestAmount() instanceof TransferValue.EntireBalance, uuid)).map(new h.c.m0.n() { // from class: com.coinbase.wallet.consumer.viewmodels.x1
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return ConsumerTransferConfirmationViewModel.v(ConsumerAccount.this, this, availableBuyAndSendTransfer, uuid, b0Var, (ConsumerAccount) obj);
            }
        });
        kotlin.jvm.internal.m.f(map, "consumerTransferRepository.refreshAccountBalance(account)\n            .onSubscribeTrack(\n                AnalyticsEvent.consumerTransferConfirmationBuyAccountBalanceCheckStarted(\n                    currencyCode = transferRequest.account.currencyCode,\n                    fiatSelected = transferRequest.isFiatPrimary,\n                    paymentMethodType = selectedTransferMethod.paymentMethod.type,\n                    maxTransfer = transferRequest.originalRequestAmount is TransferValue.EntireBalance,\n                    uuid = uuid\n                )\n            )\n            .map { latestAccount ->\n                val balanceIncreased = latestAccount.balance > account.balance\n\n                val analyticsEvent = AnalyticsEvent.consumerTransferConfirmationBuyAccountBalanceCheckStatus(\n                    currencyCode = transferRequest.account.currencyCode,\n                    fiatSelected = transferRequest.isFiatPrimary,\n                    paymentMethodType = selectedTransferMethod.paymentMethod.type,\n                    maxTransfer = transferRequest.originalRequestAmount is TransferValue.EntireBalance,\n                    uuid = uuid,\n                    balanceIncreased = balanceIncreased,\n                    attemptNumber = attemptNumber\n                )\n                attemptNumber++\n\n                Analytics.log(analyticsEvent)\n\n                if (!balanceIncreased) {\n                    throw ConsumerException.RetryGettingBuyState\n                }\n            }");
        return map;
    }

    /* renamed from: pollForBalanceIncrease$lambda-27 */
    public static final kotlin.x m1015pollForBalanceIncrease$lambda27(ConsumerAccount account, ConsumerTransferConfirmationViewModel this$0, AvailableBuyAndSendTransfer selectedTransferMethod, UUID uuid, kotlin.jvm.internal.b0 attemptNumber, ConsumerAccount latestAccount) {
        kotlin.jvm.internal.m.g(account, "$account");
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(selectedTransferMethod, "$selectedTransferMethod");
        kotlin.jvm.internal.m.g(uuid, "$uuid");
        kotlin.jvm.internal.m.g(attemptNumber, "$attemptNumber");
        kotlin.jvm.internal.m.g(latestAccount, "latestAccount");
        boolean z = latestAccount.getBalance().compareTo(account.getBalance()) > 0;
        AnalyticsEvent consumerTransferConfirmationBuyAccountBalanceCheckStatus = AnalyticsEvent_ConsumerKt.consumerTransferConfirmationBuyAccountBalanceCheckStatus(AnalyticsEvent.Companion, this$0.getTransferRequest().getAccount().getCurrencyCode(), this$0.getTransferRequest().isFiatPrimary(), selectedTransferMethod.getPaymentMethod().getType(), this$0.getTransferRequest().getOriginalRequestAmount() instanceof TransferValue.EntireBalance, uuid, z, attemptNumber.a);
        attemptNumber.a++;
        Analytics.INSTANCE.log(consumerTransferConfirmationBuyAccountBalanceCheckStatus);
        if (z) {
            return kotlin.x.a;
        }
        throw ConsumerException.RetryGettingBuyState.INSTANCE;
    }

    private final h.c.b0<kotlin.x> pollForBuyOrder(ConsumerBuyOrder consumerBuyOrder, final AvailableBuyAndSendTransfer availableBuyAndSendTransfer, final UUID uuid) {
        h.c.b0<kotlin.x> pollForBalanceIncrease;
        if (kotlin.jvm.internal.m.c(availableBuyAndSendTransfer.getPaymentMethod().getType(), ConsumerPaymentMethodType.WORLDPAY_CARD.toString())) {
            pollForBalanceIncrease = pollForBuyStatus(consumerBuyOrder, uuid, availableBuyAndSendTransfer);
        } else {
            pollForBalanceIncrease = pollForBalanceIncrease(getTransferRequest().getAccount(), uuid, availableBuyAndSendTransfer);
        }
        h.c.b0 observeOn = Single_CoreKt.retryWithBackoffDelay(pollForBalanceIncrease, 5, 10L, TimeUnit.SECONDS, ConsumerTransferConfirmationViewModel$pollForBuyOrder$1.INSTANCE).observeOn(h.c.j0.c.a.b());
        kotlin.jvm.internal.m.f(observeOn, "buyStatusSingle\n            .retryWithBackoffDelay(5, 10, TimeUnit.SECONDS) { err ->\n                err is ConsumerException.RetryGettingBuyState || err !is ConsumerException.BuyCanceled\n            }\n            .observeOn(AndroidSchedulers.mainThread())");
        h.c.b0<kotlin.x> onErrorResumeNext = Single_AnalyticsKt.logError$default(observeOn, null, null, 3, null).onErrorResumeNext(new h.c.m0.n() { // from class: com.coinbase.wallet.consumer.viewmodels.f1
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return ConsumerTransferConfirmationViewModel.d(ConsumerTransferConfirmationViewModel.this, availableBuyAndSendTransfer, uuid, (Throwable) obj);
            }
        });
        kotlin.jvm.internal.m.f(onErrorResumeNext, "buyStatusSingle\n            .retryWithBackoffDelay(5, 10, TimeUnit.SECONDS) { err ->\n                err is ConsumerException.RetryGettingBuyState || err !is ConsumerException.BuyCanceled\n            }\n            .observeOn(AndroidSchedulers.mainThread())\n            .logError()\n            .onErrorResumeNext { throwable ->\n                val innerAnalyticsEvent = AnalyticsEvent.consumerTransferConfirmationBuyGetStatusError(\n                    currencyCode = transferRequest.account.currencyCode,\n                    fiatSelected = transferRequest.isFiatPrimary,\n                    paymentMethodType = selectedTransferMethod.paymentMethod.type,\n                    maxTransfer = transferRequest.originalRequestAmount is TransferValue.EntireBalance,\n                    buyStatus = if (throwable is ConsumerException.BuyCanceled) \"canceled\" else \"error\",\n                    uuid = uuid\n                )\n\n                Analytics.log(innerAnalyticsEvent)\n\n                // For any error other than buy canceled, keep the loading state enabled - this is to make\n                // sure they don't try to buy again.\n                state = when (throwable) {\n                    ConsumerException.BuyCanceled -> {\n                        state.copy(\n                            loading = false,\n                            isDetailsShowing = true,\n                            errorText = LocalizedStrings[R.string.buy_canceled]\n                        )\n                    }\n                    else -> {\n                        state.copy(\n                            loading = true,\n                            isDetailsShowing = true,\n                            errorText = LocalizedStrings[R.string.error_getting_buy_status]\n                        )\n                    }\n                }\n\n                Single.error(throwable)\n            }");
        return onErrorResumeNext;
    }

    /* renamed from: pollForBuyOrder$lambda-24 */
    public static final h.c.h0 m1016pollForBuyOrder$lambda24(ConsumerTransferConfirmationViewModel this$0, AvailableBuyAndSendTransfer selectedTransferMethod, UUID uuid, Throwable throwable) {
        ConsumerTransferConfirmationViewState copy;
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(selectedTransferMethod, "$selectedTransferMethod");
        kotlin.jvm.internal.m.g(uuid, "$uuid");
        kotlin.jvm.internal.m.g(throwable, "throwable");
        Analytics.INSTANCE.log(AnalyticsEvent_ConsumerKt.consumerTransferConfirmationBuyGetStatusError(AnalyticsEvent.Companion, this$0.getTransferRequest().getAccount().getCurrencyCode(), this$0.getTransferRequest().isFiatPrimary(), selectedTransferMethod.getPaymentMethod().getType(), this$0.getTransferRequest().getOriginalRequestAmount() instanceof TransferValue.EntireBalance, uuid, throwable instanceof ConsumerException.BuyCanceled ? "canceled" : "error"));
        if (kotlin.jvm.internal.m.c(throwable, ConsumerException.BuyCanceled.INSTANCE)) {
            copy = r4.copy((r41 & 1) != 0 ? r4.modeText : null, (r41 & 2) != 0 ? r4.progressButtonText : null, (r41 & 4) != 0 ? r4.fromLabel : null, (r41 & 8) != 0 ? r4.fromPrimaryText : null, (r41 & 16) != 0 ? r4.fromSecondaryText : null, (r41 & 32) != 0 ? r4.fromImage : null, (r41 & 64) != 0 ? r4.fromImageUrl : null, (r41 & 128) != 0 ? r4.isDetailsShowing : true, (r41 & 256) != 0 ? r4.primaryAmount : null, (r41 & 512) != 0 ? r4.secondaryAmount : null, (r41 & 1024) != 0 ? r4.minerFeePrimaryAmount : null, (r41 & PKIFailureInfo.wrongIntegrity) != 0 ? r4.minerFeeSecondaryAmount : null, (r41 & 4096) != 0 ? r4.totalPrimaryAmount : null, (r41 & PKIFailureInfo.certRevoked) != 0 ? r4.totalSecondaryAmount : null, (r41 & 16384) != 0 ? r4.coinbaseFeeAmount : null, (r41 & 32768) != 0 ? r4.selectedTransferMethod : null, (r41 & 65536) != 0 ? r4.selectedTransferMethodText : null, (r41 & PKIFailureInfo.unsupportedVersion) != 0 ? r4.loading : Boolean.FALSE, (r41 & PKIFailureInfo.transactionIdInUse) != 0 ? r4.onrampEnabled : false, (r41 & PKIFailureInfo.signerNotTrusted) != 0 ? r4.transferExplanation : null, (r41 & PKIFailureInfo.badCertTemplate) != 0 ? r4.showWorldpay : false, (r41 & PKIFailureInfo.badSenderNonce) != 0 ? r4.errorText : LocalizedStrings.INSTANCE.get(R.string.buy_canceled), (r41 & 4194304) != 0 ? this$0.state.detailsChanged : false);
        } else {
            copy = r4.copy((r41 & 1) != 0 ? r4.modeText : null, (r41 & 2) != 0 ? r4.progressButtonText : null, (r41 & 4) != 0 ? r4.fromLabel : null, (r41 & 8) != 0 ? r4.fromPrimaryText : null, (r41 & 16) != 0 ? r4.fromSecondaryText : null, (r41 & 32) != 0 ? r4.fromImage : null, (r41 & 64) != 0 ? r4.fromImageUrl : null, (r41 & 128) != 0 ? r4.isDetailsShowing : true, (r41 & 256) != 0 ? r4.primaryAmount : null, (r41 & 512) != 0 ? r4.secondaryAmount : null, (r41 & 1024) != 0 ? r4.minerFeePrimaryAmount : null, (r41 & PKIFailureInfo.wrongIntegrity) != 0 ? r4.minerFeeSecondaryAmount : null, (r41 & 4096) != 0 ? r4.totalPrimaryAmount : null, (r41 & PKIFailureInfo.certRevoked) != 0 ? r4.totalSecondaryAmount : null, (r41 & 16384) != 0 ? r4.coinbaseFeeAmount : null, (r41 & 32768) != 0 ? r4.selectedTransferMethod : null, (r41 & 65536) != 0 ? r4.selectedTransferMethodText : null, (r41 & PKIFailureInfo.unsupportedVersion) != 0 ? r4.loading : Boolean.TRUE, (r41 & PKIFailureInfo.transactionIdInUse) != 0 ? r4.onrampEnabled : false, (r41 & PKIFailureInfo.signerNotTrusted) != 0 ? r4.transferExplanation : null, (r41 & PKIFailureInfo.badCertTemplate) != 0 ? r4.showWorldpay : false, (r41 & PKIFailureInfo.badSenderNonce) != 0 ? r4.errorText : LocalizedStrings.INSTANCE.get(R.string.error_getting_buy_status), (r41 & 4194304) != 0 ? this$0.state.detailsChanged : false);
        }
        this$0.setState(copy);
        return h.c.b0.error(throwable);
    }

    private final h.c.b0<kotlin.x> pollForBuyStatus(final ConsumerBuyOrder consumerBuyOrder, final UUID uuid, final AvailableBuyAndSendTransfer availableBuyAndSendTransfer) {
        final kotlin.jvm.internal.b0 b0Var = new kotlin.jvm.internal.b0();
        b0Var.a = 1;
        h.c.b0<kotlin.x> map = Single_AnalyticsKt.onSubscribeTrack(this.consumerTransferRepository.getCommitBuyStatus(getTransferRequest().getAccount(), consumerBuyOrder), AnalyticsEvent_ConsumerKt.consumerTransferConfirmationBuyGetStatusStarted(AnalyticsEvent.Companion, getTransferRequest().getAccount().getCurrencyCode(), getTransferRequest().isFiatPrimary(), availableBuyAndSendTransfer.getPaymentMethod().getType(), getTransferRequest().getOriginalRequestAmount() instanceof TransferValue.EntireBalance, uuid)).map(new h.c.m0.n() { // from class: com.coinbase.wallet.consumer.viewmodels.l1
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return ConsumerTransferConfirmationViewModel.j(ConsumerTransferConfirmationViewModel.this, availableBuyAndSendTransfer, uuid, b0Var, consumerBuyOrder, (BuyStatus) obj);
            }
        });
        kotlin.jvm.internal.m.f(map, "consumerTransferRepository.getCommitBuyStatus(transferRequest.account, buyOrder)\n            .onSubscribeTrack(\n                AnalyticsEvent.consumerTransferConfirmationBuyGetStatusStarted(\n                    currencyCode = transferRequest.account.currencyCode,\n                    fiatSelected = transferRequest.isFiatPrimary,\n                    paymentMethodType = selectedTransferMethod.paymentMethod.type,\n                    maxTransfer = transferRequest.originalRequestAmount is TransferValue.EntireBalance,\n                    uuid = uuid\n                )\n            )\n            .map { buyStatus ->\n                /**\n                 * The possible buy states are:\n                 *\n                 *           created\n                 *              |\n                 *           started\n                 *         //       \\\n                 *   canceled      completed\n                 *\n                 * According to\n                 * https://github.cbhq.net/engineering/coinbase/\\\n                 * blob/master/components/transfers/models/transfer.rb#L100\n                 */\n                val innerAnalyticsEvent = AnalyticsEvent.consumerTransferConfirmationBuyGetStatusEvent(\n                    currencyCode = transferRequest.account.currencyCode,\n                    fiatSelected = transferRequest.isFiatPrimary,\n                    paymentMethodType = selectedTransferMethod.paymentMethod.type,\n                    maxTransfer = transferRequest.originalRequestAmount is TransferValue.EntireBalance,\n                    uuid = uuid,\n                    buyStatus = buyStatus.status,\n                    requiresCompletionStep = buyStatus.requiresCompletionStep,\n                    attemptNumber = attemptNumber\n                )\n                attemptNumber++\n\n                Analytics.log(innerAnalyticsEvent)\n                val statusStr = buyStatus.status\n                if (statusStr == \"created\" || statusStr == \"started\") {\n                    val secure3DVerification = buyStatus.secure3DVerification\n\n                    if (buyStatus.requiresCompletionStep && secure3DVerification != null) {\n                        val args = ConsumerSecure3DVerificationArgs\n                            .createArgs(\n                                secure3DVerification,\n                                selectedTransferMethod,\n                                buyOrder,\n                                uuid\n                            )\n                            .apply {\n                                putAll(ForwardArgs.create(modalSource = R.id.consumerTransferConfirmationFragment))\n                            }\n\n                        navigationSubject.onNext(ViewModelNavRoute(R.id.consumerSecure3DVerificationFragment, args))\n                    }\n                    throw ConsumerException.RetryGettingBuyState\n                }\n                if (statusStr == \"canceled\") {\n                    throw ConsumerException.BuyCanceled\n                }\n            }");
        return map;
    }

    /* renamed from: pollForBuyStatus$lambda-26 */
    public static final kotlin.x m1017pollForBuyStatus$lambda26(ConsumerTransferConfirmationViewModel this$0, AvailableBuyAndSendTransfer selectedTransferMethod, UUID uuid, kotlin.jvm.internal.b0 attemptNumber, ConsumerBuyOrder buyOrder, BuyStatus buyStatus) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(selectedTransferMethod, "$selectedTransferMethod");
        kotlin.jvm.internal.m.g(uuid, "$uuid");
        kotlin.jvm.internal.m.g(attemptNumber, "$attemptNumber");
        kotlin.jvm.internal.m.g(buyOrder, "$buyOrder");
        kotlin.jvm.internal.m.g(buyStatus, "buyStatus");
        AnalyticsEvent consumerTransferConfirmationBuyGetStatusEvent = AnalyticsEvent_ConsumerKt.consumerTransferConfirmationBuyGetStatusEvent(AnalyticsEvent.Companion, this$0.getTransferRequest().getAccount().getCurrencyCode(), this$0.getTransferRequest().isFiatPrimary(), selectedTransferMethod.getPaymentMethod().getType(), this$0.getTransferRequest().getOriginalRequestAmount() instanceof TransferValue.EntireBalance, uuid, buyStatus.getStatus(), buyStatus.getRequiresCompletionStep(), attemptNumber.a);
        attemptNumber.a++;
        Analytics.INSTANCE.log(consumerTransferConfirmationBuyGetStatusEvent);
        String status = buyStatus.getStatus();
        if (!kotlin.jvm.internal.m.c(status, Trade.STATUS_CREATED) && !kotlin.jvm.internal.m.c(status, "started")) {
            if (!kotlin.jvm.internal.m.c(status, "canceled")) {
                return kotlin.x.a;
            }
            throw ConsumerException.BuyCanceled.INSTANCE;
        }
        Secure3DVerification secure3DVerification = buyStatus.getSecure3DVerification();
        if (buyStatus.getRequiresCompletionStep() && secure3DVerification != null) {
            Bundle createArgs = ConsumerSecure3DVerificationArgs.INSTANCE.createArgs(secure3DVerification, selectedTransferMethod, buyOrder, uuid);
            createArgs.putAll(ForwardArgs.INSTANCE.create(R.id.consumerTransferConfirmationFragment));
            this$0.navigationSubject.onNext(new ViewModelNavRoute(R.id.consumerSecure3DVerificationFragment, createArgs, null, 4, null));
        }
        throw ConsumerException.RetryGettingBuyState.INSTANCE;
    }

    public static /* synthetic */ kotlin.x q(ConsumerTransferConfirmationViewModel consumerTransferConfirmationViewModel, String str, boolean z, UUID uuid, kotlin.x xVar) {
        return m1022startSend$lambda21(consumerTransferConfirmationViewModel, str, z, uuid, xVar);
    }

    public static /* synthetic */ h.c.h0 r(ConsumerTransferConfirmationViewModel consumerTransferConfirmationViewModel, AvailableBuyAndSendTransfer availableBuyAndSendTransfer, UUID uuid, kotlin.x xVar) {
        return m1007completeBuyOrderAfterSecure3DVerification$lambda9(consumerTransferConfirmationViewModel, availableBuyAndSendTransfer, uuid, xVar);
    }

    private final void setState(ConsumerTransferConfirmationViewState consumerTransferConfirmationViewState) {
        ConsumerTransferConfirmationViewState copy;
        copy = consumerTransferConfirmationViewState.copy((r41 & 1) != 0 ? consumerTransferConfirmationViewState.modeText : null, (r41 & 2) != 0 ? consumerTransferConfirmationViewState.progressButtonText : null, (r41 & 4) != 0 ? consumerTransferConfirmationViewState.fromLabel : null, (r41 & 8) != 0 ? consumerTransferConfirmationViewState.fromPrimaryText : null, (r41 & 16) != 0 ? consumerTransferConfirmationViewState.fromSecondaryText : null, (r41 & 32) != 0 ? consumerTransferConfirmationViewState.fromImage : null, (r41 & 64) != 0 ? consumerTransferConfirmationViewState.fromImageUrl : null, (r41 & 128) != 0 ? consumerTransferConfirmationViewState.isDetailsShowing : false, (r41 & 256) != 0 ? consumerTransferConfirmationViewState.primaryAmount : null, (r41 & 512) != 0 ? consumerTransferConfirmationViewState.secondaryAmount : null, (r41 & 1024) != 0 ? consumerTransferConfirmationViewState.minerFeePrimaryAmount : null, (r41 & PKIFailureInfo.wrongIntegrity) != 0 ? consumerTransferConfirmationViewState.minerFeeSecondaryAmount : null, (r41 & 4096) != 0 ? consumerTransferConfirmationViewState.totalPrimaryAmount : null, (r41 & PKIFailureInfo.certRevoked) != 0 ? consumerTransferConfirmationViewState.totalSecondaryAmount : null, (r41 & 16384) != 0 ? consumerTransferConfirmationViewState.coinbaseFeeAmount : null, (r41 & 32768) != 0 ? consumerTransferConfirmationViewState.selectedTransferMethod : null, (r41 & 65536) != 0 ? consumerTransferConfirmationViewState.selectedTransferMethodText : null, (r41 & PKIFailureInfo.unsupportedVersion) != 0 ? consumerTransferConfirmationViewState.loading : null, (r41 & PKIFailureInfo.transactionIdInUse) != 0 ? consumerTransferConfirmationViewState.onrampEnabled : false, (r41 & PKIFailureInfo.signerNotTrusted) != 0 ? consumerTransferConfirmationViewState.transferExplanation : null, (r41 & PKIFailureInfo.badCertTemplate) != 0 ? consumerTransferConfirmationViewState.showWorldpay : false, (r41 & PKIFailureInfo.badSenderNonce) != 0 ? consumerTransferConfirmationViewState.errorText : null, (r41 & 4194304) != 0 ? consumerTransferConfirmationViewState.detailsChanged : consumerTransferConfirmationViewState.detailsChanged(this.state));
        this.state = copy;
        this.stateSubject.onNext(copy);
    }

    /* renamed from: setup$lambda-0 */
    public static final ConsumerTransferConfirmationViewState m1018setup$lambda0(ConsumerTransferConfirmationViewModel this$0) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        return this$0.consumerTransferViewState(null);
    }

    /* renamed from: setup$lambda-1 */
    public static final kotlin.x m1019setup$lambda1(ConsumerTransferConfirmationViewModel this$0, ConsumerTransferConfirmationViewState newState) {
        ConsumerTransferConfirmationViewState copy;
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(newState, "newState");
        Boolean loading = newState.getLoading();
        if (loading == null) {
            loading = this$0.state.getLoading();
        }
        copy = newState.copy((r41 & 1) != 0 ? newState.modeText : null, (r41 & 2) != 0 ? newState.progressButtonText : null, (r41 & 4) != 0 ? newState.fromLabel : null, (r41 & 8) != 0 ? newState.fromPrimaryText : null, (r41 & 16) != 0 ? newState.fromSecondaryText : null, (r41 & 32) != 0 ? newState.fromImage : null, (r41 & 64) != 0 ? newState.fromImageUrl : null, (r41 & 128) != 0 ? newState.isDetailsShowing : false, (r41 & 256) != 0 ? newState.primaryAmount : null, (r41 & 512) != 0 ? newState.secondaryAmount : null, (r41 & 1024) != 0 ? newState.minerFeePrimaryAmount : null, (r41 & PKIFailureInfo.wrongIntegrity) != 0 ? newState.minerFeeSecondaryAmount : null, (r41 & 4096) != 0 ? newState.totalPrimaryAmount : null, (r41 & PKIFailureInfo.certRevoked) != 0 ? newState.totalSecondaryAmount : null, (r41 & 16384) != 0 ? newState.coinbaseFeeAmount : null, (r41 & 32768) != 0 ? newState.selectedTransferMethod : null, (r41 & 65536) != 0 ? newState.selectedTransferMethodText : null, (r41 & PKIFailureInfo.unsupportedVersion) != 0 ? newState.loading : loading, (r41 & PKIFailureInfo.transactionIdInUse) != 0 ? newState.onrampEnabled : false, (r41 & PKIFailureInfo.signerNotTrusted) != 0 ? newState.transferExplanation : null, (r41 & PKIFailureInfo.badCertTemplate) != 0 ? newState.showWorldpay : false, (r41 & PKIFailureInfo.badSenderNonce) != 0 ? newState.errorText : null, (r41 & 4194304) != 0 ? newState.detailsChanged : false);
        this$0.setState(copy);
        return kotlin.x.a;
    }

    /* renamed from: setup$lambda-2 */
    public static final void m1020setup$lambda2(ConsumerTransferConfirmationViewModel this$0, h.c.s transferResultObservable, h.c.s cardVerificationResultObservable, h.c.s secure3DVerificationResultObservable, h.c.k0.b bVar) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(transferResultObservable, "$transferResultObservable");
        kotlin.jvm.internal.m.g(cardVerificationResultObservable, "$cardVerificationResultObservable");
        kotlin.jvm.internal.m.g(secure3DVerificationResultObservable, "$secure3DVerificationResultObservable");
        this$0.observeTransferMethodsResult(transferResultObservable);
        this$0.observeCardVerificationResult(cardVerificationResultObservable);
        this$0.observeSecure3DVerificationResult(secure3DVerificationResultObservable);
    }

    /* renamed from: setup$lambda-3 */
    public static final void m1021setup$lambda3(ConsumerTransferConfirmationViewModel this$0) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        this$0.disposeBag.d();
    }

    private final h.c.b0<kotlin.x> startSend(final boolean z, final AvailableTransfer availableTransfer, final UUID uuid) {
        ConsumerPaymentMethod paymentMethod;
        h.c.b0 send;
        final kotlin.jvm.internal.b0 b0Var = new kotlin.jvm.internal.b0();
        b0Var.a = 1;
        AvailableBuyAndSendTransfer availableBuyAndSendTransfer = availableTransfer instanceof AvailableBuyAndSendTransfer ? (AvailableBuyAndSendTransfer) availableTransfer : null;
        final String type = (availableBuyAndSendTransfer == null || (paymentMethod = availableBuyAndSendTransfer.getPaymentMethod()) == null) ? null : paymentMethod.getType();
        final boolean z2 = availableTransfer instanceof AvailableSendTransfer;
        send = this.consumerTransferRepository.send(getTransferRequest().getAccount(), getTransferRequest().getWallet(), availableTransfer.getTransferAmount(), ((AvailableTransfer) List_CommonKt.require(getTransferRequest().getAvailableTransfers(), 0)).getSendFee(), getTransferRequest().getAccount().getCurrencyCode(), getTransferRequest().getWallet().getBlockchain(), (r21 & 64) != 0 ? null : getTransferRequest().getSupportsDestinationTag() ? Boolean.TRUE : null, (r21 & 128) != 0 ? null : null);
        h.c.b0 onErrorResumeNext = Single_AnalyticsKt.onSubscribeTrack(send, AnalyticsEvent_ConsumerKt.consumerTransferConfirmSendStarted(AnalyticsEvent.Companion, getTransferRequest().getAccount().getCurrencyCode(), getTransferRequest().isFiatPrimary(), type, getTransferRequest().getOriginalRequestAmount() instanceof TransferValue.EntireBalance, z2, uuid)).observeOn(h.c.j0.c.a.b()).map(new h.c.m0.n() { // from class: com.coinbase.wallet.consumer.viewmodels.s1
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return ConsumerTransferConfirmationViewModel.q(ConsumerTransferConfirmationViewModel.this, type, z2, uuid, (kotlin.x) obj);
            }
        }).onErrorResumeNext(new h.c.m0.n() { // from class: com.coinbase.wallet.consumer.viewmodels.i1
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return ConsumerTransferConfirmationViewModel.g(ConsumerTransferConfirmationViewModel.this, availableTransfer, type, z2, uuid, b0Var, (Throwable) obj);
            }
        });
        kotlin.jvm.internal.m.f(onErrorResumeNext, "consumerTransferRepository\n            .send(\n                account = transferRequest.account,\n                receiveWallet = transferRequest.wallet,\n                amount = selectedTransferMethod.transferAmount,\n                estimatedFee = transferRequest.availableTransfers.require(0).sendFee,\n                currencyCode = transferRequest.account.currencyCode,\n                blockchain = transferRequest.wallet.blockchain,\n                noDestinationTag = if (transferRequest.supportsDestinationTag) true else null\n            )\n            .onSubscribeTrack(\n                AnalyticsEvent.consumerTransferConfirmSendStarted(\n                    currencyCode = transferRequest.account.currencyCode,\n                    fiatSelected = transferRequest.isFiatPrimary,\n                    paymentMethodType = paymentMethodType,\n                    maxTransfer = transferRequest.originalRequestAmount is TransferValue.EntireBalance,\n                    sendSelected = sendSelected,\n                    uuid = uuid\n                )\n            )\n            .observeOn(AndroidSchedulers.mainThread())\n            .map {\n                Analytics.log(\n                    AnalyticsEvent.consumerTransferConfirmSendCompleted(\n                        currencyCode = transferRequest.account.currencyCode,\n                        fiatSelected = transferRequest.isFiatPrimary,\n                        paymentMethodType = paymentMethodType,\n                        maxTransfer = transferRequest.originalRequestAmount is TransferValue.EntireBalance,\n                        sendSelected = sendSelected,\n                        uuid = uuid\n                    )\n                )\n\n                val route = ViewModelNavRoute(\n                    R.id.consumerTransferInitiatedFragment\n                )\n                navigationSubject.onNext(route)\n            }\n            .onErrorResumeNext {\n                if (it is ConsumerException.SendNeedsTwoFactor) {\n                    val route = ViewModelNavRoute(\n                        R.id.consumerSendTwoFactorFragment,\n                        ConsumerSendTwoFactorFragment.createArguments(transferRequest, selectedTransferMethod)\n                    )\n                    navigationSubject.onNext(route)\n                    Single.just(Unit)\n                } else {\n                    Analytics.log(\n                        AnalyticsEvent.consumerTransferConfirmSendError(\n                            currencyCode = transferRequest.account.currencyCode,\n                            fiatSelected = transferRequest.isFiatPrimary,\n                            paymentMethodType = paymentMethodType,\n                            maxTransfer = transferRequest.originalRequestAmount is TransferValue.EntireBalance,\n                            sendSelected = sendSelected,\n                            uuid = uuid,\n                            attemptNumber = sendAttemptNumber\n                        )\n                    )\n                    sendAttemptNumber++\n\n                    Single.error(it)\n                }\n            }");
        h.c.b0<kotlin.x> onErrorReturn = Single_AnalyticsKt.logError$default(Single_CoreKt.retryWithBackoffDelay(Single_AnalyticsKt.logError$default(onErrorResumeNext, null, null, 3, null), 3, 5L, TimeUnit.SECONDS, new ConsumerTransferConfirmationViewModel$startSend$3(z)), null, null, 3, null).observeOn(h.c.j0.c.a.b()).onErrorReturn(new h.c.m0.n() { // from class: com.coinbase.wallet.consumer.viewmodels.n1
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return ConsumerTransferConfirmationViewModel.l(ConsumerTransferConfirmationViewModel.this, z, (Throwable) obj);
            }
        });
        kotlin.jvm.internal.m.f(onErrorReturn, "triedBuying: Boolean,\n        selectedTransferMethod: AvailableTransfer,\n        uuid: UUID\n    ): Single<Unit> {\n        var sendAttemptNumber = 1\n        val paymentMethodType = (selectedTransferMethod as? AvailableBuyAndSendTransfer)?.paymentMethod?.type\n        val sendSelected = selectedTransferMethod is AvailableSendTransfer\n        return consumerTransferRepository\n            .send(\n                account = transferRequest.account,\n                receiveWallet = transferRequest.wallet,\n                amount = selectedTransferMethod.transferAmount,\n                estimatedFee = transferRequest.availableTransfers.require(0).sendFee,\n                currencyCode = transferRequest.account.currencyCode,\n                blockchain = transferRequest.wallet.blockchain,\n                noDestinationTag = if (transferRequest.supportsDestinationTag) true else null\n            )\n            .onSubscribeTrack(\n                AnalyticsEvent.consumerTransferConfirmSendStarted(\n                    currencyCode = transferRequest.account.currencyCode,\n                    fiatSelected = transferRequest.isFiatPrimary,\n                    paymentMethodType = paymentMethodType,\n                    maxTransfer = transferRequest.originalRequestAmount is TransferValue.EntireBalance,\n                    sendSelected = sendSelected,\n                    uuid = uuid\n                )\n            )\n            .observeOn(AndroidSchedulers.mainThread())\n            .map {\n                Analytics.log(\n                    AnalyticsEvent.consumerTransferConfirmSendCompleted(\n                        currencyCode = transferRequest.account.currencyCode,\n                        fiatSelected = transferRequest.isFiatPrimary,\n                        paymentMethodType = paymentMethodType,\n                        maxTransfer = transferRequest.originalRequestAmount is TransferValue.EntireBalance,\n                        sendSelected = sendSelected,\n                        uuid = uuid\n                    )\n                )\n\n                val route = ViewModelNavRoute(\n                    R.id.consumerTransferInitiatedFragment\n                )\n                navigationSubject.onNext(route)\n            }\n            .onErrorResumeNext {\n                if (it is ConsumerException.SendNeedsTwoFactor) {\n                    val route = ViewModelNavRoute(\n                        R.id.consumerSendTwoFactorFragment,\n                        ConsumerSendTwoFactorFragment.createArguments(transferRequest, selectedTransferMethod)\n                    )\n                    navigationSubject.onNext(route)\n                    Single.just(Unit)\n                } else {\n                    Analytics.log(\n                        AnalyticsEvent.consumerTransferConfirmSendError(\n                            currencyCode = transferRequest.account.currencyCode,\n                            fiatSelected = transferRequest.isFiatPrimary,\n                            paymentMethodType = paymentMethodType,\n                            maxTransfer = transferRequest.originalRequestAmount is TransferValue.EntireBalance,\n                            sendSelected = sendSelected,\n                            uuid = uuid,\n                            attemptNumber = sendAttemptNumber\n                        )\n                    )\n                    sendAttemptNumber++\n\n                    Single.error(it)\n                }\n            }\n            .logError()\n            .retryWithBackoffDelay(3, 5, TimeUnit.SECONDS) {\n                // Only retry sending if we bought\n                triedBuying\n            }\n            .logError()\n            .observeOn(AndroidSchedulers.mainThread())\n            .onErrorReturn {\n                // Don't allow the user to try again if they succeeded buying\n                state = if (triedBuying) {\n                    state.copy(\n                        loading = true,\n                        isDetailsShowing = true,\n                        errorText = LocalizedStrings[R.string.error_sending_purchase_completed]\n                    )\n                } else {\n                    state.copy(loading = false, isDetailsShowing = true, errorText = it.localizedMessage)\n                }\n                Unit\n            }");
        return onErrorReturn;
    }

    /* renamed from: startSend$lambda-21 */
    public static final kotlin.x m1022startSend$lambda21(ConsumerTransferConfirmationViewModel this$0, String str, boolean z, UUID uuid, kotlin.x it) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(uuid, "$uuid");
        kotlin.jvm.internal.m.g(it, "it");
        Analytics.INSTANCE.log(AnalyticsEvent_ConsumerKt.consumerTransferConfirmSendCompleted(AnalyticsEvent.Companion, this$0.getTransferRequest().getAccount().getCurrencyCode(), this$0.getTransferRequest().isFiatPrimary(), str, this$0.getTransferRequest().getOriginalRequestAmount() instanceof TransferValue.EntireBalance, z, uuid));
        this$0.navigationSubject.onNext(new ViewModelNavRoute(R.id.consumerTransferInitiatedFragment, null, null, 6, null));
        return kotlin.x.a;
    }

    /* renamed from: startSend$lambda-22 */
    public static final h.c.h0 m1023startSend$lambda22(ConsumerTransferConfirmationViewModel this$0, AvailableTransfer selectedTransferMethod, String str, boolean z, UUID uuid, kotlin.jvm.internal.b0 sendAttemptNumber, Throwable it) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(selectedTransferMethod, "$selectedTransferMethod");
        kotlin.jvm.internal.m.g(uuid, "$uuid");
        kotlin.jvm.internal.m.g(sendAttemptNumber, "$sendAttemptNumber");
        kotlin.jvm.internal.m.g(it, "it");
        if (it instanceof ConsumerException.SendNeedsTwoFactor) {
            this$0.navigationSubject.onNext(new ViewModelNavRoute(R.id.consumerSendTwoFactorFragment, ConsumerSendTwoFactorFragment.Companion.createArguments(this$0.getTransferRequest(), selectedTransferMethod), null, 4, null));
            return h.c.b0.just(kotlin.x.a);
        }
        Analytics.INSTANCE.log(AnalyticsEvent_ConsumerKt.consumerTransferConfirmSendError(AnalyticsEvent.Companion, this$0.getTransferRequest().getAccount().getCurrencyCode(), this$0.getTransferRequest().isFiatPrimary(), str, this$0.getTransferRequest().getOriginalRequestAmount() instanceof TransferValue.EntireBalance, z, uuid, sendAttemptNumber.a));
        sendAttemptNumber.a++;
        return h.c.b0.error(it);
    }

    /* renamed from: startSend$lambda-23 */
    public static final kotlin.x m1024startSend$lambda23(ConsumerTransferConfirmationViewModel this$0, boolean z, Throwable it) {
        ConsumerTransferConfirmationViewState copy;
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(it, "it");
        if (z) {
            copy = r3.copy((r41 & 1) != 0 ? r3.modeText : null, (r41 & 2) != 0 ? r3.progressButtonText : null, (r41 & 4) != 0 ? r3.fromLabel : null, (r41 & 8) != 0 ? r3.fromPrimaryText : null, (r41 & 16) != 0 ? r3.fromSecondaryText : null, (r41 & 32) != 0 ? r3.fromImage : null, (r41 & 64) != 0 ? r3.fromImageUrl : null, (r41 & 128) != 0 ? r3.isDetailsShowing : true, (r41 & 256) != 0 ? r3.primaryAmount : null, (r41 & 512) != 0 ? r3.secondaryAmount : null, (r41 & 1024) != 0 ? r3.minerFeePrimaryAmount : null, (r41 & PKIFailureInfo.wrongIntegrity) != 0 ? r3.minerFeeSecondaryAmount : null, (r41 & 4096) != 0 ? r3.totalPrimaryAmount : null, (r41 & PKIFailureInfo.certRevoked) != 0 ? r3.totalSecondaryAmount : null, (r41 & 16384) != 0 ? r3.coinbaseFeeAmount : null, (r41 & 32768) != 0 ? r3.selectedTransferMethod : null, (r41 & 65536) != 0 ? r3.selectedTransferMethodText : null, (r41 & PKIFailureInfo.unsupportedVersion) != 0 ? r3.loading : Boolean.TRUE, (r41 & PKIFailureInfo.transactionIdInUse) != 0 ? r3.onrampEnabled : false, (r41 & PKIFailureInfo.signerNotTrusted) != 0 ? r3.transferExplanation : null, (r41 & PKIFailureInfo.badCertTemplate) != 0 ? r3.showWorldpay : false, (r41 & PKIFailureInfo.badSenderNonce) != 0 ? r3.errorText : LocalizedStrings.INSTANCE.get(R.string.error_sending_purchase_completed), (r41 & 4194304) != 0 ? this$0.state.detailsChanged : false);
        } else {
            copy = r2.copy((r41 & 1) != 0 ? r2.modeText : null, (r41 & 2) != 0 ? r2.progressButtonText : null, (r41 & 4) != 0 ? r2.fromLabel : null, (r41 & 8) != 0 ? r2.fromPrimaryText : null, (r41 & 16) != 0 ? r2.fromSecondaryText : null, (r41 & 32) != 0 ? r2.fromImage : null, (r41 & 64) != 0 ? r2.fromImageUrl : null, (r41 & 128) != 0 ? r2.isDetailsShowing : true, (r41 & 256) != 0 ? r2.primaryAmount : null, (r41 & 512) != 0 ? r2.secondaryAmount : null, (r41 & 1024) != 0 ? r2.minerFeePrimaryAmount : null, (r41 & PKIFailureInfo.wrongIntegrity) != 0 ? r2.minerFeeSecondaryAmount : null, (r41 & 4096) != 0 ? r2.totalPrimaryAmount : null, (r41 & PKIFailureInfo.certRevoked) != 0 ? r2.totalSecondaryAmount : null, (r41 & 16384) != 0 ? r2.coinbaseFeeAmount : null, (r41 & 32768) != 0 ? r2.selectedTransferMethod : null, (r41 & 65536) != 0 ? r2.selectedTransferMethodText : null, (r41 & PKIFailureInfo.unsupportedVersion) != 0 ? r2.loading : Boolean.FALSE, (r41 & PKIFailureInfo.transactionIdInUse) != 0 ? r2.onrampEnabled : false, (r41 & PKIFailureInfo.signerNotTrusted) != 0 ? r2.transferExplanation : null, (r41 & PKIFailureInfo.badCertTemplate) != 0 ? r2.showWorldpay : false, (r41 & PKIFailureInfo.badSenderNonce) != 0 ? r2.errorText : it.getLocalizedMessage(), (r41 & 4194304) != 0 ? this$0.state.detailsChanged : false);
        }
        this$0.setState(copy);
        return kotlin.x.a;
    }

    public static /* synthetic */ ConsumerTransferConfirmationViewState t(ConsumerTransferConfirmationViewModel consumerTransferConfirmationViewModel, ConsumerTransferMethodResult consumerTransferMethodResult) {
        return m1011observeTransferMethodsResult$lambda17$lambda12(consumerTransferConfirmationViewModel, consumerTransferMethodResult);
    }

    /* renamed from: transfer$lambda-4 */
    public static final h.c.h0 m1025transfer$lambda4(ConsumerTransferConfirmationViewModel this$0, AvailableTransfer selectedTransferMethod, UUID uuid, Throwable throwable) {
        ConsumerTransferConfirmationViewState copy;
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(selectedTransferMethod, "$selectedTransferMethod");
        kotlin.jvm.internal.m.g(throwable, "throwable");
        Analytics analytics = Analytics.INSTANCE;
        kotlin.jvm.internal.m.f(uuid, "uuid");
        analytics.log(AnalyticsEvent_ConsumerKt.consumerTransferConfirmationBuyCommitError(AnalyticsEvent.Companion, this$0.getTransferRequest().getAccount().getCurrencyCode(), this$0.getTransferRequest().isFiatPrimary(), ((AvailableBuyAndSendTransfer) selectedTransferMethod).getPaymentMethod().getType(), this$0.getTransferRequest().getOriginalRequestAmount() instanceof TransferValue.EntireBalance, uuid));
        copy = r4.copy((r41 & 1) != 0 ? r4.modeText : null, (r41 & 2) != 0 ? r4.progressButtonText : null, (r41 & 4) != 0 ? r4.fromLabel : null, (r41 & 8) != 0 ? r4.fromPrimaryText : null, (r41 & 16) != 0 ? r4.fromSecondaryText : null, (r41 & 32) != 0 ? r4.fromImage : null, (r41 & 64) != 0 ? r4.fromImageUrl : null, (r41 & 128) != 0 ? r4.isDetailsShowing : true, (r41 & 256) != 0 ? r4.primaryAmount : null, (r41 & 512) != 0 ? r4.secondaryAmount : null, (r41 & 1024) != 0 ? r4.minerFeePrimaryAmount : null, (r41 & PKIFailureInfo.wrongIntegrity) != 0 ? r4.minerFeeSecondaryAmount : null, (r41 & 4096) != 0 ? r4.totalPrimaryAmount : null, (r41 & PKIFailureInfo.certRevoked) != 0 ? r4.totalSecondaryAmount : null, (r41 & 16384) != 0 ? r4.coinbaseFeeAmount : null, (r41 & 32768) != 0 ? r4.selectedTransferMethod : null, (r41 & 65536) != 0 ? r4.selectedTransferMethodText : null, (r41 & PKIFailureInfo.unsupportedVersion) != 0 ? r4.loading : Boolean.FALSE, (r41 & PKIFailureInfo.transactionIdInUse) != 0 ? r4.onrampEnabled : false, (r41 & PKIFailureInfo.signerNotTrusted) != 0 ? r4.transferExplanation : null, (r41 & PKIFailureInfo.badCertTemplate) != 0 ? r4.showWorldpay : false, (r41 & PKIFailureInfo.badSenderNonce) != 0 ? r4.errorText : throwable.getLocalizedMessage(), (r41 & 4194304) != 0 ? this$0.state.detailsChanged : false);
        this$0.setState(copy);
        return h.c.b0.error(throwable);
    }

    /* renamed from: transfer$lambda-5 */
    public static final h.c.h0 m1026transfer$lambda5(ConsumerTransferConfirmationViewModel this$0, AvailableTransfer selectedTransferMethod, UUID uuid, ConsumerBuyOrder buyOrder) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(selectedTransferMethod, "$selectedTransferMethod");
        kotlin.jvm.internal.m.g(buyOrder, "buyOrder");
        kotlin.jvm.internal.m.f(uuid, "uuid");
        return this$0.pollForBuyOrder(buyOrder, (AvailableBuyAndSendTransfer) selectedTransferMethod, uuid);
    }

    /* renamed from: transfer$lambda-6 */
    public static final h.c.h0 m1027transfer$lambda6(h.c.b0 sendSingle, kotlin.x it) {
        kotlin.jvm.internal.m.g(sendSingle, "$sendSingle");
        kotlin.jvm.internal.m.g(it, "it");
        return sendSingle;
    }

    public static /* synthetic */ kotlin.x u(ConsumerTransferConfirmationViewModel consumerTransferConfirmationViewModel, ConsumerTransferConfirmationViewState consumerTransferConfirmationViewState) {
        return m1019setup$lambda1(consumerTransferConfirmationViewModel, consumerTransferConfirmationViewState);
    }

    public static /* synthetic */ kotlin.x v(ConsumerAccount consumerAccount, ConsumerTransferConfirmationViewModel consumerTransferConfirmationViewModel, AvailableBuyAndSendTransfer availableBuyAndSendTransfer, UUID uuid, kotlin.jvm.internal.b0 b0Var, ConsumerAccount consumerAccount2) {
        return m1015pollForBalanceIncrease$lambda27(consumerAccount, consumerTransferConfirmationViewModel, availableBuyAndSendTransfer, uuid, b0Var, consumerAccount2);
    }

    public static /* synthetic */ h.c.h0 w(ConsumerTransferConfirmationViewModel consumerTransferConfirmationViewModel, AvailableTransfer availableTransfer, UUID uuid, ConsumerBuyOrder consumerBuyOrder) {
        return m1026transfer$lambda5(consumerTransferConfirmationViewModel, availableTransfer, uuid, consumerBuyOrder);
    }

    public final void detailsClicked() {
        ConsumerTransferConfirmationViewState copy;
        copy = r2.copy((r41 & 1) != 0 ? r2.modeText : null, (r41 & 2) != 0 ? r2.progressButtonText : null, (r41 & 4) != 0 ? r2.fromLabel : null, (r41 & 8) != 0 ? r2.fromPrimaryText : null, (r41 & 16) != 0 ? r2.fromSecondaryText : null, (r41 & 32) != 0 ? r2.fromImage : null, (r41 & 64) != 0 ? r2.fromImageUrl : null, (r41 & 128) != 0 ? r2.isDetailsShowing : !this.state.isDetailsShowing(), (r41 & 256) != 0 ? r2.primaryAmount : null, (r41 & 512) != 0 ? r2.secondaryAmount : null, (r41 & 1024) != 0 ? r2.minerFeePrimaryAmount : null, (r41 & PKIFailureInfo.wrongIntegrity) != 0 ? r2.minerFeeSecondaryAmount : null, (r41 & 4096) != 0 ? r2.totalPrimaryAmount : null, (r41 & PKIFailureInfo.certRevoked) != 0 ? r2.totalSecondaryAmount : null, (r41 & 16384) != 0 ? r2.coinbaseFeeAmount : null, (r41 & 32768) != 0 ? r2.selectedTransferMethod : null, (r41 & 65536) != 0 ? r2.selectedTransferMethodText : null, (r41 & PKIFailureInfo.unsupportedVersion) != 0 ? r2.loading : null, (r41 & PKIFailureInfo.transactionIdInUse) != 0 ? r2.onrampEnabled : false, (r41 & PKIFailureInfo.signerNotTrusted) != 0 ? r2.transferExplanation : null, (r41 & PKIFailureInfo.badCertTemplate) != 0 ? r2.showWorldpay : false, (r41 & PKIFailureInfo.badSenderNonce) != 0 ? r2.errorText : null, (r41 & 4194304) != 0 ? this.state.detailsChanged : false);
        setState(copy);
    }

    public final h.c.s<ConsumerConfirmationEvent> getEventObservable() {
        return this.eventObservable;
    }

    public final h.c.s<ViewModelNavRoute> getNavigationObservable() {
        return this.navigationObservable;
    }

    public final h.c.s<ConsumerTransferConfirmationViewState> getStateObservable() {
        return this.stateObservable;
    }

    public final void presentCoinbaseFee() {
        List b2;
        LocalizedStrings localizedStrings = LocalizedStrings.INSTANCE;
        String str = localizedStrings.get(R.string.prompt_coinbase_fee_title);
        String str2 = localizedStrings.get(R.string.prompt_coinbase_fee_body);
        Integer valueOf = Integer.valueOf(R.drawable.illustration_coinbase_fee);
        b2 = kotlin.a0.q.b(new PromptDialogHelper.Action(localizedStrings.get(R.string.ok), ActionStyle.POSITIVE, ConsumerTransferConfirmationViewModel$presentCoinbaseFee$properties$1.INSTANCE));
        this.eventSubject.onNext(new ConsumerConfirmationPromptEvent(new PromptDialogHelper.Properties(null, str, str2, null, valueOf, b2, null, false, null, null, ConsumerTransferConfirmationViewModel$presentCoinbaseFee$properties$2.INSTANCE, null, null, false, 15305, null)));
    }

    public final void presentMinerFee() {
        List K0;
        String str;
        int i2;
        List b2;
        K0 = kotlin.l0.y.K0(getTransferRequest().getWallet().getName(), new String[]{" "}, false, 0, 6, null);
        String str2 = (String) K0.get(0);
        if (isErc20(getTransferRequest().getWallet())) {
            str = LocalizedStrings.INSTANCE.get(R.string.send_miner_fee_erc20_description, getTransferRequest().getWallet().getCode());
            i2 = R.drawable.illustration_no_eth;
        } else {
            str = LocalizedStrings.INSTANCE.get(R.string.send_miner_fee_description, str2);
            i2 = R.drawable.illustration_dollar_arrows;
        }
        String str3 = str;
        LocalizedStrings localizedStrings = LocalizedStrings.INSTANCE;
        PromptDialogHelper.Action action = new PromptDialogHelper.Action(localizedStrings.get(R.string.got_it), ActionStyle.POSITIVE, ConsumerTransferConfirmationViewModel$presentMinerFee$action$1.INSTANCE);
        String str4 = localizedStrings.get(R.string.send_confirmation_miner_fee_dialog_title);
        b2 = kotlin.a0.q.b(action);
        this.eventSubject.onNext(new ConsumerConfirmationPromptEvent(new PromptDialogHelper.Properties(null, str4, str3, null, Integer.valueOf(i2), b2, null, true, null, null, ConsumerTransferConfirmationViewModel$presentMinerFee$properties$1.INSTANCE, null, null, false, 15177, null)));
    }

    public final h.c.b0<kotlin.x> setup(final h.c.s<ConsumerTransferMethodResult> transferResultObservable, final h.c.s<ConsumerCardCDVResult> cardVerificationResultObservable, final h.c.s<ConsumerSecure3DVerificationResult> secure3DVerificationResultObservable) {
        kotlin.jvm.internal.m.g(transferResultObservable, "transferResultObservable");
        kotlin.jvm.internal.m.g(cardVerificationResultObservable, "cardVerificationResultObservable");
        kotlin.jvm.internal.m.g(secure3DVerificationResultObservable, "secure3DVerificationResultObservable");
        h.c.b0<kotlin.x> doOnDispose = h.c.b0.fromCallable(new Callable() { // from class: com.coinbase.wallet.consumer.viewmodels.h1
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return ConsumerTransferConfirmationViewModel.f(ConsumerTransferConfirmationViewModel.this);
            }
        }).subscribeOn(h.c.u0.a.a()).observeOn(h.c.j0.c.a.b()).map(new h.c.m0.n() { // from class: com.coinbase.wallet.consumer.viewmodels.w1
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return ConsumerTransferConfirmationViewModel.u(ConsumerTransferConfirmationViewModel.this, (ConsumerTransferConfirmationViewState) obj);
            }
        }).doOnSubscribe(new h.c.m0.f() { // from class: com.coinbase.wallet.consumer.viewmodels.u1
            @Override // h.c.m0.f
            public final void accept(Object obj) {
                ConsumerTransferConfirmationViewModel.m1020setup$lambda2(ConsumerTransferConfirmationViewModel.this, transferResultObservable, cardVerificationResultObservable, secure3DVerificationResultObservable, (h.c.k0.b) obj);
            }
        }).doOnDispose(new h.c.m0.a() { // from class: com.coinbase.wallet.consumer.viewmodels.j1
            @Override // h.c.m0.a
            public final void run() {
                ConsumerTransferConfirmationViewModel.h(ConsumerTransferConfirmationViewModel.this);
            }
        });
        kotlin.jvm.internal.m.f(doOnDispose, "fromCallable { consumerTransferViewState(null) }\n            // The consumerTransferViewState takes 4ms to complete on a Pixel 2, put it on the computation thread\n            .subscribeOn(Schedulers.computation())\n            .observeOn(AndroidSchedulers.mainThread())\n            .map { newState -> state = newState.copy(loading = newState.loading ?: state.loading) }\n            .doOnSubscribe {\n                observeTransferMethodsResult(transferResultObservable)\n                observeCardVerificationResult(cardVerificationResultObservable)\n                observeSecure3DVerificationResult(secure3DVerificationResultObservable)\n            }\n            .doOnDispose {\n                disposeBag.clear()\n            }");
        return doOnDispose;
    }

    public final void switchPaymentMethod() {
        if (!getTransferRequest().getOnrampEnabled() || kotlin.jvm.internal.m.c(this.state.getLoading(), Boolean.TRUE)) {
            return;
        }
        Bundle createArgs = ConsumerTransferMethodsArgs.INSTANCE.createArgs(getTransferRequest(), null);
        createArgs.putAll(ForwardArgs.INSTANCE.create(R.id.consumerTransferConfirmationFragment));
        this.navigationSubject.onNext(new ViewModelNavRoute(R.id.consumerTransferMethodsFragment, createArgs, null, 4, null));
        Analytics.INSTANCE.log(AnalyticsEvent_ConsumerKt.consumerTransferConfirmationToTransferMethodsNavigated(AnalyticsEvent.Companion, getTransferRequest().getAccount().getCurrencyCode(), getTransferRequest().isFiatPrimary()));
    }

    public final h.c.b0<kotlin.x> transfer() {
        ConsumerTransferConfirmationViewState copy;
        ConsumerPaymentMethod paymentMethod;
        kotlin.o a;
        ConsumerTransferConfirmationViewState consumerTransferConfirmationViewState = this.state;
        Boolean bool = Boolean.TRUE;
        copy = consumerTransferConfirmationViewState.copy((r41 & 1) != 0 ? consumerTransferConfirmationViewState.modeText : null, (r41 & 2) != 0 ? consumerTransferConfirmationViewState.progressButtonText : null, (r41 & 4) != 0 ? consumerTransferConfirmationViewState.fromLabel : null, (r41 & 8) != 0 ? consumerTransferConfirmationViewState.fromPrimaryText : null, (r41 & 16) != 0 ? consumerTransferConfirmationViewState.fromSecondaryText : null, (r41 & 32) != 0 ? consumerTransferConfirmationViewState.fromImage : null, (r41 & 64) != 0 ? consumerTransferConfirmationViewState.fromImageUrl : null, (r41 & 128) != 0 ? consumerTransferConfirmationViewState.isDetailsShowing : false, (r41 & 256) != 0 ? consumerTransferConfirmationViewState.primaryAmount : null, (r41 & 512) != 0 ? consumerTransferConfirmationViewState.secondaryAmount : null, (r41 & 1024) != 0 ? consumerTransferConfirmationViewState.minerFeePrimaryAmount : null, (r41 & PKIFailureInfo.wrongIntegrity) != 0 ? consumerTransferConfirmationViewState.minerFeeSecondaryAmount : null, (r41 & 4096) != 0 ? consumerTransferConfirmationViewState.totalPrimaryAmount : null, (r41 & PKIFailureInfo.certRevoked) != 0 ? consumerTransferConfirmationViewState.totalSecondaryAmount : null, (r41 & 16384) != 0 ? consumerTransferConfirmationViewState.coinbaseFeeAmount : null, (r41 & 32768) != 0 ? consumerTransferConfirmationViewState.selectedTransferMethod : null, (r41 & 65536) != 0 ? consumerTransferConfirmationViewState.selectedTransferMethodText : null, (r41 & PKIFailureInfo.unsupportedVersion) != 0 ? consumerTransferConfirmationViewState.loading : bool, (r41 & PKIFailureInfo.transactionIdInUse) != 0 ? consumerTransferConfirmationViewState.onrampEnabled : false, (r41 & PKIFailureInfo.signerNotTrusted) != 0 ? consumerTransferConfirmationViewState.transferExplanation : null, (r41 & PKIFailureInfo.badCertTemplate) != 0 ? consumerTransferConfirmationViewState.showWorldpay : false, (r41 & PKIFailureInfo.badSenderNonce) != 0 ? consumerTransferConfirmationViewState.errorText : null, (r41 & 4194304) != 0 ? consumerTransferConfirmationViewState.detailsChanged : false);
        setState(copy);
        final UUID uuid = UUID.randomUUID();
        final AvailableTransfer selectedTransferMethod = this.state.getSelectedTransferMethod();
        if (selectedTransferMethod == null) {
            h.c.b0<kotlin.x> error = h.c.b0.error(new IllegalStateException("No transfer method selected"));
            kotlin.jvm.internal.m.f(error, "error(IllegalStateException(\"No transfer method selected\"))");
            return error;
        }
        AnalyticsEvent.Companion companion = AnalyticsEvent.Companion;
        CurrencyCode currencyCode = getTransferRequest().getAccount().getCurrencyCode();
        boolean isFiatPrimary = getTransferRequest().isFiatPrimary();
        boolean z = selectedTransferMethod instanceof AvailableBuyAndSendTransfer;
        AvailableBuyAndSendTransfer availableBuyAndSendTransfer = z ? (AvailableBuyAndSendTransfer) selectedTransferMethod : null;
        String type = (availableBuyAndSendTransfer == null || (paymentMethod = availableBuyAndSendTransfer.getPaymentMethod()) == null) ? null : paymentMethod.getType();
        boolean z2 = selectedTransferMethod instanceof AvailableSendTransfer;
        kotlin.jvm.internal.m.f(uuid, "uuid");
        Analytics.INSTANCE.log(AnalyticsEvent_ConsumerKt.consumerTransferConfirmationConfirmTapped(companion, currencyCode, isFiatPrimary, type, getTransferRequest().getOriginalRequestAmount() instanceof TransferValue.EntireBalance, z2, uuid));
        if (z) {
            AvailableBuyAndSendTransfer availableBuyAndSendTransfer2 = (AvailableBuyAndSendTransfer) selectedTransferMethod;
            if (availableBuyAndSendTransfer2.getBuyOrder() != null) {
                h.c.b0 flatMap = Single_AnalyticsKt.onSubscribeTrack(this.consumerTransferRepository.commitBuy(getTransferRequest().getAccount(), availableBuyAndSendTransfer2.getBuyOrder().getId()), AnalyticsEvent_ConsumerKt.consumerTransferConfirmationBuyCommitStarted(companion, getTransferRequest().getAccount().getCurrencyCode(), getTransferRequest().isFiatPrimary(), availableBuyAndSendTransfer2.getPaymentMethod().getType(), getTransferRequest().getOriginalRequestAmount() instanceof TransferValue.EntireBalance, uuid)).observeOn(h.c.j0.c.a.b()).onErrorResumeNext(new h.c.m0.n() { // from class: com.coinbase.wallet.consumer.viewmodels.m1
                    @Override // h.c.m0.n
                    public final Object apply(Object obj) {
                        return ConsumerTransferConfirmationViewModel.k(ConsumerTransferConfirmationViewModel.this, selectedTransferMethod, uuid, (Throwable) obj);
                    }
                }).flatMap(new h.c.m0.n() { // from class: com.coinbase.wallet.consumer.viewmodels.y1
                    @Override // h.c.m0.n
                    public final Object apply(Object obj) {
                        return ConsumerTransferConfirmationViewModel.w(ConsumerTransferConfirmationViewModel.this, selectedTransferMethod, uuid, (ConsumerBuyOrder) obj);
                    }
                });
                kotlin.jvm.internal.m.f(flatMap, "consumerTransferRepository.commitBuy(transferRequest.account, selectedTransferMethod.buyOrder.id)\n                    .onSubscribeTrack(\n                        AnalyticsEvent.consumerTransferConfirmationBuyCommitStarted(\n                            currencyCode = transferRequest.account.currencyCode,\n                            fiatSelected = transferRequest.isFiatPrimary,\n                            paymentMethodType = selectedTransferMethod.paymentMethod.type,\n                            maxTransfer = transferRequest.originalRequestAmount is TransferValue.EntireBalance,\n                            uuid = uuid\n                        )\n                    )\n                    .observeOn(AndroidSchedulers.mainThread())\n                    .onErrorResumeNext { throwable ->\n                        // Allow user to try again if they failed committing the buy\n                        Analytics.log(\n                            AnalyticsEvent.consumerTransferConfirmationBuyCommitError(\n                                currencyCode = transferRequest.account.currencyCode,\n                                fiatSelected = transferRequest.isFiatPrimary,\n                                paymentMethodType = selectedTransferMethod.paymentMethod.type,\n                                maxTransfer = transferRequest.originalRequestAmount is TransferValue.EntireBalance,\n                                uuid = uuid\n                            )\n                        )\n\n                        state = state\n                            .copy(loading = false, isDetailsShowing = true, errorText = throwable.localizedMessage)\n                        Single.error(throwable)\n                    }\n                    .flatMap { buyOrder -> pollForBuyOrder(buyOrder, selectedTransferMethod, uuid) }");
                a = kotlin.u.a(Single_CoreKt.asUnit(Single_AnalyticsKt.logError$default(flatMap, null, null, 3, null)), bool);
            } else {
                throw new AssertionException("Buy order should always be available by this point");
            }
        } else if (z2) {
            a = kotlin.u.a(h.c.b0.just(kotlin.x.a), Boolean.FALSE);
        } else {
            throw new NoWhenBranchMatchedException();
        }
        final h.c.b0<kotlin.x> startSend = startSend(((Boolean) a.b()).booleanValue(), selectedTransferMethod, uuid);
        h.c.b0<kotlin.x> flatMap2 = ((h.c.b0) a.a()).flatMap(new h.c.m0.n() { // from class: com.coinbase.wallet.consumer.viewmodels.g1
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                h.c.h0 m1027transfer$lambda6;
                m1027transfer$lambda6 = ConsumerTransferConfirmationViewModel.m1027transfer$lambda6(h.c.b0.this, (kotlin.x) obj);
                return m1027transfer$lambda6;
            }
        });
        kotlin.jvm.internal.m.f(flatMap2, "buySingle.flatMap { sendSingle }");
        return flatMap2;
    }
}