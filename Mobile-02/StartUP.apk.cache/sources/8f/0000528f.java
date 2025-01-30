package kotlin.l0;

/* compiled from: Regex.kt */
/* loaded from: classes3.dex */
public final class g {
    private final String a;

    /* renamed from: b  reason: collision with root package name */
    private final kotlin.i0.c f17363b;

    public g(String value, kotlin.i0.c range) {
        kotlin.jvm.internal.m.g(value, "value");
        kotlin.jvm.internal.m.g(range, "range");
        this.a = value;
        this.f17363b = range;
    }

    public final String a() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof g) {
                g gVar = (g) obj;
                return kotlin.jvm.internal.m.c(this.a, gVar.a) && kotlin.jvm.internal.m.c(this.f17363b, gVar.f17363b);
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        String str = this.a;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        kotlin.i0.c cVar = this.f17363b;
        return hashCode + (cVar != null ? cVar.hashCode() : 0);
    }

    public String toString() {
        return "MatchGroup(value=" + this.a + ", range=" + this.f17363b + ")";
    }
}