package h.c.n0.e.e;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: ObservablePublish.java */
/* loaded from: classes3.dex */
public final class f2<T> extends h.c.o0.a<T> {
    final h.c.x<T> a;

    /* renamed from: b  reason: collision with root package name */
    final AtomicReference<b<T>> f15664b;

    /* renamed from: c  reason: collision with root package name */
    final h.c.x<T> f15665c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ObservablePublish.java */
    /* loaded from: classes3.dex */
    public static final class a<T> extends AtomicReference<Object> implements h.c.k0.b {
        final h.c.z<? super T> a;

        a(h.c.z<? super T> zVar) {
            this.a = zVar;
        }

        void a(b<T> bVar) {
            if (compareAndSet(null, bVar)) {
                return;
            }
            bVar.b(this);
        }

        @Override // h.c.k0.b
        public void dispose() {
            Object andSet = getAndSet(this);
            if (andSet == null || andSet == this) {
                return;
            }
            ((b) andSet).b(this);
        }

        @Override // h.c.k0.b
        public boolean isDisposed() {
            return get() == this;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ObservablePublish.java */
    /* loaded from: classes3.dex */
    public static final class b<T> implements h.c.z<T>, h.c.k0.b {
        static final a[] a = new a[0];

        /* renamed from: b  reason: collision with root package name */
        static final a[] f15666b = new a[0];

        /* renamed from: c  reason: collision with root package name */
        final AtomicReference<b<T>> f15667c;

        /* renamed from: f  reason: collision with root package name */
        final AtomicReference<h.c.k0.b> f15670f = new AtomicReference<>();

        /* renamed from: d  reason: collision with root package name */
        final AtomicReference<a<T>[]> f15668d = new AtomicReference<>(a);

        /* renamed from: e  reason: collision with root package name */
        final AtomicBoolean f15669e = new AtomicBoolean();

        b(AtomicReference<b<T>> atomicReference) {
            this.f15667c = atomicReference;
        }

        boolean a(a<T> aVar) {
            a<T>[] aVarArr;
            a<T>[] aVarArr2;
            do {
                aVarArr = this.f15668d.get();
                if (aVarArr == f15666b) {
                    return false;
                }
                int length = aVarArr.length;
                aVarArr2 = new a[length + 1];
                System.arraycopy(aVarArr, 0, aVarArr2, 0, length);
                aVarArr2[length] = aVar;
            } while (!this.f15668d.compareAndSet(aVarArr, aVarArr2));
            return true;
        }

        /* JADX WARN: Multi-variable type inference failed */
        void b(a<T> aVar) {
            a<T>[] aVarArr;
            a[] aVarArr2;
            do {
                aVarArr = this.f15668d.get();
                int length = aVarArr.length;
                if (length == 0) {
                    return;
                }
                int i2 = -1;
                int i3 = 0;
                while (true) {
                    if (i3 >= length) {
                        break;
                    } else if (aVarArr[i3].equals(aVar)) {
                        i2 = i3;
                        break;
                    } else {
                        i3++;
                    }
                }
                if (i2 < 0) {
                    return;
                }
                if (length == 1) {
                    aVarArr2 = a;
                } else {
                    a[] aVarArr3 = new a[length - 1];
                    System.arraycopy(aVarArr, 0, aVarArr3, 0, i2);
                    System.arraycopy(aVarArr, i2 + 1, aVarArr3, i2, (length - i2) - 1);
                    aVarArr2 = aVarArr3;
                }
            } while (!this.f15668d.compareAndSet(aVarArr, aVarArr2));
        }

        @Override // h.c.k0.b
        public void dispose() {
            AtomicReference<a<T>[]> atomicReference = this.f15668d;
            a<T>[] aVarArr = f15666b;
            if (atomicReference.getAndSet(aVarArr) != aVarArr) {
                this.f15667c.compareAndSet(this, null);
                h.c.n0.a.c.h(this.f15670f);
            }
        }

        @Override // h.c.k0.b
        public boolean isDisposed() {
            return this.f15668d.get() == f15666b;
        }

        @Override // h.c.z, k.a.c
        public void onComplete() {
            this.f15667c.compareAndSet(this, null);
            for (a<T> aVar : this.f15668d.getAndSet(f15666b)) {
                aVar.a.onComplete();
            }
        }

        @Override // h.c.z, k.a.c
        public void onError(Throwable th) {
            this.f15667c.compareAndSet(this, null);
            a<T>[] andSet = this.f15668d.getAndSet(f15666b);
            if (andSet.length != 0) {
                for (a<T> aVar : andSet) {
                    aVar.a.onError(th);
                }
                return;
            }
            h.c.r0.a.u(th);
        }

        @Override // h.c.z, k.a.c
        public void onNext(T t) {
            for (a<T> aVar : this.f15668d.get()) {
                aVar.a.onNext(t);
            }
        }

        @Override // h.c.z
        public void onSubscribe(h.c.k0.b bVar) {
            h.c.n0.a.c.z(this.f15670f, bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ObservablePublish.java */
    /* loaded from: classes3.dex */
    public static final class c<T> implements h.c.x<T> {
        private final AtomicReference<b<T>> a;

        c(AtomicReference<b<T>> atomicReference) {
            this.a = atomicReference;
        }

        @Override // h.c.x
        public void subscribe(h.c.z<? super T> zVar) {
            a aVar = new a(zVar);
            zVar.onSubscribe(aVar);
            while (true) {
                b<T> bVar = this.a.get();
                if (bVar == null || bVar.isDisposed()) {
                    b<T> bVar2 = new b<>(this.a);
                    if (this.a.compareAndSet(bVar, bVar2)) {
                        bVar = bVar2;
                    } else {
                        continue;
                    }
                }
                if (bVar.a(aVar)) {
                    aVar.a(bVar);
                    return;
                }
            }
        }
    }

    private f2(h.c.x<T> xVar, h.c.x<T> xVar2, AtomicReference<b<T>> atomicReference) {
        this.f15665c = xVar;
        this.a = xVar2;
        this.f15664b = atomicReference;
    }

    public static <T> h.c.o0.a<T> d(h.c.x<T> xVar) {
        AtomicReference atomicReference = new AtomicReference();
        return h.c.r0.a.q(new f2(new c(atomicReference), xVar, atomicReference));
    }

    @Override // h.c.o0.a
    public void b(h.c.m0.f<? super h.c.k0.b> fVar) {
        b<T> bVar;
        while (true) {
            bVar = this.f15664b.get();
            if (bVar != null && !bVar.isDisposed()) {
                break;
            }
            b<T> bVar2 = new b<>(this.f15664b);
            if (this.f15664b.compareAndSet(bVar, bVar2)) {
                bVar = bVar2;
                break;
            }
        }
        boolean z = true;
        if (bVar.f15669e.get() || !bVar.f15669e.compareAndSet(false, true)) {
            z = false;
        }
        try {
            fVar.accept(bVar);
            if (z) {
                this.a.subscribe(bVar);
            }
        } catch (Throwable th) {
            io.reactivex.exceptions.a.b(th);
            throw h.c.n0.j.j.e(th);
        }
    }

    @Override // h.c.s
    protected void subscribeActual(h.c.z<? super T> zVar) {
        this.f15665c.subscribe(zVar);
    }
}