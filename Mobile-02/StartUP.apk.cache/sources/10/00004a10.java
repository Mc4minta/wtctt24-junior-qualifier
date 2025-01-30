package e.j.j;

import android.content.Context;
import javax.inject.Provider;

/* compiled from: MnemonicPrefs_Factory.java */
/* loaded from: classes2.dex */
public final class i implements f.c.d<g> {
    private final Provider<Context> a;

    public i(Provider<Context> provider) {
        this.a = provider;
    }

    public static i a(Provider<Context> provider) {
        return new i(provider);
    }

    public static g c(Context context) {
        return new g(context);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public g get() {
        return c(this.a.get());
    }
}