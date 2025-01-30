package com.facebook.imagepipeline.memory;

import android.annotation.SuppressLint;
import android.util.SparseArray;
import android.util.SparseIntArray;
import com.lwansbrough.RCTCamera.RCTCameraModule;
import java.util.Set;

/* loaded from: classes2.dex */
public abstract class BasePool<V> implements com.facebook.common.memory.e<V> {
    private final Class<?> a = getClass();

    /* renamed from: b  reason: collision with root package name */
    final com.facebook.common.memory.c f4547b;

    /* renamed from: c  reason: collision with root package name */
    final e0 f4548c;

    /* renamed from: d  reason: collision with root package name */
    final SparseArray<e<V>> f4549d;

    /* renamed from: e  reason: collision with root package name */
    final Set<V> f4550e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f4551f;

    /* renamed from: g  reason: collision with root package name */
    final a f4552g;

    /* renamed from: h  reason: collision with root package name */
    final a f4553h;

    /* renamed from: i  reason: collision with root package name */
    private final f0 f4554i;

    /* loaded from: classes2.dex */
    public static class InvalidSizeException extends RuntimeException {
        public InvalidSizeException(Object obj) {
            super("Invalid size: " + obj.toString());
        }
    }

    /* loaded from: classes2.dex */
    public static class InvalidValueException extends RuntimeException {
    }

    /* loaded from: classes2.dex */
    public static class PoolSizeViolationException extends RuntimeException {
        public PoolSizeViolationException(int i2, int i3, int i4, int i5) {
            super("Pool hard cap violation? Hard cap = " + i2 + " Used size = " + i3 + " Free size = " + i4 + " Request size = " + i5);
        }
    }

    /* loaded from: classes2.dex */
    public static class SizeTooLargeException extends InvalidSizeException {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class a {
        int a;

        /* renamed from: b  reason: collision with root package name */
        int f4555b;

        a() {
        }

        public void a(int i2) {
            int i3;
            int i4 = this.f4555b;
            if (i4 >= i2 && (i3 = this.a) > 0) {
                this.a = i3 - 1;
                this.f4555b = i4 - i2;
                return;
            }
            e.f.d.d.a.H("com.facebook.imagepipeline.memory.BasePool.Counter", "Unexpected decrement of %d. Current numBytes = %d, count = %d", Integer.valueOf(i2), Integer.valueOf(this.f4555b), Integer.valueOf(this.a));
        }

        public void b(int i2) {
            this.a++;
            this.f4555b += i2;
        }
    }

    public BasePool(com.facebook.common.memory.c cVar, e0 e0Var, f0 f0Var) {
        this.f4547b = (com.facebook.common.memory.c) e.f.d.c.i.g(cVar);
        e0 e0Var2 = (e0) e.f.d.c.i.g(e0Var);
        this.f4548c = e0Var2;
        this.f4554i = (f0) e.f.d.c.i.g(f0Var);
        this.f4549d = new SparseArray<>();
        if (e0Var2.f4605f) {
            l();
        } else {
            p(new SparseIntArray(0));
        }
        this.f4550e = e.f.d.c.k.b();
        this.f4553h = new a();
        this.f4552g = new a();
    }

    private synchronized void c() {
        boolean z;
        if (n() && this.f4553h.f4555b != 0) {
            z = false;
            e.f.d.c.i.i(z);
        }
        z = true;
        e.f.d.c.i.i(z);
    }

    private void d(SparseIntArray sparseIntArray) {
        this.f4549d.clear();
        for (int i2 = 0; i2 < sparseIntArray.size(); i2++) {
            int keyAt = sparseIntArray.keyAt(i2);
            this.f4549d.put(keyAt, new e<>(j(keyAt), sparseIntArray.valueAt(i2), 0, this.f4548c.f4605f));
        }
    }

    private synchronized e<V> g(int i2) {
        return this.f4549d.get(i2);
    }

    private synchronized void l() {
        SparseIntArray sparseIntArray = this.f4548c.f4602c;
        if (sparseIntArray != null) {
            d(sparseIntArray);
            this.f4551f = false;
        } else {
            this.f4551f = true;
        }
    }

    private synchronized void p(SparseIntArray sparseIntArray) {
        e.f.d.c.i.g(sparseIntArray);
        this.f4549d.clear();
        SparseIntArray sparseIntArray2 = this.f4548c.f4602c;
        if (sparseIntArray2 != null) {
            for (int i2 = 0; i2 < sparseIntArray2.size(); i2++) {
                int keyAt = sparseIntArray2.keyAt(i2);
                this.f4549d.put(keyAt, new e<>(j(keyAt), sparseIntArray2.valueAt(i2), sparseIntArray.get(keyAt, 0), this.f4548c.f4605f));
            }
            this.f4551f = false;
        } else {
            this.f4551f = true;
        }
    }

    @SuppressLint({"InvalidAccessToGuardedField"})
    private void q() {
        if (e.f.d.d.a.o(2)) {
            e.f.d.d.a.t(this.a, "Used = (%d, %d); Free = (%d, %d)", Integer.valueOf(this.f4552g.a), Integer.valueOf(this.f4552g.f4555b), Integer.valueOf(this.f4553h.a), Integer.valueOf(this.f4553h.f4555b));
        }
    }

    protected abstract V a(int i2);

    synchronized boolean b(int i2) {
        e0 e0Var = this.f4548c;
        int i3 = e0Var.a;
        int i4 = this.f4552g.f4555b;
        if (i2 > i3 - i4) {
            this.f4554i.f();
            return false;
        }
        int i5 = e0Var.f4601b;
        if (i2 > i5 - (i4 + this.f4553h.f4555b)) {
            s(i5 - i2);
        }
        if (i2 > i3 - (this.f4552g.f4555b + this.f4553h.f4555b)) {
            this.f4554i.f();
            return false;
        }
        return true;
    }

    protected abstract void e(V v);

    synchronized e<V> f(int i2) {
        e<V> eVar = this.f4549d.get(i2);
        if (eVar == null && this.f4551f) {
            if (e.f.d.d.a.o(2)) {
                e.f.d.d.a.q(this.a, "creating new bucket %s", Integer.valueOf(i2));
            }
            e<V> r = r(i2);
            this.f4549d.put(i2, r);
            return r;
        }
        return eVar;
    }

    @Override // com.facebook.common.memory.e
    public V get(int i2) {
        V k2;
        c();
        int h2 = h(i2);
        synchronized (this) {
            e<V> f2 = f(h2);
            if (f2 != null && (k2 = k(f2)) != null) {
                e.f.d.c.i.i(this.f4550e.add(k2));
                int i3 = i(k2);
                int j2 = j(i3);
                this.f4552g.b(j2);
                this.f4553h.a(j2);
                this.f4554i.b(j2);
                q();
                if (e.f.d.d.a.o(2)) {
                    e.f.d.d.a.r(this.a, "get (reuse) (object, size) = (%x, %s)", Integer.valueOf(System.identityHashCode(k2)), Integer.valueOf(i3));
                }
                return k2;
            }
            int j3 = j(h2);
            if (b(j3)) {
                this.f4552g.b(j3);
                if (f2 != null) {
                    f2.e();
                }
                V v = null;
                try {
                    v = a(h2);
                } catch (Throwable th) {
                    synchronized (this) {
                        this.f4552g.a(j3);
                        e<V> f3 = f(h2);
                        if (f3 != null) {
                            f3.b();
                        }
                        e.f.d.c.n.c(th);
                    }
                }
                synchronized (this) {
                    e.f.d.c.i.i(this.f4550e.add(v));
                    t();
                    this.f4554i.a(j3);
                    q();
                    if (e.f.d.d.a.o(2)) {
                        e.f.d.d.a.r(this.a, "get (alloc) (object, size) = (%x, %s)", Integer.valueOf(System.identityHashCode(v)), Integer.valueOf(h2));
                    }
                }
                return v;
            }
            throw new PoolSizeViolationException(this.f4548c.a, this.f4552g.f4555b, this.f4553h.f4555b, j3);
        }
    }

    protected abstract int h(int i2);

    protected abstract int i(V v);

    protected abstract int j(int i2);

    /* JADX INFO: Access modifiers changed from: protected */
    public synchronized V k(e<V> eVar) {
        return eVar.c();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void m() {
        this.f4547b.a(this);
        this.f4554i.c(this);
    }

    synchronized boolean n() {
        boolean z;
        z = this.f4552g.f4555b + this.f4553h.f4555b > this.f4548c.f4601b;
        if (z) {
            this.f4554i.d();
        }
        return z;
    }

    protected boolean o(V v) {
        e.f.d.c.i.g(v);
        return true;
    }

    e<V> r(int i2) {
        return new e<>(j(i2), RCTCameraModule.RCT_CAMERA_ORIENTATION_AUTO, 0, this.f4548c.f4605f);
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0080, code lost:
        r2.b();
     */
    @Override // com.facebook.common.memory.e, com.facebook.common.references.c
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void release(V r8) {
        /*
            r7 = this;
            e.f.d.c.i.g(r8)
            int r0 = r7.i(r8)
            int r1 = r7.j(r0)
            monitor-enter(r7)
            com.facebook.imagepipeline.memory.e r2 = r7.g(r0)     // Catch: java.lang.Throwable -> Lae
            java.util.Set<V> r3 = r7.f4550e     // Catch: java.lang.Throwable -> Lae
            boolean r3 = r3.remove(r8)     // Catch: java.lang.Throwable -> Lae
            r4 = 2
            if (r3 != 0) goto L3d
            java.lang.Class<?> r2 = r7.a     // Catch: java.lang.Throwable -> Lae
            java.lang.String r3 = "release (free, value unrecognized) (object, size) = (%x, %s)"
            java.lang.Object[] r4 = new java.lang.Object[r4]     // Catch: java.lang.Throwable -> Lae
            r5 = 0
            int r6 = java.lang.System.identityHashCode(r8)     // Catch: java.lang.Throwable -> Lae
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)     // Catch: java.lang.Throwable -> Lae
            r4[r5] = r6     // Catch: java.lang.Throwable -> Lae
            r5 = 1
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)     // Catch: java.lang.Throwable -> Lae
            r4[r5] = r0     // Catch: java.lang.Throwable -> Lae
            e.f.d.d.a.g(r2, r3, r4)     // Catch: java.lang.Throwable -> Lae
            r7.e(r8)     // Catch: java.lang.Throwable -> Lae
            com.facebook.imagepipeline.memory.f0 r8 = r7.f4554i     // Catch: java.lang.Throwable -> Lae
            r8.e(r1)     // Catch: java.lang.Throwable -> Lae
            goto La9
        L3d:
            if (r2 == 0) goto L7e
            boolean r3 = r2.f()     // Catch: java.lang.Throwable -> Lae
            if (r3 != 0) goto L7e
            boolean r3 = r7.n()     // Catch: java.lang.Throwable -> Lae
            if (r3 != 0) goto L7e
            boolean r3 = r7.o(r8)     // Catch: java.lang.Throwable -> Lae
            if (r3 != 0) goto L52
            goto L7e
        L52:
            r2.h(r8)     // Catch: java.lang.Throwable -> Lae
            com.facebook.imagepipeline.memory.BasePool$a r2 = r7.f4553h     // Catch: java.lang.Throwable -> Lae
            r2.b(r1)     // Catch: java.lang.Throwable -> Lae
            com.facebook.imagepipeline.memory.BasePool$a r2 = r7.f4552g     // Catch: java.lang.Throwable -> Lae
            r2.a(r1)     // Catch: java.lang.Throwable -> Lae
            com.facebook.imagepipeline.memory.f0 r2 = r7.f4554i     // Catch: java.lang.Throwable -> Lae
            r2.g(r1)     // Catch: java.lang.Throwable -> Lae
            boolean r1 = e.f.d.d.a.o(r4)     // Catch: java.lang.Throwable -> Lae
            if (r1 == 0) goto La9
            java.lang.Class<?> r1 = r7.a     // Catch: java.lang.Throwable -> Lae
            java.lang.String r2 = "release (reuse) (object, size) = (%x, %s)"
            int r8 = java.lang.System.identityHashCode(r8)     // Catch: java.lang.Throwable -> Lae
            java.lang.Integer r8 = java.lang.Integer.valueOf(r8)     // Catch: java.lang.Throwable -> Lae
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)     // Catch: java.lang.Throwable -> Lae
            e.f.d.d.a.r(r1, r2, r8, r0)     // Catch: java.lang.Throwable -> Lae
            goto La9
        L7e:
            if (r2 == 0) goto L83
            r2.b()     // Catch: java.lang.Throwable -> Lae
        L83:
            boolean r2 = e.f.d.d.a.o(r4)     // Catch: java.lang.Throwable -> Lae
            if (r2 == 0) goto L9c
            java.lang.Class<?> r2 = r7.a     // Catch: java.lang.Throwable -> Lae
            java.lang.String r3 = "release (free) (object, size) = (%x, %s)"
            int r4 = java.lang.System.identityHashCode(r8)     // Catch: java.lang.Throwable -> Lae
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)     // Catch: java.lang.Throwable -> Lae
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)     // Catch: java.lang.Throwable -> Lae
            e.f.d.d.a.r(r2, r3, r4, r0)     // Catch: java.lang.Throwable -> Lae
        L9c:
            r7.e(r8)     // Catch: java.lang.Throwable -> Lae
            com.facebook.imagepipeline.memory.BasePool$a r8 = r7.f4552g     // Catch: java.lang.Throwable -> Lae
            r8.a(r1)     // Catch: java.lang.Throwable -> Lae
            com.facebook.imagepipeline.memory.f0 r8 = r7.f4554i     // Catch: java.lang.Throwable -> Lae
            r8.e(r1)     // Catch: java.lang.Throwable -> Lae
        La9:
            r7.q()     // Catch: java.lang.Throwable -> Lae
            monitor-exit(r7)     // Catch: java.lang.Throwable -> Lae
            return
        Lae:
            r8 = move-exception
            monitor-exit(r7)     // Catch: java.lang.Throwable -> Lae
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.imagepipeline.memory.BasePool.release(java.lang.Object):void");
    }

    synchronized void s(int i2) {
        int i3 = this.f4552g.f4555b;
        int i4 = this.f4553h.f4555b;
        int min = Math.min((i3 + i4) - i2, i4);
        if (min <= 0) {
            return;
        }
        if (e.f.d.d.a.o(2)) {
            e.f.d.d.a.s(this.a, "trimToSize: TargetSize = %d; Initial Size = %d; Bytes to free = %d", Integer.valueOf(i2), Integer.valueOf(this.f4552g.f4555b + this.f4553h.f4555b), Integer.valueOf(min));
        }
        q();
        for (int i5 = 0; i5 < this.f4549d.size() && min > 0; i5++) {
            e<V> valueAt = this.f4549d.valueAt(i5);
            while (min > 0) {
                V g2 = valueAt.g();
                if (g2 == null) {
                    break;
                }
                e(g2);
                int i6 = valueAt.a;
                min -= i6;
                this.f4553h.a(i6);
            }
        }
        q();
        if (e.f.d.d.a.o(2)) {
            e.f.d.d.a.r(this.a, "trimToSize: TargetSize = %d; Final Size = %d", Integer.valueOf(i2), Integer.valueOf(this.f4552g.f4555b + this.f4553h.f4555b));
        }
    }

    synchronized void t() {
        if (n()) {
            s(this.f4548c.f4601b);
        }
    }
}