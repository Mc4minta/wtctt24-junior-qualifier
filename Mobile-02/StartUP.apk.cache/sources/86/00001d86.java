package com.coinbase.wallet.features.cloudbackup.view;

import com.coinbase.wallet.features.cloudbackup.models.BackupStatus;
import kotlin.Metadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: BackupRecoveryPhraseFragment.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/coinbase/wallet/features/cloudbackup/models/BackupStatus;", "kotlin.jvm.PlatformType", "it", "Lkotlin/x;", "<anonymous>", "(Lcom/coinbase/wallet/features/cloudbackup/models/BackupStatus;)V"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class BackupRecoveryPhraseFragment$setupObservers$2 extends kotlin.jvm.internal.o implements kotlin.e0.c.l<BackupStatus, kotlin.x> {
    final /* synthetic */ BackupRecoveryPhraseFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BackupRecoveryPhraseFragment$setupObservers$2(BackupRecoveryPhraseFragment backupRecoveryPhraseFragment) {
        super(1);
        this.this$0 = backupRecoveryPhraseFragment;
    }

    @Override // kotlin.e0.c.l
    public /* bridge */ /* synthetic */ kotlin.x invoke(BackupStatus backupStatus) {
        invoke2(backupStatus);
        return kotlin.x.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(BackupStatus it) {
        BackupRecoveryPhraseFragment backupRecoveryPhraseFragment = this.this$0;
        kotlin.jvm.internal.m.f(it, "it");
        backupRecoveryPhraseFragment.handleBackupStatusChange(it);
    }
}