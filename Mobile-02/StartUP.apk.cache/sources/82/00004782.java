package e.g.a.c.i;

import java.util.Set;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.datatransport:transport-runtime@@2.2.1 */
/* loaded from: classes2.dex */
public final class m implements e.g.a.c.g {
    private final Set<e.g.a.c.b> a;

    /* renamed from: b  reason: collision with root package name */
    private final l f13007b;

    /* renamed from: c  reason: collision with root package name */
    private final p f13008c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(Set<e.g.a.c.b> set, l lVar, p pVar) {
        this.a = set;
        this.f13007b = lVar;
        this.f13008c = pVar;
    }

    @Override // e.g.a.c.g
    public <T> e.g.a.c.f<T> a(String str, Class<T> cls, e.g.a.c.b bVar, e.g.a.c.e<T, byte[]> eVar) {
        if (this.a.contains(bVar)) {
            return new o(this.f13007b, str, bVar, eVar, this.f13008c);
        }
        throw new IllegalArgumentException(String.format("%s is not supported byt this factory. Supported encodings are: %s.", bVar, this.a));
    }
}