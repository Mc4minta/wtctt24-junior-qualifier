package com.coinbase.wallet.di;

import java.text.SimpleDateFormat;

/* loaded from: classes.dex */
public final class AppModule_Companion_ProvidesRfc3399SimpleDateFormatFactory implements f.c.d<SimpleDateFormat> {

    /* loaded from: classes.dex */
    private static final class InstanceHolder {
        private static final AppModule_Companion_ProvidesRfc3399SimpleDateFormatFactory INSTANCE = new AppModule_Companion_ProvidesRfc3399SimpleDateFormatFactory();

        private InstanceHolder() {
        }
    }

    public static AppModule_Companion_ProvidesRfc3399SimpleDateFormatFactory create() {
        return InstanceHolder.INSTANCE;
    }

    public static SimpleDateFormat providesRfc3399SimpleDateFormat() {
        return (SimpleDateFormat) f.c.h.f(AppModule.Companion.providesRfc3399SimpleDateFormat());
    }

    @Override // javax.inject.Provider
    public SimpleDateFormat get() {
        return providesRfc3399SimpleDateFormat();
    }
}