package com.coinbase.wallet.di;

import android.content.Context;
import android.os.Build;
import com.appsflyer.internal.referrer.Payload;
import com.coinbase.wallet.application.repository.AppLockRepository;
import com.coinbase.wallet.application.repository.MnemonicRepository;
import com.coinbase.wallet.application.repository.interfaces.AppLockRepositoryInterface;
import com.coinbase.wallet.application.repository.interfaces.MnemonicRepositoryInterface;
import com.coinbase.wallet.authentication.AuthenticationHelperInterface;
import com.coinbase.wallet.common.annotations.AppCoreScoped;
import com.coinbase.wallet.common.utilities.BuildConfigWrapper;
import com.coinbase.wallet.featureflags.apis.FeatureFlagsApi;
import com.coinbase.wallet.featureflags.apis.RPC;
import com.coinbase.wallet.featureflags.repositories.FeatureFlagsRepository;
import com.coinbase.wallet.features.applock.legacy.AuthenticationHelper;
import com.coinbase.wallet.features.networking.annotation.WalletApiUrl;
import com.coinbase.wallet.http.models.HTTPService;
import com.coinbase.wallet.store.Store;
import e.j.d.g.v;
import e.j.d.g.w;
import e.j.j.n;
import java.net.URL;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;

/* compiled from: AppCoreModule.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u009a\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b'\u0018\u0000 62\u00020\u0001:\u00016B\u0007¢\u0006\u0004\b4\u00105J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H'¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\fH'¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0012\u001a\u00020\u0011H'¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0017\u001a\u00020\u0016H'¢\u0006\u0004\b\u0019\u0010\u001aJ\u0017\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001c\u001a\u00020\u001bH'¢\u0006\u0004\b\u001c\u0010\u001eJ\u0017\u0010 \u001a\u00020!2\u0006\u0010 \u001a\u00020\u001fH'¢\u0006\u0004\b \u0010\"J\u0017\u0010&\u001a\u00020%2\u0006\u0010$\u001a\u00020#H'¢\u0006\u0004\b&\u0010'J\u0017\u0010)\u001a\u00020*2\u0006\u0010)\u001a\u00020(H'¢\u0006\u0004\b)\u0010+J\u0017\u0010-\u001a\u00020.2\u0006\u0010-\u001a\u00020,H'¢\u0006\u0004\b-\u0010/J\u0017\u00101\u001a\u0002022\u0006\u00101\u001a\u000200H'¢\u0006\u0004\b1\u00103¨\u00067"}, d2 = {"Lcom/coinbase/wallet/di/AppCoreModule;", "", "Le/j/l/o/b;", "base64Util", "Le/j/l/o/a;", "providesBase64", "(Le/j/l/o/b;)Le/j/l/o/a;", "Lcom/coinbase/wallet/application/repository/MnemonicRepository;", "mnemonicRepository", "Lcom/coinbase/wallet/application/repository/interfaces/MnemonicRepositoryInterface;", "providesMnemonicRepository", "(Lcom/coinbase/wallet/application/repository/MnemonicRepository;)Lcom/coinbase/wallet/application/repository/interfaces/MnemonicRepositoryInterface;", "Lcom/coinbase/wallet/application/repository/AppLockRepository;", "appLockRepository", "Lcom/coinbase/wallet/application/repository/interfaces/AppLockRepositoryInterface;", "providesAppLockRepository", "(Lcom/coinbase/wallet/application/repository/AppLockRepository;)Lcom/coinbase/wallet/application/repository/interfaces/AppLockRepositoryInterface;", "Le/j/d/g/v;", "masterSeedHandler", "Le/j/d/g/w;", "providesMasterSeedHandler", "(Le/j/d/g/v;)Le/j/d/g/w;", "Le/j/j/d;", "lockPrefs", "Le/j/j/e;", "providesLockPrefs", "(Le/j/j/d;)Le/j/j/e;", "Le/j/j/g;", "mnemonicPrefs", "Le/j/j/h;", "(Le/j/j/g;)Le/j/j/h;", "Le/j/j/a;", "appPrefs", "Le/j/j/b;", "(Le/j/j/a;)Le/j/j/b;", "Le/j/g/b;", "keyguardManagerWrapper", "Le/j/g/a;", "providesKeyguardManagerInterface", "(Le/j/g/b;)Le/j/g/a;", "Le/j/j/m;", "pinPrefs", "Le/j/j/n;", "(Le/j/j/m;)Le/j/j/n;", "Le/j/l/n/a;", "biometricHelper", "Le/j/l/n/b;", "(Le/j/l/n/a;)Le/j/l/n/b;", "Lcom/coinbase/wallet/features/applock/legacy/AuthenticationHelper;", "authenticationHelper", "Lcom/coinbase/wallet/authentication/AuthenticationHelperInterface;", "(Lcom/coinbase/wallet/features/applock/legacy/AuthenticationHelper;)Lcom/coinbase/wallet/authentication/AuthenticationHelperInterface;", "<init>", "()V", "Companion", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public abstract class AppCoreModule {
    public static final Companion Companion = new Companion(null);

    /* compiled from: AppCoreModule.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0087\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0003\u0010\u0004J!\u0010\n\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00052\b\b\u0001\u0010\b\u001a\u00020\u0007H\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000e\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\fH\u0007¢\u0006\u0004\b\u000e\u0010\u000f¨\u0006\u0012"}, d2 = {"Lcom/coinbase/wallet/di/AppCoreModule$Companion;", "", "Lcom/coinbase/wallet/common/utilities/BuildConfigWrapper;", "providesBuildConfig", "()Lcom/coinbase/wallet/common/utilities/BuildConfigWrapper;", "Lcom/coinbase/wallet/store/Store;", Payload.TYPE_STORE, "", "walletApiUrl", "Lcom/coinbase/wallet/featureflags/repositories/FeatureFlagsRepository;", "providesFeatureFlagRepository", "(Lcom/coinbase/wallet/store/Store;Ljava/lang/String;)Lcom/coinbase/wallet/featureflags/repositories/FeatureFlagsRepository;", "Landroid/content/Context;", "context", "providesStore", "(Landroid/content/Context;)Lcom/coinbase/wallet/store/Store;", "<init>", "()V", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @AppCoreScoped
        public final BuildConfigWrapper providesBuildConfig() {
            return new BuildConfigWrapper(false, Build.VERSION.SDK_INT, 44000398, "25.8.398");
        }

        @AppCoreScoped
        public final FeatureFlagsRepository providesFeatureFlagRepository(Store store, @WalletApiUrl String walletApiUrl) {
            m.g(store, "store");
            m.g(walletApiUrl, "walletApiUrl");
            return new FeatureFlagsRepository(store, new FeatureFlagsApi(new HTTPService(new URL(walletApiUrl)), new RPC(store)));
        }

        @AppCoreScoped
        public final Store providesStore(Context context) {
            m.g(context, "context");
            return new Store(context);
        }
    }

    @AppCoreScoped
    public static final BuildConfigWrapper providesBuildConfig() {
        return Companion.providesBuildConfig();
    }

    @AppCoreScoped
    public static final FeatureFlagsRepository providesFeatureFlagRepository(Store store, @WalletApiUrl String str) {
        return Companion.providesFeatureFlagRepository(store, str);
    }

    @AppCoreScoped
    public static final Store providesStore(Context context) {
        return Companion.providesStore(context);
    }

    @AppCoreScoped
    public abstract e.j.j.b appPrefs(e.j.j.a aVar);

    @AppCoreScoped
    public abstract AuthenticationHelperInterface authenticationHelper(AuthenticationHelper authenticationHelper);

    @AppCoreScoped
    public abstract e.j.l.n.b biometricHelper(e.j.l.n.a aVar);

    @AppCoreScoped
    public abstract e.j.j.h mnemonicPrefs(e.j.j.g gVar);

    @AppCoreScoped
    public abstract n pinPrefs(e.j.j.m mVar);

    @AppCoreScoped
    public abstract AppLockRepositoryInterface providesAppLockRepository(AppLockRepository appLockRepository);

    @AppCoreScoped
    public abstract e.j.l.o.a providesBase64(e.j.l.o.b bVar);

    @AppCoreScoped
    public abstract e.j.g.a providesKeyguardManagerInterface(e.j.g.b bVar);

    @AppCoreScoped
    public abstract e.j.j.e providesLockPrefs(e.j.j.d dVar);

    @AppCoreScoped
    public abstract w providesMasterSeedHandler(v vVar);

    @AppCoreScoped
    public abstract MnemonicRepositoryInterface providesMnemonicRepository(MnemonicRepository mnemonicRepository);
}