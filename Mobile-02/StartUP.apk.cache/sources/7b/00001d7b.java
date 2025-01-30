package com.coinbase.wallet.features.cloudbackup.view;

import android.database.ContentObserver;
import android.os.Handler;
import android.os.Looper;
import kotlin.Metadata;

/* compiled from: BackupRecoveryPhraseFragment.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0007\n\u0002\b\u0003*\u0001\u0000\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"com/coinbase/wallet/features/cloudbackup/view/BackupRecoveryPhraseFragment$screenshotObserver$2$1", "<anonymous>", "()Lcom/coinbase/wallet/features/cloudbackup/view/BackupRecoveryPhraseFragment$screenshotObserver$2$1;"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes.dex */
final class BackupRecoveryPhraseFragment$screenshotObserver$2 extends kotlin.jvm.internal.o implements kotlin.e0.c.a<AnonymousClass1> {
    final /* synthetic */ BackupRecoveryPhraseFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BackupRecoveryPhraseFragment$screenshotObserver$2(BackupRecoveryPhraseFragment backupRecoveryPhraseFragment) {
        super(0);
        this.this$0 = backupRecoveryPhraseFragment;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    /* JADX WARN: Type inference failed for: r2v1, types: [com.coinbase.wallet.features.cloudbackup.view.BackupRecoveryPhraseFragment$screenshotObserver$2$1] */
    @Override // kotlin.e0.c.a
    public final AnonymousClass1 invoke() {
        final kotlin.jvm.internal.d0 d0Var = new kotlin.jvm.internal.d0();
        Handler handler = new Handler(Looper.getMainLooper());
        final BackupRecoveryPhraseFragment backupRecoveryPhraseFragment = this.this$0;
        return new ContentObserver(handler) { // from class: com.coinbase.wallet.features.cloudbackup.view.BackupRecoveryPhraseFragment$screenshotObserver$2.1
            /* JADX WARN: Type inference failed for: r0v3, types: [T, androidx.appcompat.app.c] */
            @Override // android.database.ContentObserver
            public void onChange(boolean z) {
                ?? createAndShowScreenshotDialog;
                androidx.appcompat.app.c cVar = d0Var.a;
                boolean z2 = false;
                if (cVar != null && cVar.isShowing()) {
                    z2 = true;
                }
                if (z2) {
                    return;
                }
                kotlin.jvm.internal.d0<androidx.appcompat.app.c> d0Var2 = d0Var;
                createAndShowScreenshotDialog = backupRecoveryPhraseFragment.createAndShowScreenshotDialog();
                d0Var2.a = createAndShowScreenshotDialog;
            }
        };
    }
}