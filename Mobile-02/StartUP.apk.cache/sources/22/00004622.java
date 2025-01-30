package e.f.j.d;

/* compiled from: InstrumentedMemoryCache.java */
/* loaded from: classes2.dex */
public class o<K, V> implements p<K, V> {
    private final p<K, V> a;

    /* renamed from: b  reason: collision with root package name */
    private final r f12457b;

    public o(p<K, V> pVar, r rVar) {
        this.a = pVar;
        this.f12457b = rVar;
    }

    @Override // e.f.j.d.p
    public com.facebook.common.references.a<V> a(K k2, com.facebook.common.references.a<V> aVar) {
        this.f12457b.b();
        return this.a.a(k2, aVar);
    }

    @Override // e.f.j.d.p
    public int b(e.f.d.c.j<K> jVar) {
        return this.a.b(jVar);
    }

    @Override // e.f.j.d.p
    public boolean c(e.f.d.c.j<K> jVar) {
        return this.a.c(jVar);
    }

    @Override // e.f.j.d.p
    public com.facebook.common.references.a<V> get(K k2) {
        com.facebook.common.references.a<V> aVar = this.a.get(k2);
        if (aVar == null) {
            this.f12457b.c();
        } else {
            this.f12457b.a(k2);
        }
        return aVar;
    }
}