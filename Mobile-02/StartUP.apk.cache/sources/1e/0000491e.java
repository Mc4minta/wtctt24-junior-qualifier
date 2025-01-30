package e.j.c.a;

import android.content.Context;
import f.c.d;
import javax.inject.Provider;

/* compiled from: ConsumerOAuthPrefs_Factory.java */
/* loaded from: classes2.dex */
public final class b implements d<a> {
    private final Provider<Context> a;

    public b(Provider<Context> provider) {
        this.a = provider;
    }

    public static b a(Provider<Context> provider) {
        return new b(provider);
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