package h.c.p0;

import h.c.e0;
import h.c.p;
import h.c.z;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: TestObserver.java */
/* loaded from: classes3.dex */
public class g<T> extends h.c.p0.a<T, g<T>> implements z<T>, h.c.k0.b, p<T>, e0<T>, h.c.e {

    /* renamed from: j  reason: collision with root package name */
    private final z<? super T> f16793j;

    /* renamed from: k  reason: collision with root package name */
    private final AtomicReference<h.c.k0.b> f16794k;

    /* renamed from: l  reason: collision with root package name */
    private h.c.n0.c.e<T> f16795l;

    /* compiled from: TestObserver.java */
    /* loaded from: classes3.dex */
    enum a implements z<Object> {
        INSTANCE;

        @Override // h.c.z, k.a.c
        public void onComplete() {
        }

        @Override // h.c.z, k.a.c
        public void onError(Throwable th) {
        }

        @Override // h.c.z, k.a.c
        public void onNext(Object obj) {
        }

        @Override // h.c.z
        public void onSubscribe(h.c.k0.b bVar) {
        }
    }

    public g() {
        this(a.INSTANCE);
    }

    public final void cancel() {
        dispose();
    }

    @Override // h.c.k0.b
    public final void dispose() {
        h.c.n0.a.c.h(this.f16794k);
    }

    @Override // h.c.k0.b
    public final boolean isDisposed() {
        return h.c.n0.a.c.n(this.f16794k.get());
    }

    @Override // h.c.z, k.a.c
    public void onComplete() {
        if (!this.f16783f) {
            this.f16783f = true;
            if (this.f16794k.get() == null) {
                this.f16780c.add(new IllegalStateException("onSubscribe not called in proper order"));
            }
        }
        try {
            this.f16782e = Thread.currentThread();
            this.f16781d++;
            this.f16793j.onComplete();
        } finally {
            this.a.countDown();
        }
    }

    @Override // h.c.z, k.a.c
    public void onError(Throwable th) {
        if (!this.f16783f) {
            this.f16783f = true;
            if (this.f16794k.get() == null) {
                this.f16780c.add(new IllegalStateException("onSubscribe not called in proper order"));
            }
        }
        try {
            this.f16782e = Thread.currentThread();
            if (th == null) {
                this.f16780c.add(new NullPointerException("onError received a null Throwable"));
            } else {
                this.f16780c.add(th);
            }
            this.f16793j.onError(th);
        } finally {
            this.a.countDown();
        }
    }

    @Override // h.c.z, k.a.c
    public void onNext(T t) {
        if (!this.f16783f) {
            this.f16783f = true;
            if (this.f16794k.get() == null) {
                this.f16780c.add(new IllegalStateException("onSubscribe not called in proper order"));
            }
        }
        this.f16782e = Thread.currentThread();
        if (this.f16785h != 2) {
            this.f16779b.add(t);
            if (t == null) {
                this.f16780c.add(new NullPointerException("onNext received a null value"));
            }
            this.f16793j.onNext(t);
            return;
        }
        while (true) {
            try {
                T poll = this.f16795l.poll();
                if (poll == null) {
                    return;
                }
                this.f16779b.add(poll);
            } catch (Throwable th) {
                this.f16780c.add(th);
                this.f16795l.dispose();
                return;
            }
        }
    }

    @Override // h.c.z
    public void onSubscribe(h.c.k0.b bVar) {
        this.f16782e = Thread.currentThread();
        if (bVar == null) {
            this.f16780c.add(new NullPointerException("onSubscribe received a null Subscription"));
        } else if (!this.f16794k.compareAndSet(null, bVar)) {
            bVar.dispose();
            if (this.f16794k.get() != h.c.n0.a.c.DISPOSED) {
                this.f16780c.add(new IllegalStateException("onSubscribe received multiple subscriptions: " + bVar));
            }
        } else {
            int i2 = this.f16784g;
            if (i2 != 0 && (bVar instanceof h.c.n0.c.e)) {
                h.c.n0.c.e<T> eVar = (h.c.n0.c.e) bVar;
                this.f16795l = eVar;
                int n = eVar.n(i2);
                this.f16785h = n;
                if (n == 1) {
                    this.f16783f = true;
                    this.f16782e = Thread.currentThread();
                    while (true) {
                        try {
                            T poll = this.f16795l.poll();
                            if (poll != null) {
                                this.f16779b.add(poll);
                            } else {
                                this.f16781d++;
                                this.f16794k.lazySet(h.c.n0.a.c.DISPOSED);
                                return;
                            }
                        } catch (Throwable th) {
                            this.f16780c.add(th);
                            return;
                        }
                    }
                }
            }
            this.f16793j.onSubscribe(bVar);
        }
    }

    @Override // h.c.p
    public void onSuccess(T t) {
        onNext(t);
        onComplete();
    }

    public g(z<? super T> zVar) {
        this.f16794k = new AtomicReference<>();
        this.f16793j = zVar;
    }
}