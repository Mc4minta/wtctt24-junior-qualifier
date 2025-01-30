package e.a.a.w;

/* compiled from: MutablePair.java */
/* loaded from: classes.dex */
public class i<T> {
    T a;

    /* renamed from: b  reason: collision with root package name */
    T f11768b;

    private static boolean a(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    public void b(T t, T t2) {
        this.a = t;
        this.f11768b = t2;
    }

    public boolean equals(Object obj) {
        if (obj instanceof androidx.core.util.e) {
            androidx.core.util.e eVar = (androidx.core.util.e) obj;
            return a(eVar.a, this.a) && a(eVar.f1541b, this.f11768b);
        }
        return false;
    }

    public int hashCode() {
        T t = this.a;
        int hashCode = t == null ? 0 : t.hashCode();
        T t2 = this.f11768b;
        return hashCode ^ (t2 != null ? t2.hashCode() : 0);
    }

    public String toString() {
        return "Pair{" + String.valueOf(this.a) + " " + String.valueOf(this.f11768b) + "}";
    }
}