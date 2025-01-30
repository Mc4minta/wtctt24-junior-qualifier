package e.j.n;

import com.coinbase.wallet.application.repository.interfaces.AppLockRepositoryInterface;
import com.coinbase.wallet.application.repository.interfaces.MnemonicRepositoryInterface;
import com.coinbase.wallet.user.repositories.UserRepository;
import com.coinbase.wallet.wallets.interfaces.IWalletRepository;
import javax.inject.Provider;

/* compiled from: SignInWalletAuthenticationOnboardingViewModel_Factory.java */
/* loaded from: classes2.dex */
public final class g3 implements f.c.d<f3> {
    private final Provider<e.j.j.b> a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<e.j.d.g.w> f13839b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<AppLockRepositoryInterface> f13840c;

    /* renamed from: d  reason: collision with root package name */
    private final Provider<e.j.d.g.t> f13841d;

    /* renamed from: e  reason: collision with root package name */
    private final Provider<UserRepository> f13842e;

    /* renamed from: f  reason: collision with root package name */
    private final Provider<IWalletRepository> f13843f;

    /* renamed from: g  reason: collision with root package name */
    private final Provider<e.j.i.i2.d> f13844g;

    /* renamed from: h  reason: collision with root package name */
    private final Provider<MnemonicRepositoryInterface> f13845h;

    public g3(Provider<e.j.j.b> provider, Provider<e.j.d.g.w> provider2, Provider<AppLockRepositoryInterface> provider3, Provider<e.j.d.g.t> provider4, Provider<UserRepository> provider5, Provider<IWalletRepository> provider6, Provider<e.j.i.i2.d> provider7, Provider<MnemonicRepositoryInterface> provider8) {
        this.a = provider;
        this.f13839b = provider2;
        this.f13840c = provider3;
        this.f13841d = provider4;
        this.f13842e = provider5;
        this.f13843f = provider6;
        this.f13844g = provider7;
        this.f13845h = provider8;
    }

    public static g3 a(Provider<e.j.j.b> provider, Provider<e.j.d.g.w> provider2, Provider<AppLockRepositoryInterface> provider3, Provider<e.j.d.g.t> provider4, Provider<UserRepository> provider5, Provider<IWalletRepository> provider6, Provider<e.j.i.i2.d> provider7, Provider<MnemonicRepositoryInterface> provider8) {
        return new g3(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8);
    }

    public static f3 c(e.j.j.b bVar, e.j.d.g.w wVar, AppLockRepositoryInterface appLockRepositoryInterface, e.j.d.g.t tVar, UserRepository userRepository, IWalletRepository iWalletRepository, e.j.i.i2.d dVar, MnemonicRepositoryInterface mnemonicRepositoryInterface) {
        return new f3(bVar, wVar, appLockRepositoryInterface, tVar, userRepository, iWalletRepository, dVar, mnemonicRepositoryInterface);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public f3 get() {
        return c(this.a.get(), this.f13839b.get(), this.f13840c.get(), this.f13841d.get(), this.f13842e.get(), this.f13843f.get(), this.f13844g.get(), this.f13845h.get());
    }
}