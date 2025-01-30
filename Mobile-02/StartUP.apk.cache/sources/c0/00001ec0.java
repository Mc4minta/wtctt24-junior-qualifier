package com.coinbase.wallet.features.lend.views;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.lifecycle.b0;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import c.h.k.d0;
import com.coinbase.wallet.analytics.Analytics;
import com.coinbase.wallet.analytics.extensions.Observable_AnalyticsKt;
import com.coinbase.wallet.analytics.models.AnalyticsEvent;
import com.coinbase.wallet.application.extensions.AnalyticsEvent_ApplicationKt;
import com.coinbase.wallet.application.extensions.TraceKey_ApplicationKt;
import com.coinbase.wallet.common.extensions.ObservableSubscribeProxy_CommonKt;
import com.coinbase.wallet.commonui.di.GenericViewModelFactory;
import com.coinbase.wallet.commonui.extensions.Fragment_CommonKt;
import com.coinbase.wallet.commonui.extensions.View_CommonKt;
import com.coinbase.wallet.commonui.utilities.FragmentLifecycleScopeProvider;
import com.coinbase.wallet.commonui.views.BaseFragment;
import com.coinbase.wallet.commonui.views.StyledFragment;
import com.coinbase.wallet.core.models.TraceKey;
import com.coinbase.wallet.features.lend.models.LendDashboardItem;
import com.coinbase.wallet.features.lend.viewmodels.LendDashboardViewModel;
import com.coinbase.wallet.features.lend.views.adapters.DashboardListAdapter;
import com.coinbase.wallet.performance.Tracer;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.uber.autodispose.x;
import h.c.m0.f;
import h.c.s;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.a0.q;
import kotlin.h;
import kotlin.jvm.internal.a0;
import kotlin.jvm.internal.m;
import kotlin.k;
import org.toshi.R;

/* compiled from: LendDashboardFragment.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\bE\u0010\u0005J\u000f\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0006\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0006\u0010\u0005J\u0019\u0010\t\u001a\u00020\u00032\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0004\b\t\u0010\nJ-\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0004\b\u0010\u0010\u0011J!\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u000f2\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u001f\u0010\u0017\u001a\u00020\u00152\u0006\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0016\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u0017\u0010\u0018R(\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00198\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R$\u0010\"\u001a\u0004\u0018\u00010!8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u0016\u0010(\u001a\u00020\u001a8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b(\u0010)R%\u00100\u001a\n +*\u0004\u0018\u00010*0*8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/R\u001d\u00105\u001a\u0002018V@\u0016X\u0096\u0084\u0002¢\u0006\f\n\u0004\b2\u0010-\u001a\u0004\b3\u00104R\u0016\u00109\u001a\u0002068B@\u0002X\u0082\u0004¢\u0006\u0006\u001a\u0004\b7\u00108R\u001d\u0010>\u001a\u00020:8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b;\u0010-\u001a\u0004\b<\u0010=R\u001c\u0010A\u001a\b\u0012\u0004\u0012\u00020@0?8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bA\u0010BR\u0016\u0010C\u001a\u00020!8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bC\u0010D¨\u0006F"}, d2 = {"Lcom/coinbase/wallet/features/lend/views/LendDashboardFragment;", "Lcom/coinbase/wallet/commonui/views/BaseFragment;", "Lcom/coinbase/wallet/commonui/views/StyledFragment;", "Lkotlin/x;", "showLendingActionSheet", "()V", "hideLendingActionSheet", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "Lc/h/k/d0;", "insets", "applyWindowInsets", "(Landroid/view/View;Lc/h/k/d0;)Lc/h/k/d0;", "Lcom/coinbase/wallet/commonui/di/GenericViewModelFactory;", "Lcom/coinbase/wallet/features/lend/viewmodels/LendDashboardViewModel;", "viewModelFactory", "Lcom/coinbase/wallet/commonui/di/GenericViewModelFactory;", "getViewModelFactory", "()Lcom/coinbase/wallet/commonui/di/GenericViewModelFactory;", "setViewModelFactory", "(Lcom/coinbase/wallet/commonui/di/GenericViewModelFactory;)V", "", "transitionedToStart", "Ljava/lang/Boolean;", "getTransitionedToStart", "()Ljava/lang/Boolean;", "setTransitionedToStart", "(Ljava/lang/Boolean;)V", "viewModel", "Lcom/coinbase/wallet/features/lend/viewmodels/LendDashboardViewModel;", "Lh/c/a0;", "kotlin.jvm.PlatformType", "mainScheduler$delegate", "Lkotlin/h;", "getMainScheduler", "()Lh/c/a0;", "mainScheduler", "Lcom/coinbase/wallet/commonui/views/StyledFragment$Attributes;", "attributes$delegate", "getAttributes", "()Lcom/coinbase/wallet/commonui/views/StyledFragment$Attributes;", "attributes", "Lcom/coinbase/wallet/commonui/utilities/FragmentLifecycleScopeProvider;", "getScopeProvider", "()Lcom/coinbase/wallet/commonui/utilities/FragmentLifecycleScopeProvider;", "scopeProvider", "Lcom/coinbase/wallet/features/lend/views/adapters/DashboardListAdapter;", "adapter$delegate", "getAdapter", "()Lcom/coinbase/wallet/features/lend/views/adapters/DashboardListAdapter;", "adapter", "", "Lcom/coinbase/wallet/features/lend/models/LendDashboardItem$BlankItem;", "blankListItem", "Ljava/util/List;", "hasAppliedInsets", "Z", "<init>", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class LendDashboardFragment extends BaseFragment implements StyledFragment {
    private final h adapter$delegate;
    private final h attributes$delegate;
    private final List<LendDashboardItem.BlankItem> blankListItem;
    private boolean hasAppliedInsets;
    private final h mainScheduler$delegate;
    private Boolean transitionedToStart;
    private LendDashboardViewModel viewModel;
    public GenericViewModelFactory<LendDashboardViewModel> viewModelFactory;

    public LendDashboardFragment() {
        List<LendDashboardItem.BlankItem> b2;
        h b3;
        h b4;
        h b5;
        b2 = q.b(new LendDashboardItem.BlankItem());
        this.blankListItem = b2;
        b3 = k.b(LendDashboardFragment$mainScheduler$2.INSTANCE);
        this.mainScheduler$delegate = b3;
        b4 = k.b(new LendDashboardFragment$adapter$2(this));
        this.adapter$delegate = b4;
        b5 = k.b(new LendDashboardFragment$attributes$2(this));
        this.attributes$delegate = b5;
    }

    public static /* synthetic */ void d(a0 a0Var, Throwable th) {
        m1291onViewCreated$lambda1(a0Var, th);
    }

    public static /* synthetic */ void e(h.c.k0.b bVar) {
        m1290onViewCreated$lambda0(bVar);
    }

    public static /* synthetic */ void f(a0 a0Var, List list) {
        m1292onViewCreated$lambda2(a0Var, list);
    }

    public final DashboardListAdapter getAdapter() {
        return (DashboardListAdapter) this.adapter$delegate.getValue();
    }

    private final h.c.a0 getMainScheduler() {
        return (h.c.a0) this.mainScheduler$delegate.getValue();
    }

    private final FragmentLifecycleScopeProvider getScopeProvider() {
        return Fragment_CommonKt.getFragmentLifecycleScopeProvider$default(this, null, 1, null);
    }

    public final void hideLendingActionSheet() {
        View view = getView();
        View lendBottomSheetBackground = view == null ? null : view.findViewById(e.j.a.lendBottomSheetBackground);
        m.f(lendBottomSheetBackground, "lendBottomSheetBackground");
        View_CommonKt.fadeOut$default(lendBottomSheetBackground, 300L, null, 2, null);
        View view2 = getView();
        TextView textView = (TextView) (view2 == null ? null : view2.findViewById(e.j.a.providerAPR));
        LendDashboardViewModel lendDashboardViewModel = this.viewModel;
        if (lendDashboardViewModel != null) {
            textView.setText(lendDashboardViewModel.getSelectedItemDescription());
            View view3 = getView();
            BottomSheetBehavior.I(view3 != null ? view3.findViewById(e.j.a.lendBottomSheet) : null).S(4);
            return;
        }
        m.w("viewModel");
        throw null;
    }

    /* renamed from: onViewCreated$lambda-0 */
    public static final void m1290onViewCreated$lambda0(h.c.k0.b bVar) {
        Tracer.INSTANCE.start(TraceKey_ApplicationKt.getLoadLendDashboardKey(TraceKey.Companion));
    }

    /* renamed from: onViewCreated$lambda-1 */
    public static final void m1291onViewCreated$lambda1(a0 hasLoadedFirstDataset, Throwable th) {
        m.g(hasLoadedFirstDataset, "$hasLoadedFirstDataset");
        if (!hasLoadedFirstDataset.a) {
            Tracer.INSTANCE.stop(TraceKey_ApplicationKt.getLoadLendDashboardKey(TraceKey.Companion));
        }
        hasLoadedFirstDataset.a = true;
    }

    /* renamed from: onViewCreated$lambda-2 */
    public static final void m1292onViewCreated$lambda2(a0 hasLoadedFirstDataset, List list) {
        m.g(hasLoadedFirstDataset, "$hasLoadedFirstDataset");
        if (!hasLoadedFirstDataset.a) {
            Tracer.INSTANCE.stop(TraceKey_ApplicationKt.getLoadLendDashboardKey(TraceKey.Companion));
        }
        hasLoadedFirstDataset.a = true;
    }

    public final void showLendingActionSheet() {
        View view = getView();
        View lendBottomSheetBackground = view == null ? null : view.findViewById(e.j.a.lendBottomSheetBackground);
        m.f(lendBottomSheetBackground, "lendBottomSheetBackground");
        View_CommonKt.fadeIn$default(lendBottomSheetBackground, 300L, null, 2, null);
        View view2 = getView();
        TextView textView = (TextView) (view2 == null ? null : view2.findViewById(e.j.a.providerAPR));
        LendDashboardViewModel lendDashboardViewModel = this.viewModel;
        if (lendDashboardViewModel != null) {
            textView.setText(lendDashboardViewModel.getSelectedItemDescription());
            View view3 = getView();
            BottomSheetBehavior.I(view3 != null ? view3.findViewById(e.j.a.lendBottomSheet) : null).S(3);
            return;
        }
        m.w("viewModel");
        throw null;
    }

    @Override // com.coinbase.wallet.commonui.views.BaseFragment
    public void _$_clearFindViewByIdCache() {
    }

    @Override // com.coinbase.wallet.commonui.views.StyledFragment
    public d0 applyWindowInsets(View view, d0 insets) {
        m.g(view, "view");
        m.g(insets, "insets");
        if (this.hasAppliedInsets) {
            return insets;
        }
        View view2 = getView();
        View lendBottomSheet = view2 == null ? null : view2.findViewById(e.j.a.lendBottomSheet);
        m.f(lendBottomSheet, "lendBottomSheet");
        lendBottomSheet.setPadding(lendBottomSheet.getPaddingLeft(), lendBottomSheet.getPaddingTop(), lendBottomSheet.getPaddingRight(), insets.i());
        View view3 = getView();
        View earnMore = view3 != null ? view3.findViewById(e.j.a.earnMore) : null;
        m.f(earnMore, "earnMore");
        ViewGroup.LayoutParams layoutParams = earnMore.getLayoutParams();
        Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        marginLayoutParams.bottomMargin += insets.i();
        earnMore.setLayoutParams(marginLayoutParams);
        this.hasAppliedInsets = true;
        return insets;
    }

    @Override // com.coinbase.wallet.commonui.views.StyledFragment
    public StyledFragment.Attributes getAttributes() {
        return (StyledFragment.Attributes) this.attributes$delegate.getValue();
    }

    public final Boolean getTransitionedToStart() {
        return this.transitionedToStart;
    }

    public final GenericViewModelFactory<LendDashboardViewModel> getViewModelFactory() {
        GenericViewModelFactory<LendDashboardViewModel> genericViewModelFactory = this.viewModelFactory;
        if (genericViewModelFactory != null) {
            return genericViewModelFactory;
        }
        m.w("viewModelFactory");
        throw null;
    }

    @Override // com.coinbase.wallet.commonui.views.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Analytics.INSTANCE.log(AnalyticsEvent_ApplicationKt.lendDashboardLanded(AnalyticsEvent.Companion));
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        m.g(inflater, "inflater");
        return inflater.inflate(R.layout.fragment_lend_dashboard, viewGroup, false);
    }

    @Override // com.coinbase.wallet.commonui.views.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        m.g(view, "view");
        super.onViewCreated(view, bundle);
        this.hasAppliedInsets = false;
        b0 a = new androidx.lifecycle.d0(this, getViewModelFactory()).a(LendDashboardViewModel.class);
        m.f(a, "ViewModelProvider(this, viewModelFactory).get(T::class.java)");
        LendDashboardViewModel lendDashboardViewModel = (LendDashboardViewModel) a;
        this.viewModel = lendDashboardViewModel;
        if (lendDashboardViewModel != null) {
            Object as = Observable_AnalyticsKt.logError$default(lendDashboardViewModel.getNavigationObservable(), null, null, 3, null).as(com.uber.autodispose.d.a(getScopeProvider()));
            m.f(as, "viewModel.navigationObservable\n            .logError()\n            .`as`(AutoDispose.autoDisposable(scopeProvider))");
            ObservableSubscribeProxy_CommonKt.subscribeBy$default((x) as, null, null, new LendDashboardFragment$onViewCreated$1(this), 3, null);
            LendDashboardViewModel lendDashboardViewModel2 = this.viewModel;
            if (lendDashboardViewModel2 != null) {
                Object as2 = Observable_AnalyticsKt.logError$default(lendDashboardViewModel2.getDismissObservable(), null, null, 3, null).observeOn(getMainScheduler()).as(com.uber.autodispose.d.a(getScopeProvider()));
                m.f(as2, "viewModel.dismissObservable\n            .logError()\n            .observeOn(mainScheduler)\n            .`as`(AutoDispose.autoDisposable(scopeProvider))");
                ObservableSubscribeProxy_CommonKt.subscribeBy$default((x) as2, null, null, new LendDashboardFragment$onViewCreated$2(this), 3, null);
                final a0 a0Var = new a0();
                LendDashboardViewModel lendDashboardViewModel3 = this.viewModel;
                if (lendDashboardViewModel3 != null) {
                    s<List<LendDashboardItem>> doOnNext = lendDashboardViewModel3.getDataUpdatedObservable().doOnSubscribe(new f() { // from class: com.coinbase.wallet.features.lend.views.c
                        @Override // h.c.m0.f
                        public final void accept(Object obj) {
                            LendDashboardFragment.e((h.c.k0.b) obj);
                        }
                    }).doOnError(new f() { // from class: com.coinbase.wallet.features.lend.views.a
                        @Override // h.c.m0.f
                        public final void accept(Object obj) {
                            LendDashboardFragment.d(a0.this, (Throwable) obj);
                        }
                    }).doOnNext(new f() { // from class: com.coinbase.wallet.features.lend.views.d
                        @Override // h.c.m0.f
                        public final void accept(Object obj) {
                            LendDashboardFragment.f(a0.this, (List) obj);
                        }
                    });
                    m.f(doOnNext, "viewModel.dataUpdatedObservable\n            .doOnSubscribe {\n                Tracer.start(TraceKey.loadLendDashboardKey)\n            }\n            .doOnError {\n                if (!hasLoadedFirstDataset) Tracer.stop(TraceKey.loadLendDashboardKey)\n                hasLoadedFirstDataset = true\n            }\n            .doOnNext {\n                if (!hasLoadedFirstDataset) Tracer.stop(TraceKey.loadLendDashboardKey)\n                hasLoadedFirstDataset = true\n            }");
                    Object as3 = Observable_AnalyticsKt.logError$default(doOnNext, null, null, 3, null).as(com.uber.autodispose.d.a(getScopeProvider()));
                    m.f(as3, "viewModel.dataUpdatedObservable\n            .doOnSubscribe {\n                Tracer.start(TraceKey.loadLendDashboardKey)\n            }\n            .doOnError {\n                if (!hasLoadedFirstDataset) Tracer.stop(TraceKey.loadLendDashboardKey)\n                hasLoadedFirstDataset = true\n            }\n            .doOnNext {\n                if (!hasLoadedFirstDataset) Tracer.stop(TraceKey.loadLendDashboardKey)\n                hasLoadedFirstDataset = true\n            }\n            .logError()\n            .`as`(AutoDispose.autoDisposable(scopeProvider))");
                    ObservableSubscribeProxy_CommonKt.subscribeBy$default((x) as3, null, null, new LendDashboardFragment$onViewCreated$6(this), 3, null);
                    LendDashboardViewModel lendDashboardViewModel4 = this.viewModel;
                    if (lendDashboardViewModel4 != null) {
                        Object as4 = Observable_AnalyticsKt.logError$default(lendDashboardViewModel4.setup(), null, null, 3, null).observeOn(getMainScheduler()).as(com.uber.autodispose.d.a(getScopeProvider()));
                        m.f(as4, "viewModel.setup()\n            .logError()\n            .observeOn(mainScheduler)\n            .`as`(AutoDispose.autoDisposable(scopeProvider))");
                        ObservableSubscribeProxy_CommonKt.subscribeBy$default((x) as4, null, null, null, 7, null);
                        LendDashboardViewModel lendDashboardViewModel5 = this.viewModel;
                        if (lendDashboardViewModel5 != null) {
                            Object as5 = Observable_AnalyticsKt.logError$default(lendDashboardViewModel5.getStateObservable(), null, null, 3, null).as(com.uber.autodispose.d.a(getScopeProvider()));
                            m.f(as5, "viewModel.stateObservable\n            .logError()\n            .`as`(AutoDispose.autoDisposable(scopeProvider))");
                            ObservableSubscribeProxy_CommonKt.subscribeBy$default((x) as5, null, null, new LendDashboardFragment$onViewCreated$7(this), 3, null);
                            View view2 = getView();
                            ((RecyclerView) (view2 == null ? null : view2.findViewById(e.j.a.dashboardList))).setAdapter(getAdapter());
                            final LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
                            View view3 = getView();
                            ((RecyclerView) (view3 == null ? null : view3.findViewById(e.j.a.dashboardList))).setLayoutManager(linearLayoutManager);
                            View view4 = getView();
                            ((RecyclerView) (view4 == null ? null : view4.findViewById(e.j.a.dashboardList))).addOnScrollListener(new RecyclerView.t() { // from class: com.coinbase.wallet.features.lend.views.LendDashboardFragment$onViewCreated$8
                                @Override // androidx.recyclerview.widget.RecyclerView.t
                                public void onScrolled(RecyclerView recyclerView, int i2, int i3) {
                                    m.g(recyclerView, "recyclerView");
                                    View S = LinearLayoutManager.this.S(0);
                                    float transitionPercent = S == null ? 1.0f : LendDashboardFragmentKt.getTransitionPercent(S);
                                    if ((transitionPercent > 0.0f && i3 > 0) || LinearLayoutManager.this.h2() > 0) {
                                        Boolean transitionedToStart = this.getTransitionedToStart();
                                        Boolean bool = Boolean.FALSE;
                                        if (!m.c(transitionedToStart, bool)) {
                                            View view5 = this.getView();
                                            ((MotionLayout) (view5 != null ? view5.findViewById(e.j.a.T6) : null)).transitionToEnd();
                                        }
                                        this.setTransitionedToStart(bool);
                                        return;
                                    }
                                    if (!(transitionPercent == 0.0f) || i3 >= 0) {
                                        return;
                                    }
                                    Boolean transitionedToStart2 = this.getTransitionedToStart();
                                    Boolean bool2 = Boolean.TRUE;
                                    if (!m.c(transitionedToStart2, bool2)) {
                                        View view6 = this.getView();
                                        ((MotionLayout) (view6 != null ? view6.findViewById(e.j.a.T6) : null)).transitionToStart();
                                    }
                                    this.setTransitionedToStart(bool2);
                                }
                            });
                            View view5 = getView();
                            View closeButton = view5 == null ? null : view5.findViewById(e.j.a.t0);
                            m.f(closeButton, "closeButton");
                            View_CommonKt.setOnSingleClickListener$default(closeButton, 0L, new LendDashboardFragment$onViewCreated$9(this), 1, null);
                            View view6 = getView();
                            View earnMore = view6 == null ? null : view6.findViewById(e.j.a.earnMore);
                            m.f(earnMore, "earnMore");
                            View_CommonKt.setOnSingleClickListener$default(earnMore, 0L, new LendDashboardFragment$onViewCreated$10(this), 1, null);
                            View view7 = getView();
                            View lendMoreButton = view7 == null ? null : view7.findViewById(e.j.a.lendMoreButton);
                            m.f(lendMoreButton, "lendMoreButton");
                            View_CommonKt.setOnSingleClickListener$default(lendMoreButton, 0L, new LendDashboardFragment$onViewCreated$11(this), 1, null);
                            View view8 = getView();
                            View withdrawButton = view8 == null ? null : view8.findViewById(e.j.a.withdrawButton);
                            m.f(withdrawButton, "withdrawButton");
                            View_CommonKt.setOnSingleClickListener$default(withdrawButton, 0L, new LendDashboardFragment$onViewCreated$12(this), 1, null);
                            int d2 = e.j.f.m.d(this, R.dimen.view_size_16);
                            View view9 = getView();
                            View earnMore2 = view9 == null ? null : view9.findViewById(e.j.a.earnMore);
                            m.f(earnMore2, "earnMore");
                            View_CommonKt.setRippleForeground$default(earnMore2, d2, null, 2, null);
                            View view10 = getView();
                            BottomSheetBehavior.I(view10 == null ? null : view10.findViewById(e.j.a.lendBottomSheet)).N(new LendDashboardFragment$onViewCreated$13(this));
                            View view11 = getView();
                            View toolbar = view11 == null ? null : view11.findViewById(e.j.a.T6);
                            m.f(toolbar, "toolbar");
                            View_CommonKt.setOnSingleClickListener$default(toolbar, 0L, LendDashboardFragment$onViewCreated$14.INSTANCE, 1, null);
                            if (m.c(this.transitionedToStart, Boolean.FALSE)) {
                                View view12 = getView();
                                ((MotionLayout) (view12 != null ? view12.findViewById(e.j.a.T6) : null)).transitionToEnd();
                            }
                            hideLendingActionSheet();
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
        m.w("viewModel");
        throw null;
    }

    public final void setTransitionedToStart(Boolean bool) {
        this.transitionedToStart = bool;
    }

    public final void setViewModelFactory(GenericViewModelFactory<LendDashboardViewModel> genericViewModelFactory) {
        m.g(genericViewModelFactory, "<set-?>");
        this.viewModelFactory = genericViewModelFactory;
    }
}