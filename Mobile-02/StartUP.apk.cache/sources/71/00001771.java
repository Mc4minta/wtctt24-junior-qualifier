package com.coinbase.wallet.consumer.viewmodels;

import com.coinbase.ApiConstants;
import com.coinbase.wallet.analytics.Analytics;
import com.coinbase.wallet.analytics.models.AnalyticsEvent;
import com.coinbase.wallet.blockchains.models.CurrencyCode;
import com.coinbase.wallet.common.utilities.LocalizedStrings;
import com.coinbase.wallet.commonui.extensions.Fragment_CommonKt;
import com.coinbase.wallet.commonui.models.ViewModelNavRoute;
import com.coinbase.wallet.consumer.R;
import com.coinbase.wallet.consumer.extensions.AnalyticsEvent_ConsumerKt;
import com.coinbase.wallet.consumer.models.Connected;
import com.coinbase.wallet.consumer.models.ConsumerAccountsArgs;
import com.coinbase.wallet.consumer.models.ConsumerConnectionStatus;
import com.coinbase.wallet.consumer.models.ConsumerOnboardingViewEvent;
import com.coinbase.wallet.consumer.models.ConsumerOnboardingViewState;
import com.coinbase.wallet.consumer.models.NotConnected;
import com.coinbase.wallet.consumer.views.UMOActivity;
import com.coinbase.wallet.core.models.Four;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;

/* compiled from: ConsumerOnboardingViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000f\u0018\u00002\u00020\u0001:\u0001;B\u0013\b\u0007\u0012\b\b\u0001\u0010'\u001a\u00020&¢\u0006\u0004\b9\u0010:J\u000f\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\r\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0004J\r\u0010\u0006\u001a\u00020\u0002¢\u0006\u0004\b\u0006\u0010\u0004J\u0013\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\r\u0010\n\u001a\u00020\u0002¢\u0006\u0004\b\n\u0010\u0004J\r\u0010\u000b\u001a\u00020\u0002¢\u0006\u0004\b\u000b\u0010\u0004J\u001d\u0010\u000f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\f¢\u0006\u0004\b\u000f\u0010\u0010R$\u0010\u0014\u001a\u0010\u0012\f\u0012\n \u0013*\u0004\u0018\u00010\u00120\u00120\u00118\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u001d\u0010\u001b\u001a\u00020\u00168@@\u0000X\u0080\u0084\u0002¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u001f\u0010 \u001a\u0004\u0018\u00010\u001c8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001d\u0010\u0018\u001a\u0004\b\u001e\u0010\u001fR\u001f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00020!8\u0006@\u0006¢\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%R\u0016\u0010'\u001a\u00020&8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b'\u0010(R$\u0010*\u001a\u0010\u0012\f\u0012\n \u0013*\u0004\u0018\u00010)0)0\u00118\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b*\u0010\u0015R\u001f\u0010+\u001a\b\u0012\u0004\u0012\u00020)0!8\u0006@\u0006¢\u0006\f\n\u0004\b+\u0010#\u001a\u0004\b,\u0010%R\u001f\u0010.\u001a\b\u0012\u0004\u0012\u00020-0!8\u0006@\u0006¢\u0006\f\n\u0004\b.\u0010#\u001a\u0004\b/\u0010%R$\u00101\u001a\u00020\u00122\u0006\u00100\u001a\u00020\u00128\u0002@BX\u0082\u000e¢\u0006\f\n\u0004\b1\u00102\"\u0004\b3\u00104R\u001f\u00105\u001a\b\u0012\u0004\u0012\u00020\u00120!8\u0006@\u0006¢\u0006\f\n\u0004\b5\u0010#\u001a\u0004\b6\u0010%R$\u00107\u001a\u0010\u0012\f\u0012\n \u0013*\u0004\u0018\u00010\u00020\u00020\u00118\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b7\u0010\u0015R$\u00108\u001a\u0010\u0012\f\u0012\n \u0013*\u0004\u0018\u00010-0-0\u00118\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b8\u0010\u0015¨\u0006<"}, d2 = {"Lcom/coinbase/wallet/consumer/viewmodels/ConsumerOnboardingViewModel;", "Landroidx/lifecycle/b0;", "Lkotlin/x;", "setupState", "()V", "setup", "onLoginButtonClicked", "Lh/c/b0;", "onSecondaryButtonClicked", "()Lh/c/b0;", "onBackPressed", "setConnectionSuccessful", "", "requestCode", "resultCode", "onActivityResult", "(II)V", "Lh/c/v0/b;", "Lcom/coinbase/wallet/consumer/models/ConsumerOnboardingViewState;", "kotlin.jvm.PlatformType", "stateSubject", "Lh/c/v0/b;", "Lcom/coinbase/wallet/consumer/models/ConsumerConnectionStatus;", "connectStatus$delegate", "Lkotlin/h;", "getConnectStatus$consumer_productionRelease", "()Lcom/coinbase/wallet/consumer/models/ConsumerConnectionStatus;", "connectStatus", "Lcom/coinbase/wallet/blockchains/models/CurrencyCode;", "forwardingCurrencyCode$delegate", "getForwardingCurrencyCode", "()Lcom/coinbase/wallet/blockchains/models/CurrencyCode;", "forwardingCurrencyCode", "Lh/c/s;", "dismissObservable", "Lh/c/s;", "getDismissObservable", "()Lh/c/s;", "Landroidx/lifecycle/z;", "savedStateHandle", "Landroidx/lifecycle/z;", "Lcom/coinbase/wallet/commonui/models/ViewModelNavRoute;", "navigationSubject", "navigationObservable", "getNavigationObservable", "Lcom/coinbase/wallet/consumer/models/ConsumerOnboardingViewEvent;", "eventsObservable", "getEventsObservable", "value", ApiConstants.STATE, "Lcom/coinbase/wallet/consumer/models/ConsumerOnboardingViewState;", "setState", "(Lcom/coinbase/wallet/consumer/models/ConsumerOnboardingViewState;)V", "stateObservable", "getStateObservable", "dismissSubject", "eventsSubject", "<init>", "(Landroidx/lifecycle/z;)V", "Factory", "consumer_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class ConsumerOnboardingViewModel extends androidx.lifecycle.b0 {
    private final kotlin.h connectStatus$delegate;
    private final h.c.s<kotlin.x> dismissObservable;
    private final h.c.v0.b<kotlin.x> dismissSubject;
    private final h.c.s<ConsumerOnboardingViewEvent> eventsObservable;
    private final h.c.v0.b<ConsumerOnboardingViewEvent> eventsSubject;
    private final kotlin.h forwardingCurrencyCode$delegate;
    private final h.c.s<ViewModelNavRoute> navigationObservable;
    private final h.c.v0.b<ViewModelNavRoute> navigationSubject;
    private final androidx.lifecycle.z savedStateHandle;
    private ConsumerOnboardingViewState state;
    private final h.c.s<ConsumerOnboardingViewState> stateObservable;
    private final h.c.v0.b<ConsumerOnboardingViewState> stateSubject;

    /* compiled from: ConsumerOnboardingViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/coinbase/wallet/consumer/viewmodels/ConsumerOnboardingViewModel$Factory;", "", "Landroidx/lifecycle/z;", "savedStateHandle", "Lcom/coinbase/wallet/consumer/viewmodels/ConsumerOnboardingViewModel;", "create", "(Landroidx/lifecycle/z;)Lcom/coinbase/wallet/consumer/viewmodels/ConsumerOnboardingViewModel;", "consumer_productionRelease"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public interface Factory {
        ConsumerOnboardingViewModel create(androidx.lifecycle.z zVar);
    }

    public ConsumerOnboardingViewModel(androidx.lifecycle.z savedStateHandle) {
        kotlin.h b2;
        kotlin.h b3;
        kotlin.jvm.internal.m.g(savedStateHandle, "savedStateHandle");
        this.savedStateHandle = savedStateHandle;
        h.c.v0.b<kotlin.x> d2 = h.c.v0.b.d();
        kotlin.jvm.internal.m.f(d2, "create<Unit>()");
        this.dismissSubject = d2;
        h.c.v0.b<ViewModelNavRoute> d3 = h.c.v0.b.d();
        kotlin.jvm.internal.m.f(d3, "create<ViewModelNavRoute>()");
        this.navigationSubject = d3;
        h.c.v0.b<ConsumerOnboardingViewEvent> d4 = h.c.v0.b.d();
        kotlin.jvm.internal.m.f(d4, "create<ConsumerOnboardingViewEvent>()");
        this.eventsSubject = d4;
        h.c.v0.b<ConsumerOnboardingViewState> d5 = h.c.v0.b.d();
        kotlin.jvm.internal.m.f(d5, "create<ConsumerOnboardingViewState>()");
        this.stateSubject = d5;
        b2 = kotlin.k.b(new ConsumerOnboardingViewModel$forwardingCurrencyCode$2(this));
        this.forwardingCurrencyCode$delegate = b2;
        b3 = kotlin.k.b(new ConsumerOnboardingViewModel$connectStatus$2(this));
        this.connectStatus$delegate = b3;
        this.state = new ConsumerOnboardingViewState(false, false, null, null, null, null, false, 127, null);
        h.c.s<kotlin.x> hide = d2.hide();
        kotlin.jvm.internal.m.f(hide, "dismissSubject.hide()");
        this.dismissObservable = hide;
        h.c.s<ViewModelNavRoute> hide2 = d3.hide();
        kotlin.jvm.internal.m.f(hide2, "navigationSubject.hide()");
        this.navigationObservable = hide2;
        h.c.s<ConsumerOnboardingViewEvent> hide3 = d4.hide();
        kotlin.jvm.internal.m.f(hide3, "eventsSubject.hide()");
        this.eventsObservable = hide3;
        h.c.s<ConsumerOnboardingViewState> hide4 = d5.hide();
        kotlin.jvm.internal.m.f(hide4, "stateSubject.hide()");
        this.stateObservable = hide4;
    }

    public static /* synthetic */ kotlin.x a(ConsumerOnboardingViewModel consumerOnboardingViewModel, Long l2) {
        return m990onSecondaryButtonClicked$lambda1(consumerOnboardingViewModel, l2);
    }

    public static /* synthetic */ void b(ConsumerOnboardingViewModel consumerOnboardingViewModel, h.c.k0.b bVar) {
        m989onSecondaryButtonClicked$lambda0(consumerOnboardingViewModel, bVar);
    }

    private final CurrencyCode getForwardingCurrencyCode() {
        return (CurrencyCode) this.forwardingCurrencyCode$delegate.getValue();
    }

    /* renamed from: onSecondaryButtonClicked$lambda-0 */
    public static final void m989onSecondaryButtonClicked$lambda0(ConsumerOnboardingViewModel this$0, h.c.k0.b bVar) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        this$0.setState(ConsumerOnboardingViewState.copy$default(this$0.state, false, false, null, null, null, LocalizedStrings.INSTANCE.get(R.string.consumer_opening_coinbase), true, 31, null));
    }

    /* renamed from: onSecondaryButtonClicked$lambda-1 */
    public static final kotlin.x m990onSecondaryButtonClicked$lambda1(ConsumerOnboardingViewModel this$0, Long it) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(it, "it");
        this$0.setState(ConsumerOnboardingViewState.copy$default(this$0.state, true, false, null, null, null, null, false, 126, null));
        this$0.eventsSubject.onNext(new ConsumerOnboardingViewEvent.StartActivityForResult(UMOActivity.class, 2));
        return kotlin.x.a;
    }

    private final void setState(ConsumerOnboardingViewState consumerOnboardingViewState) {
        this.state = consumerOnboardingViewState;
        this.stateSubject.onNext(consumerOnboardingViewState);
    }

    private final void setupState() {
        Four four;
        if (getConnectStatus$consumer_productionRelease().getOnrampEnabled()) {
            LocalizedStrings localizedStrings = LocalizedStrings.INSTANCE;
            four = new Four(localizedStrings.get(R.string.consumer_connect_onramp_privacy_title), localizedStrings.get(R.string.consumer_connect_onramp_privacy_details), localizedStrings.get(R.string.consumer_login_button), localizedStrings.get(R.string.consumer_sign_up_button));
        } else {
            LocalizedStrings localizedStrings2 = LocalizedStrings.INSTANCE;
            four = new Four(localizedStrings2.get(R.string.connect_accounts), localizedStrings2.get(R.string.consumer_connect_privacy_notice_body), localizedStrings2.get(R.string.connect_accounts_now), localizedStrings2.get(R.string.consumer_connect_later));
        }
        setState(ConsumerOnboardingViewState.copy$default(this.state, true, false, (String) four.component1(), (String) four.component2(), (String) four.component3(), (String) four.component4(), false, 2, null));
    }

    public final ConsumerConnectionStatus getConnectStatus$consumer_productionRelease() {
        return (ConsumerConnectionStatus) this.connectStatus$delegate.getValue();
    }

    public final h.c.s<kotlin.x> getDismissObservable() {
        return this.dismissObservable;
    }

    public final h.c.s<ConsumerOnboardingViewEvent> getEventsObservable() {
        return this.eventsObservable;
    }

    public final h.c.s<ViewModelNavRoute> getNavigationObservable() {
        return this.navigationObservable;
    }

    public final h.c.s<ConsumerOnboardingViewState> getStateObservable() {
        return this.stateObservable;
    }

    public final void onActivityResult(int i2, int i3) {
        if (i2 == 2) {
            if (i3 == -1) {
                Analytics.INSTANCE.log(AnalyticsEvent_ConsumerKt.consumerOnrampOnboardingSuccess(AnalyticsEvent.Companion, getConnectStatus$consumer_productionRelease().getOnrampEnabled()));
                setConnectionSuccessful();
                return;
            }
            Analytics.INSTANCE.log(AnalyticsEvent_ConsumerKt.consumerOnrampOnboardingCanceled(AnalyticsEvent.Companion, getConnectStatus$consumer_productionRelease().getOnrampEnabled()));
            this.dismissSubject.onNext(kotlin.x.a);
        }
    }

    public final void onBackPressed() {
        this.dismissSubject.onNext(kotlin.x.a);
    }

    public final void onLoginButtonClicked() {
        setState(ConsumerOnboardingViewState.copy$default(this.state, true, false, null, null, null, null, false, 126, null));
    }

    public final h.c.b0<kotlin.x> onSecondaryButtonClicked() {
        if (getConnectStatus$consumer_productionRelease().getOnrampEnabled()) {
            Analytics.INSTANCE.log(AnalyticsEvent_ConsumerKt.consumerSignupButtonTapped(AnalyticsEvent.Companion));
            h.c.b0 map = h.c.b0.timer(3L, TimeUnit.SECONDS).observeOn(h.c.j0.c.a.b()).doOnSubscribe(new h.c.m0.f() { // from class: com.coinbase.wallet.consumer.viewmodels.n0
                @Override // h.c.m0.f
                public final void accept(Object obj) {
                    ConsumerOnboardingViewModel.b(ConsumerOnboardingViewModel.this, (h.c.k0.b) obj);
                }
            }).map(new h.c.m0.n() { // from class: com.coinbase.wallet.consumer.viewmodels.m0
                @Override // h.c.m0.n
                public final Object apply(Object obj) {
                    return ConsumerOnboardingViewModel.a(ConsumerOnboardingViewModel.this, (Long) obj);
                }
            });
            kotlin.jvm.internal.m.f(map, "{\n            Analytics.log(AnalyticsEvent.consumerSignupButtonTapped())\n            Single.timer(3L, TimeUnit.SECONDS)\n                .observeOn(AndroidSchedulers.mainThread())\n                .doOnSubscribe {\n                    state = state.copy(\n                        secondaryButtonText = LocalizedStrings[R.string.consumer_opening_coinbase],\n                        secondaryButtonProgressVisible = true\n                    )\n                }\n                .map {\n                    state = state.copy(showLoading = true)\n                    val umoEvent = ConsumerOnboardingViewEvent.StartActivityForResult(\n                        UMOActivity::class.java,\n                        umoRequestCode\n                    )\n                    eventsSubject.onNext(umoEvent)\n                }\n        }");
            return map;
        }
        h.c.v0.b<kotlin.x> bVar = this.dismissSubject;
        kotlin.x xVar = kotlin.x.a;
        bVar.onNext(xVar);
        h.c.b0<kotlin.x> just = h.c.b0.just(xVar);
        kotlin.jvm.internal.m.f(just, "{\n            dismissSubject.onNext(Unit)\n            Single.just(Unit)\n        }");
        return just;
    }

    public final void setConnectionSuccessful() {
        androidx.navigation.p a = Fragment_CommonKt.getFadeInNavOptionsBuilder(this).g(R.id.consumerOnboardingFragment, true).a();
        kotlin.jvm.internal.m.f(a, "fadeInNavOptionsBuilder\n            .setPopUpTo(R.id.consumerOnboardingFragment, true)\n            .build()");
        this.navigationSubject.onNext(new ViewModelNavRoute(R.id.action_consumerOnboardingFragment_to_consumerFragment, ConsumerAccountsArgs.INSTANCE.createArguments(getConnectStatus$consumer_productionRelease().getOnrampEnabled(), getForwardingCurrencyCode(), true), a));
    }

    public final void setup() {
        setupState();
        ConsumerConnectionStatus connectStatus$consumer_productionRelease = getConnectStatus$consumer_productionRelease();
        this.eventsSubject.onNext(ConsumerOnboardingViewEvent.HideKeyboard.INSTANCE);
        if (connectStatus$consumer_productionRelease instanceof NotConnected) {
            Analytics.INSTANCE.log(AnalyticsEvent_ConsumerKt.consumerConnectStart(AnalyticsEvent.Companion, connectStatus$consumer_productionRelease.getOnrampEnabled()));
            this.eventsSubject.onNext(ConsumerOnboardingViewEvent.StartConnection.INSTANCE);
            setState(ConsumerOnboardingViewState.copy$default(this.state, false, true, null, null, null, null, false, 124, null));
        } else if (connectStatus$consumer_productionRelease instanceof Connected) {
            ConsumerOnboardingViewEvent.StartActivityForResult startActivityForResult = new ConsumerOnboardingViewEvent.StartActivityForResult(UMOActivity.class, 2);
            Analytics.INSTANCE.log(AnalyticsEvent_ConsumerKt.consumerOnrampOnboardingShown(AnalyticsEvent.Companion, connectStatus$consumer_productionRelease.getOnrampEnabled()));
            this.eventsSubject.onNext(startActivityForResult);
        }
    }
}