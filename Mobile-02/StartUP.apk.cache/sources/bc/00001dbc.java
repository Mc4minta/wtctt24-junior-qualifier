package com.coinbase.wallet.features.cloudbackup.view;

import com.coinbase.wallet.commonui.extensions.Fragment_CommonKt;
import com.coinbase.wallet.features.cloudbackup.models.BackupPayload;
import com.coinbase.wallet.features.cloudbackup.view.EnterPasswordFragment;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import org.toshi.R;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: RestoreWalletFragment.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0005\u001a\u00020\u00042\u001a\u0010\u0003\u001a\u0016\u0012\u0004\u0012\u00020\u0001 \u0002*\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"", "Lcom/coinbase/wallet/features/cloudbackup/models/BackupPayload;", "kotlin.jvm.PlatformType", "it", "Lkotlin/x;", "<anonymous>", "(Ljava/util/List;)V"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class RestoreWalletFragment$getBackups$2 extends kotlin.jvm.internal.o implements kotlin.e0.c.l<List<? extends BackupPayload>, kotlin.x> {
    final /* synthetic */ RestoreWalletFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RestoreWalletFragment$getBackups$2(RestoreWalletFragment restoreWalletFragment) {
        super(1);
        this.this$0 = restoreWalletFragment;
    }

    @Override // kotlin.e0.c.l
    public /* bridge */ /* synthetic */ kotlin.x invoke(List<? extends BackupPayload> list) {
        invoke2((List<BackupPayload>) list);
        return kotlin.x.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(List<BackupPayload> it) {
        if (it.size() > 1) {
            Fragment_CommonKt.navigate$default(this.this$0, R.id.action_restoreWalletFragment_to_backupPickerFragment, BackupPickerFragment.Companion.createArguments(new ArrayList<>(it)), null, null, 12, null);
        } else if (it.size() != 1) {
            this.this$0.handleNoBackupsFound();
        } else {
            RestoreWalletFragment restoreWalletFragment = this.this$0;
            EnterPasswordFragment.Companion companion = EnterPasswordFragment.Companion;
            kotlin.jvm.internal.m.f(it, "it");
            Fragment_CommonKt.navigate$default(restoreWalletFragment, R.id.action_restoreWalletFragment_to_enterPasswordFragment, companion.createArguments((BackupPayload) kotlin.a0.p.Y(it)), null, null, 12, null);
        }
    }
}