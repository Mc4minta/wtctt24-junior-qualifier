package h.c.v0;

import h.c.n0.j.a;
import h.c.n0.j.j;
import h.c.n0.j.m;
import h.c.z;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* compiled from: BehaviorSubject.java */
/* loaded from: classes3.dex */
public final class a<T> extends f<T> {
    private static final Object[] a = new Object[0];

    /* renamed from: b  reason: collision with root package name */
    static final C0403a[] f16830b = new C0403a[0];

    /* renamed from: c  reason: collision with root package name */
    static final C0403a[] f16831c = new C0403a[0];

    /* renamed from: d  reason: collision with root package name */
    final AtomicReference<Object> f16832d;

    /* renamed from: e  reason: collision with root package name */
    final AtomicReference<C0403a<T>[]> f16833e;

    /* renamed from: f  reason: collision with root package name */
    final ReadWriteLock f16834f;

    /* renamed from: g  reason: collision with root package name */
    final Lock f16835g;

    /* renamed from: h  reason: collision with root package name */
    final Lock f16836h;

    /* renamed from: j  reason: collision with root package name */
    final AtomicReference<Throwable> f16837j;

    /* renamed from: k  reason: collision with root package name */
    long f16838k;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: BehaviorSubject.java */
    /* renamed from: h.c.v0.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static final class C0403a<T> implements h.c.k0.b, a.InterfaceC0400a<Object> {
        final z<? super T> a;

        /* renamed from: b  reason: collision with root package name */
        final a<T> f16839b;

        /* renamed from: c  reason: collision with root package name */
        boolean f16840c;

        /* renamed from: d  reason: collision with root package name */
        boolean f16841d;

        /* renamed from: e  reason: collision with root package name */
        h.c.n0.j.a<Object> f16842e;

        /* renamed from: f  reason: collision with root package name */
        boolean f16843f;

        /* renamed from: g  reason: collision with root package name */
        volatile boolean f16844g;

        /* renamed from: h  reason: collision with root package name */
        long f16845h;

        C0403a(z<? super T> zVar, a<T> aVar) {
            this.a = zVar;
            this.f16839b = aVar;
        }

        void a() {
            if (this.f16844g) {
                return;
            }
            synchronized (this) {
                if (this.f16844g) {
                    return;
                }
                if (this.f16840c) {
                    return;
                }
                a<T> aVar = this.f16839b;
                Lock lock = aVar.f16835g;
                lock.lock();
                this.f16845h = aVar.f16838k;
                Object obj = aVar.f16832d.get();
                lock.unlock();
                this.f16841d = obj != null;
                this.f16840c = true;
                if (obj == null || test(obj)) {
                    return;
                }
                b();
            }
        }

        void b() {
            h.c.n0.j.a<Object> aVar;
            while (!this.f16844g) {
                synchronized (this) {
                    aVar = this.f16842e;
                    if (aVar == null) {
                        this.f16841d = false;
                        return;
                    }
                    this.f16842e = null;
                }
                aVar.d(this);
            }
        }

        void c(Object obj, long j2) {
            if (this.f16844g) {
                return;
            }
            if (!this.f16843f) {
                synchronized (this) {
                    if (this.f16844g) {
                        return;
                    }
                    if (this.f16845h == j2) {
                        return;
                    }
                    if (this.f16841d) {
                        h.c.n0.j.a<Object> aVar = this.f16842e;
                        if (aVar == null) {
                            aVar = new h.c.n0.j.a<>(4);
                            this.f16842e = aVar;
                        }
                        aVar.c(obj);
                        return;
                    }
                    this.f16840c = true;
                    this.f16843f = true;
                }
            }
            test(obj);
        }

        @Override // h.c.k0.b
        public void dispose() {
            if (this.f16844g) {
                return;
            }
            this.f16844g = true;
            this.f16839b.g(this);
        }

        @Override // h.c.k0.b
        public boolean isDisposed() {
            return this.f16844g;
        }

        @Override // h.c.n0.j.a.InterfaceC0400a, h.c.m0.p
        public boolean test(Object obj) {
            return this.f16844g || m.h(obj, this.a);
        }
    }

    a() {
        ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
        this.f16834f = reentrantReadWriteLock;
        this.f16835g = reentrantReadWriteLock.readLock();
        this.f16836h = reentrantReadWriteLock.writeLock();
        this.f16833e = new AtomicReference<>(f16830b);
        this.f16832d = new AtomicReference<>();
        this.f16837j = new AtomicReference<>();
    }

    public static <T> a<T> d() {
        return new a<>();
    }

    public static <T> a<T> e(T t) {
        return new a<>(t);
    }

    boolean c(C0403a<T> c0403a) {
        C0403a<T>[] c0403aArr;
        C0403a<T>[] c0403aArr2;
        do {
            c0403aArr = this.f16833e.get();
            if (c0403aArr == f16831c) {
                return false;
            }
            int length = c0403aArr.length;
            c0403aArr2 = new C0403a[length + 1];
            System.arraycopy(c0403aArr, 0, c0403aArr2, 0, length);
            c0403aArr2[length] = c0403a;
        } while (!this.f16833e.compareAndSet(c0403aArr, c0403aArr2));
        return true;
    }

    public T f() {
        Object obj = this.f16832d.get();
        if (m.D(obj) || m.E(obj)) {
            return null;
        }
        return (T) m.C(obj);
    }

    /* JADX WARN: Multi-variable type inference failed */
    void g(C0403a<T> c0403a) {
        C0403a<T>[] c0403aArr;
        C0403a[] c0403aArr2;
        do {
            c0403aArr = this.f16833e.get();
            int length = c0403aArr.length;
            if (length == 0) {
                return;
            }
            int i2 = -1;
            int i3 = 0;
            while (true) {
                if (i3 >= length) {
                    break;
                } else if (c0403aArr[i3] == c0403a) {
                    i2 = i3;
                    break;
                } else {
                    i3++;
                }
            }
            if (i2 < 0) {
                return;
            }
            if (length == 1) {
                c0403aArr2 = f16830b;
            } else {
                C0403a[] c0403aArr3 = new C0403a[length - 1];
                System.arraycopy(c0403aArr, 0, c0403aArr3, 0, i2);
                System.arraycopy(c0403aArr, i2 + 1, c0403aArr3, i2, (length - i2) - 1);
                c0403aArr2 = c0403aArr3;
            }
        } while (!this.f16833e.compareAndSet(c0403aArr, c0403aArr2));
    }

    void h(Object obj) {
        this.f16836h.lock();
        this.f16838k++;
        this.f16832d.lazySet(obj);
        this.f16836h.unlock();
    }

    C0403a<T>[] i(Object obj) {
        AtomicReference<C0403a<T>[]> atomicReference = this.f16833e;
        C0403a<T>[] c0403aArr = f16831c;
        C0403a<T>[] andSet = atomicReference.getAndSet(c0403aArr);
        if (andSet != c0403aArr) {
            h(obj);
        }
        return andSet;
    }

    @Override // h.c.z, k.a.c
    public void onComplete() {
        if (this.f16837j.compareAndSet(null, j.a)) {
            Object y = m.y();
            for (C0403a<T> c0403a : i(y)) {
                c0403a.c(y, this.f16838k);
            }
        }
    }

    @Override // h.c.z, k.a.c
    public void onError(Throwable th) {
        h.c.n0.b.b.e(th, "onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (!this.f16837j.compareAndSet(null, th)) {
            h.c.r0.a.u(th);
            return;
        }
        Object A = m.A(th);
        for (C0403a<T> c0403a : i(A)) {
            c0403a.c(A, this.f16838k);
        }
    }

    @Override // h.c.z, k.a.c
    public void onNext(T t) {
        h.c.n0.b.b.e(t, "onNext called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (this.f16837j.get() != null) {
            return;
        }
        Object F = m.F(t);
        h(F);
        for (C0403a<T> c0403a : this.f16833e.get()) {
            c0403a.c(F, this.f16838k);
        }
    }

    @Override // h.c.z
    public void onSubscribe(h.c.k0.b bVar) {
        if (this.f16837j.get() != null) {
            bVar.dispose();
        }
    }

    @Override // h.c.s
    protected void subscribeActual(z<? super T> zVar) {
        C0403a<T> c0403a = new C0403a<>(zVar, this);
        zVar.onSubscribe(c0403a);
        if (c(c0403a)) {
            if (c0403a.f16844g) {
                g(c0403a);
                return;
            } else {
                c0403a.a();
                return;
            }
        }
        Throwable th = this.f16837j.get();
        if (th == j.a) {
            zVar.onComplete();
        } else {
            zVar.onError(th);
        }
    }

    a(T t) {
        this();
        this.f16832d.lazySet(h.c.n0.b.b.e(t, "defaultValue is null"));
    }
}