package e.j.h.a;

import com.coinbase.wallet.features.walletlink.repositories.WalletLinkRepository;
import com.coinbase.wallet.qr.parsers.QRCodeIntentParser;
import com.coinbase.wallet.wallets.interfaces.IWalletRepository;
import java.util.Set;
import javax.inject.Provider;

/* compiled from: UniversalQRScannerViewModel_Factory.java */
/* loaded from: classes2.dex */
public final class m implements f.c.d<l> {
    private final Provider<Set<QRCodeIntentParser>> a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<IWalletRepository> f13595b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<WalletLinkRepository> f13596c;

    public m(Provider<Set<QRCodeIntentParser>> provider, Provider<IWalletRepository> provider2, Provider<WalletLinkRepository> provider3) {
        this.a = provider;
        this.f13595b = provider2;
        this.f13596c = provider3;
    }

    public static m a(Provider<Set<QRCodeIntentParser>> provider, Provider<IWalletRepository> provider2, Provider<WalletLinkRepository> provider3) {
        return new m(provider, provider2, provider3);
    }

    public static l c(Set<QRCodeIntentParser> set, IWalletRepository iWalletRepository, WalletLinkRepository walletLinkRepository) {
        return new l(set, iWalletRepository, walletLinkRepository);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public l get() {
        return c(this.a.get(), this.f13595b.get(), this.f13596c.get());
    }
}