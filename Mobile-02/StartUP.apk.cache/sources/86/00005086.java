package h.c.v0;

import h.c.n0.j.m;
import h.c.z;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: ReplaySubject.java */
/* loaded from: classes3.dex */
public final class c<T> extends f<T> {
    static final C0404c[] a = new C0404c[0];

    /* renamed from: b  reason: collision with root package name */
    static final C0404c[] f16850b = new C0404c[0];

    /* renamed from: c  reason: collision with root package name */
    private static final Object[] f16851c = new Object[0];

    /* renamed from: d  reason: collision with root package name */
    final b<T> f16852d;

    /* renamed from: e  reason: collision with root package name */
    final AtomicReference<C0404c<T>[]> f16853e = new AtomicReference<>(a);

    /* renamed from: f  reason: collision with root package name */
    boolean f16854f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ReplaySubject.java */
    /* loaded from: classes3.dex */
    public static final class a<T> extends AtomicReference<a<T>> {
        final T a;

        a(T t) {
            this.a = t;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ReplaySubject.java */
    /* loaded from: classes3.dex */
    public interface b<T> {
        void a(Object obj);

        void add(T t);

        void b(C0404c<T> c0404c);

        boolean compareAndSet(Object obj, Object obj2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ReplaySubject.java */
    /* renamed from: h.c.v0.c$c  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static final class C0404c<T> extends AtomicInteger implements h.c.k0.b {
        final z<? super T> a;

        /* renamed from: b  reason: collision with root package name */
        final c<T> f16855b;

        /* renamed from: c  reason: collision with root package name */
        Object f16856c;

        /* renamed from: d  reason: collision with root package name */
        volatile boolean f16857d;

        C0404c(z<? super T> zVar, c<T> cVar) {
            this.a = zVar;
            this.f16855b = cVar;
        }

        @Override // h.c.k0.b
        public void dispose() {
            if (this.f16857d) {
                return;
            }
            this.f16857d = true;
            this.f16855b.e(this);
        }

        @Override // h.c.k0.b
        public boolean isDisposed() {
            return this.f16857d;
        }
    }

    /* compiled from: ReplaySubject.java */
    /* loaded from: classes3.dex */
    static final class d<T> extends AtomicReference<Object> implements b<T> {
        final int a;

        /* renamed from: b  reason: collision with root package name */
        int f16858b;

        /* renamed from: c  reason: collision with root package name */
        volatile a<Object> f16859c;

        /* renamed from: d  reason: collision with root package name */
        a<Object> f16860d;

        /* renamed from: e  reason: collision with root package name */
        volatile boolean f16861e;

        d(int i2) {
            this.a = h.c.n0.b.b.f(i2, "maxSize");
            a<Object> aVar = new a<>(null);
            this.f16860d = aVar;
            this.f16859c = aVar;
        }

        @Override // h.c.v0.c.b
        public void a(Object obj) {
            a<Object> aVar = new a<>(obj);
            a<Object> aVar2 = this.f16860d;
            this.f16860d = aVar;
            this.f16858b++;
            aVar2.lazySet(aVar);
            d();
            this.f16861e = true;
        }

        @Override // h.c.v0.c.b
        public void add(T t) {
            a<Object> aVar = new a<>(t);
            a<Object> aVar2 = this.f16860d;
            this.f16860d = aVar;
            this.f16858b++;
            aVar2.set(aVar);
            c();
        }

        @Override // h.c.v0.c.b
        public void b(C0404c<T> c0404c) {
            if (c0404c.getAndIncrement() != 0) {
                return;
            }
            z<? super T> zVar = c0404c.a;
            a<T> aVar = (a) c0404c.f16856c;
            if (aVar == null) {
                aVar = this.f16859c;
            }
            int i2 = 1;
            while (!c0404c.f16857d) {
                a<T> aVar2 = aVar.get();
                if (aVar2 == null) {
                    if (aVar.get() != null) {
                        continue;
                    } else {
                        c0404c.f16856c = aVar;
                        i2 = c0404c.addAndGet(-i2);
                        if (i2 == 0) {
                            return;
                        }
                    }
                } else {
                    Object obj = (T) aVar2.a;
                    if (this.f16861e && aVar2.get() == null) {
                        if (m.D(obj)) {
                            zVar.onComplete();
                        } else {
                            zVar.onError(m.B(obj));
                        }
                        c0404c.f16856c = null;
                        c0404c.f16857d = true;
                        return;
                    }
                    zVar.onNext(obj);
                    aVar = aVar2;
                }
            }
            c0404c.f16856c = null;
        }

        void c() {
            int i2 = this.f16858b;
            if (i2 > this.a) {
                this.f16858b = i2 - 1;
                this.f16859c = this.f16859c.get();
            }
        }

        public void d() {
            a<Object> aVar = this.f16859c;
            if (aVar.a != null) {
                a<Object> aVar2 = new a<>(null);
                aVar2.lazySet(aVar.get());
                this.f16859c = aVar2;
            }
        }
    }

    c(b<T> bVar) {
        this.f16852d = bVar;
    }

    public static <T> c<T> d(int i2) {
        return new c<>(new d(i2));
    }

    boolean c(C0404c<T> c0404c) {
        C0404c<T>[] c0404cArr;
        C0404c<T>[] c0404cArr2;
        do {
            c0404cArr = this.f16853e.get();
            if (c0404cArr == f16850b) {
                return false;
            }
            int length = c0404cArr.length;
            c0404cArr2 = new C0404c[length + 1];
            System.arraycopy(c0404cArr, 0, c0404cArr2, 0, length);
            c0404cArr2[length] = c0404c;
        } while (!this.f16853e.compareAndSet(c0404cArr, c0404cArr2));
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    void e(C0404c<T> c0404c) {
        C0404c<T>[] c0404cArr;
        C0404c[] c0404cArr2;
        do {
            c0404cArr = this.f16853e.get();
            if (c0404cArr == f16850b || c0404cArr == a) {
                return;
            }
            int length = c0404cArr.length;
            int i2 = -1;
            int i3 = 0;
            while (true) {
                if (i3 >= length) {
                    break;
                } else if (c0404cArr[i3] == c0404c) {
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
                c0404cArr2 = a;
            } else {
                C0404c[] c0404cArr3 = new C0404c[length - 1];
                System.arraycopy(c0404cArr, 0, c0404cArr3, 0, i2);
                System.arraycopy(c0404cArr, i2 + 1, c0404cArr3, i2, (length - i2) - 1);
                c0404cArr2 = c0404cArr3;
            }
        } while (!this.f16853e.compareAndSet(c0404cArr, c0404cArr2));
    }

    C0404c<T>[] f(Object obj) {
        if (this.f16852d.compareAndSet(null, obj)) {
            return this.f16853e.getAndSet(f16850b);
        }
        return f16850b;
    }

    @Override // h.c.z, k.a.c
    public void onComplete() {
        if (this.f16854f) {
            return;
        }
        this.f16854f = true;
        Object y = m.y();
        b<T> bVar = this.f16852d;
        bVar.a(y);
        for (C0404c<T> c0404c : f(y)) {
            bVar.b(c0404c);
        }
    }

    @Override // h.c.z, k.a.c
    public void onError(Throwable th) {
        h.c.n0.b.b.e(th, "onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (this.f16854f) {
            h.c.r0.a.u(th);
            return;
        }
        this.f16854f = true;
        Object A = m.A(th);
        b<T> bVar = this.f16852d;
        bVar.a(A);
        for (C0404c<T> c0404c : f(A)) {
            bVar.b(c0404c);
        }
    }

    @Override // h.c.z, k.a.c
    public void onNext(T t) {
        h.c.n0.b.b.e(t, "onNext called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (this.f16854f) {
            return;
        }
        b<T> bVar = this.f16852d;
        bVar.add(t);
        for (C0404c<T> c0404c : this.f16853e.get()) {
            bVar.b(c0404c);
        }
    }

    @Override // h.c.z
    public void onSubscribe(h.c.k0.b bVar) {
        if (this.f16854f) {
            bVar.dispose();
        }
    }

    @Override // h.c.s
    protected void subscribeActual(z<? super T> zVar) {
        C0404c<T> c0404c = new C0404c<>(zVar, this);
        zVar.onSubscribe(c0404c);
        if (c0404c.f16857d) {
            return;
        }
        if (c(c0404c) && c0404c.f16857d) {
            e(c0404c);
        } else {
            this.f16852d.b(c0404c);
        }
    }
}