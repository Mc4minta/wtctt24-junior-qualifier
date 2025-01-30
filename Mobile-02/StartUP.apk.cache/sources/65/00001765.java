package com.coinbase.wallet.consumer.viewmodels;

import com.coinbase.ApiConstants;
import com.coinbase.wallet.analytics.Analytics;
import com.coinbase.wallet.analytics.models.AnalyticsEvent;
import com.coinbase.wallet.common.utilities.LocalizedStrings;
import com.coinbase.wallet.consumer.R;
import com.coinbase.wallet.consumer.exceptions.ConsumerException;
import com.coinbase.wallet.consumer.extensions.AnalyticsEvent_ConsumerKt;
import com.coinbase.wallet.consumer.models.ConsumerCardCDVArgs;
import com.coinbase.wallet.consumer.models.ConsumerCardCDVResult;
import com.coinbase.wallet.consumer.models.ConsumerCardCDVState;
import com.coinbase.wallet.consumer.models.ConsumerPaymentMethod;
import com.coinbase.wallet.consumer.repositories.ConsumerTransferRepository;
import com.coinbase.wallet.core.extensions.Strings;
import com.coinbase.wallet.core.extensions.Strings_CoreKt;
import java.math.BigDecimal;
import java.util.UUID;
import java.util.concurrent.Callable;
import kotlin.Metadata;

/* compiled from: ConsumerCardCDVViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001:\u0001/B\u001b\b\u0007\u0012\u0006\u0010\"\u001a\u00020!\u0012\b\b\u0001\u0010\u001a\u001a\u00020\u0019¢\u0006\u0004\b-\u0010.J\u0013\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001d\u0010\t\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\nJ#\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006¢\u0006\u0004\b\u000b\u0010\fR<\u0010\u0011\u001a(\u0012$\u0012\"\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u000f \u0010*\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e0\u000e0\r8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u001f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u00138\u0006@\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001a\u001a\u00020\u00198\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR$\u0010\u001d\u001a\u00020\u00142\u0006\u0010\u001c\u001a\u00020\u00148\u0002@BX\u0082\u000e¢\u0006\f\n\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u0016\u0010\"\u001a\u00020!8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\"\u0010#R$\u0010$\u001a\u0010\u0012\f\u0012\n \u0010*\u0004\u0018\u00010\u00140\u00140\r8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b$\u0010\u0012R\u001d\u0010*\u001a\u00020%8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)R+\u0010+\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u000f0\u000e0\u00138\u0006@\u0006¢\u0006\f\n\u0004\b+\u0010\u0016\u001a\u0004\b,\u0010\u0018¨\u00060"}, d2 = {"Lcom/coinbase/wallet/consumer/viewmodels/ConsumerCardCDVViewModel;", "Landroidx/lifecycle/b0;", "Lh/c/b0;", "Lkotlin/x;", "setup", "()Lh/c/b0;", "", "amount1", "amount2", "onAmountsEntered", "(Ljava/lang/String;Ljava/lang/String;)V", "onConfirmTapped", "(Ljava/lang/String;Ljava/lang/String;)Lh/c/b0;", "Lh/c/v0/b;", "Lkotlin/o;", "Lcom/coinbase/wallet/consumer/models/ConsumerCardCDVResult;", "kotlin.jvm.PlatformType", "dismissSubject", "Lh/c/v0/b;", "Lh/c/s;", "Lcom/coinbase/wallet/consumer/models/ConsumerCardCDVState;", "stateObservable", "Lh/c/s;", "getStateObservable", "()Lh/c/s;", "Landroidx/lifecycle/z;", "savedStateHandle", "Landroidx/lifecycle/z;", "value", ApiConstants.STATE, "Lcom/coinbase/wallet/consumer/models/ConsumerCardCDVState;", "setState", "(Lcom/coinbase/wallet/consumer/models/ConsumerCardCDVState;)V", "Lcom/coinbase/wallet/consumer/repositories/ConsumerTransferRepository;", "consumerTransferRepository", "Lcom/coinbase/wallet/consumer/repositories/ConsumerTransferRepository;", "stateSubject", "Lcom/coinbase/wallet/consumer/models/ConsumerPaymentMethod;", "paymentMethod$delegate", "Lkotlin/h;", "getPaymentMethod", "()Lcom/coinbase/wallet/consumer/models/ConsumerPaymentMethod;", "paymentMethod", "dismissObservable", "getDismissObservable", "<init>", "(Lcom/coinbase/wallet/consumer/repositories/ConsumerTransferRepository;Landroidx/lifecycle/z;)V", "Factory", "consumer_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class ConsumerCardCDVViewModel extends androidx.lifecycle.b0 {
    private final ConsumerTransferRepository consumerTransferRepository;
    private final h.c.s<kotlin.o<String, ConsumerCardCDVResult>> dismissObservable;
    private final h.c.v0.b<kotlin.o<String, ConsumerCardCDVResult>> dismissSubject;
    private final kotlin.h paymentMethod$delegate;
    private final androidx.lifecycle.z savedStateHandle;
    private ConsumerCardCDVState state;
    private final h.c.s<ConsumerCardCDVState> stateObservable;
    private final h.c.v0.b<ConsumerCardCDVState> stateSubject;

    /* compiled from: ConsumerCardCDVViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/coinbase/wallet/consumer/viewmodels/ConsumerCardCDVViewModel$Factory;", "", "Landroidx/lifecycle/z;", "savedStateHandle", "Lcom/coinbase/wallet/consumer/viewmodels/ConsumerCardCDVViewModel;", "create", "(Landroidx/lifecycle/z;)Lcom/coinbase/wallet/consumer/viewmodels/ConsumerCardCDVViewModel;", "consumer_productionRelease"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public interface Factory {
        ConsumerCardCDVViewModel create(androidx.lifecycle.z zVar);
    }

    public ConsumerCardCDVViewModel(ConsumerTransferRepository consumerTransferRepository, androidx.lifecycle.z savedStateHandle) {
        kotlin.h b2;
        kotlin.jvm.internal.m.g(consumerTransferRepository, "consumerTransferRepository");
        kotlin.jvm.internal.m.g(savedStateHandle, "savedStateHandle");
        this.consumerTransferRepository = consumerTransferRepository;
        this.savedStateHandle = savedStateHandle;
        h.c.v0.b<ConsumerCardCDVState> d2 = h.c.v0.b.d();
        kotlin.jvm.internal.m.f(d2, "create<ConsumerCardCDVState>()");
        this.stateSubject = d2;
        h.c.v0.b<kotlin.o<String, ConsumerCardCDVResult>> d3 = h.c.v0.b.d();
        kotlin.jvm.internal.m.f(d3, "create<Pair<String, ConsumerCardCDVResult>>()");
        this.dismissSubject = d3;
        b2 = kotlin.k.b(new ConsumerCardCDVViewModel$paymentMethod$2(this));
        this.paymentMethod$delegate = b2;
        this.state = new ConsumerCardCDVState(null, false, false, 7, null);
        h.c.s<kotlin.o<String, ConsumerCardCDVResult>> hide = d3.hide();
        kotlin.jvm.internal.m.f(hide, "dismissSubject.hide()");
        this.dismissObservable = hide;
        h.c.s<ConsumerCardCDVState> hide2 = d2.hide();
        kotlin.jvm.internal.m.f(hide2, "stateSubject.hide()");
        this.stateObservable = hide2;
    }

    public static /* synthetic */ kotlin.x a(ConsumerCardCDVViewModel consumerCardCDVViewModel, UUID uuid, kotlin.x xVar) {
        return m986onConfirmTapped$lambda2(consumerCardCDVViewModel, uuid, xVar);
    }

    public static /* synthetic */ kotlin.x b(ConsumerCardCDVViewModel consumerCardCDVViewModel, UUID uuid, Throwable th) {
        return m987onConfirmTapped$lambda3(consumerCardCDVViewModel, uuid, th);
    }

    public static /* synthetic */ kotlin.x c(ConsumerCardCDVViewModel consumerCardCDVViewModel) {
        return m988setup$lambda0(consumerCardCDVViewModel);
    }

    public static /* synthetic */ h.c.h0 d(ConsumerCardCDVViewModel consumerCardCDVViewModel, kotlin.x xVar) {
        return m985onConfirmTapped$lambda1(consumerCardCDVViewModel, xVar);
    }

    private final ConsumerPaymentMethod getPaymentMethod() {
        return (ConsumerPaymentMethod) this.paymentMethod$delegate.getValue();
    }

    /* renamed from: onConfirmTapped$lambda-1 */
    public static final h.c.h0 m985onConfirmTapped$lambda1(ConsumerCardCDVViewModel this$0, kotlin.x it) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(it, "it");
        return this$0.consumerTransferRepository.refresh(true);
    }

    /* renamed from: onConfirmTapped$lambda-2 */
    public static final kotlin.x m986onConfirmTapped$lambda2(ConsumerCardCDVViewModel this$0, UUID uuid, kotlin.x it) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(it, "it");
        Analytics analytics = Analytics.INSTANCE;
        AnalyticsEvent.Companion companion = AnalyticsEvent.Companion;
        String type = this$0.getPaymentMethod().getType();
        kotlin.jvm.internal.m.f(uuid, "uuid");
        analytics.log(AnalyticsEvent_ConsumerKt.consumerCardCDVSuccess(companion, type, uuid));
        this$0.dismissSubject.onNext(kotlin.u.a(ConsumerCardCDVArgs.RESULT_KEY, new ConsumerCardCDVResult.Verified(this$0.getPaymentMethod().getId())));
        return kotlin.x.a;
    }

    /* renamed from: onConfirmTapped$lambda-3 */
    public static final kotlin.x m987onConfirmTapped$lambda3(ConsumerCardCDVViewModel this$0, UUID uuid, Throwable it) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(it, "it");
        Analytics analytics = Analytics.INSTANCE;
        AnalyticsEvent.Companion companion = AnalyticsEvent.Companion;
        String type = this$0.getPaymentMethod().getType();
        kotlin.jvm.internal.m.f(uuid, "uuid");
        analytics.log(AnalyticsEvent_ConsumerKt.consumerCardCDVError(companion, type, uuid));
        ConsumerException.CardVerifyException cardVerifyException = it instanceof ConsumerException.CardVerifyException ? (ConsumerException.CardVerifyException) it : null;
        String errorMessage = cardVerifyException != null ? cardVerifyException.getErrorMessage() : null;
        if (errorMessage == null) {
            errorMessage = LocalizedStrings.INSTANCE.get(R.string.consumer_cdv_error);
        }
        this$0.setState(this$0.state.copy(errorMessage, true, false));
        return kotlin.x.a;
    }

    private final void setState(ConsumerCardCDVState consumerCardCDVState) {
        this.stateSubject.onNext(consumerCardCDVState);
        this.state = consumerCardCDVState;
    }

    /* renamed from: setup$lambda-0 */
    public static final kotlin.x m988setup$lambda0(ConsumerCardCDVViewModel this$0) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        Analytics.INSTANCE.log(AnalyticsEvent_ConsumerKt.consumerCardCDVViewed(AnalyticsEvent.Companion, this$0.getPaymentMethod().getType()));
        this$0.setState(new ConsumerCardCDVState(null, false, false, 7, null));
        return kotlin.x.a;
    }

    public final h.c.s<kotlin.o<String, ConsumerCardCDVResult>> getDismissObservable() {
        return this.dismissObservable;
    }

    public final h.c.s<ConsumerCardCDVState> getStateObservable() {
        return this.stateObservable;
    }

    public final void onAmountsEntered(String amount1, String amount2) {
        BigDecimal j2;
        BigDecimal j3;
        kotlin.jvm.internal.m.g(amount1, "amount1");
        kotlin.jvm.internal.m.g(amount2, "amount2");
        j2 = kotlin.l0.v.j(amount1);
        boolean z = j2 != null;
        j3 = kotlin.l0.v.j(amount2);
        setState(ConsumerCardCDVState.copy$default(this.state, Strings_CoreKt.getEmpty(Strings.INSTANCE), z && (j3 != null), false, 4, null));
    }

    public final h.c.b0<kotlin.x> onConfirmTapped(String amount1, String amount2) {
        kotlin.jvm.internal.m.g(amount1, "amount1");
        kotlin.jvm.internal.m.g(amount2, "amount2");
        setState(ConsumerCardCDVState.copy$default(this.state, null, false, true, 1, null));
        final UUID uuid = UUID.randomUUID();
        Analytics analytics = Analytics.INSTANCE;
        AnalyticsEvent.Companion companion = AnalyticsEvent.Companion;
        String type = getPaymentMethod().getType();
        kotlin.jvm.internal.m.f(uuid, "uuid");
        analytics.log(AnalyticsEvent_ConsumerKt.consumerCardCDVSubmitted(companion, type, uuid));
        h.c.b0<kotlin.x> onErrorReturn = this.consumerTransferRepository.completeCardCDVVerification(getPaymentMethod().getId(), amount1, amount2).flatMap(new h.c.m0.n() { // from class: com.coinbase.wallet.consumer.viewmodels.l0
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return ConsumerCardCDVViewModel.d(ConsumerCardCDVViewModel.this, (kotlin.x) obj);
            }
        }).observeOn(h.c.j0.c.a.b()).map(new h.c.m0.n() { // from class: com.coinbase.wallet.consumer.viewmodels.i0
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return ConsumerCardCDVViewModel.a(ConsumerCardCDVViewModel.this, uuid, (kotlin.x) obj);
            }
        }).onErrorReturn(new h.c.m0.n() { // from class: com.coinbase.wallet.consumer.viewmodels.j0
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return ConsumerCardCDVViewModel.b(ConsumerCardCDVViewModel.this, uuid, (Throwable) obj);
            }
        });
        kotlin.jvm.internal.m.f(onErrorReturn, "consumerTransferRepository\n            .completeCardCDVVerification(\n                paymentMethodId = paymentMethod.id,\n                amount1 = amount1,\n                amount2 = amount2\n            )\n            .flatMap { consumerTransferRepository.refresh(true) }\n            .observeOn(AndroidSchedulers.mainThread())\n            .map {\n                Analytics.log(AnalyticsEvent.consumerCardCDVSuccess(paymentMethod.type, uuid))\n                val result = ConsumerCardCDVArgs.RESULT_KEY to ConsumerCardCDVResult.Verified(paymentMethod.id)\n                dismissSubject.onNext(result)\n            }\n            .onErrorReturn {\n                Analytics.log(AnalyticsEvent.consumerCardCDVError(paymentMethod.type, uuid))\n\n                val errorMessage = (\n                    it as? ConsumerException.CardVerifyException\n                    )?.errorMessage ?: LocalizedStrings[R.string.consumer_cdv_error]\n                state = state.copy(\n                    errorMessage = errorMessage,\n                    buttonEnabled = true,\n                    loading = false\n                )\n                Unit\n            }");
        return onErrorReturn;
    }

    public final h.c.b0<kotlin.x> setup() {
        h.c.b0<kotlin.x> fromCallable = h.c.b0.fromCallable(new Callable() { // from class: com.coinbase.wallet.consumer.viewmodels.k0
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return ConsumerCardCDVViewModel.c(ConsumerCardCDVViewModel.this);
            }
        });
        kotlin.jvm.internal.m.f(fromCallable, "fromCallable {\n        Analytics.log(AnalyticsEvent.consumerCardCDVViewed(paymentMethod.type))\n        state = ConsumerCardCDVState()\n    }");
        return fromCallable;
    }
}