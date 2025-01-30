package com.coinbase.wallet.wallets.extensions;

import com.coinbase.wallet.analytics.models.EventProperty;
import kotlin.Metadata;
import kotlin.h;
import kotlin.jvm.internal.m;
import kotlin.k;

/* compiled from: EventProperty+Wallets.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u001b\"!\u0010\u0006\u001a\u00020\u0001*\u00020\u00008F@\u0006X\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0002\u0010\u0003\u001a\u0004\b\u0004\u0010\u0005\"!\u0010\t\u001a\u00020\u0001*\u00020\u00008F@\u0006X\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\u0003\u001a\u0004\b\b\u0010\u0005\"!\u0010\f\u001a\u00020\u0001*\u00020\u00008F@\u0006X\u0086\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u0003\u001a\u0004\b\u000b\u0010\u0005\"!\u0010\u000f\u001a\u00020\u0001*\u00020\u00008F@\u0006X\u0086\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\u0003\u001a\u0004\b\u000e\u0010\u0005\"!\u0010\u0012\u001a\u00020\u0001*\u00020\u00008F@\u0006X\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0003\u001a\u0004\b\u0011\u0010\u0005\"!\u0010\u0015\u001a\u00020\u0001*\u00020\u00008@@\u0000X\u0080\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u0003\u001a\u0004\b\u0014\u0010\u0005\"!\u0010\u0018\u001a\u00020\u0001*\u00020\u00008F@\u0006X\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u0003\u001a\u0004\b\u0017\u0010\u0005\"!\u0010\u001b\u001a\u00020\u0001*\u00020\u00008F@\u0006X\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\u0003\u001a\u0004\b\u001a\u0010\u0005¨\u0006\u001c"}, d2 = {"Lcom/coinbase/wallet/analytics/models/EventProperty$Companion;", "Lcom/coinbase/wallet/analytics/models/EventProperty;", "MinutesToConfirm$delegate", "Lkotlin/h;", "getMinutesToConfirm", "(Lcom/coinbase/wallet/analytics/models/EventProperty$Companion;)Lcom/coinbase/wallet/analytics/models/EventProperty;", "MinutesToConfirm", "ChainName$delegate", "getChainName", "ChainName", "TxSource$delegate", "getTxSource", "TxSource", "TxHash$delegate", "getTxHash", "TxHash", "ChainId$delegate", "getChainId", "ChainId", "WasMax$delegate", "getWasMax", "WasMax", "CurrencyCode$delegate", "getCurrencyCode", "CurrencyCode", "Blockchain$delegate", "getBlockchain", "Blockchain", "wallets_release"}, k = 2, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class EventProperty_WalletsKt {
    private static final h Blockchain$delegate;
    private static final h ChainId$delegate;
    private static final h ChainName$delegate;
    private static final h CurrencyCode$delegate;
    private static final h MinutesToConfirm$delegate;
    private static final h TxHash$delegate;
    private static final h TxSource$delegate;
    private static final h WasMax$delegate;

    static {
        h b2;
        h b3;
        h b4;
        h b5;
        h b6;
        h b7;
        h b8;
        h b9;
        b2 = k.b(EventProperty_WalletsKt$Blockchain$2.INSTANCE);
        Blockchain$delegate = b2;
        b3 = k.b(EventProperty_WalletsKt$ChainId$2.INSTANCE);
        ChainId$delegate = b3;
        b4 = k.b(EventProperty_WalletsKt$ChainName$2.INSTANCE);
        ChainName$delegate = b4;
        b5 = k.b(EventProperty_WalletsKt$CurrencyCode$2.INSTANCE);
        CurrencyCode$delegate = b5;
        b6 = k.b(EventProperty_WalletsKt$MinutesToConfirm$2.INSTANCE);
        MinutesToConfirm$delegate = b6;
        b7 = k.b(EventProperty_WalletsKt$TxSource$2.INSTANCE);
        TxSource$delegate = b7;
        b8 = k.b(EventProperty_WalletsKt$TxHash$2.INSTANCE);
        TxHash$delegate = b8;
        b9 = k.b(EventProperty_WalletsKt$WasMax$2.INSTANCE);
        WasMax$delegate = b9;
    }

    public static final EventProperty getBlockchain(EventProperty.Companion companion) {
        m.g(companion, "<this>");
        return (EventProperty) Blockchain$delegate.getValue();
    }

    public static final EventProperty getChainId(EventProperty.Companion companion) {
        m.g(companion, "<this>");
        return (EventProperty) ChainId$delegate.getValue();
    }

    public static final EventProperty getChainName(EventProperty.Companion companion) {
        m.g(companion, "<this>");
        return (EventProperty) ChainName$delegate.getValue();
    }

    public static final EventProperty getCurrencyCode(EventProperty.Companion companion) {
        m.g(companion, "<this>");
        return (EventProperty) CurrencyCode$delegate.getValue();
    }

    public static final EventProperty getMinutesToConfirm(EventProperty.Companion companion) {
        m.g(companion, "<this>");
        return (EventProperty) MinutesToConfirm$delegate.getValue();
    }

    public static final EventProperty getTxHash(EventProperty.Companion companion) {
        m.g(companion, "<this>");
        return (EventProperty) TxHash$delegate.getValue();
    }

    public static final EventProperty getTxSource(EventProperty.Companion companion) {
        m.g(companion, "<this>");
        return (EventProperty) TxSource$delegate.getValue();
    }

    public static final EventProperty getWasMax(EventProperty.Companion companion) {
        m.g(companion, "<this>");
        return (EventProperty) WasMax$delegate.getValue();
    }
}