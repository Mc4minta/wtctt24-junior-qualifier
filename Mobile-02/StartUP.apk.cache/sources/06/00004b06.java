package e.j.n;

import com.coinbase.wallet.ethereum.interfaces.IETHWalletRepository;
import com.coinbase.wallet.wallets.interfaces.IWalletRepository;
import javax.inject.Provider;

/* compiled from: WalletPickerViewModel_Factory.java */
/* loaded from: classes2.dex */
public final class o3 implements f.c.d<n3> {
    private final Provider<IETHWalletRepository> a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<IWalletRepository> f13926b;

    public o3(Provider<IETHWalletRepository> provider, Provider<IWalletRepository> provider2) {
        this.a = provider;
        this.f13926b = provider2;
    }

    public static o3 a(Provider<IETHWalletRepository> provider, Provider<IWalletRepository> provider2) {
        return new o3(provider, provider2);
    }

    public static n3 c(IETHWalletRepository iETHWalletRepository, IWalletRepository iWalletRepository) {
        return new n3(iETHWalletRepository, iWalletRepository);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public n3 get() {
        return c(this.a.get(), this.f13926b.get());
    }
}