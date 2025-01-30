package h.c.w0;

import h.c.m;
import h.c.n0.c.g;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: TestSubscriber.java */
/* loaded from: classes3.dex */
public class e<T> extends h.c.p0.a<T, e<T>> implements m<T>, k.a.d, h.c.k0.b {

    /* renamed from: j  reason: collision with root package name */
    private final k.a.c<? super T> f16886j;

    /* renamed from: k  reason: collision with root package name */
    private volatile boolean f16887k;

    /* renamed from: l  reason: collision with root package name */
    private final AtomicReference<k.a.d> f16888l;
    private final AtomicLong m;
    private g<T> n;

    /* compiled from: TestSubscriber.java */
    /* loaded from: classes3.dex */
    enum a implements m<Object> {
        INSTANCE;

        @Override // k.a.c
        public void onComplete() {
        }

        @Override // k.a.c
        public void onError(Throwable th) {
        }

        @Override // k.a.c
        public void onNext(Object obj) {
        }

        @Override // h.c.m, k.a.c
        public void onSubscribe(k.a.d dVar) {
        }
    }

    public e() {
        this(a.INSTANCE, Long.MAX_VALUE);
    }

    protected void a() {
    }

    @Override // k.a.d
    public final void cancel() {
        if (this.f16887k) {
            return;
        }
        this.f16887k = true;
        h.c.n0.i.g.h(this.f16888l);
    }

    @Override // h.c.k0.b
    public final void dispose() {
        cancel();
    }

    @Override // h.c.k0.b
    public final boolean isDisposed() {
        return this.f16887k;
    }

    @Override // k.a.c
    public void onComplete() {
        if (!this.f16783f) {
            this.f16783f = true;
            if (this.f16888l.get() == null) {
                this.f16780c.add(new IllegalStateException("onSubscribe not called in proper order"));
            }
        }
        try {
            this.f16782e = Thread.currentThread();
            this.f16781d++;
            this.f16886j.onComplete();
        } finally {
            this.a.countDown();
        }
    }

    @Override // k.a.c
    public void onError(Throwable th) {
        if (!this.f16783f) {
            this.f16783f = true;
            if (this.f16888l.get() == null) {
                this.f16780c.add(new NullPointerException("onSubscribe not called in proper order"));
            }
        }
        try {
            this.f16782e = Thread.currentThread();
            this.f16780c.add(th);
            if (th == null) {
                this.f16780c.add(new IllegalStateException("onError received a null Throwable"));
            }
            this.f16886j.onError(th);
        } finally {
            this.a.countDown();
        }
    }

    @Override // k.a.c
    public void onNext(T t) {
        if (!this.f16783f) {
            this.f16783f = true;
            if (this.f16888l.get() == null) {
                this.f16780c.add(new IllegalStateException("onSubscribe not called in proper order"));
            }
        }
        this.f16782e = Thread.currentThread();
        if (this.f16785h != 2) {
            this.f16779b.add(t);
            if (t == null) {
                this.f16780c.add(new NullPointerException("onNext received a null value"));
            }
            this.f16886j.onNext(t);
            return;
        }
        while (true) {
            try {
                T poll = this.n.poll();
                if (poll == null) {
                    return;
                }
                this.f16779b.add(poll);
            } catch (Throwable th) {
                this.f16780c.add(th);
                this.n.cancel();
                return;
            }
        }
    }

    @Override // h.c.m, k.a.c
    public void onSubscribe(k.a.d dVar) {
        this.f16782e = Thread.currentThread();
        if (dVar == null) {
            this.f16780c.add(new NullPointerException("onSubscribe received a null Subscription"));
        } else if (!this.f16888l.compareAndSet(null, dVar)) {
            dVar.cancel();
            if (this.f16888l.get() != h.c.n0.i.g.CANCELLED) {
                this.f16780c.add(new IllegalStateException("onSubscribe received multiple subscriptions: " + dVar));
            }
        } else {
            int i2 = this.f16784g;
            if (i2 != 0 && (dVar instanceof g)) {
                g<T> gVar = (g) dVar;
                this.n = gVar;
                int n = gVar.n(i2);
                this.f16785h = n;
                if (n == 1) {
                    this.f16783f = true;
                    this.f16782e = Thread.currentThread();
                    while (true) {
                        try {
                            T poll = this.n.poll();
                            if (poll != null) {
                                this.f16779b.add(poll);
                            } else {
                                this.f16781d++;
                                return;
                            }
                        } catch (Throwable th) {
                            this.f16780c.add(th);
                            return;
                        }
                    }
                }
            }
            this.f16886j.onSubscribe(dVar);
            long andSet = this.m.getAndSet(0L);
            if (andSet != 0) {
                dVar.request(andSet);
            }
            a();
        }
    }

    @Override // k.a.d
    public final void request(long j2) {
        h.c.n0.i.g.n(this.f16888l, this.m, j2);
    }

    public e(long j2) {
        this(a.INSTANCE, j2);
    }

    public e(k.a.c<? super T> cVar, long j2) {
        if (j2 >= 0) {
            this.f16886j = cVar;
            this.f16888l = new AtomicReference<>();
            this.m = new AtomicLong(j2);
            return;
        }
        throw new IllegalArgumentException("Negative initial request not allowed");
    }
}