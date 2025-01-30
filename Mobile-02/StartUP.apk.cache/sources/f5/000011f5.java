package com.coinbase.wallet.application.model;

import com.coinbase.wallet.analytics.models.AnalyticsEvent;
import java.util.List;
import kotlin.Metadata;
import kotlin.a0.r;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;

/* compiled from: NotificationDestination.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/coinbase/wallet/application/model/DismissForeverDestination;", "Lcom/coinbase/wallet/application/model/NotificationDestination;", "", "Lcom/coinbase/wallet/analytics/models/AnalyticsEvent;", "analyticsEvents", "<init>", "(Ljava/util/List;)V", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class DismissForeverDestination extends NotificationDestination {
    public DismissForeverDestination() {
        this(null, 1, null);
    }

    public /* synthetic */ DismissForeverDestination(List list, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? r.g() : list);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DismissForeverDestination(List<AnalyticsEvent> analyticsEvents) {
        super("dismissForever", analyticsEvents, null);
        m.g(analyticsEvents, "analyticsEvents");
    }
}