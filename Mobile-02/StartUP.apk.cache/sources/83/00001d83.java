package com.coinbase.wallet.features.cloudbackup.view;

import android.view.View;
import com.coinbase.wallet.analytics.extensions.Single_AnalyticsKt;
import com.coinbase.wallet.common.extensions.SingleSubscribeProxy_CommonKt;
import com.coinbase.wallet.commonui.utilities.FragmentLifecycleScopeProvider;
import com.coinbase.wallet.features.cloudbackup.viewModel.BackupRecoveryPhraseViewModel;
import kotlin.Metadata;

/* compiled from: BackupRecoveryPhraseFragment.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/view/View;", "it", "Lkotlin/x;", "<anonymous>", "(Landroid/view/View;)V"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class BackupRecoveryPhraseFragment$setupClickListeners$9 extends kotlin.jvm.internal.o implements kotlin.e0.c.l<View, kotlin.x> {
    final /* synthetic */ BackupRecoveryPhraseFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BackupRecoveryPhraseFragment$setupClickListeners$9(BackupRecoveryPhraseFragment backupRecoveryPhraseFragment) {
        super(1);
        this.this$0 = backupRecoveryPhraseFragment;
    }

    public static /* synthetic */ void a(BackupRecoveryPhraseFragment backupRecoveryPhraseFragment, h.c.k0.b bVar) {
        m1225invoke$lambda1$lambda0(backupRecoveryPhraseFragment, bVar);
    }

    /* renamed from: invoke$lambda-1$lambda-0 */
    public static final void m1225invoke$lambda1$lambda0(BackupRecoveryPhraseFragment this$0, h.c.k0.b bVar) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        View view = this$0.getView();
        View deleteCloudBackupBtn = view == null ? null : view.findViewById(e.j.a.deleteCloudBackupBtn);
        kotlin.jvm.internal.m.f(deleteCloudBackupBtn, "deleteCloudBackupBtn");
        deleteCloudBackupBtn.setVisibility(8);
        View view2 = this$0.getView();
        View deleteCloudBackupProgressBar = view2 != null ? view2.findViewById(e.j.a.deleteCloudBackupProgressBar) : null;
        kotlin.jvm.internal.m.f(deleteCloudBackupProgressBar, "deleteCloudBackupProgressBar");
        deleteCloudBackupProgressBar.setVisibility(0);
    }

    @Override // kotlin.e0.c.l
    public /* bridge */ /* synthetic */ kotlin.x invoke(View view) {
        invoke2(view);
        return kotlin.x.a;
    }

    /* renamed from: invoke */
    public final void invoke2(View it) {
        String str;
        BackupRecoveryPhraseViewModel backupRecoveryPhraseViewModel;
        h.c.a0 a0Var;
        FragmentLifecycleScopeProvider onDestroyScopeProvider;
        kotlin.jvm.internal.m.g(it, "it");
        str = this.this$0.mnemonic;
        h.c.k0.b bVar = null;
        if (str != null) {
            final BackupRecoveryPhraseFragment backupRecoveryPhraseFragment = this.this$0;
            backupRecoveryPhraseViewModel = backupRecoveryPhraseFragment.viewModel;
            if (backupRecoveryPhraseViewModel != null) {
                h.c.b0<kotlin.x> deleteBackup = backupRecoveryPhraseViewModel.deleteBackup(str);
                a0Var = backupRecoveryPhraseFragment.mainScheduler;
                h.c.b0<kotlin.x> doOnSubscribe = deleteBackup.observeOn(a0Var).doOnSubscribe(new h.c.m0.f() { // from class: com.coinbase.wallet.features.cloudbackup.view.e
                    @Override // h.c.m0.f
                    public final void accept(Object obj) {
                        BackupRecoveryPhraseFragment$setupClickListeners$9.a(BackupRecoveryPhraseFragment.this, (h.c.k0.b) obj);
                    }
                });
                kotlin.jvm.internal.m.f(doOnSubscribe, "viewModel.deleteBackup(it)\n                    .observeOn(mainScheduler)\n                    .doOnSubscribe {\n                        deleteCloudBackupBtn.isVisible = false\n                        deleteCloudBackupProgressBar.isVisible = true\n                    }");
                h.c.b0 logError$default = Single_AnalyticsKt.logError$default(doOnSubscribe, "Error while deleting cloud backup", null, 2, null);
                onDestroyScopeProvider = backupRecoveryPhraseFragment.getOnDestroyScopeProvider();
                Object as = logError$default.as(com.uber.autodispose.d.a(onDestroyScopeProvider));
                kotlin.jvm.internal.m.f(as, "viewModel.deleteBackup(it)\n                    .observeOn(mainScheduler)\n                    .doOnSubscribe {\n                        deleteCloudBackupBtn.isVisible = false\n                        deleteCloudBackupProgressBar.isVisible = true\n                    }\n                    .logError(\"Error while deleting cloud backup\")\n                    .`as`(autoDisposable(onDestroyScopeProvider))");
                bVar = SingleSubscribeProxy_CommonKt.subscribeBy$default((com.uber.autodispose.a0) as, null, new BackupRecoveryPhraseFragment$setupClickListeners$9$1$2(backupRecoveryPhraseFragment), 1, null);
            } else {
                kotlin.jvm.internal.m.w("viewModel");
                throw null;
            }
        }
        if (bVar == null) {
            throw new IllegalStateException("Mnemonic is null");
        }
    }
}