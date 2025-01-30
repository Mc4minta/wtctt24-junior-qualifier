package androidx.core.util;

/* compiled from: Pair.java */
/* loaded from: classes.dex */
public class e<F, S> {
    public final F a;

    /* renamed from: b  reason: collision with root package name */
    public final S f1541b;

    public e(F f2, S s) {
        this.a = f2;
        this.f1541b = s;
    }

    public boolean equals(Object obj) {
        if (obj instanceof e) {
            e eVar = (e) obj;
            return d.a(eVar.a, this.a) && d.a(eVar.f1541b, this.f1541b);
        }
        return false;
    }

    public int hashCode() {
        F f2 = this.a;
        int hashCode = f2 == null ? 0 : f2.hashCode();
        S s = this.f1541b;
        return hashCode ^ (s != null ? s.hashCode() : 0);
    }

    public String toString() {
        return "Pair{" + this.a + " " + this.f1541b + "}";
    }
}