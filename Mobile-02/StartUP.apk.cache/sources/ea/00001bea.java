package com.coinbase.wallet.ethereum.di;

import com.coinbase.ciphercore.CipherCoreInterface;
import com.coinbase.wallet.blockchains.daos.AddressDao;
import com.coinbase.wallet.blockchains.daos.WalletDao;
import com.coinbase.wallet.ethereum.apis.ERC20TokenAPI;
import com.coinbase.wallet.ethereum.daos.ERC20Dao;
import com.coinbase.wallet.ethereum.daos.EthereumSignedTxDao;
import com.coinbase.wallet.ethereum.interfaces.IETCWalletRepository;
import com.coinbase.wallet.store.interfaces.StoreInterface;
import f.c.d;
import f.c.h;
import javax.inject.Provider;

/* loaded from: classes.dex */
public final class EthereumModule_Companion_ProvidesETCWalletRepository$ethereum_releaseFactory implements d<IETCWalletRepository> {
    private final Provider<AddressDao> addressDaoProvider;
    private final Provider<CipherCoreInterface> cipherCoreProvider;
    private final Provider<ERC20TokenAPI> erc20APIProvider;
    private final Provider<ERC20Dao> erc20DaoProvider;
    private final Provider<EthereumSignedTxDao> ethereumSignedTxDaoProvider;
    private final Provider<StoreInterface> storeProvider;
    private final Provider<WalletDao> walletDaoProvider;

    public EthereumModule_Companion_ProvidesETCWalletRepository$ethereum_releaseFactory(Provider<AddressDao> provider, Provider<WalletDao> provider2, Provider<ERC20Dao> provider3, Provider<ERC20TokenAPI> provider4, Provider<StoreInterface> provider5, Provider<CipherCoreInterface> provider6, Provider<EthereumSignedTxDao> provider7) {
        this.addressDaoProvider = provider;
        this.walletDaoProvider = provider2;
        this.erc20DaoProvider = provider3;
        this.erc20APIProvider = provider4;
        this.storeProvider = provider5;
        this.cipherCoreProvider = provider6;
        this.ethereumSignedTxDaoProvider = provider7;
    }

    public static EthereumModule_Companion_ProvidesETCWalletRepository$ethereum_releaseFactory create(Provider<AddressDao> provider, Provider<WalletDao> provider2, Provider<ERC20Dao> provider3, Provider<ERC20TokenAPI> provider4, Provider<StoreInterface> provider5, Provider<CipherCoreInterface> provider6, Provider<EthereumSignedTxDao> provider7) {
        return new EthereumModule_Companion_ProvidesETCWalletRepository$ethereum_releaseFactory(provider, provider2, provider3, provider4, provider5, provider6, provider7);
    }

    public static IETCWalletRepository providesETCWalletRepository$ethereum_release(AddressDao addressDao, WalletDao walletDao, ERC20Dao eRC20Dao, ERC20TokenAPI eRC20TokenAPI, StoreInterface storeInterface, CipherCoreInterface cipherCoreInterface, EthereumSignedTxDao ethereumSignedTxDao) {
        return (IETCWalletRepository) h.f(EthereumModule.Companion.providesETCWalletRepository$ethereum_release(addressDao, walletDao, eRC20Dao, eRC20TokenAPI, storeInterface, cipherCoreInterface, ethereumSignedTxDao));
    }

    @Override // javax.inject.Provider
    public IETCWalletRepository get() {
        return providesETCWalletRepository$ethereum_release(this.addressDaoProvider.get(), this.walletDaoProvider.get(), this.erc20DaoProvider.get(), this.erc20APIProvider.get(), this.storeProvider.get(), this.cipherCoreProvider.get(), this.ethereumSignedTxDaoProvider.get());
    }
}