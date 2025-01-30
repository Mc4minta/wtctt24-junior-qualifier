package com.coinbase.wallet.authentication;

import h.c.b0;
import kotlin.Metadata;
import kotlin.x;

/* compiled from: AuthenticationHelperInterface.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0006\u0010\u0007J\u0015\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0004H&¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/coinbase/wallet/authentication/AuthenticationHelperInterface;", "", "Lcom/coinbase/wallet/authentication/AppLockType;", "type", "Lh/c/b0;", "Lcom/coinbase/wallet/authentication/AuthenticationResult;", "unlock", "(Lcom/coinbase/wallet/authentication/AppLockType;)Lh/c/b0;", "Lkotlin/x;", "checkIfKeyInvalidated", "()Lh/c/b0;", "authentication_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public interface AuthenticationHelperInterface {
    b0<x> checkIfKeyInvalidated();

    b0<AuthenticationResult> unlock(AppLockType appLockType);
}