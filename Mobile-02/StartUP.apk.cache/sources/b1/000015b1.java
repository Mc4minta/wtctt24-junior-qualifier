package com.coinbase.wallet.consumer.di;

import com.coinbase.wallet.consumer.daos.ConsumerAvailablePaymentMethodsDAO;
import com.coinbase.wallet.consumer.db.ConsumerDatabase;
import com.coinbase.wallet.libraries.databases.db.Database;
import f.c.d;
import f.c.h;
import javax.inject.Provider;

/* loaded from: classes.dex */
public final class ConsumerModule_Companion_ProvidesConsumerAvailablePaymentMethodsDAOFactory implements d<ConsumerAvailablePaymentMethodsDAO> {
    private final Provider<Database<ConsumerDatabase>> dbProvider;

    public ConsumerModule_Companion_ProvidesConsumerAvailablePaymentMethodsDAOFactory(Provider<Database<ConsumerDatabase>> provider) {
        this.dbProvider = provider;
    }

    public static ConsumerModule_Companion_ProvidesConsumerAvailablePaymentMethodsDAOFactory create(Provider<Database<ConsumerDatabase>> provider) {
        return new ConsumerModule_Companion_ProvidesConsumerAvailablePaymentMethodsDAOFactory(provider);
    }

    public static ConsumerAvailablePaymentMethodsDAO providesConsumerAvailablePaymentMethodsDAO(Database<ConsumerDatabase> database) {
        return (ConsumerAvailablePaymentMethodsDAO) h.f(ConsumerModule.Companion.providesConsumerAvailablePaymentMethodsDAO(database));
    }

    @Override // javax.inject.Provider
    public ConsumerAvailablePaymentMethodsDAO get() {
        return providesConsumerAvailablePaymentMethodsDAO(this.dbProvider.get());
    }
}