package e.j.n.p3;

import androidx.lifecycle.u;
import com.coinbase.wallet.application.repository.interfaces.AppLockRepositoryInterface;
import com.toshi.model.local.authentication.AuthenticationMethod;
import h.c.a0;
import h.c.b0;
import kotlin.x;

/* compiled from: SwitchPinLockViewModel.kt */
/* loaded from: classes2.dex */
public final class s extends m {

    /* renamed from: i */
    private final AppLockRepositoryInterface f13952i;

    /* renamed from: j */
    private a0 f13953j;

    /* renamed from: k */
    private String f13954k;

    /* renamed from: l */
    private e.j.d.a f13955l;
    private final kotlin.h m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SwitchPinLockViewModel.kt */
    /* loaded from: classes2.dex */
    public static final class a extends kotlin.jvm.internal.o implements kotlin.e0.c.a<u<Boolean>> {
        public static final a a = new a();

        a() {
            super(0);
        }

        @Override // kotlin.e0.c.a
        /* renamed from: a */
        public final u<Boolean> invoke() {
            return new u<>();
        }
    }

    /* compiled from: SwitchPinLockViewModel.kt */
    /* loaded from: classes2.dex */
    public static final class b extends kotlin.jvm.internal.o implements kotlin.e0.c.l<Throwable, x> {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b() {
            super(1);
            s.this = r1;
        }

        @Override // kotlin.e0.c.l
        public /* bridge */ /* synthetic */ x invoke(Throwable th) {
            invoke2(th);
            return x.a;
        }

        /* renamed from: invoke */
        public final void invoke2(Throwable it) {
            kotlin.jvm.internal.m.g(it, "it");
            s.this.k().l(p.ERROR);
        }
    }

    /* compiled from: SwitchPinLockViewModel.kt */
    /* loaded from: classes2.dex */
    public static final class c extends kotlin.jvm.internal.o implements kotlin.e0.c.l<AuthenticationMethod, x> {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c() {
            super(1);
            s.this = r1;
        }

        public final void a(AuthenticationMethod authenticationMethod) {
            m.f(s.this, null, 1, null);
        }

        @Override // kotlin.e0.c.l
        public /* bridge */ /* synthetic */ x invoke(AuthenticationMethod authenticationMethod) {
            a(authenticationMethod);
            return x.a;
        }
    }

    /* compiled from: SwitchPinLockViewModel.kt */
    /* loaded from: classes2.dex */
    public static final class d extends kotlin.jvm.internal.o implements kotlin.e0.c.l<Throwable, x> {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d() {
            super(1);
            s.this = r1;
        }

        @Override // kotlin.e0.c.l
        public /* bridge */ /* synthetic */ x invoke(Throwable th) {
            invoke2(th);
            return x.a;
        }

        /* renamed from: invoke */
        public final void invoke2(Throwable it) {
            kotlin.jvm.internal.m.g(it, "it");
            s.this.k().l(p.ERROR);
        }
    }

    /* compiled from: SwitchPinLockViewModel.kt */
    /* loaded from: classes2.dex */
    public static final class e extends kotlin.jvm.internal.o implements kotlin.e0.c.l<AuthenticationMethod, x> {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        e() {
            super(1);
            s.this = r1;
        }

        public final void a(AuthenticationMethod authenticationMethod) {
            m.f(s.this, null, 1, null);
        }

        @Override // kotlin.e0.c.l
        public /* bridge */ /* synthetic */ x invoke(AuthenticationMethod authenticationMethod) {
            a(authenticationMethod);
            return x.a;
        }
    }

    public s(AppLockRepositoryInterface appLockRepository) {
        kotlin.h b2;
        kotlin.jvm.internal.m.g(appLockRepository, "appLockRepository");
        this.f13952i = appLockRepository;
        this.f13953j = h.c.j0.c.a.b();
        b2 = kotlin.k.b(a.a);
        this.m = b2;
    }

    public static /* synthetic */ void A(s sVar, AuthenticationMethod authenticationMethod) {
        R(sVar, authenticationMethod);
    }

    public static /* synthetic */ void B(s sVar) {
        Q(sVar);
    }

    public static /* synthetic */ void C(Throwable th) {
        O(th);
    }

    public static /* synthetic */ void D(s sVar, h.c.k0.b bVar) {
        P(sVar, bVar);
    }

    public static /* synthetic */ void E(s sVar) {
        M(sVar);
    }

    public static /* synthetic */ void F(s sVar, h.c.k0.b bVar) {
        L(sVar, bVar);
    }

    public static /* synthetic */ void G(Throwable th) {
        S(th);
    }

    private final void J(String str, e.j.d.a aVar) {
        b0<AuthenticationMethod> doOnError = this.f13952i.switchAuthenticationMethodToPin(str, aVar).observeOn(this.f13953j).doOnSubscribe(new h.c.m0.f() { // from class: e.j.n.p3.k
            @Override // h.c.m0.f
            public final void accept(Object obj) {
                s.F(s.this, (h.c.k0.b) obj);
            }
        }).doAfterTerminate(new h.c.m0.a() { // from class: e.j.n.p3.j
            @Override // h.c.m0.a
            public final void run() {
                s.E(s.this);
            }
        }).doOnSuccess(new h.c.m0.f() { // from class: e.j.n.p3.e
            @Override // h.c.m0.f
            public final void accept(Object obj) {
                s.z(s.this, (AuthenticationMethod) obj);
            }
        }).doOnError(new h.c.m0.f() { // from class: e.j.n.p3.h
            @Override // h.c.m0.f
            public final void accept(Object obj) {
                s.C((Throwable) obj);
            }
        });
        kotlin.jvm.internal.m.f(doOnError, "appLockRepository.switchAuthenticationMethodToPin(pinCode, permit)\n            .observeOn(mainScheduler)\n            .doOnSubscribe { isLoading.value = true }\n            .doAfterTerminate { isLoading.value = false }\n            .doOnSuccess { pinStatus.value = PinStatus.CONFIRMED }\n            .doOnError { Timber.e(it, \"Error while switching authentication method\") }");
        m().b(h.c.t0.g.f(doOnError, new d(), new e()));
    }

    private final void K(String str, String str2) {
        b0<AuthenticationMethod> doOnError = this.f13952i.switchAuthenticationPin(str, str2).observeOn(this.f13953j).doOnSubscribe(new h.c.m0.f() { // from class: e.j.n.p3.i
            @Override // h.c.m0.f
            public final void accept(Object obj) {
                s.D(s.this, (h.c.k0.b) obj);
            }
        }).doAfterTerminate(new h.c.m0.a() { // from class: e.j.n.p3.g
            @Override // h.c.m0.a
            public final void run() {
                s.B(s.this);
            }
        }).doOnSuccess(new h.c.m0.f() { // from class: e.j.n.p3.f
            @Override // h.c.m0.f
            public final void accept(Object obj) {
                s.A(s.this, (AuthenticationMethod) obj);
            }
        }).doOnError(new h.c.m0.f() { // from class: e.j.n.p3.l
            @Override // h.c.m0.f
            public final void accept(Object obj) {
                s.G((Throwable) obj);
            }
        });
        kotlin.jvm.internal.m.f(doOnError, "appLockRepository.switchAuthenticationPin(currentPin, newPin)\n            .observeOn(mainScheduler)\n            .doOnSubscribe { isLoading.value = true }\n            .doAfterTerminate { isLoading.value = false }\n            .doOnSuccess { pinStatus.value = PinStatus.CONFIRMED }\n            .doOnError { Timber.e(it, \"Error while switching authentication method to pin\") }");
        m().b(h.c.t0.g.f(doOnError, new b(), new c()));
    }

    public static final void L(s this$0, h.c.k0.b bVar) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        this$0.y().l(Boolean.TRUE);
    }

    public static final void M(s this$0) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        this$0.y().l(Boolean.FALSE);
    }

    public static final void N(s this$0, AuthenticationMethod authenticationMethod) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        this$0.k().l(p.CONFIRMED);
    }

    public static final void O(Throwable th) {
        l.a.a.f(th, "Error while switching authentication method", new Object[0]);
    }

    public static final void P(s this$0, h.c.k0.b bVar) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        this$0.y().l(Boolean.TRUE);
    }

    public static final void Q(s this$0) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        this$0.y().l(Boolean.FALSE);
    }

    public static final void R(s this$0, AuthenticationMethod authenticationMethod) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        this$0.k().l(p.CONFIRMED);
    }

    public static final void S(Throwable th) {
        l.a.a.f(th, "Error while switching authentication method to pin", new Object[0]);
    }

    private final void x() {
        k().l(p.ERROR);
        l.a.a.d("A cipher object or a pin needs to be provided", new Object[0]);
    }

    public static /* synthetic */ void z(s sVar, AuthenticationMethod authenticationMethod) {
        N(sVar, authenticationMethod);
    }

    public final void H(String str) {
        if (this.f13954k != null || str == null) {
            return;
        }
        this.f13954k = str;
    }

    public final void I(e.j.d.a aVar) {
        this.f13955l = aVar;
    }

    @Override // e.j.n.p3.m
    protected void o(String pinCode) {
        boolean B;
        kotlin.jvm.internal.m.g(pinCode, "pinCode");
        B = kotlin.l0.x.B(j(), pinCode, false, 2, null);
        if (B) {
            e.j.d.a aVar = this.f13955l;
            String str = this.f13954k;
            if (aVar != null) {
                J(pinCode, aVar);
                return;
            } else if (str != null) {
                K(str, pinCode);
                return;
            } else {
                x();
                return;
            }
        }
        k().l(p.NOT_MATCHING);
        i().l(x.a);
    }

    public final AuthenticationMethod v() {
        return this.f13952i.getAuthenticationMethod();
    }

    public final e.j.d.a w() {
        return this.f13955l;
    }

    public final u<Boolean> y() {
        return (u) this.m.getValue();
    }
}