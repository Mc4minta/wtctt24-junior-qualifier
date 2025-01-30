package com.toshi.view.fragment.pickUsername;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.lifecycle.b0;
import androidx.lifecycle.d0;
import androidx.lifecycle.i;
import com.appsflyer.share.Constants;
import com.coinbase.wallet.analytics.extensions.Observable_AnalyticsKt;
import com.coinbase.wallet.analytics.extensions.Single_AnalyticsKt;
import com.coinbase.wallet.common.extensions.ObservableSubscribeProxy_CommonKt;
import com.coinbase.wallet.common.extensions.SingleSubscribeProxy_CommonKt;
import com.coinbase.wallet.commonui.di.GenericViewModelFactory;
import com.coinbase.wallet.commonui.extensions.Fragment_CommonKt;
import com.coinbase.wallet.commonui.extensions.View_CommonKt;
import com.coinbase.wallet.commonui.utilities.FragmentLifecycleScopeProvider;
import com.toshi.view.custom.PrefixSuffixEditText;
import com.toshi.view.custom.SpinnerOverlayLayout;
import com.toshi.view.custom.UsernameStatusView;
import com.toshi.view.fragment.o0;
import e.j.n.h3;
import e.j.n.w2;
import h.c.a0;
import h.c.h0;
import h.c.m0.n;
import h.c.s;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.e0.c.l;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.o;
import kotlin.x;
import org.toshi.R;

/* compiled from: BasePickUsernameFragment.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b>\u0010\u0004J\u000f\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0006\u0010\u0004J\u000f\u0010\u0007\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0007\u0010\u0004J\u000f\u0010\b\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\b\u0010\u0004J\u000f\u0010\t\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\t\u0010\u0004J-\u0010\u0011\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\r\u001a\u0004\u0018\u00010\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J!\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0017\u001a\u00020\u0016H$¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u0019\u001a\u00020\u0016H$¢\u0006\u0004\b\u0019\u0010\u0018J\u0017\u0010\u001b\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u0016H\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ\u0017\u0010\u001e\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u001dH\u0016¢\u0006\u0004\b\u001e\u0010\u001fJ\u000f\u0010!\u001a\u00020 H\u0004¢\u0006\u0004\b!\u0010\"R\u0016\u0010&\u001a\u00020#8@@\u0000X\u0080\u0004¢\u0006\u0006\u001a\u0004\b$\u0010%R\"\u0010.\u001a\u00020'8\u0000@\u0000X\u0080.¢\u0006\u0012\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\u0016\u00100\u001a\u00020#8B@\u0002X\u0082\u0004¢\u0006\u0006\u001a\u0004\b/\u0010%R(\u00108\u001a\b\u0012\u0004\u0012\u00020'018\u0000@\u0000X\u0081.¢\u0006\u0012\n\u0004\b2\u00103\u001a\u0004\b4\u00105\"\u0004\b6\u00107R\u001e\u0010=\u001a\n :*\u0004\u0018\u000109098\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b;\u0010<¨\u0006?"}, d2 = {"Lcom/toshi/view/fragment/pickUsername/h;", "Lcom/toshi/view/fragment/o0;", "Lkotlin/x;", "init", "()V", "initViewModel", "initView", "initClickListeners", "n", "l", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "", "f", "()Ljava/lang/String;", "d", "username", "i", "(Ljava/lang/String;)V", "Le/j/n/h3;", "h", "(Le/j/n/h3;)V", "", "w", "()Z", "Lcom/coinbase/wallet/commonui/utilities/FragmentLifecycleScopeProvider;", "e", "()Lcom/coinbase/wallet/commonui/utilities/FragmentLifecycleScopeProvider;", "scopeProvider", "Le/j/n/w2;", Constants.URL_CAMPAIGN, "Le/j/n/w2;", "g", "()Le/j/n/w2;", "v", "(Le/j/n/w2;)V", "viewModel", "getOnDestroyScopeProvider", "onDestroyScopeProvider", "Lcom/coinbase/wallet/commonui/di/GenericViewModelFactory;", "b", "Lcom/coinbase/wallet/commonui/di/GenericViewModelFactory;", "getViewModelFactory$app_productionRelease", "()Lcom/coinbase/wallet/commonui/di/GenericViewModelFactory;", "setViewModelFactory$app_productionRelease", "(Lcom/coinbase/wallet/commonui/di/GenericViewModelFactory;)V", "viewModelFactory", "Lh/c/a0;", "kotlin.jvm.PlatformType", "a", "Lh/c/a0;", "mainScheduler", "<init>", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public abstract class h extends o0 {
    private final a0 a = h.c.j0.c.a.b();

    /* renamed from: b */
    public GenericViewModelFactory<w2> f11375b;

    /* renamed from: c */
    public w2 f11376c;

    /* compiled from: BasePickUsernameFragment.kt */
    /* loaded from: classes2.dex */
    public static final class a extends o implements l<h3, x> {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a() {
            super(1);
            h.this = r1;
        }

        public final void a(h3 user) {
            h hVar = h.this;
            m.f(user, "user");
            hVar.h(user);
        }

        @Override // kotlin.e0.c.l
        public /* bridge */ /* synthetic */ x invoke(h3 h3Var) {
            a(h3Var);
            return x.a;
        }
    }

    /* compiled from: BasePickUsernameFragment.kt */
    /* loaded from: classes2.dex */
    public static final class b extends o implements l<View, x> {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b() {
            super(1);
            h.this = r1;
        }

        @Override // kotlin.e0.c.l
        public /* bridge */ /* synthetic */ x invoke(View view) {
            invoke2(view);
            return x.a;
        }

        /* renamed from: invoke */
        public final void invoke2(View it) {
            m.g(it, "it");
            h hVar = h.this;
            View view = hVar.getView();
            hVar.i(String.valueOf(((PrefixSuffixEditText) (view == null ? null : view.findViewById(e.j.a.usernameInput))).getText()));
        }
    }

    /* compiled from: BasePickUsernameFragment.kt */
    /* loaded from: classes2.dex */
    public static final class c extends o implements l<View, x> {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c() {
            super(1);
            h.this = r1;
        }

        @Override // kotlin.e0.c.l
        public /* bridge */ /* synthetic */ x invoke(View view) {
            invoke2(view);
            return x.a;
        }

        /* renamed from: invoke */
        public final void invoke2(View it) {
            m.g(it, "it");
            Fragment_CommonKt.navigateUp(h.this);
        }
    }

    /* compiled from: BasePickUsernameFragment.kt */
    /* loaded from: classes2.dex */
    public static final class d extends o implements l<Boolean, x> {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d() {
            super(1);
            h.this = r1;
        }

        @Override // kotlin.e0.c.l
        public /* bridge */ /* synthetic */ x invoke(Boolean bool) {
            invoke2(bool);
            return x.a;
        }

        /* renamed from: invoke */
        public final void invoke2(Boolean isUserNameAvailable) {
            m.f(isUserNameAvailable, "isUserNameAvailable");
            if (isUserNameAvailable.booleanValue()) {
                View view = h.this.getView();
                ((UsernameStatusView) (view != null ? view.findViewById(e.j.a.usernameStatus) : null)).b();
            } else {
                View view2 = h.this.getView();
                ((UsernameStatusView) (view2 != null ? view2.findViewById(e.j.a.usernameStatus) : null)).c();
            }
            h.this.w();
        }
    }

    private final FragmentLifecycleScopeProvider getOnDestroyScopeProvider() {
        return Fragment_CommonKt.getFragmentLifecycleScopeProvider(this, i.a.ON_DESTROY);
    }

    private final void init() {
        initViewModel();
        initView();
        initClickListeners();
        n();
        l();
        View view = getView();
        e.j.f.m.q(this, view == null ? null : view.findViewById(e.j.a.usernameInput));
    }

    private final void initClickListeners() {
        View view = getView();
        View nextButton = view == null ? null : view.findViewById(e.j.a.s4);
        m.f(nextButton, "nextButton");
        View_CommonKt.setOnSingleClickListener$default(nextButton, 0L, new b(), 1, null);
        View view2 = getView();
        View backButton = view2 != null ? view2.findViewById(e.j.a.backButton) : null;
        m.f(backButton, "backButton");
        View_CommonKt.setOnSingleClickListener$default(backButton, 0L, new c(), 1, null);
    }

    private final void initView() {
        View view = getView();
        ((TextView) (view == null ? null : view.findViewById(e.j.a.K6))).setText(f());
        View view2 = getView();
        ((TextView) (view2 != null ? view2.findViewById(e.j.a.C1) : null)).setText(d());
    }

    private final void initViewModel() {
        b0 a2 = new d0(this, getViewModelFactory$app_productionRelease()).a(w2.class);
        m.f(a2, "ViewModelProvider(this, viewModelFactory).get(T::class.java)");
        v((w2) a2);
    }

    public static final void j(h this$0, h.c.k0.b bVar) {
        m.g(this$0, "this$0");
        View view = this$0.getView();
        ((SpinnerOverlayLayout) (view == null ? null : view.findViewById(e.j.a.spinnerLayout))).c(true);
    }

    public static final void k(h this$0) {
        m.g(this$0, "this$0");
        View view = this$0.getView();
        ((SpinnerOverlayLayout) (view == null ? null : view.findViewById(e.j.a.spinnerLayout))).c(false);
    }

    private final void l() {
        View view = getView();
        ((PrefixSuffixEditText) (view == null ? null : view.findViewById(e.j.a.usernameInput))).setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.toshi.view.fragment.pickUsername.e
            @Override // android.widget.TextView.OnEditorActionListener
            public final boolean onEditorAction(TextView textView, int i2, KeyEvent keyEvent) {
                return h.u(h.this, textView, i2, keyEvent);
            }
        });
    }

    public static final boolean m(h this$0, TextView textView, int i2, KeyEvent keyEvent) {
        m.g(this$0, "this$0");
        View view = this$0.getView();
        PrefixSuffixEditText prefixSuffixEditText = (PrefixSuffixEditText) (view == null ? null : view.findViewById(e.j.a.usernameInput));
        if (prefixSuffixEditText != null && i2 == 5) {
            this$0.i(String.valueOf(prefixSuffixEditText.getText()));
            return true;
        }
        return false;
    }

    private final void n() {
        View view = getView();
        ((PrefixSuffixEditText) (view == null ? null : view.findViewById(e.j.a.usernameInput))).requestFocus();
        View view2 = getView();
        s observeOn = e.h.a.d.c.a((TextView) (view2 == null ? null : view2.findViewById(e.j.a.usernameInput))).c().doOnSubscribe(new h.c.m0.f() { // from class: com.toshi.view.fragment.pickUsername.d
            @Override // h.c.m0.f
            public final void accept(Object obj) {
                h.t(h.this, (h.c.k0.b) obj);
            }
        }).observeOn(this.a).debounce(300L, TimeUnit.MILLISECONDS).flatMapSingle(new n() { // from class: com.toshi.view.fragment.pickUsername.b
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return h.r(h.this, (CharSequence) obj);
            }
        }).observeOn(this.a);
        m.f(observeOn, "textChanges(usernameInput)\n            .skipInitialValue()\n            .doOnSubscribe { usernameStatus }\n            .observeOn(mainScheduler)\n            .debounce(300, TimeUnit.MILLISECONDS)\n            .flatMapSingle { viewModel.search(it.toString()) }\n            .observeOn(mainScheduler)");
        Object as = Observable_AnalyticsKt.logError$default(observeOn, "Error while checking if username is available", null, 2, null).as(com.uber.autodispose.d.a(e()));
        m.f(as, "textChanges(usernameInput)\n            .skipInitialValue()\n            .doOnSubscribe { usernameStatus }\n            .observeOn(mainScheduler)\n            .debounce(300, TimeUnit.MILLISECONDS)\n            .flatMapSingle { viewModel.search(it.toString()) }\n            .observeOn(mainScheduler)\n            .logError(\"Error while checking if username is available\")\n            .`as`(autoDisposable(scopeProvider))");
        ObservableSubscribeProxy_CommonKt.subscribeBy$default((com.uber.autodispose.x) as, null, null, new d(), 3, null);
    }

    public static final void o(h this$0, h.c.k0.b bVar) {
        m.g(this$0, "this$0");
        View view = this$0.getView();
        if (view == null) {
            return;
        }
        view.findViewById(e.j.a.usernameStatus);
    }

    public static final h0 p(h this$0, CharSequence it) {
        m.g(this$0, "this$0");
        m.g(it, "it");
        return this$0.g().c(it.toString());
    }

    public static /* synthetic */ void q(h hVar, h.c.k0.b bVar) {
        j(hVar, bVar);
    }

    public static /* synthetic */ h0 r(h hVar, CharSequence charSequence) {
        return p(hVar, charSequence);
    }

    public static /* synthetic */ void s(h hVar) {
        k(hVar);
    }

    public static /* synthetic */ void t(h hVar, h.c.k0.b bVar) {
        o(hVar, bVar);
    }

    public static /* synthetic */ boolean u(h hVar, TextView textView, int i2, KeyEvent keyEvent) {
        return m(hVar, textView, i2, keyEvent);
    }

    @Override // com.toshi.view.fragment.o0, com.coinbase.wallet.commonui.views.BaseFragment
    public void _$_clearFindViewByIdCache() {
    }

    protected abstract String d();

    public final FragmentLifecycleScopeProvider e() {
        return Fragment_CommonKt.getFragmentLifecycleScopeProvider$default(this, null, 1, null);
    }

    protected abstract String f();

    public final w2 g() {
        w2 w2Var = this.f11376c;
        if (w2Var != null) {
            return w2Var;
        }
        m.w("viewModel");
        throw null;
    }

    public final GenericViewModelFactory<w2> getViewModelFactory$app_productionRelease() {
        GenericViewModelFactory<w2> genericViewModelFactory = this.f11375b;
        if (genericViewModelFactory != null) {
            return genericViewModelFactory;
        }
        m.w("viewModelFactory");
        throw null;
    }

    public void h(h3 username) {
        m.g(username, "username");
    }

    public void i(String username) {
        m.g(username, "username");
        h.c.b0<h3> doAfterTerminate = g().d(username).observeOn(this.a).doOnSubscribe(new h.c.m0.f() { // from class: com.toshi.view.fragment.pickUsername.a
            @Override // h.c.m0.f
            public final void accept(Object obj) {
                h.q(h.this, (h.c.k0.b) obj);
            }
        }).doAfterTerminate(new h.c.m0.a() { // from class: com.toshi.view.fragment.pickUsername.c
            @Override // h.c.m0.a
            public final void run() {
                h.s(h.this);
            }
        });
        m.f(doAfterTerminate, "viewModel.validateUsername(username)\n            .observeOn(mainScheduler)\n            .doOnSubscribe { spinnerLayout.isSpinnerVisible(true) }\n            .doAfterTerminate { spinnerLayout.isSpinnerVisible(false) }");
        Object as = Single_AnalyticsKt.logError$default(doAfterTerminate, "Error while validating username.", null, 2, null).as(com.uber.autodispose.d.a(getOnDestroyScopeProvider()));
        m.f(as, "viewModel.validateUsername(username)\n            .observeOn(mainScheduler)\n            .doOnSubscribe { spinnerLayout.isSpinnerVisible(true) }\n            .doAfterTerminate { spinnerLayout.isSpinnerVisible(false) }\n            .logError(\"Error while validating username.\")\n            .`as`(autoDisposable(onDestroyScopeProvider))");
        SingleSubscribeProxy_CommonKt.subscribeBy$default((com.uber.autodispose.a0) as, null, new a(), 1, null);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        m.g(inflater, "inflater");
        return inflater.inflate(R.layout.fragment_onboarding_pick_username, viewGroup, false);
    }

    @Override // com.coinbase.wallet.commonui.views.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        m.g(view, "view");
        init();
    }

    public final void v(w2 w2Var) {
        m.g(w2Var, "<set-?>");
        this.f11376c = w2Var;
    }

    public final boolean w() {
        View view = getView();
        return ((ScrollView) (view == null ? null : view.findViewById(e.j.a.N5))).fullScroll(130);
    }
}