package e.g.a.c.i;

import java.util.Arrays;
import java.util.Objects;

/* compiled from: com.google.android.datatransport:transport-runtime@@2.2.1 */
/* loaded from: classes2.dex */
public final class g {
    private final e.g.a.c.b a;

    /* renamed from: b  reason: collision with root package name */
    private final byte[] f13006b;

    public g(e.g.a.c.b bVar, byte[] bArr) {
        Objects.requireNonNull(bVar, "encoding is null");
        Objects.requireNonNull(bArr, "bytes is null");
        this.a = bVar;
        this.f13006b = bArr;
    }

    public byte[] a() {
        return this.f13006b;
    }

    public e.g.a.c.b b() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof g) {
            g gVar = (g) obj;
            if (this.a.equals(gVar.a)) {
                return Arrays.equals(this.f13006b, gVar.f13006b);
            }
            return false;
        }
        return false;
    }

    public int hashCode() {
        return ((this.a.hashCode() ^ 1000003) * 1000003) ^ Arrays.hashCode(this.f13006b);
    }

    public String toString() {
        return "EncodedPayload{encoding=" + this.a + ", bytes=[...]}";
    }
}