package com.coinbase.wallet.application.repository.interfaces;

import com.coinbase.wallet.authentication.AppLockType;
import com.toshi.model.local.authentication.AuthenticationMethod;
import e.j.d.a;
import e.j.d.c;
import h.c.b0;
import h.c.s;
import kotlin.Metadata;
import kotlin.x;

/* compiled from: AppLockRepositoryInterface.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u000b\bf\u0018\u00002\u00020\u0001J\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b\n\u0010\u000bJ%\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rH&¢\u0006\u0004\b\u0011\u0010\u0012J%\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\u0006\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u0004H&¢\u0006\u0004\b\u0015\u0010\u0016J%\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\u0006\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rH&¢\u0006\u0004\b\u0017\u0010\u0012J\u001d\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00070\u000f2\u0006\u0010\u000e\u001a\u00020\u0018H&¢\u0006\u0004\b\u0019\u0010\u001aJ%\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\t0\u000f2\u0006\u0010\u001b\u001a\u00020\r2\u0006\u0010\u001c\u001a\u00020\rH&¢\u0006\u0004\b\u001d\u0010\u001eR\u001c\u0010\u001f\u001a\u00020\u00078&@&X¦\u000e¢\u0006\f\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\u000bR\u001c\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00070\"8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b#\u0010$R\u001c\u0010%\u001a\u00020\u00078&@&X¦\u000e¢\u0006\f\u001a\u0004\b%\u0010 \"\u0004\b&\u0010\u000bR\u001e\u0010+\u001a\u0004\u0018\u00010\u00108&@&X¦\u000e¢\u0006\f\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\u0016\u0010,\u001a\u00020\u00078&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b,\u0010 ¨\u0006-"}, d2 = {"Lcom/coinbase/wallet/application/repository/interfaces/AppLockRepositoryInterface;", "", "Lcom/coinbase/wallet/authentication/AppLockType;", "type", "", "getActiveMnemonic", "(Lcom/coinbase/wallet/authentication/AppLockType;)Ljava/lang/String;", "", "isLocked", "Lkotlin/x;", "setIsAppLocked", "(Z)V", "currentPin", "Le/j/d/a;", "permit", "Lh/c/b0;", "Lcom/toshi/model/local/authentication/AuthenticationMethod;", "switchAuthenticationMethodToBiometric", "(Ljava/lang/String;Le/j/d/a;)Lh/c/b0;", "oldPin", "newPin", "switchAuthenticationPin", "(Ljava/lang/String;Ljava/lang/String;)Lh/c/b0;", "switchAuthenticationMethodToPin", "Le/j/d/c;", "isValidPermit", "(Le/j/d/c;)Lh/c/b0;", "decryptionPermit", "encryptionPermit", "changeBiometricPermit", "(Le/j/d/a;Le/j/d/a;)Lh/c/b0;", "isUnlockRequiredOnAppFocus", "()Z", "setUnlockRequiredOnAppFocus", "Lh/c/s;", "isAppLockedObservable", "()Lh/c/s;", "isTxAuthRequired", "setTxAuthRequired", "getAuthenticationMethod", "()Lcom/toshi/model/local/authentication/AuthenticationMethod;", "setAuthenticationMethod", "(Lcom/toshi/model/local/authentication/AuthenticationMethod;)V", "authenticationMethod", "isBiometricProtectionEnabled", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public interface AppLockRepositoryInterface {
    b0<x> changeBiometricPermit(a aVar, a aVar2);

    String getActiveMnemonic(AppLockType appLockType);

    AuthenticationMethod getAuthenticationMethod();

    s<Boolean> isAppLockedObservable();

    boolean isBiometricProtectionEnabled();

    boolean isTxAuthRequired();

    boolean isUnlockRequiredOnAppFocus();

    b0<Boolean> isValidPermit(c cVar);

    void setAuthenticationMethod(AuthenticationMethod authenticationMethod);

    void setIsAppLocked(boolean z);

    void setTxAuthRequired(boolean z);

    void setUnlockRequiredOnAppFocus(boolean z);

    b0<AuthenticationMethod> switchAuthenticationMethodToBiometric(String str, a aVar);

    b0<AuthenticationMethod> switchAuthenticationMethodToPin(String str, a aVar);

    b0<AuthenticationMethod> switchAuthenticationPin(String str, String str2);
}