package com.coinbase.wallet.application.model;

import com.coinbase.wallet.analytics.models.AnalyticsEvent;
import java.util.List;
import kotlin.Metadata;
import kotlin.a0.r;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;

/* compiled from: NotificationDestination.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0004\b\n\u0010\u000bR\u0019\u0010\u0003\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\f"}, d2 = {"Lcom/coinbase/wallet/application/model/DappDestination;", "Lcom/coinbase/wallet/application/model/NotificationDestination;", "", "url", "Ljava/lang/String;", "getUrl", "()Ljava/lang/String;", "", "Lcom/coinbase/wallet/analytics/models/AnalyticsEvent;", "analyticsEvents", "<init>", "(Ljava/lang/String;Ljava/util/List;)V", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class DappDestination extends NotificationDestination {
    private final String url;

    public /* synthetic */ DappDestination(String str, List list, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i2 & 2) != 0 ? r.g() : list);
    }

    public final String getUrl() {
        return this.url;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DappDestination(String url, List<AnalyticsEvent> analyticsEvents) {
        super("accept", analyticsEvents, null);
        m.g(url, "url");
        m.g(analyticsEvents, "analyticsEvents");
        this.url = url;
    }
}