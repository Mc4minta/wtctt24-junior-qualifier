package f.c;

/* compiled from: InstanceFactory.java */
/* loaded from: classes2.dex */
public final class e<T> implements d<T>, f.a<T> {
    private static final e<Object> a = new e<>(null);

    /* renamed from: b  reason: collision with root package name */
    private final T f14011b;

    private e(T t) {
        this.f14011b = t;
    }

    public static <T> d<T> a(T t) {
        return new e(h.c(t, "instance cannot be null"));
    }

    @Override // javax.inject.Provider
    public T get() {
        return this.f14011b;
    }
}