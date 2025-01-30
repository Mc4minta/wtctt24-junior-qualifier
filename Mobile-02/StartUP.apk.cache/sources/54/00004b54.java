package e.j.n;

import com.coinbase.wallet.application.repository.interfaces.AppLockRepositoryInterface;
import com.coinbase.wallet.application.repository.interfaces.MnemonicRepositoryInterface;
import com.coinbase.wallet.features.applock.legacy.AuthenticationHelper;
import javax.inject.Provider;

/* compiled from: AppLockSettingsViewModel_Factory.java */
/* loaded from: classes2.dex */
public final class x1 implements f.c.d<w1> {
    private final Provider<AppLockRepositoryInterface> a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<AuthenticationHelper> f13995b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<MnemonicRepositoryInterface> f13996c;

    /* renamed from: d  reason: collision with root package name */
    private final Provider<e.j.d.g.t> f13997d;

    public x1(Provider<AppLockRepositoryInterface> provider, Provider<AuthenticationHelper> provider2, Provider<MnemonicRepositoryInterface> provider3, Provider<e.j.d.g.t> provider4) {
        this.a = provider;
        this.f13995b = provider2;
        this.f13996c = provider3;
        this.f13997d = provider4;
    }

    public static x1 a(Provider<AppLockRepositoryInterface> provider, Provider<AuthenticationHelper> provider2, Provider<MnemonicRepositoryInterface> provider3, Provider<e.j.d.g.t> provider4) {
        return new x1(provider, provider2, provider3, provider4);
    }

    public static w1 c(AppLockRepositoryInterface appLockRepositoryInterface, AuthenticationHelper authenticationHelper, MnemonicRepositoryInterface mnemonicRepositoryInterface, e.j.d.g.t tVar) {
        return new w1(appLockRepositoryInterface, authenticationHelper, mnemonicRepositoryInterface, tVar);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public w1 get() {
        return c(this.a.get(), this.f13995b.get(), this.f13996c.get(), this.f13997d.get());
    }
}