package com.coinbase.wallet.features.cloudbackup.view;

import android.view.View;
import com.coinbase.wallet.analytics.Analytics;
import com.coinbase.wallet.analytics.models.AnalyticsEvent;
import com.coinbase.wallet.application.extensions.AnalyticsEvent_ApplicationKt;
import com.coinbase.wallet.common.models.UserProperties;
import kotlin.Metadata;

/* compiled from: BackupRecoveryPhraseFragment.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0003\u001a\u00020\u00002\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lkotlin/x;", "kotlin.jvm.PlatformType", "it", "<anonymous>", "(V)V"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes.dex */
final class BackupRecoveryPhraseFragment$setupClickListeners$9$1$2 extends kotlin.jvm.internal.o implements kotlin.e0.c.l<kotlin.x, kotlin.x> {
    final /* synthetic */ BackupRecoveryPhraseFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BackupRecoveryPhraseFragment$setupClickListeners$9$1$2(BackupRecoveryPhraseFragment backupRecoveryPhraseFragment) {
        super(1);
        this.this$0 = backupRecoveryPhraseFragment;
    }

    @Override // kotlin.e0.c.l
    public /* bridge */ /* synthetic */ kotlin.x invoke(kotlin.x xVar) {
        invoke2(xVar);
        return kotlin.x.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(kotlin.x xVar) {
        Analytics analytics = Analytics.INSTANCE;
        analytics.log(AnalyticsEvent_ApplicationKt.backupDeleted(AnalyticsEvent.Companion));
        analytics.setUserProperties(UserProperties.INSTANCE.getCloudBackupDeactivated());
        View view = this.this$0.getView();
        View deleteCloudBackupProgressBar = view == null ? null : view.findViewById(e.j.a.deleteCloudBackupProgressBar);
        kotlin.jvm.internal.m.f(deleteCloudBackupProgressBar, "deleteCloudBackupProgressBar");
        deleteCloudBackupProgressBar.setVisibility(8);
    }
}