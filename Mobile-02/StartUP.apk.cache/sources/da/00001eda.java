package com.coinbase.wallet.features.lend.views;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.b0;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import c.h.k.d0;
import com.coinbase.wallet.analytics.Analytics;
import com.coinbase.wallet.analytics.extensions.Observable_AnalyticsKt;
import com.coinbase.wallet.analytics.models.AnalyticsEvent;
import com.coinbase.wallet.application.extensions.AnalyticsEvent_ApplicationKt;
import com.coinbase.wallet.common.extensions.ObservableSubscribeProxy_CommonKt;
import com.coinbase.wallet.commonui.di.GenericViewModelFactory;
import com.coinbase.wallet.commonui.extensions.Fragment_CommonKt;
import com.coinbase.wallet.commonui.extensions.View_CommonKt;
import com.coinbase.wallet.commonui.views.BaseFragment;
import com.coinbase.wallet.commonui.views.StyledFragment;
import com.coinbase.wallet.features.lend.viewmodels.LendProviderPickerViewModel;
import com.coinbase.wallet.features.lend.views.adapters.LendProviderPickerAdapter;
import com.uber.autodispose.x;
import com.uber.autodispose.y;
import kotlin.Metadata;
import kotlin.jvm.internal.m;
import org.toshi.R;

/* compiled from: LendProviderPickerFragment.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b,\u0010\u0005J\u000f\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0006\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0006\u0010\u0005J-\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\b\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ!\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016¢\u0006\u0004\b\u0011\u0010\u0012R(\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u00138\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001e\u001a\u00020\u001b8B@\u0002X\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001dR\u0016\u0010 \u001a\u00020\u001f8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b \u0010!R\u0016\u0010%\u001a\u00020\"8V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\b#\u0010$R\"\u0010&\u001a\u00020\u00148\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+¨\u0006-"}, d2 = {"Lcom/coinbase/wallet/features/lend/views/LendProviderPickerFragment;", "Lcom/coinbase/wallet/commonui/views/BaseFragment;", "Lcom/coinbase/wallet/commonui/views/StyledFragment;", "Lkotlin/x;", "setupAdapter", "()V", "setupObservers", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "Lcom/coinbase/wallet/commonui/di/GenericViewModelFactory;", "Lcom/coinbase/wallet/features/lend/viewmodels/LendProviderPickerViewModel;", "lendProviderPickerViewModelFactory", "Lcom/coinbase/wallet/commonui/di/GenericViewModelFactory;", "getLendProviderPickerViewModelFactory", "()Lcom/coinbase/wallet/commonui/di/GenericViewModelFactory;", "setLendProviderPickerViewModelFactory", "(Lcom/coinbase/wallet/commonui/di/GenericViewModelFactory;)V", "Lcom/uber/autodispose/y;", "getScopeProvider", "()Lcom/uber/autodispose/y;", "scopeProvider", "Lcom/coinbase/wallet/features/lend/views/adapters/LendProviderPickerAdapter;", "providerPickerAdapter", "Lcom/coinbase/wallet/features/lend/views/adapters/LendProviderPickerAdapter;", "Lcom/coinbase/wallet/commonui/views/StyledFragment$Attributes;", "getAttributes", "()Lcom/coinbase/wallet/commonui/views/StyledFragment$Attributes;", "attributes", "viewModel", "Lcom/coinbase/wallet/features/lend/viewmodels/LendProviderPickerViewModel;", "getViewModel", "()Lcom/coinbase/wallet/features/lend/viewmodels/LendProviderPickerViewModel;", "setViewModel", "(Lcom/coinbase/wallet/features/lend/viewmodels/LendProviderPickerViewModel;)V", "<init>", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class LendProviderPickerFragment extends BaseFragment implements StyledFragment {
    public GenericViewModelFactory<LendProviderPickerViewModel> lendProviderPickerViewModelFactory;
    private LendProviderPickerAdapter providerPickerAdapter;
    public LendProviderPickerViewModel viewModel;

    private final y getScopeProvider() {
        return Fragment_CommonKt.getFragmentLifecycleScopeProvider$default(this, null, 1, null);
    }

    private final void setupAdapter() {
        this.providerPickerAdapter = new LendProviderPickerAdapter(new LendProviderPickerFragment$setupAdapter$1(this), new LendProviderPickerFragment$setupAdapter$2(this), new LendProviderPickerFragment$setupAdapter$3(this), new LendProviderPickerFragment$setupAdapter$4(this), new LendProviderPickerFragment$setupAdapter$5(this));
        View view = getView();
        ((RecyclerView) (view == null ? null : view.findViewById(e.j.a.providerRecyclerView))).setLayoutManager(new LinearLayoutManager(requireContext()));
        View view2 = getView();
        RecyclerView recyclerView = (RecyclerView) (view2 == null ? null : view2.findViewById(e.j.a.providerRecyclerView));
        LendProviderPickerAdapter lendProviderPickerAdapter = this.providerPickerAdapter;
        if (lendProviderPickerAdapter != null) {
            recyclerView.setAdapter(lendProviderPickerAdapter);
        } else {
            m.w("providerPickerAdapter");
            throw null;
        }
    }

    private final void setupObservers() {
        Object as = Observable_AnalyticsKt.logError$default(getViewModel().getStateObservable(), null, null, 3, null).as(com.uber.autodispose.d.a(getScopeProvider()));
        m.f(as, "viewModel.stateObservable\n            .logError()\n            .`as`(autoDisposable(scopeProvider))");
        ObservableSubscribeProxy_CommonKt.subscribeBy$default((x) as, null, null, new LendProviderPickerFragment$setupObservers$1(this), 3, null);
        Object as2 = Observable_AnalyticsKt.logError$default(getViewModel().getPromptObservable(), null, null, 3, null).as(com.uber.autodispose.d.a(getScopeProvider()));
        m.f(as2, "viewModel.promptObservable\n            .logError()\n            .`as`(autoDisposable(scopeProvider))");
        ObservableSubscribeProxy_CommonKt.subscribeBy$default((x) as2, null, null, new LendProviderPickerFragment$setupObservers$2(this), 3, null);
        Object as3 = getViewModel().getNavigationObservable().as(com.uber.autodispose.d.a(getScopeProvider()));
        m.f(as3, "viewModel.navigationObservable\n            .`as`(autoDisposable(scopeProvider))");
        ObservableSubscribeProxy_CommonKt.subscribeBy$default((x) as3, null, null, new LendProviderPickerFragment$setupObservers$3(this), 3, null);
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

    public final GenericViewModelFactory<LendProviderPickerViewModel> getLendProviderPickerViewModelFactory() {
        GenericViewModelFactory<LendProviderPickerViewModel> genericViewModelFactory = this.lendProviderPickerViewModelFactory;
        if (genericViewModelFactory != null) {
            return genericViewModelFactory;
        }
        m.w("lendProviderPickerViewModelFactory");
        throw null;
    }

    public final LendProviderPickerViewModel getViewModel() {
        LendProviderPickerViewModel lendProviderPickerViewModel = this.viewModel;
        if (lendProviderPickerViewModel != null) {
            return lendProviderPickerViewModel;
        }
        m.w("viewModel");
        throw null;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        m.g(inflater, "inflater");
        return inflater.inflate(R.layout.fragment_lend_provider_picker, viewGroup, false);
    }

    @Override // com.coinbase.wallet.commonui.views.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        m.g(view, "view");
        super.onViewCreated(view, bundle);
        Analytics.INSTANCE.log(AnalyticsEvent_ApplicationKt.lendProviderPickerLanded(AnalyticsEvent.Companion));
        b0 a = new androidx.lifecycle.d0(this, getLendProviderPickerViewModelFactory()).a(LendProviderPickerViewModel.class);
        m.f(a, "ViewModelProvider(this, viewModelFactory).get(T::class.java)");
        LendProviderPickerViewModel lendProviderPickerViewModel = (LendProviderPickerViewModel) a;
        Bundle requireArguments = requireArguments();
        m.f(requireArguments, "requireArguments()");
        lendProviderPickerViewModel.setArgs(requireArguments);
        if (!lendProviderPickerViewModel.isSetup()) {
            lendProviderPickerViewModel.setup();
        }
        kotlin.x xVar = kotlin.x.a;
        setViewModel(lendProviderPickerViewModel);
        View view2 = getView();
        View closeButton = view2 == null ? null : view2.findViewById(e.j.a.t0);
        m.f(closeButton, "closeButton");
        View_CommonKt.setOnSingleClickListener$default(closeButton, 0L, new LendProviderPickerFragment$onViewCreated$2(this), 1, null);
        View view3 = getView();
        View continueButton = view3 != null ? view3.findViewById(e.j.a.continueButton) : null;
        m.f(continueButton, "continueButton");
        View_CommonKt.setOnSingleClickListener$default(continueButton, 0L, new LendProviderPickerFragment$onViewCreated$3(this), 1, null);
        setupAdapter();
        setupObservers();
    }

    public final void setLendProviderPickerViewModelFactory(GenericViewModelFactory<LendProviderPickerViewModel> genericViewModelFactory) {
        m.g(genericViewModelFactory, "<set-?>");
        this.lendProviderPickerViewModelFactory = genericViewModelFactory;
    }

    public final void setViewModel(LendProviderPickerViewModel lendProviderPickerViewModel) {
        m.g(lendProviderPickerViewModel, "<set-?>");
        this.viewModel = lendProviderPickerViewModel;
    }
}