package com.coinbase.wallet.features.cloudbackup.view;

import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.Scope;
import kotlin.Metadata;

/* compiled from: BackupRecoveryPhraseFragment.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/google/android/gms/auth/api/signin/c;", "kotlin.jvm.PlatformType", "<anonymous>", "()Lcom/google/android/gms/auth/api/signin/c;"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes.dex */
final class BackupRecoveryPhraseFragment$googleSignInClient$2 extends kotlin.jvm.internal.o implements kotlin.e0.c.a<com.google.android.gms.auth.api.signin.c> {
    final /* synthetic */ BackupRecoveryPhraseFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BackupRecoveryPhraseFragment$googleSignInClient$2(BackupRecoveryPhraseFragment backupRecoveryPhraseFragment) {
        super(0);
        this.this$0 = backupRecoveryPhraseFragment;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.e0.c.a
    public final com.google.android.gms.auth.api.signin.c invoke() {
        Scope scope;
        GoogleSignInOptions.a b2 = new GoogleSignInOptions.a().b();
        scope = this.this$0.fileScope;
        return com.google.android.gms.auth.api.signin.a.a(this.this$0.requireActivity(), b2.e(scope, new Scope[0]).a());
    }
}