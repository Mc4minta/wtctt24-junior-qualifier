package com.coinbase.wallet.consumer.views;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.b0;
import c.h.k.d0;
import com.appsflyer.internal.referrer.Payload;
import com.coinbase.wallet.analytics.Analytics;
import com.coinbase.wallet.analytics.models.AnalyticsEvent;
import com.coinbase.wallet.common.extensions.ObservableSubscribeProxy_CommonKt;
import com.coinbase.wallet.common.extensions.SingleSubscribeProxy_CommonKt;
import com.coinbase.wallet.commonui.di.GenericViewModelFactory;
import com.coinbase.wallet.commonui.extensions.Fragment_CommonKt;
import com.coinbase.wallet.commonui.extensions.View_CommonKt;
import com.coinbase.wallet.commonui.utilities.FragmentLifecycleScopeProvider;
import com.coinbase.wallet.commonui.views.LockedFragment;
import com.coinbase.wallet.commonui.views.StyledFragment;
import com.coinbase.wallet.consumer.R;
import com.coinbase.wallet.consumer.extensions.AnalyticsEvent_ConsumerKt;
import com.coinbase.wallet.consumer.models.ConsumerWebViewConfig;
import com.coinbase.wallet.consumer.viewmodels.ConsumerAddCardViewModel;
import com.coinbase.wallet.store.interfaces.StoreInterface;
import com.uber.autodispose.a0;
import kotlin.Metadata;

/* compiled from: ConsumerAddCardFragment.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0007¢\u0006\u0004\b8\u0010\u0012J-\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0004\b\u000b\u0010\fJ!\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0014\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0016\u0010\u0017R\u0016\u0010\u0019\u001a\u00020\u00188\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR(\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00180\u001b8\u0000@\u0000X\u0081.¢\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\"\u0010#\u001a\u00020\"8\u0000@\u0000X\u0081.¢\u0006\u0012\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u0016\u0010,\u001a\u00020)8V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\b*\u0010+R\u0016\u00100\u001a\u00020-8B@\u0002X\u0082\u0004¢\u0006\u0006\u001a\u0004\b.\u0010/R\"\u00102\u001a\u0002018\u0000@\u0000X\u0081.¢\u0006\u0012\n\u0004\b2\u00103\u001a\u0004\b4\u00105\"\u0004\b6\u00107¨\u00069"}, d2 = {"Lcom/coinbase/wallet/consumer/views/ConsumerAddCardFragment;", "Lcom/coinbase/wallet/commonui/views/LockedFragment;", "Lcom/coinbase/wallet/commonui/views/StyledFragment;", "Lcom/coinbase/wallet/consumer/views/ConsumerWebViewNavigationDelegate;", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "Lkotlin/x;", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "pageLoaded", "()V", "", "url", "", "urlNavigated", "(Ljava/lang/String;)Z", "Lcom/coinbase/wallet/consumer/viewmodels/ConsumerAddCardViewModel;", "viewModel", "Lcom/coinbase/wallet/consumer/viewmodels/ConsumerAddCardViewModel;", "Lcom/coinbase/wallet/commonui/di/GenericViewModelFactory;", "viewModelFactory", "Lcom/coinbase/wallet/commonui/di/GenericViewModelFactory;", "getViewModelFactory$consumer_productionRelease", "()Lcom/coinbase/wallet/commonui/di/GenericViewModelFactory;", "setViewModelFactory$consumer_productionRelease", "(Lcom/coinbase/wallet/commonui/di/GenericViewModelFactory;)V", "Lcom/coinbase/wallet/store/interfaces/StoreInterface;", Payload.TYPE_STORE, "Lcom/coinbase/wallet/store/interfaces/StoreInterface;", "getStore$consumer_productionRelease", "()Lcom/coinbase/wallet/store/interfaces/StoreInterface;", "setStore$consumer_productionRelease", "(Lcom/coinbase/wallet/store/interfaces/StoreInterface;)V", "Lcom/coinbase/wallet/commonui/views/StyledFragment$Attributes;", "getAttributes", "()Lcom/coinbase/wallet/commonui/views/StyledFragment$Attributes;", "attributes", "Lcom/coinbase/wallet/commonui/utilities/FragmentLifecycleScopeProvider;", "getScopeProvider", "()Lcom/coinbase/wallet/commonui/utilities/FragmentLifecycleScopeProvider;", "scopeProvider", "Lcom/coinbase/wallet/consumer/models/ConsumerWebViewConfig;", "consumerWebViewConfig", "Lcom/coinbase/wallet/consumer/models/ConsumerWebViewConfig;", "getConsumerWebViewConfig$consumer_productionRelease", "()Lcom/coinbase/wallet/consumer/models/ConsumerWebViewConfig;", "setConsumerWebViewConfig$consumer_productionRelease", "(Lcom/coinbase/wallet/consumer/models/ConsumerWebViewConfig;)V", "<init>", "consumer_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class ConsumerAddCardFragment extends LockedFragment implements StyledFragment, ConsumerWebViewNavigationDelegate {
    public ConsumerWebViewConfig consumerWebViewConfig;
    public StoreInterface store;
    private ConsumerAddCardViewModel viewModel;
    public GenericViewModelFactory<ConsumerAddCardViewModel> viewModelFactory;

    private final FragmentLifecycleScopeProvider getScopeProvider() {
        return Fragment_CommonKt.getFragmentLifecycleScopeProvider$default(this, null, 1, null);
    }

    @Override // com.coinbase.wallet.commonui.views.LockedFragment, com.coinbase.wallet.commonui.views.BaseFragment
    public void _$_clearFindViewByIdCache() {
    }

    @Override // com.coinbase.wallet.commonui.views.StyledFragment
    public d0 applyWindowInsets(View view, d0 d0Var) {
        return StyledFragment.DefaultImpls.applyWindowInsets(this, view, d0Var);
    }

    @Override // com.coinbase.wallet.commonui.views.StyledFragment
    public StyledFragment.Attributes getAttributes() {
        return StyledFragment.Attributes.copy$default(StyledFragment.DefaultImpls.getAttributes(this), true, false, false, 4, null);
    }

    public final ConsumerWebViewConfig getConsumerWebViewConfig$consumer_productionRelease() {
        ConsumerWebViewConfig consumerWebViewConfig = this.consumerWebViewConfig;
        if (consumerWebViewConfig != null) {
            return consumerWebViewConfig;
        }
        kotlin.jvm.internal.m.w("consumerWebViewConfig");
        throw null;
    }

    public final StoreInterface getStore$consumer_productionRelease() {
        StoreInterface storeInterface = this.store;
        if (storeInterface != null) {
            return storeInterface;
        }
        kotlin.jvm.internal.m.w(Payload.TYPE_STORE);
        throw null;
    }

    public final GenericViewModelFactory<ConsumerAddCardViewModel> getViewModelFactory$consumer_productionRelease() {
        GenericViewModelFactory<ConsumerAddCardViewModel> genericViewModelFactory = this.viewModelFactory;
        if (genericViewModelFactory != null) {
            return genericViewModelFactory;
        }
        kotlin.jvm.internal.m.w("viewModelFactory");
        throw null;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        kotlin.jvm.internal.m.g(inflater, "inflater");
        return inflater.inflate(R.layout.fragment_consumer_add_card, viewGroup, false);
    }

    @Override // com.coinbase.wallet.commonui.views.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        kotlin.jvm.internal.m.g(view, "view");
        super.onViewCreated(view, bundle);
        Analytics.INSTANCE.log(AnalyticsEvent_ConsumerKt.consumerAddCardViewed(AnalyticsEvent.Companion));
        b0 a = new androidx.lifecycle.d0(this, getViewModelFactory$consumer_productionRelease()).a(ConsumerAddCardViewModel.class);
        kotlin.jvm.internal.m.f(a, "ViewModelProvider(this, viewModelFactory).get(T::class.java)");
        ConsumerAddCardViewModel consumerAddCardViewModel = (ConsumerAddCardViewModel) a;
        Bundle requireArguments = requireArguments();
        kotlin.jvm.internal.m.f(requireArguments, "requireArguments()");
        consumerAddCardViewModel.setArgs(requireArguments);
        kotlin.x xVar = kotlin.x.a;
        this.viewModel = consumerAddCardViewModel;
        View view2 = getView();
        ConsumerAuthenticatedWebView consumerAuthenticatedWebView = (ConsumerAuthenticatedWebView) (view2 == null ? null : view2.findViewById(R.id.webView));
        consumerAuthenticatedWebView.getSettings().setAllowFileAccess(false);
        consumerAuthenticatedWebView.setConsumerWebViewClient(new ConsumerAuthenticateWebViewClient(this, getConsumerWebViewConfig$consumer_productionRelease()));
        consumerAuthenticatedWebView.setWebViewClient(consumerAuthenticatedWebView.getConsumerWebViewClient());
        View view3 = getView();
        ((ConsumerAuthenticatedWebView) (view3 == null ? null : view3.findViewById(R.id.webView))).setStore(getStore$consumer_productionRelease());
        View view4 = getView();
        View closeButton = view4 == null ? null : view4.findViewById(R.id.closeButton);
        kotlin.jvm.internal.m.f(closeButton, "closeButton");
        View_CommonKt.setOnSingleClickListener$default(closeButton, 0L, new ConsumerAddCardFragment$onViewCreated$3(this), 1, null);
        ConsumerAddCardViewModel consumerAddCardViewModel2 = this.viewModel;
        if (consumerAddCardViewModel2 != null) {
            Object as = consumerAddCardViewModel2.getNavigationObservable().observeOn(h.c.j0.c.a.b()).as(com.uber.autodispose.d.a(getScopeProvider()));
            kotlin.jvm.internal.m.f(as, "viewModel.navigationObservable\n            .observeOn(AndroidSchedulers.mainThread())\n            .`as`(autoDisposable(scopeProvider))");
            ObservableSubscribeProxy_CommonKt.subscribeBy$default((com.uber.autodispose.x) as, null, null, new ConsumerAddCardFragment$onViewCreated$4(this), 3, null);
            ConsumerAddCardViewModel consumerAddCardViewModel3 = this.viewModel;
            if (consumerAddCardViewModel3 != null) {
                Object as2 = consumerAddCardViewModel3.getDismissObservable().observeOn(h.c.j0.c.a.b()).as(com.uber.autodispose.d.a(getScopeProvider()));
                kotlin.jvm.internal.m.f(as2, "viewModel.dismissObservable\n            .observeOn(AndroidSchedulers.mainThread())\n            .`as`(autoDisposable(scopeProvider))");
                ObservableSubscribeProxy_CommonKt.subscribeBy$default((com.uber.autodispose.x) as2, null, null, new ConsumerAddCardFragment$onViewCreated$5(this), 3, null);
                ConsumerAddCardViewModel consumerAddCardViewModel4 = this.viewModel;
                if (consumerAddCardViewModel4 != null) {
                    Object as3 = consumerAddCardViewModel4.getStateObservable().as(com.uber.autodispose.d.a(getScopeProvider()));
                    kotlin.jvm.internal.m.f(as3, "viewModel.stateObservable\n            .`as`(autoDisposable(scopeProvider))");
                    ObservableSubscribeProxy_CommonKt.subscribeBy$default((com.uber.autodispose.x) as3, null, null, new ConsumerAddCardFragment$onViewCreated$6(this), 3, null);
                    ConsumerAddCardViewModel consumerAddCardViewModel5 = this.viewModel;
                    if (consumerAddCardViewModel5 != null) {
                        Object as4 = consumerAddCardViewModel5.getEventObservable().as(com.uber.autodispose.d.a(getScopeProvider()));
                        kotlin.jvm.internal.m.f(as4, "viewModel.eventObservable\n            .`as`(autoDisposable(scopeProvider))");
                        ObservableSubscribeProxy_CommonKt.subscribeBy$default((com.uber.autodispose.x) as4, null, null, new ConsumerAddCardFragment$onViewCreated$7(this), 3, null);
                        ConsumerAddCardViewModel consumerAddCardViewModel6 = this.viewModel;
                        if (consumerAddCardViewModel6 != null) {
                            consumerAddCardViewModel6.setup();
                            return;
                        } else {
                            kotlin.jvm.internal.m.w("viewModel");
                            throw null;
                        }
                    }
                    kotlin.jvm.internal.m.w("viewModel");
                    throw null;
                }
                kotlin.jvm.internal.m.w("viewModel");
                throw null;
            }
            kotlin.jvm.internal.m.w("viewModel");
            throw null;
        }
        kotlin.jvm.internal.m.w("viewModel");
        throw null;
    }

    @Override // com.coinbase.wallet.consumer.views.ConsumerWebViewNavigationDelegate
    public void pageLoaded() {
        Analytics.INSTANCE.log(AnalyticsEvent_ConsumerKt.consumerAddCardLoaded(AnalyticsEvent.Companion));
        ConsumerAddCardViewModel consumerAddCardViewModel = this.viewModel;
        if (consumerAddCardViewModel != null) {
            consumerAddCardViewModel.onWebViewLoaded();
        } else {
            kotlin.jvm.internal.m.w("viewModel");
            throw null;
        }
    }

    public final void setConsumerWebViewConfig$consumer_productionRelease(ConsumerWebViewConfig consumerWebViewConfig) {
        kotlin.jvm.internal.m.g(consumerWebViewConfig, "<set-?>");
        this.consumerWebViewConfig = consumerWebViewConfig;
    }

    public final void setStore$consumer_productionRelease(StoreInterface storeInterface) {
        kotlin.jvm.internal.m.g(storeInterface, "<set-?>");
        this.store = storeInterface;
    }

    public final void setViewModelFactory$consumer_productionRelease(GenericViewModelFactory<ConsumerAddCardViewModel> genericViewModelFactory) {
        kotlin.jvm.internal.m.g(genericViewModelFactory, "<set-?>");
        this.viewModelFactory = genericViewModelFactory;
    }

    @Override // com.coinbase.wallet.consumer.views.ConsumerWebViewNavigationDelegate
    public boolean urlNavigated(String url) {
        kotlin.jvm.internal.m.g(url, "url");
        ConsumerAddCardViewModel consumerAddCardViewModel = this.viewModel;
        if (consumerAddCardViewModel == null) {
            kotlin.jvm.internal.m.w("viewModel");
            throw null;
        } else if (consumerAddCardViewModel.shouldRedirectToApp(url)) {
            ConsumerAddCardViewModel consumerAddCardViewModel2 = this.viewModel;
            if (consumerAddCardViewModel2 != null) {
                Object as = consumerAddCardViewModel2.redirectToApp(url).as(com.uber.autodispose.d.a(getScopeProvider()));
                kotlin.jvm.internal.m.f(as, "viewModel.redirectToApp(url)\n                .`as`(autoDisposable(scopeProvider))");
                SingleSubscribeProxy_CommonKt.subscribeBy$default((a0) as, null, ConsumerAddCardFragment$urlNavigated$1.INSTANCE, 1, null);
                return true;
            }
            kotlin.jvm.internal.m.w("viewModel");
            throw null;
        } else {
            return false;
        }
    }
}