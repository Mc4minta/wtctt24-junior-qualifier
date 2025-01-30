package h.c.n0.e.b;

/* compiled from: FlowableRange.java */
/* loaded from: classes3.dex */
public final class s2 extends h.c.h<Integer> {
    final int a;

    /* renamed from: b  reason: collision with root package name */
    final int f14983b;

    /* compiled from: FlowableRange.java */
    /* loaded from: classes3.dex */
    static abstract class a extends h.c.n0.i.b<Integer> {
        final int a;

        /* renamed from: b  reason: collision with root package name */
        int f14984b;

        /* renamed from: c  reason: collision with root package name */
        volatile boolean f14985c;

        a(int i2, int i3) {
            this.f14984b = i2;
            this.a = i3;
        }

        abstract void a();

        @Override // h.c.n0.c.j
        /* renamed from: b */
        public final Integer poll() {
            int i2 = this.f14984b;
            if (i2 == this.a) {
                return null;
            }
            this.f14984b = i2 + 1;
            return Integer.valueOf(i2);
        }

        abstract void c(long j2);

        @Override // k.a.d
        public final void cancel() {
            this.f14985c = true;
        }

        @Override // h.c.n0.c.j
        public final void clear() {
            this.f14984b = this.a;
        }

        @Override // h.c.n0.c.j
        public final boolean isEmpty() {
            return this.f14984b == this.a;
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

    /* compiled from: FlowableRange.java */
    /* loaded from: classes3.dex */
    static final class b extends a {

        /* renamed from: d  reason: collision with root package name */
        final h.c.n0.c.a<? super Integer> f14986d;

        b(h.c.n0.c.a<? super Integer> aVar, int i2, int i3) {
            super(i2, i3);
            this.f14986d = aVar;
        }

        @Override // h.c.n0.e.b.s2.a
        void a() {
            int i2 = this.a;
            h.c.n0.c.a<? super Integer> aVar = this.f14986d;
            for (int i3 = this.f14984b; i3 != i2; i3++) {
                if (this.f14985c) {
                    return;
                }
                aVar.h(Integer.valueOf(i3));
            }
            if (this.f14985c) {
                return;
            }
            aVar.onComplete();
        }

        @Override // h.c.n0.e.b.s2.a
        void c(long j2) {
            int i2 = this.a;
            int i3 = this.f14984b;
            h.c.n0.c.a<? super Integer> aVar = this.f14986d;
            do {
                long j3 = 0;
                while (true) {
                    if (j3 == j2 || i3 == i2) {
                        if (i3 == i2) {
                            if (this.f14985c) {
                                return;
                            }
                            aVar.onComplete();
                            return;
                        }
                        j2 = get();
                        if (j3 == j2) {
                            this.f14984b = i3;
                            j2 = addAndGet(-j3);
                        }
                    } else if (this.f14985c) {
                        return;
                    } else {
                        if (aVar.h(Integer.valueOf(i3))) {
                            j3++;
                        }
                        i3++;
                    }
                }
            } while (j2 != 0);
        }
    }

    /* compiled from: FlowableRange.java */
    /* loaded from: classes3.dex */
    static final class c extends a {

        /* renamed from: d  reason: collision with root package name */
        final k.a.c<? super Integer> f14987d;

        c(k.a.c<? super Integer> cVar, int i2, int i3) {
            super(i2, i3);
            this.f14987d = cVar;
        }

        @Override // h.c.n0.e.b.s2.a
        void a() {
            int i2 = this.a;
            k.a.c<? super Integer> cVar = this.f14987d;
            for (int i3 = this.f14984b; i3 != i2; i3++) {
                if (this.f14985c) {
                    return;
                }
                cVar.onNext(Integer.valueOf(i3));
            }
            if (this.f14985c) {
                return;
            }
            cVar.onComplete();
        }

        @Override // h.c.n0.e.b.s2.a
        void c(long j2) {
            int i2 = this.a;
            int i3 = this.f14984b;
            k.a.c<? super Integer> cVar = this.f14987d;
            do {
                long j3 = 0;
                while (true) {
                    if (j3 == j2 || i3 == i2) {
                        if (i3 == i2) {
                            if (this.f14985c) {
                                return;
                            }
                            cVar.onComplete();
                            return;
                        }
                        j2 = get();
                        if (j3 == j2) {
                            this.f14984b = i3;
                            j2 = addAndGet(-j3);
                        }
                    } else if (this.f14985c) {
                        return;
                    } else {
                        cVar.onNext(Integer.valueOf(i3));
                        j3++;
                        i3++;
                    }
                }
            } while (j2 != 0);
        }
    }

    public s2(int i2, int i3) {
        this.a = i2;
        this.f14983b = i2 + i3;
    }

    @Override // h.c.h
    public void subscribeActual(k.a.c<? super Integer> cVar) {
        if (cVar instanceof h.c.n0.c.a) {
            cVar.onSubscribe(new b((h.c.n0.c.a) cVar, this.a, this.f14983b));
        } else {
            cVar.onSubscribe(new c(cVar, this.a, this.f14983b));
        }
    }
}