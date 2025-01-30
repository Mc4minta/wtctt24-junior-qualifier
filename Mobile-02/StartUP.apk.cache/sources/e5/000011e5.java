package com.coinbase.wallet.application.migrations;

import android.content.Context;
import javax.inject.Provider;

/* loaded from: classes.dex */
public final class MigrationsDao_Factory implements f.c.d<MigrationsDao> {
    private final Provider<Context> contextProvider;

    public MigrationsDao_Factory(Provider<Context> provider) {
        this.contextProvider = provider;
    }

    public static MigrationsDao_Factory create(Provider<Context> provider) {
        return new MigrationsDao_Factory(provider);
    }

    public static MigrationsDao newInstance(Context context) {
        return new MigrationsDao(context);
    }

    @Override // javax.inject.Provider
    public MigrationsDao get() {
        return newInstance(this.contextProvider.get());
    }
}