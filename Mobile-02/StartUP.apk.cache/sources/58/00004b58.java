package e.j.n;

import com.coinbase.wallet.application.model.BiometricsProtectionType;
import com.coinbase.wallet.application.repository.interfaces.AppLockRepositoryInterface;
import com.coinbase.wallet.application.repository.interfaces.MnemonicRepositoryInterface;
import com.toshi.model.local.authentication.AuthenticationMethod;

/* compiled from: AuthenticationViewModel.kt */
/* loaded from: classes2.dex */
public final class y1 extends androidx.lifecycle.b0 {
    private final AppLockRepositoryInterface a;

    /* renamed from: b  reason: collision with root package name */
    private final MnemonicRepositoryInterface f13999b;

    /* renamed from: c  reason: collision with root package name */
    private final kotlin.h f14000c;

    /* renamed from: d  reason: collision with root package name */
    private final kotlin.h f14001d;

    /* compiled from: AuthenticationViewModel.kt */
    /* loaded from: classes2.dex */
    static final class a extends kotlin.jvm.internal.o implements kotlin.e0.c.a<androidx.lifecycle.u<AuthenticationMethod>> {
        public static final a a = new a();

        a() {
            super(0);
        }

        @Override // kotlin.e0.c.a
        /* renamed from: a */
        public final androidx.lifecycle.u<AuthenticationMethod> invoke() {
            return new androidx.lifecycle.u<>();
        }
    }

    /* compiled from: AuthenticationViewModel.kt */
    /* loaded from: classes2.dex */
    static final class b extends kotlin.jvm.internal.o implements kotlin.e0.c.a<h.c.k0.a> {
        public static final b a = new b();

        b() {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.e0.c.a
        public final h.c.k0.a invoke() {
            return new h.c.k0.a();
        }
    }

    public y1(AppLockRepositoryInterface appLockRepository, MnemonicRepositoryInterface mnemonicRepository) {
        kotlin.h b2;
        kotlin.h b3;
        kotlin.jvm.internal.m.g(appLockRepository, "appLockRepository");
        kotlin.jvm.internal.m.g(mnemonicRepository, "mnemonicRepository");
        this.a = appLockRepository;
        this.f13999b = mnemonicRepository;
        b2 = kotlin.k.b(b.a);
        this.f14000c = b2;
        b3 = kotlin.k.b(a.a);
        this.f14001d = b3;
    }

    private final h.c.k0.a b() {
        return (h.c.k0.a) this.f14000c.getValue();
    }

    public final AuthenticationMethod a() {
        return this.a.getAuthenticationMethod();
    }

    public final h.c.b0<AuthenticationMethod> c(String currentPin, e.j.d.a permit) {
        kotlin.jvm.internal.m.g(currentPin, "currentPin");
        kotlin.jvm.internal.m.g(permit, "permit");
        this.f13999b.setBiometricsProtectionType(BiometricsProtectionType.anyBiometrics);
        return this.a.switchAuthenticationMethodToBiometric(currentPin, permit);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.lifecycle.b0
    public void onCleared() {
        super.onCleared();
        b().d();
    }
}