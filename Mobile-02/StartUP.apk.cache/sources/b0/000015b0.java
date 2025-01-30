package com.coinbase.wallet.consumer.di;

import com.coinbase.wallet.consumer.daos.ConsumerAccountsDAO;
import com.coinbase.wallet.consumer.db.ConsumerDatabase;
import com.coinbase.wallet.libraries.databases.db.Database;
import f.c.d;
import f.c.h;
import javax.inject.Provider;

/* loaded from: classes.dex */
public final class ConsumerModule_Companion_ProvidesConsumerAccountsDAOFactory implements d<ConsumerAccountsDAO> {
    private final Provider<Database<ConsumerDatabase>> dbProvider;

    public ConsumerModule_Companion_ProvidesConsumerAccountsDAOFactory(Provider<Database<ConsumerDatabase>> provider) {
        this.dbProvider = provider;
    }

    public static ConsumerModule_Companion_ProvidesConsumerAccountsDAOFactory create(Provider<Database<ConsumerDatabase>> provider) {
        return new ConsumerModule_Companion_ProvidesConsumerAccountsDAOFactory(provider);
    }

    public static ConsumerAccountsDAO providesConsumerAccountsDAO(Database<ConsumerDatabase> database) {
        return (ConsumerAccountsDAO) h.f(ConsumerModule.Companion.providesConsumerAccountsDAO(database));
    }

    @Override // javax.inject.Provider
    public ConsumerAccountsDAO get() {
        return providesConsumerAccountsDAO(this.dbProvider.get());
    }
}