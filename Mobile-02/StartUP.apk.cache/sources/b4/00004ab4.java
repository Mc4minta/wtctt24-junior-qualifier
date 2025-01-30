package e.j.n;

import com.coinbase.wallet.application.repository.interfaces.MnemonicRepositoryInterface;
import com.coinbase.wallet.user.repositories.UserRepository;
import javax.inject.Provider;

/* compiled from: SignInViewModel_Factory.java */
/* loaded from: classes2.dex */
public final class e3 implements f.c.d<d3> {
    private final Provider<MnemonicRepositoryInterface> a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<UserRepository> f13826b;

    public e3(Provider<MnemonicRepositoryInterface> provider, Provider<UserRepository> provider2) {
        this.a = provider;
        this.f13826b = provider2;
    }

    public static e3 a(Provider<MnemonicRepositoryInterface> provider, Provider<UserRepository> provider2) {
        return new e3(provider, provider2);
    }

    public static d3 c(MnemonicRepositoryInterface mnemonicRepositoryInterface, UserRepository userRepository) {
        return new d3(mnemonicRepositoryInterface, userRepository);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public d3 get() {
        return c(this.a.get(), this.f13826b.get());
    }
}