package kotlinx.coroutines;

import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.KotlinNothingValueException;
import kotlinx.coroutines.r0;

/* compiled from: CancellableContinuationImpl.kt */
/* loaded from: classes3.dex */
public class f<T> extends a0<T> implements e<T>, kotlin.c0.i.a.d {

    /* renamed from: d  reason: collision with root package name */
    private static final AtomicIntegerFieldUpdater f17421d = AtomicIntegerFieldUpdater.newUpdater(f.class, "_decision");

    /* renamed from: e  reason: collision with root package name */
    private static final AtomicReferenceFieldUpdater f17422e = AtomicReferenceFieldUpdater.newUpdater(f.class, Object.class, "_state");
    private volatile int _decision;
    private volatile Object _parentHandle;
    private volatile Object _state;

    /* renamed from: f  reason: collision with root package name */
    private final kotlin.c0.f f17423f;

    /* renamed from: g  reason: collision with root package name */
    private final kotlin.c0.d<T> f17424g;

    /* JADX WARN: Multi-variable type inference failed */
    public f(kotlin.c0.d<? super T> dVar, int i2) {
        super(i2);
        this.f17424g = dVar;
        if (x.a()) {
            if (!(i2 != -1)) {
                throw new AssertionError();
            }
        }
        this.f17423f = dVar.e();
        this._decision = 0;
        this._state = a.a;
        this._parentHandle = null;
    }

    private final boolean A() {
        kotlin.c0.d<T> dVar = this.f17424g;
        return (dVar instanceof kotlinx.coroutines.internal.d) && ((kotlinx.coroutines.internal.d) dVar).n(this);
    }

    private final c B(kotlin.e0.c.l<? super Throwable, kotlin.x> lVar) {
        return lVar instanceof c ? (c) lVar : new o0(lVar);
    }

    private final void C(kotlin.e0.c.l<? super Throwable, kotlin.x> lVar, Object obj) {
        throw new IllegalStateException(("It's prohibited to register multiple handlers, tried to register " + lVar + ", already has " + obj).toString());
    }

    private final void F(Object obj, int i2, kotlin.e0.c.l<? super Throwable, kotlin.x> lVar) {
        Object obj2;
        do {
            obj2 = this._state;
            if (obj2 instanceof a1) {
            } else {
                if (obj2 instanceof g) {
                    g gVar = (g) obj2;
                    if (gVar.b()) {
                        if (lVar != null) {
                            o(lVar, gVar.f17525b);
                            return;
                        }
                        return;
                    }
                }
                l(obj);
                throw new KotlinNothingValueException();
            }
        } while (!f17422e.compareAndSet(this, obj2, H((a1) obj2, obj, i2, lVar, null)));
        t();
        u(i2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ void G(f fVar, Object obj, int i2, kotlin.e0.c.l lVar, int i3, Object obj2) {
        if (obj2 == null) {
            if ((i3 & 4) != 0) {
                lVar = null;
            }
            fVar.F(obj, i2, lVar);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: resumeImpl");
    }

    private final Object H(a1 a1Var, Object obj, int i2, kotlin.e0.c.l<? super Throwable, kotlin.x> lVar, Object obj2) {
        if (obj instanceof n) {
            if (x.a()) {
                if (!(obj2 == null)) {
                    throw new AssertionError();
                }
            }
            if (x.a()) {
                if (lVar == null) {
                    return obj;
                }
                throw new AssertionError();
            }
            return obj;
        } else if (b0.b(i2) || obj2 != null) {
            if (lVar == null && !(a1Var instanceof c) && obj2 == null) {
                return obj;
            }
            if (!(a1Var instanceof c)) {
                a1Var = null;
            }
            return new m(obj, (c) a1Var, lVar, obj2, null, 16, null);
        } else {
            return obj;
        }
    }

    private final void I(d0 d0Var) {
        this._parentHandle = d0Var;
    }

    private final void J() {
        r0 r0Var;
        if (r() || w() != null || (r0Var = (r0) this.f17424g.e().get(r0.s)) == null) {
            return;
        }
        d0 d2 = r0.a.d(r0Var, true, false, new h(r0Var, this), 2, null);
        I(d2);
        if (!z() || A()) {
            return;
        }
        d2.dispose();
        I(z0.a);
    }

    private final boolean K() {
        do {
            int i2 = this._decision;
            if (i2 != 0) {
                if (i2 == 1) {
                    return false;
                }
                throw new IllegalStateException("Already resumed".toString());
            }
        } while (!f17421d.compareAndSet(this, 0, 2));
        return true;
    }

    private final boolean L() {
        do {
            int i2 = this._decision;
            if (i2 != 0) {
                if (i2 == 2) {
                    return false;
                }
                throw new IllegalStateException("Already suspended".toString());
            }
        } while (!f17421d.compareAndSet(this, 0, 1));
        return true;
    }

    private final Void l(Object obj) {
        throw new IllegalStateException(("Already resumed, but proposed with update " + obj).toString());
    }

    private final void m(kotlin.e0.c.l<? super Throwable, kotlin.x> lVar, Throwable th) {
        try {
            lVar.invoke(th);
        } catch (Throwable th2) {
            kotlin.c0.f e2 = e();
            v.a(e2, new CompletionHandlerException("Exception in invokeOnCancellation handler for " + this, th2));
        }
    }

    private final boolean q(Throwable th) {
        if (b0.c(this.f17415c)) {
            kotlin.c0.d<T> dVar = this.f17424g;
            if (!(dVar instanceof kotlinx.coroutines.internal.d)) {
                dVar = null;
            }
            kotlinx.coroutines.internal.d dVar2 = (kotlinx.coroutines.internal.d) dVar;
            if (dVar2 != null) {
                return dVar2.o(th);
            }
            return false;
        }
        return false;
    }

    private final boolean r() {
        Throwable l2;
        boolean z = z();
        if (b0.c(this.f17415c)) {
            kotlin.c0.d<T> dVar = this.f17424g;
            if (!(dVar instanceof kotlinx.coroutines.internal.d)) {
                dVar = null;
            }
            kotlinx.coroutines.internal.d dVar2 = (kotlinx.coroutines.internal.d) dVar;
            if (dVar2 == null || (l2 = dVar2.l(this)) == null) {
                return z;
            }
            if (!z) {
                p(l2);
            }
            return true;
        }
        return z;
    }

    private final void t() {
        if (A()) {
            return;
        }
        s();
    }

    private final void u(int i2) {
        if (K()) {
            return;
        }
        b0.a(this, i2);
    }

    private final d0 w() {
        return (d0) this._parentHandle;
    }

    protected String D() {
        return "CancellableContinuation";
    }

    public final void E(Throwable th) {
        if (q(th)) {
            return;
        }
        p(th);
        t();
    }

    @Override // kotlin.c0.i.a.d
    public kotlin.c0.i.a.d a() {
        kotlin.c0.d<T> dVar = this.f17424g;
        if (!(dVar instanceof kotlin.c0.i.a.d)) {
            dVar = null;
        }
        return (kotlin.c0.i.a.d) dVar;
    }

    @Override // kotlin.c0.d
    public void b(Object obj) {
        G(this, q.b(obj, this), this.f17415c, null, 4, null);
    }

    @Override // kotlinx.coroutines.e
    public void c(kotlin.e0.c.l<? super Throwable, kotlin.x> lVar) {
        c B = B(lVar);
        while (true) {
            Object obj = this._state;
            if (obj instanceof a) {
                if (f17422e.compareAndSet(this, obj, B)) {
                    return;
                }
            } else if (obj instanceof c) {
                C(lVar, obj);
            } else {
                boolean z = obj instanceof n;
                if (z) {
                    if (!((n) obj).a()) {
                        C(lVar, obj);
                    }
                    if (obj instanceof g) {
                        if (!z) {
                            obj = null;
                        }
                        n nVar = (n) obj;
                        m(lVar, nVar != null ? nVar.f17525b : null);
                        return;
                    }
                    return;
                } else if (obj instanceof m) {
                    m mVar = (m) obj;
                    if (mVar.f17521b != null) {
                        C(lVar, obj);
                    }
                    if (mVar.c()) {
                        m(lVar, mVar.f17524e);
                        return;
                    } else {
                        if (f17422e.compareAndSet(this, obj, m.b(mVar, null, B, null, null, null, 29, null))) {
                            return;
                        }
                    }
                } else {
                    if (f17422e.compareAndSet(this, obj, new m(obj, B, null, null, null, 28, null))) {
                        return;
                    }
                }
            }
        }
    }

    @Override // kotlin.c0.i.a.d
    public StackTraceElement d() {
        return null;
    }

    @Override // kotlin.c0.d
    public kotlin.c0.f e() {
        return this.f17423f;
    }

    @Override // kotlinx.coroutines.a0
    public void f(Object obj, Throwable th) {
        while (true) {
            Object obj2 = this._state;
            if (!(obj2 instanceof a1)) {
                if (obj2 instanceof n) {
                    return;
                }
                if (obj2 instanceof m) {
                    m mVar = (m) obj2;
                    if (!mVar.c()) {
                        if (f17422e.compareAndSet(this, obj2, m.b(mVar, null, null, null, null, th, 15, null))) {
                            mVar.d(this, th);
                            return;
                        }
                    } else {
                        throw new IllegalStateException("Must be called at most once".toString());
                    }
                } else if (f17422e.compareAndSet(this, obj2, new m(obj2, null, null, null, th, 14, null))) {
                    return;
                }
            } else {
                throw new IllegalStateException("Not completed".toString());
            }
        }
    }

    @Override // kotlinx.coroutines.a0
    public final kotlin.c0.d<T> g() {
        return this.f17424g;
    }

    @Override // kotlinx.coroutines.a0
    public Throwable h(Object obj) {
        Throwable h2 = super.h(obj);
        if (h2 != null) {
            kotlin.c0.d<T> dVar = this.f17424g;
            return (x.c() && (dVar instanceof kotlin.c0.i.a.d)) ? kotlinx.coroutines.internal.n.a(h2, (kotlin.c0.i.a.d) dVar) : h2;
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlinx.coroutines.a0
    public <T> T i(Object obj) {
        return obj instanceof m ? (T) ((m) obj).a : obj;
    }

    @Override // kotlinx.coroutines.a0
    public Object k() {
        return y();
    }

    public final void n(c cVar, Throwable th) {
        try {
            cVar.a(th);
        } catch (Throwable th2) {
            kotlin.c0.f e2 = e();
            v.a(e2, new CompletionHandlerException("Exception in invokeOnCancellation handler for " + this, th2));
        }
    }

    public final void o(kotlin.e0.c.l<? super Throwable, kotlin.x> lVar, Throwable th) {
        try {
            lVar.invoke(th);
        } catch (Throwable th2) {
            kotlin.c0.f e2 = e();
            v.a(e2, new CompletionHandlerException("Exception in resume onCancellation handler for " + this, th2));
        }
    }

    public boolean p(Throwable th) {
        Object obj;
        boolean z;
        do {
            obj = this._state;
            if (!(obj instanceof a1)) {
                return false;
            }
            z = obj instanceof c;
        } while (!f17422e.compareAndSet(this, obj, new g(this, th, z)));
        if (!z) {
            obj = null;
        }
        c cVar = (c) obj;
        if (cVar != null) {
            n(cVar, th);
        }
        t();
        u(this.f17415c);
        return true;
    }

    public final void s() {
        d0 w = w();
        if (w != null) {
            w.dispose();
        }
        I(z0.a);
    }

    public String toString() {
        return D() + '(' + y.c(this.f17424g) + "){" + y() + "}@" + y.b(this);
    }

    public Throwable v(r0 r0Var) {
        return r0Var.f();
    }

    public final Object x() {
        r0 r0Var;
        Object c2;
        J();
        if (L()) {
            c2 = kotlin.c0.h.d.c();
            return c2;
        }
        Object y = y();
        if (y instanceof n) {
            Throwable th = ((n) y).f17525b;
            if (x.c()) {
                throw kotlinx.coroutines.internal.n.a(th, this);
            }
            throw th;
        } else if (b0.b(this.f17415c) && (r0Var = (r0) e().get(r0.s)) != null && !r0Var.a()) {
            CancellationException f2 = r0Var.f();
            f(y, f2);
            if (x.c()) {
                throw kotlinx.coroutines.internal.n.a(f2, this);
            }
            throw f2;
        } else {
            return i(y);
        }
    }

    public final Object y() {
        return this._state;
    }

    public boolean z() {
        return !(y() instanceof a1);
    }
}