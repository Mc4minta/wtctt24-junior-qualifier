package com.coinbase.wallet.features.cloudbackup.viewModel;

import androidx.lifecycle.b0;
import com.coinbase.wallet.application.repository.interfaces.MnemonicRepositoryInterface;
import com.coinbase.wallet.features.cloudbackup.models.BackupPayload;
import com.coinbase.wallet.features.cloudbackup.models.PasswordState;
import com.coinbase.wallet.user.models.User;
import com.coinbase.wallet.user.repositories.UserRepository;
import h.c.h0;
import h.c.m0.n;
import h.c.s;
import kotlin.Metadata;
import kotlin.jvm.internal.m;
import kotlin.l0.k;
import kotlin.o;

/* compiled from: EnterPasswordViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B!\b\u0007\u0012\u0006\u0010\u0015\u001a\u00020\u0014\u0012\u0006\u0010\u0018\u001a\u00020\u0017\u0012\u0006\u0010\u001e\u001a\u00020\u001d¢\u0006\u0004\b&\u0010'J\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J/\u0010\r\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\f0\u000b0\n2\u0006\u0010\u0003\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\r\u0010\u000eR\u0019\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f8F@\u0006¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0015\u001a\u00020\u00148\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u0018\u001a\u00020\u00178\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001b\u001a\u00020\u001a8\u0002@\u0002X\u0082D¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010\u001e\u001a\u00020\u001d8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010!\u001a\u00020 8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b!\u0010\"R\u001c\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00100#8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b$\u0010%¨\u0006("}, d2 = {"Lcom/coinbase/wallet/features/cloudbackup/viewModel/EnterPasswordViewModel;", "Landroidx/lifecycle/b0;", "", "password", "Lkotlin/x;", "validatePassword", "(Ljava/lang/CharSequence;)V", "", "Lcom/coinbase/wallet/features/cloudbackup/models/BackupPayload;", "backup", "Lh/c/b0;", "Lkotlin/o;", "Lcom/coinbase/wallet/user/models/User;", "recoverMnemonic", "(Ljava/lang/String;Lcom/coinbase/wallet/features/cloudbackup/models/BackupPayload;)Lh/c/b0;", "Lh/c/s;", "Lcom/coinbase/wallet/features/cloudbackup/models/PasswordState;", "getValidPasswordObservable", "()Lh/c/s;", "validPasswordObservable", "Le/j/i/i2/d;", "mnemonicBackupRepository", "Le/j/i/i2/d;", "Lcom/coinbase/wallet/application/repository/interfaces/MnemonicRepositoryInterface;", "mnemonicRepository", "Lcom/coinbase/wallet/application/repository/interfaces/MnemonicRepositoryInterface;", "", "minPasswordLength", "I", "Lcom/coinbase/wallet/user/repositories/UserRepository;", "userRepository", "Lcom/coinbase/wallet/user/repositories/UserRepository;", "Lkotlin/l0/k;", "passwordRegex", "Lkotlin/l0/k;", "Lh/c/v0/a;", "validPasswordSubject", "Lh/c/v0/a;", "<init>", "(Le/j/i/i2/d;Lcom/coinbase/wallet/application/repository/interfaces/MnemonicRepositoryInterface;Lcom/coinbase/wallet/user/repositories/UserRepository;)V", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class EnterPasswordViewModel extends b0 {
    private final int minPasswordLength;
    private final e.j.i.i2.d mnemonicBackupRepository;
    private final MnemonicRepositoryInterface mnemonicRepository;
    private final k passwordRegex;
    private final UserRepository userRepository;
    private final h.c.v0.a<PasswordState> validPasswordSubject;

    public EnterPasswordViewModel(e.j.i.i2.d mnemonicBackupRepository, MnemonicRepositoryInterface mnemonicRepository, UserRepository userRepository) {
        m.g(mnemonicBackupRepository, "mnemonicBackupRepository");
        m.g(mnemonicRepository, "mnemonicRepository");
        m.g(userRepository, "userRepository");
        this.mnemonicBackupRepository = mnemonicBackupRepository;
        this.mnemonicRepository = mnemonicRepository;
        this.userRepository = userRepository;
        this.passwordRegex = new k("^(?=.*[\\D+])(?=.*\\d)[\\D+\\d]{8,}$");
        this.minPasswordLength = 8;
        h.c.v0.a<PasswordState> d2 = h.c.v0.a.d();
        m.f(d2, "create()");
        this.validPasswordSubject = d2;
    }

    public static /* synthetic */ h0 a(EnterPasswordViewModel enterPasswordViewModel, String str) {
        return m1256recoverMnemonic$lambda1(enterPasswordViewModel, str);
    }

    public static /* synthetic */ h0 b(EnterPasswordViewModel enterPasswordViewModel, String str) {
        return m1255recoverMnemonic$lambda0(enterPasswordViewModel, str);
    }

    /* renamed from: recoverMnemonic$lambda-0 */
    public static final h0 m1255recoverMnemonic$lambda0(EnterPasswordViewModel this$0, String it) {
        m.g(this$0, "this$0");
        m.g(it, "it");
        return this$0.mnemonicRepository.validateMnemonic(it);
    }

    /* renamed from: recoverMnemonic$lambda-1 */
    public static final h0 m1256recoverMnemonic$lambda1(EnterPasswordViewModel this$0, String mnemonic) {
        m.g(this$0, "this$0");
        m.g(mnemonic, "mnemonic");
        h.c.b0 just = h.c.b0.just(mnemonic);
        m.f(just, "just(mnemonic)");
        return h.c.t0.f.a(just, this$0.userRepository.signIn(mnemonic));
    }

    public final s<PasswordState> getValidPasswordObservable() {
        s<PasswordState> hide = this.validPasswordSubject.hide();
        m.f(hide, "validPasswordSubject.hide()");
        return hide;
    }

    public final h.c.b0<o<String, User>> recoverMnemonic(String password, BackupPayload backup) {
        m.g(password, "password");
        m.g(backup, "backup");
        h.c.b0<o<String, User>> flatMap = this.mnemonicBackupRepository.h(password, backup).flatMap(new n() { // from class: com.coinbase.wallet.features.cloudbackup.viewModel.f
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return EnterPasswordViewModel.b(EnterPasswordViewModel.this, (String) obj);
            }
        }).flatMap(new n() { // from class: com.coinbase.wallet.features.cloudbackup.viewModel.e
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return EnterPasswordViewModel.a(EnterPasswordViewModel.this, (String) obj);
            }
        });
        m.f(flatMap, "mnemonicBackupRepository.recoverMnemonic(password, backup)\n            .flatMap { mnemonicRepository.validateMnemonic(it) }\n            .flatMap { mnemonic -> Single.just(mnemonic).zipWith(userRepository.signIn(mnemonic)) }");
        return flatMap;
    }

    public final void validatePassword(CharSequence password) {
        PasswordState passwordState;
        m.g(password, "password");
        if (password.length() < this.minPasswordLength) {
            passwordState = PasswordState.INVALID_LENGTH;
        } else {
            passwordState = this.passwordRegex.d(password) ? PasswordState.VALID : PasswordState.REQUIREMENTS_NOT_MET;
        }
        this.validPasswordSubject.onNext(passwordState);
    }
}