package com.coinbase.wallet.consumer.views;

import com.coinbase.wallet.analytics.Analytics;
import com.coinbase.wallet.analytics.extensions.Observable_AnalyticsKt;
import com.coinbase.wallet.analytics.models.AnalyticsEvent;
import com.coinbase.wallet.commonui.utilities.FragmentLifecycleScopeProvider;
import com.coinbase.wallet.consumer.extensions.AnalyticsEvent_ConsumerKt;
import com.coinbase.wallet.consumer.models.AppToAppInitiatorStatus;
import com.coinbase.wallet.consumer.models.Fallback;
import com.coinbase.wallet.consumer.models.Success;
import com.coinbase.wallet.consumer.viewmodels.ConsumerOnboardingViewModel;
import kotlin.Metadata;

/* compiled from: ConsumerOnboardingFragment.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/coinbase/wallet/consumer/models/AppToAppInitiatorStatus;", "kotlin.jvm.PlatformType", "appToAppInitiator", "Lkotlin/x;", "<anonymous>", "(Lcom/coinbase/wallet/consumer/models/AppToAppInitiatorStatus;)V"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class ConsumerOnboardingFragment$startConnecting$2 extends kotlin.jvm.internal.o implements kotlin.e0.c.l<AppToAppInitiatorStatus, kotlin.x> {
    final /* synthetic */ ConsumerOnboardingFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ConsumerOnboardingFragment$startConnecting$2(ConsumerOnboardingFragment consumerOnboardingFragment) {
        super(1);
        this.this$0 = consumerOnboardingFragment;
    }

    public static /* synthetic */ void a(ConsumerOnboardingFragment consumerOnboardingFragment, AppToAppInitiatorStatus appToAppInitiatorStatus, kotlin.x xVar) {
        m1035invoke$lambda0(consumerOnboardingFragment, appToAppInitiatorStatus, xVar);
    }

    /* renamed from: invoke$lambda-0 */
    public static final void m1035invoke$lambda0(ConsumerOnboardingFragment this$0, AppToAppInitiatorStatus appToAppInitiatorStatus, kotlin.x xVar) {
        ConsumerOnboardingViewModel onboardingViewModel;
        kotlin.jvm.internal.m.g(this$0, "this$0");
        Analytics analytics = Analytics.INSTANCE;
        AnalyticsEvent.Companion companion = AnalyticsEvent.Companion;
        onboardingViewModel = this$0.getOnboardingViewModel();
        analytics.log(AnalyticsEvent_ConsumerKt.consumerSignInApptoAppStarted(companion, onboardingViewModel.getConnectStatus$consumer_productionRelease().getOnrampEnabled()));
        this$0.startActivityForResult(((Success) appToAppInitiatorStatus).getIntent(), 1);
    }

    @Override // kotlin.e0.c.l
    public /* bridge */ /* synthetic */ kotlin.x invoke(AppToAppInitiatorStatus appToAppInitiatorStatus) {
        invoke2(appToAppInitiatorStatus);
        return kotlin.x.a;
    }

    /* renamed from: invoke */
    public final void invoke2(final AppToAppInitiatorStatus appToAppInitiatorStatus) {
        h.c.v0.b loginClickedSubject;
        FragmentLifecycleScopeProvider onDestroyScopeProvider;
        if (kotlin.jvm.internal.m.c(appToAppInitiatorStatus, Fallback.INSTANCE)) {
            this.this$0.startWebView(false);
        } else if (appToAppInitiatorStatus instanceof Success) {
            loginClickedSubject = this.this$0.getLoginClickedSubject();
            h.c.s<T> observeOn = loginClickedSubject.observeOn(h.c.j0.c.a.b());
            final ConsumerOnboardingFragment consumerOnboardingFragment = this.this$0;
            h.c.s doOnNext = observeOn.doOnNext(new h.c.m0.f() { // from class: com.coinbase.wallet.consumer.views.f
                @Override // h.c.m0.f
                public final void accept(Object obj) {
                    ConsumerOnboardingFragment$startConnecting$2.a(ConsumerOnboardingFragment.this, appToAppInitiatorStatus, (kotlin.x) obj);
                }
            });
            kotlin.jvm.internal.m.f(doOnNext, "loginClickedSubject\n                                .observeOn(AndroidSchedulers.mainThread())\n                                .doOnNext {\n                                    Analytics.log(\n                                        AnalyticsEvent.consumerSignInApptoAppStarted(\n                                            onrampEnabled = onboardingViewModel.connectStatus.onrampEnabled\n                                        )\n                                    )\n\n                                    startActivityForResult(appToAppInitiator.intent, appToAppRequestCode)\n                                }");
            h.c.s logError$default = Observable_AnalyticsKt.logError$default(doOnNext, "Couldn't setup app to app activity", null, 2, null);
            onDestroyScopeProvider = this.this$0.getOnDestroyScopeProvider();
            ((com.uber.autodispose.x) logError$default.as(com.uber.autodispose.d.a(onDestroyScopeProvider))).subscribe();
        }
    }
}