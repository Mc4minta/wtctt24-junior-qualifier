package h.c;

/* compiled from: Notification.java */
/* loaded from: classes2.dex */
public final class r<T> {
    static final r<Object> a = new r<>(null);

    /* renamed from: b  reason: collision with root package name */
    final Object f16797b;

    private r(Object obj) {
        this.f16797b = obj;
    }

    public static <T> r<T> a() {
        return (r<T>) a;
    }

    public static <T> r<T> b(Throwable th) {
        h.c.n0.b.b.e(th, "error is null");
        return new r<>(h.c.n0.j.m.A(th));
    }

    public static <T> r<T> c(T t) {
        h.c.n0.b.b.e(t, "value is null");
        return new r<>(t);
    }

    public Throwable d() {
        Object obj = this.f16797b;
        if (h.c.n0.j.m.E(obj)) {
            return h.c.n0.j.m.B(obj);
        }
        return null;
    }

    public T e() {
        Object obj = this.f16797b;
        if (obj == null || h.c.n0.j.m.E(obj)) {
            return null;
        }
        return (T) this.f16797b;
    }

    public boolean equals(Object obj) {
        if (obj instanceof r) {
            return h.c.n0.b.b.c(this.f16797b, ((r) obj).f16797b);
        }
        return false;
    }

    public boolean f() {
        return this.f16797b == null;
    }

    public boolean g() {
        return h.c.n0.j.m.E(this.f16797b);
    }

    public boolean h() {
        Object obj = this.f16797b;
        return (obj == null || h.c.n0.j.m.E(obj)) ? false : true;
    }

    public int hashCode() {
        Object obj = this.f16797b;
        if (obj != null) {
            return obj.hashCode();
        }
        return 0;
    }

    public String toString() {
        Object obj = this.f16797b;
        if (obj == null) {
            return "OnCompleteNotification";
        }
        if (h.c.n0.j.m.E(obj)) {
            return "OnErrorNotification[" + h.c.n0.j.m.B(obj) + "]";
        }
        return "OnNextNotification[" + this.f16797b + "]";
    }
}