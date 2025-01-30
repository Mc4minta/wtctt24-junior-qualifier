package e.j.n;

import com.coinbase.wallet.features.cloudbackup.prompts.CloudBackupPrompt;
import com.coinbase.wallet.features.walletlink.repositories.WalletLinkRepository;
import com.coinbase.wallet.user.repositories.UserRepository;
import com.coinbase.wallet.wallets.interfaces.IFiatCurrencyRepository;
import com.coinbase.wallet.wallets.interfaces.IWalletRepository;
import javax.inject.Provider;

/* compiled from: SettingsViewModel_Factory.java */
/* loaded from: classes2.dex */
public final class c3 implements f.c.d<b3> {
    private final Provider<UserRepository> a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<e.j.i.i2.d> f13814b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<WalletLinkRepository> f13815c;

    /* renamed from: d  reason: collision with root package name */
    private final Provider<IFiatCurrencyRepository> f13816d;

    /* renamed from: e  reason: collision with root package name */
    private final Provider<CloudBackupPrompt> f13817e;

    /* renamed from: f  reason: collision with root package name */
    private final Provider<IWalletRepository> f13818f;

    public c3(Provider<UserRepository> provider, Provider<e.j.i.i2.d> provider2, Provider<WalletLinkRepository> provider3, Provider<IFiatCurrencyRepository> provider4, Provider<CloudBackupPrompt> provider5, Provider<IWalletRepository> provider6) {
        this.a = provider;
        this.f13814b = provider2;
        this.f13815c = provider3;
        this.f13816d = provider4;
        this.f13817e = provider5;
        this.f13818f = provider6;
    }

    public static c3 a(Provider<UserRepository> provider, Provider<e.j.i.i2.d> provider2, Provider<WalletLinkRepository> provider3, Provider<IFiatCurrencyRepository> provider4, Provider<CloudBackupPrompt> provider5, Provider<IWalletRepository> provider6) {
        return new c3(provider, provider2, provider3, provider4, provider5, provider6);
    }

    public static b3 c(UserRepository userRepository, e.j.i.i2.d dVar, WalletLinkRepository walletLinkRepository, IFiatCurrencyRepository iFiatCurrencyRepository, CloudBackupPrompt cloudBackupPrompt, IWalletRepository iWalletRepository) {
        return new b3(userRepository, dVar, walletLinkRepository, iFiatCurrencyRepository, cloudBackupPrompt, iWalletRepository);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public b3 get() {
        return c(this.a.get(), this.f13814b.get(), this.f13815c.get(), this.f13816d.get(), this.f13817e.get(), this.f13818f.get());
    }
}