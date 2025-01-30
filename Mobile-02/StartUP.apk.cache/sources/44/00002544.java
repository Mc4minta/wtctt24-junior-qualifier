package com.coinbase.wallet.qr.parsers;

/* loaded from: classes2.dex */
public final class Utf8StringFixedLengthQrCodeParser_Factory implements f.c.d<Utf8StringFixedLengthQrCodeParser> {

    /* loaded from: classes2.dex */
    private static final class InstanceHolder {
        private static final Utf8StringFixedLengthQrCodeParser_Factory INSTANCE = new Utf8StringFixedLengthQrCodeParser_Factory();

        private InstanceHolder() {
        }
    }

    public static Utf8StringFixedLengthQrCodeParser_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static Utf8StringFixedLengthQrCodeParser newInstance() {
        return new Utf8StringFixedLengthQrCodeParser();
    }

    @Override // javax.inject.Provider
    public Utf8StringFixedLengthQrCodeParser get() {
        return newInstance();
    }
}