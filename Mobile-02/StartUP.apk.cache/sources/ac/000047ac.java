package e.g.a.c.i.v.j;

/* compiled from: com.google.android.datatransport:transport-runtime@@2.2.1 */
/* loaded from: classes2.dex */
public final class h implements f.c.d<d> {
    private static final h a = new h();

    public static h a() {
        return a;
    }

    public static d c() {
        return (d) f.c.h.c(e.c(), "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public d get() {
        return c();
    }
}