package h.c.n0.e.b;

/* compiled from: FlowableRangeLong.java */
/* loaded from: classes3.dex */
public final class t2 extends h.c.h<Long> {
    final long a;

    /* renamed from: b  reason: collision with root package name */
    final long f15036b;

    /* compiled from: FlowableRangeLong.java */
    /* loaded from: classes3.dex */
    static abstract class a extends h.c.n0.i.b<Long> {
        final long a;

        /* renamed from: b  reason: collision with root package name */
        long f15037b;

        /* renamed from: c  reason: collision with root package name */
        volatile boolean f15038c;

        a(long j2, long j3) {
            this.f15037b = j2;
            this.a = j3;
        }

        abstract void a();

        @Override // h.c.n0.c.j
        /* renamed from: b */
        public final Long poll() {
            long j2 = this.f15037b;
            if (j2 == this.a) {
                return null;
            }
            this.f15037b = 1 + j2;
            return Long.valueOf(j2);
        }

        abstract void c(long j2);

        @Override // k.a.d
        public final void cancel() {
            this.f15038c = true;
        }

        @Override // h.c.n0.c.j
        public final void clear() {
            this.f15037b = this.a;
        }

        @Override // h.c.n0.c.j
        public final boolean isEmpty() {
            return this.f15037b == this.a;
        }

        @Override // h.c.n0.c.f
        public final int n(int i2) {
            return i2 & 1;
        }

        @Override // k.a.d
        public final void request(long j2) {
            if (h.c.n0.i.g.B(j2) && h.c.n0.j.d.a(this, j2) == 0) {
                if (j2 == Long.MAX_VALUE) {
                    a();
                } else {
                    c(j2);
                }
            }
        }
    }

    /* compiled from: FlowableRangeLong.java */
    /* loaded from: classes3.dex */
    static final class b extends a {

        /* renamed from: d  reason: collision with root package name */
        final h.c.n0.c.a<? super Long> f15039d;

        b(h.c.n0.c.a<? super Long> aVar, long j2, long j3) {
            super(j2, j3);
            this.f15039d = aVar;
        }

        @Override // h.c.n0.e.b.t2.a
        void a() {
            long j2 = this.a;
            h.c.n0.c.a<? super Long> aVar = this.f15039d;
            for (long j3 = this.f15037b; j3 != j2; j3++) {
                if (this.f15038c) {
                    return;
                }
                aVar.h(Long.valueOf(j3));
            }
            if (this.f15038c) {
                return;
            }
            aVar.onComplete();
        }

        @Override // h.c.n0.e.b.t2.a
        void c(long j2) {
            long j3 = this.a;
            long j4 = this.f15037b;
            h.c.n0.c.a<? super Long> aVar = this.f15039d;
            do {
                long j5 = 0;
                while (true) {
                    if (j5 == j2 || j4 == j3) {
                        if (j4 == j3) {
                            if (this.f15038c) {
                                return;
                            }
                            aVar.onComplete();
                            return;
                        }
                        j2 = get();
                        if (j5 == j2) {
                            this.f15037b = j4;
                            j2 = addAndGet(-j5);
                        }
                    } else if (this.f15038c) {
                        return;
                    } else {
                        if (aVar.h(Long.valueOf(j4))) {
                            j5++;
                        }
                        j4++;
                    }
                }
            } while (j2 != 0);
        }
    }

    /* compiled from: FlowableRangeLong.java */
    /* loaded from: classes3.dex */
    static final class c extends a {

        /* renamed from: d  reason: collision with root package name */
        final k.a.c<? super Long> f15040d;

        c(k.a.c<? super Long> cVar, long j2, long j3) {
            super(j2, j3);
            this.f15040d = cVar;
        }

        @Override // h.c.n0.e.b.t2.a
        void a() {
            long j2 = this.a;
            k.a.c<? super Long> cVar = this.f15040d;
            for (long j3 = this.f15037b; j3 != j2; j3++) {
                if (this.f15038c) {
                    return;
                }
                cVar.onNext(Long.valueOf(j3));
            }
            if (this.f15038c) {
                return;
            }
            cVar.onComplete();
        }

        @Override // h.c.n0.e.b.t2.a
        void c(long j2) {
            long j3 = this.a;
            long j4 = this.f15037b;
            k.a.c<? super Long> cVar = this.f15040d;
            do {
                long j5 = 0;
                while (true) {
                    if (j5 == j2 || j4 == j3) {
                        if (j4 == j3) {
                            if (this.f15038c) {
                                return;
                            }
                            cVar.onComplete();
                            return;
                        }
                        j2 = get();
                        if (j5 == j2) {
                            this.f15037b = j4;
                            j2 = addAndGet(-j5);
                        }
                    } else if (this.f15038c) {
                        return;
                    } else {
                        cVar.onNext(Long.valueOf(j4));
                        j5++;
                        j4++;
                    }
                }
            } while (j2 != 0);
        }
    }

    public t2(long j2, long j3) {
        this.a = j2;
        this.f15036b = j2 + j3;
    }

    @Override // h.c.h
    public void subscribeActual(k.a.c<? super Long> cVar) {
        if (cVar instanceof h.c.n0.c.a) {
            cVar.onSubscribe(new b((h.c.n0.c.a) cVar, this.a, this.f15036b));
        } else {
            cVar.onSubscribe(new c(cVar, this.a, this.f15036b));
        }
    }
}