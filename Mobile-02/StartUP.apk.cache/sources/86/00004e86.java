package h.c.n0.e.e;

/* compiled from: ObservableRangeLong.java */
/* loaded from: classes3.dex */
public final class i2 extends h.c.s<Long> {
    private final long a;

    /* renamed from: b  reason: collision with root package name */
    private final long f15808b;

    /* compiled from: ObservableRangeLong.java */
    /* loaded from: classes3.dex */
    static final class a extends h.c.n0.d.b<Long> {
        final h.c.z<? super Long> a;

        /* renamed from: b  reason: collision with root package name */
        final long f15809b;

        /* renamed from: c  reason: collision with root package name */
        long f15810c;

        /* renamed from: d  reason: collision with root package name */
        boolean f15811d;

        a(h.c.z<? super Long> zVar, long j2, long j3) {
            this.a = zVar;
            this.f15810c = j2;
            this.f15809b = j3;
        }

        @Override // h.c.n0.c.j
        /* renamed from: a */
        public Long poll() throws Exception {
            long j2 = this.f15810c;
            if (j2 != this.f15809b) {
                this.f15810c = 1 + j2;
                return Long.valueOf(j2);
            }
            lazySet(1);
            return null;
        }

        @Override // h.c.n0.c.j
        public void clear() {
            this.f15810c = this.f15809b;
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
            return this.f15810c == this.f15809b;
        }

        @Override // h.c.n0.c.f
        public int n(int i2) {
            if ((i2 & 1) != 0) {
                this.f15811d = true;
                return 1;
            }
            return 0;
        }

        void run() {
            if (this.f15811d) {
                return;
            }
            h.c.z<? super Long> zVar = this.a;
            long j2 = this.f15809b;
            for (long j3 = this.f15810c; j3 != j2 && get() == 0; j3++) {
                zVar.onNext(Long.valueOf(j3));
            }
            if (get() == 0) {
                lazySet(1);
                zVar.onComplete();
            }
        }
    }

    public i2(long j2, long j3) {
        this.a = j2;
        this.f15808b = j3;
    }

    @Override // h.c.s
    protected void subscribeActual(h.c.z<? super Long> zVar) {
        long j2 = this.a;
        a aVar = new a(zVar, j2, j2 + this.f15808b);
        zVar.onSubscribe(aVar);
        aVar.run();
    }
}