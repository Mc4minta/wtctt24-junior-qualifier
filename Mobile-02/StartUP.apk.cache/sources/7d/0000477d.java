package e.g.a.c.i;

import java.util.concurrent.Executor;

/* compiled from: com.google.android.datatransport:transport-runtime@@2.2.1 */
/* loaded from: classes2.dex */
public final class j implements f.c.d<Executor> {
    private static final j a = new j();

    public static j a() {
        return a;
    }

    public static Executor b() {
        return (Executor) f.c.h.c(i.a(), "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // javax.inject.Provider
    /* renamed from: c */
    public Executor get() {
        return b();
    }
}