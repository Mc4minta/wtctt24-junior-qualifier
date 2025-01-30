package e.g.a.c.i.w;

import f.c.h;

/* compiled from: com.google.android.datatransport:transport-runtime@@2.2.1 */
/* loaded from: classes2.dex */
public final class c implements f.c.d<a> {
    private static final c a = new c();

    public static c a() {
        return a;
    }

    public static a b() {
        return (a) h.c(b.a(), "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // javax.inject.Provider
    /* renamed from: c */
    public a get() {
        return b();
    }
}