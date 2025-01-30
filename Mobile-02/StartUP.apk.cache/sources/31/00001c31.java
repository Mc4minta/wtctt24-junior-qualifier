package com.coinbase.wallet.ethereum.extensions;

import com.coinbase.wallet.blockchains.models.CurrencyCode;
import kotlin.Metadata;
import kotlin.h;
import kotlin.jvm.internal.m;
import kotlin.k;

/* compiled from: CurrencyCode+Ethereum.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\"!\u0010\u0006\u001a\u00020\u0001*\u00020\u00008F@\u0006X\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0002\u0010\u0003\u001a\u0004\b\u0004\u0010\u0005\"!\u0010\t\u001a\u00020\u0001*\u00020\u00008F@\u0006X\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\u0003\u001a\u0004\b\b\u0010\u0005\"!\u0010\f\u001a\u00020\u0001*\u00020\u00008F@\u0006X\u0086\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u0003\u001a\u0004\b\u000b\u0010\u0005¨\u0006\r"}, d2 = {"Lcom/coinbase/wallet/blockchains/models/CurrencyCode$Companion;", "Lcom/coinbase/wallet/blockchains/models/CurrencyCode;", "ETH$delegate", "Lkotlin/h;", "getETH", "(Lcom/coinbase/wallet/blockchains/models/CurrencyCode$Companion;)Lcom/coinbase/wallet/blockchains/models/CurrencyCode;", "ETH", "ETC$delegate", "getETC", "ETC", "WETH$delegate", "getWETH", "WETH", "ethereum_release"}, k = 2, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class CurrencyCode_EthereumKt {
    private static final h ETC$delegate;
    private static final h ETH$delegate;
    private static final h WETH$delegate;

    static {
        h b2;
        h b3;
        h b4;
        b2 = k.b(CurrencyCode_EthereumKt$ETH$2.INSTANCE);
        ETH$delegate = b2;
        b3 = k.b(CurrencyCode_EthereumKt$ETC$2.INSTANCE);
        ETC$delegate = b3;
        b4 = k.b(CurrencyCode_EthereumKt$WETH$2.INSTANCE);
        WETH$delegate = b4;
    }

    public static final CurrencyCode getETC(CurrencyCode.Companion companion) {
        m.g(companion, "<this>");
        return (CurrencyCode) ETC$delegate.getValue();
    }

    public static final CurrencyCode getETH(CurrencyCode.Companion companion) {
        m.g(companion, "<this>");
        return (CurrencyCode) ETH$delegate.getValue();
    }

    public static final CurrencyCode getWETH(CurrencyCode.Companion companion) {
        m.g(companion, "<this>");
        return (CurrencyCode) WETH$delegate.getValue();
    }
}