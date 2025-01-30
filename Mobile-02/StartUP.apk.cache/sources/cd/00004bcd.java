package h.c.n0.b;

import io.reactivex.exceptions.OnErrorNotImplementedException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/* compiled from: Functions.java */
/* loaded from: classes.dex */
public final class a {
    static final h.c.m0.n<Object, Object> a = new w();

    /* renamed from: b  reason: collision with root package name */
    public static final Runnable f14095b = new r();

    /* renamed from: c  reason: collision with root package name */
    public static final h.c.m0.a f14096c = new o();

    /* renamed from: d  reason: collision with root package name */
    static final h.c.m0.f<Object> f14097d = new p();

    /* renamed from: e  reason: collision with root package name */
    public static final h.c.m0.f<Throwable> f14098e = new t();

    /* renamed from: f  reason: collision with root package name */
    public static final h.c.m0.f<Throwable> f14099f = new g0();

    /* renamed from: g  reason: collision with root package name */
    public static final h.c.m0.o f14100g = new q();

    /* renamed from: h  reason: collision with root package name */
    static final h.c.m0.p<Object> f14101h = new l0();

    /* renamed from: i  reason: collision with root package name */
    static final h.c.m0.p<Object> f14102i = new u();

    /* renamed from: j  reason: collision with root package name */
    static final Callable<Object> f14103j = new f0();

    /* renamed from: k  reason: collision with root package name */
    static final Comparator<Object> f14104k = new b0();

    /* renamed from: l  reason: collision with root package name */
    public static final h.c.m0.f<k.a.d> f14105l = new z();

    /* compiled from: Functions.java */
    /* renamed from: h.c.n0.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    static final class C0342a<T> implements h.c.m0.f<T> {
        final h.c.m0.a a;

        C0342a(h.c.m0.a aVar) {
            this.a = aVar;
        }

        @Override // h.c.m0.f
        public void accept(T t) throws Exception {
            this.a.run();
        }
    }

    /* compiled from: Functions.java */
    /* loaded from: classes.dex */
    enum a0 implements Comparator<Object> {
        INSTANCE;

        @Override // java.util.Comparator
        public int compare(Object obj, Object obj2) {
            return ((Comparable) obj).compareTo(obj2);
        }
    }

    /* compiled from: Functions.java */
    /* loaded from: classes.dex */
    static final class b<T1, T2, R> implements h.c.m0.n<Object[], R> {
        final h.c.m0.c<? super T1, ? super T2, ? extends R> a;

        b(h.c.m0.c<? super T1, ? super T2, ? extends R> cVar) {
            this.a = cVar;
        }

        @Override // h.c.m0.n
        /* renamed from: a */
        public R apply(Object[] objArr) throws Exception {
            if (objArr.length == 2) {
                return this.a.apply(objArr[0], objArr[1]);
            }
            throw new IllegalArgumentException("Array of size 2 expected but got " + objArr.length);
        }
    }

    /* compiled from: Functions.java */
    /* loaded from: classes.dex */
    static final class b0 implements Comparator<Object> {
        b0() {
        }

        @Override // java.util.Comparator
        public int compare(Object obj, Object obj2) {
            return ((Comparable) obj).compareTo(obj2);
        }
    }

    /* compiled from: Functions.java */
    /* loaded from: classes.dex */
    static final class c<T1, T2, T3, R> implements h.c.m0.n<Object[], R> {
        final h.c.m0.g<T1, T2, T3, R> a;

        c(h.c.m0.g<T1, T2, T3, R> gVar) {
            this.a = gVar;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // h.c.m0.n
        /* renamed from: a */
        public R apply(Object[] objArr) throws Exception {
            if (objArr.length == 3) {
                return (R) this.a.a(objArr[0], objArr[1], objArr[2]);
            }
            throw new IllegalArgumentException("Array of size 3 expected but got " + objArr.length);
        }
    }

    /* compiled from: Functions.java */
    /* loaded from: classes.dex */
    static final class c0<T> implements h.c.m0.a {
        final h.c.m0.f<? super h.c.r<T>> a;

        c0(h.c.m0.f<? super h.c.r<T>> fVar) {
            this.a = fVar;
        }

        @Override // h.c.m0.a
        public void run() throws Exception {
            this.a.accept(h.c.r.a());
        }
    }

    /* compiled from: Functions.java */
    /* loaded from: classes.dex */
    static final class d<T1, T2, T3, T4, R> implements h.c.m0.n<Object[], R> {
        final h.c.m0.h<T1, T2, T3, T4, R> a;

        d(h.c.m0.h<T1, T2, T3, T4, R> hVar) {
            this.a = hVar;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // h.c.m0.n
        /* renamed from: a */
        public R apply(Object[] objArr) throws Exception {
            if (objArr.length == 4) {
                return (R) this.a.apply(objArr[0], objArr[1], objArr[2], objArr[3]);
            }
            throw new IllegalArgumentException("Array of size 4 expected but got " + objArr.length);
        }
    }

    /* compiled from: Functions.java */
    /* loaded from: classes.dex */
    static final class d0<T> implements h.c.m0.f<Throwable> {
        final h.c.m0.f<? super h.c.r<T>> a;

        d0(h.c.m0.f<? super h.c.r<T>> fVar) {
            this.a = fVar;
        }

        @Override // h.c.m0.f
        /* renamed from: a */
        public void accept(Throwable th) throws Exception {
            this.a.accept(h.c.r.b(th));
        }
    }

    /* compiled from: Functions.java */
    /* loaded from: classes.dex */
    static final class e<T1, T2, T3, T4, T5, R> implements h.c.m0.n<Object[], R> {
        private final h.c.m0.i<T1, T2, T3, T4, T5, R> a;

        e(h.c.m0.i<T1, T2, T3, T4, T5, R> iVar) {
            this.a = iVar;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // h.c.m0.n
        /* renamed from: a */
        public R apply(Object[] objArr) throws Exception {
            if (objArr.length == 5) {
                return (R) this.a.apply(objArr[0], objArr[1], objArr[2], objArr[3], objArr[4]);
            }
            throw new IllegalArgumentException("Array of size 5 expected but got " + objArr.length);
        }
    }

    /* compiled from: Functions.java */
    /* loaded from: classes.dex */
    static final class e0<T> implements h.c.m0.f<T> {
        final h.c.m0.f<? super h.c.r<T>> a;

        e0(h.c.m0.f<? super h.c.r<T>> fVar) {
            this.a = fVar;
        }

        @Override // h.c.m0.f
        public void accept(T t) throws Exception {
            this.a.accept(h.c.r.c(t));
        }
    }

    /* compiled from: Functions.java */
    /* loaded from: classes.dex */
    static final class f<T1, T2, T3, T4, T5, T6, R> implements h.c.m0.n<Object[], R> {
        final h.c.m0.j<T1, T2, T3, T4, T5, T6, R> a;

        f(h.c.m0.j<T1, T2, T3, T4, T5, T6, R> jVar) {
            this.a = jVar;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // h.c.m0.n
        /* renamed from: a */
        public R apply(Object[] objArr) throws Exception {
            if (objArr.length == 6) {
                return (R) this.a.apply(objArr[0], objArr[1], objArr[2], objArr[3], objArr[4], objArr[5]);
            }
            throw new IllegalArgumentException("Array of size 6 expected but got " + objArr.length);
        }
    }

    /* compiled from: Functions.java */
    /* loaded from: classes.dex */
    static final class f0 implements Callable<Object> {
        f0() {
        }

        @Override // java.util.concurrent.Callable
        public Object call() {
            return null;
        }
    }

    /* compiled from: Functions.java */
    /* loaded from: classes.dex */
    static final class g<T1, T2, T3, T4, T5, T6, T7, R> implements h.c.m0.n<Object[], R> {
        final h.c.m0.k<T1, T2, T3, T4, T5, T6, T7, R> a;

        g(h.c.m0.k<T1, T2, T3, T4, T5, T6, T7, R> kVar) {
            this.a = kVar;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // h.c.m0.n
        /* renamed from: a */
        public R apply(Object[] objArr) throws Exception {
            if (objArr.length == 7) {
                return (R) this.a.apply(objArr[0], objArr[1], objArr[2], objArr[3], objArr[4], objArr[5], objArr[6]);
            }
            throw new IllegalArgumentException("Array of size 7 expected but got " + objArr.length);
        }
    }

    /* compiled from: Functions.java */
    /* loaded from: classes.dex */
    static final class g0 implements h.c.m0.f<Throwable> {
        g0() {
        }

        @Override // h.c.m0.f
        /* renamed from: a */
        public void accept(Throwable th) {
            h.c.r0.a.u(new OnErrorNotImplementedException(th));
        }
    }

    /* compiled from: Functions.java */
    /* loaded from: classes.dex */
    static final class h<T1, T2, T3, T4, T5, T6, T7, T8, R> implements h.c.m0.n<Object[], R> {
        final h.c.m0.l<T1, T2, T3, T4, T5, T6, T7, T8, R> a;

        h(h.c.m0.l<T1, T2, T3, T4, T5, T6, T7, T8, R> lVar) {
            this.a = lVar;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // h.c.m0.n
        /* renamed from: a */
        public R apply(Object[] objArr) throws Exception {
            if (objArr.length == 8) {
                return (R) this.a.a(objArr[0], objArr[1], objArr[2], objArr[3], objArr[4], objArr[5], objArr[6], objArr[7]);
            }
            throw new IllegalArgumentException("Array of size 8 expected but got " + objArr.length);
        }
    }

    /* compiled from: Functions.java */
    /* loaded from: classes.dex */
    static final class h0<T> implements h.c.m0.n<T, h.c.u0.b<T>> {
        final TimeUnit a;

        /* renamed from: b  reason: collision with root package name */
        final h.c.a0 f14107b;

        h0(TimeUnit timeUnit, h.c.a0 a0Var) {
            this.a = timeUnit;
            this.f14107b = a0Var;
        }

        @Override // h.c.m0.n
        /* renamed from: a */
        public h.c.u0.b<T> apply(T t) throws Exception {
            return new h.c.u0.b<>(t, this.f14107b.b(this.a), this.a);
        }
    }

    /* compiled from: Functions.java */
    /* loaded from: classes.dex */
    static final class i<T1, T2, T3, T4, T5, T6, T7, T8, T9, R> implements h.c.m0.n<Object[], R> {
        final h.c.m0.m<T1, T2, T3, T4, T5, T6, T7, T8, T9, R> a;

        i(h.c.m0.m<T1, T2, T3, T4, T5, T6, T7, T8, T9, R> mVar) {
            this.a = mVar;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // h.c.m0.n
        /* renamed from: a */
        public R apply(Object[] objArr) throws Exception {
            if (objArr.length == 9) {
                return (R) this.a.a(objArr[0], objArr[1], objArr[2], objArr[3], objArr[4], objArr[5], objArr[6], objArr[7], objArr[8]);
            }
            throw new IllegalArgumentException("Array of size 9 expected but got " + objArr.length);
        }
    }

    /* compiled from: Functions.java */
    /* loaded from: classes.dex */
    static final class i0<K, T> implements h.c.m0.b<Map<K, T>, T> {
        private final h.c.m0.n<? super T, ? extends K> a;

        i0(h.c.m0.n<? super T, ? extends K> nVar) {
            this.a = nVar;
        }

        @Override // h.c.m0.b
        /* renamed from: b */
        public void a(Map<K, T> map, T t) throws Exception {
            map.put(this.a.apply(t), t);
        }
    }

    /* compiled from: Functions.java */
    /* loaded from: classes.dex */
    static final class j<T> implements Callable<List<T>> {
        final int a;

        j(int i2) {
            this.a = i2;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public List<T> call() throws Exception {
            return new ArrayList(this.a);
        }
    }

    /* compiled from: Functions.java */
    /* loaded from: classes.dex */
    static final class j0<K, V, T> implements h.c.m0.b<Map<K, V>, T> {
        private final h.c.m0.n<? super T, ? extends V> a;

        /* renamed from: b  reason: collision with root package name */
        private final h.c.m0.n<? super T, ? extends K> f14108b;

        j0(h.c.m0.n<? super T, ? extends V> nVar, h.c.m0.n<? super T, ? extends K> nVar2) {
            this.a = nVar;
            this.f14108b = nVar2;
        }

        @Override // h.c.m0.b
        /* renamed from: b */
        public void a(Map<K, V> map, T t) throws Exception {
            map.put(this.f14108b.apply(t), this.a.apply(t));
        }
    }

    /* compiled from: Functions.java */
    /* loaded from: classes.dex */
    static final class k<T> implements h.c.m0.p<T> {
        final h.c.m0.e a;

        k(h.c.m0.e eVar) {
            this.a = eVar;
        }

        @Override // h.c.m0.p
        public boolean test(T t) throws Exception {
            return !this.a.a();
        }
    }

    /* compiled from: Functions.java */
    /* loaded from: classes.dex */
    static final class k0<K, V, T> implements h.c.m0.b<Map<K, Collection<V>>, T> {
        private final h.c.m0.n<? super K, ? extends Collection<? super V>> a;

        /* renamed from: b  reason: collision with root package name */
        private final h.c.m0.n<? super T, ? extends V> f14109b;

        /* renamed from: c  reason: collision with root package name */
        private final h.c.m0.n<? super T, ? extends K> f14110c;

        k0(h.c.m0.n<? super K, ? extends Collection<? super V>> nVar, h.c.m0.n<? super T, ? extends V> nVar2, h.c.m0.n<? super T, ? extends K> nVar3) {
            this.a = nVar;
            this.f14109b = nVar2;
            this.f14110c = nVar3;
        }

        @Override // h.c.m0.b
        /* renamed from: b */
        public void a(Map<K, Collection<V>> map, T t) throws Exception {
            K apply = this.f14110c.apply(t);
            Collection<? super V> collection = map.get(apply);
            if (collection == null) {
                collection = this.a.apply(apply);
                map.put(apply, collection);
            }
            collection.add(this.f14109b.apply(t));
        }
    }

    /* compiled from: Functions.java */
    /* loaded from: classes.dex */
    public static class l implements h.c.m0.f<k.a.d> {
        final int a;

        l(int i2) {
            this.a = i2;
        }

        @Override // h.c.m0.f
        /* renamed from: a */
        public void accept(k.a.d dVar) throws Exception {
            dVar.request(this.a);
        }
    }

    /* compiled from: Functions.java */
    /* loaded from: classes.dex */
    static final class l0 implements h.c.m0.p<Object> {
        l0() {
        }

        @Override // h.c.m0.p
        public boolean test(Object obj) {
            return true;
        }
    }

    /* compiled from: Functions.java */
    /* loaded from: classes.dex */
    static final class m<T, U> implements h.c.m0.n<T, U> {
        final Class<U> a;

        m(Class<U> cls) {
            this.a = cls;
        }

        @Override // h.c.m0.n
        public U apply(T t) throws Exception {
            return this.a.cast(t);
        }
    }

    /* compiled from: Functions.java */
    /* loaded from: classes.dex */
    static final class n<T, U> implements h.c.m0.p<T> {
        final Class<U> a;

        n(Class<U> cls) {
            this.a = cls;
        }

        @Override // h.c.m0.p
        public boolean test(T t) throws Exception {
            return this.a.isInstance(t);
        }
    }

    /* compiled from: Functions.java */
    /* loaded from: classes.dex */
    static final class o implements h.c.m0.a {
        o() {
        }

        @Override // h.c.m0.a
        public void run() {
        }

        public String toString() {
            return "EmptyAction";
        }
    }

    /* compiled from: Functions.java */
    /* loaded from: classes.dex */
    static final class p implements h.c.m0.f<Object> {
        p() {
        }

        @Override // h.c.m0.f
        public void accept(Object obj) {
        }

        public String toString() {
            return "EmptyConsumer";
        }
    }

    /* compiled from: Functions.java */
    /* loaded from: classes.dex */
    static final class q implements h.c.m0.o {
        q() {
        }

        @Override // h.c.m0.o
        public void a(long j2) {
        }
    }

    /* compiled from: Functions.java */
    /* loaded from: classes.dex */
    static final class r implements Runnable {
        r() {
        }

        @Override // java.lang.Runnable
        public void run() {
        }

        public String toString() {
            return "EmptyRunnable";
        }
    }

    /* compiled from: Functions.java */
    /* loaded from: classes.dex */
    static final class s<T> implements h.c.m0.p<T> {
        final T a;

        s(T t) {
            this.a = t;
        }

        @Override // h.c.m0.p
        public boolean test(T t) throws Exception {
            return h.c.n0.b.b.c(t, this.a);
        }
    }

    /* compiled from: Functions.java */
    /* loaded from: classes.dex */
    static final class t implements h.c.m0.f<Throwable> {
        t() {
        }

        @Override // h.c.m0.f
        /* renamed from: a */
        public void accept(Throwable th) {
            h.c.r0.a.u(th);
        }
    }

    /* compiled from: Functions.java */
    /* loaded from: classes.dex */
    static final class u implements h.c.m0.p<Object> {
        u() {
        }

        @Override // h.c.m0.p
        public boolean test(Object obj) {
            return false;
        }
    }

    /* compiled from: Functions.java */
    /* loaded from: classes.dex */
    enum v implements Callable<Set<Object>> {
        INSTANCE;

        @Override // java.util.concurrent.Callable
        /* renamed from: h */
        public Set<Object> call() throws Exception {
            return new HashSet();
        }
    }

    /* compiled from: Functions.java */
    /* loaded from: classes.dex */
    static final class w implements h.c.m0.n<Object, Object> {
        w() {
        }

        @Override // h.c.m0.n
        public Object apply(Object obj) {
            return obj;
        }

        public String toString() {
            return "IdentityFunction";
        }
    }

    /* compiled from: Functions.java */
    /* loaded from: classes.dex */
    static final class x<T, U> implements Callable<U>, h.c.m0.n<T, U> {
        final U a;

        x(U u) {
            this.a = u;
        }

        @Override // h.c.m0.n
        public U apply(T t) throws Exception {
            return this.a;
        }

        @Override // java.util.concurrent.Callable
        public U call() throws Exception {
            return this.a;
        }
    }

    /* compiled from: Functions.java */
    /* loaded from: classes.dex */
    static final class y<T> implements h.c.m0.n<List<T>, List<T>> {
        final Comparator<? super T> a;

        y(Comparator<? super T> comparator) {
            this.a = comparator;
        }

        @Override // h.c.m0.n
        /* renamed from: a */
        public List<T> apply(List<T> list) {
            Collections.sort(list, this.a);
            return list;
        }
    }

    /* compiled from: Functions.java */
    /* loaded from: classes.dex */
    static final class z implements h.c.m0.f<k.a.d> {
        z() {
        }

        @Override // h.c.m0.f
        /* renamed from: a */
        public void accept(k.a.d dVar) throws Exception {
            dVar.request(Long.MAX_VALUE);
        }
    }

    public static <T1, T2, T3, T4, T5, T6, R> h.c.m0.n<Object[], R> A(h.c.m0.j<T1, T2, T3, T4, T5, T6, R> jVar) {
        h.c.n0.b.b.e(jVar, "f is null");
        return new f(jVar);
    }

    public static <T1, T2, T3, T4, T5, T6, T7, R> h.c.m0.n<Object[], R> B(h.c.m0.k<T1, T2, T3, T4, T5, T6, T7, R> kVar) {
        h.c.n0.b.b.e(kVar, "f is null");
        return new g(kVar);
    }

    public static <T1, T2, T3, T4, T5, T6, T7, T8, R> h.c.m0.n<Object[], R> C(h.c.m0.l<T1, T2, T3, T4, T5, T6, T7, T8, R> lVar) {
        h.c.n0.b.b.e(lVar, "f is null");
        return new h(lVar);
    }

    public static <T1, T2, T3, T4, T5, T6, T7, T8, T9, R> h.c.m0.n<Object[], R> D(h.c.m0.m<T1, T2, T3, T4, T5, T6, T7, T8, T9, R> mVar) {
        h.c.n0.b.b.e(mVar, "f is null");
        return new i(mVar);
    }

    public static <T, K> h.c.m0.b<Map<K, T>, T> E(h.c.m0.n<? super T, ? extends K> nVar) {
        return new i0(nVar);
    }

    public static <T, K, V> h.c.m0.b<Map<K, V>, T> F(h.c.m0.n<? super T, ? extends K> nVar, h.c.m0.n<? super T, ? extends V> nVar2) {
        return new j0(nVar2, nVar);
    }

    public static <T, K, V> h.c.m0.b<Map<K, Collection<V>>, T> G(h.c.m0.n<? super T, ? extends K> nVar, h.c.m0.n<? super T, ? extends V> nVar2, h.c.m0.n<? super K, ? extends Collection<? super V>> nVar3) {
        return new k0(nVar3, nVar2, nVar);
    }

    public static <T> h.c.m0.f<T> a(h.c.m0.a aVar) {
        return new C0342a(aVar);
    }

    public static <T> h.c.m0.p<T> b() {
        return (h.c.m0.p<T>) f14102i;
    }

    public static <T> h.c.m0.p<T> c() {
        return (h.c.m0.p<T>) f14101h;
    }

    public static <T> h.c.m0.f<T> d(int i2) {
        return new l(i2);
    }

    public static <T, U> h.c.m0.n<T, U> e(Class<U> cls) {
        return new m(cls);
    }

    public static <T> Callable<List<T>> f(int i2) {
        return new j(i2);
    }

    public static <T> Callable<Set<T>> g() {
        return v.INSTANCE;
    }

    public static <T> h.c.m0.f<T> h() {
        return (h.c.m0.f<T>) f14097d;
    }

    public static <T> h.c.m0.p<T> i(T t2) {
        return new s(t2);
    }

    public static <T> h.c.m0.n<T, T> j() {
        return (h.c.m0.n<T, T>) a;
    }

    public static <T, U> h.c.m0.p<T> k(Class<U> cls) {
        return new n(cls);
    }

    public static <T> Callable<T> l(T t2) {
        return new x(t2);
    }

    public static <T, U> h.c.m0.n<T, U> m(U u2) {
        return new x(u2);
    }

    public static <T> h.c.m0.n<List<T>, List<T>> n(Comparator<? super T> comparator) {
        return new y(comparator);
    }

    public static <T> Comparator<T> o() {
        return a0.INSTANCE;
    }

    public static <T> Comparator<T> p() {
        return (Comparator<T>) f14104k;
    }

    public static <T> h.c.m0.a q(h.c.m0.f<? super h.c.r<T>> fVar) {
        return new c0(fVar);
    }

    public static <T> h.c.m0.f<Throwable> r(h.c.m0.f<? super h.c.r<T>> fVar) {
        return new d0(fVar);
    }

    public static <T> h.c.m0.f<T> s(h.c.m0.f<? super h.c.r<T>> fVar) {
        return new e0(fVar);
    }

    public static <T> Callable<T> t() {
        return (Callable<T>) f14103j;
    }

    public static <T> h.c.m0.p<T> u(h.c.m0.e eVar) {
        return new k(eVar);
    }

    public static <T> h.c.m0.n<T, h.c.u0.b<T>> v(TimeUnit timeUnit, h.c.a0 a0Var) {
        return new h0(timeUnit, a0Var);
    }

    public static <T1, T2, R> h.c.m0.n<Object[], R> w(h.c.m0.c<? super T1, ? super T2, ? extends R> cVar) {
        h.c.n0.b.b.e(cVar, "f is null");
        return new b(cVar);
    }

    public static <T1, T2, T3, R> h.c.m0.n<Object[], R> x(h.c.m0.g<T1, T2, T3, R> gVar) {
        h.c.n0.b.b.e(gVar, "f is null");
        return new c(gVar);
    }

    public static <T1, T2, T3, T4, R> h.c.m0.n<Object[], R> y(h.c.m0.h<T1, T2, T3, T4, R> hVar) {
        h.c.n0.b.b.e(hVar, "f is null");
        return new d(hVar);
    }

    public static <T1, T2, T3, T4, T5, R> h.c.m0.n<Object[], R> z(h.c.m0.i<T1, T2, T3, T4, T5, R> iVar) {
        h.c.n0.b.b.e(iVar, "f is null");
        return new e(iVar);
    }
}