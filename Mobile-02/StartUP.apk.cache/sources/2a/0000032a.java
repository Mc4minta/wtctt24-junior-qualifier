package androidx.lifecycle;

/* compiled from: LiveDataReactiveStreams.java */
/* loaded from: classes.dex */
public final class s {

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: LiveDataReactiveStreams.java */
    /* loaded from: classes.dex */
    public static final class a<T> implements k.a.b<T> {
        final o a;

        /* renamed from: b  reason: collision with root package name */
        final LiveData<T> f1800b;

        /* compiled from: LiveDataReactiveStreams.java */
        /* renamed from: androidx.lifecycle.s$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        static final class C0033a<T> implements k.a.d, v<T> {
            final k.a.c<? super T> a;

            /* renamed from: b  reason: collision with root package name */
            final o f1801b;

            /* renamed from: c  reason: collision with root package name */
            final LiveData<T> f1802c;

            /* renamed from: d  reason: collision with root package name */
            volatile boolean f1803d;

            /* renamed from: e  reason: collision with root package name */
            boolean f1804e;

            /* renamed from: f  reason: collision with root package name */
            long f1805f;

            /* renamed from: g  reason: collision with root package name */
            T f1806g;

            /* compiled from: LiveDataReactiveStreams.java */
            /* renamed from: androidx.lifecycle.s$a$a$a  reason: collision with other inner class name */
            /* loaded from: classes.dex */
            class RunnableC0034a implements Runnable {
                final /* synthetic */ long a;

                RunnableC0034a(long j2) {
                    this.a = j2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    if (C0033a.this.f1803d) {
                        return;
                    }
                    long j2 = this.a;
                    if (j2 <= 0) {
                        C0033a.this.f1803d = true;
                        C0033a c0033a = C0033a.this;
                        if (c0033a.f1804e) {
                            c0033a.f1802c.k(c0033a);
                            C0033a.this.f1804e = false;
                        }
                        C0033a c0033a2 = C0033a.this;
                        c0033a2.f1806g = null;
                        c0033a2.a.onError(new IllegalArgumentException("Non-positive request"));
                        return;
                    }
                    C0033a c0033a3 = C0033a.this;
                    long j3 = c0033a3.f1805f;
                    c0033a3.f1805f = j3 + j2 >= j3 ? j3 + j2 : Long.MAX_VALUE;
                    if (!c0033a3.f1804e) {
                        c0033a3.f1804e = true;
                        c0033a3.f1802c.g(c0033a3.f1801b, c0033a3);
                        return;
                    }
                    T t = c0033a3.f1806g;
                    if (t != null) {
                        c0033a3.a(t);
                        C0033a.this.f1806g = null;
                    }
                }
            }

            /* compiled from: LiveDataReactiveStreams.java */
            /* renamed from: androidx.lifecycle.s$a$a$b */
            /* loaded from: classes.dex */
            class b implements Runnable {
                b() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    C0033a c0033a = C0033a.this;
                    if (c0033a.f1804e) {
                        c0033a.f1802c.k(c0033a);
                        C0033a.this.f1804e = false;
                    }
                    C0033a.this.f1806g = null;
                }
            }

            C0033a(k.a.c<? super T> cVar, o oVar, LiveData<T> liveData) {
                this.a = cVar;
                this.f1801b = oVar;
                this.f1802c = liveData;
            }

            @Override // androidx.lifecycle.v
            public void a(T t) {
                if (this.f1803d) {
                    return;
                }
                if (this.f1805f > 0) {
                    this.f1806g = null;
                    this.a.onNext(t);
                    long j2 = this.f1805f;
                    if (j2 != Long.MAX_VALUE) {
                        this.f1805f = j2 - 1;
                        return;
                    }
                    return;
                }
                this.f1806g = t;
            }

            @Override // k.a.d
            public void cancel() {
                if (this.f1803d) {
                    return;
                }
                this.f1803d = true;
                c.b.a.a.a.f().b(new b());
            }

            @Override // k.a.d
            public void request(long j2) {
                if (this.f1803d) {
                    return;
                }
                c.b.a.a.a.f().b(new RunnableC0034a(j2));
            }
        }

        a(o oVar, LiveData<T> liveData) {
            this.a = oVar;
            this.f1800b = liveData;
        }

        @Override // k.a.b
        public void subscribe(k.a.c<? super T> cVar) {
            cVar.onSubscribe(new C0033a(cVar, this.a, this.f1800b));
        }
    }

    public static <T> k.a.b<T> a(o oVar, LiveData<T> liveData) {
        return new a(oVar, liveData);
    }
}