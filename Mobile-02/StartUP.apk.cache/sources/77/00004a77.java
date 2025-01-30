package e.j.m.a;

/* compiled from: SectionedCompactCoinAdapter.kt */
/* loaded from: classes2.dex */
public final class n implements p {
    private final String a;

    /* renamed from: b  reason: collision with root package name */
    private final k f13767b;

    public n(String text, k paddingType) {
        kotlin.jvm.internal.m.g(text, "text");
        kotlin.jvm.internal.m.g(paddingType, "paddingType");
        this.a = text;
        this.f13767b = paddingType;
    }

    public static /* synthetic */ n b(n nVar, String str, k kVar, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = nVar.a;
        }
        if ((i2 & 2) != 0) {
            kVar = nVar.f13767b;
        }
        return nVar.a(str, kVar);
    }

    public final n a(String text, k paddingType) {
        kotlin.jvm.internal.m.g(text, "text");
        kotlin.jvm.internal.m.g(paddingType, "paddingType");
        return new n(text, paddingType);
    }

    public final k c() {
        return this.f13767b;
    }

    public final String d() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof n) {
            n nVar = (n) obj;
            return kotlin.jvm.internal.m.c(this.a, nVar.a) && this.f13767b == nVar.f13767b;
        }
        return false;
    }

    public int hashCode() {
        return (this.a.hashCode() * 31) + this.f13767b.hashCode();
    }

    public String toString() {
        return "SectionTitle(text=" + this.a + ", paddingType=" + this.f13767b + ')';
    }
}