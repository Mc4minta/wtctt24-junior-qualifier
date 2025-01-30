package com.toshi.view.fragment;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import com.appsflyer.share.Constants;
import com.coinbase.wallet.analytics.Analytics;
import com.coinbase.wallet.analytics.extensions.Observable_AnalyticsKt;
import com.coinbase.wallet.analytics.models.AnalyticsEvent;
import com.coinbase.wallet.application.extensions.AnalyticsEvent_ApplicationKt;
import com.coinbase.wallet.blockchains.models.Wallet;
import com.coinbase.wallet.commonui.di.GenericViewModelFactory;
import com.coinbase.wallet.commonui.extensions.Fragment_CommonKt;
import com.coinbase.wallet.commonui.extensions.View_CommonKt;
import com.coinbase.wallet.commonui.utilities.FragmentLifecycleScopeProvider;
import com.coinbase.wallet.commonui.views.BackableFragment;
import com.coinbase.wallet.commonui.views.HorizontalLineDivider;
import com.coinbase.wallet.commonui.views.LockedFragment;
import com.coinbase.wallet.commonui.views.StyledFragment;
import e.j.n.m3;
import e.j.n.y2;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import org.toshi.R;

/* compiled from: ReceiveCoinPickerFragment.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0095\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t*\u0001K\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003:\u0001UB\u0007¢\u0006\u0004\b[\u0010\u0006J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\b\u0010\u0006J\u000f\u0010\t\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\t\u0010\u0006J\u000f\u0010\n\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\n\u0010\u0006J\u0019\u0010\r\u001a\u00020\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u000f\u0010\u0006J\u0017\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0014\u0010\u0006J-\u0010\u001c\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u0016\u001a\u00020\u00152\b\u0010\u0018\u001a\u0004\u0018\u00010\u00172\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019H\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ!\u0010\u001f\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u001b2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019H\u0016¢\u0006\u0004\b\u001f\u0010 J\u000f\u0010!\u001a\u00020\u0004H\u0016¢\u0006\u0004\b!\u0010\u0006J\u001f\u0010$\u001a\u00020\"2\u0006\u0010\u001e\u001a\u00020\u001b2\u0006\u0010#\u001a\u00020\"H\u0016¢\u0006\u0004\b$\u0010%J\u000f\u0010&\u001a\u00020\u0010H\u0016¢\u0006\u0004\b&\u0010'R\u0016\u0010+\u001a\u00020(8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b)\u0010*R\"\u00102\u001a\u00020,8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b-\u0010.\u001a\u0004\b-\u0010/\"\u0004\b0\u00101R\u0016\u00106\u001a\u0002038V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\b4\u00105R\u0016\u0010:\u001a\u0002078\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b8\u00109R(\u0010C\u001a\b\u0012\u0004\u0012\u00020<0;8\u0000@\u0000X\u0081.¢\u0006\u0012\n\u0004\b=\u0010>\u001a\u0004\b?\u0010@\"\u0004\bA\u0010BR\u0016\u0010G\u001a\u00020D8B@\u0002X\u0082\u0004¢\u0006\u0006\u001a\u0004\bE\u0010FR\u0018\u0010J\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bH\u0010IR\u0016\u0010N\u001a\u00020K8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bL\u0010MR\u0016\u0010R\u001a\u00020O8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bP\u0010QR\u001e\u0010W\u001a\n T*\u0004\u0018\u00010S0S8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bU\u0010VR\u0016\u0010Z\u001a\u00020<8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\bX\u0010Y¨\u0006\\"}, d2 = {"Lcom/toshi/view/fragment/ReceiveCoinPickerFragment;", "Lcom/coinbase/wallet/commonui/views/LockedFragment;", "Lcom/coinbase/wallet/commonui/views/StyledFragment;", "Lcom/coinbase/wallet/commonui/views/BackableFragment;", "Lkotlin/x;", "init", "()V", "m", "initObservables", "initViewModel", "initAdapter", "Le/j/n/m3;", "wallet", "w", "(Le/j/n/m3;)V", "initClickListeners", "", "isNotElevated", "setHeaderElevated", "(Z)V", "x", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "onResume", "Lc/h/k/d0;", "insets", "applyWindowInsets", "(Landroid/view/View;Lc/h/k/d0;)Lc/h/k/d0;", "onBackPressed", "()Z", "Le/j/m/a/o;", Constants.URL_CAMPAIGN, "Le/j/m/a/o;", "coinAdapter", "Lcom/toshi/view/fragment/h0;", "g", "Lcom/toshi/view/fragment/h0;", "()Lcom/toshi/view/fragment/h0;", "setDisplayCoinAddressFragmentFactory", "(Lcom/toshi/view/fragment/h0;)V", "displayCoinAddressFragmentFactory", "Lcom/coinbase/wallet/commonui/views/StyledFragment$Attributes;", "getAttributes", "()Lcom/coinbase/wallet/commonui/views/StyledFragment$Attributes;", "attributes", "Lcom/coinbase/wallet/commonui/views/HorizontalLineDivider;", "j", "Lcom/coinbase/wallet/commonui/views/HorizontalLineDivider;", "dividerDecoration", "Lcom/coinbase/wallet/commonui/di/GenericViewModelFactory;", "Le/j/n/y2;", "f", "Lcom/coinbase/wallet/commonui/di/GenericViewModelFactory;", "getViewModelFactory$app_productionRelease", "()Lcom/coinbase/wallet/commonui/di/GenericViewModelFactory;", "setViewModelFactory$app_productionRelease", "(Lcom/coinbase/wallet/commonui/di/GenericViewModelFactory;)V", "viewModelFactory", "Lcom/coinbase/wallet/commonui/utilities/FragmentLifecycleScopeProvider;", "getScopeProvider", "()Lcom/coinbase/wallet/commonui/utilities/FragmentLifecycleScopeProvider;", "scopeProvider", "d", "Le/j/n/m3;", "defaultWalletCompactCell", "com/toshi/view/fragment/ReceiveCoinPickerFragment$f", "h", "Lcom/toshi/view/fragment/ReceiveCoinPickerFragment$f;", "scrollListener", "Lcom/toshi/view/fragment/ReceiveCoinPickerFragment$a;", "e", "Lcom/toshi/view/fragment/ReceiveCoinPickerFragment$a;", "searchState", "Lh/c/a0;", "kotlin.jvm.PlatformType", "a", "Lh/c/a0;", "mainScheduler", "b", "Le/j/n/y2;", "viewModel", "<init>", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class ReceiveCoinPickerFragment extends LockedFragment implements StyledFragment, BackableFragment {

    /* renamed from: b */
    private y2 f11281b;

    /* renamed from: c */
    private e.j.m.a.o f11282c;

    /* renamed from: d */
    private m3 f11283d;

    /* renamed from: f */
    public GenericViewModelFactory<y2> f11285f;

    /* renamed from: g */
    public h0 f11286g;

    /* renamed from: j */
    private HorizontalLineDivider f11288j;
    private final h.c.a0 a = h.c.j0.c.a.b();

    /* renamed from: e */
    private a f11284e = a.NotSearching;

    /* renamed from: h */
    private final f f11287h = new f();

    /* compiled from: ReceiveCoinPickerFragment.kt */
    /* loaded from: classes2.dex */
    public enum a {
        Searching,
        NotSearching
    }

    /* compiled from: ReceiveCoinPickerFragment.kt */
    /* loaded from: classes2.dex */
    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[a.values().length];
            iArr[a.NotSearching.ordinal()] = 1;
            a = iArr;
        }
    }

    /* compiled from: ReceiveCoinPickerFragment.kt */
    /* loaded from: classes2.dex */
    public static final class c extends kotlin.jvm.internal.o implements kotlin.e0.c.l<m3, kotlin.x> {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c() {
            super(1);
            ReceiveCoinPickerFragment.this = r1;
        }

        public final void a(m3 wallet) {
            kotlin.jvm.internal.m.g(wallet, "wallet");
            ReceiveCoinPickerFragment.this.w(wallet);
        }

        @Override // kotlin.e0.c.l
        public /* bridge */ /* synthetic */ kotlin.x invoke(m3 m3Var) {
            a(m3Var);
            return kotlin.x.a;
        }
    }

    /* compiled from: ReceiveCoinPickerFragment.kt */
    /* loaded from: classes2.dex */
    public static final class d extends kotlin.jvm.internal.o implements kotlin.e0.c.a<kotlin.x> {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d() {
            super(0);
            ReceiveCoinPickerFragment.this = r1;
        }

        @Override // kotlin.e0.c.a
        public /* bridge */ /* synthetic */ kotlin.x invoke() {
            invoke2();
            return kotlin.x.a;
        }

        /* renamed from: invoke */
        public final void invoke2() {
            ReceiveCoinPickerFragment receiveCoinPickerFragment = ReceiveCoinPickerFragment.this;
            receiveCoinPickerFragment.w(receiveCoinPickerFragment.f11283d);
        }
    }

    /* compiled from: ReceiveCoinPickerFragment.kt */
    /* loaded from: classes2.dex */
    public static final class e extends kotlin.jvm.internal.o implements kotlin.e0.c.l<View, kotlin.x> {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        e() {
            super(1);
            ReceiveCoinPickerFragment.this = r1;
        }

        @Override // kotlin.e0.c.l
        public /* bridge */ /* synthetic */ kotlin.x invoke(View view) {
            invoke2(view);
            return kotlin.x.a;
        }

        /* renamed from: invoke */
        public final void invoke2(View it) {
            kotlin.jvm.internal.m.g(it, "it");
            e.j.f.m.g(ReceiveCoinPickerFragment.this, null, 1, null);
            Fragment_CommonKt.navigateUp(ReceiveCoinPickerFragment.this);
        }
    }

    /* compiled from: ReceiveCoinPickerFragment.kt */
    /* loaded from: classes2.dex */
    public static final class f extends RecyclerView.t {
        f() {
            ReceiveCoinPickerFragment.this = r1;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.t
        public void onScrolled(RecyclerView recyclerView, int i2, int i3) {
            kotlin.jvm.internal.m.g(recyclerView, "recyclerView");
            super.onScrolled(recyclerView, i2, i3);
            View view = ReceiveCoinPickerFragment.this.getView();
            RecyclerView recyclerView2 = (RecyclerView) (view == null ? null : view.findViewById(e.j.a.sectionedRecyclerView));
            Boolean valueOf = recyclerView2 != null ? Boolean.valueOf(recyclerView2.canScrollVertically(-1)) : null;
            if (valueOf == null) {
                return;
            }
            if (valueOf.booleanValue()) {
                ReceiveCoinPickerFragment.this.setHeaderElevated(false);
            } else {
                ReceiveCoinPickerFragment.this.setHeaderElevated(true);
            }
            if (recyclerView.getScrollState() == 1) {
                recyclerView.requestFocus();
            }
        }
    }

    private final FragmentLifecycleScopeProvider getScopeProvider() {
        return Fragment_CommonKt.getFragmentLifecycleScopeProvider$default(this, null, 1, null);
    }

    public static final String h(CharSequence it) {
        kotlin.jvm.internal.m.g(it, "it");
        return it.toString();
    }

    public static final void i(ReceiveCoinPickerFragment this$0, String it) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.f(it, "it");
        this$0.f11284e = it.length() == 0 ? a.NotSearching : a.Searching;
        this$0.x();
    }

    private final void init() {
        m();
        initViewModel();
        initAdapter();
        initClickListeners();
        initObservables();
    }

    private final void initAdapter() {
        Resources resources = getResources();
        kotlin.jvm.internal.m.f(resources, "resources");
        this.f11282c = new e.j.m.a.o(resources, new c(), new d());
        View view = getView();
        RecyclerView recyclerView = (RecyclerView) (view == null ? null : view.findViewById(e.j.a.sectionedRecyclerView));
        HorizontalLineDivider horizontalLineDivider = this.f11288j;
        if (horizontalLineDivider != null) {
            recyclerView.addItemDecoration(horizontalLineDivider);
            recyclerView.addOnScrollListener(this.f11287h);
            e.j.m.a.o oVar = this.f11282c;
            if (oVar != null) {
                recyclerView.setAdapter(oVar);
                return;
            } else {
                kotlin.jvm.internal.m.w("coinAdapter");
                throw null;
            }
        }
        kotlin.jvm.internal.m.w("dividerDecoration");
        throw null;
    }

    private final void initClickListeners() {
        View view = getView();
        View closeButton = view == null ? null : view.findViewById(e.j.a.t0);
        kotlin.jvm.internal.m.f(closeButton, "closeButton");
        View_CommonKt.setOnSingleClickListener$default(closeButton, 0L, new e(), 1, null);
        View view2 = getView();
        ((com.uber.autodispose.x) e.h.a.d.c.a((TextView) (view2 == null ? null : view2.findViewById(e.j.a.filterCoins))).c().debounce(300L, TimeUnit.MILLISECONDS).observeOn(this.a).map(new h.c.m0.n() { // from class: com.toshi.view.fragment.s
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return ReceiveCoinPickerFragment.r((CharSequence) obj);
            }
        }).doOnNext(new h.c.m0.f() { // from class: com.toshi.view.fragment.q
            @Override // h.c.m0.f
            public final void accept(Object obj) {
                ReceiveCoinPickerFragment.p(ReceiveCoinPickerFragment.this, (String) obj);
            }
        }).as(com.uber.autodispose.d.a(getScopeProvider()))).subscribe(new h.c.m0.f() { // from class: com.toshi.view.fragment.r
            @Override // h.c.m0.f
            public final void accept(Object obj) {
                ReceiveCoinPickerFragment.q(ReceiveCoinPickerFragment.this, (String) obj);
            }
        }, new h.c.m0.f() { // from class: com.toshi.view.fragment.w
            @Override // h.c.m0.f
            public final void accept(Object obj) {
                ReceiveCoinPickerFragment.v((Throwable) obj);
            }
        });
        View view3 = getView();
        ((EditText) (view3 != null ? view3.findViewById(e.j.a.filterCoins) : null)).setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.toshi.view.fragment.u
            @Override // android.view.View.OnFocusChangeListener
            public final void onFocusChange(View view4, boolean z) {
                ReceiveCoinPickerFragment.t(ReceiveCoinPickerFragment.this, view4, z);
            }
        });
    }

    private final void initObservables() {
        y2 y2Var = this.f11281b;
        if (y2Var != null) {
            h.c.s<List<e.j.m.a.p>> observeOn = y2Var.h().observeOn(this.a);
            kotlin.jvm.internal.m.f(observeOn, "viewModel.listItemObservable\n            .observeOn(mainScheduler)");
            ((com.uber.autodispose.x) Observable_AnalyticsKt.logError$default(observeOn, "Error could not set list items for coins.", null, 2, null).as(com.uber.autodispose.d.a(getScopeProvider()))).subscribe(new h.c.m0.f() { // from class: com.toshi.view.fragment.v
                @Override // h.c.m0.f
                public final void accept(Object obj) {
                    ReceiveCoinPickerFragment.u(ReceiveCoinPickerFragment.this, (List) obj);
                }
            });
            y2 y2Var2 = this.f11281b;
            if (y2Var2 != null) {
                h.c.s<Wallet> observeOn2 = y2Var2.g().observeOn(this.a);
                kotlin.jvm.internal.m.f(observeOn2, "viewModel.activeWalletObservable\n            .observeOn(mainScheduler)");
                ((com.uber.autodispose.x) Observable_AnalyticsKt.logError$default(observeOn2, "Error could not set list items for coins.", null, 2, null).as(com.uber.autodispose.d.a(getScopeProvider()))).subscribe(new h.c.m0.f() { // from class: com.toshi.view.fragment.t
                    @Override // h.c.m0.f
                    public final void accept(Object obj) {
                        ReceiveCoinPickerFragment.s(ReceiveCoinPickerFragment.this, (Wallet) obj);
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
        androidx.lifecycle.b0 a2 = new androidx.lifecycle.d0(this, getViewModelFactory$app_productionRelease()).a(y2.class);
        kotlin.jvm.internal.m.f(a2, "ViewModelProvider(this, viewModelFactory).get(T::class.java)");
        this.f11281b = (y2) a2;
    }

    public static final void j(ReceiveCoinPickerFragment this$0, String str) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        e.j.m.a.o oVar = this$0.f11282c;
        if (oVar != null) {
            oVar.c(str);
            View view = this$0.getView();
            ((RecyclerView) (view != null ? view.findViewById(e.j.a.sectionedRecyclerView) : null)).smoothScrollToPosition(0);
            return;
        }
        kotlin.jvm.internal.m.w("coinAdapter");
        throw null;
    }

    public static final void k(Throwable th) {
        l.a.a.f(th, "Error while streaming search.", new Object[0]);
    }

    public static final void l(ReceiveCoinPickerFragment this$0, View view, boolean z) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        if (z) {
            e.j.f.m.q(this$0, view);
        } else {
            e.j.f.m.f(this$0, view);
        }
    }

    private final void m() {
        List b2;
        int m = e.j.f.m.m(this, R.color.grey_5);
        int d2 = e.j.f.m.d(this, R.dimen.view_size_16);
        int d3 = e.j.f.m.d(this, R.dimen.view_size_16);
        int d4 = e.j.f.m.d(this, R.dimen.height_divider);
        b2 = kotlin.a0.q.b(4);
        this.f11288j = new HorizontalLineDivider(m, d2, d3, d4, 1, 1, b2);
    }

    public static final void n(ReceiveCoinPickerFragment this$0, List it) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.f(it, "it");
        if (!it.isEmpty()) {
            e.j.m.a.o oVar = this$0.f11282c;
            if (oVar != null) {
                oVar.setItems(it);
            } else {
                kotlin.jvm.internal.m.w("coinAdapter");
                throw null;
            }
        }
    }

    public static final void o(ReceiveCoinPickerFragment this$0, Wallet wallet) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        y2 y2Var = this$0.f11281b;
        if (y2Var == null) {
            kotlin.jvm.internal.m.w("viewModel");
            throw null;
        }
        m3 f2 = y2Var.f(wallet);
        if (f2 == null) {
            throw new IllegalStateException("Active Ethereum Wallet cannot be null");
        }
        this$0.f11283d = f2;
    }

    public static /* synthetic */ void p(ReceiveCoinPickerFragment receiveCoinPickerFragment, String str) {
        i(receiveCoinPickerFragment, str);
    }

    public static /* synthetic */ void q(ReceiveCoinPickerFragment receiveCoinPickerFragment, String str) {
        j(receiveCoinPickerFragment, str);
    }

    public static /* synthetic */ String r(CharSequence charSequence) {
        return h(charSequence);
    }

    public static /* synthetic */ void s(ReceiveCoinPickerFragment receiveCoinPickerFragment, Wallet wallet) {
        o(receiveCoinPickerFragment, wallet);
    }

    public final void setHeaderElevated(boolean z) {
        if (z) {
            View view = getView();
            ((CardView) (view != null ? view.findViewById(e.j.a.searchBarHeaderCard) : null)).setCardElevation(0.0f);
            return;
        }
        View view2 = getView();
        ((CardView) (view2 != null ? view2.findViewById(e.j.a.searchBarHeaderCard) : null)).setCardElevation(getResources().getDimension(R.dimen.elevation_default));
    }

    public static /* synthetic */ void t(ReceiveCoinPickerFragment receiveCoinPickerFragment, View view, boolean z) {
        l(receiveCoinPickerFragment, view, z);
    }

    public static /* synthetic */ void u(ReceiveCoinPickerFragment receiveCoinPickerFragment, List list) {
        n(receiveCoinPickerFragment, list);
    }

    public static /* synthetic */ void v(Throwable th) {
        k(th);
    }

    public final void w(m3 m3Var) {
        if (m3Var == null) {
            return;
        }
        Analytics.INSTANCE.log(AnalyticsEvent_ApplicationKt.receiveCoinPickerCoinSelected(AnalyticsEvent.Companion, m3Var.b().getName()));
        Fragment_CommonKt.navigate$default(this, R.id.action_receiveCoinPickerFragment_to_displayCoinAddressFragment, g().c(m3Var.a(), m3Var.b().getCode(), m3Var.b().getBlockchain(), m3Var.d()), null, null, 12, null);
    }

    private final void x() {
        if (b.a[this.f11284e.ordinal()] == 1) {
            View view = getView();
            RecyclerView recyclerView = (RecyclerView) (view == null ? null : view.findViewById(e.j.a.sectionedRecyclerView));
            HorizontalLineDivider horizontalLineDivider = this.f11288j;
            if (horizontalLineDivider != null) {
                recyclerView.addItemDecoration(horizontalLineDivider);
                return;
            } else {
                kotlin.jvm.internal.m.w("dividerDecoration");
                throw null;
            }
        }
        View view2 = getView();
        RecyclerView recyclerView2 = (RecyclerView) (view2 == null ? null : view2.findViewById(e.j.a.sectionedRecyclerView));
        HorizontalLineDivider horizontalLineDivider2 = this.f11288j;
        if (horizontalLineDivider2 != null) {
            recyclerView2.removeItemDecoration(horizontalLineDivider2);
        } else {
            kotlin.jvm.internal.m.w("dividerDecoration");
            throw null;
        }
    }

    @Override // com.coinbase.wallet.commonui.views.LockedFragment, com.coinbase.wallet.commonui.views.BaseFragment
    public void _$_clearFindViewByIdCache() {
    }

    @Override // com.coinbase.wallet.commonui.views.StyledFragment
    public c.h.k.d0 applyWindowInsets(View view, c.h.k.d0 insets) {
        kotlin.jvm.internal.m.g(view, "view");
        kotlin.jvm.internal.m.g(insets, "insets");
        View view2 = getView();
        View sectionedRecyclerView = view2 == null ? null : view2.findViewById(e.j.a.sectionedRecyclerView);
        kotlin.jvm.internal.m.f(sectionedRecyclerView, "sectionedRecyclerView");
        sectionedRecyclerView.setPadding(sectionedRecyclerView.getPaddingLeft(), sectionedRecyclerView.getPaddingTop(), sectionedRecyclerView.getPaddingRight(), insets.i());
        return insets;
    }

    public final h0 g() {
        h0 h0Var = this.f11286g;
        if (h0Var != null) {
            return h0Var;
        }
        kotlin.jvm.internal.m.w("displayCoinAddressFragmentFactory");
        throw null;
    }

    @Override // com.coinbase.wallet.commonui.views.StyledFragment
    public StyledFragment.Attributes getAttributes() {
        return StyledFragment.Attributes.copy$default(StyledFragment.DefaultImpls.getAttributes(this), true, false, false, 6, null);
    }

    public final GenericViewModelFactory<y2> getViewModelFactory$app_productionRelease() {
        GenericViewModelFactory<y2> genericViewModelFactory = this.f11285f;
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
        return inflater.inflate(R.layout.fragment_receive_coin_picker, viewGroup, false);
    }

    @Override // com.coinbase.wallet.commonui.views.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        y2 y2Var = this.f11281b;
        if (y2Var != null) {
            y2Var.w();
            Analytics.INSTANCE.log(AnalyticsEvent_ApplicationKt.receiveCoinPickerLanded(AnalyticsEvent.Companion));
            return;
        }
        kotlin.jvm.internal.m.w("viewModel");
        throw null;
    }

    @Override // com.coinbase.wallet.commonui.views.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        kotlin.jvm.internal.m.g(view, "view");
        init();
    }
}