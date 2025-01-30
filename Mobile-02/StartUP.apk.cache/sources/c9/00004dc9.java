package h.c.n0.e.b;

import io.reactivex.exceptions.MissingBackpressureException;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: FlowableSwitchMap.java */
/* loaded from: classes3.dex */
public final class y3<T, R> extends h.c.n0.e.b.a<T, R> {

    /* renamed from: b  reason: collision with root package name */
    final h.c.m0.n<? super T, ? extends k.a.b<? extends R>> f15266b;

    /* renamed from: c  reason: collision with root package name */
    final int f15267c;

    /* renamed from: d  reason: collision with root package name */
    final boolean f15268d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: FlowableSwitchMap.java */
    /* loaded from: classes3.dex */
    public static final class a<T, R> extends AtomicReference<k.a.d> implements h.c.m<R> {
        final b<T, R> a;

        /* renamed from: b  reason: collision with root package name */
        final long f15269b;

        /* renamed from: c  reason: collision with root package name */
        final int f15270c;

        /* renamed from: d  reason: collision with root package name */
        volatile h.c.n0.c.j<R> f15271d;

        /* renamed from: e  reason: collision with root package name */
        volatile boolean f15272e;

        /* renamed from: f  reason: collision with root package name */
        int f15273f;

        a(b<T, R> bVar, long j2, int i2) {
            this.a = bVar;
            this.f15269b = j2;
            this.f15270c = i2;
        }

        public void a() {
            h.c.n0.i.g.h(this);
        }

        @Override // k.a.c
        public void onComplete() {
            b<T, R> bVar = this.a;
            if (this.f15269b == bVar.m) {
                this.f15272e = true;
                bVar.b();
            }
        }

        @Override // k.a.c
        public void onError(Throwable th) {
            b<T, R> bVar = this.a;
            if (this.f15269b == bVar.m && bVar.f15279g.a(th)) {
                if (!bVar.f15277e) {
                    bVar.f15281j.cancel();
                }
                this.f15272e = true;
                bVar.b();
                return;
            }
            h.c.r0.a.u(th);
        }

        @Override // k.a.c
        public void onNext(R r) {
            b<T, R> bVar = this.a;
            if (this.f15269b == bVar.m) {
                if (this.f15273f == 0 && !this.f15271d.offer(r)) {
                    onError(new MissingBackpressureException("Queue full?!"));
                } else {
                    bVar.b();
                }
            }
        }

        @Override // h.c.m, k.a.c
        public void onSubscribe(k.a.d dVar) {
            if (h.c.n0.i.g.z(this, dVar)) {
                if (dVar instanceof h.c.n0.c.g) {
                    h.c.n0.c.g gVar = (h.c.n0.c.g) dVar;
                    int n = gVar.n(7);
                    if (n == 1) {
                        this.f15273f = n;
                        this.f15271d = gVar;
                        this.f15272e = true;
                        this.a.b();
                        return;
                    } else if (n == 2) {
                        this.f15273f = n;
                        this.f15271d = gVar;
                        dVar.request(this.f15270c);
                        return;
                    }
                }
                this.f15271d = new h.c.n0.f.b(this.f15270c);
                dVar.request(this.f15270c);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: FlowableSwitchMap.java */
    /* loaded from: classes3.dex */
    public static final class b<T, R> extends AtomicInteger implements h.c.m<T>, k.a.d {
        static final a<Object, Object> a;

        /* renamed from: b  reason: collision with root package name */
        final k.a.c<? super R> f15274b;

        /* renamed from: c  reason: collision with root package name */
        final h.c.m0.n<? super T, ? extends k.a.b<? extends R>> f15275c;

        /* renamed from: d  reason: collision with root package name */
        final int f15276d;

        /* renamed from: e  reason: collision with root package name */
        final boolean f15277e;

        /* renamed from: f  reason: collision with root package name */
        volatile boolean f15278f;

        /* renamed from: h  reason: collision with root package name */
        volatile boolean f15280h;

        /* renamed from: j  reason: collision with root package name */
        k.a.d f15281j;
        volatile long m;

        /* renamed from: k  reason: collision with root package name */
        final AtomicReference<a<T, R>> f15282k = new AtomicReference<>();

        /* renamed from: l  reason: collision with root package name */
        final AtomicLong f15283l = new AtomicLong();

        /* renamed from: g  reason: collision with root package name */
        final h.c.n0.j.c f15279g = new h.c.n0.j.c();

        static {
            a<Object, Object> aVar = new a<>(null, -1L, 1);
            a = aVar;
            aVar.a();
        }

        b(k.a.c<? super R> cVar, h.c.m0.n<? super T, ? extends k.a.b<? extends R>> nVar, int i2, boolean z) {
            this.f15274b = cVar;
            this.f15275c = nVar;
            this.f15276d = i2;
            this.f15277e = z;
        }

        /* JADX WARN: Multi-variable type inference failed */
        void a() {
            a<Object, Object> aVar;
            a<T, R> aVar2 = this.f15282k.get();
            a<Object, Object> aVar3 = a;
            if (aVar2 == aVar3 || (aVar = (a) this.f15282k.getAndSet(aVar3)) == aVar3 || aVar == null) {
                return;
            }
            aVar.a();
        }

        /* JADX WARN: Code restructure failed: missing block: B:113:0x000c, code lost:
            continue;
         */
        /* JADX WARN: Code restructure failed: missing block: B:64:0x00e5, code lost:
            r14 = true;
         */
        /* JADX WARN: Code restructure failed: missing block: B:80:0x011d, code lost:
            if (r12 == 0) goto L76;
         */
        /* JADX WARN: Code restructure failed: missing block: B:82:0x0121, code lost:
            if (r17.f15280h != false) goto L76;
         */
        /* JADX WARN: Code restructure failed: missing block: B:84:0x012a, code lost:
            if (r8 == Long.MAX_VALUE) goto L75;
         */
        /* JADX WARN: Code restructure failed: missing block: B:85:0x012c, code lost:
            r17.f15283l.addAndGet(-r12);
         */
        /* JADX WARN: Code restructure failed: missing block: B:86:0x0132, code lost:
            r6.get().request(r12);
         */
        /* JADX WARN: Code restructure failed: missing block: B:87:0x013b, code lost:
            if (r14 == false) goto L77;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        void b() {
            /*
                Method dump skipped, instructions count: 327
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: h.c.n0.e.b.y3.b.b():void");
        }

        @Override // k.a.d
        public void cancel() {
            if (this.f15280h) {
                return;
            }
            this.f15280h = true;
            this.f15281j.cancel();
            a();
        }

        @Override // k.a.c
        public void onComplete() {
            if (this.f15278f) {
                return;
            }
            this.f15278f = true;
            b();
        }

        @Override // k.a.c
        public void onError(Throwable th) {
            if (!this.f15278f && this.f15279g.a(th)) {
                if (!this.f15277e) {
                    a();
                }
                this.f15278f = true;
                b();
                return;
            }
            h.c.r0.a.u(th);
        }

        @Override // k.a.c
        public void onNext(T t) {
            a<T, R> aVar;
            if (this.f15278f) {
                return;
            }
            long j2 = this.m + 1;
            this.m = j2;
            a<T, R> aVar2 = this.f15282k.get();
            if (aVar2 != null) {
                aVar2.a();
            }
            try {
                k.a.b bVar = (k.a.b) h.c.n0.b.b.e(this.f15275c.apply(t), "The publisher returned is null");
                a<T, R> aVar3 = new a<>(this, j2, this.f15276d);
                do {
                    aVar = this.f15282k.get();
                    if (aVar == a) {
                        return;
                    }
                } while (!this.f15282k.compareAndSet(aVar, aVar3));
                bVar.subscribe(aVar3);
            } catch (Throwable th) {
                io.reactivex.exceptions.a.b(th);
                this.f15281j.cancel();
                onError(th);
            }
        }

        @Override // h.c.m, k.a.c
        public void onSubscribe(k.a.d dVar) {
            if (h.c.n0.i.g.C(this.f15281j, dVar)) {
                this.f15281j = dVar;
                this.f15274b.onSubscribe(this);
            }
        }

        @Override // k.a.d
        public void request(long j2) {
            if (h.c.n0.i.g.B(j2)) {
                h.c.n0.j.d.a(this.f15283l, j2);
                if (this.m == 0) {
                    this.f15281j.request(Long.MAX_VALUE);
                } else {
                    b();
                }
            }
        }
    }

    public y3(h.c.h<T> hVar, h.c.m0.n<? super T, ? extends k.a.b<? extends R>> nVar, int i2, boolean z) {
        super(hVar);
        this.f15266b = nVar;
        this.f15267c = i2;
        this.f15268d = z;
    }

    @Override // h.c.h
    protected void subscribeActual(k.a.c<? super R> cVar) {
        if (i3.b(this.a, cVar, this.f15266b)) {
            return;
        }
        this.a.subscribe((h.c.m) new b(cVar, this.f15266b, this.f15267c, this.f15268d));
    }
}