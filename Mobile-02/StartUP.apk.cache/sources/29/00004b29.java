package e.j.n.p3;

import com.coinbase.wallet.application.repository.interfaces.AppLockRepositoryInterface;
import javax.inject.Provider;

/* compiled from: SwitchPinLockViewModel_Factory.java */
/* loaded from: classes2.dex */
public final class t implements f.c.d<s> {
    private final Provider<AppLockRepositoryInterface> a;

    public t(Provider<AppLockRepositoryInterface> provider) {
        this.a = provider;
    }

    public static t a(Provider<AppLockRepositoryInterface> provider) {
        return new t(provider);
    }

    public static s c(AppLockRepositoryInterface appLockRepositoryInterface) {
        return new s(appLockRepositoryInterface);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public s get() {
        return c(this.a.get());
    }
}