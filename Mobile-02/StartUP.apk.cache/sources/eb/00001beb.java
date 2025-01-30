package com.coinbase.wallet.ethereum.di;

import com.coinbase.ciphercore.CipherCoreInterface;
import com.coinbase.wallet.blockchains.daos.AddressDao;
import com.coinbase.wallet.blockchains.daos.WalletDao;
import com.coinbase.wallet.ethereum.apis.ERC20TokenAPI;
import com.coinbase.wallet.ethereum.apis.MinerFeeAPI;
import com.coinbase.wallet.ethereum.daos.ERC20Dao;
import com.coinbase.wallet.ethereum.daos.EthereumSignedTxDao;
import com.coinbase.wallet.ethereum.interfaces.IETHTxRepository;
import com.coinbase.wallet.store.interfaces.StoreInterface;
import f.c.d;
import f.c.h;
import javax.inject.Provider;

/* loaded from: classes.dex */
public final class EthereumModule_Companion_ProvidesETHTxRepository$ethereum_releaseFactory implements d<IETHTxRepository> {
    private final Provider<AddressDao> addressDaoProvider;
    private final Provider<CipherCoreInterface> cipherCoreProvider;
    private final Provider<ERC20Dao> erc20DaoProvider;
    private final Provider<ERC20TokenAPI> erc20TokenAPIProvider;
    private final Provider<EthereumSignedTxDao> ethereumSignedTxDaoProvider;
    private final Provider<MinerFeeAPI> minerFeeAPIProvider;
    private final Provider<StoreInterface> storeProvider;
    private final Provider<WalletDao> walletDaoProvider;

    public EthereumModule_Companion_ProvidesETHTxRepository$ethereum_releaseFactory(Provider<AddressDao> provider, Provider<WalletDao> provider2, Provider<EthereumSignedTxDao> provider3, Provider<ERC20Dao> provider4, Provider<MinerFeeAPI> provider5, Provider<ERC20TokenAPI> provider6, Provider<CipherCoreInterface> provider7, Provider<StoreInterface> provider8) {
        this.addressDaoProvider = provider;
        this.walletDaoProvider = provider2;
        this.ethereumSignedTxDaoProvider = provider3;
        this.erc20DaoProvider = provider4;
        this.minerFeeAPIProvider = provider5;
        this.erc20TokenAPIProvider = provider6;
        this.cipherCoreProvider = provider7;
        this.storeProvider = provider8;
    }

    public static EthereumModule_Companion_ProvidesETHTxRepository$ethereum_releaseFactory create(Provider<AddressDao> provider, Provider<WalletDao> provider2, Provider<EthereumSignedTxDao> provider3, Provider<ERC20Dao> provider4, Provider<MinerFeeAPI> provider5, Provider<ERC20TokenAPI> provider6, Provider<CipherCoreInterface> provider7, Provider<StoreInterface> provider8) {
        return new EthereumModule_Companion_ProvidesETHTxRepository$ethereum_releaseFactory(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8);
    }

    public static IETHTxRepository providesETHTxRepository$ethereum_release(AddressDao addressDao, WalletDao walletDao, EthereumSignedTxDao ethereumSignedTxDao, ERC20Dao eRC20Dao, MinerFeeAPI minerFeeAPI, ERC20TokenAPI eRC20TokenAPI, CipherCoreInterface cipherCoreInterface, StoreInterface storeInterface) {
        return (IETHTxRepository) h.f(EthereumModule.Companion.providesETHTxRepository$ethereum_release(addressDao, walletDao, ethereumSignedTxDao, eRC20Dao, minerFeeAPI, eRC20TokenAPI, cipherCoreInterface, storeInterface));
    }

    @Override // javax.inject.Provider
    public IETHTxRepository get() {
        return providesETHTxRepository$ethereum_release(this.addressDaoProvider.get(), this.walletDaoProvider.get(), this.ethereumSignedTxDaoProvider.get(), this.erc20DaoProvider.get(), this.minerFeeAPIProvider.get(), this.erc20TokenAPIProvider.get(), this.cipherCoreProvider.get(), this.storeProvider.get());
    }
}