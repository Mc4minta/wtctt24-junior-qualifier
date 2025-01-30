package com.toshi.view.fragment.onboarding.authMethod;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.lifecycle.b0;
import androidx.lifecycle.d0;
import androidx.lifecycle.i;
import com.coinbase.wallet.analytics.extensions.Single_AnalyticsKt;
import com.coinbase.wallet.application.MainActivity;
import com.coinbase.wallet.application.extensions.TraceKey_ApplicationKt;
import com.coinbase.wallet.common.extensions.SingleSubscribeProxy_CommonKt;
import com.coinbase.wallet.commonui.di.GenericViewModelFactory;
import com.coinbase.wallet.commonui.extensions.Fragment_CommonKt;
import com.coinbase.wallet.commonui.utilities.FragmentLifecycleScopeProvider;
import com.coinbase.wallet.commonui.views.StyledFragment;
import com.coinbase.wallet.core.models.TraceKey;
import com.coinbase.wallet.features.applock.legacy.AuthenticationCallback;
import com.coinbase.wallet.performance.Tracer;
import com.toshi.exception.InvalidOnboardingStateException;
import com.toshi.model.local.OnboardingState;
import com.toshi.model.local.authentication.AuthenticationMethod;
import com.toshi.model.local.authentication.EncryptionMethod;
import com.toshi.view.custom.SpinnerOverlayLayout;
import e.j.n.f3;
import h.c.a0;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.e0.c.l;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.o;
import kotlin.k;
import kotlin.x;

/* compiled from: SignInWalletAuthenticationOnboardingFragment.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 H2\u00020\u00012\u00020\u0002:\u0001IB\u0007¢\u0006\u0004\bG\u0010\u0005J\u000f\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0006\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0006\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0007\u0010\u0005J\u001f\u0010\f\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\f\u0010\rJ!\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0014\u0010\u0005J\u000f\u0010\u0015\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\u0015\u0010\u0005J)\u0010\u001b\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u00162\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019H\u0016¢\u0006\u0004\b\u001b\u0010\u001cR\u0016\u0010 \u001a\u00020\u001d8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR(\u0010(\u001a\b\u0012\u0004\u0012\u00020\u001d0!8\u0000@\u0000X\u0081.¢\u0006\u0012\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u001d\u0010.\u001a\u00020)8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-R\u001d\u00102\u001a\u00020/8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010+\u001a\u0004\b0\u00101R\u001e\u00107\u001a\n 4*\u0004\u0018\u000103038\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b5\u00106R\u0016\u0010;\u001a\u0002088B@\u0002X\u0082\u0004¢\u0006\u0006\u001a\u0004\b9\u0010:R\u001f\u0010@\u001a\u0004\u0018\u00010<8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b=\u0010+\u001a\u0004\b>\u0010?R\u001c\u0010F\u001a\u00020A8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\bB\u0010C\u001a\u0004\bD\u0010E¨\u0006J"}, d2 = {"Lcom/toshi/view/fragment/onboarding/authMethod/SignInWalletAuthenticationOnboardingFragment;", "Lcom/toshi/view/fragment/onboarding/authMethod/g;", "Lcom/coinbase/wallet/commonui/views/StyledFragment;", "Lkotlin/x;", "init", "()V", "initViewModel", "w", "Le/j/d/c;", "permit", "Lcom/toshi/model/local/authentication/AuthenticationMethod;", "authenticationMethod", "r", "(Le/j/d/c;Lcom/toshi/model/local/authentication/AuthenticationMethod;)V", "Landroid/view/View;", "view", "Landroid/os/Bundle;", "savedInstanceState", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "onDestroy", "j", "", "requestCode", "resultCode", "Landroid/content/Intent;", "data", "onActivityResult", "(IILandroid/content/Intent;)V", "Le/j/n/f3;", "h", "Le/j/n/f3;", "viewModel", "Lcom/coinbase/wallet/commonui/di/GenericViewModelFactory;", "n", "Lcom/coinbase/wallet/commonui/di/GenericViewModelFactory;", "getViewModelFactory$app_productionRelease", "()Lcom/coinbase/wallet/commonui/di/GenericViewModelFactory;", "setViewModelFactory$app_productionRelease", "(Lcom/coinbase/wallet/commonui/di/GenericViewModelFactory;)V", "viewModelFactory", "", "l", "Lkotlin/h;", "o", "()Z", "hasCloudBackup", "", "p", "()Ljava/lang/String;", "masterSeed", "Lh/c/a0;", "kotlin.jvm.PlatformType", "g", "Lh/c/a0;", "mainScheduler", "Lcom/coinbase/wallet/commonui/utilities/FragmentLifecycleScopeProvider;", "getOnDestroyScopeProvider", "()Lcom/coinbase/wallet/commonui/utilities/FragmentLifecycleScopeProvider;", "onDestroyScopeProvider", "Ljava/io/Serializable;", "k", "q", "()Ljava/io/Serializable;", "onboardingState", "Lcom/coinbase/wallet/commonui/views/StyledFragment$Attributes;", "m", "Lcom/coinbase/wallet/commonui/views/StyledFragment$Attributes;", "getAttributes", "()Lcom/coinbase/wallet/commonui/views/StyledFragment$Attributes;", "attributes", "<init>", "f", "a", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class SignInWalletAuthenticationOnboardingFragment extends com.toshi.view.fragment.onboarding.authMethod.g implements StyledFragment {

    /* renamed from: f */
    public static final a f11359f = new a(null);

    /* renamed from: g */
    private final a0 f11360g = h.c.j0.c.a.b();

    /* renamed from: h */
    private f3 f11361h;

    /* renamed from: j */
    private final kotlin.h f11362j;

    /* renamed from: k */
    private final kotlin.h f11363k;

    /* renamed from: l */
    private final kotlin.h f11364l;
    private final StyledFragment.Attributes m;
    public GenericViewModelFactory<f3> n;

    /* compiled from: SignInWalletAuthenticationOnboardingFragment.kt */
    /* loaded from: classes2.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ Bundle b(a aVar, String str, OnboardingState onboardingState, boolean z, int i2, Object obj) {
            if ((i2 & 4) != 0) {
                z = false;
            }
            return aVar.a(str, onboardingState, z);
        }

        public final Bundle a(String masterSeed, OnboardingState onboardingState, boolean z) {
            m.g(masterSeed, "masterSeed");
            m.g(onboardingState, "onboardingState");
            Bundle bundle = new Bundle();
            bundle.putString("masterSeed", masterSeed);
            bundle.putSerializable("onboardingState", onboardingState);
            bundle.putBoolean("hasCloudBackup", z);
            return bundle;
        }
    }

    /* compiled from: SignInWalletAuthenticationOnboardingFragment.kt */
    /* loaded from: classes2.dex */
    public static final class b extends o implements l<Throwable, x> {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b() {
            super(1);
            SignInWalletAuthenticationOnboardingFragment.this = r1;
        }

        @Override // kotlin.e0.c.l
        public /* bridge */ /* synthetic */ x invoke(Throwable th) {
            invoke2(th);
            return x.a;
        }

        /* renamed from: invoke */
        public final void invoke2(Throwable it) {
            m.g(it, "it");
            e.j.f.m.u(SignInWalletAuthenticationOnboardingFragment.this, e.j.l.t.a.a(it), 0, 2, null);
            l.a.a.f(it, "Error while creating new wallet", new Object[0]);
        }
    }

    /* compiled from: SignInWalletAuthenticationOnboardingFragment.kt */
    /* loaded from: classes2.dex */
    public static final class c extends o implements l<x, x> {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c() {
            super(1);
            SignInWalletAuthenticationOnboardingFragment.this = r1;
        }

        @Override // kotlin.e0.c.l
        public /* bridge */ /* synthetic */ x invoke(x xVar) {
            invoke2(xVar);
            return x.a;
        }

        /* renamed from: invoke */
        public final void invoke2(x xVar) {
            SignInWalletAuthenticationOnboardingFragment signInWalletAuthenticationOnboardingFragment = SignInWalletAuthenticationOnboardingFragment.this;
            signInWalletAuthenticationOnboardingFragment.startActivity(new Intent(signInWalletAuthenticationOnboardingFragment.getActivity(), MainActivity.class));
            androidx.fragment.app.d activity = signInWalletAuthenticationOnboardingFragment.getActivity();
            if (activity == null) {
                return;
            }
            activity.finish();
        }
    }

    /* compiled from: SignInWalletAuthenticationOnboardingFragment.kt */
    /* loaded from: classes2.dex */
    static final class d extends o implements kotlin.e0.c.a<Boolean> {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d() {
            super(0);
            SignInWalletAuthenticationOnboardingFragment.this = r1;
        }

        @Override // kotlin.e0.c.a
        public /* bridge */ /* synthetic */ Boolean invoke() {
            return Boolean.valueOf(invoke2());
        }

        /* renamed from: invoke */
        public final boolean invoke2() {
            Bundle arguments = SignInWalletAuthenticationOnboardingFragment.this.getArguments();
            if (arguments == null) {
                return false;
            }
            return arguments.getBoolean("hasCloudBackup", false);
        }
    }

    /* compiled from: SignInWalletAuthenticationOnboardingFragment.kt */
    /* loaded from: classes2.dex */
    static final class e extends o implements kotlin.e0.c.a<String> {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        e() {
            super(0);
            SignInWalletAuthenticationOnboardingFragment.this = r1;
        }

        @Override // kotlin.e0.c.a
        public final String invoke() {
            return e.j.f.e.d(SignInWalletAuthenticationOnboardingFragment.this.getArguments(), "masterSeed");
        }
    }

    /* compiled from: SignInWalletAuthenticationOnboardingFragment.kt */
    /* loaded from: classes2.dex */
    static final class f extends o implements kotlin.e0.c.a<Serializable> {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        f() {
            super(0);
            SignInWalletAuthenticationOnboardingFragment.this = r1;
        }

        @Override // kotlin.e0.c.a
        /* renamed from: a */
        public final Serializable invoke() {
            Bundle arguments = SignInWalletAuthenticationOnboardingFragment.this.getArguments();
            if (arguments == null) {
                return null;
            }
            return e.j.f.e.c(arguments, "onboardingState");
        }
    }

    /* compiled from: SignInWalletAuthenticationOnboardingFragment.kt */
    /* loaded from: classes2.dex */
    public static final class g extends AuthenticationCallback {
        g() {
            SignInWalletAuthenticationOnboardingFragment.this = r1;
        }

        @Override // com.coinbase.wallet.features.applock.legacy.AuthenticationCallback
        public void onAuthenticationLockout(boolean z) {
        }

        @Override // com.coinbase.wallet.features.applock.legacy.AuthenticationCallback
        public void onAuthenticationSucceeded(e.j.d.c permit) {
            m.g(permit, "permit");
            if (permit instanceof e.j.d.a) {
                SignInWalletAuthenticationOnboardingFragment.this.r(permit, AuthenticationMethod.BIOMETRIC);
            } else {
                onAuthenticationFailed();
            }
        }
    }

    public SignInWalletAuthenticationOnboardingFragment() {
        kotlin.h b2;
        kotlin.h b3;
        kotlin.h b4;
        b2 = k.b(new e());
        this.f11362j = b2;
        b3 = k.b(new f());
        this.f11363k = b3;
        b4 = k.b(new d());
        this.f11364l = b4;
        this.m = new StyledFragment.Attributes(true, false, false, 6, null);
    }

    private final FragmentLifecycleScopeProvider getOnDestroyScopeProvider() {
        return Fragment_CommonKt.getFragmentLifecycleScopeProvider(this, i.a.ON_DESTROY);
    }

    private final void init() {
        initViewModel();
        setupClickListeners();
    }

    private final void initViewModel() {
        b0 a2 = new d0(this, getViewModelFactory$app_productionRelease()).a(f3.class);
        m.f(a2, "ViewModelProvider(this, viewModelFactory).get(T::class.java)");
        this.f11361h = (f3) a2;
    }

    private final boolean o() {
        return ((Boolean) this.f11364l.getValue()).booleanValue();
    }

    private final String p() {
        return (String) this.f11362j.getValue();
    }

    private final Serializable q() {
        return (Serializable) this.f11363k.getValue();
    }

    public final void r(e.j.d.c cVar, AuthenticationMethod authenticationMethod) {
        if (q() == OnboardingState.EXISTING_USER) {
            f3 f3Var = this.f11361h;
            if (f3Var != null) {
                h.c.b0<x> doAfterTerminate = f3Var.f(p(), cVar, authenticationMethod, o()).observeOn(this.f11360g).doOnSubscribe(new h.c.m0.f() { // from class: com.toshi.view.fragment.onboarding.authMethod.f
                    @Override // h.c.m0.f
                    public final void accept(Object obj) {
                        SignInWalletAuthenticationOnboardingFragment.v(SignInWalletAuthenticationOnboardingFragment.this, (h.c.k0.b) obj);
                    }
                }).doAfterTerminate(new h.c.m0.a() { // from class: com.toshi.view.fragment.onboarding.authMethod.e
                    @Override // h.c.m0.a
                    public final void run() {
                        SignInWalletAuthenticationOnboardingFragment.u(SignInWalletAuthenticationOnboardingFragment.this);
                    }
                });
                m.f(doAfterTerminate, "viewModel.registerExistingUser(masterSeed, permit, authenticationMethod, hasCloudBackup)\n                    .observeOn(mainScheduler)\n                    .doOnSubscribe {\n                        spinnerOverlay.isOverlayVisible(true)\n                        Tracer.start(TraceKey.registerExistingUserKey)\n                    }\n                    .doAfterTerminate {\n                        spinnerOverlay.isOverlayVisible(false)\n                        Tracer.stop(TraceKey.registerExistingUserKey)\n                    }");
                Object as = Single_AnalyticsKt.logError$default(doAfterTerminate, "Had error signing user in", null, 2, null).as(com.uber.autodispose.d.a(getOnDestroyScopeProvider()));
                m.f(as, "viewModel.registerExistingUser(masterSeed, permit, authenticationMethod, hasCloudBackup)\n                    .observeOn(mainScheduler)\n                    .doOnSubscribe {\n                        spinnerOverlay.isOverlayVisible(true)\n                        Tracer.start(TraceKey.registerExistingUserKey)\n                    }\n                    .doAfterTerminate {\n                        spinnerOverlay.isOverlayVisible(false)\n                        Tracer.stop(TraceKey.registerExistingUserKey)\n                    }\n                    .logError(\"Had error signing user in\")\n                    .`as`(autoDisposable<Unit>(onDestroyScopeProvider))");
                SingleSubscribeProxy_CommonKt.subscribeBy((com.uber.autodispose.a0) as, new b(), new c());
                return;
            }
            m.w("viewModel");
            throw null;
        }
        throw new InvalidOnboardingStateException("User should not be here with an invalid mnemonic.");
    }

    public static final void s(SignInWalletAuthenticationOnboardingFragment this$0, h.c.k0.b bVar) {
        m.g(this$0, "this$0");
        View view = this$0.getView();
        ((SpinnerOverlayLayout) (view == null ? null : view.findViewById(e.j.a.spinnerOverlay))).b(true);
        Tracer.INSTANCE.start(TraceKey_ApplicationKt.getRegisterExistingUserKey(TraceKey.Companion));
    }

    public static final void t(SignInWalletAuthenticationOnboardingFragment this$0) {
        m.g(this$0, "this$0");
        View view = this$0.getView();
        ((SpinnerOverlayLayout) (view == null ? null : view.findViewById(e.j.a.spinnerOverlay))).b(false);
        Tracer.INSTANCE.stop(TraceKey_ApplicationKt.getRegisterExistingUserKey(TraceKey.Companion));
    }

    public static /* synthetic */ void u(SignInWalletAuthenticationOnboardingFragment signInWalletAuthenticationOnboardingFragment) {
        t(signInWalletAuthenticationOnboardingFragment);
    }

    public static /* synthetic */ void v(SignInWalletAuthenticationOnboardingFragment signInWalletAuthenticationOnboardingFragment, h.c.k0.b bVar) {
        s(signInWalletAuthenticationOnboardingFragment, bVar);
    }

    private final void w() {
        f3 f3Var = this.f11361h;
        if (f3Var != null) {
            f3Var.a();
            h().authenticateWithBiometricPrompt(EncryptionMethod.ENCRYPTION, new g(), Boolean.FALSE);
            return;
        }
        m.w("viewModel");
        throw null;
    }

    @Override // com.toshi.view.fragment.onboarding.authMethod.g, com.toshi.view.fragment.o0, com.coinbase.wallet.commonui.views.BaseFragment
    public void _$_clearFindViewByIdCache() {
    }

    @Override // com.toshi.view.fragment.onboarding.authMethod.g, com.coinbase.wallet.commonui.views.StyledFragment
    public StyledFragment.Attributes getAttributes() {
        return this.m;
    }

    public final GenericViewModelFactory<f3> getViewModelFactory$app_productionRelease() {
        GenericViewModelFactory<f3> genericViewModelFactory = this.n;
        if (genericViewModelFactory != null) {
            return genericViewModelFactory;
        }
        m.w("viewModelFactory");
        throw null;
    }

    @Override // com.toshi.view.fragment.onboarding.authMethod.g
    protected void j() {
        if (e.j.f.m.h(this)) {
            w();
        } else {
            l();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i2, int i3, Intent intent) {
        String stringExtra;
        super.onActivityResult(i2, i3, intent);
        if (i2 != 102 || i3 != -1 || intent == null || (stringExtra = intent.getStringExtra("pin")) == null) {
            return;
        }
        r(new e.j.d.d(stringExtra), AuthenticationMethod.PIN);
    }

    @Override // com.coinbase.wallet.commonui.views.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        h().clear();
    }

    @Override // com.toshi.view.fragment.onboarding.authMethod.g, com.coinbase.wallet.commonui.views.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        m.g(view, "view");
        super.onViewCreated(view, bundle);
        init();
    }
}