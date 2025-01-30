package com.coinbase.wallet.txhistory.extensions;

import com.appsflyer.internal.referrer.Payload;
import com.coinbase.wallet.analytics.models.AnalyticsEvent;
import com.coinbase.wallet.analytics.models.EventFeature;
import com.coinbase.wallet.analytics.models.EventProperty;
import com.coinbase.wallet.analytics.models.EventType;
import com.coinbase.wallet.blockchains.models.Blockchain;
import com.coinbase.wallet.routing.models.RouteActionKey;
import com.coinbase.wallet.wallets.extensions.EventProperty_WalletsKt;
import java.util.Map;
import kotlin.Metadata;
import kotlin.a0.m0;
import kotlin.jvm.internal.m;
import kotlin.u;

/* compiled from: AnalyticsEvent+TxHistory.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\u001a1\u0010\t\u001a\u00020\b*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0001¢\u0006\u0004\b\t\u0010\n\u001a9\u0010\f\u001a\u00020\b*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0001¢\u0006\u0004\b\f\u0010\r\u001a9\u0010\u0010\u001a\u00020\b*\u00020\u00002\u0006\u0010\u000e\u001a\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0001¢\u0006\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Lcom/coinbase/wallet/analytics/models/AnalyticsEvent$Companion;", "", Payload.SOURCE, "Lcom/coinbase/wallet/blockchains/models/Blockchain;", RouteActionKey.RouteActionKeys.BLOCKCHAIN, "", RouteActionKey.RouteActionKeys.CHAIN_ID, "chainName", "Lcom/coinbase/wallet/analytics/models/AnalyticsEvent;", "txDropped", "(Lcom/coinbase/wallet/analytics/models/AnalyticsEvent$Companion;Ljava/lang/String;Lcom/coinbase/wallet/blockchains/models/Blockchain;ILjava/lang/String;)Lcom/coinbase/wallet/analytics/models/AnalyticsEvent;", "txHash", "txFailed", "(Lcom/coinbase/wallet/analytics/models/AnalyticsEvent$Companion;Ljava/lang/String;Lcom/coinbase/wallet/blockchains/models/Blockchain;Ljava/lang/String;ILjava/lang/String;)Lcom/coinbase/wallet/analytics/models/AnalyticsEvent;", "minutesToConfirm", "txSource", "txConfirmed", "(Lcom/coinbase/wallet/analytics/models/AnalyticsEvent$Companion;Ljava/lang/String;Ljava/lang/String;Lcom/coinbase/wallet/blockchains/models/Blockchain;ILjava/lang/String;)Lcom/coinbase/wallet/analytics/models/AnalyticsEvent;", "txhistory_productionRelease"}, k = 2, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class AnalyticsEvent_TxHistoryKt {
    public static final AnalyticsEvent txConfirmed(AnalyticsEvent.Companion companion, String minutesToConfirm, String txSource, Blockchain blockchain, int i2, String chainName) {
        Map l2;
        m.g(companion, "<this>");
        m.g(minutesToConfirm, "minutesToConfirm");
        m.g(txSource, "txSource");
        m.g(blockchain, "blockchain");
        m.g(chainName, "chainName");
        EventProperty.Companion companion2 = EventProperty.Companion;
        l2 = m0.l(u.a(EventProperty_WalletsKt.getMinutesToConfirm(companion2), minutesToConfirm), u.a(EventProperty_WalletsKt.getTxSource(companion2), txSource), u.a(EventProperty_WalletsKt.getBlockchain(companion2), blockchain.getRawValue()), u.a(EventProperty_WalletsKt.getChainId(companion2), String.valueOf(i2)), u.a(EventProperty_WalletsKt.getChainName(companion2), chainName));
        return new AnalyticsEvent(EventType.PRODUCT, "tx_confirmed", EventFeature.Companion.getNone(), false, l2, 8, null);
    }

    public static final AnalyticsEvent txDropped(AnalyticsEvent.Companion companion, String source, Blockchain blockchain, int i2, String chainName) {
        Map l2;
        m.g(companion, "<this>");
        m.g(source, "source");
        m.g(blockchain, "blockchain");
        m.g(chainName, "chainName");
        EventProperty.Companion companion2 = EventProperty.Companion;
        l2 = m0.l(u.a(EventProperty_WalletsKt.getTxSource(companion2), source), u.a(EventProperty_WalletsKt.getBlockchain(companion2), blockchain.getRawValue()), u.a(EventProperty_WalletsKt.getChainId(companion2), String.valueOf(i2)), u.a(EventProperty_WalletsKt.getChainName(companion2), chainName));
        return new AnalyticsEvent(EventType.PRODUCT, "tx_dropped", EventFeature.Companion.getNone(), false, l2, 8, null);
    }

    public static final AnalyticsEvent txFailed(AnalyticsEvent.Companion companion, String source, Blockchain blockchain, String txHash, int i2, String chainName) {
        Map l2;
        m.g(companion, "<this>");
        m.g(source, "source");
        m.g(blockchain, "blockchain");
        m.g(txHash, "txHash");
        m.g(chainName, "chainName");
        EventProperty.Companion companion2 = EventProperty.Companion;
        l2 = m0.l(u.a(EventProperty_WalletsKt.getTxSource(companion2), source), u.a(EventProperty_WalletsKt.getBlockchain(companion2), blockchain.getRawValue()), u.a(EventProperty_WalletsKt.getTxHash(companion2), txHash), u.a(EventProperty_WalletsKt.getChainId(companion2), String.valueOf(i2)), u.a(EventProperty_WalletsKt.getChainName(companion2), chainName));
        return new AnalyticsEvent(EventType.PRODUCT, "tx_failed", EventFeature.Companion.getNone(), false, l2, 8, null);
    }
}