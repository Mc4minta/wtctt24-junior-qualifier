package com.coinbase.wallet.application.model;

import com.coinbase.wallet.analytics.models.AnalyticsEvent;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: NotificationDestination.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001B\u001f\b\u0004\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0004\b\r\u0010\u000eR\u0019\u0010\u0003\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00078\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\u0082\u0001\u0005\u000f\u0010\u0011\u0012\u0013¨\u0006\u0014"}, d2 = {"Lcom/coinbase/wallet/application/model/NotificationDestination;", "", "", "actionType", "Ljava/lang/String;", "getActionType", "()Ljava/lang/String;", "", "Lcom/coinbase/wallet/analytics/models/AnalyticsEvent;", "analyticsEvents", "Ljava/util/List;", "getAnalyticsEvents", "()Ljava/util/List;", "<init>", "(Ljava/lang/String;Ljava/util/List;)V", "Lcom/coinbase/wallet/application/model/NavDestination;", "Lcom/coinbase/wallet/application/model/DappDestination;", "Lcom/coinbase/wallet/application/model/DismissDestination;", "Lcom/coinbase/wallet/application/model/DismissForeverDestination;", "Lcom/coinbase/wallet/application/model/NoDestination;", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public abstract class NotificationDestination {
    private final String actionType;
    private final List<AnalyticsEvent> analyticsEvents;

    private NotificationDestination(String str, List<AnalyticsEvent> list) {
        this.actionType = str;
        this.analyticsEvents = list;
    }

    public /* synthetic */ NotificationDestination(String str, List list, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, list);
    }

    public final String getActionType() {
        return this.actionType;
    }

    public final List<AnalyticsEvent> getAnalyticsEvents() {
        return this.analyticsEvents;
    }
}