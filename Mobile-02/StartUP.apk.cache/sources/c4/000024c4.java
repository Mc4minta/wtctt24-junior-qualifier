package com.coinbase.wallet.litecoin.extensions;

import com.coinbase.wallet.blockchains.models.AddressType;
import kotlin.Metadata;
import kotlin.h;
import kotlin.jvm.internal.m;
import kotlin.k;

/* compiled from: AddressKind+Litecoin.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\"!\u0010\u0006\u001a\u00020\u0001*\u00020\u00008F@\u0006X\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0002\u0010\u0003\u001a\u0004\b\u0004\u0010\u0005\"!\u0010\t\u001a\u00020\u0001*\u00020\u00008F@\u0006X\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\u0003\u001a\u0004\b\b\u0010\u0005¨\u0006\n"}, d2 = {"Lcom/coinbase/wallet/blockchains/models/AddressType$Companion;", "Lcom/coinbase/wallet/blockchains/models/AddressType;", "LitecoinLegacy$delegate", "Lkotlin/h;", "getLitecoinLegacy", "(Lcom/coinbase/wallet/blockchains/models/AddressType$Companion;)Lcom/coinbase/wallet/blockchains/models/AddressType;", "LitecoinLegacy", "LiteCoinSegWit$delegate", "getLiteCoinSegWit", "LiteCoinSegWit", "litecoin_release"}, k = 2, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class AddressKind_LitecoinKt {
    private static final h LiteCoinSegWit$delegate;
    private static final h LitecoinLegacy$delegate;

    static {
        h b2;
        h b3;
        b2 = k.b(AddressKind_LitecoinKt$LiteCoinSegWit$2.INSTANCE);
        LiteCoinSegWit$delegate = b2;
        b3 = k.b(AddressKind_LitecoinKt$LitecoinLegacy$2.INSTANCE);
        LitecoinLegacy$delegate = b3;
    }

    public static final AddressType getLiteCoinSegWit(AddressType.Companion companion) {
        m.g(companion, "<this>");
        return (AddressType) LiteCoinSegWit$delegate.getValue();
    }

    public static final AddressType getLitecoinLegacy(AddressType.Companion companion) {
        m.g(companion, "<this>");
        return (AddressType) LitecoinLegacy$delegate.getValue();
    }
}