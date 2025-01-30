package h.c.n0.e.e;

import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: ObservableBuffer.java */
/* loaded from: classes3.dex */
public final class l<T, U extends Collection<? super T>> extends h.c.n0.e.e.a<T, U> {

    /* renamed from: b  reason: collision with root package name */
    final int f15895b;

    /* renamed from: c  reason: collision with root package name */
    final int f15896c;

    /* renamed from: d  reason: collision with root package name */
    final Callable<U> f15897d;

    /* compiled from: ObservableBuffer.java */
    /* loaded from: classes3.dex */
    static final class a<T, U extends Collection<? super T>> implements h.c.z<T>, h.c.k0.b {
        final h.c.z<? super U> a;

        /* renamed from: b  reason: collision with root package name */
        final int f15898b;

        /* renamed from: c  reason: collision with root package name */
        final Callable<U> f15899c;

        /* renamed from: d  reason: collision with root package name */
        U f15900d;

        /* renamed from: e  reason: collision with root package name */
        int f15901e;

        /* renamed from: f  reason: collision with root package name */
        h.c.k0.b f15902f;

        a(h.c.z<? super U> zVar, int i2, Callable<U> callable) {
            this.a = zVar;
            this.f15898b = i2;
            this.f15899c = callable;
        }

        boolean a() {
            try {
                this.f15900d = (U) h.c.n0.b.b.e(this.f15899c.call(), "Empty buffer supplied");
                return true;
            } catch (Throwable th) {
                io.reactivex.exceptions.a.b(th);
                this.f15900d = null;
                h.c.k0.b bVar = this.f15902f;
                if (bVar == null) {
                    h.c.n0.a.d.y(th, this.a);
                    return false;
                }
                bVar.dispose();
                this.a.onError(th);
                return false;
            }
        }

        @Override // h.c.k0.b
        public void dispose() {
            this.f15902f.dispose();
        }

        @Override // h.c.k0.b
        public boolean isDisposed() {
            return this.f15902f.isDisposed();
        }

        @Override // h.c.z, k.a.c
        public void onComplete() {
            U u = this.f15900d;
            if (u != null) {
                this.f15900d = null;
                if (!u.isEmpty()) {
                    this.a.onNext(u);
                }
                this.a.onComplete();
            }
        }

        @Override // h.c.z, k.a.c
        public void onError(Throwable th) {
            this.f15900d = null;
            this.a.onError(th);
        }

        @Override // h.c.z, k.a.c
        public void onNext(T t) {
            U u = this.f15900d;
            if (u != null) {
                u.add(t);
                int i2 = this.f15901e + 1;
                this.f15901e = i2;
                if (i2 >= this.f15898b) {
                    this.a.onNext(u);
                    this.f15901e = 0;
                    a();
                }
            }
        }

        @Override // h.c.z
        public void onSubscribe(h.c.k0.b bVar) {
            if (h.c.n0.a.c.B(this.f15902f, bVar)) {
                this.f15902f = bVar;
                this.a.onSubscribe(this);
            }
        }
    }

    /* compiled from: ObservableBuffer.java */
    /* loaded from: classes3.dex */
    static final class b<T, U extends Collection<? super T>> extends AtomicBoolean implements h.c.z<T>, h.c.k0.b {
        final h.c.z<? super U> a;

        /* renamed from: b  reason: collision with root package name */
        final int f15903b;

        /* renamed from: c  reason: collision with root package name */
        final int f15904c;

        /* renamed from: d  reason: collision with root package name */
        final Callable<U> f15905d;

        /* renamed from: e  reason: collision with root package name */
        h.c.k0.b f15906e;

        /* renamed from: f  reason: collision with root package name */
        final ArrayDeque<U> f15907f = new ArrayDeque<>();

        /* renamed from: g  reason: collision with root package name */
        long f15908g;

        b(h.c.z<? super U> zVar, int i2, int i3, Callable<U> callable) {
            this.a = zVar;
            this.f15903b = i2;
            this.f15904c = i3;
            this.f15905d = callable;
        }

        @Override // h.c.k0.b
        public void dispose() {
            this.f15906e.dispose();
        }

        @Override // h.c.k0.b
        public boolean isDisposed() {
            return this.f15906e.isDisposed();
        }

        @Override // h.c.z, k.a.c
        public void onComplete() {
            while (!this.f15907f.isEmpty()) {
                this.a.onNext(this.f15907f.poll());
            }
            this.a.onComplete();
        }

        @Override // h.c.z, k.a.c
        public void onError(Throwable th) {
            this.f15907f.clear();
            this.a.onError(th);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // h.c.z, k.a.c
        public void onNext(T t) {
            long j2 = this.f15908g;
            this.f15908g = 1 + j2;
            if (j2 % this.f15904c == 0) {
                try {
                    this.f15907f.offer((Collection) h.c.n0.b.b.e(this.f15905d.call(), "The bufferSupplier returned a null collection. Null values are generally not allowed in 2.x operators and sources."));
                } catch (Throwable th) {
                    this.f15907f.clear();
                    this.f15906e.dispose();
                    this.a.onError(th);
                    return;
                }
            }
            Iterator<U> it = this.f15907f.iterator();
            while (it.hasNext()) {
                U next = it.next();
                next.add(t);
                if (this.f15903b <= next.size()) {
                    it.remove();
                    this.a.onNext(next);
                }
            }
        }

        @Override // h.c.z
        public void onSubscribe(h.c.k0.b bVar) {
            if (h.c.n0.a.c.B(this.f15906e, bVar)) {
                this.f15906e = bVar;
                this.a.onSubscribe(this);
            }
        }
    }

    public l(h.c.x<T> xVar, int i2, int i3, Callable<U> callable) {
        super(xVar);
        this.f15895b = i2;
        this.f15896c = i3;
        this.f15897d = callable;
    }

    @Override // h.c.s
    protected void subscribeActual(h.c.z<? super U> zVar) {
        int i2 = this.f15896c;
        int i3 = this.f15895b;
        if (i2 == i3) {
            a aVar = new a(zVar, i3, this.f15897d);
            if (aVar.a()) {
                this.a.subscribe(aVar);
                return;
            }
            return;
        }
        this.a.subscribe(new b(zVar, this.f15895b, this.f15896c, this.f15897d));
    }
}