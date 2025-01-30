package com.coinbase.wallet.consumer.extensions;

import com.coinbase.wallet.blockchains.models.TxMetadataKey;
import kotlin.Metadata;
import kotlin.h;
import kotlin.jvm.internal.m;
import kotlin.k;

/* compiled from: TxMetadataKey+ConsumerConnect.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\"!\u0010\u0006\u001a\u00020\u0001*\u00020\u00008F@\u0006X\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0002\u0010\u0003\u001a\u0004\b\u0004\u0010\u0005\"!\u0010\t\u001a\u00020\u0001*\u00020\u00008F@\u0006X\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\u0003\u001a\u0004\b\b\u0010\u0005¨\u0006\n"}, d2 = {"Lcom/coinbase/wallet/blockchains/models/TxMetadataKey$Companion;", "Lcom/coinbase/wallet/blockchains/models/TxMetadataKey;", "consumerAccountID$delegate", "Lkotlin/h;", "getConsumerAccountID", "(Lcom/coinbase/wallet/blockchains/models/TxMetadataKey$Companion;)Lcom/coinbase/wallet/blockchains/models/TxMetadataKey;", "consumerAccountID", "consumerTxID$delegate", "getConsumerTxID", "consumerTxID", "consumer_productionRelease"}, k = 2, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class TxMetadataKey_ConsumerConnectKt {
    private static final h consumerAccountID$delegate;
    private static final h consumerTxID$delegate;

    static {
        h b2;
        h b3;
        b2 = k.b(TxMetadataKey_ConsumerConnectKt$consumerAccountID$2.INSTANCE);
        consumerAccountID$delegate = b2;
        b3 = k.b(TxMetadataKey_ConsumerConnectKt$consumerTxID$2.INSTANCE);
        consumerTxID$delegate = b3;
    }

    public static final TxMetadataKey getConsumerAccountID(TxMetadataKey.Companion companion) {
        m.g(companion, "<this>");
        return (TxMetadataKey) consumerAccountID$delegate.getValue();
    }

    public static final TxMetadataKey getConsumerTxID(TxMetadataKey.Companion companion) {
        m.g(companion, "<this>");
        return (TxMetadataKey) consumerTxID$delegate.getValue();
    }
}