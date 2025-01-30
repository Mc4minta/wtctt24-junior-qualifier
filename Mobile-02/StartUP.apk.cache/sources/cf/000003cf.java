package androidx.recyclerview.widget;

import androidx.recyclerview.widget.h;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/* compiled from: AsyncDifferConfig.java */
/* loaded from: classes.dex */
public final class c<T> {
    private final Executor a;

    /* renamed from: b  reason: collision with root package name */
    private final Executor f2092b;

    /* renamed from: c  reason: collision with root package name */
    private final h.d<T> f2093c;

    /* compiled from: AsyncDifferConfig.java */
    /* loaded from: classes.dex */
    public static final class a<T> {
        private static final Object a = new Object();

        /* renamed from: b  reason: collision with root package name */
        private static Executor f2094b;

        /* renamed from: c  reason: collision with root package name */
        private Executor f2095c;

        /* renamed from: d  reason: collision with root package name */
        private Executor f2096d;

        /* renamed from: e  reason: collision with root package name */
        private final h.d<T> f2097e;

        public a(h.d<T> dVar) {
            this.f2097e = dVar;
        }

        public c<T> a() {
            if (this.f2096d == null) {
                synchronized (a) {
                    if (f2094b == null) {
                        f2094b = Executors.newFixedThreadPool(2);
                    }
                }
                this.f2096d = f2094b;
            }
            return new c<>(this.f2095c, this.f2096d, this.f2097e);
        }
    }

    c(Executor executor, Executor executor2, h.d<T> dVar) {
        this.a = executor;
        this.f2092b = executor2;
        this.f2093c = dVar;
    }

    public Executor a() {
        return this.f2092b;
    }

    public h.d<T> b() {
        return this.f2093c;
    }

    public Executor c() {
        return this.a;
    }
}