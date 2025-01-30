package com.coinbase.wallet.qr.parsers;

import com.coinbase.ciphercore.CipherCoreInterface;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class ERC20QRCodeParser_Factory implements f.c.d<ERC20QRCodeParser> {
    private final Provider<CipherCoreInterface> cipherCoreProvider;

    public ERC20QRCodeParser_Factory(Provider<CipherCoreInterface> provider) {
        this.cipherCoreProvider = provider;
    }

    public static ERC20QRCodeParser_Factory create(Provider<CipherCoreInterface> provider) {
        return new ERC20QRCodeParser_Factory(provider);
    }

    public static ERC20QRCodeParser newInstance(CipherCoreInterface cipherCoreInterface) {
        return new ERC20QRCodeParser(cipherCoreInterface);
    }

    @Override // javax.inject.Provider
    public ERC20QRCodeParser get() {
        return newInstance(this.cipherCoreProvider.get());
    }
}