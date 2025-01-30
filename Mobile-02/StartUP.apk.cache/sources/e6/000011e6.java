package com.coinbase.wallet.application.migrations;

import java.util.Map;
import javax.inject.Provider;

/* loaded from: classes.dex */
public final class Migrations_Factory implements f.c.d<Migrations> {
    private final Provider<Map<Integer, Provider<Migratable>>> migratablesProvider;

    public Migrations_Factory(Provider<Map<Integer, Provider<Migratable>>> provider) {
        this.migratablesProvider = provider;
    }

    public static Migrations_Factory create(Provider<Map<Integer, Provider<Migratable>>> provider) {
        return new Migrations_Factory(provider);
    }

    public static Migrations newInstance(Map<Integer, Provider<Migratable>> map) {
        return new Migrations(map);
    }

    @Override // javax.inject.Provider
    public Migrations get() {
        return newInstance(this.migratablesProvider.get());
    }
}