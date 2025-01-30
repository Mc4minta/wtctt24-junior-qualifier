package h.c.n0.e.b;

import io.reactivex.exceptions.MissingBackpressureException;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: FlowableSequenceEqual.java */
/* loaded from: classes3.dex */
public final class l3<T> extends h.c.h<Boolean> {
    final k.a.b<? extends T> a;

    /* renamed from: b  reason: collision with root package name */
    final k.a.b<? extends T> f14640b;

    /* renamed from: c  reason: collision with root package name */
    final h.c.m0.d<? super T, ? super T> f14641c;

    /* renamed from: d  reason: collision with root package name */
    final int f14642d;

    /* compiled from: FlowableSequenceEqual.java */
    /* loaded from: classes3.dex */
    static final class a<T> extends h.c.n0.i.c<Boolean> implements b {

        /* renamed from: c  reason: collision with root package name */
        final h.c.m0.d<? super T, ? super T> f14643c;

        /* renamed from: d  reason: collision with root package name */
        final c<T> f14644d;

        /* renamed from: e  reason: collision with root package name */
        final c<T> f14645e;

        /* renamed from: f  reason: collision with root package name */
        final h.c.n0.j.c f14646f;

        /* renamed from: g  reason: collision with root package name */
        final AtomicInteger f14647g;

        /* renamed from: h  reason: collision with root package name */
        T f14648h;

        /* renamed from: j  reason: collision with root package name */
        T f14649j;

        a(k.a.c<? super Boolean> cVar, int i2, h.c.m0.d<? super T, ? super T> dVar) {
            super(cVar);
            this.f14643c = dVar;
            this.f14647g = new AtomicInteger();
            this.f14644d = new c<>(this, i2);
            this.f14645e = new c<>(this, i2);
            this.f14646f = new h.c.n0.j.c();
        }

        @Override // h.c.n0.e.b.l3.b
        public void a(Throwable th) {
            if (this.f14646f.a(th)) {
                b();
            } else {
                h.c.r0.a.u(th);
            }
        }

        @Override // h.c.n0.e.b.l3.b
        public void b() {
            if (this.f14647g.getAndIncrement() != 0) {
                return;
            }
            int i2 = 1;
            do {
                h.c.n0.c.j<T> jVar = this.f14644d.f14653e;
                h.c.n0.c.j<T> jVar2 = this.f14645e.f14653e;
                if (jVar != null && jVar2 != null) {
                    while (!d()) {
                        if (this.f14646f.get() != null) {
                            e();
                            this.a.onError(this.f14646f.b());
                            return;
                        }
                        boolean z = this.f14644d.f14654f;
                        T t = this.f14648h;
                        if (t == null) {
                            try {
                                t = jVar.poll();
                                this.f14648h = t;
                            } catch (Throwable th) {
                                io.reactivex.exceptions.a.b(th);
                                e();
                                this.f14646f.a(th);
                                this.a.onError(this.f14646f.b());
                                return;
                            }
                        }
                        boolean z2 = t == null;
                        boolean z3 = this.f14645e.f14654f;
                        T t2 = this.f14649j;
                        if (t2 == null) {
                            try {
                                t2 = jVar2.poll();
                                this.f14649j = t2;
                            } catch (Throwable th2) {
                                io.reactivex.exceptions.a.b(th2);
                                e();
                                this.f14646f.a(th2);
                                this.a.onError(this.f14646f.b());
                                return;
                            }
                        }
                        boolean z4 = t2 == null;
                        if (z && z3 && z2 && z4) {
                            c(Boolean.TRUE);
                            return;
                        } else if (z && z3 && z2 != z4) {
                            e();
                            c(Boolean.FALSE);
                            return;
                        } else if (!z2 && !z4) {
                            try {
                                if (!this.f14643c.a(t, t2)) {
                                    e();
                                    c(Boolean.FALSE);
                                    return;
                                }
                                this.f14648h = null;
                                this.f14649j = null;
                                this.f14644d.c();
                                this.f14645e.c();
                            } catch (Throwable th3) {
                                io.reactivex.exceptions.a.b(th3);
                                e();
                                this.f14646f.a(th3);
                                this.a.onError(this.f14646f.b());
                                return;
                            }
                        }
                    }
                    this.f14644d.b();
                    this.f14645e.b();
                    return;
                } else if (d()) {
                    this.f14644d.b();
                    this.f14645e.b();
                    return;
                } else if (this.f14646f.get() != null) {
                    e();
                    this.a.onError(this.f14646f.b());
                    return;
                }
                i2 = this.f14647g.addAndGet(-i2);
            } while (i2 != 0);
        }

        @Override // h.c.n0.i.c, k.a.d
        public void cancel() {
            super.cancel();
            this.f14644d.a();
            this.f14645e.a();
            if (this.f14647g.getAndIncrement() == 0) {
                this.f14644d.b();
                this.f14645e.b();
            }
        }

        void e() {
            this.f14644d.a();
            this.f14644d.b();
            this.f14645e.a();
            this.f14645e.b();
        }

        void f(k.a.b<? extends T> bVar, k.a.b<? extends T> bVar2) {
            bVar.subscribe(this.f14644d);
            bVar2.subscribe(this.f14645e);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: FlowableSequenceEqual.java */
    /* loaded from: classes3.dex */
    public interface b {
        void a(Throwable th);

        void b();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: FlowableSequenceEqual.java */
    /* loaded from: classes3.dex */
    public static final class c<T> extends AtomicReference<k.a.d> implements h.c.m<T> {
        final b a;

        /* renamed from: b  reason: collision with root package name */
        final int f14650b;

        /* renamed from: c  reason: collision with root package name */
        final int f14651c;

        /* renamed from: d  reason: collision with root package name */
        long f14652d;

        /* renamed from: e  reason: collision with root package name */
        volatile h.c.n0.c.j<T> f14653e;

        /* renamed from: f  reason: collision with root package name */
        volatile boolean f14654f;

        /* renamed from: g  reason: collision with root package name */
        int f14655g;

        /* JADX INFO: Access modifiers changed from: package-private */
        public c(b bVar, int i2) {
            this.a = bVar;
            this.f14651c = i2 - (i2 >> 2);
            this.f14650b = i2;
        }

        public void a() {
            h.c.n0.i.g.h(this);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void b() {
            h.c.n0.c.j<T> jVar = this.f14653e;
            if (jVar != null) {
                jVar.clear();
            }
        }

        public void c() {
            if (this.f14655g != 1) {
                long j2 = this.f14652d + 1;
                if (j2 >= this.f14651c) {
                    this.f14652d = 0L;
                    get().request(j2);
                    return;
                }
                this.f14652d = j2;
            }
        }

        @Override // k.a.c
        public void onComplete() {
            this.f14654f = true;
            this.a.b();
        }

        @Override // k.a.c
        public void onError(Throwable th) {
            this.a.a(th);
        }

        @Override // k.a.c
        public void onNext(T t) {
            if (this.f14655g == 0 && !this.f14653e.offer(t)) {
                onError(new MissingBackpressureException());
            } else {
                this.a.b();
            }
        }

        @Override // h.c.m, k.a.c
        public void onSubscribe(k.a.d dVar) {
            if (h.c.n0.i.g.z(this, dVar)) {
                if (dVar instanceof h.c.n0.c.g) {
                    h.c.n0.c.g gVar = (h.c.n0.c.g) dVar;
                    int n = gVar.n(3);
                    if (n == 1) {
                        this.f14655g = n;
                        this.f14653e = gVar;
                        this.f14654f = true;
                        this.a.b();
                        return;
                    } else if (n == 2) {
                        this.f14655g = n;
                        this.f14653e = gVar;
                        dVar.request(this.f14650b);
                        return;
                    }
                }
                this.f14653e = new h.c.n0.f.b(this.f14650b);
                dVar.request(this.f14650b);
            }
        }
    }

    public l3(k.a.b<? extends T> bVar, k.a.b<? extends T> bVar2, h.c.m0.d<? super T, ? super T> dVar, int i2) {
        this.a = bVar;
        this.f14640b = bVar2;
        this.f14641c = dVar;
        this.f14642d = i2;
    }

    @Override // h.c.h
    public void subscribeActual(k.a.c<? super Boolean> cVar) {
        a aVar = new a(cVar, this.f14642d, this.f14641c);
        cVar.onSubscribe(aVar);
        aVar.f(this.a, this.f14640b);
    }
}