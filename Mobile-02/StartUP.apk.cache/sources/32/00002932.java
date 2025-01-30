package com.coinbase.wallet.wallets.di;

import com.coinbase.wallet.blockchains.daos.AddressDao;
import com.coinbase.wallet.blockchains.daos.WalletDao;
import com.coinbase.wallet.blockchains.interfaces.WalletManaging;
import com.coinbase.wallet.blockchains.models.NetworkSetting;
import com.coinbase.wallet.compoundfinance.repositories.CompoundFinanceRepository;
import com.coinbase.wallet.core.interfaces.Tracing;
import com.coinbase.wallet.store.interfaces.StoreInterface;
import com.coinbase.wallet.wallets.apis.CryptoCurrencyAPI;
import com.coinbase.wallet.wallets.apis.WatchAddressAPI;
import com.coinbase.wallet.wallets.daos.CryptoCurrencyDAO;
import com.coinbase.wallet.wallets.interfaces.IWalletRepository;
import f.c.d;
import f.c.h;
import java.util.List;
import java.util.Set;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class WalletsModule_Companion_ProvidesWalletRepository$wallets_releaseFactory implements d<IWalletRepository> {
    private final Provider<AddressDao> addressDaoProvider;
    private final Provider<CompoundFinanceRepository> compoundFinanceRepositoryProvider;
    private final Provider<CryptoCurrencyAPI> cryptoCurrencyAPIProvider;
    private final Provider<CryptoCurrencyDAO> cryptoCurrencyDAOProvider;
    private final Provider<List<NetworkSetting>> networkSettingsProvider;
    private final Provider<Set<WalletManaging>> repositoriesProvider;
    private final Provider<StoreInterface> storeProvider;
    private final Provider<Tracing> tracerProvider;
    private final Provider<WalletDao> walletDaoProvider;
    private final Provider<WatchAddressAPI> watchAddressAPIProvider;

    public WalletsModule_Companion_ProvidesWalletRepository$wallets_releaseFactory(Provider<Set<WalletManaging>> provider, Provider<List<NetworkSetting>> provider2, Provider<WalletDao> provider3, Provider<CompoundFinanceRepository> provider4, Provider<StoreInterface> provider5, Provider<CryptoCurrencyDAO> provider6, Provider<CryptoCurrencyAPI> provider7, Provider<AddressDao> provider8, Provider<WatchAddressAPI> provider9, Provider<Tracing> provider10) {
        this.repositoriesProvider = provider;
        this.networkSettingsProvider = provider2;
        this.walletDaoProvider = provider3;
        this.compoundFinanceRepositoryProvider = provider4;
        this.storeProvider = provider5;
        this.cryptoCurrencyDAOProvider = provider6;
        this.cryptoCurrencyAPIProvider = provider7;
        this.addressDaoProvider = provider8;
        this.watchAddressAPIProvider = provider9;
        this.tracerProvider = provider10;
    }

    public static WalletsModule_Companion_ProvidesWalletRepository$wallets_releaseFactory create(Provider<Set<WalletManaging>> provider, Provider<List<NetworkSetting>> provider2, Provider<WalletDao> provider3, Provider<CompoundFinanceRepository> provider4, Provider<StoreInterface> provider5, Provider<CryptoCurrencyDAO> provider6, Provider<CryptoCurrencyAPI> provider7, Provider<AddressDao> provider8, Provider<WatchAddressAPI> provider9, Provider<Tracing> provider10) {
        return new WalletsModule_Companion_ProvidesWalletRepository$wallets_releaseFactory(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9, provider10);
    }

    public static IWalletRepository providesWalletRepository$wallets_release(Set<WalletManaging> set, List<NetworkSetting> list, WalletDao walletDao, CompoundFinanceRepository compoundFinanceRepository, StoreInterface storeInterface, CryptoCurrencyDAO cryptoCurrencyDAO, CryptoCurrencyAPI cryptoCurrencyAPI, AddressDao addressDao, WatchAddressAPI watchAddressAPI, Tracing tracing) {
        return (IWalletRepository) h.f(WalletsModule.Companion.providesWalletRepository$wallets_release(set, list, walletDao, compoundFinanceRepository, storeInterface, cryptoCurrencyDAO, cryptoCurrencyAPI, addressDao, watchAddressAPI, tracing));
    }

    @Override // javax.inject.Provider
    public IWalletRepository get() {
        return providesWalletRepository$wallets_release(this.repositoriesProvider.get(), this.networkSettingsProvider.get(), this.walletDaoProvider.get(), this.compoundFinanceRepositoryProvider.get(), this.storeProvider.get(), this.cryptoCurrencyDAOProvider.get(), this.cryptoCurrencyAPIProvider.get(), this.addressDaoProvider.get(), this.watchAddressAPIProvider.get(), this.tracerProvider.get());
    }
}