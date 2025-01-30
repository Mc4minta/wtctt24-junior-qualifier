package com.coinbase.wallet.wallets.extensions;

import com.coinbase.wallet.blockchains.models.CurrencyCode;
import kotlin.Metadata;
import kotlin.h;
import kotlin.jvm.internal.m;
import kotlin.k;

/* compiled from: CurrencyCode+Wallets.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\"!\u0010\u0006\u001a\u00020\u0001*\u00020\u00008@@\u0000X\u0080\u0084\u0002¢\u0006\f\n\u0004\b\u0002\u0010\u0003\u001a\u0004\b\u0004\u0010\u0005\"!\u0010\t\u001a\u00020\u0001*\u00020\u00008@@\u0000X\u0080\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\u0003\u001a\u0004\b\b\u0010\u0005\"!\u0010\f\u001a\u00020\u0001*\u00020\u00008@@\u0000X\u0080\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u0003\u001a\u0004\b\u000b\u0010\u0005¨\u0006\r"}, d2 = {"Lcom/coinbase/wallet/blockchains/models/CurrencyCode$Companion;", "Lcom/coinbase/wallet/blockchains/models/CurrencyCode;", "WBTC$delegate", "Lkotlin/h;", "getWBTC", "(Lcom/coinbase/wallet/blockchains/models/CurrencyCode$Companion;)Lcom/coinbase/wallet/blockchains/models/CurrencyCode;", "WBTC", "CWBTC$delegate", "getCWBTC", "CWBTC", "CETH$delegate", "getCETH", "CETH", "wallets_release"}, k = 2, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class CurrencyCode_WalletsKt {
    private static final h CETH$delegate;
    private static final h CWBTC$delegate;
    private static final h WBTC$delegate;

    static {
        h b2;
        h b3;
        h b4;
        b2 = k.b(CurrencyCode_WalletsKt$CETH$2.INSTANCE);
        CETH$delegate = b2;
        b3 = k.b(CurrencyCode_WalletsKt$WBTC$2.INSTANCE);
        WBTC$delegate = b3;
        b4 = k.b(CurrencyCode_WalletsKt$CWBTC$2.INSTANCE);
        CWBTC$delegate = b4;
    }

    public static final CurrencyCode getCETH(CurrencyCode.Companion companion) {
        m.g(companion, "<this>");
        return (CurrencyCode) CETH$delegate.getValue();
    }

    public static final CurrencyCode getCWBTC(CurrencyCode.Companion companion) {
        m.g(companion, "<this>");
        return (CurrencyCode) CWBTC$delegate.getValue();
    }

    public static final CurrencyCode getWBTC(CurrencyCode.Companion companion) {
        m.g(companion, "<this>");
        return (CurrencyCode) WBTC$delegate.getValue();
    }
}