package com.coinbase.wallet.di;

import android.content.Context;
import com.coinbase.ciphercore.CipherCoreInterface;
import com.coinbase.wallet.application.BaseApplication;
import com.coinbase.wallet.application.repository.AppLockRepository;
import com.coinbase.wallet.application.repository.AppLockRepository_Factory;
import com.coinbase.wallet.application.repository.MnemonicRepository;
import com.coinbase.wallet.application.repository.MnemonicRepository_Factory;
import com.coinbase.wallet.application.repository.interfaces.AppLockRepositoryInterface;
import com.coinbase.wallet.application.repository.interfaces.MnemonicRepositoryInterface;
import com.coinbase.wallet.common.utilities.BuildConfigWrapper;
import com.coinbase.wallet.di.AppCoreComponent;
import com.coinbase.wallet.featureflags.repositories.FeatureFlagsRepository;
import com.coinbase.wallet.features.applock.legacy.AuthenticationHelper;
import com.coinbase.wallet.features.applock.legacy.AuthenticationHelper_Factory;
import com.coinbase.wallet.features.networking.jwt.AccessTokenAuthenticator;
import com.coinbase.wallet.features.networking.jwt.AccessTokenAuthenticator_Factory;
import com.coinbase.wallet.features.networking.jwt.AccessTokenInterceptor;
import com.coinbase.wallet.features.networking.jwt.AccessTokenInterceptor_Factory;
import com.coinbase.wallet.features.networking.jwt.AccessTokenProvider;
import com.coinbase.wallet.features.networking.jwt.AccessTokenProvider_Factory;
import com.coinbase.wallet.store.Store;
import com.coinbase.wallet.store.interfaces.StoreInterface;
import com.coinbase.wallet.user.apis.AccessTokenApi;
import com.coinbase.wallet.user.apis.AccessTokenApiInterface;
import com.coinbase.wallet.user.apis.AccessTokenApi_Factory;
import com.coinbase.wallet.user.dtos.CreateAccessTokenResponseDTO;
import com.coinbase.wallet.user.repositories.AccessTokenRepository;
import com.coinbase.wallet.user.repositories.AccessTokenRepository_Factory;
import com.coinbase.wallet.wallets.di.CryptoContainer;
import com.squareup.moshi.Moshi;
import e.j.d.g.u;
import e.j.d.g.v;
import e.j.d.g.w;
import e.j.d.g.x;
import e.j.d.g.y;
import e.j.d.g.z;
import e.j.j.m;
import e.j.j.n;
import e.j.j.o;
import h.c.b0;
import javax.inject.Provider;
import okhttp3.Cache;
import okhttp3.OkHttpClient;
import retrofit2.t;

/* loaded from: classes.dex */
public final class DaggerAppCoreComponent implements AppCoreComponent {
    private Provider<AccessTokenApiInterface> accessTokenApiInterfaceProvider;
    private Provider<AccessTokenApi> accessTokenApiProvider;
    private Provider<AccessTokenAuthenticator> accessTokenAuthenticatorProvider;
    private Provider<AccessTokenInterceptor> accessTokenInterceptorProvider;
    private Provider<AccessTokenProvider> accessTokenProvider;
    private Provider<AccessTokenRepository> accessTokenRepositoryProvider;
    private final BaseApplication app;
    private final DaggerAppCoreComponent appCoreComponent;
    private Provider<AppLockRepository> appLockRepositoryProvider;
    private Provider<e.j.j.a> appPrefsProvider;
    private Provider<AuthenticationHelper> authenticationHelperProvider;
    private Provider<e.j.l.o.b> base64UtilProvider;
    private Provider<OkHttpClient> baseOkHttpClientProvider;
    private Provider<t> baseRetrofitProvider;
    private Provider<t> baseWalletServiceRetrofitProvider;
    private Provider<e.j.l.n.a> biometricHelperProvider;
    private Provider<CipherCoreInterface> cipherCoreProvider;
    private Provider<Context> contextProvider;
    private Provider<e.j.l.p.b> cryptoErrorUtilProvider;
    private Provider<e.j.d.f.c> decryptorProvider;
    private Provider<e.j.d.f.e> encryptorProvider;
    private Provider<e.j.d.g.t> keyStoreKeyHandlerProvider;
    private Provider<e.j.j.d> lockPrefsProvider;
    private Provider<v> masterSeedHandlerProvider;
    private Provider<e.j.j.g> mnemonicPrefsProvider;
    private Provider<MnemonicRepository> mnemonicRepositoryProvider;
    private Provider<y> pinKeyHandlerProvider;
    private Provider<m> pinPrefsProvider;
    private Provider<Cache> provideCacheProvider;
    private Provider<BuildConfigWrapper> providesBuildConfigProvider;
    private Provider<FeatureFlagsRepository> providesFeatureFlagRepositoryProvider;
    private Provider<e.j.g.a> providesKeyguardManagerInterfaceProvider;
    private Provider<w> providesMasterSeedHandlerProvider;
    private Provider<Moshi> providesMoshiProvider;
    private Provider<b0<CreateAccessTokenResponseDTO>> providesSignInHandlerProvider;
    private Provider<StoreInterface> providesStoreProvider;
    private Provider<Store> providesStoreProvider2;
    private final String walletApiUrl;
    private Provider<String> walletApiUrlProvider;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class Factory implements AppCoreComponent.Factory {
        private Factory() {
        }

        @Override // com.coinbase.wallet.di.AppCoreComponent.Factory
        public AppCoreComponent create(BaseApplication baseApplication, CryptoContainer cryptoContainer, String str) {
            f.c.h.b(baseApplication);
            f.c.h.b(cryptoContainer);
            f.c.h.b(str);
            return new DaggerAppCoreComponent(new ApiCoreModule(), cryptoContainer, baseApplication, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class com_coinbase_wallet_wallets_di_CryptoContainer_cipherCore implements Provider<CipherCoreInterface> {
        private final CryptoContainer cryptoContainer;

        com_coinbase_wallet_wallets_di_CryptoContainer_cipherCore(CryptoContainer cryptoContainer) {
            this.cryptoContainer = cryptoContainer;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // javax.inject.Provider
        public CipherCoreInterface get() {
            return (CipherCoreInterface) f.c.h.e(this.cryptoContainer.cipherCore());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class com_coinbase_wallet_wallets_di_CryptoContainer_context implements Provider<Context> {
        private final CryptoContainer cryptoContainer;

        com_coinbase_wallet_wallets_di_CryptoContainer_context(CryptoContainer cryptoContainer) {
            this.cryptoContainer = cryptoContainer;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // javax.inject.Provider
        public Context get() {
            return (Context) f.c.h.e(this.cryptoContainer.context());
        }
    }

    private e.j.l.p.b cryptoErrorUtil() {
        return new e.j.l.p.b(this.appPrefsProvider.get(), this.lockPrefsProvider.get(), this.providesStoreProvider.get());
    }

    private e.j.d.f.c decryptor() {
        return new e.j.d.f.c(new e.j.d.f.a(), this.base64UtilProvider.get(), cryptoErrorUtil());
    }

    private e.j.d.f.e encryptor() {
        return new e.j.d.f.e(new e.j.d.f.a(), this.base64UtilProvider.get(), cryptoErrorUtil());
    }

    public static AppCoreComponent.Factory factory() {
        return new Factory();
    }

    private void initialize(ApiCoreModule apiCoreModule, CryptoContainer cryptoContainer, BaseApplication baseApplication, String str) {
        com_coinbase_wallet_wallets_di_CryptoContainer_context com_coinbase_wallet_wallets_di_cryptocontainer_context = new com_coinbase_wallet_wallets_di_CryptoContainer_context(cryptoContainer);
        this.contextProvider = com_coinbase_wallet_wallets_di_cryptocontainer_context;
        Provider<Cache> b2 = f.c.c.b(NetworkCoreModule_ProvideCacheFactory.create(com_coinbase_wallet_wallets_di_cryptocontainer_context));
        this.provideCacheProvider = b2;
        this.baseOkHttpClientProvider = f.c.c.b(NetworkCoreModule_BaseOkHttpClientFactory.create(b2));
        this.base64UtilProvider = f.c.c.b(e.j.l.o.c.a());
        this.mnemonicPrefsProvider = f.c.c.b(e.j.j.i.a(this.contextProvider));
        com_coinbase_wallet_wallets_di_CryptoContainer_cipherCore com_coinbase_wallet_wallets_di_cryptocontainer_ciphercore = new com_coinbase_wallet_wallets_di_CryptoContainer_cipherCore(cryptoContainer);
        this.cipherCoreProvider = com_coinbase_wallet_wallets_di_cryptocontainer_ciphercore;
        this.mnemonicRepositoryProvider = f.c.c.b(MnemonicRepository_Factory.create(this.mnemonicPrefsProvider, com_coinbase_wallet_wallets_di_cryptocontainer_ciphercore));
        this.lockPrefsProvider = f.c.c.b(e.j.j.f.a(this.contextProvider));
        this.providesStoreProvider = f.c.c.b(StoreModule_ProvidesStoreFactory.create(this.contextProvider));
        this.pinPrefsProvider = f.c.c.b(o.a(this.base64UtilProvider, this.contextProvider));
        Provider<e.j.j.a> b3 = f.c.c.b(e.j.j.c.a(this.contextProvider));
        this.appPrefsProvider = b3;
        this.cryptoErrorUtilProvider = e.j.l.p.c.a(b3, this.lockPrefsProvider, this.providesStoreProvider);
        this.encryptorProvider = e.j.d.f.f.a(e.j.d.f.b.a(), this.base64UtilProvider, this.cryptoErrorUtilProvider);
        e.j.d.f.d a = e.j.d.f.d.a(e.j.d.f.b.a(), this.base64UtilProvider, this.cryptoErrorUtilProvider);
        this.decryptorProvider = a;
        this.pinKeyHandlerProvider = f.c.c.b(z.a(this.pinPrefsProvider, this.encryptorProvider, a));
        u a2 = u.a(this.encryptorProvider, this.decryptorProvider, this.mnemonicRepositoryProvider);
        this.keyStoreKeyHandlerProvider = a2;
        x a3 = x.a(this.lockPrefsProvider, this.pinKeyHandlerProvider, a2, this.mnemonicRepositoryProvider);
        this.masterSeedHandlerProvider = a3;
        this.providesMasterSeedHandlerProvider = f.c.c.b(a3);
        Provider<e.j.g.a> b4 = f.c.c.b(e.j.g.c.a());
        this.providesKeyguardManagerInterfaceProvider = b4;
        this.appLockRepositoryProvider = f.c.c.b(AppLockRepository_Factory.create(this.mnemonicRepositoryProvider, this.lockPrefsProvider, this.providesStoreProvider, this.providesMasterSeedHandlerProvider, b4));
        Provider<e.j.l.n.a> b5 = f.c.c.b(e.j.l.n.c.a(this.contextProvider));
        this.biometricHelperProvider = b5;
        this.authenticationHelperProvider = f.c.c.b(AuthenticationHelper_Factory.create(this.base64UtilProvider, this.mnemonicRepositoryProvider, this.appLockRepositoryProvider, this.providesMasterSeedHandlerProvider, b5));
        this.providesMoshiProvider = f.c.c.b(NetworkCoreModule_ProvidesMoshiFactory.create());
        f.c.d a4 = f.c.e.a(str);
        this.walletApiUrlProvider = a4;
        Provider<t> b6 = f.c.c.b(NetworkCoreModule_BaseRetrofitFactory.create(this.providesMoshiProvider, this.baseOkHttpClientProvider, a4));
        this.baseRetrofitProvider = b6;
        Provider<AccessTokenApiInterface> b7 = f.c.c.b(ApiCoreModule_AccessTokenApiInterfaceFactory.create(apiCoreModule, b6));
        this.accessTokenApiInterfaceProvider = b7;
        AccessTokenApi_Factory create = AccessTokenApi_Factory.create(b7);
        this.accessTokenApiProvider = create;
        Provider<AccessTokenRepository> b8 = f.c.c.b(AccessTokenRepository_Factory.create(this.authenticationHelperProvider, create, this.cipherCoreProvider, this.providesStoreProvider));
        this.accessTokenRepositoryProvider = b8;
        NetworkCoreModule_ProvidesSignInHandlerFactory create2 = NetworkCoreModule_ProvidesSignInHandlerFactory.create(b8);
        this.providesSignInHandlerProvider = create2;
        Provider<AccessTokenProvider> b9 = f.c.c.b(AccessTokenProvider_Factory.create(create2, this.accessTokenApiProvider, this.providesStoreProvider));
        this.accessTokenProvider = b9;
        this.accessTokenAuthenticatorProvider = f.c.c.b(AccessTokenAuthenticator_Factory.create(b9));
        AccessTokenInterceptor_Factory create3 = AccessTokenInterceptor_Factory.create(this.accessTokenProvider);
        this.accessTokenInterceptorProvider = create3;
        this.baseWalletServiceRetrofitProvider = f.c.c.b(NetworkCoreModule_BaseWalletServiceRetrofitFactory.create(this.baseOkHttpClientProvider, this.accessTokenAuthenticatorProvider, create3, this.baseRetrofitProvider));
        this.providesBuildConfigProvider = f.c.c.b(AppCoreModule_ProvidesBuildConfigFactory.create());
        Provider<Store> b10 = f.c.c.b(AppCoreModule_ProvidesStoreFactory.create(this.contextProvider));
        this.providesStoreProvider2 = b10;
        this.providesFeatureFlagRepositoryProvider = f.c.c.b(AppCoreModule_ProvidesFeatureFlagRepositoryFactory.create(b10, this.walletApiUrlProvider));
    }

    @Override // com.coinbase.wallet.di.AppCoreComponent
    public AccessTokenApiInterface accessTokenApiInterface() {
        return this.accessTokenApiInterfaceProvider.get();
    }

    @Override // com.coinbase.wallet.di.AppCoreComponent
    public AccessTokenRepository accessTokenRepository() {
        return this.accessTokenRepositoryProvider.get();
    }

    @Override // com.coinbase.wallet.di.AppCoreComponent
    public AppLockRepositoryInterface appLockRepository() {
        return this.appLockRepositoryProvider.get();
    }

    @Override // com.coinbase.wallet.di.AppCoreComponent
    public e.j.j.b appPrefs() {
        return this.appPrefsProvider.get();
    }

    @Override // com.coinbase.wallet.di.AppCoreComponent
    public AuthenticationHelper authenticationHelper() {
        return this.authenticationHelperProvider.get();
    }

    @Override // com.coinbase.wallet.di.AppCoreComponent
    public e.j.l.o.a base64() {
        return this.base64UtilProvider.get();
    }

    @Override // com.coinbase.wallet.di.AppCoreComponent
    public BaseApplication baseApplication() {
        return this.app;
    }

    @Override // com.coinbase.wallet.di.AppCoreComponent
    public e.j.l.n.b biometricHelper() {
        return this.biometricHelperProvider.get();
    }

    @Override // com.coinbase.wallet.di.AppCoreComponent
    public BuildConfigWrapper buildConfigWrapper() {
        return this.providesBuildConfigProvider.get();
    }

    @Override // com.coinbase.wallet.di.AppCoreComponent
    public Cache cache() {
        return this.provideCacheProvider.get();
    }

    @Override // com.coinbase.wallet.di.AppCoreComponent
    public FeatureFlagsRepository featureFlagsRepository() {
        return this.providesFeatureFlagRepositoryProvider.get();
    }

    @Override // com.coinbase.wallet.di.AppCoreComponent
    public e.j.d.g.t keyStoreHandler() {
        return new e.j.d.g.t(encryptor(), decryptor(), this.mnemonicRepositoryProvider.get());
    }

    @Override // com.coinbase.wallet.di.AppCoreComponent
    public e.j.g.a keyguardManager() {
        return this.providesKeyguardManagerInterfaceProvider.get();
    }

    @Override // com.coinbase.wallet.di.AppCoreComponent
    public e.j.j.e lockPrefs() {
        return this.lockPrefsProvider.get();
    }

    @Override // com.coinbase.wallet.di.AppCoreComponent
    public w masterSeedHandler() {
        return this.providesMasterSeedHandlerProvider.get();
    }

    @Override // com.coinbase.wallet.di.AppCoreComponent
    public e.j.j.h mnemonicPrefs() {
        return this.mnemonicPrefsProvider.get();
    }

    @Override // com.coinbase.wallet.di.AppCoreComponent
    public MnemonicRepositoryInterface mnemonicRepository() {
        return this.mnemonicRepositoryProvider.get();
    }

    @Override // com.coinbase.wallet.di.AppCoreComponent
    public Moshi moshi() {
        return this.providesMoshiProvider.get();
    }

    @Override // com.coinbase.wallet.di.AppCoreComponent
    public OkHttpClient okHttp() {
        return this.baseOkHttpClientProvider.get();
    }

    @Override // com.coinbase.wallet.di.AppCoreComponent
    public y pinKeyHandler() {
        return this.pinKeyHandlerProvider.get();
    }

    @Override // com.coinbase.wallet.di.AppCoreComponent
    public n pinPrefs() {
        return this.pinPrefsProvider.get();
    }

    @Override // com.coinbase.wallet.di.AppCoreComponent
    public t retrofit() {
        return this.baseRetrofitProvider.get();
    }

    @Override // com.coinbase.wallet.di.AppCoreComponent
    public t retrofitWalletService() {
        return this.baseWalletServiceRetrofitProvider.get();
    }

    @Override // com.coinbase.wallet.di.AppCoreComponent
    public StoreInterface store() {
        return this.providesStoreProvider.get();
    }

    @Override // com.coinbase.wallet.di.AppCoreComponent
    public String walletApiUrl() {
        return this.walletApiUrl;
    }

    private DaggerAppCoreComponent(ApiCoreModule apiCoreModule, CryptoContainer cryptoContainer, BaseApplication baseApplication, String str) {
        this.appCoreComponent = this;
        this.walletApiUrl = str;
        this.app = baseApplication;
        initialize(apiCoreModule, cryptoContainer, baseApplication, str);
    }
}