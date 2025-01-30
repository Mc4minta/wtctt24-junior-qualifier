package com.coinbase.wallet.bip44wallets.extensions;

import com.coinbase.wallet.blockchains.models.TxMetadataKey;
import kotlin.Metadata;
import kotlin.h;
import kotlin.jvm.internal.m;
import kotlin.k;

/* compiled from: TxMetadataKey+BIP44Wallets.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\"'\u0010\b\u001a\u00020\u0001*\u00020\u00008F@\u0007X\u0087\u0084\u0002¢\u0006\u0012\n\u0004\b\u0002\u0010\u0003\u0012\u0004\b\u0006\u0010\u0007\u001a\u0004\b\u0004\u0010\u0005\"'\u0010\f\u001a\u00020\u0001*\u00020\u00008F@\u0007X\u0087\u0084\u0002¢\u0006\u0012\n\u0004\b\t\u0010\u0003\u0012\u0004\b\u000b\u0010\u0007\u001a\u0004\b\n\u0010\u0005¨\u0006\r"}, d2 = {"Lcom/coinbase/wallet/blockchains/models/TxMetadataKey$Companion;", "Lcom/coinbase/wallet/blockchains/models/TxMetadataKey;", "inputCount$delegate", "Lkotlin/h;", "getInputCount", "(Lcom/coinbase/wallet/blockchains/models/TxMetadataKey$Companion;)Lcom/coinbase/wallet/blockchains/models/TxMetadataKey;", "getInputCount$annotations", "(Lcom/coinbase/wallet/blockchains/models/TxMetadataKey$Companion;)V", "inputCount", "outputCount$delegate", "getOutputCount", "getOutputCount$annotations", "outputCount", "bip44wallets_release"}, k = 2, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class TxMetadataKey_BIP44WalletsKt {
    private static final h inputCount$delegate;
    private static final h outputCount$delegate;

    static {
        h b2;
        h b3;
        b2 = k.b(TxMetadataKey_BIP44WalletsKt$inputCount$2.INSTANCE);
        inputCount$delegate = b2;
        b3 = k.b(TxMetadataKey_BIP44WalletsKt$outputCount$2.INSTANCE);
        outputCount$delegate = b3;
    }

    public static final TxMetadataKey getInputCount(TxMetadataKey.Companion companion) {
        m.g(companion, "<this>");
        return (TxMetadataKey) inputCount$delegate.getValue();
    }

    public static /* synthetic */ void getInputCount$annotations(TxMetadataKey.Companion companion) {
    }

    public static final TxMetadataKey getOutputCount(TxMetadataKey.Companion companion) {
        m.g(companion, "<this>");
        return (TxMetadataKey) outputCount$delegate.getValue();
    }

    public static /* synthetic */ void getOutputCount$annotations(TxMetadataKey.Companion companion) {
    }
}