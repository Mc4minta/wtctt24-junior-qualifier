package h.c.n0.e.b;

import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/* compiled from: FlowableBuffer.java */
/* loaded from: classes3.dex */
public final class l<T, C extends Collection<? super T>> extends h.c.n0.e.b.a<T, C> {

    /* renamed from: b  reason: collision with root package name */
    final int f14601b;

    /* renamed from: c  reason: collision with root package name */
    final int f14602c;

    /* renamed from: d  reason: collision with root package name */
    final Callable<C> f14603d;

    /* compiled from: FlowableBuffer.java */
    /* loaded from: classes3.dex */
    static final class a<T, C extends Collection<? super T>> implements h.c.m<T>, k.a.d {
        final k.a.c<? super C> a;

        /* renamed from: b  reason: collision with root package name */
        final Callable<C> f14604b;

        /* renamed from: c  reason: collision with root package name */
        final int f14605c;

        /* renamed from: d  reason: collision with root package name */
        C f14606d;

        /* renamed from: e  reason: collision with root package name */
        k.a.d f14607e;

        /* renamed from: f  reason: collision with root package name */
        boolean f14608f;

        /* renamed from: g  reason: collision with root package name */
        int f14609g;

        a(k.a.c<? super C> cVar, int i2, Callable<C> callable) {
            this.a = cVar;
            this.f14605c = i2;
            this.f14604b = callable;
        }

        @Override // k.a.d
        public void cancel() {
            this.f14607e.cancel();
        }

        @Override // k.a.c
        public void onComplete() {
            if (this.f14608f) {
                return;
            }
            this.f14608f = true;
            C c2 = this.f14606d;
            if (c2 != null && !c2.isEmpty()) {
                this.a.onNext(c2);
            }
            this.a.onComplete();
        }

        @Override // k.a.c
        public void onError(Throwable th) {
            if (this.f14608f) {
                h.c.r0.a.u(th);
                return;
            }
            this.f14608f = true;
            this.a.onError(th);
        }

        @Override // k.a.c
        public void onNext(T t) {
            if (this.f14608f) {
                return;
            }
            C c2 = this.f14606d;
            if (c2 == null) {
                try {
                    c2 = (C) h.c.n0.b.b.e(this.f14604b.call(), "The bufferSupplier returned a null buffer");
                    this.f14606d = c2;
                } catch (Throwable th) {
                    io.reactivex.exceptions.a.b(th);
                    cancel();
                    onError(th);
                    return;
                }
            }
            c2.add(t);
            int i2 = this.f14609g + 1;
            if (i2 == this.f14605c) {
                this.f14609g = 0;
                this.f14606d = null;
                this.a.onNext(c2);
                return;
            }
            this.f14609g = i2;
        }

        @Override // h.c.m, k.a.c
        public void onSubscribe(k.a.d dVar) {
            if (h.c.n0.i.g.C(this.f14607e, dVar)) {
                this.f14607e = dVar;
                this.a.onSubscribe(this);
            }
        }

        @Override // k.a.d
        public void request(long j2) {
            if (h.c.n0.i.g.B(j2)) {
                this.f14607e.request(h.c.n0.j.d.d(j2, this.f14605c));
            }
        }
    }

    /* compiled from: FlowableBuffer.java */
    /* loaded from: classes3.dex */
    static final class b<T, C extends Collection<? super T>> extends AtomicLong implements h.c.m<T>, k.a.d, h.c.m0.e {
        final k.a.c<? super C> a;

        /* renamed from: b  reason: collision with root package name */
        final Callable<C> f14610b;

        /* renamed from: c  reason: collision with root package name */
        final int f14611c;

        /* renamed from: d  reason: collision with root package name */
        final int f14612d;

        /* renamed from: g  reason: collision with root package name */
        k.a.d f14615g;

        /* renamed from: h  reason: collision with root package name */
        boolean f14616h;

        /* renamed from: j  reason: collision with root package name */
        int f14617j;

        /* renamed from: k  reason: collision with root package name */
        volatile boolean f14618k;

        /* renamed from: l  reason: collision with root package name */
        long f14619l;

        /* renamed from: f  reason: collision with root package name */
        final AtomicBoolean f14614f = new AtomicBoolean();

        /* renamed from: e  reason: collision with root package name */
        final ArrayDeque<C> f14613e = new ArrayDeque<>();

        b(k.a.c<? super C> cVar, int i2, int i3, Callable<C> callable) {
            this.a = cVar;
            this.f14611c = i2;
            this.f14612d = i3;
            this.f14610b = callable;
        }

        @Override // h.c.m0.e
        public boolean a() {
            return this.f14618k;
        }

        @Override // k.a.d
        public void cancel() {
            this.f14618k = true;
            this.f14615g.cancel();
        }

        @Override // k.a.c
        public void onComplete() {
            if (this.f14616h) {
                return;
            }
            this.f14616h = true;
            long j2 = this.f14619l;
            if (j2 != 0) {
                h.c.n0.j.d.e(this, j2);
            }
            h.c.n0.j.r.g(this.a, this.f14613e, this, this);
        }

        @Override // k.a.c
        public void onError(Throwable th) {
            if (this.f14616h) {
                h.c.r0.a.u(th);
                return;
            }
            this.f14616h = true;
            this.f14613e.clear();
            this.a.onError(th);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // k.a.c
        public void onNext(T t) {
            if (this.f14616h) {
                return;
            }
            ArrayDeque<C> arrayDeque = this.f14613e;
            int i2 = this.f14617j;
            int i3 = i2 + 1;
            if (i2 == 0) {
                try {
                    arrayDeque.offer((Collection) h.c.n0.b.b.e(this.f14610b.call(), "The bufferSupplier returned a null buffer"));
                } catch (Throwable th) {
                    io.reactivex.exceptions.a.b(th);
                    cancel();
                    onError(th);
                    return;
                }
            }
            Collection collection = (Collection) arrayDeque.peek();
            if (collection != null && collection.size() + 1 == this.f14611c) {
                arrayDeque.poll();
                collection.add(t);
                this.f14619l++;
                this.a.onNext(collection);
            }
            Iterator it = arrayDeque.iterator();
            while (it.hasNext()) {
                ((Collection) it.next()).add(t);
            }
            if (i3 == this.f14612d) {
                i3 = 0;
            }
            this.f14617j = i3;
        }

        @Override // h.c.m, k.a.c
        public void onSubscribe(k.a.d dVar) {
            if (h.c.n0.i.g.C(this.f14615g, dVar)) {
                this.f14615g = dVar;
                this.a.onSubscribe(this);
            }
        }

        @Override // k.a.d
        public void request(long j2) {
            if (!h.c.n0.i.g.B(j2) || h.c.n0.j.r.i(j2, this.a, this.f14613e, this, this)) {
                return;
            }
            if (!this.f14614f.get() && this.f14614f.compareAndSet(false, true)) {
                this.f14615g.request(h.c.n0.j.d.c(this.f14611c, h.c.n0.j.d.d(this.f14612d, j2 - 1)));
                return;
            }
            this.f14615g.request(h.c.n0.j.d.d(this.f14612d, j2));
        }
    }

    /* compiled from: FlowableBuffer.java */
    /* loaded from: classes3.dex */
    static final class c<T, C extends Collection<? super T>> extends AtomicInteger implements h.c.m<T>, k.a.d {
        final k.a.c<? super C> a;

        /* renamed from: b  reason: collision with root package name */
        final Callable<C> f14620b;

        /* renamed from: c  reason: collision with root package name */
        final int f14621c;

        /* renamed from: d  reason: collision with root package name */
        final int f14622d;

        /* renamed from: e  reason: collision with root package name */
        C f14623e;

        /* renamed from: f  reason: collision with root package name */
        k.a.d f14624f;

        /* renamed from: g  reason: collision with root package name */
        boolean f14625g;

        /* renamed from: h  reason: collision with root package name */
        int f14626h;

        c(k.a.c<? super C> cVar, int i2, int i3, Callable<C> callable) {
            this.a = cVar;
            this.f14621c = i2;
            this.f14622d = i3;
            this.f14620b = callable;
        }

        @Override // k.a.d
        public void cancel() {
            this.f14624f.cancel();
        }

        @Override // k.a.c
        public void onComplete() {
            if (this.f14625g) {
                return;
            }
            this.f14625g = true;
            C c2 = this.f14623e;
            this.f14623e = null;
            if (c2 != null) {
                this.a.onNext(c2);
            }
            this.a.onComplete();
        }

        @Override // k.a.c
        public void onError(Throwable th) {
            if (this.f14625g) {
                h.c.r0.a.u(th);
                return;
            }
            this.f14625g = true;
            this.f14623e = null;
            this.a.onError(th);
        }

        @Override // k.a.c
        public void onNext(T t) {
            if (this.f14625g) {
                return;
            }
            C c2 = this.f14623e;
            int i2 = this.f14626h;
            int i3 = i2 + 1;
            if (i2 == 0) {
                try {
                    c2 = (C) h.c.n0.b.b.e(this.f14620b.call(), "The bufferSupplier returned a null buffer");
                    this.f14623e = c2;
                } catch (Throwable th) {
                    io.reactivex.exceptions.a.b(th);
                    cancel();
                    onError(th);
                    return;
                }
            }
            if (c2 != null) {
                c2.add(t);
                if (c2.size() == this.f14621c) {
                    this.f14623e = null;
                    this.a.onNext(c2);
                }
            }
            if (i3 == this.f14622d) {
                i3 = 0;
            }
            this.f14626h = i3;
        }

        @Override // h.c.m, k.a.c
        public void onSubscribe(k.a.d dVar) {
            if (h.c.n0.i.g.C(this.f14624f, dVar)) {
                this.f14624f = dVar;
                this.a.onSubscribe(this);
            }
        }

        @Override // k.a.d
        public void request(long j2) {
            if (h.c.n0.i.g.B(j2)) {
                if (get() == 0 && compareAndSet(0, 1)) {
                    this.f14624f.request(h.c.n0.j.d.c(h.c.n0.j.d.d(j2, this.f14621c), h.c.n0.j.d.d(this.f14622d - this.f14621c, j2 - 1)));
                    return;
                }
                this.f14624f.request(h.c.n0.j.d.d(this.f14622d, j2));
            }
        }
    }

    public l(h.c.h<T> hVar, int i2, int i3, Callable<C> callable) {
        super(hVar);
        this.f14601b = i2;
        this.f14602c = i3;
        this.f14603d = callable;
    }

    @Override // h.c.h
    public void subscribeActual(k.a.c<? super C> cVar) {
        int i2 = this.f14601b;
        int i3 = this.f14602c;
        if (i2 == i3) {
            this.a.subscribe((h.c.m) new a(cVar, i2, this.f14603d));
        } else if (i3 > i2) {
            this.a.subscribe((h.c.m) new c(cVar, this.f14601b, this.f14602c, this.f14603d));
        } else {
            this.a.subscribe((h.c.m) new b(cVar, this.f14601b, this.f14602c, this.f14603d));
        }
    }
}