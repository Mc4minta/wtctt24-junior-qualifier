package h.c.n0.e.b;

import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: FlowableGroupBy.java */
/* loaded from: classes3.dex */
public final class m1<T, K, V> extends h.c.n0.e.b.a<T, h.c.l0.b<K, V>> {

    /* renamed from: b  reason: collision with root package name */
    final h.c.m0.n<? super T, ? extends K> f14689b;

    /* renamed from: c  reason: collision with root package name */
    final h.c.m0.n<? super T, ? extends V> f14690c;

    /* renamed from: d  reason: collision with root package name */
    final int f14691d;

    /* renamed from: e  reason: collision with root package name */
    final boolean f14692e;

    /* renamed from: f  reason: collision with root package name */
    final h.c.m0.n<? super h.c.m0.f<Object>, ? extends Map<K, Object>> f14693f;

    /* compiled from: FlowableGroupBy.java */
    /* loaded from: classes3.dex */
    static final class a<K, V> implements h.c.m0.f<c<K, V>> {
        final Queue<c<K, V>> a;

        a(Queue<c<K, V>> queue) {
            this.a = queue;
        }

        @Override // h.c.m0.f
        /* renamed from: a */
        public void accept(c<K, V> cVar) {
            this.a.offer(cVar);
        }
    }

    /* compiled from: FlowableGroupBy.java */
    /* loaded from: classes3.dex */
    public static final class b<T, K, V> extends h.c.n0.i.a<h.c.l0.b<K, V>> implements h.c.m<T> {
        static final Object a = new Object();

        /* renamed from: b  reason: collision with root package name */
        final k.a.c<? super h.c.l0.b<K, V>> f14694b;

        /* renamed from: c  reason: collision with root package name */
        final h.c.m0.n<? super T, ? extends K> f14695c;

        /* renamed from: d  reason: collision with root package name */
        final h.c.m0.n<? super T, ? extends V> f14696d;

        /* renamed from: e  reason: collision with root package name */
        final int f14697e;

        /* renamed from: f  reason: collision with root package name */
        final boolean f14698f;

        /* renamed from: g  reason: collision with root package name */
        final Map<Object, c<K, V>> f14699g;

        /* renamed from: h  reason: collision with root package name */
        final h.c.n0.f.c<h.c.l0.b<K, V>> f14700h;

        /* renamed from: j  reason: collision with root package name */
        final Queue<c<K, V>> f14701j;

        /* renamed from: k  reason: collision with root package name */
        k.a.d f14702k;

        /* renamed from: l  reason: collision with root package name */
        final AtomicBoolean f14703l = new AtomicBoolean();
        final AtomicLong m = new AtomicLong();
        final AtomicInteger n = new AtomicInteger(1);
        Throwable p;
        volatile boolean q;
        boolean t;
        boolean u;

        public b(k.a.c<? super h.c.l0.b<K, V>> cVar, h.c.m0.n<? super T, ? extends K> nVar, h.c.m0.n<? super T, ? extends V> nVar2, int i2, boolean z, Map<Object, c<K, V>> map, Queue<c<K, V>> queue) {
            this.f14694b = cVar;
            this.f14695c = nVar;
            this.f14696d = nVar2;
            this.f14697e = i2;
            this.f14698f = z;
            this.f14699g = map;
            this.f14701j = queue;
            this.f14700h = new h.c.n0.f.c<>(i2);
        }

        private void e() {
            if (this.f14701j != null) {
                int i2 = 0;
                while (true) {
                    c<K, V> poll = this.f14701j.poll();
                    if (poll == null) {
                        break;
                    }
                    poll.onComplete();
                    i2++;
                }
                if (i2 != 0) {
                    this.n.addAndGet(-i2);
                }
            }
        }

        void b() {
            if (getAndIncrement() != 0) {
                return;
            }
            if (this.u) {
                f();
            } else {
                g();
            }
        }

        public void c(K k2) {
            if (k2 == null) {
                k2 = (K) a;
            }
            this.f14699g.remove(k2);
            if (this.n.decrementAndGet() == 0) {
                this.f14702k.cancel();
                if (getAndIncrement() == 0) {
                    this.f14700h.clear();
                }
            }
        }

        @Override // k.a.d
        public void cancel() {
            if (this.f14703l.compareAndSet(false, true)) {
                e();
                if (this.n.decrementAndGet() == 0) {
                    this.f14702k.cancel();
                }
            }
        }

        @Override // h.c.n0.c.j
        public void clear() {
            this.f14700h.clear();
        }

        boolean d(boolean z, boolean z2, k.a.c<?> cVar, h.c.n0.f.c<?> cVar2) {
            if (this.f14703l.get()) {
                cVar2.clear();
                return true;
            } else if (this.f14698f) {
                if (z && z2) {
                    Throwable th = this.p;
                    if (th != null) {
                        cVar.onError(th);
                    } else {
                        cVar.onComplete();
                    }
                    return true;
                }
                return false;
            } else if (z) {
                Throwable th2 = this.p;
                if (th2 != null) {
                    cVar2.clear();
                    cVar.onError(th2);
                    return true;
                } else if (z2) {
                    cVar.onComplete();
                    return true;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        }

        void f() {
            Throwable th;
            h.c.n0.f.c<h.c.l0.b<K, V>> cVar = this.f14700h;
            k.a.c<? super h.c.l0.b<K, V>> cVar2 = this.f14694b;
            int i2 = 1;
            while (!this.f14703l.get()) {
                boolean z = this.q;
                if (z && !this.f14698f && (th = this.p) != null) {
                    cVar.clear();
                    cVar2.onError(th);
                    return;
                }
                cVar2.onNext(null);
                if (z) {
                    Throwable th2 = this.p;
                    if (th2 != null) {
                        cVar2.onError(th2);
                        return;
                    } else {
                        cVar2.onComplete();
                        return;
                    }
                }
                i2 = addAndGet(-i2);
                if (i2 == 0) {
                    return;
                }
            }
            cVar.clear();
        }

        void g() {
            int i2;
            h.c.n0.f.c<h.c.l0.b<K, V>> cVar = this.f14700h;
            k.a.c<? super h.c.l0.b<K, V>> cVar2 = this.f14694b;
            int i3 = 1;
            do {
                long j2 = this.m.get();
                long j3 = 0;
                while (true) {
                    i2 = (j3 > j2 ? 1 : (j3 == j2 ? 0 : -1));
                    if (i2 == 0) {
                        break;
                    }
                    boolean z = this.q;
                    h.c.l0.b<K, V> poll = cVar.poll();
                    boolean z2 = poll == null;
                    if (d(z, z2, cVar2, cVar)) {
                        return;
                    }
                    if (z2) {
                        break;
                    }
                    cVar2.onNext(poll);
                    j3++;
                }
                if (i2 == 0 && d(this.q, cVar.isEmpty(), cVar2, cVar)) {
                    return;
                }
                if (j3 != 0) {
                    if (j2 != Long.MAX_VALUE) {
                        this.m.addAndGet(-j3);
                    }
                    this.f14702k.request(j3);
                }
                i3 = addAndGet(-i3);
            } while (i3 != 0);
        }

        @Override // h.c.n0.c.j
        /* renamed from: i */
        public h.c.l0.b<K, V> poll() {
            return this.f14700h.poll();
        }

        @Override // h.c.n0.c.j
        public boolean isEmpty() {
            return this.f14700h.isEmpty();
        }

        @Override // h.c.n0.c.f
        public int n(int i2) {
            if ((i2 & 2) != 0) {
                this.u = true;
                return 2;
            }
            return 0;
        }

        @Override // k.a.c
        public void onComplete() {
            if (this.t) {
                return;
            }
            for (c<K, V> cVar : this.f14699g.values()) {
                cVar.onComplete();
            }
            this.f14699g.clear();
            Queue<c<K, V>> queue = this.f14701j;
            if (queue != null) {
                queue.clear();
            }
            this.t = true;
            this.q = true;
            b();
        }

        @Override // k.a.c
        public void onError(Throwable th) {
            if (this.t) {
                h.c.r0.a.u(th);
                return;
            }
            this.t = true;
            for (c<K, V> cVar : this.f14699g.values()) {
                cVar.onError(th);
            }
            this.f14699g.clear();
            Queue<c<K, V>> queue = this.f14701j;
            if (queue != null) {
                queue.clear();
            }
            this.p = th;
            this.q = true;
            b();
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // k.a.c
        public void onNext(T t) {
            if (this.t) {
                return;
            }
            h.c.n0.f.c<h.c.l0.b<K, V>> cVar = this.f14700h;
            try {
                K apply = this.f14695c.apply(t);
                boolean z = false;
                Object obj = apply != null ? apply : a;
                c<K, V> cVar2 = this.f14699g.get(obj);
                if (cVar2 == null) {
                    if (this.f14703l.get()) {
                        return;
                    }
                    cVar2 = c.b(apply, this.f14697e, this, this.f14698f);
                    this.f14699g.put(obj, cVar2);
                    this.n.getAndIncrement();
                    z = true;
                }
                try {
                    cVar2.onNext(h.c.n0.b.b.e(this.f14696d.apply(t), "The valueSelector returned null"));
                    e();
                    if (z) {
                        cVar.offer(cVar2);
                        b();
                    }
                } catch (Throwable th) {
                    io.reactivex.exceptions.a.b(th);
                    this.f14702k.cancel();
                    onError(th);
                }
            } catch (Throwable th2) {
                io.reactivex.exceptions.a.b(th2);
                this.f14702k.cancel();
                onError(th2);
            }
        }

        @Override // h.c.m, k.a.c
        public void onSubscribe(k.a.d dVar) {
            if (h.c.n0.i.g.C(this.f14702k, dVar)) {
                this.f14702k = dVar;
                this.f14694b.onSubscribe(this);
                dVar.request(this.f14697e);
            }
        }

        @Override // k.a.d
        public void request(long j2) {
            if (h.c.n0.i.g.B(j2)) {
                h.c.n0.j.d.a(this.m, j2);
                b();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: FlowableGroupBy.java */
    /* loaded from: classes3.dex */
    public static final class c<K, T> extends h.c.l0.b<K, T> {

        /* renamed from: b  reason: collision with root package name */
        final d<T, K> f14704b;

        protected c(K k2, d<T, K> dVar) {
            super(k2);
            this.f14704b = dVar;
        }

        public static <T, K> c<K, T> b(K k2, int i2, b<?, K, T> bVar, boolean z) {
            return new c<>(k2, new d(i2, bVar, k2, z));
        }

        public void onComplete() {
            this.f14704b.onComplete();
        }

        public void onError(Throwable th) {
            this.f14704b.onError(th);
        }

        public void onNext(T t) {
            this.f14704b.onNext(t);
        }

        @Override // h.c.h
        protected void subscribeActual(k.a.c<? super T> cVar) {
            this.f14704b.subscribe(cVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: FlowableGroupBy.java */
    /* loaded from: classes3.dex */
    public static final class d<T, K> extends h.c.n0.i.a<T> implements k.a.b<T> {
        final K a;

        /* renamed from: b  reason: collision with root package name */
        final h.c.n0.f.c<T> f14705b;

        /* renamed from: c  reason: collision with root package name */
        final b<?, K, T> f14706c;

        /* renamed from: d  reason: collision with root package name */
        final boolean f14707d;

        /* renamed from: f  reason: collision with root package name */
        volatile boolean f14709f;

        /* renamed from: g  reason: collision with root package name */
        Throwable f14710g;

        /* renamed from: l  reason: collision with root package name */
        boolean f14714l;
        int m;

        /* renamed from: e  reason: collision with root package name */
        final AtomicLong f14708e = new AtomicLong();

        /* renamed from: h  reason: collision with root package name */
        final AtomicBoolean f14711h = new AtomicBoolean();

        /* renamed from: j  reason: collision with root package name */
        final AtomicReference<k.a.c<? super T>> f14712j = new AtomicReference<>();

        /* renamed from: k  reason: collision with root package name */
        final AtomicBoolean f14713k = new AtomicBoolean();

        d(int i2, b<?, K, T> bVar, K k2, boolean z) {
            this.f14705b = new h.c.n0.f.c<>(i2);
            this.f14706c = bVar;
            this.a = k2;
            this.f14707d = z;
        }

        void b() {
            if (getAndIncrement() != 0) {
                return;
            }
            if (this.f14714l) {
                d();
            } else {
                e();
            }
        }

        boolean c(boolean z, boolean z2, k.a.c<? super T> cVar, boolean z3) {
            if (this.f14711h.get()) {
                this.f14705b.clear();
                return true;
            } else if (z) {
                if (z3) {
                    if (z2) {
                        Throwable th = this.f14710g;
                        if (th != null) {
                            cVar.onError(th);
                        } else {
                            cVar.onComplete();
                        }
                        return true;
                    }
                    return false;
                }
                Throwable th2 = this.f14710g;
                if (th2 != null) {
                    this.f14705b.clear();
                    cVar.onError(th2);
                    return true;
                } else if (z2) {
                    cVar.onComplete();
                    return true;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        }

        @Override // k.a.d
        public void cancel() {
            if (this.f14711h.compareAndSet(false, true)) {
                this.f14706c.c(this.a);
            }
        }

        @Override // h.c.n0.c.j
        public void clear() {
            this.f14705b.clear();
        }

        void d() {
            Throwable th;
            h.c.n0.f.c<T> cVar = this.f14705b;
            k.a.c<? super T> cVar2 = this.f14712j.get();
            int i2 = 1;
            while (true) {
                if (cVar2 != null) {
                    if (this.f14711h.get()) {
                        cVar.clear();
                        return;
                    }
                    boolean z = this.f14709f;
                    if (z && !this.f14707d && (th = this.f14710g) != null) {
                        cVar.clear();
                        cVar2.onError(th);
                        return;
                    }
                    cVar2.onNext(null);
                    if (z) {
                        Throwable th2 = this.f14710g;
                        if (th2 != null) {
                            cVar2.onError(th2);
                            return;
                        } else {
                            cVar2.onComplete();
                            return;
                        }
                    }
                }
                i2 = addAndGet(-i2);
                if (i2 == 0) {
                    return;
                }
                if (cVar2 == null) {
                    cVar2 = this.f14712j.get();
                }
            }
        }

        void e() {
            int i2;
            h.c.n0.f.c<T> cVar = this.f14705b;
            boolean z = this.f14707d;
            k.a.c<? super T> cVar2 = this.f14712j.get();
            int i3 = 1;
            while (true) {
                if (cVar2 != null) {
                    long j2 = this.f14708e.get();
                    long j3 = 0;
                    while (true) {
                        i2 = (j3 > j2 ? 1 : (j3 == j2 ? 0 : -1));
                        if (i2 == 0) {
                            break;
                        }
                        boolean z2 = this.f14709f;
                        Object obj = (T) cVar.poll();
                        boolean z3 = obj == null;
                        if (c(z2, z3, cVar2, z)) {
                            return;
                        }
                        if (z3) {
                            break;
                        }
                        cVar2.onNext(obj);
                        j3++;
                    }
                    if (i2 == 0 && c(this.f14709f, cVar.isEmpty(), cVar2, z)) {
                        return;
                    }
                    if (j3 != 0) {
                        if (j2 != Long.MAX_VALUE) {
                            this.f14708e.addAndGet(-j3);
                        }
                        this.f14706c.f14702k.request(j3);
                    }
                }
                i3 = addAndGet(-i3);
                if (i3 == 0) {
                    return;
                }
                if (cVar2 == null) {
                    cVar2 = this.f14712j.get();
                }
            }
        }

        @Override // h.c.n0.c.j
        public boolean isEmpty() {
            return this.f14705b.isEmpty();
        }

        @Override // h.c.n0.c.f
        public int n(int i2) {
            if ((i2 & 2) != 0) {
                this.f14714l = true;
                return 2;
            }
            return 0;
        }

        public void onComplete() {
            this.f14709f = true;
            b();
        }

        public void onError(Throwable th) {
            this.f14710g = th;
            this.f14709f = true;
            b();
        }

        public void onNext(T t) {
            this.f14705b.offer(t);
            b();
        }

        @Override // h.c.n0.c.j
        public T poll() {
            T poll = this.f14705b.poll();
            if (poll != null) {
                this.m++;
                return poll;
            }
            int i2 = this.m;
            if (i2 != 0) {
                this.m = 0;
                this.f14706c.f14702k.request(i2);
                return null;
            }
            return null;
        }

        @Override // k.a.d
        public void request(long j2) {
            if (h.c.n0.i.g.B(j2)) {
                h.c.n0.j.d.a(this.f14708e, j2);
                b();
            }
        }

        @Override // k.a.b
        public void subscribe(k.a.c<? super T> cVar) {
            if (this.f14713k.compareAndSet(false, true)) {
                cVar.onSubscribe(this);
                this.f14712j.lazySet(cVar);
                b();
                return;
            }
            h.c.n0.i.d.q(new IllegalStateException("Only one Subscriber allowed!"), cVar);
        }
    }

    public m1(h.c.h<T> hVar, h.c.m0.n<? super T, ? extends K> nVar, h.c.m0.n<? super T, ? extends V> nVar2, int i2, boolean z, h.c.m0.n<? super h.c.m0.f<Object>, ? extends Map<K, Object>> nVar3) {
        super(hVar);
        this.f14689b = nVar;
        this.f14690c = nVar2;
        this.f14691d = i2;
        this.f14692e = z;
        this.f14693f = nVar3;
    }

    @Override // h.c.h
    protected void subscribeActual(k.a.c<? super h.c.l0.b<K, V>> cVar) {
        ConcurrentLinkedQueue concurrentLinkedQueue;
        Map<K, Object> apply;
        try {
            if (this.f14693f == null) {
                concurrentLinkedQueue = null;
                apply = new ConcurrentHashMap<>();
            } else {
                concurrentLinkedQueue = new ConcurrentLinkedQueue();
                apply = this.f14693f.apply(new a(concurrentLinkedQueue));
            }
            this.a.subscribe((h.c.m) new b(cVar, this.f14689b, this.f14690c, this.f14691d, this.f14692e, apply, concurrentLinkedQueue));
        } catch (Exception e2) {
            io.reactivex.exceptions.a.b(e2);
            cVar.onSubscribe(h.c.n0.j.g.INSTANCE);
            cVar.onError(e2);
        }
    }
}