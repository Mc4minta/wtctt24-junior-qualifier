package com.toshi.view.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.appsflyer.share.Constants;
import com.coinbase.wallet.analytics.Analytics;
import com.coinbase.wallet.analytics.extensions.Single_AnalyticsKt;
import com.coinbase.wallet.analytics.models.AnalyticsEvent;
import com.coinbase.wallet.application.extensions.AnalyticsEvent_ApplicationKt;
import com.coinbase.wallet.common.extensions.ObservableSubscribeProxy_CommonKt;
import com.coinbase.wallet.common.extensions.SingleSubscribeProxy_CommonKt;
import com.coinbase.wallet.commonui.di.GenericViewModelFactory;
import com.coinbase.wallet.commonui.extensions.Fragment_CommonKt;
import com.coinbase.wallet.commonui.extensions.View_CommonKt;
import com.coinbase.wallet.commonui.utilities.FragmentLifecycleScopeProvider;
import com.coinbase.wallet.commonui.utilities.PromptDialogHelper;
import com.coinbase.wallet.commonui.views.BackableFragment;
import com.coinbase.wallet.commonui.views.LockedFragment;
import com.coinbase.wallet.commonui.views.StyledFragment;
import com.coinbase.wallet.core.extensions.Observable_CoreKt;
import com.coinbase.wallet.ethereum.extensions.Network_EthereumKt;
import com.coinbase.wallet.features.applock.legacy.AuthenticationHelper;
import e.j.n.q2;
import e.j.n.r2;
import e.j.n.s2;
import java.util.List;
import kotlin.Metadata;
import org.toshi.R;

/* compiled from: NetworkSwitcherFragment.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0007¢\u0006\u0004\bD\u0010\u0006J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u000b\u0010\u0006J\u000f\u0010\f\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\f\u0010\u0006J\u000f\u0010\r\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\r\u0010\u0006J-\u0010\u0015\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J!\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u00142\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001a\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u001a\u0010\u0006J\u000f\u0010\u001c\u001a\u00020\u001bH\u0016¢\u0006\u0004\b\u001c\u0010\u001dR\u0016\u0010!\u001a\u00020\u001e8V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010 R\u0016\u0010%\u001a\u00020\"8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b#\u0010$R\u0016\u0010)\u001a\u00020&8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b'\u0010(R(\u00101\u001a\b\u0012\u0004\u0012\u00020\"0*8\u0000@\u0000X\u0081.¢\u0006\u0012\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\"\u00109\u001a\u0002028\u0000@\u0000X\u0081.¢\u0006\u0012\n\u0004\b3\u00104\u001a\u0004\b5\u00106\"\u0004\b7\u00108R\u0016\u0010=\u001a\u00020:8B@\u0002X\u0082\u0004¢\u0006\u0006\u001a\u0004\b;\u0010<R\u001d\u0010C\u001a\u00020>8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b?\u0010@\u001a\u0004\bA\u0010B¨\u0006E"}, d2 = {"Lcom/toshi/view/fragment/NetworkSwitcherFragment;", "Lcom/coinbase/wallet/commonui/views/LockedFragment;", "Lcom/coinbase/wallet/commonui/views/StyledFragment;", "Lcom/coinbase/wallet/commonui/views/BackableFragment;", "Lkotlin/x;", "setupViewModel", "()V", "Le/j/n/q2;", "networkItem", "f", "(Le/j/n/q2;)V", "setupAdapter", "setupClickListeners", "setupObservers", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "onResume", "", "onBackPressed", "()Z", "Lcom/coinbase/wallet/commonui/views/StyledFragment$Attributes;", "getAttributes", "()Lcom/coinbase/wallet/commonui/views/StyledFragment$Attributes;", "attributes", "Le/j/n/s2;", "b", "Le/j/n/s2;", "viewModel", "Le/j/m/a/h;", Constants.URL_CAMPAIGN, "Le/j/m/a/h;", "networkAdapter", "Lcom/coinbase/wallet/commonui/di/GenericViewModelFactory;", "a", "Lcom/coinbase/wallet/commonui/di/GenericViewModelFactory;", "getViewModelFactory$app_productionRelease", "()Lcom/coinbase/wallet/commonui/di/GenericViewModelFactory;", "setViewModelFactory$app_productionRelease", "(Lcom/coinbase/wallet/commonui/di/GenericViewModelFactory;)V", "viewModelFactory", "Lcom/coinbase/wallet/features/applock/legacy/AuthenticationHelper;", "e", "Lcom/coinbase/wallet/features/applock/legacy/AuthenticationHelper;", "getAuthenticationHelper$app_productionRelease", "()Lcom/coinbase/wallet/features/applock/legacy/AuthenticationHelper;", "setAuthenticationHelper$app_productionRelease", "(Lcom/coinbase/wallet/features/applock/legacy/AuthenticationHelper;)V", "authenticationHelper", "Lcom/coinbase/wallet/commonui/utilities/FragmentLifecycleScopeProvider;", "getScopeProvider", "()Lcom/coinbase/wallet/commonui/utilities/FragmentLifecycleScopeProvider;", "scopeProvider", "Lh/c/a0;", "d", "Lkotlin/h;", "getMainScheduler", "()Lh/c/a0;", "mainScheduler", "<init>", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class NetworkSwitcherFragment extends LockedFragment implements StyledFragment, BackableFragment {
    public GenericViewModelFactory<s2> a;

    /* renamed from: b  reason: collision with root package name */
    private s2 f11275b;

    /* renamed from: c  reason: collision with root package name */
    private e.j.m.a.h f11276c;

    /* renamed from: d  reason: collision with root package name */
    private final kotlin.h f11277d;

    /* renamed from: e  reason: collision with root package name */
    public AuthenticationHelper f11278e;

    /* compiled from: NetworkSwitcherFragment.kt */
    /* loaded from: classes2.dex */
    static final class a extends kotlin.jvm.internal.o implements kotlin.e0.c.a<h.c.a0> {
        public static final a a = new a();

        a() {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.e0.c.a
        public final h.c.a0 invoke() {
            return h.c.j0.c.a.b();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: NetworkSwitcherFragment.kt */
    /* loaded from: classes2.dex */
    public static final class b extends kotlin.jvm.internal.o implements kotlin.e0.c.l<q2, kotlin.x> {
        b() {
            super(1);
        }

        public final void a(q2 it) {
            kotlin.jvm.internal.m.g(it, "it");
            NetworkSwitcherFragment.this.f(it);
        }

        @Override // kotlin.e0.c.l
        public /* bridge */ /* synthetic */ kotlin.x invoke(q2 q2Var) {
            a(q2Var);
            return kotlin.x.a;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: NetworkSwitcherFragment.kt */
    /* loaded from: classes2.dex */
    public static final class c extends kotlin.jvm.internal.o implements kotlin.e0.c.l<View, kotlin.x> {
        c() {
            super(1);
        }

        @Override // kotlin.e0.c.l
        public /* bridge */ /* synthetic */ kotlin.x invoke(View view) {
            invoke2(view);
            return kotlin.x.a;
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2(View it) {
            kotlin.jvm.internal.m.g(it, "it");
            Fragment_CommonKt.navigateUp(NetworkSwitcherFragment.this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: NetworkSwitcherFragment.kt */
    /* loaded from: classes2.dex */
    public static final class d extends kotlin.jvm.internal.o implements kotlin.e0.c.l<List<? extends r2>, kotlin.x> {
        d() {
            super(1);
        }

        @Override // kotlin.e0.c.l
        public /* bridge */ /* synthetic */ kotlin.x invoke(List<? extends r2> list) {
            invoke2(list);
            return kotlin.x.a;
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2(List<? extends r2> it) {
            e.j.m.a.h hVar = NetworkSwitcherFragment.this.f11276c;
            if (hVar == null) {
                kotlin.jvm.internal.m.w("networkAdapter");
                throw null;
            }
            kotlin.jvm.internal.m.f(it, "it");
            hVar.c(it);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: NetworkSwitcherFragment.kt */
    /* loaded from: classes2.dex */
    public static final class e extends kotlin.jvm.internal.o implements kotlin.e0.c.l<PromptDialogHelper.Properties, kotlin.x> {
        e() {
            super(1);
        }

        @Override // kotlin.e0.c.l
        public /* bridge */ /* synthetic */ kotlin.x invoke(PromptDialogHelper.Properties properties) {
            invoke2(properties);
            return kotlin.x.a;
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2(PromptDialogHelper.Properties it) {
            PromptDialogHelper promptDialogHelper = PromptDialogHelper.INSTANCE;
            NetworkSwitcherFragment networkSwitcherFragment = NetworkSwitcherFragment.this;
            kotlin.jvm.internal.m.f(it, "it");
            promptDialogHelper.show(networkSwitcherFragment, it);
        }
    }

    public NetworkSwitcherFragment() {
        kotlin.h b2;
        b2 = kotlin.k.b(a.a);
        this.f11277d = b2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void f(q2 q2Var) {
        Analytics.INSTANCE.log(AnalyticsEvent_ApplicationKt.networkPickerNetworkChanged(AnalyticsEvent.Companion, q2Var.a().getName(), q2Var.b().getBlockchain(), Network_EthereumKt.getAsEthereumChain(q2Var.a().getNetwork())));
        s2 s2Var = this.f11275b;
        if (s2Var != null) {
            s2Var.i(q2Var);
        } else {
            kotlin.jvm.internal.m.w("viewModel");
            throw null;
        }
    }

    private final h.c.a0 getMainScheduler() {
        Object value = this.f11277d.getValue();
        kotlin.jvm.internal.m.f(value, "<get-mainScheduler>(...)");
        return (h.c.a0) value;
    }

    private final FragmentLifecycleScopeProvider getScopeProvider() {
        return Fragment_CommonKt.getFragmentLifecycleScopeProvider$default(this, null, 1, null);
    }

    private final void setupAdapter() {
        this.f11276c = new e.j.m.a.h(new b());
        View view = getView();
        RecyclerView recyclerView = (RecyclerView) (view == null ? null : view.findViewById(e.j.a.networks));
        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
        e.j.m.a.h hVar = this.f11276c;
        if (hVar != null) {
            recyclerView.setAdapter(hVar);
            recyclerView.setItemAnimator(null);
            kotlin.jvm.internal.m.f(recyclerView, "");
            e.j.f.r.b(recyclerView, 0, 0, 0, 0, 0, 0, 63, null);
            return;
        }
        kotlin.jvm.internal.m.w("networkAdapter");
        throw null;
    }

    private final void setupClickListeners() {
        View view = getView();
        View closeButton = view == null ? null : view.findViewById(e.j.a.t0);
        kotlin.jvm.internal.m.f(closeButton, "closeButton");
        View_CommonKt.setOnSingleClickListener$default(closeButton, 0L, new c(), 1, null);
    }

    private final void setupObservers() {
        s2 s2Var = this.f11275b;
        if (s2Var != null) {
            h.c.b0 observeOn = Observable_CoreKt.takeSingle(s2Var.d()).observeOn(getMainScheduler());
            kotlin.jvm.internal.m.f(observeOn, "viewModel.observeNetworks()\n            .takeSingle()\n            .observeOn(mainScheduler)");
            Object as = Single_AnalyticsKt.logError$default(observeOn, "Couldn't get networks.", null, 2, null).as(com.uber.autodispose.d.a(getScopeProvider()));
            kotlin.jvm.internal.m.f(as, "viewModel.observeNetworks()\n            .takeSingle()\n            .observeOn(mainScheduler)\n            .logError(\"Couldn't get networks.\")\n            .`as`(autoDisposable(scopeProvider))");
            SingleSubscribeProxy_CommonKt.subscribeBy$default((com.uber.autodispose.a0) as, null, new d(), 1, null);
            s2 s2Var2 = this.f11275b;
            if (s2Var2 != null) {
                Object as2 = s2Var2.getPromptObservable().observeOn(getMainScheduler()).as(com.uber.autodispose.d.a(getScopeProvider()));
                kotlin.jvm.internal.m.f(as2, "viewModel.promptObservable\n            .observeOn(mainScheduler)\n            .`as`(autoDisposable(scopeProvider))");
                ObservableSubscribeProxy_CommonKt.subscribeBy$default((com.uber.autodispose.x) as2, null, null, new e(), 3, null);
                return;
            }
            kotlin.jvm.internal.m.w("viewModel");
            throw null;
        }
        kotlin.jvm.internal.m.w("viewModel");
        throw null;
    }

    private final void setupViewModel() {
        androidx.lifecycle.b0 a2 = new androidx.lifecycle.d0(this, getViewModelFactory$app_productionRelease()).a(s2.class);
        kotlin.jvm.internal.m.f(a2, "ViewModelProvider(this, viewModelFactory).get(T::class.java)");
        this.f11275b = (s2) a2;
    }

    @Override // com.coinbase.wallet.commonui.views.LockedFragment, com.coinbase.wallet.commonui.views.BaseFragment
    public void _$_clearFindViewByIdCache() {
    }

    @Override // com.coinbase.wallet.commonui.views.StyledFragment
    public c.h.k.d0 applyWindowInsets(View view, c.h.k.d0 d0Var) {
        return StyledFragment.DefaultImpls.applyWindowInsets(this, view, d0Var);
    }

    @Override // com.coinbase.wallet.commonui.views.StyledFragment
    public StyledFragment.Attributes getAttributes() {
        return StyledFragment.Attributes.copy$default(StyledFragment.DefaultImpls.getAttributes(this), false, true, false, 5, null);
    }

    public final AuthenticationHelper getAuthenticationHelper$app_productionRelease() {
        AuthenticationHelper authenticationHelper = this.f11278e;
        if (authenticationHelper != null) {
            return authenticationHelper;
        }
        kotlin.jvm.internal.m.w("authenticationHelper");
        throw null;
    }

    public final GenericViewModelFactory<s2> getViewModelFactory$app_productionRelease() {
        GenericViewModelFactory<s2> genericViewModelFactory = this.a;
        if (genericViewModelFactory != null) {
            return genericViewModelFactory;
        }
        kotlin.jvm.internal.m.w("viewModelFactory");
        throw null;
    }

    @Override // com.coinbase.wallet.commonui.views.BackableFragment
    public boolean onBackPressed() {
        return Fragment_CommonKt.navigateUp(this);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        kotlin.jvm.internal.m.g(inflater, "inflater");
        return inflater.inflate(R.layout.fragment_network_switcher, viewGroup, false);
    }

    @Override // com.coinbase.wallet.commonui.views.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        Analytics.INSTANCE.log(AnalyticsEvent_ApplicationKt.networkPickerLanded(AnalyticsEvent.Companion));
    }

    @Override // com.coinbase.wallet.commonui.views.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        kotlin.jvm.internal.m.g(view, "view");
        super.onViewCreated(view, bundle);
        e.j.f.m.o(this, getAuthenticationHelper$app_productionRelease());
        setupViewModel();
        setupAdapter();
        setupClickListeners();
        setupObservers();
    }
}