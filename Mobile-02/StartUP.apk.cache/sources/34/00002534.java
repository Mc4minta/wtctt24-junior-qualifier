package com.coinbase.wallet.qr.parsers;

import com.coinbase.ciphercore.CipherCoreInterface;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class EthereumQrCodeParser_Factory implements f.c.d<EthereumQrCodeParser> {
    private final Provider<CipherCoreInterface> cipherCoreProvider;

    public EthereumQrCodeParser_Factory(Provider<CipherCoreInterface> provider) {
        this.cipherCoreProvider = provider;
    }

    public static EthereumQrCodeParser_Factory create(Provider<CipherCoreInterface> provider) {
        return new EthereumQrCodeParser_Factory(provider);
    }

    public static EthereumQrCodeParser newInstance(CipherCoreInterface cipherCoreInterface) {
        return new EthereumQrCodeParser(cipherCoreInterface);
    }

    @Override // javax.inject.Provider
    public EthereumQrCodeParser get() {
        return newInstance(this.cipherCoreProvider.get());
    }
}