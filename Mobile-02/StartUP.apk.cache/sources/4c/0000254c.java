package com.coinbase.wallet.qr.parsers;

import com.coinbase.wallet.wallets.interfaces.ITxRepository;
import com.coinbase.wallet.wallets.interfaces.IWalletRepository;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class XRPQrCodeParser_Factory implements f.c.d<XRPQrCodeParser> {
    private final Provider<ITxRepository> txRepositoryProvider;
    private final Provider<IWalletRepository> walletRepositoryProvider;

    public XRPQrCodeParser_Factory(Provider<ITxRepository> provider, Provider<IWalletRepository> provider2) {
        this.txRepositoryProvider = provider;
        this.walletRepositoryProvider = provider2;
    }

    public static XRPQrCodeParser_Factory create(Provider<ITxRepository> provider, Provider<IWalletRepository> provider2) {
        return new XRPQrCodeParser_Factory(provider, provider2);
    }

    public static XRPQrCodeParser newInstance(ITxRepository iTxRepository, IWalletRepository iWalletRepository) {
        return new XRPQrCodeParser(iTxRepository, iWalletRepository);
    }

    @Override // javax.inject.Provider
    public XRPQrCodeParser get() {
        return newInstance(this.txRepositoryProvider.get(), this.walletRepositoryProvider.get());
    }
}