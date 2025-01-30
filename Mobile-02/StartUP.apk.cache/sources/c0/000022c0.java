package com.coinbase.wallet.features.swap.views;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.z;
import c.h.k.d0;
import com.coinbase.wallet.analytics.Analytics;
import com.coinbase.wallet.analytics.models.AnalyticsEvent;
import com.coinbase.wallet.application.extensions.AnalyticsEvent_ApplicationKt;
import com.coinbase.wallet.common.extensions.ObservableSubscribeProxy_CommonKt;
import com.coinbase.wallet.common.extensions.SingleSubscribeProxy_CommonKt;
import com.coinbase.wallet.common.utilities.LocalizedStrings;
import com.coinbase.wallet.commonui.extensions.Fragment_CommonKt;
import com.coinbase.wallet.commonui.views.BaseFragment;
import com.coinbase.wallet.commonui.views.StyledFragment;
import com.coinbase.wallet.features.swap.viewmodels.SwapCompleteViewModel;
import com.uber.autodispose.a0;
import com.uber.autodispose.d;
import com.uber.autodispose.x;
import com.uber.autodispose.y;
import h.c.b0;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.h;
import kotlin.jvm.internal.e0;
import kotlin.jvm.internal.m;
import org.toshi.R;

/* compiled from: SwapCompleteFragment.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b'\u0010\u0011J-\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000bJ!\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\rH\u0016¢\u0006\u0004\b\u0010\u0010\u0011R\"\u0010\u0013\u001a\u00020\u00128\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001c\u001a\u00020\u00198B@\u0002X\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001bR\u0016\u0010 \u001a\u00020\u001d8V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001fR\u001d\u0010&\u001a\u00020!8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%¨\u0006("}, d2 = {"Lcom/coinbase/wallet/features/swap/views/SwapCompleteFragment;", "Lcom/coinbase/wallet/commonui/views/BaseFragment;", "Lcom/coinbase/wallet/commonui/views/StyledFragment;", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "Lkotlin/x;", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "onResume", "()V", "Lcom/coinbase/wallet/features/swap/viewmodels/SwapCompleteViewModel$Factory;", "viewModelFactory", "Lcom/coinbase/wallet/features/swap/viewmodels/SwapCompleteViewModel$Factory;", "getViewModelFactory", "()Lcom/coinbase/wallet/features/swap/viewmodels/SwapCompleteViewModel$Factory;", "setViewModelFactory", "(Lcom/coinbase/wallet/features/swap/viewmodels/SwapCompleteViewModel$Factory;)V", "Lcom/uber/autodispose/y;", "getScopeProvider", "()Lcom/uber/autodispose/y;", "scopeProvider", "Lcom/coinbase/wallet/commonui/views/StyledFragment$Attributes;", "getAttributes", "()Lcom/coinbase/wallet/commonui/views/StyledFragment$Attributes;", "attributes", "Lcom/coinbase/wallet/features/swap/viewmodels/SwapCompleteViewModel;", "viewModel$delegate", "Lkotlin/h;", "getViewModel", "()Lcom/coinbase/wallet/features/swap/viewmodels/SwapCompleteViewModel;", "viewModel", "<init>", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class SwapCompleteFragment extends BaseFragment implements StyledFragment {
    private final h viewModel$delegate = z.a(this, e0.b(SwapCompleteViewModel.class), new SwapCompleteFragment$special$$inlined$viewModel$3(new SwapCompleteFragment$special$$inlined$viewModel$2(this)), new SwapCompleteFragment$special$$inlined$viewModel$1(this, this));
    public SwapCompleteViewModel.Factory viewModelFactory;

    private final y getScopeProvider() {
        return Fragment_CommonKt.getFragmentLifecycleScopeProvider$default(this, null, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final SwapCompleteViewModel getViewModel() {
        return (SwapCompleteViewModel) this.viewModel$delegate.getValue();
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
        return StyledFragment.Attributes.copy$default(StyledFragment.DefaultImpls.getAttributes(this), true, false, false, 4, null);
    }

    public final SwapCompleteViewModel.Factory getViewModelFactory() {
        SwapCompleteViewModel.Factory factory = this.viewModelFactory;
        if (factory != null) {
            return factory;
        }
        m.w("viewModelFactory");
        throw null;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        m.g(inflater, "inflater");
        return inflater.inflate(R.layout.fragment_complete, viewGroup, false);
    }

    @Override // com.coinbase.wallet.commonui.views.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        Object as = getViewModel().getNavigationObservable().as(d.a(getScopeProvider()));
        m.f(as, "viewModel.navigationObservable\n            .`as`(autoDisposable(scopeProvider))");
        ObservableSubscribeProxy_CommonKt.subscribeBy$default((x) as, null, null, new SwapCompleteFragment$onResume$1(this), 3, null);
        Object as2 = b0.just(kotlin.x.a).delay(2000L, TimeUnit.MILLISECONDS, h.c.j0.c.a.b()).as(d.a(getScopeProvider()));
        m.f(as2, "just(Unit)\n            .delay(2000, TimeUnit.MILLISECONDS, AndroidSchedulers.mainThread())\n            .`as`(autoDisposable(scopeProvider))");
        SingleSubscribeProxy_CommonKt.subscribeBy$default((a0) as2, null, new SwapCompleteFragment$onResume$2(this), 1, null);
    }

    @Override // com.coinbase.wallet.commonui.views.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        m.g(view, "view");
        super.onViewCreated(view, bundle);
        Analytics.INSTANCE.log(AnalyticsEvent_ApplicationKt.getSwapSuccessLanded(AnalyticsEvent.Companion));
        View view2 = getView();
        ((TextView) (view2 == null ? null : view2.findViewById(e.j.a.messageLabel))).setText(LocalizedStrings.INSTANCE.get(R.string.swap_complete_message));
    }

    public final void setViewModelFactory(SwapCompleteViewModel.Factory factory) {
        m.g(factory, "<set-?>");
        this.viewModelFactory = factory;
    }
}