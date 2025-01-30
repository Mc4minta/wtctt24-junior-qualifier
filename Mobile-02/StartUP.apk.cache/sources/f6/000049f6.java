package e.j.i;

import com.coinbase.wallet.core.interfaces.Tracing;
import com.coinbase.wallet.features.ethereum.apis.CollectiblesApi;
import com.coinbase.wallet.wallets.interfaces.IWalletRepository;
import javax.inject.Provider;

/* compiled from: CollectibleTypesRepository_Factory.java */
/* loaded from: classes2.dex */
public final class x1 implements f.c.d<w1> {
    private final Provider<CollectiblesApi> a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<com.toshi.db.h.b> f13666b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<IWalletRepository> f13667c;

    /* renamed from: d  reason: collision with root package name */
    private final Provider<Tracing> f13668d;

    public x1(Provider<CollectiblesApi> provider, Provider<com.toshi.db.h.b> provider2, Provider<IWalletRepository> provider3, Provider<Tracing> provider4) {
        this.a = provider;
        this.f13666b = provider2;
        this.f13667c = provider3;
        this.f13668d = provider4;
    }

    public static x1 a(Provider<CollectiblesApi> provider, Provider<com.toshi.db.h.b> provider2, Provider<IWalletRepository> provider3, Provider<Tracing> provider4) {
        return new x1(provider, provider2, provider3, provider4);
    }

    public static w1 c(CollectiblesApi collectiblesApi, com.toshi.db.h.b bVar, IWalletRepository iWalletRepository, Tracing tracing) {
        return new w1(collectiblesApi, bVar, iWalletRepository, tracing);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public w1 get() {
        return c(this.a.get(), this.f13666b.get(), this.f13667c.get(), this.f13668d.get());
    }
}