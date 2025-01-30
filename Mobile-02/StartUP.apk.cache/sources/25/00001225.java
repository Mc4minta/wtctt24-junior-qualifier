package com.coinbase.wallet.application.service;

import com.coinbase.wallet.analytics.Analytics;
import com.coinbase.wallet.analytics.models.AnalyticsEvent;
import com.coinbase.wallet.application.extensions.AnalyticsEvent_ApplicationKt;
import com.coinbase.walletlink.models.HostRequestId;
import kotlin.Metadata;
import kotlin.x;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ApplicationService.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/coinbase/walletlink/models/HostRequestId;", "kotlin.jvm.PlatformType", "childRequest", "Lkotlin/x;", "<anonymous>", "(Lcom/coinbase/walletlink/models/HostRequestId;)V"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class ApplicationService$start$1 extends kotlin.jvm.internal.o implements kotlin.e0.c.l<HostRequestId, x> {
    public static final ApplicationService$start$1 INSTANCE = new ApplicationService$start$1();

    ApplicationService$start$1() {
        super(1);
    }

    @Override // kotlin.e0.c.l
    public /* bridge */ /* synthetic */ x invoke(HostRequestId hostRequestId) {
        invoke2(hostRequestId);
        return x.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(HostRequestId hostRequestId) {
        Analytics analytics = Analytics.INSTANCE;
        AnalyticsEvent.Companion companion = AnalyticsEvent.Companion;
        String dappName = hostRequestId.getDappName();
        if (dappName == null) {
            dappName = "";
        }
        String host = hostRequestId.getDappURL().getHost();
        analytics.log(AnalyticsEvent_ApplicationKt.dappConnectedViaExtension(companion, dappName, host != null ? host : "", String.valueOf(hostRequestId.getDappImageURL())));
    }
}