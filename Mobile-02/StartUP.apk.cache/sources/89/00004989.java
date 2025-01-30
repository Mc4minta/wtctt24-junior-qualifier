package e.j.h.a;

import com.coinbase.wallet.wallets.interfaces.IWalletRepository;
import javax.inject.Provider;

/* compiled from: QRScannerViewModel_Factory.java */
/* loaded from: classes2.dex */
public final class k implements f.c.d<j> {
    private final Provider<IWalletRepository> a;

    public k(Provider<IWalletRepository> provider) {
        this.a = provider;
    }

    public static k a(Provider<IWalletRepository> provider) {
        return new k(provider);
    }

    public static j c(IWalletRepository iWalletRepository) {
        return new j(iWalletRepository);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public j get() {
        return c(this.a.get());
    }
}