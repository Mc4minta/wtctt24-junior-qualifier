package com.coinbase.wallet.features.lend.views;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.b0;
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
import com.coinbase.wallet.commonui.models.ViewModelNavRoute;
import com.coinbase.wallet.commonui.utilities.FragmentLifecycleScopeProvider;
import com.coinbase.wallet.commonui.views.BaseFragment;
import com.coinbase.wallet.commonui.views.StyledFragment;
import com.coinbase.wallet.features.lend.models.LendCoinPickerState;
import com.coinbase.wallet.features.lend.viewmodels.LendCoinPickerViewModel;
import com.coinbase.wallet.features.lend.views.adapters.LendCoinPickerAdapter;
import com.uber.autodispose.x;
import h.c.a0;
import h.c.s;
import kotlin.Metadata;
import kotlin.h;
import kotlin.jvm.internal.m;
import kotlin.k;
import org.toshi.R;

/* compiled from: LendCoinPickerFragment.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b.\u0010\u0005J\u000f\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0006\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0006\u0010\u0005J-\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\b\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ!\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016¢\u0006\u0004\b\u0011\u0010\u0012R\u001d\u0010\u0018\u001a\u00020\u00138B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001a\u001a\u00020\u00198\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR(\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00190\u001c8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u0016\u0010&\u001a\u00020#8B@\u0002X\u0082\u0004¢\u0006\u0006\u001a\u0004\b$\u0010%R\u0016\u0010(\u001a\u00020'8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b(\u0010)R\u0016\u0010-\u001a\u00020*8V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\b+\u0010,¨\u0006/"}, d2 = {"Lcom/coinbase/wallet/features/lend/views/LendCoinPickerFragment;", "Lcom/coinbase/wallet/commonui/views/BaseFragment;", "Lcom/coinbase/wallet/commonui/views/StyledFragment;", "Lkotlin/x;", "setupAdapter", "()V", "setupObservers", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "Lh/c/a0;", "mainScheduler$delegate", "Lkotlin/h;", "getMainScheduler", "()Lh/c/a0;", "mainScheduler", "Lcom/coinbase/wallet/features/lend/viewmodels/LendCoinPickerViewModel;", "viewModel", "Lcom/coinbase/wallet/features/lend/viewmodels/LendCoinPickerViewModel;", "Lcom/coinbase/wallet/commonui/di/GenericViewModelFactory;", "lendCoinPickerViewModelFactory", "Lcom/coinbase/wallet/commonui/di/GenericViewModelFactory;", "getLendCoinPickerViewModelFactory", "()Lcom/coinbase/wallet/commonui/di/GenericViewModelFactory;", "setLendCoinPickerViewModelFactory", "(Lcom/coinbase/wallet/commonui/di/GenericViewModelFactory;)V", "Lcom/coinbase/wallet/commonui/utilities/FragmentLifecycleScopeProvider;", "getScopeProvider", "()Lcom/coinbase/wallet/commonui/utilities/FragmentLifecycleScopeProvider;", "scopeProvider", "Lcom/coinbase/wallet/features/lend/views/adapters/LendCoinPickerAdapter;", "coinPickerAdapter", "Lcom/coinbase/wallet/features/lend/views/adapters/LendCoinPickerAdapter;", "Lcom/coinbase/wallet/commonui/views/StyledFragment$Attributes;", "getAttributes", "()Lcom/coinbase/wallet/commonui/views/StyledFragment$Attributes;", "attributes", "<init>", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class LendCoinPickerFragment extends BaseFragment implements StyledFragment {
    private LendCoinPickerAdapter coinPickerAdapter;
    public GenericViewModelFactory<LendCoinPickerViewModel> lendCoinPickerViewModelFactory;
    private final h mainScheduler$delegate;
    private LendCoinPickerViewModel viewModel;

    public LendCoinPickerFragment() {
        h b2;
        b2 = k.b(LendCoinPickerFragment$mainScheduler$2.INSTANCE);
        this.mainScheduler$delegate = b2;
    }

    private final a0 getMainScheduler() {
        Object value = this.mainScheduler$delegate.getValue();
        m.f(value, "<get-mainScheduler>(...)");
        return (a0) value;
    }

    private final FragmentLifecycleScopeProvider getScopeProvider() {
        return Fragment_CommonKt.getFragmentLifecycleScopeProvider$default(this, null, 1, null);
    }

    private final void setupAdapter() {
        this.coinPickerAdapter = new LendCoinPickerAdapter(new LendCoinPickerFragment$setupAdapter$1(this));
        View view = getView();
        RecyclerView recyclerView = (RecyclerView) (view == null ? null : view.findViewById(e.j.a.chooseCoinRecyclerView));
        LendCoinPickerAdapter lendCoinPickerAdapter = this.coinPickerAdapter;
        if (lendCoinPickerAdapter != null) {
            recyclerView.setAdapter(lendCoinPickerAdapter);
        } else {
            m.w("coinPickerAdapter");
            throw null;
        }
    }

    private final void setupObservers() {
        LendCoinPickerAdapter lendCoinPickerAdapter = this.coinPickerAdapter;
        if (lendCoinPickerAdapter == null) {
            m.w("coinPickerAdapter");
            throw null;
        }
        LendCoinPickerViewModel lendCoinPickerViewModel = this.viewModel;
        if (lendCoinPickerViewModel != null) {
            lendCoinPickerAdapter.submitList(lendCoinPickerViewModel.getState().getItems());
            LendCoinPickerViewModel lendCoinPickerViewModel2 = this.viewModel;
            if (lendCoinPickerViewModel2 != null) {
                s<LendCoinPickerState> observeOn = lendCoinPickerViewModel2.getStateObservable().observeOn(getMainScheduler());
                m.f(observeOn, "viewModel.stateObservable\n            .observeOn(mainScheduler)");
                Object as = Observable_AnalyticsKt.logError$default(observeOn, null, null, 3, null).as(com.uber.autodispose.d.a(getScopeProvider()));
                m.f(as, "viewModel.stateObservable\n            .observeOn(mainScheduler)\n            .logError()\n            .`as`(autoDisposable(scopeProvider))");
                ObservableSubscribeProxy_CommonKt.subscribeBy$default((x) as, null, null, new LendCoinPickerFragment$setupObservers$1(this), 3, null);
                LendCoinPickerViewModel lendCoinPickerViewModel3 = this.viewModel;
                if (lendCoinPickerViewModel3 != null) {
                    s<ViewModelNavRoute> observeOn2 = lendCoinPickerViewModel3.getNavigationObservable().observeOn(getMainScheduler());
                    m.f(observeOn2, "viewModel.navigationObservable\n            .observeOn(mainScheduler)");
                    Object as2 = Observable_AnalyticsKt.logError$default(observeOn2, null, null, 3, null).as(com.uber.autodispose.d.a(getScopeProvider()));
                    m.f(as2, "viewModel.navigationObservable\n            .observeOn(mainScheduler)\n            .logError()\n            .`as`(autoDisposable(scopeProvider))");
                    ObservableSubscribeProxy_CommonKt.subscribeBy$default((x) as2, null, null, new LendCoinPickerFragment$setupObservers$2(this), 3, null);
                    LendCoinPickerViewModel lendCoinPickerViewModel4 = this.viewModel;
                    if (lendCoinPickerViewModel4 != null) {
                        Object as3 = lendCoinPickerViewModel4.getActionSheetObservable().as(com.uber.autodispose.d.a(getScopeProvider()));
                        m.f(as3, "viewModel.actionSheetObservable\n            .`as`(autoDisposable(scopeProvider))");
                        ObservableSubscribeProxy_CommonKt.subscribeBy$default((x) as3, null, null, new LendCoinPickerFragment$setupObservers$3(this), 3, null);
                        return;
                    }
                    m.w("viewModel");
                    throw null;
                }
                m.w("viewModel");
                throw null;
            }
            m.w("viewModel");
            throw null;
        }
        m.w("viewModel");
        throw null;
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

    public final GenericViewModelFactory<LendCoinPickerViewModel> getLendCoinPickerViewModelFactory() {
        GenericViewModelFactory<LendCoinPickerViewModel> genericViewModelFactory = this.lendCoinPickerViewModelFactory;
        if (genericViewModelFactory != null) {
            return genericViewModelFactory;
        }
        m.w("lendCoinPickerViewModelFactory");
        throw null;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        m.g(inflater, "inflater");
        return inflater.inflate(R.layout.fragment_lend_coin_picker, viewGroup, false);
    }

    @Override // com.coinbase.wallet.commonui.views.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        m.g(view, "view");
        super.onViewCreated(view, bundle);
        Analytics.INSTANCE.log(AnalyticsEvent_ApplicationKt.lendCoinPickerLanded(AnalyticsEvent.Companion));
        b0 a = new androidx.lifecycle.d0(this, getLendCoinPickerViewModelFactory()).a(LendCoinPickerViewModel.class);
        m.f(a, "ViewModelProvider(this, viewModelFactory).get(T::class.java)");
        LendCoinPickerViewModel lendCoinPickerViewModel = (LendCoinPickerViewModel) a;
        Bundle requireArguments = requireArguments();
        m.f(requireArguments, "requireArguments()");
        lendCoinPickerViewModel.setArgs(requireArguments);
        kotlin.x xVar = kotlin.x.a;
        this.viewModel = lendCoinPickerViewModel;
        View view2 = getView();
        View closeButton = view2 == null ? null : view2.findViewById(e.j.a.t0);
        m.f(closeButton, "closeButton");
        View_CommonKt.setOnSingleClickListener$default(closeButton, 0L, new LendCoinPickerFragment$onViewCreated$2(this), 1, null);
        setupAdapter();
        setupObservers();
    }

    public final void setLendCoinPickerViewModelFactory(GenericViewModelFactory<LendCoinPickerViewModel> genericViewModelFactory) {
        m.g(genericViewModelFactory, "<set-?>");
        this.lendCoinPickerViewModelFactory = genericViewModelFactory;
    }
}