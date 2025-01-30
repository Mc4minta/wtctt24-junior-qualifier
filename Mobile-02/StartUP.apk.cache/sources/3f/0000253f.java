package com.coinbase.wallet.qr.parsers;

import com.coinbase.wallet.wallets.interfaces.ITxRepository;
import com.coinbase.wallet.wallets.interfaces.IWalletRepository;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class StellarQrCodeParser_Factory implements f.c.d<StellarQrCodeParser> {
    private final Provider<ITxRepository> txRepositoryProvider;
    private final Provider<IWalletRepository> walletRepositoryProvider;

    public StellarQrCodeParser_Factory(Provider<ITxRepository> provider, Provider<IWalletRepository> provider2) {
        this.txRepositoryProvider = provider;
        this.walletRepositoryProvider = provider2;
    }

    public static StellarQrCodeParser_Factory create(Provider<ITxRepository> provider, Provider<IWalletRepository> provider2) {
        return new StellarQrCodeParser_Factory(provider, provider2);
    }

    public static StellarQrCodeParser newInstance(ITxRepository iTxRepository, IWalletRepository iWalletRepository) {
        return new StellarQrCodeParser(iTxRepository, iWalletRepository);
    }

    @Override // javax.inject.Provider
    public StellarQrCodeParser get() {
        return newInstance(this.txRepositoryProvider.get(), this.walletRepositoryProvider.get());
    }
}