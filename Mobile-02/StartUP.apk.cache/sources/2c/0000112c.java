package com.coinbase.wallet.analytics;

import com.appsflyer.AppsFlyerLib;
import kotlin.Metadata;
import kotlin.jvm.internal.o;

/* compiled from: Analytics.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/appsflyer/AppsFlyerLib;", "kotlin.jvm.PlatformType", "<anonymous>", "()Lcom/appsflyer/AppsFlyerLib;"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes.dex */
final class Analytics$appsFlyer$2 extends o implements kotlin.e0.c.a<AppsFlyerLib> {
    public static final Analytics$appsFlyer$2 INSTANCE = new Analytics$appsFlyer$2();

    Analytics$appsFlyer$2() {
        super(0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.e0.c.a
    public final AppsFlyerLib invoke() {
        return AppsFlyerLib.getInstance();
    }
}