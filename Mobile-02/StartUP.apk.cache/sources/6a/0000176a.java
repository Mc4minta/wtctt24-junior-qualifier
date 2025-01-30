package com.coinbase.wallet.consumer.viewmodels;

import com.coinbase.wallet.blockchains.models.CurrencyCode;
import com.coinbase.wallet.common.extensions.SavedStateHandle_CommonKt;
import com.coinbase.wallet.commonui.models.ViewModelNavRoute;
import com.coinbase.wallet.consumer.R;
import com.coinbase.wallet.consumer.models.Connected;
import com.coinbase.wallet.consumer.models.ConsumerAccountsArgs;
import com.coinbase.wallet.consumer.models.ConsumerConnectionStatus;
import com.coinbase.wallet.consumer.models.ConsumerInterstitialArgs;
import com.coinbase.wallet.consumer.models.ConsumerOnboardingArgs;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: ConsumerInterstitialViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 +2\u00020\u0001:\u0002+,B\u0013\b\u0007\u0012\b\b\u0001\u0010\"\u001a\u00020!¢\u0006\u0004\b)\u0010*J\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\r\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0004R\u0019\u0010\u0007\u001a\u00020\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0007\u0010\tR\u001f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n8\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00108\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00020\u00108\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0012R\u001f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00020\n8\u0006@\u0006¢\u0006\f\n\u0004\b\u0014\u0010\r\u001a\u0004\b\u0015\u0010\u000fR$\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u00068B@BX\u0082\u000e¢\u0006\f\u001a\u0004\b\u0017\u0010\t\"\u0004\b\u0018\u0010\u0019R\u001d\u0010 \u001a\u00020\u001b8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u0016\u0010\"\u001a\u00020!8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\"\u0010#R\u0018\u0010%\u001a\u0004\u0018\u00010$8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b%\u0010&R\u0019\u0010'\u001a\u00020\u00068\u0006@\u0006¢\u0006\f\n\u0004\b'\u0010\b\u001a\u0004\b(\u0010\t¨\u0006-"}, d2 = {"Lcom/coinbase/wallet/consumer/viewmodels/ConsumerInterstitialViewModel;", "Landroidx/lifecycle/b0;", "Lkotlin/x;", "onPause", "()V", "setup", "", "isDefaultTransition", "Z", "()Z", "Lh/c/s;", "Lcom/coinbase/wallet/commonui/models/ViewModelNavRoute;", "navigationObservable", "Lh/c/s;", "getNavigationObservable", "()Lh/c/s;", "Lh/c/v0/b;", "navigationSubject", "Lh/c/v0/b;", "dismissSubject", "dismissObservable", "getDismissObservable", "value", "getShouldFinish", "setShouldFinish", "(Z)V", ConsumerInterstitialViewModel.shouldFinishKey, "Lcom/coinbase/wallet/consumer/models/ConsumerConnectionStatus;", "connectionStatus$delegate", "Lkotlin/h;", "getConnectionStatus", "()Lcom/coinbase/wallet/consumer/models/ConsumerConnectionStatus;", "connectionStatus", "Landroidx/lifecycle/z;", "savedStateHandle", "Landroidx/lifecycle/z;", "Lcom/coinbase/wallet/blockchains/models/CurrencyCode;", "forwardingCurrency", "Lcom/coinbase/wallet/blockchains/models/CurrencyCode;", "hasSharedElementTransition", "getHasSharedElementTransition", "<init>", "(Landroidx/lifecycle/z;)V", "Companion", "Factory", "consumer_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class ConsumerInterstitialViewModel extends androidx.lifecycle.b0 {
    public static final Companion Companion = new Companion(null);
    private static final String shouldFinishKey = "shouldFinish";
    private final kotlin.h connectionStatus$delegate;
    private final h.c.s<kotlin.x> dismissObservable;
    private final h.c.v0.b<kotlin.x> dismissSubject;
    private final CurrencyCode forwardingCurrency;
    private final boolean hasSharedElementTransition;
    private final boolean isDefaultTransition;
    private final h.c.s<ViewModelNavRoute> navigationObservable;
    private final h.c.v0.b<ViewModelNavRoute> navigationSubject;
    private final androidx.lifecycle.z savedStateHandle;

    /* compiled from: ConsumerInterstitialViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, d2 = {"Lcom/coinbase/wallet/consumer/viewmodels/ConsumerInterstitialViewModel$Companion;", "", "", "shouldFinishKey", "Ljava/lang/String;", "<init>", "()V", "consumer_productionRelease"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: ConsumerInterstitialViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/coinbase/wallet/consumer/viewmodels/ConsumerInterstitialViewModel$Factory;", "", "Landroidx/lifecycle/z;", "savedStateHandle", "Lcom/coinbase/wallet/consumer/viewmodels/ConsumerInterstitialViewModel;", "create", "(Landroidx/lifecycle/z;)Lcom/coinbase/wallet/consumer/viewmodels/ConsumerInterstitialViewModel;", "consumer_productionRelease"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public interface Factory {
        ConsumerInterstitialViewModel create(androidx.lifecycle.z zVar);
    }

    public ConsumerInterstitialViewModel(androidx.lifecycle.z savedStateHandle) {
        kotlin.jvm.internal.m.g(savedStateHandle, "savedStateHandle");
        this.savedStateHandle = savedStateHandle;
        h.c.v0.b<ViewModelNavRoute> d2 = h.c.v0.b.d();
        kotlin.jvm.internal.m.f(d2, "create()");
        this.navigationSubject = d2;
        h.c.v0.b<kotlin.x> d3 = h.c.v0.b.d();
        kotlin.jvm.internal.m.f(d3, "create()");
        this.dismissSubject = d3;
        this.forwardingCurrency = (CurrencyCode) savedStateHandle.b(ConsumerInterstitialArgs.forwardingCurrencyKey);
        this.connectionStatus$delegate = kotlin.j.b(new ConsumerInterstitialViewModel$connectionStatus$2(this));
        this.hasSharedElementTransition = ((Boolean) SavedStateHandle_CommonKt.require(savedStateHandle, "hasSharedElementTransition")).booleanValue();
        this.isDefaultTransition = ((Boolean) SavedStateHandle_CommonKt.require(savedStateHandle, ConsumerInterstitialArgs.isDefaultTransitionKey)).booleanValue();
        h.c.s<ViewModelNavRoute> hide = d2.hide();
        kotlin.jvm.internal.m.f(hide, "navigationSubject.hide()");
        this.navigationObservable = hide;
        h.c.s<kotlin.x> hide2 = d3.hide();
        kotlin.jvm.internal.m.f(hide2, "dismissSubject.hide()");
        this.dismissObservable = hide2;
    }

    private final ConsumerConnectionStatus getConnectionStatus() {
        return (ConsumerConnectionStatus) this.connectionStatus$delegate.getValue();
    }

    private final boolean getShouldFinish() {
        return kotlin.jvm.internal.m.c(this.savedStateHandle.b(shouldFinishKey), Boolean.TRUE);
    }

    private final void setShouldFinish(boolean z) {
        this.savedStateHandle.g(shouldFinishKey, Boolean.valueOf(z));
    }

    public final h.c.s<kotlin.x> getDismissObservable() {
        return this.dismissObservable;
    }

    public final boolean getHasSharedElementTransition() {
        return this.hasSharedElementTransition;
    }

    public final h.c.s<ViewModelNavRoute> getNavigationObservable() {
        return this.navigationObservable;
    }

    public final boolean isDefaultTransition() {
        return this.isDefaultTransition;
    }

    public final void onPause() {
        setShouldFinish(true);
    }

    public final void setup() {
        if (getShouldFinish()) {
            this.dismissSubject.onNext(kotlin.x.a);
            return;
        }
        ConsumerConnectionStatus connectionStatus = getConnectionStatus();
        if ((connectionStatus instanceof Connected) && !((Connected) connectionStatus).getHasRestrictions()) {
            this.navigationSubject.onNext(new ViewModelNavRoute(R.id.action_consumerInterstitialFragment_to_consumerFragment, ConsumerAccountsArgs.INSTANCE.createArguments(connectionStatus.getOnrampEnabled(), this.forwardingCurrency, false), null, 4, null));
            return;
        }
        this.navigationSubject.onNext(new ViewModelNavRoute(R.id.action_consumerInterstitialFragment_to_consumerOnboardingFragment, ConsumerOnboardingArgs.INSTANCE.createArguments(this.forwardingCurrency, connectionStatus), null, 4, null));
    }
}