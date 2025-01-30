package e.j.m.a;

import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: SectionedCompactCoinAdapter.kt */
/* loaded from: classes2.dex */
public final class i implements p {
    private final String a;

    public i() {
        this(null, 1, null);
    }

    public i(String str) {
        this.a = str;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof i) && kotlin.jvm.internal.m.c(this.a, ((i) obj).a);
    }

    public int hashCode() {
        String str = this.a;
        if (str == null) {
            return 0;
        }
        return str.hashCode();
    }

    public String toString() {
        return "NoResultsCell(msg=" + ((Object) this.a) + ')';
    }

    public /* synthetic */ i(String str, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? "" : str);
    }
}