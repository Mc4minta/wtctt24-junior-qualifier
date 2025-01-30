package com.coinbase.wallet.ethereum.extensions;

import com.coinbase.wallet.blockchains.models.TxMetadataKey;
import kotlin.Metadata;
import kotlin.h;
import kotlin.jvm.internal.m;
import kotlin.k;

/* compiled from: TxMetadataKey+Ethereum.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\"!\u0010\u0006\u001a\u00020\u0001*\u00020\u00008F@\u0006X\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0002\u0010\u0003\u001a\u0004\b\u0004\u0010\u0005\"!\u0010\t\u001a\u00020\u0001*\u00020\u00008F@\u0006X\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\u0003\u001a\u0004\b\b\u0010\u0005¨\u0006\n"}, d2 = {"Lcom/coinbase/wallet/blockchains/models/TxMetadataKey$Companion;", "Lcom/coinbase/wallet/blockchains/models/TxMetadataKey;", "contractAction$delegate", "Lkotlin/h;", "getContractAction", "(Lcom/coinbase/wallet/blockchains/models/TxMetadataKey$Companion;)Lcom/coinbase/wallet/blockchains/models/TxMetadataKey;", "contractAction", "txSource$delegate", "getTxSource", "txSource", "ethereum_release"}, k = 2, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class TxMetadataKey_EthereumKt {
    private static final h contractAction$delegate;
    private static final h txSource$delegate;

    static {
        h b2;
        h b3;
        b2 = k.b(TxMetadataKey_EthereumKt$contractAction$2.INSTANCE);
        contractAction$delegate = b2;
        b3 = k.b(TxMetadataKey_EthereumKt$txSource$2.INSTANCE);
        txSource$delegate = b3;
    }

    public static final TxMetadataKey getContractAction(TxMetadataKey.Companion companion) {
        m.g(companion, "<this>");
        return (TxMetadataKey) contractAction$delegate.getValue();
    }

    public static final TxMetadataKey getTxSource(TxMetadataKey.Companion companion) {
        m.g(companion, "<this>");
        return (TxMetadataKey) txSource$delegate.getValue();
    }
}