package e.j.n;

import com.coinbase.wallet.consumer.repositories.ConsumerUserRepository;
import com.coinbase.wallet.featureflags.repositories.FeatureFlagsRepository;
import com.coinbase.wallet.lending.interfaces.ILendRepository;
import com.coinbase.wallet.user.repositories.UserRepository;
import com.coinbase.wallet.wallets.formatters.CurrencyFormatter;
import com.coinbase.wallet.wallets.interfaces.IExchangeRateRepository;
import com.coinbase.wallet.wallets.interfaces.IWalletRepository;
import javax.inject.Provider;

/* compiled from: HomeViewModel_Factory.java */
/* loaded from: classes2.dex */
public final class m2 implements f.c.d<l2> {
    private final Provider<UserRepository> a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<e.j.i.i2.b> f13900b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<IExchangeRateRepository> f13901c;

    /* renamed from: d  reason: collision with root package name */
    private final Provider<ILendRepository> f13902d;

    /* renamed from: e  reason: collision with root package name */
    private final Provider<CurrencyFormatter> f13903e;

    /* renamed from: f  reason: collision with root package name */
    private final Provider<FeatureFlagsRepository> f13904f;

    /* renamed from: g  reason: collision with root package name */
    private final Provider<ConsumerUserRepository> f13905g;

    /* renamed from: h  reason: collision with root package name */
    private final Provider<e.j.j.b> f13906h;

    /* renamed from: i  reason: collision with root package name */
    private final Provider<e.j.i.c2> f13907i;

    /* renamed from: j  reason: collision with root package name */
    private final Provider<IWalletRepository> f13908j;

    public m2(Provider<UserRepository> provider, Provider<e.j.i.i2.b> provider2, Provider<IExchangeRateRepository> provider3, Provider<ILendRepository> provider4, Provider<CurrencyFormatter> provider5, Provider<FeatureFlagsRepository> provider6, Provider<ConsumerUserRepository> provider7, Provider<e.j.j.b> provider8, Provider<e.j.i.c2> provider9, Provider<IWalletRepository> provider10) {
        this.a = provider;
        this.f13900b = provider2;
        this.f13901c = provider3;
        this.f13902d = provider4;
        this.f13903e = provider5;
        this.f13904f = provider6;
        this.f13905g = provider7;
        this.f13906h = provider8;
        this.f13907i = provider9;
        this.f13908j = provider10;
    }

    public static m2 a(Provider<UserRepository> provider, Provider<e.j.i.i2.b> provider2, Provider<IExchangeRateRepository> provider3, Provider<ILendRepository> provider4, Provider<CurrencyFormatter> provider5, Provider<FeatureFlagsRepository> provider6, Provider<ConsumerUserRepository> provider7, Provider<e.j.j.b> provider8, Provider<e.j.i.c2> provider9, Provider<IWalletRepository> provider10) {
        return new m2(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9, provider10);
    }

    public static l2 c(UserRepository userRepository, e.j.i.i2.b bVar, IExchangeRateRepository iExchangeRateRepository, ILendRepository iLendRepository, CurrencyFormatter currencyFormatter, FeatureFlagsRepository featureFlagsRepository, ConsumerUserRepository consumerUserRepository, e.j.j.b bVar2, e.j.i.c2 c2Var, IWalletRepository iWalletRepository) {
        return new l2(userRepository, bVar, iExchangeRateRepository, iLendRepository, currencyFormatter, featureFlagsRepository, consumerUserRepository, bVar2, c2Var, iWalletRepository);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public l2 get() {
        return c(this.a.get(), this.f13900b.get(), this.f13901c.get(), this.f13902d.get(), this.f13903e.get(), this.f13904f.get(), this.f13905g.get(), this.f13906h.get(), this.f13907i.get(), this.f13908j.get());
    }
}