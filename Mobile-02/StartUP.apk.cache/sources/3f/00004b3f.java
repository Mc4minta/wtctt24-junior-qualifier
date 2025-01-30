package e.j.n;

import com.coinbase.wallet.blockchains.models.NetworkSetting;
import com.coinbase.wallet.featureflags.repositories.FeatureFlagsRepository;
import com.coinbase.wallet.wallets.interfaces.IWalletRepository;
import java.util.List;
import javax.inject.Provider;

/* compiled from: NetworkSwitcherViewModel_Factory.java */
/* loaded from: classes2.dex */
public final class t2 implements f.c.d<s2> {
    private final Provider<IWalletRepository> a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<List<NetworkSetting>> f13968b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<FeatureFlagsRepository> f13969c;

    public t2(Provider<IWalletRepository> provider, Provider<List<NetworkSetting>> provider2, Provider<FeatureFlagsRepository> provider3) {
        this.a = provider;
        this.f13968b = provider2;
        this.f13969c = provider3;
    }

    public static t2 a(Provider<IWalletRepository> provider, Provider<List<NetworkSetting>> provider2, Provider<FeatureFlagsRepository> provider3) {
        return new t2(provider, provider2, provider3);
    }

    public static s2 c(IWalletRepository iWalletRepository, List<NetworkSetting> list, FeatureFlagsRepository featureFlagsRepository) {
        return new s2(iWalletRepository, list, featureFlagsRepository);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public s2 get() {
        return c(this.a.get(), this.f13968b.get(), this.f13969c.get());
    }
}