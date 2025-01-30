package com.coinbase.wallet.qr.parsers;

import com.coinbase.wallet.wallets.interfaces.ITxRepository;
import com.coinbase.wallet.wallets.interfaces.IWalletRepository;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class DogecoinQrCodeParser_Factory implements f.c.d<DogecoinQrCodeParser> {
    private final Provider<ITxRepository> txRepositoryProvider;
    private final Provider<IWalletRepository> walletRepositoryProvider;

    public DogecoinQrCodeParser_Factory(Provider<ITxRepository> provider, Provider<IWalletRepository> provider2) {
        this.txRepositoryProvider = provider;
        this.walletRepositoryProvider = provider2;
    }

    public static DogecoinQrCodeParser_Factory create(Provider<ITxRepository> provider, Provider<IWalletRepository> provider2) {
        return new DogecoinQrCodeParser_Factory(provider, provider2);
    }

    public static DogecoinQrCodeParser newInstance(ITxRepository iTxRepository, IWalletRepository iWalletRepository) {
        return new DogecoinQrCodeParser(iTxRepository, iWalletRepository);
    }

    @Override // javax.inject.Provider
    public DogecoinQrCodeParser get() {
        return newInstance(this.txRepositoryProvider.get(), this.walletRepositoryProvider.get());
    }
}