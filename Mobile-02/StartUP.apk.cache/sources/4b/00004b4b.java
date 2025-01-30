package e.j.n;

import com.coinbase.wallet.application.repository.interfaces.AppLockRepositoryInterface;
import com.coinbase.wallet.application.repository.interfaces.MnemonicRepositoryInterface;
import com.coinbase.wallet.user.repositories.UserRepository;
import com.coinbase.wallet.wallets.interfaces.IWalletRepository;
import javax.inject.Provider;

/* compiled from: NewWalletAuthenticationOnboardingViewModel_Factory.java */
/* loaded from: classes2.dex */
public final class v2 implements f.c.d<u2> {
    private final Provider<e.j.j.b> a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<e.j.d.g.w> f13981b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<AppLockRepositoryInterface> f13982c;

    /* renamed from: d  reason: collision with root package name */
    private final Provider<e.j.d.g.t> f13983d;

    /* renamed from: e  reason: collision with root package name */
    private final Provider<UserRepository> f13984e;

    /* renamed from: f  reason: collision with root package name */
    private final Provider<IWalletRepository> f13985f;

    /* renamed from: g  reason: collision with root package name */
    private final Provider<e.j.i.i2.d> f13986g;

    /* renamed from: h  reason: collision with root package name */
    private final Provider<MnemonicRepositoryInterface> f13987h;

    public v2(Provider<e.j.j.b> provider, Provider<e.j.d.g.w> provider2, Provider<AppLockRepositoryInterface> provider3, Provider<e.j.d.g.t> provider4, Provider<UserRepository> provider5, Provider<IWalletRepository> provider6, Provider<e.j.i.i2.d> provider7, Provider<MnemonicRepositoryInterface> provider8) {
        this.a = provider;
        this.f13981b = provider2;
        this.f13982c = provider3;
        this.f13983d = provider4;
        this.f13984e = provider5;
        this.f13985f = provider6;
        this.f13986g = provider7;
        this.f13987h = provider8;
    }

    public static v2 a(Provider<e.j.j.b> provider, Provider<e.j.d.g.w> provider2, Provider<AppLockRepositoryInterface> provider3, Provider<e.j.d.g.t> provider4, Provider<UserRepository> provider5, Provider<IWalletRepository> provider6, Provider<e.j.i.i2.d> provider7, Provider<MnemonicRepositoryInterface> provider8) {
        return new v2(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8);
    }

    public static u2 c(e.j.j.b bVar, e.j.d.g.w wVar, AppLockRepositoryInterface appLockRepositoryInterface, e.j.d.g.t tVar, UserRepository userRepository, IWalletRepository iWalletRepository, e.j.i.i2.d dVar, MnemonicRepositoryInterface mnemonicRepositoryInterface) {
        return new u2(bVar, wVar, appLockRepositoryInterface, tVar, userRepository, iWalletRepository, dVar, mnemonicRepositoryInterface);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public u2 get() {
        return c(this.a.get(), this.f13981b.get(), this.f13982c.get(), this.f13983d.get(), this.f13984e.get(), this.f13985f.get(), this.f13986g.get(), this.f13987h.get());
    }
}