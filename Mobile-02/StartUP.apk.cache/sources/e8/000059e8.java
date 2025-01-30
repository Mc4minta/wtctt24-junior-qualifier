package kotlinx.coroutines;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* compiled from: EventLoop.common.kt */
/* loaded from: classes3.dex */
public abstract class g0 extends h0 {

    /* renamed from: e  reason: collision with root package name */
    private static final AtomicReferenceFieldUpdater f17429e = AtomicReferenceFieldUpdater.newUpdater(g0.class, Object.class, "_queue");

    /* renamed from: f  reason: collision with root package name */
    private static final AtomicReferenceFieldUpdater f17430f = AtomicReferenceFieldUpdater.newUpdater(g0.class, Object.class, "_delayed");
    private volatile Object _queue = null;
    private volatile Object _delayed = null;
    private volatile int _isCompleted = 0;

    /* compiled from: EventLoop.common.kt */
    /* loaded from: classes3.dex */
    public static abstract class a implements Runnable, Comparable<a>, d0, kotlinx.coroutines.internal.u {
        private Object a;

        /* renamed from: b  reason: collision with root package name */
        private int f17431b;

        /* renamed from: c  reason: collision with root package name */
        public long f17432c;

        public final boolean A(long j2) {
            return j2 - this.f17432c >= 0;
        }

        @Override // kotlinx.coroutines.d0
        public final synchronized void dispose() {
            kotlinx.coroutines.internal.o oVar;
            kotlinx.coroutines.internal.o oVar2;
            Object obj = this.a;
            oVar = j0.a;
            if (obj == oVar) {
                return;
            }
            if (!(obj instanceof b)) {
                obj = null;
            }
            b bVar = (b) obj;
            if (bVar != null) {
                bVar.g(this);
            }
            oVar2 = j0.a;
            this.a = oVar2;
        }

        @Override // kotlinx.coroutines.internal.u
        public int getIndex() {
            return this.f17431b;
        }

        @Override // kotlinx.coroutines.internal.u
        public void h(kotlinx.coroutines.internal.t<?> tVar) {
            kotlinx.coroutines.internal.o oVar;
            Object obj = this.a;
            oVar = j0.a;
            if (obj != oVar) {
                this.a = tVar;
                return;
            }
            throw new IllegalArgumentException("Failed requirement.".toString());
        }

        @Override // kotlinx.coroutines.internal.u
        public kotlinx.coroutines.internal.t<?> q() {
            Object obj = this.a;
            if (!(obj instanceof kotlinx.coroutines.internal.t)) {
                obj = null;
            }
            return (kotlinx.coroutines.internal.t) obj;
        }

        @Override // kotlinx.coroutines.internal.u
        public void s(int i2) {
            this.f17431b = i2;
        }

        public String toString() {
            return "Delayed[nanos=" + this.f17432c + ']';
        }

        @Override // java.lang.Comparable
        /* renamed from: y */
        public int compareTo(a aVar) {
            int i2 = ((this.f17432c - aVar.f17432c) > 0L ? 1 : ((this.f17432c - aVar.f17432c) == 0L ? 0 : -1));
            if (i2 > 0) {
                return 1;
            }
            return i2 < 0 ? -1 : 0;
        }

        public final synchronized int z(long j2, b bVar, g0 g0Var) {
            kotlinx.coroutines.internal.o oVar;
            Object obj = this.a;
            oVar = j0.a;
            if (obj == oVar) {
                return 2;
            }
            synchronized (bVar) {
                a b2 = bVar.b();
                if (g0Var.I0()) {
                    return 1;
                }
                if (b2 == null) {
                    bVar.f17433b = j2;
                } else {
                    long j3 = b2.f17432c;
                    if (j3 - j2 < 0) {
                        j2 = j3;
                    }
                    if (j2 - bVar.f17433b > 0) {
                        bVar.f17433b = j2;
                    }
                }
                long j4 = this.f17432c;
                long j5 = bVar.f17433b;
                if (j4 - j5 < 0) {
                    this.f17432c = j5;
                }
                bVar.a(this);
                return 0;
            }
        }
    }

    /* compiled from: EventLoop.common.kt */
    /* loaded from: classes3.dex */
    public static final class b extends kotlinx.coroutines.internal.t<a> {

        /* renamed from: b  reason: collision with root package name */
        public long f17433b;

        public b(long j2) {
            this.f17433b = j2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r0v0, types: [int, boolean] */
    public final boolean I0() {
        return this._isCompleted;
    }

    private final void M0() {
        a i2;
        e1 a2 = f1.a();
        long nanoTime = a2 != null ? a2.nanoTime() : System.nanoTime();
        while (true) {
            b bVar = (b) this._delayed;
            if (bVar == null || (i2 = bVar.i()) == null) {
                return;
            }
            o0(nanoTime, i2);
        }
    }

    private final int R0(long j2, a aVar) {
        if (I0()) {
            return 1;
        }
        b bVar = (b) this._delayed;
        if (bVar == null) {
            f17430f.compareAndSet(this, null, new b(j2));
            Object obj = this._delayed;
            kotlin.jvm.internal.m.e(obj);
            bVar = (b) obj;
        }
        return aVar.z(j2, bVar, this);
    }

    private final void S0(boolean z) {
        this._isCompleted = z ? 1 : 0;
    }

    private final boolean W0(a aVar) {
        b bVar = (b) this._delayed;
        return (bVar != null ? bVar.e() : null) == aVar;
    }

    private final void w0() {
        kotlinx.coroutines.internal.o oVar;
        kotlinx.coroutines.internal.o oVar2;
        if (x.a() && !I0()) {
            throw new AssertionError();
        }
        while (true) {
            Object obj = this._queue;
            if (obj == null) {
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f17429e;
                oVar = j0.f17516b;
                if (atomicReferenceFieldUpdater.compareAndSet(this, null, oVar)) {
                    return;
                }
            } else if (!(obj instanceof kotlinx.coroutines.internal.k)) {
                oVar2 = j0.f17516b;
                if (obj == oVar2) {
                    return;
                }
                kotlinx.coroutines.internal.k kVar = new kotlinx.coroutines.internal.k(8, true);
                kVar.a((Runnable) obj);
                if (f17429e.compareAndSet(this, obj, kVar)) {
                    return;
                }
            } else {
                ((kotlinx.coroutines.internal.k) obj).d();
                return;
            }
        }
    }

    private final Runnable x0() {
        kotlinx.coroutines.internal.o oVar;
        while (true) {
            Object obj = this._queue;
            if (obj == null) {
                return null;
            }
            if (!(obj instanceof kotlinx.coroutines.internal.k)) {
                oVar = j0.f17516b;
                if (obj == oVar) {
                    return null;
                }
                if (f17429e.compareAndSet(this, obj, null)) {
                    return (Runnable) obj;
                }
            } else {
                kotlinx.coroutines.internal.k kVar = (kotlinx.coroutines.internal.k) obj;
                Object j2 = kVar.j();
                if (j2 != kotlinx.coroutines.internal.k.f17502c) {
                    return (Runnable) j2;
                }
                f17429e.compareAndSet(this, obj, kVar.i());
            }
        }
    }

    private final boolean z0(Runnable runnable) {
        kotlinx.coroutines.internal.o oVar;
        while (true) {
            Object obj = this._queue;
            if (I0()) {
                return false;
            }
            if (obj == null) {
                if (f17429e.compareAndSet(this, null, runnable)) {
                    return true;
                }
            } else if (!(obj instanceof kotlinx.coroutines.internal.k)) {
                oVar = j0.f17516b;
                if (obj == oVar) {
                    return false;
                }
                kotlinx.coroutines.internal.k kVar = new kotlinx.coroutines.internal.k(8, true);
                kVar.a((Runnable) obj);
                kVar.a(runnable);
                if (f17429e.compareAndSet(this, obj, kVar)) {
                    return true;
                }
            } else {
                kotlinx.coroutines.internal.k kVar2 = (kotlinx.coroutines.internal.k) obj;
                int a2 = kVar2.a(runnable);
                if (a2 == 0) {
                    return true;
                }
                if (a2 == 1) {
                    f17429e.compareAndSet(this, obj, kVar2.i());
                } else if (a2 == 2) {
                    return false;
                }
            }
        }
    }

    @Override // kotlinx.coroutines.t
    public final void A(kotlin.c0.f fVar, Runnable runnable) {
        y0(runnable);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean J0() {
        kotlinx.coroutines.internal.o oVar;
        if (g0()) {
            b bVar = (b) this._delayed;
            if (bVar == null || bVar.d()) {
                Object obj = this._queue;
                if (obj != null) {
                    if (obj instanceof kotlinx.coroutines.internal.k) {
                        return ((kotlinx.coroutines.internal.k) obj).g();
                    }
                    oVar = j0.f17516b;
                    if (obj != oVar) {
                        return false;
                    }
                }
                return true;
            }
            return false;
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0057  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public long L0() {
        /*
            r9 = this;
            boolean r0 = r9.k0()
            r1 = 0
            if (r0 == 0) goto L9
            return r1
        L9:
            java.lang.Object r0 = r9._delayed
            kotlinx.coroutines.g0$b r0 = (kotlinx.coroutines.g0.b) r0
            if (r0 == 0) goto L4d
            boolean r3 = r0.d()
            if (r3 != 0) goto L4d
            kotlinx.coroutines.e1 r3 = kotlinx.coroutines.f1.a()
            if (r3 == 0) goto L20
            long r3 = r3.nanoTime()
            goto L24
        L20:
            long r3 = java.lang.System.nanoTime()
        L24:
            monitor-enter(r0)
            kotlinx.coroutines.internal.u r5 = r0.b()     // Catch: java.lang.Throwable -> L4a
            r6 = 0
            if (r5 == 0) goto L44
            kotlinx.coroutines.g0$a r5 = (kotlinx.coroutines.g0.a) r5     // Catch: java.lang.Throwable -> L4a
            boolean r7 = r5.A(r3)     // Catch: java.lang.Throwable -> L4a
            r8 = 0
            if (r7 == 0) goto L3a
            boolean r5 = r9.z0(r5)     // Catch: java.lang.Throwable -> L4a
            goto L3b
        L3a:
            r5 = r8
        L3b:
            if (r5 == 0) goto L42
            kotlinx.coroutines.internal.u r5 = r0.h(r8)     // Catch: java.lang.Throwable -> L4a
            r6 = r5
        L42:
            monitor-exit(r0)
            goto L45
        L44:
            monitor-exit(r0)
        L45:
            kotlinx.coroutines.g0$a r6 = (kotlinx.coroutines.g0.a) r6
            if (r6 == 0) goto L4d
            goto L24
        L4a:
            r1 = move-exception
            monitor-exit(r0)
            throw r1
        L4d:
            java.lang.Runnable r0 = r9.x0()
            if (r0 == 0) goto L57
            r0.run()
            return r1
        L57:
            long r0 = r9.V()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.g0.L0():long");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void O0() {
        this._queue = null;
        this._delayed = null;
    }

    public final void Q0(long j2, a aVar) {
        int R0 = R0(j2, aVar);
        if (R0 == 0) {
            if (W0(aVar)) {
                r0();
            }
        } else if (R0 == 1) {
            o0(j2, aVar);
        } else if (R0 != 2) {
            throw new IllegalStateException("unexpected result".toString());
        }
    }

    @Override // kotlinx.coroutines.f0
    protected long V() {
        a e2;
        kotlinx.coroutines.internal.o oVar;
        if (super.V() == 0) {
            return 0L;
        }
        Object obj = this._queue;
        if (obj != null) {
            if (!(obj instanceof kotlinx.coroutines.internal.k)) {
                oVar = j0.f17516b;
                return obj == oVar ? Long.MAX_VALUE : 0L;
            } else if (!((kotlinx.coroutines.internal.k) obj).g()) {
                return 0L;
            }
        }
        b bVar = (b) this._delayed;
        if (bVar == null || (e2 = bVar.e()) == null) {
            return Long.MAX_VALUE;
        }
        long j2 = e2.f17432c;
        e1 a2 = f1.a();
        return kotlin.i0.d.c(j2 - (a2 != null ? a2.nanoTime() : System.nanoTime()), 0L);
    }

    @Override // kotlinx.coroutines.f0
    protected void shutdown() {
        d1.f17420b.b();
        S0(true);
        w0();
        do {
        } while (L0() <= 0);
        M0();
    }

    public final void y0(Runnable runnable) {
        if (z0(runnable)) {
            r0();
        } else {
            z.f17548h.y0(runnable);
        }
    }
}