package com.coinbase.wallet.features.cloudbackup.viewModel;

import androidx.lifecycle.b0;
import com.coinbase.wallet.core.extensions.Observable_CoreKt;
import com.coinbase.wallet.core.util.Optional;
import com.coinbase.wallet.features.cloudbackup.models.BackupStatus;
import com.coinbase.wallet.features.cloudbackup.models.OnboardingBackupRecoveryPhraseArgs;
import com.coinbase.wallet.features.cloudbackup.models.PasswordMatchState;
import com.coinbase.wallet.features.cloudbackup.models.PasswordState;
import com.coinbase.wallet.user.models.User;
import com.coinbase.wallet.user.repositories.UserRepository;
import h.c.h0;
import h.c.m0.n;
import h.c.m0.p;
import h.c.s;
import kotlin.Metadata;
import kotlin.jvm.internal.m;
import kotlin.l0.k;
import kotlin.l0.x;
import kotlin.t;

/* compiled from: CreatePasswordViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u00100\u001a\u00020/\u0012\u0006\u0010*\u001a\u00020)¢\u0006\u0004\b2\u00103J!\u0010\u0006\u001a\u00020\u00052\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0015\u0010\n\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bJ#\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\b0\u000f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\f¢\u0006\u0004\b\u0010\u0010\u0011R\u001f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\b0\u00128\u0006@\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R%\u0010\u0019\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00180\u00170\u00128\u0006@\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u0014\u001a\u0004\b\u001a\u0010\u0016R\u0019\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001b0\u00128F@\u0006¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u0016R\u001c\u0010 \u001a\b\u0012\u0004\u0012\u00020\u001f0\u001e8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b \u0010!R\u0016\u0010#\u001a\u00020\"8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b#\u0010$R\u001c\u0010%\u001a\b\u0012\u0004\u0012\u00020\b0\u001e8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b%\u0010!R\u0016\u0010'\u001a\u00020&8\u0002@\u0002X\u0082D¢\u0006\u0006\n\u0004\b'\u0010(R\u0016\u0010*\u001a\u00020)8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b*\u0010+R\u0019\u0010-\u001a\b\u0012\u0004\u0012\u00020\u001f0\u00128F@\u0006¢\u0006\u0006\u001a\u0004\b,\u0010\u0016R\u001c\u0010.\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001e8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b.\u0010!R\u0016\u00100\u001a\u00020/8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b0\u00101¨\u00064"}, d2 = {"Lcom/coinbase/wallet/features/cloudbackup/viewModel/CreatePasswordViewModel;", "Landroidx/lifecycle/b0;", "", "firstPassword", "confirmedPassword", "Lkotlin/x;", "verifyPasswords", "(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)V", "", "isChecked", "setIsAgreementChecked", "(Z)V", "", "password", OnboardingBackupRecoveryPhraseArgs.mnemonicKey, "Lh/c/b0;", "backupMnemonic", "(Ljava/lang/String;Ljava/lang/String;)Lh/c/b0;", "Lh/c/s;", "createPasswordButtonState", "Lh/c/s;", "getCreatePasswordButtonState", "()Lh/c/s;", "Lcom/coinbase/wallet/core/util/Optional;", "Lcom/coinbase/wallet/features/cloudbackup/models/BackupStatus;", "backupStatusObservable", "getBackupStatusObservable", "Lcom/coinbase/wallet/features/cloudbackup/models/PasswordMatchState;", "getPasswordsMatchObservable", "passwordsMatchObservable", "Lh/c/v0/a;", "Lcom/coinbase/wallet/features/cloudbackup/models/PasswordState;", "validPasswordSubject", "Lh/c/v0/a;", "Lkotlin/l0/k;", "passwordRegex", "Lkotlin/l0/k;", "isAgreementCheckedSubject", "", "minPasswordLength", "I", "Lcom/coinbase/wallet/user/repositories/UserRepository;", "userRepository", "Lcom/coinbase/wallet/user/repositories/UserRepository;", "getValidPasswordObservable", "validPasswordObservable", "passwordsMatchSubject", "Le/j/i/i2/d;", "mnemonicBackupRepository", "Le/j/i/i2/d;", "<init>", "(Le/j/i/i2/d;Lcom/coinbase/wallet/user/repositories/UserRepository;)V", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class CreatePasswordViewModel extends b0 {
    private final s<Optional<BackupStatus>> backupStatusObservable;
    private final s<Boolean> createPasswordButtonState;
    private final h.c.v0.a<Boolean> isAgreementCheckedSubject;
    private final int minPasswordLength;
    private final e.j.i.i2.d mnemonicBackupRepository;
    private final k passwordRegex;
    private final h.c.v0.a<PasswordMatchState> passwordsMatchSubject;
    private final UserRepository userRepository;
    private final h.c.v0.a<PasswordState> validPasswordSubject;

    public CreatePasswordViewModel(e.j.i.i2.d mnemonicBackupRepository, UserRepository userRepository) {
        m.g(mnemonicBackupRepository, "mnemonicBackupRepository");
        m.g(userRepository, "userRepository");
        this.mnemonicBackupRepository = mnemonicBackupRepository;
        this.userRepository = userRepository;
        this.passwordRegex = new k("^(?=.*([A-Z]|[a-z]))(?=.*\\d)[\\D+\\d]{8,}$");
        this.minPasswordLength = 8;
        Boolean bool = Boolean.FALSE;
        h.c.v0.a<Boolean> e2 = h.c.v0.a.e(bool);
        m.f(e2, "createDefault(false)");
        this.isAgreementCheckedSubject = e2;
        h.c.v0.a<PasswordState> d2 = h.c.v0.a.d();
        m.f(d2, "create()");
        this.validPasswordSubject = d2;
        h.c.v0.a<PasswordMatchState> d3 = h.c.v0.a.d();
        m.f(d3, "create()");
        this.passwordsMatchSubject = d3;
        s<Boolean> startWith = h.c.t0.c.a.b(getValidPasswordObservable(), getPasswordsMatchObservable(), e2).map(new n() { // from class: com.coinbase.wallet.features.cloudbackup.viewModel.c
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return CreatePasswordViewModel.a((t) obj);
            }
        }).startWith((s) bool);
        m.f(startWith, "Observables\n        .combineLatest(validPasswordObservable, passwordsMatchObservable, isAgreementCheckedSubject)\n        .map { (passwordState, matchingState, isAgreementChecked) ->\n            return@map passwordState == PasswordState.VALID && matchingState == PasswordMatchState.MATCH &&\n                isAgreementChecked\n        }\n        .startWith(false)");
        this.createPasswordButtonState = startWith;
        this.backupStatusObservable = mnemonicBackupRepository.f();
    }

    public static /* synthetic */ Boolean a(t tVar) {
        return m1254createPasswordButtonState$lambda0(tVar);
    }

    public static /* synthetic */ h0 b(CreatePasswordViewModel createPasswordViewModel, String str, String str2, User user) {
        return m1253backupMnemonic$lambda1(createPasswordViewModel, str, str2, user);
    }

    /* renamed from: backupMnemonic$lambda-1 */
    public static final h0 m1253backupMnemonic$lambda1(CreatePasswordViewModel this$0, String password, String mnemonic, User it) {
        m.g(this$0, "this$0");
        m.g(password, "$password");
        m.g(mnemonic, "$mnemonic");
        m.g(it, "it");
        return this$0.mnemonicBackupRepository.g(password, mnemonic, it.getUsername());
    }

    /* renamed from: createPasswordButtonState$lambda-0 */
    public static final Boolean m1254createPasswordButtonState$lambda0(t dstr$passwordState$matchingState$isAgreementChecked) {
        boolean z;
        m.g(dstr$passwordState$matchingState$isAgreementChecked, "$dstr$passwordState$matchingState$isAgreementChecked");
        PasswordState passwordState = (PasswordState) dstr$passwordState$matchingState$isAgreementChecked.a();
        PasswordMatchState passwordMatchState = (PasswordMatchState) dstr$passwordState$matchingState$isAgreementChecked.b();
        Boolean isAgreementChecked = (Boolean) dstr$passwordState$matchingState$isAgreementChecked.c();
        if (passwordState == PasswordState.VALID && passwordMatchState == PasswordMatchState.MATCH) {
            m.f(isAgreementChecked, "isAgreementChecked");
            if (isAgreementChecked.booleanValue()) {
                z = true;
                return Boolean.valueOf(z);
            }
        }
        z = false;
        return Boolean.valueOf(z);
    }

    public final h.c.b0<Boolean> backupMnemonic(final String password, final String mnemonic) {
        m.g(password, "password");
        m.g(mnemonic, "mnemonic");
        s<R> map = this.userRepository.getActiveUserObservable().filter(new p() { // from class: com.coinbase.wallet.features.cloudbackup.viewModel.CreatePasswordViewModel$backupMnemonic$$inlined$unwrap$1
            public final boolean test(Optional<? extends T> it) {
                m.g(it, "it");
                return it.toNullable() != null;
            }

            @Override // h.c.m0.p
            public /* bridge */ /* synthetic */ boolean test(Object obj) {
                return test((Optional) ((Optional) obj));
            }
        }).map(new n() { // from class: com.coinbase.wallet.features.cloudbackup.viewModel.CreatePasswordViewModel$backupMnemonic$$inlined$unwrap$2
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
        h.c.b0<Boolean> flatMap = Observable_CoreKt.takeSingle(map).flatMap(new n() { // from class: com.coinbase.wallet.features.cloudbackup.viewModel.d
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return CreatePasswordViewModel.b(CreatePasswordViewModel.this, password, mnemonic, (User) obj);
            }
        });
        m.f(flatMap, "userRepository.activeUserObservable\n                    .unwrap()\n                    .takeSingle()\n                    .flatMap { mnemonicBackupRepository.backupMnemonic(password, mnemonic, it.username) }");
        return flatMap;
    }

    public final s<Optional<BackupStatus>> getBackupStatusObservable() {
        return this.backupStatusObservable;
    }

    public final s<Boolean> getCreatePasswordButtonState() {
        return this.createPasswordButtonState;
    }

    public final s<PasswordMatchState> getPasswordsMatchObservable() {
        s<PasswordMatchState> hide = this.passwordsMatchSubject.hide();
        m.f(hide, "passwordsMatchSubject.hide()");
        return hide;
    }

    public final s<PasswordState> getValidPasswordObservable() {
        s<PasswordState> hide = this.validPasswordSubject.hide();
        m.f(hide, "validPasswordSubject.hide()");
        return hide;
    }

    public final void setIsAgreementChecked(boolean z) {
        this.isAgreementCheckedSubject.onNext(Boolean.valueOf(z));
    }

    public final void verifyPasswords(CharSequence charSequence, CharSequence charSequence2) {
        PasswordState passwordState;
        PasswordMatchState passwordMatchState;
        boolean Q;
        String obj = charSequence == null ? null : charSequence.toString();
        h.c.v0.a<PasswordState> aVar = this.validPasswordSubject;
        if (obj != null && obj.length() >= this.minPasswordLength) {
            passwordState = this.passwordRegex.d(obj) ? PasswordState.VALID : PasswordState.REQUIREMENTS_NOT_MET;
        } else {
            passwordState = PasswordState.INVALID_LENGTH;
        }
        aVar.onNext(passwordState);
        String obj2 = charSequence2 == null ? null : charSequence2.toString();
        h.c.v0.a<PasswordMatchState> aVar2 = this.passwordsMatchSubject;
        boolean z = true;
        if (!(obj == null || obj.length() == 0)) {
            if (!(obj2 == null || obj2.length() == 0) && m.c(obj, obj2)) {
                passwordMatchState = PasswordMatchState.MATCH;
                aVar2.onNext(passwordMatchState);
            }
        }
        if (!(obj == null || obj.length() == 0)) {
            if (obj2 != null && obj2.length() != 0) {
                z = false;
            }
            if (!z) {
                Q = x.Q(obj, obj2, false, 2, null);
                if (!Q) {
                    passwordMatchState = PasswordMatchState.DONT_MATCH;
                    aVar2.onNext(passwordMatchState);
                }
            }
        }
        passwordMatchState = PasswordMatchState.NO_MESSAGE;
        aVar2.onNext(passwordMatchState);
    }
}