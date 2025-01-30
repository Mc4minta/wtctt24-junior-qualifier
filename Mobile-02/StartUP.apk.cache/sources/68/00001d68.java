package com.coinbase.wallet.features.cloudbackup.view;

import com.coinbase.wallet.commonui.extensions.Fragment_CommonKt;
import com.coinbase.wallet.features.cloudbackup.models.BackupPayload;
import com.coinbase.wallet.features.cloudbackup.view.adapter.BackupPickerAdapter;
import java.util.List;
import kotlin.Metadata;
import org.toshi.R;

/* compiled from: BackupPickerFragment.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lcom/coinbase/wallet/features/cloudbackup/view/adapter/BackupPickerAdapter;", "<anonymous>", "()Lcom/coinbase/wallet/features/cloudbackup/view/adapter/BackupPickerAdapter;"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes.dex */
final class BackupPickerFragment$backupPickerAdapter$2 extends kotlin.jvm.internal.o implements kotlin.e0.c.a<BackupPickerAdapter> {
    final /* synthetic */ BackupPickerFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: BackupPickerFragment.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/coinbase/wallet/features/cloudbackup/models/BackupPayload;", "backup", "Lkotlin/x;", "<anonymous>", "(Lcom/coinbase/wallet/features/cloudbackup/models/BackupPayload;)V"}, k = 3, mv = {1, 5, 1})
    /* renamed from: com.coinbase.wallet.features.cloudbackup.view.BackupPickerFragment$backupPickerAdapter$2$1  reason: invalid class name */
    /* loaded from: classes.dex */
    public static final class AnonymousClass1 extends kotlin.jvm.internal.o implements kotlin.e0.c.l<BackupPayload, kotlin.x> {
        final /* synthetic */ BackupPickerFragment this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(BackupPickerFragment backupPickerFragment) {
            super(1);
            this.this$0 = backupPickerFragment;
        }

        @Override // kotlin.e0.c.l
        public /* bridge */ /* synthetic */ kotlin.x invoke(BackupPayload backupPayload) {
            invoke2(backupPayload);
            return kotlin.x.a;
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2(BackupPayload backup) {
            kotlin.jvm.internal.m.g(backup, "backup");
            Fragment_CommonKt.navigate$default(this.this$0, R.id.action_backupPickerFragment_to_enterPasswordFragment, EnterPasswordFragment.Companion.createArguments(backup), null, null, 12, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BackupPickerFragment$backupPickerAdapter$2(BackupPickerFragment backupPickerFragment) {
        super(0);
        this.this$0 = backupPickerFragment;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.e0.c.a
    public final BackupPickerAdapter invoke() {
        List backups;
        backups = this.this$0.getBackups();
        return new BackupPickerAdapter(backups, new AnonymousClass1(this.this$0));
    }
}