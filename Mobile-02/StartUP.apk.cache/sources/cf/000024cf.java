package com.coinbase.wallet.litecoin.extensions;

import com.coinbase.wallet.blockchains.models.CurrencyCode;
import kotlin.Metadata;
import kotlin.h;
import kotlin.jvm.internal.m;
import kotlin.k;

/* compiled from: CurrencyCode+Litecoin.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\"!\u0010\u0006\u001a\u00020\u0001*\u00020\u00008F@\u0006X\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0002\u0010\u0003\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0007"}, d2 = {"Lcom/coinbase/wallet/blockchains/models/CurrencyCode$Companion;", "Lcom/coinbase/wallet/blockchains/models/CurrencyCode;", "LTC$delegate", "Lkotlin/h;", "getLTC", "(Lcom/coinbase/wallet/blockchains/models/CurrencyCode$Companion;)Lcom/coinbase/wallet/blockchains/models/CurrencyCode;", "LTC", "litecoin_release"}, k = 2, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class CurrencyCode_LitecoinKt {
    private static final h LTC$delegate;

    static {
        h b2;
        b2 = k.b(CurrencyCode_LitecoinKt$LTC$2.INSTANCE);
        LTC$delegate = b2;
    }

    public static final CurrencyCode getLTC(CurrencyCode.Companion companion) {
        m.g(companion, "<this>");
        return (CurrencyCode) LTC$delegate.getValue();
    }
}