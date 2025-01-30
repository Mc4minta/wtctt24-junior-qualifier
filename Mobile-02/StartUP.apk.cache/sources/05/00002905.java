package com.coinbase.wallet.wallets.di;

import androidx.room.s.a;
import f.c.d;
import f.c.h;
import java.util.List;

/* loaded from: classes2.dex */
public final class DAOModule_ProvidesMigrationsFactory implements d<List<a>> {

    /* loaded from: classes2.dex */
    private static final class InstanceHolder {
        private static final DAOModule_ProvidesMigrationsFactory INSTANCE = new DAOModule_ProvidesMigrationsFactory();

        private InstanceHolder() {
        }
    }

    public static DAOModule_ProvidesMigrationsFactory create() {
        return InstanceHolder.INSTANCE;
    }

    public static List<a> providesMigrations() {
        return (List) h.f(DAOModule.providesMigrations());
    }

    @Override // javax.inject.Provider
    public List<a> get() {
        return providesMigrations();
    }
}