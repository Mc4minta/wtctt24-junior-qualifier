package com.coinbase.wallet.consumer.views;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import androidx.fragment.app.z;
import c.h.k.d0;
import com.coinbase.wallet.common.annotations.ScreenshotProtection;
import com.coinbase.wallet.common.extensions.ObservableSubscribeProxy_CommonKt;
import com.coinbase.wallet.commonui.extensions.Fragment_CommonKt;
import com.coinbase.wallet.commonui.extensions.View_CommonKt;
import com.coinbase.wallet.commonui.utilities.FragmentLifecycleScopeProvider;
import com.coinbase.wallet.commonui.views.BackableFragment;
import com.coinbase.wallet.commonui.views.BaseFragment;
import com.coinbase.wallet.commonui.views.StyledFragment;
import com.coinbase.wallet.consumer.R;
import com.coinbase.wallet.consumer.models.ConsumerWebViewConfig;
import com.coinbase.wallet.consumer.viewmodels.ConsumerSecure3DVerificationViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.e0;

/* compiled from: ConsumerSecure3DVerificationFragment.kt */
@ScreenshotProtection(behavior = ScreenshotProtection.Behavior.BLOCK)
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004B\u0007¢\u0006\u0004\b9\u0010\u0016J-\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0004\b\f\u0010\rJ!\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0017¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0013\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0015\u0010\u0016J!\u0010\u001a\u001a\u00020\u00122\u0006\u0010\u0018\u001a\u00020\u00172\b\u0010\u0019\u001a\u0004\u0018\u00010\u0017H\u0016¢\u0006\u0004\b\u001a\u0010\u001bR\u001d\u0010!\u001a\u00020\u001c8V@\u0016X\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u001d\u0010&\u001a\u00020\"8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b#\u0010\u001e\u001a\u0004\b$\u0010%R\"\u0010(\u001a\u00020'8\u0000@\u0000X\u0081.¢\u0006\u0012\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\"\u0010/\u001a\u00020.8\u0000@\u0000X\u0081.¢\u0006\u0012\n\u0004\b/\u00100\u001a\u0004\b1\u00102\"\u0004\b3\u00104R\u0016\u00108\u001a\u0002058B@\u0002X\u0082\u0004¢\u0006\u0006\u001a\u0004\b6\u00107¨\u0006:"}, d2 = {"Lcom/coinbase/wallet/consumer/views/ConsumerSecure3DVerificationFragment;", "Lcom/coinbase/wallet/commonui/views/BaseFragment;", "Lcom/coinbase/wallet/commonui/views/StyledFragment;", "Lcom/coinbase/wallet/commonui/views/BackableFragment;", "Lcom/coinbase/wallet/consumer/views/ConsumerSecure3DWebViewNavigationDelegate;", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "Lkotlin/x;", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "", "onBackPressed", "()Z", "pageLoaded", "()V", "", "url", "paRes", "urlNavigated", "(Ljava/lang/String;Ljava/lang/String;)Z", "Lcom/coinbase/wallet/commonui/views/StyledFragment$Attributes;", "attributes$delegate", "Lkotlin/h;", "getAttributes", "()Lcom/coinbase/wallet/commonui/views/StyledFragment$Attributes;", "attributes", "Lcom/coinbase/wallet/consumer/viewmodels/ConsumerSecure3DVerificationViewModel;", "viewModel$delegate", "getViewModel", "()Lcom/coinbase/wallet/consumer/viewmodels/ConsumerSecure3DVerificationViewModel;", "viewModel", "Lcom/coinbase/wallet/consumer/viewmodels/ConsumerSecure3DVerificationViewModel$Factory;", "viewModelFactory", "Lcom/coinbase/wallet/consumer/viewmodels/ConsumerSecure3DVerificationViewModel$Factory;", "getViewModelFactory$consumer_productionRelease", "()Lcom/coinbase/wallet/consumer/viewmodels/ConsumerSecure3DVerificationViewModel$Factory;", "setViewModelFactory$consumer_productionRelease", "(Lcom/coinbase/wallet/consumer/viewmodels/ConsumerSecure3DVerificationViewModel$Factory;)V", "Lcom/coinbase/wallet/consumer/models/ConsumerWebViewConfig;", "webviewConfig", "Lcom/coinbase/wallet/consumer/models/ConsumerWebViewConfig;", "getWebviewConfig$consumer_productionRelease", "()Lcom/coinbase/wallet/consumer/models/ConsumerWebViewConfig;", "setWebviewConfig$consumer_productionRelease", "(Lcom/coinbase/wallet/consumer/models/ConsumerWebViewConfig;)V", "Lcom/coinbase/wallet/commonui/utilities/FragmentLifecycleScopeProvider;", "getScopeProvider", "()Lcom/coinbase/wallet/commonui/utilities/FragmentLifecycleScopeProvider;", "scopeProvider", "<init>", "consumer_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class ConsumerSecure3DVerificationFragment extends BaseFragment implements StyledFragment, BackableFragment, ConsumerSecure3DWebViewNavigationDelegate {
    private final kotlin.h attributes$delegate;
    private final kotlin.h viewModel$delegate = z.a(this, e0.b(ConsumerSecure3DVerificationViewModel.class), new ConsumerSecure3DVerificationFragment$special$$inlined$viewModel$3(new ConsumerSecure3DVerificationFragment$special$$inlined$viewModel$2(this)), new ConsumerSecure3DVerificationFragment$special$$inlined$viewModel$1(this, this));
    public ConsumerSecure3DVerificationViewModel.Factory viewModelFactory;
    public ConsumerWebViewConfig webviewConfig;

    public ConsumerSecure3DVerificationFragment() {
        kotlin.h b2;
        b2 = kotlin.k.b(new ConsumerSecure3DVerificationFragment$attributes$2(this));
        this.attributes$delegate = b2;
    }

    private final FragmentLifecycleScopeProvider getScopeProvider() {
        return Fragment_CommonKt.getFragmentLifecycleScopeProvider$default(this, null, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ConsumerSecure3DVerificationViewModel getViewModel() {
        return (ConsumerSecure3DVerificationViewModel) this.viewModel$delegate.getValue();
    }

    @Override // com.coinbase.wallet.commonui.views.BaseFragment
    public void _$_clearFindViewByIdCache() {
    }

    @Override // com.coinbase.wallet.commonui.views.StyledFragment
    public d0 applyWindowInsets(View view, d0 d0Var) {
        return StyledFragment.DefaultImpls.applyWindowInsets(this, view, d0Var);
    }

    @Override // com.coinbase.wallet.commonui.views.StyledFragment
    public StyledFragment.Attributes getAttributes() {
        return (StyledFragment.Attributes) this.attributes$delegate.getValue();
    }

    public final ConsumerSecure3DVerificationViewModel.Factory getViewModelFactory$consumer_productionRelease() {
        ConsumerSecure3DVerificationViewModel.Factory factory = this.viewModelFactory;
        if (factory != null) {
            return factory;
        }
        kotlin.jvm.internal.m.w("viewModelFactory");
        throw null;
    }

    public final ConsumerWebViewConfig getWebviewConfig$consumer_productionRelease() {
        ConsumerWebViewConfig consumerWebViewConfig = this.webviewConfig;
        if (consumerWebViewConfig != null) {
            return consumerWebViewConfig;
        }
        kotlin.jvm.internal.m.w("webviewConfig");
        throw null;
    }

    @Override // com.coinbase.wallet.commonui.views.BackableFragment
    public boolean onBackPressed() {
        getViewModel().onBackPressed();
        return true;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        kotlin.jvm.internal.m.g(inflater, "inflater");
        return inflater.inflate(R.layout.fragment_consumer_secure_3d_verification, viewGroup, false);
    }

    @Override // com.coinbase.wallet.commonui.views.BaseFragment, androidx.fragment.app.Fragment
    @SuppressLint({"SetJavaScriptEnabled"})
    public void onViewCreated(View view, Bundle bundle) {
        kotlin.jvm.internal.m.g(view, "view");
        super.onViewCreated(view, bundle);
        View view2 = getView();
        View closeButton = view2 == null ? null : view2.findViewById(R.id.closeButton);
        kotlin.jvm.internal.m.f(closeButton, "closeButton");
        View_CommonKt.setOnSingleClickListener$default(closeButton, 0L, new ConsumerSecure3DVerificationFragment$onViewCreated$1(this), 1, null);
        View view3 = getView();
        WebView webView = (WebView) (view3 != null ? view3.findViewById(R.id.webView) : null);
        WebSettings settings = webView.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setBuiltInZoomControls(true);
        settings.setAllowFileAccess(false);
        settings.setAllowContentAccess(false);
        webView.setWebViewClient(new Secure3DWebViewClient(this));
        Object as = getViewModel().getStateObservable().as(com.uber.autodispose.d.a(getScopeProvider()));
        kotlin.jvm.internal.m.f(as, "viewModel.stateObservable\n            .`as`(autoDisposable(scopeProvider))");
        ObservableSubscribeProxy_CommonKt.subscribeBy$default((com.uber.autodispose.x) as, null, null, new ConsumerSecure3DVerificationFragment$onViewCreated$3(this), 3, null);
        Object as2 = getViewModel().getEventObservable().as(com.uber.autodispose.d.a(getScopeProvider()));
        kotlin.jvm.internal.m.f(as2, "viewModel.eventObservable\n            .`as`(autoDisposable(scopeProvider))");
        ObservableSubscribeProxy_CommonKt.subscribeBy$default((com.uber.autodispose.x) as2, null, null, new ConsumerSecure3DVerificationFragment$onViewCreated$4(this), 3, null);
        Object as3 = getViewModel().getDismissObservable().as(com.uber.autodispose.d.a(getScopeProvider()));
        kotlin.jvm.internal.m.f(as3, "viewModel.dismissObservable\n            .`as`(autoDisposable(scopeProvider))");
        ObservableSubscribeProxy_CommonKt.subscribeBy$default((com.uber.autodispose.x) as3, null, null, new ConsumerSecure3DVerificationFragment$onViewCreated$5(this), 3, null);
        getViewModel().setup();
    }

    @Override // com.coinbase.wallet.consumer.views.ConsumerSecure3DWebViewNavigationDelegate
    public void pageLoaded() {
        getViewModel().onUrlLoaded();
    }

    public final void setViewModelFactory$consumer_productionRelease(ConsumerSecure3DVerificationViewModel.Factory factory) {
        kotlin.jvm.internal.m.g(factory, "<set-?>");
        this.viewModelFactory = factory;
    }

    public final void setWebviewConfig$consumer_productionRelease(ConsumerWebViewConfig consumerWebViewConfig) {
        kotlin.jvm.internal.m.g(consumerWebViewConfig, "<set-?>");
        this.webviewConfig = consumerWebViewConfig;
    }

    @Override // com.coinbase.wallet.consumer.views.ConsumerSecure3DWebViewNavigationDelegate
    public boolean urlNavigated(String url, String str) {
        kotlin.jvm.internal.m.g(url, "url");
        return getViewModel().redirectToApp(url, str);
    }
}