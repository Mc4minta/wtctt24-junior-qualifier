package e.j.d.g;

import com.coinbase.wallet.application.repository.MnemonicRepository;
import javax.inject.Provider;

/* compiled from: MasterSeedHandler_Factory.java */
/* loaded from: classes2.dex */
public final class x implements f.c.d<v> {
    private final Provider<e.j.j.e> a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<y> f13574b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<t> f13575c;

    /* renamed from: d  reason: collision with root package name */
    private final Provider<MnemonicRepository> f13576d;

    public x(Provider<e.j.j.e> provider, Provider<y> provider2, Provider<t> provider3, Provider<MnemonicRepository> provider4) {
        this.a = provider;
        this.f13574b = provider2;
        this.f13575c = provider3;
        this.f13576d = provider4;
    }

    public static x a(Provider<e.j.j.e> provider, Provider<y> provider2, Provider<t> provider3, Provider<MnemonicRepository> provider4) {
        return new x(provider, provider2, provider3, provider4);
    }

    public static v c(e.j.j.e eVar, y yVar, t tVar, MnemonicRepository mnemonicRepository) {
        return new v(eVar, yVar, tVar, mnemonicRepository);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public v get() {
        return c(this.a.get(), this.f13574b.get(), this.f13575c.get(), this.f13576d.get());
    }
}