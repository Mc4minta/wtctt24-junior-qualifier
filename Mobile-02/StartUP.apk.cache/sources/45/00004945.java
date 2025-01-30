package e.j.d.g;

import androidx.biometric.BiometricPrompt;
import com.coinbase.wallet.application.model.BiometricsProtectionType;
import com.coinbase.wallet.application.repository.MnemonicRepository;
import com.toshi.exception.KeyStoreException;
import com.toshi.model.local.authentication.AuthenticationMethod;
import h.c.b0;
import h.c.h0;
import java.util.concurrent.Callable;
import kotlin.NoWhenBranchMatchedException;

/* compiled from: MasterSeedHandler.kt */
/* loaded from: classes2.dex */
public final class v implements w {
    private final e.j.j.e a;

    /* renamed from: b */
    private final y f13559b;

    /* renamed from: c */
    private final t f13560c;

    /* renamed from: d */
    private final MnemonicRepository f13561d;

    /* compiled from: MasterSeedHandler.kt */
    /* loaded from: classes2.dex */
    static final class a extends kotlin.jvm.internal.o implements kotlin.e0.c.l<String, b0<String>> {

        /* renamed from: b */
        final /* synthetic */ e.j.d.a f13562b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(e.j.d.a aVar) {
            super(1);
            v.this = r1;
            this.f13562b = aVar;
        }

        @Override // kotlin.e0.c.l
        /* renamed from: a */
        public final b0<String> invoke(String it) {
            kotlin.jvm.internal.m.g(it, "it");
            return v.this.f13560c.c(it, this.f13562b);
        }
    }

    /* compiled from: MasterSeedHandler.kt */
    /* loaded from: classes2.dex */
    public static final class b extends kotlin.jvm.internal.o implements kotlin.e0.c.l<String, b0<String>> {

        /* renamed from: b */
        final /* synthetic */ e.j.d.a f13563b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(e.j.d.a aVar) {
            super(1);
            v.this = r1;
            this.f13563b = aVar;
        }

        @Override // kotlin.e0.c.l
        /* renamed from: a */
        public final b0<String> invoke(String it) {
            kotlin.jvm.internal.m.g(it, "it");
            return v.this.f13560c.g(it, this.f13563b);
        }
    }

    /* compiled from: MasterSeedHandler.kt */
    /* loaded from: classes2.dex */
    static final class c extends kotlin.jvm.internal.o implements kotlin.e0.c.l<String, b0<String>> {

        /* renamed from: b */
        final /* synthetic */ e.j.d.c f13564b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(e.j.d.c cVar) {
            super(1);
            v.this = r1;
            this.f13564b = cVar;
        }

        @Override // kotlin.e0.c.l
        /* renamed from: a */
        public final b0<String> invoke(String it) {
            kotlin.jvm.internal.m.g(it, "it");
            return v.this.f13560c.c(it, (e.j.d.a) this.f13564b);
        }
    }

    /* compiled from: MasterSeedHandler.kt */
    /* loaded from: classes2.dex */
    static final class d extends kotlin.jvm.internal.o implements kotlin.e0.c.l<String, b0<String>> {

        /* renamed from: b */
        final /* synthetic */ e.j.d.c f13565b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(e.j.d.c cVar) {
            super(1);
            v.this = r1;
            this.f13565b = cVar;
        }

        @Override // kotlin.e0.c.l
        /* renamed from: a */
        public final b0<String> invoke(String it) {
            kotlin.jvm.internal.m.g(it, "it");
            return v.this.f13559b.a(it, ((e.j.d.d) this.f13565b).a());
        }
    }

    /* compiled from: MasterSeedHandler.kt */
    /* loaded from: classes2.dex */
    static final class e extends kotlin.jvm.internal.o implements kotlin.e0.c.l<String, b0<String>> {

        /* renamed from: b */
        final /* synthetic */ e.j.d.c f13566b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        e(e.j.d.c cVar) {
            super(1);
            v.this = r1;
            this.f13566b = cVar;
        }

        @Override // kotlin.e0.c.l
        /* renamed from: a */
        public final b0<String> invoke(String it) {
            kotlin.jvm.internal.m.g(it, "it");
            return v.this.f13560c.g(it, (e.j.d.a) this.f13566b);
        }
    }

    /* compiled from: MasterSeedHandler.kt */
    /* loaded from: classes2.dex */
    static final class f extends kotlin.jvm.internal.o implements kotlin.e0.c.l<String, b0<String>> {

        /* renamed from: b */
        final /* synthetic */ e.j.d.c f13567b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        f(e.j.d.c cVar) {
            super(1);
            v.this = r1;
            this.f13567b = cVar;
        }

        @Override // kotlin.e0.c.l
        /* renamed from: a */
        public final b0<String> invoke(String it) {
            kotlin.jvm.internal.m.g(it, "it");
            return v.this.f13559b.d(it, ((e.j.d.d) this.f13567b).a());
        }
    }

    /* compiled from: MasterSeedHandler.kt */
    /* loaded from: classes2.dex */
    public static final class g extends kotlin.jvm.internal.o implements kotlin.e0.c.l<String, b0<String>> {

        /* renamed from: b */
        final /* synthetic */ String f13568b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        g(String str) {
            super(1);
            v.this = r1;
            this.f13568b = str;
        }

        @Override // kotlin.e0.c.l
        /* renamed from: a */
        public final b0<String> invoke(String it) {
            kotlin.jvm.internal.m.g(it, "it");
            return v.this.f13559b.a(it, this.f13568b);
        }
    }

    /* compiled from: MasterSeedHandler.kt */
    /* loaded from: classes2.dex */
    public static final class h extends kotlin.jvm.internal.o implements kotlin.e0.c.l<String, b0<String>> {

        /* renamed from: b */
        final /* synthetic */ e.j.d.a f13569b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        h(e.j.d.a aVar) {
            super(1);
            v.this = r1;
            this.f13569b = aVar;
        }

        @Override // kotlin.e0.c.l
        /* renamed from: a */
        public final b0<String> invoke(String it) {
            kotlin.jvm.internal.m.g(it, "it");
            return v.this.f13560c.g(it, this.f13569b);
        }
    }

    /* compiled from: MasterSeedHandler.kt */
    /* loaded from: classes2.dex */
    static final class i extends kotlin.jvm.internal.o implements kotlin.e0.c.l<String, b0<String>> {

        /* renamed from: b */
        final /* synthetic */ e.j.d.a f13570b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        i(e.j.d.a aVar) {
            super(1);
            v.this = r1;
            this.f13570b = aVar;
        }

        @Override // kotlin.e0.c.l
        /* renamed from: a */
        public final b0<String> invoke(String it) {
            kotlin.jvm.internal.m.g(it, "it");
            return v.this.f13560c.c(it, this.f13570b);
        }
    }

    /* compiled from: MasterSeedHandler.kt */
    /* loaded from: classes2.dex */
    public static final class j extends kotlin.jvm.internal.o implements kotlin.e0.c.l<String, b0<String>> {

        /* renamed from: b */
        final /* synthetic */ String f13571b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        j(String str) {
            super(1);
            v.this = r1;
            this.f13571b = str;
        }

        @Override // kotlin.e0.c.l
        /* renamed from: a */
        public final b0<String> invoke(String it) {
            kotlin.jvm.internal.m.g(it, "it");
            return v.this.f13559b.d(it, this.f13571b);
        }
    }

    /* compiled from: MasterSeedHandler.kt */
    /* loaded from: classes2.dex */
    public static final class k extends kotlin.jvm.internal.o implements kotlin.e0.c.l<String, b0<String>> {

        /* renamed from: b */
        final /* synthetic */ String f13572b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        k(String str) {
            super(1);
            v.this = r1;
            this.f13572b = str;
        }

        @Override // kotlin.e0.c.l
        /* renamed from: a */
        public final b0<String> invoke(String it) {
            kotlin.jvm.internal.m.g(it, "it");
            return v.this.f13559b.a(it, this.f13572b);
        }
    }

    /* compiled from: MasterSeedHandler.kt */
    /* loaded from: classes2.dex */
    public static final class l extends kotlin.jvm.internal.o implements kotlin.e0.c.l<String, b0<String>> {

        /* renamed from: b */
        final /* synthetic */ String f13573b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        l(String str) {
            super(1);
            v.this = r1;
            this.f13573b = str;
        }

        @Override // kotlin.e0.c.l
        /* renamed from: a */
        public final b0<String> invoke(String it) {
            kotlin.jvm.internal.m.g(it, "it");
            return v.this.f13559b.d(it, this.f13573b);
        }
    }

    public v(e.j.j.e lockPrefs, y pinKeyHandler, t keystoreKeyHandler, MnemonicRepository mnemonicRepository) {
        kotlin.jvm.internal.m.g(lockPrefs, "lockPrefs");
        kotlin.jvm.internal.m.g(pinKeyHandler, "pinKeyHandler");
        kotlin.jvm.internal.m.g(keystoreKeyHandler, "keystoreKeyHandler");
        kotlin.jvm.internal.m.g(mnemonicRepository, "mnemonicRepository");
        this.a = lockPrefs;
        this.f13559b = pinKeyHandler;
        this.f13560c = keystoreKeyHandler;
        this.f13561d = mnemonicRepository;
    }

    public static final h0 A(v this$0, String currentPin, kotlin.x it) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(currentPin, "$currentPin");
        kotlin.jvm.internal.m.g(it, "it");
        return this$0.f13561d.getMnemonicFromStorage(new g(currentPin));
    }

    public static final h0 B(v this$0, e.j.d.a permit, String masterSeed) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(permit, "$permit");
        kotlin.jvm.internal.m.g(masterSeed, "masterSeed");
        return this$0.f13561d.saveMnemonicToStorage(masterSeed, new h(permit));
    }

    public static final void C(v this$0, String str) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        this$0.a.setAuthenticationMethod(AuthenticationMethod.BIOMETRIC);
    }

    public static final AuthenticationMethod D(String it) {
        kotlin.jvm.internal.m.g(it, "it");
        return AuthenticationMethod.BIOMETRIC;
    }

    public static final kotlin.x E(v this$0) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        if (this$0.a.getAuthenticationMethod() == AuthenticationMethod.PIN) {
            return kotlin.x.a;
        }
        throw new IllegalStateException("Authentication method needs to be PIN");
    }

    public static final h0 F(v this$0, String oldPin, kotlin.x it) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(oldPin, "$oldPin");
        kotlin.jvm.internal.m.g(it, "it");
        return this$0.f13561d.getMnemonicFromStorage(new k(oldPin));
    }

    public static final h0 G(v this$0, String newPin, String masterSeed) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(newPin, "$newPin");
        kotlin.jvm.internal.m.g(masterSeed, "masterSeed");
        return this$0.f13561d.saveMnemonicToStorage(masterSeed, new l(newPin));
    }

    public static final void H(v this$0, String str) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        this$0.a.setAuthenticationMethod(AuthenticationMethod.PIN);
    }

    public static final AuthenticationMethod I(String it) {
        kotlin.jvm.internal.m.g(it, "it");
        return AuthenticationMethod.PIN;
    }

    public static final h0 J(v this$0, String newPin, String masterSeed) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(newPin, "$newPin");
        kotlin.jvm.internal.m.g(masterSeed, "masterSeed");
        this$0.f13560c.f(BiometricsProtectionType.currentBiometrics);
        return this$0.f13561d.saveMnemonicToStorage(masterSeed, new j(newPin));
    }

    public static final void K(v this$0, String str) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        this$0.a.setAuthenticationMethod(AuthenticationMethod.PIN);
    }

    public static final AuthenticationMethod L(String it) {
        kotlin.jvm.internal.m.g(it, "it");
        return AuthenticationMethod.PIN;
    }

    public static final h0 i(v this$0, e.j.d.a encryptionPermit, String masterSeed) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(encryptionPermit, "$encryptionPermit");
        kotlin.jvm.internal.m.g(masterSeed, "masterSeed");
        return this$0.f13561d.saveMnemonicToStorage(masterSeed, new b(encryptionPermit));
    }

    public static final kotlin.x j(String it) {
        kotlin.jvm.internal.m.g(it, "it");
        return kotlin.x.a;
    }

    public static /* synthetic */ h0 k(v vVar, String str, String str2) {
        return G(vVar, str, str2);
    }

    public static /* synthetic */ h0 l(v vVar, e.j.d.a aVar, String str) {
        return i(vVar, aVar, str);
    }

    public static /* synthetic */ AuthenticationMethod m(String str) {
        return L(str);
    }

    public static /* synthetic */ kotlin.x n(String str) {
        return j(str);
    }

    public static /* synthetic */ h0 o(v vVar, String str, String str2) {
        return J(vVar, str, str2);
    }

    public static /* synthetic */ h0 p(v vVar, e.j.d.a aVar, String str) {
        return B(vVar, aVar, str);
    }

    public static /* synthetic */ void q(v vVar, String str) {
        K(vVar, str);
    }

    public static /* synthetic */ h0 r(v vVar, String str, kotlin.x xVar) {
        return A(vVar, str, xVar);
    }

    public static /* synthetic */ h0 s(v vVar, String str, kotlin.x xVar) {
        return F(vVar, str, xVar);
    }

    public static /* synthetic */ void t(v vVar, String str) {
        C(vVar, str);
    }

    public static /* synthetic */ AuthenticationMethod u(String str) {
        return D(str);
    }

    public static /* synthetic */ kotlin.x v(v vVar) {
        return E(vVar);
    }

    public static /* synthetic */ void w(v vVar, String str) {
        H(vVar, str);
    }

    public static /* synthetic */ kotlin.x x(v vVar) {
        return z(vVar);
    }

    public static /* synthetic */ AuthenticationMethod y(String str) {
        return I(str);
    }

    public static final kotlin.x z(v this$0) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        if (this$0.a.getAuthenticationMethod() == AuthenticationMethod.PIN) {
            return kotlin.x.a;
        }
        throw new IllegalStateException("Authentication method needs to be PIN");
    }

    @Override // e.j.d.g.w
    public b0<String> a(String masterSeed, e.j.d.c permit) {
        kotlin.jvm.internal.m.g(masterSeed, "masterSeed");
        kotlin.jvm.internal.m.g(permit, "permit");
        if (permit instanceof e.j.d.a) {
            return this.f13561d.saveMnemonicToStorage(masterSeed, new e(permit));
        }
        if (permit instanceof e.j.d.d) {
            return this.f13561d.saveMnemonicToStorage(masterSeed, new f(permit));
        }
        if (permit instanceof e.j.d.e) {
            b0<String> error = b0.error(new IllegalStateException("Recovery phrase is an invalid permit type for save"));
            kotlin.jvm.internal.m.f(error, "{\n                Single.error(IllegalStateException(\"Recovery phrase is an invalid permit type for save\"))\n            }");
            return error;
        }
        throw new NoWhenBranchMatchedException();
    }

    @Override // e.j.d.g.w
    public BiometricPrompt.d b(Boolean bool) throws KeyStoreException {
        return this.f13560c.b(bool);
    }

    @Override // e.j.d.g.w
    public boolean c(byte[] iv) {
        kotlin.jvm.internal.m.g(iv, "iv");
        return this.f13560c.i(iv);
    }

    @Override // e.j.d.g.w
    public b0<kotlin.x> changeBiometricPermit(e.j.d.a decryptionPermit, final e.j.d.a encryptionPermit) throws IllegalStateException {
        kotlin.jvm.internal.m.g(decryptionPermit, "decryptionPermit");
        kotlin.jvm.internal.m.g(encryptionPermit, "encryptionPermit");
        b0<kotlin.x> map = this.f13561d.getMnemonicFromStorage(new a(decryptionPermit)).flatMap(new h.c.m0.n() { // from class: e.j.d.g.d
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return v.l(v.this, encryptionPermit, (String) obj);
            }
        }).map(new h.c.m0.n() { // from class: e.j.d.g.f
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return v.n((String) obj);
            }
        });
        kotlin.jvm.internal.m.f(map, "@Throws(IllegalStateException::class)\n    override fun changeBiometricPermit(\n        decryptionPermit: CipherPermit,\n        encryptionPermit: CipherPermit\n    ) = mnemonicRepository\n        .getMnemonicFromStorage { keystoreKeyHandler.decrypt(it, decryptionPermit) }\n        .flatMap { masterSeed ->\n            mnemonicRepository.saveMnemonicToStorage(masterSeed) { keystoreKeyHandler.encrypt(it, encryptionPermit) }\n        }\n        .map { }");
        return map;
    }

    @Override // e.j.d.g.w
    public BiometricPrompt.d d(byte[] iv) throws KeyStoreException {
        kotlin.jvm.internal.m.g(iv, "iv");
        return this.f13560c.a(iv);
    }

    @Override // e.j.d.g.w
    public b0<AuthenticationMethod> e(final String oldPin, final String newPin) throws IllegalStateException {
        kotlin.jvm.internal.m.g(oldPin, "oldPin");
        kotlin.jvm.internal.m.g(newPin, "newPin");
        b0<AuthenticationMethod> map = b0.fromCallable(new Callable() { // from class: e.j.d.g.n
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return v.v(v.this);
            }
        }).flatMap(new h.c.m0.n() { // from class: e.j.d.g.k
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return v.s(v.this, oldPin, (kotlin.x) obj);
            }
        }).flatMap(new h.c.m0.n() { // from class: e.j.d.g.c
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return v.k(v.this, newPin, (String) obj);
            }
        }).doOnSuccess(new h.c.m0.f() { // from class: e.j.d.g.o
            @Override // h.c.m0.f
            public final void accept(Object obj) {
                v.w(v.this, (String) obj);
            }
        }).map(new h.c.m0.n() { // from class: e.j.d.g.q
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return v.y((String) obj);
            }
        });
        kotlin.jvm.internal.m.f(map, "fromCallable {\n            val currentAuthenticationMethod = lockPrefs.authenticationMethod\n            if (currentAuthenticationMethod != AuthenticationMethod.PIN) {\n                throw IllegalStateException(\"Authentication method needs to be PIN\")\n            }\n        }\n        .flatMap { mnemonicRepository.getMnemonicFromStorage { pinKeyHandler.decrypt(it, oldPin) } }\n        .flatMap { masterSeed ->\n            mnemonicRepository.saveMnemonicToStorage(masterSeed) { pinKeyHandler.encrypt(it, newPin) }\n        }\n        .doOnSuccess { lockPrefs.authenticationMethod = AuthenticationMethod.PIN }\n        .map { AuthenticationMethod.PIN }");
        return map;
    }

    @Override // e.j.d.g.w
    public b0<String> f(e.j.d.c permit) {
        kotlin.jvm.internal.m.g(permit, "permit");
        if (permit instanceof e.j.d.a) {
            return this.f13561d.getMnemonicFromStorage(new c(permit));
        }
        if (permit instanceof e.j.d.d) {
            return this.f13561d.getMnemonicFromStorage(new d(permit));
        }
        if (permit instanceof e.j.d.e) {
            b0<String> just = b0.just(((e.j.d.e) permit).a());
            kotlin.jvm.internal.m.f(just, "just(permit.recoveryPhrase)");
            return just;
        }
        throw new NoWhenBranchMatchedException();
    }

    @Override // e.j.d.g.w
    public b0<AuthenticationMethod> switchAuthenticationMethodToBiometric(final String currentPin, final e.j.d.a permit) throws IllegalStateException {
        kotlin.jvm.internal.m.g(currentPin, "currentPin");
        kotlin.jvm.internal.m.g(permit, "permit");
        b0<AuthenticationMethod> map = b0.fromCallable(new Callable() { // from class: e.j.d.g.p
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return v.x(v.this);
            }
        }).flatMap(new h.c.m0.n() { // from class: e.j.d.g.j
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return v.r(v.this, currentPin, (kotlin.x) obj);
            }
        }).flatMap(new h.c.m0.n() { // from class: e.j.d.g.h
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return v.p(v.this, permit, (String) obj);
            }
        }).doOnSuccess(new h.c.m0.f() { // from class: e.j.d.g.l
            @Override // h.c.m0.f
            public final void accept(Object obj) {
                v.t(v.this, (String) obj);
            }
        }).map(new h.c.m0.n() { // from class: e.j.d.g.m
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return v.u((String) obj);
            }
        });
        kotlin.jvm.internal.m.f(map, "fromCallable {\n            val currentAuthenticationMethod = lockPrefs.authenticationMethod\n            if (currentAuthenticationMethod != AuthenticationMethod.PIN) {\n                throw IllegalStateException(\"Authentication method needs to be PIN\")\n            }\n        }\n        .flatMap { mnemonicRepository.getMnemonicFromStorage { pinKeyHandler.decrypt(it, currentPin) } }\n        .flatMap { masterSeed ->\n            mnemonicRepository.saveMnemonicToStorage(masterSeed) { keystoreKeyHandler.encrypt(it, permit) }\n        }\n        .doOnSuccess { lockPrefs.authenticationMethod = AuthenticationMethod.BIOMETRIC }\n        .map { AuthenticationMethod.BIOMETRIC }");
        return map;
    }

    @Override // e.j.d.g.w
    public b0<AuthenticationMethod> switchAuthenticationMethodToPin(final String newPin, e.j.d.a permit) throws IllegalStateException {
        kotlin.jvm.internal.m.g(newPin, "newPin");
        kotlin.jvm.internal.m.g(permit, "permit");
        b0<AuthenticationMethod> map = this.f13561d.getMnemonicFromStorage(new i(permit)).flatMap(new h.c.m0.n() { // from class: e.j.d.g.g
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return v.o(v.this, newPin, (String) obj);
            }
        }).doOnSuccess(new h.c.m0.f() { // from class: e.j.d.g.i
            @Override // h.c.m0.f
            public final void accept(Object obj) {
                v.q(v.this, (String) obj);
            }
        }).map(new h.c.m0.n() { // from class: e.j.d.g.e
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return v.m((String) obj);
            }
        });
        kotlin.jvm.internal.m.f(map, "@Throws(IllegalStateException::class)\n    override fun switchAuthenticationMethodToPin(\n        newPin: String,\n        permit: CipherPermit\n    ): Single<AuthenticationMethod> = mnemonicRepository\n        .getMnemonicFromStorage { keystoreKeyHandler.decrypt(it, permit) }\n        .flatMap { masterSeed ->\n            keystoreKeyHandler.deleteEntry(BiometricsProtectionType.currentBiometrics)\n            mnemonicRepository.saveMnemonicToStorage(masterSeed) { pinKeyHandler.encrypt(it, newPin) }\n        }\n        .doOnSuccess { lockPrefs.authenticationMethod = AuthenticationMethod.PIN }\n        .map { AuthenticationMethod.PIN }");
        return map;
    }
}