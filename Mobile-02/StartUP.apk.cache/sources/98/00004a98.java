package e.j.n;

/* compiled from: NetworkSwitcherViewModel.kt */
/* loaded from: classes2.dex */
public final class a3 implements r2 {
    private final String a;

    public a3(String title) {
        kotlin.jvm.internal.m.g(title, "title");
        this.a = title;
    }

    public final String a() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof a3) && kotlin.jvm.internal.m.c(this.a, ((a3) obj).a);
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    public String toString() {
        return "SectionHeader(title=" + this.a + ')';
    }
}