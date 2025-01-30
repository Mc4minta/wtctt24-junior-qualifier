package h.c.n0.e.b;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicReferenceArray;

/* compiled from: FlowableWithLatestFromMany.java */
/* loaded from: classes3.dex */
public final class x4<T, R> extends h.c.n0.e.b.a<T, R> {

    /* renamed from: b  reason: collision with root package name */
    final k.a.b<?>[] f15217b;

    /* renamed from: c  reason: collision with root package name */
    final Iterable<? extends k.a.b<?>> f15218c;

    /* renamed from: d  reason: collision with root package name */
    final h.c.m0.n<? super Object[], R> f15219d;

    /* compiled from: FlowableWithLatestFromMany.java */
    /* loaded from: classes3.dex */
    final class a implements h.c.m0.n<T, R> {
        a() {
        }

        /* JADX WARN: Type inference failed for: r1v1, types: [java.lang.Object[], java.lang.Object] */
        @Override // h.c.m0.n
        public R apply(T t) throws Exception {
            return (R) h.c.n0.b.b.e(x4.this.f15219d.apply(new Object[]{t}), "The combiner returned a null value");
        }
    }

    /* compiled from: FlowableWithLatestFromMany.java */
    /* loaded from: classes3.dex */
    static final class b<T, R> extends AtomicInteger implements h.c.n0.c.a<T>, k.a.d {
        final k.a.c<? super R> a;

        /* renamed from: b  reason: collision with root package name */
        final h.c.m0.n<? super Object[], R> f15220b;

        /* renamed from: c  reason: collision with root package name */
        final c[] f15221c;

        /* renamed from: d  reason: collision with root package name */
        final AtomicReferenceArray<Object> f15222d;

        /* renamed from: e  reason: collision with root package name */
        final AtomicReference<k.a.d> f15223e;

        /* renamed from: f  reason: collision with root package name */
        final AtomicLong f15224f;

        /* renamed from: g  reason: collision with root package name */
        final h.c.n0.j.c f15225g;

        /* renamed from: h  reason: collision with root package name */
        volatile boolean f15226h;

        b(k.a.c<? super R> cVar, h.c.m0.n<? super Object[], R> nVar, int i2) {
            this.a = cVar;
            this.f15220b = nVar;
            c[] cVarArr = new c[i2];
            for (int i3 = 0; i3 < i2; i3++) {
                cVarArr[i3] = new c(this, i3);
            }
            this.f15221c = cVarArr;
            this.f15222d = new AtomicReferenceArray<>(i2);
            this.f15223e = new AtomicReference<>();
            this.f15224f = new AtomicLong();
            this.f15225g = new h.c.n0.j.c();
        }

        void a(int i2) {
            c[] cVarArr = this.f15221c;
            for (int i3 = 0; i3 < cVarArr.length; i3++) {
                if (i3 != i2) {
                    cVarArr[i3].a();
                }
            }
        }

        void b(int i2, boolean z) {
            if (z) {
                return;
            }
            this.f15226h = true;
            h.c.n0.i.g.h(this.f15223e);
            a(i2);
            h.c.n0.j.k.b(this.a, this, this.f15225g);
        }

        void c(int i2, Throwable th) {
            this.f15226h = true;
            h.c.n0.i.g.h(this.f15223e);
            a(i2);
            h.c.n0.j.k.d(this.a, th, this, this.f15225g);
        }

        @Override // k.a.d
        public void cancel() {
            h.c.n0.i.g.h(this.f15223e);
            for (c cVar : this.f15221c) {
                cVar.a();
            }
        }

        void d(int i2, Object obj) {
            this.f15222d.set(i2, obj);
        }

        void e(k.a.b<?>[] bVarArr, int i2) {
            c[] cVarArr = this.f15221c;
            AtomicReference<k.a.d> atomicReference = this.f15223e;
            for (int i3 = 0; i3 < i2 && atomicReference.get() != h.c.n0.i.g.CANCELLED; i3++) {
                bVarArr[i3].subscribe(cVarArr[i3]);
            }
        }

        @Override // h.c.n0.c.a
        public boolean h(T t) {
            if (this.f15226h) {
                return false;
            }
            AtomicReferenceArray<Object> atomicReferenceArray = this.f15222d;
            int length = atomicReferenceArray.length();
            Object[] objArr = new Object[length + 1];
            objArr[0] = t;
            int i2 = 0;
            while (i2 < length) {
                Object obj = atomicReferenceArray.get(i2);
                if (obj == null) {
                    return false;
                }
                i2++;
                objArr[i2] = obj;
            }
            try {
                h.c.n0.j.k.f(this.a, h.c.n0.b.b.e(this.f15220b.apply(objArr), "The combiner returned a null value"), this, this.f15225g);
                return true;
            } catch (Throwable th) {
                io.reactivex.exceptions.a.b(th);
                cancel();
                onError(th);
                return false;
            }
        }

        @Override // k.a.c
        public void onComplete() {
            if (this.f15226h) {
                return;
            }
            this.f15226h = true;
            a(-1);
            h.c.n0.j.k.b(this.a, this, this.f15225g);
        }

        @Override // k.a.c
        public void onError(Throwable th) {
            if (this.f15226h) {
                h.c.r0.a.u(th);
                return;
            }
            this.f15226h = true;
            a(-1);
            h.c.n0.j.k.d(this.a, th, this, this.f15225g);
        }

        @Override // k.a.c
        public void onNext(T t) {
            if (h(t) || this.f15226h) {
                return;
            }
            this.f15223e.get().request(1L);
        }

        @Override // h.c.m, k.a.c
        public void onSubscribe(k.a.d dVar) {
            h.c.n0.i.g.q(this.f15223e, this.f15224f, dVar);
        }

        @Override // k.a.d
        public void request(long j2) {
            h.c.n0.i.g.n(this.f15223e, this.f15224f, j2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: FlowableWithLatestFromMany.java */
    /* loaded from: classes3.dex */
    public static final class c extends AtomicReference<k.a.d> implements h.c.m<Object> {
        final b<?, ?> a;

        /* renamed from: b  reason: collision with root package name */
        final int f15227b;

        /* renamed from: c  reason: collision with root package name */
        boolean f15228c;

        c(b<?, ?> bVar, int i2) {
            this.a = bVar;
            this.f15227b = i2;
        }

        void a() {
            h.c.n0.i.g.h(this);
        }

        @Override // k.a.c
        public void onComplete() {
            this.a.b(this.f15227b, this.f15228c);
        }

        @Override // k.a.c
        public void onError(Throwable th) {
            this.a.c(this.f15227b, th);
        }

        @Override // k.a.c
        public void onNext(Object obj) {
            if (!this.f15228c) {
                this.f15228c = true;
            }
            this.a.d(this.f15227b, obj);
        }

        @Override // h.c.m, k.a.c
        public void onSubscribe(k.a.d dVar) {
            h.c.n0.i.g.A(this, dVar, Long.MAX_VALUE);
        }
    }

    public x4(h.c.h<T> hVar, k.a.b<?>[] bVarArr, h.c.m0.n<? super Object[], R> nVar) {
        super(hVar);
        this.f15217b = bVarArr;
        this.f15218c = null;
        this.f15219d = nVar;
    }

    @Override // h.c.h
    protected void subscribeActual(k.a.c<? super R> cVar) {
        int length;
        k.a.b<?>[] bVarArr = this.f15217b;
        if (bVarArr == null) {
            bVarArr = new k.a.b[8];
            try {
                length = 0;
                for (k.a.b<?> bVar : this.f15218c) {
                    if (length == bVarArr.length) {
                        bVarArr = (k.a.b[]) Arrays.copyOf(bVarArr, (length >> 1) + length);
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
            new a2(this.a, new a()).subscribeActual(cVar);
            return;
        }
        b bVar2 = new b(cVar, this.f15219d, length);
        cVar.onSubscribe(bVar2);
        bVar2.e(bVarArr, length);
        this.a.subscribe((h.c.m) bVar2);
    }

    public x4(h.c.h<T> hVar, Iterable<? extends k.a.b<?>> iterable, h.c.m0.n<? super Object[], R> nVar) {
        super(hVar);
        this.f15217b = null;
        this.f15218c = iterable;
        this.f15219d = nVar;
    }
}