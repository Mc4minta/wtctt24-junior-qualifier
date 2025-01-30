package com.coinbase.wallet.features.applock.legacy;

import kotlin.Metadata;
import kotlin.jvm.internal.m;

/* compiled from: AuthenticationCallbackWrapper.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\b\u0016\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0016\u001a\u00020\u0001¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J-\u0010\u000b\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0014¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\r\u0010\u0004J\u0017\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0016\u001a\u00020\u00018\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017¨\u0006\u001a"}, d2 = {"Lcom/coinbase/wallet/features/applock/legacy/AuthenticationCallbackWrapper;", "Lcom/coinbase/wallet/features/applock/legacy/AuthenticationCallback;", "Lkotlin/x;", "onAuthenticationCancelled", "()V", "", "throwable", "", "errString", "", "errorCode", "onAuthenticationError", "(Ljava/lang/Throwable;Ljava/lang/CharSequence;Ljava/lang/Integer;)V", "onAuthenticationFailed", "", "permanent", "onAuthenticationLockout", "(Z)V", "Le/j/d/c;", "permit", "onAuthenticationSucceeded", "(Le/j/d/c;)V", "callback", "Lcom/coinbase/wallet/features/applock/legacy/AuthenticationCallback;", "<init>", "(Lcom/coinbase/wallet/features/applock/legacy/AuthenticationCallback;)V", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public class AuthenticationCallbackWrapper extends AuthenticationCallback {
    private final AuthenticationCallback callback;

    public AuthenticationCallbackWrapper(AuthenticationCallback callback) {
        m.g(callback, "callback");
        this.callback = callback;
    }

    @Override // com.coinbase.wallet.features.applock.legacy.AuthenticationCallback
    public void onAuthenticationCancelled() {
        this.callback.onAuthenticationCancelled();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.coinbase.wallet.features.applock.legacy.AuthenticationCallback
    public void onAuthenticationError(Throwable th, CharSequence charSequence, Integer num) {
        this.callback.checkAuthenticationError(th, charSequence, num);
    }

    @Override // com.coinbase.wallet.features.applock.legacy.AuthenticationCallback, androidx.biometric.BiometricPrompt.b
    public void onAuthenticationFailed() {
        this.callback.onAuthenticationFailed();
    }

    @Override // com.coinbase.wallet.features.applock.legacy.AuthenticationCallback
    public void onAuthenticationLockout(boolean z) {
        this.callback.onAuthenticationLockout(z);
    }

    @Override // com.coinbase.wallet.features.applock.legacy.AuthenticationCallback
    public void onAuthenticationSucceeded(e.j.d.c permit) {
        m.g(permit, "permit");
        this.callback.onAuthenticationSucceeded(permit);
    }
}