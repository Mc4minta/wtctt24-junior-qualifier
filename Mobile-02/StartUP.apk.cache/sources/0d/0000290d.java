package com.coinbase.wallet.wallets.di;

import android.app.Application;
import android.content.Context;
import androidx.room.s.a;
import com.coinbase.Coinbase;
import com.coinbase.ciphercore.CipherCoreInterface;
import com.coinbase.wallet.bip44wallets.apis.BatchBalanceAPI;
import com.coinbase.wallet.bip44wallets.apis.BatchBalanceAPI_Factory;
import com.coinbase.wallet.bip44wallets.daos.BIP44SignedTxDao;
import com.coinbase.wallet.bitcoin.services.BTCService;
import com.coinbase.wallet.bitcoincash.services.BCHService;
import com.coinbase.wallet.blockchains.daos.AddressDao;
import com.coinbase.wallet.blockchains.daos.WalletDao;
import com.coinbase.wallet.blockchains.interfaces.TxManaging;
import com.coinbase.wallet.blockchains.interfaces.WalletManaging;
import com.coinbase.wallet.blockchains.models.NetworkSetting;
import com.coinbase.wallet.compoundfinance.apis.CompoundFinanceAPI;
import com.coinbase.wallet.compoundfinance.daos.CompoundTokenDAO;
import com.coinbase.wallet.compoundfinance.repositories.CompoundFinanceRepository;
import com.coinbase.wallet.core.interfaces.Tracing;
import com.coinbase.wallet.dogecoin.services.DOGEService;
import com.coinbase.wallet.ethereum.apis.ERC20ContractAPI;
import com.coinbase.wallet.ethereum.apis.ERC20TokenAPI;
import com.coinbase.wallet.ethereum.apis.MinerFeeAPI;
import com.coinbase.wallet.ethereum.daos.ERC20Dao;
import com.coinbase.wallet.ethereum.daos.EthereumSignedTxDao;
import com.coinbase.wallet.ethereum.di.EthereumModule_Erc20API$ethereum_releaseFactory;
import com.coinbase.wallet.ethereum.di.EthereumModule_MinerFeeAPI$ethereum_releaseFactory;
import com.coinbase.wallet.ethereum.di.EthereumModule_ProvidesERC20Dao$ethereum_releaseFactory;
import com.coinbase.wallet.ethereum.di.EthereumModule_ProvidesERC20Fetching$ethereum_releaseFactory;
import com.coinbase.wallet.ethereum.di.EthereumModule_ProvidesETCTxRepository$ethereum_releaseFactory;
import com.coinbase.wallet.ethereum.di.EthereumModule_ProvidesETCWalletRepository$ethereum_releaseFactory;
import com.coinbase.wallet.ethereum.di.EthereumModule_ProvidesETHTxRepository$ethereum_releaseFactory;
import com.coinbase.wallet.ethereum.di.EthereumModule_ProvidesETHWalletRepository$ethereum_releaseFactory;
import com.coinbase.wallet.ethereum.di.EthereumModule_ProvidesEthTxDAO$ethereum_releaseFactory;
import com.coinbase.wallet.ethereum.interfaces.IERC20Fetching;
import com.coinbase.wallet.ethereum.interfaces.IETCTxRepository;
import com.coinbase.wallet.ethereum.interfaces.IETCWalletRepository;
import com.coinbase.wallet.ethereum.interfaces.IETHTxRepository;
import com.coinbase.wallet.ethereum.interfaces.IETHWalletRepository;
import com.coinbase.wallet.libraries.databases.db.Database;
import com.coinbase.wallet.litecoin.services.LTCService;
import com.coinbase.wallet.ripple.daos.XRPSignedTxDAO;
import com.coinbase.wallet.stellar.api.TimeAPI;
import com.coinbase.wallet.stellar.daos.StellarSignedTxDao;
import com.coinbase.wallet.store.interfaces.StoreInterface;
import com.coinbase.wallet.wallets.apis.CryptoCurrencyAPI;
import com.coinbase.wallet.wallets.apis.ExchangeRateAPI;
import com.coinbase.wallet.wallets.apis.FiatCurrencyAPI;
import com.coinbase.wallet.wallets.apis.WatchAddressAPI;
import com.coinbase.wallet.wallets.daos.CryptoCurrencyDAO;
import com.coinbase.wallet.wallets.daos.FiatCurrencyDAO;
import com.coinbase.wallet.wallets.daos.FiatExchangeRateDAO;
import com.coinbase.wallet.wallets.db.WalletsDatabase;
import com.coinbase.wallet.wallets.di.WalletsComponent;
import com.coinbase.wallet.wallets.formatters.CurrencyFormatter;
import com.coinbase.wallet.wallets.interfaces.IExchangeRateRepository;
import com.coinbase.wallet.wallets.interfaces.IFiatCurrencyRepository;
import com.coinbase.wallet.wallets.interfaces.ITxRepository;
import com.coinbase.wallet.wallets.interfaces.IWalletRepository;
import com.coinbase.walletengine.WalletEngine;
import com.coinbase.walletengine.services.stellar.StellarService;
import com.coinbase.walletengine.services.xrp.XRPService;
import f.c.c;
import f.c.d;
import f.c.e;
import f.c.h;
import f.c.i;
import java.util.List;
import java.util.Set;
import javax.inject.Provider;
import retrofit2.t;

/* loaded from: classes2.dex */
public final class DaggerWalletsComponent implements WalletsComponent {
    private Provider<Application> applicationProvider;
    private Provider<BatchBalanceAPI> batchBalanceAPIProvider;
    private Provider<CipherCoreInterface> cipherCoreProvider;
    private Provider<Coinbase> coinbaseProvider;
    private Provider<CompoundFinanceAPI> compoundFinanceAPIProvider;
    private Provider<Context> contextProvider;
    private Provider<CryptoCurrencyAPI> cryptoCurrencyAPI$wallets_releaseProvider;
    private Provider<CurrencyFormatter> currencyFormatterProvider;
    private Provider<ERC20TokenAPI> erc20API$ethereum_releaseProvider;
    private Provider<ERC20ContractAPI> erc20ContractAPIProvider;
    private Provider<ExchangeRateAPI> exchangeRateAPI$wallets_releaseProvider;
    private Provider<FiatCurrencyAPI> fiatCurrencyAPI$wallets_releaseProvider;
    private Provider<MinerFeeAPI> minerFeeAPI$ethereum_releaseProvider;
    private Provider<IExchangeRateRepository> provideExchangeRateRepository$wallets_releaseProvider;
    private Provider<IFiatCurrencyRepository> provideFiatCurrencyRepository$wallets_releaseProvider;
    private Provider<AddressDao> providesAddressDaoProvider;
    private Provider<BCHService> providesBCHServiceProvider;
    private Provider<TxManaging> providesBCHTxManaging$wallets_releaseProvider;
    private Provider<WalletManaging> providesBCHWalletRepositoryProvider;
    private Provider<BTCService> providesBTCServiceProvider;
    private Provider<TxManaging> providesBTCTxManaging$wallets_releaseProvider;
    private Provider<WalletManaging> providesBTCWalletRepositoryProvider;
    private Provider<BIP44SignedTxDao> providesBtcTxDAOProvider;
    private Provider<CompoundFinanceRepository> providesCompoundFinanceRepositoryProvider;
    private Provider<CompoundTokenDAO> providesCompoundTokenDAOProvider;
    private Provider<CryptoCurrencyDAO> providesCryptoCurrencyDao$wallets_releaseProvider;
    private Provider<DOGEService> providesDOGEServiceProvider;
    private Provider<TxManaging> providesDOGETxManaging$wallets_releaseProvider;
    private Provider<WalletManaging> providesDOGEWalletRepositoryProvider;
    private Provider<Database<WalletsDatabase>> providesDatabaseProvider;
    private Provider<ERC20Dao> providesERC20Dao$ethereum_releaseProvider;
    private Provider<IERC20Fetching> providesERC20Fetching$ethereum_releaseProvider;
    private Provider<IETCTxRepository> providesETCTxRepository$ethereum_releaseProvider;
    private Provider<IETCWalletRepository> providesETCWalletRepository$ethereum_releaseProvider;
    private Provider<IETHTxRepository> providesETHTxRepository$ethereum_releaseProvider;
    private Provider<IETHWalletRepository> providesETHWalletRepository$ethereum_releaseProvider;
    private Provider<EthereumSignedTxDao> providesEthTxDAO$ethereum_releaseProvider;
    private Provider<FiatCurrencyDAO> providesFiatCurrencyDao$wallets_releaseProvider;
    private Provider<FiatExchangeRateDAO> providesFiatExchangeRateDao$wallets_releaseProvider;
    private Provider<LTCService> providesLTCServiceProvider;
    private Provider<TxManaging> providesLTCTxManaging$wallets_releaseProvider;
    private Provider<WalletManaging> providesLTCWalletRepositoryProvider;
    private Provider<List<a>> providesMigrationsProvider;
    private Provider<List<NetworkSetting>> providesNetworkSettingsProvider;
    private Provider<StellarService> providesStellarServiceProvider;
    private Provider<StellarSignedTxDao> providesStellarTxDAOProvider;
    private Provider<TxManaging> providesStellarTxManaging$wallets_releaseProvider;
    private Provider<WalletManaging> providesStellarWalletRepositoryProvider;
    private Provider<List<TxManaging>> providesTxManagingListProvider;
    private Provider<ITxRepository> providesTxRepository$wallets_releaseProvider;
    private Provider<WalletDao> providesWalletDaoProvider;
    private Provider<WalletEngine> providesWalletEngineProvider;
    private Provider<IWalletRepository> providesWalletRepository$wallets_releaseProvider;
    private Provider<XRPService> providesXRPServiceProvider;
    private Provider<TxManaging> providesXRPTxManaging$wallets_releaseProvider;
    private Provider<WalletManaging> providesXRPWalletRepositoryProvider;
    private Provider<XRPSignedTxDAO> providesXrpTxDAOProvider;
    private Provider<t> retrofitProvider;
    private Provider<Set<TxManaging>> setOfTxManagingProvider;
    private Provider<Set<WalletManaging>> setOfWalletManagingProvider;
    private Provider<StoreInterface> storeProvider;
    private Provider<TimeAPI> timeApiProvider;
    private Provider<Tracing> tracerProvider;
    private Provider<String> walletApiUrlProvider;
    private Provider<String> walletBlockchainUrlProvider;
    private Provider<String> walletXRPNodeUrlProvider;
    private final DaggerWalletsComponent walletsComponent;
    private Provider<WatchAddressAPI> watchAddressAPI$wallets_releaseProvider;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static final class Factory implements WalletsComponent.Factory {
        private Factory() {
        }

        @Override // com.coinbase.wallet.wallets.di.WalletsComponent.Factory
        public WalletsComponent create(t tVar, StoreInterface storeInterface, Coinbase coinbase, CipherCoreInterface cipherCoreInterface, Application application, Context context, Tracing tracing, String str, String str2, String str3) {
            h.b(tVar);
            h.b(storeInterface);
            h.b(coinbase);
            h.b(cipherCoreInterface);
            h.b(application);
            h.b(context);
            h.b(tracing);
            h.b(str);
            h.b(str2);
            h.b(str3);
            return new DaggerWalletsComponent(tVar, storeInterface, coinbase, cipherCoreInterface, application, context, tracing, str, str2, str3);
        }
    }

    public static WalletsComponent.Factory factory() {
        return new Factory();
    }

    private void initialize(t tVar, StoreInterface storeInterface, Coinbase coinbase, CipherCoreInterface cipherCoreInterface, Application application, Context context, Tracing tracing, String str, String str2, String str3) {
        this.applicationProvider = e.a(application);
        Provider<List<a>> b2 = c.b(DAOModule_ProvidesMigrationsFactory.create());
        this.providesMigrationsProvider = b2;
        Provider<Database<WalletsDatabase>> b3 = c.b(DAOModule_ProvidesDatabaseFactory.create(this.applicationProvider, b2));
        this.providesDatabaseProvider = b3;
        this.providesAddressDaoProvider = c.b(DAOModule_ProvidesAddressDaoFactory.create(b3));
        this.providesWalletDaoProvider = c.b(DAOModule_ProvidesWalletDaoFactory.create(this.providesDatabaseProvider));
        this.storeProvider = e.a(storeInterface);
        this.cipherCoreProvider = e.a(cipherCoreInterface);
        this.contextProvider = e.a(context);
        this.tracerProvider = e.a(tracing);
        this.walletApiUrlProvider = e.a(str);
        this.walletBlockchainUrlProvider = e.a(str2);
        d a = e.a(str3);
        this.walletXRPNodeUrlProvider = a;
        Provider<WalletEngine> b4 = c.b(WalletsModule_ProvidesWalletEngineFactory.create(this.contextProvider, this.tracerProvider, this.walletApiUrlProvider, this.walletBlockchainUrlProvider, a));
        this.providesWalletEngineProvider = b4;
        this.providesBTCServiceProvider = c.b(WalletsModule_ProvidesBTCServiceFactory.create(b4));
        Provider<BatchBalanceAPI> b5 = c.b(BatchBalanceAPI_Factory.create());
        this.batchBalanceAPIProvider = b5;
        this.providesBTCWalletRepositoryProvider = c.b(WalletsRepositoriesModule_ProvidesBTCWalletRepositoryFactory.create(this.providesAddressDaoProvider, this.providesWalletDaoProvider, this.storeProvider, this.cipherCoreProvider, this.providesBTCServiceProvider, this.tracerProvider, b5));
        Provider<BCHService> b6 = c.b(WalletsModule_ProvidesBCHServiceFactory.create(this.providesWalletEngineProvider));
        this.providesBCHServiceProvider = b6;
        this.providesBCHWalletRepositoryProvider = c.b(WalletsRepositoriesModule_ProvidesBCHWalletRepositoryFactory.create(this.providesAddressDaoProvider, this.providesWalletDaoProvider, this.storeProvider, this.cipherCoreProvider, b6, this.tracerProvider, this.batchBalanceAPIProvider));
        Provider<LTCService> b7 = c.b(WalletsModule_ProvidesLTCServiceFactory.create(this.providesWalletEngineProvider));
        this.providesLTCServiceProvider = b7;
        this.providesLTCWalletRepositoryProvider = c.b(WalletsRepositoriesModule_ProvidesLTCWalletRepositoryFactory.create(this.providesAddressDaoProvider, this.providesWalletDaoProvider, this.storeProvider, this.cipherCoreProvider, b7, this.tracerProvider, this.batchBalanceAPIProvider));
        Provider<DOGEService> b8 = c.b(WalletsModule_ProvidesDOGEServiceFactory.create(this.providesWalletEngineProvider));
        this.providesDOGEServiceProvider = b8;
        this.providesDOGEWalletRepositoryProvider = c.b(WalletsRepositoriesModule_ProvidesDOGEWalletRepositoryFactory.create(this.providesAddressDaoProvider, this.providesWalletDaoProvider, this.storeProvider, this.cipherCoreProvider, b8, this.tracerProvider, this.batchBalanceAPIProvider));
        this.providesXRPServiceProvider = c.b(WalletsModule_ProvidesXRPServiceFactory.create(this.providesWalletEngineProvider));
        Provider<XRPSignedTxDAO> b9 = c.b(DAOModule_ProvidesXrpTxDAOFactory.create(this.providesDatabaseProvider));
        this.providesXrpTxDAOProvider = b9;
        this.providesXRPWalletRepositoryProvider = c.b(WalletsRepositoriesModule_ProvidesXRPWalletRepositoryFactory.create(this.providesAddressDaoProvider, this.providesWalletDaoProvider, this.storeProvider, this.cipherCoreProvider, this.providesXRPServiceProvider, b9));
        Provider<StellarService> b10 = c.b(WalletsModule_ProvidesStellarServiceFactory.create(this.providesWalletEngineProvider));
        this.providesStellarServiceProvider = b10;
        this.providesStellarWalletRepositoryProvider = c.b(WalletsRepositoriesModule_ProvidesStellarWalletRepositoryFactory.create(this.providesAddressDaoProvider, this.providesWalletDaoProvider, this.cipherCoreProvider, b10));
        this.providesERC20Dao$ethereum_releaseProvider = c.b(EthereumModule_ProvidesERC20Dao$ethereum_releaseFactory.create(this.providesDatabaseProvider));
        d a2 = e.a(tVar);
        this.retrofitProvider = a2;
        this.erc20API$ethereum_releaseProvider = c.b(EthereumModule_Erc20API$ethereum_releaseFactory.create(a2));
        Provider<EthereumSignedTxDao> b11 = c.b(EthereumModule_ProvidesEthTxDAO$ethereum_releaseFactory.create(this.providesDatabaseProvider));
        this.providesEthTxDAO$ethereum_releaseProvider = b11;
        this.providesETHWalletRepository$ethereum_releaseProvider = c.b(EthereumModule_ProvidesETHWalletRepository$ethereum_releaseFactory.create(this.providesAddressDaoProvider, this.providesWalletDaoProvider, this.providesERC20Dao$ethereum_releaseProvider, this.erc20API$ethereum_releaseProvider, this.storeProvider, this.cipherCoreProvider, b11));
        this.providesETCWalletRepository$ethereum_releaseProvider = c.b(EthereumModule_ProvidesETCWalletRepository$ethereum_releaseFactory.create(this.providesAddressDaoProvider, this.providesWalletDaoProvider, this.providesERC20Dao$ethereum_releaseProvider, this.erc20API$ethereum_releaseProvider, this.storeProvider, this.cipherCoreProvider, this.providesEthTxDAO$ethereum_releaseProvider));
        this.setOfWalletManagingProvider = i.a(8, 0).a(this.providesBTCWalletRepositoryProvider).a(this.providesBCHWalletRepositoryProvider).a(this.providesLTCWalletRepositoryProvider).a(this.providesDOGEWalletRepositoryProvider).a(this.providesXRPWalletRepositoryProvider).a(this.providesStellarWalletRepositoryProvider).a(this.providesETHWalletRepository$ethereum_releaseProvider).a(this.providesETCWalletRepository$ethereum_releaseProvider).b();
        this.providesNetworkSettingsProvider = c.b(WalletsModule_ProvidesNetworkSettingsFactory.create());
        this.compoundFinanceAPIProvider = c.b(APIModule_CompoundFinanceAPIFactory.create(this.walletApiUrlProvider));
        Provider<CompoundTokenDAO> b12 = c.b(DAOModule_ProvidesCompoundTokenDAOFactory.create(this.providesDatabaseProvider));
        this.providesCompoundTokenDAOProvider = b12;
        this.providesCompoundFinanceRepositoryProvider = c.b(WalletsModule_ProvidesCompoundFinanceRepositoryFactory.create(this.compoundFinanceAPIProvider, b12));
        this.providesCryptoCurrencyDao$wallets_releaseProvider = c.b(DAOModule_ProvidesCryptoCurrencyDao$wallets_releaseFactory.create(this.providesDatabaseProvider));
        this.cryptoCurrencyAPI$wallets_releaseProvider = c.b(APIModule_CryptoCurrencyAPI$wallets_releaseFactory.create(this.retrofitProvider));
        Provider<WatchAddressAPI> b13 = c.b(APIModule_WatchAddressAPI$wallets_releaseFactory.create(this.retrofitProvider));
        this.watchAddressAPI$wallets_releaseProvider = b13;
        this.providesWalletRepository$wallets_releaseProvider = c.b(WalletsModule_ProvidesWalletRepository$wallets_releaseFactory.create(this.setOfWalletManagingProvider, this.providesNetworkSettingsProvider, this.providesWalletDaoProvider, this.providesCompoundFinanceRepositoryProvider, this.storeProvider, this.providesCryptoCurrencyDao$wallets_releaseProvider, this.cryptoCurrencyAPI$wallets_releaseProvider, this.providesAddressDaoProvider, b13, this.tracerProvider));
        Provider<BIP44SignedTxDao> b14 = c.b(DAOModule_ProvidesBtcTxDAOFactory.create(this.providesDatabaseProvider));
        this.providesBtcTxDAOProvider = b14;
        this.providesBTCTxManaging$wallets_releaseProvider = c.b(TxManagingModule_ProvidesBTCTxManaging$wallets_releaseFactory.create(this.providesBTCServiceProvider, this.providesAddressDaoProvider, this.providesWalletDaoProvider, b14, this.cipherCoreProvider, this.storeProvider, this.tracerProvider, this.batchBalanceAPIProvider));
        this.providesBCHTxManaging$wallets_releaseProvider = c.b(TxManagingModule_ProvidesBCHTxManaging$wallets_releaseFactory.create(this.providesBCHServiceProvider, this.providesAddressDaoProvider, this.providesWalletDaoProvider, this.providesBtcTxDAOProvider, this.cipherCoreProvider, this.storeProvider, this.tracerProvider, this.batchBalanceAPIProvider));
        this.providesLTCTxManaging$wallets_releaseProvider = c.b(TxManagingModule_ProvidesLTCTxManaging$wallets_releaseFactory.create(this.providesLTCServiceProvider, this.providesAddressDaoProvider, this.providesWalletDaoProvider, this.providesBtcTxDAOProvider, this.cipherCoreProvider, this.storeProvider, this.tracerProvider, this.batchBalanceAPIProvider));
        this.providesDOGETxManaging$wallets_releaseProvider = c.b(TxManagingModule_ProvidesDOGETxManaging$wallets_releaseFactory.create(this.providesDOGEServiceProvider, this.providesAddressDaoProvider, this.providesWalletDaoProvider, this.providesBtcTxDAOProvider, this.cipherCoreProvider, this.storeProvider, this.tracerProvider, this.batchBalanceAPIProvider));
        this.providesXRPTxManaging$wallets_releaseProvider = c.b(TxManagingModule_ProvidesXRPTxManaging$wallets_releaseFactory.create(this.cipherCoreProvider, this.providesXrpTxDAOProvider, this.providesXRPServiceProvider, this.providesAddressDaoProvider, this.providesWalletDaoProvider, this.storeProvider));
        this.providesStellarTxDAOProvider = c.b(DAOModule_ProvidesStellarTxDAOFactory.create(this.providesDatabaseProvider));
        Provider<TimeAPI> b15 = c.b(APIModule_TimeApiFactory.create(this.retrofitProvider));
        this.timeApiProvider = b15;
        this.providesStellarTxManaging$wallets_releaseProvider = c.b(TxManagingModule_ProvidesStellarTxManaging$wallets_releaseFactory.create(this.providesStellarTxDAOProvider, this.cipherCoreProvider, b15, this.providesStellarServiceProvider, this.providesAddressDaoProvider, this.providesWalletDaoProvider));
        Provider<MinerFeeAPI> b16 = c.b(EthereumModule_MinerFeeAPI$ethereum_releaseFactory.create(this.retrofitProvider));
        this.minerFeeAPI$ethereum_releaseProvider = b16;
        this.providesETHTxRepository$ethereum_releaseProvider = c.b(EthereumModule_ProvidesETHTxRepository$ethereum_releaseFactory.create(this.providesAddressDaoProvider, this.providesWalletDaoProvider, this.providesEthTxDAO$ethereum_releaseProvider, this.providesERC20Dao$ethereum_releaseProvider, b16, this.erc20API$ethereum_releaseProvider, this.cipherCoreProvider, this.storeProvider));
        this.providesETCTxRepository$ethereum_releaseProvider = c.b(EthereumModule_ProvidesETCTxRepository$ethereum_releaseFactory.create(this.providesAddressDaoProvider, this.providesEthTxDAO$ethereum_releaseProvider, this.providesWalletDaoProvider, this.providesERC20Dao$ethereum_releaseProvider, this.minerFeeAPI$ethereum_releaseProvider, this.erc20API$ethereum_releaseProvider, this.cipherCoreProvider, this.storeProvider));
        i b17 = i.a(8, 0).a(this.providesBTCTxManaging$wallets_releaseProvider).a(this.providesBCHTxManaging$wallets_releaseProvider).a(this.providesLTCTxManaging$wallets_releaseProvider).a(this.providesDOGETxManaging$wallets_releaseProvider).a(this.providesXRPTxManaging$wallets_releaseProvider).a(this.providesStellarTxManaging$wallets_releaseProvider).a(this.providesETHTxRepository$ethereum_releaseProvider).a(this.providesETCTxRepository$ethereum_releaseProvider).b();
        this.setOfTxManagingProvider = b17;
        Provider<List<TxManaging>> b18 = c.b(TxManagingModule_ProvidesTxManagingListFactory.create(b17));
        this.providesTxManagingListProvider = b18;
        this.providesTxRepository$wallets_releaseProvider = c.b(WalletsModule_ProvidesTxRepository$wallets_releaseFactory.create(b18, this.storeProvider, this.providesNetworkSettingsProvider, this.tracerProvider));
        this.fiatCurrencyAPI$wallets_releaseProvider = c.b(APIModule_FiatCurrencyAPI$wallets_releaseFactory.create(this.retrofitProvider));
        Provider<FiatCurrencyDAO> b19 = c.b(DAOModule_ProvidesFiatCurrencyDao$wallets_releaseFactory.create(this.providesDatabaseProvider));
        this.providesFiatCurrencyDao$wallets_releaseProvider = b19;
        this.provideFiatCurrencyRepository$wallets_releaseProvider = c.b(WalletsRepositoriesModule_ProvideFiatCurrencyRepository$wallets_releaseFactory.create(this.storeProvider, this.fiatCurrencyAPI$wallets_releaseProvider, b19));
        d a3 = e.a(coinbase);
        this.coinbaseProvider = a3;
        this.exchangeRateAPI$wallets_releaseProvider = c.b(APIModule_ExchangeRateAPI$wallets_releaseFactory.create(this.retrofitProvider, a3));
        Provider<FiatExchangeRateDAO> b20 = c.b(DAOModule_ProvidesFiatExchangeRateDao$wallets_releaseFactory.create(this.providesDatabaseProvider));
        this.providesFiatExchangeRateDao$wallets_releaseProvider = b20;
        this.provideExchangeRateRepository$wallets_releaseProvider = c.b(WalletsRepositoriesModule_ProvideExchangeRateRepository$wallets_releaseFactory.create(this.provideFiatCurrencyRepository$wallets_releaseProvider, this.exchangeRateAPI$wallets_releaseProvider, this.providesCompoundFinanceRepositoryProvider, b20, this.providesWalletRepository$wallets_releaseProvider, this.tracerProvider));
        this.providesERC20Fetching$ethereum_releaseProvider = c.b(EthereumModule_ProvidesERC20Fetching$ethereum_releaseFactory.create(this.cipherCoreProvider));
        this.currencyFormatterProvider = c.b(WalletsModule_CurrencyFormatterFactory.create(this.storeProvider, this.provideExchangeRateRepository$wallets_releaseProvider));
        this.erc20ContractAPIProvider = c.b(APIModule_Erc20ContractAPIFactory.create());
    }

    @Override // com.coinbase.wallet.wallets.di.WalletsComponent
    public AddressDao addressDao() {
        return this.providesAddressDaoProvider.get();
    }

    @Override // com.coinbase.wallet.wallets.di.WalletsComponent
    public CompoundFinanceRepository compoundFinanceRepository() {
        return this.providesCompoundFinanceRepositoryProvider.get();
    }

    @Override // com.coinbase.wallet.wallets.di.WalletsComponent
    public CurrencyFormatter currencyFormatter() {
        return this.currencyFormatterProvider.get();
    }

    @Override // com.coinbase.wallet.wallets.di.WalletsComponent
    public ERC20ContractAPI erc20ContractAPI() {
        return this.erc20ContractAPIProvider.get();
    }

    @Override // com.coinbase.wallet.wallets.di.WalletsComponent
    public IERC20Fetching erc20Fetching() {
        return this.providesERC20Fetching$ethereum_releaseProvider.get();
    }

    @Override // com.coinbase.wallet.wallets.di.WalletsComponent
    public IETCWalletRepository etcWalletRepository() {
        return this.providesETCWalletRepository$ethereum_releaseProvider.get();
    }

    @Override // com.coinbase.wallet.wallets.di.WalletsComponent
    public IETHTxRepository ethTxRepository() {
        return this.providesETHTxRepository$ethereum_releaseProvider.get();
    }

    @Override // com.coinbase.wallet.wallets.di.WalletsComponent
    public IETHWalletRepository ethWalletRepository() {
        return this.providesETHWalletRepository$ethereum_releaseProvider.get();
    }

    @Override // com.coinbase.wallet.wallets.di.WalletsComponent
    public EthereumSignedTxDao ethereumSignedTxDao() {
        return this.providesEthTxDAO$ethereum_releaseProvider.get();
    }

    @Override // com.coinbase.wallet.wallets.di.WalletsComponent
    public IExchangeRateRepository exchangeRateRepository() {
        return this.provideExchangeRateRepository$wallets_releaseProvider.get();
    }

    @Override // com.coinbase.wallet.wallets.di.WalletsComponent
    public IFiatCurrencyRepository fiatCurrencyRepository() {
        return this.provideFiatCurrencyRepository$wallets_releaseProvider.get();
    }

    @Override // com.coinbase.wallet.wallets.di.WalletsComponent
    public MinerFeeAPI minerFeeAPI() {
        return this.minerFeeAPI$ethereum_releaseProvider.get();
    }

    @Override // com.coinbase.wallet.wallets.di.WalletsComponent
    public List<NetworkSetting> networkSettings() {
        return this.providesNetworkSettingsProvider.get();
    }

    @Override // com.coinbase.wallet.wallets.di.WalletsComponent
    public ITxRepository txRepository() {
        return this.providesTxRepository$wallets_releaseProvider.get();
    }

    @Override // com.coinbase.wallet.wallets.di.WalletsComponent
    public WalletEngine walletEngine() {
        return this.providesWalletEngineProvider.get();
    }

    @Override // com.coinbase.wallet.wallets.di.WalletsComponent
    public IWalletRepository walletRepository() {
        return this.providesWalletRepository$wallets_releaseProvider.get();
    }

    @Override // com.coinbase.wallet.wallets.di.WalletsComponent
    public Database<WalletsDatabase> walletsDatabase() {
        return this.providesDatabaseProvider.get();
    }

    @Override // com.coinbase.wallet.wallets.di.WalletsComponent
    public XRPService xrpService() {
        return this.providesXRPServiceProvider.get();
    }

    private DaggerWalletsComponent(t tVar, StoreInterface storeInterface, Coinbase coinbase, CipherCoreInterface cipherCoreInterface, Application application, Context context, Tracing tracing, String str, String str2, String str3) {
        this.walletsComponent = this;
        initialize(tVar, storeInterface, coinbase, cipherCoreInterface, application, context, tracing, str, str2, str3);
    }
}