package com.coinbase.wallet.swap.repositories;

import com.coinbase.ciphercore.CipherCoreInterface;
import com.coinbase.wallet.blockchains.daos.AddressDao;
import com.coinbase.wallet.ethereum.apis.ERC20ContractAPI;
import com.coinbase.wallet.ethereum.apis.MinerFeeAPI;
import com.coinbase.wallet.store.interfaces.StoreInterface;
import com.coinbase.wallet.swap.apis.SwapAPI;
import com.coinbase.wallet.swap.daos.SwapAssetStatsDAO;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class SwapRepository_Factory implements f.c.d<SwapRepository> {
    private final Provider<AddressDao> addressDaoProvider;
    private final Provider<SwapAPI> apiProvider;
    private final Provider<CipherCoreInterface> cipherCoreProvider;
    private final Provider<ERC20ContractAPI> erc20ContractAPIProvider;
    private final Provider<MinerFeeAPI> minerFeeAPIProvider;
    private final Provider<StoreInterface> storeProvider;
    private final Provider<SwapAssetStatsDAO> swapStatsDAOProvider;

    public SwapRepository_Factory(Provider<CipherCoreInterface> provider, Provider<AddressDao> provider2, Provider<ERC20ContractAPI> provider3, Provider<MinerFeeAPI> provider4, Provider<SwapAPI> provider5, Provider<SwapAssetStatsDAO> provider6, Provider<StoreInterface> provider7) {
        this.cipherCoreProvider = provider;
        this.addressDaoProvider = provider2;
        this.erc20ContractAPIProvider = provider3;
        this.minerFeeAPIProvider = provider4;
        this.apiProvider = provider5;
        this.swapStatsDAOProvider = provider6;
        this.storeProvider = provider7;
    }

    public static SwapRepository_Factory create(Provider<CipherCoreInterface> provider, Provider<AddressDao> provider2, Provider<ERC20ContractAPI> provider3, Provider<MinerFeeAPI> provider4, Provider<SwapAPI> provider5, Provider<SwapAssetStatsDAO> provider6, Provider<StoreInterface> provider7) {
        return new SwapRepository_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7);
    }

    public static SwapRepository newInstance(CipherCoreInterface cipherCoreInterface, AddressDao addressDao, ERC20ContractAPI eRC20ContractAPI, MinerFeeAPI minerFeeAPI, SwapAPI swapAPI, SwapAssetStatsDAO swapAssetStatsDAO, StoreInterface storeInterface) {
        return new SwapRepository(cipherCoreInterface, addressDao, eRC20ContractAPI, minerFeeAPI, swapAPI, swapAssetStatsDAO, storeInterface);
    }

    @Override // javax.inject.Provider
    public SwapRepository get() {
        return newInstance(this.cipherCoreProvider.get(), this.addressDaoProvider.get(), this.erc20ContractAPIProvider.get(), this.minerFeeAPIProvider.get(), this.apiProvider.get(), this.swapStatsDAOProvider.get(), this.storeProvider.get());
    }
}