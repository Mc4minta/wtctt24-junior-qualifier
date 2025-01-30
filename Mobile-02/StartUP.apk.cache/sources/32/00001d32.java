package com.coinbase.wallet.features.applock.legacy;

import androidx.biometric.BiometricPrompt;
import javax.crypto.Cipher;
import kotlin.Metadata;
import kotlin.jvm.internal.m;

/* compiled from: AuthenticationCallback.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001b\u0010\fJ1\u0010\t\u001a\u00020\b2\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\fJ3\u0010\r\u001a\u00020\b2\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0014¢\u0006\u0004\b\r\u0010\nJ\u001d\u0010\r\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000f\u0010\fJ\u0017\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u0010H&¢\u0006\u0004\b\u0012\u0010\u0013J\u0015\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020\u0018H&¢\u0006\u0004\b\u0016\u0010\u001a¨\u0006\u001c"}, d2 = {"Lcom/coinbase/wallet/features/applock/legacy/AuthenticationCallback;", "Landroidx/biometric/BiometricPrompt$b;", "", "throwable", "", "errString", "", "errorCode", "Lkotlin/x;", "checkAuthenticationError", "(Ljava/lang/Throwable;Ljava/lang/CharSequence;Ljava/lang/Integer;)V", "onAuthenticationCancelled", "()V", "onAuthenticationError", "(ILjava/lang/CharSequence;)V", "onAuthenticationFailed", "", "permanent", "onAuthenticationLockout", "(Z)V", "Landroidx/biometric/BiometricPrompt$c;", "result", "onAuthenticationSucceeded", "(Landroidx/biometric/BiometricPrompt$c;)V", "Le/j/d/c;", "permit", "(Le/j/d/c;)V", "<init>", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public abstract class AuthenticationCallback extends BiometricPrompt.b {
    public static /* synthetic */ void checkAuthenticationError$default(AuthenticationCallback authenticationCallback, Throwable th, CharSequence charSequence, Integer num, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: checkAuthenticationError");
        }
        if ((i2 & 1) != 0) {
            th = null;
        }
        if ((i2 & 2) != 0) {
            charSequence = null;
        }
        if ((i2 & 4) != 0) {
            num = null;
        }
        authenticationCallback.checkAuthenticationError(th, charSequence, num);
    }

    public static /* synthetic */ void onAuthenticationError$default(AuthenticationCallback authenticationCallback, Throwable th, CharSequence charSequence, Integer num, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onAuthenticationError");
        }
        if ((i2 & 1) != 0) {
            th = null;
        }
        if ((i2 & 2) != 0) {
            charSequence = null;
        }
        if ((i2 & 4) != 0) {
            num = null;
        }
        authenticationCallback.onAuthenticationError(th, charSequence, num);
    }

    public final void checkAuthenticationError(Throwable th, CharSequence charSequence, Integer num) {
        l.a.a.f(th, "Authentication error (" + num + "): " + ((Object) charSequence), new Object[0]);
        if (((num != null && num.intValue() == 5) || (num != null && num.intValue() == 13)) || (num != null && num.intValue() == 10)) {
            onAuthenticationCancelled();
        } else if (num != null && num.intValue() == 7) {
            onAuthenticationLockout(false);
        } else if (num != null && num.intValue() == 9) {
            onAuthenticationLockout(true);
        } else {
            onAuthenticationError(th, charSequence, num);
        }
    }

    public void onAuthenticationCancelled() {
    }

    @Override // androidx.biometric.BiometricPrompt.b
    public final void onAuthenticationError(int i2, CharSequence errString) {
        m.g(errString, "errString");
        checkAuthenticationError$default(this, null, errString, Integer.valueOf(i2), 1, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onAuthenticationError(Throwable th, CharSequence charSequence, Integer num) {
    }

    @Override // androidx.biometric.BiometricPrompt.b
    public void onAuthenticationFailed() {
    }

    public abstract void onAuthenticationLockout(boolean z);

    @Override // androidx.biometric.BiometricPrompt.b
    public final void onAuthenticationSucceeded(BiometricPrompt.c result) {
        m.g(result, "result");
        BiometricPrompt.d a = result.a();
        Cipher a2 = a == null ? null : a.a();
        if (a2 == null) {
            l.a.a.a("Authentication failed (cipher is null)", new Object[0]);
            onAuthenticationFailed();
            return;
        }
        l.a.a.a("Authentication succeeded", new Object[0]);
        onAuthenticationSucceeded(new e.j.d.a(a2));
    }

    public abstract void onAuthenticationSucceeded(e.j.d.c cVar);
}