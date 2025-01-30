package e.j.n;

import com.coinbase.wallet.wallets.interfaces.IWalletRepository;
import javax.inject.Provider;

/* compiled from: ReceiveCoinPickerViewModel_Factory.java */
/* loaded from: classes2.dex */
public final class z2 implements f.c.d<y2> {
    private final Provider<IWalletRepository> a;

    public z2(Provider<IWalletRepository> provider) {
        this.a = provider;
    }

    public static z2 a(Provider<IWalletRepository> provider) {
        return new z2(provider);
    }

    public static y2 c(IWalletRepository iWalletRepository) {
        return new y2(iWalletRepository);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public y2 get() {
        return c(this.a.get());
    }
}