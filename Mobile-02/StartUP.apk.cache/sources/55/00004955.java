package e.j.d.g;

import javax.inject.Provider;

/* compiled from: PinKeyHandler_Factory.java */
/* loaded from: classes2.dex */
public final class z implements f.c.d<y> {
    private final Provider<e.j.j.n> a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<e.j.d.f.e> f13579b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<e.j.d.f.c> f13580c;

    public z(Provider<e.j.j.n> provider, Provider<e.j.d.f.e> provider2, Provider<e.j.d.f.c> provider3) {
        this.a = provider;
        this.f13579b = provider2;
        this.f13580c = provider3;
    }

    public static z a(Provider<e.j.j.n> provider, Provider<e.j.d.f.e> provider2, Provider<e.j.d.f.c> provider3) {
        return new z(provider, provider2, provider3);
    }

    public static y c(e.j.j.n nVar, e.j.d.f.e eVar, e.j.d.f.c cVar) {
        return new y(nVar, eVar, cVar);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public y get() {
        return c(this.a.get(), this.f13579b.get(), this.f13580c.get());
    }
}