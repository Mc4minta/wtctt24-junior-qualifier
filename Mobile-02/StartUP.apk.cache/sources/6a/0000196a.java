package com.coinbase.wallet.di;

import com.appsflyer.internal.referrer.Payload;
import com.coinbase.wallet.application.BaseApplication;
import com.coinbase.wallet.application.repository.interfaces.AppLockRepositoryInterface;
import com.coinbase.wallet.application.repository.interfaces.MnemonicRepositoryInterface;
import com.coinbase.wallet.common.annotations.AppCoreScoped;
import com.coinbase.wallet.common.utilities.BuildConfigWrapper;
import com.coinbase.wallet.featureflags.repositories.FeatureFlagsRepository;
import com.coinbase.wallet.features.applock.legacy.AuthenticationHelper;
import com.coinbase.wallet.features.networking.annotation.WalletApiUrl;
import com.coinbase.wallet.features.networking.annotation.WalletService;
import com.coinbase.wallet.store.interfaces.StoreInterface;
import com.coinbase.wallet.user.apis.AccessTokenApiInterface;
import com.coinbase.wallet.user.repositories.AccessTokenRepository;
import com.coinbase.wallet.wallets.di.CryptoContainer;
import com.squareup.moshi.Moshi;
import e.j.d.g.t;
import e.j.d.g.w;
import e.j.d.g.y;
import e.j.j.n;
import kotlin.Metadata;
import okhttp3.Cache;
import okhttp3.OkHttpClient;

/* compiled from: AppCoreComponent.kt */
@AppCoreScoped
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000È\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001:\u0001KJ\u000f\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H'¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u00020\u0002H&¢\u0006\u0004\b\b\u0010\u0004J\u000f\u0010\n\u001a\u00020\tH&¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\r\u001a\u00020\fH&¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u0010\u001a\u00020\u000fH&¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0013\u001a\u00020\u0012H&¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0016\u001a\u00020\u0015H&¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0019\u001a\u00020\u0018H&¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u001c\u001a\u00020\u001bH&¢\u0006\u0004\b\u001c\u0010\u001dJ\u000f\u0010\u001f\u001a\u00020\u001eH&¢\u0006\u0004\b\u001f\u0010 J\u000f\u0010\"\u001a\u00020!H&¢\u0006\u0004\b\"\u0010#J\u000f\u0010%\u001a\u00020$H&¢\u0006\u0004\b%\u0010&J\u000f\u0010(\u001a\u00020'H&¢\u0006\u0004\b(\u0010)J\u000f\u0010+\u001a\u00020*H&¢\u0006\u0004\b+\u0010,J\u000f\u0010.\u001a\u00020-H&¢\u0006\u0004\b.\u0010/J\u000f\u00101\u001a\u000200H&¢\u0006\u0004\b1\u00102J\u000f\u00104\u001a\u000203H&¢\u0006\u0004\b4\u00105J\u000f\u00107\u001a\u000206H&¢\u0006\u0004\b7\u00108J\u000f\u0010:\u001a\u000209H&¢\u0006\u0004\b:\u0010;J\u000f\u0010=\u001a\u00020<H&¢\u0006\u0004\b=\u0010>J\u000f\u0010@\u001a\u00020?H&¢\u0006\u0004\b@\u0010AJ\u000f\u0010C\u001a\u00020BH&¢\u0006\u0004\bC\u0010DJ\u000f\u0010F\u001a\u00020EH&¢\u0006\u0004\bF\u0010GJ\u000f\u0010I\u001a\u00020HH&¢\u0006\u0004\bI\u0010J¨\u0006L"}, d2 = {"Lcom/coinbase/wallet/di/AppCoreComponent;", "", "Lretrofit2/t;", "retrofitWalletService", "()Lretrofit2/t;", "", "walletApiUrl", "()Ljava/lang/String;", "retrofit", "Lokhttp3/Cache;", "cache", "()Lokhttp3/Cache;", "Lcom/coinbase/wallet/store/interfaces/StoreInterface;", Payload.TYPE_STORE, "()Lcom/coinbase/wallet/store/interfaces/StoreInterface;", "Lcom/coinbase/wallet/features/applock/legacy/AuthenticationHelper;", "authenticationHelper", "()Lcom/coinbase/wallet/features/applock/legacy/AuthenticationHelper;", "Lcom/coinbase/wallet/application/BaseApplication;", "baseApplication", "()Lcom/coinbase/wallet/application/BaseApplication;", "Lcom/squareup/moshi/Moshi;", "moshi", "()Lcom/squareup/moshi/Moshi;", "Lokhttp3/OkHttpClient;", "okHttp", "()Lokhttp3/OkHttpClient;", "Lcom/coinbase/wallet/user/apis/AccessTokenApiInterface;", "accessTokenApiInterface", "()Lcom/coinbase/wallet/user/apis/AccessTokenApiInterface;", "Lcom/coinbase/wallet/user/repositories/AccessTokenRepository;", "accessTokenRepository", "()Lcom/coinbase/wallet/user/repositories/AccessTokenRepository;", "Lcom/coinbase/wallet/application/repository/interfaces/MnemonicRepositoryInterface;", "mnemonicRepository", "()Lcom/coinbase/wallet/application/repository/interfaces/MnemonicRepositoryInterface;", "Le/j/l/o/a;", "base64", "()Le/j/l/o/a;", "Le/j/j/e;", "lockPrefs", "()Le/j/j/e;", "Le/j/j/h;", "mnemonicPrefs", "()Le/j/j/h;", "Le/j/g/a;", "keyguardManager", "()Le/j/g/a;", "Le/j/d/g/y;", "pinKeyHandler", "()Le/j/d/g/y;", "Le/j/d/g/t;", "keyStoreHandler", "()Le/j/d/g/t;", "Le/j/j/n;", "pinPrefs", "()Le/j/j/n;", "Lcom/coinbase/wallet/application/repository/interfaces/AppLockRepositoryInterface;", "appLockRepository", "()Lcom/coinbase/wallet/application/repository/interfaces/AppLockRepositoryInterface;", "Le/j/d/g/w;", "masterSeedHandler", "()Le/j/d/g/w;", "Le/j/l/n/b;", "biometricHelper", "()Le/j/l/n/b;", "Le/j/j/b;", "appPrefs", "()Le/j/j/b;", "Lcom/coinbase/wallet/common/utilities/BuildConfigWrapper;", "buildConfigWrapper", "()Lcom/coinbase/wallet/common/utilities/BuildConfigWrapper;", "Lcom/coinbase/wallet/featureflags/repositories/FeatureFlagsRepository;", "featureFlagsRepository", "()Lcom/coinbase/wallet/featureflags/repositories/FeatureFlagsRepository;", "Factory", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public interface AppCoreComponent {

    /* compiled from: AppCoreComponent.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J+\u0010\t\u001a\u00020\b2\b\b\u0001\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0001\u0010\u0007\u001a\u00020\u0006H&¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/coinbase/wallet/di/AppCoreComponent$Factory;", "", "Lcom/coinbase/wallet/application/BaseApplication;", "app", "Lcom/coinbase/wallet/wallets/di/CryptoContainer;", "container", "", "walletApiUrl", "Lcom/coinbase/wallet/di/AppCoreComponent;", "create", "(Lcom/coinbase/wallet/application/BaseApplication;Lcom/coinbase/wallet/wallets/di/CryptoContainer;Ljava/lang/String;)Lcom/coinbase/wallet/di/AppCoreComponent;", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public interface Factory {
        AppCoreComponent create(BaseApplication baseApplication, CryptoContainer cryptoContainer, @WalletApiUrl String str);
    }

    AccessTokenApiInterface accessTokenApiInterface();

    AccessTokenRepository accessTokenRepository();

    AppLockRepositoryInterface appLockRepository();

    e.j.j.b appPrefs();

    AuthenticationHelper authenticationHelper();

    e.j.l.o.a base64();

    BaseApplication baseApplication();

    e.j.l.n.b biometricHelper();

    BuildConfigWrapper buildConfigWrapper();

    Cache cache();

    FeatureFlagsRepository featureFlagsRepository();

    t keyStoreHandler();

    e.j.g.a keyguardManager();

    e.j.j.e lockPrefs();

    w masterSeedHandler();

    e.j.j.h mnemonicPrefs();

    MnemonicRepositoryInterface mnemonicRepository();

    Moshi moshi();

    OkHttpClient okHttp();

    y pinKeyHandler();

    n pinPrefs();

    retrofit2.t retrofit();

    @WalletService
    retrofit2.t retrofitWalletService();

    StoreInterface store();

    @WalletApiUrl
    String walletApiUrl();
}