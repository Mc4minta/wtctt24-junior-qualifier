package com.toshi.view.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.appsflyer.share.Constants;
import com.coinbase.wallet.analytics.Analytics;
import com.coinbase.wallet.analytics.models.AnalyticsEvent;
import com.coinbase.wallet.application.extensions.AnalyticsEvent_ApplicationKt;
import com.coinbase.wallet.commonui.di.GenericViewModelFactory;
import com.coinbase.wallet.commonui.extensions.Fragment_CommonKt;
import com.coinbase.wallet.commonui.extensions.View_CommonKt;
import com.coinbase.wallet.commonui.views.BackableFragment;
import com.coinbase.wallet.commonui.views.BaseFragment;
import com.coinbase.wallet.commonui.views.StyledFragment;
import com.coinbase.wallet.wallets.models.FiatCurrency;
import e.j.n.f2;
import java.util.List;
import kotlin.Metadata;
import org.toshi.R;

/* compiled from: CurrencyFragment.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0007¢\u0006\u0004\b3\u0010\u0006J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\b\u0010\u0006J\u0017\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\r\u0010\u0006J\u000f\u0010\u000e\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u000e\u0010\u0006J-\u0010\u0016\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J!\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u00152\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u001b\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u001b\u0010\u0006J\u000f\u0010\u001d\u001a\u00020\u001cH\u0016¢\u0006\u0004\b\u001d\u0010\u001eR(\u0010'\u001a\b\u0012\u0004\u0012\u00020 0\u001f8\u0000@\u0000X\u0081.¢\u0006\u0012\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u0016\u0010*\u001a\u00020 8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b(\u0010)R\u0016\u0010.\u001a\u00020+8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b,\u0010-R\u0016\u00102\u001a\u00020/8V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\b0\u00101¨\u00064"}, d2 = {"Lcom/toshi/view/fragment/CurrencyFragment;", "Lcom/coinbase/wallet/commonui/views/BaseFragment;", "Lcom/coinbase/wallet/commonui/views/StyledFragment;", "Lcom/coinbase/wallet/commonui/views/BackableFragment;", "Lkotlin/x;", "init", "()V", "initViewModel", "initViews", "Lcom/coinbase/wallet/wallets/models/FiatCurrency;", "it", "e", "(Lcom/coinbase/wallet/wallets/models/FiatCurrency;)V", "initViewListeners", "initObservers", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "onResume", "", "onBackPressed", "()Z", "Lcom/coinbase/wallet/commonui/di/GenericViewModelFactory;", "Le/j/n/f2;", "a", "Lcom/coinbase/wallet/commonui/di/GenericViewModelFactory;", "getViewModelFactory$app_productionRelease", "()Lcom/coinbase/wallet/commonui/di/GenericViewModelFactory;", "setViewModelFactory$app_productionRelease", "(Lcom/coinbase/wallet/commonui/di/GenericViewModelFactory;)V", "viewModelFactory", "b", "Le/j/n/f2;", "viewModel", "Le/j/m/a/d;", Constants.URL_CAMPAIGN, "Le/j/m/a/d;", "adapter", "Lcom/coinbase/wallet/commonui/views/StyledFragment$Attributes;", "getAttributes", "()Lcom/coinbase/wallet/commonui/views/StyledFragment$Attributes;", "attributes", "<init>", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class CurrencyFragment extends BaseFragment implements StyledFragment, BackableFragment {
    public GenericViewModelFactory<f2> a;

    /* renamed from: b */
    private f2 f11255b;

    /* renamed from: c */
    private e.j.m.a.d f11256c;

    /* compiled from: CurrencyFragment.kt */
    /* loaded from: classes2.dex */
    public static final class a extends kotlin.jvm.internal.o implements kotlin.e0.c.l<View, kotlin.x> {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a() {
            super(1);
            CurrencyFragment.this = r1;
        }

        @Override // kotlin.e0.c.l
        public /* bridge */ /* synthetic */ kotlin.x invoke(View view) {
            invoke2(view);
            return kotlin.x.a;
        }

        /* renamed from: invoke */
        public final void invoke2(View it) {
            kotlin.jvm.internal.m.g(it, "it");
            Fragment_CommonKt.navigateUp(CurrencyFragment.this);
        }
    }

    /* compiled from: CurrencyFragment.kt */
    /* loaded from: classes2.dex */
    public static final class b extends kotlin.jvm.internal.o implements kotlin.e0.c.l<FiatCurrency, kotlin.x> {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b() {
            super(1);
            CurrencyFragment.this = r1;
        }

        @Override // kotlin.e0.c.l
        public /* bridge */ /* synthetic */ kotlin.x invoke(FiatCurrency fiatCurrency) {
            invoke2(fiatCurrency);
            return kotlin.x.a;
        }

        /* renamed from: invoke */
        public final void invoke2(FiatCurrency it) {
            kotlin.jvm.internal.m.g(it, "it");
            CurrencyFragment.this.e(it);
        }
    }

    public final void e(FiatCurrency fiatCurrency) {
        Analytics.INSTANCE.log(AnalyticsEvent_ApplicationKt.currencySettingsCurrencySet(AnalyticsEvent.Companion, fiatCurrency.getCode().getRawValue()));
        f2 f2Var = this.f11255b;
        if (f2Var != null) {
            f2Var.g(fiatCurrency);
        } else {
            kotlin.jvm.internal.m.w("viewModel");
            throw null;
        }
    }

    public static final void f(CurrencyFragment this$0, List list) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        if (list != null) {
            e.j.m.a.d dVar = this$0.f11256c;
            if (dVar != null) {
                dVar.d(list);
            } else {
                kotlin.jvm.internal.m.w("adapter");
                throw null;
            }
        }
    }

    public static final void g(CurrencyFragment this$0, FiatCurrency fiatCurrency) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        Fragment_CommonKt.navigateUp(this$0);
    }

    public static /* synthetic */ void h(CurrencyFragment currencyFragment, List list) {
        f(currencyFragment, list);
    }

    public static /* synthetic */ void i(CurrencyFragment currencyFragment, FiatCurrency fiatCurrency) {
        g(currencyFragment, fiatCurrency);
    }

    private final void init() {
        initViewModel();
        initViews();
        initViewListeners();
        initObservers();
    }

    private final void initObservers() {
        f2 f2Var = this.f11255b;
        if (f2Var != null) {
            f2Var.d().g(getViewLifecycleOwner(), new androidx.lifecycle.v() { // from class: com.toshi.view.fragment.o
                @Override // androidx.lifecycle.v
                public final void a(Object obj) {
                    CurrencyFragment.h(CurrencyFragment.this, (List) obj);
                }
            });
            f2 f2Var2 = this.f11255b;
            if (f2Var2 == null) {
                kotlin.jvm.internal.m.w("viewModel");
                throw null;
            }
            e.j.l.k<FiatCurrency> e2 = f2Var2.e();
            androidx.lifecycle.o viewLifecycleOwner = getViewLifecycleOwner();
            kotlin.jvm.internal.m.f(viewLifecycleOwner, "viewLifecycleOwner");
            e2.g(viewLifecycleOwner, new androidx.lifecycle.v() { // from class: com.toshi.view.fragment.p
                @Override // androidx.lifecycle.v
                public final void a(Object obj) {
                    CurrencyFragment.i(CurrencyFragment.this, (FiatCurrency) obj);
                }
            });
            return;
        }
        kotlin.jvm.internal.m.w("viewModel");
        throw null;
    }

    private final void initViewListeners() {
        View view = getView();
        View closeButton = view == null ? null : view.findViewById(e.j.a.t0);
        kotlin.jvm.internal.m.f(closeButton, "closeButton");
        View_CommonKt.setOnSingleClickListener$default(closeButton, 0L, new a(), 1, null);
    }

    private final void initViewModel() {
        androidx.lifecycle.b0 a2 = new androidx.lifecycle.d0(this, getViewModelFactory$app_productionRelease()).a(f2.class);
        kotlin.jvm.internal.m.f(a2, "ViewModelProvider(this, viewModelFactory).get(T::class.java)");
        this.f11255b = (f2) a2;
    }

    private final void initViews() {
        View view = getView();
        View currencyList = view == null ? null : view.findViewById(e.j.a.currencyList);
        kotlin.jvm.internal.m.f(currencyList, "currencyList");
        e.j.f.r.b((RecyclerView) currencyList, 0, 0, 0, 0, 0, 0, 63, null);
        this.f11256c = new e.j.m.a.d(null, new b(), 1, null);
        View view2 = getView();
        RecyclerView recyclerView = (RecyclerView) (view2 == null ? null : view2.findViewById(e.j.a.currencyList));
        e.j.m.a.d dVar = this.f11256c;
        if (dVar != null) {
            recyclerView.setAdapter(dVar);
        } else {
            kotlin.jvm.internal.m.w("adapter");
            throw null;
        }
    }

    @Override // com.coinbase.wallet.commonui.views.BaseFragment
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

    public final GenericViewModelFactory<f2> getViewModelFactory$app_productionRelease() {
        GenericViewModelFactory<f2> genericViewModelFactory = this.a;
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
        return inflater.inflate(R.layout.fragment_currency, viewGroup, false);
    }

    @Override // com.coinbase.wallet.commonui.views.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        Analytics.INSTANCE.log(AnalyticsEvent_ApplicationKt.currencySettingsLanded(AnalyticsEvent.Companion));
    }

    @Override // com.coinbase.wallet.commonui.views.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        kotlin.jvm.internal.m.g(view, "view");
        init();
    }
}