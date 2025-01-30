package com.coinbase.wallet.ethereum.extensions;

import com.coinbase.wallet.analytics.models.AnalyticsEvent;
import com.coinbase.wallet.analytics.models.EventFeature;
import com.coinbase.wallet.analytics.models.EventType;
import java.util.Map;
import kotlin.Metadata;
import kotlin.a0.m0;
import kotlin.jvm.internal.m;

/* compiled from: AnalyticsEvent+Ethereum.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0011\u0010\u0004\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0004\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/coinbase/wallet/analytics/models/AnalyticsEvent$Companion;", "Lcom/coinbase/wallet/analytics/models/AnalyticsEvent;", "ethFailedToEncodeTxHash", "(Lcom/coinbase/wallet/analytics/models/AnalyticsEvent$Companion;)Lcom/coinbase/wallet/analytics/models/AnalyticsEvent;", "ethTxAcceptedButReverted", "ethereum_release"}, k = 2, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class AnalyticsEvent_EthereumKt {
    public static final AnalyticsEvent ethFailedToEncodeTxHash(AnalyticsEvent.Companion companion) {
        Map i2;
        m.g(companion, "<this>");
        i2 = m0.i();
        return new AnalyticsEvent(EventType.PRODUCT, "eth_failed_to_encode_tx_hash", EventFeature.Companion.getNone(), false, i2, 8, null);
    }

    public static final AnalyticsEvent ethTxAcceptedButReverted(AnalyticsEvent.Companion companion) {
        Map i2;
        m.g(companion, "<this>");
        i2 = m0.i();
        return new AnalyticsEvent(EventType.PRODUCT, "eth_tx_accepted_but_reverted", EventFeature.Companion.getNone(), false, i2, 8, null);
    }
}