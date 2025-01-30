package e.g.a.c.i.v.j;

import android.content.Context;
import javax.inject.Provider;

/* compiled from: com.google.android.datatransport:transport-runtime@@2.2.1 */
/* loaded from: classes2.dex */
public final class i0 implements f.c.d<h0> {
    private final Provider<Context> a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<String> f13065b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<Integer> f13066c;

    public i0(Provider<Context> provider, Provider<String> provider2, Provider<Integer> provider3) {
        this.a = provider;
        this.f13065b = provider2;
        this.f13066c = provider3;
    }

    public static i0 a(Provider<Context> provider, Provider<String> provider2, Provider<Integer> provider3) {
        return new i0(provider, provider2, provider3);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public h0 get() {
        return new h0(this.a.get(), this.f13065b.get(), this.f13066c.get().intValue());
    }
}