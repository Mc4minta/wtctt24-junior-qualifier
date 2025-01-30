package e.j.n.p3;

import androidx.lifecycle.b0;
import androidx.lifecycle.u;
import h.c.a0;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.x;

/* compiled from: BasePinSetupViewModel.kt */
/* loaded from: classes2.dex */
public abstract class m extends b0 {
    public static final a a = new a(null);

    /* renamed from: b */
    private a0 f13939b = h.c.j0.c.a.b();

    /* renamed from: c */
    private int f13940c;

    /* renamed from: d */
    private final kotlin.h f13941d;

    /* renamed from: e */
    private String f13942e;

    /* renamed from: f */
    private final kotlin.h f13943f;

    /* renamed from: g */
    private final kotlin.h f13944g;

    /* renamed from: h */
    private final kotlin.h f13945h;

    /* compiled from: BasePinSetupViewModel.kt */
    /* loaded from: classes2.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: BasePinSetupViewModel.kt */
    /* loaded from: classes2.dex */
    public static final class b extends kotlin.jvm.internal.o implements kotlin.e0.c.a<e.j.l.k<x>> {
        public static final b a = new b();

        b() {
            super(0);
        }

        @Override // kotlin.e0.c.a
        /* renamed from: a */
        public final e.j.l.k<x> invoke() {
            return new e.j.l.k<>();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: BasePinSetupViewModel.kt */
    /* loaded from: classes2.dex */
    public static final class c extends kotlin.jvm.internal.o implements kotlin.e0.c.a<u<p>> {
        public static final c a = new c();

        c() {
            super(0);
        }

        @Override // kotlin.e0.c.a
        /* renamed from: a */
        public final u<p> invoke() {
            return new u<>();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: BasePinSetupViewModel.kt */
    /* loaded from: classes2.dex */
    public static final class d extends kotlin.jvm.internal.o implements kotlin.e0.c.a<e.j.l.k<String>> {
        public static final d a = new d();

        d() {
            super(0);
        }

        @Override // kotlin.e0.c.a
        /* renamed from: a */
        public final e.j.l.k<String> invoke() {
            return new e.j.l.k<>();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: BasePinSetupViewModel.kt */
    /* loaded from: classes2.dex */
    public static final class e extends kotlin.jvm.internal.o implements kotlin.e0.c.a<h.c.k0.a> {
        public static final e a = new e();

        e() {
            super(0);
        }

        @Override // kotlin.e0.c.a
        public final h.c.k0.a invoke() {
            return new h.c.k0.a();
        }
    }

    public m() {
        kotlin.h b2;
        kotlin.h b3;
        kotlin.h b4;
        kotlin.h b5;
        b2 = kotlin.k.b(e.a);
        this.f13941d = b2;
        b3 = kotlin.k.b(d.a);
        this.f13943f = b3;
        b4 = kotlin.k.b(c.a);
        this.f13944g = b4;
        b5 = kotlin.k.b(b.a);
        this.f13945h = b5;
    }

    private final void b() {
        h.c.k0.b b2 = h.c.c.u(150L, TimeUnit.MILLISECONDS).s(this.f13939b).b(new h.c.m0.a() { // from class: e.j.n.p3.d
            @Override // h.c.m0.a
            public final void run() {
                m.s(m.this);
            }
        }, new h.c.m0.f() { // from class: e.j.n.p3.a
            @Override // h.c.m0.f
            public final void accept(Object obj) {
                m.p((Throwable) obj);
            }
        });
        kotlin.jvm.internal.m.f(b2, "timer(150, TimeUnit.MILLISECONDS)\n            .observeOn(mainScheduler)\n            .subscribe(\n                { clear.invoke() },\n                // TODO: create logError extension for Completable\n                { Timber.e(it, \"Error while finishing first pin step\") }\n            )");
        m().b(b2);
    }

    public static final void c(m this$0) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        e.j.f.q.a(this$0.i());
    }

    public static final void d(Throwable th) {
        l.a.a.f(th, "Error while finishing first pin step", new Object[0]);
    }

    public static /* synthetic */ void f(m mVar, String str, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: finishWithDelay");
        }
        if ((i2 & 1) != 0) {
            str = null;
        }
        mVar.e(str);
    }

    public static final void g(m this$0, String str) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        this$0.l().l(str);
    }

    public static final void h(Throwable th) {
        l.a.a.f(th, "Error while finishing with delay when setting up pin", new Object[0]);
    }

    private final void n(String str) {
        k().l(p.CONFIRM_PIN);
        this.f13942e = str;
        this.f13940c++;
        b();
    }

    public static /* synthetic */ void p(Throwable th) {
        d(th);
    }

    public static /* synthetic */ void q(m mVar, String str) {
        g(mVar, str);
    }

    public static /* synthetic */ void r(Throwable th) {
        h(th);
    }

    public static /* synthetic */ void s(m mVar) {
        c(mVar);
    }

    public final boolean a(String pinCode) {
        boolean Q;
        kotlin.jvm.internal.m.g(pinCode, "pinCode");
        if (this.f13940c == 1) {
            String str = this.f13942e;
            if (str == null) {
                return false;
            }
            Q = kotlin.l0.x.Q(str, pinCode, false, 2, null);
            return Q;
        }
        return true;
    }

    public final void e(final String str) {
        h.c.k0.b b2 = h.c.c.u(500L, TimeUnit.MILLISECONDS).s(this.f13939b).b(new h.c.m0.a() { // from class: e.j.n.p3.b
            @Override // h.c.m0.a
            public final void run() {
                m.q(m.this, str);
            }
        }, new h.c.m0.f() { // from class: e.j.n.p3.c
            @Override // h.c.m0.f
            public final void accept(Object obj) {
                m.r((Throwable) obj);
            }
        });
        kotlin.jvm.internal.m.f(b2, "timer(500, TimeUnit.MILLISECONDS)\n            .observeOn(mainScheduler)\n            .subscribe(\n                { pinSuccess.value = pinCode },\n                // TODO: create logError extension for Completable\n                { Timber.e(it, \"Error while finishing with delay when setting up pin\") }\n            )");
        m().b(b2);
    }

    public final e.j.l.k<x> i() {
        return (e.j.l.k) this.f13945h.getValue();
    }

    public final String j() {
        return this.f13942e;
    }

    public final u<p> k() {
        return (u) this.f13944g.getValue();
    }

    public final e.j.l.k<String> l() {
        return (e.j.l.k) this.f13943f.getValue();
    }

    public final h.c.k0.a m() {
        return (h.c.k0.a) this.f13941d.getValue();
    }

    protected abstract void o(String str);

    @Override // androidx.lifecycle.b0
    public void onCleared() {
        super.onCleared();
        m().d();
    }

    public final void t(String pinCode) {
        kotlin.jvm.internal.m.g(pinCode, "pinCode");
        if (pinCode.length() != 6) {
            k().l(p.INVALID_LENGTH);
            return;
        }
        int i2 = this.f13940c;
        if (i2 == 0) {
            n(pinCode);
        } else if (i2 != 1) {
        } else {
            o(pinCode);
        }
    }

    public final void u(boolean z) {
        if (this.f13940c != 1) {
            return;
        }
        if (z) {
            k().l(p.CONFIRM_PIN);
        } else {
            k().l(p.INCORRECT_PIN);
        }
    }
}