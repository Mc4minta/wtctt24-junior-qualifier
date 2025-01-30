package e.j.n;

import com.coinbase.wallet.features.ofac.repositories.OFACRepository;
import javax.inject.Provider;

/* compiled from: BannedLocationViewModel_Factory.java */
/* loaded from: classes2.dex */
public final class b2 implements f.c.d<a2> {
    private final Provider<OFACRepository> a;

    public b2(Provider<OFACRepository> provider) {
        this.a = provider;
    }

    public static b2 a(Provider<OFACRepository> provider) {
        return new b2(provider);
    }

    public static a2 c(OFACRepository oFACRepository) {
        return new a2(oFACRepository);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public a2 get() {
        return c(this.a.get());
    }
}