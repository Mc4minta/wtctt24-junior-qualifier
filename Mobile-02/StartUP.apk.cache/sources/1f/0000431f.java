package com.toshi.view.fragment.onboarding.authMethod;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.lifecycle.b0;
import androidx.lifecycle.d0;
import androidx.lifecycle.i;
import com.coinbase.wallet.analytics.Analytics;
import com.coinbase.wallet.analytics.models.AnalyticsEvent;
import com.coinbase.wallet.application.extensions.AnalyticsEvent_ApplicationKt;
import com.coinbase.wallet.application.extensions.TraceKey_ApplicationKt;
import com.coinbase.wallet.commonui.di.GenericViewModelFactory;
import com.coinbase.wallet.commonui.extensions.Fragment_CommonKt;
import com.coinbase.wallet.commonui.utilities.FragmentLifecycleScopeProvider;
import com.coinbase.wallet.commonui.views.StyledFragment;
import com.coinbase.wallet.core.models.TraceKey;
import com.coinbase.wallet.features.applock.legacy.AuthenticationCallback;
import com.coinbase.wallet.features.cloudbackup.models.OnboardingBackupRecoveryPhraseArgs;
import com.coinbase.wallet.performance.Tracer;
import com.coinbase.wallet.user.exceptions.UserException;
import com.toshi.model.local.authentication.AuthenticationMethod;
import com.toshi.model.local.authentication.EncryptionMethod;
import com.toshi.view.custom.SpinnerOverlayLayout;
import com.uber.autodispose.s;
import e.j.n.u2;
import h.c.a0;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.o;
import kotlin.k;
import org.toshi.R;

/* compiled from: NewWalletAuthenticationOnboardingFragment.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 F2\u00020\u00012\u00020\u0002:\u0001GB\u0007¢\u0006\u0004\bE\u0010\u0005J\u000f\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0006\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0006\u0010\u0005J\u001f\u0010\u000b\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\u000b\u0010\fJ!\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0013\u0010\u0005J\u000f\u0010\u0014\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0014\u0010\u0005J)\u0010\u001a\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u00152\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u001c\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\u001c\u0010\u0005R\u0016\u0010 \u001a\u00020\u001d8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010$\u001a\u00020!8B@\u0002X\u0082\u0004¢\u0006\u0006\u001a\u0004\b\"\u0010#R\u001e\u0010)\u001a\n &*\u0004\u0018\u00010%0%8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b'\u0010(R(\u00101\u001a\b\u0012\u0004\u0012\u00020\u001d0*8\u0000@\u0000X\u0081.¢\u0006\u0012\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\u001d\u00107\u001a\u0002028B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b3\u00104\u001a\u0004\b5\u00106R\u001d\u0010<\u001a\u0002088B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b9\u00104\u001a\u0004\b:\u0010;R\u001d\u0010>\u001a\u0002088B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001c\u00104\u001a\u0004\b=\u0010;R\u001c\u0010D\u001a\u00020?8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b@\u0010A\u001a\u0004\bB\u0010C¨\u0006H"}, d2 = {"Lcom/toshi/view/fragment/onboarding/authMethod/NewWalletAuthenticationOnboardingFragment;", "Lcom/toshi/view/fragment/onboarding/authMethod/g;", "Lcom/coinbase/wallet/commonui/views/StyledFragment;", "Lkotlin/x;", "setup", "()V", "z", "Le/j/d/c;", "permit", "Lcom/toshi/model/local/authentication/AuthenticationMethod;", "authenticationMethod", "p", "(Le/j/d/c;Lcom/toshi/model/local/authentication/AuthenticationMethod;)V", "Landroid/view/View;", "view", "Landroid/os/Bundle;", "savedInstanceState", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "onDestroy", "onResume", "", "requestCode", "resultCode", "Landroid/content/Intent;", "data", "onActivityResult", "(IILandroid/content/Intent;)V", "j", "Le/j/n/u2;", "m", "Le/j/n/u2;", "viewModel", "Lcom/coinbase/wallet/commonui/utilities/FragmentLifecycleScopeProvider;", "getOnDestroyScopeProvider", "()Lcom/coinbase/wallet/commonui/utilities/FragmentLifecycleScopeProvider;", "onDestroyScopeProvider", "Lh/c/a0;", "kotlin.jvm.PlatformType", "g", "Lh/c/a0;", "mainScheduler", "Lcom/coinbase/wallet/commonui/di/GenericViewModelFactory;", "n", "Lcom/coinbase/wallet/commonui/di/GenericViewModelFactory;", "getViewModelFactory$app_productionRelease", "()Lcom/coinbase/wallet/commonui/di/GenericViewModelFactory;", "setViewModelFactory$app_productionRelease", "(Lcom/coinbase/wallet/commonui/di/GenericViewModelFactory;)V", "viewModelFactory", "", "k", "Lkotlin/h;", "u", "()Z", "isPublic", "", "h", "getMnemonic", "()Ljava/lang/String;", OnboardingBackupRecoveryPhraseArgs.mnemonicKey, "o", "username", "Lcom/coinbase/wallet/commonui/views/StyledFragment$Attributes;", "l", "Lcom/coinbase/wallet/commonui/views/StyledFragment$Attributes;", "getAttributes", "()Lcom/coinbase/wallet/commonui/views/StyledFragment$Attributes;", "attributes", "<init>", "f", "a", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class NewWalletAuthenticationOnboardingFragment extends g implements StyledFragment {

    /* renamed from: f */
    public static final a f11353f = new a(null);

    /* renamed from: g */
    private final a0 f11354g = h.c.j0.c.a.b();

    /* renamed from: h */
    private final kotlin.h f11355h;

    /* renamed from: j */
    private final kotlin.h f11356j;

    /* renamed from: k */
    private final kotlin.h f11357k;

    /* renamed from: l */
    private final StyledFragment.Attributes f11358l;
    private u2 m;
    public GenericViewModelFactory<u2> n;

    /* compiled from: NewWalletAuthenticationOnboardingFragment.kt */
    /* loaded from: classes2.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Bundle a(String masterSeed, String username, boolean z) {
            m.g(masterSeed, "masterSeed");
            m.g(username, "username");
            Bundle bundle = new Bundle();
            bundle.putString(OnboardingBackupRecoveryPhraseArgs.mnemonicKey, masterSeed);
            bundle.putString("username", username);
            bundle.putBoolean("isPublic", z);
            return bundle;
        }
    }

    /* compiled from: NewWalletAuthenticationOnboardingFragment.kt */
    /* loaded from: classes2.dex */
    static final class b extends o implements kotlin.e0.c.a<Boolean> {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b() {
            super(0);
            NewWalletAuthenticationOnboardingFragment.this = r1;
        }

        @Override // kotlin.e0.c.a
        public /* bridge */ /* synthetic */ Boolean invoke() {
            return Boolean.valueOf(invoke2());
        }

        /* renamed from: invoke */
        public final boolean invoke2() {
            return e.j.f.e.a(NewWalletAuthenticationOnboardingFragment.this.getArguments(), "isPublic");
        }
    }

    /* compiled from: NewWalletAuthenticationOnboardingFragment.kt */
    /* loaded from: classes2.dex */
    static final class c extends o implements kotlin.e0.c.a<String> {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c() {
            super(0);
            NewWalletAuthenticationOnboardingFragment.this = r1;
        }

        @Override // kotlin.e0.c.a
        public final String invoke() {
            return e.j.f.e.d(NewWalletAuthenticationOnboardingFragment.this.getArguments(), OnboardingBackupRecoveryPhraseArgs.mnemonicKey);
        }
    }

    /* compiled from: NewWalletAuthenticationOnboardingFragment.kt */
    /* loaded from: classes2.dex */
    public static final class d extends AuthenticationCallback {
        d() {
            NewWalletAuthenticationOnboardingFragment.this = r1;
        }

        @Override // com.coinbase.wallet.features.applock.legacy.AuthenticationCallback
        public void onAuthenticationLockout(boolean z) {
        }

        @Override // com.coinbase.wallet.features.applock.legacy.AuthenticationCallback
        public void onAuthenticationSucceeded(e.j.d.c permit) {
            m.g(permit, "permit");
            Analytics.INSTANCE.log(AnalyticsEvent_ApplicationKt.authMethodBiometricSuccess(AnalyticsEvent.Companion));
            NewWalletAuthenticationOnboardingFragment.this.p(permit, AuthenticationMethod.BIOMETRIC);
        }
    }

    /* compiled from: NewWalletAuthenticationOnboardingFragment.kt */
    /* loaded from: classes2.dex */
    static final class e extends o implements kotlin.e0.c.a<String> {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        e() {
            super(0);
            NewWalletAuthenticationOnboardingFragment.this = r1;
        }

        @Override // kotlin.e0.c.a
        public final String invoke() {
            return e.j.f.e.d(NewWalletAuthenticationOnboardingFragment.this.getArguments(), "username");
        }
    }

    public NewWalletAuthenticationOnboardingFragment() {
        kotlin.h b2;
        kotlin.h b3;
        kotlin.h b4;
        b2 = k.b(new c());
        this.f11355h = b2;
        b3 = k.b(new e());
        this.f11356j = b3;
        b4 = k.b(new b());
        this.f11357k = b4;
        this.f11358l = new StyledFragment.Attributes(true, false, false, 6, null);
    }

    private final String getMnemonic() {
        return (String) this.f11355h.getValue();
    }

    private final FragmentLifecycleScopeProvider getOnDestroyScopeProvider() {
        return Fragment_CommonKt.getFragmentLifecycleScopeProvider(this, i.a.ON_DESTROY);
    }

    private final String o() {
        return (String) this.f11356j.getValue();
    }

    public final void p(e.j.d.c cVar, AuthenticationMethod authenticationMethod) {
        u2 u2Var = this.m;
        if (u2Var != null) {
            ((s) u2Var.f(getMnemonic(), cVar, authenticationMethod, o(), u()).s(this.f11354g).o(new h.c.m0.f() { // from class: com.toshi.view.fragment.onboarding.authMethod.b
                @Override // h.c.m0.f
                public final void accept(Object obj) {
                    NewWalletAuthenticationOnboardingFragment.w(NewWalletAuthenticationOnboardingFragment.this, (h.c.k0.b) obj);
                }
            }).p(new h.c.m0.a() { // from class: com.toshi.view.fragment.onboarding.authMethod.d
                @Override // h.c.m0.a
                public final void run() {
                    NewWalletAuthenticationOnboardingFragment.y(NewWalletAuthenticationOnboardingFragment.this);
                }
            }).f(com.uber.autodispose.d.a(getOnDestroyScopeProvider()))).b(new h.c.m0.a() { // from class: com.toshi.view.fragment.onboarding.authMethod.a
                @Override // h.c.m0.a
                public final void run() {
                    NewWalletAuthenticationOnboardingFragment.v(NewWalletAuthenticationOnboardingFragment.this);
                }
            }, new h.c.m0.f() { // from class: com.toshi.view.fragment.onboarding.authMethod.c
                @Override // h.c.m0.f
                public final void accept(Object obj) {
                    NewWalletAuthenticationOnboardingFragment.x(NewWalletAuthenticationOnboardingFragment.this, (Throwable) obj);
                }
            });
        } else {
            m.w("viewModel");
            throw null;
        }
    }

    public static final void q(NewWalletAuthenticationOnboardingFragment this$0, h.c.k0.b bVar) {
        m.g(this$0, "this$0");
        View view = this$0.getView();
        ((SpinnerOverlayLayout) (view == null ? null : view.findViewById(e.j.a.spinnerOverlay))).b(true);
        Tracer.INSTANCE.start(TraceKey_ApplicationKt.getRegisterNewUserKey(TraceKey.Companion));
    }

    public static final void r(NewWalletAuthenticationOnboardingFragment this$0) {
        m.g(this$0, "this$0");
        View view = this$0.getView();
        ((SpinnerOverlayLayout) (view == null ? null : view.findViewById(e.j.a.spinnerOverlay))).b(false);
        Tracer.INSTANCE.stop(TraceKey_ApplicationKt.getRegisterNewUserKey(TraceKey.Companion));
    }

    public static final void s(NewWalletAuthenticationOnboardingFragment this$0) {
        m.g(this$0, "this$0");
        u2 u2Var = this$0.m;
        if (u2Var != null) {
            u2Var.k(true);
            u2 u2Var2 = this$0.m;
            if (u2Var2 != null) {
                u2Var2.l();
                Analytics analytics = Analytics.INSTANCE;
                AnalyticsEvent.Companion companion = AnalyticsEvent.Companion;
                analytics.log(AnalyticsEvent_ApplicationKt.newWalletCreated(companion));
                analytics.log(AnalyticsEvent_ApplicationKt.onboardingSuccess(companion));
                Fragment_CommonKt.navigate$default(this$0, R.id.action_newWalletAuthenticationFragment_to_onboardingBackupRecoveryPhraseFragment, OnboardingBackupRecoveryPhraseArgs.INSTANCE.createArguments(this$0.getMnemonic()), null, null, 12, null);
                return;
            }
            m.w("viewModel");
            throw null;
        }
        m.w("viewModel");
        throw null;
    }

    private final void setup() {
        b0 a2 = new d0(this, getViewModelFactory$app_productionRelease()).a(u2.class);
        m.f(a2, "ViewModelProvider(this, viewModelFactory).get(T::class.java)");
        this.m = (u2) a2;
        setupClickListeners();
    }

    public static final void t(NewWalletAuthenticationOnboardingFragment this$0, Throwable it) {
        m.g(this$0, "this$0");
        if (it instanceof UserException.UsernameAlreadyTakenException) {
            Fragment_CommonKt.navigateUp(this$0);
            return;
        }
        m.f(it, "it");
        e.j.f.m.u(this$0, e.j.l.t.a.a(it), 0, 2, null);
        l.a.a.f(it, "Error while creating new wallet", new Object[0]);
    }

    private final boolean u() {
        return ((Boolean) this.f11357k.getValue()).booleanValue();
    }

    public static /* synthetic */ void v(NewWalletAuthenticationOnboardingFragment newWalletAuthenticationOnboardingFragment) {
        s(newWalletAuthenticationOnboardingFragment);
    }

    public static /* synthetic */ void w(NewWalletAuthenticationOnboardingFragment newWalletAuthenticationOnboardingFragment, h.c.k0.b bVar) {
        q(newWalletAuthenticationOnboardingFragment, bVar);
    }

    public static /* synthetic */ void x(NewWalletAuthenticationOnboardingFragment newWalletAuthenticationOnboardingFragment, Throwable th) {
        t(newWalletAuthenticationOnboardingFragment, th);
    }

    public static /* synthetic */ void y(NewWalletAuthenticationOnboardingFragment newWalletAuthenticationOnboardingFragment) {
        r(newWalletAuthenticationOnboardingFragment);
    }

    private final void z() {
        u2 u2Var = this.m;
        if (u2Var != null) {
            u2Var.a();
            h().authenticateWithBiometricPrompt(EncryptionMethod.ENCRYPTION, new d(), Boolean.FALSE);
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
        return this.f11358l;
    }

    public final GenericViewModelFactory<u2> getViewModelFactory$app_productionRelease() {
        GenericViewModelFactory<u2> genericViewModelFactory = this.n;
        if (genericViewModelFactory != null) {
            return genericViewModelFactory;
        }
        m.w("viewModelFactory");
        throw null;
    }

    @Override // com.toshi.view.fragment.onboarding.authMethod.g
    protected void j() {
        if (e.j.f.m.h(this)) {
            z();
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
        e.j.d.d dVar = new e.j.d.d(stringExtra);
        Analytics.INSTANCE.log(AnalyticsEvent_ApplicationKt.authMethodPinSuccess(AnalyticsEvent.Companion));
        p(dVar, AuthenticationMethod.PIN);
    }

    @Override // com.coinbase.wallet.commonui.views.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        h().clear();
    }

    @Override // com.toshi.view.fragment.onboarding.authMethod.g, com.coinbase.wallet.commonui.views.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        Analytics.INSTANCE.log(AnalyticsEvent_ApplicationKt.authMethodLanded(AnalyticsEvent.Companion));
    }

    @Override // com.toshi.view.fragment.onboarding.authMethod.g, com.coinbase.wallet.commonui.views.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        m.g(view, "view");
        super.onViewCreated(view, bundle);
        setup();
    }
}