package com.coinbase.wallet.application.extensions;

import com.coinbase.wallet.analytics.models.AnalyticsEvent;
import com.coinbase.wallet.analytics.models.EventType;
import kotlin.Metadata;
import kotlin.e0.c.a;
import kotlin.jvm.internal.o;

/* compiled from: AnalyticsEvent+Application.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lcom/coinbase/wallet/analytics/models/AnalyticsEvent;", "<anonymous>", "()Lcom/coinbase/wallet/analytics/models/AnalyticsEvent;"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes.dex */
final class AnalyticsEvent_ApplicationKt$blankWalletList$2 extends o implements a<AnalyticsEvent> {
    public static final AnalyticsEvent_ApplicationKt$blankWalletList$2 INSTANCE = new AnalyticsEvent_ApplicationKt$blankWalletList$2();

    AnalyticsEvent_ApplicationKt$blankWalletList$2() {
        super(0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.e0.c.a
    public final AnalyticsEvent invoke() {
        return new AnalyticsEvent(EventType.DIAGNOSTIC, "blank_wallet_list", null, false, null, 28, null);
    }
}