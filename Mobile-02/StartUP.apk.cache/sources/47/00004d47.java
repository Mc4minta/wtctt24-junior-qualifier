package h.c.n0.e.b;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/* compiled from: FlowableInternalHelper.java */
/* loaded from: classes3.dex */
public final class r1 {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: FlowableInternalHelper.java */
    /* loaded from: classes3.dex */
    public static final class a<T> implements Callable<h.c.l0.a<T>> {
        private final h.c.h<T> a;

        /* renamed from: b  reason: collision with root package name */
        private final int f14904b;

        a(h.c.h<T> hVar, int i2) {
            this.a = hVar;
            this.f14904b = i2;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public h.c.l0.a<T> call() {
            return this.a.replay(this.f14904b);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: FlowableInternalHelper.java */
    /* loaded from: classes3.dex */
    public static final class b<T> implements Callable<h.c.l0.a<T>> {
        private final h.c.h<T> a;

        /* renamed from: b  reason: collision with root package name */
        private final int f14905b;

        /* renamed from: c  reason: collision with root package name */
        private final long f14906c;

        /* renamed from: d  reason: collision with root package name */
        private final TimeUnit f14907d;

        /* renamed from: e  reason: collision with root package name */
        private final h.c.a0 f14908e;

        b(h.c.h<T> hVar, int i2, long j2, TimeUnit timeUnit, h.c.a0 a0Var) {
            this.a = hVar;
            this.f14905b = i2;
            this.f14906c = j2;
            this.f14907d = timeUnit;
            this.f14908e = a0Var;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public h.c.l0.a<T> call() {
            return this.a.replay(this.f14905b, this.f14906c, this.f14907d, this.f14908e);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: FlowableInternalHelper.java */
    /* loaded from: classes3.dex */
    public static final class c<T, U> implements h.c.m0.n<T, k.a.b<U>> {
        private final h.c.m0.n<? super T, ? extends Iterable<? extends U>> a;

        c(h.c.m0.n<? super T, ? extends Iterable<? extends U>> nVar) {
            this.a = nVar;
        }

        @Override // h.c.m0.n
        /* renamed from: a */
        public k.a.b<U> apply(T t) throws Exception {
            return new i1((Iterable) h.c.n0.b.b.e(this.a.apply(t), "The mapper returned a null Iterable"));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: FlowableInternalHelper.java */
    /* loaded from: classes3.dex */
    public static final class d<U, R, T> implements h.c.m0.n<U, R> {
        private final h.c.m0.c<? super T, ? super U, ? extends R> a;

        /* renamed from: b  reason: collision with root package name */
        private final T f14909b;

        d(h.c.m0.c<? super T, ? super U, ? extends R> cVar, T t) {
            this.a = cVar;
            this.f14909b = t;
        }

        @Override // h.c.m0.n
        public R apply(U u) throws Exception {
            return this.a.apply((T) this.f14909b, u);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: FlowableInternalHelper.java */
    /* loaded from: classes3.dex */
    public static final class e<T, R, U> implements h.c.m0.n<T, k.a.b<R>> {
        private final h.c.m0.c<? super T, ? super U, ? extends R> a;

        /* renamed from: b  reason: collision with root package name */
        private final h.c.m0.n<? super T, ? extends k.a.b<? extends U>> f14910b;

        e(h.c.m0.c<? super T, ? super U, ? extends R> cVar, h.c.m0.n<? super T, ? extends k.a.b<? extends U>> nVar) {
            this.a = cVar;
            this.f14910b = nVar;
        }

        @Override // h.c.m0.n
        /* renamed from: a */
        public k.a.b<R> apply(T t) throws Exception {
            return new c2((k.a.b) h.c.n0.b.b.e(this.f14910b.apply(t), "The mapper returned a null Publisher"), new d(this.a, t));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: FlowableInternalHelper.java */
    /* loaded from: classes3.dex */
    public static final class f<T, U> implements h.c.m0.n<T, k.a.b<T>> {
        final h.c.m0.n<? super T, ? extends k.a.b<U>> a;

        f(h.c.m0.n<? super T, ? extends k.a.b<U>> nVar) {
            this.a = nVar;
        }

        @Override // h.c.m0.n
        /* renamed from: a */
        public k.a.b<T> apply(T t) throws Exception {
            return new d4((k.a.b) h.c.n0.b.b.e(this.a.apply(t), "The itemDelay returned a null Publisher"), 1L).map(h.c.n0.b.a.m(t)).defaultIfEmpty(t);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: FlowableInternalHelper.java */
    /* loaded from: classes3.dex */
    public static final class g<T> implements Callable<h.c.l0.a<T>> {
        private final h.c.h<T> a;

        g(h.c.h<T> hVar) {
            this.a = hVar;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public h.c.l0.a<T> call() {
            return this.a.replay();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: FlowableInternalHelper.java */
    /* loaded from: classes3.dex */
    public static final class h<T, R> implements h.c.m0.n<h.c.h<T>, k.a.b<R>> {
        private final h.c.m0.n<? super h.c.h<T>, ? extends k.a.b<R>> a;

        /* renamed from: b  reason: collision with root package name */
        private final h.c.a0 f14911b;

        h(h.c.m0.n<? super h.c.h<T>, ? extends k.a.b<R>> nVar, h.c.a0 a0Var) {
            this.a = nVar;
            this.f14911b = a0Var;
        }

        @Override // h.c.m0.n
        /* renamed from: a */
        public k.a.b<R> apply(h.c.h<T> hVar) throws Exception {
            return h.c.h.fromPublisher((k.a.b) h.c.n0.b.b.e(this.a.apply(hVar), "The selector returned a null Publisher")).observeOn(this.f14911b);
        }
    }

    /* compiled from: FlowableInternalHelper.java */
    /* loaded from: classes3.dex */
    public enum i implements h.c.m0.f<k.a.d> {
        INSTANCE;

        @Override // h.c.m0.f
        /* renamed from: h */
        public void accept(k.a.d dVar) throws Exception {
            dVar.request(Long.MAX_VALUE);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: FlowableInternalHelper.java */
    /* loaded from: classes3.dex */
    public static final class j<T, S> implements h.c.m0.c<S, h.c.g<T>, S> {
        final h.c.m0.b<S, h.c.g<T>> a;

        j(h.c.m0.b<S, h.c.g<T>> bVar) {
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
    /* compiled from: FlowableInternalHelper.java */
    /* loaded from: classes3.dex */
    public static final class k<T, S> implements h.c.m0.c<S, h.c.g<T>, S> {
        final h.c.m0.f<h.c.g<T>> a;

        k(h.c.m0.f<h.c.g<T>> fVar) {
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
    /* compiled from: FlowableInternalHelper.java */
    /* loaded from: classes3.dex */
    public static final class l<T> implements h.c.m0.a {
        final k.a.c<T> a;

        l(k.a.c<T> cVar) {
            this.a = cVar;
        }

        @Override // h.c.m0.a
        public void run() throws Exception {
            this.a.onComplete();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: FlowableInternalHelper.java */
    /* loaded from: classes3.dex */
    public static final class m<T> implements h.c.m0.f<Throwable> {
        final k.a.c<T> a;

        m(k.a.c<T> cVar) {
            this.a = cVar;
        }

        @Override // h.c.m0.f
        /* renamed from: a */
        public void accept(Throwable th) throws Exception {
            this.a.onError(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: FlowableInternalHelper.java */
    /* loaded from: classes3.dex */
    public static final class n<T> implements h.c.m0.f<T> {
        final k.a.c<T> a;

        n(k.a.c<T> cVar) {
            this.a = cVar;
        }

        @Override // h.c.m0.f
        public void accept(T t) throws Exception {
            this.a.onNext(t);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: FlowableInternalHelper.java */
    /* loaded from: classes3.dex */
    public static final class o<T> implements Callable<h.c.l0.a<T>> {
        private final h.c.h<T> a;

        /* renamed from: b  reason: collision with root package name */
        private final long f14913b;

        /* renamed from: c  reason: collision with root package name */
        private final TimeUnit f14914c;

        /* renamed from: d  reason: collision with root package name */
        private final h.c.a0 f14915d;

        o(h.c.h<T> hVar, long j2, TimeUnit timeUnit, h.c.a0 a0Var) {
            this.a = hVar;
            this.f14913b = j2;
            this.f14914c = timeUnit;
            this.f14915d = a0Var;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public h.c.l0.a<T> call() {
            return this.a.replay(this.f14913b, this.f14914c, this.f14915d);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: FlowableInternalHelper.java */
    /* loaded from: classes3.dex */
    public static final class p<T, R> implements h.c.m0.n<List<k.a.b<? extends T>>, k.a.b<? extends R>> {
        private final h.c.m0.n<? super Object[], ? extends R> a;

        p(h.c.m0.n<? super Object[], ? extends R> nVar) {
            this.a = nVar;
        }

        @Override // h.c.m0.n
        /* renamed from: a */
        public k.a.b<? extends R> apply(List<k.a.b<? extends T>> list) {
            return h.c.h.zipIterable(list, this.a, false, h.c.h.bufferSize());
        }
    }

    public static <T, U> h.c.m0.n<T, k.a.b<U>> a(h.c.m0.n<? super T, ? extends Iterable<? extends U>> nVar) {
        return new c(nVar);
    }

    public static <T, U, R> h.c.m0.n<T, k.a.b<R>> b(h.c.m0.n<? super T, ? extends k.a.b<? extends U>> nVar, h.c.m0.c<? super T, ? super U, ? extends R> cVar) {
        return new e(cVar, nVar);
    }

    public static <T, U> h.c.m0.n<T, k.a.b<T>> c(h.c.m0.n<? super T, ? extends k.a.b<U>> nVar) {
        return new f(nVar);
    }

    public static <T> Callable<h.c.l0.a<T>> d(h.c.h<T> hVar) {
        return new g(hVar);
    }

    public static <T> Callable<h.c.l0.a<T>> e(h.c.h<T> hVar, int i2) {
        return new a(hVar, i2);
    }

    public static <T> Callable<h.c.l0.a<T>> f(h.c.h<T> hVar, int i2, long j2, TimeUnit timeUnit, h.c.a0 a0Var) {
        return new b(hVar, i2, j2, timeUnit, a0Var);
    }

    public static <T> Callable<h.c.l0.a<T>> g(h.c.h<T> hVar, long j2, TimeUnit timeUnit, h.c.a0 a0Var) {
        return new o(hVar, j2, timeUnit, a0Var);
    }

    public static <T, R> h.c.m0.n<h.c.h<T>, k.a.b<R>> h(h.c.m0.n<? super h.c.h<T>, ? extends k.a.b<R>> nVar, h.c.a0 a0Var) {
        return new h(nVar, a0Var);
    }

    public static <T, S> h.c.m0.c<S, h.c.g<T>, S> i(h.c.m0.b<S, h.c.g<T>> bVar) {
        return new j(bVar);
    }

    public static <T, S> h.c.m0.c<S, h.c.g<T>, S> j(h.c.m0.f<h.c.g<T>> fVar) {
        return new k(fVar);
    }

    public static <T> h.c.m0.a k(k.a.c<T> cVar) {
        return new l(cVar);
    }

    public static <T> h.c.m0.f<Throwable> l(k.a.c<T> cVar) {
        return new m(cVar);
    }

    public static <T> h.c.m0.f<T> m(k.a.c<T> cVar) {
        return new n(cVar);
    }

    public static <T, R> h.c.m0.n<List<k.a.b<? extends T>>, k.a.b<? extends R>> n(h.c.m0.n<? super Object[], ? extends R> nVar) {
        return new p(nVar);
    }
}