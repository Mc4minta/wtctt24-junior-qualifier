package e.g.a.c.i;

import javax.inject.Provider;

/* compiled from: com.google.android.datatransport:transport-runtime@@2.2.1 */
/* loaded from: classes2.dex */
public final class s implements f.c.d<q> {
    private final Provider<e.g.a.c.i.w.a> a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<e.g.a.c.i.w.a> f13017b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<e.g.a.c.i.v.e> f13018c;

    /* renamed from: d  reason: collision with root package name */
    private final Provider<com.google.android.datatransport.runtime.scheduling.jobscheduling.m> f13019d;

    /* renamed from: e  reason: collision with root package name */
    private final Provider<com.google.android.datatransport.runtime.scheduling.jobscheduling.q> f13020e;

    public s(Provider<e.g.a.c.i.w.a> provider, Provider<e.g.a.c.i.w.a> provider2, Provider<e.g.a.c.i.v.e> provider3, Provider<com.google.android.datatransport.runtime.scheduling.jobscheduling.m> provider4, Provider<com.google.android.datatransport.runtime.scheduling.jobscheduling.q> provider5) {
        this.a = provider;
        this.f13017b = provider2;
        this.f13018c = provider3;
        this.f13019d = provider4;
        this.f13020e = provider5;
    }

    public static s a(Provider<e.g.a.c.i.w.a> provider, Provider<e.g.a.c.i.w.a> provider2, Provider<e.g.a.c.i.v.e> provider3, Provider<com.google.android.datatransport.runtime.scheduling.jobscheduling.m> provider4, Provider<com.google.android.datatransport.runtime.scheduling.jobscheduling.q> provider5) {
        return new s(provider, provider2, provider3, provider4, provider5);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public q get() {
        return new q(this.a.get(), this.f13017b.get(), this.f13018c.get(), this.f13019d.get(), this.f13020e.get());
    }
}