package e.f.e;

import android.util.Pair;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executor;

/* compiled from: AbstractDataSource.java */
/* loaded from: classes2.dex */
public abstract class a<T> implements e.f.e.c<T> {

    /* renamed from: c  reason: collision with root package name */
    private T f12101c = null;

    /* renamed from: d  reason: collision with root package name */
    private Throwable f12102d = null;

    /* renamed from: e  reason: collision with root package name */
    private float f12103e = 0.0f;

    /* renamed from: b  reason: collision with root package name */
    private boolean f12100b = false;
    private c a = c.IN_PROGRESS;

    /* renamed from: f  reason: collision with root package name */
    private final ConcurrentLinkedQueue<Pair<e<T>, Executor>> f12104f = new ConcurrentLinkedQueue<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AbstractDataSource.java */
    /* renamed from: e.f.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class RunnableC0263a implements Runnable {
        final /* synthetic */ boolean a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ e f12105b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ boolean f12106c;

        RunnableC0263a(boolean z, e eVar, boolean z2) {
            this.a = z;
            this.f12105b = eVar;
            this.f12106c = z2;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.a) {
                this.f12105b.b(a.this);
            } else if (this.f12106c) {
                this.f12105b.a(a.this);
            } else {
                this.f12105b.c(a.this);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AbstractDataSource.java */
    /* loaded from: classes2.dex */
    public class b implements Runnable {
        final /* synthetic */ e a;

        b(e eVar) {
            this.a = eVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.a.d(a.this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: AbstractDataSource.java */
    /* loaded from: classes2.dex */
    public enum c {
        IN_PROGRESS,
        SUCCESS,
        FAILURE
    }

    private void k(e<T> eVar, Executor executor, boolean z, boolean z2) {
        executor.execute(new RunnableC0263a(z, eVar, z2));
    }

    private void l() {
        boolean i2 = i();
        boolean t = t();
        Iterator<Pair<e<T>, Executor>> it = this.f12104f.iterator();
        while (it.hasNext()) {
            Pair<e<T>, Executor> next = it.next();
            k((e) next.first, (Executor) next.second, i2, t);
        }
    }

    private synchronized boolean o(Throwable th) {
        if (!this.f12100b && this.a == c.IN_PROGRESS) {
            this.a = c.FAILURE;
            this.f12102d = th;
            return true;
        }
        return false;
    }

    private synchronized boolean q(float f2) {
        if (!this.f12100b && this.a == c.IN_PROGRESS) {
            if (f2 < this.f12103e) {
                return false;
            }
            this.f12103e = f2;
            return true;
        }
        return false;
    }

    private boolean s(T t, boolean z) {
        T t2;
        T t3 = null;
        try {
            synchronized (this) {
                try {
                    try {
                        if (!this.f12100b && this.a == c.IN_PROGRESS) {
                            if (z) {
                                this.a = c.SUCCESS;
                                this.f12103e = 1.0f;
                            }
                            T t4 = this.f12101c;
                            if (t4 != t) {
                                try {
                                    this.f12101c = t;
                                    t2 = t4;
                                } catch (Throwable th) {
                                    th = th;
                                    t3 = t4;
                                    throw th;
                                }
                            } else {
                                t2 = null;
                            }
                            return true;
                        }
                        if (t != null) {
                            h(t);
                        }
                        return false;
                    } catch (Throwable th2) {
                        t3 = t;
                        th = th2;
                    }
                } catch (Throwable th3) {
                    th = th3;
                }
            }
        } finally {
            if (t3 != null) {
                h(t3);
            }
        }
    }

    private synchronized boolean t() {
        boolean z;
        if (j()) {
            z = b() ? false : true;
        }
        return z;
    }

    @Override // e.f.e.c
    public synchronized boolean a() {
        return this.f12101c != null;
    }

    @Override // e.f.e.c
    public synchronized boolean b() {
        return this.a != c.IN_PROGRESS;
    }

    @Override // e.f.e.c
    public synchronized Throwable c() {
        return this.f12102d;
    }

    @Override // e.f.e.c
    public boolean close() {
        synchronized (this) {
            if (this.f12100b) {
                return false;
            }
            this.f12100b = true;
            T t = this.f12101c;
            this.f12101c = null;
            if (t != null) {
                h(t);
            }
            if (!b()) {
                l();
            }
            synchronized (this) {
                this.f12104f.clear();
            }
            return true;
        }
    }

    @Override // e.f.e.c
    public synchronized float d() {
        return this.f12103e;
    }

    @Override // e.f.e.c
    public boolean e() {
        return false;
    }

    @Override // e.f.e.c
    public synchronized T f() {
        return this.f12101c;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:28:? A[RETURN, SYNTHETIC] */
    @Override // e.f.e.c
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void g(e.f.e.e<T> r3, java.util.concurrent.Executor r4) {
        /*
            r2 = this;
            e.f.d.c.i.g(r3)
            e.f.d.c.i.g(r4)
            monitor-enter(r2)
            boolean r0 = r2.f12100b     // Catch: java.lang.Throwable -> L41
            if (r0 == 0) goto Ld
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L41
            return
        Ld:
            e.f.e.a$c r0 = r2.a     // Catch: java.lang.Throwable -> L41
            e.f.e.a$c r1 = e.f.e.a.c.IN_PROGRESS     // Catch: java.lang.Throwable -> L41
            if (r0 != r1) goto L1c
            java.util.concurrent.ConcurrentLinkedQueue<android.util.Pair<e.f.e.e<T>, java.util.concurrent.Executor>> r0 = r2.f12104f     // Catch: java.lang.Throwable -> L41
            android.util.Pair r1 = android.util.Pair.create(r3, r4)     // Catch: java.lang.Throwable -> L41
            r0.add(r1)     // Catch: java.lang.Throwable -> L41
        L1c:
            boolean r0 = r2.a()     // Catch: java.lang.Throwable -> L41
            if (r0 != 0) goto L31
            boolean r0 = r2.b()     // Catch: java.lang.Throwable -> L41
            if (r0 != 0) goto L31
            boolean r0 = r2.t()     // Catch: java.lang.Throwable -> L41
            if (r0 == 0) goto L2f
            goto L31
        L2f:
            r0 = 0
            goto L32
        L31:
            r0 = 1
        L32:
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L41
            if (r0 == 0) goto L40
            boolean r0 = r2.i()
            boolean r1 = r2.t()
            r2.k(r3, r4, r0, r1)
        L40:
            return
        L41:
            r3 = move-exception
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L41
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: e.f.e.a.g(e.f.e.e, java.util.concurrent.Executor):void");
    }

    protected void h(T t) {
    }

    public synchronized boolean i() {
        return this.a == c.FAILURE;
    }

    public synchronized boolean j() {
        return this.f12100b;
    }

    protected void m() {
        Iterator<Pair<e<T>, Executor>> it = this.f12104f.iterator();
        while (it.hasNext()) {
            Pair<e<T>, Executor> next = it.next();
            ((Executor) next.second).execute(new b((e) next.first));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean n(Throwable th) {
        boolean o = o(th);
        if (o) {
            l();
        }
        return o;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean p(float f2) {
        boolean q = q(f2);
        if (q) {
            m();
        }
        return q;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean r(T t, boolean z) {
        boolean s = s(t, z);
        if (s) {
            l();
        }
        return s;
    }
}