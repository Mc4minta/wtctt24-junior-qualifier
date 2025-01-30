package com.coinbase.wallet.analytics.models;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;

/* compiled from: EventFeature.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0016\u0018\u0000 \t2\u00020\u0001:\u0001\tB\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0019\u0010\u0003\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/coinbase/wallet/analytics/models/EventFeature;", "", "", "rawValue", "Ljava/lang/String;", "getRawValue", "()Ljava/lang/String;", "<init>", "(Ljava/lang/String;)V", "Companion", "analytics_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public class EventFeature {
    public static final Companion Companion = new Companion(null);
    private static final EventFeature None = new EventFeature("None");
    private final String rawValue;

    /* compiled from: EventFeature.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0019\u0010\u0003\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/coinbase/wallet/analytics/models/EventFeature$Companion;", "", "Lcom/coinbase/wallet/analytics/models/EventFeature;", "None", "Lcom/coinbase/wallet/analytics/models/EventFeature;", "getNone", "()Lcom/coinbase/wallet/analytics/models/EventFeature;", "<init>", "()V", "analytics_release"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final EventFeature getNone() {
            return EventFeature.None;
        }
    }

    public EventFeature(String rawValue) {
        m.g(rawValue, "rawValue");
        this.rawValue = rawValue;
    }

    public final String getRawValue() {
        return this.rawValue;
    }
}