package com.coinbase.wallet.features.swap.views;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.z;
import c.h.k.d0;
import com.coinbase.wallet.analytics.Analytics;
import com.coinbase.wallet.analytics.models.AnalyticsEvent;
import com.coinbase.wallet.application.extensions.AnalyticsEvent_ApplicationKt;
import com.coinbase.wallet.commonui.extensions.Fragment_CommonKt;
import com.coinbase.wallet.commonui.extensions.View_CommonKt;
import com.coinbase.wallet.commonui.views.BaseFragment;
import com.coinbase.wallet.commonui.views.StyledFragment;
import com.coinbase.wallet.features.swap.viewmodels.SwapDisclaimerViewModel;
import com.uber.autodispose.y;
import kotlin.Metadata;
import kotlin.h;
import kotlin.jvm.internal.e0;
import kotlin.jvm.internal.m;
import org.toshi.R;

/* compiled from: SwapDisclaimerFragment.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b%\u0010&J-\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000bJ!\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0004\b\u000e\u0010\u000fR\"\u0010\u0011\u001a\u00020\u00108\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001d\u0010\u001c\u001a\u00020\u00178B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u0016\u0010 \u001a\u00020\u001d8V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001fR\u0016\u0010$\u001a\u00020!8B@\u0002X\u0082\u0004¢\u0006\u0006\u001a\u0004\b\"\u0010#¨\u0006'"}, d2 = {"Lcom/coinbase/wallet/features/swap/views/SwapDisclaimerFragment;", "Lcom/coinbase/wallet/commonui/views/BaseFragment;", "Lcom/coinbase/wallet/commonui/views/StyledFragment;", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "Lkotlin/x;", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "Lcom/coinbase/wallet/features/swap/viewmodels/SwapDisclaimerViewModel$Factory;", "viewModelFactory", "Lcom/coinbase/wallet/features/swap/viewmodels/SwapDisclaimerViewModel$Factory;", "getViewModelFactory", "()Lcom/coinbase/wallet/features/swap/viewmodels/SwapDisclaimerViewModel$Factory;", "setViewModelFactory", "(Lcom/coinbase/wallet/features/swap/viewmodels/SwapDisclaimerViewModel$Factory;)V", "Lcom/coinbase/wallet/features/swap/viewmodels/SwapDisclaimerViewModel;", "viewModel$delegate", "Lkotlin/h;", "getViewModel", "()Lcom/coinbase/wallet/features/swap/viewmodels/SwapDisclaimerViewModel;", "viewModel", "Lcom/coinbase/wallet/commonui/views/StyledFragment$Attributes;", "getAttributes", "()Lcom/coinbase/wallet/commonui/views/StyledFragment$Attributes;", "attributes", "Lcom/uber/autodispose/y;", "getScopeProvider", "()Lcom/uber/autodispose/y;", "scopeProvider", "<init>", "()V", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class SwapDisclaimerFragment extends BaseFragment implements StyledFragment {
    private final h viewModel$delegate = z.a(this, e0.b(SwapDisclaimerViewModel.class), new SwapDisclaimerFragment$special$$inlined$viewModel$3(new SwapDisclaimerFragment$special$$inlined$viewModel$2(this)), new SwapDisclaimerFragment$special$$inlined$viewModel$1(this, this));
    public SwapDisclaimerViewModel.Factory viewModelFactory;

    /* JADX INFO: Access modifiers changed from: private */
    public final y getScopeProvider() {
        return Fragment_CommonKt.getFragmentLifecycleScopeProvider$default(this, null, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final SwapDisclaimerViewModel getViewModel() {
        return (SwapDisclaimerViewModel) this.viewModel$delegate.getValue();
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

    public final SwapDisclaimerViewModel.Factory getViewModelFactory() {
        SwapDisclaimerViewModel.Factory factory = this.viewModelFactory;
        if (factory != null) {
            return factory;
        }
        m.w("viewModelFactory");
        throw null;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        m.g(inflater, "inflater");
        return inflater.inflate(R.layout.fragment_swap_user_agreement, viewGroup, false);
    }

    @Override // com.coinbase.wallet.commonui.views.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        m.g(view, "view");
        super.onViewCreated(view, bundle);
        Analytics.INSTANCE.log(AnalyticsEvent_ApplicationKt.getSwapDisclaimerLanded(AnalyticsEvent.Companion));
        View view2 = getView();
        View closeButton = view2 == null ? null : view2.findViewById(e.j.a.t0);
        m.f(closeButton, "closeButton");
        View_CommonKt.setOnSingleClickListener$default(closeButton, 0L, new SwapDisclaimerFragment$onViewCreated$1(this), 1, null);
        View view3 = getView();
        View acknowledgeButton = view3 == null ? null : view3.findViewById(e.j.a.acknowledgeButton);
        m.f(acknowledgeButton, "acknowledgeButton");
        View_CommonKt.setOnSingleClickListener$default(acknowledgeButton, 0L, new SwapDisclaimerFragment$onViewCreated$2(this), 1, null);
        View view4 = getView();
        ((ImageView) (view4 == null ? null : view4.findViewById(e.j.a.disclosureIllustration))).setImageResource(getViewModel().getState().getIllustrationID());
        View view5 = getView();
        ((TextView) (view5 == null ? null : view5.findViewById(e.j.a.disclosureTitle))).setText(getViewModel().getState().getTitle());
        View view6 = getView();
        ((TextView) (view6 != null ? view6.findViewById(e.j.a.disclosureBody) : null)).setText(getViewModel().getState().getBody());
    }

    public final void setViewModelFactory(SwapDisclaimerViewModel.Factory factory) {
        m.g(factory, "<set-?>");
        this.viewModelFactory = factory;
    }
}