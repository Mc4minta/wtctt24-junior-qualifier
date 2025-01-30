package e.j.l.n;

import android.content.Context;
import f.c.d;
import javax.inject.Provider;

/* compiled from: BiometricHelper_Factory.java */
/* loaded from: classes2.dex */
public final class c implements d<a> {
    private final Provider<Context> a;

    public c(Provider<Context> provider) {
        this.a = provider;
    }

    public static c a(Provider<Context> provider) {
        return new c(provider);
    }

    public static a c(Context context) {
        return new a(context);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public a get() {
        return c(this.a.get());
    }
}