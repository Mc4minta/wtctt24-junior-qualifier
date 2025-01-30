package kotlinx.coroutines;

import kotlin.p;

/* compiled from: DispatchedTask.kt */
/* loaded from: classes3.dex */
public abstract class a0<T> extends kotlinx.coroutines.i1.i {

    /* renamed from: c  reason: collision with root package name */
    public int f17415c;

    public a0(int i2) {
        this.f17415c = i2;
    }

    public void f(Object obj, Throwable th) {
    }

    public abstract kotlin.c0.d<T> g();

    public Throwable h(Object obj) {
        if (!(obj instanceof n)) {
            obj = null;
        }
        n nVar = (n) obj;
        if (nVar != null) {
            return nVar.f17525b;
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <T> T i(Object obj) {
        return obj;
    }

    public final void j(Throwable th, Throwable th2) {
        if (th == null && th2 == null) {
            return;
        }
        if (th != null && th2 != null) {
            kotlin.c.a(th, th2);
        }
        if (th == null) {
            th = th2;
        }
        kotlin.jvm.internal.m.e(th);
        v.a(g().e(), new w("Fatal exception in coroutines machinery for " + this + ". Please read KDoc to 'handleFatalException' method and report this incident to maintainers", th));
    }

    public abstract Object k();

    @Override // java.lang.Runnable
    public final void run() {
        Object a;
        Object a2;
        if (x.a()) {
            if (!(this.f17415c != -1)) {
                throw new AssertionError();
            }
        }
        kotlinx.coroutines.i1.j jVar = this.f17473b;
        try {
            kotlin.c0.d<T> g2 = g();
            if (g2 != null) {
                kotlinx.coroutines.internal.d dVar = (kotlinx.coroutines.internal.d) g2;
                kotlin.c0.d<T> dVar2 = dVar.f17492j;
                kotlin.c0.f e2 = dVar2.e();
                Object k2 = k();
                Object c2 = kotlinx.coroutines.internal.s.c(e2, dVar.f17490g);
                Throwable h2 = h(k2);
                r0 r0Var = (h2 == null && b0.b(this.f17415c)) ? (r0) e2.get(r0.s) : null;
                if (r0Var != null && !r0Var.a()) {
                    Throwable f2 = r0Var.f();
                    f(k2, f2);
                    p.a aVar = kotlin.p.a;
                    if (x.c() && (dVar2 instanceof kotlin.c0.i.a.d)) {
                        f2 = kotlinx.coroutines.internal.n.a(f2, (kotlin.c0.i.a.d) dVar2);
                    }
                    dVar2.b(kotlin.p.a(kotlin.q.a(f2)));
                } else if (h2 != null) {
                    p.a aVar2 = kotlin.p.a;
                    dVar2.b(kotlin.p.a(kotlin.q.a(h2)));
                } else {
                    T i2 = i(k2);
                    p.a aVar3 = kotlin.p.a;
                    dVar2.b(kotlin.p.a(i2));
                }
                kotlin.x xVar = kotlin.x.a;
                kotlinx.coroutines.internal.s.a(e2, c2);
                try {
                    p.a aVar4 = kotlin.p.a;
                    jVar.d();
                    a2 = kotlin.p.a(xVar);
                } catch (Throwable th) {
                    p.a aVar5 = kotlin.p.a;
                    a2 = kotlin.p.a(kotlin.q.a(th));
                }
                j(null, kotlin.p.b(a2));
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.internal.DispatchedContinuation<T>");
        } catch (Throwable th2) {
            try {
                p.a aVar6 = kotlin.p.a;
                jVar.d();
                a = kotlin.p.a(kotlin.x.a);
            } catch (Throwable th3) {
                p.a aVar7 = kotlin.p.a;
                a = kotlin.p.a(kotlin.q.a(th3));
            }
            j(th2, kotlin.p.b(a));
        }
    }
}