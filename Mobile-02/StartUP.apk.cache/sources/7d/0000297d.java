package com.coinbase.wallet.wallets.extensions;

import com.appsflyer.AppsFlyerProperties;
import com.coinbase.wallet.analytics.models.AnalyticsEvent;
import com.coinbase.wallet.analytics.models.EventProperty;
import com.coinbase.wallet.analytics.models.EventType;
import com.coinbase.wallet.core.extensions.Strings;
import com.coinbase.wallet.core.extensions.Strings_CoreKt;
import java.util.Map;
import kotlin.Metadata;
import kotlin.a0.m0;
import kotlin.jvm.internal.m;
import kotlin.u;

/* compiled from: AnalyticsEvent+Wallets.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\f\u001a#\u0010\u0005\u001a\u00020\u0004*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0001H\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u001a#\u0010\u0007\u001a\u00020\u0004*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0001H\u0000¢\u0006\u0004\b\u0007\u0010\u0006\u001a-\u0010\t\u001a\u00020\u0004*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\b\b\u0002\u0010\b\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0001H\u0000¢\u0006\u0004\b\t\u0010\n\u001a+\u0010\r\u001a\u00020\u0004*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00012\u0006\u0010\f\u001a\u00020\u000bH\u0000¢\u0006\u0004\b\r\u0010\u000e\u001a+\u0010\u000f\u001a\u00020\u0004*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00012\u0006\u0010\f\u001a\u00020\u000bH\u0000¢\u0006\u0004\b\u000f\u0010\u000e\u001a+\u0010\u0010\u001a\u00020\u0004*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00012\u0006\u0010\f\u001a\u00020\u000bH\u0000¢\u0006\u0004\b\u0010\u0010\u000e\u001a#\u0010\u0011\u001a\u00020\u0004*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0001H\u0000¢\u0006\u0004\b\u0011\u0010\u0006\u001a#\u0010\u0012\u001a\u00020\u0004*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0001H\u0000¢\u0006\u0004\b\u0012\u0010\u0006\u001a#\u0010\u0013\u001a\u00020\u0004*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0001H\u0000¢\u0006\u0004\b\u0013\u0010\u0006\u001a#\u0010\u0014\u001a\u00020\u0004*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0001H\u0000¢\u0006\u0004\b\u0014\u0010\u0006\u001a#\u0010\u0015\u001a\u00020\u0004*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0001H\u0000¢\u0006\u0004\b\u0015\u0010\u0006\u001a-\u0010\u0016\u001a\u00020\u0004*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00012\b\b\u0002\u0010\b\u001a\u00020\u0001H\u0000¢\u0006\u0004\b\u0016\u0010\n¨\u0006\u0017"}, d2 = {"Lcom/coinbase/wallet/analytics/models/AnalyticsEvent$Companion;", "", AppsFlyerProperties.CURRENCY_CODE, "uuid", "Lcom/coinbase/wallet/analytics/models/AnalyticsEvent;", "createWalletStart", "(Lcom/coinbase/wallet/analytics/models/AnalyticsEvent$Companion;Ljava/lang/String;Ljava/lang/String;)Lcom/coinbase/wallet/analytics/models/AnalyticsEvent;", "createWalletSuccess", "desc", "createWalletFail", "(Lcom/coinbase/wallet/analytics/models/AnalyticsEvent$Companion;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/coinbase/wallet/analytics/models/AnalyticsEvent;", "", "wasMax", "txGenerationStart", "(Lcom/coinbase/wallet/analytics/models/AnalyticsEvent$Companion;Ljava/lang/String;Ljava/lang/String;Z)Lcom/coinbase/wallet/analytics/models/AnalyticsEvent;", "txGenerationSuccess", "txGenerationFail", "txSubmittedStart", "txSubmittedSuccess", "txSubmittedFail", "txResubmitJobStart", "txResubmitJobSuccess", "txResubmitJobFail", "wallets_release"}, k = 2, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class AnalyticsEvent_WalletsKt {
    public static final AnalyticsEvent createWalletFail(AnalyticsEvent.Companion companion, String currencyCode, String desc, String uuid) {
        Map l2;
        m.g(companion, "<this>");
        m.g(currencyCode, "currencyCode");
        m.g(desc, "desc");
        m.g(uuid, "uuid");
        EventType eventType = EventType.DIAGNOSTIC;
        EventProperty.Companion companion2 = EventProperty.Companion;
        l2 = m0.l(u.a(EventProperty_WalletsKt.getCurrencyCode(companion2), currencyCode), u.a(companion2.getDescription(), desc), u.a(companion2.getUUID(), uuid));
        return new AnalyticsEvent(eventType, "task.create_wallet.fail", null, false, l2, 12, null);
    }

    public static /* synthetic */ AnalyticsEvent createWalletFail$default(AnalyticsEvent.Companion companion, String str, String str2, String str3, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            str2 = "";
        }
        return createWalletFail(companion, str, str2, str3);
    }

    public static final AnalyticsEvent createWalletStart(AnalyticsEvent.Companion companion, String currencyCode, String uuid) {
        Map l2;
        m.g(companion, "<this>");
        m.g(currencyCode, "currencyCode");
        m.g(uuid, "uuid");
        EventType eventType = EventType.DIAGNOSTIC;
        EventProperty.Companion companion2 = EventProperty.Companion;
        l2 = m0.l(u.a(EventProperty_WalletsKt.getCurrencyCode(companion2), currencyCode), u.a(companion2.getUUID(), uuid));
        return new AnalyticsEvent(eventType, "task.create_wallet.start", null, false, l2, 12, null);
    }

    public static final AnalyticsEvent createWalletSuccess(AnalyticsEvent.Companion companion, String currencyCode, String uuid) {
        Map l2;
        m.g(companion, "<this>");
        m.g(currencyCode, "currencyCode");
        m.g(uuid, "uuid");
        EventType eventType = EventType.DIAGNOSTIC;
        EventProperty.Companion companion2 = EventProperty.Companion;
        l2 = m0.l(u.a(EventProperty_WalletsKt.getCurrencyCode(companion2), currencyCode), u.a(companion2.getUUID(), uuid));
        return new AnalyticsEvent(eventType, "task.create_wallet.success", null, false, l2, 12, null);
    }

    public static final AnalyticsEvent txGenerationFail(AnalyticsEvent.Companion companion, String currencyCode, String uuid, boolean z) {
        Map l2;
        m.g(companion, "<this>");
        m.g(currencyCode, "currencyCode");
        m.g(uuid, "uuid");
        EventType eventType = EventType.DIAGNOSTIC;
        EventProperty.Companion companion2 = EventProperty.Companion;
        l2 = m0.l(u.a(EventProperty_WalletsKt.getWasMax(companion2), String.valueOf(z)), u.a(companion2.getUUID(), uuid), u.a(EventProperty_WalletsKt.getCurrencyCode(companion2), currencyCode));
        return new AnalyticsEvent(eventType, "task.tx_generation.fail", null, false, l2, 12, null);
    }

    public static final AnalyticsEvent txGenerationStart(AnalyticsEvent.Companion companion, String currencyCode, String uuid, boolean z) {
        Map l2;
        m.g(companion, "<this>");
        m.g(currencyCode, "currencyCode");
        m.g(uuid, "uuid");
        EventType eventType = EventType.DIAGNOSTIC;
        EventProperty.Companion companion2 = EventProperty.Companion;
        l2 = m0.l(u.a(EventProperty_WalletsKt.getWasMax(companion2), String.valueOf(z)), u.a(companion2.getUUID(), uuid), u.a(EventProperty_WalletsKt.getCurrencyCode(companion2), currencyCode));
        return new AnalyticsEvent(eventType, "task.tx_generation.start", null, false, l2, 12, null);
    }

    public static final AnalyticsEvent txGenerationSuccess(AnalyticsEvent.Companion companion, String currencyCode, String uuid, boolean z) {
        Map l2;
        m.g(companion, "<this>");
        m.g(currencyCode, "currencyCode");
        m.g(uuid, "uuid");
        EventType eventType = EventType.DIAGNOSTIC;
        EventProperty.Companion companion2 = EventProperty.Companion;
        l2 = m0.l(u.a(EventProperty_WalletsKt.getWasMax(companion2), String.valueOf(z)), u.a(companion2.getUUID(), uuid), u.a(EventProperty_WalletsKt.getCurrencyCode(companion2), currencyCode));
        return new AnalyticsEvent(eventType, "task.tx_generation.success", null, false, l2, 12, null);
    }

    public static final AnalyticsEvent txResubmitJobFail(AnalyticsEvent.Companion companion, String currencyCode, String uuid, String desc) {
        Map l2;
        m.g(companion, "<this>");
        m.g(currencyCode, "currencyCode");
        m.g(uuid, "uuid");
        m.g(desc, "desc");
        EventType eventType = EventType.DIAGNOSTIC;
        EventProperty.Companion companion2 = EventProperty.Companion;
        l2 = m0.l(u.a(EventProperty_WalletsKt.getCurrencyCode(companion2), currencyCode), u.a(companion2.getUUID(), uuid), u.a(companion2.getDescription(), desc));
        return new AnalyticsEvent(eventType, "job.tx_resubmit.fail", null, false, l2, 12, null);
    }

    public static /* synthetic */ AnalyticsEvent txResubmitJobFail$default(AnalyticsEvent.Companion companion, String str, String str2, String str3, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            str3 = Strings_CoreKt.getEmpty(Strings.INSTANCE);
        }
        return txResubmitJobFail(companion, str, str2, str3);
    }

    public static final AnalyticsEvent txResubmitJobStart(AnalyticsEvent.Companion companion, String currencyCode, String uuid) {
        Map l2;
        m.g(companion, "<this>");
        m.g(currencyCode, "currencyCode");
        m.g(uuid, "uuid");
        EventType eventType = EventType.DIAGNOSTIC;
        EventProperty.Companion companion2 = EventProperty.Companion;
        l2 = m0.l(u.a(EventProperty_WalletsKt.getCurrencyCode(companion2), currencyCode), u.a(companion2.getUUID(), uuid));
        return new AnalyticsEvent(eventType, "job.tx_resubmit.start", null, true, l2, 4, null);
    }

    public static final AnalyticsEvent txResubmitJobSuccess(AnalyticsEvent.Companion companion, String currencyCode, String uuid) {
        Map l2;
        m.g(companion, "<this>");
        m.g(currencyCode, "currencyCode");
        m.g(uuid, "uuid");
        EventType eventType = EventType.DIAGNOSTIC;
        EventProperty.Companion companion2 = EventProperty.Companion;
        l2 = m0.l(u.a(EventProperty_WalletsKt.getCurrencyCode(companion2), currencyCode), u.a(companion2.getUUID(), uuid));
        return new AnalyticsEvent(eventType, "job.tx_resubmit.success", null, true, l2, 4, null);
    }

    public static final AnalyticsEvent txSubmittedFail(AnalyticsEvent.Companion companion, String currencyCode, String uuid) {
        Map l2;
        m.g(companion, "<this>");
        m.g(currencyCode, "currencyCode");
        m.g(uuid, "uuid");
        EventType eventType = EventType.DIAGNOSTIC;
        EventProperty.Companion companion2 = EventProperty.Companion;
        l2 = m0.l(u.a(EventProperty_WalletsKt.getCurrencyCode(companion2), currencyCode), u.a(companion2.getUUID(), uuid));
        return new AnalyticsEvent(eventType, "task.confirm_transaction.tx_submitted.fail", null, false, l2, 12, null);
    }

    public static final AnalyticsEvent txSubmittedStart(AnalyticsEvent.Companion companion, String currencyCode, String uuid) {
        Map l2;
        m.g(companion, "<this>");
        m.g(currencyCode, "currencyCode");
        m.g(uuid, "uuid");
        EventType eventType = EventType.DIAGNOSTIC;
        EventProperty.Companion companion2 = EventProperty.Companion;
        l2 = m0.l(u.a(EventProperty_WalletsKt.getCurrencyCode(companion2), currencyCode), u.a(companion2.getUUID(), uuid));
        return new AnalyticsEvent(eventType, "task.confirm_transaction.tx_submitted.start", null, false, l2, 12, null);
    }

    public static final AnalyticsEvent txSubmittedSuccess(AnalyticsEvent.Companion companion, String currencyCode, String uuid) {
        Map l2;
        m.g(companion, "<this>");
        m.g(currencyCode, "currencyCode");
        m.g(uuid, "uuid");
        EventType eventType = EventType.DIAGNOSTIC;
        EventProperty.Companion companion2 = EventProperty.Companion;
        l2 = m0.l(u.a(EventProperty_WalletsKt.getCurrencyCode(companion2), currencyCode), u.a(companion2.getUUID(), uuid));
        return new AnalyticsEvent(eventType, "task.confirm_transaction.tx_submitted.success", null, false, l2, 12, null);
    }
}