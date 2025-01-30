package com.coinbase.wallet.qr.parsers;

/* loaded from: classes2.dex */
public final class HexStringFixedLengthQrCodeParser_Factory implements f.c.d<HexStringFixedLengthQrCodeParser> {

    /* loaded from: classes2.dex */
    private static final class InstanceHolder {
        private static final HexStringFixedLengthQrCodeParser_Factory INSTANCE = new HexStringFixedLengthQrCodeParser_Factory();

        private InstanceHolder() {
        }
    }

    public static HexStringFixedLengthQrCodeParser_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static HexStringFixedLengthQrCodeParser newInstance() {
        return new HexStringFixedLengthQrCodeParser();
    }

    @Override // javax.inject.Provider
    public HexStringFixedLengthQrCodeParser get() {
        return newInstance();
    }
}