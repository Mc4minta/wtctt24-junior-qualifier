package com.coinbase.wallet.features.cloudbackup.viewModel;

import android.content.Intent;
import androidx.lifecycle.b0;
import com.coinbase.wallet.core.util.Optional;
import com.coinbase.wallet.core.util.OptionalKt;
import com.coinbase.wallet.features.cloudbackup.models.BackupPayload;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.api.ApiException;
import com.google.api.services.drive.Drive;
import h.a.a.a.a;
import h.c.a0;
import h.c.m0.n;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.m;

/* compiled from: RestoreWalletViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\u0018\u0010\u0019J\u0019\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0015\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\n\u0010\u000bJ#\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000e0\u00022\b\u0010\r\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0013\u001a\u00020\u00128\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0016\u001a\u00020\u00158\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017¨\u0006\u001a"}, d2 = {"Lcom/coinbase/wallet/features/cloudbackup/viewModel/RestoreWalletViewModel;", "Landroidx/lifecycle/b0;", "Lh/c/b0;", "", "Lcom/coinbase/wallet/features/cloudbackup/models/BackupPayload;", "getBackups", "()Lh/c/b0;", "Lcom/google/api/services/drive/Drive;", "drive", "Lkotlin/x;", "initDriveClient", "(Lcom/google/api/services/drive/Drive;)V", "Landroid/content/Intent;", "intent", "Lcom/coinbase/wallet/core/util/Optional;", "Lcom/google/android/gms/auth/api/signin/GoogleSignInAccount;", "getGoogleSignedInAccount", "(Landroid/content/Intent;)Lh/c/b0;", "Le/j/i/i2/d;", "mnemonicBackupRepository", "Le/j/i/i2/d;", "Lh/c/a0;", "concurrentScheduler", "Lh/c/a0;", "<init>", "(Le/j/i/i2/d;)V", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class RestoreWalletViewModel extends b0 {
    private final a0 concurrentScheduler;
    private final e.j.i.i2.d mnemonicBackupRepository;

    public RestoreWalletViewModel(e.j.i.i2.d mnemonicBackupRepository) {
        m.g(mnemonicBackupRepository, "mnemonicBackupRepository");
        this.mnemonicBackupRepository = mnemonicBackupRepository;
        a0 c2 = h.c.u0.a.c();
        m.f(c2, "io()");
        this.concurrentScheduler = c2;
    }

    public static /* synthetic */ Optional a(Throwable th) {
        return m1258getGoogleSignedInAccount$lambda1(th);
    }

    public static /* synthetic */ Optional b(GoogleSignInAccount googleSignInAccount) {
        return m1257getGoogleSignedInAccount$lambda0(googleSignInAccount);
    }

    /* renamed from: getGoogleSignedInAccount$lambda-0 */
    public static final Optional m1257getGoogleSignedInAccount$lambda0(GoogleSignInAccount it) {
        m.g(it, "it");
        return OptionalKt.toOptional(it);
    }

    /* renamed from: getGoogleSignedInAccount$lambda-1 */
    public static final Optional m1258getGoogleSignedInAccount$lambda1(Throwable error) {
        m.g(error, "error");
        ApiException apiException = error instanceof ApiException ? (ApiException) error : null;
        if (apiException != null) {
            if (apiException.a() == 12501) {
                return new Optional(null);
            }
            throw error;
        }
        throw error;
    }

    public final h.c.b0<List<BackupPayload>> getBackups() {
        return this.mnemonicBackupRepository.a();
    }

    public final h.c.b0<Optional<GoogleSignInAccount>> getGoogleSignedInAccount(Intent intent) {
        com.google.android.gms.tasks.g<GoogleSignInAccount> getAccountTask = com.google.android.gms.auth.api.signin.a.d(intent);
        a.C0336a c0336a = h.a.a.a.a.a;
        m.f(getAccountTask, "getAccountTask");
        h.c.b0<Optional<GoogleSignInAccount>> onErrorReturn = c0336a.a(getAccountTask).subscribeOn(this.concurrentScheduler).map(new n() { // from class: com.coinbase.wallet.features.cloudbackup.viewModel.h
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return RestoreWalletViewModel.b((GoogleSignInAccount) obj);
            }
        }).onErrorReturn(new n() { // from class: com.coinbase.wallet.features.cloudbackup.viewModel.g
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return RestoreWalletViewModel.a((Throwable) obj);
            }
        });
        m.f(onErrorReturn, "RxTasks.single(getAccountTask).subscribeOn(concurrentScheduler)\n            .map { it.toOptional() }\n            .onErrorReturn { error ->\n                val apiException = error as? ApiException ?: throw error\n                if (apiException.statusCode != UserCancelledStatusCode) throw error\n\n                Optional(null)\n            }");
        return onErrorReturn;
    }

    public final void initDriveClient(Drive drive) {
        m.g(drive, "drive");
        this.mnemonicBackupRepository.e(drive);
    }
}