package h.c.n0.e.b;

import io.reactivex.exceptions.MissingBackpressureException;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: FlowableCreate.java */
/* loaded from: classes3.dex */
public final class e0<T> extends h.c.h<T> {
    final h.c.k<T> a;

    /* renamed from: b  reason: collision with root package name */
    final h.c.b f14336b;

    /* compiled from: FlowableCreate.java */
    /* loaded from: classes3.dex */
    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[h.c.b.values().length];
            a = iArr;
            try {
                iArr[h.c.b.MISSING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[h.c.b.ERROR.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[h.c.b.DROP.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[h.c.b.LATEST.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: FlowableCreate.java */
    /* loaded from: classes3.dex */
    public static abstract class b<T> extends AtomicLong implements h.c.j<T>, k.a.d {
        final k.a.c<? super T> a;

        /* renamed from: b  reason: collision with root package name */
        final h.c.n0.a.g f14337b = new h.c.n0.a.g();

        b(k.a.c<? super T> cVar) {
            this.a = cVar;
        }

        protected void a() {
            if (c()) {
                return;
            }
            try {
                this.a.onComplete();
            } finally {
                this.f14337b.dispose();
            }
        }

        protected boolean b(Throwable th) {
            if (th == null) {
                th = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
            }
            if (c()) {
                return false;
            }
            try {
                this.a.onError(th);
                this.f14337b.dispose();
                return true;
            } catch (Throwable th2) {
                this.f14337b.dispose();
                throw th2;
            }
        }

        public final boolean c() {
            return this.f14337b.isDisposed();
        }

        @Override // k.a.d
        public final void cancel() {
            this.f14337b.dispose();
            f();
        }

        public final void d(Throwable th) {
            if (g(th)) {
                return;
            }
            h.c.r0.a.u(th);
        }

        void e() {
        }

        void f() {
        }

        public boolean g(Throwable th) {
            return b(th);
        }

        @Override // h.c.g
        public void onComplete() {
            a();
        }

        @Override // k.a.d
        public final void request(long j2) {
            if (h.c.n0.i.g.B(j2)) {
                h.c.n0.j.d.a(this, j2);
                e();
            }
        }

        @Override // java.util.concurrent.atomic.AtomicLong
        public String toString() {
            return String.format("%s{%s}", getClass().getSimpleName(), super.toString());
        }
    }

    /* compiled from: FlowableCreate.java */
    /* loaded from: classes3.dex */
    static final class c<T> extends b<T> {

        /* renamed from: c  reason: collision with root package name */
        final h.c.n0.f.c<T> f14338c;

        /* renamed from: d  reason: collision with root package name */
        Throwable f14339d;

        /* renamed from: e  reason: collision with root package name */
        volatile boolean f14340e;

        /* renamed from: f  reason: collision with root package name */
        final AtomicInteger f14341f;

        c(k.a.c<? super T> cVar, int i2) {
            super(cVar);
            this.f14338c = new h.c.n0.f.c<>(i2);
            this.f14341f = new AtomicInteger();
        }

        @Override // h.c.n0.e.b.e0.b
        void e() {
            h();
        }

        @Override // h.c.n0.e.b.e0.b
        void f() {
            if (this.f14341f.getAndIncrement() == 0) {
                this.f14338c.clear();
            }
        }

        @Override // h.c.n0.e.b.e0.b
        public boolean g(Throwable th) {
            if (this.f14340e || c()) {
                return false;
            }
            if (th == null) {
                th = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
            }
            this.f14339d = th;
            this.f14340e = true;
            h();
            return true;
        }

        void h() {
            int i2;
            if (this.f14341f.getAndIncrement() != 0) {
                return;
            }
            k.a.c<? super T> cVar = this.a;
            h.c.n0.f.c<T> cVar2 = this.f14338c;
            int i3 = 1;
            do {
                long j2 = get();
                long j3 = 0;
                while (true) {
                    i2 = (j3 > j2 ? 1 : (j3 == j2 ? 0 : -1));
                    if (i2 == 0) {
                        break;
                    } else if (c()) {
                        cVar2.clear();
                        return;
                    } else {
                        boolean z = this.f14340e;
                        Object obj = (T) cVar2.poll();
                        boolean z2 = obj == null;
                        if (z && z2) {
                            Throwable th = this.f14339d;
                            if (th != null) {
                                b(th);
                                return;
                            } else {
                                a();
                                return;
                            }
                        } else if (z2) {
                            break;
                        } else {
                            cVar.onNext(obj);
                            j3++;
                        }
                    }
                }
                if (i2 == 0) {
                    if (c()) {
                        cVar2.clear();
                        return;
                    }
                    boolean z3 = this.f14340e;
                    boolean isEmpty = cVar2.isEmpty();
                    if (z3 && isEmpty) {
                        Throwable th2 = this.f14339d;
                        if (th2 != null) {
                            b(th2);
                            return;
                        } else {
                            a();
                            return;
                        }
                    }
                }
                if (j3 != 0) {
                    h.c.n0.j.d.e(this, j3);
                }
                i3 = this.f14341f.addAndGet(-i3);
            } while (i3 != 0);
        }

        @Override // h.c.n0.e.b.e0.b, h.c.g
        public void onComplete() {
            this.f14340e = true;
            h();
        }

        @Override // h.c.g
        public void onNext(T t) {
            if (this.f14340e || c()) {
                return;
            }
            if (t == null) {
                d(new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources."));
                return;
            }
            this.f14338c.offer(t);
            h();
        }
    }

    /* compiled from: FlowableCreate.java */
    /* loaded from: classes3.dex */
    static final class d<T> extends h<T> {
        d(k.a.c<? super T> cVar) {
            super(cVar);
        }

        @Override // h.c.n0.e.b.e0.h
        void h() {
        }
    }

    /* compiled from: FlowableCreate.java */
    /* loaded from: classes3.dex */
    static final class e<T> extends h<T> {
        e(k.a.c<? super T> cVar) {
            super(cVar);
        }

        @Override // h.c.n0.e.b.e0.h
        void h() {
            d(new MissingBackpressureException("create: could not emit value due to lack of requests"));
        }
    }

    /* compiled from: FlowableCreate.java */
    /* loaded from: classes3.dex */
    static final class f<T> extends b<T> {

        /* renamed from: c  reason: collision with root package name */
        final AtomicReference<T> f14342c;

        /* renamed from: d  reason: collision with root package name */
        Throwable f14343d;

        /* renamed from: e  reason: collision with root package name */
        volatile boolean f14344e;

        /* renamed from: f  reason: collision with root package name */
        final AtomicInteger f14345f;

        f(k.a.c<? super T> cVar) {
            super(cVar);
            this.f14342c = new AtomicReference<>();
            this.f14345f = new AtomicInteger();
        }

        @Override // h.c.n0.e.b.e0.b
        void e() {
            h();
        }

        @Override // h.c.n0.e.b.e0.b
        void f() {
            if (this.f14345f.getAndIncrement() == 0) {
                this.f14342c.lazySet(null);
            }
        }

        @Override // h.c.n0.e.b.e0.b
        public boolean g(Throwable th) {
            if (this.f14344e || c()) {
                return false;
            }
            if (th == null) {
                d(new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources."));
            }
            this.f14343d = th;
            this.f14344e = true;
            h();
            return true;
        }

        void h() {
            int i2;
            if (this.f14345f.getAndIncrement() != 0) {
                return;
            }
            k.a.c<? super T> cVar = this.a;
            AtomicReference<T> atomicReference = this.f14342c;
            int i3 = 1;
            do {
                long j2 = get();
                long j3 = 0;
                while (true) {
                    i2 = (j3 > j2 ? 1 : (j3 == j2 ? 0 : -1));
                    if (i2 == 0) {
                        break;
                    } else if (c()) {
                        atomicReference.lazySet(null);
                        return;
                    } else {
                        boolean z = this.f14344e;
                        Object obj = (T) atomicReference.getAndSet(null);
                        boolean z2 = obj == null;
                        if (z && z2) {
                            Throwable th = this.f14343d;
                            if (th != null) {
                                b(th);
                                return;
                            } else {
                                a();
                                return;
                            }
                        } else if (z2) {
                            break;
                        } else {
                            cVar.onNext(obj);
                            j3++;
                        }
                    }
                }
                if (i2 == 0) {
                    if (c()) {
                        atomicReference.lazySet(null);
                        return;
                    }
                    boolean z3 = this.f14344e;
                    boolean z4 = atomicReference.get() == null;
                    if (z3 && z4) {
                        Throwable th2 = this.f14343d;
                        if (th2 != null) {
                            b(th2);
                            return;
                        } else {
                            a();
                            return;
                        }
                    }
                }
                if (j3 != 0) {
                    h.c.n0.j.d.e(this, j3);
                }
                i3 = this.f14345f.addAndGet(-i3);
            } while (i3 != 0);
        }

        @Override // h.c.n0.e.b.e0.b, h.c.g
        public void onComplete() {
            this.f14344e = true;
            h();
        }

        @Override // h.c.g
        public void onNext(T t) {
            if (this.f14344e || c()) {
                return;
            }
            if (t == null) {
                d(new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources."));
                return;
            }
            this.f14342c.set(t);
            h();
        }
    }

    /* compiled from: FlowableCreate.java */
    /* loaded from: classes3.dex */
    static final class g<T> extends b<T> {
        g(k.a.c<? super T> cVar) {
            super(cVar);
        }

        @Override // h.c.g
        public void onNext(T t) {
            long j2;
            if (c()) {
                return;
            }
            if (t != null) {
                this.a.onNext(t);
                do {
                    j2 = get();
                    if (j2 == 0) {
                        return;
                    }
                } while (!compareAndSet(j2, j2 - 1));
                return;
            }
            d(new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources."));
        }
    }

    /* compiled from: FlowableCreate.java */
    /* loaded from: classes3.dex */
    static abstract class h<T> extends b<T> {
        h(k.a.c<? super T> cVar) {
            super(cVar);
        }

        abstract void h();

        @Override // h.c.g
        public final void onNext(T t) {
            if (c()) {
                return;
            }
            if (t == null) {
                d(new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources."));
            } else if (get() != 0) {
                this.a.onNext(t);
                h.c.n0.j.d.e(this, 1L);
            } else {
                h();
            }
        }
    }

    public e0(h.c.k<T> kVar, h.c.b bVar) {
        this.a = kVar;
        this.f14336b = bVar;
    }

    @Override // h.c.h
    public void subscribeActual(k.a.c<? super T> cVar) {
        b gVar;
        int i2 = a.a[this.f14336b.ordinal()];
        if (i2 == 1) {
            gVar = new g(cVar);
        } else if (i2 == 2) {
            gVar = new e(cVar);
        } else if (i2 == 3) {
            gVar = new d(cVar);
        } else if (i2 != 4) {
            gVar = new c(cVar, h.c.h.bufferSize());
        } else {
            gVar = new f(cVar);
        }
        cVar.onSubscribe(gVar);
        try {
            this.a.a(gVar);
        } catch (Throwable th) {
            io.reactivex.exceptions.a.b(th);
            gVar.d(th);
        }
    }
}