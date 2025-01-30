package com.coinbase.wallet.features.cloudbackup.view;

import android.view.View;
import com.coinbase.wallet.analytics.Analytics;
import com.coinbase.wallet.analytics.models.AnalyticsEvent;
import com.coinbase.wallet.application.extensions.AnalyticsEvent_ApplicationKt;
import kotlin.Metadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: RestoreWalletFragment.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/view/View;", "it", "Lkotlin/x;", "<anonymous>", "(Landroid/view/View;)V"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class RestoreWalletFragment$initClicks$2 extends kotlin.jvm.internal.o implements kotlin.e0.c.l<View, kotlin.x> {
    final /* synthetic */ RestoreWalletFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RestoreWalletFragment$initClicks$2(RestoreWalletFragment restoreWalletFragment) {
        super(1);
        this.this$0 = restoreWalletFragment;
    }

    @Override // kotlin.e0.c.l
    public /* bridge */ /* synthetic */ kotlin.x invoke(View view) {
        invoke2(view);
        return kotlin.x.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(View it) {
        com.google.android.gms.auth.api.signin.c googleSignInClient;
        com.google.android.gms.auth.api.signin.c googleSignInClient2;
        kotlin.jvm.internal.m.g(it, "it");
        googleSignInClient = this.this$0.getGoogleSignInClient();
        googleSignInClient.q();
        Analytics.INSTANCE.log(AnalyticsEvent_ApplicationKt.restoreWithCloudStart$default(AnalyticsEvent.Companion, null, 1, null));
        RestoreWalletFragment restoreWalletFragment = this.this$0;
        googleSignInClient2 = restoreWalletFragment.getGoogleSignInClient();
        restoreWalletFragment.startActivityForResult(googleSignInClient2.o(), 0);
    }
}