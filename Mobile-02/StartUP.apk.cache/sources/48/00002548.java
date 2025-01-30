package com.coinbase.wallet.qr.parsers;

/* loaded from: classes2.dex */
public final class WalletLinkQrParser_Factory implements f.c.d<WalletLinkQrParser> {

    /* loaded from: classes2.dex */
    private static final class InstanceHolder {
        private static final WalletLinkQrParser_Factory INSTANCE = new WalletLinkQrParser_Factory();

        private InstanceHolder() {
        }
    }

    public static WalletLinkQrParser_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static WalletLinkQrParser newInstance() {
        return new WalletLinkQrParser();
    }

    @Override // javax.inject.Provider
    public WalletLinkQrParser get() {
        return newInstance();
    }
}