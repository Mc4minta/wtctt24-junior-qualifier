package com.coinbase.wallet.di;

import java.util.Calendar;

/* loaded from: classes.dex */
public final class AppModule_Companion_ProvidesCalendarFunctionFactory implements f.c.d<Calendar> {

    /* loaded from: classes.dex */
    private static final class InstanceHolder {
        private static final AppModule_Companion_ProvidesCalendarFunctionFactory INSTANCE = new AppModule_Companion_ProvidesCalendarFunctionFactory();

        private InstanceHolder() {
        }
    }

    public static AppModule_Companion_ProvidesCalendarFunctionFactory create() {
        return InstanceHolder.INSTANCE;
    }

    public static Calendar providesCalendarFunction() {
        return (Calendar) f.c.h.f(AppModule.Companion.providesCalendarFunction());
    }

    @Override // javax.inject.Provider
    public Calendar get() {
        return providesCalendarFunction();
    }
}