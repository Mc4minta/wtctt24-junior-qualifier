package e.g.a.c.i.v;

import javax.inject.Provider;

/* compiled from: com.google.android.datatransport:transport-runtime@@2.2.1 */
/* loaded from: classes2.dex */
public final class g implements f.c.d<com.google.android.datatransport.runtime.scheduling.jobscheduling.g> {
    private final Provider<e.g.a.c.i.w.a> a;

    public g(Provider<e.g.a.c.i.w.a> provider) {
        this.a = provider;
    }

    public static com.google.android.datatransport.runtime.scheduling.jobscheduling.g a(e.g.a.c.i.w.a aVar) {
        return (com.google.android.datatransport.runtime.scheduling.jobscheduling.g) f.c.h.c(f.a(aVar), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static g b(Provider<e.g.a.c.i.w.a> provider) {
        return new g(provider);
    }

    @Override // javax.inject.Provider
    /* renamed from: c */
    public com.google.android.datatransport.runtime.scheduling.jobscheduling.g get() {
        return a(this.a.get());
    }
}