package h.c.n0.e.b;

/* compiled from: FlowableFromArray.java */
/* loaded from: classes3.dex */
public final class f1<T> extends h.c.h<T> {
    final T[] a;

    /* compiled from: FlowableFromArray.java */
    /* loaded from: classes3.dex */
    static final class a<T> extends c<T> {

        /* renamed from: d  reason: collision with root package name */
        final h.c.n0.c.a<? super T> f14392d;

        a(h.c.n0.c.a<? super T> aVar, T[] tArr) {
            super(tArr);
            this.f14392d = aVar;
        }

        @Override // h.c.n0.e.b.f1.c
        void a() {
            T[] tArr = this.a;
            int length = tArr.length;
            h.c.n0.c.a<? super T> aVar = this.f14392d;
            for (int i2 = this.f14394b; i2 != length; i2++) {
                if (this.f14395c) {
                    return;
                }
                T t = tArr[i2];
                if (t == null) {
                    aVar.onError(new NullPointerException("The element at index " + i2 + " is null"));
                    return;
                }
                aVar.h(t);
            }
            if (this.f14395c) {
                return;
            }
            aVar.onComplete();
        }

        @Override // h.c.n0.e.b.f1.c
        void b(long j2) {
            T[] tArr = this.a;
            int length = tArr.length;
            int i2 = this.f14394b;
            h.c.n0.c.a<? super T> aVar = this.f14392d;
            do {
                long j3 = 0;
                while (true) {
                    if (j3 == j2 || i2 == length) {
                        if (i2 == length) {
                            if (this.f14395c) {
                                return;
                            }
                            aVar.onComplete();
                            return;
                        }
                        j2 = get();
                        if (j3 == j2) {
                            this.f14394b = i2;
                            j2 = addAndGet(-j3);
                        }
                    } else if (this.f14395c) {
                        return;
                    } else {
                        T t = tArr[i2];
                        if (t == null) {
                            aVar.onError(new NullPointerException("The element at index " + i2 + " is null"));
                            return;
                        }
                        if (aVar.h(t)) {
                            j3++;
                        }
                        i2++;
                    }
                }
            } while (j2 != 0);
        }
    }

    /* compiled from: FlowableFromArray.java */
    /* loaded from: classes3.dex */
    static final class b<T> extends c<T> {

        /* renamed from: d  reason: collision with root package name */
        final k.a.c<? super T> f14393d;

        b(k.a.c<? super T> cVar, T[] tArr) {
            super(tArr);
            this.f14393d = cVar;
        }

        @Override // h.c.n0.e.b.f1.c
        void a() {
            T[] tArr = this.a;
            int length = tArr.length;
            k.a.c<? super T> cVar = this.f14393d;
            for (int i2 = this.f14394b; i2 != length; i2++) {
                if (this.f14395c) {
                    return;
                }
                T t = tArr[i2];
                if (t == null) {
                    cVar.onError(new NullPointerException("The element at index " + i2 + " is null"));
                    return;
                }
                cVar.onNext(t);
            }
            if (this.f14395c) {
                return;
            }
            cVar.onComplete();
        }

        @Override // h.c.n0.e.b.f1.c
        void b(long j2) {
            T[] tArr = this.a;
            int length = tArr.length;
            int i2 = this.f14394b;
            k.a.c<? super T> cVar = this.f14393d;
            do {
                long j3 = 0;
                while (true) {
                    if (j3 == j2 || i2 == length) {
                        if (i2 == length) {
                            if (this.f14395c) {
                                return;
                            }
                            cVar.onComplete();
                            return;
                        }
                        j2 = get();
                        if (j3 == j2) {
                            this.f14394b = i2;
                            j2 = addAndGet(-j3);
                        }
                    } else if (this.f14395c) {
                        return;
                    } else {
                        T t = tArr[i2];
                        if (t == null) {
                            cVar.onError(new NullPointerException("The element at index " + i2 + " is null"));
                            return;
                        }
                        cVar.onNext(t);
                        j3++;
                        i2++;
                    }
                }
            } while (j2 != 0);
        }
    }

    /* compiled from: FlowableFromArray.java */
    /* loaded from: classes3.dex */
    static abstract class c<T> extends h.c.n0.i.b<T> {
        final T[] a;

        /* renamed from: b  reason: collision with root package name */
        int f14394b;

        /* renamed from: c  reason: collision with root package name */
        volatile boolean f14395c;

        c(T[] tArr) {
            this.a = tArr;
        }

        abstract void a();

        abstract void b(long j2);

        @Override // k.a.d
        public final void cancel() {
            this.f14395c = true;
        }

        @Override // h.c.n0.c.j
        public final void clear() {
            this.f14394b = this.a.length;
        }

        @Override // h.c.n0.c.j
        public final boolean isEmpty() {
            return this.f14394b == this.a.length;
        }

        @Override // h.c.n0.c.f
        public final int n(int i2) {
            return i2 & 1;
        }

        @Override // h.c.n0.c.j
        public final T poll() {
            int i2 = this.f14394b;
            T[] tArr = this.a;
            if (i2 == tArr.length) {
                return null;
            }
            this.f14394b = i2 + 1;
            return (T) h.c.n0.b.b.e(tArr[i2], "array element is null");
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

    public f1(T[] tArr) {
        this.a = tArr;
    }

    @Override // h.c.h
    public void subscribeActual(k.a.c<? super T> cVar) {
        if (cVar instanceof h.c.n0.c.a) {
            cVar.onSubscribe(new a((h.c.n0.c.a) cVar, this.a));
        } else {
            cVar.onSubscribe(new b(cVar, this.a));
        }
    }
}