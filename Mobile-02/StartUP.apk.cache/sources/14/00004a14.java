package e.j.j;

import android.content.Context;
import javax.inject.Provider;

/* compiled from: NotificationPrefs_Factory.java */
/* loaded from: classes2.dex */
public final class l implements f.c.d<j> {
    private final Provider<Context> a;

    public l(Provider<Context> provider) {
        this.a = provider;
    }

    public static l a(Provider<Context> provider) {
        return new l(provider);
    }

    public static j c(Context context) {
        return new j(context);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public j get() {
        return c(this.a.get());
    }
}