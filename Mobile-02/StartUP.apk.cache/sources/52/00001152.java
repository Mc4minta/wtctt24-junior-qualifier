package com.coinbase.wallet.analytics.models;

import com.coinbase.ApiConstants;
import kotlin.Metadata;
import kotlin.h;
import kotlin.j0.m;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.e0;
import kotlin.jvm.internal.x;
import kotlin.k;

/* compiled from: EventProperty.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0016\u0018\u0000 \t2\u00020\u0001:\u0001\tB\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0019\u0010\u0003\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/coinbase/wallet/analytics/models/EventProperty;", "", "", "rawValue", "Ljava/lang/String;", "getRawValue", "()Ljava/lang/String;", "<init>", "(Ljava/lang/String;)V", "Companion", "analytics_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public class EventProperty {
    private static final h<EventProperty> ContractAddress$delegate;
    private final String rawValue;
    public static final Companion Companion = new Companion(null);
    private static final EventProperty UUID = new EventProperty("uuid");
    private static final EventProperty Description = new EventProperty(ApiConstants.DESCRIPTION);

    /* compiled from: EventProperty.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\r\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\r\u0010\u000eR\u001d\u0010\u0007\u001a\u00020\u00028F@\u0006X\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u0006R\u0019\u0010\u000b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u000b\u0010\t\u001a\u0004\b\f\u0010\u0006¨\u0006\u000f"}, d2 = {"Lcom/coinbase/wallet/analytics/models/EventProperty$Companion;", "", "Lcom/coinbase/wallet/analytics/models/EventProperty;", "ContractAddress$delegate", "Lkotlin/h;", "getContractAddress", "()Lcom/coinbase/wallet/analytics/models/EventProperty;", "ContractAddress", "Description", "Lcom/coinbase/wallet/analytics/models/EventProperty;", "getDescription", "UUID", "getUUID", "<init>", "()V", "analytics_release"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public static final class Companion {
        static final /* synthetic */ m<Object>[] $$delegatedProperties = {e0.h(new x(e0.b(Companion.class), "ContractAddress", "getContractAddress()Lcom/coinbase/wallet/analytics/models/EventProperty;"))};

        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final EventProperty getContractAddress() {
            return (EventProperty) EventProperty.ContractAddress$delegate.getValue();
        }

        public final EventProperty getDescription() {
            return EventProperty.Description;
        }

        public final EventProperty getUUID() {
            return EventProperty.UUID;
        }
    }

    static {
        h<EventProperty> b2;
        b2 = k.b(EventProperty$Companion$ContractAddress$2.INSTANCE);
        ContractAddress$delegate = b2;
    }

    public EventProperty(String rawValue) {
        kotlin.jvm.internal.m.g(rawValue, "rawValue");
        this.rawValue = rawValue;
    }

    public final String getRawValue() {
        return this.rawValue;
    }
}