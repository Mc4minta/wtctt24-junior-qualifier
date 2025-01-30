package com.coinbase.wallet.application.extensions;

import com.coinbase.wallet.analytics.models.EventProperty;
import kotlin.Metadata;
import kotlin.e0.c.a;
import kotlin.jvm.internal.o;

/* compiled from: EventProperty+Application.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lcom/coinbase/wallet/analytics/models/EventProperty;", "<anonymous>", "()Lcom/coinbase/wallet/analytics/models/EventProperty;"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes.dex */
final class EventProperty_ApplicationKt$SwapFeeAmount$2 extends o implements a<EventProperty> {
    public static final EventProperty_ApplicationKt$SwapFeeAmount$2 INSTANCE = new EventProperty_ApplicationKt$SwapFeeAmount$2();

    EventProperty_ApplicationKt$SwapFeeAmount$2() {
        super(0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.e0.c.a
    public final EventProperty invoke() {
        return new EventProperty("swap_fee_amount");
    }
}