package com.toshi.view.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.appsflyer.share.Constants;
import com.coinbase.wallet.analytics.extensions.Observable_AnalyticsKt;
import com.coinbase.wallet.commonui.di.GenericViewModelFactory;
import com.coinbase.wallet.commonui.extensions.Fragment_CommonKt;
import com.coinbase.wallet.commonui.extensions.View_CommonKt;
import com.coinbase.wallet.commonui.utilities.FragmentLifecycleScopeProvider;
import com.coinbase.wallet.commonui.views.BackableFragment;
import com.coinbase.wallet.commonui.views.LockedFragment;
import com.coinbase.wallet.commonui.views.StyledFragment;
import e.j.n.u1;
import kotlin.Metadata;
import org.toshi.R;

/* compiled from: AdvancedSettingsFragment.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0007¢\u0006\u0004\b9\u0010\u0006J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\b\u0010\u0006J\u000f\u0010\t\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\t\u0010\u0006J\u000f\u0010\n\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\n\u0010\u0006J\u0017\u0010\r\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\r\u0010\u000eJ-\u0010\u0016\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J!\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u00152\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u001b\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u001b\u0010\u001cR\u0016\u0010 \u001a\u00020\u001d8V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001fR\u0016\u0010$\u001a\u00020!8B@\u0002X\u0082\u0004¢\u0006\u0006\u001a\u0004\b\"\u0010#R\u0016\u0010(\u001a\u00020%8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b&\u0010'R(\u0010/\u001a\b\u0012\u0004\u0012\u00020%0)8\u0000@\u0000X\u0081.¢\u0006\u0012\n\u0004\b\t\u0010*\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\u001e\u00104\u001a\n 1*\u0004\u0018\u000100008\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b2\u00103R\u0016\u00108\u001a\u0002058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b6\u00107¨\u0006:"}, d2 = {"Lcom/toshi/view/fragment/AdvancedSettingsFragment;", "Lcom/coinbase/wallet/commonui/views/LockedFragment;", "Lcom/coinbase/wallet/commonui/views/StyledFragment;", "Lcom/coinbase/wallet/commonui/views/BackableFragment;", "Lkotlin/x;", "init", "()V", "initViewModel", "initClickListeners", "d", "initObservers", "", "isDebuggable", "k", "(Z)V", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "onBackPressed", "()Z", "Lcom/coinbase/wallet/commonui/views/StyledFragment$Attributes;", "getAttributes", "()Lcom/coinbase/wallet/commonui/views/StyledFragment$Attributes;", "attributes", "Lcom/coinbase/wallet/commonui/utilities/FragmentLifecycleScopeProvider;", "getScopeProvider", "()Lcom/coinbase/wallet/commonui/utilities/FragmentLifecycleScopeProvider;", "scopeProvider", "Le/j/n/u1;", "b", "Le/j/n/u1;", "viewModel", "Lcom/coinbase/wallet/commonui/di/GenericViewModelFactory;", "Lcom/coinbase/wallet/commonui/di/GenericViewModelFactory;", "getViewModelFactory$app_productionRelease", "()Lcom/coinbase/wallet/commonui/di/GenericViewModelFactory;", "setViewModelFactory$app_productionRelease", "(Lcom/coinbase/wallet/commonui/di/GenericViewModelFactory;)V", "viewModelFactory", "Lh/c/a0;", "kotlin.jvm.PlatformType", "a", "Lh/c/a0;", "mainScheduler", "", Constants.URL_CAMPAIGN, "I", "developMessageClicks", "<init>", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class AdvancedSettingsFragment extends LockedFragment implements StyledFragment, BackableFragment {
    private final h.c.a0 a = h.c.j0.c.a.b();

    /* renamed from: b */
    private u1 f11230b;

    /* renamed from: c */
    private int f11231c;

    /* renamed from: d */
    public GenericViewModelFactory<u1> f11232d;

    /* compiled from: AdvancedSettingsFragment.kt */
    /* loaded from: classes2.dex */
    public static final class a extends kotlin.jvm.internal.o implements kotlin.e0.c.l<View, kotlin.x> {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a() {
            super(1);
            AdvancedSettingsFragment.this = r1;
        }

        @Override // kotlin.e0.c.l
        public /* bridge */ /* synthetic */ kotlin.x invoke(View view) {
            invoke2(view);
            return kotlin.x.a;
        }

        /* renamed from: invoke */
        public final void invoke2(View it) {
            kotlin.jvm.internal.m.g(it, "it");
            Fragment_CommonKt.navigateUp(AdvancedSettingsFragment.this);
        }
    }

    /* compiled from: AdvancedSettingsFragment.kt */
    /* loaded from: classes2.dex */
    public static final class b extends kotlin.jvm.internal.o implements kotlin.e0.c.l<View, kotlin.x> {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b() {
            super(1);
            AdvancedSettingsFragment.this = r1;
        }

        @Override // kotlin.e0.c.l
        public /* bridge */ /* synthetic */ kotlin.x invoke(View view) {
            invoke2(view);
            return kotlin.x.a;
        }

        /* renamed from: invoke */
        public final void invoke2(View it) {
            kotlin.jvm.internal.m.g(it, "it");
            Fragment_CommonKt.navigate$default(AdvancedSettingsFragment.this, R.id.action_advancedSettingsFragment_to_walletPickerFragment, null, null, null, 14, null);
        }
    }

    private final void d() {
        int i2 = this.f11231c + 1;
        this.f11231c = i2;
        if (i2 % 10 == 0) {
            u1 u1Var = this.f11230b;
            if (u1Var != null) {
                u1Var.f();
            } else {
                kotlin.jvm.internal.m.w("viewModel");
                throw null;
            }
        }
    }

    public static final void e(AdvancedSettingsFragment this$0, View view) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        this$0.d();
    }

    public static final void f(AdvancedSettingsFragment this$0, String str) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        View view = this$0.getView();
        ((TextView) (view == null ? null : view.findViewById(e.j.a.currentWallet))).setText(str);
    }

    public static final void g(AdvancedSettingsFragment this$0, Boolean it) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.f(it, "it");
        this$0.k(it.booleanValue());
    }

    private final FragmentLifecycleScopeProvider getScopeProvider() {
        return Fragment_CommonKt.getFragmentLifecycleScopeProvider$default(this, null, 1, null);
    }

    public static /* synthetic */ void h(AdvancedSettingsFragment advancedSettingsFragment, View view) {
        e(advancedSettingsFragment, view);
    }

    public static /* synthetic */ void i(AdvancedSettingsFragment advancedSettingsFragment, String str) {
        f(advancedSettingsFragment, str);
    }

    private final void init() {
        initViewModel();
        initClickListeners();
        initObservers();
    }

    private final void initClickListeners() {
        View view = getView();
        View closeButton = view == null ? null : view.findViewById(e.j.a.t0);
        kotlin.jvm.internal.m.f(closeButton, "closeButton");
        View_CommonKt.setOnSingleClickListener$default(closeButton, 0L, new a(), 1, null);
        View view2 = getView();
        View wallet = view2 == null ? null : view2.findViewById(e.j.a.wallet);
        kotlin.jvm.internal.m.f(wallet, "wallet");
        View_CommonKt.setOnSingleClickListener$default(wallet, 0L, new b(), 1, null);
        View view3 = getView();
        ((TextView) (view3 != null ? view3.findViewById(e.j.a.developMessage) : null)).setOnClickListener(new View.OnClickListener() { // from class: com.toshi.view.fragment.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view4) {
                AdvancedSettingsFragment.h(AdvancedSettingsFragment.this, view4);
            }
        });
    }

    private final void initObservers() {
        u1 u1Var = this.f11230b;
        if (u1Var != null) {
            h.c.s<String> observeOn = u1Var.a().observeOn(this.a);
            kotlin.jvm.internal.m.f(observeOn, "viewModel.walletNameObservable\n            .observeOn(mainScheduler)");
            ((com.uber.autodispose.x) Observable_AnalyticsKt.logError$default(observeOn, "Error while fetching wallet name", null, 2, null).as(com.uber.autodispose.d.a(getScopeProvider()))).subscribe(new h.c.m0.f() { // from class: com.toshi.view.fragment.b
                @Override // h.c.m0.f
                public final void accept(Object obj) {
                    AdvancedSettingsFragment.i(AdvancedSettingsFragment.this, (String) obj);
                }
            });
            u1 u1Var2 = this.f11230b;
            if (u1Var2 != null) {
                h.c.s<Boolean> observeOn2 = u1Var2.b().observeOn(this.a);
                kotlin.jvm.internal.m.f(observeOn2, "viewModel.isWebViewDebuggableObservable\n            .observeOn(mainScheduler)");
                ((com.uber.autodispose.x) Observable_AnalyticsKt.logError$default(observeOn2, "Error while toggling webview debugging", null, 2, null).as(com.uber.autodispose.d.a(getScopeProvider()))).subscribe(new h.c.m0.f() { // from class: com.toshi.view.fragment.c
                    @Override // h.c.m0.f
                    public final void accept(Object obj) {
                        AdvancedSettingsFragment.j(AdvancedSettingsFragment.this, (Boolean) obj);
                    }
                });
                return;
            }
            kotlin.jvm.internal.m.w("viewModel");
            throw null;
        }
        kotlin.jvm.internal.m.w("viewModel");
        throw null;
    }

    private final void initViewModel() {
        androidx.lifecycle.b0 a2 = new androidx.lifecycle.d0(this, getViewModelFactory$app_productionRelease()).a(u1.class);
        kotlin.jvm.internal.m.f(a2, "ViewModelProvider(this, viewModelFactory).get(T::class.java)");
        this.f11230b = (u1) a2;
    }

    public static /* synthetic */ void j(AdvancedSettingsFragment advancedSettingsFragment, Boolean bool) {
        g(advancedSettingsFragment, bool);
    }

    private final void k(boolean z) {
        e.j.f.m.u(this, z ? R.string.web_debugging_enabled : R.string.web_debugging_disabled, 0, 2, null);
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

    public final GenericViewModelFactory<u1> getViewModelFactory$app_productionRelease() {
        GenericViewModelFactory<u1> genericViewModelFactory = this.f11232d;
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
        return inflater.inflate(R.layout.fragment_advanced_settings, viewGroup, false);
    }

    @Override // com.coinbase.wallet.commonui.views.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        kotlin.jvm.internal.m.g(view, "view");
        init();
    }
}