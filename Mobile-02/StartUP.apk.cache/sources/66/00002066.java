package com.coinbase.wallet.features.send.views;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.coinbase.wallet.analytics.Analytics;
import com.coinbase.wallet.analytics.models.AnalyticsEvent;
import com.coinbase.wallet.application.extensions.AnalyticsEvent_ApplicationKt;
import com.coinbase.wallet.common.extensions.ObservableSubscribeProxy_CommonKt;
import com.coinbase.wallet.common.extensions.SingleSubscribeProxy_CommonKt;
import com.coinbase.wallet.commonui.di.GenericViewModelFactory;
import com.coinbase.wallet.commonui.extensions.Fragment_CommonKt;
import com.coinbase.wallet.commonui.extensions.View_CommonKt;
import com.coinbase.wallet.commonui.utilities.FragmentLifecycleScopeProvider;
import com.coinbase.wallet.commonui.views.DaggerBottomSheetDialogFragment;
import com.coinbase.wallet.features.send.viewmodels.AdjustableMinerFeeSharedViewModel;
import com.coinbase.wallet.features.send.viewmodels.AdjustableMinerFeeViewModel;
import com.coinbase.wallet.features.send.views.adapters.AdjustableMinerFeePresetAdapter;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.toshi.R;

/* compiled from: AdjustableMinerFeeFragment.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 .2\u00020\u0001:\u0001.B\u0007¢\u0006\u0004\b-\u0010\u0010J-\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ!\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\r\u0010\u000eJ\r\u0010\u000f\u001a\u00020\f¢\u0006\u0004\b\u000f\u0010\u0010R(\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u00118\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001c\u001a\u00020\u00198B@\u0002X\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001bR\u001d\u0010\"\u001a\u00020\u001d8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!R\u0016\u0010$\u001a\u00020#8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b$\u0010%R\"\u0010'\u001a\u00020&8\u0000@\u0000X\u0081.¢\u0006\u0012\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,¨\u0006/"}, d2 = {"Lcom/coinbase/wallet/features/send/views/AdjustableMinerFeeFragment;", "Lcom/coinbase/wallet/commonui/views/DaggerBottomSheetDialogFragment;", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "Lkotlin/x;", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "setupViewModel", "()V", "Lcom/coinbase/wallet/commonui/di/GenericViewModelFactory;", "Lcom/coinbase/wallet/features/send/viewmodels/AdjustableMinerFeeSharedViewModel;", "adjustableMinerFeeSharedFactory", "Lcom/coinbase/wallet/commonui/di/GenericViewModelFactory;", "getAdjustableMinerFeeSharedFactory", "()Lcom/coinbase/wallet/commonui/di/GenericViewModelFactory;", "setAdjustableMinerFeeSharedFactory", "(Lcom/coinbase/wallet/commonui/di/GenericViewModelFactory;)V", "Lcom/coinbase/wallet/commonui/utilities/FragmentLifecycleScopeProvider;", "getScopeProvider", "()Lcom/coinbase/wallet/commonui/utilities/FragmentLifecycleScopeProvider;", "scopeProvider", "Lcom/coinbase/wallet/features/send/viewmodels/AdjustableMinerFeeViewModel;", "viewModel$delegate", "Lkotlin/h;", "getViewModel", "()Lcom/coinbase/wallet/features/send/viewmodels/AdjustableMinerFeeViewModel;", "viewModel", "Lcom/coinbase/wallet/features/send/views/adapters/AdjustableMinerFeePresetAdapter;", "adjustableAdjustableMinerFeeAdapter", "Lcom/coinbase/wallet/features/send/views/adapters/AdjustableMinerFeePresetAdapter;", "Lcom/coinbase/wallet/features/send/viewmodels/AdjustableMinerFeeViewModel$Factory;", "viewModelFactory", "Lcom/coinbase/wallet/features/send/viewmodels/AdjustableMinerFeeViewModel$Factory;", "getViewModelFactory$app_productionRelease", "()Lcom/coinbase/wallet/features/send/viewmodels/AdjustableMinerFeeViewModel$Factory;", "setViewModelFactory$app_productionRelease", "(Lcom/coinbase/wallet/features/send/viewmodels/AdjustableMinerFeeViewModel$Factory;)V", "<init>", "Companion", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class AdjustableMinerFeeFragment extends DaggerBottomSheetDialogFragment {
    public static final Companion Companion = new Companion(null);
    private static final String TAG;
    private AdjustableMinerFeePresetAdapter adjustableAdjustableMinerFeeAdapter;
    public GenericViewModelFactory<AdjustableMinerFeeSharedViewModel> adjustableMinerFeeSharedFactory;
    private final kotlin.h viewModel$delegate = androidx.fragment.app.z.a(this, kotlin.jvm.internal.e0.b(AdjustableMinerFeeViewModel.class), new AdjustableMinerFeeFragment$special$$inlined$viewModel$3(new AdjustableMinerFeeFragment$special$$inlined$viewModel$2(this)), new AdjustableMinerFeeFragment$special$$inlined$viewModel$1(this, this));
    public AdjustableMinerFeeViewModel.Factory viewModelFactory;

    /* compiled from: AdjustableMinerFeeFragment.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0019\u0010\u0003\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/coinbase/wallet/features/send/views/AdjustableMinerFeeFragment$Companion;", "", "", "TAG", "Ljava/lang/String;", "getTAG", "()Ljava/lang/String;", "<init>", "()V", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final String getTAG() {
            return AdjustableMinerFeeFragment.TAG;
        }
    }

    static {
        String simpleName = AdjustableMinerFeeFragment.class.getSimpleName();
        kotlin.jvm.internal.m.f(simpleName, "AdjustableMinerFeeFragment::class.java.simpleName");
        TAG = simpleName;
    }

    public static /* synthetic */ void d(AdjustableMinerFeeFragment adjustableMinerFeeFragment, h.c.k0.b bVar) {
        m1385setupViewModel$lambda1(adjustableMinerFeeFragment, bVar);
    }

    public static /* synthetic */ void e(AdjustableMinerFeeFragment adjustableMinerFeeFragment, Throwable th) {
        m1386setupViewModel$lambda2(adjustableMinerFeeFragment, th);
    }

    public final FragmentLifecycleScopeProvider getScopeProvider() {
        return Fragment_CommonKt.getFragmentLifecycleScopeProvider$default(this, null, 1, null);
    }

    public final AdjustableMinerFeeViewModel getViewModel() {
        return (AdjustableMinerFeeViewModel) this.viewModel$delegate.getValue();
    }

    /* renamed from: setupViewModel$lambda-1 */
    public static final void m1385setupViewModel$lambda1(AdjustableMinerFeeFragment this$0, h.c.k0.b bVar) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        View view = this$0.getView();
        View minerFeePresetList = view == null ? null : view.findViewById(e.j.a.minerFeePresetList);
        kotlin.jvm.internal.m.f(minerFeePresetList, "minerFeePresetList");
        minerFeePresetList.setVisibility(0);
        View view2 = this$0.getView();
        View retryButton = view2 == null ? null : view2.findViewById(e.j.a.retryButton);
        kotlin.jvm.internal.m.f(retryButton, "retryButton");
        retryButton.setVisibility(8);
        View view3 = this$0.getView();
        View errorText = view3 != null ? view3.findViewById(e.j.a.errorText) : null;
        kotlin.jvm.internal.m.f(errorText, "errorText");
        errorText.setVisibility(8);
    }

    /* renamed from: setupViewModel$lambda-2 */
    public static final void m1386setupViewModel$lambda2(AdjustableMinerFeeFragment this$0, Throwable th) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        View view = this$0.getView();
        View minerFeePresetList = view == null ? null : view.findViewById(e.j.a.minerFeePresetList);
        kotlin.jvm.internal.m.f(minerFeePresetList, "minerFeePresetList");
        minerFeePresetList.setVisibility(8);
        View view2 = this$0.getView();
        View retryButton = view2 == null ? null : view2.findViewById(e.j.a.retryButton);
        kotlin.jvm.internal.m.f(retryButton, "retryButton");
        retryButton.setVisibility(0);
        View view3 = this$0.getView();
        View errorText = view3 != null ? view3.findViewById(e.j.a.errorText) : null;
        kotlin.jvm.internal.m.f(errorText, "errorText");
        errorText.setVisibility(0);
        Analytics analytics = Analytics.INSTANCE;
        AnalyticsEvent.Companion companion = AnalyticsEvent.Companion;
        String message = th.getMessage();
        if (message == null) {
            message = "";
        }
        analytics.log(AnalyticsEvent_ApplicationKt.adjustableMinerFeeErrorReturned(companion, message));
    }

    @Override // com.coinbase.wallet.commonui.views.DaggerBottomSheetDialogFragment
    public void _$_clearFindViewByIdCache() {
    }

    public final GenericViewModelFactory<AdjustableMinerFeeSharedViewModel> getAdjustableMinerFeeSharedFactory() {
        GenericViewModelFactory<AdjustableMinerFeeSharedViewModel> genericViewModelFactory = this.adjustableMinerFeeSharedFactory;
        if (genericViewModelFactory != null) {
            return genericViewModelFactory;
        }
        kotlin.jvm.internal.m.w("adjustableMinerFeeSharedFactory");
        throw null;
    }

    public final AdjustableMinerFeeViewModel.Factory getViewModelFactory$app_productionRelease() {
        AdjustableMinerFeeViewModel.Factory factory = this.viewModelFactory;
        if (factory != null) {
            return factory;
        }
        kotlin.jvm.internal.m.w("viewModelFactory");
        throw null;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        kotlin.jvm.internal.m.g(inflater, "inflater");
        return inflater.inflate(R.layout.fragment_adjustable_miner_fee, viewGroup, false);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        kotlin.jvm.internal.m.g(view, "view");
        super.onViewCreated(view, bundle);
        View view2 = getView();
        View closeButton = view2 == null ? null : view2.findViewById(e.j.a.t0);
        kotlin.jvm.internal.m.f(closeButton, "closeButton");
        View_CommonKt.setOnSingleClickListener$default(closeButton, 0L, new AdjustableMinerFeeFragment$onViewCreated$1(this), 1, null);
        View view3 = getView();
        View retryButton = view3 == null ? null : view3.findViewById(e.j.a.retryButton);
        kotlin.jvm.internal.m.f(retryButton, "retryButton");
        View_CommonKt.setOnSingleClickListener$default(retryButton, 0L, new AdjustableMinerFeeFragment$onViewCreated$2(this), 1, null);
        AdjustableMinerFeePresetAdapter adjustableMinerFeePresetAdapter = new AdjustableMinerFeePresetAdapter(new AdjustableMinerFeeFragment$onViewCreated$3(this), new AdjustableMinerFeeFragment$onViewCreated$4(this), new AdjustableMinerFeeFragment$onViewCreated$5(this, view));
        this.adjustableAdjustableMinerFeeAdapter = adjustableMinerFeePresetAdapter;
        if (adjustableMinerFeePresetAdapter != null) {
            adjustableMinerFeePresetAdapter.setHasStableIds(true);
            View view4 = getView();
            RecyclerView recyclerView = (RecyclerView) (view4 == null ? null : view4.findViewById(e.j.a.minerFeePresetList));
            AdjustableMinerFeePresetAdapter adjustableMinerFeePresetAdapter2 = this.adjustableAdjustableMinerFeeAdapter;
            if (adjustableMinerFeePresetAdapter2 != null) {
                recyclerView.setAdapter(adjustableMinerFeePresetAdapter2);
                View view5 = getView();
                ((RecyclerView) (view5 != null ? view5.findViewById(e.j.a.minerFeePresetList) : null)).setLayoutManager(new LinearLayoutManager(getContext()));
                Object as = getViewModel().getStateObservable().as(com.uber.autodispose.d.a(getScopeProvider()));
                kotlin.jvm.internal.m.f(as, "viewModel\n            .stateObservable\n            .`as`(autoDisposable(scopeProvider))");
                ObservableSubscribeProxy_CommonKt.subscribeBy$default((com.uber.autodispose.x) as, null, null, new AdjustableMinerFeeFragment$onViewCreated$6(this), 3, null);
                Object as2 = getViewModel().getDismissObservable().as(com.uber.autodispose.d.a(getScopeProvider()));
                kotlin.jvm.internal.m.f(as2, "viewModel\n            .dismissObservable\n            .`as`(autoDisposable(scopeProvider))");
                ObservableSubscribeProxy_CommonKt.subscribeBy$default((com.uber.autodispose.x) as2, null, null, new AdjustableMinerFeeFragment$onViewCreated$7(this), 3, null);
                setupViewModel();
                return;
            }
            kotlin.jvm.internal.m.w("adjustableAdjustableMinerFeeAdapter");
            throw null;
        }
        kotlin.jvm.internal.m.w("adjustableAdjustableMinerFeeAdapter");
        throw null;
    }

    public final void setAdjustableMinerFeeSharedFactory(GenericViewModelFactory<AdjustableMinerFeeSharedViewModel> genericViewModelFactory) {
        kotlin.jvm.internal.m.g(genericViewModelFactory, "<set-?>");
        this.adjustableMinerFeeSharedFactory = genericViewModelFactory;
    }

    public final void setViewModelFactory$app_productionRelease(AdjustableMinerFeeViewModel.Factory factory) {
        kotlin.jvm.internal.m.g(factory, "<set-?>");
        this.viewModelFactory = factory;
    }

    public final void setupViewModel() {
        Object as = getViewModel().setup().doOnSubscribe(new h.c.m0.f() { // from class: com.coinbase.wallet.features.send.views.c
            @Override // h.c.m0.f
            public final void accept(Object obj) {
                AdjustableMinerFeeFragment.d(AdjustableMinerFeeFragment.this, (h.c.k0.b) obj);
            }
        }).doOnError(new h.c.m0.f() { // from class: com.coinbase.wallet.features.send.views.d
            @Override // h.c.m0.f
            public final void accept(Object obj) {
                AdjustableMinerFeeFragment.e(AdjustableMinerFeeFragment.this, (Throwable) obj);
            }
        }).as(com.uber.autodispose.d.a(getScopeProvider()));
        kotlin.jvm.internal.m.f(as, "viewModel\n            .setup()\n            .doOnSubscribe {\n                minerFeePresetList.isVisible = true\n                retryButton.isVisible = false\n                errorText.isVisible = false\n            }\n            .doOnError {\n                minerFeePresetList.isVisible = false\n                retryButton.isVisible = true\n                errorText.isVisible = true\n\n                Analytics.log(AnalyticsEvent.adjustableMinerFeeErrorReturned(it.message ?: \"\"))\n            }\n            .`as`(autoDisposable(scopeProvider))");
        SingleSubscribeProxy_CommonKt.subscribeBy$default((com.uber.autodispose.a0) as, null, new AdjustableMinerFeeFragment$setupViewModel$3(this), 1, null);
    }
}