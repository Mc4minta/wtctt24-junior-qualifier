package e.j.i;

import com.toshi.network.VersioningInterface;
import javax.inject.Provider;

/* compiled from: VersioningRepository_Factory.java */
/* loaded from: classes2.dex */
public final class h2 implements f.c.d<g2> {
    private final Provider<VersioningInterface> a;

    public h2(Provider<VersioningInterface> provider) {
        this.a = provider;
    }

    public static h2 a(Provider<VersioningInterface> provider) {
        return new h2(provider);
    }

    public static g2 c(VersioningInterface versioningInterface) {
        return new g2(versioningInterface);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public g2 get() {
        return c(this.a.get());
    }
}