package e.j.n;

import com.coinbase.wallet.application.repository.interfaces.AppLockRepositoryInterface;
import com.coinbase.wallet.application.repository.interfaces.MnemonicRepositoryInterface;
import javax.inject.Provider;

/* compiled from: AuthenticationViewModel_Factory.java */
/* loaded from: classes2.dex */
public final class z1 implements f.c.d<y1> {
    private final Provider<AppLockRepositoryInterface> a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<MnemonicRepositoryInterface> f14008b;

    public z1(Provider<AppLockRepositoryInterface> provider, Provider<MnemonicRepositoryInterface> provider2) {
        this.a = provider;
        this.f14008b = provider2;
    }

    public static z1 a(Provider<AppLockRepositoryInterface> provider, Provider<MnemonicRepositoryInterface> provider2) {
        return new z1(provider, provider2);
    }

    public static y1 c(AppLockRepositoryInterface appLockRepositoryInterface, MnemonicRepositoryInterface mnemonicRepositoryInterface) {
        return new y1(appLockRepositoryInterface, mnemonicRepositoryInterface);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public y1 get() {
        return c(this.a.get(), this.f14008b.get());
    }
}