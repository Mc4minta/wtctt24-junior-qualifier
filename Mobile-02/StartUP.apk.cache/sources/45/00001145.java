package com.coinbase.wallet.analytics.extensions;

import com.coinbase.ApiConstants;
import com.coinbase.wallet.analytics.models.AnalyticsEvent;
import com.coinbase.wallet.analytics.models.EventProperty;
import com.coinbase.wallet.analytics.models.EventType;
import com.coinbase.wallet.core.extensions.Strings;
import com.coinbase.wallet.core.extensions.Strings_CoreKt;
import java.util.Map;
import kotlin.Metadata;
import kotlin.a0.m0;
import kotlin.jvm.internal.m;
import kotlin.l0.x;

/* compiled from: AnalyticsEvent+Analytics.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a1\u0010\u0007\u001a\u00020\u0006*\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00012\u0014\b\u0002\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/coinbase/wallet/analytics/models/AnalyticsEvent$Companion;", "", ApiConstants.DESCRIPTION, "", "Lcom/coinbase/wallet/analytics/models/EventProperty;", "properties", "Lcom/coinbase/wallet/analytics/models/AnalyticsEvent;", "generalError", "(Lcom/coinbase/wallet/analytics/models/AnalyticsEvent$Companion;Ljava/lang/String;Ljava/util/Map;)Lcom/coinbase/wallet/analytics/models/AnalyticsEvent;", "analytics_release"}, k = 2, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class AnalyticsEvent_AnalyticsKt {
    public static final AnalyticsEvent generalError(AnalyticsEvent.Companion companion, String description, Map<EventProperty, String> properties) {
        Map v;
        boolean D;
        m.g(companion, "<this>");
        m.g(description, "description");
        m.g(properties, "properties");
        v = m0.v(properties);
        D = x.D(description);
        if (!D) {
            v.put(EventProperty.Companion.getDescription(), description);
        }
        return new AnalyticsEvent(EventType.PRODUCT, "general_error", null, true, v, 4, null);
    }

    public static /* synthetic */ AnalyticsEvent generalError$default(AnalyticsEvent.Companion companion, String str, Map map, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = Strings_CoreKt.getEmpty(Strings.INSTANCE);
        }
        if ((i2 & 2) != 0) {
            map = m0.i();
        }
        return generalError(companion, str, map);
    }
}