package com.coinbase.wallet.features.debugmenu.util;

import f.c.d;

/* loaded from: classes.dex */
public final class DebugSettings_Factory implements d<DebugSettings> {

    /* loaded from: classes.dex */
    private static final class InstanceHolder {
        private static final DebugSettings_Factory INSTANCE = new DebugSettings_Factory();

        private InstanceHolder() {
        }
    }

    public static DebugSettings_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static DebugSettings newInstance() {
        return new DebugSettings();
    }

    @Override // javax.inject.Provider
    public DebugSettings get() {
        return newInstance();
    }
}