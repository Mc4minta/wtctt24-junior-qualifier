package e.j.j;

import android.content.Context;
import javax.inject.Provider;

/* compiled from: PinPrefs_Factory.java */
/* loaded from: classes2.dex */
public final class o implements f.c.d<m> {
    private final Provider<e.j.l.o.a> a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<Context> f13691b;

    public o(Provider<e.j.l.o.a> provider, Provider<Context> provider2) {
        this.a = provider;
        this.f13691b = provider2;
    }

    public static o a(Provider<e.j.l.o.a> provider, Provider<Context> provider2) {
        return new o(provider, provider2);
    }

    public static m c(e.j.l.o.a aVar, Context context) {
        return new m(aVar, context);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public m get() {
        return c(this.a.get(), this.f13691b.get());
    }
}