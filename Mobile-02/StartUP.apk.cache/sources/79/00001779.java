package com.coinbase.wallet.consumer.viewmodels;

import com.coinbase.ApiConstants;
import com.coinbase.wallet.analytics.Analytics;
import com.coinbase.wallet.analytics.models.AnalyticsEvent;
import com.coinbase.wallet.consumer.extensions.AnalyticsEvent_ConsumerKt;
import com.coinbase.wallet.consumer.models.AvailableBuyAndSendTransfer;
import com.coinbase.wallet.consumer.models.ConsumerBuyOrder;
import com.coinbase.wallet.consumer.models.ConsumerSecure3DEvent;
import com.coinbase.wallet.consumer.models.ConsumerSecure3DVerificationArgs;
import com.coinbase.wallet.consumer.models.ConsumerSecure3DVerificationResult;
import com.coinbase.wallet.consumer.models.ConsumerSecure3DVerificationViewState;
import com.coinbase.wallet.consumer.models.ConsumerWebViewConfig;
import com.coinbase.wallet.consumer.models.Secure3DVerification;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import okhttp3.FormBody;
import okhttp3.RequestBody;

/* compiled from: ConsumerSecure3DVerificationViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\u0018\u0000 F2\u00020\u0001:\u0002FGB\u001b\b\u0007\u0012\u0006\u0010(\u001a\u00020'\u0012\b\b\u0001\u0010%\u001a\u00020$¢\u0006\u0004\bD\u0010EJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\r\u0010\t\u001a\u00020\u0004¢\u0006\u0004\b\t\u0010\bJ\u001f\u0010\r\u001a\u00020\f2\u0006\u0010\n\u001a\u00020\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\r\u0010\u000eJ\r\u0010\u000f\u001a\u00020\u0004¢\u0006\u0004\b\u000f\u0010\bJ\r\u0010\u0010\u001a\u00020\u0004¢\u0006\u0004\b\u0010\u0010\bR$\u0010\u0014\u001a\u0010\u0012\f\u0012\n \u0013*\u0004\u0018\u00010\u00120\u00120\u00118\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R<\u0010\u0018\u001a(\u0012$\u0012\"\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0017 \u0013*\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u00160\u00160\u00118\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0015R\u001d\u0010\u001e\u001a\u00020\u00198B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u001d\u0010#\u001a\u00020\u001f8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b \u0010\u001b\u001a\u0004\b!\u0010\"R\u0016\u0010%\u001a\u00020$8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010(\u001a\u00020'8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b(\u0010)R\u001d\u0010.\u001a\u00020*8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b+\u0010\u001b\u001a\u0004\b,\u0010-R+\u00100\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00170\u00160/8\u0006@\u0006¢\u0006\f\n\u0004\b0\u00101\u001a\u0004\b2\u00103R\u001f\u00104\u001a\b\u0012\u0004\u0012\u00020\u00120/8\u0006@\u0006¢\u0006\f\n\u0004\b4\u00101\u001a\u0004\b5\u00103R\u001f\u00107\u001a\b\u0012\u0004\u0012\u0002060/8\u0006@\u0006¢\u0006\f\n\u0004\b7\u00101\u001a\u0004\b8\u00103R\u001d\u0010=\u001a\u0002098B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b:\u0010\u001b\u001a\u0004\b;\u0010<R$\u0010>\u001a\u0010\u0012\f\u0012\n \u0013*\u0004\u0018\u000106060\u00118\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b>\u0010\u0015R$\u0010@\u001a\u0002062\u0006\u0010?\u001a\u0002068\u0002@BX\u0082\u000e¢\u0006\f\n\u0004\b@\u0010A\"\u0004\bB\u0010C¨\u0006H"}, d2 = {"Lcom/coinbase/wallet/consumer/viewmodels/ConsumerSecure3DVerificationViewModel;", "Landroidx/lifecycle/b0;", "", "paymentResult", "Lkotlin/x;", "onAuthorizationCompleted", "(Ljava/lang/String;)V", "onAuthorizationFailed", "()V", "setup", "url", "paRes", "", "redirectToApp", "(Ljava/lang/String;Ljava/lang/String;)Z", "onUrlLoaded", "onBackPressed", "Lh/c/v0/b;", "Lcom/coinbase/wallet/consumer/models/ConsumerSecure3DEvent;", "kotlin.jvm.PlatformType", "eventSubject", "Lh/c/v0/b;", "Lkotlin/o;", "Lcom/coinbase/wallet/consumer/models/ConsumerSecure3DVerificationResult;", "dismissSubject", "Lcom/coinbase/wallet/consumer/models/ConsumerBuyOrder;", "buyOrder$delegate", "Lkotlin/h;", "getBuyOrder", "()Lcom/coinbase/wallet/consumer/models/ConsumerBuyOrder;", "buyOrder", "Lcom/coinbase/wallet/consumer/models/AvailableBuyAndSendTransfer;", "selectedTransferMethod$delegate", "getSelectedTransferMethod", "()Lcom/coinbase/wallet/consumer/models/AvailableBuyAndSendTransfer;", "selectedTransferMethod", "Landroidx/lifecycle/z;", "savedStateHandle", "Landroidx/lifecycle/z;", "Lcom/coinbase/wallet/consumer/models/ConsumerWebViewConfig;", "consumerWebViewConfig", "Lcom/coinbase/wallet/consumer/models/ConsumerWebViewConfig;", "Ljava/util/UUID;", "uuid$delegate", "getUuid", "()Ljava/util/UUID;", "uuid", "Lh/c/s;", "dismissObservable", "Lh/c/s;", "getDismissObservable", "()Lh/c/s;", "eventObservable", "getEventObservable", "Lcom/coinbase/wallet/consumer/models/ConsumerSecure3DVerificationViewState;", "stateObservable", "getStateObservable", "Lcom/coinbase/wallet/consumer/models/Secure3DVerification;", "secure3DVerification$delegate", "getSecure3DVerification", "()Lcom/coinbase/wallet/consumer/models/Secure3DVerification;", "secure3DVerification", "stateSubject", "value", ApiConstants.STATE, "Lcom/coinbase/wallet/consumer/models/ConsumerSecure3DVerificationViewState;", "setState", "(Lcom/coinbase/wallet/consumer/models/ConsumerSecure3DVerificationViewState;)V", "<init>", "(Lcom/coinbase/wallet/consumer/models/ConsumerWebViewConfig;Landroidx/lifecycle/z;)V", "Companion", "Factory", "consumer_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class ConsumerSecure3DVerificationViewModel extends androidx.lifecycle.b0 {
    public static final Companion Companion = new Companion(null);
    private final kotlin.h buyOrder$delegate;
    private final ConsumerWebViewConfig consumerWebViewConfig;
    private final h.c.s<kotlin.o<String, ConsumerSecure3DVerificationResult>> dismissObservable;
    private final h.c.v0.b<kotlin.o<String, ConsumerSecure3DVerificationResult>> dismissSubject;
    private final h.c.s<ConsumerSecure3DEvent> eventObservable;
    private final h.c.v0.b<ConsumerSecure3DEvent> eventSubject;
    private final androidx.lifecycle.z savedStateHandle;
    private final kotlin.h secure3DVerification$delegate;
    private final kotlin.h selectedTransferMethod$delegate;
    private ConsumerSecure3DVerificationViewState state;
    private final h.c.s<ConsumerSecure3DVerificationViewState> stateObservable;
    private final h.c.v0.b<ConsumerSecure3DVerificationViewState> stateSubject;
    private final kotlin.h uuid$delegate;

    /* compiled from: ConsumerSecure3DVerificationViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0013\u0010\t\u001a\u00020\b*\u00020\u0007H\u0002¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\u000f\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\u0002H\u0000¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u0012"}, d2 = {"Lcom/coinbase/wallet/consumer/viewmodels/ConsumerSecure3DVerificationViewModel$Companion;", "", "Lcom/coinbase/wallet/consumer/models/Secure3DVerification;", "params", "Lokhttp3/FormBody;", "buildFormBody", "(Lcom/coinbase/wallet/consumer/models/Secure3DVerification;)Lokhttp3/FormBody;", "Lokhttp3/RequestBody;", "Lj/f;", "asBuffer", "(Lokhttp3/RequestBody;)Lj/f;", "payload", "", "buildPostBody$consumer_productionRelease", "(Lcom/coinbase/wallet/consumer/models/Secure3DVerification;)[B", "buildPostBody", "<init>", "()V", "consumer_productionRelease"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final j.f asBuffer(RequestBody requestBody) {
            j.f fVar = new j.f();
            requestBody.writeTo(fVar);
            return fVar;
        }

        private final FormBody buildFormBody(Secure3DVerification secure3DVerification) {
            FormBody.Builder builder = new FormBody.Builder(null, 1, null);
            builder.add("PaReq", secure3DVerification.getPaReq());
            builder.add("TermUrl", secure3DVerification.getRedirectURL());
            return builder.build();
        }

        public final byte[] buildPostBody$consumer_productionRelease(Secure3DVerification payload) {
            kotlin.jvm.internal.m.g(payload, "payload");
            return asBuffer(buildFormBody(payload)).J();
        }
    }

    /* compiled from: ConsumerSecure3DVerificationViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/coinbase/wallet/consumer/viewmodels/ConsumerSecure3DVerificationViewModel$Factory;", "", "Landroidx/lifecycle/z;", "savedStateHandle", "Lcom/coinbase/wallet/consumer/viewmodels/ConsumerSecure3DVerificationViewModel;", "create", "(Landroidx/lifecycle/z;)Lcom/coinbase/wallet/consumer/viewmodels/ConsumerSecure3DVerificationViewModel;", "consumer_productionRelease"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public interface Factory {
        ConsumerSecure3DVerificationViewModel create(androidx.lifecycle.z zVar);
    }

    public ConsumerSecure3DVerificationViewModel(ConsumerWebViewConfig consumerWebViewConfig, androidx.lifecycle.z savedStateHandle) {
        kotlin.h b2;
        kotlin.h b3;
        kotlin.h b4;
        kotlin.h b5;
        kotlin.jvm.internal.m.g(consumerWebViewConfig, "consumerWebViewConfig");
        kotlin.jvm.internal.m.g(savedStateHandle, "savedStateHandle");
        this.consumerWebViewConfig = consumerWebViewConfig;
        this.savedStateHandle = savedStateHandle;
        h.c.v0.b<ConsumerSecure3DVerificationViewState> d2 = h.c.v0.b.d();
        kotlin.jvm.internal.m.f(d2, "create<ConsumerSecure3DVerificationViewState>()");
        this.stateSubject = d2;
        h.c.v0.b<ConsumerSecure3DEvent> d3 = h.c.v0.b.d();
        kotlin.jvm.internal.m.f(d3, "create<ConsumerSecure3DEvent>()");
        this.eventSubject = d3;
        h.c.v0.b<kotlin.o<String, ConsumerSecure3DVerificationResult>> d4 = h.c.v0.b.d();
        kotlin.jvm.internal.m.f(d4, "create<Pair<String, ConsumerSecure3DVerificationResult>>()");
        this.dismissSubject = d4;
        this.state = new ConsumerSecure3DVerificationViewState(false, 1, null);
        h.c.s<ConsumerSecure3DVerificationViewState> hide = d2.hide();
        kotlin.jvm.internal.m.f(hide, "stateSubject.hide()");
        this.stateObservable = hide;
        h.c.s<ConsumerSecure3DEvent> hide2 = d3.hide();
        kotlin.jvm.internal.m.f(hide2, "eventSubject.hide()");
        this.eventObservable = hide2;
        h.c.s<kotlin.o<String, ConsumerSecure3DVerificationResult>> hide3 = d4.hide();
        kotlin.jvm.internal.m.f(hide3, "dismissSubject.hide()");
        this.dismissObservable = hide3;
        b2 = kotlin.k.b(new ConsumerSecure3DVerificationViewModel$uuid$2(this));
        this.uuid$delegate = b2;
        b3 = kotlin.k.b(new ConsumerSecure3DVerificationViewModel$secure3DVerification$2(this));
        this.secure3DVerification$delegate = b3;
        b4 = kotlin.k.b(new ConsumerSecure3DVerificationViewModel$buyOrder$2(this));
        this.buyOrder$delegate = b4;
        b5 = kotlin.k.b(new ConsumerSecure3DVerificationViewModel$selectedTransferMethod$2(this));
        this.selectedTransferMethod$delegate = b5;
    }

    private final ConsumerBuyOrder getBuyOrder() {
        return (ConsumerBuyOrder) this.buyOrder$delegate.getValue();
    }

    private final Secure3DVerification getSecure3DVerification() {
        return (Secure3DVerification) this.secure3DVerification$delegate.getValue();
    }

    private final AvailableBuyAndSendTransfer getSelectedTransferMethod() {
        return (AvailableBuyAndSendTransfer) this.selectedTransferMethod$delegate.getValue();
    }

    private final UUID getUuid() {
        return (UUID) this.uuid$delegate.getValue();
    }

    private final void onAuthorizationCompleted(String str) {
        Analytics.INSTANCE.log(AnalyticsEvent_ConsumerKt.consumerSecure3DVerificationAuthorizationCompleted(AnalyticsEvent.Companion, getSelectedTransferMethod().getAccount().getCurrencyCode(), getSelectedTransferMethod().getPaymentMethod().getType(), getUuid()));
        this.dismissSubject.onNext(kotlin.u.a(ConsumerSecure3DVerificationArgs.INSTANCE.getResultKey(), new ConsumerSecure3DVerificationResult.Success(getSelectedTransferMethod(), getBuyOrder(), getUuid(), str)));
    }

    private final void onAuthorizationFailed() {
        Analytics.INSTANCE.log(AnalyticsEvent_ConsumerKt.consumerSecure3DVerificationAuthorizationFailed(AnalyticsEvent.Companion, getSelectedTransferMethod().getAccount().getCurrencyCode(), getSelectedTransferMethod().getPaymentMethod().getType(), getUuid()));
        this.dismissSubject.onNext(kotlin.u.a(ConsumerSecure3DVerificationArgs.INSTANCE.getResultKey(), ConsumerSecure3DVerificationResult.Failed.INSTANCE));
    }

    private final void setState(ConsumerSecure3DVerificationViewState consumerSecure3DVerificationViewState) {
        this.stateSubject.onNext(consumerSecure3DVerificationViewState);
        this.state = consumerSecure3DVerificationViewState;
    }

    public final h.c.s<kotlin.o<String, ConsumerSecure3DVerificationResult>> getDismissObservable() {
        return this.dismissObservable;
    }

    public final h.c.s<ConsumerSecure3DEvent> getEventObservable() {
        return this.eventObservable;
    }

    public final h.c.s<ConsumerSecure3DVerificationViewState> getStateObservable() {
        return this.stateObservable;
    }

    public final void onBackPressed() {
        Analytics.INSTANCE.log(AnalyticsEvent_ConsumerKt.consumerSecure3DVerificationCanceled(AnalyticsEvent.Companion, getSelectedTransferMethod().getAccount().getCurrencyCode(), getSelectedTransferMethod().getPaymentMethod().getType(), getUuid()));
        this.dismissSubject.onNext(kotlin.u.a(ConsumerSecure3DVerificationArgs.INSTANCE.getResultKey(), ConsumerSecure3DVerificationResult.Canceled.INSTANCE));
    }

    public final void onUrlLoaded() {
        Analytics.INSTANCE.log(AnalyticsEvent_ConsumerKt.consumerSecure3DVerificationPageLoaded(AnalyticsEvent.Companion, getSelectedTransferMethod().getAccount().getCurrencyCode(), getSelectedTransferMethod().getPaymentMethod().getType(), getUuid()));
        setState(this.state.copy(false));
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x0031, code lost:
        if (r6 != false) goto L16;
     */
    /* JADX WARN: Removed duplicated region for block: B:11:0x0036 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0037  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean redirectToApp(java.lang.String r6, java.lang.String r7) {
        /*
            r5 = this;
            java.lang.String r0 = "url"
            kotlin.jvm.internal.m.g(r6, r0)
            android.net.Uri r6 = android.net.Uri.parse(r6)
            java.lang.String r6 = r6.getHost()
            r0 = 1
            r1 = 0
            if (r6 != 0) goto L13
        L11:
            r6 = r1
            goto L34
        L13:
            com.coinbase.wallet.consumer.models.ConsumerWebViewConfig r2 = r5.consumerWebViewConfig
            java.lang.String r2 = r2.getHost()
            boolean r2 = kotlin.jvm.internal.m.c(r6, r2)
            if (r2 != 0) goto L33
            com.coinbase.wallet.consumer.models.ConsumerWebViewConfig r2 = r5.consumerWebViewConfig
            java.lang.String r2 = r2.getHost()
            java.lang.String r3 = "."
            java.lang.String r2 = kotlin.jvm.internal.m.o(r3, r2)
            r3 = 2
            r4 = 0
            boolean r6 = kotlin.l0.o.z(r6, r2, r1, r3, r4)
            if (r6 == 0) goto L11
        L33:
            r6 = r0
        L34:
            if (r6 != 0) goto L37
            return r1
        L37:
            if (r7 != 0) goto L44
            java.lang.Object[] r6 = new java.lang.Object[r1]
            java.lang.String r7 = "WorldPay redirected to correct url but no PaRes found"
            l.a.a.i(r7, r6)
            r5.onAuthorizationFailed()
            return r1
        L44:
            r5.onAuthorizationCompleted(r7)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.coinbase.wallet.consumer.viewmodels.ConsumerSecure3DVerificationViewModel.redirectToApp(java.lang.String, java.lang.String):boolean");
    }

    public final void setup() {
        Analytics.INSTANCE.log(AnalyticsEvent_ConsumerKt.consumerSecure3DVerificationViewed(AnalyticsEvent.Companion, getSelectedTransferMethod().getAccount().getCurrencyCode(), getSelectedTransferMethod().getPaymentMethod().getType(), getUuid()));
        setState(this.state.copy(true));
        this.eventSubject.onNext(new ConsumerSecure3DEvent.UrlEvent(getSecure3DVerification().getUrl(), Companion.buildPostBody$consumer_productionRelease(getSecure3DVerification())));
    }
}