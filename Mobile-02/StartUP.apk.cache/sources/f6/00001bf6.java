package com.coinbase.wallet.ethereum.di;

import com.coinbase.wallet.ethereum.daos.EthereumSignedTxDao;
import com.coinbase.wallet.libraries.databases.db.Database;
import f.c.d;
import f.c.h;
import javax.inject.Provider;

/* loaded from: classes.dex */
public final class EthereumModule_ProvidesEthTxDAO$ethereum_releaseFactory implements d<EthereumSignedTxDao> {
    private final Provider<Database<?>> databaseProvider;

    public EthereumModule_ProvidesEthTxDAO$ethereum_releaseFactory(Provider<Database<?>> provider) {
        this.databaseProvider = provider;
    }

    public static EthereumModule_ProvidesEthTxDAO$ethereum_releaseFactory create(Provider<Database<?>> provider) {
        return new EthereumModule_ProvidesEthTxDAO$ethereum_releaseFactory(provider);
    }

    public static EthereumSignedTxDao providesEthTxDAO$ethereum_release(Database<?> database) {
        EthereumSignedTxDao providesEthTxDAO$ethereum_release;
        providesEthTxDAO$ethereum_release = EthereumModule.Companion.providesEthTxDAO$ethereum_release(database);
        return (EthereumSignedTxDao) h.f(providesEthTxDAO$ethereum_release);
    }

    @Override // javax.inject.Provider
    public EthereumSignedTxDao get() {
        return providesEthTxDAO$ethereum_release(this.databaseProvider.get());
    }
}