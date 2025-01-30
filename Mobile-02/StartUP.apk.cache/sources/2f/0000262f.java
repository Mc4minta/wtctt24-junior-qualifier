package com.coinbase.wallet.stellar.extensions;

import com.coinbase.wallet.blockchains.models.TxMetadataKey;
import kotlin.Metadata;
import kotlin.h;
import kotlin.jvm.internal.m;
import kotlin.k;

/* compiled from: TxMetadataKey+Stellar.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\"!\u0010\u0006\u001a\u00020\u0001*\u00020\u00008F@\u0006X\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0002\u0010\u0003\u001a\u0004\b\u0004\u0010\u0005\"!\u0010\t\u001a\u00020\u0001*\u00020\u00008F@\u0006X\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\u0003\u001a\u0004\b\b\u0010\u0005\"!\u0010\f\u001a\u00020\u0001*\u00020\u00008F@\u0006X\u0086\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u0003\u001a\u0004\b\u000b\u0010\u0005\"!\u0010\u000f\u001a\u00020\u0001*\u00020\u00008F@\u0006X\u0086\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\u0003\u001a\u0004\b\u000e\u0010\u0005¨\u0006\u0010"}, d2 = {"Lcom/coinbase/wallet/blockchains/models/TxMetadataKey$Companion;", "Lcom/coinbase/wallet/blockchains/models/TxMetadataKey;", "memoText$delegate", "Lkotlin/h;", "getMemoText", "(Lcom/coinbase/wallet/blockchains/models/TxMetadataKey$Companion;)Lcom/coinbase/wallet/blockchains/models/TxMetadataKey;", "memoText", "memoReturn$delegate", "getMemoReturn", "memoReturn", "memoId$delegate", "getMemoId", "memoId", "memoHash$delegate", "getMemoHash", "memoHash", "stellar_release"}, k = 2, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class TxMetadataKey_StellarKt {
    private static final h memoHash$delegate;
    private static final h memoId$delegate;
    private static final h memoReturn$delegate;
    private static final h memoText$delegate;

    static {
        h b2;
        h b3;
        h b4;
        h b5;
        b2 = k.b(TxMetadataKey_StellarKt$memoText$2.INSTANCE);
        memoText$delegate = b2;
        b3 = k.b(TxMetadataKey_StellarKt$memoId$2.INSTANCE);
        memoId$delegate = b3;
        b4 = k.b(TxMetadataKey_StellarKt$memoHash$2.INSTANCE);
        memoHash$delegate = b4;
        b5 = k.b(TxMetadataKey_StellarKt$memoReturn$2.INSTANCE);
        memoReturn$delegate = b5;
    }

    public static final TxMetadataKey getMemoHash(TxMetadataKey.Companion companion) {
        m.g(companion, "<this>");
        return (TxMetadataKey) memoHash$delegate.getValue();
    }

    public static final TxMetadataKey getMemoId(TxMetadataKey.Companion companion) {
        m.g(companion, "<this>");
        return (TxMetadataKey) memoId$delegate.getValue();
    }

    public static final TxMetadataKey getMemoReturn(TxMetadataKey.Companion companion) {
        m.g(companion, "<this>");
        return (TxMetadataKey) memoReturn$delegate.getValue();
    }

    public static final TxMetadataKey getMemoText(TxMetadataKey.Companion companion) {
        m.g(companion, "<this>");
        return (TxMetadataKey) memoText$delegate.getValue();
    }
}