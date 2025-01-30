package h.c.n0.e.b;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: FlowableAmb.java */
/* loaded from: classes3.dex */
public final class h<T> extends h.c.h<T> {
    final k.a.b<? extends T>[] a;

    /* renamed from: b  reason: collision with root package name */
    final Iterable<? extends k.a.b<? extends T>> f14452b;

    /* compiled from: FlowableAmb.java */
    /* loaded from: classes3.dex */
    static final class a<T> implements k.a.d {
        final k.a.c<? super T> a;

        /* renamed from: b  reason: collision with root package name */
        final b<T>[] f14453b;

        /* renamed from: c  reason: collision with root package name */
        final AtomicInteger f14454c = new AtomicInteger();

        a(k.a.c<? super T> cVar, int i2) {
            this.a = cVar;
            this.f14453b = new b[i2];
        }

        public void a(k.a.b<? extends T>[] bVarArr) {
            b<T>[] bVarArr2 = this.f14453b;
            int length = bVarArr2.length;
            int i2 = 0;
            while (i2 < length) {
                int i3 = i2 + 1;
                bVarArr2[i2] = new b<>(this, i3, this.a);
                i2 = i3;
            }
            this.f14454c.lazySet(0);
            this.a.onSubscribe(this);
            for (int i4 = 0; i4 < length && this.f14454c.get() == 0; i4++) {
                bVarArr[i4].subscribe(bVarArr2[i4]);
            }
        }

        public boolean b(int i2) {
            int i3 = 0;
            if (this.f14454c.get() == 0 && this.f14454c.compareAndSet(0, i2)) {
                b<T>[] bVarArr = this.f14453b;
                int length = bVarArr.length;
                while (i3 < length) {
                    int i4 = i3 + 1;
                    if (i4 != i2) {
                        bVarArr[i3].cancel();
                    }
                    i3 = i4;
                }
                return true;
            }
            return false;
        }

        @Override // k.a.d
        public void cancel() {
            if (this.f14454c.get() != -1) {
                this.f14454c.lazySet(-1);
                for (b<T> bVar : this.f14453b) {
                    bVar.cancel();
                }
            }
        }

        @Override // k.a.d
        public void request(long j2) {
            if (h.c.n0.i.g.B(j2)) {
                int i2 = this.f14454c.get();
                if (i2 > 0) {
                    this.f14453b[i2 - 1].request(j2);
                } else if (i2 == 0) {
                    for (b<T> bVar : this.f14453b) {
                        bVar.request(j2);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: FlowableAmb.java */
    /* loaded from: classes3.dex */
    public static final class b<T> extends AtomicReference<k.a.d> implements h.c.m<T>, k.a.d {
        final a<T> a;

        /* renamed from: b  reason: collision with root package name */
        final int f14455b;

        /* renamed from: c  reason: collision with root package name */
        final k.a.c<? super T> f14456c;

        /* renamed from: d  reason: collision with root package name */
        boolean f14457d;

        /* renamed from: e  reason: collision with root package name */
        final AtomicLong f14458e = new AtomicLong();

        b(a<T> aVar, int i2, k.a.c<? super T> cVar) {
            this.a = aVar;
            this.f14455b = i2;
            this.f14456c = cVar;
        }

        @Override // k.a.d
        public void cancel() {
            h.c.n0.i.g.h(this);
        }

        @Override // k.a.c
        public void onComplete() {
            if (this.f14457d) {
                this.f14456c.onComplete();
            } else if (this.a.b(this.f14455b)) {
                this.f14457d = true;
                this.f14456c.onComplete();
            } else {
                get().cancel();
            }
        }

        @Override // k.a.c
        public void onError(Throwable th) {
            if (this.f14457d) {
                this.f14456c.onError(th);
            } else if (this.a.b(this.f14455b)) {
                this.f14457d = true;
                this.f14456c.onError(th);
            } else {
                get().cancel();
                h.c.r0.a.u(th);
            }
        }

        @Override // k.a.c
        public void onNext(T t) {
            if (this.f14457d) {
                this.f14456c.onNext(t);
            } else if (this.a.b(this.f14455b)) {
                this.f14457d = true;
                this.f14456c.onNext(t);
            } else {
                get().cancel();
            }
        }

        @Override // h.c.m, k.a.c
        public void onSubscribe(k.a.d dVar) {
            h.c.n0.i.g.q(this, this.f14458e, dVar);
        }

        @Override // k.a.d
        public void request(long j2) {
            h.c.n0.i.g.n(this, this.f14458e, j2);
        }
    }

    public h(k.a.b<? extends T>[] bVarArr, Iterable<? extends k.a.b<? extends T>> iterable) {
        this.a = bVarArr;
        this.f14452b = iterable;
    }

    @Override // h.c.h
    public void subscribeActual(k.a.c<? super T> cVar) {
        int length;
        k.a.b<? extends T>[] bVarArr = this.a;
        if (bVarArr == null) {
            bVarArr = new k.a.b[8];
            try {
                length = 0;
                for (k.a.b<? extends T> bVar : this.f14452b) {
                    if (bVar == null) {
                        h.c.n0.i.d.q(new NullPointerException("One of the sources is null"), cVar);
                        return;
                    }
                    if (length == bVarArr.length) {
                        k.a.b<? extends T>[] bVarArr2 = new k.a.b[(length >> 2) + length];
                        System.arraycopy(bVarArr, 0, bVarArr2, 0, length);
                        bVarArr = bVarArr2;
                    }
                    int i2 = length + 1;
                    bVarArr[length] = bVar;
                    length = i2;
                }
            } catch (Throwable th) {
                io.reactivex.exceptions.a.b(th);
                h.c.n0.i.d.q(th, cVar);
                return;
            }
        } else {
            length = bVarArr.length;
        }
        if (length == 0) {
            h.c.n0.i.d.h(cVar);
        } else if (length == 1) {
            bVarArr[0].subscribe(cVar);
        } else {
            new a(cVar, length).a(bVarArr);
        }
    }
}