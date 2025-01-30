package e.g.a.c;

import java.util.Objects;

/* compiled from: com.google.android.datatransport:transport-api@@2.2.0 */
/* loaded from: classes2.dex */
public final class b {
    private final String a;

    private b(String str) {
        Objects.requireNonNull(str, "name is null");
        this.a = str;
    }

    public static b b(String str) {
        return new b(str);
    }

    public String a() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof b) {
            return this.a.equals(((b) obj).a);
        }
        return false;
    }

    public int hashCode() {
        return this.a.hashCode() ^ 1000003;
    }

    public String toString() {
        return "Encoding{name=\"" + this.a + "\"}";
    }
}