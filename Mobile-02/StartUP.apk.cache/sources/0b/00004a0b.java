package e.j.j;

import android.content.Context;
import javax.inject.Provider;

/* compiled from: LockPrefs_Factory.java */
/* loaded from: classes2.dex */
public final class f implements f.c.d<d> {
    private final Provider<Context> a;

    public f(Provider<Context> provider) {
        this.a = provider;
    }

    public static f a(Provider<Context> provider) {
        return new f(provider);
    }

    public static d c(Context context) {
        return new d(context);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public d get() {
        return c(this.a.get());
    }
}