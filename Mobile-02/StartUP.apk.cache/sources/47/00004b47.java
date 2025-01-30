package e.j.n;

import com.coinbase.wallet.application.model.BiometricsProtectionType;
import com.coinbase.wallet.application.repository.interfaces.AppLockRepositoryInterface;
import com.coinbase.wallet.application.repository.interfaces.MnemonicRepositoryInterface;
import com.coinbase.wallet.user.models.User;
import com.coinbase.wallet.user.repositories.UserRepository;
import com.coinbase.wallet.wallets.interfaces.IWalletRepository;
import com.toshi.model.local.authentication.AuthenticationMethod;

/* compiled from: NewWalletAuthenticationOnboardingViewModel.kt */
/* loaded from: classes2.dex */
public final class u2 extends androidx.lifecycle.b0 {
    private final e.j.j.b a;

    /* renamed from: b */
    private final e.j.d.g.w f13972b;

    /* renamed from: c */
    private final AppLockRepositoryInterface f13973c;

    /* renamed from: d */
    private final e.j.d.g.t f13974d;

    /* renamed from: e */
    private final UserRepository f13975e;

    /* renamed from: f */
    private final IWalletRepository f13976f;

    /* renamed from: g */
    private final e.j.i.i2.d f13977g;

    /* renamed from: h */
    private final MnemonicRepositoryInterface f13978h;

    public u2(e.j.j.b appPrefs, e.j.d.g.w masterSeedHandler, AppLockRepositoryInterface appLockRepository, e.j.d.g.t keyStoreKeyHandler, UserRepository userRepository, IWalletRepository walletRepository, e.j.i.i2.d mnemonicBackupRepository, MnemonicRepositoryInterface mnemonicRepository) {
        kotlin.jvm.internal.m.g(appPrefs, "appPrefs");
        kotlin.jvm.internal.m.g(masterSeedHandler, "masterSeedHandler");
        kotlin.jvm.internal.m.g(appLockRepository, "appLockRepository");
        kotlin.jvm.internal.m.g(keyStoreKeyHandler, "keyStoreKeyHandler");
        kotlin.jvm.internal.m.g(userRepository, "userRepository");
        kotlin.jvm.internal.m.g(walletRepository, "walletRepository");
        kotlin.jvm.internal.m.g(mnemonicBackupRepository, "mnemonicBackupRepository");
        kotlin.jvm.internal.m.g(mnemonicRepository, "mnemonicRepository");
        this.a = appPrefs;
        this.f13972b = masterSeedHandler;
        this.f13973c = appLockRepository;
        this.f13974d = keyStoreKeyHandler;
        this.f13975e = userRepository;
        this.f13976f = walletRepository;
        this.f13977g = mnemonicBackupRepository;
        this.f13978h = mnemonicRepository;
    }

    public static /* synthetic */ h.c.h0 b(u2 u2Var, String str, boolean z, String str2, kotlin.x xVar) {
        return h(u2Var, str, z, str2, xVar);
    }

    public static /* synthetic */ h.c.h0 c(u2 u2Var, String str, User user) {
        return i(u2Var, str, user);
    }

    public static /* synthetic */ kotlin.x d(u2 u2Var, String str) {
        return g(u2Var, str);
    }

    public static /* synthetic */ kotlin.x e(u2 u2Var, String str, AuthenticationMethod authenticationMethod, kotlin.x xVar) {
        return j(u2Var, str, authenticationMethod, xVar);
    }

    public static final kotlin.x g(u2 this$0, String it) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(it, "it");
        this$0.f13978h.setBiometricsProtectionType(BiometricsProtectionType.anyBiometrics);
        return kotlin.x.a;
    }

    public static final h.c.h0 h(u2 this$0, String username, boolean z, String masterSeed, kotlin.x it) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(username, "$username");
        kotlin.jvm.internal.m.g(masterSeed, "$masterSeed");
        kotlin.jvm.internal.m.g(it, "it");
        return this$0.f13975e.createUser(username, z, masterSeed);
    }

    public static final h.c.h0 i(u2 this$0, String masterSeed, User it) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(masterSeed, "$masterSeed");
        kotlin.jvm.internal.m.g(it, "it");
        return this$0.f13976f.createWallets(masterSeed);
    }

    public static final kotlin.x j(u2 this$0, String masterSeed, AuthenticationMethod authenticationMethod, kotlin.x it) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(masterSeed, "$masterSeed");
        kotlin.jvm.internal.m.g(authenticationMethod, "$authenticationMethod");
        kotlin.jvm.internal.m.g(it, "it");
        this$0.f13973c.setIsAppLocked(false);
        this$0.f13977g.i(e.j.f.u.d(masterSeed, "CoinbaseWallet"));
        this$0.f13973c.setAuthenticationMethod(authenticationMethod);
        return kotlin.x.a;
    }

    public final void a() {
        this.f13974d.e();
    }

    public final h.c.c f(final String masterSeed, e.j.d.c permit, final AuthenticationMethod authenticationMethod, final String username, final boolean z) {
        kotlin.jvm.internal.m.g(masterSeed, "masterSeed");
        kotlin.jvm.internal.m.g(permit, "permit");
        kotlin.jvm.internal.m.g(authenticationMethod, "authenticationMethod");
        kotlin.jvm.internal.m.g(username, "username");
        h.c.c ignoreElement = this.f13972b.a(masterSeed, permit).map(new h.c.m0.n() { // from class: e.j.n.s0
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return u2.d(u2.this, (String) obj);
            }
        }).flatMap(new h.c.m0.n() { // from class: e.j.n.q0
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return u2.b(u2.this, username, z, masterSeed, (kotlin.x) obj);
            }
        }).flatMap(new h.c.m0.n() { // from class: e.j.n.r0
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return u2.c(u2.this, masterSeed, (User) obj);
            }
        }).map(new h.c.m0.n() { // from class: e.j.n.t0
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return u2.e(u2.this, masterSeed, authenticationMethod, (kotlin.x) obj);
            }
        }).ignoreElement();
        kotlin.jvm.internal.m.f(ignoreElement, "masterSeedHandler.saveMasterSeed(masterSeed, permit)\n        .map { mnemonicRepository.biometricsProtectionType = BiometricsProtectionType.anyBiometrics }\n        .flatMap { userRepository.createUser(username, isPublic, masterSeed) }\n        .flatMap { walletRepository.createWallets(masterSeed) }\n        .map {\n            appLockRepository.setIsAppLocked(false)\n            mnemonicBackupRepository.activeMnemonicHash = masterSeed.sha256WithSalt(MnemonicBackupRepository.SALT)\n            appLockRepository.authenticationMethod = authenticationMethod\n        }\n        .ignoreElement()");
        return ignoreElement;
    }

    public final void k(boolean z) {
        this.a.k(z);
    }

    public final void l() {
        this.a.q();
    }
}