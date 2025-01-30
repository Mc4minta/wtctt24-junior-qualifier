package kotlinx.coroutines;

import java.util.ArrayList;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.c0.f;
import kotlinx.coroutines.internal.i;
import kotlinx.coroutines.r0;

/* compiled from: JobSupport.kt */
/* loaded from: classes3.dex */
public class w0 implements r0, k, b1 {
    private static final AtomicReferenceFieldUpdater a = AtomicReferenceFieldUpdater.newUpdater(w0.class, Object.class, "_state");
    private volatile Object _parentHandle;
    private volatile Object _state;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: JobSupport.kt */
    /* loaded from: classes3.dex */
    public static final class a extends v0<r0> {

        /* renamed from: e  reason: collision with root package name */
        private final w0 f17531e;

        /* renamed from: f  reason: collision with root package name */
        private final b f17532f;

        /* renamed from: g  reason: collision with root package name */
        private final j f17533g;

        /* renamed from: h  reason: collision with root package name */
        private final Object f17534h;

        public a(w0 w0Var, b bVar, j jVar, Object obj) {
            super(jVar.f17515e);
            this.f17531e = w0Var;
            this.f17532f = bVar;
            this.f17533g = jVar;
            this.f17534h = obj;
        }

        @Override // kotlin.e0.c.l
        public /* bridge */ /* synthetic */ kotlin.x invoke(Throwable th) {
            q(th);
            return kotlin.x.a;
        }

        @Override // kotlinx.coroutines.p
        public void q(Throwable th) {
            this.f17531e.u(this.f17532f, this.f17533g, this.f17534h);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: JobSupport.kt */
    /* loaded from: classes3.dex */
    public static final class b implements m0 {
        private volatile Object _exceptionsHolder = null;
        private volatile int _isCompleting;
        private volatile Object _rootCause;
        private final y0 a;

        public b(y0 y0Var, boolean z, Throwable th) {
            this.a = y0Var;
            this._isCompleting = z ? 1 : 0;
            this._rootCause = th;
        }

        private final ArrayList<Throwable> d() {
            return new ArrayList<>(4);
        }

        private final Object e() {
            return this._exceptionsHolder;
        }

        private final void l(Object obj) {
            this._exceptionsHolder = obj;
        }

        @Override // kotlinx.coroutines.m0
        public boolean a() {
            return f() == null;
        }

        @Override // kotlinx.coroutines.m0
        public y0 b() {
            return this.a;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final void c(Throwable th) {
            Throwable f2 = f();
            if (f2 == null) {
                m(th);
            } else if (th == f2) {
            } else {
                Object e2 = e();
                if (e2 == null) {
                    l(th);
                } else if (!(e2 instanceof Throwable)) {
                    if (e2 instanceof ArrayList) {
                        ((ArrayList) e2).add(th);
                        return;
                    }
                    throw new IllegalStateException(("State is " + e2).toString());
                } else if (th == e2) {
                } else {
                    ArrayList<Throwable> d2 = d();
                    d2.add(e2);
                    d2.add(th);
                    kotlin.x xVar = kotlin.x.a;
                    l(d2);
                }
            }
        }

        public final Throwable f() {
            return (Throwable) this._rootCause;
        }

        public final boolean g() {
            return f() != null;
        }

        /* JADX WARN: Type inference failed for: r0v0, types: [int, boolean] */
        public final boolean h() {
            return this._isCompleting;
        }

        public final boolean i() {
            kotlinx.coroutines.internal.o oVar;
            Object e2 = e();
            oVar = x0.f17544e;
            return e2 == oVar;
        }

        public final List<Throwable> j(Throwable th) {
            ArrayList<Throwable> arrayList;
            kotlinx.coroutines.internal.o oVar;
            Object e2 = e();
            if (e2 == null) {
                arrayList = d();
            } else if (e2 instanceof Throwable) {
                ArrayList<Throwable> d2 = d();
                d2.add(e2);
                arrayList = d2;
            } else if (!(e2 instanceof ArrayList)) {
                throw new IllegalStateException(("State is " + e2).toString());
            } else {
                arrayList = (ArrayList) e2;
            }
            Throwable f2 = f();
            if (f2 != null) {
                arrayList.add(0, f2);
            }
            if (th != null && (!kotlin.jvm.internal.m.c(th, f2))) {
                arrayList.add(th);
            }
            oVar = x0.f17544e;
            l(oVar);
            return arrayList;
        }

        public final void k(boolean z) {
            this._isCompleting = z ? 1 : 0;
        }

        public final void m(Throwable th) {
            this._rootCause = th;
        }

        public String toString() {
            return "Finishing[cancelling=" + g() + ", completing=" + h() + ", rootCause=" + f() + ", exceptions=" + e() + ", list=" + b() + ']';
        }
    }

    /* compiled from: LockFreeLinkedList.kt */
    /* loaded from: classes3.dex */
    public static final class c extends i.a {

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ kotlinx.coroutines.internal.i f17535d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ w0 f17536e;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ Object f17537f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(kotlinx.coroutines.internal.i iVar, kotlinx.coroutines.internal.i iVar2, w0 w0Var, Object obj) {
            super(iVar2);
            this.f17535d = iVar;
            this.f17536e = w0Var;
            this.f17537f = obj;
        }

        @Override // kotlinx.coroutines.internal.c
        /* renamed from: i */
        public Object g(kotlinx.coroutines.internal.i iVar) {
            if (this.f17536e.F() == this.f17537f) {
                return null;
            }
            return kotlinx.coroutines.internal.h.a();
        }
    }

    private final Throwable A(b bVar, List<? extends Throwable> list) {
        Object obj;
        boolean z;
        Object obj2 = null;
        if (list.isEmpty()) {
            if (bVar.g()) {
                return new JobCancellationException(r(), null, this);
            }
            return null;
        }
        Iterator<T> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (!(((Throwable) obj) instanceof CancellationException)) {
                break;
            }
        }
        Throwable th = (Throwable) obj;
        if (th != null) {
            return th;
        }
        Throwable th2 = list.get(0);
        if (th2 instanceof TimeoutCancellationException) {
            Iterator<T> it2 = list.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                Object next = it2.next();
                Throwable th3 = (Throwable) next;
                if (th3 == th2 || !(th3 instanceof TimeoutCancellationException)) {
                    z = false;
                    continue;
                } else {
                    z = true;
                    continue;
                }
                if (z) {
                    obj2 = next;
                    break;
                }
            }
            Throwable th4 = (Throwable) obj2;
            if (th4 != null) {
                return th4;
            }
        }
        return th2;
    }

    private final y0 D(m0 m0Var) {
        y0 b2 = m0Var.b();
        if (b2 != null) {
            return b2;
        }
        if (m0Var instanceof e0) {
            return new y0();
        }
        if (m0Var instanceof v0) {
            S((v0) m0Var);
            return null;
        }
        throw new IllegalStateException(("State should have list: " + m0Var).toString());
    }

    private final Object J(Object obj) {
        kotlinx.coroutines.internal.o oVar;
        kotlinx.coroutines.internal.o oVar2;
        kotlinx.coroutines.internal.o oVar3;
        kotlinx.coroutines.internal.o oVar4;
        kotlinx.coroutines.internal.o oVar5;
        kotlinx.coroutines.internal.o oVar6;
        Throwable th = null;
        while (true) {
            Object F = F();
            if (F instanceof b) {
                synchronized (F) {
                    if (((b) F).i()) {
                        oVar2 = x0.f17543d;
                        return oVar2;
                    }
                    boolean g2 = ((b) F).g();
                    if (obj != null || !g2) {
                        if (th == null) {
                            th = w(obj);
                        }
                        ((b) F).c(th);
                    }
                    Throwable f2 = g2 ^ true ? ((b) F).f() : null;
                    if (f2 != null) {
                        N(((b) F).b(), f2);
                    }
                    oVar = x0.a;
                    return oVar;
                }
            } else if (!(F instanceof m0)) {
                oVar3 = x0.f17543d;
                return oVar3;
            } else {
                if (th == null) {
                    th = w(obj);
                }
                m0 m0Var = (m0) F;
                if (m0Var.a()) {
                    if (a0(m0Var, th)) {
                        oVar4 = x0.a;
                        return oVar4;
                    }
                } else {
                    Object b0 = b0(F, new n(th, false, 2, null));
                    oVar5 = x0.a;
                    if (b0 != oVar5) {
                        oVar6 = x0.f17542c;
                        if (b0 != oVar6) {
                            return b0;
                        }
                    } else {
                        throw new IllegalStateException(("Cannot happen in " + F).toString());
                    }
                }
            }
        }
    }

    private final v0<?> K(kotlin.e0.c.l<? super Throwable, kotlin.x> lVar, boolean z) {
        if (z) {
            s0 s0Var = lVar instanceof s0 ? lVar : null;
            if (s0Var != null) {
                if (x.a()) {
                    if (s0Var.f17530d == this) {
                        return s0Var;
                    }
                    throw new AssertionError();
                }
                return s0Var;
            }
            return new p0(this, lVar);
        }
        v0<?> v0Var = lVar instanceof v0 ? lVar : null;
        if (v0Var != null) {
            if (x.a()) {
                if (v0Var.f17530d != this || (v0Var instanceof s0)) {
                    r0 = false;
                }
                if (r0) {
                    return v0Var;
                }
                throw new AssertionError();
            }
            return v0Var;
        }
        return new q0(this, lVar);
    }

    private final j M(kotlinx.coroutines.internal.i iVar) {
        while (iVar.k()) {
            iVar = iVar.j();
        }
        while (true) {
            iVar = iVar.i();
            if (!iVar.k()) {
                if (iVar instanceof j) {
                    return (j) iVar;
                }
                if (iVar instanceof y0) {
                    return null;
                }
            }
        }
    }

    private final void N(y0 y0Var, Throwable th) {
        P(th);
        Object h2 = y0Var.h();
        Objects.requireNonNull(h2, "null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */");
        CompletionHandlerException completionHandlerException = null;
        for (kotlinx.coroutines.internal.i iVar = (kotlinx.coroutines.internal.i) h2; !kotlin.jvm.internal.m.c(iVar, y0Var); iVar = iVar.i()) {
            if (iVar instanceof s0) {
                v0 v0Var = (v0) iVar;
                try {
                    v0Var.q(th);
                } catch (Throwable th2) {
                    if (completionHandlerException != null) {
                        kotlin.c.a(completionHandlerException, th2);
                    } else {
                        completionHandlerException = new CompletionHandlerException("Exception in completion handler " + v0Var + " for " + this, th2);
                        kotlin.x xVar = kotlin.x.a;
                    }
                }
            }
        }
        if (completionHandlerException != null) {
            H(completionHandlerException);
        }
        q(th);
    }

    private final void O(y0 y0Var, Throwable th) {
        Object h2 = y0Var.h();
        Objects.requireNonNull(h2, "null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */");
        CompletionHandlerException completionHandlerException = null;
        for (kotlinx.coroutines.internal.i iVar = (kotlinx.coroutines.internal.i) h2; !kotlin.jvm.internal.m.c(iVar, y0Var); iVar = iVar.i()) {
            if (iVar instanceof v0) {
                v0 v0Var = (v0) iVar;
                try {
                    v0Var.q(th);
                } catch (Throwable th2) {
                    if (completionHandlerException != null) {
                        kotlin.c.a(completionHandlerException, th2);
                    } else {
                        completionHandlerException = new CompletionHandlerException("Exception in completion handler " + v0Var + " for " + this, th2);
                        kotlin.x xVar = kotlin.x.a;
                    }
                }
            }
        }
        if (completionHandlerException != null) {
            H(completionHandlerException);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v2, types: [kotlinx.coroutines.l0] */
    private final void R(e0 e0Var) {
        y0 y0Var = new y0();
        if (!e0Var.a()) {
            y0Var = new l0(y0Var);
        }
        a.compareAndSet(this, e0Var, y0Var);
    }

    private final void S(v0<?> v0Var) {
        v0Var.d(new y0());
        a.compareAndSet(this, v0Var, v0Var.i());
    }

    private final String V(Object obj) {
        if (!(obj instanceof b)) {
            return obj instanceof m0 ? ((m0) obj).a() ? "Active" : "New" : obj instanceof n ? "Cancelled" : "Completed";
        }
        b bVar = (b) obj;
        return bVar.g() ? "Cancelling" : bVar.h() ? "Completing" : "Active";
    }

    public static /* synthetic */ CancellationException X(w0 w0Var, Throwable th, String str, int i2, Object obj) {
        if (obj == null) {
            if ((i2 & 1) != 0) {
                str = null;
            }
            return w0Var.W(th, str);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: toCancellationException");
    }

    private final boolean Z(m0 m0Var, Object obj) {
        if (x.a()) {
            if (!((m0Var instanceof e0) || (m0Var instanceof v0))) {
                throw new AssertionError();
            }
        }
        if (!x.a() || (!(obj instanceof n))) {
            if (a.compareAndSet(this, m0Var, x0.f(obj))) {
                P(null);
                Q(obj);
                t(m0Var, obj);
                return true;
            }
            return false;
        }
        throw new AssertionError();
    }

    private final boolean a0(m0 m0Var, Throwable th) {
        if (!x.a() || (!(m0Var instanceof b))) {
            if (!x.a() || m0Var.a()) {
                y0 D = D(m0Var);
                if (D != null) {
                    if (a.compareAndSet(this, m0Var, new b(D, false, th))) {
                        N(D, th);
                        return true;
                    }
                    return false;
                }
                return false;
            }
            throw new AssertionError();
        }
        throw new AssertionError();
    }

    private final Object b0(Object obj, Object obj2) {
        kotlinx.coroutines.internal.o oVar;
        kotlinx.coroutines.internal.o oVar2;
        if (!(obj instanceof m0)) {
            oVar2 = x0.a;
            return oVar2;
        } else if (((obj instanceof e0) || (obj instanceof v0)) && !(obj instanceof j) && !(obj2 instanceof n)) {
            if (Z((m0) obj, obj2)) {
                return obj2;
            }
            oVar = x0.f17542c;
            return oVar;
        } else {
            return c0((m0) obj, obj2);
        }
    }

    private final Object c0(m0 m0Var, Object obj) {
        kotlinx.coroutines.internal.o oVar;
        kotlinx.coroutines.internal.o oVar2;
        kotlinx.coroutines.internal.o oVar3;
        y0 D = D(m0Var);
        if (D == null) {
            oVar = x0.f17542c;
            return oVar;
        }
        b bVar = (b) (!(m0Var instanceof b) ? null : m0Var);
        if (bVar == null) {
            bVar = new b(D, false, null);
        }
        synchronized (bVar) {
            if (bVar.h()) {
                oVar3 = x0.a;
                return oVar3;
            }
            bVar.k(true);
            if (bVar != m0Var && !a.compareAndSet(this, m0Var, bVar)) {
                oVar2 = x0.f17542c;
                return oVar2;
            }
            if (x.a() && !(!bVar.i())) {
                throw new AssertionError();
            }
            boolean g2 = bVar.g();
            n nVar = (n) (!(obj instanceof n) ? null : obj);
            if (nVar != null) {
                bVar.c(nVar.f17525b);
            }
            Throwable f2 = true ^ g2 ? bVar.f() : null;
            kotlin.x xVar = kotlin.x.a;
            if (f2 != null) {
                N(D, f2);
            }
            j y = y(m0Var);
            if (y != null && d0(bVar, y, obj)) {
                return x0.f17541b;
            }
            return x(bVar, obj);
        }
    }

    private final boolean d0(b bVar, j jVar, Object obj) {
        while (r0.a.d(jVar.f17515e, false, false, new a(this, bVar, jVar, obj), 1, null) == z0.a) {
            jVar = M(jVar);
            if (jVar == null) {
                return false;
            }
        }
        return true;
    }

    private final boolean i(Object obj, y0 y0Var, v0<?> v0Var) {
        int p;
        c cVar = new c(v0Var, v0Var, this, obj);
        do {
            p = y0Var.j().p(v0Var, y0Var, cVar);
            if (p == 1) {
                return true;
            }
        } while (p != 2);
        return false;
    }

    private final void j(Throwable th, List<? extends Throwable> list) {
        if (list.size() <= 1) {
            return;
        }
        Set newSetFromMap = Collections.newSetFromMap(new IdentityHashMap(list.size()));
        Throwable k2 = !x.c() ? th : kotlinx.coroutines.internal.n.k(th);
        for (Throwable th2 : list) {
            if (x.c()) {
                th2 = kotlinx.coroutines.internal.n.k(th2);
            }
            if (th2 != th && th2 != k2 && !(th2 instanceof CancellationException) && newSetFromMap.add(th2)) {
                kotlin.c.a(th, th2);
            }
        }
    }

    private final Object p(Object obj) {
        kotlinx.coroutines.internal.o oVar;
        Object b0;
        kotlinx.coroutines.internal.o oVar2;
        do {
            Object F = F();
            if (!(F instanceof m0) || ((F instanceof b) && ((b) F).h())) {
                oVar = x0.a;
                return oVar;
            }
            b0 = b0(F, new n(w(obj), false, 2, null));
            oVar2 = x0.f17542c;
        } while (b0 == oVar2);
        return b0;
    }

    private final boolean q(Throwable th) {
        if (I()) {
            return true;
        }
        boolean z = th instanceof CancellationException;
        i E = E();
        return (E == null || E == z0.a) ? z : E.n(th) || z;
    }

    private final void t(m0 m0Var, Object obj) {
        i E = E();
        if (E != null) {
            E.dispose();
            U(z0.a);
        }
        if (!(obj instanceof n)) {
            obj = null;
        }
        n nVar = (n) obj;
        Throwable th = nVar != null ? nVar.f17525b : null;
        if (m0Var instanceof v0) {
            try {
                ((v0) m0Var).q(th);
                return;
            } catch (Throwable th2) {
                H(new CompletionHandlerException("Exception in completion handler " + m0Var + " for " + this, th2));
                return;
            }
        }
        y0 b2 = m0Var.b();
        if (b2 != null) {
            O(b2, th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void u(b bVar, j jVar, Object obj) {
        if (x.a()) {
            if (!(F() == bVar)) {
                throw new AssertionError();
            }
        }
        j M = M(jVar);
        if (M == null || !d0(bVar, M, obj)) {
            k(x(bVar, obj));
        }
    }

    private final Throwable w(Object obj) {
        if (obj != null ? obj instanceof Throwable : true) {
            return obj != null ? (Throwable) obj : new JobCancellationException(r(), null, this);
        }
        Objects.requireNonNull(obj, "null cannot be cast to non-null type kotlinx.coroutines.ParentJob");
        return ((b1) obj).n();
    }

    private final Object x(b bVar, Object obj) {
        boolean g2;
        Throwable A;
        boolean z = true;
        if (x.a()) {
            if (!(F() == bVar)) {
                throw new AssertionError();
            }
        }
        if (!x.a() || (!bVar.i())) {
            if (!x.a() || bVar.h()) {
                n nVar = (n) (!(obj instanceof n) ? null : obj);
                Throwable th = nVar != null ? nVar.f17525b : null;
                synchronized (bVar) {
                    g2 = bVar.g();
                    List<Throwable> j2 = bVar.j(th);
                    A = A(bVar, j2);
                    if (A != null) {
                        j(A, j2);
                    }
                }
                if (A != null && A != th) {
                    obj = new n(A, false, 2, null);
                }
                if (A != null) {
                    if (!q(A) && !G(A)) {
                        z = false;
                    }
                    if (z) {
                        Objects.requireNonNull(obj, "null cannot be cast to non-null type kotlinx.coroutines.CompletedExceptionally");
                        ((n) obj).a();
                    }
                }
                if (!g2) {
                    P(A);
                }
                Q(obj);
                boolean compareAndSet = a.compareAndSet(this, bVar, x0.f(obj));
                if (!x.a() || compareAndSet) {
                    t(bVar, obj);
                    return obj;
                }
                throw new AssertionError();
            }
            throw new AssertionError();
        }
        throw new AssertionError();
    }

    private final j y(m0 m0Var) {
        j jVar = (j) (!(m0Var instanceof j) ? null : m0Var);
        if (jVar != null) {
            return jVar;
        }
        y0 b2 = m0Var.b();
        if (b2 != null) {
            return M(b2);
        }
        return null;
    }

    public boolean B() {
        return true;
    }

    public boolean C() {
        return false;
    }

    public final i E() {
        return (i) this._parentHandle;
    }

    public final Object F() {
        while (true) {
            Object obj = this._state;
            if (!(obj instanceof kotlinx.coroutines.internal.l)) {
                return obj;
            }
            ((kotlinx.coroutines.internal.l) obj).c(this);
        }
    }

    protected boolean G(Throwable th) {
        return false;
    }

    public void H(Throwable th) {
        throw th;
    }

    protected boolean I() {
        return false;
    }

    public String L() {
        return y.a(this);
    }

    protected void P(Throwable th) {
    }

    protected void Q(Object obj) {
    }

    public final void T(v0<?> v0Var) {
        Object F;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        e0 e0Var;
        do {
            F = F();
            if (!(F instanceof v0)) {
                if (!(F instanceof m0) || ((m0) F).b() == null) {
                    return;
                }
                v0Var.l();
                return;
            } else if (F != v0Var) {
                return;
            } else {
                atomicReferenceFieldUpdater = a;
                e0Var = x0.f17546g;
            }
        } while (!atomicReferenceFieldUpdater.compareAndSet(this, F, e0Var));
    }

    public final void U(i iVar) {
        this._parentHandle = iVar;
    }

    protected final CancellationException W(Throwable th, String str) {
        CancellationException cancellationException = (CancellationException) (!(th instanceof CancellationException) ? null : th);
        if (cancellationException == null) {
            if (str == null) {
                str = r();
            }
            cancellationException = new JobCancellationException(str, th, this);
        }
        return cancellationException;
    }

    public final String Y() {
        return L() + '{' + V(F()) + '}';
    }

    @Override // kotlinx.coroutines.r0
    public boolean a() {
        Object F = F();
        return (F instanceof m0) && ((m0) F).a();
    }

    @Override // kotlinx.coroutines.r0
    public final d0 e(boolean z, boolean z2, kotlin.e0.c.l<? super Throwable, kotlin.x> lVar) {
        Throwable th;
        v0<?> v0Var = null;
        while (true) {
            Object F = F();
            if (F instanceof e0) {
                e0 e0Var = (e0) F;
                if (e0Var.a()) {
                    if (v0Var == null) {
                        v0Var = K(lVar, z);
                    }
                    if (a.compareAndSet(this, F, v0Var)) {
                        return v0Var;
                    }
                } else {
                    R(e0Var);
                }
            } else if (F instanceof m0) {
                y0 b2 = ((m0) F).b();
                if (b2 == null) {
                    Objects.requireNonNull(F, "null cannot be cast to non-null type kotlinx.coroutines.JobNode<*>");
                    S((v0) F);
                } else {
                    d0 d0Var = z0.a;
                    if (z && (F instanceof b)) {
                        synchronized (F) {
                            th = ((b) F).f();
                            if (th == null || ((lVar instanceof j) && !((b) F).h())) {
                                if (v0Var == null) {
                                    v0Var = K(lVar, z);
                                }
                                if (i(F, b2, v0Var)) {
                                    if (th == null) {
                                        return v0Var;
                                    }
                                    d0Var = v0Var;
                                }
                            }
                            kotlin.x xVar = kotlin.x.a;
                        }
                    } else {
                        th = null;
                    }
                    if (th != null) {
                        if (z2) {
                            lVar.invoke(th);
                        }
                        return d0Var;
                    }
                    if (v0Var == null) {
                        v0Var = K(lVar, z);
                    }
                    if (i(F, b2, v0Var)) {
                        return v0Var;
                    }
                }
            } else {
                if (z2) {
                    if (!(F instanceof n)) {
                        F = null;
                    }
                    n nVar = (n) F;
                    lVar.invoke(nVar != null ? nVar.f17525b : null);
                }
                return z0.a;
            }
        }
    }

    @Override // kotlinx.coroutines.r0
    public final CancellationException f() {
        Object F = F();
        if (F instanceof b) {
            Throwable f2 = ((b) F).f();
            if (f2 != null) {
                CancellationException W = W(f2, y.a(this) + " is cancelling");
                if (W != null) {
                    return W;
                }
            }
            throw new IllegalStateException(("Job is still new or active: " + this).toString());
        } else if (!(F instanceof m0)) {
            if (F instanceof n) {
                return X(this, ((n) F).f17525b, null, 1, null);
            }
            return new JobCancellationException(y.a(this) + " has completed normally", null, this);
        } else {
            throw new IllegalStateException(("Job is still new or active: " + this).toString());
        }
    }

    @Override // kotlin.c0.f
    public <R> R fold(R r, kotlin.e0.c.p<? super R, ? super f.b, ? extends R> pVar) {
        return (R) r0.a.b(this, r, pVar);
    }

    @Override // kotlinx.coroutines.k
    public final void g(b1 b1Var) {
        l(b1Var);
    }

    @Override // kotlin.c0.f.b, kotlin.c0.f
    public <E extends f.b> E get(f.c<E> cVar) {
        return (E) r0.a.c(this, cVar);
    }

    @Override // kotlin.c0.f.b
    public final f.c<?> getKey() {
        return r0.s;
    }

    protected void k(Object obj) {
    }

    public final boolean l(Object obj) {
        Object obj2;
        kotlinx.coroutines.internal.o oVar;
        kotlinx.coroutines.internal.o oVar2;
        kotlinx.coroutines.internal.o oVar3;
        obj2 = x0.a;
        if (C() && (obj2 = p(obj)) == x0.f17541b) {
            return true;
        }
        oVar = x0.a;
        if (obj2 == oVar) {
            obj2 = J(obj);
        }
        oVar2 = x0.a;
        if (obj2 == oVar2 || obj2 == x0.f17541b) {
            return true;
        }
        oVar3 = x0.f17543d;
        if (obj2 == oVar3) {
            return false;
        }
        k(obj2);
        return true;
    }

    @Override // kotlin.c0.f
    public kotlin.c0.f minusKey(f.c<?> cVar) {
        return r0.a.e(this, cVar);
    }

    @Override // kotlinx.coroutines.b1
    public CancellationException n() {
        Throwable th;
        Object F = F();
        if (F instanceof b) {
            th = ((b) F).f();
        } else if (F instanceof n) {
            th = ((n) F).f17525b;
        } else if (F instanceof m0) {
            throw new IllegalStateException(("Cannot be cancelling child in this state: " + F).toString());
        } else {
            th = null;
        }
        CancellationException cancellationException = th instanceof CancellationException ? th : null;
        if (cancellationException != null) {
            return cancellationException;
        }
        return new JobCancellationException("Parent job is " + V(F), th, this);
    }

    public void o(Throwable th) {
        l(th);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String r() {
        return "Job was cancelled";
    }

    public boolean s(Throwable th) {
        if (th instanceof CancellationException) {
            return true;
        }
        return l(th) && B();
    }

    public String toString() {
        return Y() + '@' + y.b(this);
    }

    @Override // kotlinx.coroutines.r0
    public void v(CancellationException cancellationException) {
        if (cancellationException == null) {
            cancellationException = new JobCancellationException(r(), null, this);
        }
        o(cancellationException);
    }
}