package e.j.i;

import com.coinbase.wallet.features.ethereum.apis.CollectiblesApi;
import com.coinbase.wallet.wallets.interfaces.IWalletRepository;
import javax.inject.Provider;

/* compiled from: Erc721Repository_Factory.java */
/* loaded from: classes2.dex */
public final class z1 implements f.c.d<y1> {
    private final Provider<w1> a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<CollectiblesApi> f13678b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<com.toshi.db.i.b> f13679c;

    /* renamed from: d  reason: collision with root package name */
    private final Provider<IWalletRepository> f13680d;

    public z1(Provider<w1> provider, Provider<CollectiblesApi> provider2, Provider<com.toshi.db.i.b> provider3, Provider<IWalletRepository> provider4) {
        this.a = provider;
        this.f13678b = provider2;
        this.f13679c = provider3;
        this.f13680d = provider4;
    }

    public static z1 a(Provider<w1> provider, Provider<CollectiblesApi> provider2, Provider<com.toshi.db.i.b> provider3, Provider<IWalletRepository> provider4) {
        return new z1(provider, provider2, provider3, provider4);
    }

    public static y1 c(w1 w1Var, CollectiblesApi collectiblesApi, com.toshi.db.i.b bVar, IWalletRepository iWalletRepository) {
        return new y1(w1Var, collectiblesApi, bVar, iWalletRepository);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public y1 get() {
        return c(this.a.get(), this.f13678b.get(), this.f13679c.get(), this.f13680d.get());
    }
}