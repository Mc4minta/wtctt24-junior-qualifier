package com.coinbase.wallet.di;

import com.coinbase.wallet.core.interfaces.Tracing;

/* loaded from: classes.dex */
public final class AppModule_ProvidesTraceLoggerFactory implements f.c.d<Tracing> {

    /* loaded from: classes.dex */
    private static final class InstanceHolder {
        private static final AppModule_ProvidesTraceLoggerFactory INSTANCE = new AppModule_ProvidesTraceLoggerFactory();

        private InstanceHolder() {
        }
    }

    public static AppModule_ProvidesTraceLoggerFactory create() {
        return InstanceHolder.INSTANCE;
    }

    public static Tracing providesTraceLogger() {
        return (Tracing) f.c.h.f(AppModule.providesTraceLogger());
    }

    @Override // javax.inject.Provider
    public Tracing get() {
        return providesTraceLogger();
    }
}