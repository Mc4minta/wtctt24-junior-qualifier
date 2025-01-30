package h.c.n0.e.e;

import java.util.ArrayDeque;

/* compiled from: ObservableTakeLast.java */
/* loaded from: classes3.dex */
public final class n3<T> extends h.c.n0.e.e.a<T, T> {

    /* renamed from: b  reason: collision with root package name */
    final int f16008b;

    /* compiled from: ObservableTakeLast.java */
    /* loaded from: classes3.dex */
    static final class a<T> extends ArrayDeque<T> implements h.c.z<T>, h.c.k0.b {
        final h.c.z<? super T> a;

        /* renamed from: b  reason: collision with root package name */
        final int f16009b;

        /* renamed from: c  reason: collision with root package name */
        h.c.k0.b f16010c;

        /* renamed from: d  reason: collision with root package name */
        volatile boolean f16011d;

        a(h.c.z<? super T> zVar, int i2) {
            this.a = zVar;
            this.f16009b = i2;
        }

        @Override // h.c.k0.b
        public void dispose() {
            if (this.f16011d) {
                return;
            }
            this.f16011d = true;
            this.f16010c.dispose();
        }

        @Override // h.c.k0.b
        public boolean isDisposed() {
            return this.f16011d;
        }

        @Override // h.c.z, k.a.c
        public void onComplete() {
            h.c.z<? super T> zVar = this.a;
            while (!this.f16011d) {
                Object obj = (T) poll();
                if (obj == null) {
                    if (this.f16011d) {
                        return;
                    }
                    zVar.onComplete();
                    return;
                }
                zVar.onNext(obj);
            }
        }

        @Override // h.c.z, k.a.c
        public void onError(Throwable th) {
            this.a.onError(th);
        }

        @Override // h.c.z, k.a.c
        public void onNext(T t) {
            if (this.f16009b == size()) {
                poll();
            }
            offer(t);
        }

        @Override // h.c.z
        public void onSubscribe(h.c.k0.b bVar) {
            if (h.c.n0.a.c.B(this.f16010c, bVar)) {
                this.f16010c = bVar;
                this.a.onSubscribe(this);
            }
        }
    }

    public n3(h.c.x<T> xVar, int i2) {
        super(xVar);
        this.f16008b = i2;
    }

    @Override // h.c.s
    public void subscribeActual(h.c.z<? super T> zVar) {
        this.a.subscribe(new a(zVar, this.f16008b));
    }
}