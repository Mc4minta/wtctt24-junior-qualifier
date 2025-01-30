package com.coinbase.wallet.features.collectibles;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.widget.NestedScrollView;
import androidx.lifecycle.b0;
import androidx.lifecycle.d0;
import androidx.recyclerview.widget.GridLayoutManager;
import com.coinbase.ApiConstants;
import com.coinbase.wallet.analytics.extensions.Observable_AnalyticsKt;
import com.coinbase.wallet.application.view.custom.TopAwareRecyclerView;
import com.coinbase.wallet.application.viewmodel.ScrolledToTopViewModel;
import com.coinbase.wallet.common.extensions.ObservableSubscribeProxy_CommonKt;
import com.coinbase.wallet.commonui.di.GenericViewModelFactory;
import com.coinbase.wallet.commonui.extensions.Fragment_CommonKt;
import com.coinbase.wallet.commonui.utilities.FragmentLifecycleScopeProvider;
import com.coinbase.wallet.commonui.views.BaseFragment;
import com.coinbase.wallet.core.extensions.Observable_CoreKt;
import com.toshi.model.local.room.CollectibleType;
import com.toshi.view.fragment.ViewCollectibleTypeFragment;
import com.uber.autodispose.d;
import e.j.m.a.c;
import e.j.n.d2;
import h.c.a0;
import h.c.j0.c.a;
import h.c.t0.g;
import h.c.v0.b;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.m;
import kotlin.x;
import org.toshi.R;

/* compiled from: CollectibleTypesTabFragment.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\bC\u0010\u0004J\u000f\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0006\u0010\u0004J\u000f\u0010\u0007\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0007\u0010\u0004J\u0017\u0010\n\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\u0002H\u0003¢\u0006\u0004\b\f\u0010\u0004J\u001d\u0010\u000f\u001a\u00020\u00022\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\b0\rH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u001d\u0010\u0012\u001a\u00020\u00022\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\b0\rH\u0002¢\u0006\u0004\b\u0012\u0010\u0010J\u000f\u0010\u0013\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0013\u0010\u0004J-\u0010\u001b\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u0015\u001a\u00020\u00142\b\u0010\u0017\u001a\u0004\u0018\u00010\u00162\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ!\u0010\u001e\u001a\u00020\u00022\u0006\u0010\u001d\u001a\u00020\u001a2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0016¢\u0006\u0004\b\u001e\u0010\u001fJ\u000f\u0010 \u001a\u00020\u0002H\u0016¢\u0006\u0004\b \u0010\u0004J\u000f\u0010!\u001a\u00020\u0002H\u0016¢\u0006\u0004\b!\u0010\u0004R\u0016\u0010%\u001a\u00020\"8B@\u0002X\u0082\u0004¢\u0006\u0006\u001a\u0004\b#\u0010$R\u0016\u0010'\u001a\u00020&8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b'\u0010(R(\u0010+\u001a\b\u0012\u0004\u0012\u00020*0)8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R(\u00102\u001a\b\u0012\u0004\u0012\u0002010)8\u0000@\u0000X\u0081.¢\u0006\u0012\n\u0004\b2\u0010,\u001a\u0004\b3\u0010.\"\u0004\b4\u00100R\u0016\u00105\u001a\u00020*8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b5\u00106R\u0016\u00107\u001a\u0002018\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b7\u00108R$\u0010;\u001a\u0010\u0012\f\u0012\n :*\u0004\u0018\u00010\u00020\u0002098\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b;\u0010<R\u001e\u0010>\u001a\n :*\u0004\u0018\u00010=0=8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b>\u0010?R\u0016\u0010A\u001a\u00020@8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\bA\u0010B¨\u0006D"}, d2 = {"Lcom/coinbase/wallet/features/collectibles/CollectibleTypesTabFragment;", "Lcom/coinbase/wallet/commonui/views/BaseFragment;", "Lkotlin/x;", "init", "()V", "resumeObservables", "initViewModel", "initAdapter", "Lcom/toshi/model/local/room/CollectibleType;", ApiConstants.TOKEN, "navigateToViewErc721TokensFragment", "(Lcom/toshi/model/local/room/CollectibleType;)V", "initObservers", "", "tokens", "showTokensOrEmptyState", "(Ljava/util/List;)V", "tokenList", "showAndAddTokens", "showEmptyStateView", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "onResume", "onPause", "Lcom/coinbase/wallet/commonui/utilities/FragmentLifecycleScopeProvider;", "getScopeProvider", "()Lcom/coinbase/wallet/commonui/utilities/FragmentLifecycleScopeProvider;", "scopeProvider", "Lh/c/k0/b;", "scrolledToTopDisposable", "Lh/c/k0/b;", "Lcom/coinbase/wallet/commonui/di/GenericViewModelFactory;", "Lcom/coinbase/wallet/application/viewmodel/ScrolledToTopViewModel;", "scrolledToTopViewModelFactory", "Lcom/coinbase/wallet/commonui/di/GenericViewModelFactory;", "getScrolledToTopViewModelFactory", "()Lcom/coinbase/wallet/commonui/di/GenericViewModelFactory;", "setScrolledToTopViewModelFactory", "(Lcom/coinbase/wallet/commonui/di/GenericViewModelFactory;)V", "Le/j/n/d2;", "viewModelFactory", "getViewModelFactory$app_productionRelease", "setViewModelFactory$app_productionRelease", "scrolledToTopViewModel", "Lcom/coinbase/wallet/application/viewmodel/ScrolledToTopViewModel;", "viewModel", "Le/j/n/d2;", "Lh/c/v0/b;", "kotlin.jvm.PlatformType", "isReadySubject", "Lh/c/v0/b;", "Lh/c/a0;", "mainScheduler", "Lh/c/a0;", "Le/j/m/a/c;", "collectibleTypesAdapter", "Le/j/m/a/c;", "<init>", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class CollectibleTypesTabFragment extends BaseFragment {
    private c collectibleTypesAdapter;
    private final b<x> isReadySubject;
    private final a0 mainScheduler = a.b();
    private h.c.k0.b scrolledToTopDisposable;
    private ScrolledToTopViewModel scrolledToTopViewModel;
    public GenericViewModelFactory<ScrolledToTopViewModel> scrolledToTopViewModelFactory;
    private d2 viewModel;
    public GenericViewModelFactory<d2> viewModelFactory;

    public CollectibleTypesTabFragment() {
        b<x> d2 = b.d();
        m.f(d2, "create<Unit>()");
        this.isReadySubject = d2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final FragmentLifecycleScopeProvider getScopeProvider() {
        return Fragment_CommonKt.getFragmentLifecycleScopeProvider$default(this, null, 1, null);
    }

    private final void init() {
        initViewModel();
        initAdapter();
        initObservers();
    }

    private final void initAdapter() {
        c cVar = new c(new ArrayList());
        this.collectibleTypesAdapter = cVar;
        if (cVar != null) {
            cVar.e(new CollectibleTypesTabFragment$initAdapter$1(this));
            View view = getView();
            TopAwareRecyclerView topAwareRecyclerView = (TopAwareRecyclerView) (view == null ? null : view.findViewById(e.j.a.collectiblesRecyclerView));
            c cVar2 = this.collectibleTypesAdapter;
            if (cVar2 != null) {
                topAwareRecyclerView.setAdapter(cVar2);
                View view2 = getView();
                ((TopAwareRecyclerView) (view2 != null ? view2.findViewById(e.j.a.collectiblesRecyclerView) : null)).setLayoutManager(new GridLayoutManager(getContext(), 2));
                return;
            }
            m.w("collectibleTypesAdapter");
            throw null;
        }
        m.w("collectibleTypesAdapter");
        throw null;
    }

    @SuppressLint({"CheckResult"})
    private final void initObservers() {
        g.i(Observable_CoreKt.takeSingle(this.isReadySubject), null, new CollectibleTypesTabFragment$initObservers$1(this), 1, null);
        View view = getView();
        TopAwareRecyclerView topAwareRecyclerView = (TopAwareRecyclerView) (view == null ? null : view.findViewById(e.j.a.collectiblesRecyclerView));
        ScrolledToTopViewModel scrolledToTopViewModel = this.scrolledToTopViewModel;
        if (scrolledToTopViewModel != null) {
            Object as = Observable_AnalyticsKt.logError$default(topAwareRecyclerView.startTouchedObservable(scrolledToTopViewModel), "Couldn't update touched state of motion layout", null, 2, null).as(d.a(getScopeProvider()));
            m.f(as, "collectiblesRecyclerView.startTouchedObservable(scrolledToTopViewModel)\n            .logError(\"Couldn't update touched state of motion layout\")\n            .`as`(autoDisposable(scopeProvider))");
            ObservableSubscribeProxy_CommonKt.subscribeBy$default((com.uber.autodispose.x) as, null, null, null, 7, null);
            return;
        }
        m.w("scrolledToTopViewModel");
        throw null;
    }

    private final void initViewModel() {
        b0 a = new d0(this, getViewModelFactory$app_productionRelease()).a(d2.class);
        m.f(a, "ViewModelProvider(this, viewModelFactory).get(T::class.java)");
        this.viewModel = (d2) a;
        b0 a2 = new d0(requireActivity(), getScrolledToTopViewModelFactory()).a(ScrolledToTopViewModel.class);
        m.f(a2, "{\n    ViewModelProvider(requireActivity(), viewModelFactory).get(T::class.java)\n}");
        this.scrolledToTopViewModel = (ScrolledToTopViewModel) a2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void navigateToViewErc721TokensFragment(CollectibleType collectibleType) {
        Fragment_CommonKt.navigate$default(this, R.id.action_walletFragment_to_viewErc721TokensFragment, ViewCollectibleTypeFragment.a.a(collectibleType), null, null, 12, null);
    }

    private final void resumeObservables() {
        View view = getView();
        TopAwareRecyclerView topAwareRecyclerView = (TopAwareRecyclerView) (view == null ? null : view.findViewById(e.j.a.collectiblesRecyclerView));
        ScrolledToTopViewModel scrolledToTopViewModel = this.scrolledToTopViewModel;
        if (scrolledToTopViewModel != null) {
            h.c.k0.b subscribe = ((com.uber.autodispose.x) Observable_AnalyticsKt.logError$default(topAwareRecyclerView.startScrollToTopListener(scrolledToTopViewModel), "Couldn't load scrolled to top status", null, 2, null).as(d.a(getScopeProvider()))).subscribe();
            m.f(subscribe, "collectiblesRecyclerView.startScrollToTopListener(scrolledToTopViewModel)\n            .logError(\"Couldn't load scrolled to top status\")\n            .`as`(autoDisposable(scopeProvider))\n            .subscribe()");
            this.scrolledToTopDisposable = subscribe;
            initObservers();
            return;
        }
        m.w("scrolledToTopViewModel");
        throw null;
    }

    private final void showAndAddTokens(List<CollectibleType> list) {
        View view = getView();
        ((NestedScrollView) (view == null ? null : view.findViewById(e.j.a.emptyState))).setVisibility(8);
        View view2 = getView();
        ((TopAwareRecyclerView) (view2 == null ? null : view2.findViewById(e.j.a.collectiblesRecyclerView))).setVisibility(0);
        c cVar = this.collectibleTypesAdapter;
        if (cVar != null) {
            cVar.d(list);
        } else {
            m.w("collectibleTypesAdapter");
            throw null;
        }
    }

    private final void showEmptyStateView() {
        View view = getView();
        ((NestedScrollView) (view == null ? null : view.findViewById(e.j.a.emptyState))).setVisibility(0);
        View view2 = getView();
        ((TopAwareRecyclerView) (view2 == null ? null : view2.findViewById(e.j.a.collectiblesRecyclerView))).setVisibility(8);
        View view3 = getView();
        ((TextView) (view3 != null ? view3.findViewById(e.j.a.emptyStateTitle) : null)).setText(getString(R.string.empty_state_collectibles_title));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showTokensOrEmptyState(List<CollectibleType> list) {
        if (!list.isEmpty()) {
            showAndAddTokens(list);
        } else {
            showEmptyStateView();
        }
    }

    @Override // com.coinbase.wallet.commonui.views.BaseFragment
    public void _$_clearFindViewByIdCache() {
    }

    public final GenericViewModelFactory<ScrolledToTopViewModel> getScrolledToTopViewModelFactory() {
        GenericViewModelFactory<ScrolledToTopViewModel> genericViewModelFactory = this.scrolledToTopViewModelFactory;
        if (genericViewModelFactory != null) {
            return genericViewModelFactory;
        }
        m.w("scrolledToTopViewModelFactory");
        throw null;
    }

    public final GenericViewModelFactory<d2> getViewModelFactory$app_productionRelease() {
        GenericViewModelFactory<d2> genericViewModelFactory = this.viewModelFactory;
        if (genericViewModelFactory != null) {
            return genericViewModelFactory;
        }
        m.w("viewModelFactory");
        throw null;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        m.g(inflater, "inflater");
        return inflater.inflate(R.layout.fragment_collectible_types, viewGroup, false);
    }

    @Override // com.coinbase.wallet.commonui.views.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        d2 d2Var = this.viewModel;
        if (d2Var != null) {
            d2Var.e();
            View view = getView();
            ((TopAwareRecyclerView) (view == null ? null : view.findViewById(e.j.a.collectiblesRecyclerView))).setNestedScrollingEnabled(false);
            h.c.k0.b bVar = this.scrolledToTopDisposable;
            if (bVar != null) {
                bVar.dispose();
                return;
            } else {
                m.w("scrolledToTopDisposable");
                throw null;
            }
        }
        m.w("viewModel");
        throw null;
    }

    @Override // com.coinbase.wallet.commonui.views.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        resumeObservables();
        d2 d2Var = this.viewModel;
        if (d2Var != null) {
            d2Var.d();
            this.isReadySubject.onNext(x.a);
            View view = getView();
            ((TopAwareRecyclerView) (view != null ? view.findViewById(e.j.a.collectiblesRecyclerView) : null)).setNestedScrollingEnabled(true);
            return;
        }
        m.w("viewModel");
        throw null;
    }

    @Override // com.coinbase.wallet.commonui.views.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        m.g(view, "view");
        init();
    }

    public final void setScrolledToTopViewModelFactory(GenericViewModelFactory<ScrolledToTopViewModel> genericViewModelFactory) {
        m.g(genericViewModelFactory, "<set-?>");
        this.scrolledToTopViewModelFactory = genericViewModelFactory;
    }

    public final void setViewModelFactory$app_productionRelease(GenericViewModelFactory<d2> genericViewModelFactory) {
        m.g(genericViewModelFactory, "<set-?>");
        this.viewModelFactory = genericViewModelFactory;
    }
}