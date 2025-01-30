package e.j.n;

import javax.inject.Provider;

/* compiled from: ViewErc721TokensViewModel_Factory.java */
/* loaded from: classes2.dex */
public final class l3 implements f.c.d<k3> {
    private final Provider<e.j.i.y1> a;

    public l3(Provider<e.j.i.y1> provider) {
        this.a = provider;
    }

    public static l3 a(Provider<e.j.i.y1> provider) {
        return new l3(provider);
    }

    public static k3 c(e.j.i.y1 y1Var) {
        return new k3(y1Var);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public k3 get() {
        return c(this.a.get());
    }
}