package com.coinbase.wallet.swap.di;

import android.app.Application;
import com.coinbase.ciphercore.CipherCoreInterface;
import com.coinbase.wallet.blockchains.daos.AddressDao;
import com.coinbase.wallet.ethereum.apis.ERC20ContractAPI;
import com.coinbase.wallet.ethereum.apis.MinerFeeAPI;
import com.coinbase.wallet.http.models.HTTPService;
import com.coinbase.wallet.libraries.databases.db.Database;
import com.coinbase.wallet.store.interfaces.StoreInterface;
import com.coinbase.wallet.swap.apis.SwapAPI;
import com.coinbase.wallet.swap.daos.SwapAssetStatsDAO;
import com.coinbase.wallet.swap.db.SwapDatabase;
import com.coinbase.wallet.swap.di.SwapComponent;
import com.coinbase.wallet.swap.interfaces.ISwapRepository;
import f.c.c;
import f.c.d;
import f.c.e;
import f.c.h;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class DaggerSwapComponent implements SwapComponent {
    private Provider<AddressDao> addressDaoProvider;
    private Provider<Application> applicationProvider;
    private Provider<CipherCoreInterface> cipherCoreProvider;
    private Provider<ERC20ContractAPI> erC20ContractAPIProvider;
    private Provider<MinerFeeAPI> minerFeeAPIProvider;
    private Provider<Database<SwapDatabase>> providesDatabaseProvider;
    private Provider<SwapAssetStatsDAO> providesSwapAssetStatsDAO$swap_releaseProvider;
    private Provider<ISwapRepository> providesSwapRepositoryProvider;
    private Provider<StoreInterface> storeProvider;
    private Provider<SwapAPI> swapAPI$swap_releaseProvider;
    private final DaggerSwapComponent swapComponent;
    private Provider<HTTPService> swapHTTPServiceProvider;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static final class Factory implements SwapComponent.Factory {
        private Factory() {
        }

        @Override // com.coinbase.wallet.swap.di.SwapComponent.Factory
        public SwapComponent create(Application application, CipherCoreInterface cipherCoreInterface, AddressDao addressDao, ERC20ContractAPI eRC20ContractAPI, MinerFeeAPI minerFeeAPI, HTTPService hTTPService, StoreInterface storeInterface) {
            h.b(application);
            h.b(cipherCoreInterface);
            h.b(addressDao);
            h.b(eRC20ContractAPI);
            h.b(minerFeeAPI);
            h.b(hTTPService);
            h.b(storeInterface);
            return new DaggerSwapComponent(application, cipherCoreInterface, addressDao, eRC20ContractAPI, minerFeeAPI, hTTPService, storeInterface);
        }
    }

    public static SwapComponent.Factory factory() {
        return new Factory();
    }

    private void initialize(Application application, CipherCoreInterface cipherCoreInterface, AddressDao addressDao, ERC20ContractAPI eRC20ContractAPI, MinerFeeAPI minerFeeAPI, HTTPService hTTPService, StoreInterface storeInterface) {
        this.cipherCoreProvider = e.a(cipherCoreInterface);
        this.addressDaoProvider = e.a(addressDao);
        this.minerFeeAPIProvider = e.a(minerFeeAPI);
        this.erC20ContractAPIProvider = e.a(eRC20ContractAPI);
        d a = e.a(hTTPService);
        this.swapHTTPServiceProvider = a;
        this.swapAPI$swap_releaseProvider = c.b(SwapModule_SwapAPI$swap_releaseFactory.create(a));
        d a2 = e.a(application);
        this.applicationProvider = a2;
        Provider<Database<SwapDatabase>> b2 = c.b(SwapModule_ProvidesDatabaseFactory.create(a2));
        this.providesDatabaseProvider = b2;
        this.providesSwapAssetStatsDAO$swap_releaseProvider = c.b(SwapModule_ProvidesSwapAssetStatsDAO$swap_releaseFactory.create(b2));
        d a3 = e.a(storeInterface);
        this.storeProvider = a3;
        this.providesSwapRepositoryProvider = c.b(SwapModule_ProvidesSwapRepositoryFactory.create(this.cipherCoreProvider, this.addressDaoProvider, this.minerFeeAPIProvider, this.erC20ContractAPIProvider, this.swapAPI$swap_releaseProvider, this.providesSwapAssetStatsDAO$swap_releaseProvider, a3));
    }

    @Override // com.coinbase.wallet.swap.di.SwapComponent
    public Database<SwapDatabase> swapDatabase() {
        return this.providesDatabaseProvider.get();
    }

    @Override // com.coinbase.wallet.swap.di.SwapComponent
    public ISwapRepository swapRepository() {
        return this.providesSwapRepositoryProvider.get();
    }

    private DaggerSwapComponent(Application application, CipherCoreInterface cipherCoreInterface, AddressDao addressDao, ERC20ContractAPI eRC20ContractAPI, MinerFeeAPI minerFeeAPI, HTTPService hTTPService, StoreInterface storeInterface) {
        this.swapComponent = this;
        initialize(application, cipherCoreInterface, addressDao, eRC20ContractAPI, minerFeeAPI, hTTPService, storeInterface);
    }
}