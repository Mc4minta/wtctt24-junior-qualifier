package com.coinbase.wallet.bitcoincash.extensions;

import com.coinbase.wallet.blockchains.models.CurrencyDecimal;
import kotlin.Metadata;
import kotlin.h;
import kotlin.jvm.internal.m;
import kotlin.k;

/* compiled from: CurrencyDecimal+BitcoinCash.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0006\"!\u0010\u0006\u001a\u00020\u0001*\u00020\u00008F@\u0006X\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0002\u0010\u0003\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0007"}, d2 = {"Lcom/coinbase/wallet/blockchains/models/CurrencyDecimal;", "", "BCH$delegate", "Lkotlin/h;", "getBCH", "(Lcom/coinbase/wallet/blockchains/models/CurrencyDecimal;)I", "BCH", "bitcoincash_release"}, k = 2, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class CurrencyDecimal_BitcoinCashKt {
    private static final h BCH$delegate;

    static {
        h b2;
        b2 = k.b(CurrencyDecimal_BitcoinCashKt$BCH$2.INSTANCE);
        BCH$delegate = b2;
    }

    public static final int getBCH(CurrencyDecimal currencyDecimal) {
        m.g(currencyDecimal, "<this>");
        return ((Number) BCH$delegate.getValue()).intValue();
    }
}