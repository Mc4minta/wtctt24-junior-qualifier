package h.c.n0.e.e;

/* compiled from: ObservableFromArray.java */
/* loaded from: classes3.dex */
public final class b1<T> extends h.c.s<T> {
    final T[] a;

    /* compiled from: ObservableFromArray.java */
    /* loaded from: classes3.dex */
    static final class a<T> extends h.c.n0.d.c<T> {
        final h.c.z<? super T> a;

        /* renamed from: b  reason: collision with root package name */
        final T[] f15523b;

        /* renamed from: c  reason: collision with root package name */
        int f15524c;

        /* renamed from: d  reason: collision with root package name */
        boolean f15525d;

        /* renamed from: e  reason: collision with root package name */
        volatile boolean f15526e;

        a(h.c.z<? super T> zVar, T[] tArr) {
            this.a = zVar;
            this.f15523b = tArr;
        }

        void a() {
            T[] tArr = this.f15523b;
            int length = tArr.length;
            for (int i2 = 0; i2 < length && !isDisposed(); i2++) {
                T t = tArr[i2];
                if (t == null) {
                    h.c.z<? super T> zVar = this.a;
                    zVar.onError(new NullPointerException("The element at index " + i2 + " is null"));
                    return;
                }
                this.a.onNext(t);
            }
            if (isDisposed()) {
                return;
            }
            this.a.onComplete();
        }

        @Override // h.c.n0.c.j
        public void clear() {
            this.f15524c = this.f15523b.length;
        }

        @Override // h.c.k0.b
        public void dispose() {
            this.f15526e = true;
        }

        @Override // h.c.k0.b
        public boolean isDisposed() {
            return this.f15526e;
        }

        @Override // h.c.n0.c.j
        public boolean isEmpty() {
            return this.f15524c == this.f15523b.length;
        }

        @Override // h.c.n0.c.f
        public int n(int i2) {
            if ((i2 & 1) != 0) {
                this.f15525d = true;
                return 1;
            }
            return 0;
        }

        @Override // h.c.n0.c.j
        public T poll() {
            int i2 = this.f15524c;
            T[] tArr = this.f15523b;
            if (i2 != tArr.length) {
                this.f15524c = i2 + 1;
                return (T) h.c.n0.b.b.e(tArr[i2], "The array element is null");
            }
            return null;
        }
    }

    public b1(T[] tArr) {
        this.a = tArr;
    }

    @Override // h.c.s
    public void subscribeActual(h.c.z<? super T> zVar) {
        a aVar = new a(zVar, this.a);
        zVar.onSubscribe(aVar);
        if (aVar.f15525d) {
            return;
        }
        aVar.a();
    }
}