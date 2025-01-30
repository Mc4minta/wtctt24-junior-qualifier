package e.g.a.c.i.v.j;

/* compiled from: com.google.android.datatransport:transport-runtime@@2.2.1 */
/* loaded from: classes2.dex */
public final class g implements f.c.d<Integer> {
    private static final g a = new g();

    public static g a() {
        return a;
    }

    public static int c() {
        return e.b();
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public Integer get() {
        return Integer.valueOf(c());
    }
}