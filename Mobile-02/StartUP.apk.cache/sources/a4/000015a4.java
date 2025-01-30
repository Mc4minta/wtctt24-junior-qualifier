package com.coinbase.wallet.consumer.di;

import android.annotation.SuppressLint;
import android.app.Application;
import android.os.Build;
import android.provider.Settings;
import com.appsflyer.internal.referrer.Payload;
import com.coinbase.Coinbase;
import com.coinbase.CoinbaseBuilder;
import com.coinbase.android.apiv3.ApiV3QueryEncoderConverterFactory;
import com.coinbase.android.apiv3.ProtobufContentTypeInterceptor;
import com.coinbase.android.apiv3.generated.authed.sends.Sends;
import com.coinbase.errors.CoinbaseOAuthException;
import com.coinbase.network.adapter.KotlinRxJava2CallAdapterFactory;
import com.coinbase.resources.auth.AccessToken;
import com.coinbase.wallet.common.annotations.AppCoreScoped;
import com.coinbase.wallet.common.utilities.BuildConfigWrapper;
import com.coinbase.wallet.consumer.annotations.ConsumerService;
import com.coinbase.wallet.consumer.annotations.ConsumerV3Service;
import com.coinbase.wallet.consumer.apis.ConsumerAPIHttp;
import com.coinbase.wallet.consumer.daos.ConsumerAccountsDAO;
import com.coinbase.wallet.consumer.daos.ConsumerAvailablePaymentMethodsDAO;
import com.coinbase.wallet.consumer.daos.ConsumerPaymentMethodsDAO;
import com.coinbase.wallet.consumer.db.ConsumerDatabase;
import com.coinbase.wallet.consumer.extensions.StoreKeys_ConsumerConnectKt;
import com.coinbase.wallet.consumer.models.ConsumerNetworkConfig;
import com.coinbase.wallet.consumer.networking.interceptor.DeviceInterceptor;
import com.coinbase.wallet.libraries.databases.db.Database;
import com.coinbase.wallet.libraries.databases.model.DiskOptions;
import com.coinbase.wallet.store.interfaces.StoreInterface;
import com.coinbase.wallet.store.models.StoreKeys;
import com.squareup.moshi.Moshi;
import java.net.URL;
import java.util.List;
import kotlin.Metadata;
import kotlin.a0.q;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;
import okhttp3.Interceptor;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.adapter.rxjava2.g;
import retrofit2.t;
import retrofit2.y.b.a;

/* compiled from: ConsumerModule.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\b'\u0018\u0000 \u00042\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/coinbase/wallet/consumer/di/ConsumerModule;", "", "<init>", "()V", "Companion", "consumer_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public abstract class ConsumerModule {
    public static final Companion Companion = new Companion(null);

    /* compiled from: ConsumerModule.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0087\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b+\u0010,J/\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0007¢\u0006\u0004\b\u000b\u0010\fJ\u001f\u0010\u0011\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u000eH\u0007¢\u0006\u0004\b\u0011\u0010\u0012J\u001f\u0010\u0014\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\u0014\u0010\u0015J\u0019\u0010\u0018\u001a\u00020\u00172\b\b\u0001\u0010\u0016\u001a\u00020\u0010H\u0007¢\u0006\u0004\b\u0018\u0010\u0019J\u0019\u0010\u001b\u001a\u00020\u001a2\b\b\u0001\u0010\u0016\u001a\u00020\u0010H\u0007¢\u0006\u0004\b\u001b\u0010\u001cJ\u001d\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001d2\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u001f\u0010 J\u001d\u0010#\u001a\u00020\"2\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001dH\u0007¢\u0006\u0004\b#\u0010$J\u001d\u0010&\u001a\u00020%2\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001dH\u0007¢\u0006\u0004\b&\u0010'J\u001d\u0010)\u001a\u00020(2\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001dH\u0007¢\u0006\u0004\b)\u0010*¨\u0006-"}, d2 = {"Lcom/coinbase/wallet/consumer/di/ConsumerModule$Companion;", "", "Landroid/app/Application;", "app", "Lcom/coinbase/wallet/store/interfaces/StoreInterface;", Payload.TYPE_STORE, "Lcom/coinbase/wallet/consumer/models/ConsumerNetworkConfig;", "networkConfig", "Lcom/coinbase/wallet/common/utilities/BuildConfigWrapper;", "buildConfigWrapper", "Lcom/coinbase/Coinbase;", "providesCoinbase", "(Landroid/app/Application;Lcom/coinbase/wallet/store/interfaces/StoreInterface;Lcom/coinbase/wallet/consumer/models/ConsumerNetworkConfig;Lcom/coinbase/wallet/common/utilities/BuildConfigWrapper;)Lcom/coinbase/Coinbase;", "coinbase", "Lcom/squareup/moshi/Moshi;", "moshi", "Lretrofit2/t;", "coinbaseRetrofit", "(Lcom/coinbase/Coinbase;Lcom/squareup/moshi/Moshi;)Lretrofit2/t;", "consumerNetworkConfig", "coinbaseV3Retrofit", "(Lcom/coinbase/Coinbase;Lcom/coinbase/wallet/consumer/models/ConsumerNetworkConfig;)Lretrofit2/t;", "retrofit", "Lcom/coinbase/wallet/consumer/apis/ConsumerAPIHttp;", "consumerApi", "(Lretrofit2/t;)Lcom/coinbase/wallet/consumer/apis/ConsumerAPIHttp;", "Lcom/coinbase/android/apiv3/generated/authed/sends/Sends;", "consumerApiV3", "(Lretrofit2/t;)Lcom/coinbase/android/apiv3/generated/authed/sends/Sends;", "Lcom/coinbase/wallet/libraries/databases/db/Database;", "Lcom/coinbase/wallet/consumer/db/ConsumerDatabase;", "providesAppDatabase", "(Landroid/app/Application;)Lcom/coinbase/wallet/libraries/databases/db/Database;", "db", "Lcom/coinbase/wallet/consumer/daos/ConsumerAccountsDAO;", "providesConsumerAccountsDAO", "(Lcom/coinbase/wallet/libraries/databases/db/Database;)Lcom/coinbase/wallet/consumer/daos/ConsumerAccountsDAO;", "Lcom/coinbase/wallet/consumer/daos/ConsumerPaymentMethodsDAO;", "providesConsumerPaymentMethodsDAO", "(Lcom/coinbase/wallet/libraries/databases/db/Database;)Lcom/coinbase/wallet/consumer/daos/ConsumerPaymentMethodsDAO;", "Lcom/coinbase/wallet/consumer/daos/ConsumerAvailablePaymentMethodsDAO;", "providesConsumerAvailablePaymentMethodsDAO", "(Lcom/coinbase/wallet/libraries/databases/db/Database;)Lcom/coinbase/wallet/consumer/daos/ConsumerAvailablePaymentMethodsDAO;", "<init>", "()V", "consumer_productionRelease"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @ConsumerService
        @AppCoreScoped
        public final t coinbaseRetrofit(Coinbase coinbase, Moshi moshi) {
            m.g(coinbase, "coinbase");
            m.g(moshi, "moshi");
            t.b e2 = coinbase.getRetrofit().e();
            e2.h().add(0, a.a(moshi));
            t e3 = e2.e();
            m.f(e3, "coinbase\n                .retrofit\n                .newBuilder()\n                .apply { converterFactories().add(0, MoshiConverterFactory.create(moshi)) }\n                .build()");
            return e3;
        }

        @ConsumerV3Service
        @AppCoreScoped
        public final t coinbaseV3Retrofit(Coinbase coinbase, ConsumerNetworkConfig consumerNetworkConfig) {
            m.g(coinbase, "coinbase");
            m.g(consumerNetworkConfig, "consumerNetworkConfig");
            t e2 = new t.b().c(consumerNetworkConfig.getBaseApiV3URL()).g(coinbase.getOkHttpClient().newBuilder().addNetworkInterceptor(new ProtobufContentTypeInterceptor()).build()).b(ApiV3QueryEncoderConverterFactory.Companion.create()).a(KotlinRxJava2CallAdapterFactory.Companion.create()).a(g.b(h.c.u0.a.c())).b(retrofit2.y.c.a.a()).e();
            m.f(e2, "Builder()\n                .baseUrl(consumerNetworkConfig.baseApiV3URL)\n                .client(okHttpClient)\n                .addConverterFactory(ApiV3QueryEncoderConverterFactory.create())\n                .addCallAdapterFactory(KotlinRxJava2CallAdapterFactory.create())\n                .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io()))\n                .addConverterFactory(WireConverterFactory.create())\n                .build()");
            return e2;
        }

        @AppCoreScoped
        public final ConsumerAPIHttp consumerApi(@ConsumerService t retrofit) {
            m.g(retrofit, "retrofit");
            Object c2 = retrofit.c(ConsumerAPIHttp.class);
            m.f(c2, "retrofit.create(ConsumerAPIHttp::class.java)");
            return (ConsumerAPIHttp) c2;
        }

        @AppCoreScoped
        public final Sends consumerApiV3(@ConsumerV3Service t retrofit) {
            m.g(retrofit, "retrofit");
            return (Sends) retrofit.c(Sends.class);
        }

        @AppCoreScoped
        public final Database<ConsumerDatabase> providesAppDatabase(Application app) {
            m.g(app, "app");
            return new Database<>(new DiskOptions(app, ConsumerDatabase.class, "CONSUMER_CONNECT_DATABASE", null, true, 8, null));
        }

        @AppCoreScoped
        @SuppressLint({"HardwareIds"})
        public final Coinbase providesCoinbase(Application app, final StoreInterface store, ConsumerNetworkConfig networkConfig, BuildConfigWrapper buildConfigWrapper) {
            List<Interceptor> b2;
            m.g(app, "app");
            m.g(store, "store");
            m.g(networkConfig, "networkConfig");
            m.g(buildConfigWrapper, "buildConfigWrapper");
            URL url = new URL(networkConfig.getBaseApiURL());
            URL url2 = new URL(networkConfig.getOAuthApiURL());
            String clientId = networkConfig.getClientId();
            String clientSecret = networkConfig.getClientSecret();
            StoreKeys storeKeys = StoreKeys.INSTANCE;
            CoinbaseBuilder withSkipCertPinning = CoinbaseBuilder.withTokenAutoRefresh(app, clientId, clientSecret, (String) store.get(StoreKeys_ConsumerConnectKt.getConsumerAccessToken(storeKeys)), (String) store.get(StoreKeys_ConsumerConnectKt.getConsumerRefreshToken(storeKeys)), null).withSkipCertPinning(!networkConfig.getPinCertificates());
            String MODEL = Build.MODEL;
            m.f(MODEL, "MODEL");
            String PRODUCT = Build.PRODUCT;
            m.f(PRODUCT, "PRODUCT");
            String BRAND = Build.BRAND;
            m.f(BRAND, "BRAND");
            String MANUFACTURER = Build.MANUFACTURER;
            m.f(MANUFACTURER, "MANUFACTURER");
            String DEVICE = Build.DEVICE;
            m.f(DEVICE, "DEVICE");
            String valueOf = String.valueOf(Build.VERSION.SDK_INT);
            String BOARD = Build.BOARD;
            m.f(BOARD, "BOARD");
            String BOOTLOADER = Build.BOOTLOADER;
            m.f(BOOTLOADER, "BOOTLOADER");
            String RELEASE = Build.VERSION.RELEASE;
            m.f(RELEASE, "RELEASE");
            String string = Settings.Secure.getString(app.getContentResolver(), "android_id");
            m.f(string, "getString(\n                                app.contentResolver,\n                                Settings.Secure.ANDROID_ID\n                            )");
            b2 = q.b(new DeviceInterceptor(MODEL, PRODUCT, BRAND, MANUFACTURER, DEVICE, valueOf, BOARD, BOOTLOADER, RELEASE, "Android", string, ConsumerModule$Companion$providesCoinbase$1.INSTANCE));
            Coinbase build = withSkipCertPinning.withAdditionalInterceptors(b2).withClientName(buildConfigWrapper.getVersionName()).withClientVersion(String.valueOf(buildConfigWrapper.getVersionCode())).withBaseApiURL(url).withBaseOAuthURL(url2).withLoggingLevel(HttpLoggingInterceptor.Level.NONE).build();
            build.setRefreshTokenListener(new Coinbase.TokenListener() { // from class: com.coinbase.wallet.consumer.di.ConsumerModule$Companion$providesCoinbase$2$1
                private final void clearStoredAuth() {
                    StoreInterface storeInterface = StoreInterface.this;
                    StoreKeys storeKeys2 = StoreKeys.INSTANCE;
                    storeInterface.set(StoreKeys_ConsumerConnectKt.getConsumerAccessToken(storeKeys2), null);
                    StoreInterface.this.set(StoreKeys_ConsumerConnectKt.getConsumerRefreshToken(storeKeys2), null);
                    StoreInterface.this.set(StoreKeys_ConsumerConnectKt.getConsumerUser(storeKeys2), null);
                    StoreInterface.this.set(StoreKeys_ConsumerConnectKt.getConsumerScope(storeKeys2), null);
                }

                @Override // com.coinbase.Coinbase.TokenListener
                public void onNewTokensAvailable(AccessToken accessToken) {
                    m.g(accessToken, "accessToken");
                    StoreInterface storeInterface = StoreInterface.this;
                    StoreKeys storeKeys2 = StoreKeys.INSTANCE;
                    storeInterface.set(StoreKeys_ConsumerConnectKt.getConsumerAccessToken(storeKeys2), accessToken.getAccessToken());
                    StoreInterface.this.set(StoreKeys_ConsumerConnectKt.getConsumerRefreshToken(storeKeys2), accessToken.getRefreshToken());
                    StoreInterface.this.set(StoreKeys_ConsumerConnectKt.getConsumerScope(storeKeys2), accessToken.getScope());
                }

                @Override // com.coinbase.Coinbase.TokenListener
                public void onRefreshFailed(CoinbaseOAuthException cause) {
                    m.g(cause, "cause");
                    l.a.a.f(cause, "Access token autorefresh failed, logging out", new Object[0]);
                    clearStoredAuth();
                }

                @Override // com.coinbase.Coinbase.TokenListener
                public void onTokenRevoked() {
                    clearStoredAuth();
                }
            });
            m.f(build, "withTokenAutoRefresh(\n                    app,\n                    networkConfig.clientId,\n                    networkConfig.clientSecret,\n                    store.get(StoreKeys.consumerAccessToken),\n                    store.get(StoreKeys.consumerRefreshToken),\n                    null\n                )\n                .withSkipCertPinning(!networkConfig.pinCertificates)\n                .withAdditionalInterceptors(\n                    listOf(\n                        DeviceInterceptor(\n                            model = Build.MODEL,\n                            product = Build.PRODUCT,\n                            brand = Build.BRAND,\n                            manufacturer = Build.MANUFACTURER,\n                            systemName = Build.DEVICE,\n                            systemVersion = Build.VERSION.SDK_INT.toString(),\n                            systemBoard = Build.BOARD,\n                            systemBootloader = Build.BOOTLOADER,\n                            osVersion = Build.VERSION.RELEASE,\n                            osName = \"Android\",\n                            androidId = Settings.Secure.getString(\n                                app.contentResolver,\n                                Settings.Secure.ANDROID_ID\n                            ),\n                            advertisingIdProvider = { null }\n                        )\n                    )\n                )\n                .withClientName(buildConfigWrapper.versionName)\n                .withClientVersion(buildConfigWrapper.versionCode.toString())\n                .withBaseApiURL(baseApiURL)\n                .withBaseOAuthURL(oauthApiURL)\n                .withLoggingLevel(\n                    if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY else HttpLoggingInterceptor.Level.NONE\n                )\n                .build()\n                .apply {\n                    setRefreshTokenListener(\n                        object : Coinbase.TokenListener {\n                            override fun onNewTokensAvailable(accessToken: AccessToken) {\n                                store.set(StoreKeys.consumerAccessToken, accessToken.accessToken)\n                                store.set(StoreKeys.consumerRefreshToken, accessToken.refreshToken)\n                                store.set(StoreKeys.consumerScope, accessToken.scope)\n                            }\n\n                            override fun onRefreshFailed(cause: CoinbaseOAuthException) {\n                                Timber.e(cause, \"Access token autorefresh failed, logging out\")\n                                clearStoredAuth()\n                            }\n\n                            override fun onTokenRevoked() {\n                                clearStoredAuth()\n                            }\n\n                            private fun clearStoredAuth() {\n                                store.set(StoreKeys.consumerAccessToken, null)\n                                store.set(StoreKeys.consumerRefreshToken, null)\n                                store.set(StoreKeys.consumerUser, null)\n                                store.set(StoreKeys.consumerScope, null)\n                            }\n                        }\n                    )\n                }");
            return build;
        }

        @AppCoreScoped
        public final ConsumerAccountsDAO providesConsumerAccountsDAO(Database<ConsumerDatabase> db) {
            m.g(db, "db");
            return new ConsumerAccountsDAO(db);
        }

        @AppCoreScoped
        public final ConsumerAvailablePaymentMethodsDAO providesConsumerAvailablePaymentMethodsDAO(Database<ConsumerDatabase> db) {
            m.g(db, "db");
            return new ConsumerAvailablePaymentMethodsDAO(db);
        }

        @AppCoreScoped
        public final ConsumerPaymentMethodsDAO providesConsumerPaymentMethodsDAO(Database<ConsumerDatabase> db) {
            m.g(db, "db");
            return new ConsumerPaymentMethodsDAO(db);
        }
    }

    @ConsumerService
    @AppCoreScoped
    public static final t coinbaseRetrofit(Coinbase coinbase, Moshi moshi) {
        return Companion.coinbaseRetrofit(coinbase, moshi);
    }

    @ConsumerV3Service
    @AppCoreScoped
    public static final t coinbaseV3Retrofit(Coinbase coinbase, ConsumerNetworkConfig consumerNetworkConfig) {
        return Companion.coinbaseV3Retrofit(coinbase, consumerNetworkConfig);
    }

    @AppCoreScoped
    public static final ConsumerAPIHttp consumerApi(@ConsumerService t tVar) {
        return Companion.consumerApi(tVar);
    }

    @AppCoreScoped
    public static final Sends consumerApiV3(@ConsumerV3Service t tVar) {
        return Companion.consumerApiV3(tVar);
    }

    @AppCoreScoped
    public static final Database<ConsumerDatabase> providesAppDatabase(Application application) {
        return Companion.providesAppDatabase(application);
    }

    @AppCoreScoped
    @SuppressLint({"HardwareIds"})
    public static final Coinbase providesCoinbase(Application application, StoreInterface storeInterface, ConsumerNetworkConfig consumerNetworkConfig, BuildConfigWrapper buildConfigWrapper) {
        return Companion.providesCoinbase(application, storeInterface, consumerNetworkConfig, buildConfigWrapper);
    }

    @AppCoreScoped
    public static final ConsumerAccountsDAO providesConsumerAccountsDAO(Database<ConsumerDatabase> database) {
        return Companion.providesConsumerAccountsDAO(database);
    }

    @AppCoreScoped
    public static final ConsumerAvailablePaymentMethodsDAO providesConsumerAvailablePaymentMethodsDAO(Database<ConsumerDatabase> database) {
        return Companion.providesConsumerAvailablePaymentMethodsDAO(database);
    }

    @AppCoreScoped
    public static final ConsumerPaymentMethodsDAO providesConsumerPaymentMethodsDAO(Database<ConsumerDatabase> database) {
        return Companion.providesConsumerPaymentMethodsDAO(database);
    }
}