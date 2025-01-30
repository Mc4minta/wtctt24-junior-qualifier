package com.coinbase.wallet.features.cloudbackup.view;

import com.coinbase.wallet.commonui.utilities.FragmentLifecycleScopeProvider;
import com.coinbase.wallet.features.cloudbackup.models.BackupStatus;
import com.coinbase.wallet.features.cloudbackup.viewModel.BackupRecoveryPhraseViewModel;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import kotlin.Metadata;

/* compiled from: BackupRecoveryPhraseFragment.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/google/android/gms/auth/api/signin/GoogleSignInAccount;", "kotlin.jvm.PlatformType", "it", "Lkotlin/x;", "<anonymous>", "(Lcom/google/android/gms/auth/api/signin/GoogleSignInAccount;)V"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class BackupRecoveryPhraseFragment$handleSignIn$2 extends kotlin.jvm.internal.o implements kotlin.e0.c.l<GoogleSignInAccount, kotlin.x> {
    final /* synthetic */ BackupRecoveryPhraseFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BackupRecoveryPhraseFragment$handleSignIn$2(BackupRecoveryPhraseFragment backupRecoveryPhraseFragment) {
        super(1);
        this.this$0 = backupRecoveryPhraseFragment;
    }

    public static /* synthetic */ kotlin.x a(BackupRecoveryPhraseFragment backupRecoveryPhraseFragment, BackupStatus backupStatus) {
        return m1224invoke$lambda0(backupRecoveryPhraseFragment, backupStatus);
    }

    /* renamed from: invoke$lambda-0 */
    public static final kotlin.x m1224invoke$lambda0(BackupRecoveryPhraseFragment this$0, BackupStatus status) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(status, "status");
        if (!kotlin.jvm.internal.m.c(status, BackupStatus.BackedUpAll.INSTANCE) && !kotlin.jvm.internal.m.c(status, BackupStatus.BackedUpToCloud.INSTANCE)) {
            this$0.navigateToCreatePasswordScreen();
        }
        return kotlin.x.a;
    }

    @Override // kotlin.e0.c.l
    public /* bridge */ /* synthetic */ kotlin.x invoke(GoogleSignInAccount googleSignInAccount) {
        invoke2(googleSignInAccount);
        return kotlin.x.a;
    }

    /* renamed from: invoke */
    public final void invoke2(GoogleSignInAccount it) {
        BackupRecoveryPhraseViewModel backupRecoveryPhraseViewModel;
        h.c.a0 a0Var;
        FragmentLifecycleScopeProvider scopeProvider;
        this.this$0.lastSignedInAccount = it;
        backupRecoveryPhraseViewModel = this.this$0.viewModel;
        if (backupRecoveryPhraseViewModel != null) {
            h.c.s<BackupStatus> skip = backupRecoveryPhraseViewModel.getBackupStatus().skip(1L);
            a0Var = this.this$0.mainScheduler;
            h.c.s<BackupStatus> observeOn = skip.observeOn(a0Var);
            final BackupRecoveryPhraseFragment backupRecoveryPhraseFragment = this.this$0;
            h.c.s<R> map = observeOn.map(new h.c.m0.n() { // from class: com.coinbase.wallet.features.cloudbackup.view.d
                @Override // h.c.m0.n
                public final Object apply(Object obj) {
                    return BackupRecoveryPhraseFragment$handleSignIn$2.a(BackupRecoveryPhraseFragment.this, (BackupStatus) obj);
                }
            });
            scopeProvider = this.this$0.getScopeProvider();
            ((com.uber.autodispose.x) map.as(com.uber.autodispose.d.a(scopeProvider))).subscribe();
            BackupRecoveryPhraseFragment backupRecoveryPhraseFragment2 = this.this$0;
            kotlin.jvm.internal.m.f(it, "it");
            backupRecoveryPhraseFragment2.setupGoogleDriveClient(it);
            return;
        }
        kotlin.jvm.internal.m.w("viewModel");
        throw null;
    }
}