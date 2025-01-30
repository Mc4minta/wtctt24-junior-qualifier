package e.j.n;

import com.coinbase.wallet.wallets.interfaces.IFiatCurrencyRepository;
import javax.inject.Provider;

/* compiled from: CurrencyViewModel_Factory.java */
/* loaded from: classes2.dex */
public final class g2 implements f.c.d<f2> {
    private final Provider<IFiatCurrencyRepository> a;

    public g2(Provider<IFiatCurrencyRepository> provider) {
        this.a = provider;
    }

    public static g2 a(Provider<IFiatCurrencyRepository> provider) {
        return new g2(provider);
    }

    public static f2 c(IFiatCurrencyRepository iFiatCurrencyRepository) {
        return new f2(iFiatCurrencyRepository);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public f2 get() {
        return c(this.a.get());
    }
}