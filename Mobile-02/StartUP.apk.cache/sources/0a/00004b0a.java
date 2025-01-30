package e.j.n;

import com.coinbase.wallet.application.repository.interfaces.AppLockRepositoryInterface;
import com.coinbase.wallet.application.repository.interfaces.MnemonicRepositoryInterface;
import com.coinbase.wallet.application.repository.interfaces.NotificationRepositoryInterface;
import com.coinbase.wallet.appreview.repositories.AppReviewRepository;
import com.coinbase.wallet.features.applock.legacy.AuthenticationHelper;
import com.coinbase.wallet.features.pushnotifications.repositories.PushNotificationRepository;
import com.coinbase.wallet.http.connectivity.ConnectionStatus;
import com.coinbase.wallet.routing.repositories.DeepLinkRepository;
import com.coinbase.wallet.store.interfaces.StoreInterface;
import com.coinbase.wallet.user.repositories.UserRepository;
import com.coinbase.wallet.wallets.interfaces.ITxRepository;
import com.coinbase.wallet.wallets.interfaces.IWalletRepository;
import javax.inject.Provider;

/* compiled from: MainViewModel_Factory.java */
/* loaded from: classes2.dex */
public final class p2 implements f.c.d<o2> {
    private final Provider<AppReviewRepository> a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<e.j.i.g2> f13927b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<ITxRepository> f13928c;

    /* renamed from: d  reason: collision with root package name */
    private final Provider<e.j.j.b> f13929d;

    /* renamed from: e  reason: collision with root package name */
    private final Provider<NotificationRepositoryInterface> f13930e;

    /* renamed from: f  reason: collision with root package name */
    private final Provider<UserRepository> f13931f;

    /* renamed from: g  reason: collision with root package name */
    private final Provider<IWalletRepository> f13932g;

    /* renamed from: h  reason: collision with root package name */
    private final Provider<AppLockRepositoryInterface> f13933h;

    /* renamed from: i  reason: collision with root package name */
    private final Provider<DeepLinkRepository> f13934i;

    /* renamed from: j  reason: collision with root package name */
    private final Provider<StoreInterface> f13935j;

    /* renamed from: k  reason: collision with root package name */
    private final Provider<PushNotificationRepository> f13936k;

    /* renamed from: l  reason: collision with root package name */
    private final Provider<AuthenticationHelper> f13937l;
    private final Provider<MnemonicRepositoryInterface> m;
    private final Provider<h.c.s<ConnectionStatus>> n;

    public p2(Provider<AppReviewRepository> provider, Provider<e.j.i.g2> provider2, Provider<ITxRepository> provider3, Provider<e.j.j.b> provider4, Provider<NotificationRepositoryInterface> provider5, Provider<UserRepository> provider6, Provider<IWalletRepository> provider7, Provider<AppLockRepositoryInterface> provider8, Provider<DeepLinkRepository> provider9, Provider<StoreInterface> provider10, Provider<PushNotificationRepository> provider11, Provider<AuthenticationHelper> provider12, Provider<MnemonicRepositoryInterface> provider13, Provider<h.c.s<ConnectionStatus>> provider14) {
        this.a = provider;
        this.f13927b = provider2;
        this.f13928c = provider3;
        this.f13929d = provider4;
        this.f13930e = provider5;
        this.f13931f = provider6;
        this.f13932g = provider7;
        this.f13933h = provider8;
        this.f13934i = provider9;
        this.f13935j = provider10;
        this.f13936k = provider11;
        this.f13937l = provider12;
        this.m = provider13;
        this.n = provider14;
    }

    public static p2 a(Provider<AppReviewRepository> provider, Provider<e.j.i.g2> provider2, Provider<ITxRepository> provider3, Provider<e.j.j.b> provider4, Provider<NotificationRepositoryInterface> provider5, Provider<UserRepository> provider6, Provider<IWalletRepository> provider7, Provider<AppLockRepositoryInterface> provider8, Provider<DeepLinkRepository> provider9, Provider<StoreInterface> provider10, Provider<PushNotificationRepository> provider11, Provider<AuthenticationHelper> provider12, Provider<MnemonicRepositoryInterface> provider13, Provider<h.c.s<ConnectionStatus>> provider14) {
        return new p2(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9, provider10, provider11, provider12, provider13, provider14);
    }

    public static o2 c(AppReviewRepository appReviewRepository, e.j.i.g2 g2Var, ITxRepository iTxRepository, e.j.j.b bVar, NotificationRepositoryInterface notificationRepositoryInterface, UserRepository userRepository, IWalletRepository iWalletRepository, AppLockRepositoryInterface appLockRepositoryInterface, DeepLinkRepository deepLinkRepository, StoreInterface storeInterface, PushNotificationRepository pushNotificationRepository, AuthenticationHelper authenticationHelper, MnemonicRepositoryInterface mnemonicRepositoryInterface, h.c.s<ConnectionStatus> sVar) {
        return new o2(appReviewRepository, g2Var, iTxRepository, bVar, notificationRepositoryInterface, userRepository, iWalletRepository, appLockRepositoryInterface, deepLinkRepository, storeInterface, pushNotificationRepository, authenticationHelper, mnemonicRepositoryInterface, sVar);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public o2 get() {
        return c(this.a.get(), this.f13927b.get(), this.f13928c.get(), this.f13929d.get(), this.f13930e.get(), this.f13931f.get(), this.f13932g.get(), this.f13933h.get(), this.f13934i.get(), this.f13935j.get(), this.f13936k.get(), this.f13937l.get(), this.m.get(), this.n.get());
    }
}