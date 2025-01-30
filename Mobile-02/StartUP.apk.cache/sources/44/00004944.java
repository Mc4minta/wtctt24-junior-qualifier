package e.j.d.g;

import com.coinbase.wallet.application.repository.MnemonicRepository;
import javax.inject.Provider;

/* compiled from: KeyStoreKeyHandler_Factory.java */
/* loaded from: classes2.dex */
public final class u implements f.c.d<t> {
    private final Provider<e.j.d.f.e> a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<e.j.d.f.c> f13557b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<MnemonicRepository> f13558c;

    public u(Provider<e.j.d.f.e> provider, Provider<e.j.d.f.c> provider2, Provider<MnemonicRepository> provider3) {
        this.a = provider;
        this.f13557b = provider2;
        this.f13558c = provider3;
    }

    public static u a(Provider<e.j.d.f.e> provider, Provider<e.j.d.f.c> provider2, Provider<MnemonicRepository> provider3) {
        return new u(provider, provider2, provider3);
    }

    public static t c(e.j.d.f.e eVar, e.j.d.f.c cVar, MnemonicRepository mnemonicRepository) {
        return new t(eVar, cVar, mnemonicRepository);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public t get() {
        return c(this.a.get(), this.f13557b.get(), this.f13558c.get());
    }
}