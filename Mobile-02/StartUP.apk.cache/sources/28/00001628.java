package com.coinbase.wallet.consumer.extensions;

import com.coinbase.wallet.consumer.models.ConsumerUser;
import com.coinbase.wallet.store.models.EncryptedSharedPrefsStoreKey;
import com.coinbase.wallet.store.models.SharedPrefsStoreKey;
import com.coinbase.wallet.store.models.StoreKeys;
import kotlin.Metadata;
import kotlin.h;
import kotlin.jvm.internal.m;
import kotlin.k;

/* compiled from: StoreKeys+ConsumerConnect.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\"'\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u00008F@\u0006X\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"'\u0010\f\u001a\b\u0012\u0004\u0012\u00020\b0\u0007*\u00020\u00008F@\u0006X\u0086\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u000b\"'\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\r0\u0001*\u00020\u00008F@\u0006X\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u0004\u001a\u0004\b\u000f\u0010\u0006\"'\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\b0\u0007*\u00020\u00008F@\u0006X\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0004\u001a\u0004\b\u0012\u0010\u000b\"'\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\b0\u0007*\u00020\u00008F@\u0006X\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u0004\u001a\u0004\b\u0015\u0010\u000b¨\u0006\u0017"}, d2 = {"Lcom/coinbase/wallet/store/models/StoreKeys;", "Lcom/coinbase/wallet/store/models/SharedPrefsStoreKey;", "", "isFiatSelectedForConsumer$delegate", "Lkotlin/h;", "isFiatSelectedForConsumer", "(Lcom/coinbase/wallet/store/models/StoreKeys;)Lcom/coinbase/wallet/store/models/SharedPrefsStoreKey;", "Lcom/coinbase/wallet/store/models/EncryptedSharedPrefsStoreKey;", "", "consumerAccessToken$delegate", "getConsumerAccessToken", "(Lcom/coinbase/wallet/store/models/StoreKeys;)Lcom/coinbase/wallet/store/models/EncryptedSharedPrefsStoreKey;", "consumerAccessToken", "Lcom/coinbase/wallet/consumer/models/ConsumerUser;", "consumerUser$delegate", "getConsumerUser", "consumerUser", "consumerRefreshToken$delegate", "getConsumerRefreshToken", "consumerRefreshToken", "consumerScope$delegate", "getConsumerScope", "consumerScope", "consumer_productionRelease"}, k = 2, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class StoreKeys_ConsumerConnectKt {
    private static final h consumerAccessToken$delegate;
    private static final h consumerRefreshToken$delegate;
    private static final h consumerScope$delegate;
    private static final h consumerUser$delegate;
    private static final h isFiatSelectedForConsumer$delegate;

    static {
        h b2;
        h b3;
        h b4;
        h b5;
        h b6;
        b2 = k.b(StoreKeys_ConsumerConnectKt$consumerAccessToken$2.INSTANCE);
        consumerAccessToken$delegate = b2;
        b3 = k.b(StoreKeys_ConsumerConnectKt$consumerRefreshToken$2.INSTANCE);
        consumerRefreshToken$delegate = b3;
        b4 = k.b(StoreKeys_ConsumerConnectKt$consumerScope$2.INSTANCE);
        consumerScope$delegate = b4;
        b5 = k.b(StoreKeys_ConsumerConnectKt$consumerUser$2.INSTANCE);
        consumerUser$delegate = b5;
        b6 = k.b(StoreKeys_ConsumerConnectKt$isFiatSelectedForConsumer$2.INSTANCE);
        isFiatSelectedForConsumer$delegate = b6;
    }

    public static final EncryptedSharedPrefsStoreKey<String> getConsumerAccessToken(StoreKeys storeKeys) {
        m.g(storeKeys, "<this>");
        return (EncryptedSharedPrefsStoreKey) consumerAccessToken$delegate.getValue();
    }

    public static final EncryptedSharedPrefsStoreKey<String> getConsumerRefreshToken(StoreKeys storeKeys) {
        m.g(storeKeys, "<this>");
        return (EncryptedSharedPrefsStoreKey) consumerRefreshToken$delegate.getValue();
    }

    public static final EncryptedSharedPrefsStoreKey<String> getConsumerScope(StoreKeys storeKeys) {
        m.g(storeKeys, "<this>");
        return (EncryptedSharedPrefsStoreKey) consumerScope$delegate.getValue();
    }

    public static final SharedPrefsStoreKey<ConsumerUser> getConsumerUser(StoreKeys storeKeys) {
        m.g(storeKeys, "<this>");
        return (SharedPrefsStoreKey) consumerUser$delegate.getValue();
    }

    public static final SharedPrefsStoreKey<Boolean> isFiatSelectedForConsumer(StoreKeys storeKeys) {
        m.g(storeKeys, "<this>");
        return (SharedPrefsStoreKey) isFiatSelectedForConsumer$delegate.getValue();
    }
}