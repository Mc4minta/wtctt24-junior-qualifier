package com.coinbase.wallet.bitcoincash.extensions;

import com.coinbase.wallet.blockchains.models.AddressType;
import kotlin.Metadata;
import kotlin.h;
import kotlin.jvm.internal.m;
import kotlin.k;

/* compiled from: AddressKind+BitcoinCash.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\"!\u0010\u0006\u001a\u00020\u0001*\u00020\u00008F@\u0006X\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0002\u0010\u0003\u001a\u0004\b\u0004\u0010\u0005\"!\u0010\t\u001a\u00020\u0001*\u00020\u00008F@\u0006X\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\u0003\u001a\u0004\b\b\u0010\u0005¨\u0006\n"}, d2 = {"Lcom/coinbase/wallet/blockchains/models/AddressType$Companion;", "Lcom/coinbase/wallet/blockchains/models/AddressType;", "BitcoinCashLegacy$delegate", "Lkotlin/h;", "getBitcoinCashLegacy", "(Lcom/coinbase/wallet/blockchains/models/AddressType$Companion;)Lcom/coinbase/wallet/blockchains/models/AddressType;", "BitcoinCashLegacy", "BitcoinCashAddr$delegate", "getBitcoinCashAddr", "BitcoinCashAddr", "bitcoincash_release"}, k = 2, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class AddressKind_BitcoinCashKt {
    private static final h BitcoinCashAddr$delegate;
    private static final h BitcoinCashLegacy$delegate;

    static {
        h b2;
        h b3;
        b2 = k.b(AddressKind_BitcoinCashKt$BitcoinCashAddr$2.INSTANCE);
        BitcoinCashAddr$delegate = b2;
        b3 = k.b(AddressKind_BitcoinCashKt$BitcoinCashLegacy$2.INSTANCE);
        BitcoinCashLegacy$delegate = b3;
    }

    public static final AddressType getBitcoinCashAddr(AddressType.Companion companion) {
        m.g(companion, "<this>");
        return (AddressType) BitcoinCashAddr$delegate.getValue();
    }

    public static final AddressType getBitcoinCashLegacy(AddressType.Companion companion) {
        m.g(companion, "<this>");
        return (AddressType) BitcoinCashLegacy$delegate.getValue();
    }
}