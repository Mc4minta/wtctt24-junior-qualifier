package h.c.n0.e.b;

import h.c.a0;
import io.reactivex.exceptions.MissingBackpressureException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: FlowableDebounceTimed.java */
/* loaded from: classes3.dex */
public final class g0<T> extends h.c.n0.e.b.a<T, T> {

    /* renamed from: b  reason: collision with root package name */
    final long f14416b;

    /* renamed from: c  reason: collision with root package name */
    final TimeUnit f14417c;

    /* renamed from: d  reason: collision with root package name */
    final h.c.a0 f14418d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: FlowableDebounceTimed.java */
    /* loaded from: classes3.dex */
    public static final class a<T> extends AtomicReference<h.c.k0.b> implements Runnable, h.c.k0.b {
        final T a;

        /* renamed from: b  reason: collision with root package name */
        final long f14419b;

        /* renamed from: c  reason: collision with root package name */
        final b<T> f14420c;

        /* renamed from: d  reason: collision with root package name */
        final AtomicBoolean f14421d = new AtomicBoolean();

        a(T t, long j2, b<T> bVar) {
            this.a = t;
            this.f14419b = j2;
            this.f14420c = bVar;
        }

        void a() {
            if (this.f14421d.compareAndSet(false, true)) {
                this.f14420c.a(this.f14419b, this.a, this);
            }
        }

        public void b(h.c.k0.b bVar) {
            h.c.n0.a.c.q(this, bVar);
        }

        @Override // h.c.k0.b
        public void dispose() {
            h.c.n0.a.c.h(this);
        }

        @Override // h.c.k0.b
        public boolean isDisposed() {
            return get() == h.c.n0.a.c.DISPOSED;
        }

        @Override // java.lang.Runnable
        public void run() {
            a();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: FlowableDebounceTimed.java */
    /* loaded from: classes3.dex */
    public static final class b<T> extends AtomicLong implements h.c.m<T>, k.a.d {
        final k.a.c<? super T> a;

        /* renamed from: b  reason: collision with root package name */
        final long f14422b;

        /* renamed from: c  reason: collision with root package name */
        final TimeUnit f14423c;

        /* renamed from: d  reason: collision with root package name */
        final a0.c f14424d;

        /* renamed from: e  reason: collision with root package name */
        k.a.d f14425e;

        /* renamed from: f  reason: collision with root package name */
        h.c.k0.b f14426f;

        /* renamed from: g  reason: collision with root package name */
        volatile long f14427g;

        /* renamed from: h  reason: collision with root package name */
        boolean f14428h;

        b(k.a.c<? super T> cVar, long j2, TimeUnit timeUnit, a0.c cVar2) {
            this.a = cVar;
            this.f14422b = j2;
            this.f14423c = timeUnit;
            this.f14424d = cVar2;
        }

        void a(long j2, T t, a<T> aVar) {
            if (j2 == this.f14427g) {
                if (get() != 0) {
                    this.a.onNext(t);
                    h.c.n0.j.d.e(this, 1L);
                    aVar.dispose();
                    return;
                }
                cancel();
                this.a.onError(new MissingBackpressureException("Could not deliver value due to lack of requests"));
            }
        }

        @Override // k.a.d
        public void cancel() {
            this.f14425e.cancel();
            this.f14424d.dispose();
        }

        @Override // k.a.c
        public void onComplete() {
            if (this.f14428h) {
                return;
            }
            this.f14428h = true;
            h.c.k0.b bVar = this.f14426f;
            if (bVar != null) {
                bVar.dispose();
            }
            a aVar = (a) bVar;
            if (aVar != null) {
                aVar.a();
            }
            this.a.onComplete();
            this.f14424d.dispose();
        }

        @Override // k.a.c
        public void onError(Throwable th) {
            if (this.f14428h) {
                h.c.r0.a.u(th);
                return;
            }
            this.f14428h = true;
            h.c.k0.b bVar = this.f14426f;
            if (bVar != null) {
                bVar.dispose();
            }
            this.a.onError(th);
            this.f14424d.dispose();
        }

        @Override // k.a.c
        public void onNext(T t) {
            if (this.f14428h) {
                return;
            }
            long j2 = this.f14427g + 1;
            this.f14427g = j2;
            h.c.k0.b bVar = this.f14426f;
            if (bVar != null) {
                bVar.dispose();
            }
            a aVar = new a(t, j2, this);
            this.f14426f = aVar;
            aVar.b(this.f14424d.c(aVar, this.f14422b, this.f14423c));
        }

        @Override // h.c.m, k.a.c
        public void onSubscribe(k.a.d dVar) {
            if (h.c.n0.i.g.C(this.f14425e, dVar)) {
                this.f14425e = dVar;
                this.a.onSubscribe(this);
                dVar.request(Long.MAX_VALUE);
            }
        }

        @Override // k.a.d
        public void request(long j2) {
            if (h.c.n0.i.g.B(j2)) {
                h.c.n0.j.d.a(this, j2);
            }
        }
    }

    public g0(h.c.h<T> hVar, long j2, TimeUnit timeUnit, h.c.a0 a0Var) {
        super(hVar);
        this.f14416b = j2;
        this.f14417c = timeUnit;
        this.f14418d = a0Var;
    }

    @Override // h.c.h
    protected void subscribeActual(k.a.c<? super T> cVar) {
        this.a.subscribe((h.c.m) new b(new h.c.w0.d(cVar), this.f14416b, this.f14417c, this.f14418d.a()));
    }
}