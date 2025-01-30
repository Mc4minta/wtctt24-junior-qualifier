package e.j.e;

import com.coinbase.wallet.blockchains.models.Wallet;
import com.coinbase.wallet.wallets.interfaces.IWalletRepository;
import f.c.h;
import h.c.s;
import java.util.List;
import javax.inject.Provider;

/* compiled from: TxHistoryModule_ProvidesWalletsObservableFactory.java */
/* loaded from: classes2.dex */
public final class e implements f.c.d<s<List<Wallet>>> {
    private final Provider<IWalletRepository> a;

    public e(Provider<IWalletRepository> provider) {
        this.a = provider;
    }

    public static e a(Provider<IWalletRepository> provider) {
        return new e(provider);
    }

    public static s<List<Wallet>> c(IWalletRepository iWalletRepository) {
        return (s) h.f(b.c(iWalletRepository));
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public s<List<Wallet>> get() {
        return c(this.a.get());
    }
}