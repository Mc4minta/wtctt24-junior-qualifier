package com.coinbase.wallet.consumer.viewmodels;

import com.coinbase.ApiConstants;
import com.coinbase.wallet.analytics.Analytics;
import com.coinbase.wallet.analytics.extensions.Single_AnalyticsKt;
import com.coinbase.wallet.analytics.models.AnalyticsEvent;
import com.coinbase.wallet.blockchains.models.CurrencyCode;
import com.coinbase.wallet.blockchains.models.TransferValue;
import com.coinbase.wallet.common.extensions.SavedStateHandle_CommonKt;
import com.coinbase.wallet.common.utilities.LocalizedStrings;
import com.coinbase.wallet.commonui.models.ActionStyle;
import com.coinbase.wallet.commonui.utilities.PromptDialogHelper;
import com.coinbase.wallet.consumer.R;
import com.coinbase.wallet.consumer.extensions.AnalyticsEvent_ConsumerKt;
import com.coinbase.wallet.consumer.models.AddPaymentTransferItem;
import com.coinbase.wallet.consumer.models.AvailableBuyAndSendTransfer;
import com.coinbase.wallet.consumer.models.AvailableSendTransfer;
import com.coinbase.wallet.consumer.models.AvailableTransfer;
import com.coinbase.wallet.consumer.models.AvailableTransferItem;
import com.coinbase.wallet.consumer.models.ConsumerAccount;
import com.coinbase.wallet.consumer.models.ConsumerAvailableTransferContainer;
import com.coinbase.wallet.consumer.models.ConsumerCardCDVResult;
import com.coinbase.wallet.consumer.models.ConsumerPaymentMethod;
import com.coinbase.wallet.consumer.models.ConsumerTransferMethodItem;
import com.coinbase.wallet.consumer.models.ConsumerTransferMethodResult;
import com.coinbase.wallet.consumer.models.ConsumerTransferMethodsArgs;
import com.coinbase.wallet.consumer.models.ConsumerTransferMethodsEvent;
import com.coinbase.wallet.consumer.models.ConsumerTransferMethodsPrompt;
import com.coinbase.wallet.consumer.models.ConsumerTransferMethodsState;
import com.coinbase.wallet.consumer.models.PlaceholderTransferItem;
import com.coinbase.wallet.consumer.models.TransferMoneyRequest;
import com.coinbase.wallet.consumer.repositories.ConsumerTransferRepository;
import com.coinbase.wallet.core.extensions.Strings;
import com.coinbase.wallet.core.extensions.Strings_CoreKt;
import com.coinbase.wallet.core.util.AssertionException;
import com.coinbase.wallet.wallets.formatters.CurrencyFormatter;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import org.apache.http.protocol.HttpRequestExecutor;
import org.spongycastle.crypto.tls.CipherSuite;

/* compiled from: ConsumerTransferMethodsViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001:\u0001<B#\b\u0007\u0012\u0006\u0010'\u001a\u00020&\u0012\u0006\u0010 \u001a\u00020\u001f\u0012\b\b\u0001\u0010\u0018\u001a\u00020\u0017¢\u0006\u0004\b:\u0010;J3\u0010\n\u001a\u00020\t2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0013\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\f¢\u0006\u0004\b\u000e\u0010\u000fJ\u0015\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0012\u0010\u0013J\u0015\u0010\u0015\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u0003¢\u0006\u0004\b\u0015\u0010\u0016R\u0016\u0010\u0018\u001a\u00020\u00178\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R$\u0010\u001b\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\t8\u0002@BX\u0082\u000e¢\u0006\f\n\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u0016\u0010 \u001a\u00020\u001f8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b \u0010!R$\u0010$\u001a\u0010\u0012\f\u0012\n #*\u0004\u0018\u00010\t0\t0\"8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b$\u0010%R\u0016\u0010'\u001a\u00020&8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b'\u0010(R<\u0010+\u001a(\u0012$\u0012\"\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020* #*\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020*\u0018\u00010)0)0\"8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b+\u0010%R\u0016\u0010-\u001a\u00020,8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b-\u0010.R\u001f\u00100\u001a\b\u0012\u0004\u0012\u00020\t0/8\u0006@\u0006¢\u0006\f\n\u0004\b0\u00101\u001a\u0004\b2\u00103R$\u00105\u001a\u0010\u0012\f\u0012\n #*\u0004\u0018\u000104040\"8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b5\u0010%R\u001f\u00106\u001a\b\u0012\u0004\u0012\u0002040/8\u0006@\u0006¢\u0006\f\n\u0004\b6\u00101\u001a\u0004\b7\u00103R+\u00108\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020*0)0/8\u0006@\u0006¢\u0006\f\n\u0004\b8\u00101\u001a\u0004\b9\u00103¨\u0006="}, d2 = {"Lcom/coinbase/wallet/consumer/viewmodels/ConsumerTransferMethodsViewModel;", "Landroidx/lifecycle/b0;", "", "Lcom/coinbase/wallet/consumer/models/AvailableTransfer;", "availableTransfers", "", "addedPaymentMethodSuccess", "", "verifyingPaymentMethodId", "Lcom/coinbase/wallet/consumer/models/ConsumerTransferMethodsState;", "generateState", "(Ljava/util/List;ZLjava/lang/String;)Lcom/coinbase/wallet/consumer/models/ConsumerTransferMethodsState;", "Lh/c/b0;", "Lkotlin/x;", "setup", "()Lh/c/b0;", "Lcom/coinbase/wallet/consumer/models/ConsumerTransferMethodItem;", "selectedItem", "selectTransfer", "(Lcom/coinbase/wallet/consumer/models/ConsumerTransferMethodItem;)V", "availableTransfer", "infoClicked", "(Lcom/coinbase/wallet/consumer/models/AvailableTransfer;)V", "Landroidx/lifecycle/z;", "savedStateHandle", "Landroidx/lifecycle/z;", "value", ApiConstants.STATE, "Lcom/coinbase/wallet/consumer/models/ConsumerTransferMethodsState;", "setState", "(Lcom/coinbase/wallet/consumer/models/ConsumerTransferMethodsState;)V", "Lcom/coinbase/wallet/consumer/repositories/ConsumerTransferRepository;", "consumerTransferRepository", "Lcom/coinbase/wallet/consumer/repositories/ConsumerTransferRepository;", "Lh/c/v0/b;", "kotlin.jvm.PlatformType", "stateSubject", "Lh/c/v0/b;", "Lcom/coinbase/wallet/wallets/formatters/CurrencyFormatter;", "currencyFormatter", "Lcom/coinbase/wallet/wallets/formatters/CurrencyFormatter;", "Lkotlin/o;", "Lcom/coinbase/wallet/consumer/models/ConsumerTransferMethodResult;", "dismissSubject", "Lcom/coinbase/wallet/consumer/models/TransferMoneyRequest;", "transferRequest", "Lcom/coinbase/wallet/consumer/models/TransferMoneyRequest;", "Lh/c/s;", "stateObservable", "Lh/c/s;", "getStateObservable", "()Lh/c/s;", "Lcom/coinbase/wallet/consumer/models/ConsumerTransferMethodsEvent;", "eventsSubject", "eventsObservable", "getEventsObservable", "dismissObservable", "getDismissObservable", "<init>", "(Lcom/coinbase/wallet/wallets/formatters/CurrencyFormatter;Lcom/coinbase/wallet/consumer/repositories/ConsumerTransferRepository;Landroidx/lifecycle/z;)V", "Factory", "consumer_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class ConsumerTransferMethodsViewModel extends androidx.lifecycle.b0 {
    private final ConsumerTransferRepository consumerTransferRepository;
    private final CurrencyFormatter currencyFormatter;
    private final h.c.s<kotlin.o<String, ConsumerTransferMethodResult>> dismissObservable;
    private final h.c.v0.b<kotlin.o<String, ConsumerTransferMethodResult>> dismissSubject;
    private final h.c.s<ConsumerTransferMethodsEvent> eventsObservable;
    private final h.c.v0.b<ConsumerTransferMethodsEvent> eventsSubject;
    private final androidx.lifecycle.z savedStateHandle;
    private ConsumerTransferMethodsState state;
    private final h.c.s<ConsumerTransferMethodsState> stateObservable;
    private final h.c.v0.b<ConsumerTransferMethodsState> stateSubject;
    private TransferMoneyRequest transferRequest;

    /* compiled from: ConsumerTransferMethodsViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/coinbase/wallet/consumer/viewmodels/ConsumerTransferMethodsViewModel$Factory;", "", "Landroidx/lifecycle/z;", "savedStateHandle", "Lcom/coinbase/wallet/consumer/viewmodels/ConsumerTransferMethodsViewModel;", "create", "(Landroidx/lifecycle/z;)Lcom/coinbase/wallet/consumer/viewmodels/ConsumerTransferMethodsViewModel;", "consumer_productionRelease"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public interface Factory {
        ConsumerTransferMethodsViewModel create(androidx.lifecycle.z zVar);
    }

    public ConsumerTransferMethodsViewModel(CurrencyFormatter currencyFormatter, ConsumerTransferRepository consumerTransferRepository, androidx.lifecycle.z savedStateHandle) {
        kotlin.jvm.internal.m.g(currencyFormatter, "currencyFormatter");
        kotlin.jvm.internal.m.g(consumerTransferRepository, "consumerTransferRepository");
        kotlin.jvm.internal.m.g(savedStateHandle, "savedStateHandle");
        this.currencyFormatter = currencyFormatter;
        this.consumerTransferRepository = consumerTransferRepository;
        this.savedStateHandle = savedStateHandle;
        h.c.v0.b<ConsumerTransferMethodsState> d2 = h.c.v0.b.d();
        kotlin.jvm.internal.m.f(d2, "create<ConsumerTransferMethodsState>()");
        this.stateSubject = d2;
        h.c.v0.b<kotlin.o<String, ConsumerTransferMethodResult>> d3 = h.c.v0.b.d();
        kotlin.jvm.internal.m.f(d3, "create<Pair<String, ConsumerTransferMethodResult>>()");
        this.dismissSubject = d3;
        h.c.v0.b<ConsumerTransferMethodsEvent> d4 = h.c.v0.b.d();
        kotlin.jvm.internal.m.f(d4, "create<ConsumerTransferMethodsEvent>()");
        this.eventsSubject = d4;
        this.state = new ConsumerTransferMethodsState(null, null, null, 7, null);
        h.c.s<ConsumerTransferMethodsState> hide = d2.hide();
        kotlin.jvm.internal.m.f(hide, "stateSubject.hide()");
        this.stateObservable = hide;
        h.c.s<kotlin.o<String, ConsumerTransferMethodResult>> hide2 = d3.hide();
        kotlin.jvm.internal.m.f(hide2, "dismissSubject.hide()");
        this.dismissObservable = hide2;
        h.c.s<ConsumerTransferMethodsEvent> hide3 = d4.hide();
        kotlin.jvm.internal.m.f(hide3, "eventsSubject.hide()");
        this.eventsObservable = hide3;
    }

    public static /* synthetic */ h.c.h0 a(long j2, ConsumerAvailableTransferContainer consumerAvailableTransferContainer) {
        return m1029setup$lambda1$lambda0(j2, consumerAvailableTransferContainer);
    }

    public static /* synthetic */ kotlin.x b(ConsumerTransferMethodsViewModel consumerTransferMethodsViewModel) {
        return m1028setup$lambda1(consumerTransferMethodsViewModel);
    }

    private final ConsumerTransferMethodsState generateState(List<? extends AvailableTransfer> list, boolean z, String str) {
        int r;
        List K0;
        kotlin.o a;
        String str2;
        List l2;
        String str3;
        AvailableTransferItem availableTransferItem;
        String formatToFiat;
        String formatToFiat2;
        r = kotlin.a0.s.r(list, 10);
        ArrayList arrayList = new ArrayList(r);
        boolean z2 = false;
        int i2 = 0;
        for (AvailableTransfer availableTransfer : list) {
            if (availableTransfer instanceof AvailableSendTransfer) {
                AvailableSendTransfer availableSendTransfer = (AvailableSendTransfer) availableTransfer;
                formatToFiat = this.currencyFormatter.formatToFiat(availableTransfer.getAccount().getCurrencyCode(), null, availableTransfer.getAccount().getDecimals(), availableSendTransfer.getMaxAmountCrypto(), (r17 & 16) != 0 ? false : false, (r17 & 32) != 0 ? null : availableTransfer.getAccount().getName(), (r17 & 64) != 0 ? null : null);
                formatToFiat2 = this.currencyFormatter.formatToFiat(availableTransfer.getAccount().getCurrencyCode(), null, availableTransfer.getAccount().getDecimals(), availableTransfer.getAccount().getBalance(), (r17 & 16) != 0 ? false : false, (r17 & 32) != 0 ? null : availableTransfer.getAccount().getName(), (r17 & 64) != 0 ? null : null);
                String str4 = (formatToFiat == null || formatToFiat2 == null) ? null : LocalizedStrings.INSTANCE.get(R.string.consumer_transfer_available_balance, formatToFiat2, formatToFiat);
                boolean z3 = availableTransfer.getTransferAmount().compareTo(BigInteger.ZERO) > 0;
                if (z3) {
                    i2++;
                }
                availableTransferItem = new AvailableTransferItem(availableTransfer, LocalizedStrings.INSTANCE.get(R.string.consumer_transfer_method_coinbase), str4, null, Integer.valueOf(R.drawable.consumer_transfer_balance), availableSendTransfer.isWblLimited(), z3, false, CipherSuite.TLS_DHE_RSA_WITH_CAMELLIA_256_CBC_SHA, null);
            } else if (availableTransfer instanceof AvailableBuyAndSendTransfer) {
                AvailableBuyAndSendTransfer availableBuyAndSendTransfer = (AvailableBuyAndSendTransfer) availableTransfer;
                if (kotlin.jvm.internal.m.c(str, availableBuyAndSendTransfer.getPaymentMethod().getId())) {
                    z2 = true;
                }
                BigDecimal buyLimit = availableBuyAndSendTransfer.getBuyLimit();
                if (buyLimit == null) {
                    buyLimit = BigDecimal.ZERO;
                }
                boolean c2 = kotlin.jvm.internal.m.c(str, availableBuyAndSendTransfer.getPaymentMethod().getId());
                boolean z4 = (!availableBuyAndSendTransfer.getPaymentMethod().getVerified() || buyLimit.compareTo(BigDecimal.ZERO) <= 0) && !c2;
                String paymentMethodSubtitle = availableBuyAndSendTransfer.getPaymentMethodSubtitle();
                if (availableBuyAndSendTransfer.getSupportedPaymentMethod()) {
                    str2 = availableBuyAndSendTransfer.getSupplementalPaymentInfo();
                } else {
                    str2 = LocalizedStrings.INSTANCE.get(R.string.consumer_payment_method_not_yet_supported);
                }
                l2 = kotlin.a0.r.l(paymentMethodSubtitle, str2);
                if (!availableBuyAndSendTransfer.getPaymentMethod().getVerified()) {
                    str3 = LocalizedStrings.INSTANCE.get(R.string.consumer_payment_method_verify);
                } else if (l2.isEmpty()) {
                    str3 = Strings_CoreKt.getEmpty(Strings.INSTANCE);
                } else if (l2.size() == 1) {
                    str3 = LocalizedStrings.INSTANCE.get(R.string.available_payment_method_1_fields, l2.get(0));
                } else if (l2.size() == 2) {
                    str3 = LocalizedStrings.INSTANCE.get(R.string.available_payment_method_2_fields, l2.get(0), l2.get(1));
                } else {
                    throw new AssertionException("Unexpected subtext list size " + l2.size() + ", coding error");
                }
                String str5 = str3;
                boolean z5 = availableTransfer.getTransferAmount().compareTo(BigInteger.ZERO) > 0;
                if (z5) {
                    i2++;
                }
                AvailableBuyAndSendTransfer availableBuyAndSendTransfer2 = (AvailableBuyAndSendTransfer) availableTransfer;
                availableTransferItem = new AvailableTransferItem(availableTransfer, availableBuyAndSendTransfer2.getPaymentMethod().getName(), str5, availableBuyAndSendTransfer2.getPaymentMethodImageUrl(), availableBuyAndSendTransfer2.getLocalPaymentMethodImage(), z4, z5, c2);
            } else {
                throw new NoWhenBranchMatchedException();
            }
            arrayList.add(availableTransferItem);
        }
        K0 = kotlin.a0.z.K0(arrayList);
        if (z && !z2) {
            K0.add(PlaceholderTransferItem.INSTANCE);
        }
        LocalizedStrings localizedStrings = LocalizedStrings.INSTANCE;
        K0.add(new AddPaymentTransferItem(localizedStrings.get(R.string.consumer_add_payment_method)));
        if (i2 > 0) {
            a = kotlin.u.a(localizedStrings.get(R.string.consumer_transfer_method_selector_header), localizedStrings.get(R.string.consumer_choose_transfer_method));
        } else {
            a = kotlin.u.a(localizedStrings.get(R.string.consumer_add_transfer_method), localizedStrings.get(R.string.consumer_add_transfer_method_subtext));
        }
        return new ConsumerTransferMethodsState(K0, (String) a.a(), (String) a.b());
    }

    public static /* synthetic */ ConsumerTransferMethodsState generateState$default(ConsumerTransferMethodsViewModel consumerTransferMethodsViewModel, List list, boolean z, String str, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        if ((i2 & 4) != 0) {
            str = null;
        }
        return consumerTransferMethodsViewModel.generateState(list, z, str);
    }

    public final void setState(ConsumerTransferMethodsState consumerTransferMethodsState) {
        this.stateSubject.onNext(consumerTransferMethodsState);
        this.state = consumerTransferMethodsState;
    }

    /* renamed from: setup$lambda-1 */
    public static final kotlin.x m1028setup$lambda1(ConsumerTransferMethodsViewModel this$0) {
        kotlin.o a;
        kotlin.jvm.internal.m.g(this$0, "this$0");
        androidx.lifecycle.z zVar = this$0.savedStateHandle;
        ConsumerTransferMethodsArgs consumerTransferMethodsArgs = ConsumerTransferMethodsArgs.INSTANCE;
        TransferMoneyRequest transferMoneyRequest = (TransferMoneyRequest) SavedStateHandle_CommonKt.require(zVar, consumerTransferMethodsArgs.getTransferRequestKey());
        this$0.transferRequest = transferMoneyRequest;
        Analytics analytics = Analytics.INSTANCE;
        AnalyticsEvent.Companion companion = AnalyticsEvent.Companion;
        if (transferMoneyRequest != null) {
            CurrencyCode currencyCode = transferMoneyRequest.getAccount().getCurrencyCode();
            TransferMoneyRequest transferMoneyRequest2 = this$0.transferRequest;
            if (transferMoneyRequest2 != null) {
                analytics.log(AnalyticsEvent_ConsumerKt.consumerTransferMethodsViewed(companion, currencyCode, transferMoneyRequest2.isFiatPrimary()));
                ConsumerCardCDVResult consumerCardCDVResult = (ConsumerCardCDVResult) this$0.savedStateHandle.b(consumerTransferMethodsArgs.getAddedPaymentMethodResultKey());
                if (consumerCardCDVResult instanceof ConsumerCardCDVResult.Verified) {
                    a = kotlin.u.a(Boolean.TRUE, ((ConsumerCardCDVResult.Verified) consumerCardCDVResult).getPaymentMethodId());
                } else {
                    if (!((consumerCardCDVResult instanceof ConsumerCardCDVResult.Unverified) || consumerCardCDVResult == null)) {
                        throw new NoWhenBranchMatchedException();
                    }
                    a = kotlin.u.a(Boolean.FALSE, null);
                }
                boolean booleanValue = ((Boolean) a.a()).booleanValue();
                String str = (String) a.b();
                TransferMoneyRequest transferMoneyRequest3 = this$0.transferRequest;
                if (transferMoneyRequest3 != null) {
                    this$0.setState(this$0.generateState(transferMoneyRequest3.getAvailableTransfers(), booleanValue, str));
                    if (booleanValue) {
                        final long currentTimeMillis = System.currentTimeMillis();
                        ConsumerTransferRepository consumerTransferRepository = this$0.consumerTransferRepository;
                        TransferMoneyRequest transferMoneyRequest4 = this$0.transferRequest;
                        if (transferMoneyRequest4 != null) {
                            ConsumerAccount account = transferMoneyRequest4.getAccount();
                            TransferMoneyRequest transferMoneyRequest5 = this$0.transferRequest;
                            if (transferMoneyRequest5 != null) {
                                TransferValue originalRequestAmount = transferMoneyRequest5.getOriginalRequestAmount();
                                TransferMoneyRequest transferMoneyRequest6 = this$0.transferRequest;
                                if (transferMoneyRequest6 != null) {
                                    h.c.b0<ConsumerAvailableTransferContainer> availableTransfers = consumerTransferRepository.getAvailableTransfers(account, originalRequestAmount, transferMoneyRequest6.getWallet().getAddress());
                                    TransferMoneyRequest transferMoneyRequest7 = this$0.transferRequest;
                                    if (transferMoneyRequest7 != null) {
                                        CurrencyCode currencyCode2 = transferMoneyRequest7.getAccount().getCurrencyCode();
                                        TransferMoneyRequest transferMoneyRequest8 = this$0.transferRequest;
                                        if (transferMoneyRequest8 != null) {
                                            h.c.b0 observeOn = Single_AnalyticsKt.onSubscribeTrack(availableTransfers, AnalyticsEvent_ConsumerKt.consumerTransferMethodsAddPaymentSuccess(companion, currencyCode2, transferMoneyRequest8.isFiatPrimary())).flatMap(new h.c.m0.n() { // from class: com.coinbase.wallet.consumer.viewmodels.z1
                                                @Override // h.c.m0.n
                                                public final Object apply(Object obj) {
                                                    return ConsumerTransferMethodsViewModel.a(currentTimeMillis, (ConsumerAvailableTransferContainer) obj);
                                                }
                                            }).observeOn(h.c.j0.c.a.b());
                                            kotlin.jvm.internal.m.f(observeOn, "consumerTransferRepository\n                .getAvailableTransfers(\n                    account = transferRequest.account,\n                    amount = transferRequest.originalRequestAmount,\n                    toAddress = transferRequest.wallet.address\n                )\n                .onSubscribeTrack(\n                    AnalyticsEvent.consumerTransferMethodsAddPaymentSuccess(\n                        currencyCode = transferRequest.account.currencyCode,\n                        fiatSelected = transferRequest.isFiatPrimary\n                    )\n                )\n                .flatMap { transfers ->\n                    val delta = System.currentTimeMillis() - startTime\n                    // If it took less than 3 seconds, wait to update the state so the progress shows up\n                    if (delta < 3000) {\n                        Single.just(transfers.availableTransfers).delay(3000 - delta, TimeUnit.MILLISECONDS)\n                    } else {\n                        Single.just(transfers.availableTransfers)\n                    }\n                }\n                .observeOn(AndroidSchedulers.mainThread())");
                                            h.c.t0.g.i(observeOn, null, new ConsumerTransferMethodsViewModel$setup$1$2(this$0), 1, null);
                                        } else {
                                            kotlin.jvm.internal.m.w("transferRequest");
                                            throw null;
                                        }
                                    } else {
                                        kotlin.jvm.internal.m.w("transferRequest");
                                        throw null;
                                    }
                                } else {
                                    kotlin.jvm.internal.m.w("transferRequest");
                                    throw null;
                                }
                            } else {
                                kotlin.jvm.internal.m.w("transferRequest");
                                throw null;
                            }
                        } else {
                            kotlin.jvm.internal.m.w("transferRequest");
                            throw null;
                        }
                    }
                    return kotlin.x.a;
                }
                kotlin.jvm.internal.m.w("transferRequest");
                throw null;
            }
            kotlin.jvm.internal.m.w("transferRequest");
            throw null;
        }
        kotlin.jvm.internal.m.w("transferRequest");
        throw null;
    }

    /* renamed from: setup$lambda-1$lambda-0 */
    public static final h.c.h0 m1029setup$lambda1$lambda0(long j2, ConsumerAvailableTransferContainer transfers) {
        kotlin.jvm.internal.m.g(transfers, "transfers");
        long currentTimeMillis = System.currentTimeMillis() - j2;
        if (currentTimeMillis < 3000) {
            return h.c.b0.just(transfers.getAvailableTransfers()).delay(((long) HttpRequestExecutor.DEFAULT_WAIT_FOR_CONTINUE) - currentTimeMillis, TimeUnit.MILLISECONDS);
        }
        return h.c.b0.just(transfers.getAvailableTransfers());
    }

    public final h.c.s<kotlin.o<String, ConsumerTransferMethodResult>> getDismissObservable() {
        return this.dismissObservable;
    }

    public final h.c.s<ConsumerTransferMethodsEvent> getEventsObservable() {
        return this.eventsObservable;
    }

    public final h.c.s<ConsumerTransferMethodsState> getStateObservable() {
        return this.stateObservable;
    }

    public final void infoClicked(AvailableTransfer availableTransfer) {
        List b2;
        String formatToFiat;
        List b3;
        kotlin.jvm.internal.m.g(availableTransfer, "availableTransfer");
        if (availableTransfer instanceof AvailableSendTransfer) {
            formatToFiat = this.currencyFormatter.formatToFiat(availableTransfer.getAccount().getCurrencyCode(), null, availableTransfer.getAccount().getDecimals(), ((AvailableSendTransfer) availableTransfer).getMaxAmountCrypto(), (r17 & 16) != 0 ? false : false, (r17 & 32) != 0 ? null : availableTransfer.getAccount().getCurrencyName(), (r17 & 64) != 0 ? null : null);
            String str = formatToFiat != null ? LocalizedStrings.INSTANCE.get(R.string.consumer_wbl_info_transfer_limit_subtext, formatToFiat) : null;
            LocalizedStrings localizedStrings = LocalizedStrings.INSTANCE;
            PromptDialogHelper.Action action = new PromptDialogHelper.Action(localizedStrings.get(R.string.consumer_wbl_ok), ActionStyle.POSITIVE, ConsumerTransferMethodsViewModel$infoClicked$action$1.INSTANCE);
            String str2 = localizedStrings.get(R.string.consumer_wbl_info_transfer_limit);
            Integer valueOf = Integer.valueOf(R.drawable.ic_consumer_wbl_info);
            b3 = kotlin.a0.q.b(action);
            this.eventsSubject.onNext(new ConsumerTransferMethodsPrompt(new PromptDialogHelper.Properties(null, str2, str, null, valueOf, b3, null, false, null, null, null, null, null, false, 16329, null)));
            Analytics analytics = Analytics.INSTANCE;
            AnalyticsEvent.Companion companion = AnalyticsEvent.Companion;
            TransferMoneyRequest transferMoneyRequest = this.transferRequest;
            if (transferMoneyRequest != null) {
                CurrencyCode currencyCode = transferMoneyRequest.getAccount().getCurrencyCode();
                TransferMoneyRequest transferMoneyRequest2 = this.transferRequest;
                if (transferMoneyRequest2 != null) {
                    analytics.log(AnalyticsEvent_ConsumerKt.consumerTransferMethodsWBLViewed(companion, currencyCode, transferMoneyRequest2.isFiatPrimary()));
                    return;
                } else {
                    kotlin.jvm.internal.m.w("transferRequest");
                    throw null;
                }
            }
            kotlin.jvm.internal.m.w("transferRequest");
            throw null;
        } else if (availableTransfer instanceof AvailableBuyAndSendTransfer) {
            AvailableBuyAndSendTransfer availableBuyAndSendTransfer = (AvailableBuyAndSendTransfer) availableTransfer;
            boolean verified = availableBuyAndSendTransfer.getPaymentMethod().getVerified();
            BigDecimal buyLimit = availableBuyAndSendTransfer.getBuyLimit();
            if (buyLimit == null) {
                buyLimit = BigDecimal.ZERO;
            }
            boolean z = buyLimit.compareTo(BigDecimal.ZERO) <= 0;
            if (!verified) {
                ConsumerTransferMethodResult.VerifyingPaymentMethod verifyingPaymentMethod = new ConsumerTransferMethodResult.VerifyingPaymentMethod(availableBuyAndSendTransfer.getPaymentMethod());
                this.dismissSubject.onNext(kotlin.u.a(ConsumerTransferMethodsArgs.INSTANCE.getResultKey(), verifyingPaymentMethod));
                Analytics analytics2 = Analytics.INSTANCE;
                AnalyticsEvent.Companion companion2 = AnalyticsEvent.Companion;
                TransferMoneyRequest transferMoneyRequest3 = this.transferRequest;
                if (transferMoneyRequest3 != null) {
                    CurrencyCode currencyCode2 = transferMoneyRequest3.getAccount().getCurrencyCode();
                    TransferMoneyRequest transferMoneyRequest4 = this.transferRequest;
                    if (transferMoneyRequest4 != null) {
                        analytics2.log(AnalyticsEvent_ConsumerKt.consumerTransferMethodsVerifyPaymentTapped(companion2, currencyCode2, transferMoneyRequest4.isFiatPrimary(), verifyingPaymentMethod.getPaymentMethod().getType()));
                        return;
                    } else {
                        kotlin.jvm.internal.m.w("transferRequest");
                        throw null;
                    }
                }
                kotlin.jvm.internal.m.w("transferRequest");
                throw null;
            } else if (z) {
                LocalizedStrings localizedStrings2 = LocalizedStrings.INSTANCE;
                PromptDialogHelper.Action action2 = new PromptDialogHelper.Action(localizedStrings2.get(R.string.consumer_wbl_ok), ActionStyle.POSITIVE, ConsumerTransferMethodsViewModel$infoClicked$action$2.INSTANCE);
                String str3 = localizedStrings2.get(R.string.consumer_transfer_daily_limit);
                String str4 = localizedStrings2.get(R.string.consumer_transfer_daily_limit_subtext);
                Integer valueOf2 = Integer.valueOf(R.drawable.ic_consumer_daily_limit);
                b2 = kotlin.a0.q.b(action2);
                this.eventsSubject.onNext(new ConsumerTransferMethodsPrompt(new PromptDialogHelper.Properties(null, str3, str4, null, valueOf2, b2, null, false, null, null, null, null, null, false, 16329, null)));
                Analytics analytics3 = Analytics.INSTANCE;
                AnalyticsEvent.Companion companion3 = AnalyticsEvent.Companion;
                TransferMoneyRequest transferMoneyRequest5 = this.transferRequest;
                if (transferMoneyRequest5 != null) {
                    CurrencyCode currencyCode3 = transferMoneyRequest5.getAccount().getCurrencyCode();
                    TransferMoneyRequest transferMoneyRequest6 = this.transferRequest;
                    if (transferMoneyRequest6 != null) {
                        analytics3.log(AnalyticsEvent_ConsumerKt.consumerTransferMethodsPaymentLimitViewed(companion3, currencyCode3, transferMoneyRequest6.isFiatPrimary(), availableBuyAndSendTransfer.getPaymentMethod().getType()));
                        return;
                    } else {
                        kotlin.jvm.internal.m.w("transferRequest");
                        throw null;
                    }
                }
                kotlin.jvm.internal.m.w("transferRequest");
                throw null;
            }
        }
    }

    public final void selectTransfer(ConsumerTransferMethodItem selectedItem) {
        ConsumerPaymentMethod paymentMethod;
        kotlin.jvm.internal.m.g(selectedItem, "selectedItem");
        String str = null;
        if (selectedItem instanceof AddPaymentTransferItem) {
            this.dismissSubject.onNext(kotlin.u.a(ConsumerTransferMethodsArgs.INSTANCE.getResultKey(), ConsumerTransferMethodResult.AddingPaymentMethod.INSTANCE));
            Analytics analytics = Analytics.INSTANCE;
            AnalyticsEvent.Companion companion = AnalyticsEvent.Companion;
            TransferMoneyRequest transferMoneyRequest = this.transferRequest;
            if (transferMoneyRequest != null) {
                CurrencyCode currencyCode = transferMoneyRequest.getAccount().getCurrencyCode();
                TransferMoneyRequest transferMoneyRequest2 = this.transferRequest;
                if (transferMoneyRequest2 != null) {
                    analytics.log(AnalyticsEvent_ConsumerKt.consumerTransferMethodsAddPaymentTapped(companion, currencyCode, transferMoneyRequest2.isFiatPrimary()));
                    return;
                } else {
                    kotlin.jvm.internal.m.w("transferRequest");
                    throw null;
                }
            }
            kotlin.jvm.internal.m.w("transferRequest");
            throw null;
        } else if (selectedItem instanceof AvailableTransferItem) {
            AvailableTransfer availableTransfer = ((AvailableTransferItem) selectedItem).getAvailableTransfer();
            if (availableTransfer.getTransferAmount().compareTo(BigInteger.ZERO) > 0) {
                this.dismissSubject.onNext(kotlin.u.a(ConsumerTransferMethodsArgs.INSTANCE.getResultKey(), new ConsumerTransferMethodResult.SelectedTransfer(availableTransfer)));
                Analytics analytics2 = Analytics.INSTANCE;
                AnalyticsEvent.Companion companion2 = AnalyticsEvent.Companion;
                TransferMoneyRequest transferMoneyRequest3 = this.transferRequest;
                if (transferMoneyRequest3 != null) {
                    CurrencyCode currencyCode2 = transferMoneyRequest3.getAccount().getCurrencyCode();
                    TransferMoneyRequest transferMoneyRequest4 = this.transferRequest;
                    if (transferMoneyRequest4 != null) {
                        boolean isFiatPrimary = transferMoneyRequest4.isFiatPrimary();
                        boolean z = availableTransfer instanceof AvailableSendTransfer;
                        AvailableBuyAndSendTransfer availableBuyAndSendTransfer = availableTransfer instanceof AvailableBuyAndSendTransfer ? (AvailableBuyAndSendTransfer) availableTransfer : null;
                        if (availableBuyAndSendTransfer != null && (paymentMethod = availableBuyAndSendTransfer.getPaymentMethod()) != null) {
                            str = paymentMethod.getType();
                        }
                        analytics2.log(AnalyticsEvent_ConsumerKt.consumerTransferMethodsTransferSelected(companion2, currencyCode2, isFiatPrimary, z, str));
                        return;
                    }
                    kotlin.jvm.internal.m.w("transferRequest");
                    throw null;
                }
                kotlin.jvm.internal.m.w("transferRequest");
                throw null;
            }
        }
    }

    public final h.c.b0<kotlin.x> setup() {
        h.c.b0<kotlin.x> fromCallable = h.c.b0.fromCallable(new Callable() { // from class: com.coinbase.wallet.consumer.viewmodels.a2
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return ConsumerTransferMethodsViewModel.b(ConsumerTransferMethodsViewModel.this);
            }
        });
        kotlin.jvm.internal.m.f(fromCallable, "fromCallable {\n        transferRequest = savedStateHandle.require(ConsumerTransferMethodsArgs.transferRequestKey)\n\n        Analytics.log(\n            AnalyticsEvent.consumerTransferMethodsViewed(\n                currencyCode = transferRequest.account.currencyCode,\n                fiatSelected = transferRequest.isFiatPrimary\n            )\n        )\n\n        val addedPaymentMethodResult: ConsumerCardCDVResult? = savedStateHandle\n            .get(ConsumerTransferMethodsArgs.addedPaymentMethodResultKey)\n\n        val (addedPaymentMethodSuccess, verifyingPaymentMethodId) = when (addedPaymentMethodResult) {\n            is ConsumerCardCDVResult.Verified -> true to addedPaymentMethodResult.paymentMethodId\n            is ConsumerCardCDVResult.Unverified, null -> false to null\n        }\n\n        state = generateState(transferRequest.availableTransfers, addedPaymentMethodSuccess, verifyingPaymentMethodId)\n        if (addedPaymentMethodSuccess) {\n            val startTime = System.currentTimeMillis()\n            consumerTransferRepository\n                .getAvailableTransfers(\n                    account = transferRequest.account,\n                    amount = transferRequest.originalRequestAmount,\n                    toAddress = transferRequest.wallet.address\n                )\n                .onSubscribeTrack(\n                    AnalyticsEvent.consumerTransferMethodsAddPaymentSuccess(\n                        currencyCode = transferRequest.account.currencyCode,\n                        fiatSelected = transferRequest.isFiatPrimary\n                    )\n                )\n                .flatMap { transfers ->\n                    val delta = System.currentTimeMillis() - startTime\n                    // If it took less than 3 seconds, wait to update the state so the progress shows up\n                    if (delta < 3000) {\n                        Single.just(transfers.availableTransfers).delay(3000 - delta, TimeUnit.MILLISECONDS)\n                    } else {\n                        Single.just(transfers.availableTransfers)\n                    }\n                }\n                .observeOn(AndroidSchedulers.mainThread())\n                .subscribeBy { availableTransfers ->\n                    transferRequest = transferRequest.copy(availableTransfers = availableTransfers)\n                    state = generateState(availableTransfers)\n                }\n        }\n    }");
        return fromCallable;
    }
}