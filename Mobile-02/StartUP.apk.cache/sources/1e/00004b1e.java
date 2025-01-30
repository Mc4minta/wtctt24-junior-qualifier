package e.j.n.p3;

import com.coinbase.wallet.application.repository.interfaces.AppLockRepositoryInterface;
import javax.inject.Provider;

/* compiled from: PinLockViewModel_Factory.java */
/* loaded from: classes2.dex */
public final class o implements f.c.d<n> {
    private final Provider<AppLockRepositoryInterface> a;

    public o(Provider<AppLockRepositoryInterface> provider) {
        this.a = provider;
    }

    public static o a(Provider<AppLockRepositoryInterface> provider) {
        return new o(provider);
    }

    public static n c(AppLockRepositoryInterface appLockRepositoryInterface) {
        return new n(appLockRepositoryInterface);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public n get() {
        return c(this.a.get());
    }
}