package com.coinbase.wallet.qr.parsers;

/* loaded from: classes2.dex */
public final class UnsignedIntegerQrCodeParser_Factory implements f.c.d<UnsignedIntegerQrCodeParser> {

    /* loaded from: classes2.dex */
    private static final class InstanceHolder {
        private static final UnsignedIntegerQrCodeParser_Factory INSTANCE = new UnsignedIntegerQrCodeParser_Factory();

        private InstanceHolder() {
        }
    }

    public static UnsignedIntegerQrCodeParser_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static UnsignedIntegerQrCodeParser newInstance() {
        return new UnsignedIntegerQrCodeParser();
    }

    @Override // javax.inject.Provider
    public UnsignedIntegerQrCodeParser get() {
        return newInstance();
    }
}