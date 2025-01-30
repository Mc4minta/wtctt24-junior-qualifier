package e.g.a.c.i.v;

import android.content.Context;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.s;
import javax.inject.Provider;

/* compiled from: com.google.android.datatransport:transport-runtime@@2.2.1 */
/* loaded from: classes2.dex */
public final class i implements f.c.d<s> {
    private final Provider<Context> a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<e.g.a.c.i.v.j.c> f13035b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<com.google.android.datatransport.runtime.scheduling.jobscheduling.g> f13036c;

    /* renamed from: d  reason: collision with root package name */
    private final Provider<e.g.a.c.i.w.a> f13037d;

    public i(Provider<Context> provider, Provider<e.g.a.c.i.v.j.c> provider2, Provider<com.google.android.datatransport.runtime.scheduling.jobscheduling.g> provider3, Provider<e.g.a.c.i.w.a> provider4) {
        this.a = provider;
        this.f13035b = provider2;
        this.f13036c = provider3;
        this.f13037d = provider4;
    }

    public static i a(Provider<Context> provider, Provider<e.g.a.c.i.v.j.c> provider2, Provider<com.google.android.datatransport.runtime.scheduling.jobscheduling.g> provider3, Provider<e.g.a.c.i.w.a> provider4) {
        return new i(provider, provider2, provider3, provider4);
    }

    public static s c(Context context, e.g.a.c.i.v.j.c cVar, com.google.android.datatransport.runtime.scheduling.jobscheduling.g gVar, e.g.a.c.i.w.a aVar) {
        return (s) f.c.h.c(h.a(context, cVar, gVar, aVar), "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public s get() {
        return c(this.a.get(), this.f13035b.get(), this.f13036c.get(), this.f13037d.get());
    }
}