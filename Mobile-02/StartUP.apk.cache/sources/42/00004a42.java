package e.j.l.p;

import com.coinbase.wallet.store.interfaces.StoreInterface;
import javax.inject.Provider;

/* compiled from: CryptoErrorUtil_Factory.java */
/* loaded from: classes2.dex */
public final class c implements f.c.d<b> {
    private final Provider<e.j.j.b> a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<e.j.j.e> f13727b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<StoreInterface> f13728c;

    public c(Provider<e.j.j.b> provider, Provider<e.j.j.e> provider2, Provider<StoreInterface> provider3) {
        this.a = provider;
        this.f13727b = provider2;
        this.f13728c = provider3;
    }

    public static c a(Provider<e.j.j.b> provider, Provider<e.j.j.e> provider2, Provider<StoreInterface> provider3) {
        return new c(provider, provider2, provider3);
    }

    public static b c(e.j.j.b bVar, e.j.j.e eVar, StoreInterface storeInterface) {
        return new b(bVar, eVar, storeInterface);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public b get() {
        return c(this.a.get(), this.f13727b.get(), this.f13728c.get());
    }
}