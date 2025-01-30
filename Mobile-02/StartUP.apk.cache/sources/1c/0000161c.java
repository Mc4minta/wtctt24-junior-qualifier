package com.coinbase.wallet.consumer.extensions;

import com.coinbase.wallet.analytics.models.EventFeature;
import kotlin.Metadata;
import kotlin.e0.c.a;
import kotlin.jvm.internal.o;

/* compiled from: EventFeature+Consumer.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lcom/coinbase/wallet/analytics/models/EventFeature;", "<anonymous>", "()Lcom/coinbase/wallet/analytics/models/EventFeature;"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes.dex */
final class EventFeature_ConsumerKt$ConsumerConnect$2 extends o implements a<EventFeature> {
    public static final EventFeature_ConsumerKt$ConsumerConnect$2 INSTANCE = new EventFeature_ConsumerKt$ConsumerConnect$2();

    EventFeature_ConsumerKt$ConsumerConnect$2() {
        super(0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.e0.c.a
    public final EventFeature invoke() {
        return new EventFeature("ConsumerConnect");
    }
}