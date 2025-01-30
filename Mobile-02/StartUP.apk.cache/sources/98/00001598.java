package com.coinbase.wallet.consumer.db;

import com.coinbase.wallet.consumer.models.ConsumerAccount;
import com.coinbase.wallet.consumer.models.ConsumerAvailablePaymentMethod;
import com.coinbase.wallet.consumer.models.ConsumerPaymentMethod;
import com.coinbase.wallet.libraries.databases.db.RoomDatabaseProvider;
import com.coinbase.wallet.libraries.databases.interfaces.DatabaseDaoInterface;
import java.util.Map;
import kotlin.Metadata;
import kotlin.a0.m0;
import kotlin.u;

/* compiled from: ConsumerDatabase.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b'\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0013\u0010\u0014J#\u0010\u0005\u001a\u0016\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0003\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00040\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\n\u001a\u00020\u00078&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0016\u0010\u000e\u001a\u00020\u000b8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0016\u0010\u0012\u001a\u00020\u000f8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0015"}, d2 = {"Lcom/coinbase/wallet/consumer/db/ConsumerDatabase;", "Lcom/coinbase/wallet/libraries/databases/db/RoomDatabaseProvider;", "", "Ljava/lang/Class;", "Lcom/coinbase/wallet/libraries/databases/interfaces/DatabaseDaoInterface;", "modelMappings", "()Ljava/util/Map;", "Lcom/coinbase/wallet/consumer/db/ConsumerPaymentMethodsRoomDAO;", "getConsumerPaymentMethodsDAO", "()Lcom/coinbase/wallet/consumer/db/ConsumerPaymentMethodsRoomDAO;", "consumerPaymentMethodsDAO", "Lcom/coinbase/wallet/consumer/db/ConsumerAccountsRoomDAO;", "getConsumerAccountsDAO", "()Lcom/coinbase/wallet/consumer/db/ConsumerAccountsRoomDAO;", "consumerAccountsDAO", "Lcom/coinbase/wallet/consumer/db/ConsumerAvailablePaymentMethodsRoomDAO;", "getConsumerAvailablePaymentMethodsDAO", "()Lcom/coinbase/wallet/consumer/db/ConsumerAvailablePaymentMethodsRoomDAO;", "consumerAvailablePaymentMethodsDAO", "<init>", "()V", "consumer_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public abstract class ConsumerDatabase extends RoomDatabaseProvider {
    public abstract ConsumerAccountsRoomDAO getConsumerAccountsDAO();

    public abstract ConsumerAvailablePaymentMethodsRoomDAO getConsumerAvailablePaymentMethodsDAO();

    public abstract ConsumerPaymentMethodsRoomDAO getConsumerPaymentMethodsDAO();

    @Override // com.coinbase.wallet.libraries.databases.db.RoomDatabaseProvider
    public Map<Class<?>, DatabaseDaoInterface<?>> modelMappings() {
        Map<Class<?>, DatabaseDaoInterface<?>> l2;
        l2 = m0.l(u.a(ConsumerAccount.class, getConsumerAccountsDAO()), u.a(ConsumerPaymentMethod.class, getConsumerPaymentMethodsDAO()), u.a(ConsumerAvailablePaymentMethod.class, getConsumerAvailablePaymentMethodsDAO()));
        return l2;
    }
}