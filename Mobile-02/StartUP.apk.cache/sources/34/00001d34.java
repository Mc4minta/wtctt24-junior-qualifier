package com.coinbase.wallet.features.applock.legacy;

import android.os.Bundle;
import android.security.keystore.KeyPermanentlyInvalidatedException;
import androidx.biometric.BiometricPrompt;
import androidx.fragment.app.Fragment;
import com.coinbase.wallet.analytics.extensions.Single_AnalyticsKt;
import com.coinbase.wallet.application.model.CallToAction;
import com.coinbase.wallet.application.model.NavDestination;
import com.coinbase.wallet.application.model.Notification;
import com.coinbase.wallet.application.repository.interfaces.AppLockRepositoryInterface;
import com.coinbase.wallet.application.repository.interfaces.MnemonicRepositoryInterface;
import com.coinbase.wallet.authentication.AppLockType;
import com.coinbase.wallet.authentication.AuthenticationHelperInterface;
import com.coinbase.wallet.authentication.AuthenticationResult;
import com.coinbase.wallet.common.annotations.AppCoreScoped;
import com.coinbase.wallet.common.utilities.LocalizedStrings;
import com.coinbase.wallet.commonui.models.ActionStyle;
import com.coinbase.wallet.core.extensions.Observable_CoreKt;
import com.coinbase.wallet.features.applock.exceptions.AppLockException;
import com.coinbase.wallet.features.cloudbackup.view.BackupRecoveryPhraseFragment;
import com.toshi.exception.KeyStoreException;
import com.toshi.model.local.authentication.AuthenticationMethod;
import com.toshi.model.local.authentication.EncryptionMethod;
import e.j.d.g.w;
import e.j.l.o.a;
import h.c.a0;
import h.c.b0;
import h.c.d0;
import h.c.f0;
import h.c.h0;
import h.c.m0.n;
import h.c.m0.p;
import h.c.s;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.a0.q;
import kotlin.jvm.internal.m;
import kotlin.x;
import org.apache.http.HttpStatus;
import org.toshi.R;

/* compiled from: AuthenticationHelper.kt */
@AppCoreScoped
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000¶\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B1\b\u0007\u0012\u0006\u0010J\u001a\u00020I\u0012\u0006\u0010?\u001a\u00020>\u0012\u0006\u00106\u001a\u000205\u0012\u0006\u00103\u001a\u000202\u0012\u0006\u0010P\u001a\u00020O¢\u0006\u0004\b]\u0010^J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ%\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0012\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u001f\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u001f\u0010\u001a\u001a\u00020\u00132\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0012\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u001d\u001a\u00020\u001cH\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ\u001f\u0010!\u001a\b\u0012\u0004\u0012\u00020 0\r2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0004H\u0002¢\u0006\u0004\b!\u0010\"J\u0015\u0010#\u001a\b\u0012\u0004\u0012\u00020 0\rH\u0002¢\u0006\u0004\b#\u0010$J!\u0010'\u001a\u00020\u00132\u0006\u0010%\u001a\u00020\u000e2\b\b\u0002\u0010&\u001a\u00020\u0004H\u0002¢\u0006\u0004\b'\u0010(J\r\u0010)\u001a\u00020\u0013¢\u0006\u0004\b)\u0010*J\u0015\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00130\rH\u0016¢\u0006\u0004\b+\u0010$J)\u0010.\u001a\u00020\u00132\u0006\u0010-\u001a\u00020,2\u0006\u0010\u0012\u001a\u00020\u00112\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b.\u0010/J\u0015\u00100\u001a\u00020\u00132\u0006\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\b0\u0010\u0015J\u001d\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u0010\f\u001a\u00020\u000bH\u0017¢\u0006\u0004\b\u000f\u00101R\u0016\u00103\u001a\u0002028\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b3\u00104R\u0016\u00106\u001a\u0002058\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b6\u00107R\u001d\u0010=\u001a\u0002088B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b9\u0010:\u001a\u0004\b;\u0010<R\u0016\u0010?\u001a\u00020>8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b?\u0010@R$\u0010D\u001a\u0010\u0012\f\u0012\n C*\u0004\u0018\u00010B0B0A8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bD\u0010ER$\u0010G\u001a\u0010\u0012\f\u0012\n C*\u0004\u0018\u00010\u00040\u00040F8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bG\u0010HR\u0016\u0010J\u001a\u00020I8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bJ\u0010KR\u0016\u0010M\u001a\u00020L8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bM\u0010NR\u0016\u0010P\u001a\u00020O8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bP\u0010QR$\u0010R\u001a\u0004\u0018\u00010\u001c8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bR\u0010S\u001a\u0004\bT\u0010\u001e\"\u0004\bU\u0010VR\u001e\u0010W\u001a\n C*\u0004\u0018\u00010L0L8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bW\u0010NR\u001f\u0010Y\u001a\b\u0012\u0004\u0012\u00020B0X8\u0006@\u0006¢\u0006\f\n\u0004\bY\u0010Z\u001a\u0004\b[\u0010\\¨\u0006_"}, d2 = {"Lcom/coinbase/wallet/features/applock/legacy/AuthenticationHelper;", "Lcom/coinbase/wallet/authentication/AuthenticationHelperInterface;", "", "fragmentTag", "", "isCancellable", "Lcom/toshi/view/fragment/r0/e;", "getPinDialog", "(Ljava/lang/String;Z)Lcom/toshi/view/fragment/r0/e;", "Lcom/toshi/model/local/authentication/AuthenticationMethod;", "authMethod", "Lcom/coinbase/wallet/authentication/AppLockType;", "type", "Lh/c/b0;", "Lcom/coinbase/wallet/authentication/AuthenticationResult;", "unlock", "(Lcom/toshi/model/local/authentication/AuthenticationMethod;Lcom/coinbase/wallet/authentication/AppLockType;)Lh/c/b0;", "Lcom/coinbase/wallet/features/applock/legacy/AuthenticationCallback;", "callback", "Lkotlin/x;", "unlockRecoveryPhraseWithBiometricPrompt", "(Lcom/coinbase/wallet/features/applock/legacy/AuthenticationCallback;)V", "unlockRecoveryPhraseWithPinDialog", "(Lcom/coinbase/wallet/features/applock/legacy/AuthenticationCallback;Z)V", "Le/j/d/c;", "permit", "decryptRecoveryPhrase", "(Le/j/d/c;Lcom/coinbase/wallet/features/applock/legacy/AuthenticationCallback;)V", "Landroidx/fragment/app/d;", "requireActivity", "()Landroidx/fragment/app/d;", "biometryProtection", "Landroidx/biometric/BiometricPrompt$d;", "createEncryptionCryptoObject", "(Ljava/lang/Boolean;)Lh/c/b0;", "createDecryptionCryptoObject", "()Lh/c/b0;", "result", "finishOnDismiss", "displayAuthenticationNotification", "(Lcom/coinbase/wallet/authentication/AuthenticationResult;Z)V", "clear", "()V", "checkIfKeyInvalidated", "Lcom/toshi/model/local/authentication/EncryptionMethod;", "encryptionMethod", "authenticateWithBiometricPrompt", "(Lcom/toshi/model/local/authentication/EncryptionMethod;Lcom/coinbase/wallet/features/applock/legacy/AuthenticationCallback;Ljava/lang/Boolean;)V", "showPinDialog", "(Lcom/coinbase/wallet/authentication/AppLockType;)Lh/c/b0;", "Le/j/d/g/w;", "masterSeedHandler", "Le/j/d/g/w;", "Lcom/coinbase/wallet/application/repository/interfaces/AppLockRepositoryInterface;", "appLockRepository", "Lcom/coinbase/wallet/application/repository/interfaces/AppLockRepositoryInterface;", "Lh/c/k0/a;", "disposeBag$delegate", "Lkotlin/h;", "getDisposeBag", "()Lh/c/k0/a;", "disposeBag", "Lcom/coinbase/wallet/application/repository/interfaces/MnemonicRepositoryInterface;", "mnemonicRepository", "Lcom/coinbase/wallet/application/repository/interfaces/MnemonicRepositoryInterface;", "Lh/c/v0/b;", "Lcom/coinbase/wallet/application/model/Notification;", "kotlin.jvm.PlatformType", "lockoutNotificationSubject", "Lh/c/v0/b;", "Lh/c/v0/a;", "isAuthenticating", "Lh/c/v0/a;", "Le/j/l/o/a;", "base64Util", "Le/j/l/o/a;", "Lh/c/a0;", "concurrentScheduler", "Lh/c/a0;", "Le/j/l/n/a;", "biometricHelper", "Le/j/l/n/a;", "activity", "Landroidx/fragment/app/d;", "getActivity", "setActivity", "(Landroidx/fragment/app/d;)V", "mainScheduler", "Lh/c/s;", "lockoutNotificationObservable", "Lh/c/s;", "getLockoutNotificationObservable", "()Lh/c/s;", "<init>", "(Le/j/l/o/a;Lcom/coinbase/wallet/application/repository/interfaces/MnemonicRepositoryInterface;Lcom/coinbase/wallet/application/repository/interfaces/AppLockRepositoryInterface;Le/j/d/g/w;Le/j/l/n/a;)V", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class AuthenticationHelper implements AuthenticationHelperInterface {
    private androidx.fragment.app.d activity;
    private final AppLockRepositoryInterface appLockRepository;
    private final e.j.l.o.a base64Util;
    private final e.j.l.n.a biometricHelper;
    private final a0 concurrentScheduler;
    private final kotlin.h disposeBag$delegate;
    private final h.c.v0.a<Boolean> isAuthenticating;
    private final s<Notification> lockoutNotificationObservable;
    private final h.c.v0.b<Notification> lockoutNotificationSubject;
    private final a0 mainScheduler;
    private final w masterSeedHandler;
    private final MnemonicRepositoryInterface mnemonicRepository;

    /* compiled from: AuthenticationHelper.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[EncryptionMethod.values().length];
            iArr[EncryptionMethod.DECRYPTION.ordinal()] = 1;
            iArr[EncryptionMethod.ENCRYPTION.ordinal()] = 2;
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[AuthenticationMethod.values().length];
            iArr2[AuthenticationMethod.BIOMETRIC.ordinal()] = 1;
            iArr2[AuthenticationMethod.PIN.ordinal()] = 2;
            $EnumSwitchMapping$1 = iArr2;
        }
    }

    public AuthenticationHelper(e.j.l.o.a base64Util, MnemonicRepositoryInterface mnemonicRepository, AppLockRepositoryInterface appLockRepository, w masterSeedHandler, e.j.l.n.a biometricHelper) {
        kotlin.h b2;
        m.g(base64Util, "base64Util");
        m.g(mnemonicRepository, "mnemonicRepository");
        m.g(appLockRepository, "appLockRepository");
        m.g(masterSeedHandler, "masterSeedHandler");
        m.g(biometricHelper, "biometricHelper");
        this.base64Util = base64Util;
        this.mnemonicRepository = mnemonicRepository;
        this.appLockRepository = appLockRepository;
        this.masterSeedHandler = masterSeedHandler;
        this.biometricHelper = biometricHelper;
        h.c.v0.a<Boolean> e2 = h.c.v0.a.e(Boolean.FALSE);
        m.f(e2, "createDefault(false)");
        this.isAuthenticating = e2;
        a0 c2 = h.c.u0.a.c();
        m.f(c2, "io()");
        this.concurrentScheduler = c2;
        this.mainScheduler = h.c.j0.c.a.b();
        h.c.v0.b<Notification> d2 = h.c.v0.b.d();
        m.f(d2, "create<Notification>()");
        this.lockoutNotificationSubject = d2;
        s<Notification> hide = d2.hide();
        m.f(hide, "lockoutNotificationSubject.hide()");
        this.lockoutNotificationObservable = hide;
        b2 = kotlin.k.b(AuthenticationHelper$disposeBag$2.INSTANCE);
        this.disposeBag$delegate = b2;
    }

    public static /* synthetic */ void a(Throwable th) {
        m1211createDecryptionCryptoObject$lambda13(th);
    }

    public static final /* synthetic */ void access$decryptRecoveryPhrase(AuthenticationHelper authenticationHelper, e.j.d.c cVar, AuthenticationCallback authenticationCallback) {
        authenticationHelper.decryptRecoveryPhrase(cVar, authenticationCallback);
    }

    public static final /* synthetic */ void access$displayAuthenticationNotification(AuthenticationHelper authenticationHelper, AuthenticationResult authenticationResult, boolean z) {
        authenticationHelper.displayAuthenticationNotification(authenticationResult, z);
    }

    public static /* synthetic */ void authenticateWithBiometricPrompt$default(AuthenticationHelper authenticationHelper, EncryptionMethod encryptionMethod, AuthenticationCallback authenticationCallback, Boolean bool, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            bool = null;
        }
        authenticationHelper.authenticateWithBiometricPrompt(encryptionMethod, authenticationCallback, bool);
    }

    /* renamed from: authenticateWithBiometricPrompt$lambda-2 */
    public static final void m1206authenticateWithBiometricPrompt$lambda2(EncryptionMethod encryptionMethod, h.c.k0.b bVar) {
        m.g(encryptionMethod, "$encryptionMethod");
        l.a.a.a(m.o("Getting crypto object: ", encryptionMethod), new Object[0]);
    }

    /* renamed from: authenticateWithBiometricPrompt$lambda-3 */
    public static final x m1207authenticateWithBiometricPrompt$lambda3(AuthenticationHelper this$0, AuthenticationCallback callback, BiometricPrompt.d cryptoObject) {
        m.g(this$0, "this$0");
        m.g(callback, "$callback");
        m.g(cryptoObject, "cryptoObject");
        e.j.f.c.c(this$0.requireActivity(), callback, cryptoObject, null, 4, null);
        return x.a;
    }

    public static /* synthetic */ BiometricPrompt.d b(AuthenticationHelper authenticationHelper, String str) {
        return m1210createDecryptionCryptoObject$lambda12(authenticationHelper, str);
    }

    public static /* synthetic */ void c(Throwable th) {
        m1209checkIfKeyInvalidated$lambda1(th);
    }

    /* renamed from: checkIfKeyInvalidated$lambda-0 */
    public static final x m1208checkIfKeyInvalidated$lambda0(AuthenticationHelper this$0, String mnemonic) {
        m.g(this$0, "this$0");
        m.g(mnemonic, "mnemonic");
        boolean c2 = this$0.biometricHelper.c();
        byte[] a = this$0.base64Util.a(mnemonic, a.EnumC0327a.DEFAULT);
        Objects.requireNonNull(a, "encryptedMasterSeedAsBytes is null");
        if (this$0.masterSeedHandler.c(e.j.l.p.d.a.b(a))) {
            displayAuthenticationNotification$default(this$0, new AuthenticationResult.Error(new KeyPermanentlyInvalidatedException()), false, 2, null);
        } else if (!c2 && this$0.appLockRepository.getAuthenticationMethod() == AuthenticationMethod.BIOMETRIC) {
            this$0.displayAuthenticationNotification(new AuthenticationResult.NoBiometricFound(this$0.appLockRepository.isBiometricProtectionEnabled()), true);
        }
        return x.a;
    }

    /* renamed from: checkIfKeyInvalidated$lambda-1 */
    public static final void m1209checkIfKeyInvalidated$lambda1(Throwable th) {
        l.a.a.f(th, "Error while creating decryption object", new Object[0]);
    }

    private final b0<BiometricPrompt.d> createDecryptionCryptoObject() throws KeyStoreException {
        b0<BiometricPrompt.d> doOnError = this.mnemonicRepository.getEncryptedMnemonic().map(new n() { // from class: com.coinbase.wallet.features.applock.legacy.b
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return AuthenticationHelper.b(AuthenticationHelper.this, (String) obj);
            }
        }).doOnError(new h.c.m0.f() { // from class: com.coinbase.wallet.features.applock.legacy.a
            @Override // h.c.m0.f
            public final void accept(Object obj) {
                AuthenticationHelper.a((Throwable) obj);
            }
        });
        m.f(doOnError, "mnemonicRepository.getEncryptedMnemonic()\n            .map {\n                val encryptedMasterSeedAsBytes = base64Util.decode(it, Base64Interface.Flag.DEFAULT)\n                    ?: throw NullPointerException(\"encryptedMasterSeedAsBytes is null\")\n                val iv = CryptoUtil.getIvFromBytes(encryptedMasterSeedAsBytes)\n                masterSeedHandler.createDecryptionCryptoObject(iv)\n            }\n            .doOnError { Timber.e(it, \"Error while creating decryption object\") }");
        return doOnError;
    }

    /* renamed from: createDecryptionCryptoObject$lambda-12 */
    public static final BiometricPrompt.d m1210createDecryptionCryptoObject$lambda12(AuthenticationHelper this$0, String it) {
        m.g(this$0, "this$0");
        m.g(it, "it");
        byte[] a = this$0.base64Util.a(it, a.EnumC0327a.DEFAULT);
        Objects.requireNonNull(a, "encryptedMasterSeedAsBytes is null");
        return this$0.masterSeedHandler.d(e.j.l.p.d.a.b(a));
    }

    /* renamed from: createDecryptionCryptoObject$lambda-13 */
    public static final void m1211createDecryptionCryptoObject$lambda13(Throwable th) {
        l.a.a.f(th, "Error while creating decryption object", new Object[0]);
    }

    private final b0<BiometricPrompt.d> createEncryptionCryptoObject(Boolean bool) throws KeyStoreException {
        b0<BiometricPrompt.d> just = b0.just(this.masterSeedHandler.b(bool));
        m.f(just, "just(masterSeedHandler.createEncryptionCryptoObject(biometryProtection))");
        return just;
    }

    public static /* synthetic */ h0 d(AuthenticationHelper authenticationHelper, AppLockType appLockType, AuthenticationMethod authenticationMethod, Boolean bool) {
        return m1215unlock$lambda7(authenticationHelper, appLockType, authenticationMethod, bool);
    }

    public final void decryptRecoveryPhrase(e.j.d.c cVar, AuthenticationCallback authenticationCallback) {
        h.c.t0.a.a(h.c.t0.g.f(this.masterSeedHandler.f(cVar), new AuthenticationHelper$decryptRecoveryPhrase$1(authenticationCallback), new AuthenticationHelper$decryptRecoveryPhrase$2(authenticationCallback)), getDisposeBag());
    }

    public final void displayAuthenticationNotification(AuthenticationResult authenticationResult, boolean z) {
        List b2;
        String str;
        Notification notification = null;
        AuthenticationHelper$displayAuthenticationNotification$onDismissHook$1 authenticationHelper$displayAuthenticationNotification$onDismissHook$1 = z ? new AuthenticationHelper$displayAuthenticationNotification$onDismissHook$1(this) : null;
        if (authenticationResult instanceof AuthenticationResult.LockedOut) {
            LocalizedStrings localizedStrings = LocalizedStrings.INSTANCE;
            String str2 = localizedStrings.get(R.string.error_lockout_title);
            if (((AuthenticationResult.LockedOut) authenticationResult).getPermanent()) {
                str = localizedStrings.get(R.string.error_lockout_permanent);
            } else {
                str = localizedStrings.get(R.string.error_lockout);
            }
            b0 just = b0.just(Boolean.TRUE);
            Integer valueOf = Integer.valueOf((int) R.drawable.illustration_key_locked);
            m.f(just, "just(true)");
            notification = new Notification(null, str2, str, true, valueOf, null, just, null, null, authenticationHelper$displayAuthenticationNotification$onDismissHook$1, HttpStatus.SC_EXPECTATION_FAILED, null);
        } else if (authenticationResult instanceof AuthenticationResult.Error) {
            AuthenticationResult.Error error = (AuthenticationResult.Error) authenticationResult;
            l.a.a.e(error.getThrowable());
            if (e.j.f.w.b(error.getThrowable())) {
                CallToAction callToAction = new CallToAction(R.string.confirm, new NavDestination(R.id.sign_out_nav_graph, null, null, null, null, 30, null), ActionStyle.POSITIVE, null, 8, null);
                LocalizedStrings localizedStrings2 = LocalizedStrings.INSTANCE;
                String str3 = localizedStrings2.get(R.string.key_invalidated_notification_title);
                String str4 = localizedStrings2.get(R.string.key_invalidated_notification);
                Integer valueOf2 = Integer.valueOf((int) R.drawable.ic_fingerprint_primary);
                b2 = q.b(callToAction);
                b0 just2 = b0.just(Boolean.TRUE);
                m.f(just2, "just(true)");
                notification = new Notification(null, str3, str4, false, valueOf2, b2, just2, null, null, new AuthenticationHelper$displayAuthenticationNotification$notification$1(this), 385, null);
            } else {
                LocalizedStrings localizedStrings3 = LocalizedStrings.INSTANCE;
                String str5 = localizedStrings3.get(R.string.fatal_authentication_dialog_title);
                String str6 = localizedStrings3.get(R.string.fatal_authentication_dialog_message);
                b0 just3 = b0.just(Boolean.TRUE);
                m.f(just3, "just(true)");
                notification = new Notification(null, str5, str6, true, null, null, just3, null, null, authenticationHelper$displayAuthenticationNotification$onDismissHook$1, 433, null);
            }
        } else if (authenticationResult instanceof AuthenticationResult.NoBiometricFound) {
            if (((AuthenticationResult.NoBiometricFound) authenticationResult).isBiometricProtectionEnabled()) {
                displayAuthenticationNotification$default(this, new AuthenticationResult.Error(new KeyPermanentlyInvalidatedException()), false, 2, null);
            } else {
                LocalizedStrings localizedStrings4 = LocalizedStrings.INSTANCE;
                String str7 = localizedStrings4.get(R.string.no_biometric_title);
                String str8 = localizedStrings4.get(R.string.no_biometric_dialog_message);
                b0 just4 = b0.just(Boolean.TRUE);
                Integer valueOf3 = Integer.valueOf((int) R.drawable.ic_fingerprint_primary);
                m.f(just4, "just(true)");
                notification = new Notification(null, str7, str8, true, valueOf3, null, just4, null, null, authenticationHelper$displayAuthenticationNotification$onDismissHook$1, HttpStatus.SC_EXPECTATION_FAILED, null);
            }
        }
        if (notification != null) {
            this.lockoutNotificationSubject.onNext(notification);
        }
    }

    public static /* synthetic */ void displayAuthenticationNotification$default(AuthenticationHelper authenticationHelper, AuthenticationResult authenticationResult, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        authenticationHelper.displayAuthenticationNotification(authenticationResult, z);
    }

    public static /* synthetic */ void e(AuthenticationHelper authenticationHelper) {
        m1212unlock$lambda10(authenticationHelper);
    }

    public static /* synthetic */ void f(AuthenticationHelper authenticationHelper, Throwable th) {
        m1217unlock$lambda9(authenticationHelper, th);
    }

    public static /* synthetic */ x g(AuthenticationHelper authenticationHelper, AuthenticationCallback authenticationCallback, BiometricPrompt.d dVar) {
        return m1207authenticateWithBiometricPrompt$lambda3(authenticationHelper, authenticationCallback, dVar);
    }

    private final h.c.k0.a getDisposeBag() {
        return (h.c.k0.a) this.disposeBag$delegate.getValue();
    }

    private final com.toshi.view.fragment.r0.e getPinDialog(String str, boolean z) {
        Fragment Z = requireActivity().getSupportFragmentManager().Z(str);
        if (Z != null && (Z instanceof com.toshi.view.fragment.r0.e)) {
            return (com.toshi.view.fragment.r0.e) Z;
        }
        Bundle bundle = new Bundle();
        bundle.putBoolean(com.toshi.view.fragment.r0.d.a.a(), z);
        com.toshi.view.fragment.r0.e eVar = new com.toshi.view.fragment.r0.e();
        eVar.setArguments(bundle);
        return eVar;
    }

    public static /* synthetic */ x h(AuthenticationHelper authenticationHelper, String str) {
        return m1208checkIfKeyInvalidated$lambda0(authenticationHelper, str);
    }

    public static /* synthetic */ boolean i(Boolean bool) {
        return m1214unlock$lambda6(bool);
    }

    public static /* synthetic */ void j(AuthenticationMethod authenticationMethod, AuthenticationHelper authenticationHelper, AppLockType appLockType, d0 d0Var) {
        m1213unlock$lambda11(authenticationMethod, authenticationHelper, appLockType, d0Var);
    }

    public static /* synthetic */ void k(AuthenticationHelper authenticationHelper, AuthenticationResult authenticationResult) {
        m1216unlock$lambda8(authenticationHelper, authenticationResult);
    }

    public static /* synthetic */ void l(EncryptionMethod encryptionMethod, h.c.k0.b bVar) {
        m1206authenticateWithBiometricPrompt$lambda2(encryptionMethod, bVar);
    }

    public final androidx.fragment.app.d requireActivity() {
        androidx.fragment.app.d dVar = this.activity;
        if (dVar != null) {
            return dVar;
        }
        throw new IllegalStateException("Activity is null");
    }

    /* renamed from: unlock$lambda-10 */
    public static final void m1212unlock$lambda10(AuthenticationHelper this$0) {
        m.g(this$0, "this$0");
        this$0.isAuthenticating.onNext(Boolean.FALSE);
    }

    /* renamed from: unlock$lambda-11 */
    public static final void m1213unlock$lambda11(AuthenticationMethod authMethod, final AuthenticationHelper this$0, final AppLockType type, final d0 observer) {
        m.g(authMethod, "$authMethod");
        m.g(this$0, "this$0");
        m.g(type, "$type");
        m.g(observer, "observer");
        AuthenticationCallback authenticationCallback = new AuthenticationCallback() { // from class: com.coinbase.wallet.features.applock.legacy.AuthenticationHelper$unlock$6$callback$1
            @Override // com.coinbase.wallet.features.applock.legacy.AuthenticationCallback
            public void onAuthenticationCancelled() {
                super.onAuthenticationCancelled();
                observer.onSuccess(AuthenticationResult.Cancelled.INSTANCE);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.coinbase.wallet.features.applock.legacy.AuthenticationCallback
            public void onAuthenticationError(Throwable th, CharSequence charSequence, Integer num) {
                super.onAuthenticationError(th, charSequence, num);
                if (th == null) {
                    th = new Throwable(charSequence == null ? null : charSequence.toString());
                }
                if (e.j.f.w.b(th)) {
                    AuthenticationHelper.access$displayAuthenticationNotification(this$0, new AuthenticationResult.Error(th), m.c(type, AppLockType.AppAccess.INSTANCE));
                }
                observer.onSuccess(new AuthenticationResult.Error(th));
            }

            @Override // com.coinbase.wallet.features.applock.legacy.AuthenticationCallback
            public void onAuthenticationLockout(boolean z) {
                AuthenticationResult.LockedOut lockedOut = new AuthenticationResult.LockedOut(z);
                AuthenticationHelper.access$displayAuthenticationNotification(this$0, lockedOut, m.c(type, AppLockType.AppAccess.INSTANCE));
                observer.onSuccess(lockedOut);
            }

            @Override // com.coinbase.wallet.features.applock.legacy.AuthenticationCallback
            public void onAuthenticationSucceeded(e.j.d.c permit) {
                m.g(permit, "permit");
                if (permit instanceof e.j.d.e) {
                    observer.onSuccess(new AuthenticationResult.RecoveryPhrase(((e.j.d.e) permit).a()));
                } else {
                    observer.onSuccess(new AuthenticationResult.Error(new IllegalStateException("Invalid permit type")));
                }
            }
        };
        int i2 = WhenMappings.$EnumSwitchMapping$1[authMethod.ordinal()];
        if (i2 == 1) {
            this$0.unlockRecoveryPhraseWithBiometricPrompt(authenticationCallback);
        } else if (i2 != 2) {
        } else {
            this$0.unlockRecoveryPhraseWithPinDialog(authenticationCallback, type.isCancellable());
        }
    }

    /* renamed from: unlock$lambda-6 */
    public static final boolean m1214unlock$lambda6(Boolean it) {
        m.g(it, "it");
        return !it.booleanValue();
    }

    /* renamed from: unlock$lambda-7 */
    public static final h0 m1215unlock$lambda7(AuthenticationHelper this$0, AppLockType type, AuthenticationMethod authMethod, Boolean it) {
        m.g(this$0, "this$0");
        m.g(type, "$type");
        m.g(authMethod, "$authMethod");
        m.g(it, "it");
        String activeMnemonic = this$0.appLockRepository.getActiveMnemonic(type);
        if (activeMnemonic != null) {
            return b0.just(new AuthenticationResult.RecoveryPhrase(activeMnemonic));
        }
        this$0.isAuthenticating.onNext(Boolean.TRUE);
        return this$0.unlock(authMethod, type);
    }

    /* renamed from: unlock$lambda-8 */
    public static final void m1216unlock$lambda8(AuthenticationHelper this$0, AuthenticationResult authenticationResult) {
        m.g(this$0, "this$0");
        this$0.isAuthenticating.onNext(Boolean.FALSE);
    }

    /* renamed from: unlock$lambda-9 */
    public static final void m1217unlock$lambda9(AuthenticationHelper this$0, Throwable th) {
        m.g(this$0, "this$0");
        this$0.isAuthenticating.onNext(Boolean.FALSE);
    }

    private final void unlockRecoveryPhraseWithBiometricPrompt(AuthenticationCallback authenticationCallback) {
        authenticateWithBiometricPrompt$default(this, EncryptionMethod.DECRYPTION, new AuthenticationCallbackWrapper(authenticationCallback) { // from class: com.coinbase.wallet.features.applock.legacy.AuthenticationHelper$unlockRecoveryPhraseWithBiometricPrompt$wrapper$1
            final /* synthetic */ AuthenticationCallback $callback;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(authenticationCallback);
                this.$callback = authenticationCallback;
            }

            @Override // com.coinbase.wallet.features.applock.legacy.AuthenticationCallbackWrapper, com.coinbase.wallet.features.applock.legacy.AuthenticationCallback
            public void onAuthenticationSucceeded(e.j.d.c permit) {
                m.g(permit, "permit");
                AuthenticationHelper.access$decryptRecoveryPhrase(AuthenticationHelper.this, permit, this.$callback);
            }
        }, null, 4, null);
    }

    private final void unlockRecoveryPhraseWithPinDialog(AuthenticationCallback authenticationCallback, boolean z) {
        com.toshi.view.fragment.r0.e pinDialog = getPinDialog(BackupRecoveryPhraseFragment.BACKUP_MNEMONIC, z);
        pinDialog.h(new AuthenticationCallbackWrapper(authenticationCallback) { // from class: com.coinbase.wallet.features.applock.legacy.AuthenticationHelper$unlockRecoveryPhraseWithPinDialog$1
            final /* synthetic */ AuthenticationCallback $callback;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(authenticationCallback);
                this.$callback = authenticationCallback;
            }

            @Override // com.coinbase.wallet.features.applock.legacy.AuthenticationCallbackWrapper, com.coinbase.wallet.features.applock.legacy.AuthenticationCallback
            public void onAuthenticationSucceeded(e.j.d.c permit) {
                m.g(permit, "permit");
                AuthenticationHelper.access$decryptRecoveryPhrase(AuthenticationHelper.this, permit, this.$callback);
            }
        });
        if (pinDialog.isAdded()) {
            return;
        }
        pinDialog.show(requireActivity().getSupportFragmentManager(), BackupRecoveryPhraseFragment.BACKUP_MNEMONIC);
    }

    public final void authenticateWithBiometricPrompt(final EncryptionMethod encryptionMethod, final AuthenticationCallback callback, Boolean bool) {
        b0<BiometricPrompt.d> createDecryptionCryptoObject;
        m.g(encryptionMethod, "encryptionMethod");
        m.g(callback, "callback");
        getDisposeBag().d();
        l.a.a.a("Preparing to show biometric prompt...", new Object[0]);
        int i2 = WhenMappings.$EnumSwitchMapping$0[encryptionMethod.ordinal()];
        if (i2 == 1) {
            createDecryptionCryptoObject = createDecryptionCryptoObject();
        } else if (i2 == 2) {
            createDecryptionCryptoObject = createEncryptionCryptoObject(bool);
        } else {
            throw new IllegalArgumentException(m.o("Illegal EncryptionMethod: ", encryptionMethod));
        }
        b0<BiometricPrompt.d> doOnSubscribe = createDecryptionCryptoObject.doOnSubscribe(new h.c.m0.f() { // from class: com.coinbase.wallet.features.applock.legacy.l
            @Override // h.c.m0.f
            public final void accept(Object obj) {
                AuthenticationHelper.l(EncryptionMethod.this, (h.c.k0.b) obj);
            }
        });
        m.f(doOnSubscribe, "cryptoObjectSingle\n            .doOnSubscribe { Timber.d(\"Getting crypto object: $encryptionMethod\") }");
        h.c.c ignoreElement = Single_AnalyticsKt.logError$default(doOnSubscribe, "Error showing biometric prompt", null, 2, null).subscribeOn(this.concurrentScheduler).observeOn(this.mainScheduler).map(new n() { // from class: com.coinbase.wallet.features.applock.legacy.g
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return AuthenticationHelper.g(AuthenticationHelper.this, callback, (BiometricPrompt.d) obj);
            }
        }).ignoreElement();
        m.f(ignoreElement, "cryptoObjectSingle\n            .doOnSubscribe { Timber.d(\"Getting crypto object: $encryptionMethod\") }\n            .logError(\"Error showing biometric prompt\")\n            .subscribeOn(concurrentScheduler)\n            .observeOn(mainScheduler)\n            .map { cryptoObject -> requireActivity().authenticateWithBiometricPrompt(callback, cryptoObject) }\n            .ignoreElement()");
        h.c.t0.a.a(h.c.t0.g.g(ignoreElement, new AuthenticationHelper$authenticateWithBiometricPrompt$3(callback), null, 2, null), getDisposeBag());
    }

    @Override // com.coinbase.wallet.authentication.AuthenticationHelperInterface
    public b0<x> checkIfKeyInvalidated() {
        b0<x> doOnError = this.mnemonicRepository.getEncryptedMnemonic().map(new n() { // from class: com.coinbase.wallet.features.applock.legacy.h
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return AuthenticationHelper.h(AuthenticationHelper.this, (String) obj);
            }
        }).doOnError(new h.c.m0.f() { // from class: com.coinbase.wallet.features.applock.legacy.c
            @Override // h.c.m0.f
            public final void accept(Object obj) {
                AuthenticationHelper.c((Throwable) obj);
            }
        });
        m.f(doOnError, "mnemonicRepository.getEncryptedMnemonic()\n            .map { mnemonic ->\n                val hasBiometrics = biometricHelper.hasEnrolledBiometrics\n                val encryptedMasterSeedAsBytes = base64Util.decode(mnemonic, Base64Interface.Flag.DEFAULT)\n                    ?: throw NullPointerException(\"encryptedMasterSeedAsBytes is null\")\n                val iv = CryptoUtil.getIvFromBytes(encryptedMasterSeedAsBytes)\n                if (masterSeedHandler.isKeyInvalidated(iv)) {\n                    displayAuthenticationNotification(AuthenticationResult.Error(KeyPermanentlyInvalidatedException()))\n                } else if (!hasBiometrics && appLockRepository.authenticationMethod == AuthenticationMethod.BIOMETRIC) {\n                    val biometricProtectionEnabled = appLockRepository.isBiometricProtectionEnabled\n                    displayAuthenticationNotification(\n                        AuthenticationResult.NoBiometricFound(biometricProtectionEnabled),\n                        true\n                    )\n                }\n            }\n            .doOnError { Timber.e(it, \"Error while creating decryption object\") }");
        return doOnError;
    }

    public final void clear() {
        getDisposeBag().d();
    }

    public final androidx.fragment.app.d getActivity() {
        return this.activity;
    }

    public final s<Notification> getLockoutNotificationObservable() {
        return this.lockoutNotificationObservable;
    }

    public final void setActivity(androidx.fragment.app.d dVar) {
        this.activity = dVar;
    }

    public final void showPinDialog(AuthenticationCallback callback) {
        m.g(callback, "callback");
        androidx.fragment.app.d requireActivity = requireActivity();
        com.toshi.view.fragment.r0.e pinDialog = getPinDialog("PinLockDialog", true);
        pinDialog.h(callback);
        if (pinDialog.isAdded()) {
            return;
        }
        pinDialog.show(requireActivity.getSupportFragmentManager(), "PinLockDialog");
    }

    @Override // com.coinbase.wallet.authentication.AuthenticationHelperInterface
    public b0<AuthenticationResult> unlock(final AppLockType type) {
        m.g(type, "type");
        final AuthenticationMethod authenticationMethod = this.appLockRepository.getAuthenticationMethod();
        if (authenticationMethod == null) {
            b0<AuthenticationResult> error = b0.error(AppLockException.InvalidLockMethod.INSTANCE);
            m.f(error, "error(AppLockException.InvalidLockMethod)");
            return error;
        }
        s<Boolean> filter = this.isAuthenticating.filter(new p() { // from class: com.coinbase.wallet.features.applock.legacy.i
            @Override // h.c.m0.p
            public final boolean test(Object obj) {
                return AuthenticationHelper.i((Boolean) obj);
            }
        });
        m.f(filter, "isAuthenticating\n            .filter { !it }");
        b0 doOnDispose = Observable_CoreKt.takeSingle(filter).flatMap(new n() { // from class: com.coinbase.wallet.features.applock.legacy.d
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return AuthenticationHelper.d(AuthenticationHelper.this, type, authenticationMethod, (Boolean) obj);
            }
        }).doOnSuccess(new h.c.m0.f() { // from class: com.coinbase.wallet.features.applock.legacy.k
            @Override // h.c.m0.f
            public final void accept(Object obj) {
                AuthenticationHelper.k(AuthenticationHelper.this, (AuthenticationResult) obj);
            }
        }).doOnError(new h.c.m0.f() { // from class: com.coinbase.wallet.features.applock.legacy.f
            @Override // h.c.m0.f
            public final void accept(Object obj) {
                AuthenticationHelper.f(AuthenticationHelper.this, (Throwable) obj);
            }
        }).doOnDispose(new h.c.m0.a() { // from class: com.coinbase.wallet.features.applock.legacy.e
            @Override // h.c.m0.a
            public final void run() {
                AuthenticationHelper.e(AuthenticationHelper.this);
            }
        });
        m.f(doOnDispose, "isAuthenticating\n            .filter { !it }\n            .takeSingle()\n            .flatMap {\n                val mnemonic = appLockRepository.getActiveMnemonic(type)\n                if (mnemonic != null) {\n                    return@flatMap Single.just(AuthenticationResult.RecoveryPhrase(mnemonic))\n                }\n\n                isAuthenticating.onNext(true)\n\n                unlock(authMethod, type)\n            }\n            .doOnSuccess { isAuthenticating.onNext(false) }\n            .doOnError { isAuthenticating.onNext(false) }\n            .doOnDispose { isAuthenticating.onNext(false) }");
        return Single_AnalyticsKt.logError$default(doOnDispose, null, null, 3, null);
    }

    private final b0<AuthenticationResult> unlock(final AuthenticationMethod authenticationMethod, final AppLockType appLockType) {
        b0<AuthenticationResult> create = b0.create(new f0() { // from class: com.coinbase.wallet.features.applock.legacy.j
            @Override // h.c.f0
            public final void subscribe(d0 d0Var) {
                AuthenticationHelper.j(AuthenticationMethod.this, this, appLockType, d0Var);
            }
        });
        m.f(create, "create { observer ->\n            val callback = object : AuthenticationCallback() {\n                override fun onAuthenticationSucceeded(permit: Permit) {\n                    when (permit) {\n                        is RecoveryPhrasePermit -> {\n                            observer.onSuccess(AuthenticationResult.RecoveryPhrase(permit.recoveryPhrase))\n                        }\n                        else -> {\n                            observer.onSuccess(AuthenticationResult.Error(IllegalStateException(\"Invalid permit type\")))\n                        }\n                    }\n                }\n\n                override fun onAuthenticationLockout(permanent: Boolean) {\n                    val result = AuthenticationResult.LockedOut(permanent)\n                    displayAuthenticationNotification(result, type == AppLockType.AppAccess)\n                    observer.onSuccess(result)\n                }\n\n                override fun onAuthenticationCancelled() {\n                    super.onAuthenticationCancelled()\n                    observer.onSuccess(AuthenticationResult.Cancelled)\n                }\n\n                override fun onAuthenticationError(throwable: Throwable?, errString: CharSequence?, errorCode: Int?) {\n                    super.onAuthenticationError(throwable, errString, errorCode)\n                    val error = throwable ?: Throwable(errString?.toString())\n                    if (error.hasKeyPermanentlyInvalidatedException) {\n                        displayAuthenticationNotification(\n                            AuthenticationResult.Error(error),\n                            type == AppLockType.AppAccess\n                        )\n                    }\n                    observer.onSuccess(AuthenticationResult.Error(error))\n                }\n            }\n\n            when (authMethod) {\n                AuthenticationMethod.BIOMETRIC -> unlockRecoveryPhraseWithBiometricPrompt(callback)\n                AuthenticationMethod.PIN -> unlockRecoveryPhraseWithPinDialog(callback, type.isCancellable)\n            }\n        }");
        return create;
    }
}