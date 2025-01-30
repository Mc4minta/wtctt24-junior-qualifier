package com.coinbase.wallet.application.model;

import android.os.Bundle;
import androidx.navigation.p;
import com.coinbase.wallet.analytics.models.AnalyticsEvent;
import java.util.List;
import kotlin.Metadata;
import kotlin.a0.r;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;

/* compiled from: NotificationDestination.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001BE\u0012\b\b\u0001\u0010\u0003\u001a\u00020\u0002\u0012\u000e\b\u0002\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0011¢\u0006\u0004\b\u0019\u0010\u001aR\u0019\u0010\u0003\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001b\u0010\r\u001a\u0004\u0018\u00010\f8\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001b\u0010\u0012\u001a\u0004\u0018\u00010\u00118\u0006@\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u001b"}, d2 = {"Lcom/coinbase/wallet/application/model/NavDestination;", "Lcom/coinbase/wallet/application/model/NotificationDestination;", "", "destinationResId", "I", "getDestinationResId", "()I", "Landroid/os/Bundle;", "args", "Landroid/os/Bundle;", "getArgs", "()Landroid/os/Bundle;", "Lcom/coinbase/wallet/application/model/MainTab;", "tab", "Lcom/coinbase/wallet/application/model/MainTab;", "getTab", "()Lcom/coinbase/wallet/application/model/MainTab;", "Landroidx/navigation/p;", "navOptions", "Landroidx/navigation/p;", "getNavOptions", "()Landroidx/navigation/p;", "", "Lcom/coinbase/wallet/analytics/models/AnalyticsEvent;", "analyticsEvents", "<init>", "(ILjava/util/List;Lcom/coinbase/wallet/application/model/MainTab;Landroid/os/Bundle;Landroidx/navigation/p;)V", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class NavDestination extends NotificationDestination {
    private final Bundle args;
    private final int destinationResId;
    private final p navOptions;
    private final MainTab tab;

    public /* synthetic */ NavDestination(int i2, List list, MainTab mainTab, Bundle bundle, p pVar, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(i2, (i3 & 2) != 0 ? r.g() : list, (i3 & 4) != 0 ? null : mainTab, (i3 & 8) != 0 ? null : bundle, (i3 & 16) != 0 ? null : pVar);
    }

    public final Bundle getArgs() {
        return this.args;
    }

    public final int getDestinationResId() {
        return this.destinationResId;
    }

    public final p getNavOptions() {
        return this.navOptions;
    }

    public final MainTab getTab() {
        return this.tab;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NavDestination(int i2, List<AnalyticsEvent> analyticsEvents, MainTab mainTab, Bundle bundle, p pVar) {
        super("accept", analyticsEvents, null);
        m.g(analyticsEvents, "analyticsEvents");
        this.destinationResId = i2;
        this.tab = mainTab;
        this.args = bundle;
        this.navOptions = pVar;
    }
}