package h.c.n0.e.b;

import io.reactivex.exceptions.MissingBackpressureException;
import java.util.Iterator;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: FlowableFlattenIterable.java */
/* loaded from: classes3.dex */
public final class e1<T, R> extends h.c.n0.e.b.a<T, R> {

    /* renamed from: b  reason: collision with root package name */
    final h.c.m0.n<? super T, ? extends Iterable<? extends R>> f14346b;

    /* renamed from: c  reason: collision with root package name */
    final int f14347c;

    /* compiled from: FlowableFlattenIterable.java */
    /* loaded from: classes3.dex */
    static final class a<T, R> extends h.c.n0.i.a<R> implements h.c.m<T> {
        final k.a.c<? super R> a;

        /* renamed from: b  reason: collision with root package name */
        final h.c.m0.n<? super T, ? extends Iterable<? extends R>> f14348b;

        /* renamed from: c  reason: collision with root package name */
        final int f14349c;

        /* renamed from: d  reason: collision with root package name */
        final int f14350d;

        /* renamed from: f  reason: collision with root package name */
        k.a.d f14352f;

        /* renamed from: g  reason: collision with root package name */
        h.c.n0.c.j<T> f14353g;

        /* renamed from: h  reason: collision with root package name */
        volatile boolean f14354h;

        /* renamed from: j  reason: collision with root package name */
        volatile boolean f14355j;

        /* renamed from: l  reason: collision with root package name */
        Iterator<? extends R> f14357l;
        int m;
        int n;

        /* renamed from: k  reason: collision with root package name */
        final AtomicReference<Throwable> f14356k = new AtomicReference<>();

        /* renamed from: e  reason: collision with root package name */
        final AtomicLong f14351e = new AtomicLong();

        a(k.a.c<? super R> cVar, h.c.m0.n<? super T, ? extends Iterable<? extends R>> nVar, int i2) {
            this.a = cVar;
            this.f14348b = nVar;
            this.f14349c = i2;
            this.f14350d = i2 - (i2 >> 2);
        }

        /* JADX WARN: Code restructure failed: missing block: B:67:0x0121, code lost:
            if (r6 == null) goto L57;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        void b() {
            /*
                Method dump skipped, instructions count: 303
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: h.c.n0.e.b.e1.a.b():void");
        }

        boolean c(boolean z, boolean z2, k.a.c<?> cVar, h.c.n0.c.j<?> jVar) {
            if (this.f14355j) {
                this.f14357l = null;
                jVar.clear();
                return true;
            } else if (z) {
                if (this.f14356k.get() == null) {
                    if (z2) {
                        cVar.onComplete();
                        return true;
                    }
                    return false;
                }
                Throwable b2 = h.c.n0.j.j.b(this.f14356k);
                this.f14357l = null;
                jVar.clear();
                cVar.onError(b2);
                return true;
            } else {
                return false;
            }
        }

        @Override // k.a.d
        public void cancel() {
            if (this.f14355j) {
                return;
            }
            this.f14355j = true;
            this.f14352f.cancel();
            if (getAndIncrement() == 0) {
                this.f14353g.clear();
            }
        }

        @Override // h.c.n0.c.j
        public void clear() {
            this.f14357l = null;
            this.f14353g.clear();
        }

        void d(boolean z) {
            if (z) {
                int i2 = this.m + 1;
                if (i2 == this.f14350d) {
                    this.m = 0;
                    this.f14352f.request(i2);
                    return;
                }
                this.m = i2;
            }
        }

        @Override // h.c.n0.c.j
        public boolean isEmpty() {
            return this.f14357l == null && this.f14353g.isEmpty();
        }

        @Override // h.c.n0.c.f
        public int n(int i2) {
            return ((i2 & 1) == 0 || this.n != 1) ? 0 : 1;
        }

        @Override // k.a.c
        public void onComplete() {
            if (this.f14354h) {
                return;
            }
            this.f14354h = true;
            b();
        }

        @Override // k.a.c
        public void onError(Throwable th) {
            if (!this.f14354h && h.c.n0.j.j.a(this.f14356k, th)) {
                this.f14354h = true;
                b();
                return;
            }
            h.c.r0.a.u(th);
        }

        @Override // k.a.c
        public void onNext(T t) {
            if (this.f14354h) {
                return;
            }
            if (this.n == 0 && !this.f14353g.offer(t)) {
                onError(new MissingBackpressureException("Queue is full?!"));
            } else {
                b();
            }
        }

        @Override // h.c.m, k.a.c
        public void onSubscribe(k.a.d dVar) {
            if (h.c.n0.i.g.C(this.f14352f, dVar)) {
                this.f14352f = dVar;
                if (dVar instanceof h.c.n0.c.g) {
                    h.c.n0.c.g gVar = (h.c.n0.c.g) dVar;
                    int n = gVar.n(3);
                    if (n == 1) {
                        this.n = n;
                        this.f14353g = gVar;
                        this.f14354h = true;
                        this.a.onSubscribe(this);
                        return;
                    } else if (n == 2) {
                        this.n = n;
                        this.f14353g = gVar;
                        this.a.onSubscribe(this);
                        dVar.request(this.f14349c);
                        return;
                    }
                }
                this.f14353g = new h.c.n0.f.b(this.f14349c);
                this.a.onSubscribe(this);
                dVar.request(this.f14349c);
            }
        }

        @Override // h.c.n0.c.j
        public R poll() throws Exception {
            Iterator<? extends R> it = this.f14357l;
            while (true) {
                if (it == null) {
                    T poll = this.f14353g.poll();
                    if (poll != null) {
                        it = this.f14348b.apply(poll).iterator();
                        if (it.hasNext()) {
                            this.f14357l = it;
                            break;
                        }
                        it = null;
                    } else {
                        return null;
                    }
                } else {
                    break;
                }
            }
            R r = (R) h.c.n0.b.b.e(it.next(), "The iterator returned a null value");
            if (!it.hasNext()) {
                this.f14357l = null;
            }
            return r;
        }

        @Override // k.a.d
        public void request(long j2) {
            if (h.c.n0.i.g.B(j2)) {
                h.c.n0.j.d.a(this.f14351e, j2);
                b();
            }
        }
    }

    public e1(h.c.h<T> hVar, h.c.m0.n<? super T, ? extends Iterable<? extends R>> nVar, int i2) {
        super(hVar);
        this.f14346b = nVar;
        this.f14347c = i2;
    }

    @Override // h.c.h
    public void subscribeActual(k.a.c<? super R> cVar) {
        h.c.h<T> hVar = this.a;
        if (hVar instanceof Callable) {
            try {
                Object call = ((Callable) hVar).call();
                if (call == null) {
                    h.c.n0.i.d.h(cVar);
                    return;
                }
                try {
                    i1.b(cVar, this.f14346b.apply(call).iterator());
                    return;
                } catch (Throwable th) {
                    io.reactivex.exceptions.a.b(th);
                    h.c.n0.i.d.q(th, cVar);
                    return;
                }
            } catch (Throwable th2) {
                io.reactivex.exceptions.a.b(th2);
                h.c.n0.i.d.q(th2, cVar);
                return;
            }
        }
        hVar.subscribe((h.c.m) new a(cVar, this.f14346b, this.f14347c));
    }
}