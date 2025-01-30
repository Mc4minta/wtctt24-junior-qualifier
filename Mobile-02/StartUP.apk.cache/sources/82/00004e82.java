package h.c.n0.e.e;

import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: ObservableGroupBy.java */
/* loaded from: classes3.dex */
public final class i1<T, K, V> extends h.c.n0.e.e.a<T, h.c.o0.b<K, V>> {

    /* renamed from: b  reason: collision with root package name */
    final h.c.m0.n<? super T, ? extends K> f15787b;

    /* renamed from: c  reason: collision with root package name */
    final h.c.m0.n<? super T, ? extends V> f15788c;

    /* renamed from: d  reason: collision with root package name */
    final int f15789d;

    /* renamed from: e  reason: collision with root package name */
    final boolean f15790e;

    /* compiled from: ObservableGroupBy.java */
    /* loaded from: classes3.dex */
    public static final class a<T, K, V> extends AtomicInteger implements h.c.z<T>, h.c.k0.b {
        static final Object a = new Object();

        /* renamed from: b  reason: collision with root package name */
        final h.c.z<? super h.c.o0.b<K, V>> f15791b;

        /* renamed from: c  reason: collision with root package name */
        final h.c.m0.n<? super T, ? extends K> f15792c;

        /* renamed from: d  reason: collision with root package name */
        final h.c.m0.n<? super T, ? extends V> f15793d;

        /* renamed from: e  reason: collision with root package name */
        final int f15794e;

        /* renamed from: f  reason: collision with root package name */
        final boolean f15795f;

        /* renamed from: h  reason: collision with root package name */
        h.c.k0.b f15797h;

        /* renamed from: j  reason: collision with root package name */
        final AtomicBoolean f15798j = new AtomicBoolean();

        /* renamed from: g  reason: collision with root package name */
        final Map<Object, b<K, V>> f15796g = new ConcurrentHashMap();

        public a(h.c.z<? super h.c.o0.b<K, V>> zVar, h.c.m0.n<? super T, ? extends K> nVar, h.c.m0.n<? super T, ? extends V> nVar2, int i2, boolean z) {
            this.f15791b = zVar;
            this.f15792c = nVar;
            this.f15793d = nVar2;
            this.f15794e = i2;
            this.f15795f = z;
            lazySet(1);
        }

        public void a(K k2) {
            if (k2 == null) {
                k2 = (K) a;
            }
            this.f15796g.remove(k2);
            if (decrementAndGet() == 0) {
                this.f15797h.dispose();
            }
        }

        @Override // h.c.k0.b
        public void dispose() {
            if (this.f15798j.compareAndSet(false, true) && decrementAndGet() == 0) {
                this.f15797h.dispose();
            }
        }

        @Override // h.c.k0.b
        public boolean isDisposed() {
            return this.f15798j.get();
        }

        @Override // h.c.z, k.a.c
        public void onComplete() {
            ArrayList<b> arrayList = new ArrayList(this.f15796g.values());
            this.f15796g.clear();
            for (b bVar : arrayList) {
                bVar.onComplete();
            }
            this.f15791b.onComplete();
        }

        @Override // h.c.z, k.a.c
        public void onError(Throwable th) {
            ArrayList<b> arrayList = new ArrayList(this.f15796g.values());
            this.f15796g.clear();
            for (b bVar : arrayList) {
                bVar.onError(th);
            }
            this.f15791b.onError(th);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // h.c.z, k.a.c
        public void onNext(T t) {
            try {
                K apply = this.f15792c.apply(t);
                Object obj = apply != null ? apply : a;
                b<K, V> bVar = this.f15796g.get(obj);
                if (bVar == null) {
                    if (this.f15798j.get()) {
                        return;
                    }
                    bVar = b.b(apply, this.f15794e, this, this.f15795f);
                    this.f15796g.put(obj, bVar);
                    getAndIncrement();
                    this.f15791b.onNext(bVar);
                }
                try {
                    bVar.onNext(h.c.n0.b.b.e(this.f15793d.apply(t), "The value supplied is null"));
                } catch (Throwable th) {
                    io.reactivex.exceptions.a.b(th);
                    this.f15797h.dispose();
                    onError(th);
                }
            } catch (Throwable th2) {
                io.reactivex.exceptions.a.b(th2);
                this.f15797h.dispose();
                onError(th2);
            }
        }

        @Override // h.c.z
        public void onSubscribe(h.c.k0.b bVar) {
            if (h.c.n0.a.c.B(this.f15797h, bVar)) {
                this.f15797h = bVar;
                this.f15791b.onSubscribe(this);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ObservableGroupBy.java */
    /* loaded from: classes3.dex */
    public static final class b<K, T> extends h.c.o0.b<K, T> {

        /* renamed from: b  reason: collision with root package name */
        final c<T, K> f15799b;

        protected b(K k2, c<T, K> cVar) {
            super(k2);
            this.f15799b = cVar;
        }

        public static <T, K> b<K, T> b(K k2, int i2, a<?, K, T> aVar, boolean z) {
            return new b<>(k2, new c(i2, aVar, k2, z));
        }

        public void onComplete() {
            this.f15799b.c();
        }

        public void onError(Throwable th) {
            this.f15799b.d(th);
        }

        public void onNext(T t) {
            this.f15799b.e(t);
        }

        @Override // h.c.s
        protected void subscribeActual(h.c.z<? super T> zVar) {
            this.f15799b.subscribe(zVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ObservableGroupBy.java */
    /* loaded from: classes3.dex */
    public static final class c<T, K> extends AtomicInteger implements h.c.k0.b, h.c.x<T> {
        final K a;

        /* renamed from: b  reason: collision with root package name */
        final h.c.n0.f.c<T> f15800b;

        /* renamed from: c  reason: collision with root package name */
        final a<?, K, T> f15801c;

        /* renamed from: d  reason: collision with root package name */
        final boolean f15802d;

        /* renamed from: e  reason: collision with root package name */
        volatile boolean f15803e;

        /* renamed from: f  reason: collision with root package name */
        Throwable f15804f;

        /* renamed from: g  reason: collision with root package name */
        final AtomicBoolean f15805g = new AtomicBoolean();

        /* renamed from: h  reason: collision with root package name */
        final AtomicBoolean f15806h = new AtomicBoolean();

        /* renamed from: j  reason: collision with root package name */
        final AtomicReference<h.c.z<? super T>> f15807j = new AtomicReference<>();

        c(int i2, a<?, K, T> aVar, K k2, boolean z) {
            this.f15800b = new h.c.n0.f.c<>(i2);
            this.f15801c = aVar;
            this.a = k2;
            this.f15802d = z;
        }

        boolean a(boolean z, boolean z2, h.c.z<? super T> zVar, boolean z3) {
            if (this.f15805g.get()) {
                this.f15800b.clear();
                this.f15801c.a(this.a);
                this.f15807j.lazySet(null);
                return true;
            } else if (z) {
                if (z3) {
                    if (z2) {
                        Throwable th = this.f15804f;
                        this.f15807j.lazySet(null);
                        if (th != null) {
                            zVar.onError(th);
                        } else {
                            zVar.onComplete();
                        }
                        return true;
                    }
                    return false;
                }
                Throwable th2 = this.f15804f;
                if (th2 != null) {
                    this.f15800b.clear();
                    this.f15807j.lazySet(null);
                    zVar.onError(th2);
                    return true;
                } else if (z2) {
                    this.f15807j.lazySet(null);
                    zVar.onComplete();
                    return true;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        }

        void b() {
            if (getAndIncrement() != 0) {
                return;
            }
            h.c.n0.f.c<T> cVar = this.f15800b;
            boolean z = this.f15802d;
            h.c.z<? super T> zVar = this.f15807j.get();
            int i2 = 1;
            while (true) {
                if (zVar != null) {
                    while (true) {
                        boolean z2 = this.f15803e;
                        Object obj = (T) cVar.poll();
                        boolean z3 = obj == null;
                        if (a(z2, z3, zVar, z)) {
                            return;
                        }
                        if (z3) {
                            break;
                        }
                        zVar.onNext(obj);
                    }
                }
                i2 = addAndGet(-i2);
                if (i2 == 0) {
                    return;
                }
                if (zVar == null) {
                    zVar = this.f15807j.get();
                }
            }
        }

        public void c() {
            this.f15803e = true;
            b();
        }

        public void d(Throwable th) {
            this.f15804f = th;
            this.f15803e = true;
            b();
        }

        @Override // h.c.k0.b
        public void dispose() {
            if (this.f15805g.compareAndSet(false, true) && getAndIncrement() == 0) {
                this.f15807j.lazySet(null);
                this.f15801c.a(this.a);
            }
        }

        public void e(T t) {
            this.f15800b.offer(t);
            b();
        }

        @Override // h.c.k0.b
        public boolean isDisposed() {
            return this.f15805g.get();
        }

        @Override // h.c.x
        public void subscribe(h.c.z<? super T> zVar) {
            if (this.f15806h.compareAndSet(false, true)) {
                zVar.onSubscribe(this);
                this.f15807j.lazySet(zVar);
                if (this.f15805g.get()) {
                    this.f15807j.lazySet(null);
                    return;
                } else {
                    b();
                    return;
                }
            }
            h.c.n0.a.d.y(new IllegalStateException("Only one Observer allowed!"), zVar);
        }
    }

    public i1(h.c.x<T> xVar, h.c.m0.n<? super T, ? extends K> nVar, h.c.m0.n<? super T, ? extends V> nVar2, int i2, boolean z) {
        super(xVar);
        this.f15787b = nVar;
        this.f15788c = nVar2;
        this.f15789d = i2;
        this.f15790e = z;
    }

    @Override // h.c.s
    public void subscribeActual(h.c.z<? super h.c.o0.b<K, V>> zVar) {
        this.a.subscribe(new a(zVar, this.f15787b, this.f15788c, this.f15789d, this.f15790e));
    }
}