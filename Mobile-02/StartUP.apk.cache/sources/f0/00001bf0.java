package com.coinbase.wallet.ethereum.di;

import com.coinbase.wallet.ethereum.daos.ERC20Dao;
import com.coinbase.wallet.libraries.databases.db.Database;
import f.c.d;
import f.c.h;
import javax.inject.Provider;

/* loaded from: classes.dex */
public final class EthereumModule_ProvidesERC20Dao$ethereum_releaseFactory implements d<ERC20Dao> {
    private final Provider<Database<?>> databaseProvider;

    public EthereumModule_ProvidesERC20Dao$ethereum_releaseFactory(Provider<Database<?>> provider) {
        this.databaseProvider = provider;
    }

    public static EthereumModule_ProvidesERC20Dao$ethereum_releaseFactory create(Provider<Database<?>> provider) {
        return new EthereumModule_ProvidesERC20Dao$ethereum_releaseFactory(provider);
    }

    public static ERC20Dao providesERC20Dao$ethereum_release(Database<?> database) {
        ERC20Dao providesERC20Dao$ethereum_release;
        providesERC20Dao$ethereum_release = EthereumModule.Companion.providesERC20Dao$ethereum_release(database);
        return (ERC20Dao) h.f(providesERC20Dao$ethereum_release);
    }

    @Override // javax.inject.Provider
    public ERC20Dao get() {
        return providesERC20Dao$ethereum_release(this.databaseProvider.get());
    }
}