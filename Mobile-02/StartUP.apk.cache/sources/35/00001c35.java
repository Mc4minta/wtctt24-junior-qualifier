package com.coinbase.wallet.ethereum.extensions;

import com.coinbase.wallet.blockchains.models.CurrencyDecimal;
import kotlin.Metadata;
import kotlin.h;
import kotlin.jvm.internal.m;
import kotlin.k;

/* compiled from: CurrencyDecimal+Ethereum.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\t\"!\u0010\u0006\u001a\u00020\u0001*\u00020\u00008F@\u0006X\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0002\u0010\u0003\u001a\u0004\b\u0004\u0010\u0005\"!\u0010\t\u001a\u00020\u0001*\u00020\u00008F@\u0006X\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\u0003\u001a\u0004\b\b\u0010\u0005¨\u0006\n"}, d2 = {"Lcom/coinbase/wallet/blockchains/models/CurrencyDecimal;", "", "ETC$delegate", "Lkotlin/h;", "getETC", "(Lcom/coinbase/wallet/blockchains/models/CurrencyDecimal;)I", "ETC", "ETH$delegate", "getETH", "ETH", "ethereum_release"}, k = 2, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class CurrencyDecimal_EthereumKt {
    private static final h ETC$delegate;
    private static final h ETH$delegate;

    static {
        h b2;
        h b3;
        b2 = k.b(CurrencyDecimal_EthereumKt$ETC$2.INSTANCE);
        ETC$delegate = b2;
        b3 = k.b(CurrencyDecimal_EthereumKt$ETH$2.INSTANCE);
        ETH$delegate = b3;
    }

    public static final int getETC(CurrencyDecimal currencyDecimal) {
        m.g(currencyDecimal, "<this>");
        return ((Number) ETC$delegate.getValue()).intValue();
    }

    public static final int getETH(CurrencyDecimal currencyDecimal) {
        m.g(currencyDecimal, "<this>");
        return ((Number) ETH$delegate.getValue()).intValue();
    }
}