package com.coinbase.wallet.consumer.extensions;

import com.coinbase.wallet.blockchains.models.TxMetadataKey;
import kotlin.Metadata;
import kotlin.e0.c.a;
import kotlin.jvm.internal.o;

/* compiled from: TxMetadataKey+ConsumerConnect.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lcom/coinbase/wallet/blockchains/models/TxMetadataKey;", "<anonymous>", "()Lcom/coinbase/wallet/blockchains/models/TxMetadataKey;"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes.dex */
final class TxMetadataKey_ConsumerConnectKt$consumerAccountID$2 extends o implements a<TxMetadataKey> {
    public static final TxMetadataKey_ConsumerConnectKt$consumerAccountID$2 INSTANCE = new TxMetadataKey_ConsumerConnectKt$consumerAccountID$2();

    TxMetadataKey_ConsumerConnectKt$consumerAccountID$2() {
        super(0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.e0.c.a
    public final TxMetadataKey invoke() {
        return TxMetadataKey.Companion.create("consumerAccountID", String.class);
    }
}