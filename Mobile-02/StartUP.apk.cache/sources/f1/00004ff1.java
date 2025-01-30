package h.c.n0.f;

import h.c.n0.c.i;
import h.c.n0.j.p;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReferenceArray;

/* compiled from: SpscLinkedArrayQueue.java */
/* loaded from: classes3.dex */
public final class c<T> implements i<T> {
    static final int a = Integer.getInteger("jctools.spsc.max.lookahead.step", 4096).intValue();

    /* renamed from: b  reason: collision with root package name */
    private static final Object f16615b = new Object();

    /* renamed from: d  reason: collision with root package name */
    int f16617d;

    /* renamed from: e  reason: collision with root package name */
    long f16618e;

    /* renamed from: f  reason: collision with root package name */
    final int f16619f;

    /* renamed from: g  reason: collision with root package name */
    AtomicReferenceArray<Object> f16620g;

    /* renamed from: h  reason: collision with root package name */
    final int f16621h;

    /* renamed from: j  reason: collision with root package name */
    AtomicReferenceArray<Object> f16622j;

    /* renamed from: c  reason: collision with root package name */
    final AtomicLong f16616c = new AtomicLong();

    /* renamed from: k  reason: collision with root package name */
    final AtomicLong f16623k = new AtomicLong();

    public c(int i2) {
        int a2 = p.a(Math.max(8, i2));
        int i3 = a2 - 1;
        AtomicReferenceArray<Object> atomicReferenceArray = new AtomicReferenceArray<>(a2 + 1);
        this.f16620g = atomicReferenceArray;
        this.f16619f = i3;
        a(a2);
        this.f16622j = atomicReferenceArray;
        this.f16621h = i3;
        this.f16618e = i3 - 1;
        t(0L);
    }

    private void a(int i2) {
        this.f16617d = Math.min(i2 / 4, a);
    }

    private static int b(int i2) {
        return i2;
    }

    private static int c(long j2, int i2) {
        return b(((int) j2) & i2);
    }

    private long d() {
        return this.f16623k.get();
    }

    private long e() {
        return this.f16616c.get();
    }

    private long f() {
        return this.f16623k.get();
    }

    private static <E> Object g(AtomicReferenceArray<Object> atomicReferenceArray, int i2) {
        return atomicReferenceArray.get(i2);
    }

    private AtomicReferenceArray<Object> h(AtomicReferenceArray<Object> atomicReferenceArray, int i2) {
        int b2 = b(i2);
        AtomicReferenceArray<Object> atomicReferenceArray2 = (AtomicReferenceArray) g(atomicReferenceArray, b2);
        r(atomicReferenceArray, b2, null);
        return atomicReferenceArray2;
    }

    private long i() {
        return this.f16616c.get();
    }

    private T j(AtomicReferenceArray<Object> atomicReferenceArray, long j2, int i2) {
        this.f16622j = atomicReferenceArray;
        return (T) g(atomicReferenceArray, c(j2, i2));
    }

    private T k(AtomicReferenceArray<Object> atomicReferenceArray, long j2, int i2) {
        this.f16622j = atomicReferenceArray;
        int c2 = c(j2, i2);
        T t = (T) g(atomicReferenceArray, c2);
        if (t != null) {
            r(atomicReferenceArray, c2, null);
            q(j2 + 1);
        }
        return t;
    }

    private void o(AtomicReferenceArray<Object> atomicReferenceArray, long j2, int i2, T t, long j3) {
        AtomicReferenceArray<Object> atomicReferenceArray2 = new AtomicReferenceArray<>(atomicReferenceArray.length());
        this.f16620g = atomicReferenceArray2;
        this.f16618e = (j3 + j2) - 1;
        r(atomicReferenceArray2, i2, t);
        s(atomicReferenceArray, atomicReferenceArray2);
        r(atomicReferenceArray, i2, f16615b);
        t(j2 + 1);
    }

    private void q(long j2) {
        this.f16623k.lazySet(j2);
    }

    private static void r(AtomicReferenceArray<Object> atomicReferenceArray, int i2, Object obj) {
        atomicReferenceArray.lazySet(i2, obj);
    }

    private void s(AtomicReferenceArray<Object> atomicReferenceArray, AtomicReferenceArray<Object> atomicReferenceArray2) {
        r(atomicReferenceArray, b(atomicReferenceArray.length() - 1), atomicReferenceArray2);
    }

    private void t(long j2) {
        this.f16616c.lazySet(j2);
    }

    private boolean u(AtomicReferenceArray<Object> atomicReferenceArray, T t, long j2, int i2) {
        r(atomicReferenceArray, i2, t);
        t(j2 + 1);
        return true;
    }

    @Override // h.c.n0.c.j
    public void clear() {
        while (true) {
            if (poll() == null && isEmpty()) {
                return;
            }
        }
    }

    @Override // h.c.n0.c.j
    public boolean isEmpty() {
        return i() == f();
    }

    public boolean l(T t, T t2) {
        AtomicReferenceArray<Object> atomicReferenceArray = this.f16620g;
        long i2 = i();
        int i3 = this.f16619f;
        long j2 = 2 + i2;
        if (g(atomicReferenceArray, c(j2, i3)) == null) {
            int c2 = c(i2, i3);
            r(atomicReferenceArray, c2 + 1, t2);
            r(atomicReferenceArray, c2, t);
            t(j2);
            return true;
        }
        AtomicReferenceArray<Object> atomicReferenceArray2 = new AtomicReferenceArray<>(atomicReferenceArray.length());
        this.f16620g = atomicReferenceArray2;
        int c3 = c(i2, i3);
        r(atomicReferenceArray2, c3 + 1, t2);
        r(atomicReferenceArray2, c3, t);
        s(atomicReferenceArray, atomicReferenceArray2);
        r(atomicReferenceArray, c3, f16615b);
        t(j2);
        return true;
    }

    public T m() {
        AtomicReferenceArray<Object> atomicReferenceArray = this.f16622j;
        long d2 = d();
        int i2 = this.f16621h;
        T t = (T) g(atomicReferenceArray, c(d2, i2));
        return t == f16615b ? j(h(atomicReferenceArray, i2 + 1), d2, i2) : t;
    }

    @Override // h.c.n0.c.j
    public boolean offer(T t) {
        Objects.requireNonNull(t, "Null is not a valid element");
        AtomicReferenceArray<Object> atomicReferenceArray = this.f16620g;
        long e2 = e();
        int i2 = this.f16619f;
        int c2 = c(e2, i2);
        if (e2 < this.f16618e) {
            return u(atomicReferenceArray, t, e2, c2);
        }
        long j2 = this.f16617d + e2;
        if (g(atomicReferenceArray, c(j2, i2)) == null) {
            this.f16618e = j2 - 1;
            return u(atomicReferenceArray, t, e2, c2);
        } else if (g(atomicReferenceArray, c(1 + e2, i2)) == null) {
            return u(atomicReferenceArray, t, e2, c2);
        } else {
            o(atomicReferenceArray, e2, c2, t, i2);
            return true;
        }
    }

    public int p() {
        long f2 = f();
        while (true) {
            long i2 = i();
            long f3 = f();
            if (f2 == f3) {
                return (int) (i2 - f3);
            }
            f2 = f3;
        }
    }

    @Override // h.c.n0.c.i, h.c.n0.c.j
    public T poll() {
        AtomicReferenceArray<Object> atomicReferenceArray = this.f16622j;
        long d2 = d();
        int i2 = this.f16621h;
        int c2 = c(d2, i2);
        T t = (T) g(atomicReferenceArray, c2);
        boolean z = t == f16615b;
        if (t == null || z) {
            if (z) {
                return k(h(atomicReferenceArray, i2 + 1), d2, i2);
            }
            return null;
        }
        r(atomicReferenceArray, c2, null);
        q(d2 + 1);
        return t;
    }
}