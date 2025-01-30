package com.coinbase.wallet.ripple.extensions;

import com.coinbase.wallet.blockchains.models.TxMetadataKey;
import kotlin.Metadata;
import kotlin.h;
import kotlin.jvm.internal.m;
import kotlin.k;

/* compiled from: TxMetadataKey+Ripple.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\"'\u0010\b\u001a\u00020\u0001*\u00020\u00008F@\u0007X\u0087\u0084\u0002¢\u0006\u0012\n\u0004\b\u0002\u0010\u0003\u0012\u0004\b\u0006\u0010\u0007\u001a\u0004\b\u0004\u0010\u0005¨\u0006\t"}, d2 = {"Lcom/coinbase/wallet/blockchains/models/TxMetadataKey$Companion;", "Lcom/coinbase/wallet/blockchains/models/TxMetadataKey;", "destinationTag$delegate", "Lkotlin/h;", "getDestinationTag", "(Lcom/coinbase/wallet/blockchains/models/TxMetadataKey$Companion;)Lcom/coinbase/wallet/blockchains/models/TxMetadataKey;", "getDestinationTag$annotations", "(Lcom/coinbase/wallet/blockchains/models/TxMetadataKey$Companion;)V", "destinationTag", "ripple_release"}, k = 2, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class TxMetadataKey_RippleKt {
    private static final h destinationTag$delegate;

    static {
        h b2;
        b2 = k.b(TxMetadataKey_RippleKt$destinationTag$2.INSTANCE);
        destinationTag$delegate = b2;
    }

    public static final TxMetadataKey getDestinationTag(TxMetadataKey.Companion companion) {
        m.g(companion, "<this>");
        return (TxMetadataKey) destinationTag$delegate.getValue();
    }

    public static /* synthetic */ void getDestinationTag$annotations(TxMetadataKey.Companion companion) {
    }
}