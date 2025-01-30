package h.c.n0.e.e;

import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: ObservableWindow.java */
/* loaded from: classes3.dex */
public final class d4<T> extends h.c.n0.e.e.a<T, h.c.s<T>> {

    /* renamed from: b  reason: collision with root package name */
    final long f15597b;

    /* renamed from: c  reason: collision with root package name */
    final long f15598c;

    /* renamed from: d  reason: collision with root package name */
    final int f15599d;

    /* compiled from: ObservableWindow.java */
    /* loaded from: classes3.dex */
    static final class a<T> extends AtomicInteger implements h.c.z<T>, h.c.k0.b, Runnable {
        final h.c.z<? super h.c.s<T>> a;

        /* renamed from: b  reason: collision with root package name */
        final long f15600b;

        /* renamed from: c  reason: collision with root package name */
        final int f15601c;

        /* renamed from: d  reason: collision with root package name */
        long f15602d;

        /* renamed from: e  reason: collision with root package name */
        h.c.k0.b f15603e;

        /* renamed from: f  reason: collision with root package name */
        h.c.v0.g<T> f15604f;

        /* renamed from: g  reason: collision with root package name */
        volatile boolean f15605g;

        a(h.c.z<? super h.c.s<T>> zVar, long j2, int i2) {
            this.a = zVar;
            this.f15600b = j2;
            this.f15601c = i2;
        }

        @Override // h.c.k0.b
        public void dispose() {
            this.f15605g = true;
        }

        @Override // h.c.k0.b
        public boolean isDisposed() {
            return this.f15605g;
        }

        @Override // h.c.z, k.a.c
        public void onComplete() {
            h.c.v0.g<T> gVar = this.f15604f;
            if (gVar != null) {
                this.f15604f = null;
                gVar.onComplete();
            }
            this.a.onComplete();
        }

        @Override // h.c.z, k.a.c
        public void onError(Throwable th) {
            h.c.v0.g<T> gVar = this.f15604f;
            if (gVar != null) {
                this.f15604f = null;
                gVar.onError(th);
            }
            this.a.onError(th);
        }

        @Override // h.c.z, k.a.c
        public void onNext(T t) {
            h.c.v0.g<T> gVar = this.f15604f;
            if (gVar == null && !this.f15605g) {
                gVar = h.c.v0.g.e(this.f15601c, this);
                this.f15604f = gVar;
                this.a.onNext(gVar);
            }
            if (gVar != null) {
                gVar.onNext(t);
                long j2 = this.f15602d + 1;
                this.f15602d = j2;
                if (j2 >= this.f15600b) {
                    this.f15602d = 0L;
                    this.f15604f = null;
                    gVar.onComplete();
                    if (this.f15605g) {
                        this.f15603e.dispose();
                    }
                }
            }
        }

        @Override // h.c.z
        public void onSubscribe(h.c.k0.b bVar) {
            if (h.c.n0.a.c.B(this.f15603e, bVar)) {
                this.f15603e = bVar;
                this.a.onSubscribe(this);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f15605g) {
                this.f15603e.dispose();
            }
        }
    }

    /* compiled from: ObservableWindow.java */
    /* loaded from: classes3.dex */
    static final class b<T> extends AtomicBoolean implements h.c.z<T>, h.c.k0.b, Runnable {
        final h.c.z<? super h.c.s<T>> a;

        /* renamed from: b  reason: collision with root package name */
        final long f15606b;

        /* renamed from: c  reason: collision with root package name */
        final long f15607c;

        /* renamed from: d  reason: collision with root package name */
        final int f15608d;

        /* renamed from: f  reason: collision with root package name */
        long f15610f;

        /* renamed from: g  reason: collision with root package name */
        volatile boolean f15611g;

        /* renamed from: h  reason: collision with root package name */
        long f15612h;

        /* renamed from: j  reason: collision with root package name */
        h.c.k0.b f15613j;

        /* renamed from: k  reason: collision with root package name */
        final AtomicInteger f15614k = new AtomicInteger();

        /* renamed from: e  reason: collision with root package name */
        final ArrayDeque<h.c.v0.g<T>> f15609e = new ArrayDeque<>();

        b(h.c.z<? super h.c.s<T>> zVar, long j2, long j3, int i2) {
            this.a = zVar;
            this.f15606b = j2;
            this.f15607c = j3;
            this.f15608d = i2;
        }

        @Override // h.c.k0.b
        public void dispose() {
            this.f15611g = true;
        }

        @Override // h.c.k0.b
        public boolean isDisposed() {
            return this.f15611g;
        }

        @Override // h.c.z, k.a.c
        public void onComplete() {
            ArrayDeque<h.c.v0.g<T>> arrayDeque = this.f15609e;
            while (!arrayDeque.isEmpty()) {
                arrayDeque.poll().onComplete();
            }
            this.a.onComplete();
        }

        @Override // h.c.z, k.a.c
        public void onError(Throwable th) {
            ArrayDeque<h.c.v0.g<T>> arrayDeque = this.f15609e;
            while (!arrayDeque.isEmpty()) {
                arrayDeque.poll().onError(th);
            }
            this.a.onError(th);
        }

        @Override // h.c.z, k.a.c
        public void onNext(T t) {
            ArrayDeque<h.c.v0.g<T>> arrayDeque = this.f15609e;
            long j2 = this.f15610f;
            long j3 = this.f15607c;
            if (j2 % j3 == 0 && !this.f15611g) {
                this.f15614k.getAndIncrement();
                h.c.v0.g<T> e2 = h.c.v0.g.e(this.f15608d, this);
                arrayDeque.offer(e2);
                this.a.onNext(e2);
            }
            long j4 = this.f15612h + 1;
            Iterator<h.c.v0.g<T>> it = arrayDeque.iterator();
            while (it.hasNext()) {
                it.next().onNext(t);
            }
            if (j4 >= this.f15606b) {
                arrayDeque.poll().onComplete();
                if (arrayDeque.isEmpty() && this.f15611g) {
                    this.f15613j.dispose();
                    return;
                }
                this.f15612h = j4 - j3;
            } else {
                this.f15612h = j4;
            }
            this.f15610f = j2 + 1;
        }

        @Override // h.c.z
        public void onSubscribe(h.c.k0.b bVar) {
            if (h.c.n0.a.c.B(this.f15613j, bVar)) {
                this.f15613j = bVar;
                this.a.onSubscribe(this);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f15614k.decrementAndGet() == 0 && this.f15611g) {
                this.f15613j.dispose();
            }
        }
    }

    public d4(h.c.x<T> xVar, long j2, long j3, int i2) {
        super(xVar);
        this.f15597b = j2;
        this.f15598c = j3;
        this.f15599d = i2;
    }

    @Override // h.c.s
    public void subscribeActual(h.c.z<? super h.c.s<T>> zVar) {
        if (this.f15597b == this.f15598c) {
            this.a.subscribe(new a(zVar, this.f15597b, this.f15599d));
        } else {
            this.a.subscribe(new b(zVar, this.f15597b, this.f15598c, this.f15599d));
        }
    }
}