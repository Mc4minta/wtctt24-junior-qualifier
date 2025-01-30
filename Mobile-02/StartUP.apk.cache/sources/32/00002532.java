package com.coinbase.wallet.qr.parsers;

import com.coinbase.ciphercore.CipherCoreInterface;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class EthereumClassicQrCodeParser_Factory implements f.c.d<EthereumClassicQrCodeParser> {
    private final Provider<CipherCoreInterface> cipherCoreProvider;

    public EthereumClassicQrCodeParser_Factory(Provider<CipherCoreInterface> provider) {
        this.cipherCoreProvider = provider;
    }

    public static EthereumClassicQrCodeParser_Factory create(Provider<CipherCoreInterface> provider) {
        return new EthereumClassicQrCodeParser_Factory(provider);
    }

    public static EthereumClassicQrCodeParser newInstance(CipherCoreInterface cipherCoreInterface) {
        return new EthereumClassicQrCodeParser(cipherCoreInterface);
    }

    @Override // javax.inject.Provider
    public EthereumClassicQrCodeParser get() {
        return newInstance(this.cipherCoreProvider.get());
    }
}