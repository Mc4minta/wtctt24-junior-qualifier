package e.j.n;

import javax.inject.Provider;

/* compiled from: VerifyManualBackupViewModel_Factory.java */
/* loaded from: classes2.dex */
public final class j3 implements f.c.d<i3> {
    private final Provider<e.j.i.i2.d> a;

    public j3(Provider<e.j.i.i2.d> provider) {
        this.a = provider;
    }

    public static j3 a(Provider<e.j.i.i2.d> provider) {
        return new j3(provider);
    }

    public static i3 c(e.j.i.i2.d dVar) {
        return new i3(dVar);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public i3 get() {
        return c(this.a.get());
    }
}