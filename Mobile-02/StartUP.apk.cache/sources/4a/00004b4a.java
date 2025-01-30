package e.j.n;

import com.coinbase.wallet.ethereum.interfaces.IETHWalletRepository;
import com.coinbase.wallet.wallets.interfaces.IWalletRepository;
import javax.inject.Provider;

/* compiled from: AdvancedSettingsViewModel_Factory.java */
/* loaded from: classes2.dex */
public final class v1 implements f.c.d<u1> {
    private final Provider<e.j.j.b> a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<IWalletRepository> f13979b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<IETHWalletRepository> f13980c;

    public v1(Provider<e.j.j.b> provider, Provider<IWalletRepository> provider2, Provider<IETHWalletRepository> provider3) {
        this.a = provider;
        this.f13979b = provider2;
        this.f13980c = provider3;
    }

    public static v1 a(Provider<e.j.j.b> provider, Provider<IWalletRepository> provider2, Provider<IETHWalletRepository> provider3) {
        return new v1(provider, provider2, provider3);
    }

    public static u1 c(e.j.j.b bVar, IWalletRepository iWalletRepository, IETHWalletRepository iETHWalletRepository) {
        return new u1(bVar, iWalletRepository, iETHWalletRepository);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public u1 get() {
        return c(this.a.get(), this.f13979b.get(), this.f13980c.get());
    }
}