package com.coinbase.wallet.ethereum.di;

import com.coinbase.ciphercore.CipherCoreInterface;
import com.coinbase.wallet.blockchains.daos.AddressDao;
import com.coinbase.wallet.blockchains.daos.WalletDao;
import com.coinbase.wallet.ethereum.apis.ERC20TokenAPI;
import com.coinbase.wallet.ethereum.apis.MinerFeeAPI;
import com.coinbase.wallet.ethereum.daos.ERC20Dao;
import com.coinbase.wallet.ethereum.daos.EthereumSignedTxDao;
import com.coinbase.wallet.ethereum.interfaces.IETCTxRepository;
import com.coinbase.wallet.store.interfaces.StoreInterface;
import f.c.d;
import f.c.h;
import javax.inject.Provider;

/* loaded from: classes.dex */
public final class EthereumModule_ProvidesETCTxRepository$ethereum_releaseFactory implements d<IETCTxRepository> {
    private final Provider<AddressDao> addressDaoProvider;
    private final Provider<CipherCoreInterface> cipherCoreProvider;
    private final Provider<ERC20Dao> erc20DaoProvider;
    private final Provider<ERC20TokenAPI> erc20TokenAPIProvider;
    private final Provider<EthereumSignedTxDao> ethereumSignedTxDaoProvider;
    private final Provider<MinerFeeAPI> minerFeeAPIProvider;
    private final Provider<StoreInterface> storeProvider;
    private final Provider<WalletDao> walletDaoProvider;

    public EthereumModule_ProvidesETCTxRepository$ethereum_releaseFactory(Provider<AddressDao> provider, Provider<EthereumSignedTxDao> provider2, Provider<WalletDao> provider3, Provider<ERC20Dao> provider4, Provider<MinerFeeAPI> provider5, Provider<ERC20TokenAPI> provider6, Provider<CipherCoreInterface> provider7, Provider<StoreInterface> provider8) {
        this.addressDaoProvider = provider;
        this.ethereumSignedTxDaoProvider = provider2;
        this.walletDaoProvider = provider3;
        this.erc20DaoProvider = provider4;
        this.minerFeeAPIProvider = provider5;
        this.erc20TokenAPIProvider = provider6;
        this.cipherCoreProvider = provider7;
        this.storeProvider = provider8;
    }

    public static EthereumModule_ProvidesETCTxRepository$ethereum_releaseFactory create(Provider<AddressDao> provider, Provider<EthereumSignedTxDao> provider2, Provider<WalletDao> provider3, Provider<ERC20Dao> provider4, Provider<MinerFeeAPI> provider5, Provider<ERC20TokenAPI> provider6, Provider<CipherCoreInterface> provider7, Provider<StoreInterface> provider8) {
        return new EthereumModule_ProvidesETCTxRepository$ethereum_releaseFactory(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8);
    }

    public static IETCTxRepository providesETCTxRepository$ethereum_release(AddressDao addressDao, EthereumSignedTxDao ethereumSignedTxDao, WalletDao walletDao, ERC20Dao eRC20Dao, MinerFeeAPI minerFeeAPI, ERC20TokenAPI eRC20TokenAPI, CipherCoreInterface cipherCoreInterface, StoreInterface storeInterface) {
        IETCTxRepository providesETCTxRepository$ethereum_release;
        providesETCTxRepository$ethereum_release = EthereumModule.Companion.providesETCTxRepository$ethereum_release(addressDao, ethereumSignedTxDao, walletDao, eRC20Dao, minerFeeAPI, eRC20TokenAPI, cipherCoreInterface, storeInterface);
        return (IETCTxRepository) h.f(providesETCTxRepository$ethereum_release);
    }

    @Override // javax.inject.Provider
    public IETCTxRepository get() {
        return providesETCTxRepository$ethereum_release(this.addressDaoProvider.get(), this.ethereumSignedTxDaoProvider.get(), this.walletDaoProvider.get(), this.erc20DaoProvider.get(), this.minerFeeAPIProvider.get(), this.erc20TokenAPIProvider.get(), this.cipherCoreProvider.get(), this.storeProvider.get());
    }
}