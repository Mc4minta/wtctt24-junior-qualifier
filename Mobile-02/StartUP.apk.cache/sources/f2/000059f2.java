package kotlinx.coroutines.i1;

import com.appsflyer.share.Constants;
import com.lwansbrough.RCTCamera.RCTCameraModule;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.locks.LockSupport;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.e1;
import kotlinx.coroutines.f1;
import kotlinx.coroutines.internal.o;
import kotlinx.coroutines.x;
import kotlinx.coroutines.y;

/* compiled from: CoroutineScheduler.kt */
/* loaded from: classes3.dex */
public final class a implements Executor, Closeable {
    private volatile int _isTerminated;
    volatile long controlState;

    /* renamed from: f  reason: collision with root package name */
    public final e f17441f;

    /* renamed from: g  reason: collision with root package name */
    public final e f17442g;

    /* renamed from: h  reason: collision with root package name */
    public final AtomicReferenceArray<b> f17443h;

    /* renamed from: j  reason: collision with root package name */
    public final int f17444j;

    /* renamed from: k  reason: collision with root package name */
    public final int f17445k;

    /* renamed from: l  reason: collision with root package name */
    public final long f17446l;
    public final String m;
    private volatile long parkedWorkersStack;

    /* renamed from: e  reason: collision with root package name */
    public static final C0420a f17440e = new C0420a(null);

    /* renamed from: d  reason: collision with root package name */
    public static final o f17439d = new o("NOT_IN_STACK");
    private static final AtomicLongFieldUpdater a = AtomicLongFieldUpdater.newUpdater(a.class, "parkedWorkersStack");

    /* renamed from: b  reason: collision with root package name */
    static final AtomicLongFieldUpdater f17437b = AtomicLongFieldUpdater.newUpdater(a.class, "controlState");

    /* renamed from: c  reason: collision with root package name */
    private static final AtomicIntegerFieldUpdater f17438c = AtomicIntegerFieldUpdater.newUpdater(a.class, "_isTerminated");

    /* compiled from: CoroutineScheduler.kt */
    /* renamed from: kotlinx.coroutines.i1.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static final class C0420a {
        private C0420a() {
        }

        public /* synthetic */ C0420a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: CoroutineScheduler.kt */
    /* loaded from: classes3.dex */
    public enum c {
        CPU_ACQUIRED,
        BLOCKING,
        PARKING,
        DORMANT,
        TERMINATED
    }

    public a(int i2, int i3, long j2, String str) {
        this.f17444j = i2;
        this.f17445k = i3;
        this.f17446l = j2;
        this.m = str;
        if (!(i2 >= 1)) {
            throw new IllegalArgumentException(("Core pool size " + i2 + " should be at least 1").toString());
        }
        if (!(i3 >= i2)) {
            throw new IllegalArgumentException(("Max pool size " + i3 + " should be greater than or equals to core pool size " + i2).toString());
        }
        if (!(i3 <= 2097150)) {
            throw new IllegalArgumentException(("Max pool size " + i3 + " should not exceed maximal supported number of threads 2097150").toString());
        }
        if (j2 > 0) {
            this.f17441f = new e();
            this.f17442g = new e();
            this.parkedWorkersStack = 0L;
            this.f17443h = new AtomicReferenceArray<>(i3 + 1);
            this.controlState = i2 << 42;
            this._isTerminated = 0;
            return;
        }
        throw new IllegalArgumentException(("Idle worker keep alive time " + j2 + " must be positive").toString());
    }

    private final void K(boolean z) {
        long addAndGet = f17437b.addAndGet(this, 2097152L);
        if (z || d0() || V(addAndGet)) {
            return;
        }
        d0();
    }

    private final i O(b bVar, i iVar, boolean z) {
        if (bVar == null || bVar.f17448c == c.TERMINATED) {
            return iVar;
        }
        if (iVar.f17473b.j() == 0 && bVar.f17448c == c.BLOCKING) {
            return iVar;
        }
        bVar.f17452g = true;
        return bVar.f17447b.a(iVar, z);
    }

    private final boolean V(long j2) {
        int b2;
        b2 = kotlin.i0.f.b(((int) (2097151 & j2)) - ((int) ((j2 & 4398044413952L) >> 21)), 0);
        if (b2 < this.f17444j) {
            int c2 = c();
            if (c2 == 1 && this.f17444j > 1) {
                c();
            }
            if (c2 > 0) {
                return true;
            }
        }
        return false;
    }

    static /* synthetic */ boolean a0(a aVar, long j2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            j2 = aVar.controlState;
        }
        return aVar.V(j2);
    }

    private final boolean b(i iVar) {
        if (iVar.f17473b.j() == 1) {
            return this.f17442g.a(iVar);
        }
        return this.f17441f.a(iVar);
    }

    private final int c() {
        int b2;
        synchronized (this.f17443h) {
            if (isTerminated()) {
                return -1;
            }
            long j2 = this.controlState;
            int i2 = (int) (j2 & 2097151);
            b2 = kotlin.i0.f.b(i2 - ((int) ((j2 & 4398044413952L) >> 21)), 0);
            if (b2 >= this.f17444j) {
                return 0;
            }
            if (i2 >= this.f17445k) {
                return 0;
            }
            int i3 = ((int) (this.controlState & 2097151)) + 1;
            if (i3 > 0 && this.f17443h.get(i3) == null) {
                b bVar = new b(this, i3);
                this.f17443h.set(i3, bVar);
                if (i3 == ((int) (2097151 & f17437b.incrementAndGet(this)))) {
                    bVar.start();
                    return b2 + 1;
                }
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
    }

    private final boolean d0() {
        b n;
        do {
            n = n();
            if (n == null) {
                return false;
            }
        } while (!b.a.compareAndSet(n, -1, 0));
        LockSupport.unpark(n);
        return true;
    }

    private final b e() {
        Thread currentThread = Thread.currentThread();
        if (!(currentThread instanceof b)) {
            currentThread = null;
        }
        b bVar = (b) currentThread;
        if (bVar == null || !kotlin.jvm.internal.m.c(a.this, this)) {
            return null;
        }
        return bVar;
    }

    public static /* synthetic */ void g(a aVar, Runnable runnable, j jVar, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            jVar = h.f17472b;
        }
        if ((i2 & 4) != 0) {
            z = false;
        }
        aVar.f(runnable, jVar, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int j() {
        return (int) (this.controlState & 2097151);
    }

    private final int m(b bVar) {
        Object g2 = bVar.g();
        while (g2 != f17439d) {
            if (g2 == null) {
                return 0;
            }
            b bVar2 = (b) g2;
            int f2 = bVar2.f();
            if (f2 != 0) {
                return f2;
            }
            g2 = bVar2.g();
        }
        return -1;
    }

    private final b n() {
        while (true) {
            long j2 = this.parkedWorkersStack;
            b bVar = this.f17443h.get((int) (2097151 & j2));
            if (bVar == null) {
                return null;
            }
            long j3 = (2097152 + j2) & (-2097152);
            int m = m(bVar);
            if (m >= 0 && a.compareAndSet(this, j2, m | j3)) {
                bVar.o(f17439d);
                return bVar;
            }
        }
    }

    public final void A(i iVar) {
        try {
            iVar.run();
        } catch (Throwable th) {
            try {
                Thread currentThread = Thread.currentThread();
                currentThread.getUncaughtExceptionHandler().uncaughtException(currentThread, th);
                e1 a2 = f1.a();
                if (a2 == null) {
                }
            } finally {
                e1 a3 = f1.a();
                if (a3 != null) {
                    a3.c();
                }
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x006b, code lost:
        if (r9 != null) goto L37;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void G(long r9) {
        /*
            r8 = this;
            java.util.concurrent.atomic.AtomicIntegerFieldUpdater r0 = kotlinx.coroutines.i1.a.f17438c
            r1 = 0
            r2 = 1
            boolean r0 = r0.compareAndSet(r8, r1, r2)
            if (r0 != 0) goto Lb
            return
        Lb:
            kotlinx.coroutines.i1.a$b r0 = r8.e()
            java.util.concurrent.atomic.AtomicReferenceArray<kotlinx.coroutines.i1.a$b> r3 = r8.f17443h
            monitor-enter(r3)
            long r4 = r8.controlState     // Catch: java.lang.Throwable -> Lb5
            r6 = 2097151(0x1fffff, double:1.0361303E-317)
            long r4 = r4 & r6
            int r4 = (int) r4
            monitor-exit(r3)
            if (r2 > r4) goto L5b
            r3 = r2
        L1d:
            java.util.concurrent.atomic.AtomicReferenceArray<kotlinx.coroutines.i1.a$b> r5 = r8.f17443h
            java.lang.Object r5 = r5.get(r3)
            kotlin.jvm.internal.m.e(r5)
            kotlinx.coroutines.i1.a$b r5 = (kotlinx.coroutines.i1.a.b) r5
            if (r5 == r0) goto L56
        L2a:
            boolean r6 = r5.isAlive()
            if (r6 == 0) goto L37
            java.util.concurrent.locks.LockSupport.unpark(r5)
            r5.join(r9)
            goto L2a
        L37:
            kotlinx.coroutines.i1.a$c r6 = r5.f17448c
            boolean r7 = kotlinx.coroutines.x.a()
            if (r7 == 0) goto L4f
            kotlinx.coroutines.i1.a$c r7 = kotlinx.coroutines.i1.a.c.TERMINATED
            if (r6 != r7) goto L45
            r6 = r2
            goto L46
        L45:
            r6 = r1
        L46:
            if (r6 == 0) goto L49
            goto L4f
        L49:
            java.lang.AssertionError r9 = new java.lang.AssertionError
            r9.<init>()
            throw r9
        L4f:
            kotlinx.coroutines.i1.n r5 = r5.f17447b
            kotlinx.coroutines.i1.e r6 = r8.f17442g
            r5.g(r6)
        L56:
            if (r3 == r4) goto L5b
            int r3 = r3 + 1
            goto L1d
        L5b:
            kotlinx.coroutines.i1.e r9 = r8.f17442g
            r9.b()
            kotlinx.coroutines.i1.e r9 = r8.f17441f
            r9.b()
        L65:
            if (r0 == 0) goto L6e
            kotlinx.coroutines.i1.i r9 = r0.e(r2)
            if (r9 == 0) goto L6e
            goto L76
        L6e:
            kotlinx.coroutines.i1.e r9 = r8.f17441f
            java.lang.Object r9 = r9.d()
            kotlinx.coroutines.i1.i r9 = (kotlinx.coroutines.i1.i) r9
        L76:
            if (r9 == 0) goto L79
            goto L81
        L79:
            kotlinx.coroutines.i1.e r9 = r8.f17442g
            java.lang.Object r9 = r9.d()
            kotlinx.coroutines.i1.i r9 = (kotlinx.coroutines.i1.i) r9
        L81:
            if (r9 == 0) goto L87
            r8.A(r9)
            goto L65
        L87:
            if (r0 == 0) goto L8e
            kotlinx.coroutines.i1.a$c r9 = kotlinx.coroutines.i1.a.c.TERMINATED
            r0.r(r9)
        L8e:
            boolean r9 = kotlinx.coroutines.x.a()
            if (r9 == 0) goto Lae
            long r9 = r8.controlState
            r3 = 9223367638808264704(0x7ffffc0000000000, double:NaN)
            long r9 = r9 & r3
            r0 = 42
            long r9 = r9 >> r0
            int r9 = (int) r9
            int r10 = r8.f17444j
            if (r9 != r10) goto La5
            r1 = r2
        La5:
            if (r1 == 0) goto La8
            goto Lae
        La8:
            java.lang.AssertionError r9 = new java.lang.AssertionError
            r9.<init>()
            throw r9
        Lae:
            r9 = 0
            r8.parkedWorkersStack = r9
            r8.controlState = r9
            return
        Lb5:
            r9 = move-exception
            monitor-exit(r3)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.i1.a.G(long):void");
    }

    public final void N() {
        if (d0() || a0(this, 0L, 1, null)) {
            return;
        }
        d0();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        G(10000L);
    }

    public final i d(Runnable runnable, j jVar) {
        long a2 = l.f17479f.a();
        if (runnable instanceof i) {
            i iVar = (i) runnable;
            iVar.a = a2;
            iVar.f17473b = jVar;
            return iVar;
        }
        return new k(runnable, a2, jVar);
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        g(this, runnable, null, false, 6, null);
    }

    public final void f(Runnable runnable, j jVar, boolean z) {
        e1 a2 = f1.a();
        if (a2 != null) {
            a2.g();
        }
        i d2 = d(runnable, jVar);
        b e2 = e();
        i O = O(e2, d2, z);
        if (O != null && !b(O)) {
            throw new RejectedExecutionException(this.m + " was terminated");
        }
        boolean z2 = z && e2 != null;
        if (d2.f17473b.j() != 0) {
            K(z2);
        } else if (z2) {
        } else {
            N();
        }
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [int, boolean] */
    public final boolean isTerminated() {
        return this._isTerminated;
    }

    public String toString() {
        ArrayList arrayList = new ArrayList();
        int length = this.f17443h.length();
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        for (int i7 = 1; i7 < length; i7++) {
            b bVar = this.f17443h.get(i7);
            if (bVar != null) {
                int f2 = bVar.f17447b.f();
                int i8 = kotlinx.coroutines.i1.b.a[bVar.f17448c.ordinal()];
                if (i8 == 1) {
                    i4++;
                } else if (i8 == 2) {
                    i3++;
                    arrayList.add(String.valueOf(f2) + "b");
                } else if (i8 == 3) {
                    i2++;
                    arrayList.add(String.valueOf(f2) + Constants.URL_CAMPAIGN);
                } else if (i8 == 4) {
                    i5++;
                    if (f2 > 0) {
                        arrayList.add(String.valueOf(f2) + "d");
                    }
                } else if (i8 == 5) {
                    i6++;
                }
            }
        }
        long j2 = this.controlState;
        return this.m + '@' + y.b(this) + "[Pool Size {core = " + this.f17444j + ", max = " + this.f17445k + "}, Worker States {CPU = " + i2 + ", blocking = " + i3 + ", parked = " + i4 + ", dormant = " + i5 + ", terminated = " + i6 + "}, running workers queues = " + arrayList + ", global CPU queue size = " + this.f17441f.c() + ", global blocking queue size = " + this.f17442g.c() + ", Control State {created workers= " + ((int) (2097151 & j2)) + ", blocking tasks = " + ((int) ((4398044413952L & j2) >> 21)) + ", CPUs acquired = " + (this.f17444j - ((int) ((9223367638808264704L & j2) >> 42))) + "}]";
    }

    public final boolean v(b bVar) {
        long j2;
        long j3;
        int f2;
        if (bVar.g() != f17439d) {
            return false;
        }
        do {
            j2 = this.parkedWorkersStack;
            int i2 = (int) (2097151 & j2);
            j3 = (2097152 + j2) & (-2097152);
            f2 = bVar.f();
            if (x.a()) {
                if (!(f2 != 0)) {
                    throw new AssertionError();
                }
            }
            bVar.o(this.f17443h.get(i2));
        } while (!a.compareAndSet(this, j2, f2 | j3));
        return true;
    }

    public final void z(b bVar, int i2, int i3) {
        while (true) {
            long j2 = this.parkedWorkersStack;
            int i4 = (int) (2097151 & j2);
            long j3 = (2097152 + j2) & (-2097152);
            if (i4 == i2) {
                i4 = i3 == 0 ? m(bVar) : i3;
            }
            if (i4 >= 0 && a.compareAndSet(this, j2, j3 | i4)) {
                return;
            }
        }
    }

    /* compiled from: CoroutineScheduler.kt */
    /* loaded from: classes3.dex */
    public final class b extends Thread {
        static final AtomicIntegerFieldUpdater a = AtomicIntegerFieldUpdater.newUpdater(b.class, "workerCtl");

        /* renamed from: b  reason: collision with root package name */
        public final n f17447b;

        /* renamed from: c  reason: collision with root package name */
        public c f17448c;

        /* renamed from: d  reason: collision with root package name */
        private long f17449d;

        /* renamed from: e  reason: collision with root package name */
        private long f17450e;

        /* renamed from: f  reason: collision with root package name */
        private int f17451f;

        /* renamed from: g  reason: collision with root package name */
        public boolean f17452g;
        private volatile int indexInArray;
        private volatile Object nextParkedWorker;
        volatile int workerCtl;

        private b() {
            setDaemon(true);
            this.f17447b = new n();
            this.f17448c = c.DORMANT;
            this.workerCtl = 0;
            this.nextParkedWorker = a.f17439d;
            this.f17451f = kotlin.h0.c.f17279b.c();
        }

        private final void a(int i2) {
            if (i2 == 0) {
                return;
            }
            a.f17437b.addAndGet(a.this, -2097152L);
            c cVar = this.f17448c;
            if (cVar != c.TERMINATED) {
                if (x.a()) {
                    if (!(cVar == c.BLOCKING)) {
                        throw new AssertionError();
                    }
                }
                this.f17448c = c.DORMANT;
            }
        }

        private final void b(int i2) {
            if (i2 != 0 && r(c.BLOCKING)) {
                a.this.N();
            }
        }

        private final void c(i iVar) {
            int j2 = iVar.f17473b.j();
            h(j2);
            b(j2);
            a.this.A(iVar);
            a(j2);
        }

        private final i d(boolean z) {
            i l2;
            i l3;
            if (z) {
                boolean z2 = j(a.this.f17444j * 2) == 0;
                if (z2 && (l3 = l()) != null) {
                    return l3;
                }
                i h2 = this.f17447b.h();
                if (h2 != null) {
                    return h2;
                }
                if (!z2 && (l2 = l()) != null) {
                    return l2;
                }
            } else {
                i l4 = l();
                if (l4 != null) {
                    return l4;
                }
            }
            return s(false);
        }

        private final void h(int i2) {
            this.f17449d = 0L;
            if (this.f17448c == c.PARKING) {
                if (x.a()) {
                    if (!(i2 == 1)) {
                        throw new AssertionError();
                    }
                }
                this.f17448c = c.BLOCKING;
            }
        }

        private final boolean i() {
            return this.nextParkedWorker != a.f17439d;
        }

        private final void k() {
            if (this.f17449d == 0) {
                this.f17449d = System.nanoTime() + a.this.f17446l;
            }
            LockSupport.parkNanos(a.this.f17446l);
            if (System.nanoTime() - this.f17449d >= 0) {
                this.f17449d = 0L;
                t();
            }
        }

        private final i l() {
            if (j(2) == 0) {
                i d2 = a.this.f17441f.d();
                return d2 != null ? d2 : a.this.f17442g.d();
            }
            i d3 = a.this.f17442g.d();
            return d3 != null ? d3 : a.this.f17441f.d();
        }

        private final void m() {
            loop0: while (true) {
                boolean z = false;
                while (!a.this.isTerminated() && this.f17448c != c.TERMINATED) {
                    i e2 = e(this.f17452g);
                    if (e2 != null) {
                        this.f17450e = 0L;
                        c(e2);
                    } else {
                        this.f17452g = false;
                        if (this.f17450e == 0) {
                            q();
                        } else if (z) {
                            r(c.PARKING);
                            Thread.interrupted();
                            LockSupport.parkNanos(this.f17450e);
                            this.f17450e = 0L;
                        } else {
                            z = true;
                        }
                    }
                }
            }
            r(c.TERMINATED);
        }

        private final boolean p() {
            boolean z;
            if (this.f17448c != c.CPU_ACQUIRED) {
                a aVar = a.this;
                while (true) {
                    long j2 = aVar.controlState;
                    if (((int) ((9223367638808264704L & j2) >> 42)) != 0) {
                        if (a.f17437b.compareAndSet(aVar, j2, j2 - 4398046511104L)) {
                            z = true;
                            break;
                        }
                    } else {
                        z = false;
                        break;
                    }
                }
                if (!z) {
                    return false;
                }
                this.f17448c = c.CPU_ACQUIRED;
            }
            return true;
        }

        private final void q() {
            if (!i()) {
                a.this.v(this);
                return;
            }
            if (x.a()) {
                if (!(this.f17447b.f() == 0)) {
                    throw new AssertionError();
                }
            }
            this.workerCtl = -1;
            while (i() && this.workerCtl == -1 && !a.this.isTerminated() && this.f17448c != c.TERMINATED) {
                r(c.PARKING);
                Thread.interrupted();
                k();
            }
        }

        private final i s(boolean z) {
            long l2;
            if (x.a()) {
                if (!(this.f17447b.f() == 0)) {
                    throw new AssertionError();
                }
            }
            int j2 = a.this.j();
            if (j2 < 2) {
                return null;
            }
            int j3 = j(j2);
            long j4 = Long.MAX_VALUE;
            for (int i2 = 0; i2 < j2; i2++) {
                j3++;
                if (j3 > j2) {
                    j3 = 1;
                }
                b bVar = a.this.f17443h.get(j3);
                if (bVar != null && bVar != this) {
                    if (x.a()) {
                        if (!(this.f17447b.f() == 0)) {
                            throw new AssertionError();
                        }
                    }
                    if (z) {
                        l2 = this.f17447b.k(bVar.f17447b);
                    } else {
                        l2 = this.f17447b.l(bVar.f17447b);
                    }
                    if (l2 == -1) {
                        return this.f17447b.h();
                    }
                    if (l2 > 0) {
                        j4 = Math.min(j4, l2);
                    }
                }
            }
            if (j4 == Long.MAX_VALUE) {
                j4 = 0;
            }
            this.f17450e = j4;
            return null;
        }

        private final void t() {
            synchronized (a.this.f17443h) {
                if (a.this.isTerminated()) {
                    return;
                }
                if (a.this.j() <= a.this.f17444j) {
                    return;
                }
                if (a.compareAndSet(this, -1, 1)) {
                    int i2 = this.indexInArray;
                    n(0);
                    a.this.z(this, i2, 0);
                    int andDecrement = (int) (a.f17437b.getAndDecrement(a.this) & 2097151);
                    if (andDecrement != i2) {
                        b bVar = a.this.f17443h.get(andDecrement);
                        kotlin.jvm.internal.m.e(bVar);
                        b bVar2 = bVar;
                        a.this.f17443h.set(i2, bVar2);
                        bVar2.n(i2);
                        a.this.z(bVar2, andDecrement, i2);
                    }
                    a.this.f17443h.set(andDecrement, null);
                    kotlin.x xVar = kotlin.x.a;
                    this.f17448c = c.TERMINATED;
                }
            }
        }

        public final i e(boolean z) {
            i d2;
            if (p()) {
                return d(z);
            }
            if (z) {
                d2 = this.f17447b.h();
                if (d2 == null) {
                    d2 = a.this.f17442g.d();
                }
            } else {
                d2 = a.this.f17442g.d();
            }
            return d2 != null ? d2 : s(true);
        }

        public final int f() {
            return this.indexInArray;
        }

        public final Object g() {
            return this.nextParkedWorker;
        }

        public final int j(int i2) {
            int i3 = this.f17451f;
            int i4 = i3 ^ (i3 << 13);
            int i5 = i4 ^ (i4 >> 17);
            int i6 = i5 ^ (i5 << 5);
            this.f17451f = i6;
            int i7 = i2 - 1;
            return (i7 & i2) == 0 ? i6 & i7 : (i6 & RCTCameraModule.RCT_CAMERA_ORIENTATION_AUTO) % i2;
        }

        public final void n(int i2) {
            StringBuilder sb = new StringBuilder();
            sb.append(a.this.m);
            sb.append("-worker-");
            sb.append(i2 == 0 ? "TERMINATED" : String.valueOf(i2));
            setName(sb.toString());
            this.indexInArray = i2;
        }

        public final void o(Object obj) {
            this.nextParkedWorker = obj;
        }

        public final boolean r(c cVar) {
            c cVar2 = this.f17448c;
            boolean z = cVar2 == c.CPU_ACQUIRED;
            if (z) {
                a.f17437b.addAndGet(a.this, 4398046511104L);
            }
            if (cVar2 != cVar) {
                this.f17448c = cVar;
            }
            return z;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            m();
        }

        public b(a aVar, int i2) {
            this();
            n(i2);
        }
    }
}