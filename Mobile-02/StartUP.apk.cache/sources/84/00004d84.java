package h.c.n0.e.b;

import io.reactivex.exceptions.CompositeException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: FlowableConcatArray.java */
/* loaded from: classes3.dex */
public final class u<T> extends h.c.h<T> {
    final k.a.b<? extends T>[] a;

    /* renamed from: b  reason: collision with root package name */
    final boolean f15068b;

    /* compiled from: FlowableConcatArray.java */
    /* loaded from: classes3.dex */
    static final class a<T> extends h.c.n0.i.f implements h.c.m<T> {

        /* renamed from: j  reason: collision with root package name */
        final k.a.c<? super T> f15069j;

        /* renamed from: k  reason: collision with root package name */
        final k.a.b<? extends T>[] f15070k;

        /* renamed from: l  reason: collision with root package name */
        final boolean f15071l;
        final AtomicInteger m;
        int n;
        List<Throwable> p;
        long q;

        a(k.a.b<? extends T>[] bVarArr, boolean z, k.a.c<? super T> cVar) {
            super(false);
            this.f15069j = cVar;
            this.f15070k = bVarArr;
            this.f15071l = z;
            this.m = new AtomicInteger();
        }

        @Override // k.a.c
        public void onComplete() {
            if (this.m.getAndIncrement() == 0) {
                k.a.b<? extends T>[] bVarArr = this.f15070k;
                int length = bVarArr.length;
                int i2 = this.n;
                while (i2 != length) {
                    k.a.b<? extends T> bVar = bVarArr[i2];
                    if (bVar == null) {
                        NullPointerException nullPointerException = new NullPointerException("A Publisher entry is null");
                        if (this.f15071l) {
                            List list = this.p;
                            if (list == null) {
                                list = new ArrayList((length - i2) + 1);
                                this.p = list;
                            }
                            list.add(nullPointerException);
                            i2++;
                        } else {
                            this.f15069j.onError(nullPointerException);
                            return;
                        }
                    } else {
                        long j2 = this.q;
                        if (j2 != 0) {
                            this.q = 0L;
                            g(j2);
                        }
                        bVar.subscribe(this);
                        i2++;
                        this.n = i2;
                        if (this.m.decrementAndGet() == 0) {
                            return;
                        }
                    }
                }
                List<Throwable> list2 = this.p;
                if (list2 != null) {
                    if (list2.size() == 1) {
                        this.f15069j.onError(list2.get(0));
                        return;
                    } else {
                        this.f15069j.onError(new CompositeException(list2));
                        return;
                    }
                }
                this.f15069j.onComplete();
            }
        }

        @Override // k.a.c
        public void onError(Throwable th) {
            if (this.f15071l) {
                List list = this.p;
                if (list == null) {
                    list = new ArrayList((this.f15070k.length - this.n) + 1);
                    this.p = list;
                }
                list.add(th);
                onComplete();
                return;
            }
            this.f15069j.onError(th);
        }

        @Override // k.a.c
        public void onNext(T t) {
            this.q++;
            this.f15069j.onNext(t);
        }

        @Override // h.c.m, k.a.c
        public void onSubscribe(k.a.d dVar) {
            i(dVar);
        }
    }

    public u(k.a.b<? extends T>[] bVarArr, boolean z) {
        this.a = bVarArr;
        this.f15068b = z;
    }

    @Override // h.c.h
    protected void subscribeActual(k.a.c<? super T> cVar) {
        a aVar = new a(this.a, this.f15068b, cVar);
        cVar.onSubscribe(aVar);
        aVar.onComplete();
    }
}