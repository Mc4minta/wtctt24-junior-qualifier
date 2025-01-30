package h.c.n0.f;

import h.c.n0.c.i;
import h.c.n0.j.p;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReferenceArray;

/* compiled from: SpscArrayQueue.java */
/* loaded from: classes3.dex */
public final class b<E> extends AtomicReferenceArray<E> implements i<E> {
    private static final Integer a = Integer.getInteger("jctools.spsc.max.lookahead.step", 4096);

    /* renamed from: b  reason: collision with root package name */
    final int f16610b;

    /* renamed from: c  reason: collision with root package name */
    final AtomicLong f16611c;

    /* renamed from: d  reason: collision with root package name */
    long f16612d;

    /* renamed from: e  reason: collision with root package name */
    final AtomicLong f16613e;

    /* renamed from: f  reason: collision with root package name */
    final int f16614f;

    public b(int i2) {
        super(p.a(i2));
        this.f16610b = length() - 1;
        this.f16611c = new AtomicLong();
        this.f16613e = new AtomicLong();
        this.f16614f = Math.min(i2 / 4, a.intValue());
    }

    int a(long j2) {
        return ((int) j2) & this.f16610b;
    }

    int b(long j2, int i2) {
        return ((int) j2) & i2;
    }

    E c(int i2) {
        return get(i2);
    }

    @Override // h.c.n0.c.j
    public void clear() {
        while (true) {
            if (poll() == null && isEmpty()) {
                return;
            }
        }
    }

    void d(long j2) {
        this.f16613e.lazySet(j2);
    }

    void e(int i2, E e2) {
        lazySet(i2, e2);
    }

    void f(long j2) {
        this.f16611c.lazySet(j2);
    }

    @Override // h.c.n0.c.j
    public boolean isEmpty() {
        return this.f16611c.get() == this.f16613e.get();
    }

    @Override // h.c.n0.c.j
    public boolean offer(E e2) {
        Objects.requireNonNull(e2, "Null is not a valid element");
        int i2 = this.f16610b;
        long j2 = this.f16611c.get();
        int b2 = b(j2, i2);
        if (j2 >= this.f16612d) {
            long j3 = this.f16614f + j2;
            if (c(b(j3, i2)) == null) {
                this.f16612d = j3;
            } else if (c(b2) != null) {
                return false;
            }
        }
        e(b2, e2);
        f(j2 + 1);
        return true;
    }

    @Override // h.c.n0.c.i, h.c.n0.c.j
    public E poll() {
        long j2 = this.f16613e.get();
        int a2 = a(j2);
        E c2 = c(a2);
        if (c2 == null) {
            return null;
        }
        d(j2 + 1);
        e(a2, null);
        return c2;
    }
}