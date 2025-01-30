package h.c.n0.e.b;

import h.c.a0;
import java.util.concurrent.TimeUnit;

/* compiled from: FlowableDelay.java */
/* loaded from: classes3.dex */
public final class i0<T> extends h.c.n0.e.b.a<T, T> {

    /* renamed from: b  reason: collision with root package name */
    final long f14486b;

    /* renamed from: c  reason: collision with root package name */
    final TimeUnit f14487c;

    /* renamed from: d  reason: collision with root package name */
    final h.c.a0 f14488d;

    /* renamed from: e  reason: collision with root package name */
    final boolean f14489e;

    /* compiled from: FlowableDelay.java */
    /* loaded from: classes3.dex */
    static final class a<T> implements h.c.m<T>, k.a.d {
        final k.a.c<? super T> a;

        /* renamed from: b  reason: collision with root package name */
        final long f14490b;

        /* renamed from: c  reason: collision with root package name */
        final TimeUnit f14491c;

        /* renamed from: d  reason: collision with root package name */
        final a0.c f14492d;

        /* renamed from: e  reason: collision with root package name */
        final boolean f14493e;

        /* renamed from: f  reason: collision with root package name */
        k.a.d f14494f;

        /* compiled from: FlowableDelay.java */
        /* renamed from: h.c.n0.e.b.i0$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        final class RunnableC0353a implements Runnable {
            RunnableC0353a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    a.this.a.onComplete();
                } finally {
                    a.this.f14492d.dispose();
                }
            }
        }

        /* compiled from: FlowableDelay.java */
        /* loaded from: classes3.dex */
        final class b implements Runnable {
            private final Throwable a;

            b(Throwable th) {
                this.a = th;
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    a.this.a.onError(this.a);
                } finally {
                    a.this.f14492d.dispose();
                }
            }
        }

        /* compiled from: FlowableDelay.java */
        /* loaded from: classes3.dex */
        final class c implements Runnable {
            private final T a;

            c(T t) {
                this.a = t;
            }

            @Override // java.lang.Runnable
            public void run() {
                a.this.a.onNext((T) this.a);
            }
        }

        a(k.a.c<? super T> cVar, long j2, TimeUnit timeUnit, a0.c cVar2, boolean z) {
            this.a = cVar;
            this.f14490b = j2;
            this.f14491c = timeUnit;
            this.f14492d = cVar2;
            this.f14493e = z;
        }

        @Override // k.a.d
        public void cancel() {
            this.f14494f.cancel();
            this.f14492d.dispose();
        }

        @Override // k.a.c
        public void onComplete() {
            this.f14492d.c(new RunnableC0353a(), this.f14490b, this.f14491c);
        }

        @Override // k.a.c
        public void onError(Throwable th) {
            this.f14492d.c(new b(th), this.f14493e ? this.f14490b : 0L, this.f14491c);
        }

        @Override // k.a.c
        public void onNext(T t) {
            this.f14492d.c(new c(t), this.f14490b, this.f14491c);
        }

        @Override // h.c.m, k.a.c
        public void onSubscribe(k.a.d dVar) {
            if (h.c.n0.i.g.C(this.f14494f, dVar)) {
                this.f14494f = dVar;
                this.a.onSubscribe(this);
            }
        }

        @Override // k.a.d
        public void request(long j2) {
            this.f14494f.request(j2);
        }
    }

    public i0(h.c.h<T> hVar, long j2, TimeUnit timeUnit, h.c.a0 a0Var, boolean z) {
        super(hVar);
        this.f14486b = j2;
        this.f14487c = timeUnit;
        this.f14488d = a0Var;
        this.f14489e = z;
    }

    @Override // h.c.h
    protected void subscribeActual(k.a.c<? super T> cVar) {
        this.a.subscribe((h.c.m) new a(this.f14489e ? cVar : new h.c.w0.d(cVar), this.f14486b, this.f14487c, this.f14488d.a(), this.f14489e));
    }
}