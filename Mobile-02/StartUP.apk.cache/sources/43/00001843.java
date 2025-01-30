package com.coinbase.wallet.consumer.views;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.z;
import androidx.lifecycle.i;
import c.h.k.d0;
import com.coinbase.Coinbase;
import com.coinbase.wallet.analytics.Analytics;
import com.coinbase.wallet.analytics.extensions.Observable_AnalyticsKt;
import com.coinbase.wallet.analytics.extensions.Single_AnalyticsKt;
import com.coinbase.wallet.analytics.models.AnalyticsEvent;
import com.coinbase.wallet.common.annotations.ScreenshotProtection;
import com.coinbase.wallet.common.extensions.ObservableSubscribeProxy_CommonKt;
import com.coinbase.wallet.common.extensions.SingleSubscribeProxy_CommonKt;
import com.coinbase.wallet.commonui.di.GenericViewModelFactory;
import com.coinbase.wallet.commonui.extensions.Fragment_CommonKt;
import com.coinbase.wallet.commonui.extensions.TextView_CommonKt;
import com.coinbase.wallet.commonui.extensions.View_CommonKt;
import com.coinbase.wallet.commonui.utilities.FragmentLifecycleScopeProvider;
import com.coinbase.wallet.commonui.views.BackableFragment;
import com.coinbase.wallet.commonui.views.LockedFragment;
import com.coinbase.wallet.commonui.views.StyledFragment;
import com.coinbase.wallet.consumer.R;
import com.coinbase.wallet.consumer.extensions.AnalyticsEvent_ConsumerKt;
import com.coinbase.wallet.consumer.models.AppToAppResult;
import com.coinbase.wallet.consumer.models.ConsumerWebViewConfig;
import com.coinbase.wallet.consumer.repositories.ConsumerUserRepository;
import com.coinbase.wallet.consumer.viewmodels.ConsumerAppToAppViewModel;
import com.coinbase.wallet.consumer.viewmodels.ConsumerOnboardingViewModel;
import com.coinbase.wallet.consumer.views.ConsumerWebViewClient;
import com.uber.autodispose.a0;
import h.c.b0;
import kotlin.Metadata;
import kotlin.jvm.internal.e0;
import org.spongycastle.i18n.MessageBundle;

/* compiled from: ConsumerOnboardingFragment.kt */
@ScreenshotProtection(behavior = ScreenshotProtection.Behavior.BLOCK)
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000ª\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0007¢\u0006\u0004\bf\u0010\u0006J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u000b\u0010\u0006J\u000f\u0010\f\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\f\u0010\u0006J\u001f\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\rH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0012\u0010\u0006J-\u0010\u001a\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u0014\u001a\u00020\u00132\b\u0010\u0016\u001a\u0004\u0018\u00010\u00152\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ!\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u00192\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ)\u0010$\u001a\u00020\u00042\u0006\u0010 \u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\u001f2\b\u0010#\u001a\u0004\u0018\u00010\"H\u0016¢\u0006\u0004\b$\u0010%J\u000f\u0010&\u001a\u00020\u0007H\u0016¢\u0006\u0004\b&\u0010'R\"\u0010)\u001a\u00020(8\u0000@\u0000X\u0081.¢\u0006\u0012\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\u0016\u00102\u001a\u00020/8B@\u0002X\u0082\u0004¢\u0006\u0006\u001a\u0004\b0\u00101R\u0016\u00106\u001a\u0002038V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\b4\u00105R\"\u00108\u001a\u0002078\u0000@\u0000X\u0081.¢\u0006\u0012\n\u0004\b8\u00109\u001a\u0004\b:\u0010;\"\u0004\b<\u0010=R\"\u0010?\u001a\u00020>8\u0000@\u0000X\u0081.¢\u0006\u0012\n\u0004\b?\u0010@\u001a\u0004\bA\u0010B\"\u0004\bC\u0010DR\u0016\u0010F\u001a\u00020E8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\bF\u0010GR(\u0010I\u001a\b\u0012\u0004\u0012\u00020E0H8\u0000@\u0000X\u0081.¢\u0006\u0012\n\u0004\bI\u0010J\u001a\u0004\bK\u0010L\"\u0004\bM\u0010NR\u001d\u0010T\u001a\u00020O8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\bP\u0010Q\u001a\u0004\bR\u0010SR+\u0010Z\u001a\u0010\u0012\f\u0012\n V*\u0004\u0018\u00010\u00040\u00040U8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\bW\u0010Q\u001a\u0004\bX\u0010YR\"\u0010\\\u001a\u00020[8\u0000@\u0000X\u0081.¢\u0006\u0012\n\u0004\b\\\u0010]\u001a\u0004\b^\u0010_\"\u0004\b`\u0010aR\u0016\u0010e\u001a\u00020b8B@\u0002X\u0082\u0004¢\u0006\u0006\u001a\u0004\bc\u0010d¨\u0006g"}, d2 = {"Lcom/coinbase/wallet/consumer/views/ConsumerOnboardingFragment;", "Lcom/coinbase/wallet/commonui/views/LockedFragment;", "Lcom/coinbase/wallet/commonui/views/StyledFragment;", "Lcom/coinbase/wallet/commonui/views/BackableFragment;", "Lkotlin/x;", "startConnecting", "()V", "", "userAgreed", "startWebView", "(Z)V", "initView", "switchToLoadingView", "", MessageBundle.TITLE_ENTRY, "body", "switchToPrivacyNoticeView", "(Ljava/lang/String;Ljava/lang/String;)V", "switchToWebView", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "", "requestCode", "resultCode", "Landroid/content/Intent;", "data", "onActivityResult", "(IILandroid/content/Intent;)V", "onBackPressed", "()Z", "Lcom/coinbase/wallet/consumer/viewmodels/ConsumerOnboardingViewModel$Factory;", "onboardingViewModelFactory", "Lcom/coinbase/wallet/consumer/viewmodels/ConsumerOnboardingViewModel$Factory;", "getOnboardingViewModelFactory$consumer_productionRelease", "()Lcom/coinbase/wallet/consumer/viewmodels/ConsumerOnboardingViewModel$Factory;", "setOnboardingViewModelFactory$consumer_productionRelease", "(Lcom/coinbase/wallet/consumer/viewmodels/ConsumerOnboardingViewModel$Factory;)V", "Lcom/uber/autodispose/y;", "getScopeProvider", "()Lcom/uber/autodispose/y;", "scopeProvider", "Lcom/coinbase/wallet/commonui/views/StyledFragment$Attributes;", "getAttributes", "()Lcom/coinbase/wallet/commonui/views/StyledFragment$Attributes;", "attributes", "Lcom/coinbase/Coinbase;", "coinbaseApi", "Lcom/coinbase/Coinbase;", "getCoinbaseApi$consumer_productionRelease", "()Lcom/coinbase/Coinbase;", "setCoinbaseApi$consumer_productionRelease", "(Lcom/coinbase/Coinbase;)V", "Lcom/coinbase/wallet/consumer/models/ConsumerWebViewConfig;", "consumerWebviewConfig", "Lcom/coinbase/wallet/consumer/models/ConsumerWebViewConfig;", "getConsumerWebviewConfig$consumer_productionRelease", "()Lcom/coinbase/wallet/consumer/models/ConsumerWebViewConfig;", "setConsumerWebviewConfig$consumer_productionRelease", "(Lcom/coinbase/wallet/consumer/models/ConsumerWebViewConfig;)V", "Lcom/coinbase/wallet/consumer/viewmodels/ConsumerAppToAppViewModel;", "appToAppViewModel", "Lcom/coinbase/wallet/consumer/viewmodels/ConsumerAppToAppViewModel;", "Lcom/coinbase/wallet/commonui/di/GenericViewModelFactory;", "appToAppViewModelFactory", "Lcom/coinbase/wallet/commonui/di/GenericViewModelFactory;", "getAppToAppViewModelFactory$consumer_productionRelease", "()Lcom/coinbase/wallet/commonui/di/GenericViewModelFactory;", "setAppToAppViewModelFactory$consumer_productionRelease", "(Lcom/coinbase/wallet/commonui/di/GenericViewModelFactory;)V", "Lcom/coinbase/wallet/consumer/viewmodels/ConsumerOnboardingViewModel;", "onboardingViewModel$delegate", "Lkotlin/h;", "getOnboardingViewModel", "()Lcom/coinbase/wallet/consumer/viewmodels/ConsumerOnboardingViewModel;", "onboardingViewModel", "Lh/c/v0/b;", "kotlin.jvm.PlatformType", "loginClickedSubject$delegate", "getLoginClickedSubject", "()Lh/c/v0/b;", "loginClickedSubject", "Lcom/coinbase/wallet/consumer/repositories/ConsumerUserRepository;", "consumerUserRepository", "Lcom/coinbase/wallet/consumer/repositories/ConsumerUserRepository;", "getConsumerUserRepository$consumer_productionRelease", "()Lcom/coinbase/wallet/consumer/repositories/ConsumerUserRepository;", "setConsumerUserRepository$consumer_productionRelease", "(Lcom/coinbase/wallet/consumer/repositories/ConsumerUserRepository;)V", "Lcom/coinbase/wallet/commonui/utilities/FragmentLifecycleScopeProvider;", "getOnDestroyScopeProvider", "()Lcom/coinbase/wallet/commonui/utilities/FragmentLifecycleScopeProvider;", "onDestroyScopeProvider", "<init>", "consumer_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class ConsumerOnboardingFragment extends LockedFragment implements StyledFragment, BackableFragment {
    private ConsumerAppToAppViewModel appToAppViewModel;
    public GenericViewModelFactory<ConsumerAppToAppViewModel> appToAppViewModelFactory;
    public Coinbase coinbaseApi;
    public ConsumerUserRepository consumerUserRepository;
    public ConsumerWebViewConfig consumerWebviewConfig;
    private final kotlin.h loginClickedSubject$delegate;
    private final kotlin.h onboardingViewModel$delegate;
    public ConsumerOnboardingViewModel.Factory onboardingViewModelFactory;

    public ConsumerOnboardingFragment() {
        kotlin.h b2;
        b2 = kotlin.k.b(ConsumerOnboardingFragment$loginClickedSubject$2.INSTANCE);
        this.loginClickedSubject$delegate = b2;
        this.onboardingViewModel$delegate = z.a(this, e0.b(ConsumerOnboardingViewModel.class), new ConsumerOnboardingFragment$special$$inlined$viewModel$3(new ConsumerOnboardingFragment$special$$inlined$viewModel$2(this)), new ConsumerOnboardingFragment$special$$inlined$viewModel$1(this, this));
    }

    public static /* synthetic */ ConsumerWebViewClient.ConnectionStatus d(kotlin.o oVar) {
        return m1034startWebView$lambda3(oVar);
    }

    public final h.c.v0.b<kotlin.x> getLoginClickedSubject() {
        return (h.c.v0.b) this.loginClickedSubject$delegate.getValue();
    }

    public final FragmentLifecycleScopeProvider getOnDestroyScopeProvider() {
        return Fragment_CommonKt.getFragmentLifecycleScopeProvider(this, i.a.ON_DESTROY);
    }

    public final ConsumerOnboardingViewModel getOnboardingViewModel() {
        return (ConsumerOnboardingViewModel) this.onboardingViewModel$delegate.getValue();
    }

    public final com.uber.autodispose.y getScopeProvider() {
        return Fragment_CommonKt.getFragmentLifecycleScopeProvider$default(this, null, 1, null);
    }

    private final void initView() {
        View view = getView();
        ConsumerOnboardingWebView consumerOnboardingWebView = (ConsumerOnboardingWebView) (view == null ? null : view.findViewById(R.id.webView));
        consumerOnboardingWebView.setCoinbaseApi(getCoinbaseApi$consumer_productionRelease());
        ConsumerWebViewClient consumerWebViewClient = new ConsumerWebViewClient();
        consumerWebViewClient.setConsumerUserRepository(getConsumerUserRepository$consumer_productionRelease());
        kotlin.x xVar = kotlin.x.a;
        consumerOnboardingWebView.setConsumerWebViewClient(consumerWebViewClient);
        consumerOnboardingWebView.setConsumerUserRepository(getConsumerUserRepository$consumer_productionRelease());
        consumerOnboardingWebView.setConsumerWebviewConfig(getConsumerWebviewConfig$consumer_productionRelease());
        String string = getString(R.string.coinbase_consumer_tos_url);
        kotlin.jvm.internal.m.f(string, "getString(R.string.coinbase_consumer_tos_url)");
        String string2 = getString(R.string.coinbase_consumer_privacy_url);
        kotlin.jvm.internal.m.f(string2, "getString(R.string.coinbase_consumer_privacy_url)");
        String string3 = getString(R.string.consumer_connect_privacy_notice_fine_print, string, string2);
        kotlin.jvm.internal.m.f(string3, "getString(R.string.consumer_connect_privacy_notice_fine_print, tosUrl, privacyUrl)");
        View view2 = getView();
        View finePrint = view2 != null ? view2.findViewById(R.id.finePrint) : null;
        kotlin.jvm.internal.m.f(finePrint, "finePrint");
        TextView_CommonKt.addLinkifiedText((TextView) finePrint, string3);
    }

    public final void startConnecting() {
        ConsumerAppToAppViewModel consumerAppToAppViewModel = this.appToAppViewModel;
        if (consumerAppToAppViewModel != null) {
            Object as = consumerAppToAppViewModel.tryInitiateAppToApp().observeOn(h.c.j0.c.a.b()).as(com.uber.autodispose.d.a(getOnDestroyScopeProvider()));
            kotlin.jvm.internal.m.f(as, "appToAppViewModel.tryInitiateAppToApp()\n            .observeOn(AndroidSchedulers.mainThread())\n            .`as`(AutoDispose.autoDisposable(onDestroyScopeProvider))");
            SingleSubscribeProxy_CommonKt.subscribeBy((a0) as, new ConsumerOnboardingFragment$startConnecting$1(this), new ConsumerOnboardingFragment$startConnecting$2(this));
            return;
        }
        kotlin.jvm.internal.m.w("appToAppViewModel");
        throw null;
    }

    public final void startWebView(boolean z) {
        Analytics.INSTANCE.log(AnalyticsEvent_ConsumerKt.consumerSignInWebviewStarted(AnalyticsEvent.Companion, getOnboardingViewModel().getConnectStatus$consumer_productionRelease().getOnrampEnabled()));
        Object just = z ? h.c.s.just(kotlin.x.a) : getLoginClickedSubject();
        kotlin.jvm.internal.m.f(just, "if (userAgreed) Observable.just(Unit) else loginClickedSubject");
        h.c.t0.c cVar = h.c.t0.c.a;
        View view = getView();
        h.c.s observeOn = cVar.a(((ConsumerOnboardingWebView) (view == null ? null : view.findViewById(R.id.webView))).start(), just).map(new h.c.m0.n() { // from class: com.coinbase.wallet.consumer.views.e
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return ConsumerOnboardingFragment.d((kotlin.o) obj);
            }
        }).observeOn(h.c.j0.c.a.b());
        kotlin.jvm.internal.m.f(observeOn, "Observables.combineLatest(webView.start(), userAgreement)\n            .map { (state, _) -> state }\n            .observeOn(AndroidSchedulers.mainThread())");
        Object as = Observable_AnalyticsKt.logError$default(observeOn, "Failure authenticating", null, 2, null).as(com.uber.autodispose.d.a(getOnDestroyScopeProvider()));
        kotlin.jvm.internal.m.f(as, "Observables.combineLatest(webView.start(), userAgreement)\n            .map { (state, _) -> state }\n            .observeOn(AndroidSchedulers.mainThread())\n            .logError(\"Failure authenticating\")\n            .`as`(AutoDispose.autoDisposable(onDestroyScopeProvider))");
        ObservableSubscribeProxy_CommonKt.subscribeBy$default((com.uber.autodispose.x) as, new ConsumerOnboardingFragment$startWebView$2(this), null, new ConsumerOnboardingFragment$startWebView$3(this), 2, null);
    }

    /* renamed from: startWebView$lambda-3 */
    public static final ConsumerWebViewClient.ConnectionStatus m1034startWebView$lambda3(kotlin.o dstr$state$_u24__u24) {
        kotlin.jvm.internal.m.g(dstr$state$_u24__u24, "$dstr$state$_u24__u24");
        return (ConsumerWebViewClient.ConnectionStatus) dstr$state$_u24__u24.a();
    }

    public final void switchToLoadingView() {
        View view = getView();
        View privacyNotice = view == null ? null : view.findViewById(R.id.privacyNotice);
        kotlin.jvm.internal.m.f(privacyNotice, "privacyNotice");
        privacyNotice.setVisibility(8);
        View view2 = getView();
        View progress = view2 == null ? null : view2.findViewById(R.id.progress);
        kotlin.jvm.internal.m.f(progress, "progress");
        progress.setVisibility(0);
        View view3 = getView();
        View webView = view3 != null ? view3.findViewById(R.id.webView) : null;
        kotlin.jvm.internal.m.f(webView, "webView");
        webView.setVisibility(8);
    }

    public final void switchToPrivacyNoticeView(String str, String str2) {
        View view = getView();
        c.s.a0.a((ViewGroup) (view == null ? null : view.findViewById(R.id.rootConsumerConnect)));
        View view2 = getView();
        View privacyNotice = view2 == null ? null : view2.findViewById(R.id.privacyNotice);
        kotlin.jvm.internal.m.f(privacyNotice, "privacyNotice");
        privacyNotice.setVisibility(0);
        View view3 = getView();
        View progress = view3 == null ? null : view3.findViewById(R.id.progress);
        kotlin.jvm.internal.m.f(progress, "progress");
        progress.setVisibility(4);
        View view4 = getView();
        View webView = view4 == null ? null : view4.findViewById(R.id.webView);
        kotlin.jvm.internal.m.f(webView, "webView");
        webView.setVisibility(8);
        View view5 = getView();
        ((TextView) (view5 == null ? null : view5.findViewById(R.id.privacyTitle))).setText(str);
        View view6 = getView();
        ((TextView) (view6 != null ? view6.findViewById(R.id.bodyText) : null)).setText(str2);
    }

    public final void switchToWebView() {
        Analytics.INSTANCE.log(AnalyticsEvent_ConsumerKt.consumerSigninWebviewViewed(AnalyticsEvent.Companion, getOnboardingViewModel().getConnectStatus$consumer_productionRelease().getOnrampEnabled()));
        View view = getView();
        c.s.a0.a((ViewGroup) (view == null ? null : view.findViewById(R.id.rootConsumerConnect)));
        View view2 = getView();
        View privacyNotice = view2 == null ? null : view2.findViewById(R.id.privacyNotice);
        kotlin.jvm.internal.m.f(privacyNotice, "privacyNotice");
        privacyNotice.setVisibility(8);
        View view3 = getView();
        View progress = view3 == null ? null : view3.findViewById(R.id.progress);
        kotlin.jvm.internal.m.f(progress, "progress");
        progress.setVisibility(4);
        View view4 = getView();
        View webView = view4 != null ? view4.findViewById(R.id.webView) : null;
        kotlin.jvm.internal.m.f(webView, "webView");
        webView.setVisibility(0);
    }

    @Override // com.coinbase.wallet.commonui.views.LockedFragment, com.coinbase.wallet.commonui.views.BaseFragment
    public void _$_clearFindViewByIdCache() {
    }

    @Override // com.coinbase.wallet.commonui.views.StyledFragment
    public d0 applyWindowInsets(View view, d0 d0Var) {
        return StyledFragment.DefaultImpls.applyWindowInsets(this, view, d0Var);
    }

    public final GenericViewModelFactory<ConsumerAppToAppViewModel> getAppToAppViewModelFactory$consumer_productionRelease() {
        GenericViewModelFactory<ConsumerAppToAppViewModel> genericViewModelFactory = this.appToAppViewModelFactory;
        if (genericViewModelFactory != null) {
            return genericViewModelFactory;
        }
        kotlin.jvm.internal.m.w("appToAppViewModelFactory");
        throw null;
    }

    @Override // com.coinbase.wallet.commonui.views.StyledFragment
    public StyledFragment.Attributes getAttributes() {
        return StyledFragment.Attributes.copy$default(StyledFragment.DefaultImpls.getAttributes(this), true, false, false, 4, null);
    }

    public final Coinbase getCoinbaseApi$consumer_productionRelease() {
        Coinbase coinbase = this.coinbaseApi;
        if (coinbase != null) {
            return coinbase;
        }
        kotlin.jvm.internal.m.w("coinbaseApi");
        throw null;
    }

    public final ConsumerUserRepository getConsumerUserRepository$consumer_productionRelease() {
        ConsumerUserRepository consumerUserRepository = this.consumerUserRepository;
        if (consumerUserRepository != null) {
            return consumerUserRepository;
        }
        kotlin.jvm.internal.m.w("consumerUserRepository");
        throw null;
    }

    public final ConsumerWebViewConfig getConsumerWebviewConfig$consumer_productionRelease() {
        ConsumerWebViewConfig consumerWebViewConfig = this.consumerWebviewConfig;
        if (consumerWebViewConfig != null) {
            return consumerWebViewConfig;
        }
        kotlin.jvm.internal.m.w("consumerWebviewConfig");
        throw null;
    }

    public final ConsumerOnboardingViewModel.Factory getOnboardingViewModelFactory$consumer_productionRelease() {
        ConsumerOnboardingViewModel.Factory factory = this.onboardingViewModelFactory;
        if (factory != null) {
            return factory;
        }
        kotlin.jvm.internal.m.w("onboardingViewModelFactory");
        throw null;
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i2 == 1) {
            String stringExtra = (intent != null && intent.hasExtra("code")) ? intent.getStringExtra("code") : null;
            String stringExtra2 = (intent != null && intent.hasExtra("error")) ? intent.getStringExtra("error") : null;
            ConsumerAppToAppViewModel consumerAppToAppViewModel = this.appToAppViewModel;
            if (consumerAppToAppViewModel != null) {
                b0<AppToAppResult> observeOn = consumerAppToAppViewModel.handleActivityResultStatus(i3, stringExtra, stringExtra2).observeOn(h.c.j0.c.a.b());
                kotlin.jvm.internal.m.f(observeOn, "appToAppViewModel.handleActivityResultStatus(resultCode, code, error)\n                    .observeOn(AndroidSchedulers.mainThread())");
                Object as = Single_AnalyticsKt.logError$default(observeOn, "Couldn't check activity result status", null, 2, null).as(com.uber.autodispose.d.a(getOnDestroyScopeProvider()));
                kotlin.jvm.internal.m.f(as, "appToAppViewModel.handleActivityResultStatus(resultCode, code, error)\n                    .observeOn(AndroidSchedulers.mainThread())\n                    .logError(\"Couldn't check activity result status\")\n                    .`as`(AutoDispose.autoDisposable(onDestroyScopeProvider))");
                SingleSubscribeProxy_CommonKt.subscribeBy$default((a0) as, null, new ConsumerOnboardingFragment$onActivityResult$1(this), 1, null);
                return;
            }
            kotlin.jvm.internal.m.w("appToAppViewModel");
            throw null;
        }
        getOnboardingViewModel().onActivityResult(i2, i3);
    }

    @Override // com.coinbase.wallet.commonui.views.BackableFragment
    public boolean onBackPressed() {
        getOnboardingViewModel().onBackPressed();
        return true;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        kotlin.jvm.internal.m.g(inflater, "inflater");
        return inflater.inflate(R.layout.fragment_consumer_onboarding, viewGroup, false);
    }

    @Override // com.coinbase.wallet.commonui.views.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        kotlin.jvm.internal.m.g(view, "view");
        super.onViewCreated(view, bundle);
        androidx.lifecycle.b0 a = new androidx.lifecycle.d0(this, getAppToAppViewModelFactory$consumer_productionRelease()).a(ConsumerAppToAppViewModel.class);
        kotlin.jvm.internal.m.f(a, "ViewModelProvider(this, viewModelFactory).get(T::class.java)");
        this.appToAppViewModel = (ConsumerAppToAppViewModel) a;
        switchToLoadingView();
        initView();
        View view2 = getView();
        View privacyCloseButton = view2 == null ? null : view2.findViewById(R.id.privacyCloseButton);
        kotlin.jvm.internal.m.f(privacyCloseButton, "privacyCloseButton");
        View_CommonKt.setOnSingleClickListener$default(privacyCloseButton, 0L, new ConsumerOnboardingFragment$onViewCreated$1(this), 1, null);
        View view3 = getView();
        View privacyCloseButton2 = view3 == null ? null : view3.findViewById(R.id.privacyCloseButton);
        kotlin.jvm.internal.m.f(privacyCloseButton2, "privacyCloseButton");
        View_CommonKt.setOnSingleClickListener$default(privacyCloseButton2, 0L, new ConsumerOnboardingFragment$onViewCreated$2(this), 1, null);
        View view4 = getView();
        View secondaryButton = view4 == null ? null : view4.findViewById(R.id.secondaryButton);
        kotlin.jvm.internal.m.f(secondaryButton, "secondaryButton");
        View_CommonKt.setOnSingleClickListener$default(secondaryButton, 0L, new ConsumerOnboardingFragment$onViewCreated$3(this), 1, null);
        View view5 = getView();
        View loginButton = view5 != null ? view5.findViewById(R.id.loginButton) : null;
        kotlin.jvm.internal.m.f(loginButton, "loginButton");
        View_CommonKt.setOnSingleClickListener$default(loginButton, 0L, new ConsumerOnboardingFragment$onViewCreated$4(this), 1, null);
        Object as = getOnboardingViewModel().getStateObservable().as(com.uber.autodispose.d.a(getScopeProvider()));
        kotlin.jvm.internal.m.f(as, "onboardingViewModel.stateObservable\n            .`as`(AutoDispose.autoDisposable(scopeProvider))");
        ObservableSubscribeProxy_CommonKt.subscribeBy$default((com.uber.autodispose.x) as, null, null, new ConsumerOnboardingFragment$onViewCreated$5(this), 3, null);
        Object as2 = getOnboardingViewModel().getEventsObservable().as(com.uber.autodispose.d.a(getScopeProvider()));
        kotlin.jvm.internal.m.f(as2, "onboardingViewModel.eventsObservable\n            .`as`(AutoDispose.autoDisposable(scopeProvider))");
        ObservableSubscribeProxy_CommonKt.subscribeBy$default((com.uber.autodispose.x) as2, null, null, new ConsumerOnboardingFragment$onViewCreated$6(this), 3, null);
        Object as3 = getOnboardingViewModel().getDismissObservable().as(com.uber.autodispose.d.a(getScopeProvider()));
        kotlin.jvm.internal.m.f(as3, "onboardingViewModel.dismissObservable\n            .`as`(AutoDispose.autoDisposable(scopeProvider))");
        ObservableSubscribeProxy_CommonKt.subscribeBy$default((com.uber.autodispose.x) as3, null, null, new ConsumerOnboardingFragment$onViewCreated$7(this), 3, null);
        Object as4 = getOnboardingViewModel().getNavigationObservable().as(com.uber.autodispose.d.a(getScopeProvider()));
        kotlin.jvm.internal.m.f(as4, "onboardingViewModel.navigationObservable\n            .`as`(AutoDispose.autoDisposable(scopeProvider))");
        ObservableSubscribeProxy_CommonKt.subscribeBy$default((com.uber.autodispose.x) as4, null, null, new ConsumerOnboardingFragment$onViewCreated$8(this), 3, null);
        getOnboardingViewModel().setup();
    }

    public final void setAppToAppViewModelFactory$consumer_productionRelease(GenericViewModelFactory<ConsumerAppToAppViewModel> genericViewModelFactory) {
        kotlin.jvm.internal.m.g(genericViewModelFactory, "<set-?>");
        this.appToAppViewModelFactory = genericViewModelFactory;
    }

    public final void setCoinbaseApi$consumer_productionRelease(Coinbase coinbase) {
        kotlin.jvm.internal.m.g(coinbase, "<set-?>");
        this.coinbaseApi = coinbase;
    }

    public final void setConsumerUserRepository$consumer_productionRelease(ConsumerUserRepository consumerUserRepository) {
        kotlin.jvm.internal.m.g(consumerUserRepository, "<set-?>");
        this.consumerUserRepository = consumerUserRepository;
    }

    public final void setConsumerWebviewConfig$consumer_productionRelease(ConsumerWebViewConfig consumerWebViewConfig) {
        kotlin.jvm.internal.m.g(consumerWebViewConfig, "<set-?>");
        this.consumerWebviewConfig = consumerWebViewConfig;
    }

    public final void setOnboardingViewModelFactory$consumer_productionRelease(ConsumerOnboardingViewModel.Factory factory) {
        kotlin.jvm.internal.m.g(factory, "<set-?>");
        this.onboardingViewModelFactory = factory;
    }
}