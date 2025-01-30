package e.j.n;

import com.coinbase.ciphercore.CipherCoreInterface;
import com.coinbase.wallet.ethereum.interfaces.IETHTxRepository;
import com.coinbase.wallet.ethereum.interfaces.IETHWalletRepository;
import com.coinbase.wallet.features.signer.viewmodel.SignerViewModel;
import com.coinbase.wallet.routing.repositories.DeepLinkRepository;
import com.coinbase.wallet.wallets.interfaces.IWalletRepository;
import javax.inject.Provider;

/* compiled from: DappsViewModel_Factory.java */
/* loaded from: classes2.dex */
public final class i2 implements f.c.d<h2> {
    private final Provider<e.j.i.u1> a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<CipherCoreInterface> f13873b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<DeepLinkRepository> f13874c;

    /* renamed from: d  reason: collision with root package name */
    private final Provider<IWalletRepository> f13875d;

    /* renamed from: e  reason: collision with root package name */
    private final Provider<IETHTxRepository> f13876e;

    /* renamed from: f  reason: collision with root package name */
    private final Provider<SignerViewModel> f13877f;

    /* renamed from: g  reason: collision with root package name */
    private final Provider<IETHWalletRepository> f13878g;

    public i2(Provider<e.j.i.u1> provider, Provider<CipherCoreInterface> provider2, Provider<DeepLinkRepository> provider3, Provider<IWalletRepository> provider4, Provider<IETHTxRepository> provider5, Provider<SignerViewModel> provider6, Provider<IETHWalletRepository> provider7) {
        this.a = provider;
        this.f13873b = provider2;
        this.f13874c = provider3;
        this.f13875d = provider4;
        this.f13876e = provider5;
        this.f13877f = provider6;
        this.f13878g = provider7;
    }

    public static i2 a(Provider<e.j.i.u1> provider, Provider<CipherCoreInterface> provider2, Provider<DeepLinkRepository> provider3, Provider<IWalletRepository> provider4, Provider<IETHTxRepository> provider5, Provider<SignerViewModel> provider6, Provider<IETHWalletRepository> provider7) {
        return new i2(provider, provider2, provider3, provider4, provider5, provider6, provider7);
    }

    public static h2 c(e.j.i.u1 u1Var, CipherCoreInterface cipherCoreInterface, DeepLinkRepository deepLinkRepository, IWalletRepository iWalletRepository, IETHTxRepository iETHTxRepository, SignerViewModel signerViewModel, IETHWalletRepository iETHWalletRepository) {
        return new h2(u1Var, cipherCoreInterface, deepLinkRepository, iWalletRepository, iETHTxRepository, signerViewModel, iETHWalletRepository);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public h2 get() {
        return c(this.a.get(), this.f13873b.get(), this.f13874c.get(), this.f13875d.get(), this.f13876e.get(), this.f13877f.get(), this.f13878g.get());
    }
}