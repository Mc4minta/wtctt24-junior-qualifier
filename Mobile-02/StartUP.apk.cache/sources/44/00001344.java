package com.coinbase.wallet.bitcoin.extensions;

import com.coinbase.wallet.blockchains.models.AddressType;
import kotlin.Metadata;
import kotlin.h;
import kotlin.jvm.internal.m;
import kotlin.k;

/* compiled from: AddressKind+Bitcoin.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\"!\u0010\u0006\u001a\u00020\u0001*\u00020\u00008F@\u0006X\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0002\u0010\u0003\u001a\u0004\b\u0004\u0010\u0005\"!\u0010\t\u001a\u00020\u0001*\u00020\u00008F@\u0006X\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\u0003\u001a\u0004\b\b\u0010\u0005¨\u0006\n"}, d2 = {"Lcom/coinbase/wallet/blockchains/models/AddressType$Companion;", "Lcom/coinbase/wallet/blockchains/models/AddressType;", "BitcoinLegacy$delegate", "Lkotlin/h;", "getBitcoinLegacy", "(Lcom/coinbase/wallet/blockchains/models/AddressType$Companion;)Lcom/coinbase/wallet/blockchains/models/AddressType;", "BitcoinLegacy", "BitcoinSegWit$delegate", "getBitcoinSegWit", "BitcoinSegWit", "bitcoin_release"}, k = 2, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class AddressKind_BitcoinKt {
    private static final h BitcoinLegacy$delegate;
    private static final h BitcoinSegWit$delegate;

    static {
        h b2;
        h b3;
        b2 = k.b(AddressKind_BitcoinKt$BitcoinSegWit$2.INSTANCE);
        BitcoinSegWit$delegate = b2;
        b3 = k.b(AddressKind_BitcoinKt$BitcoinLegacy$2.INSTANCE);
        BitcoinLegacy$delegate = b3;
    }

    public static final AddressType getBitcoinLegacy(AddressType.Companion companion) {
        m.g(companion, "<this>");
        return (AddressType) BitcoinLegacy$delegate.getValue();
    }

    public static final AddressType getBitcoinSegWit(AddressType.Companion companion) {
        m.g(companion, "<this>");
        return (AddressType) BitcoinSegWit$delegate.getValue();
    }
}