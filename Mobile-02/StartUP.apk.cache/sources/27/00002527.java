package com.coinbase.wallet.qr.parsers;

import com.coinbase.wallet.wallets.interfaces.ITxRepository;
import com.coinbase.wallet.wallets.interfaces.IWalletRepository;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class BitcoinCashQrCodeParser_Factory implements f.c.d<BitcoinCashQrCodeParser> {
    private final Provider<ITxRepository> txRepositoryProvider;
    private final Provider<IWalletRepository> walletRepositoryProvider;

    public BitcoinCashQrCodeParser_Factory(Provider<ITxRepository> provider, Provider<IWalletRepository> provider2) {
        this.txRepositoryProvider = provider;
        this.walletRepositoryProvider = provider2;
    }

    public static BitcoinCashQrCodeParser_Factory create(Provider<ITxRepository> provider, Provider<IWalletRepository> provider2) {
        return new BitcoinCashQrCodeParser_Factory(provider, provider2);
    }

    public static BitcoinCashQrCodeParser newInstance(ITxRepository iTxRepository, IWalletRepository iWalletRepository) {
        return new BitcoinCashQrCodeParser(iTxRepository, iWalletRepository);
    }

    @Override // javax.inject.Provider
    public BitcoinCashQrCodeParser get() {
        return newInstance(this.txRepositoryProvider.get(), this.walletRepositoryProvider.get());
    }
}