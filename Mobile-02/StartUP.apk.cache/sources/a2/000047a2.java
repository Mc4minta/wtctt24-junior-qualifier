package e.g.a.c.i.v.j;

import javax.inject.Provider;

/* compiled from: com.google.android.datatransport:transport-runtime@@2.2.1 */
/* loaded from: classes2.dex */
public final class c0 implements f.c.d<b0> {
    private final Provider<e.g.a.c.i.w.a> a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<e.g.a.c.i.w.a> f13055b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<d> f13056c;

    /* renamed from: d  reason: collision with root package name */
    private final Provider<h0> f13057d;

    public c0(Provider<e.g.a.c.i.w.a> provider, Provider<e.g.a.c.i.w.a> provider2, Provider<d> provider3, Provider<h0> provider4) {
        this.a = provider;
        this.f13055b = provider2;
        this.f13056c = provider3;
        this.f13057d = provider4;
    }

    public static c0 a(Provider<e.g.a.c.i.w.a> provider, Provider<e.g.a.c.i.w.a> provider2, Provider<d> provider3, Provider<h0> provider4) {
        return new c0(provider, provider2, provider3, provider4);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public b0 get() {
        return new b0(this.a.get(), this.f13055b.get(), this.f13056c.get(), this.f13057d.get());
    }
}