package e.g.a.c.i.v.j;

/* compiled from: com.google.android.datatransport:transport-runtime@@2.2.1 */
/* loaded from: classes2.dex */
public final class f implements f.c.d<String> {
    private static final f a = new f();

    public static f a() {
        return a;
    }

    public static String b() {
        return (String) f.c.h.c(e.a(), "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // javax.inject.Provider
    /* renamed from: c */
    public String get() {
        return b();
    }
}