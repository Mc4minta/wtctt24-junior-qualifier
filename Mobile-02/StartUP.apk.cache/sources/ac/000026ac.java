package com.coinbase.wallet.swap.di;

import com.coinbase.ciphercore.CipherCoreInterface;
import com.coinbase.wallet.blockchains.daos.AddressDao;
import com.coinbase.wallet.ethereum.apis.ERC20ContractAPI;
import com.coinbase.wallet.ethereum.apis.MinerFeeAPI;
import com.coinbase.wallet.store.interfaces.StoreInterface;
import com.coinbase.wallet.swap.apis.SwapAPI;
import com.coinbase.wallet.swap.daos.SwapAssetStatsDAO;
import com.coinbase.wallet.swap.interfaces.ISwapRepository;
import f.c.d;
import f.c.h;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class SwapModule_Companion_ProvidesSwapRepositoryFactory implements d<ISwapRepository> {
    private final Provider<AddressDao> addressDaoProvider;
    private final Provider<CipherCoreInterface> cipherCoreProvider;
    private final Provider<ERC20ContractAPI> erc20ContractAPIProvider;
    private final Provider<MinerFeeAPI> minerFeeAPIProvider;
    private final Provider<StoreInterface> storeProvider;
    private final Provider<SwapAPI> swapAPIProvider;
    private final Provider<SwapAssetStatsDAO> swapAssetStatsDAOProvider;

    public SwapModule_Companion_ProvidesSwapRepositoryFactory(Provider<CipherCoreInterface> provider, Provider<AddressDao> provider2, Provider<MinerFeeAPI> provider3, Provider<ERC20ContractAPI> provider4, Provider<SwapAPI> provider5, Provider<SwapAssetStatsDAO> provider6, Provider<StoreInterface> provider7) {
        this.cipherCoreProvider = provider;
        this.addressDaoProvider = provider2;
        this.minerFeeAPIProvider = provider3;
        this.erc20ContractAPIProvider = provider4;
        this.swapAPIProvider = provider5;
        this.swapAssetStatsDAOProvider = provider6;
        this.storeProvider = provider7;
    }

    public static SwapModule_Companion_ProvidesSwapRepositoryFactory create(Provider<CipherCoreInterface> provider, Provider<AddressDao> provider2, Provider<MinerFeeAPI> provider3, Provider<ERC20ContractAPI> provider4, Provider<SwapAPI> provider5, Provider<SwapAssetStatsDAO> provider6, Provider<StoreInterface> provider7) {
        return new SwapModule_Companion_ProvidesSwapRepositoryFactory(provider, provider2, provider3, provider4, provider5, provider6, provider7);
    }

    public static ISwapRepository providesSwapRepository(CipherCoreInterface cipherCoreInterface, AddressDao addressDao, MinerFeeAPI minerFeeAPI, ERC20ContractAPI eRC20ContractAPI, SwapAPI swapAPI, SwapAssetStatsDAO swapAssetStatsDAO, StoreInterface storeInterface) {
        return (ISwapRepository) h.f(SwapModule.Companion.providesSwapRepository(cipherCoreInterface, addressDao, minerFeeAPI, eRC20ContractAPI, swapAPI, swapAssetStatsDAO, storeInterface));
    }

    @Override // javax.inject.Provider
    public ISwapRepository get() {
        return providesSwapRepository(this.cipherCoreProvider.get(), this.addressDaoProvider.get(), this.minerFeeAPIProvider.get(), this.erc20ContractAPIProvider.get(), this.swapAPIProvider.get(), this.swapAssetStatsDAOProvider.get(), this.storeProvider.get());
    }
}