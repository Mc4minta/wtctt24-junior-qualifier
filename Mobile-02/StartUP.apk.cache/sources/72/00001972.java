package com.coinbase.wallet.di;

import com.coinbase.wallet.common.utilities.BuildConfigWrapper;

/* loaded from: classes.dex */
public final class AppCoreModule_ProvidesBuildConfigFactory implements f.c.d<BuildConfigWrapper> {

    /* loaded from: classes.dex */
    private static final class InstanceHolder {
        private static final AppCoreModule_ProvidesBuildConfigFactory INSTANCE = new AppCoreModule_ProvidesBuildConfigFactory();

        private InstanceHolder() {
        }
    }

    public static AppCoreModule_ProvidesBuildConfigFactory create() {
        return InstanceHolder.INSTANCE;
    }

    public static BuildConfigWrapper providesBuildConfig() {
        return (BuildConfigWrapper) f.c.h.f(AppCoreModule.providesBuildConfig());
    }

    @Override // javax.inject.Provider
    public BuildConfigWrapper get() {
        return providesBuildConfig();
    }
}