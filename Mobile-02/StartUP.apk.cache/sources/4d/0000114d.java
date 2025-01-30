package com.coinbase.wallet.analytics.models;

import com.coinbase.ApiConstants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.a0.m0;
import kotlin.a0.s;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;
import kotlin.u;

/* compiled from: AnalyticsEvent.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dBA\u0012\u0006\u0010\u0016\u001a\u00020\u0015\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0011\u0012\u0014\b\u0002\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u00070\f¢\u0006\u0004\b\u001b\u0010\u001cR\u0019\u0010\u0003\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\b\u001a\u00020\u00078\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR%\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\f8\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u0019\u0010\u0012\u001a\u00020\u00118\u0006@\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0012\u0010\u0014R\u0019\u0010\u0016\u001a\u00020\u00158\u0006@\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019¨\u0006\u001e"}, d2 = {"Lcom/coinbase/wallet/analytics/models/AnalyticsEvent;", "", "Lcom/coinbase/wallet/analytics/models/EventFeature;", "feature", "Lcom/coinbase/wallet/analytics/models/EventFeature;", "getFeature", "()Lcom/coinbase/wallet/analytics/models/EventFeature;", "", ApiConstants.NAME, "Ljava/lang/String;", "getName", "()Ljava/lang/String;", "", "properties", "Ljava/util/Map;", "getProperties", "()Ljava/util/Map;", "", "isNoisy", "Z", "()Z", "Lcom/coinbase/wallet/analytics/models/EventType;", "type", "Lcom/coinbase/wallet/analytics/models/EventType;", "getType", "()Lcom/coinbase/wallet/analytics/models/EventType;", "Lcom/coinbase/wallet/analytics/models/EventProperty;", "<init>", "(Lcom/coinbase/wallet/analytics/models/EventType;Ljava/lang/String;Lcom/coinbase/wallet/analytics/models/EventFeature;ZLjava/util/Map;)V", "Companion", "analytics_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class AnalyticsEvent {
    public static final Companion Companion = new Companion(null);
    private final EventFeature feature;
    private final boolean isNoisy;
    private final String name;
    private final Map<String, String> properties;
    private final EventType type;

    /* compiled from: AnalyticsEvent.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/coinbase/wallet/analytics/models/AnalyticsEvent$Companion;", "", "<init>", "()V", "analytics_release"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public AnalyticsEvent(EventType type, String name, EventFeature feature, boolean z, Map<EventProperty, String> properties) {
        int r;
        Map r2;
        Map<String, String> v;
        m.g(type, "type");
        m.g(name, "name");
        m.g(feature, "feature");
        m.g(properties, "properties");
        this.type = type;
        this.name = name;
        this.feature = feature;
        this.isNoisy = z;
        Set<Map.Entry<EventProperty, String>> entrySet = properties.entrySet();
        r = s.r(entrySet, 10);
        ArrayList arrayList = new ArrayList(r);
        Iterator<T> it = entrySet.iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            arrayList.add(u.a(((EventProperty) entry.getKey()).getRawValue(), entry.getValue()));
        }
        r2 = m0.r(arrayList);
        v = m0.v(r2);
        v.put("category", this.feature.getRawValue());
        this.properties = v;
    }

    public final EventFeature getFeature() {
        return this.feature;
    }

    public final String getName() {
        return this.name;
    }

    public final Map<String, String> getProperties() {
        return this.properties;
    }

    public final EventType getType() {
        return this.type;
    }

    public final boolean isNoisy() {
        return this.isNoisy;
    }

    public /* synthetic */ AnalyticsEvent(EventType eventType, String str, EventFeature eventFeature, boolean z, Map map, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(eventType, str, (i2 & 4) != 0 ? EventFeature.Companion.getNone() : eventFeature, (i2 & 8) != 0 ? false : z, (i2 & 16) != 0 ? m0.i() : map);
    }
}