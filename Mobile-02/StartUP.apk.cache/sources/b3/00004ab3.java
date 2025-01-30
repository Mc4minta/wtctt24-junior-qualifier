package e.j.n;

import javax.inject.Provider;

/* compiled from: CollectibleTypesTabViewModel_Factory.java */
/* loaded from: classes2.dex */
public final class e2 implements f.c.d<d2> {
    private final Provider<e.j.i.w1> a;

    public e2(Provider<e.j.i.w1> provider) {
        this.a = provider;
    }

    public static e2 a(Provider<e.j.i.w1> provider) {
        return new e2(provider);
    }

    public static d2 c(e.j.i.w1 w1Var) {
        return new d2(w1Var);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public d2 get() {
        return c(this.a.get());
    }
}