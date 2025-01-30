package e.g.a.c.i.w;

import f.c.h;

/* compiled from: com.google.android.datatransport:transport-runtime@@2.2.1 */
/* loaded from: classes2.dex */
public final class d implements f.c.d<a> {
    private static final d a = new d();

    public static d a() {
        return a;
    }

    public static a c() {
        return (a) h.c(b.b(), "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public a get() {
        return c();
    }
}