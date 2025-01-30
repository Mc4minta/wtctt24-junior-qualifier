package h.c.n0.e.e;

import java.util.ArrayDeque;

/* compiled from: ObservableSkipLast.java */
/* loaded from: classes3.dex */
public final class f3<T> extends h.c.n0.e.e.a<T, T> {

    /* renamed from: b  reason: collision with root package name */
    final int f15671b;

    /* compiled from: ObservableSkipLast.java */
    /* loaded from: classes3.dex */
    static final class a<T> extends ArrayDeque<T> implements h.c.z<T>, h.c.k0.b {
        final h.c.z<? super T> a;

        /* renamed from: b  reason: collision with root package name */
        final int f15672b;

        /* renamed from: c  reason: collision with root package name */
        h.c.k0.b f15673c;

        a(h.c.z<? super T> zVar, int i2) {
            super(i2);
            this.a = zVar;
            this.f15672b = i2;
        }

        @Override // h.c.k0.b
        public void dispose() {
            this.f15673c.dispose();
        }

        @Override // h.c.k0.b
        public boolean isDisposed() {
            return this.f15673c.isDisposed();
        }

        @Override // h.c.z, k.a.c
        public void onComplete() {
            this.a.onComplete();
        }

        @Override // h.c.z, k.a.c
        public void onError(Throwable th) {
            this.a.onError(th);
        }

        @Override // h.c.z, k.a.c
        public void onNext(T t) {
            if (this.f15672b == size()) {
                this.a.onNext((T) poll());
            }
            offer(t);
        }

        @Override // h.c.z
        public void onSubscribe(h.c.k0.b bVar) {
            if (h.c.n0.a.c.B(this.f15673c, bVar)) {
                this.f15673c = bVar;
                this.a.onSubscribe(this);
            }
        }
    }

    public f3(h.c.x<T> xVar, int i2) {
        super(xVar);
        this.f15671b = i2;
    }

    @Override // h.c.s
    public void subscribeActual(h.c.z<? super T> zVar) {
        this.a.subscribe(new a(zVar, this.f15671b));
    }
}