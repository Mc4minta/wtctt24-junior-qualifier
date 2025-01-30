package com.coinbase.wallet.features.cloudbackup.viewModel;

import android.content.Intent;
import androidx.lifecycle.b0;
import com.coinbase.wallet.core.util.Optional;
import com.coinbase.wallet.features.cloudbackup.models.BackupStatus;
import com.coinbase.wallet.features.cloudbackup.models.OnboardingBackupRecoveryPhraseArgs;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.api.services.drive.Drive;
import e.j.f.u;
import h.a.a.a.a;
import h.c.a0;
import h.c.m0.n;
import h.c.m0.p;
import h.c.s;
import java.util.concurrent.Callable;
import kotlin.Metadata;
import kotlin.jvm.internal.m;
import kotlin.x;

/* compiled from: BackupRecoveryPhraseViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001'B\u0011\b\u0007\u0012\u0006\u0010#\u001a\u00020\"¢\u0006\u0004\b%\u0010&J\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u001b\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00040\t2\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u0015\u0010\f\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\f\u0010\rJ\u001d\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\t2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\u0011\u0010\u0012R\u001f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u00138\u0006@\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001a\u001a\u00020\u00198\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u001f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00040\u00138\u0006@\u0006¢\u0006\f\n\u0004\b\u001c\u0010\u0016\u001a\u0004\b\u001d\u0010\u0018R$\u0010 \u001a\u0010\u0012\f\u0012\n \u001f*\u0004\u0018\u00010\u00040\u00040\u001e8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b \u0010!R\u0016\u0010#\u001a\u00020\"8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b#\u0010$¨\u0006("}, d2 = {"Lcom/coinbase/wallet/features/cloudbackup/viewModel/BackupRecoveryPhraseViewModel;", "Landroidx/lifecycle/b0;", "Lcom/google/api/services/drive/Drive;", "driveClient", "Lkotlin/x;", "setupGoogleDriveClient", "(Lcom/google/api/services/drive/Drive;)V", "", OnboardingBackupRecoveryPhraseArgs.mnemonicKey, "Lh/c/b0;", "deleteBackup", "(Ljava/lang/String;)Lh/c/b0;", "setMnemonicHash", "(Ljava/lang/String;)V", "Landroid/content/Intent;", "intent", "Lcom/google/android/gms/auth/api/signin/GoogleSignInAccount;", "getGoogleSignedInAccount", "(Landroid/content/Intent;)Lh/c/b0;", "Lh/c/s;", "Lcom/coinbase/wallet/features/cloudbackup/models/BackupStatus;", "backupStatus", "Lh/c/s;", "getBackupStatus", "()Lh/c/s;", "Lh/c/a0;", "concurrentScheduler", "Lh/c/a0;", "navigateToCreatePasswordObservable", "getNavigateToCreatePasswordObservable", "Lh/c/v0/b;", "kotlin.jvm.PlatformType", "navigateToCreatePasswordSubject", "Lh/c/v0/b;", "Le/j/i/i2/d;", "mnemonicBackupRepository", "Le/j/i/i2/d;", "<init>", "(Le/j/i/i2/d;)V", "BackupMode", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class BackupRecoveryPhraseViewModel extends b0 {
    private final s<BackupStatus> backupStatus;
    private final a0 concurrentScheduler;
    private final e.j.i.i2.d mnemonicBackupRepository;
    private final s<x> navigateToCreatePasswordObservable;
    private final h.c.v0.b<x> navigateToCreatePasswordSubject;

    /* compiled from: BackupRecoveryPhraseViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/coinbase/wallet/features/cloudbackup/viewModel/BackupRecoveryPhraseViewModel$BackupMode;", "", "<init>", "(Ljava/lang/String;I)V", "BackupOne", "BackupAll", "Ofac", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public enum BackupMode {
        BackupOne,
        BackupAll,
        Ofac
    }

    public BackupRecoveryPhraseViewModel(e.j.i.i2.d mnemonicBackupRepository) {
        m.g(mnemonicBackupRepository, "mnemonicBackupRepository");
        this.mnemonicBackupRepository = mnemonicBackupRepository;
        a0 c2 = h.c.u0.a.c();
        m.f(c2, "io()");
        this.concurrentScheduler = c2;
        h.c.v0.b<x> d2 = h.c.v0.b.d();
        m.f(d2, "create<Unit>()");
        this.navigateToCreatePasswordSubject = d2;
        s map = mnemonicBackupRepository.f().filter(new p() { // from class: com.coinbase.wallet.features.cloudbackup.viewModel.BackupRecoveryPhraseViewModel$special$$inlined$unwrap$1
            public final boolean test(Optional<? extends T> it) {
                m.g(it, "it");
                return it.toNullable() != null;
            }

            @Override // h.c.m0.p
            public /* bridge */ /* synthetic */ boolean test(Object obj) {
                return test((Optional) ((Optional) obj));
            }
        }).map(new n() { // from class: com.coinbase.wallet.features.cloudbackup.viewModel.BackupRecoveryPhraseViewModel$special$$inlined$unwrap$2
            public final T apply(Optional<? extends T> it) {
                m.g(it, "it");
                return it.toNullable();
            }

            @Override // h.c.m0.n
            public /* bridge */ /* synthetic */ Object apply(Object obj) {
                return apply((Optional) ((Optional) obj));
            }
        });
        m.f(map, "this\n    .filter { it.toNullable() != null }\n    .map { it.toNullable() }");
        this.backupStatus = map;
        s<x> hide = d2.hide();
        m.f(hide, "navigateToCreatePasswordSubject.hide()");
        this.navigateToCreatePasswordObservable = hide;
    }

    public static /* synthetic */ h.c.f a(BackupRecoveryPhraseViewModel backupRecoveryPhraseViewModel, String str) {
        return m1252deleteBackup$lambda1(backupRecoveryPhraseViewModel, str);
    }

    public static /* synthetic */ String b(String str) {
        return m1251deleteBackup$lambda0(str);
    }

    /* renamed from: deleteBackup$lambda-0 */
    public static final String m1251deleteBackup$lambda0(String mnemonic) {
        m.g(mnemonic, "$mnemonic");
        return u.d(mnemonic, "CoinbaseWallet");
    }

    /* renamed from: deleteBackup$lambda-1 */
    public static final h.c.f m1252deleteBackup$lambda1(BackupRecoveryPhraseViewModel this$0, String it) {
        m.g(this$0, "this$0");
        m.g(it, "it");
        return this$0.mnemonicBackupRepository.c(it);
    }

    public final h.c.b0<x> deleteBackup(final String mnemonic) {
        m.g(mnemonic, "mnemonic");
        h.c.b0<x> x = h.c.b0.fromCallable(new Callable() { // from class: com.coinbase.wallet.features.cloudbackup.viewModel.b
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return BackupRecoveryPhraseViewModel.b(mnemonic);
            }
        }).flatMapCompletable(new n() { // from class: com.coinbase.wallet.features.cloudbackup.viewModel.a
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return BackupRecoveryPhraseViewModel.a(BackupRecoveryPhraseViewModel.this, (String) obj);
            }
        }).x(x.a);
        m.f(x, "fromCallable { mnemonic.sha256WithSalt(MnemonicBackupRepository.SALT) }\n        .flatMapCompletable { mnemonicBackupRepository.deleteBackup(it) }\n        .toSingleDefault(Unit)");
        return x;
    }

    public final s<BackupStatus> getBackupStatus() {
        return this.backupStatus;
    }

    public final h.c.b0<GoogleSignInAccount> getGoogleSignedInAccount(Intent intent) {
        com.google.android.gms.tasks.g<GoogleSignInAccount> getAccountTask = com.google.android.gms.auth.api.signin.a.d(intent);
        a.C0336a c0336a = h.a.a.a.a.a;
        m.f(getAccountTask, "getAccountTask");
        h.c.b0<GoogleSignInAccount> subscribeOn = c0336a.a(getAccountTask).subscribeOn(this.concurrentScheduler);
        m.f(subscribeOn, "RxTasks.single(getAccountTask).subscribeOn(concurrentScheduler)");
        return subscribeOn;
    }

    public final s<x> getNavigateToCreatePasswordObservable() {
        return this.navigateToCreatePasswordObservable;
    }

    public final void setMnemonicHash(String mnemonic) {
        m.g(mnemonic, "mnemonic");
        this.mnemonicBackupRepository.i(u.d(mnemonic, "CoinbaseWallet"));
    }

    public final void setupGoogleDriveClient(Drive driveClient) {
        m.g(driveClient, "driveClient");
        this.mnemonicBackupRepository.e(driveClient);
    }
}