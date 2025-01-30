package com.coinbase.wallet.qr.parsers;

import com.coinbase.wallet.wallets.interfaces.ITxRepository;
import com.coinbase.wallet.wallets.interfaces.IWalletRepository;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class LitecoinQrCodeParser_Factory implements f.c.d<LitecoinQrCodeParser> {
    private final Provider<ITxRepository> txRepositoryProvider;
    private final Provider<IWalletRepository> walletRepositoryProvider;

    public LitecoinQrCodeParser_Factory(Provider<ITxRepository> provider, Provider<IWalletRepository> provider2) {
        this.txRepositoryProvider = provider;
        this.walletRepositoryProvider = provider2;
    }

    public static LitecoinQrCodeParser_Factory create(Provider<ITxRepository> provider, Provider<IWalletRepository> provider2) {
        return new LitecoinQrCodeParser_Factory(provider, provider2);
    }

    public static LitecoinQrCodeParser newInstance(ITxRepository iTxRepository, IWalletRepository iWalletRepository) {
        return new LitecoinQrCodeParser(iTxRepository, iWalletRepository);
    }

    @Override // javax.inject.Provider
    public LitecoinQrCodeParser get() {
        return newInstance(this.txRepositoryProvider.get(), this.walletRepositoryProvider.get());
    }
}