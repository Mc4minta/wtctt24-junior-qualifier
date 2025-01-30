package com.coinbase.wallet.consumer.di;

import android.app.Application;
import com.coinbase.Coinbase;
import com.coinbase.android.apiv3.generated.authed.sends.Sends;
import com.coinbase.wallet.common.utilities.BuildConfigWrapper;
import com.coinbase.wallet.consumer.apis.ConsumerAPI;
import com.coinbase.wallet.consumer.apis.ConsumerAPIHttp;
import com.coinbase.wallet.consumer.apis.ConsumerAPI_Factory;
import com.coinbase.wallet.consumer.daos.ConsumerAccountsDAO;
import com.coinbase.wallet.consumer.daos.ConsumerAvailablePaymentMethodsDAO;
import com.coinbase.wallet.consumer.daos.ConsumerPaymentMethodsDAO;
import com.coinbase.wallet.consumer.db.ConsumerDatabase;
import com.coinbase.wallet.consumer.di.ConsumerCoreComponent;
import com.coinbase.wallet.consumer.models.ConsumerNetworkConfig;
import com.coinbase.wallet.consumer.models.ConsumerWebViewConfig;
import com.coinbase.wallet.libraries.databases.db.Database;
import com.coinbase.wallet.store.interfaces.StoreInterface;
import com.squareup.moshi.Moshi;
import f.c.c;
import f.c.d;
import f.c.e;
import f.c.h;
import javax.inject.Provider;
import retrofit2.t;

/* loaded from: classes.dex */
public final class DaggerConsumerCoreComponent implements ConsumerCoreComponent {
    private Provider<Application> appProvider;
    private Provider<BuildConfigWrapper> buildConfigWrapperProvider;
    private Provider<t> coinbaseRetrofitProvider;
    private Provider<t> coinbaseV3RetrofitProvider;
    private Provider<ConsumerAPI> consumerAPIProvider;
    private Provider<ConsumerAPIHttp> consumerApiProvider;
    private Provider<Sends> consumerApiV3Provider;
    private final DaggerConsumerCoreComponent consumerCoreComponent;
    private Provider<Moshi> moshiProvider;
    private final ConsumerNetworkConfig networkConfig;
    private Provider<ConsumerNetworkConfig> networkConfigProvider;
    private Provider<Database<ConsumerDatabase>> providesAppDatabaseProvider;
    private Provider<Coinbase> providesCoinbaseProvider;
    private Provider<ConsumerAccountsDAO> providesConsumerAccountsDAOProvider;
    private Provider<ConsumerAvailablePaymentMethodsDAO> providesConsumerAvailablePaymentMethodsDAOProvider;
    private Provider<ConsumerPaymentMethodsDAO> providesConsumerPaymentMethodsDAOProvider;
    private Provider<StoreInterface> storeProvider;
    private final ConsumerWebViewConfig webviewConfig;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class Factory implements ConsumerCoreComponent.Factory {
        private Factory() {
        }

        @Override // com.coinbase.wallet.consumer.di.ConsumerCoreComponent.Factory
        public ConsumerCoreComponent create(StoreInterface storeInterface, Application application, Moshi moshi, BuildConfigWrapper buildConfigWrapper, ConsumerNetworkConfig consumerNetworkConfig, ConsumerWebViewConfig consumerWebViewConfig) {
            h.b(storeInterface);
            h.b(application);
            h.b(moshi);
            h.b(buildConfigWrapper);
            h.b(consumerNetworkConfig);
            h.b(consumerWebViewConfig);
            return new DaggerConsumerCoreComponent(storeInterface, application, moshi, buildConfigWrapper, consumerNetworkConfig, consumerWebViewConfig);
        }
    }

    public static ConsumerCoreComponent.Factory factory() {
        return new Factory();
    }

    private void initialize(StoreInterface storeInterface, Application application, Moshi moshi, BuildConfigWrapper buildConfigWrapper, ConsumerNetworkConfig consumerNetworkConfig, ConsumerWebViewConfig consumerWebViewConfig) {
        d a = e.a(application);
        this.appProvider = a;
        this.providesAppDatabaseProvider = c.b(ConsumerModule_ProvidesAppDatabaseFactory.create(a));
        this.storeProvider = e.a(storeInterface);
        this.networkConfigProvider = e.a(consumerNetworkConfig);
        d a2 = e.a(buildConfigWrapper);
        this.buildConfigWrapperProvider = a2;
        this.providesCoinbaseProvider = c.b(ConsumerModule_ProvidesCoinbaseFactory.create(this.appProvider, this.storeProvider, this.networkConfigProvider, a2));
        this.providesConsumerAccountsDAOProvider = c.b(ConsumerModule_ProvidesConsumerAccountsDAOFactory.create(this.providesAppDatabaseProvider));
        this.providesConsumerPaymentMethodsDAOProvider = c.b(ConsumerModule_ProvidesConsumerPaymentMethodsDAOFactory.create(this.providesAppDatabaseProvider));
        this.providesConsumerAvailablePaymentMethodsDAOProvider = c.b(ConsumerModule_ProvidesConsumerAvailablePaymentMethodsDAOFactory.create(this.providesAppDatabaseProvider));
        d a3 = e.a(moshi);
        this.moshiProvider = a3;
        Provider<t> b2 = c.b(ConsumerModule_CoinbaseRetrofitFactory.create(this.providesCoinbaseProvider, a3));
        this.coinbaseRetrofitProvider = b2;
        this.consumerApiProvider = c.b(ConsumerModule_ConsumerApiFactory.create(b2));
        Provider<t> b3 = c.b(ConsumerModule_CoinbaseV3RetrofitFactory.create(this.providesCoinbaseProvider, this.networkConfigProvider));
        this.coinbaseV3RetrofitProvider = b3;
        Provider<Sends> b4 = c.b(ConsumerModule_ConsumerApiV3Factory.create(b3));
        this.consumerApiV3Provider = b4;
        this.consumerAPIProvider = c.b(ConsumerAPI_Factory.create(this.providesCoinbaseProvider, this.consumerApiProvider, b4));
    }

    @Override // com.coinbase.wallet.consumer.di.ConsumerCoreComponent
    public Coinbase coinbaseSdk() {
        return this.providesCoinbaseProvider.get();
    }

    @Override // com.coinbase.wallet.consumer.di.ConsumerCoreComponent
    public ConsumerAPI consumerAPI() {
        return this.consumerAPIProvider.get();
    }

    @Override // com.coinbase.wallet.consumer.di.ConsumerCoreComponent
    public ConsumerAccountsDAO consumerAccountsDAO() {
        return this.providesConsumerAccountsDAOProvider.get();
    }

    @Override // com.coinbase.wallet.consumer.di.ConsumerCoreComponent
    public ConsumerAvailablePaymentMethodsDAO consumerAvailablePaymentMethodsDAO() {
        return this.providesConsumerAvailablePaymentMethodsDAOProvider.get();
    }

    @Override // com.coinbase.wallet.consumer.di.ConsumerCoreComponent
    public Database<ConsumerDatabase> consumerDatabase() {
        return this.providesAppDatabaseProvider.get();
    }

    @Override // com.coinbase.wallet.consumer.di.ConsumerCoreComponent
    public ConsumerNetworkConfig consumerNetworkConfig() {
        return this.networkConfig;
    }

    @Override // com.coinbase.wallet.consumer.di.ConsumerCoreComponent
    public ConsumerPaymentMethodsDAO consumerPaymentMethodsDAO() {
        return this.providesConsumerPaymentMethodsDAOProvider.get();
    }

    @Override // com.coinbase.wallet.consumer.di.ConsumerCoreComponent
    public ConsumerWebViewConfig consumerWebviewConfig() {
        return this.webviewConfig;
    }

    private DaggerConsumerCoreComponent(StoreInterface storeInterface, Application application, Moshi moshi, BuildConfigWrapper buildConfigWrapper, ConsumerNetworkConfig consumerNetworkConfig, ConsumerWebViewConfig consumerWebViewConfig) {
        this.consumerCoreComponent = this;
        this.networkConfig = consumerNetworkConfig;
        this.webviewConfig = consumerWebViewConfig;
        initialize(storeInterface, application, moshi, buildConfigWrapper, consumerNetworkConfig, consumerWebViewConfig);
    }
}