package com.coinbase.wallet.ethereum.extensions;

import com.coinbase.wallet.blockchains.models.AddressType;
import kotlin.Metadata;
import kotlin.h;
import kotlin.jvm.internal.m;
import kotlin.k;

/* compiled from: AddressKind+Ethereum.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\"!\u0010\u0006\u001a\u00020\u0001*\u00020\u00008F@\u0006X\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0002\u0010\u0003\u001a\u0004\b\u0004\u0010\u0005\"!\u0010\t\u001a\u00020\u0001*\u00020\u00008F@\u0006X\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\u0003\u001a\u0004\b\b\u0010\u0005¨\u0006\n"}, d2 = {"Lcom/coinbase/wallet/blockchains/models/AddressType$Companion;", "Lcom/coinbase/wallet/blockchains/models/AddressType;", "Ethereum$delegate", "Lkotlin/h;", "getEthereum", "(Lcom/coinbase/wallet/blockchains/models/AddressType$Companion;)Lcom/coinbase/wallet/blockchains/models/AddressType;", "Ethereum", "EthereumClassic$delegate", "getEthereumClassic", "EthereumClassic", "ethereum_release"}, k = 2, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class AddressKind_EthereumKt {
    private static final h Ethereum$delegate;
    private static final h EthereumClassic$delegate;

    static {
        h b2;
        h b3;
        b2 = k.b(AddressKind_EthereumKt$Ethereum$2.INSTANCE);
        Ethereum$delegate = b2;
        b3 = k.b(AddressKind_EthereumKt$EthereumClassic$2.INSTANCE);
        EthereumClassic$delegate = b3;
    }

    public static final AddressType getEthereum(AddressType.Companion companion) {
        m.g(companion, "<this>");
        return (AddressType) Ethereum$delegate.getValue();
    }

    public static final AddressType getEthereumClassic(AddressType.Companion companion) {
        m.g(companion, "<this>");
        return (AddressType) EthereumClassic$delegate.getValue();
    }
}