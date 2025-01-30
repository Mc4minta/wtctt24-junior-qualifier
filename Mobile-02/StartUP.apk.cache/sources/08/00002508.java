package com.coinbase.wallet.qr.di;

import com.coinbase.wallet.qr.parsers.QRCodeIntentParser;
import f.c.d;
import f.c.h;
import java.util.Map;
import java.util.Set;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class QrCodeParsersModule_ProvidesQrParsersFactory implements d<Set<QRCodeIntentParser>> {
    private final Provider<Map<Class<? extends QRCodeIntentParser>, QRCodeIntentParser>> mapProvider;

    public QrCodeParsersModule_ProvidesQrParsersFactory(Provider<Map<Class<? extends QRCodeIntentParser>, QRCodeIntentParser>> provider) {
        this.mapProvider = provider;
    }

    public static QrCodeParsersModule_ProvidesQrParsersFactory create(Provider<Map<Class<? extends QRCodeIntentParser>, QRCodeIntentParser>> provider) {
        return new QrCodeParsersModule_ProvidesQrParsersFactory(provider);
    }

    public static Set<QRCodeIntentParser> providesQrParsers(Map<Class<? extends QRCodeIntentParser>, QRCodeIntentParser> map) {
        return (Set) h.f(QrCodeParsersModule.providesQrParsers(map));
    }

    @Override // javax.inject.Provider
    public Set<QRCodeIntentParser> get() {
        return providesQrParsers(this.mapProvider.get());
    }
}