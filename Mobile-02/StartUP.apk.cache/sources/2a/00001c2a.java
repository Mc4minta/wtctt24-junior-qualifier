package com.coinbase.wallet.ethereum.extensions;

import com.coinbase.wallet.blockchains.models.Blockchain;
import kotlin.Metadata;
import kotlin.h;
import kotlin.jvm.internal.m;
import kotlin.k;

/* compiled from: Blockchain+Ethereum.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\"!\u0010\u0006\u001a\u00020\u0001*\u00020\u00008F@\u0006X\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0002\u0010\u0003\u001a\u0004\b\u0004\u0010\u0005\"!\u0010\t\u001a\u00020\u0001*\u00020\u00008F@\u0006X\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\u0003\u001a\u0004\b\b\u0010\u0005¨\u0006\n"}, d2 = {"Lcom/coinbase/wallet/blockchains/models/Blockchain$Companion;", "Lcom/coinbase/wallet/blockchains/models/Blockchain;", "ETHEREUM$delegate", "Lkotlin/h;", "getETHEREUM", "(Lcom/coinbase/wallet/blockchains/models/Blockchain$Companion;)Lcom/coinbase/wallet/blockchains/models/Blockchain;", "ETHEREUM", "ETHEREUM_CLASSIC$delegate", "getETHEREUM_CLASSIC", "ETHEREUM_CLASSIC", "ethereum_release"}, k = 2, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class Blockchain_EthereumKt {
    private static final h ETHEREUM$delegate;
    private static final h ETHEREUM_CLASSIC$delegate;

    static {
        h b2;
        h b3;
        b2 = k.b(Blockchain_EthereumKt$ETHEREUM$2.INSTANCE);
        ETHEREUM$delegate = b2;
        b3 = k.b(Blockchain_EthereumKt$ETHEREUM_CLASSIC$2.INSTANCE);
        ETHEREUM_CLASSIC$delegate = b3;
    }

    public static final Blockchain getETHEREUM(Blockchain.Companion companion) {
        m.g(companion, "<this>");
        return (Blockchain) ETHEREUM$delegate.getValue();
    }

    public static final Blockchain getETHEREUM_CLASSIC(Blockchain.Companion companion) {
        m.g(companion, "<this>");
        return (Blockchain) ETHEREUM_CLASSIC$delegate.getValue();
    }
}