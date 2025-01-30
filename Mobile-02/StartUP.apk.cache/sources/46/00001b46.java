package com.coinbase.wallet.di;

import com.coinbase.wallet.analytics.Analytics;
import com.coinbase.wallet.analytics.models.AnalyticsEvent;
import com.coinbase.wallet.application.BaseApplication;
import com.coinbase.wallet.application.extensions.AnalyticsEvent_ApplicationKt;
import kotlin.Metadata;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.o;
import kotlin.x;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: NotificationsModule.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lkotlin/x;", "<anonymous>", "()V"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class NotificationsModule$Companion$providesVerifyAppsPrompt$callToAction$1 extends o implements kotlin.e0.c.a<x> {
    final /* synthetic */ BaseApplication $appContext;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NotificationsModule$Companion$providesVerifyAppsPrompt$callToAction$1(BaseApplication baseApplication) {
        super(0);
        this.$appContext = baseApplication;
    }

    public static /* synthetic */ void a(com.google.android.gms.tasks.g gVar) {
        m1081invoke$lambda0(gVar);
    }

    /* renamed from: invoke$lambda-0 */
    public static final void m1081invoke$lambda0(com.google.android.gms.tasks.g task) {
        m.g(task, "task");
        if (task.q()) {
            Analytics.INSTANCE.log(AnalyticsEvent_ApplicationKt.verifyAppsPromptEnabled(AnalyticsEvent.Companion));
        } else {
            Analytics.INSTANCE.log(AnalyticsEvent_ApplicationKt.enablingVerifyAppsFailed(AnalyticsEvent.Companion));
        }
    }

    @Override // kotlin.e0.c.a
    public /* bridge */ /* synthetic */ x invoke() {
        invoke2();
        return x.a;
    }

    /* renamed from: invoke */
    public final void invoke2() {
        e.g.a.e.f.c.a(this.$appContext).o().b(new com.google.android.gms.tasks.c() { // from class: com.coinbase.wallet.di.i
            @Override // com.google.android.gms.tasks.c
            public final void a(com.google.android.gms.tasks.g gVar) {
                NotificationsModule$Companion$providesVerifyAppsPrompt$callToAction$1.a(gVar);
            }
        });
    }
}