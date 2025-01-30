package com.coinbase.wallet.features.cloudbackup.view;

import android.content.DialogInterface;
import androidx.appcompat.app.c;
import com.coinbase.wallet.commonui.extensions.Fragment_CommonKt;
import kotlin.Metadata;
import org.toshi.R;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: BackupRecoveryPhraseFragment.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u0002*\u00060\u0000j\u0002`\u0001H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroidx/appcompat/app/c$a;", "Lcom/toshi/extensions/DialogBuilder;", "Lkotlin/x;", "<anonymous>", "(Landroidx/appcompat/app/c$a;)V"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class BackupRecoveryPhraseFragment$showRecoveryPhraseErrorDialog$1 extends kotlin.jvm.internal.o implements kotlin.e0.c.l<c.a, kotlin.x> {
    final /* synthetic */ BackupRecoveryPhraseFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BackupRecoveryPhraseFragment$showRecoveryPhraseErrorDialog$1(BackupRecoveryPhraseFragment backupRecoveryPhraseFragment) {
        super(1);
        this.this$0 = backupRecoveryPhraseFragment;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: invoke$lambda-0  reason: not valid java name */
    public static final void m1226invoke$lambda0(BackupRecoveryPhraseFragment this$0, DialogInterface dialogInterface) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        Fragment_CommonKt.navigateUp(this$0);
    }

    @Override // kotlin.e0.c.l
    public /* bridge */ /* synthetic */ kotlin.x invoke(c.a aVar) {
        invoke2(aVar);
        return kotlin.x.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(c.a showDialog) {
        kotlin.jvm.internal.m.g(showDialog, "$this$showDialog");
        showDialog.n(R.string.recovery_phrase_error_dialog_title);
        showDialog.f(R.string.recovery_phrase_error_dialog_message);
        e.j.f.k.b(showDialog, R.string.ok);
        final BackupRecoveryPhraseFragment backupRecoveryPhraseFragment = this.this$0;
        showDialog.j(new DialogInterface.OnDismissListener() { // from class: com.coinbase.wallet.features.cloudbackup.view.f
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                BackupRecoveryPhraseFragment$showRecoveryPhraseErrorDialog$1.m1226invoke$lambda0(BackupRecoveryPhraseFragment.this, dialogInterface);
            }
        });
    }
}