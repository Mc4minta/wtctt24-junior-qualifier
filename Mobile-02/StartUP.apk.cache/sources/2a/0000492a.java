package e.j.d.f;

import javax.inject.Provider;

/* compiled from: Decryptor_Factory.java */
/* loaded from: classes2.dex */
public final class d implements f.c.d<c> {
    private final Provider<a> a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<e.j.l.o.a> f13530b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<e.j.l.p.b> f13531c;

    public d(Provider<a> provider, Provider<e.j.l.o.a> provider2, Provider<e.j.l.p.b> provider3) {
        this.a = provider;
        this.f13530b = provider2;
        this.f13531c = provider3;
    }

    public static d a(Provider<a> provider, Provider<e.j.l.o.a> provider2, Provider<e.j.l.p.b> provider3) {
        return new d(provider, provider2, provider3);
    }

    public static c c(a aVar, e.j.l.o.a aVar2, e.j.l.p.b bVar) {
        return new c(aVar, aVar2, bVar);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public c get() {
        return c(this.a.get(), this.f13530b.get(), this.f13531c.get());
    }
}