package h.c.n0.e.b;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: FlowableOnBackpressureLatest.java */
/* loaded from: classes3.dex */
public final class n2<T> extends h.c.n0.e.b.a<T, T> {

    /* compiled from: FlowableOnBackpressureLatest.java */
    /* loaded from: classes3.dex */
    static final class a<T> extends AtomicInteger implements h.c.m<T>, k.a.d {
        final k.a.c<? super T> a;

        /* renamed from: b  reason: collision with root package name */
        k.a.d f14764b;

        /* renamed from: c  reason: collision with root package name */
        volatile boolean f14765c;

        /* renamed from: d  reason: collision with root package name */
        Throwable f14766d;

        /* renamed from: e  reason: collision with root package name */
        volatile boolean f14767e;

        /* renamed from: f  reason: collision with root package name */
        final AtomicLong f14768f = new AtomicLong();

        /* renamed from: g  reason: collision with root package name */
        final AtomicReference<T> f14769g = new AtomicReference<>();

        a(k.a.c<? super T> cVar) {
            this.a = cVar;
        }

        boolean a(boolean z, boolean z2, k.a.c<?> cVar, AtomicReference<T> atomicReference) {
            if (this.f14767e) {
                atomicReference.lazySet(null);
                return true;
            } else if (z) {
                Throwable th = this.f14766d;
                if (th != null) {
                    atomicReference.lazySet(null);
                    cVar.onError(th);
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

        void b() {
            if (getAndIncrement() != 0) {
                return;
            }
            k.a.c<? super T> cVar = this.a;
            AtomicLong atomicLong = this.f14768f;
            AtomicReference<T> atomicReference = this.f14769g;
            int i2 = 1;
            do {
                long j2 = 0;
                while (true) {
                    if (j2 == atomicLong.get()) {
                        break;
                    }
                    boolean z = this.f14765c;
                    Object obj = (T) atomicReference.getAndSet(null);
                    boolean z2 = obj == null;
                    if (a(z, z2, cVar, atomicReference)) {
                        return;
                    }
                    if (z2) {
                        break;
                    }
                    cVar.onNext(obj);
                    j2++;
                }
                if (j2 == atomicLong.get()) {
                    if (a(this.f14765c, atomicReference.get() == null, cVar, atomicReference)) {
                        return;
                    }
                }
                if (j2 != 0) {
                    h.c.n0.j.d.e(atomicLong, j2);
                }
                i2 = addAndGet(-i2);
            } while (i2 != 0);
        }

        @Override // k.a.d
        public void cancel() {
            if (this.f14767e) {
                return;
            }
            this.f14767e = true;
            this.f14764b.cancel();
            if (getAndIncrement() == 0) {
                this.f14769g.lazySet(null);
            }
        }

        @Override // k.a.c
        public void onComplete() {
            this.f14765c = true;
            b();
        }

        @Override // k.a.c
        public void onError(Throwable th) {
            this.f14766d = th;
            this.f14765c = true;
            b();
        }

        @Override // k.a.c
        public void onNext(T t) {
            this.f14769g.lazySet(t);
            b();
        }

        @Override // h.c.m, k.a.c
        public void onSubscribe(k.a.d dVar) {
            if (h.c.n0.i.g.C(this.f14764b, dVar)) {
                this.f14764b = dVar;
                this.a.onSubscribe(this);
                dVar.request(Long.MAX_VALUE);
            }
        }

        @Override // k.a.d
        public void request(long j2) {
            if (h.c.n0.i.g.B(j2)) {
                h.c.n0.j.d.a(this.f14768f, j2);
                b();
            }
        }
    }

    public n2(h.c.h<T> hVar) {
        super(hVar);
    }

    @Override // h.c.h
    protected void subscribeActual(k.a.c<? super T> cVar) {
        this.a.subscribe((h.c.m) new a(cVar));
    }
}