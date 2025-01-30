package h.c.n0.e.e;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/* compiled from: ObservableInternalHelper.java */
/* loaded from: classes3.dex */
public final class n1 {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ObservableInternalHelper.java */
    /* loaded from: classes3.dex */
    public static final class a<T> implements Callable<h.c.o0.a<T>> {
        private final h.c.s<T> a;

        /* renamed from: b  reason: collision with root package name */
        private final int f15993b;

        a(h.c.s<T> sVar, int i2) {
            this.a = sVar;
            this.f15993b = i2;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public h.c.o0.a<T> call() {
            return this.a.replay(this.f15993b);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ObservableInternalHelper.java */
    /* loaded from: classes3.dex */
    public static final class b<T> implements Callable<h.c.o0.a<T>> {
        private final h.c.s<T> a;

        /* renamed from: b  reason: collision with root package name */
        private final int f15994b;

        /* renamed from: c  reason: collision with root package name */
        private final long f15995c;

        /* renamed from: d  reason: collision with root package name */
        private final TimeUnit f15996d;

        /* renamed from: e  reason: collision with root package name */
        private final h.c.a0 f15997e;

        b(h.c.s<T> sVar, int i2, long j2, TimeUnit timeUnit, h.c.a0 a0Var) {
            this.a = sVar;
            this.f15994b = i2;
            this.f15995c = j2;
            this.f15996d = timeUnit;
            this.f15997e = a0Var;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public h.c.o0.a<T> call() {
            return this.a.replay(this.f15994b, this.f15995c, this.f15996d, this.f15997e);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ObservableInternalHelper.java */
    /* loaded from: classes3.dex */
    public static final class c<T, U> implements h.c.m0.n<T, h.c.x<U>> {
        private final h.c.m0.n<? super T, ? extends Iterable<? extends U>> a;

        c(h.c.m0.n<? super T, ? extends Iterable<? extends U>> nVar) {
            this.a = nVar;
        }

        @Override // h.c.m0.n
        /* renamed from: a */
        public h.c.x<U> apply(T t) throws Exception {
            return new e1((Iterable) h.c.n0.b.b.e(this.a.apply(t), "The mapper returned a null Iterable"));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ObservableInternalHelper.java */
    /* loaded from: classes3.dex */
    public static final class d<U, R, T> implements h.c.m0.n<U, R> {
        private final h.c.m0.c<? super T, ? super U, ? extends R> a;

        /* renamed from: b  reason: collision with root package name */
        private final T f15998b;

        d(h.c.m0.c<? super T, ? super U, ? extends R> cVar, T t) {
            this.a = cVar;
            this.f15998b = t;
        }

        @Override // h.c.m0.n
        public R apply(U u) throws Exception {
            return this.a.apply((T) this.f15998b, u);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ObservableInternalHelper.java */
    /* loaded from: classes3.dex */
    public static final class e<T, R, U> implements h.c.m0.n<T, h.c.x<R>> {
        private final h.c.m0.c<? super T, ? super U, ? extends R> a;

        /* renamed from: b  reason: collision with root package name */
        private final h.c.m0.n<? super T, ? extends h.c.x<? extends U>> f15999b;

        e(h.c.m0.c<? super T, ? super U, ? extends R> cVar, h.c.m0.n<? super T, ? extends h.c.x<? extends U>> nVar) {
            this.a = cVar;
            this.f15999b = nVar;
        }

        @Override // h.c.m0.n
        /* renamed from: a */
        public h.c.x<R> apply(T t) throws Exception {
            return new v1((h.c.x) h.c.n0.b.b.e(this.f15999b.apply(t), "The mapper returned a null ObservableSource"), new d(this.a, t));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ObservableInternalHelper.java */
    /* loaded from: classes3.dex */
    public static final class f<T, U> implements h.c.m0.n<T, h.c.x<T>> {
        final h.c.m0.n<? super T, ? extends h.c.x<U>> a;

        f(h.c.m0.n<? super T, ? extends h.c.x<U>> nVar) {
            this.a = nVar;
        }

        @Override // h.c.m0.n
        /* renamed from: a */
        public h.c.x<T> apply(T t) throws Exception {
            return new m3((h.c.x) h.c.n0.b.b.e(this.a.apply(t), "The itemDelay returned a null ObservableSource"), 1L).map(h.c.n0.b.a.m(t)).defaultIfEmpty(t);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ObservableInternalHelper.java */
    /* loaded from: classes3.dex */
    public static final class g<T> implements h.c.m0.a {
        final h.c.z<T> a;

        g(h.c.z<T> zVar) {
            this.a = zVar;
        }

        @Override // h.c.m0.a
        public void run() throws Exception {
            this.a.onComplete();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ObservableInternalHelper.java */
    /* loaded from: classes3.dex */
    public static final class h<T> implements h.c.m0.f<Throwable> {
        final h.c.z<T> a;

        h(h.c.z<T> zVar) {
            this.a = zVar;
        }

        @Override // h.c.m0.f
        /* renamed from: a */
        public void accept(Throwable th) throws Exception {
            this.a.onError(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ObservableInternalHelper.java */
    /* loaded from: classes3.dex */
    public static final class i<T> implements h.c.m0.f<T> {
        final h.c.z<T> a;

        i(h.c.z<T> zVar) {
            this.a = zVar;
        }

        @Override // h.c.m0.f
        public void accept(T t) throws Exception {
            this.a.onNext(t);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ObservableInternalHelper.java */
    /* loaded from: classes3.dex */
    public static final class j<T> implements Callable<h.c.o0.a<T>> {
        private final h.c.s<T> a;

        j(h.c.s<T> sVar) {
            this.a = sVar;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public h.c.o0.a<T> call() {
            return this.a.replay();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ObservableInternalHelper.java */
    /* loaded from: classes3.dex */
    public static final class k<T, R> implements h.c.m0.n<h.c.s<T>, h.c.x<R>> {
        private final h.c.m0.n<? super h.c.s<T>, ? extends h.c.x<R>> a;

        /* renamed from: b  reason: collision with root package name */
        private final h.c.a0 f16000b;

        k(h.c.m0.n<? super h.c.s<T>, ? extends h.c.x<R>> nVar, h.c.a0 a0Var) {
            this.a = nVar;
            this.f16000b = a0Var;
        }

        @Override // h.c.m0.n
        /* renamed from: a */
        public h.c.x<R> apply(h.c.s<T> sVar) throws Exception {
            return h.c.s.wrap((h.c.x) h.c.n0.b.b.e(this.a.apply(sVar), "The selector returned a null ObservableSource")).observeOn(this.f16000b);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ObservableInternalHelper.java */
    /* loaded from: classes3.dex */
    public static final class l<T, S> implements h.c.m0.c<S, h.c.g<T>, S> {
        final h.c.m0.b<S, h.c.g<T>> a;

        l(h.c.m0.b<S, h.c.g<T>> bVar) {
            this.a = bVar;
        }

        @Override // h.c.m0.c
        /* renamed from: a */
        public S apply(S s, h.c.g<T> gVar) throws Exception {
            this.a.a(s, gVar);
            return s;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ObservableInternalHelper.java */
    /* loaded from: classes3.dex */
    public static final class m<T, S> implements h.c.m0.c<S, h.c.g<T>, S> {
        final h.c.m0.f<h.c.g<T>> a;

        m(h.c.m0.f<h.c.g<T>> fVar) {
            this.a = fVar;
        }

        @Override // h.c.m0.c
        /* renamed from: a */
        public S apply(S s, h.c.g<T> gVar) throws Exception {
            this.a.accept(gVar);
            return s;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ObservableInternalHelper.java */
    /* loaded from: classes3.dex */
    public static final class n<T> implements Callable<h.c.o0.a<T>> {
        private final h.c.s<T> a;

        /* renamed from: b  reason: collision with root package name */
        private final long f16001b;

        /* renamed from: c  reason: collision with root package name */
        private final TimeUnit f16002c;

        /* renamed from: d  reason: collision with root package name */
        private final h.c.a0 f16003d;

        n(h.c.s<T> sVar, long j2, TimeUnit timeUnit, h.c.a0 a0Var) {
            this.a = sVar;
            this.f16001b = j2;
            this.f16002c = timeUnit;
            this.f16003d = a0Var;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public h.c.o0.a<T> call() {
            return this.a.replay(this.f16001b, this.f16002c, this.f16003d);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ObservableInternalHelper.java */
    /* loaded from: classes3.dex */
    public static final class o<T, R> implements h.c.m0.n<List<h.c.x<? extends T>>, h.c.x<? extends R>> {
        private final h.c.m0.n<? super Object[], ? extends R> a;

        o(h.c.m0.n<? super Object[], ? extends R> nVar) {
            this.a = nVar;
        }

        @Override // h.c.m0.n
        /* renamed from: a */
        public h.c.x<? extends R> apply(List<h.c.x<? extends T>> list) {
            return h.c.s.zipIterable(list, this.a, false, h.c.s.bufferSize());
        }
    }

    public static <T, U> h.c.m0.n<T, h.c.x<U>> a(h.c.m0.n<? super T, ? extends Iterable<? extends U>> nVar) {
        return new c(nVar);
    }

    public static <T, U, R> h.c.m0.n<T, h.c.x<R>> b(h.c.m0.n<? super T, ? extends h.c.x<? extends U>> nVar, h.c.m0.c<? super T, ? super U, ? extends R> cVar) {
        return new e(cVar, nVar);
    }

    public static <T, U> h.c.m0.n<T, h.c.x<T>> c(h.c.m0.n<? super T, ? extends h.c.x<U>> nVar) {
        return new f(nVar);
    }

    public static <T> h.c.m0.a d(h.c.z<T> zVar) {
        return new g(zVar);
    }

    public static <T> h.c.m0.f<Throwable> e(h.c.z<T> zVar) {
        return new h(zVar);
    }

    public static <T> h.c.m0.f<T> f(h.c.z<T> zVar) {
        return new i(zVar);
    }

    public static <T> Callable<h.c.o0.a<T>> g(h.c.s<T> sVar) {
        return new j(sVar);
    }

    public static <T> Callable<h.c.o0.a<T>> h(h.c.s<T> sVar, int i2) {
        return new a(sVar, i2);
    }

    public static <T> Callable<h.c.o0.a<T>> i(h.c.s<T> sVar, int i2, long j2, TimeUnit timeUnit, h.c.a0 a0Var) {
        return new b(sVar, i2, j2, timeUnit, a0Var);
    }

    public static <T> Callable<h.c.o0.a<T>> j(h.c.s<T> sVar, long j2, TimeUnit timeUnit, h.c.a0 a0Var) {
        return new n(sVar, j2, timeUnit, a0Var);
    }

    public static <T, R> h.c.m0.n<h.c.s<T>, h.c.x<R>> k(h.c.m0.n<? super h.c.s<T>, ? extends h.c.x<R>> nVar, h.c.a0 a0Var) {
        return new k(nVar, a0Var);
    }

    public static <T, S> h.c.m0.c<S, h.c.g<T>, S> l(h.c.m0.b<S, h.c.g<T>> bVar) {
        return new l(bVar);
    }

    public static <T, S> h.c.m0.c<S, h.c.g<T>, S> m(h.c.m0.f<h.c.g<T>> fVar) {
        return new m(fVar);
    }

    public static <T, R> h.c.m0.n<List<h.c.x<? extends T>>, h.c.x<? extends R>> n(h.c.m0.n<? super Object[], ? extends R> nVar) {
        return new o(nVar);
    }
}