package e.j.d.f;

/* compiled from: CipherGenerator_Factory.java */
/* loaded from: classes2.dex */
public final class b implements f.c.d<e.j.d.f.a> {

    /* compiled from: CipherGenerator_Factory.java */
    /* loaded from: classes2.dex */
    private static final class a {
        private static final b a = new b();
    }

    public static b a() {
        return a.a;
    }

    public static e.j.d.f.a c() {
        return new e.j.d.f.a();
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public e.j.d.f.a get() {
        return c();
    }
}