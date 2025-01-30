package e.j.i;

import com.coinbase.wallet.core.interfaces.Refreshable;
import com.coinbase.wallet.wallets.interfaces.IWalletRepository;
import java.util.List;
import javax.inject.Provider;

/* compiled from: RefreshService_Factory.java */
/* loaded from: classes2.dex */
public final class f2 implements f.c.d<c2> {
    private final Provider<List<Refreshable>> a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<IWalletRepository> f13631b;

    public f2(Provider<List<Refreshable>> provider, Provider<IWalletRepository> provider2) {
        this.a = provider;
        this.f13631b = provider2;
    }

    public static f2 a(Provider<List<Refreshable>> provider, Provider<IWalletRepository> provider2) {
        return new f2(provider, provider2);
    }

    public static c2 c(List<Refreshable> list, IWalletRepository iWalletRepository) {
        return new c2(list, iWalletRepository);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public c2 get() {
        return c(this.a.get(), this.f13631b.get());
    }
}