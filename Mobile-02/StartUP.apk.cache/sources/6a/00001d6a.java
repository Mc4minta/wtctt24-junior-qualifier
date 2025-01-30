package com.coinbase.wallet.features.cloudbackup.view;

import android.os.Bundle;
import com.coinbase.wallet.features.cloudbackup.models.BackupPayload;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

/* compiled from: BackupPickerFragment.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u0010\u0012\f\u0012\n \u0002*\u0004\u0018\u00010\u00010\u00010\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "Lcom/coinbase/wallet/features/cloudbackup/models/BackupPayload;", "kotlin.jvm.PlatformType", "<anonymous>", "()Ljava/util/List;"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes.dex */
final class BackupPickerFragment$backups$2 extends kotlin.jvm.internal.o implements kotlin.e0.c.a<List<? extends BackupPayload>> {
    final /* synthetic */ BackupPickerFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BackupPickerFragment$backups$2(BackupPickerFragment backupPickerFragment) {
        super(0);
        this.this$0 = backupPickerFragment;
    }

    @Override // kotlin.e0.c.a
    public final List<? extends BackupPayload> invoke() {
        ArrayList parcelableArrayList;
        Bundle arguments = this.this$0.getArguments();
        List<? extends BackupPayload> list = null;
        if (arguments != null && (parcelableArrayList = arguments.getParcelableArrayList("backups")) != null) {
            list = kotlin.a0.z.I0(parcelableArrayList);
        }
        if (list != null) {
            return list;
        }
        throw new RuntimeException("Bundle does not have extra: backups");
    }
}