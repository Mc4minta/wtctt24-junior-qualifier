package e.j.n;

import com.coinbase.wallet.analytics.Analytics;
import com.coinbase.wallet.analytics.models.AnalyticsEvent;
import com.coinbase.wallet.application.extensions.AnalyticsEvent_ApplicationKt;
import com.coinbase.wallet.application.model.BiometricsProtectionType;
import com.coinbase.wallet.application.repository.interfaces.AppLockRepositoryInterface;
import com.coinbase.wallet.application.repository.interfaces.MnemonicRepositoryInterface;
import com.coinbase.wallet.features.applock.legacy.AuthenticationCallback;
import com.coinbase.wallet.features.applock.legacy.AuthenticationHelper;
import com.toshi.model.local.AppLockSettingsViewState;
import com.toshi.model.local.authentication.AuthenticationMethod;
import com.toshi.model.local.authentication.EncryptionMethod;

/* compiled from: AppLockSettingsViewModel.kt */
/* loaded from: classes2.dex */
public final class w1 extends androidx.lifecycle.b0 {
    private final AppLockRepositoryInterface a;

    /* renamed from: b */
    private final AuthenticationHelper f13988b;

    /* renamed from: c */
    private final MnemonicRepositoryInterface f13989c;

    /* renamed from: d */
    private final e.j.d.g.t f13990d;

    /* renamed from: e */
    private final h.c.v0.b<AppLockSettingsViewState> f13991e;

    /* renamed from: f */
    private AppLockSettingsViewState f13992f;

    /* renamed from: g */
    private final h.c.s<AppLockSettingsViewState> f13993g;

    /* compiled from: AppLockSettingsViewModel.kt */
    /* loaded from: classes2.dex */
    public static final class a extends AuthenticationCallback {
        final /* synthetic */ h.c.v0.e<e.j.d.a> a;

        a(h.c.v0.e<e.j.d.a> eVar) {
            this.a = eVar;
        }

        @Override // com.coinbase.wallet.features.applock.legacy.AuthenticationCallback
        public void onAuthenticationLockout(boolean z) {
        }

        @Override // com.coinbase.wallet.features.applock.legacy.AuthenticationCallback
        public void onAuthenticationSucceeded(e.j.d.c permit) {
            kotlin.jvm.internal.m.g(permit, "permit");
            if (permit instanceof e.j.d.a) {
                this.a.onSuccess(permit);
            } else {
                onAuthenticationCancelled();
            }
        }
    }

    /* compiled from: AppLockSettingsViewModel.kt */
    /* loaded from: classes2.dex */
    public static final class b extends AuthenticationCallback {
        final /* synthetic */ h.c.v0.e<e.j.d.a> a;

        b(h.c.v0.e<e.j.d.a> eVar) {
            this.a = eVar;
        }

        @Override // com.coinbase.wallet.features.applock.legacy.AuthenticationCallback
        public void onAuthenticationLockout(boolean z) {
        }

        @Override // com.coinbase.wallet.features.applock.legacy.AuthenticationCallback
        public void onAuthenticationSucceeded(e.j.d.c permit) {
            kotlin.jvm.internal.m.g(permit, "permit");
            if (permit instanceof e.j.d.a) {
                this.a.onSuccess(permit);
            } else {
                onAuthenticationCancelled();
            }
        }
    }

    public w1(AppLockRepositoryInterface appLockRepository, AuthenticationHelper authenticationHelper, MnemonicRepositoryInterface mnemonicRepository, e.j.d.g.t keyStoreKeyHandler) {
        kotlin.jvm.internal.m.g(appLockRepository, "appLockRepository");
        kotlin.jvm.internal.m.g(authenticationHelper, "authenticationHelper");
        kotlin.jvm.internal.m.g(mnemonicRepository, "mnemonicRepository");
        kotlin.jvm.internal.m.g(keyStoreKeyHandler, "keyStoreKeyHandler");
        this.a = appLockRepository;
        this.f13988b = authenticationHelper;
        this.f13989c = mnemonicRepository;
        this.f13990d = keyStoreKeyHandler;
        h.c.v0.b<AppLockSettingsViewState> d2 = h.c.v0.b.d();
        kotlin.jvm.internal.m.f(d2, "create()");
        this.f13991e = d2;
        this.f13992f = new AppLockSettingsViewState(null, null, 3, null);
        h.c.s<AppLockSettingsViewState> hide = d2.hide();
        kotlin.jvm.internal.m.f(hide, "stateSubject.hide()");
        this.f13993g = hide;
    }

    public static /* synthetic */ kotlin.x d(boolean z, w1 w1Var, kotlin.x xVar) {
        return m(z, w1Var, xVar);
    }

    public static /* synthetic */ h.c.h0 e(w1 w1Var, kotlin.o oVar) {
        return l(w1Var, oVar);
    }

    public static /* synthetic */ e.j.d.a f(w1 w1Var, b bVar, boolean z, e.j.d.a aVar) {
        return k(w1Var, bVar, z, aVar);
    }

    private final void i(AppLockSettingsViewState appLockSettingsViewState) {
        this.f13992f = appLockSettingsViewState;
        this.f13991e.onNext(appLockSettingsViewState);
    }

    public static final e.j.d.a k(w1 this$0, b encryptionCallback, boolean z, e.j.d.a decryptionPermit) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(encryptionCallback, "$encryptionCallback");
        kotlin.jvm.internal.m.g(decryptionPermit, "decryptionPermit");
        this$0.f13988b.authenticateWithBiometricPrompt(EncryptionMethod.ENCRYPTION, encryptionCallback, Boolean.valueOf(z));
        return decryptionPermit;
    }

    public static final h.c.h0 l(w1 this$0, kotlin.o dstr$decryptionPermit$encryptionPermit) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(dstr$decryptionPermit$encryptionPermit, "$dstr$decryptionPermit$encryptionPermit");
        e.j.d.a decryptionPermit = (e.j.d.a) dstr$decryptionPermit$encryptionPermit.a();
        e.j.d.a encryptionPermit = (e.j.d.a) dstr$decryptionPermit$encryptionPermit.b();
        AppLockRepositoryInterface appLockRepositoryInterface = this$0.a;
        kotlin.jvm.internal.m.f(decryptionPermit, "decryptionPermit");
        kotlin.jvm.internal.m.f(encryptionPermit, "encryptionPermit");
        return appLockRepositoryInterface.changeBiometricPermit(decryptionPermit, encryptionPermit);
    }

    public static final kotlin.x m(boolean z, w1 this$0, kotlin.x it) {
        BiometricsProtectionType biometricsProtectionType;
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(it, "it");
        if (z) {
            biometricsProtectionType = BiometricsProtectionType.currentBiometrics;
            this$0.f13990d.f(BiometricsProtectionType.anyBiometrics);
        } else {
            biometricsProtectionType = BiometricsProtectionType.anyBiometrics;
            this$0.f13990d.f(BiometricsProtectionType.currentBiometrics);
        }
        this$0.f13989c.setBiometricsProtectionType(biometricsProtectionType);
        this$0.i(AppLockSettingsViewState.copy$default(this$0.f13992f, biometricsProtectionType, null, 2, null));
        Analytics.INSTANCE.log(AnalyticsEvent_ApplicationKt.deviceLockBiometryProtectionEnabled(AnalyticsEvent.Companion, z));
        return kotlin.x.a;
    }

    public final AuthenticationMethod a() {
        return this.a.getAuthenticationMethod();
    }

    public final boolean b() {
        return this.a.isUnlockRequiredOnAppFocus();
    }

    public final boolean c() {
        return this.a.isTxAuthRequired();
    }

    public final void g(boolean z) {
        this.a.setUnlockRequiredOnAppFocus(z);
    }

    public final h.c.s<AppLockSettingsViewState> getStateObservable() {
        return this.f13993g;
    }

    public final void h(boolean z) {
        this.a.setTxAuthRequired(z);
    }

    public final h.c.b0<kotlin.x> j(final boolean z) {
        h.c.v0.e c2 = h.c.v0.e.c();
        kotlin.jvm.internal.m.f(c2, "create<CipherPermit>()");
        h.c.v0.e c3 = h.c.v0.e.c();
        kotlin.jvm.internal.m.f(c3, "create<CipherPermit>()");
        a aVar = new a(c3);
        final b bVar = new b(c2);
        AuthenticationHelper.authenticateWithBiometricPrompt$default(this.f13988b, EncryptionMethod.DECRYPTION, aVar, null, 4, null);
        h.c.b0<R> map = c3.map(new h.c.m0.n() { // from class: e.j.n.f
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return w1.f(w1.this, bVar, z, (e.j.d.a) obj);
            }
        });
        kotlin.jvm.internal.m.f(map, "decryptionPermitSubject\n            .map { decryptionPermit ->\n                authenticationHelper.authenticateWithBiometricPrompt(\n                    EncryptionMethod.ENCRYPTION, encryptionCallback, isEnabled\n                )\n                decryptionPermit\n            }");
        h.c.b0<kotlin.x> map2 = h.c.t0.f.a(map, c2).flatMap(new h.c.m0.n() { // from class: e.j.n.e
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return w1.e(w1.this, (kotlin.o) obj);
            }
        }).map(new h.c.m0.n() { // from class: e.j.n.d
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return w1.d(z, this, (kotlin.x) obj);
            }
        });
        kotlin.jvm.internal.m.f(map2, "decryptionPermitSubject\n            .map { decryptionPermit ->\n                authenticationHelper.authenticateWithBiometricPrompt(\n                    EncryptionMethod.ENCRYPTION, encryptionCallback, isEnabled\n                )\n                decryptionPermit\n            }\n            .zipWith(encryptionPermitSubject)\n            .flatMap { (decryptionPermit, encryptionPermit) ->\n                // 3. Use our permits to decrypt and re-encrypt the seed phrase with the new key\n                appLockRepository.changeBiometricPermit(decryptionPermit, encryptionPermit)\n            }.map {\n                // 4. Delete the old key, set local state and state in the mnemonicRepository\n                val biometricsProtectionType: BiometricsProtectionType\n                if (isEnabled) {\n                    biometricsProtectionType = BiometricsProtectionType.currentBiometrics\n                    keyStoreKeyHandler.deleteEntry(BiometricsProtectionType.anyBiometrics)\n                } else {\n                    biometricsProtectionType = BiometricsProtectionType.anyBiometrics\n                    keyStoreKeyHandler.deleteEntry(BiometricsProtectionType.currentBiometrics)\n                }\n                mnemonicRepository.biometricsProtectionType = biometricsProtectionType\n                state = state.copy(biometricsProtectionType = biometricsProtectionType)\n                Analytics.log(AnalyticsEvent.deviceLockBiometryProtectionEnabled(isEnabled))\n            }");
        return map2;
    }

    public final void setup() {
        i(this.f13992f.copy(this.f13989c.getBiometricsProtectionType(), this.a.getAuthenticationMethod()));
    }
}