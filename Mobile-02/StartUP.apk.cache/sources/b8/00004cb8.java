package h.c.n0.e.b;

import java.util.Iterator;

/* compiled from: FlowableFromIterable.java */
/* loaded from: classes3.dex */
public final class i1<T> extends h.c.h<T> {
    final Iterable<? extends T> a;

    /* compiled from: FlowableFromIterable.java */
    /* loaded from: classes3.dex */
    static abstract class a<T> extends h.c.n0.i.b<T> {
        Iterator<? extends T> a;

        /* renamed from: b  reason: collision with root package name */
        volatile boolean f14497b;

        /* renamed from: c  reason: collision with root package name */
        boolean f14498c;

        a(Iterator<? extends T> it) {
            this.a = it;
        }

        abstract void a();

        abstract void b(long j2);

        @Override // k.a.d
        public final void cancel() {
            this.f14497b = true;
        }

        @Override // h.c.n0.c.j
        public final void clear() {
            this.a = null;
        }

        @Override // h.c.n0.c.j
        public final boolean isEmpty() {
            Iterator<? extends T> it = this.a;
            return it == null || !it.hasNext();
        }

        @Override // h.c.n0.c.f
        public final int n(int i2) {
            return i2 & 1;
        }

        @Override // h.c.n0.c.j
        public final T poll() {
            Iterator<? extends T> it = this.a;
            if (it == null) {
                return null;
            }
            if (!this.f14498c) {
                this.f14498c = true;
            } else if (!it.hasNext()) {
                return null;
            }
            return (T) h.c.n0.b.b.e(this.a.next(), "Iterator.next() returned a null value");
        }

        @Override // k.a.d
        public final void request(long j2) {
            if (h.c.n0.i.g.B(j2) && h.c.n0.j.d.a(this, j2) == 0) {
                if (j2 == Long.MAX_VALUE) {
                    a();
                } else {
                    b(j2);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: FlowableFromIterable.java */
    /* loaded from: classes3.dex */
    public static final class b<T> extends a<T> {

        /* renamed from: d  reason: collision with root package name */
        final h.c.n0.c.a<? super T> f14499d;

        b(h.c.n0.c.a<? super T> aVar, Iterator<? extends T> it) {
            super(it);
            this.f14499d = aVar;
        }

        @Override // h.c.n0.e.b.i1.a
        void a() {
            Iterator<? extends T> it = this.a;
            h.c.n0.c.a<? super T> aVar = this.f14499d;
            while (!this.f14497b) {
                try {
                    Object obj = (T) it.next();
                    if (this.f14497b) {
                        return;
                    }
                    if (obj == null) {
                        aVar.onError(new NullPointerException("Iterator.next() returned a null value"));
                        return;
                    }
                    aVar.h(obj);
                    if (this.f14497b) {
                        return;
                    }
                    try {
                        if (!it.hasNext()) {
                            if (this.f14497b) {
                                return;
                            }
                            aVar.onComplete();
                            return;
                        }
                    } catch (Throwable th) {
                        io.reactivex.exceptions.a.b(th);
                        aVar.onError(th);
                        return;
                    }
                } catch (Throwable th2) {
                    io.reactivex.exceptions.a.b(th2);
                    aVar.onError(th2);
                    return;
                }
            }
        }

        @Override // h.c.n0.e.b.i1.a
        void b(long j2) {
            Iterator<? extends T> it = this.a;
            h.c.n0.c.a<? super T> aVar = this.f14499d;
            do {
                long j3 = 0;
                while (true) {
                    if (j3 != j2) {
                        if (this.f14497b) {
                            return;
                        }
                        try {
                            Object obj = (T) it.next();
                            if (this.f14497b) {
                                return;
                            }
                            if (obj == null) {
                                aVar.onError(new NullPointerException("Iterator.next() returned a null value"));
                                return;
                            }
                            boolean h2 = aVar.h(obj);
                            if (this.f14497b) {
                                return;
                            }
                            try {
                                if (!it.hasNext()) {
                                    if (this.f14497b) {
                                        return;
                                    }
                                    aVar.onComplete();
                                    return;
                                } else if (h2) {
                                    j3++;
                                }
                            } catch (Throwable th) {
                                io.reactivex.exceptions.a.b(th);
                                aVar.onError(th);
                                return;
                            }
                        } catch (Throwable th2) {
                            io.reactivex.exceptions.a.b(th2);
                            aVar.onError(th2);
                            return;
                        }
                    } else {
                        j2 = get();
                        if (j3 == j2) {
                            j2 = addAndGet(-j3);
                        }
                    }
                }
            } while (j2 != 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: FlowableFromIterable.java */
    /* loaded from: classes3.dex */
    public static final class c<T> extends a<T> {

        /* renamed from: d  reason: collision with root package name */
        final k.a.c<? super T> f14500d;

        c(k.a.c<? super T> cVar, Iterator<? extends T> it) {
            super(it);
            this.f14500d = cVar;
        }

        @Override // h.c.n0.e.b.i1.a
        void a() {
            Iterator<? extends T> it = this.a;
            k.a.c<? super T> cVar = this.f14500d;
            while (!this.f14497b) {
                try {
                    Object obj = (T) it.next();
                    if (this.f14497b) {
                        return;
                    }
                    if (obj == null) {
                        cVar.onError(new NullPointerException("Iterator.next() returned a null value"));
                        return;
                    }
                    cVar.onNext(obj);
                    if (this.f14497b) {
                        return;
                    }
                    try {
                        if (!it.hasNext()) {
                            if (this.f14497b) {
                                return;
                            }
                            cVar.onComplete();
                            return;
                        }
                    } catch (Throwable th) {
                        io.reactivex.exceptions.a.b(th);
                        cVar.onError(th);
                        return;
                    }
                } catch (Throwable th2) {
                    io.reactivex.exceptions.a.b(th2);
                    cVar.onError(th2);
                    return;
                }
            }
        }

        @Override // h.c.n0.e.b.i1.a
        void b(long j2) {
            Iterator<? extends T> it = this.a;
            k.a.c<? super T> cVar = this.f14500d;
            do {
                long j3 = 0;
                while (true) {
                    if (j3 != j2) {
                        if (this.f14497b) {
                            return;
                        }
                        try {
                            Object obj = (T) it.next();
                            if (this.f14497b) {
                                return;
                            }
                            if (obj == null) {
                                cVar.onError(new NullPointerException("Iterator.next() returned a null value"));
                                return;
                            }
                            cVar.onNext(obj);
                            if (this.f14497b) {
                                return;
                            }
                            try {
                                if (!it.hasNext()) {
                                    if (this.f14497b) {
                                        return;
                                    }
                                    cVar.onComplete();
                                    return;
                                }
                                j3++;
                            } catch (Throwable th) {
                                io.reactivex.exceptions.a.b(th);
                                cVar.onError(th);
                                return;
                            }
                        } catch (Throwable th2) {
                            io.reactivex.exceptions.a.b(th2);
                            cVar.onError(th2);
                            return;
                        }
                    } else {
                        j2 = get();
                        if (j3 == j2) {
                            j2 = addAndGet(-j3);
                        }
                    }
                }
            } while (j2 != 0);
        }
    }

    public i1(Iterable<? extends T> iterable) {
        this.a = iterable;
    }

    public static <T> void b(k.a.c<? super T> cVar, Iterator<? extends T> it) {
        try {
            if (!it.hasNext()) {
                h.c.n0.i.d.h(cVar);
            } else if (cVar instanceof h.c.n0.c.a) {
                cVar.onSubscribe(new b((h.c.n0.c.a) cVar, it));
            } else {
                cVar.onSubscribe(new c(cVar, it));
            }
        } catch (Throwable th) {
            io.reactivex.exceptions.a.b(th);
            h.c.n0.i.d.q(th, cVar);
        }
    }

    @Override // h.c.h
    public void subscribeActual(k.a.c<? super T> cVar) {
        try {
            b(cVar, this.a.iterator());
        } catch (Throwable th) {
            io.reactivex.exceptions.a.b(th);
            h.c.n0.i.d.q(th, cVar);
        }
    }
}