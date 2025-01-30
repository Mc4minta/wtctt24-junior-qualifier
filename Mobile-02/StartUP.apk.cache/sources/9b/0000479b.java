package e.g.a.c.i.v.j;

import java.util.Objects;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.datatransport:transport-runtime@@2.2.1 */
/* loaded from: classes2.dex */
public final class b extends i {
    private final long a;

    /* renamed from: b  reason: collision with root package name */
    private final e.g.a.c.i.l f13048b;

    /* renamed from: c  reason: collision with root package name */
    private final e.g.a.c.i.h f13049c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(long j2, e.g.a.c.i.l lVar, e.g.a.c.i.h hVar) {
        this.a = j2;
        Objects.requireNonNull(lVar, "Null transportContext");
        this.f13048b = lVar;
        Objects.requireNonNull(hVar, "Null event");
        this.f13049c = hVar;
    }

    @Override // e.g.a.c.i.v.j.i
    public e.g.a.c.i.h b() {
        return this.f13049c;
    }

    @Override // e.g.a.c.i.v.j.i
    public long c() {
        return this.a;
    }

    @Override // e.g.a.c.i.v.j.i
    public e.g.a.c.i.l d() {
        return this.f13048b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof i) {
            i iVar = (i) obj;
            return this.a == iVar.c() && this.f13048b.equals(iVar.d()) && this.f13049c.equals(iVar.b());
        }
        return false;
    }

    public int hashCode() {
        long j2 = this.a;
        return ((((((int) (j2 ^ (j2 >>> 32))) ^ 1000003) * 1000003) ^ this.f13048b.hashCode()) * 1000003) ^ this.f13049c.hashCode();
    }

    public String toString() {
        return "PersistedEvent{id=" + this.a + ", transportContext=" + this.f13048b + ", event=" + this.f13049c + "}";
    }
}