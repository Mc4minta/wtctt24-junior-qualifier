package com.coinbase.wallet.application.view;

import com.coinbase.wallet.analytics.Analytics;
import com.coinbase.wallet.analytics.models.AnalyticsUserProperty;
import java.util.List;
import kotlin.Metadata;
import kotlin.e0.c.l;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.o;
import kotlin.x;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: HomeFragment.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0005\u001a\u00020\u00042\u001a\u0010\u0003\u001a\u0016\u0012\u0004\u0012\u00020\u0001 \u0002*\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"", "Lcom/coinbase/wallet/analytics/models/AnalyticsUserProperty;", "kotlin.jvm.PlatformType", "it", "Lkotlin/x;", "<anonymous>", "(Ljava/util/List;)V"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class HomeFragment$initObservables$8 extends o implements l<List<? extends AnalyticsUserProperty>, x> {
    public static final HomeFragment$initObservables$8 INSTANCE = new HomeFragment$initObservables$8();

    HomeFragment$initObservables$8() {
        super(1);
    }

    @Override // kotlin.e0.c.l
    public /* bridge */ /* synthetic */ x invoke(List<? extends AnalyticsUserProperty> list) {
        invoke2((List<AnalyticsUserProperty>) list);
        return x.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(List<AnalyticsUserProperty> it) {
        m.f(it, "it");
        for (AnalyticsUserProperty analyticsUserProperty : it) {
            Analytics.INSTANCE.setUserProperties(analyticsUserProperty);
        }
    }
}