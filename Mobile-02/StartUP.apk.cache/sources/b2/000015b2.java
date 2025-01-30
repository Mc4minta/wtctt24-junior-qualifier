package com.coinbase.wallet.consumer.di;

import com.coinbase.wallet.consumer.daos.ConsumerPaymentMethodsDAO;
import com.coinbase.wallet.consumer.db.ConsumerDatabase;
import com.coinbase.wallet.libraries.databases.db.Database;
import f.c.d;
import f.c.h;
import javax.inject.Provider;

/* loaded from: classes.dex */
public final class ConsumerModule_Companion_ProvidesConsumerPaymentMethodsDAOFactory implements d<ConsumerPaymentMethodsDAO> {
    private final Provider<Database<ConsumerDatabase>> dbProvider;

    public ConsumerModule_Companion_ProvidesConsumerPaymentMethodsDAOFactory(Provider<Database<ConsumerDatabase>> provider) {
        this.dbProvider = provider;
    }

    public static ConsumerModule_Companion_ProvidesConsumerPaymentMethodsDAOFactory create(Provider<Database<ConsumerDatabase>> provider) {
        return new ConsumerModule_Companion_ProvidesConsumerPaymentMethodsDAOFactory(provider);
    }

    public static ConsumerPaymentMethodsDAO providesConsumerPaymentMethodsDAO(Database<ConsumerDatabase> database) {
        return (ConsumerPaymentMethodsDAO) h.f(ConsumerModule.Companion.providesConsumerPaymentMethodsDAO(database));
    }

    @Override // javax.inject.Provider
    public ConsumerPaymentMethodsDAO get() {
        return providesConsumerPaymentMethodsDAO(this.dbProvider.get());
    }
}