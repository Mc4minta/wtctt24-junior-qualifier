package com.coinbase.wallet.lending.di;

import android.app.Application;
import com.coinbase.wallet.blockchains.models.WalletAddress;
import com.coinbase.wallet.core.interfaces.Tracing;
import com.coinbase.wallet.lending.apis.LendAPI;
import com.coinbase.wallet.lending.daos.LendTokenDAO;
import com.coinbase.wallet.lending.db.LendDatabase;
import com.coinbase.wallet.lending.di.LendComponent;
import com.coinbase.wallet.lending.interfaces.ILendRepository;
import com.coinbase.wallet.libraries.databases.db.Database;
import com.coinbase.wallet.store.interfaces.StoreInterface;
import com.coinbase.walletengine.WalletEngine;
import f.c.c;
import f.c.d;
import f.c.e;
import f.c.h;
import h.c.s;
import javax.inject.Provider;

/* loaded from: classes.dex */
public final class DaggerLendComponent implements LendComponent {
    private Provider<Application> applicationProvider;
    private final DaggerLendComponent lendComponent;
    private Provider<Database<LendDatabase>> providesDatabaseProvider;
    private Provider<LendAPI> providesLendAPI$lending_releaseProvider;
    private Provider<ILendRepository> providesLendRepository$lending_releaseProvider;
    private Provider<LendTokenDAO> providesLendTokenDAO$lending_releaseProvider;
    private Provider<StoreInterface> storeProvider;
    private Provider<Tracing> tracerProvider;
    private Provider<s<WalletAddress>> walletAddressObservableProvider;
    private Provider<String> walletApiUrlProvider;
    private Provider<WalletEngine> walletEngineProvider;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class Factory implements LendComponent.Factory {
        private Factory() {
        }

        @Override // com.coinbase.wallet.lending.di.LendComponent.Factory
        public LendComponent create(Application application, WalletEngine walletEngine, s<WalletAddress> sVar, Tracing tracing, String str, StoreInterface storeInterface) {
            h.b(application);
            h.b(walletEngine);
            h.b(sVar);
            h.b(tracing);
            h.b(str);
            h.b(storeInterface);
            return new DaggerLendComponent(application, walletEngine, sVar, tracing, str, storeInterface);
        }
    }

    public static LendComponent.Factory factory() {
        return new Factory();
    }

    private void initialize(Application application, WalletEngine walletEngine, s<WalletAddress> sVar, Tracing tracing, String str, StoreInterface storeInterface) {
        this.walletEngineProvider = e.a(walletEngine);
        this.walletAddressObservableProvider = e.a(sVar);
        d a = e.a(application);
        this.applicationProvider = a;
        Provider<Database<LendDatabase>> b2 = c.b(LendModule_ProvidesDatabaseFactory.create(a));
        this.providesDatabaseProvider = b2;
        this.providesLendTokenDAO$lending_releaseProvider = c.b(LendModule_ProvidesLendTokenDAO$lending_releaseFactory.create(b2));
        this.tracerProvider = e.a(tracing);
        d a2 = e.a(str);
        this.walletApiUrlProvider = a2;
        this.providesLendAPI$lending_releaseProvider = c.b(LendModule_ProvidesLendAPI$lending_releaseFactory.create(a2));
        d a3 = e.a(storeInterface);
        this.storeProvider = a3;
        this.providesLendRepository$lending_releaseProvider = c.b(LendModule_ProvidesLendRepository$lending_releaseFactory.create(this.walletEngineProvider, this.walletAddressObservableProvider, this.providesLendTokenDAO$lending_releaseProvider, this.tracerProvider, this.providesLendAPI$lending_releaseProvider, a3));
    }

    @Override // com.coinbase.wallet.lending.di.LendContainer
    public Database<LendDatabase> lendDatabase() {
        return this.providesDatabaseProvider.get();
    }

    @Override // com.coinbase.wallet.lending.di.LendContainer
    public ILendRepository lendRepository() {
        return this.providesLendRepository$lending_releaseProvider.get();
    }

    private DaggerLendComponent(Application application, WalletEngine walletEngine, s<WalletAddress> sVar, Tracing tracing, String str, StoreInterface storeInterface) {
        this.lendComponent = this;
        initialize(application, walletEngine, sVar, tracing, str, storeInterface);
    }
}