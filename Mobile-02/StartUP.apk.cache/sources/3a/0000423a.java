package com.toshi.view.fragment;

import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import androidx.appcompat.app.c;
import androidx.appcompat.widget.SwitchCompat;
import androidx.lifecycle.i;
import com.appsflyer.share.Constants;
import com.coinbase.wallet.analytics.Analytics;
import com.coinbase.wallet.analytics.models.AnalyticsEvent;
import com.coinbase.wallet.application.extensions.AnalyticsEvent_ApplicationKt;
import com.coinbase.wallet.application.model.BiometricsProtectionType;
import com.coinbase.wallet.authentication.AppLockType;
import com.coinbase.wallet.authentication.AuthenticationResult;
import com.coinbase.wallet.common.extensions.ObservableSubscribeProxy_CommonKt;
import com.coinbase.wallet.commonui.di.GenericViewModelFactory;
import com.coinbase.wallet.commonui.extensions.Fragment_CommonKt;
import com.coinbase.wallet.commonui.extensions.View_CommonKt;
import com.coinbase.wallet.commonui.utilities.FragmentLifecycleScopeProvider;
import com.coinbase.wallet.commonui.views.BackableFragment;
import com.coinbase.wallet.commonui.views.LockedFragment;
import com.coinbase.wallet.commonui.views.StyledFragment;
import com.coinbase.wallet.features.applock.legacy.AuthenticationCallback;
import com.coinbase.wallet.features.applock.legacy.AuthenticationHelper;
import com.toshi.model.local.AppLockSettingsViewState;
import com.toshi.model.local.authentication.AuthenticationMethod;
import com.toshi.view.activity.pin.SwitchPinLockFragment;
import e.j.n.w1;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import org.toshi.R;

/* compiled from: AppLockSettingsFragment.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u008c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0007¢\u0006\u0004\bW\u0010\u0006J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\b\u0010\u0006J\u000f\u0010\t\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\t\u0010\u0006J\u000f\u0010\n\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\n\u0010\u0006J\u000f\u0010\u000b\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u000b\u0010\u0006J\u000f\u0010\r\u001a\u00020\fH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u000f\u0010\u0006J\u000f\u0010\u0010\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0010\u0010\u0006J\u000f\u0010\u0011\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0011\u0010\u0006J\u000f\u0010\u0012\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0012\u0010\u0006J#\u0010\u0016\u001a\u00020\u00042\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00040\u0013H\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0019\u001a\u00020\u0018H\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ-\u0010$\u001a\u0004\u0018\u00010#2\u0006\u0010\u001e\u001a\u00020\u001d2\b\u0010 \u001a\u0004\u0018\u00010\u001f2\b\u0010\"\u001a\u0004\u0018\u00010!H\u0016¢\u0006\u0004\b$\u0010%J!\u0010'\u001a\u00020\u00042\u0006\u0010&\u001a\u00020#2\b\u0010\"\u001a\u0004\u0018\u00010!H\u0016¢\u0006\u0004\b'\u0010(J\u000f\u0010)\u001a\u00020\u0004H\u0016¢\u0006\u0004\b)\u0010\u0006J\u0015\u0010+\u001a\u00020\u00042\u0006\u0010*\u001a\u00020\f¢\u0006\u0004\b+\u0010,J\u000f\u0010-\u001a\u00020\u0004H\u0016¢\u0006\u0004\b-\u0010\u0006J\u000f\u0010.\u001a\u00020\fH\u0016¢\u0006\u0004\b.\u0010\u000eR\u0016\u00102\u001a\u00020/8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b0\u00101R(\u0010:\u001a\b\u0012\u0004\u0012\u00020/038\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b4\u00105\u001a\u0004\b6\u00107\"\u0004\b8\u00109R\u0016\u0010>\u001a\u00020;8B@\u0002X\u0082\u0004¢\u0006\u0006\u001a\u0004\b<\u0010=R\u0016\u0010B\u001a\u00020?8V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\b@\u0010AR\"\u0010I\u001a\u00020C8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\bD\u0010E\u001a\u0004\bD\u0010F\"\u0004\bG\u0010HR\"\u0010Q\u001a\u00020J8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\bK\u0010L\u001a\u0004\bM\u0010N\"\u0004\bO\u0010PR\u001e\u0010V\u001a\n S*\u0004\u0018\u00010R0R8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bT\u0010U¨\u0006X"}, d2 = {"Lcom/toshi/view/fragment/AppLockSettingsFragment;", "Lcom/coinbase/wallet/commonui/views/LockedFragment;", "Lcom/coinbase/wallet/commonui/views/StyledFragment;", "Lcom/coinbase/wallet/commonui/views/BackableFragment;", "Lkotlin/x;", "init", "()V", "initViewModel", "initViews", "initObservables", "r", "initClickListeners", "", "v", "()Z", "l", "i", "H", "h", "Lkotlin/Function1;", "Le/j/d/c;", "callback", "I", "(Lkotlin/e0/c/l;)V", "Lcom/toshi/model/local/authentication/AuthenticationMethod;", "authenticationMethod", "", "g", "(Lcom/toshi/model/local/authentication/AuthenticationMethod;)Ljava/lang/String;", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "onResume", "isEnabled", "G", "(Z)V", "onStart", "onBackPressed", "Le/j/n/w1;", "a", "Le/j/n/w1;", "viewModel", "Lcom/coinbase/wallet/commonui/di/GenericViewModelFactory;", Constants.URL_CAMPAIGN, "Lcom/coinbase/wallet/commonui/di/GenericViewModelFactory;", "getViewModelFactory", "()Lcom/coinbase/wallet/commonui/di/GenericViewModelFactory;", "setViewModelFactory", "(Lcom/coinbase/wallet/commonui/di/GenericViewModelFactory;)V", "viewModelFactory", "Lcom/coinbase/wallet/commonui/utilities/FragmentLifecycleScopeProvider;", "getOnDestroyScopeProvider", "()Lcom/coinbase/wallet/commonui/utilities/FragmentLifecycleScopeProvider;", "onDestroyScopeProvider", "Lcom/coinbase/wallet/commonui/views/StyledFragment$Attributes;", "getAttributes", "()Lcom/coinbase/wallet/commonui/views/StyledFragment$Attributes;", "attributes", "Lcom/coinbase/wallet/features/applock/legacy/AuthenticationHelper;", "e", "Lcom/coinbase/wallet/features/applock/legacy/AuthenticationHelper;", "()Lcom/coinbase/wallet/features/applock/legacy/AuthenticationHelper;", "setAuthenticationHelper", "(Lcom/coinbase/wallet/features/applock/legacy/AuthenticationHelper;)V", "authenticationHelper", "Le/j/l/n/b;", "d", "Le/j/l/n/b;", "f", "()Le/j/l/n/b;", "setBiometricHelper", "(Le/j/l/n/b;)V", "biometricHelper", "Lh/c/a0;", "kotlin.jvm.PlatformType", "b", "Lh/c/a0;", "mainScheduler", "<init>", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class AppLockSettingsFragment extends LockedFragment implements StyledFragment, BackableFragment {
    private w1 a;

    /* renamed from: b */
    private final h.c.a0 f11233b = h.c.j0.c.a.b();

    /* renamed from: c */
    public GenericViewModelFactory<w1> f11234c;

    /* renamed from: d */
    public e.j.l.n.b f11235d;

    /* renamed from: e */
    public AuthenticationHelper f11236e;

    /* compiled from: AppLockSettingsFragment.kt */
    /* loaded from: classes2.dex */
    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[AuthenticationMethod.values().length];
            iArr[AuthenticationMethod.BIOMETRIC.ordinal()] = 1;
            iArr[AuthenticationMethod.PIN.ordinal()] = 2;
            a = iArr;
        }
    }

    /* compiled from: AppLockSettingsFragment.kt */
    /* loaded from: classes2.dex */
    public static final class b extends kotlin.jvm.internal.o implements kotlin.e0.c.l<e.j.d.c, kotlin.x> {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b() {
            super(1);
            AppLockSettingsFragment.this = r1;
        }

        public final void a(e.j.d.c permit) {
            kotlin.jvm.internal.m.g(permit, "permit");
            if (permit instanceof e.j.d.d) {
                Fragment_CommonKt.navigate$default(AppLockSettingsFragment.this, R.id.action_appLockSettingsFragment_to_switchPinLockFragment, SwitchPinLockFragment.a.a(((e.j.d.d) permit).a()), null, null, 12, null);
                return;
            }
            throw new IllegalStateException("Pin permit expected");
        }

        @Override // kotlin.e0.c.l
        public /* bridge */ /* synthetic */ kotlin.x invoke(e.j.d.c cVar) {
            a(cVar);
            return kotlin.x.a;
        }
    }

    /* compiled from: AppLockSettingsFragment.kt */
    /* loaded from: classes2.dex */
    public static final class c extends kotlin.jvm.internal.o implements kotlin.e0.c.l<View, kotlin.x> {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c() {
            super(1);
            AppLockSettingsFragment.this = r1;
        }

        @Override // kotlin.e0.c.l
        public /* bridge */ /* synthetic */ kotlin.x invoke(View view) {
            invoke2(view);
            return kotlin.x.a;
        }

        /* renamed from: invoke */
        public final void invoke2(View it) {
            kotlin.jvm.internal.m.g(it, "it");
            Fragment_CommonKt.navigateUp(AppLockSettingsFragment.this);
        }
    }

    /* compiled from: AppLockSettingsFragment.kt */
    /* loaded from: classes2.dex */
    public static final class d extends kotlin.jvm.internal.o implements kotlin.e0.c.l<View, kotlin.x> {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d() {
            super(1);
            AppLockSettingsFragment.this = r1;
        }

        @Override // kotlin.e0.c.l
        public /* bridge */ /* synthetic */ kotlin.x invoke(View view) {
            invoke2(view);
            return kotlin.x.a;
        }

        /* renamed from: invoke */
        public final void invoke2(View it) {
            kotlin.jvm.internal.m.g(it, "it");
            AppLockSettingsFragment.this.h();
        }
    }

    /* compiled from: AppLockSettingsFragment.kt */
    /* loaded from: classes2.dex */
    public static final class e extends kotlin.jvm.internal.o implements kotlin.e0.c.l<AppLockSettingsViewState, kotlin.x> {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        e() {
            super(1);
            AppLockSettingsFragment.this = r1;
        }

        public final void a(AppLockSettingsViewState appLockSettingsViewState) {
            View view = AppLockSettingsFragment.this.getView();
            ((SwitchCompat) (view == null ? null : view.findViewById(e.j.a.biometricProtectionSwitch))).setChecked(appLockSettingsViewState.getBiometricsProtectionType() != BiometricsProtectionType.anyBiometrics);
            boolean z = appLockSettingsViewState.getAuthenticationMethod() == AuthenticationMethod.BIOMETRIC;
            View view2 = AppLockSettingsFragment.this.getView();
            View biometricSettingLayout = view2 == null ? null : view2.findViewById(e.j.a.biometricSettingLayout);
            kotlin.jvm.internal.m.f(biometricSettingLayout, "biometricSettingLayout");
            biometricSettingLayout.setVisibility(z ? 0 : 8);
            View view3 = AppLockSettingsFragment.this.getView();
            View footerBiometricProtection = view3 != null ? view3.findViewById(e.j.a.footerBiometricProtection) : null;
            kotlin.jvm.internal.m.f(footerBiometricProtection, "footerBiometricProtection");
            footerBiometricProtection.setVisibility(z ? 0 : 8);
        }

        @Override // kotlin.e0.c.l
        public /* bridge */ /* synthetic */ kotlin.x invoke(AppLockSettingsViewState appLockSettingsViewState) {
            a(appLockSettingsViewState);
            return kotlin.x.a;
        }
    }

    /* compiled from: AppLockSettingsFragment.kt */
    /* loaded from: classes2.dex */
    public static final class f extends AuthenticationCallback {

        /* renamed from: b */
        final /* synthetic */ kotlin.e0.c.l<e.j.d.c, kotlin.x> f11237b;

        /* compiled from: AppLockSettingsFragment.kt */
        /* loaded from: classes2.dex */
        static final class a extends kotlin.jvm.internal.o implements kotlin.e0.c.l<c.a, kotlin.x> {
            public static final a a = new a();

            a() {
                super(1);
            }

            @Override // kotlin.e0.c.l
            public /* bridge */ /* synthetic */ kotlin.x invoke(c.a aVar) {
                invoke2(aVar);
                return kotlin.x.a;
            }

            /* renamed from: invoke */
            public final void invoke2(c.a showDialog) {
                kotlin.jvm.internal.m.g(showDialog, "$this$showDialog");
                showDialog.n(R.string.key_invalidated_dialog_title);
                showDialog.f(R.string.key_invalidated_dialog_info);
                e.j.f.k.b(showDialog, R.string.ok);
            }
        }

        /* compiled from: AppLockSettingsFragment.kt */
        /* loaded from: classes2.dex */
        static final class b extends kotlin.jvm.internal.o implements kotlin.e0.c.l<c.a, kotlin.x> {
            public static final b a = new b();

            b() {
                super(1);
            }

            @Override // kotlin.e0.c.l
            public /* bridge */ /* synthetic */ kotlin.x invoke(c.a aVar) {
                invoke2(aVar);
                return kotlin.x.a;
            }

            /* renamed from: invoke */
            public final void invoke2(c.a showDialog) {
                kotlin.jvm.internal.m.g(showDialog, "$this$showDialog");
                showDialog.n(R.string.fatal_authentication_dialog_title);
                showDialog.f(R.string.fatal_authentication_dialog_message);
                e.j.f.k.b(showDialog, R.string.ok);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        f(kotlin.e0.c.l<? super e.j.d.c, kotlin.x> lVar) {
            AppLockSettingsFragment.this = r1;
            this.f11237b = lVar;
        }

        @Override // com.coinbase.wallet.features.applock.legacy.AuthenticationCallback
        public void onAuthenticationError(Throwable th, CharSequence charSequence, Integer num) {
            l.a.a.e(th);
            if (e.j.f.w.b(th)) {
                e.j.f.m.p(AppLockSettingsFragment.this, a.a);
            } else {
                e.j.f.m.p(AppLockSettingsFragment.this, b.a);
            }
        }

        @Override // com.coinbase.wallet.features.applock.legacy.AuthenticationCallback
        public void onAuthenticationLockout(boolean z) {
        }

        @Override // com.coinbase.wallet.features.applock.legacy.AuthenticationCallback
        public void onAuthenticationSucceeded(e.j.d.c permit) {
            kotlin.jvm.internal.m.g(permit, "permit");
            this.f11237b.invoke(permit);
        }
    }

    public static /* synthetic */ boolean A(View view, MotionEvent motionEvent) {
        return u(view, motionEvent);
    }

    public static /* synthetic */ void B(AppLockSettingsFragment appLockSettingsFragment, View view) {
        p(appLockSettingsFragment, view);
    }

    public static /* synthetic */ void C(AppLockSettingsFragment appLockSettingsFragment, View view) {
        o(appLockSettingsFragment, view);
    }

    public static /* synthetic */ boolean D(View view, MotionEvent motionEvent) {
        return s(view, motionEvent);
    }

    public static /* synthetic */ void E(AppLockSettingsFragment appLockSettingsFragment, AuthenticationResult authenticationResult) {
        m(appLockSettingsFragment, authenticationResult);
    }

    public static /* synthetic */ void F(AppLockSettingsFragment appLockSettingsFragment, AuthenticationResult authenticationResult) {
        j(appLockSettingsFragment, authenticationResult);
    }

    private final void H() {
        View view = getView();
        ((TextView) (view == null ? null : view.findViewById(e.j.a.footerMinimumOptions))).startAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.shake));
    }

    private final void I(kotlin.e0.c.l<? super e.j.d.c, kotlin.x> lVar) {
        e().showPinDialog(new f(lVar));
    }

    private final String g(AuthenticationMethod authenticationMethod) {
        int i2;
        int i3 = a.a[authenticationMethod.ordinal()];
        if (i3 == 1) {
            i2 = R.string.biometric;
        } else if (i3 != 2) {
            throw new NoWhenBranchMatchedException();
        } else {
            i2 = R.string.pin;
        }
        String string = getString(i2);
        kotlin.jvm.internal.m.f(string, "getString(resourceId)");
        return string;
    }

    private final FragmentLifecycleScopeProvider getOnDestroyScopeProvider() {
        return Fragment_CommonKt.getFragmentLifecycleScopeProvider(this, i.a.ON_DESTROY);
    }

    public final void h() {
        if (f().b()) {
            Fragment_CommonKt.navigate$default(this, R.id.action_appLockSettingsFragment_to_authenticationFragment, null, null, null, 14, null);
            return;
        }
        w1 w1Var = this.a;
        if (w1Var != null) {
            if (w1Var.a() == AuthenticationMethod.PIN) {
                I(new b());
                return;
            }
            return;
        }
        kotlin.jvm.internal.m.w("viewModel");
        throw null;
    }

    private final void i() {
        if (!v()) {
            View view = getView();
            ((SwitchCompat) (view == null ? null : view.findViewById(e.j.a.requireAuthForAppSwitch))).toggle();
            H();
        }
        View view2 = getView();
        boolean isChecked = ((SwitchCompat) (view2 == null ? null : view2.findViewById(e.j.a.requireAuthForAppSwitch))).isChecked();
        if (!isChecked) {
            ((com.uber.autodispose.a0) e().unlock(new AppLockType.UnlockIfNeeded(true)).subscribeOn(this.f11233b).as(com.uber.autodispose.d.a(getOnDestroyScopeProvider()))).subscribe(new h.c.m0.f() { // from class: com.toshi.view.fragment.m
                @Override // h.c.m0.f
                public final void accept(Object obj) {
                    AppLockSettingsFragment.F(AppLockSettingsFragment.this, (AuthenticationResult) obj);
                }
            }, new h.c.m0.f() { // from class: com.toshi.view.fragment.g
                @Override // h.c.m0.f
                public final void accept(Object obj) {
                    AppLockSettingsFragment.z(AppLockSettingsFragment.this, (Throwable) obj);
                }
            });
            return;
        }
        w1 w1Var = this.a;
        if (w1Var != null) {
            w1Var.g(isChecked);
        } else {
            kotlin.jvm.internal.m.w("viewModel");
            throw null;
        }
    }

    private final void init() {
        initViewModel();
        initViews();
        r();
        initClickListeners();
        initObservables();
        w1 w1Var = this.a;
        if (w1Var != null) {
            w1Var.setup();
        } else {
            kotlin.jvm.internal.m.w("viewModel");
            throw null;
        }
    }

    private final void initClickListeners() {
        View view = getView();
        View closeButton = view == null ? null : view.findViewById(e.j.a.t0);
        kotlin.jvm.internal.m.f(closeButton, "closeButton");
        View_CommonKt.setOnSingleClickListener$default(closeButton, 0L, new c(), 1, null);
        View view2 = getView();
        View lockMethodOption = view2 == null ? null : view2.findViewById(e.j.a.lockMethodOption);
        kotlin.jvm.internal.m.f(lockMethodOption, "lockMethodOption");
        View_CommonKt.setOnSingleClickListener$default(lockMethodOption, 0L, new d(), 1, null);
        View view3 = getView();
        ((SwitchCompat) (view3 == null ? null : view3.findViewById(e.j.a.requireAuthForAppSwitch))).setOnClickListener(new View.OnClickListener() { // from class: com.toshi.view.fragment.j
            @Override // android.view.View.OnClickListener
            public final void onClick(View view4) {
                AppLockSettingsFragment.C(AppLockSettingsFragment.this, view4);
            }
        });
        View view4 = getView();
        ((SwitchCompat) (view4 == null ? null : view4.findViewById(e.j.a.requireAuthForTxnSwitch))).setOnClickListener(new View.OnClickListener() { // from class: com.toshi.view.fragment.i
            @Override // android.view.View.OnClickListener
            public final void onClick(View view5) {
                AppLockSettingsFragment.B(AppLockSettingsFragment.this, view5);
            }
        });
        View view5 = getView();
        ((SwitchCompat) (view5 != null ? view5.findViewById(e.j.a.biometricProtectionSwitch) : null)).setOnClickListener(new View.OnClickListener() { // from class: com.toshi.view.fragment.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view6) {
                AppLockSettingsFragment.x(AppLockSettingsFragment.this, view6);
            }
        });
    }

    private final void initObservables() {
        w1 w1Var = this.a;
        if (w1Var != null) {
            Object as = w1Var.getStateObservable().observeOn(this.f11233b).as(com.uber.autodispose.d.a(getOnDestroyScopeProvider()));
            kotlin.jvm.internal.m.f(as, "viewModel.stateObservable\n            .observeOn(mainScheduler)\n            .`as`(autoDisposable(onDestroyScopeProvider))");
            ObservableSubscribeProxy_CommonKt.subscribeBy$default((com.uber.autodispose.x) as, null, null, new e(), 3, null);
            return;
        }
        kotlin.jvm.internal.m.w("viewModel");
        throw null;
    }

    private final void initViewModel() {
        androidx.lifecycle.b0 a2 = new androidx.lifecycle.d0(this, getViewModelFactory()).a(w1.class);
        kotlin.jvm.internal.m.f(a2, "ViewModelProvider(this, viewModelFactory).get(T::class.java)");
        this.a = (w1) a2;
    }

    private final void initViews() {
        View view = getView();
        SwitchCompat switchCompat = (SwitchCompat) (view == null ? null : view.findViewById(e.j.a.requireAuthForAppSwitch));
        w1 w1Var = this.a;
        if (w1Var != null) {
            switchCompat.setChecked(w1Var.b());
            switchCompat.setOnTouchListener(new View.OnTouchListener() { // from class: com.toshi.view.fragment.k
                @Override // android.view.View.OnTouchListener
                public final boolean onTouch(View view2, MotionEvent motionEvent) {
                    return AppLockSettingsFragment.D(view2, motionEvent);
                }
            });
            View view2 = getView();
            SwitchCompat switchCompat2 = (SwitchCompat) (view2 == null ? null : view2.findViewById(e.j.a.requireAuthForTxnSwitch));
            w1 w1Var2 = this.a;
            if (w1Var2 != null) {
                switchCompat2.setChecked(w1Var2.c());
                switchCompat2.setOnTouchListener(new View.OnTouchListener() { // from class: com.toshi.view.fragment.f
                    @Override // android.view.View.OnTouchListener
                    public final boolean onTouch(View view3, MotionEvent motionEvent) {
                        return AppLockSettingsFragment.y(view3, motionEvent);
                    }
                });
                View view3 = getView();
                ((SwitchCompat) (view3 == null ? null : view3.findViewById(e.j.a.biometricProtectionSwitch))).setOnTouchListener(new View.OnTouchListener() { // from class: com.toshi.view.fragment.h
                    @Override // android.view.View.OnTouchListener
                    public final boolean onTouch(View view4, MotionEvent motionEvent) {
                        return AppLockSettingsFragment.A(view4, motionEvent);
                    }
                });
                boolean z = Build.VERSION.SDK_INT >= 24;
                View view4 = getView();
                View biometricSettingLayout = view4 == null ? null : view4.findViewById(e.j.a.biometricSettingLayout);
                kotlin.jvm.internal.m.f(biometricSettingLayout, "biometricSettingLayout");
                biometricSettingLayout.setVisibility(z ? 0 : 8);
                View view5 = getView();
                View footerBiometricProtection = view5 != null ? view5.findViewById(e.j.a.footerBiometricProtection) : null;
                kotlin.jvm.internal.m.f(footerBiometricProtection, "footerBiometricProtection");
                footerBiometricProtection.setVisibility(z ? 0 : 8);
                return;
            }
            kotlin.jvm.internal.m.w("viewModel");
            throw null;
        }
        kotlin.jvm.internal.m.w("viewModel");
        throw null;
    }

    public static final void j(AppLockSettingsFragment this$0, AuthenticationResult authenticationResult) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        if (authenticationResult instanceof AuthenticationResult.RecoveryPhrase) {
            w1 w1Var = this$0.a;
            if (w1Var != null) {
                w1Var.g(false);
                kotlin.x xVar = kotlin.x.a;
                View view = this$0.getView();
                ((SwitchCompat) (view != null ? view.findViewById(e.j.a.requireAuthForAppSwitch) : null)).setChecked(false);
                return;
            }
            kotlin.jvm.internal.m.w("viewModel");
            throw null;
        } else if (authenticationResult instanceof AuthenticationResult.Error) {
            w1 w1Var2 = this$0.a;
            if (w1Var2 != null) {
                w1Var2.g(true);
                kotlin.x xVar2 = kotlin.x.a;
                View view2 = this$0.getView();
                ((SwitchCompat) (view2 != null ? view2.findViewById(e.j.a.requireAuthForAppSwitch) : null)).setChecked(true);
                return;
            }
            kotlin.jvm.internal.m.w("viewModel");
            throw null;
        } else if (authenticationResult instanceof AuthenticationResult.Cancelled) {
            w1 w1Var3 = this$0.a;
            if (w1Var3 != null) {
                w1Var3.g(true);
                kotlin.x xVar3 = kotlin.x.a;
                View view3 = this$0.getView();
                ((SwitchCompat) (view3 != null ? view3.findViewById(e.j.a.requireAuthForAppSwitch) : null)).setChecked(true);
                return;
            }
            kotlin.jvm.internal.m.w("viewModel");
            throw null;
        }
    }

    public static final void k(AppLockSettingsFragment this$0, Throwable th) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        l.a.a.f(th, "Error while authenticating", new Object[0]);
        w1 w1Var = this$0.a;
        if (w1Var != null) {
            w1Var.g(true);
            kotlin.x xVar = kotlin.x.a;
            View view = this$0.getView();
            ((SwitchCompat) (view != null ? view.findViewById(e.j.a.requireAuthForAppSwitch) : null)).setChecked(true);
            return;
        }
        kotlin.jvm.internal.m.w("viewModel");
        throw null;
    }

    private final void l() {
        if (!v()) {
            View view = getView();
            ((SwitchCompat) (view == null ? null : view.findViewById(e.j.a.requireAuthForTxnSwitch))).toggle();
            H();
        }
        View view2 = getView();
        boolean isChecked = ((SwitchCompat) (view2 == null ? null : view2.findViewById(e.j.a.requireAuthForTxnSwitch))).isChecked();
        if (!isChecked) {
            ((com.uber.autodispose.a0) e().unlock(AppLockType.RequireAuthentication.INSTANCE).subscribeOn(this.f11233b).as(com.uber.autodispose.d.a(getOnDestroyScopeProvider()))).subscribe(new h.c.m0.f() { // from class: com.toshi.view.fragment.l
                @Override // h.c.m0.f
                public final void accept(Object obj) {
                    AppLockSettingsFragment.E(AppLockSettingsFragment.this, (AuthenticationResult) obj);
                }
            }, new h.c.m0.f() { // from class: com.toshi.view.fragment.d
                @Override // h.c.m0.f
                public final void accept(Object obj) {
                    AppLockSettingsFragment.w(AppLockSettingsFragment.this, (Throwable) obj);
                }
            });
            return;
        }
        w1 w1Var = this.a;
        if (w1Var != null) {
            w1Var.h(isChecked);
        } else {
            kotlin.jvm.internal.m.w("viewModel");
            throw null;
        }
    }

    public static final void m(AppLockSettingsFragment this$0, AuthenticationResult authenticationResult) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        if (authenticationResult instanceof AuthenticationResult.RecoveryPhrase) {
            w1 w1Var = this$0.a;
            if (w1Var != null) {
                w1Var.h(false);
                kotlin.x xVar = kotlin.x.a;
                View view = this$0.getView();
                ((SwitchCompat) (view != null ? view.findViewById(e.j.a.requireAuthForTxnSwitch) : null)).setChecked(false);
                return;
            }
            kotlin.jvm.internal.m.w("viewModel");
            throw null;
        } else if (authenticationResult instanceof AuthenticationResult.Error) {
            w1 w1Var2 = this$0.a;
            if (w1Var2 != null) {
                w1Var2.h(true);
                kotlin.x xVar2 = kotlin.x.a;
                View view2 = this$0.getView();
                ((SwitchCompat) (view2 != null ? view2.findViewById(e.j.a.requireAuthForTxnSwitch) : null)).setChecked(true);
                return;
            }
            kotlin.jvm.internal.m.w("viewModel");
            throw null;
        } else if (authenticationResult instanceof AuthenticationResult.Cancelled) {
            w1 w1Var3 = this$0.a;
            if (w1Var3 != null) {
                w1Var3.h(true);
                kotlin.x xVar3 = kotlin.x.a;
                View view3 = this$0.getView();
                ((SwitchCompat) (view3 != null ? view3.findViewById(e.j.a.requireAuthForTxnSwitch) : null)).setChecked(true);
                return;
            }
            kotlin.jvm.internal.m.w("viewModel");
            throw null;
        }
    }

    public static final void n(AppLockSettingsFragment this$0, Throwable th) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        l.a.a.f(th, "Error while authenticating", new Object[0]);
        w1 w1Var = this$0.a;
        if (w1Var != null) {
            w1Var.h(true);
            kotlin.x xVar = kotlin.x.a;
            View view = this$0.getView();
            ((SwitchCompat) (view != null ? view.findViewById(e.j.a.requireAuthForTxnSwitch) : null)).setChecked(true);
            return;
        }
        kotlin.jvm.internal.m.w("viewModel");
        throw null;
    }

    public static final void o(AppLockSettingsFragment this$0, View view) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        this$0.i();
    }

    public static final void p(AppLockSettingsFragment this$0, View view) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        this$0.l();
    }

    public static final void q(AppLockSettingsFragment this$0, View view) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        View view2 = this$0.getView();
        this$0.G(((SwitchCompat) (view2 == null ? null : view2.findViewById(e.j.a.biometricProtectionSwitch))).isChecked());
    }

    private final void r() {
        View lockMethodType;
        if (f().b()) {
            View view = getView();
            ((TextView) (view == null ? null : view.findViewById(e.j.a.lockMethod))).setText(getString(R.string.lock_method));
            View view2 = getView();
            lockMethodType = view2 != null ? view2.findViewById(e.j.a.lockMethodType) : null;
            kotlin.jvm.internal.m.f(lockMethodType, "lockMethodType");
            lockMethodType.setVisibility(0);
            return;
        }
        View view3 = getView();
        ((TextView) (view3 == null ? null : view3.findViewById(e.j.a.lockMethod))).setText(getString(R.string.change_pin));
        View view4 = getView();
        lockMethodType = view4 != null ? view4.findViewById(e.j.a.lockMethodType) : null;
        kotlin.jvm.internal.m.f(lockMethodType, "lockMethodType");
        lockMethodType.setVisibility(8);
    }

    public static final boolean s(View view, MotionEvent motionEvent) {
        return motionEvent.getActionMasked() == 2;
    }

    public static final boolean t(View view, MotionEvent motionEvent) {
        return motionEvent.getActionMasked() == 2;
    }

    public static final boolean u(View view, MotionEvent motionEvent) {
        return motionEvent.getActionMasked() == 2;
    }

    private final boolean v() {
        View view = getView();
        if (!((SwitchCompat) (view == null ? null : view.findViewById(e.j.a.requireAuthForAppSwitch))).isChecked()) {
            View view2 = getView();
            if (!((SwitchCompat) (view2 != null ? view2.findViewById(e.j.a.requireAuthForTxnSwitch) : null)).isChecked()) {
                return false;
            }
        }
        return true;
    }

    public static /* synthetic */ void w(AppLockSettingsFragment appLockSettingsFragment, Throwable th) {
        n(appLockSettingsFragment, th);
    }

    public static /* synthetic */ void x(AppLockSettingsFragment appLockSettingsFragment, View view) {
        q(appLockSettingsFragment, view);
    }

    public static /* synthetic */ boolean y(View view, MotionEvent motionEvent) {
        return t(view, motionEvent);
    }

    public static /* synthetic */ void z(AppLockSettingsFragment appLockSettingsFragment, Throwable th) {
        k(appLockSettingsFragment, th);
    }

    public final void G(boolean z) {
        View view = getView();
        ((SwitchCompat) (view == null ? null : view.findViewById(e.j.a.biometricProtectionSwitch))).toggle();
        w1 w1Var = this.a;
        if (w1Var != null) {
            ((com.uber.autodispose.a0) w1Var.j(z).subscribeOn(this.f11233b).as(com.uber.autodispose.d.a(getOnDestroyScopeProvider()))).subscribe();
        } else {
            kotlin.jvm.internal.m.w("viewModel");
            throw null;
        }
    }

    @Override // com.coinbase.wallet.commonui.views.LockedFragment, com.coinbase.wallet.commonui.views.BaseFragment
    public void _$_clearFindViewByIdCache() {
    }

    @Override // com.coinbase.wallet.commonui.views.StyledFragment
    public c.h.k.d0 applyWindowInsets(View view, c.h.k.d0 d0Var) {
        return StyledFragment.DefaultImpls.applyWindowInsets(this, view, d0Var);
    }

    public final AuthenticationHelper e() {
        AuthenticationHelper authenticationHelper = this.f11236e;
        if (authenticationHelper != null) {
            return authenticationHelper;
        }
        kotlin.jvm.internal.m.w("authenticationHelper");
        throw null;
    }

    public final e.j.l.n.b f() {
        e.j.l.n.b bVar = this.f11235d;
        if (bVar != null) {
            return bVar;
        }
        kotlin.jvm.internal.m.w("biometricHelper");
        throw null;
    }

    @Override // com.coinbase.wallet.commonui.views.StyledFragment
    public StyledFragment.Attributes getAttributes() {
        return StyledFragment.Attributes.copy$default(StyledFragment.DefaultImpls.getAttributes(this), false, true, false, 5, null);
    }

    public final GenericViewModelFactory<w1> getViewModelFactory() {
        GenericViewModelFactory<w1> genericViewModelFactory = this.f11234c;
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
        return inflater.inflate(R.layout.fragment_device_lock_settings, viewGroup, false);
    }

    @Override // com.coinbase.wallet.commonui.views.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        Analytics.INSTANCE.log(AnalyticsEvent_ApplicationKt.deviceLockLanded(AnalyticsEvent.Companion));
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        View view = getView();
        TextView textView = (TextView) (view == null ? null : view.findViewById(e.j.a.lockMethodType));
        w1 w1Var = this.a;
        if (w1Var == null) {
            kotlin.jvm.internal.m.w("viewModel");
            throw null;
        }
        AuthenticationMethod a2 = w1Var.a();
        textView.setText(a2 != null ? g(a2) : null);
    }

    @Override // com.coinbase.wallet.commonui.views.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        kotlin.jvm.internal.m.g(view, "view");
        init();
    }
}