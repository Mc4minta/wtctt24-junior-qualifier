package f.c;

import javax.inject.Provider;

/* compiled from: DoubleCheck.java */
/* loaded from: classes2.dex */
public final class c<T> implements Provider<T>, f.a<T> {
    private static final Object a = new Object();

    /* renamed from: b  reason: collision with root package name */
    private volatile Provider<T> f14009b;

    /* renamed from: c  reason: collision with root package name */
    private volatile Object f14010c = a;

    private c(Provider<T> provider) {
        this.f14009b = provider;
    }

    public static <P extends Provider<T>, T> f.a<T> a(P p) {
        if (p instanceof f.a) {
            return (f.a) p;
        }
        return new c((Provider) h.b(p));
    }

    public static <P extends Provider<T>, T> Provider<T> b(P p) {
        h.b(p);
        return p instanceof c ? p : new c(p);
    }

    public static Object c(Object obj, Object obj2) {
        if (!(obj != a) || obj == obj2) {
            return obj2;
        }
        throw new IllegalStateException("Scoped provider was invoked recursively returning different results: " + obj + " & " + obj2 + ". This is likely due to a circular dependency.");
    }

    @Override // javax.inject.Provider
    public T get() {
        T t = (T) this.f14010c;
        Object obj = a;
        if (t == obj) {
            synchronized (this) {
                t = this.f14010c;
                if (t == obj) {
                    t = this.f14009b.get();
                    this.f14010c = c(this.f14010c, t);
                    this.f14009b = null;
                }
            }
        }
        return t;
    }
}