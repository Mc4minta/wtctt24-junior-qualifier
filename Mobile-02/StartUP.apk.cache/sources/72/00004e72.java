package h.c.n0.e.e;

/* compiled from: ObservableRange.java */
/* loaded from: classes3.dex */
public final class h2 extends h.c.s<Integer> {
    private final int a;

    /* renamed from: b  reason: collision with root package name */
    private final long f15744b;

    /* compiled from: ObservableRange.java */
    /* loaded from: classes3.dex */
    static final class a extends h.c.n0.d.b<Integer> {
        final h.c.z<? super Integer> a;

        /* renamed from: b  reason: collision with root package name */
        final long f15745b;

        /* renamed from: c  reason: collision with root package name */
        long f15746c;

        /* renamed from: d  reason: collision with root package name */
        boolean f15747d;

        a(h.c.z<? super Integer> zVar, long j2, long j3) {
            this.a = zVar;
            this.f15746c = j2;
            this.f15745b = j3;
        }

        @Override // h.c.n0.c.j
        /* renamed from: a */
        public Integer poll() throws Exception {
            long j2 = this.f15746c;
            if (j2 != this.f15745b) {
                this.f15746c = 1 + j2;
                return Integer.valueOf((int) j2);
            }
            lazySet(1);
            return null;
        }

        @Override // h.c.n0.c.j
        public void clear() {
            this.f15746c = this.f15745b;
            lazySet(1);
        }

        @Override // h.c.k0.b
        public void dispose() {
            set(1);
        }

        @Override // h.c.k0.b
        public boolean isDisposed() {
            return get() != 0;
        }

        @Override // h.c.n0.c.j
        public boolean isEmpty() {
            return this.f15746c == this.f15745b;
        }

        @Override // h.c.n0.c.f
        public int n(int i2) {
            if ((i2 & 1) != 0) {
                this.f15747d = true;
                return 1;
            }
            return 0;
        }

        void run() {
            if (this.f15747d) {
                return;
            }
            h.c.z<? super Integer> zVar = this.a;
            long j2 = this.f15745b;
            for (long j3 = this.f15746c; j3 != j2 && get() == 0; j3++) {
                zVar.onNext(Integer.valueOf((int) j3));
            }
            if (get() == 0) {
                lazySet(1);
                zVar.onComplete();
            }
        }
    }

    public h2(int i2, int i3) {
        this.a = i2;
        this.f15744b = i2 + i3;
    }

    @Override // h.c.s
    protected void subscribeActual(h.c.z<? super Integer> zVar) {
        a aVar = new a(zVar, this.a, this.f15744b);
        zVar.onSubscribe(aVar);
        aVar.run();
    }
}