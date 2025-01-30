package e.j.d.f;

import javax.inject.Provider;

/* compiled from: Encryptor_Factory.java */
/* loaded from: classes2.dex */
public final class f implements f.c.d<e> {
    private final Provider<a> a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<e.j.l.o.a> f13535b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<e.j.l.p.b> f13536c;

    public f(Provider<a> provider, Provider<e.j.l.o.a> provider2, Provider<e.j.l.p.b> provider3) {
        this.a = provider;
        this.f13535b = provider2;
        this.f13536c = provider3;
    }

    public static f a(Provider<a> provider, Provider<e.j.l.o.a> provider2, Provider<e.j.l.p.b> provider3) {
        return new f(provider, provider2, provider3);
    }

    public static e c(a aVar, e.j.l.o.a aVar2, e.j.l.p.b bVar) {
        return new e(aVar, aVar2, bVar);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public e get() {
        return c(this.a.get(), this.f13535b.get(), this.f13536c.get());
    }
}