package e.j.i;

import javax.inject.Provider;

/* compiled from: BookmarkRepository_Factory.java */
/* loaded from: classes2.dex */
public final class v1 implements f.c.d<u1> {
    private final Provider<com.toshi.db.g.b> a;

    public v1(Provider<com.toshi.db.g.b> provider) {
        this.a = provider;
    }

    public static v1 a(Provider<com.toshi.db.g.b> provider) {
        return new v1(provider);
    }

    public static u1 c(com.toshi.db.g.b bVar) {
        return new u1(bVar);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public u1 get() {
        return c(this.a.get());
    }
}