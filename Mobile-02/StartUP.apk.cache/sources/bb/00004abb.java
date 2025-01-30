package e.j.n;

import com.coinbase.wallet.application.model.BiometricsProtectionType;
import com.coinbase.wallet.application.repository.interfaces.AppLockRepositoryInterface;
import com.coinbase.wallet.application.repository.interfaces.MnemonicRepositoryInterface;
import com.coinbase.wallet.user.models.User;
import com.coinbase.wallet.user.repositories.UserRepository;
import com.coinbase.wallet.wallets.interfaces.IWalletRepository;
import com.toshi.model.local.authentication.AuthenticationMethod;

/* compiled from: SignInWalletAuthenticationOnboardingViewModel.kt */
/* loaded from: classes2.dex */
public final class f3 extends androidx.lifecycle.b0 {
    private final e.j.j.b a;

    /* renamed from: b */
    private final e.j.d.g.w f13832b;

    /* renamed from: c */
    private final AppLockRepositoryInterface f13833c;

    /* renamed from: d */
    private final e.j.d.g.t f13834d;

    /* renamed from: e */
    private final UserRepository f13835e;

    /* renamed from: f */
    private final IWalletRepository f13836f;

    /* renamed from: g */
    private final e.j.i.i2.d f13837g;

    /* renamed from: h */
    private final MnemonicRepositoryInterface f13838h;

    public f3(e.j.j.b appPrefs, e.j.d.g.w masterSeedHandler, AppLockRepositoryInterface appLockRepository, e.j.d.g.t keyStoreKeyHandler, UserRepository userRepository, IWalletRepository walletRepository, e.j.i.i2.d mnemonicBackupRepository, MnemonicRepositoryInterface mnemonicRepository) {
        kotlin.jvm.internal.m.g(appPrefs, "appPrefs");
        kotlin.jvm.internal.m.g(masterSeedHandler, "masterSeedHandler");
        kotlin.jvm.internal.m.g(appLockRepository, "appLockRepository");
        kotlin.jvm.internal.m.g(keyStoreKeyHandler, "keyStoreKeyHandler");
        kotlin.jvm.internal.m.g(userRepository, "userRepository");
        kotlin.jvm.internal.m.g(walletRepository, "walletRepository");
        kotlin.jvm.internal.m.g(mnemonicBackupRepository, "mnemonicBackupRepository");
        kotlin.jvm.internal.m.g(mnemonicRepository, "mnemonicRepository");
        this.a = appPrefs;
        this.f13832b = masterSeedHandler;
        this.f13833c = appLockRepository;
        this.f13834d = keyStoreKeyHandler;
        this.f13835e = userRepository;
        this.f13836f = walletRepository;
        this.f13837g = mnemonicBackupRepository;
        this.f13838h = mnemonicRepository;
    }

    public static /* synthetic */ kotlin.x b(f3 f3Var, String str) {
        return g(f3Var, str);
    }

    public static /* synthetic */ kotlin.x c(f3 f3Var, AuthenticationMethod authenticationMethod, String str, boolean z, kotlin.x xVar) {
        return j(f3Var, authenticationMethod, str, z, xVar);
    }

    public static /* synthetic */ h.c.h0 d(f3 f3Var, String str, User user) {
        return i(f3Var, str, user);
    }

    public static /* synthetic */ h.c.h0 e(f3 f3Var, String str, kotlin.x xVar) {
        return h(f3Var, str, xVar);
    }

    public static final kotlin.x g(f3 this$0, String it) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(it, "it");
        this$0.f13838h.setBiometricsProtectionType(BiometricsProtectionType.anyBiometrics);
        return kotlin.x.a;
    }

    public static final h.c.h0 h(f3 this$0, String masterSeed, kotlin.x it) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(masterSeed, "$masterSeed");
        kotlin.jvm.internal.m.g(it, "it");
        return this$0.f13835e.signIn(masterSeed);
    }

    public static final h.c.h0 i(f3 this$0, String masterSeed, User it) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(masterSeed, "$masterSeed");
        kotlin.jvm.internal.m.g(it, "it");
        return this$0.f13836f.createWallets(masterSeed);
    }

    public static final kotlin.x j(f3 this$0, AuthenticationMethod authenticationMethod, String masterSeed, boolean z, kotlin.x it) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(authenticationMethod, "$authenticationMethod");
        kotlin.jvm.internal.m.g(masterSeed, "$masterSeed");
        kotlin.jvm.internal.m.g(it, "it");
        this$0.f13833c.setAuthenticationMethod(authenticationMethod);
        this$0.f13833c.setIsAppLocked(false);
        this$0.f13837g.i(e.j.f.u.d(masterSeed, "CoinbaseWallet"));
        this$0.a.q();
        this$0.a.h(z);
        return kotlin.x.a;
    }

    public final void a() {
        this.f13834d.e();
    }

    public final h.c.b0<kotlin.x> f(final String masterSeed, e.j.d.c permit, final AuthenticationMethod authenticationMethod, final boolean z) {
        kotlin.jvm.internal.m.g(masterSeed, "masterSeed");
        kotlin.jvm.internal.m.g(permit, "permit");
        kotlin.jvm.internal.m.g(authenticationMethod, "authenticationMethod");
        h.c.b0<kotlin.x> map = this.f13832b.a(masterSeed, permit).map(new h.c.m0.n() { // from class: e.j.n.l1
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return f3.b(f3.this, (String) obj);
            }
        }).flatMap(new h.c.m0.n() { // from class: e.j.n.o1
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return f3.e(f3.this, masterSeed, (kotlin.x) obj);
            }
        }).flatMap(new h.c.m0.n() { // from class: e.j.n.n1
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return f3.d(f3.this, masterSeed, (User) obj);
            }
        }).map(new h.c.m0.n() { // from class: e.j.n.m1
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return f3.c(f3.this, authenticationMethod, masterSeed, z, (kotlin.x) obj);
            }
        });
        kotlin.jvm.internal.m.f(map, "masterSeedHandler.saveMasterSeed(masterSeed, permit)\n            .map { mnemonicRepository.biometricsProtectionType = BiometricsProtectionType.anyBiometrics }\n            .flatMap { userRepository.signIn(masterSeed) }\n            .flatMap { walletRepository.createWallets(masterSeed) }\n            .map {\n                appLockRepository.authenticationMethod = authenticationMethod\n                appLockRepository.setIsAppLocked(false)\n                mnemonicBackupRepository.activeMnemonicHash = masterSeed.sha256WithSalt(MnemonicBackupRepository.SALT)\n                appPrefs.incrementSessionNumber()\n                appPrefs.setHasBackedUpToCloud(hasCloudBackup)\n            }");
        return map;
    }
}