package com.coinbase.wallet.consumer.extensions;

import com.coinbase.wallet.analytics.models.EventFeature;
import kotlin.Metadata;
import kotlin.h;
import kotlin.jvm.internal.m;
import kotlin.k;

/* compiled from: EventFeature+Consumer.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\"!\u0010\u0006\u001a\u00020\u0001*\u00020\u00008F@\u0006X\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0002\u0010\u0003\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0007"}, d2 = {"Lcom/coinbase/wallet/analytics/models/EventFeature$Companion;", "Lcom/coinbase/wallet/analytics/models/EventFeature;", "ConsumerConnect$delegate", "Lkotlin/h;", "getConsumerConnect", "(Lcom/coinbase/wallet/analytics/models/EventFeature$Companion;)Lcom/coinbase/wallet/analytics/models/EventFeature;", "ConsumerConnect", "consumer_productionRelease"}, k = 2, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class EventFeature_ConsumerKt {
    private static final h ConsumerConnect$delegate;

    static {
        h b2;
        b2 = k.b(EventFeature_ConsumerKt$ConsumerConnect$2.INSTANCE);
        ConsumerConnect$delegate = b2;
    }

    public static final EventFeature getConsumerConnect(EventFeature.Companion companion) {
        m.g(companion, "<this>");
        return (EventFeature) ConsumerConnect$delegate.getValue();
    }
}