package com.coinbase.wallet.features.cloudbackup.view;

import com.coinbase.wallet.authentication.AuthenticationResult;
import com.coinbase.wallet.commonui.extensions.Fragment_CommonKt;
import com.coinbase.wallet.features.cloudbackup.viewModel.BackupRecoveryPhraseViewModel;
import kotlin.Metadata;

/* compiled from: BackupRecoveryPhraseFragment.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/coinbase/wallet/authentication/AuthenticationResult;", "kotlin.jvm.PlatformType", "result", "Lkotlin/x;", "<anonymous>", "(Lcom/coinbase/wallet/authentication/AuthenticationResult;)V"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes.dex */
final class BackupRecoveryPhraseFragment$onResume$2 extends kotlin.jvm.internal.o implements kotlin.e0.c.l<AuthenticationResult, kotlin.x> {
    final /* synthetic */ BackupRecoveryPhraseFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BackupRecoveryPhraseFragment$onResume$2(BackupRecoveryPhraseFragment backupRecoveryPhraseFragment) {
        super(1);
        this.this$0 = backupRecoveryPhraseFragment;
    }

    @Override // kotlin.e0.c.l
    public /* bridge */ /* synthetic */ kotlin.x invoke(AuthenticationResult authenticationResult) {
        invoke2(authenticationResult);
        return kotlin.x.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(AuthenticationResult authenticationResult) {
        BackupRecoveryPhraseViewModel backupRecoveryPhraseViewModel;
        if (authenticationResult instanceof AuthenticationResult.RecoveryPhrase) {
            AuthenticationResult.RecoveryPhrase recoveryPhrase = (AuthenticationResult.RecoveryPhrase) authenticationResult;
            this.this$0.setMnemonic(recoveryPhrase.getRecoveryPhrase());
            backupRecoveryPhraseViewModel = this.this$0.viewModel;
            if (backupRecoveryPhraseViewModel != null) {
                backupRecoveryPhraseViewModel.setMnemonicHash(recoveryPhrase.getRecoveryPhrase());
            } else {
                kotlin.jvm.internal.m.w("viewModel");
                throw null;
            }
        } else if (authenticationResult instanceof AuthenticationResult.Error) {
            this.this$0.handleRecoveryPhraseError(((AuthenticationResult.Error) authenticationResult).getThrowable());
        } else if (!(authenticationResult instanceof AuthenticationResult.LockedOut) && (authenticationResult instanceof AuthenticationResult.Cancelled)) {
            Fragment_CommonKt.navigateUp(this.this$0);
        }
    }
}