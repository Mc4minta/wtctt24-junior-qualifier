package e.j.n;

import com.coinbase.wallet.application.repository.interfaces.MnemonicRepositoryInterface;
import com.coinbase.wallet.user.repositories.UserRepository;
import javax.inject.Provider;

/* compiled from: PickUsernameViewModel_Factory.java */
/* loaded from: classes2.dex */
public final class x2 implements f.c.d<w2> {
    private final Provider<MnemonicRepositoryInterface> a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<UserRepository> f13998b;

    public x2(Provider<MnemonicRepositoryInterface> provider, Provider<UserRepository> provider2) {
        this.a = provider;
        this.f13998b = provider2;
    }

    public static x2 a(Provider<MnemonicRepositoryInterface> provider, Provider<UserRepository> provider2) {
        return new x2(provider, provider2);
    }

    public static w2 c(MnemonicRepositoryInterface mnemonicRepositoryInterface, UserRepository userRepository) {
        return new w2(mnemonicRepositoryInterface, userRepository);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public w2 get() {
        return c(this.a.get(), this.f13998b.get());
    }
}